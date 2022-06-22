package com.jichu.常用类.java比较器;

import java.util.Arrays;
//顺序排序
public class ComparAbleTest {
    public static void main(String[] args) {
        Goods[] arr = new Goods[4];
        arr[0] = new Goods("红楼梦",80);
        arr[1] = new Goods("三国演义",120);
        arr[2] = new Goods("西游记",90);
        arr[3] = new Goods("水浒传",100);

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
