package ru.rdtex.mvd.weapon.view.backing.input_data;

import java.util.HashMap;

import java.util.Map;

import java.util.Set;

import javax.annotation.PostConstruct;

import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.component.rich.RichForm;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;
import oracle.adf.view.rich.component.rich.input.RichSelectItem;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.input.RichSelectOneRadio;
import oracle.adf.view.rich.component.rich.layout.RichPanelAccordion;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelSplitter;
import oracle.adf.view.rich.component.rich.layout.RichPanelTabbed;
import oracle.adf.view.rich.component.rich.layout.RichShowDetailItem;
import oracle.adf.view.rich.component.rich.layout.RichToolbar;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.nav.RichGoButton;
import oracle.adf.view.rich.component.rich.output.RichMessages;
import oracle.adf.view.rich.component.rich.output.RichPanelCollection;

import oracle.adf.view.rich.render.ClientEvent;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.AttributeList;
import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.RowSet;
import oracle.jbo.ViewObject;

import oracle.jbo.server.AttributeListImpl;
import oracle.jbo.server.DBTransaction;

import oracle.jbo.server.ViewObjectImpl;

import org.apache.myfaces.trinidad.component.UIXGroup;

import org.apache.myfaces.trinidad.event.DisclosureEvent;

import org.apache.myfaces.trinidad.event.SelectionEvent;

import ru.rdtex.global.ADFUtils;
import ru.rdtex.mvd.weapon.global.JSFUtils;
import ru.rdtex.mvd.weapon.model.am.AppModuleImpl;
import ru.rdtex.mvd.weapon.model.vo.DocDocumentsViewImpl;
import ru.rdtex.mvd.weapon.model.vo.EntPersonsViewImpl;
import ru.rdtex.mvd.weapon.model.vo.read.VSuperDocViewImpl;
import ru.rdtex.mvd.weapon.view.backing.Main;
import oracle.jbo.domain.Number;

import oracle.jbo.server.ViewRowImpl;

import ru.rdtex.global.utils.Reflection;
import ru.rdtex.mvd.weapon.model.vo.DocPermissionsViewImpl;
import ru.rdtex.mvd.weapon.view.word.WordData;

public class Person_documents {
    private AppModuleImpl mod = (AppModuleImpl)ADFUtils.getBindingApplicationModule();
    private Row rowEntPersons;
    private int riEP;
    private int riSD;
    private EntPersonsViewImpl voEntPersons;
    private ViewObject voSuperDoc;
    private RichForm f1;
    private RichDocument d1;
    private RichMessages m1;
    private RichPanelCollection pc1;
    private RichTable t1;
    private UIXGroup g1;
    private RichPanelSplitter ps1;
    private RichPanelAccordion pa1;
    private RichShowDetailItem sdiRequest;
    private RichShowDetailItem sdiLicense;
    private RichInputText it1;
    private RichInputDate id1;
    private RichSelectOneChoice soc1;
    private UISelectItems si1;
    private RichSelectOneChoice soc2;
    private UISelectItems si2;
    private RichSelectOneChoice soc3;
    private UISelectItems si3;
    private RichInputDate id2;
    private RichPanelFormLayout pfl1;
    private RichInputText it2;
    private RichSelectBooleanCheckbox sbc1;
    private RichSelectOneChoice soc4;
    private UISelectItems si4;
    private RichPanelFormLayout pfl2;
    private RichPanelFormLayout pfl3;
    private RichCommandButton cb1;
    private RichPanelGroupLayout pgl1;
    private RichToolbar t2;
    private RichCommandButton cb3;
    private RichSelectBooleanCheckbox HEADER_CHECKBOX;
    private RichCommandButton cb4;
    private RichCommandButton cbCommit;
    private RichPanelFormLayout pfl4;
    private RichSelectOneChoice soc5;
    private UISelectItems si5;
    private RichPanelFormLayout pfl5;
    private RichSelectOneChoice soc6;
    private UISelectItems si6;
    private RichPanelFormLayout pfl6;
    private RichSelectOneChoice soc7;
    private UISelectItems si7;
    private RichInputText it3;
    private RichInputText it4;
    private RichInputDate id3;
    private RichInputDate id4;
    private RichPanelFormLayout pfl7;
    private RichSelectOneChoice soc8;
    private UISelectItems si8;
    private RichPanelFormLayout pfl8;
    private RichSelectOneChoice soc9;
    private UISelectItems si9;
    private RichInputDate id5;
    private RichInputText it5;
    private RichInputText it6;
    private RichInputText it7;
    private RichPanelFormLayout pfl9;
    private RichPanelGroupLayout panelGroupLayout2;
    private RichCommandButton commandButton3;
    private RichCommandButton commandButton4;
    private RichSelectOneChoice soc10;
    private UISelectItems si10;
    private RichSelectOneChoice soc11;
    private UISelectItems si11;
    private RichShowDetailItem sdiPermission;
    private RichPanelFormLayout panelFormLayout1;
    private RichSelectOneChoice selectOneChoice1;
    private UISelectItems selectItems1;
    private RichPanelFormLayout panelFormLayout2;
    private RichSelectOneChoice selectOneChoice2;
    private UISelectItems selectItems2;
    private RichInputText inputText1;
    private RichInputText inputText2;
    private RichInputDate inputDate1;
    private RichInputDate inputDate2;
    private RichPanelFormLayout panelFormLayout3;
    private RichSelectOneChoice selectOneChoice3;
    private UISelectItems selectItems3;
    private RichPanelFormLayout panelFormLayout4;
    private RichSelectOneChoice selectOneChoice4;
    private UISelectItems selectItems4;
    private RichInputText inputText3;
    private RichInputText inputText4;
    private RichInputDate inputDate3;
    private RichInputText inputText5;
    private RichPanelFormLayout panelFormLayout5;
    private RichPanelGroupLayout panelGroupLayout1;
    private RichCommandButton commandButton1;
    private RichCommandButton commandButton2;
    private RichSelectOneChoice selectOneChoice5;
    private UISelectItems selectItems5;
    private RichSelectOneChoice selectOneChoice6;
    private UISelectItems selectItems6;
    private RichPanelFormLayout pfl10;
    private RichCommandButton cb6;
    private RichPanelGroupLayout licenseEditPanel;
    private RichCommandButton cb7;
    private RichPanelGroupLayout pgl2;
    private RichPanelGroupLayout pgl3;
    private RichCommandButton cb8;
    private RichCommandButton cb9;
    private RichCommandButton cbRollback;
    private RichCommandButton cb5;
    private RichCommandButton cb10;
    private RichToolbar t3;
    private RichSelectOneRadio sor1;
    private RichSelectItem si12;
    private RichSelectItem si13;
    private RichInputText radioText;
    private String fdoc;
    private RichCommandButton cb2;
    private RichGoButton gb1;
    private RichPanelTabbed pt2;
    private RichShowDetailItem sdi1;
    private RichPanelCollection pc2;
    private RichTable t4;
    private RichInputDate id6;
    private RichInputDate id7;
    private RichPanelTabbed pt3;
    private RichShowDetailItem sdi2;
    private RichPanelCollection pc3;
    private RichTable t5;
    private RichToolbar t6;
    private RichCommandButton cb11;
    private RichToolbar t7;
    private RichCommandButton cb12;

    public String goWeaponLicense() {
        return goWeapon("DlId"); 
    }
    
    public String goWeaponPermission() {
        return goWeapon("DpId"); 
    }
    
    private String goWeapon(String colname) {
        ViewObjectImpl vo = (ViewObjectImpl)mod.findViewObject("VSuperDocView2");
        ViewRowImpl row = (ViewRowImpl)vo.getCurrentRow();
        Number id = (Number)row.getAttribute(colname);
        //HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = JSFUtils.getSession();
        session.setAttribute("docId", id);
        return "add_weapon"; 
    }
    
    public void selectVSuperDocRow(SelectionEvent selectionEvent) {
        Object collectionModel = JSFUtils.resolveExpression("#{bindings.VSuperDocView2.collectionModel}");
        Reflection.runInvokeMethod(collectionModel, "makeCurrent", new Object[]{selectionEvent});
        
        setWordData(null);
    }
    
    @PostConstruct
    public void initBean() {
        ViewObjectImpl vo = (ViewObjectImpl)mod.findViewObject("VSuperDocView2");
        ViewRowImpl row = (ViewRowImpl)vo.getCurrentRow();    
        if (row == null) {
            row = (ViewRowImpl)vo.first();
            Key k = row.getKey();
            setWordData(k);
        }
    }
    
    private void setWordData(Key key) {
        WordData wordData = new WordData("ЛГА_Бланк");
        Row personRow = wordData.addRow("EntPersonsView1");
        wordData.addRowRead("EntPersonsView1", "REntPersonsView1", personRow.getKey());        
        wordData.addColumn("EntPersonsView1", "TitleSurname");
        wordData.addColumn("EntPersonsView1", "Name");
        wordData.addColumn("EntPersonsView1", "Otchestvo");
        //из таблице 
        wordData.addColumn("EntPersonsView1", "AddrStrAdrs");
       
        Row vSuoerDocRow = null;
        if (key == null) vSuoerDocRow = wordData.addRow("VSuperDocView2"); 
        else vSuoerDocRow = wordData.addRow("VSuperDocView2", key);
        //ADFUtils.printDataRow(vSuoerDocRow);
        wordData.addColumn("VSuperDocView2", "DrDocNumb");
        wordData.addColumn("VSuperDocView2", "DrDocDate");
        wordData.addColumn("VSuperDocView2", "DrDocDay");
        wordData.addColumn("VSuperDocView2", "DrDocMonth");
        wordData.addColumn("VSuperDocView2", "DrDocMonStr");
        wordData.addColumn("VSuperDocView2", "DrDocYear");
        wordData.addColumn("VSuperDocView2", "DlDocDate");
        wordData.addColumn("VSuperDocView2", "DlDocDay");
        wordData.addColumn("VSuperDocView2", "DlDocMonth");
        wordData.addColumn("VSuperDocView2", "DlDocMonStr");
        wordData.addColumn("VSuperDocView2", "DlDocYear");
        wordData.addColumn("VSuperDocView2", "DpDocDate");
        wordData.addColumn("VSuperDocView2", "DpDocDay");
        wordData.addColumn("VSuperDocView2", "DpDocMonth");
        wordData.addColumn("VSuperDocView2", "DpDocMonStr");
        wordData.addColumn("VSuperDocView2", "DpDocYear");
        wordData.addColumn("VSuperDocView2", "LEndDate");
        wordData.addColumn("VSuperDocView2", "LEndDay");
        wordData.addColumn("VSuperDocView2", "LEndMonth");
        wordData.addColumn("VSuperDocView2", "LEndMonStr");
        wordData.addColumn("VSuperDocView2", "LEndYear");
        wordData.addColumn("VSuperDocView2", "PEndDate");
        wordData.addColumn("VSuperDocView2", "PEndDay");
        wordData.addColumn("VSuperDocView2", "PEndMonth");
        wordData.addColumn("VSuperDocView2", "PEndMonStr");
        wordData.addColumn("VSuperDocView2", "PEndYear");
        wordData.addIterator("VSuperDocView2", "DocPermissionsView");
        wordData.addColumn(new String[]{"VSuperDocView2"}, "DocPermissionsView", "EmpSign"); //DocPermissionsViewEmpSing
        wordData.addColumn(new String[]{"VSuperDocView2"}, "DocPermissionsView", "HeadSign"); //DocPermissionsViewHeadSing
        wordData.addIterator("VSuperDocView2", "RGunGunsView");
        wordData.addColumn(new String[]{"VSuperDocView2"}, "RGunGunsView", "ModelTitle");
        wordData.addColumn(new String[]{"VSuperDocView2"}, "RGunGunsView", "Series"); 
        wordData.addColumn(new String[]{"VSuperDocView2"}, "RGunGunsView", "Numb"); 
        wordData.addColumn(new String[]{"VSuperDocView2"}, "RGunGunsView", "MakeYear"); 
        
        wordData.addRow("RObjObjectCurrentView1");
        wordData.addColumn("RObjObjectCurrentView1", "ShortName");
        wordData.addColumn("RObjObjectCurrentView1", "RegionTitleAdr");
        wordData.addColumn("RObjObjectCurrentView1", "AdrFull");
        wordData.addColumn("RObjObjectCurrentView1", "AdrTown");
        wordData.addColumn("RObjObjectCurrentView1", "AdrStreet");
        wordData.addColumn("RObjObjectCurrentView1", "AdrHouse");
        wordData.addColumn("RObjObjectCurrentView1", "AdrCorpus");
        wordData.addColumn("RObjObjectCurrentView1", "AdrRoom");
        
        wordData.addVals("VarTypeDocument", "Лицензия");
        
        System.out.println("ЛГА_Бланк = "+wordData);        
        
        //передаем все параметры в сессию
        HttpSession session = JSFUtils.getSession(); 
        session.setAttribute("WORD_DATA", wordData);
    }
    
    public void myCustomChangeRadioListener(ClientEvent event) {
        String value;// = event.getParameters().get("value").toString();
        Double vNum;
        Number vInt;
        try {
            value = (String)event.getParameters().get("value");
        } catch(Exception ex) {
            vNum = (Double)event.getParameters().get("value");
            value = vNum.toString();
            value = value.substring(0, 1);
        }
        String id = (String)event.getParameters().get("id");
        System.out.println("@id = "+id);
        System.out.println("@value = "+value);
        VSuperDocViewImpl vo = mod.getVSuperDocView2();
        vo.setfdoc("1");
        if (value != null) {
            vo.setfdoc(value);
        } 
        vo.executeQuery();
        vo.first();
    }
    
    public void setFdoc(String fdoc) {
        
    }

    public String getFdoc() {
        VSuperDocViewImpl vo = mod.getVSuperDocView2();
        String fdoc = vo.getfdoc();
        return (fdoc == null ? "1" : fdoc);
    }
    
    public void createRequest(ActionEvent actionEvent) {    
        Number personId = getEntPersonId(); 
        Number idDocRelations = insertDocRelations(personId);
        Number idDocDocuments = insertDocDocuments("1", null);
        insertDocRequests(idDocDocuments);
        insertDocDocumentsDocRelations(idDocRelations, idDocDocuments);
        
        focusRequest();
    }
    
    public void deleteSelectedRows(ActionEvent actionEvent) {        
        ViewObjectImpl vo = (ViewObjectImpl)mod.findViewObject("VSuperDocView2");
        RowSet duplicateRowSet = vo.createRowSet("duplicateRowSet");
        duplicateRowSet.first();
        Row currentRow = vo.getCurrentRow();
        boolean currentRowDeleted = false;
        Row[] rowsToDelete = duplicateRowSet.getFilteredRows("DeleteRow", true);
        
        if (rowsToDelete.length > 0) {
            for (Row rw : rowsToDelete) {
                if (rw.getKey().equals(currentRow.getKey())) {
                    currentRowDeleted = true;
                }
                Number idDocRelations = getDocRelationId(rw);
                Number idDocDocuments = getDocDocumentsRequestId(rw);
                deleteRequest(idDocRelations, idDocDocuments);
            }
            vo.executeQuery();
            if (!currentRowDeleted) {
                vo.setCurrentRow(currentRow);
            }
        }
        duplicateRowSet.closeRowSet();
    }
    
    public void deleteRequest(ActionEvent actionEvent) {           
        Number idDocRelations = getDocRelationId();
//        Key keyDocRelations = new Key(new Object[]{idDocRelations});
                
        DocDocumentsViewImpl voDD = (DocDocumentsViewImpl)mod.getDocDocumentsView4();
        Row  rowDD = voDD.getCurrentRow();
        Number idDocDocuments = (Number)rowDD.getAttribute("Id");
//        voDD.removeCurrentRow();
        
//        ViewObjectImpl voDR = mod.getDocRelationsView1();
//        Row rowDR = voDR.getRow(keyDocRelations);
//        rowDR.remove();
        
        deleteRequest(idDocRelations, idDocDocuments);      
    }
    
    private void deleteRequest(Number idDocRelations, Number idDocDocuments) {   
        setViewObjectParams();
        
        DBTransaction tran = (DBTransaction)mod.getTransaction();
        String ddl = "DELETE FROM DOC_RELATIONS WHERE ID = " + idDocRelations;
        tran.executeCommand(ddl);
        ddl = "DELETE FROM DOC_DOCUMENTS WHERE ID = " + idDocDocuments;
        tran.executeCommand(ddl);
        
        reloadViewObject();
        
        setDisabledCommit(false);        
    }
    
    public void deleteLicense(ActionEvent actionEvent) {           
        DocDocumentsViewImpl voDD = (DocDocumentsViewImpl)mod.getDocDocumentsView6();
        Row  rowDD = voDD.getCurrentRow();
        Number idDocDocuments = (Number)rowDD.getAttribute("Id");
        
        deleteDocument(idDocDocuments);      
    }
    
    public void deletePermission(ActionEvent actionEvent) {           
        DocDocumentsViewImpl voDD = (DocDocumentsViewImpl)mod.getDocDocumentsView8();
        Row  rowDD = voDD.getCurrentRow();
        Number idDocDocuments = (Number)rowDD.getAttribute("Id");
        
        deleteDocument(idDocDocuments);      
    }
    
    private void deleteDocument(Number idDocDocuments) {   
        setViewObjectParams();
        
        DBTransaction tran = (DBTransaction)mod.getTransaction();
        String ddl = "DELETE FROM DOC_DOCUMENTS WHERE ID = " + idDocDocuments;
        tran.executeCommand(ddl);
        
        reloadViewObject();     
        
        setDisabledCommit(false);  
    }
    
    public void createLicense(ActionEvent actionEvent) {
        Number idDocRelations = getDocRelationId();
        Number idDocDocumentsRequest = getDocDocumentsRequestId();
        Number idDocDocuments = insertDocDocuments("2", idDocDocumentsRequest);
        insertDocPermissionsL(idDocDocuments);
        insertDocDocumentsDocRelations(idDocRelations, idDocDocuments);
    }
    
    public void createPermission(ActionEvent actionEvent) {
        Number idDocRelations = getDocRelationId();
        Number idDocDocumentsRequest = getDocDocumentsRequestId();
        Number idDocDocuments = insertDocDocuments("3", idDocDocumentsRequest);
        insertDocPermissionsP(idDocDocuments);
        insertDocDocumentsDocRelations(idDocRelations, idDocDocuments);
    }
    
    private Number getEntPersonId() {
        EntPersonsViewImpl voEP = (EntPersonsViewImpl)mod.getEntPersonsView1();
        Row rEP = voEP.getCurrentRow();
        return (Number)rEP.getAttribute("Id");
    }
    
    private Number insertDocRelations(Number personId) {
        ViewObjectImpl voDR = mod.getDocRelationsView1();
        AttributeList alDR = new AttributeListImpl();
        alDR.setAttribute("EpId", personId);
        Row rDR = voDR.createAndInitRow(alDR);
        voDR.insertRow(rDR);
        
//        String[] names =  rDR.getAttributeNames();
//        Object[] vals = rDR.getAttributeValues();
//        int i = 0;
//        for (String name : names) {
//            System.out.println("DocRelations: " + names[i] + " = " + vals[i]); 
//            i++;
//        }
        
        return (Number)rDR.getAttribute("Id");
    }
    
    private Number getDocRelationId() {
        VSuperDocViewImpl voSD = mod.getVSuperDocView2();
        Row SDRow = voSD.getCurrentRow();
        return getDocRelationId(SDRow);
    }
    
    private Number getDocRelationId(Row row) {
        return (Number)row.getAttribute("DrelId");
    }
    
    private Number getDocDocumentsRequestId() {
        VSuperDocViewImpl voSD = mod.getVSuperDocView2();
        Row SDRow = voSD.getCurrentRow();
        return getDocDocumentsRequestId(SDRow);
    }
    
    private Number getDocDocumentsRequestId(Row row) {
        return (Number)row.getAttribute("DrId");
    }
    
    private Number insertDocDocuments(String type, Number idDocDocumentsRequest) {
            DocDocumentsViewImpl voDD = null;
            String docName = null;
            if (type.equals("1")) {
                voDD = (DocDocumentsViewImpl)mod.getDocDocumentsView4();
                docName = "ЗАЯВЛЕНИЕ";
            } else if (type.equals("2")) {
                voDD = (DocDocumentsViewImpl)mod.getDocDocumentsView6();
                docName = "ЛИЦЕНЗИЯ";
            } else if (type.equals("3")) { 
                voDD = mod.getDocDocumentsView8();
                docName = "РАЗРЕШЕНИЕ";
            }
            
            AttributeList alDD = new AttributeListImpl();
            alDD.setAttribute("DdcId", idDocDocumentsRequest);
            alDD.setAttribute("DocType", type);
            alDD.setAttribute("DocName", docName);
            alDD.setAttribute("DocNumb", null);
            alDD.setAttribute("DocDate", null);
            String dept = Main.getObjObjectCurrent();
            alDD.setAttribute("Department", dept);
            Row rDD = voDD.createAndInitRow(alDD);
            voDD.insertRow(rDD);

            return (Number)rDD.getAttribute("Id");
    }
    
    private void insertDocPermissionsL(Number idDocDocuments) {
        DocPermissionsViewImpl vo = mod.getDocPermissionsView4();
        insertDocPermissions(vo, idDocDocuments);
    }
    
    private void insertDocPermissionsP(Number idDocDocuments) {
        DocPermissionsViewImpl vo = mod.getDocPermissionsView6();
        insertDocPermissions(vo, idDocDocuments);
    }
    
    private void insertDocPermissions(DocPermissionsViewImpl vo, Number idDocDocuments) {        
        AttributeList alDP = new AttributeListImpl();
        alDP.setAttribute("DdcId", idDocDocuments);
        alDP.setAttribute("TypelicId", null);
        Row rDP = vo.createAndInitRow(alDP);
        vo.insertRow(rDP);
    }
    
    private void insertDocRequests(Number idDocDocuments) {
        ViewObjectImpl voDR = mod.getDocRequestsView3();
        AttributeList alDR = new AttributeListImpl();
        alDR.setAttribute("DdcId", idDocDocuments);
        alDR.setAttribute("TypelicId", null);
        alDR.setAttribute("Result", null);
        alDR.setAttribute("ResultDate", null);
        Row rDR = voDR.createAndInitRow(alDR);
        voDR.insertRow(rDR);
    }
            
    private void insertDocDocumentsDocRelations(Number idDocRelations, Number idDocDocuments) {        
        ViewObjectImpl voDDDR = mod.getDocDocumentsDocRelationsView1();
        AttributeList alDDDR = new AttributeListImpl();
        alDDDR.setAttribute("DrlId", idDocRelations);
        alDDDR.setAttribute("DdcId", idDocDocuments);
        Row rDDDR = voDDDR.createAndInitRow(alDDDR);
        voDDDR.insertRow(rDDDR);        

//          EntPersonsViewImpl voEP = (EntPersonsViewImpl)mod.getEntPersonsView1();
//          int ri = voEP.getCurrentRowIndex();
//          voEP.executeQuery();
//          voEP.setCurrentRowAtRangeIndex(ri);
    }
    
    private void focusRequest() {
        RichShowDetailItem sdiR = getSdiRequest();
        RichShowDetailItem sdiL = getSdiLicense();
        RichShowDetailItem sdiP = getSdiPermission();
        sdiR.setDisclosed(true);
        //sdiL.setDisabled(true);
       // sdiP.setDisabled(true);
    }
    
    private void clearFocus() {
        RichShowDetailItem sdiR = getSdiRequest();
        RichShowDetailItem sdiL = getSdiLicense();
        RichShowDetailItem sdiP = getSdiPermission();
        sdiR.setDisabled(false);
        sdiL.setDisabled(false);
        sdiP.setDisabled(false);
    }
    
    private void setDisabledCommit(boolean isDisabled) {
        RichCommandButton com = getCbCommit();
        com.setDisabled(isDisabled);
        RichCommandButton rol = getCbRollback();
        rol.setDisabled(isDisabled);
    }
        
    
    public void changeTypeBlank(DisclosureEvent disclosureEvent){
        UIComponent comp = disclosureEvent.getComponent();    
    }
    
    public String save_action() {
        //String save_action = Main.save_action();            
        return action("Commit");
    }
    
    public String rollback_action() {            
        return action("Rollback");
    }
    
    private String action(String name) {
        //String save_action = Main.save_action();
        setViewObjectParams();
        
        BindingContainer bindings = BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding operationBinding = bindings.getOperationBinding(name);
        operationBinding.execute();
        
        reloadViewObject();
        
        setDisabledCommit(true);
            
        return null;
    }
    
    private void setViewObjectParams() {
        voEntPersons = (EntPersonsViewImpl)mod.getEntPersonsView1();
        DCIteratorBinding iter = ADFUtils.findIterator("VSuperDocView2Iterator");
        voSuperDoc = iter.getViewObject();
        rowEntPersons = voEntPersons.getCurrentRow();
        riEP = voEntPersons.getCurrentRowIndex();
        riSD = voSuperDoc.getCurrentRowIndex();
    }
    
    private void reloadViewObject() {
        voEntPersons.refreshCollection(new Row[]{rowEntPersons}, false, false);
        //voEP.executeQuery();
        voEntPersons.setRangeStart(riEP);
        voEntPersons.setCurrentRowAtRangeIndex(0);
        //voEP.setCurrentRow(rowEP);

        voSuperDoc.executeQuery();
        voSuperDoc.setRangeStart(riSD);
        voSuperDoc.setCurrentRowAtRangeIndex(0);
    }
    
    public static void main(String[] args) throws Exception {
        Map rowsData = new HashMap();
        Map params = new HashMap();
        rowsData.put("test", params);
        params.put("i", "1");
        Set<String> k = params.keySet();
        for (String entry : k) {
                 System.out.println(entry);
             }
        
//        AppModuleImpl mod =
//            (AppModuleImpl)Configuration.createRootApplicationModule(
//                  "ru.rdtex.mvd.weapon.model.am.AppModule",
//                  "AppModuleLocal");
//        DBTransaction tran = (DBTransaction)mod.getTransaction();
//
//        EntPersonsViewImpl voEP = (EntPersonsViewImpl)mod.getEntPersonsView1();
//        voEP.setpersonType("ФЛ");
//        
//        Key k = new Key(new Object[]{"13504"});
//        Row rEP = voEP.getRow(k);
//        voEP.setCurrentRow(rEP);
//        
//        
//        ViewObjectImpl voDR = mod.getDocRelationsView1();
//        AttributeList alDR = new AttributeListImpl();
//        alDR.setAttribute("EpId", "13504");
//        Row rDR = voDR.createAndInitRow(alDR);
//        voDR.insertRow(rDR);
//        
//        Number DocRelationsId = (Number)rDR.getAttribute("Id");
//        
//        DocDocumentsViewImpl voDD = (DocDocumentsViewImpl)mod.getDocDocumentsView4();
//        
//        AttributeList alDD = new AttributeListImpl();
//        alDD.setAttribute("DdcId", null);
//        alDD.setAttribute("DocType", "1");
//        alDD.setAttribute("DocNumb", "111");
//        alDD.setAttribute("DocDate", new Date());
//        ///String dept = Main.getObjObjectCurrent();
//        alDD.setAttribute("Department", "DDD");
//        Row rDD = voDD.createAndInitRow(alDD);
//        voDD.insertRow(rDD);
//        
//        Number DocDocumentsId = (Number)rDD.getAttribute("Id");
//        
//        System.out.println(DocRelationsId);
//        System.out.println(DocDocumentsId);
//        ViewObjectImpl voDDDR = mod.getDocDocumentsDocRelationsView1();
//        AttributeList alDDDR = new AttributeListImpl();
//        alDDDR.setAttribute("DrlId", DocRelationsId);
//        alDDDR.setAttribute("DdcId", DocDocumentsId);
//        Row rDDDR = voDDDR.createAndInitRow(alDDDR);
//        voDDDR.insertRow(rDDDR);
//        
//        tran.commit();

        // tran.connect(arg0, dd);
        // ddd();
        
        
    }

    private static void ddd() {
        //Configuration.
        //System.out.println(co);
    }
    
    public void setF1(RichForm f1) {
        this.f1 = f1;
    }

    public RichForm getF1() {
        return f1;
    }

    public void setD1(RichDocument d1) {
        this.d1 = d1;
    }

    public RichDocument getD1() {
        return d1;
    }


    public void setM1(RichMessages m1) {
        this.m1 = m1;
    }

    public RichMessages getM1() {
        return m1;
    }


    public void setPc1(RichPanelCollection pc1) {
        this.pc1 = pc1;
    }

    public RichPanelCollection getPc1() {
        return pc1;
    }

    public void setT1(RichTable t1) {
        this.t1 = t1;
    }

    public RichTable getT1() {
        return t1;
    }

    public void setG1(UIXGroup g1) {
        this.g1 = g1;
    }

    public UIXGroup getG1() {
        return g1;
    }

    public void setPs1(RichPanelSplitter ps1) {
        this.ps1 = ps1;
    }

    public RichPanelSplitter getPs1() {
        return ps1;
    }


    public void setPa1(RichPanelAccordion pa1) {
        this.pa1 = pa1;
    }

    public RichPanelAccordion getPa1() {
        return pa1;
    }

    public void setSdiRequest(RichShowDetailItem sdi1) {
        this.sdiRequest = sdi1;
    }

    public RichShowDetailItem getSdiRequest() {
        return sdiRequest;
    }

    public void setSdiLicense(RichShowDetailItem sdi2) {
        this.sdiLicense = sdi2;
    }

    public RichShowDetailItem getSdiLicense() {
        return sdiLicense;
    }


    public void setIt1(RichInputText it1) {
        this.it1 = it1;
    }

    public RichInputText getIt1() {
        return it1;
    }

    public void setId1(RichInputDate id1) {
        this.id1 = id1;
    }

    public RichInputDate getId1() {
        return id1;
    }

    public void setSoc1(RichSelectOneChoice soc1) {
        this.soc1 = soc1;
    }

    public RichSelectOneChoice getSoc1() {
        return soc1;
    }

    public void setSi1(UISelectItems si1) {
        this.si1 = si1;
    }

    public UISelectItems getSi1() {
        return si1;
    }


    public void setSoc2(RichSelectOneChoice soc2) {
        this.soc2 = soc2;
    }

    public RichSelectOneChoice getSoc2() {
        return soc2;
    }

    public void setSi2(UISelectItems si2) {
        this.si2 = si2;
    }

    public UISelectItems getSi2() {
        return si2;
    }


    public void setSoc3(RichSelectOneChoice soc3) {
        this.soc3 = soc3;
    }

    public RichSelectOneChoice getSoc3() {
        return soc3;
    }

    public void setSi3(UISelectItems si3) {
        this.si3 = si3;
    }

    public UISelectItems getSi3() {
        return si3;
    }

    public void setId2(RichInputDate id2) {
        this.id2 = id2;
    }

    public RichInputDate getId2() {
        return id2;
    }

    public void setPfl1(RichPanelFormLayout pfl1) {
        this.pfl1 = pfl1;
    }

    public RichPanelFormLayout getPfl1() {
        return pfl1;
    }

    public void setIt2(RichInputText it2) {
        this.it2 = it2;
    }

    public RichInputText getIt2() {
        return it2;
    }

    public void setSbc1(RichSelectBooleanCheckbox sbc1) {
        this.sbc1 = sbc1;
    }

    public RichSelectBooleanCheckbox getSbc1() {
        return sbc1;
    }

    public void setSoc4(RichSelectOneChoice soc4) {
        this.soc4 = soc4;
    }

    public RichSelectOneChoice getSoc4() {
        return soc4;
    }

    public void setSi4(UISelectItems si4) {
        this.si4 = si4;
    }

    public UISelectItems getSi4() {
        return si4;
    }

    public void setPfl2(RichPanelFormLayout pfl2) {
        this.pfl2 = pfl2;
    }

    public RichPanelFormLayout getPfl2() {
        return pfl2;
    }


    public void setPfl3(RichPanelFormLayout pfl3) {
        this.pfl3 = pfl3;
    }

    public RichPanelFormLayout getPfl3() {
        return pfl3;
    }


    public void setCb1(RichCommandButton cb1) {
        this.cb1 = cb1;
    }

    public RichCommandButton getCb1() {
        return cb1;
    }

    public void setPgl1(RichPanelGroupLayout pgl1) {
        this.pgl1 = pgl1;
    }

    public RichPanelGroupLayout getPgl1() {
        return pgl1;
    }

    public void setT2(RichToolbar t2) {
        this.t2 = t2;
    }

    public RichToolbar getT2() {
        return t2;
    }


    public void setCb3(RichCommandButton cb3) {
        this.cb3 = cb3;
    }

    public RichCommandButton getCb3() {
        return cb3;
    }


    public void setHEADER_CHECKBOX(RichSelectBooleanCheckbox HEADER_CHECKBOX) {
        this.HEADER_CHECKBOX = HEADER_CHECKBOX;
    }

    public RichSelectBooleanCheckbox getHEADER_CHECKBOX() {
        return HEADER_CHECKBOX;
    }

    public void setCb4(RichCommandButton cb4) {
        this.cb4 = cb4;
    }

    public RichCommandButton getCb4() {
        return cb4;
    }


    public void setCbCommit(RichCommandButton cb5) {
        this.cbCommit = cb5;
    }

    public RichCommandButton getCbCommit() {
        return cbCommit;
    }

    public void setPfl4(RichPanelFormLayout pfl4) {
        this.pfl4 = pfl4;
    }

    public RichPanelFormLayout getPfl4() {
        return pfl4;
    }

    public void setSoc5(RichSelectOneChoice soc5) {
        this.soc5 = soc5;
    }

    public RichSelectOneChoice getSoc5() {
        return soc5;
    }

    public void setSi5(UISelectItems si5) {
        this.si5 = si5;
    }

    public UISelectItems getSi5() {
        return si5;
    }

    public void setPfl5(RichPanelFormLayout pfl5) {
        this.pfl5 = pfl5;
    }

    public RichPanelFormLayout getPfl5() {
        return pfl5;
    }

    public void setSoc6(RichSelectOneChoice soc6) {
        this.soc6 = soc6;
    }

    public RichSelectOneChoice getSoc6() {
        return soc6;
    }

    public void setSi6(UISelectItems si6) {
        this.si6 = si6;
    }

    public UISelectItems getSi6() {
        return si6;
    }

    public void setPfl6(RichPanelFormLayout pfl6) {
        this.pfl6 = pfl6;
    }

    public RichPanelFormLayout getPfl6() {
        return pfl6;
    }

    public void setSoc7(RichSelectOneChoice soc7) {
        this.soc7 = soc7;
    }

    public RichSelectOneChoice getSoc7() {
        return soc7;
    }

    public void setSi7(UISelectItems si7) {
        this.si7 = si7;
    }

    public UISelectItems getSi7() {
        return si7;
    }

    public void setIt3(RichInputText it3) {
        this.it3 = it3;
    }

    public RichInputText getIt3() {
        return it3;
    }

    public void setIt4(RichInputText it4) {
        this.it4 = it4;
    }

    public RichInputText getIt4() {
        return it4;
    }

    public void setId3(RichInputDate id3) {
        this.id3 = id3;
    }

    public RichInputDate getId3() {
        return id3;
    }

    public void setId4(RichInputDate id4) {
        this.id4 = id4;
    }

    public RichInputDate getId4() {
        return id4;
    }

    public void setPfl7(RichPanelFormLayout pfl7) {
        this.pfl7 = pfl7;
    }

    public RichPanelFormLayout getPfl7() {
        return pfl7;
    }

    public void setSoc8(RichSelectOneChoice soc8) {
        this.soc8 = soc8;
    }

    public RichSelectOneChoice getSoc8() {
        return soc8;
    }

    public void setSi8(UISelectItems si8) {
        this.si8 = si8;
    }

    public UISelectItems getSi8() {
        return si8;
    }

    public void setPfl8(RichPanelFormLayout pfl8) {
        this.pfl8 = pfl8;
    }

    public RichPanelFormLayout getPfl8() {
        return pfl8;
    }

    public void setSoc9(RichSelectOneChoice soc9) {
        this.soc9 = soc9;
    }

    public RichSelectOneChoice getSoc9() {
        return soc9;
    }

    public void setSi9(UISelectItems si9) {
        this.si9 = si9;
    }

    public UISelectItems getSi9() {
        return si9;
    }

    public void setId5(RichInputDate id5) {
        this.id5 = id5;
    }

    public RichInputDate getId5() {
        return id5;
    }


    public void setIt5(RichInputText it5) {
        this.it5 = it5;
    }

    public RichInputText getIt5() {
        return it5;
    }

    public void setIt6(RichInputText it6) {
        this.it6 = it6;
    }

    public RichInputText getIt6() {
        return it6;
    }

    public void setIt7(RichInputText it7) {
        this.it7 = it7;
    }

    public RichInputText getIt7() {
        return it7;
    }


    public void setPfl9(RichPanelFormLayout pfl9) {
        this.pfl9 = pfl9;
    }

    public RichPanelFormLayout getPfl9() {
        return pfl9;
    }

    public void setPanelGroupLayout2(RichPanelGroupLayout panelGroupLayout2) {
        this.panelGroupLayout2 = panelGroupLayout2;
    }

    public RichPanelGroupLayout getPanelGroupLayout2() {
        return panelGroupLayout2;
    }

    public void setCommandButton3(RichCommandButton commandButton3) {
        this.commandButton3 = commandButton3;
    }

    public RichCommandButton getCommandButton3() {
        return commandButton3;
    }

    public void setCommandButton4(RichCommandButton commandButton4) {
        this.commandButton4 = commandButton4;
    }

    public RichCommandButton getCommandButton4() {
        return commandButton4;
    }

    public void setSoc10(RichSelectOneChoice soc10) {
        this.soc10 = soc10;
    }

    public RichSelectOneChoice getSoc10() {
        return soc10;
    }

    public void setSi10(UISelectItems si10) {
        this.si10 = si10;
    }

    public UISelectItems getSi10() {
        return si10;
    }

    public void setSoc11(RichSelectOneChoice soc11) {
        this.soc11 = soc11;
    }

    public RichSelectOneChoice getSoc11() {
        return soc11;
    }

    public void setSi11(UISelectItems si11) {
        this.si11 = si11;
    }

    public UISelectItems getSi11() {
        return si11;
    }

    public void setSdiPermission(RichShowDetailItem showDetailItem1) {
        this.sdiPermission = showDetailItem1;
    }

    public RichShowDetailItem getSdiPermission() {
        return sdiPermission;
    }

    public void setPanelFormLayout1(RichPanelFormLayout panelFormLayout1) {
        this.panelFormLayout1 = panelFormLayout1;
    }

    public RichPanelFormLayout getPanelFormLayout1() {
        return panelFormLayout1;
    }

    public void setSelectOneChoice1(RichSelectOneChoice selectOneChoice1) {
        this.selectOneChoice1 = selectOneChoice1;
    }

    public RichSelectOneChoice getSelectOneChoice1() {
        return selectOneChoice1;
    }

    public void setSelectItems1(UISelectItems selectItems1) {
        this.selectItems1 = selectItems1;
    }

    public UISelectItems getSelectItems1() {
        return selectItems1;
    }

    public void setPanelFormLayout2(RichPanelFormLayout panelFormLayout2) {
        this.panelFormLayout2 = panelFormLayout2;
    }

    public RichPanelFormLayout getPanelFormLayout2() {
        return panelFormLayout2;
    }

    public void setSelectOneChoice2(RichSelectOneChoice selectOneChoice2) {
        this.selectOneChoice2 = selectOneChoice2;
    }

    public RichSelectOneChoice getSelectOneChoice2() {
        return selectOneChoice2;
    }

    public void setSelectItems2(UISelectItems selectItems2) {
        this.selectItems2 = selectItems2;
    }

    public UISelectItems getSelectItems2() {
        return selectItems2;
    }

    public void setInputText1(RichInputText inputText1) {
        this.inputText1 = inputText1;
    }

    public RichInputText getInputText1() {
        return inputText1;
    }

    public void setInputText2(RichInputText inputText2) {
        this.inputText2 = inputText2;
    }

    public RichInputText getInputText2() {
        return inputText2;
    }

    public void setInputDate1(RichInputDate inputDate1) {
        this.inputDate1 = inputDate1;
    }

    public RichInputDate getInputDate1() {
        return inputDate1;
    }

    public void setInputDate2(RichInputDate inputDate2) {
        this.inputDate2 = inputDate2;
    }

    public RichInputDate getInputDate2() {
        return inputDate2;
    }

    public void setPanelFormLayout3(RichPanelFormLayout panelFormLayout3) {
        this.panelFormLayout3 = panelFormLayout3;
    }

    public RichPanelFormLayout getPanelFormLayout3() {
        return panelFormLayout3;
    }

    public void setSelectOneChoice3(RichSelectOneChoice selectOneChoice3) {
        this.selectOneChoice3 = selectOneChoice3;
    }

    public RichSelectOneChoice getSelectOneChoice3() {
        return selectOneChoice3;
    }

    public void setSelectItems3(UISelectItems selectItems3) {
        this.selectItems3 = selectItems3;
    }

    public UISelectItems getSelectItems3() {
        return selectItems3;
    }

    public void setPanelFormLayout4(RichPanelFormLayout panelFormLayout4) {
        this.panelFormLayout4 = panelFormLayout4;
    }

    public RichPanelFormLayout getPanelFormLayout4() {
        return panelFormLayout4;
    }

    public void setSelectOneChoice4(RichSelectOneChoice selectOneChoice4) {
        this.selectOneChoice4 = selectOneChoice4;
    }

    public RichSelectOneChoice getSelectOneChoice4() {
        return selectOneChoice4;
    }

    public void setSelectItems4(UISelectItems selectItems4) {
        this.selectItems4 = selectItems4;
    }

    public UISelectItems getSelectItems4() {
        return selectItems4;
    }

    public void setInputText3(RichInputText inputText3) {
        this.inputText3 = inputText3;
    }

    public RichInputText getInputText3() {
        return inputText3;
    }

    public void setInputText4(RichInputText inputText4) {
        this.inputText4 = inputText4;
    }

    public RichInputText getInputText4() {
        return inputText4;
    }

    public void setInputDate3(RichInputDate inputDate3) {
        this.inputDate3 = inputDate3;
    }

    public RichInputDate getInputDate3() {
        return inputDate3;
    }

    public void setInputText5(RichInputText inputText5) {
        this.inputText5 = inputText5;
    }

    public RichInputText getInputText5() {
        return inputText5;
    }

    public void setPanelFormLayout5(RichPanelFormLayout panelFormLayout5) {
        this.panelFormLayout5 = panelFormLayout5;
    }

    public RichPanelFormLayout getPanelFormLayout5() {
        return panelFormLayout5;
    }

    public void setPanelGroupLayout1(RichPanelGroupLayout panelGroupLayout1) {
        this.panelGroupLayout1 = panelGroupLayout1;
    }

    public RichPanelGroupLayout getPanelGroupLayout1() {
        return panelGroupLayout1;
    }

    public void setCommandButton1(RichCommandButton commandButton1) {
        this.commandButton1 = commandButton1;
    }

    public RichCommandButton getCommandButton1() {
        return commandButton1;
    }

    public void setCommandButton2(RichCommandButton commandButton2) {
        this.commandButton2 = commandButton2;
    }

    public RichCommandButton getCommandButton2() {
        return commandButton2;
    }

    public void setSelectOneChoice5(RichSelectOneChoice selectOneChoice5) {
        this.selectOneChoice5 = selectOneChoice5;
    }

    public RichSelectOneChoice getSelectOneChoice5() {
        return selectOneChoice5;
    }

    public void setSelectItems5(UISelectItems selectItems5) {
        this.selectItems5 = selectItems5;
    }

    public UISelectItems getSelectItems5() {
        return selectItems5;
    }

    public void setSelectOneChoice6(RichSelectOneChoice selectOneChoice6) {
        this.selectOneChoice6 = selectOneChoice6;
    }

    public RichSelectOneChoice getSelectOneChoice6() {
        return selectOneChoice6;
    }

    public void setSelectItems6(UISelectItems selectItems6) {
        this.selectItems6 = selectItems6;
    }

    public UISelectItems getSelectItems6() {
        return selectItems6;
    }


    public void setPfl10(RichPanelFormLayout pfl10) {
        this.pfl10 = pfl10;
    }

    public RichPanelFormLayout getPfl10() {
        return pfl10;
    }

    public void setCb6(RichCommandButton cb6) {
        this.cb6 = cb6;
    }

    public RichCommandButton getCb6() {
        return cb6;
    }

    public void setLicenseEditPanel(RichPanelGroupLayout pgl2) {
        this.licenseEditPanel = pgl2;
    }

    public RichPanelGroupLayout getLicenseEditPanel() {
        return licenseEditPanel;
    }


    public void setCb7(RichCommandButton cb7) {
        this.cb7 = cb7;
    }

    public RichCommandButton getCb7() {
        return cb7;
    }

    public void setPgl2(RichPanelGroupLayout pgl2) {
        this.pgl2 = pgl2;
    }

    public RichPanelGroupLayout getPgl2() {
        return pgl2;
    }

    public void setPgl3(RichPanelGroupLayout pgl3) {
        this.pgl3 = pgl3;
    }

    public RichPanelGroupLayout getPgl3() {
        return pgl3;
    }

    public void setCb8(RichCommandButton cb8) {
        this.cb8 = cb8;
    }

    public RichCommandButton getCb8() {
        return cb8;
    }

    public void setCb9(RichCommandButton cb9) {
        this.cb9 = cb9;
    }

    public RichCommandButton getCb9() {
        return cb9;
    }

    public void setCbRollback(RichCommandButton cb10) {
        this.cbRollback = cb10;
    }

    public RichCommandButton getCbRollback() {
        return cbRollback;
    }

    public void setCb5(RichCommandButton cb5) {
        this.cb5 = cb5;
    }

    public RichCommandButton getCb5() {
        return cb5;
    }

    public void setCb10(RichCommandButton cb10) {
        this.cb10 = cb10;
    }

    public RichCommandButton getCb10() {
        return cb10;
    }

    public void setT3(RichToolbar t3) {
        this.t3 = t3;
    }

    public RichToolbar getT3() {
        return t3;
    }

    public void setSor1(RichSelectOneRadio sor1) {
        this.sor1 = sor1;
    }

    public RichSelectOneRadio getSor1() {
        return sor1;
    }


    public void setSi12(RichSelectItem si12) {
        this.si12 = si12;
    }

    public RichSelectItem getSi12() {
        return si12;
    }

    public void setSi13(RichSelectItem si13) {
        this.si13 = si13;
    }

    public RichSelectItem getSi13() {
        return si13;
    }

    public void setRadioText(RichInputText radioText) {
        this.radioText = radioText;
    }

    public RichInputText getRadioText() {
        return radioText;
    }


    public void setCb2(RichCommandButton cb2) {
        this.cb2 = cb2;
    }

    public RichCommandButton getCb2() {
        return cb2;
    }


    public void setGb1(RichGoButton gb1) {
        this.gb1 = gb1;
    }

    public RichGoButton getGb1() {
        return gb1;
    }

    public void setPt2(RichPanelTabbed pt2) {
        this.pt2 = pt2;
    }

    public RichPanelTabbed getPt2() {
        return pt2;
    }

    public void setSdi1(RichShowDetailItem sdi1) {
        this.sdi1 = sdi1;
    }

    public RichShowDetailItem getSdi1() {
        return sdi1;
    }

    public void setPc2(RichPanelCollection pc2) {
        this.pc2 = pc2;
    }

    public RichPanelCollection getPc2() {
        return pc2;
    }

    public void setT4(RichTable t4) {
        this.t4 = t4;
    }

    public RichTable getT4() {
        return t4;
    }

    public void setId6(RichInputDate id6) {
        this.id6 = id6;
    }

    public RichInputDate getId6() {
        return id6;
    }

    public void setId7(RichInputDate id7) {
        this.id7 = id7;
    }

    public RichInputDate getId7() {
        return id7;
    }

    public void setPt3(RichPanelTabbed pt3) {
        this.pt3 = pt3;
    }

    public RichPanelTabbed getPt3() {
        return pt3;
    }

    public void setSdi2(RichShowDetailItem sdi2) {
        this.sdi2 = sdi2;
    }

    public RichShowDetailItem getSdi2() {
        return sdi2;
    }

    public void setPc3(RichPanelCollection pc3) {
        this.pc3 = pc3;
    }

    public RichPanelCollection getPc3() {
        return pc3;
    }

    public void setT5(RichTable t5) {
        this.t5 = t5;
    }

    public RichTable getT5() {
        return t5;
    }

    public void setT6(RichToolbar t6) {
        this.t6 = t6;
    }

    public RichToolbar getT6() {
        return t6;
    }

    public void setCb11(RichCommandButton cb11) {
        this.cb11 = cb11;
    }

    public RichCommandButton getCb11() {
        return cb11;
    }

    public void setT7(RichToolbar t7) {
        this.t7 = t7;
    }

    public RichToolbar getT7() {
        return t7;
    }

    public void setCb12(RichCommandButton cb12) {
        this.cb12 = cb12;
    }

    public RichCommandButton getCb12() {
        return cb12;
    }
}
