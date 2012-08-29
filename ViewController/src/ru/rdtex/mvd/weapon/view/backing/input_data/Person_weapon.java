package ru.rdtex.mvd.weapon.view.backing.input_data;


import javax.annotation.PostConstruct;

import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.component.rich.RichForm;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;
import oracle.adf.view.rich.component.rich.input.RichSelectItem;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.input.RichSelectOneRadio;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelSplitter;
import oracle.adf.view.rich.component.rich.layout.RichToolbar;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.output.RichMessages;
import oracle.adf.view.rich.component.rich.output.RichPanelCollection;
import oracle.adf.view.rich.render.ClientEvent;

import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.domain.Number;

import oracle.jbo.server.ViewObjectImpl;

import oracle.jbo.server.ViewRowImpl;

import org.apache.myfaces.trinidad.component.UIXGroup;

import ru.rdtex.global.ADFUtils;
import ru.rdtex.mvd.weapon.global.JSFUtils;
import ru.rdtex.mvd.weapon.model.am.AppModuleImpl;
import ru.rdtex.mvd.weapon.model.vo.read.RGunGunsViewImpl;
import ru.rdtex.mvd.weapon.model.vo.read.VSuperDocViewImpl;
import ru.rdtex.mvd.weapon.view.backing.Main;

public class Person_weapon {
    private AppModuleImpl mod = (AppModuleImpl)ADFUtils.getBindingApplicationModule();
    private RGunGunsViewImpl vo = (RGunGunsViewImpl)mod.getRGunGunsView1();
    private RichForm f1;
    private RichDocument d1;
    private RichPanelCollection pc1;
    private RichMessages m1;
    private RichTable t1;
    private RichToolbar t3;
    private RichSelectOneRadio sorTypeWeapon;
    private RichSelectItem si12;
    private RichSelectItem si13;
    private RichInputText radioText;
    private RichToolbar t2;
    private RichCommandButton cb1;
    private String isPerson;
    private Number docId;
    private UIXGroup g1;
    private RichPanelSplitter ps1;
    private RichToolbar t4;
    private RichCommandButton cb2;
    private RichToolbar t5;
    private RichSelectOneRadio sor1;
    private RichSelectItem si1;
    private RichSelectItem si2;
    private RichInputText radio;
    private RichTable t6;
    private RichPanelGroupLayout pgl1;
    private RichPanelFormLayout pfl1;
    private RichInputText it2;
    private RichInputText it3;
    private RichInputText it4;
    private RichSelectOneChoice soc1;
    private UISelectItems si3;
    private RichPanelFormLayout pfl2;
    private RichPanelFormLayout pfl3;
    private RichSelectOneChoice soc2;
    private UISelectItems si4;
    private RichSelectOneChoice soc3;
    private UISelectItems si5;
    private RichPanelFormLayout pfl4;
    private RichInputText it5;
    private RichInputText it6;
    private RichInputText it7;
    private RichInputText it8;
    private RichInputText it9;
    private RichSelectOneChoice soc4;
    private UISelectItems si6;
    private RichSelectOneChoice soc5;
    private UISelectItems si7;
    private RichPanelFormLayout pfl5;
    private RichInputText it10;
    private RichPanelFormLayout pfl6;
    private RichInputText it11;
    private RichInputDate id1;
    private RichSelectBooleanCheckbox sbc1;


    public String back() {
         Number id = getDocId();  
         if (id == null) return "back";
         return "add_back";         
    }
    
    @PostConstruct
    public void initBean() {
        Number id = getDocId(); 
        String isPers = getIsPerson();
        if (id == null && isPers.equals("1")) {
            setIsPerson("0");
            reloadVO();
        } else {
            setIsPerson(isPers);
        }

        System.out.println("isPerson = " + vo.getisPerson());
        System.out.println("personId = " + vo.getpersonId());
    }
    
    private void reloadVO() {
        vo.executeQuery();
        //vo.first();
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
        vo.setisPerson("0");
        
        if (value != null) {
            vo.setisPerson(value);
        } 
        
        reloadVO();
    }
    
    public void setIsPerson(String isPerson) {
        vo.setpersonId(JSFUtils.resolveExpression("#{Myses.personId}").toString());
        vo.setisPerson(isPerson);
        System.out.println("setIsPerson = " + isPerson);
    }

    public String getIsPerson() {
        String isPerson = vo.getisPerson();
        System.out.println("getIsPerson = " + isPerson);
        return (isPerson == null ? "0" : isPerson);
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

    public void setT3(RichToolbar t3) {
        this.t3 = t3;
    }

    public RichToolbar getT3() {
        return t3;
    }

    public void setSorTypeWeapon(RichSelectOneRadio sor1) {
        this.sorTypeWeapon = sor1;
    }

    public RichSelectOneRadio getSorTypeWeapon() {
        return sorTypeWeapon;
    }

    public void setSi12(RichSelectItem si12) {
        this.si12 = si12;
    }

    public RichSelectItem getSi12() {
        return si12;
    }

    public void setSi13(RichSelectItem si13) {
        this.si13 = si13;
    }

    public RichSelectItem getSi13() {
        return si13;
    }

    public void setRadioText(RichInputText radioText) {
        this.radioText = radioText;
    }

    public RichInputText getRadioText() {
        return radioText;
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

    public void setDocId(Number id) {  
        //this.docId = id;
    }

    public Number getDocId() {
        HttpSession session = JSFUtils.getSession();
        //HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        Number id = (Number)session.getAttribute("docId");
        System.out.println("DocId = " + id);
        return id;
    }

    public void setG1(UIXGroup g1) {
        this.g1 = g1;
    }

    public UIXGroup getG1() {
        return g1;
    }

    public void setPs1(RichPanelSplitter ps1) {
        this.ps1 = ps1;
    }

    public RichPanelSplitter getPs1() {
        return ps1;
    }

    public void setT4(RichToolbar t4) {
        this.t4 = t4;
    }

    public RichToolbar getT4() {
        return t4;
    }

    public void setCb2(RichCommandButton cb2) {
        this.cb2 = cb2;
    }

    public RichCommandButton getCb2() {
        return cb2;
    }

    public void setT5(RichToolbar t5) {
        this.t5 = t5;
    }

    public RichToolbar getT5() {
        return t5;
    }

    public void setSor1(RichSelectOneRadio sor1) {
        this.sor1 = sor1;
    }

    public RichSelectOneRadio getSor1() {
        return sor1;
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

    public void setRadio(RichInputText it1) {
        this.radio = it1;
    }

    public RichInputText getRadio() {
        return radio;
    }

    public void setT6(RichTable t6) {
        this.t6 = t6;
    }

    public RichTable getT6() {
        return t6;
    }

    public void setPgl1(RichPanelGroupLayout pgl1) {
        this.pgl1 = pgl1;
    }

    public RichPanelGroupLayout getPgl1() {
        return pgl1;
    }

    public void setPfl1(RichPanelFormLayout pfl1) {
        this.pfl1 = pfl1;
    }

    public RichPanelFormLayout getPfl1() {
        return pfl1;
    }

    public void setIt2(RichInputText it2) {
        this.it2 = it2;
    }

    public RichInputText getIt2() {
        return it2;
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

    public void setSoc1(RichSelectOneChoice soc1) {
        this.soc1 = soc1;
    }

    public RichSelectOneChoice getSoc1() {
        return soc1;
    }

    public void setSi3(UISelectItems si3) {
        this.si3 = si3;
    }

    public UISelectItems getSi3() {
        return si3;
    }

    public void setPfl2(RichPanelFormLayout pfl2) {
        this.pfl2 = pfl2;
    }

    public RichPanelFormLayout getPfl2() {
        return pfl2;
    }


    public void setPfl3(RichPanelFormLayout pfl3) {
        this.pfl3 = pfl3;
    }

    public RichPanelFormLayout getPfl3() {
        return pfl3;
    }

    public void setSoc2(RichSelectOneChoice soc2) {
        this.soc2 = soc2;
    }

    public RichSelectOneChoice getSoc2() {
        return soc2;
    }

    public void setSi4(UISelectItems si4) {
        this.si4 = si4;
    }

    public UISelectItems getSi4() {
        return si4;
    }

    public void setSoc3(RichSelectOneChoice soc3) {
        this.soc3 = soc3;
    }

    public RichSelectOneChoice getSoc3() {
        return soc3;
    }

    public void setSi5(UISelectItems si5) {
        this.si5 = si5;
    }

    public UISelectItems getSi5() {
        return si5;
    }

    public void setPfl4(RichPanelFormLayout pfl4) {
        this.pfl4 = pfl4;
    }

    public RichPanelFormLayout getPfl4() {
        return pfl4;
    }

    public void setIt5(RichInputText it5) {
        this.it5 = it5;
    }

    public RichInputText getIt5() {
        return it5;
    }

    public void setIt6(RichInputText it6) {
        this.it6 = it6;
    }

    public RichInputText getIt6() {
        return it6;
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

    public void setSoc4(RichSelectOneChoice soc4) {
        this.soc4 = soc4;
    }

    public RichSelectOneChoice getSoc4() {
        return soc4;
    }

    public void setSi6(UISelectItems si6) {
        this.si6 = si6;
    }

    public UISelectItems getSi6() {
        return si6;
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

    public void setPfl5(RichPanelFormLayout pfl5) {
        this.pfl5 = pfl5;
    }

    public RichPanelFormLayout getPfl5() {
        return pfl5;
    }

    public void setIt10(RichInputText it10) {
        this.it10 = it10;
    }

    public RichInputText getIt10() {
        return it10;
    }

    public void setPfl6(RichPanelFormLayout pfl6) {
        this.pfl6 = pfl6;
    }

    public RichPanelFormLayout getPfl6() {
        return pfl6;
    }

    public void setIt11(RichInputText it11) {
        this.it11 = it11;
    }

    public RichInputText getIt11() {
        return it11;
    }

    public void setId1(RichInputDate id1) {
        this.id1 = id1;
    }

    public RichInputDate getId1() {
        return id1;
    }

    public void setSbc1(RichSelectBooleanCheckbox sbc1) {
        this.sbc1 = sbc1;
    }

    public RichSelectBooleanCheckbox getSbc1() {
        return sbc1;
    }
}
