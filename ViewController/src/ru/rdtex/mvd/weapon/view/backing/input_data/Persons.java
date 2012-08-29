package ru.rdtex.mvd.weapon.view.backing.input_data;

import javax.annotation.PostConstruct;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.component.rich.RichForm;
import oracle.adf.view.rich.component.rich.RichMenu;
import oracle.adf.view.rich.component.rich.RichMenuBar;
import oracle.adf.view.rich.component.rich.RichPanelWindow;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.RichQuery;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelHeader;
import oracle.adf.view.rich.component.rich.layout.RichPanelStretchLayout;
import oracle.adf.view.rich.component.rich.layout.RichToolbar;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.nav.RichCommandMenuItem;
import oracle.adf.view.rich.component.rich.nav.RichCommandNavigationItem;
import oracle.adf.view.rich.component.rich.nav.RichNavigationPane;
import oracle.adf.view.rich.component.rich.output.RichMessages;
import oracle.adf.view.rich.component.rich.output.RichPanelCollection;
import oracle.adf.view.rich.component.rich.output.RichSeparator;
import oracle.adf.view.rich.render.ClientEvent;

import oracle.javatools.parser.java.v2.classfile.Convert;

import oracle.jbo.RowSet;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
import oracle.jbo.server.DBTransaction;

import ru.rdtex.global.ADFUtils;
import ru.rdtex.mvd.weapon.global.JSFUtils;
import ru.rdtex.mvd.weapon.model.am.AppModuleImpl;
import ru.rdtex.mvd.weapon.model.vo.EntPersonsViewImpl;
import ru.rdtex.mvd.weapon.model.vo.EntPersonsViewRowImpl;
import ru.rdtex.mvd.weapon.view.backing.Main;
import ru.rdtex.mvd.weapon.view.session.MySesBean;
import ru.rdtex.mvd.weapon.view.session.mysession;
import ru.rdtex.mvd.weapon.view.utils.DatabaseProcedure;
import ru.rdtex.mvd.weapon.view.utils.PageUtil;


public class Persons {
    private RichPanelStretchLayout psl1;
    private RichForm f1;
    private RichDocument d1;
    private RichPanelCollection pc1;
    private RichTable t1;
    private RichMessages m1;
    private RichToolbar t2;
    private RichCommandButton cb1;
    private RichCommandButton cb2;
    private RichPopup p1;
    private RichPanelWindow pw1;
    private RichPanelGroupLayout pgl1;
    private RichPanelHeader ph1;
    private RichQuery qryId1;
    private RichCommandButton cb3;
    private boolean showButton;
    private RichCommandButton cb4;
    private String myColor;
    private RichCommandButton cb5;
    private RichMenuBar mb1;
    private RichCommandMenuItem cmi1;
    private RichCommandMenuItem cmi2;
    private RichMenu m2;
    private RichCommandMenuItem cmi3;
    private RichCommandMenuItem cmi4;
    private RichPanelGroupLayout pgl2;
    private RichCommandMenuItem cmi5;
    private RichCommandMenuItem cmi6;
    private RichMenu m3;
    private RichCommandMenuItem cmi7;
    private RichCommandMenuItem cmi8;
    private RichNavigationPane np1;
    private RichCommandNavigationItem cni1;
    private RichCommandNavigationItem cni2;
    private RichSeparator s1;
    
    private Boolean fownerBoolean = false;
    
    private AppModuleImpl mod = (AppModuleImpl)ADFUtils.getBindingApplicationModule();
    private EntPersonsViewImpl vo = (EntPersonsViewImpl)mod.getEntPersonsView1();
    private RichTable table1;
    
    private Integer fstate;
    private Boolean fowner;
    private Boolean fguard;
    private Boolean femployee;
    
    @PostConstruct
    public void initBean() {
        setPersonType("Ф");
        //String personType = (String)JSFUtils.resolveExpression("#{Myses.personType}");
    }
    
    public void setPersonType(String personType) {
        JSFUtils.setManagedBeanValue("Myses.personType", personType);
        
        String personTypeToFilter = "ФЛ";
        if (personType.equals("Ю")) personTypeToFilter = "ЮЛ";
        vo.setpersonType(personTypeToFilter);
    } 
    
    public void setPsl1(RichPanelStretchLayout psl1) {
        this.psl1 = psl1;
    }

    public RichPanelStretchLayout getPsl1() {
        return psl1;
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


    public void setM1(RichMessages m1) {
        this.m1 = m1;
    }

    public RichMessages getM1() {
        return m1;
    }

    public void setT2(RichToolbar t2) {
        this.t2 = t2;
    }

    public RichToolbar getT2() {
        return t2;
    }

    public void setCb1(RichCommandButton cb1) {
        this.cb1 = cb1;
    }

    public RichCommandButton getCb1() {
        return cb1;
    }

    public String edit_action() {
        return Main.edit();
    }

    public void setCb2(RichCommandButton cb2) {
        this.cb2 = cb2;
    }

    public RichCommandButton getCb2() {
        return cb2;
    }

    public void setP1(RichPopup p1) {
        this.p1 = p1;
    }

    public RichPopup getP1() {
        return p1;
    }

    public void setPw1(RichPanelWindow pw1) {
        this.pw1 = pw1;
    }

    public RichPanelWindow getPw1() {
        return pw1;
    }

    public void setPgl1(RichPanelGroupLayout pgl1) {
        this.pgl1 = pgl1;
    }

    public RichPanelGroupLayout getPgl1() {
        return pgl1;
    }

    public void setPh1(RichPanelHeader ph1) {
        this.ph1 = ph1;
    }

    public RichPanelHeader getPh1() {
        return ph1;
    }

    public void setQryId1(RichQuery qryId1) {
        this.qryId1 = qryId1;
    }

    public RichQuery getQryId1() {
        return qryId1;
    }

    public String testProc() {
        AppModuleImpl am1 =

            (AppModuleImpl)PageUtil.getApplicationModule("AppModuleDataControl");
        DBTransaction connection = am1.getDBTransaction();

        DatabaseProcedure CHECK_VOTE =
            DatabaseProcedure.define("function text_out(  IN_TEXT IN VARCHAR2 ) return varchar2");

        String result =
            CHECK_VOTE.call(connection, "PROVERKA").getReturnValue().toString();
        PageUtil.message("HELLOO " + result, "", "INFO");
        return null;

    }

    public void setCb3(RichCommandButton cb3) {
        this.cb3 = cb3;
    }

    public RichCommandButton getCb3() {
        return cb3;
    }

    public void setShowButton(boolean showButton) {
        this.showButton = showButton;
    }

    public boolean isShowButton() {
        AppModuleImpl am1 =

            (AppModuleImpl)PageUtil.getApplicationModule("AppModuleDataControl");
        DBTransaction connection = am1.getDBTransaction();

        DatabaseProcedure CHECK_VOTE =
            DatabaseProcedure.define("function text_out(  IN_TEXT IN VARCHAR2 ) return varchar2");

        String result =
            CHECK_VOTE.call(connection, "PROVERKA").getReturnValue().toString();
        if (result.equals("1")) {

            return true;

        } else {
            return false;
        }

    }

    public void setCb4(RichCommandButton cb4) {
        this.cb4 = cb4;
    }

    public RichCommandButton getCb4() {
        return cb4;
    }

    public String test_action() {
        PageUtil.setExpression("#{sessionScope.Myses.myParams}",
                               "TRRR XZJKDNKSAN JKNFSKA KFN SFSA  ");
        return null;
    }

    public void setMyColor(String myColor) {
        this.myColor = myColor;
    }

    public String getMyColor() {
        Number nn = (Number)PageUtil.resolveExpression("#{row.Id}");
        String color = "color:red;";
        if (nn.equals(new Number(11545))) {
            System.out.println("HELLLO");
            color = "color:blue;font-weight:bold;";
        }

        return color;
    }

    public void setCb5(RichCommandButton cb5) {
        this.cb5 = cb5;
    }

    public RichCommandButton getCb5() {
        return cb5;
    }

    public void setMb1(RichMenuBar mb1) {
        this.mb1 = mb1;
    }

    public RichMenuBar getMb1() {
        return mb1;
    }

    public void setCmi1(RichCommandMenuItem cmi1) {
        this.cmi1 = cmi1;
    }

    public RichCommandMenuItem getCmi1() {
        return cmi1;
    }

    public void setCmi2(RichCommandMenuItem cmi2) {
        this.cmi2 = cmi2;
    }

    public RichCommandMenuItem getCmi2() {
        return cmi2;
    }

    public void setM2(RichMenu m2) {
        this.m2 = m2;
    }

    public RichMenu getM2() {
        return m2;
    }

    public void setCmi3(RichCommandMenuItem cmi3) {
        this.cmi3 = cmi3;
    }

    public RichCommandMenuItem getCmi3() {
        return cmi3;
    }

    public void setCmi4(RichCommandMenuItem cmi4) {
        this.cmi4 = cmi4;
    }

    public RichCommandMenuItem getCmi4() {
        return cmi4;
    }

    public void setPgl2(RichPanelGroupLayout pgl2) {
        this.pgl2 = pgl2;
    }

    public RichPanelGroupLayout getPgl2() {
        return pgl2;
    }

    public void setCmi5(RichCommandMenuItem cmi5) {
        this.cmi5 = cmi5;
    }

    public RichCommandMenuItem getCmi5() {
        return cmi5;
    }

    public void setCmi6(RichCommandMenuItem cmi6) {
        this.cmi6 = cmi6;
    }

    public RichCommandMenuItem getCmi6() {
        return cmi6;
    }

    public void setM3(RichMenu m3) {
        this.m3 = m3;
    }

    public RichMenu getM3() {
        return m3;
    }

    public void setCmi7(RichCommandMenuItem cmi7) {
        this.cmi7 = cmi7;
    }

    public RichCommandMenuItem getCmi7() {
        return cmi7;
    }

    public void setCmi8(RichCommandMenuItem cmi8) {
        this.cmi8 = cmi8;
    }

    public RichCommandMenuItem getCmi8() {
        return cmi8;
    }

    public void setNp1(RichNavigationPane np1) {
        this.np1 = np1;
    }

    public RichNavigationPane getNp1() {
        return np1;
    }

    public void setCni1(RichCommandNavigationItem cni1) {
        this.cni1 = cni1;
    }

    public RichCommandNavigationItem getCni1() {
        return cni1;
    }

    public void setCni2(RichCommandNavigationItem cni2) {
        this.cni2 = cni2;
    }

    public RichCommandNavigationItem getCni2() {
        return cni2;
    }

    public String ur_action() {
        // Add event code here...
        return null;
    }

    public void setS1(RichSeparator s1) {
        this.s1 = s1;
    }

    public RichSeparator getS1() {
        return s1;
    }

    

    public void setFownerBoolean(Boolean fownerBoolean) {
        this.fownerBoolean = fownerBoolean;
        //set fowner
        //System.out.println("@fownerBoolean = "+fownerBoolean);
//        AppModuleImpl mod = (AppModuleImpl)ADFUtils.getBindingApplicationModule();
//        EntPersonsViewImpl vo = (EntPersonsViewImpl)mod.getEntPersonsView1();
//        if (fownerBoolean != null && fownerBoolean) {
//            vo.setfowner("Y"); 
//            //System.out.println("set Y");
//        }
//        else {
//            vo.setfowner("N");    
//            //System.out.println("set N");
//        }
//        vo.executeQuery();
//        vo.first();
    }

    public Boolean getFownerBoolean() {
        return fownerBoolean;
    }

//    public void fownerListener(ValueChangeEvent valueChangeEvent) {
//        System.out.println("@value = "+valueChangeEvent.getNewValue());
//    }

    public void myCustomChangeCheckListener(ClientEvent event) {
        Boolean value = (Boolean)event.getParameters().get("value");
        String id = (String)event.getParameters().get("id");
        AppModuleImpl mod =
            (AppModuleImpl)ADFUtils.getBindingApplicationModule();
        EntPersonsViewImpl vo = (EntPersonsViewImpl)mod.getEntPersonsView1();
        System.out.println("@id = "+id);
        System.out.println("@value = "+value);
        if (value != null && value) {
            if (id.equals("fowner")) vo.setfowner("Y");
            else if (id.equals("fguard")) vo.setfguard("Y");
            else if (id.equals("femployee")) vo.setfemployee("Y");
        } else {
            if (id.equals("fowner")) vo.setfowner("N");
            else if (id.equals("fguard")) vo.setfguard("N");
            else if (id.equals("femployee")) vo.setfemployee("N");
        }
        vo.executeQuery();
        vo.first();
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
        vo.setfstate(0);
        if (value != null) {
            Integer val = new Integer(value); 
            if (id.equals("fstate")) vo.setfstate(val);
        } 
        vo.executeQuery();
        vo.first();
    }

    public String clearFindForm() {
        // Add event code here...
        //JSFUtils.setExpressionValue("#{bindings.fid.inputValue}", "");
        //oracle.adfinternal.view.faces.model.binding.FacesCtrlAttrsBinding obj = (FacesCtrlAttrsBinding)JSFUtils.resolveExpression("#{bindings.fid}");
        //System.out.println("@obj = "+obj.getClass().getName());
        //obj.setInputValue("");
        // setInputValue
        
        //ADFUtils.adfBindingActionListener(action, actionEvent);
//        AppModuleImpl mod = (AppModuleImpl)ADFUtils.getBindingApplicationModule();
//        EntPersonsViewImpl vo = (EntPersonsViewImpl)mod.getEntPersonsView1();
//        vo.setfid(null);
        JSFUtils.setExpressionValue("#{bindings.fid.inputValue}", "");
        Object newVal = JSFUtils.resolveExpression("#{bindings.fid.inputValue}");
        System.out.println(newVal);
        
        return null;
    }

    public void toggleAllCheckBox(ValueChangeEvent valueChangeEvent) {
        Boolean newVal = (Boolean)valueChangeEvent.getNewValue();
        if (newVal != null && newVal.equals(false))
            newVal = null;

        RowSet rowSet = vo.getRowSet();
        //Integer countViewRow = table1.getRows();
        //System.out.println("@countViewRow=" + countViewRow);
        EntPersonsViewRowImpl first = (EntPersonsViewRowImpl)rowSet.first();
        //System.out.println("@first=" + first);
        if (first != null) {
            first.setDeleteRow(newVal);
            int i = 0;

            while (rowSet.hasNext()) {
                try {
                    EntPersonsViewRowImpl item =
                        (EntPersonsViewRowImpl)rowSet.next();
                    item.setDeleteRow(newVal);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                i++;
                if (i > 50) {
                    break;
                }
            }
        }
    }
        
//    public void selectAll_action(ValueChangeEvent valueChangeEvent) {        
//        Boolean newVal = (Boolean)valueChangeEvent.getNewValue();
//        if (newVal != null && newVal.equals(false)) {
//           newVal = null;
//        }
//        DCBindingContainer bindings = ADFUtils.getBindingContainer();
//        DCIteratorBinding iter = bindings.findIteratorBinding("EntPersonsView1Iterator");
//        Row[] rows = iter.getAllRowsInRange();
//        for (Row item : rows) {
//            EntPersonsViewRowImpl row = (EntPersonsViewRowImpl)item;    
//            row.setDeleteRow(newVal);
//        }
//    }

//    public void selectAll_action(ValueChangeEvent valueChangeEvent) {        
//        Boolean newVal = (Boolean)valueChangeEvent.getNewValue();
//        DCBindingContainer bindings = (DCBindingContainer)getBindings();
//        DCIteratorBinding iter =  (DCIteratorBinding)bindings.findIteratorBinding("EntPersonsView1Iterator");
//
//        System.out.println("rowCount = " + iter.getViewObject().getEstimatedRowCount());
////        for (int i = 0; i < iter.getViewObject().getEstimatedRowCount(); i++) {
//        //for (int i = 0; i < 24; i++) {
//        
//        //for (int i = 0; i < vo.getRowCount(); i++) {    
//        System.out.println("*** 1"); 
//        
//        System.out.println(table1.getRowCount()); // 29750
//        System.out.println(table1.getRows()); // 50
//        System.out.println(table1.getEstimatedRowCount()); // 29750
//        System.out.println(table1.getDisplayRow()); // first
//        System.out.println(table1.getFetchSize()); // 25
//        System.out.println(table1.getRowData()); // null
//        System.out.println(table1.getRowIndex()); // -1
//        System.out.println(table1.getRowKey()); // null
//        System.out.println(table1.getRowBandingInterval()); // 0
//        System.out.println(table1.getSelectedRowData());
//        System.out.println("*** 9");
//        if (newVal != null && newVal.equals(false)) {
//            newVal = null;
//        }
//        
//        vo.
//        
//        for (int i = 0; i < table1.getRows() - 1; i++) {
//            try {
//                EntPersonsViewRowImpl row = (EntPersonsViewRowImpl)iter.getRowAtRangeIndex(i);
//                iter.getRow
//                row.setDeleteRow(newVal);
//            }
//            catch(Exception ex) {
//                ex.printStackTrace();
//            }
//            //Row row = iter.getRowAtRangeIndex(i);
//            //row.setDeleteRow(newVal);
//            //System.out.println(row.getDeleteRow());
//            //row.setAttribute("DeleteRow", newVal);
////                   System.out.println("i=" + i + " " +
////                               row.getAttribute(0));
//
//              //System.out.println("i=" + i + " " + row.getAttribute("DeleteRow"));
//            //JSFUtils.setExpressionValue("#{row.bindings.DeleteRow.inputValue}", newVal);
//            //System.out.println(JSFUtils.resolveExpression("#{row.bindings.DeleteRow.inputValue}"));
//        }
//
//    }


    public void setTable1(RichTable table1) {
        this.table1 = table1;
    }

    public RichTable getTable1() {
        return table1;
    }


    public void setFstate(Integer fstate) {
        
    }

    public Integer getFstate() {
        Integer fstate = vo.getfstate();
        return (fstate == null ? 0 : fstate);
    }

    public void setFowner(Boolean fowner) {

    }

    public Boolean getFowner() {
        String fowner = vo.getfowner();
        if (fowner != null && fowner.equals("Y")) return true;
        return null;
    }

    public void setFguard(Boolean fguard) {

    }

    public Boolean getFguard() {
        String fguard = vo.getfguard();
        if (fguard != null && fguard.equals("Y")) return true;
        return null;
    }

    public void setFemployee(Boolean femployee) {

    }

    public Boolean getFemployee() {
        String femployee = vo.getfemployee();
        if (femployee != null && femployee.equals("Y")) return true;
        return null;
    }

}
