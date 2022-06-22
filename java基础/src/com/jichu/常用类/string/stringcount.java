package com.jichu.常用类.string;

import org.junit.Test;
//短的字符串在长的字符串中出现的次数
public class stringcount {
    @Test
    public void st(){
        String a = "asdfdsfkladwiegjlkadssadssssadljlkjladhljlkad";
        String b = "ad";
        System.out.println(countTest(a,b));
    }


    public int countTest(String mainStr, String inStr){
        int ml = mainStr.length();
        int il = inStr.length();
        int count = 0;
        int k = 0 ;
        if (ml >= il){
                while (mainStr.indexOf(inStr,k)!=-1){
                    k = mainStr.indexOf(inStr,k);
                    k +=inStr.length();
                    count++;
                }
            }
        return count;
    }

}
