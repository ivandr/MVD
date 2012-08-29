package ru.rdtex.mvd.weapon.view.backing.administration.classifiers.directory;

import com.bea.core.repackaged.jdt.internal.compiler.lookup.TypeBinding;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UISelectItems;
import javax.faces.event.ValueChangeEvent;

import javax.faces.model.SelectItem;

import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.component.rich.RichForm;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;
import oracle.adf.view.rich.component.rich.input.RichSelectItem;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichPanelStretchLayout;
import oracle.adf.view.rich.component.rich.layout.RichToolbar;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.output.RichMessages;
import oracle.adf.view.rich.component.rich.output.RichPanelCollection;

import ru.rdtex.global.ADFUtils;
import ru.rdtex.global.AdfBaseBean;
import ru.rdtex.mvd.weapon.model.am.AppModuleImpl;
import ru.rdtex.mvd.weapon.model.vo.EntPersonsViewImpl;
import ru.rdtex.mvd.weapon.model.vo.lov.TypeBlankImpl;
import ru.rdtex.mvd.weapon.model.vo.lov.TypeBlankRowImpl;
import ru.rdtex.mvd.weapon.model.vo.TypeLicenceViewImpl;
import ru.rdtex.mvd.weapon.view.session.QueryFilterBean;

public class Licenses_types {
    private RichForm f1;
    private RichDocument d1;
    private RichPanelStretchLayout psl1;
    private RichPanelCollection pc1;
    private RichMessages m1;
    private RichToolbar t2;
    private RichCommandButton cb1;
    private RichCommandButton cb2;
    private RichCommandButton cb3;
    private RichCommandButton cb4;
    private RichTable t1;
    private RichSelectBooleanCheckbox HEADER_CHECKBOX;
    private RichSelectOneChoice soc3;
    private UISelectItems si3;
    private RichSelectItem si4;
    private RichSelectItem si5;

//    private Object fTypeBlank = "-1";
//    public void setFTypeBlank(Object newStatus) {
//        this.fTypeBlank = newStatus;
//        //setFilterByStatus(tbf);
//        QueryFilterBean.setFilterByStatus(this.fTypeBlank, "TypeLicence.TYPE_BLANK",
//                                          this.t1, "TypeLicenceView1");
//    }
//    public Object getFTypeBlank() {
//        return fTypeBlank;
//    }
    
    //    public SelectItem[] getRequestStatusSelectItems() {
    //        TypeBlank[] values = TypeBlank.values();
    //        SelectItem[] rc = new SelectItem[values.length + 1];
    //        rc[0] = new SelectItem(-1, "", "");
    //        for (int i = 0; i < values.length; i++) {
    //            RequestStatus item = values[i];
    //            rc[i + 1] =
    //                    new SelectItem(item.ordinal(), item.getCaption(), item.getCaption());
    //        }
    //        return rc;
    //    }

    public List<SelectItem> getFTypeBlankSelectList() {
        return QueryFilterBean.getFilterSelectItems("TypeBlank1");
        //        AppModuleImpl mod = (AppModuleImpl)ADFUtils.getBindingApplicationModule();
        //        TypeBlankImpl vo = (TypeBlankImpl)mod.getTypeBlank1();
        //        List<SelectItem> rc = new ArrayList<SelectItem>();
        //        vo.reset();
        //        rc.add(new SelectItem("-1",""));
        //        while (vo.hasNext()) {
        //          TypeBlankRowImpl rowItem = (TypeBlankRowImpl)vo.next();
        //          String value =  rowItem.getID();
        //          String caption = rowItem.getNAME();
        //          rc.add(new SelectItem(value,caption));
        //        }
        //        return rc;
    }

//    private void setFilterByStatus(String newStatus) {
//        QueryFilterBean.setFilterByStatus(newStatus, "TypeLicence.TYPE_BLANK",
//                                          t1, "TypeLicenceView1");
//
//        String filter = null;
//        //System.out.println("newStatus: " + newStatus);
//        if (!newStatus.equals("-1")) {
//            filter = "TypeLicence.TYPE_BLANK = '" + newStatus + "'";
//        }
//        //System.out.println("filter: " + filter);
//        AppModuleImpl mod =
//            (AppModuleImpl)ADFUtils.getBindingApplicationModule();
//        TypeLicenceViewImpl vo =
//            (TypeLicenceViewImpl)mod.getTypeLicenceView1();
//        vo.setWhereClause(filter);
//        vo.executeQuery();
//        vo.first();
//        //---------------------
//        AdfBaseBean.addPartialTarget(t1);
//        //addPartialTarget(table2);
//    }
    
//    private Object fFisUr = "-1";
//    public void setFFisUr(Object newStatus) {
//        this.fFisUr = newStatus;
//        QueryFilterBean.setFilterByStatus(this.fFisUr, "TypeLicence.TYPE_PERSON",
//                                          this.t1, "TypeLicenceView1");
//    }
//    public Object getFFisUr() {
//        return fFisUr;
//    }
    public List<SelectItem> getFFisUrSelectList() {
        return QueryFilterBean.getFilterSelectItems("FisUr1");
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

    public void setCb4(RichCommandButton cb4) {
        this.cb4 = cb4;
    }

    public RichCommandButton getCb4() {
        return cb4;
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

    public void addPartialTarget(ValueChangeEvent valueChangeEvent) {
        System.out.println("11111111111");
        AdfBaseBean.addPartialTarget(getCb3());
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

    public void setSi4(RichSelectItem si4) {
        this.si4 = si4;
    }

    public RichSelectItem getSi4() {
        return si4;
    }

    public void setSi5(RichSelectItem si5) {
        this.si5 = si5;
    }

    public RichSelectItem getSi5() {
        return si5;
    }
}
