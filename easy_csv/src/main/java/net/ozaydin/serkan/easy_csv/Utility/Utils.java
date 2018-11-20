package net.ozaydin.serkan.easy_csv.Utility;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static String withCommaAsString(String value){
        return "\"" +value+"\"";
    }

    public static List<String> withCommaAsList(List<String> stringList){
        List<String> strings=new ArrayList<>();

        for(String value:stringList){
            strings.add(withCommaAsString(value));
        }
        return strings;
    }



    public static List<String> separatorReplace(String separatorColumnSign,String separatorLineSign,List<String> stringList){
        List<String> strings=new ArrayList<>();

        for(String value:stringList){
            strings.add(value.replace(separatorColumnSign,",").replace(separatorLineSign,"\r\n"));
        }
        return strings;
    }



}
