package com.yang.aduoxiancheng;

/**
 * @Author: yang
 * @Date: 2020-03-05 21:54
 * @Description: 创建多线程
 * <p>
 * 多个线程在一个进程中 有多条执行路径 目的是为了程序的执行效率
 * 在一个线程中一定会有哪个线程：一定会有主线程 如果连主要的线程都没有 怎么执行程序呢
 * 创建线程的方式：继承thread类 重写run方法 实现runnable接口
 */
class Demo01 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("子线程执行" + i);
        }
    }
}
class Demo02 implements Runnable {

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Runnable子线程执行" + i);
        }
    }
}
//使用匿名内部类创建线程
class Demo03 {
    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            public void run() {
                System.out.println("使用匿名内部类创建线程");
            }
        });
        thread.start();


    }
}

public class CreateThread {

    //应用场景迅雷多任务下载 分批发送祝福短信
    //数据库批量插入大量的数据 ES数据库初始化大量的数据
    //每个线程之间互相不影响

    public static void main(String[] args) {

        System.out.println("主线程执行");
        Demo01 demo01 = new Demo01();
        demo01.start();//启动线程
        for (int i = 0; i < 10; i++) {
            System.out.println("主线程main执行" + i);
        }


        Demo02 demo02 = new Demo02();
        Thread thread = new Thread(demo02);
        thread.start();
    }


}

class Testt {

    static Testt t = new Testt();

    class T1 extends Thread {
        public T1(String name) {
            super(name);
        }

        @Override
        public void run() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //T3线程中要处理的东西
            System.out.println("T1线程执行");
            for (int i = 0; i < 10; i++) {
                System.out.println(this.getName() + ":" + i);
            }
        }
    }

    class T2 extends Thread {
        public T2(String name) {
            super(name);
        }

        @Override
        public void run() {
            //T3线程中要处理的东西
            System.out.println("T2线程执行");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(this.getName() + ":" + i);
            }
        }
    }

    class T3 extends Thread {
        public T3(String name) {
            super(name);
        }

        @Override
        public void run() {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //T3线程中要处理的东西
            System.out.println("T3线程执行");
            for (int i = 0; i < 10; i++) {
                System.out.println(this.getName() + ":" + i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T3 t3 = t.new T3("T3");
        t3.start();//启动t3线程
        t3.join();//阻塞主线程，执行完t3再返回

        T2 t2 = t.new T2("T2");
        t2.start();//启动t3线程
        t2.join();//阻塞主线程，执行完t3再返回

        T1 t1 = t.new T1("T1");
        t1.start();//启动t3线程
        //t1.join();//阻塞主线程，执行完t3再返回

    }
}