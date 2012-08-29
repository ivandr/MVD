package ru.rdtex.mvd.weapon.view.word;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import java.util.Set;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;

import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.server.ViewObjectImpl;

import oracle.jbo.server.ViewRowImpl;

import ru.rdtex.global.ADFUtils;
import ru.rdtex.mvd.weapon.model.am.AppModuleImpl;

public class WordData {
    private String fileName;
    private AppModuleImpl mod;
    private Map rowsData = new HashMap();
    
    public WordData(String fileName) {
        super();
        
        setFileName(fileName);
        
        BindingContext bindingctx = BindingContext.getCurrent();
        DCBindingContainer bindings = (DCBindingContainer)bindingctx.getCurrentBindingsEntry();
        mod = (AppModuleImpl)bindings.getDataControl().getApplicationModule();
    }

    public String toString() {
        return rowsData.toString();
    }
    
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
    
    public Map getVals() {
        return (Map)rowsData.get("values");
    }
    
    public void addVals(String valName, String value) {
        Map values = (Map)rowsData.get("values");
        if (values == null) {
            values = new HashMap();
            rowsData.put("values", values);
        }
        values.put(valName, value);
    }
    
    public String[] getViewObjNames() {
        Set<String> k = rowsData.keySet();
        String[] names = new String[]{};
        for (String name : k) {
            if (!name.equals("values")) names = addElement(names, name);
        }
        return names;
    }
    
    public Map getViewObj(String nameViewObject) {
        return getViewObj(new String[]{}, nameViewObject);
    }
    
    public ViewRowImpl getRow(String nameViewObject) {
        Map vo = getViewObj(new String[]{}, nameViewObject);
        return (ViewRowImpl)vo.get("row");
    }
    
    public ViewRowImpl getRowView(String nameViewObject) {
        Map vo = getViewObj(new String[]{}, nameViewObject);
        return (ViewRowImpl)vo.get("row_view");
    }
    
    public ArrayList getColumns(String nameViewObject) {
        return getColumns(new String[]{}, nameViewObject);
    }
    
    public ArrayList getColumns(String[] linkViewObjects, String nameViewObject) {
        Map vo = getViewObj(linkViewObjects, nameViewObject);
        return (ArrayList)vo.get("names");
    }
    
    public Row addRow(String nameViewObject) {
        return addRow(new String[]{}, nameViewObject);
    }
    
    public Row addRow(String nameViewObject, Key key) {
        return addRow(new String[]{}, nameViewObject, key);
    }
    
    public Row addRow(String[] linkViewObjects, String nameViewObject) {
        ViewObjectImpl vo = (ViewObjectImpl)mod.findViewObject(nameViewObject);
        ViewRowImpl row = (ViewRowImpl)vo.getCurrentRow();
        if (row == null) row = (ViewRowImpl)vo.first();
        //System.err.println(row);
        setViewObjRow(linkViewObjects, nameViewObject, row);
        return row;
    }
    
    public Row addRow(String[] linkViewObjects, String nameViewObject, Key key) {
        ViewObjectImpl vo = (ViewObjectImpl)mod.findViewObject(nameViewObject);
        ViewRowImpl row = (ViewRowImpl)vo.getRow(key);
        setViewObjRow(linkViewObjects, nameViewObject, row);
        return row;
    }
    
    public Key addRowRead(String nameViewObject, String nameViewObjectRead) {
        return addRowRead(new String[]{}, nameViewObject, nameViewObjectRead);
    }
    
    public void addRowRead(String nameViewObject, String nameViewObjectRead, Key key) {
        addRowRead(new String[]{}, nameViewObject, nameViewObjectRead, key);
    }
    
    public Key addRowRead(String[] linkViewObjects, String nameViewObject, String nameViewObjectRead) {
        ViewObjectImpl vo = (ViewObjectImpl)mod.findViewObject(nameViewObjectRead);
        ViewRowImpl row = (ViewRowImpl)vo.getCurrentRow();
        setViewObjRow(linkViewObjects, nameViewObject, row, true);
        return row.getKey();
    }
    
    public void addRowRead(String[] linkViewObjects, String nameViewObject, String nameViewObjectRead, Key key) {
        ViewObjectImpl vo = (ViewObjectImpl)mod.findViewObject(nameViewObjectRead);
        ViewRowImpl row = (ViewRowImpl)vo.getRow(key);
        setViewObjRow(linkViewObjects, nameViewObject, row, true);
    }
    
    public void removeRow(String nameViewObject) {
        rowsData.remove(nameViewObject);
    }
    
    public void addColumn(String nameViewObject, String column) {
        addColumn(new String[]{}, nameViewObject, column);
    }
    
    public void addColumn(String[] linkViewObjects, String nameViewObject, String column) {
        Map vo = setViewObj(linkViewObjects, nameViewObject);
        ArrayList names = (ArrayList)vo.get("names");
        names.add(column);
    }
    
    public void addIterator(String nameViewObject, String iter) {
        addIterator(new String[]{}, nameViewObject, iter);
    }
    
    public void addIterator(String[] linkViewObjects, String nameViewObject, String iter) {
        addColumn(linkViewObjects, nameViewObject, iter);
        
        String[] link = addElement(linkViewObjects, nameViewObject);
        setViewObj(link, iter);
    }
    
    private void setViewObjRow(String[] linkViewObjects, String nameViewObject, ViewRowImpl row) {
        setViewObjRow(linkViewObjects, nameViewObject, row, false);
    }
    
    private void setViewObjRow(String[] linkViewObjects, String nameViewObject, ViewRowImpl row, boolean isRead) {
        Map vo = setViewObj(linkViewObjects, nameViewObject);
        //Map vo = (Map)rowsData.get(nameViewObject);
        //ADFUtils.printDataRow(row);
        if (!isRead) vo.put("row", row);
        vo.put("row_view", row);
    }

    private Map setViewObj(String[] linkViewObjects, String nameViewObject) {
            Map corrViewObj = getViewObj(linkViewObjects, nameViewObject, true);
            
            Map iter = null;
            if (corrViewObj == null) iter = rowsData;
            else iter = (Map)corrViewObj.get("iters");
            
            if (iter.get(nameViewObject) == null) {
                Map params = new HashMap();
                //params.put("row", null);
                    ArrayList names = new ArrayList();
                    Map iters = new HashMap();
                params.put("names", names);
                params.put("iters", iters);
                iter.put(nameViewObject, params);
            }
            return (Map)iter.get(nameViewObject);
    }
    
    private Map getViewObj(String[] linkViewObjects, String nameViewObject) {
            return getViewObj(linkViewObjects, nameViewObject, false);
    }
    
    private Map getViewObj(String[] linkViewObjects, String nameViewObject, boolean isParent) {
            Map corrViewObj = null;
            if (linkViewObjects.length != 0) {
                int i = 0;
                for (String viewObject : linkViewObjects) {
                    if (i == 0) corrViewObj = (Map)rowsData.get(viewObject); 
                    else {
                        Map iters = (Map)corrViewObj.get("iters");
                        corrViewObj = (Map)iters.get(viewObject); 
                    }
                    i++;
                }
            }
            if (isParent) return corrViewObj;
            else if (corrViewObj == null) return (Map)rowsData.get(nameViewObject); 
            return (Map)corrViewObj.get(nameViewObject);
    }
    
    public static String[] addElement(String[] org, String added) {
        String[] result = Arrays.copyOf(org, org.length +1);
        result[org.length] = added;
        return result;
    }
}
