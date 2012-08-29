package ru.rdtex.mvd.weapon.view.backing.administration.classifiers;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.component.rich.RichForm;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;

import oracle.jbo.Row;
import oracle.jbo.server.ViewObjectImpl;

import ru.rdtex.global.ADFUtils;
import ru.rdtex.mvd.weapon.global.JSFUtils;
import ru.rdtex.mvd.weapon.model.am.AppModuleImpl;

public class Main {
    private RichForm f1;
    private RichDocument d1;
    private RichPanelGroupLayout pgl1;
    
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

    public void setPgl1(RichPanelGroupLayout pgl1) {
        this.pgl1 = pgl1;
    }

    public RichPanelGroupLayout getPgl1() {
        return pgl1;
    }
    
    public void initialize() {
        JSFUtils.setExpressionValue("#{attrs.menuName}", "classifierMenu");
        Object newVal = JSFUtils.resolveExpression("#{attrs.menuName}");
        System.out.println(newVal);
    }

}
