package com.yang.fankonghui;


enum ServiceStatus{
    START,RUNNING,CLOSE;
    private ServiceStatus(){
        System.out.println("it is service running status");
    }
}
public class Test03 {
    public static void main(String[] args) {
        System.out.println(ServiceStatus.RUNNING);
        //it is service running status
        //it is service running status
        //it is service running status
        //RUNNING
    }
}
