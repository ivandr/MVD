package ru.rdtex.mvd.weapon.view.backing.input_data;

import javax.annotation.PostConstruct;

import javax.annotation.PreDestroy;

import javax.faces.component.UIComponent;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.component.rich.RichForm;
import oracle.adf.view.rich.component.rich.fragment.RichDeclarativeComponent;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichPanelBox;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelStretchLayout;

import org.apache.myfaces.trinidad.event.AttributeChangeEvent;

import ru.rdtex.global.ADFUtils;
import ru.rdtex.global.AdfBaseBean;
import ru.rdtex.mvd.weapon.model.am.AppModuleImpl;
import ru.rdtex.mvd.weapon.model.vo.EntAddressesViewImpl;
import ru.rdtex.mvd.weapon.model.vo.EntPersonsViewImpl;
import ru.rdtex.mvd.weapon.model.vo.RegionDeptViewImpl;

import utils.system;

public class Person_addresses_edit extends AdfBaseBean {
    private RichForm f1;
    private RichDocument d1;
    private RichPanelStretchLayout psl1;
    private RichPanelGroupLayout pgl1;
    private RichPanelBox pb1;
    private RichDeclarativeComponent cbdd1;
    private RichSelectOneChoice regionDept;

    @PostConstruct
    public void initBean() {

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

    public void setPgl1(RichPanelGroupLayout pgl1) {
        this.pgl1 = pgl1;
    }

    public RichPanelGroupLayout getPgl1() {
        return pgl1;
    }

    public void setPb1(RichPanelBox pb1) {
        this.pb1 = pb1;
    }

    public RichPanelBox getPb1() {
        return pb1;
    }

    public void setCbdd1(RichDeclarativeComponent cbdd1) {
        this.cbdd1 = cbdd1;
    }

    public RichDeclarativeComponent getCbdd1() {
        return cbdd1;
    }

    public void setRegionDept(RichSelectOneChoice regionDept) {
        this.regionDept = regionDept;
    }

    public RichSelectOneChoice getRegionDept() {
        return regionDept;
    }

    public void changeRegion(ValueChangeEvent valueChangeEvent) {
        UIComponent comp = valueChangeEvent.getComponent();  
        Object value = comp.getAttributes().get("value");
        System.out.println("value = "+value);
        
        AppModuleImpl mod = (AppModuleImpl)ADFUtils.getBindingApplicationModule();
//        RegionDeptViewImpl vo = (RegionDeptViewImpl)mod.getRegionDeptView1();        
        EntAddressesViewImpl vo = mod.getEntAddressesView2();
        vo.setWhereClause("REGION_CODE="+value);
        vo.executeQuery();
        vo.first();
        System.out.println("getQuery = "+vo.getQuery());
        //        ///
        addPartialTarget(getRegionDept());
    }

    public void changeTypeAddr(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
    }
}
