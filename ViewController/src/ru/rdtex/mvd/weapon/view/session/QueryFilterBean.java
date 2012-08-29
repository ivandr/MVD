package ru.rdtex.mvd.weapon.view.session;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;

import javax.faces.context.FacesContext;

import javax.faces.model.SelectItem;

import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.event.QueryEvent;
import oracle.adf.view.rich.model.FilterableQueryDescriptor;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ViewObjectImpl;

import ru.rdtex.global.ADFUtils;
import ru.rdtex.global.AdfBaseBean;
import ru.rdtex.mvd.weapon.model.am.AppModuleImpl;
import ru.rdtex.mvd.weapon.model.vo.lov.TypeBlankImpl;
import ru.rdtex.mvd.weapon.model.vo.lov.TypeBlankRowImpl;
import ru.rdtex.mvd.weapon.model.vo.TypeLicenceViewImpl;

public class QueryFilterBean {
    public QueryFilterBean() {
        super();
    }

    public static List<SelectItem> getFilterSelectItems(String viewObject) {

        String valueName = "ID";
        String captionName = "NAME";
        return getFilterSelectItems(viewObject, valueName, captionName);
    }

    public static List<SelectItem> getFilterSelectItems(String viewObject,
                                                 String valueName,
                                                 String captionName) {
        boolean isEmptyRowExists = true;
        Object valueEmpty = null;
        String captionEmpty = "";
        String dataControlName = "AppModule";
        return getFilterSelectItems(viewObject, valueName, captionName,
                                    isEmptyRowExists, valueEmpty, captionEmpty,
                                    dataControlName);
    }

    public static List<SelectItem> getFilterSelectItems(String viewObject,
                                                 String valueName,
                                                 String captionName,
                                                 boolean isEmptyRowExists,
                                                 Object valueEmpty,
                                                 String captionEmpty,
                                                 String dataControlName) {

        //ApplicationModule mod = ADFUtils.getApplicationModuleForDataControl(dataControlName);
        AppModuleImpl mod = (AppModuleImpl)ADFUtils.getBindingApplicationModule();
        ViewObject vo = mod.findViewObject(viewObject);
        List<SelectItem> rc = new ArrayList<SelectItem>();
        vo.reset();
        if (isEmptyRowExists) {
            rc.add(new SelectItem(valueEmpty, captionEmpty));
        }
        while (vo.hasNext()) {
            Row rowItem = vo.next();
            Object valueItem = rowItem.getAttribute(valueName);
            String captionItem = (String)rowItem.getAttribute(captionName);
            rc.add(new SelectItem(valueItem, captionItem));
        }

        return rc;
    }
    
    //    public static void setFilterByStatus(Object newStatus, String column,
    //                                  RichTable table, String viewObject)
    //    //, String dataControlName
    //    {
    //        System.out.println("newStatus = " + newStatus);
    //        String filter = null;
    //        //System.out.println("newStatus: " + newStatus);
    //        if (!newStatus.equals("-1")) {
    //            filter = column + " = '" + newStatus + "'";
    //        }
    //        //System.out.println("filter: " + filter);
    //        AppModuleImpl mod =
    //            (AppModuleImpl)ADFUtils.getBindingApplicationModule();
    //        ViewObjectImpl vo = (ViewObjectImpl)mod.findViewObject(viewObject);
    //        vo.setWhereClause(filter);
    //        System.out.println("WhereClause: " +vo.getWhereClause());
    //        vo.executeQuery();
    //        vo.first();
    //
    //        AdfBaseBean.addPartialTarget(table);
    //    }

    public void onQuery(QueryEvent queryEvent) {
        // pre-processing code here

        boolean invokeQuery = true;
        /*
       * Method called by the Query Listener. This method checks if
    * the DepartmentId parameter contains a valid number and puts
       * the DepartmentName into the expected case
      */
        FilterableQueryDescriptor fqd =
            (FilterableQueryDescriptor)queryEvent.getDescriptor();
        Map map = fqd.getFilterCriteria();
        System.out.println("Id: " + map.get("Id"));
        map.put("TypeBlank", "Лицензия");
        System.out.println("TypeBlank: " + map.get("TypeBlank"));
        // ensure DepartmentId contains a Number
        String departmentId = (String)map.get("Id");

        if (departmentId != null && departmentId.length() > 0) {
            try {
                // try to parse String to integer
                Long.parseLong(departmentId);
            } catch (Exception ex) {
                // not a string
                System.out.println("Not a string");
                // add some error message here
                // unset selection
                map.remove("Id");
                invokeQuery = false;
            }
        }
        // ensure the initial character is in uppercase
        String departmentName = (String)map.get("Series");
        if (departmentName != null && departmentName.length() > 0) {
            StringBuffer sbuf = new StringBuffer();
            sbuf.append(departmentName.substring(0, 1).toUpperCase());
            sbuf.append(departmentName.substring(1).toLowerCase());
            map.put("Series", sbuf.toString());
        }
        if (invokeQuery) {
            // execute the defaul QueryListener code added by JDeveloper
            //when creating the table
            invokeMethodExpression("#{bindings.TypeLicenceView1Query.processQuery}",
                                   Object.class, QueryEvent.class, queryEvent);
        }
        // post processing code here
    }
    // The code below should be in a Utility clas

    public Object invokeMethodExpression(String expr, Class returnType,
                                         Class[] argTypes, Object[] args) {
        FacesContext fc = FacesContext.getCurrentInstance();
        ELContext elctx = fc.getELContext();
        ExpressionFactory elFactory =
            fc.getApplication().getExpressionFactory();
        MethodExpression methodExpr =
            elFactory.createMethodExpression(elctx, expr, returnType,
                                             argTypes);
        return methodExpr.invoke(elctx, args);
    }

    public Object invokeMethodExpression(String expr, Class returnType,
                                         Class argType, Object argument) {
        return invokeMethodExpression(expr, returnType,
                                      new Class[] { argType },
                                      new Object[] { argument });
    }

}
