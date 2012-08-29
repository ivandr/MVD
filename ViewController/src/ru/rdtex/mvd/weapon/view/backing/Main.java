package ru.rdtex.mvd.weapon.view.backing;

import oracle.adf.model.BindingContext;
import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.component.rich.RichForm;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.server.ViewObjectImpl;

import ru.rdtex.global.ADFUtils;
import ru.rdtex.mvd.weapon.model.am.AppModuleImpl;

public class Main {
    private RichForm f1;
    private RichDocument d1;
    private RichPanelGroupLayout pgl1;
    
    //получаем значение для Department
    public static String getObjObjectCurrent() {
        return getObjObjectCurrent("Name");
    }
    
    public static String getObjObjectCurrent(String attrName) {
        AppModuleImpl mod = (AppModuleImpl)ADFUtils.getBindingApplicationModule();
        ViewObjectImpl voROOC = mod.getRObjObjectCurrentView1(); 
        Row rROOC = voROOC.first();
        return (String)rROOC.getAttribute(attrName);
    }
    
    public static String save_action() {
        return action("Commit");
    }
    
    public static String cancel_action() {
        return action("Rollback");
    }
    
    public static String edit() {
        return action("setCurrentRowWithKeyValue", "edit");
    }
    
    public static String action(String name) {
        return action(name, "back");
    }
    
    public static String action(String name, String link) {
        BindingContainer bindings = BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding operationBinding = bindings.getOperationBinding(name);
        Object result = operationBinding.execute();
        if (!operationBinding.getErrors().isEmpty()) {
            return null;
        }
        return link;
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

    public void setPgl1(RichPanelGroupLayout pgl1) {
        this.pgl1 = pgl1;
    }

    public RichPanelGroupLayout getPgl1() {
        return pgl1;
    }
}
