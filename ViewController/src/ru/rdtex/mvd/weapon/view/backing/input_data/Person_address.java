package ru.rdtex.mvd.weapon.view.backing.input_data;

import oracle.adf.model.BindingContext;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.fragment.RichDeclarativeComponent;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;
import oracle.adf.view.rich.component.rich.layout.RichPanelStretchLayout;
import oracle.adf.view.rich.component.rich.layout.RichToolbar;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.output.RichMessages;
import oracle.adf.view.rich.component.rich.output.RichPanelCollection;

import oracle.binding.BindingContainer;

import ru.rdtex.mvd.weapon.view.backing.Main;

public class Person_address {
    private RichPanelStretchLayout psl1;
    private RichPanelCollection pc1;
    private RichMessages m1;
    private RichTable t1;
    private RichInputDate id1;
    private RichToolbar t2;
    private RichSelectBooleanCheckbox HEADER_CHECKBOX;
    private RichCommandButton cb1;
    private RichCommandButton cb2;
    private RichDeclarativeComponent cbdd1;
    private RichCommandButton cb3;

    public String edit() {
        return Main.edit();
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

    public void setId1(RichInputDate id1) {
        this.id1 = id1;
    }

    public RichInputDate getId1() {
        return id1;
    }

    public void setT2(RichToolbar t2) {
        this.t2 = t2;
    }

    public RichToolbar getT2() {
        return t2;
    }

    public void setHEADER_CHECKBOX(RichSelectBooleanCheckbox HEADER_CHECKBOX) {
        this.HEADER_CHECKBOX = HEADER_CHECKBOX;
    }

    public RichSelectBooleanCheckbox getHEADER_CHECKBOX() {
        return HEADER_CHECKBOX;
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

    public void setCbdd1(RichDeclarativeComponent cbdd1) {
        this.cbdd1 = cbdd1;
    }

    public RichDeclarativeComponent getCbdd1() {
        return cbdd1;
    }

    public void setCb3(RichCommandButton cb3) {
        this.cb3 = cb3;
    }

    public RichCommandButton getCb3() {
        return cb3;
    }
}
