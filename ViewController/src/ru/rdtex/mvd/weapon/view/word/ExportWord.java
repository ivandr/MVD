package ru.rdtex.mvd.weapon.view.word;


import java.awt.image.BufferedImage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import java.net.URLEncoder;

import java.util.ArrayList;
import java.util.Map;

import java.util.Set;

import javax.imageio.ImageIO;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oracle.jbo.Row;
import oracle.jbo.RowIterator;
import oracle.jbo.domain.BlobDomain;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
import oracle.jbo.server.ViewObjectImpl;

import ru.rdtex.global.ADFUtils;
import ru.rdtex.global.utils.DateTime;
import ru.rdtex.global.utils.Resource;


public class ExportWord extends HttpServlet {
    private static final String CONTENT_TYPE =
        "application/msword; charset=UTF-8"; //application/msword
//    private static Row ROW = null;
//    private static Map ROW_PARAMS = null;
//    private static String ITER_NAME = null;
    private static String FILE_TEXT = null;
    
    private String img_template = "\n<w:pict>"
                + "\n       <v:shapetype id=\"_x0000_t75\" coordsize=\"21600,21600\" o:spt=\"75\" o:preferrelative=\"t\" path=\"m@4@5l@4@11@9@11@9@5xe\" filled=\"f\" stroked=\"f\">"
                + "         <v:stroke joinstyle=\"miter\"/>"
                + "         <v:formulas>"
                + "                 <v:f eqn=\"if lineDrawn pixelLineWidth 0\"/>"
                + "                 <v:f eqn=\"sum @0 1 0\"/><v:f eqn=\"sum 0 0 @1\"/>"
                + "                 <v:f eqn=\"prod @2 1 2\"/>"
                + "                 <v:f eqn=\"prod @3 21600 pixelWidth\"/>"
                + "                 <v:f eqn=\"prod @3 21600 pixelHeight\"/>"
                + "                 <v:f eqn=\"sum @0 0 1\"/>"
                + "                 <v:f eqn=\"prod @6 1 2\"/>"
                + "                 <v:f eqn=\"prod @7 21600 pixelWidth\"/>"
                + "                 <v:f eqn=\"sum @8 21600 0\"/>"
                + "                 <v:f eqn=\"prod @7 21600 pixelHeight\"/>"
                + "                 <v:f eqn=\"sum @10 21600 0\"/>"
                + "         </v:formulas>"
                + "         <v:path o:extrusionok=\"f\" gradientshapeok=\"t\" o:connecttype=\"rect\"/>"
                + "         <o:lock v:ext=\"edit\" aspectratio=\"t\"/>"
                + " </v:shapetype>"
                + "\n<w:binData w:name=\"wordml://{internalFileName}\" xml:space=\"preserve\">{binary}</w:binData>"
                + "\n       <v:shape id=\"_x0000_i1026\" type=\"#_x0000_t75\" style=\"width:{width}pt;height:{height}pt\"><v:imagedata src=\"wordml://{internalFileName}\" o:title=\"{fileName}\"/>"
                + "\n       </v:shape>" + "\n</w:pict>";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public static void main(ViewObjectImpl vo, Row row, String[] rowAttrs,
                            RowIterator[] iters, String[][] iterAttrs) {
        //        String[][] xxx = new String[][]();
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException,
                                                           IOException {
        HttpSession session = request.getSession();
        WordData wordData = (WordData)session.getAttribute("WORD_DATA");
        
        //String fileName = (String)session.getAttribute("FILE_NAME");
        String fileName = wordData.getFileName();
        System.out.println("fileName = " + fileName);
//        try {
//            fileName = request.getParameter("fileName");
//            System.out.println("encode fileName = " + fileName);
//            fileName = StringFunc.decodeRusString(fileName);
//            System.out.println("decode fileName = " + fileName);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        //if (fileName == null) fileName = "worddoc";

        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();

        response.setHeader("Content-Transfer-Encoding", "binary");
        response.setHeader("Content-Disposition",
                           "attachment; filename=\"" + URLEncoder.encode(fileName, "utf-8") + "\"");

        FILE_TEXT = Resource.getResourceString(Resource.class, "/doc_temps/" + fileName + ".doc");
        //System.out.println(FILE_TEXT);
        
        Map vals = wordData.getVals();
        setVals(vals);
//        Row row = (Row)session.getAttribute("ROW");
//        Row row_view = (Row)session.getAttribute("ROW_VIEW");
        String[] viewNames = wordData.getViewObjNames();
        for (String viewName : viewNames) {
            System.out.println("VIEW_NAME = "+viewName);
            Row row = wordData.getRow(viewName);  
            Row row_view = wordData.getRowView(viewName);

//            ADFUtils.printDataRow(row);
            ADFUtils.printDataRow(row_view);    
            
            //Map params = (Map)session.getAttribute("ROW_PARAMS");
            Map params = wordData.getViewObj(viewName); 
                
            setAttributes(null, row, params, row_view);
        }
        
        out.println(FILE_TEXT);
        out.close();
    }
    
    private void setVals(Map vals) {
        Set<String> keys = vals.keySet();
        for (String key : keys) {
            String val = (String)vals.get(key);
            replaceVal(key, val);
        }
    }
    
    private void setAttributes(String iterName, Row row, Map params) {
        setAttributes(iterName, row, params, null);
    }
    
    private void setAttributes(String iterName, Row row, Map params, Row row_view) {
            Row main_row = row;
            if (row_view != null) main_row = row_view;
            ArrayList rowNames = (ArrayList)params.get("names");
        
            for (int i = 0; i < rowNames.size(); i++) {
                String name = (String)rowNames.get(i);
                
                if (main_row == null) {
                    setAttribute(iterName, name, "");                    
                } else if (isIter(params, name)) {
                    setIter(params, name, row);
                } else setRowVal(iterName, name, main_row); 
            }
    }

    private void setIter(Map params, String iterName, Row row) {
        RowIterator iter = getIter(row, iterName);
        Map iters = (Map)params.get("iters");
        Map iterParams = (Map)iters.get(iterName);
        String iterText = getIterText(iterName);
        //System.err.println("iterName = " + iterName);
        //System.err.println("iterText = " + iterText);
        ArrayList names = (ArrayList)iterParams.get("names");
        Map filter = (Map)iterParams.get("filter");
        
        ArrayList arriter = filterIter(iter, filter);

        int size = arriter.size();
        if (size == 0) {
            setAttributes(iterName, null, iterParams);
            closeIterText(iterName);
        } else {
            for (int i = 0; i < size; i++) {
                setAttributes(iterName, (Row)arriter.get(i), iterParams);
                if (i != (size - 1)) addIterText(iterName, iterText);
                else closeIterText(iterName);
            }
        }
    }
    
    private void closeIterText(String iterName) {
        addIterText(iterName, "");
    }
    
    private void addIterText(String iterName, String iterText) {
        String start = "Start"+iterName;
        String end = "End"+iterName;
        FILE_TEXT = FILE_TEXT.replace(start, "");
        FILE_TEXT = FILE_TEXT.replace(end, iterText);
    }
    
    private ArrayList filterIter(RowIterator iter, Map filter) {
        String filterName = null;
        String filterVal = null;
        if (filter != null) {
            filterName = (String)filter.get("name");
            filterVal = (String)filter.get("val");
        }
        
        ArrayList arriter = new ArrayList();
        Row row;
        iter.reset();
        while ((row = iter.next()) != null) {
            if (filterName == null || row.getAttribute(filterName).equals(filterVal)) {
                arriter.add(row);
            }
        }
        return arriter;
    }
                                 
    private String getIterText(String iterName) {
        String text = FILE_TEXT;
        String start = "Start"+iterName;
        String end = "End"+iterName;
//        System.out.println("IterStart = "+start);
//        System.out.println("IterEnd = "+end);
        int i = text.indexOf(start);
        int j = text.indexOf(end, i);
//        System.out.println(i);
//        System.out.println(j);
        int l = end.length();
        if (i != -1 && j != -1) text = text.substring(i,j+l);
        return text;
    }
    
    private Boolean isIter(Map params, String name) {
        Map iters = (Map)params.get("iters");
        if (iters != null && iters.get(name) != null) {
            return true;
        } 
        return false;        
    }
    
    private RowIterator getIter(Row row, String name) {
        try {
            RowIterator vView = (RowIterator)row.getAttribute(name);
            return vView;
        } catch (Exception e) {
            System.err.println("Итератора с именем "+ name + " не найдено!");
            return null;
        }
    }

    private void setRowVal(String iterName, String attrName, Row row) {
        String value = null;
        oracle.jbo.domain.Number vNumber = null;
        oracle.jbo.domain.Date vDate = null;
        BlobDomain vBlob = null; 
//        if (numIter == 1) {
//        System.out.println(numIter);
//        String[] attrNames = row.getAttributeNames();
//        for (String attrN : attrNames) {
//            System.out.println("attrN = "+attrN);
//        }
//        Object[] attrValues = row.getAttributeValues();
//        for (Object attrV : attrValues) {
//            System.out.println("  attrV = "+attrV);
//        }
//        }
        //java.util.Date vDate = null;
        
        try {
            value = (String)row.getAttribute(attrName);
        } catch (Exception e1) {
            //e.printStackTrace();
            try {
                vNumber = (Number)row.getAttribute(attrName);
                value = vNumber.toString();
            } catch (Exception e2) {
                try {
                    vDate = (Date)row.getAttribute(attrName);
                    value = DateTime.dateToString(vDate);
                } catch (Exception e3) {
                    try {
                        vBlob = (BlobDomain)row.getAttribute(attrName);
                        value = getImage(vBlob);
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        System.err.println("Error: Не удалось определить тип значения!");
                    }
                }
            }
        }
        setAttribute(iterName, attrName, value);
    }
    

        
    private void setAttribute(String iterName, String attrName, String value) {
        if (value == null) value = "";
        String atN = "R" + attrName;
        if (iterName != null) atN = iterName + attrName;
        replaceVal(atN, value);
    }
    
    private void replaceVal(String valName, String value) {
        System.out.println(valName + " = " + value);
        String pattern = "\\{([^\\{])*"+valName+"([^\\}])*\\}";
                
        FILE_TEXT = FILE_TEXT.replaceAll(pattern, value);
    }
    
    private String getImage(BlobDomain blob) throws IOException {
        String fileName = "photo.jpg";
        String imageformat = "jpeg";
        String internalFileName = System.currentTimeMillis() + fileName;
        
        InputStream is = blob.getInputStream();
        BufferedImage bufferedImage = ImageIO.read(is);

        String binary = getImageHexaBase64(bufferedImage, imageformat);
        
        String res = img_template;
        res = res.replace("{fileName}", fileName);
        res = res.replace("{internalFileName}", internalFileName);
        res = res.replace("{binary}", binary);
        res = res.replace("{width}", "120");
        res = res.replace("{height}", "100");
        return res;
    }
    
    public static String getImageHexaBase64(BufferedImage bufferedImage, String imageformat) {
                    //System.out.println("@@@@@@@ IMAGE - getImageHexaBase64 NEW Way @@@@@@");
                    ByteArrayOutputStream baos = new ByteArrayOutputStream(1000);
                    //"gif"  "png" "jpeg"
                    try {
                            ImageIO.write(bufferedImage, imageformat.toString() , baos);
                            baos.flush();
                    } catch (IOException e) {
                            e.printStackTrace();
                            throw new RuntimeException("Erro generating Base64 for the image", e);
                    }
                    byte[] resultImageAsRawBytes = baos.toByteArray();

                    String encodedString = new Base64Encoder().encode(resultImageAsRawBytes);
                    //String encodedString = Base64.encodeBytes(resultImageAsRawBytes);
                    return encodedString;
    }


}
