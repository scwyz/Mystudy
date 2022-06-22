package com.jichu.常用类.java比较器;

import java.util.Arrays;
import java.util.Comparator;

//定制排序
public class ComparatorTest {
    public static void main(String[] args) {
        Goods[] arr = new Goods[5];
        arr[0] = new Goods("红楼梦", 80);
        arr[1] = new Goods("三国演义", 120);
        arr[2] = new Goods("西游记", 90);
        arr[3] = new Goods("水浒传", 100);
        arr[4] = new Goods("三国演义", 110);
        Arrays.sort(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Goods && o2 instanceof Goods) {
                    Goods g1 = (Goods) o1;
                    Goods g2 = (Goods) o2;
                    return -g1.getName().compareTo(g2.getName());
                } else {
                    throw new RuntimeException("参数类型异常");
                }

            }
        });
        System.out.println(Arrays.toString(arr));
    }
}
