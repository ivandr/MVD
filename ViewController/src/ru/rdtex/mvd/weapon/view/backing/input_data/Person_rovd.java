package ru.rdtex.mvd.weapon.view.backing.input_data;

import java.util.List;

import javax.faces.component.UISelectItems;

import javax.faces.model.SelectItem;

import oracle.adf.model.BindingContext;
import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.component.rich.RichForm;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichPanelStretchLayout;
import oracle.adf.view.rich.component.rich.layout.RichToolbar;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.output.RichMessages;
import oracle.adf.view.rich.component.rich.output.RichPanelCollection;

import oracle.binding.BindingContainer;

import ru.rdtex.mvd.weapon.view.backing.Main;
import ru.rdtex.mvd.weapon.view.session.QueryFilterBean;

public class Person_rovd {
    private RichForm f1;
    private RichDocument d1;
    private RichPanelStretchLayout psl1;
    private RichPanelCollection pc1;
    private RichMessages m1;
    private RichTable t1;
    private RichSelectBooleanCheckbox HEADER_CHECKBOX;
    private RichToolbar t2;
    private RichCommandButton cb1;
    private RichCommandButton cb2;
    private RichCommandButton cb3;
    private RichSelectOneChoice soc3;
    private UISelectItems pt_si1;
    private RichCommandButton cb4;

    //фильтр по Состоянию
//    private Object fRovdStatus = "-1";
//    public void setFRovdStatus(Object newStatus) {
//        this.fRovdStatus = newStatus;
//        QueryFilterBean.setFilterByStatus(this.fRovdStatus, "EntPersonsRovd.ROVD_STATUS",
//                                          this.t1, "EntPersonsRovdView2");
//    }
//    public Object getFRovdStatus() {
//        return fRovdStatus;
//    }
    public List<SelectItem> getFRovdStatusSelectList() {
        //ссылка на View Object, колонка ключа (по умолчанию ID), колонка названия (по умолчанию NAME)
        return QueryFilterBean.getFilterSelectItems("RovdStatusView1");
    }
    
    public String edit() {
        return Main.edit();
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

    public void setPsl1(RichPanelStretchLayout psl1) {
        this.psl1 = psl1;
    }

    public RichPanelStretchLayout getPsl1() {
        return psl1;
    }

    public void setPc1(RichPanelCollection pc1) {
        this.pc1 = pc1;
    }

    public RichPanelCollection getPc1() {
        return pc1;
    }

    public void setM1(RichMessages m1) {
        this.m1 = m1;
    }

    public RichMessages getM1() {
        return m1;
    }

    public void setT1(RichTable t1) {
        this.t1 = t1;
    }

    public RichTable getT1() {
        return t1;
    }

    public void setHEADER_CHECKBOX(RichSelectBooleanCheckbox HEADER_CHECKBOX) {
        this.HEADER_CHECKBOX = HEADER_CHECKBOX;
    }

    public RichSelectBooleanCheckbox getHEADER_CHECKBOX() {
        return HEADER_CHECKBOX;
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

    public void setCb2(RichCommandButton cb2) {
        this.cb2 = cb2;
    }

    public RichCommandButton getCb2() {
        return cb2;
    }


    public void setCb3(RichCommandButton cb3) {
        this.cb3 = cb3;
    }

    public RichCommandButton getCb3() {
        return cb3;
    }

    public void setSoc3(RichSelectOneChoice soc3) {
        this.soc3 = soc3;
    }

    public RichSelectOneChoice getSoc3() {
        return soc3;
    }

    public void setPt_si1(UISelectItems pt_si1) {
        this.pt_si1 = pt_si1;
    }

    public UISelectItems getPt_si1() {
        return pt_si1;
    }

    public void setCb4(RichCommandButton cb4) {
        this.cb4 = cb4;
    }

    public RichCommandButton getCb4() {
        return cb4;
    }
}
