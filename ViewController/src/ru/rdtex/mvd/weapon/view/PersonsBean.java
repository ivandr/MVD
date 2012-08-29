package ru.rdtex.mvd.weapon.view;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import oracle.jbo.domain.Number;

import oracle.sqlj.runtime.Oracle;

import ru.rdtex.global.ADFUtils;
import ru.rdtex.mvd.weapon.model.am.AppModuleImpl;
import ru.rdtex.mvd.weapon.model.vo.EntPersonsViewImpl;


public class PersonsBean {
    public PersonsBean() {
        super();
    }
    
    public String getTitle() {
        return "Физ лица";
    }
    
@PostConstruct
public void initBean() {
   AppModuleImpl mod = (AppModuleImpl)ADFUtils.getBindingApplicationModule();
   EntPersonsViewImpl vo = (EntPersonsViewImpl)mod.getEntPersonsView1();
   //vo.setfowner("Y");
   Integer fstate = vo.getfstate();
   String fowner = vo.getfowner();
   String fguard = vo.getfguard();
   String femployee = vo.getfemployee();
   String fvip = vo.getfvip();
   String fname = vo.getfname();
   String persontype = vo.getpersonType();
   //String id = vo.getfid();
   //System.out.println("@id = "+id);
   System.out.println("@PersonBean.PERSONTYPE = "+persontype);
   System.out.println("@PersonBean.fstate = "+fstate);
   System.out.println("@PersonBean.fowner = "+fowner);
   System.out.println("@PersonBean.fguard = "+fguard);
   System.out.println("@PersonBean.femployee = "+femployee);
   System.out.println("@PersonBean.fvip = "+fvip);
   System.out.println("@PersonBean.fname = "+fname);
   //TODO
}

@PreDestroy
public void destroyBean() {
        
}
    
    
}
