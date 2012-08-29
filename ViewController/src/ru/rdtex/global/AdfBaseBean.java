package ru.rdtex.global;


import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.jbo.AttributeDef;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.server.DBTransaction;

import weblogic.servlet.security.ServletAuthentication;


/**
 <pre>
 * Базовый класс для всех бинов в системе.
 * Должен содержать функциональность, используемую более чем в одном бине.
 * Везде доступен через rcoreBaseBean (определено в проекте Components)
 * Пример:
 * &lt;trh:script text="{rcoreBaseBean.textByResource['/META-INF/adf/js/jquery.js']}" id="s1"/&gt;
 </pre>
 */
public class AdfBaseBean
{
  public String getWindowBasePath() {
    StringBuffer rc = new StringBuffer("window.basePath = ").append("'").append(getBasePath()).append("';");
    return rc.toString();
  }
  
  public String getBasePath() {
    return getBasePath(getRequest());
  }
  public String getServerBasePath() {
    return getServerBasePath(getRequest());
  }
  
  public static String getBasePath(HttpServletRequest request) {
    String path = request.getContextPath(); // '/cdu'
    String basePath =
      request.getScheme() + "://" + request.getServerName() + ":" +
      request.getServerPort() + path + "/";
    return basePath;
  }
  
  public static String getServerBasePath(HttpServletRequest request) {
    String basePath =
      request.getScheme() + "://" + request.getServerName() + ":" +
      request.getServerPort() + "/";
    return basePath;
  }
  
  public static void printViewObject(ViewObject vo) {
    AttributeDef[] attrs = vo.getAttributeDefs();
    StringBuffer buf = new StringBuffer();
    while (true) {
      Row row = vo.next();
      if (row == null) {
        break;
      }
      System.out.println("*** printViewObject begin");
      for (int i = 0; i < attrs.length; i++) {
        AttributeDef def = attrs[i];
        buf.setLength(0);
        String name = def.getName();
        buf.append("  ").append(name).append(" = ").append(row.getAttribute(name));
        System.out.println(buf.toString());
      }
      System.out.println("*** printViewObject end");
    } // while
  }
  
  public static Map<String, Object> row2map(Row row) {
    Map<String, Object> rc = new HashMap<String, Object>();
    if (row == null) {
      return rc;
    }
    String[] attrs = row.getAttributeNames();
    for (String attr : attrs) {
      Object value = row.getAttribute(attr);
      rc.put(attr, value);
    }
    return rc;
  }
  
  public static String getCurrentViewId() {
    String currentViewId =
      FacesContext.getCurrentInstance().getViewRoot().getViewId();
    return currentViewId;
  }
  
  public static javax.faces.component.UIViewRoot getViewRoot() {
    javax.faces.component.UIViewRoot rc =
      FacesContext.getCurrentInstance().getViewRoot();
    return rc;
  }

  public String getSessionId() {
    HttpSession session = getSession();
    String rc = session.getId();
    return rc;
  }

  public static HttpSession getSession() {
    FacesContext context = FacesContext.getCurrentInstance();
    if (context == null)
      return null;
    Object session = context.getExternalContext().getSession(true);
    return (HttpSession)session;
  }
  
  public static ServletContext getApplication() 
  {
    javax.faces.context.ExternalContext ex = javax.faces.context.FacesContext.getCurrentInstance().getExternalContext();
    ServletContext rc = (ServletContext)ex.getContext();
    return rc;
  }


  public static String getServerPath(HttpServletRequest request) {
    String basePath =
      request.getScheme() + "://" + request.getServerName() + ":" +
      request.getServerPort() + "/"; // + path + "/";
    return basePath;
  }

  public String getServerPath() {
    HttpServletRequest request = getRequest();
    String basePath =
      request.getScheme() + "://" + request.getServerName() + ":" +
      request.getServerPort() + "/"; // + path + "/";
    return basePath;
  }

  public static HttpServletRequest getRequest() {
    HttpServletRequest req = null;
    try {
      FacesContext context = FacesContext.getCurrentInstance();
      Object request = context.getExternalContext().getRequest();
      req = (HttpServletRequest)request;
    }
    catch (Throwable ex) {
      ;
    }
    return req;
  }
  public static HttpServletResponse getResponse() {
    HttpServletResponse res = null;
    try {
      FacesContext context = FacesContext.getCurrentInstance();
      Object request = context.getExternalContext().getResponse();
      res = (HttpServletResponse)request;
    }
    catch (Throwable ex) {
      ;
    }
    return res;
  }

  public double __getBrowserVersion(String appVersion)
  {
    try {
      int index1 = appVersion.indexOf("MSIE ");
      if (index1 < 0) {
        return 8.0;
      }
      int index2 = appVersion.indexOf(";", index1);
      if (index2 < 0) {
        return 8.0;
      }
      String sVer = appVersion.substring(index1 + 5, index2);
      sVer = sVer.trim();
      Double rc = Double.parseDouble(sVer);
      return rc;
    }
    catch (Throwable ex) {
      ex.printStackTrace();
      return 8.0;
    }
  } // public double __getBrowserVersion(String appVersion)

  public static UIComponent findComponentParentByClassName(UIComponent child,
                                                           String parentClassName) 
  {
    UIComponent rc = null;
    UIComponent parent = child;
    while (true) {
      if (parent == null) {
        break;
      }
      if (parent.getClass().getName().equals(parentClassName)) {
        rc = parent;
        break;
      }
      parent = parent.getParent();
    } // while
    return rc;
  } // public static UIComponent findComponentParentByClassName
  
  public static UIComponent findComponent(String id) {
    UIViewRoot root = getViewRoot();
    UIComponent rc = findComponent(root, id);
    return rc;
  }
  
  /**
   * Рекурсивный поиск
   * @param parent
   * @param id
   * @return Найденный компонент или null
   */
  private static UIComponent findComponent(UIComponent parent, String id) {
    if (parent == null) {
      return null;
    }
    String idParent = parent.getId();
    if (id.equals(idParent)) {
      return parent;
    }
    //----------------------------
    List<UIComponent> childs = parent.getChildren();
    for (UIComponent child : childs) {
      UIComponent item = findComponent(child, id);
      if (item != null) {
        return item;
      }
    }
    return null;
  } // private static UIComponent findComponent

  public static void setNotEditableComponent(UIComponent root) {
    setNotEditableComponentOne(root);
    Iterator<UIComponent> iter = root.getFacetsAndChildren();
    while (iter.hasNext()) {
      UIComponent item = iter.next();
      setNotEditableComponent(item);
    }
  }

  private static void setNotEditableComponentOne(UIComponent root) {
    // TODO
  }
  
  
  public static UIComponent getRoot(UIComponent child) {
    UIComponent rc = child;
    if (rc == null) {
      return null;
    }
    while (true) {
      UIComponent parent = rc.getParent();
      if (parent == null) {
        break;
      }
      rc = parent;
    } // loop
    return rc;
  }
 

  
  public static void addPartialTarget(UIComponent comp) 
  {
    AdfFacesContext context = AdfFacesContext.getCurrentInstance();
    context.addPartialTarget(comp);
    //-------------------------------------------
  }
  //--------------

  public static String getBrowser() 
  {
    /*
     * FireFox - Mozilla/5.0 (Windows NT 6.1; WOW64; rv:9.0) Gecko/20100101 Firefox/9.0'
     * IE8 - Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Trident/4.0; .NET CLR 1.1.4322)
     * IE9 - Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.1; WOW64; Trident/5.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; .NET4.0C; .NET4.0E)
     */
    HttpServletRequest request = getRequest();
    String rc = request.getHeader("User-Agent");
    return rc;
  }
  
  public static boolean isFireFox() 
  {
    String ua = getBrowser();
    boolean isFirefox = ( ua != null && ua.indexOf( "Firefox/" ) != -1 );
    return isFirefox;
  }
  public static boolean isIE() 
  {
    String ua = getBrowser();
    boolean isMSIE = ( ua != null && ua.indexOf( "MSIE" ) != -1 );
    return isMSIE;
  }
  
  public static boolean isIE8Browser()
  {
    boolean rc = false;
    if (isIE())
    {
      String ua = getBrowser();
      if (ua.toUpperCase().contains("MSIE 8.0"))
      {
        rc = true;
      }
      else
      {
        if (ua.toUpperCase().contains("MSIE 7.0"))
        {
          if (ua.toUpperCase().contains("TRIDENT/4.0"))
          {
            rc = true;
          }
        }
      }
    }
    return rc;
  }
  public boolean getisIE8Browser() 
  {
    return isIE8Browser();
  }
  public static String getCookieValue(String name) 
  {
    HttpServletRequest request = getRequest();
    Cookie[] list = request.getCookies();
    String rc = null;
    for (Cookie item : list) 
    {
      if (item.getName().equals(name)) 
      {
        rc = item.getValue();
        break;
      }
    }
    return rc;
  }
  
  public boolean webcenterLogout() 
  {
    boolean isLogout = ServletAuthentication.logout(getRequest());
    if (isLogout) 
    {
      System.out.println("Успешный logout");
    }
    else 
    {
      System.err.println("Не успешный logout");
    }
    return isLogout;
  }
  
  public static long getNextSeq(DBTransaction trans, String seq) throws SQLException
  {
    long rc = 1;
    String sql = "SELECT " + seq + ".NEXTVAL val FROM dual";
    Statement st = trans.createStatement(1);
    ResultSet rs = st.executeQuery(sql);
    while (rs.next())
    {
      rc = rs.getInt("val");
      break;
    }
    return rc;
  }
  
  public Date getCurrentDate()
  {
    Date rc = new Date();
    return rc;
  }
  public Date getYesterdayDate() // Вчерашняя дата
  {
    Date rc = new Date();
    long newLong = rc.getTime() - (24 * 60 * 60 * 1000);
    rc = new Date(newLong);
    return rc;
  }

}

