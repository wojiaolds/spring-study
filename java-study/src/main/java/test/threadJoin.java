package test;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: lds
 * @Date: 2019/8/20 18:13
 */
public class threadJoin {
	
	public static void main ( String[] args ) {
		try {
			CyclicBarrier cyclicBarrier = new CyclicBarrier (5);
			Scanner scan = new Scanner (System.in);
			int len = scan.nextInt ();
			ArrayList <Character> list = new ArrayList <> (4*len);
			ExecutorService executorService = Executors.newFixedThreadPool (4);
	
			while (len-- > 0) {
				Task1 task1 = new Task1 (list,cyclicBarrier);
				Task2 task2 = new Task2 (task1, list,cyclicBarrier);
				Task3 task3 = new Task3 (task2, list,cyclicBarrier);
				Task4 task4 = new Task4 (task3, list,cyclicBarrier);
				executorService.execute (task1);
				executorService.execute (task2);
				executorService.execute (task3);
				executorService.execute (task4);
				cyclicBarrier.await ();
			}
			executorService.shutdown ();
			while (Thread.activeCount () > 2)  //保证前面的线程都执行完
				Thread.yield ();
			list.forEach (System.out:: print);
		}catch ( Exception e ){
		
		}
	}
	static class  Task1 extends Thread{
		CyclicBarrier cyclicBarrier;
		private ArrayList<Character> list;
		public Task1(ArrayList<Character> list,CyclicBarrier cyclicBarrier){
			this.list=list;
			this.cyclicBarrier=cyclicBarrier;
		}
		@Override
		public void run () {
			try {
				list.add ('A');
				cyclicBarrier.await ();
			}catch ( Exception e ){
				System.out.println (e);
			}
		}
	}
	static class  Task2 extends Thread{
		CyclicBarrier cyclicBarrier;
		private ArrayList<Character> list;
		Thread previousThread; //上一个线程
		public Task2(Thread previousThread,ArrayList<Character> list,CyclicBarrier cyclicBarrier){
			this.previousThread=previousThread;
			this.list=list;
			this.cyclicBarrier=cyclicBarrier;
		}
		@Override
		public void run () {
			try {
				previousThread.join ();
				list.add ('B');
				cyclicBarrier.await ();
				
			}catch ( Exception e ){
				System.out.println (e);
			}
		}
	}
	static class  Task3 extends Thread{
		CyclicBarrier cyclicBarrier;
		private ArrayList<Character> list;
		Thread previousThread; //上一个线程
		public Task3(Thread previousThread,ArrayList<Character> list,CyclicBarrier cyclicBarrier){
			this.previousThread=previousThread;
			this.list=list;
			this.cyclicBarrier=cyclicBarrier;
		}
		@Override
		public void run () {
			try {
				previousThread.join ();
				list.add ('C');
				cyclicBarrier.await ();
				
			}catch ( Exception e ){
				System.out.println (e);
			}
		}
	}
	static class  Task4 extends Thread{
		CyclicBarrier cyclicBarrier;
		private ArrayList<Character> list;
		Thread previousThread; //上一个线程
		public Task4(Thread previousThread,ArrayList<Character> list,CyclicBarrier cyclicBarrier){
			this.previousThread=previousThread;
			this.list=list;
			this.cyclicBarrier=cyclicBarrier;
		}
		@Override
		public void run () {
			try {
				previousThread.join ();
				list.add ('D');
				cyclicBarrier.await ();
				
			}catch ( Exception e ){
				System.out.println (e);
			}
		}
	}

	
}
