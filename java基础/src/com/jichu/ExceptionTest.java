package com.jichu;

public class ExceptionTest {
    public static void main(String[] args) {
        int[] b = new int[10];
        int a = -100;
        try {
            exceptionTest1(a);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    //    public static void exceptionTest1() throws NumberFormatException {
//        String s = "abv";
//        Integer integer = Integer.parseInt(s);
//    }
    public static void exceptionTest1(int a) throws NumberFormatException {
        if (a >= 0) {
            System.out.println("aa");
        } else {
            throw new NumberFormatException("数字异常");
        }
    }
}
