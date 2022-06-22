package com.jichu.常用类.string;

import org.junit.Test;

//返回小字符串与大字符串中的最大相同字段
public class MaxString {
    @Test
    public void maxTest(){
        String a = "abcdefghijklmn";
        String b = "efgshijxaalmn";
        System.out.println(maxString(a,b));
    }


    public String maxString(String string1,String string2){
        String maxString = (string1.length() >= string2.length()) ? string1:string2;
        String minString = (string1.length() < string2.length()) ? string1:string2;
        if(string1 != null || string2 != null ){
            for (int i = 0; i <minString.length() ; i++) {
                String value = minString.substring(i,minString.length()+0);
                for (int k = value.length(); k>i+1; k--){
                    String value2 = value.substring(i,k);
                    if(maxString.contains(value2) & value2!=null){
                        return value2;
                    }
                }
            }
        }

        return "参数为空";
    }
}
