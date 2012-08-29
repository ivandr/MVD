package ru.rdtex.mvd.weapon.view.session;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.event.ValueChangeEvent;

import ru.rdtex.global.utils.StringFunc;


public class mysession implements Serializable {
   
    private EncodeRusText encodeObject = new EncodeRusText();
    
    public mysession() {
        super();
    }

    public void checkAllCheckBox(ValueChangeEvent valueChangeEvent) {
      UIComponent comp = valueChangeEvent.getComponent();  
      String value1 = (String)comp.getAttributes().get("param1");
    }
    
    
    
    public class EncodeRusText extends HashMap<String,Object> {
        private static final long serialVersionUID = 1L;
        @Override
      public Object get(Object property) {
        String text = property.toString();
        if (text == null) {
            return null;
        }
        return StringFunc.encodeRusString(text);
      }
    }
    
    public Map<String,Object> getEncodeRusText() {
        return encodeObject;
    }
    
    /*private ViewObjectImpl getVO(String nameVO) {
        AppModuleImpl mod = (AppModuleImpl)ADFUtils.getBindingApplicationModule();
        return (ViewObjectImpl)mod.findViewObject(nameVO);
    }
    
    public void toggleAllCheckBox(ValueChangeEvent valueChangeEvent) {
        String nameVO = "CountryView1";
        System.out.println("CountryView1");
        Boolean newVal = (Boolean)valueChangeEvent.getNewValue();
        if (newVal != null && newVal.equals(false))
            newVal = null;
    
        ViewObjectImpl vo = this.getVO(nameVO);
        RowSet rowSet = vo.getRowSet();
        //Integer countViewRow = table1.getRows();
        //System.out.println("@countViewRow=" + countViewRow);
        ViewObjectImpl first = (ViewObjectImpl)rowSet.first();
        //System.out.println("@first=" + first);
        if (first != null) {
            first.setDeleteRow(newVal);
            int i = 0;

            while (rowSet.hasNext()) {
                try {
                    ViewObjectImpl item =
                        (ViewObjectImpl)rowSet.next();
                    item.setDeleteRow(newVal);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                i++;
                if (i > 50) {
                    break;
                }
            }
        }
    }*/
}
