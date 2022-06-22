package com.jichu.常用类.java比较器;

public class Goods implements Comparable{
   private String name;
   private double price;

    @Override
    public int compareTo(Object o) {
        if (o instanceof Goods){
            Goods other = (Goods) o;
            if (this.price > other.price){
                return 1;
            }else if (this.price < other.price){
                return -1;
            }else
                return this.name.compareTo(other.name);
            //    return 0;
        }
        throw new RuntimeException("参数异常");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Goods() {
    }

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
