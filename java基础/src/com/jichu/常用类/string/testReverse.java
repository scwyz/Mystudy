package com.jichu.常用类.string;

import org.junit.Test;

public class testReverse {
    //将字符串abefgmq中efg反转
    @Test
    public void testReverse2(){
        String ss = "abefgmq";
        String sss = reverse1(ss,2,4);
        System.out.println(sss);
        System.out.println(ss.indexOf("fq"));
    }

    public String reverse1(String s , int startInt , int endInt){
        if (s != null){
            char[] cr = s.toCharArray();

            for (int i = startInt, k = endInt; i < k ; i++,k--){
                char change = cr[i];
                cr[i] = cr[k];
                cr[k] = change;
            }
            return new String(cr);
        }
       return null;
    }

}
