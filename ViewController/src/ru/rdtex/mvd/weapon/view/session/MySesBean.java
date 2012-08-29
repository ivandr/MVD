package ru.rdtex.mvd.weapon.view.session;

import oracle.jbo.domain.Number;

public class MySesBean {
    
    private String personType; 
    private Number personId;
    private String typeBlank;
    

    
    public MySesBean() {
      super();
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public String getPersonType() {
        return personType;
    }

    public void setPersonId(Number personId) {
        this.personId = personId;
    }

    public Number getPersonId() {
        return personId;
    }

    public void setTypeBlank(String typeBlank) {
        this.typeBlank = typeBlank;
    }

    public String getTypeBlank() {
        return typeBlank;
    }

}
