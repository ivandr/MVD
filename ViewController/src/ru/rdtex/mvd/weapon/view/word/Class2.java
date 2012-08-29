package ru.rdtex.mvd.weapon.view.word;

import java.io.UnsupportedEncodingException;

import java.net.URLDecoder;

import java.net.URLEncoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import oracle.jbo.server.ViewObjectImpl;

import ru.rdtex.global.ADFUtils;
import ru.rdtex.global.utils.Resource;
import ru.rdtex.global.utils.StringFunc;
import ru.rdtex.mvd.weapon.model.am.AppModuleImpl;

public class Class2 {
    public Class2() {
        super();
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        test7();
    }
    
    private static void hash() {
        Map iters = new HashMap();
        iters.put("RPersonGunsView1", "111");
        iters.put("RPersonGunsView2", "null");
        if (iters.get("RPersonGunsView1") == null) System.out.println(iters.get("RPersonGunsView1"));
        if (iters.get("RPersonGunsView2") == null) System.out.println(iters.get("RPersonGunsView2"));
        if (iters.get("RPersonGunsView") == null) System.out.println(iters.get("RPersonGunsView"));
        
    }
    
    private static void ok1() {
        String person_card = "<p><b>Место рождения</b> {<span lang=EN-US style='mso-ansi-language:EN-US'>asdasda</span>BirthAdr<span\n" + 
        "lang=EN-US style='mso-ansi-language:EN-US'>zsdasd</span>}</p>";
        //        person_card = person_card.replaceAll("\\{(\t\n\x0B\f\r|\s)*BirthAdr(.|\s)*\\}", "rrr");
        String pattern = "\\{(.|\\t|\\n|\\f|\\r)*BirthAdr(.|\\t|\\n|\\f|\\r)*\\}";
        System.out.println(person_card);
        System.out.println(pattern);
        person_card = person_card.replaceAll(pattern, "rrr");
        System.out.println(person_card);
    }

    private static void test3() {
        Pattern p = Pattern.compile("1*0");
        Matcher m = p.matcher("11111111111110_aaaa");
        String out = m.replaceAll("rrrrr");
        //boolean b = m.matches(); 
        System.out.println(out);
    }
    private static void test4() {
        final String person_card0 = Resource.getResourceString(Resource.class, 
                                                             "/doc_temps/PERSON_FL.doc");
        String person_card = person_card0;
        Pattern p = Pattern.compile("\\{(.|\\n)*TitleSurname(.|\\n)*\\}");
        Matcher m = p.matcher(person_card);
        String out = m.replaceAll("rrrrr");
        //String out = m.replaceAll("rrrrr");
        System.out.println(out);
    }
    private static void test5_ok() {
        
//        final String person_card0 = Resource.getResourceString(Resource.class, 
//                                                             "/doc_temps/PERSON_FL.doc");
        final String person_card0 = "{ aaa Id }_123_{Id}_456_{Id}";
        String person_card = person_card0;
        String[] ctrl = new String[31];
        String[] repl = new String[31];
        for (int i=0; i < ctrl.length; i++ ) {
            ctrl[i] = ((char)(i))+"";
            repl[i] = "@@@@@@@@_"+i+"_";
        }
        person_card = StringFunc.replace(person_card, ctrl, repl);
        //String pattern = "(.*)(\\{(.)*Id(.)*\\})(.*)";
        String pattern = "\\{([^\\{])*Id([^\\}])*\\}";
        person_card = person_card.replaceAll(pattern,"A_B");
        person_card = StringFunc.replace(person_card, repl, ctrl);
        System.out.println(person_card);
        
        
        
                     
        //System.out.println(person_card);
        
        
        //person_card = StringFunc.replace(person_card, "\r", "");
            //person_card.replace("\r", "");
        //String pattern = "\\{(.|\\t|\\n|\\f)*Id(.|\\t|\\n|\\f)*\\}";
        //String out = person_card.replaceAll(pattern,"rrrrr");
        //System.out.println(out);
    }
    
    private static void test6() {
        
        //final String person_card0 = Resource.getResourceString(Resource.class, "/doc_temps/КАРТОЧКА_ФЛ.doc");
        final String person_card0 = "123_{фвфывTitleSurnameфывфыв}_456_{Id}";
        String person_card = person_card0;
        
        String pattern = "\\{([^\\{])*TitleSurname([^\\}])*\\}";
        person_card = person_card.replaceAll(pattern,"AAA_BBB");
        
        System.out.println(person_card);
        
        
        
                     
        //System.out.println(person_card);
        
        
        //person_card = StringFunc.replace(person_card, "\r", "");
            //person_card.replace("\r", "");
        //String pattern = "\\{(.|\\t|\\n|\\f)*Id(.|\\t|\\n|\\f)*\\}";
        //String out = person_card.replaceAll(pattern,"rrrrr");
        //System.out.println(out);
    }
    
    private static void test7() {
        
        final String person_card0 = Resource.getResourceString(Resource.class, "/doc_temps/КАРТОЧКА_ФЛ.doc");
//        final String person_card0 = "Место рождения {RBirthAdr}\n" + 
//        "Домашний адрес {EntAddressesViewStrAdrs}\n" + 
//        "дом. тел. {EntAddressesViewPhone}о/м {EntAddressesViewPolice}\n" + 
//        "Паспортные данные: Серия {RDocSer} № {RDocNum}\n" + 
//        "Кем выдан {RDocOrg} Дата {RDocDate}\n" + 
//        "iterStart\n" + 
//        "Оружие  ({RPersonGunsViewState}):  {RPersonGunsViewModelTitle} { RPersonGunsViewCalibrCode} \n" + 
//        "Серия:    №:  {RPersonGunsViewSeries}  Год выпуска:  {RPersonGunsViewMakeYear}\n" + 
//        "Документ( {RGunDocumentsViewLicstatCode} ):  {RGunDocumentsViewDdcId}  Серия:  {RGunDocumentsViewDocSeries}  №:  {RGunDocumentsViewDocNumb}\n" + 
//        "Дата выдачи:  {RGunDocumentsViewDocDate}  Дата окончания:  {RGunDocumentsViewEndDate}\n" + 
//        "iterEnd\n";
        String person_card = person_card0;
        System.out.println(person_card);
        String pattern = "iterStart([^\\t])*iterEnd";
        
        int i = person_card.indexOf("RPersonGunsViewStart");
        int j = person_card.indexOf("RPersonGunsViewEnd", i);
        int l = "RPersonGunsViewEnd".length();
        String text = person_card.substring(i,j+l);
        System.out.println(i);
        System.out.println(j);
        System.out.println(text);
    }

}
