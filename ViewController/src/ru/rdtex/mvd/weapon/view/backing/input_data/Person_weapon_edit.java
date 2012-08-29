package ru.rdtex.mvd.weapon.view.backing.input_data;

import javax.annotation.PostConstruct;

import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.component.rich.RichForm;

import oracle.adf.view.rich.component.rich.layout.RichPanelBox;

import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.component.rich.layout.RichToolbox;

import oracle.adf.view.rich.component.rich.nav.RichCommandButton;

import oracle.jbo.Row;
import oracle.jbo.domain.Number;

import ru.rdtex.global.ADFUtils;
import ru.rdtex.mvd.weapon.model.am.AppModuleImpl;
import ru.rdtex.mvd.weapon.model.vo.read.RGunGunsViewImpl;

public class Person_weapon_edit {
    private AppModuleImpl mod = (AppModuleImpl)ADFUtils.getBindingApplicationModule();
    private RichForm f1;
    private RichDocument d1;
    private RichPanelBox pb1;
    private RichToolbox t1;
    private RichPanelFormLayout pfl1;
    private RichCommandButton cb1;

    @PostConstruct
    public void initBean() {
        RGunGunsViewImpl vo = (RGunGunsViewImpl)mod.getRGunGunsView1();
        Row row = vo.getCurrentRow();
        ADFUtils.printDataRow(row);
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

    public void setT1(RichToolbox t1) {
        this.t1 = t1;
    }

    public RichToolbox getT1() {
        return t1;
    }

    public void setPfl1(RichPanelFormLayout pfl1) {
        this.pfl1 = pfl1;
    }

    public RichPanelFormLayout getPfl1() {
        return pfl1;
    }

    public void setCb1(RichCommandButton cb1) {
        this.cb1 = cb1;
    }

    public RichCommandButton getCb1() {
        return cb1;
    }
}
