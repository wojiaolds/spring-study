package test;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//使用lock和Condition，更加灵活
public class LockPrint {
    public volatile static ArrayList <Character> list = null;
    private static volatile int count = 0;
    private static int len = 0;
    private Lock lock = new ReentrantLock();
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    Condition c3 = lock.newCondition();
    Condition c4 = lock.newCondition();
    Thread t1 = new Thread(new Runnable() {

        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();
                    if(count == (len-1)*4+1) break;
                    while (count % 4 != 0) {
//                        System.out.println("A wait ");
                        c1.await();
                    }
//                    System.out.print("A");
                    list.add('A');
                    count++;
                    c2.signal();// 唤醒条件2
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

        }
    });
    Thread t2 = new Thread(new Runnable() {

        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();
                    if(count == (len-1)*4 + 2 ) break;
                    while (count % 4 != 1) {
//                        System.out.println("B wait ");
                        c2.await();
                    }
//                    System.out.print("B");
                    list.add('B');
                    count++;
                    c3.signal();// 唤醒条件3
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

        }
    });
    Thread t3 = new Thread(new Runnable() {

        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();
                    if(count == (len-1)*4+3) break;
                    while (count % 4 != 2) {
//                        System.out.println("C wait ");
                        c3.await();
                    }
//                    System.out.print("C");
                    list.add('C');
                    count++;
                    c4.signal();// 唤醒条件1
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

        }
    });

    Thread t4 = new Thread(new Runnable() {

        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();
                    if(count == (len-1)*4+4) break;
                    while (count % 4 != 3) {
//                        System.out.println("D wait ");
                        c4.await();
                    }
//                    System.out.print("D");
                    list.add('D');
                    count++;
                    c1.signal();// 唤醒条件1
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }

        }
    });

    public void fun() {

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        len = scan.nextInt ();
        scan.nextLine();
        list = new ArrayList<>(4*len);

        LockPrint lp = new LockPrint();

        lp.fun();
//        System.out.println("end");

        while(true){
            if(count == 4*len) {
                list.forEach(System.out::print);
                break;
            }
        }



    }
}
