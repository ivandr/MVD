package ru.rdtex.mvd.weapon.view.backing.administration.classifiers.directory;

import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.component.rich.RichForm;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;
import oracle.adf.view.rich.component.rich.layout.RichPanelStretchLayout;
import oracle.adf.view.rich.component.rich.layout.RichToolbar;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.nav.RichCommandToolbarButton;
import oracle.adf.view.rich.component.rich.output.RichMessages;
import oracle.adf.view.rich.component.rich.output.RichPanelCollection;

import org.apache.myfaces.trinidad.component.UIXGroup;

import ru.rdtex.mvd.weapon.model.am.AppModuleImpl;

public class Country {
    private RichForm f1;
    private RichDocument d1;
    private RichPanelStretchLayout psl1;
    private RichPanelCollection pc1;
    private RichMessages m1;
    private RichTable t1;
    private RichToolbar t2;
    private RichCommandToolbarButton ctb1;
    private RichCommandToolbarButton ctb2;
    private RichCommandToolbarButton ctb3;
    private RichCommandButton cb1;
    private RichCommandButton cb2;
    private RichCommandButton cb3;
    private RichCommandButton cb4;
    private HtmlSelectBooleanCheckbox sbc1;
    private UIXGroup g1;
    private RichSelectBooleanCheckbox sbc2;

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

    public void setT2(RichToolbar t2) {
        this.t2 = t2;
    }

    public RichToolbar getT2() {
        return t2;
    }


    public void setCtb1(RichCommandToolbarButton ctb1) {
        this.ctb1 = ctb1;
    }

    public RichCommandToolbarButton getCtb1() {
        return ctb1;
    }

    public void setCtb2(RichCommandToolbarButton ctb2) {
        this.ctb2 = ctb2;
    }

    public RichCommandToolbarButton getCtb2() {
        return ctb2;
    }

    public void setCtb3(RichCommandToolbarButton ctb3) {
        this.ctb3 = ctb3;
    }

    public RichCommandToolbarButton getCtb3() {
        return ctb3;
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

    public void setCb4(RichCommandButton cb4) {
        this.cb4 = cb4;
    }

    public RichCommandButton getCb4() {
        return cb4;
    }


    public void toggleAllCheckBox(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
    }


    public void setSbc1(HtmlSelectBooleanCheckbox sbc1) {
        this.sbc1 = sbc1;
    }

    public HtmlSelectBooleanCheckbox getSbc1() {
        return sbc1;
    }

    public void setG1(UIXGroup g1) {
        this.g1 = g1;
    }

    public UIXGroup getG1() {
        return g1;
    }

    public void setSbc2(RichSelectBooleanCheckbox sbc2) {
        this.sbc2 = sbc2;
    }

    public RichSelectBooleanCheckbox getSbc2() {
        return sbc2;
    }
}
