package com.example.demo;

/**
 * @author why
 * @date 2021/9/18 17:19
 * @PackageName com.example.demo
 * @description
 */
public class Test02 {
    class Res {
        public String userName;
        public char sex;
        public boolean flag = false;
    }

    class InputThread extends Thread {
        private Res res;

        //输入线程
        public InputThread(Res res) {
            this.res = res;
        }

        @Override
        public void run() {
            int count = 0;
            while (true) {
                synchronized (res) {
                    if(res.flag){
                        try {
                            //输入线程主动释放锁，同时阻塞该线程
                            res.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (count == 0) {
                        res.userName = "余胜军";
                        res.sex = '男';
                    } else {
                        res.userName = "小薇";
                        res.sex = '女';
                    }
                    //输出线程输出值
                    res.flag = true;
                    //唤醒输出线程
                    res.notify();
                }
                count = (count + 1) % 2;

            }

        }
    }

    //输出线程
    class OutPutThread extends Thread {
        private Res res;

        public OutPutThread(Res res) {
            this.res = res;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (res) {
                    if (!res.flag) {
                        try {
                            //输出线程主动释放锁，同时阻塞该线程
                            res.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(res.userName + "," + res.sex);
                    //输出完毕，交给输入线程继续输入
                    res.flag = false;
                    //唤醒输入线程
                    res.notify();
                }

            }

        }
    }

    public static void main(String[] args) {
        new Test02().print();
    }

    public void print() {
        Res res = new Res();
        InputThread inputThread = new InputThread(res);
        OutPutThread outPutThread = new OutPutThread(res);
        inputThread.start();
        outPutThread.start();
    }


}
