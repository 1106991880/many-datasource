package com.yang.shejimoshi.mubanfangfa;

/**
 * @Author: yang
 * @Date: 2020-03-18 22:38
 * @Description: 模板方法设计模式
 */
//短信模板
public abstract class MsgTemplate {

    public  void  sendMsg(){
        //开始日志
        addHeadLog();
        //调用不同的运营商发送
        httpRequest();
        //结束日志报文
        addFootLog();
    }

    private void addFootLog() {
        System.out.println("调用运营商结束");
    }

    public abstract void httpRequest();

    private void addHeadLog() {
        System.out.println("调用运营商开始");
    }
}
