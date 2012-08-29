package ru.rdtex.mvd.weapon.view.backing.input_data;


import java.util.ArrayList;

import java.util.HashMap;

import java.util.Map;

import javax.annotation.PostConstruct;

import javax.faces.component.UISelectItems;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;
import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.component.rich.RichForm;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputFile;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;
import oracle.adf.view.rich.component.rich.input.RichSelectItem;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichDecorativeBox;
import oracle.adf.view.rich.component.rich.layout.RichPanelBox;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelStretchLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelTabbed;
import oracle.adf.view.rich.component.rich.layout.RichShowDetailItem;
import oracle.adf.view.rich.component.rich.layout.RichToolbar;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.nav.RichGoButton;
import oracle.adf.view.rich.component.rich.output.RichImage;
import oracle.adf.view.rich.component.rich.output.RichMessages;


import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.RowIterator;
import oracle.jbo.RowSet;

import oracle.jbo.Transaction;
import oracle.jbo.client.Configuration;
import oracle.jbo.domain.Number;
import oracle.jbo.server.DBTransaction;
import oracle.jbo.server.ViewObjectImpl;
import oracle.jbo.server.ViewRowImpl;

import org.apache.myfaces.trinidad.component.UIXGroup;

import ru.rdtex.global.ADFUtils;
import ru.rdtex.mvd.weapon.global.JSFUtils;
import ru.rdtex.mvd.weapon.model.am.AppModuleImpl;
import ru.rdtex.mvd.weapon.model.am.common.AppModule;
import ru.rdtex.mvd.weapon.model.vo.EntPersonsViewImpl;
import ru.rdtex.mvd.weapon.model.vo.EntPersonsViewRowImpl;
import ru.rdtex.mvd.weapon.model.vo.read.REntPersonsViewImpl;
import ru.rdtex.mvd.weapon.view.backing.Main;
import ru.rdtex.mvd.weapon.view.word.WordData;

public class Edit_person {
    private RichPanelStretchLayout psl1;
    private RichForm f1;
    private RichDocument d1;
    private RichPanelBox pb1;
    private RichPanelFormLayout pfl1;
    private RichPanelTabbed pt1;
    private RichShowDetailItem sdi1;
    private RichShowDetailItem sdi2;
    private RichShowDetailItem sdi3;
    private RichShowDetailItem sdi4;
    private RichInputText it1;
    private RichMessages m1;
    private RichInputText it3;
    private RichInputText it4;
    private RichInputText it5;
    private RichSelectOneChoice soc1;
    private RichSelectItem si1;
    private RichSelectItem si2;
    private RichInputText it6;
    private RichSelectBooleanCheckbox sbc1;
    private RichPanelFormLayout pfl2;
    private RichInputDate id2;
    private RichInputText it7;
    private RichInputText it8;
    private RichInputText it9;
    private RichSelectOneChoice soc2;
    private UISelectItems si3;
    private RichPanelFormLayout pfl3;
    private RichInputText it10;
    private RichInputText it11;
    private RichInputText it12;
    private RichInputText it13;
    private RichInputText it14;
    private RichSelectOneChoice soc3;
    private UISelectItems si4;
    private RichPanelFormLayout pfl4;
    private RichToolbar t1;
    private RichCommandButton cb1;
    private RichCommandButton cb2;
    private UIXGroup g1;
    private RichPanelGroupLayout pgl1;
    private UIXGroup g2;
    private RichToolbar t2;
    private RichPanelFormLayout pfl5;
    private RichInputText it15;
    private RichInputText it16;
    private RichInputText it17;
    private RichInputText it18;
    private RichSelectOneChoice soc4;
    private RichSelectItem si5;
    private RichSelectItem si6;
    private RichInputText it19;
    private RichInputDate id3;
    private RichSelectBooleanCheckbox sbc2;
    private RichPanelTabbed pt2;
    private RichShowDetailItem sdi5;
    private RichPanelFormLayout pfl6;
    private RichSelectOneChoice soc5;
    private UISelectItems si7;
    private RichInputText it20;
    private RichInputText it21;
    private RichInputDate id4;
    private RichInputText it22;
    private RichShowDetailItem sdi6;
    private RichPanelFormLayout pfl7;
    private RichInputText it23;
    private RichShowDetailItem sdi7;
    private RichPanelFormLayout pfl8;
    private RichInputText it24;
    private RichInputText it25;
    private RichInputText it26;
    private RichSelectOneChoice soc6;
    private UISelectItems si8;
    private RichInputText it27;
    private RichShowDetailItem sdi8;
    private RichInputText it28;
    private RichPanelGroupLayout pgl2;
    private RichCommandButton cb3;
    private RichCommandButton cb4;
    private RichCommandButton cb5;
    private RichCommandButton cb7;
    private RichCommandButton cb8;
    private RichCommandButton cb9;
    private RichGoButton gb1;
    private RichInputDate id1;
    private RichInputFile if1;
    private RichInputText it2;
    private RichImage i1;
    private RichCommandButton cb6;
    private RichDecorativeBox db1;
    private RichPanelGroupLayout pgl3;
    private RichCommandButton cb10;
    private RichPanelGroupLayout pgl4;
    
    public String goWeapon() {
        //HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = JSFUtils.getSession();
        session.setAttribute("docId", null);
        return "weapon";
    }
    
    @PostConstruct
    public void initBean() {
        //?fileName=#{mysession.encodeRusText['КАРТОЧКА_ФЛ']}
        
        WordData wordData = new WordData("КАРТОЧКА_ФЛ");
        Row personRow = wordData.addRow("EntPersonsView1");
        wordData.addRowRead("EntPersonsView1", "REntPersonsView1", personRow.getKey());
                
        wordData.addColumn("EntPersonsView1", "Id");
        wordData.addColumn("EntPersonsView1", "TitleSurname");
        wordData.addColumn("EntPersonsView1", "Name");
        wordData.addColumn("EntPersonsView1", "Otchestvo");
        wordData.addColumn("EntPersonsView1", "Birthday");
        wordData.addColumn("EntPersonsView1", "BirthAdr");
        wordData.addColumn("EntPersonsView1", "DocSer");
        wordData.addColumn("EntPersonsView1", "DocNum");
        wordData.addColumn("EntPersonsView1", "DocOrg");
        wordData.addColumn("EntPersonsView1", "DocDate");
        //из таблице адресов
        wordData.addColumn("EntPersonsView1", "AddrPhone");
        wordData.addColumn("EntPersonsView1", "AddrStrAdrs");
        wordData.addColumn("EntPersonsView1", "AddrPolice");
        //пользователь который последним менял запись
        wordData.addColumn("EntPersonsView1", "UserName");
        wordData.addColumn("EntPersonsView1", "ChangeDate");
        wordData.addColumn("EntPersonsView1", "Photo");
         
        wordData.addIterator("EntPersonsView1", "RPersonGunsView");
        wordData.addColumn(new String[]{"EntPersonsView1"}, "RPersonGunsView", "StateName");
        wordData.addColumn(new String[]{"EntPersonsView1"}, "RPersonGunsView", "TypeTitle");
        wordData.addColumn(new String[]{"EntPersonsView1"}, "RPersonGunsView", "KindTitle");
        wordData.addColumn(new String[]{"EntPersonsView1"}, "RPersonGunsView", "ModelTitle");
        wordData.addColumn(new String[]{"EntPersonsView1"}, "RPersonGunsView", "Series");
        wordData.addColumn(new String[]{"EntPersonsView1"}, "RPersonGunsView", "Numb");    
        wordData.addColumn(new String[]{"EntPersonsView1"}, "RPersonGunsView", "MakeYear");  
//        System.out.println(wordData.getColumns(new String[]{"EntPersonsView1"}, "RPersonGunsView")); 
        
        wordData.addIterator(new String[]{"EntPersonsView1"}, "RPersonGunsView", "RGunDocumentsView");
        wordData.addColumn(new String[]{"EntPersonsView1", "RPersonGunsView"}, "RGunDocumentsView", "LicstatCode");
        wordData.addColumn(new String[]{"EntPersonsView1", "RPersonGunsView"}, "RGunDocumentsView", "DocName");
        wordData.addColumn(new String[]{"EntPersonsView1", "RPersonGunsView"}, "RGunDocumentsView", "DocSeries");
        wordData.addColumn(new String[]{"EntPersonsView1", "RPersonGunsView"}, "RGunDocumentsView", "DocNumb");
        wordData.addColumn(new String[]{"EntPersonsView1", "RPersonGunsView"}, "RGunDocumentsView", "DocDate"); 
        wordData.addColumn(new String[]{"EntPersonsView1", "RPersonGunsView"}, "RGunDocumentsView", "EndDate");
//        System.out.println(wordData.getColumns(new String[]{"EntPersonsView1", "RPersonGunsView"}, "RGunDocumentsView")); 
        System.out.println("КАРТОЧКА_ФЛ = "+wordData.toString());        
        
        //передаем все параметры в сессию
        HttpSession session = JSFUtils.getSession(); 
        session.setAttribute("WORD_DATA", wordData);
        
        //запоминаем в сессию параметр personId
        AppModuleImpl mod = (AppModuleImpl)ADFUtils.getBindingApplicationModule();
        ViewObjectImpl vo = (ViewObjectImpl)mod.findViewObject("EntPersonsView1");
        ViewRowImpl row = (ViewRowImpl)vo.getCurrentRow();
        JSFUtils.setManagedBeanValue("Myses.personId", row.getAttribute("Id"));
    }
    
    public String save_action() {
        return Main.save_action();
    }

    public String cancel_action() {
        return Main.cancel_action();
    }
    
    public String toggle_state() {
        AppModuleImpl mod = (AppModuleImpl)ADFUtils.getBindingApplicationModule();
        EntPersonsViewImpl vo = (EntPersonsViewImpl)mod.getEntPersonsView1();
        EntPersonsViewRowImpl row = (EntPersonsViewRowImpl)vo.getCurrentRow();
        oracle.jbo.domain.Number state = row.getState();
        
        if (state.equals("2")) row.setState(new Number(0));
        else row.setState(new Number(2));
        String move = save_action();
        //vo.refreshCollection(new Row[]{row}, true, true);
        vo.executeQuery();
        //DBTransaction tran = (DBTransaction)mod.getTransaction();
        //System.out.println("@@ Locking = "+tran.getLockingMode());
        //tran.commit();
        //vo.clearCache();
        return move;
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

    public void setPb1(RichPanelBox pb1) {
        this.pb1 = pb1;
    }

    public RichPanelBox getPb1() {
        return pb1;
    }

    public void setPfl1(RichPanelFormLayout pfl1) {
        this.pfl1 = pfl1;
    }

    public RichPanelFormLayout getPfl1() {
        return pfl1;
    }

    public void setPt1(RichPanelTabbed pt1) {
        this.pt1 = pt1;
    }

    public RichPanelTabbed getPt1() {
        return pt1;
    }

    public void setSdi1(RichShowDetailItem sdi1) {
        this.sdi1 = sdi1;
    }

    public RichShowDetailItem getSdi1() {
        return sdi1;
    }

    public void setSdi2(RichShowDetailItem sdi2) {
        this.sdi2 = sdi2;
    }

    public RichShowDetailItem getSdi2() {
        return sdi2;
    }

    public void setSdi3(RichShowDetailItem sdi3) {
        this.sdi3 = sdi3;
    }

    public RichShowDetailItem getSdi3() {
        return sdi3;
    }

    public void setSdi4(RichShowDetailItem sdi4) {
        this.sdi4 = sdi4;
    }

    public RichShowDetailItem getSdi4() {
        return sdi4;
    }

    public void setIt1(RichInputText it1) {
        this.it1 = it1;
    }

    public RichInputText getIt1() {
        return it1;
    }

    public void setM1(RichMessages m1) {
        this.m1 = m1;
    }

    public RichMessages getM1() {
        return m1;
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

    public void setIt5(RichInputText it5) {
        this.it5 = it5;
    }

    public RichInputText getIt5() {
        return it5;
    }

    public void setSoc1(RichSelectOneChoice soc1) {
        this.soc1 = soc1;
    }

    public RichSelectOneChoice getSoc1() {
        return soc1;
    }


    public void setSi1(RichSelectItem si1) {
        this.si1 = si1;
    }

    public RichSelectItem getSi1() {
        return si1;
    }

    public void setSi2(RichSelectItem si2) {
        this.si2 = si2;
    }

    public RichSelectItem getSi2() {
        return si2;
    }

    public void setIt6(RichInputText it6) {
        this.it6 = it6;
    }

    public RichInputText getIt6() {
        return it6;
    }


    public void setSbc1(RichSelectBooleanCheckbox sbc1) {
        this.sbc1 = sbc1;
    }

    public RichSelectBooleanCheckbox getSbc1() {
        return sbc1;
    }

    public void setPfl2(RichPanelFormLayout pfl2) {
        this.pfl2 = pfl2;
    }

    public RichPanelFormLayout getPfl2() {
        return pfl2;
    }

    public void setId2(RichInputDate id2) {
        this.id2 = id2;
    }

    public RichInputDate getId2() {
        return id2;
    }

    public void setIt7(RichInputText it7) {
        this.it7 = it7;
    }

    public RichInputText getIt7() {
        return it7;
    }

    public void setIt8(RichInputText it8) {
        this.it8 = it8;
    }

    public RichInputText getIt8() {
        return it8;
    }

    public void setIt9(RichInputText it9) {
        this.it9 = it9;
    }

    public RichInputText getIt9() {
        return it9;
    }

    public void setSoc2(RichSelectOneChoice soc2) {
        this.soc2 = soc2;
    }

    public RichSelectOneChoice getSoc2() {
        return soc2;
    }

    public void setSi3(UISelectItems si3) {
        this.si3 = si3;
    }

    public UISelectItems getSi3() {
        return si3;
    }

    public void setPfl3(RichPanelFormLayout pfl3) {
        this.pfl3 = pfl3;
    }

    public RichPanelFormLayout getPfl3() {
        return pfl3;
    }

    public void setIt10(RichInputText it10) {
        this.it10 = it10;
    }

    public RichInputText getIt10() {
        return it10;
    }


    public void setIt11(RichInputText it11) {
        this.it11 = it11;
    }

    public RichInputText getIt11() {
        return it11;
    }

    public void setIt12(RichInputText it12) {
        this.it12 = it12;
    }

    public RichInputText getIt12() {
        return it12;
    }

    public void setIt13(RichInputText it13) {
        this.it13 = it13;
    }

    public RichInputText getIt13() {
        return it13;
    }

    public void setIt14(RichInputText it14) {
        this.it14 = it14;
    }

    public RichInputText getIt14() {
        return it14;
    }

    public void setSoc3(RichSelectOneChoice soc3) {
        this.soc3 = soc3;
    }

    public RichSelectOneChoice getSoc3() {
        return soc3;
    }

    public void setSi4(UISelectItems si4) {
        this.si4 = si4;
    }

    public UISelectItems getSi4() {
        return si4;
    }

    public void setPfl4(RichPanelFormLayout pfl4) {
        this.pfl4 = pfl4;
    }

    public RichPanelFormLayout getPfl4() {
        return pfl4;
    }

    public void setT1(RichToolbar t1) {
        this.t1 = t1;
    }

    public RichToolbar getT1() {
        return t1;
    }

    public void setCb1(RichCommandButton cb1) {
        this.cb1 = cb1;
    }

    public RichCommandButton getCb1() {
        return cb1;
    }

    public void setCb2(RichCommandButton cb2) {
        this.cb2 = cb2;
    }

    public RichCommandButton getCb2() {
        return cb2;
    }



    public void setG1(UIXGroup g1) {
        this.g1 = g1;
    }

    public UIXGroup getG1() {
        return g1;
    }


    public void setPgl1(RichPanelGroupLayout pgl1) {
        this.pgl1 = pgl1;
    }

    public RichPanelGroupLayout getPgl1() {
        return pgl1;
    }


    public void setG2(UIXGroup g2) {
        this.g2 = g2;
    }

    public UIXGroup getG2() {
        return g2;
    }

    public void setT2(RichToolbar t2) {
        this.t2 = t2;
    }

    public RichToolbar getT2() {
        return t2;
    }


    public void setPfl5(RichPanelFormLayout pfl5) {
        this.pfl5 = pfl5;
    }

    public RichPanelFormLayout getPfl5() {
        return pfl5;
    }

    public void setIt15(RichInputText it15) {
        this.it15 = it15;
    }

    public RichInputText getIt15() {
        return it15;
    }

    public void setIt16(RichInputText it16) {
        this.it16 = it16;
    }

    public RichInputText getIt16() {
        return it16;
    }

    public void setIt17(RichInputText it17) {
        this.it17 = it17;
    }

    public RichInputText getIt17() {
        return it17;
    }

    public void setIt18(RichInputText it18) {
        this.it18 = it18;
    }

    public RichInputText getIt18() {
        return it18;
    }

    public void setSoc4(RichSelectOneChoice soc4) {
        this.soc4 = soc4;
    }

    public RichSelectOneChoice getSoc4() {
        return soc4;
    }

    public void setSi5(RichSelectItem si5) {
        this.si5 = si5;
    }

    public RichSelectItem getSi5() {
        return si5;
    }

    public void setSi6(RichSelectItem si6) {
        this.si6 = si6;
    }

    public RichSelectItem getSi6() {
        return si6;
    }

    public void setIt19(RichInputText it19) {
        this.it19 = it19;
    }

    public RichInputText getIt19() {
        return it19;
    }

    public void setId3(RichInputDate id3) {
        this.id3 = id3;
    }

    public RichInputDate getId3() {
        return id3;
    }

    public void setSbc2(RichSelectBooleanCheckbox sbc2) {
        this.sbc2 = sbc2;
    }

    public RichSelectBooleanCheckbox getSbc2() {
        return sbc2;
    }

    public void setPt2(RichPanelTabbed pt2) {
        this.pt2 = pt2;
    }

    public RichPanelTabbed getPt2() {
        return pt2;
    }

    public void setSdi5(RichShowDetailItem sdi5) {
        this.sdi5 = sdi5;
    }

    public RichShowDetailItem getSdi5() {
        return sdi5;
    }

    public void setPfl6(RichPanelFormLayout pfl6) {
        this.pfl6 = pfl6;
    }

    public RichPanelFormLayout getPfl6() {
        return pfl6;
    }

    public void setSoc5(RichSelectOneChoice soc5) {
        this.soc5 = soc5;
    }

    public RichSelectOneChoice getSoc5() {
        return soc5;
    }

    public void setSi7(UISelectItems si7) {
        this.si7 = si7;
    }

    public UISelectItems getSi7() {
        return si7;
    }

    public void setIt20(RichInputText it20) {
        this.it20 = it20;
    }

    public RichInputText getIt20() {
        return it20;
    }

    public void setIt21(RichInputText it21) {
        this.it21 = it21;
    }

    public RichInputText getIt21() {
        return it21;
    }

    public void setId4(RichInputDate id4) {
        this.id4 = id4;
    }

    public RichInputDate getId4() {
        return id4;
    }

    public void setIt22(RichInputText it22) {
        this.it22 = it22;
    }

    public RichInputText getIt22() {
        return it22;
    }

    public void setSdi6(RichShowDetailItem sdi6) {
        this.sdi6 = sdi6;
    }

    public RichShowDetailItem getSdi6() {
        return sdi6;
    }

    public void setPfl7(RichPanelFormLayout pfl7) {
        this.pfl7 = pfl7;
    }

    public RichPanelFormLayout getPfl7() {
        return pfl7;
    }

    public void setIt23(RichInputText it23) {
        this.it23 = it23;
    }

    public RichInputText getIt23() {
        return it23;
    }

    public void setSdi7(RichShowDetailItem sdi7) {
        this.sdi7 = sdi7;
    }

    public RichShowDetailItem getSdi7() {
        return sdi7;
    }

    public void setPfl8(RichPanelFormLayout pfl8) {
        this.pfl8 = pfl8;
    }

    public RichPanelFormLayout getPfl8() {
        return pfl8;
    }

    public void setIt24(RichInputText it24) {
        this.it24 = it24;
    }

    public RichInputText getIt24() {
        return it24;
    }

    public void setIt25(RichInputText it25) {
        this.it25 = it25;
    }

    public RichInputText getIt25() {
        return it25;
    }

    public void setIt26(RichInputText it26) {
        this.it26 = it26;
    }

    public RichInputText getIt26() {
        return it26;
    }

    public void setSoc6(RichSelectOneChoice soc6) {
        this.soc6 = soc6;
    }

    public RichSelectOneChoice getSoc6() {
        return soc6;
    }

    public void setSi8(UISelectItems si8) {
        this.si8 = si8;
    }

    public UISelectItems getSi8() {
        return si8;
    }

    public void setIt27(RichInputText it27) {
        this.it27 = it27;
    }

    public RichInputText getIt27() {
        return it27;
    }

    public void setSdi8(RichShowDetailItem sdi8) {
        this.sdi8 = sdi8;
    }

    public RichShowDetailItem getSdi8() {
        return sdi8;
    }

    public void setIt28(RichInputText it28) {
        this.it28 = it28;
    }

    public RichInputText getIt28() {
        return it28;
    }


    public void setPgl2(RichPanelGroupLayout pgl2) {
        this.pgl2 = pgl2;
    }

    public RichPanelGroupLayout getPgl2() {
        return pgl2;
    }


    public void setCb3(RichCommandButton cb3) {
        this.cb3 = cb3;
    }

    public RichCommandButton getCb3() {
        return cb3;
    }

    public void setCb4(RichCommandButton cb4) {
        this.cb4 = cb4;
    }

    public RichCommandButton getCb4() {
        return cb4;
    }

    public void setCb5(RichCommandButton cb5) {
        this.cb5 = cb5;
    }

    public RichCommandButton getCb5() {
        return cb5;
    }

    public void setCb7(RichCommandButton cb7) {
        this.cb7 = cb7;
    }

    public RichCommandButton getCb7() {
        return cb7;
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

    public void setGb1(RichGoButton gb1) {
        this.gb1 = gb1;
    }

    public RichGoButton getGb1() {
        return gb1;
    }

    public void setId1(RichInputDate id1) {
        this.id1 = id1;
    }

    public RichInputDate getId1() {
        return id1;
    }

    public void setIf1(RichInputFile if1) {
        this.if1 = if1;
    }

    public RichInputFile getIf1() {
        return if1;
    }

    public void setIt2(RichInputText it2) {
        this.it2 = it2;
    }

    public RichInputText getIt2() {
        return it2;
    }

    public void setI1(RichImage i1) {
        this.i1 = i1;
    }

    public RichImage getI1() {
        return i1;
    }

    public void setCb6(RichCommandButton cb6) {
        this.cb6 = cb6;
    }

    public RichCommandButton getCb6() {
        return cb6;
    }

    public void setDb1(RichDecorativeBox db1) {
        this.db1 = db1;
    }

    public RichDecorativeBox getDb1() {
        return db1;
    }

    public void setPgl3(RichPanelGroupLayout pgl3) {
        this.pgl3 = pgl3;
    }

    public RichPanelGroupLayout getPgl3() {
        return pgl3;
    }

    public void setCb10(RichCommandButton cb10) {
        this.cb10 = cb10;
    }

    public RichCommandButton getCb10() {
        return cb10;
    }

    public void setPgl4(RichPanelGroupLayout pgl4) {
        this.pgl4 = pgl4;
    }

    public RichPanelGroupLayout getPgl4() {
        return pgl4;
    }


    public void toggle_state(ActionEvent actionEvent) {
        // Add event code here...
    }
    //=================================================
    public static void main(String[] args) {
//        AppModuleImpl mod = (AppModuleImpl)Configuration.createRootApplicationModule(
//                    "ru.rdtex.mvd.weapon.model.am.AppModule",                   
//                    "AppModuleLocal");
//        //mod.getTransaction().setLockingMode(Transaction.LOCK_NONE);
//        DBTransaction tran = (DBTransaction)mod.getTransaction();
//        //tran.getTransactionHandler().
//            
//            
//        EntPersonsViewImpl vo = (EntPersonsViewImpl)mod.getEntPersonsView1();
//        //vo.first();
//        Key key = new Key(new Object[]{"25736"});
//        Row[] rows = vo.findByKey(key, 1);
//                        
//          vo.setCurrentRow(rows[0]);
//          EntPersonsViewRowImpl row = (EntPersonsViewRowImpl)vo.getCurrentRow();
//         System.out.println(row.getId());
//         //        
//        row.setState(new Number(0));
//        mod.getTransaction().commit();
//        
//        
//        rows = vo.findByKey(key, 1);
//        vo.setCurrentRow(rows[0]);
//        row = (EntPersonsViewRowImpl)vo.getCurrentRow();
//         
//       
//        System.out.println(row.getId());
//        
//        row.setState(new Number(0));
//        mod.getTransaction().commit();
        test1();

        
    }
    private static void test1() {
        AppModuleImpl mod = (AppModuleImpl)Configuration.createRootApplicationModule(
                    "ru.rdtex.mvd.weapon.model.am.AppModule",                   
                    "AppModuleLocal");
        DBTransaction tran = (DBTransaction)mod.getTransaction();
        EntPersonsViewImpl vo = (EntPersonsViewImpl)mod.getEntPersonsView1();
        Key key = new Key(new Object[]{"25736"});
        Row[] rows = vo.findByKey(key, 1);
        vo.setCurrentRow(rows[0]);
        EntPersonsViewRowImpl row = (EntPersonsViewRowImpl)vo.getCurrentRow();
        System.out.println(row.getId());
         //        
        row.setState(new Number(0));
        mod.getTransaction().commit();
        
        vo.refreshCollection(new Row[]{row}, true, true);
                         
        System.out.println(row.getId());
        
        row.setState(new Number(0));
        mod.getTransaction().commit();
        
    }
}
