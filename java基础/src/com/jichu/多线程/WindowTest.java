package com.jichu.多线程;

public class WindowTest {
    public static void main(String[] args) {
    Window ww =  new Window();
    Window ww2 =  new Window();
    Window ww3 =  new Window();
    ww.start();
    ww2.start();
    ww3.start();
    }
}

class Window extends Thread{
    static int ticket = 100;
    @Override
    public void run(){
        while( true ){
            if(ticket>0){
            System.out.print(ticket--+" ");
            }else {
                break;
            }
        }
    }

}