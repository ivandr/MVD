package ru.rdtex.mvd.weapon.view.utils;



import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Set;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;
import javax.el.ValueExpression;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseId;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oracle.adf.controller.ControllerContext;
import oracle.adf.controller.TaskFlowId;
import oracle.adf.model.BindingContext;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.data.RichTreeTable;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.QueryEvent;
import oracle.adf.view.rich.model.FilterableQueryDescriptor;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.javatools.resourcebundle.BundleFactory;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Key;
import oracle.jbo.uicli.binding.JUCtrlHierNodeBinding;

import org.apache.myfaces.trinidad.component.UIXComponent;
import org.apache.myfaces.trinidad.component.UIXTree;
import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;


public class PageUtil {

    
    public static ApplicationModule getApplicationModule(String amName) {
        return (ApplicationModule)resolveExpression("#{data."+ amName +".dataProvider}");
    }
     
    public static Object resolveExpression(String expression) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Application app = facesContext.getApplication();
        ExpressionFactory elFactory = app.getExpressionFactory();
        ELContext elContext = facesContext.getELContext();
        ValueExpression valueExp = elFactory.createValueExpression(elContext, expression, Object.class);
      
        return valueExp.getValue(elContext);
    }
  public static void setExpression(String expression,Object value) {
      FacesContext facesContext = FacesContext.getCurrentInstance();
      Application app = facesContext.getApplication();
      ExpressionFactory elFactory = app.getExpressionFactory();
      ELContext elContext = facesContext.getELContext();
      ValueExpression valueExp = elFactory.createValueExpression(elContext, expression, Object.class);
      valueExp.setValue(elContext, value);
  }
    public static Object resolveMethodExpression(String expression, 
                                                 Class returnType, 
                                                 Class[] argTypes, 
                                                 Object[] argValues) {
      FacesContext facesContext = FacesContext.getCurrentInstance();
      Application app = facesContext.getApplication();
      ExpressionFactory elFactory = app.getExpressionFactory();
      ELContext elContext = facesContext.getELContext();
      MethodExpression methodExpression = 
                elFactory.createMethodExpression(elContext, expression, returnType, 
                                                 argTypes);
        return methodExpression.invoke(elContext, argValues);
      }
    
    public static String getHTTPSessionId(){
        ExternalContext ectx = FacesContext.getCurrentInstance().getExternalContext();
        //HttpServletResponse response = (HttpServletResponse)ectx.getResponse();
        HttpSession session = (HttpSession)ectx.getSession(false);
        String res = session.getId();
        return res;
    }
    
    public static String getApplicationUrl() { 
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext eContext = context.getExternalContext();
        //ViewHandler handler = context.getApplication().getViewHandler();
        String prefix="";
        Object requestObject = eContext.getRequest();
        if (requestObject instanceof HttpServletRequest) { 
           prefix = getHttpUrlPrefix((HttpServletRequest)requestObject);
        } else{
           prefix = "";
        } 
        //String actionUrl = handler.getActionURL(context, context.getViewRoot().getViewId());
        return prefix;
    }
    
    public static String getCurrentUrl() { 
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext eContext = context.getExternalContext();
        ViewHandler handler = context.getApplication().getViewHandler();
        String prefix="";
        Object requestObject = eContext.getRequest();
        if (requestObject instanceof HttpServletRequest) { 
           prefix = getHttpUrlPrefix((HttpServletRequest)requestObject);
        } else{
           // Portlet? prefix = "";
        } 
        String actionUrl = handler.getActionURL(context, context.getViewRoot().getViewId());
        return prefix + actionUrl;
    }
    
    private static String getHttpUrlPrefix(HttpServletRequest request) { 
         StringBuilder builder = new StringBuilder(32);
         builder.append(request.getScheme());
         builder.append("://");
         builder.append(request.getServerName());
         builder.append(':');
         builder.append(request.getServerPort());
         return builder.toString();
    }
    
    public static BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }
    
    public static void OperationBindingExec(String oper_name){
        if (oper_name != null) {
            BindingContainer bindings = getBindings();
            OperationBinding operationBinding = bindings.getOperationBinding(oper_name);
            if (operationBinding != null ){
                Object result = operationBinding.execute();
                if (!operationBinding.getErrors().isEmpty()) {
                    return;
                }
            }
        }
    }
    public static Boolean ExecOperation(String oper_name){
        if (getBindings()!=null){
            BindingContainer bindings = getBindings();
            OperationBinding operationBinding = bindings.getOperationBinding(oper_name);
            Object result = operationBinding.execute();
            if (operationBinding.getErrors().isEmpty()) {
                return true;
            }
            else {
                System.out.println("Error in executing operation "+ oper_name + ": "+ operationBinding.getErrors().toString());
                Object[] l = operationBinding.getErrors().toArray();
                String all_errrors=null;
                for (Object el : l){
                    all_errrors=all_errrors+el.toString();
                }
                message("Error in executing operation "+ oper_name + ": "+ all_errrors,"","ERROR");
            }
        }
        return false;
    }
    // ________________________________________________________________________________
    // ppr extension
    //
    public static void update_control_now (Object target) {
        AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
        if (adfFacesContext != null) {
            adfFacesContext.addPartialTarget((UIXComponent) target);
        }
    } 
    
    // ****************************************************************************** 
    // RichTableManipulations
    //
    private static FilterableQueryDescriptor getTableQueryDescriptor(RichTable tt) {
        return (FilterableQueryDescriptor)tt.getFilterModel();
    }
    
    private static Map getTableFilterCriteria(RichTable tt) {
      return getTableQueryDescriptor(tt).getFilterCriteria();
    }
    
    private static void queueTableQueryEvent(RichTable tt) {
        QueryEvent queryEvent = new QueryEvent(tt, getTableQueryDescriptor(tt) );
        // Query event should be delivered after the updates have been processed. This
        // will ensure that filter facets with input date etc are updated.
        queryEvent.setPhaseId(PhaseId.INVOKE_APPLICATION);
        tt.queueEvent(queryEvent);        
    }
    
    public static String onClearTableSearchFields(RichTable tt) {
        try{
            getTableFilterCriteria(tt).clear();
        }
        catch(NullPointerException e){
            System.out.println("ERROR in PageUtil.onClearTableSearchFields(): "+e.toString());
        }
        return null;
    }
    public static String onClearSearchField(RichTable tt, String SearchField) {
        try{
            getTableFilterCriteria(tt).remove(SearchField);
        }
        catch(NullPointerException e){
            System.out.println("ERROR in onClearSearchField(): "+e.toString());
        }
        return null;
    }

    public static String onClearTableSearchFieldsAndReexecuteQuery(RichTable tt) {
        if (tt !=null){
            try{
                getTableFilterCriteria(tt).clear();
                queueTableQueryEvent(tt);
            }
            catch(NullPointerException e){
                System.out.println("ERROR in PageUtil.onClearTableSearchFieldsAndReexecuteQuery(): "+e.toString());
            }
        }
        return null;
    }
    
    // FilteРїС—Р… must be with # as devider column and value ( NAME#Alex%)
    // filter may includes more then one if use ';' as splitter
    public static String onProgrammaticallySetFilterCriteriaAndReexecuteQuery(RichTable tt, String filters) {
        getTableFilterCriteria(tt).clear();
        String current_filter[];
        String f[]={""};
        if (filters.contains(";")) {
            f = filters.split(";");
        }
        else
        {
            f[0]=filters;
        }
        for (int i=0; i<f.length; i++)
        {
            if (f[i].contains("#")) { 
                current_filter = f[i].split("#");
                getTableFilterCriteria(tt).put(current_filter[0],current_filter[1]);
            }
        }    
        //getTableFilterCriteria(tt).put("Dname","%N%");
        //getTableFilterCriteria(tt).put("Loc","%O%");
        queueTableQueryEvent(tt);
        return null;
    } 
    public static Set<Key> getSelectedAdfRowKeys(RichTable table) {
        Set<Key> retVal = new HashSet<Key>();
        if (table!=null){
            for (Object opaqueFacesRowKey : table.getSelectedRowKeys()) {
                table.setRowKey(opaqueFacesRowKey);
                Object o = table.getRowData();
                JUCtrlHierNodeBinding rowData = (JUCtrlHierNodeBinding)o;
                if (rowData!=null){
                    //System.out.println("getSelectedAdfRowKeys >"+rowData.getRow().getKey());
                    retVal.add(rowData.getRow().getKey());
                }
            }
            table.setRowKey(null); /// Р В­РЎвЂљР В° РЎРѓРЎвЂљРЎР‚Р С•Р С”Р В° Р С•РЎвЂЎР ВµР Р…РЎРЉ Р Р†Р В°Р В¶Р Р…Р В° - Р ВµР В±Р В°Р В»РЎРѓРЎРЏ 3 Р Т‘Р Р…РЎРЏ!
        }
        return retVal;
    }
    public static Set<Key> getSelectedAdfRowKey(RichTable table) {
        Set<Key> retVal = new HashSet<Key>();
        if (table!=null){
            for (Object opaqueFacesRowKey : table.getSelectedRowKeys()) {
                table.setRowKey(opaqueFacesRowKey);
                Object o = table.getRowData();
                JUCtrlHierNodeBinding rowData = (JUCtrlHierNodeBinding)o;
                if (rowData!=null){ //System.out.println("getSelectedAdfRowKeys >"+rowData.getRow().getKey());
                    retVal.add(rowData.getRow().getKey());
                }
            }
            //table.setRowKey(null); /// Р В­РЎвЂљР В° РЎРѓРЎвЂљРЎР‚Р С•Р С”Р В° Р С•РЎвЂЎР ВµР Р…РЎРЉ Р Р†Р В°Р В¶Р Р…Р В° - Р ВµР В±Р В°Р В»РЎРѓРЎРЏ 3 Р Т‘Р Р…РЎРЏ!
            // Р СњР С• Р Р† Р Т‘Р В°Р Р…Р Р…Р С•Р С РЎРѓР В»РЎС“РЎвЂЎР В°Р Вµ - Р Р…Р Вµ Р Р…РЎС“Р В¶Р Р…Р В°, Р С—Р С•РЎвЂљР С•Р СРЎС“ РЎвЂЎРЎвЂљР С• Р Р…Р Вµ multiselect!!!
        }
        return retVal;
    }
    
    //Return ALL (!) Selected RowKey's from RichTreeTable
    public static Set<Key> getSelectedAdfRowKeys(RichTreeTable table) {
        Set<Key> retVal = new HashSet<Key>();
        if (table!=null){
            for (Object opaqueFacesRowKey : table.getSelectedRowKeys()) {
                table.setRowKey(opaqueFacesRowKey);
                Object o = table.getRowData();
                JUCtrlHierNodeBinding rowData = (JUCtrlHierNodeBinding)o;
                if (rowData!=null){
                    //System.out.println("getSelectedAdfRowKeys >"+rowData.getRow().getKey());
                    retVal.add(rowData.getRow().getKey());
                }
            }
            table.setRowKey(null); /// Р В­РЎвЂљР В° РЎРѓРЎвЂљРЎР‚Р С•Р С”Р В° Р С•РЎвЂЎР ВµР Р…РЎРЉ Р Р†Р В°Р В¶Р Р…Р В° - Р ВµР В±Р В°Р В»РЎРѓРЎРЏ 3 Р Т‘Р Р…РЎРЏ!
        }
        return retVal;
    }
    
    //Return ALL (!) Selected RowKey's from RichTreeTable
    public static Set<Key> getSelectedAdfRowKeys(UIXTree table) {
        Set<Key> retVal = new HashSet<Key>();
        if (table!=null){
            for (Object opaqueFacesRowKey : table.getSelectedRowKeys()) {
                table.setRowKey(opaqueFacesRowKey);
                Object o = table.getRowData();
                JUCtrlHierNodeBinding rowData = (JUCtrlHierNodeBinding)o;
                if (rowData!=null){
                    //System.out.println("getSelectedAdfRowKeys >"+rowData.getRow().getKey());
                    retVal.add(rowData.getRow().getKey());
                }
            }
            table.setRowKey(null); /// Р В­РЎвЂљР В° РЎРѓРЎвЂљРЎР‚Р С•Р С”Р В° Р С•РЎвЂЎР ВµР Р…РЎРЉ Р Р†Р В°Р В¶Р Р…Р В° - Р ВµР В±Р В°Р В»РЎРѓРЎРЏ 3 Р Т‘Р Р…РЎРЏ!
        }
        return retVal;
    }
    
    //Return ONE (!) Selected RowKey from RichTreeTable
    public static Set<Key> getSelectedAdfRowKey(RichTreeTable table) {
        Set<Key> retVal = new HashSet<Key>();
        if (table!=null){
            for (Object opaqueFacesRowKey : table.getSelectedRowKeys()) {
                table.setRowKey(opaqueFacesRowKey);
                Object o = table.getRowData();
                JUCtrlHierNodeBinding rowData = (JUCtrlHierNodeBinding)o;
                if (rowData!=null){ //System.out.println("getSelectedAdfRowKeys >"+rowData.getRow().getKey());
                    retVal.add(rowData.getRow().getKey());
                }
            }
            //table.setRowKey(null); /// Р В­РЎвЂљР В° РЎРѓРЎвЂљРЎР‚Р С•Р С”Р В° Р С•РЎвЂЎР ВµР Р…РЎРЉ Р Р†Р В°Р В¶Р Р…Р В° - Р ВµР В±Р В°Р В»РЎРѓРЎРЏ 3 Р Т‘Р Р…РЎРЏ!
            // Р СњР С• Р Р† Р Т‘Р В°Р Р…Р Р…Р С•Р С РЎРѓР В»РЎС“РЎвЂЎР В°Р Вµ - Р Р…Р Вµ Р Р…РЎС“Р В¶Р Р…Р В°, Р С—Р С•РЎвЂљР С•Р СРЎС“ РЎвЂЎРЎвЂљР С• Р Р…Р Вµ multiselect!!!
        }
        return retVal;
    }
    public static void MessToUser(String mess, UIXComponent component)
    {
       FacesContext context = FacesContext.getCurrentInstance();
       FacesMessage message = new FacesMessage(mess);
       context.addMessage(component.getClientId(context), message);
    }
    
    public static void message(String mes_text, String detail_text, String type_str){
        FacesContext fctx = FacesContext.getCurrentInstance();
         FacesMessage fmessage = new FacesMessage(mes_text);
         fmessage.setDetail(detail_text);
         if (type_str.toUpperCase()=="FATAL"){
             fmessage.setSeverity(fmessage.SEVERITY_FATAL);
         }
         else if (type_str.toUpperCase()=="WARN"){
            fmessage.setSeverity(fmessage.SEVERITY_WARN);
         }
         else if (type_str.toUpperCase()=="ERROR"){
            fmessage.setSeverity(fmessage.SEVERITY_ERROR);
         }
         else{
            fmessage.setSeverity(fmessage.SEVERITY_INFO);
         }
         fctx.addMessage(null, fmessage);
    }
    
    public static void showPopup(RichPopup popup, ActionEvent event, String type_oper) 
    {
      FacesContext context = FacesContext.getCurrentInstance();
        String alignId =null;
      if (event!=null){
          UIComponent source = (UIComponent) event.getSource();
          if (source!=null){
            alignId = source.getClientId(context);
          }
      }
      String popupId = popup.getClientId(context);
        
      StringBuilder script = new StringBuilder();
      script.append("var popup = AdfPage.PAGE.findComponent('").append(popupId).append("'); ")
            .append("if (!popup.isPopupVisible()) { ")
            .append("var hints = {}; ");
          if (alignId!=null){
            script.append("hints[AdfRichPopup.HINT_ALIGN_ID] = '").append(alignId).append("'; ") 
            .append("hints[AdfRichPopup.HINT_ALIGN] = AdfRichPopup.ALIGN_AFTER_START; ");
          }
      script.append("popup.show(hints);}");
      addScript(script.toString());
      // Setting operation type ...
      popup.setEventContext(type_oper);
    }
    /* WARNING!!!
     * Currently only AdfRichPopup.ALIGN_START_AFTER, 
     *                AdfRichPopup.ALIGN_BEFORE_START 
     *            and AdfRichPopup.ALIGN_END_BEFORE are supported */
    public static void showPopup(RichPopup popup, UIComponent source, String type_oper, String align_hint) 
    {
        FacesContext context = FacesContext.getCurrentInstance();
        String alignId = null;
        if (source!=null){
            alignId = source.getClientId(context);
        }
        String popupId = popup.getClientId(context);
        StringBuilder script = new StringBuilder();
        script.append("var popup = AdfPage.PAGE.findComponent('").append(popupId).append("'); ")
                .append("if (!popup.isPopupVisible()) { ")
                .append("var hints = {}; ");
        if (alignId!=null){
          script.append("hints[AdfRichPopup.HINT_ALIGN_ID] = '").append(alignId).append("'; ") 
              .append("hints[AdfRichPopup.HINT_ALIGN] = AdfRichPopup."+(align_hint==null ? "ALIGN_AFTER_START" : align_hint) +"; ");
        }
        script.append("popup.show(hints);}");
      addScript(script.toString());
      // Setting operation type ...
      popup.setEventContext(type_oper);
    }
    
    public static void hidePopup(RichPopup popup) 
    {
      FacesContext context = FacesContext.getCurrentInstance();
      String popupId = popup.getClientId(context);
      StringBuilder script = new StringBuilder();
      script.append("var popup = AdfPage.PAGE.findComponent('").append(popupId).append("'); ")
            .append("if (popup.isPopupVisible()==true) { ")
            .append("popup.hide();}");
      addScript(script.toString());
    }
    
    public static void addScript(String script_str){
        ExtendedRenderKitService erks = Service.getRenderKitService(FacesContext.getCurrentInstance(), ExtendedRenderKitService.class);
        StringBuilder strb = new StringBuilder(script_str);
        erks.addScript(FacesContext.getCurrentInstance(),strb.toString());
    }
    
    // Р вЂ™РЎвЂ№Р В·Р С•Р Р† task-flow Р Р† Р С•РЎвЂљР Т‘Р ВµР В»РЎРЉР Р…Р С•Р С Р С•Р С”Р Р…Р Вµ 
    // (РЎвЂЎРЎвЂљР С•Р В±РЎвЂ№ РЎРЊРЎвЂљР С• Р В±РЎвЂ№Р В»Р С• Р Р†Р С•Р В·Р СР С•Р В¶Р Р…Р С• Р Р…Р ВµР С•Р В±РЎвЂ¦Р С•Р Т‘Р С‘Р СР С• Р Р† РЎРѓР Р†Р С•Р в„–РЎРѓРЎвЂљР Р†Р В°РЎвЂ¦ task flow Р Р†РЎвЂ№РЎРѓРЎвЂљР В°Р Р†Р С‘РЎвЂљРЎРЉ Р Р† URL invoke="url-invoke-allowed" )
    
    public static void launchTFWindow(String taskflowId, String taskflowDocument, Map<String, Object> params) {
            //final String taskflowId="spy-TF";
            //final String taskflowDocument="/WEB-INF/spy-TF-definition.xml";
            FacesContext fctx = FacesContext.getCurrentInstance();
            //String rowKeyString = rwKey;
            //task flow parameters can be passed as input arguments configured on a task flow
            //call activity or ADFregion, or they can be provided in a hash map
            //Map<String, Object> params = new HashMap<String, Object>();
            //params.put("rowKey",rowKeyString);
            String taskflowURL = ControllerContext.getInstance().getTaskFlowURL(false,new TaskFlowId(taskflowDocument,taskflowId),params);
            /*ExtendedRenderKitService erks = Service.getRenderKitService(fctx, ExtendedRenderKitService.class);
            StringBuilder script = new StringBuilder();
            script.append("window.open(\""+taskflowURL+"\");");
            erks.addScript(FacesContext.getCurrentInstance(), script.toString());*/
            addScript("window.open(\""+taskflowURL+"\");");
    } 
    public static void launchTFWindow(String taskflowURL) {
            addScript("window.open(\""+taskflowURL+"\");");
    } 
    
    public static void openNewWindowAsDialog(String page, Integer width, Integer height){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ViewHandler viewHandler = facesContext.getApplication().getViewHandler();
        StringBuilder strBuilder = new StringBuilder();
        UIViewRoot dialog = viewHandler.createView(facesContext, strBuilder.append("/"+page).toString());
        Map properties = new HashMap();
        properties.put("width", Integer.valueOf(width));
        properties.put("height", Integer.valueOf(height));
        AdfFacesContext afContext = AdfFacesContext.getCurrentInstance();
        afContext.launchDialog(dialog, null, null, true, properties);    
    }
    
    public static void refreshCurrentPage() {
        FacesContext context = FacesContext.getCurrentInstance();
        String currentView = context.getViewRoot().getViewId();
        ViewHandler vh = context.getApplication().getViewHandler();
        UIViewRoot x = vh.createView(context, currentView);
        context.setViewRoot(x);
    }
    
    public static void redirecttonewURL (String url){
        ExternalContext ectx = FacesContext.getCurrentInstance().getExternalContext();  
        //FacesContext.getCurrentInstance().getViewRoot().
      
        HttpServletResponse response = (HttpServletResponse)ectx.getResponse();  
        //String url = ectx.getRequestContextPath()+"/adfAuthentication?logout=true&end_url=/faces/start.jspx";  
        try {  
          response.sendRedirect(url);  
        } catch (Exception ex) {  
          ex.printStackTrace();  
        }    
    }
  private static ResourceBundle getBundle() {
         FacesContext ctx =  FacesContext.getCurrentInstance();
         UIViewRoot uiRoot = ctx.getViewRoot();
         Locale locale = uiRoot.getLocale();
         ClassLoader ldr = Thread.currentThread().getContextClassLoader();
         return ResourceBundle.getBundle(ctx.getApplication().getMessageBundle(), 
                                         locale, ldr);
     }

  public static String getStringFromBundle(String key) {
        ResourceBundle bundle = getBundle();
        return getStringSafely(bundle, key, null);
    }
  private static String getStringSafely(ResourceBundle bundle, String key, 
                                            String defaultValue) {
          String resource = null;
          try {
              resource = bundle.getString(key);
          } catch (MissingResourceException mrex) {
              if (defaultValue != null) {
                  resource = defaultValue;
              } else {
                  resource = "NO_RESOURCE_FOUND" + key;
              }
          }
          return resource;
      }
  public static String getStringFromBundle(String boundlePath, String key ) {
      ResourceBundle bundle = BundleFactory.getBundle(boundlePath);
      return getStringSafely(bundle, key, null);
      //System.out.println(getStringFromBundle("b2b.personalcabinet.ui.PersonalCabinetUIBundle","PC_PF_INPUT_MESSAGES"));
  }
}