package ru.kpfu.itis.group403.sharipova.deadLock;
import java.util.Random;


public class Pony implements Runnable{
	private String name;
	//    private int step;   
	private Random random = new Random();

	@Override
	public void run() {
		int path=100;
		while(path>0){
			path-= random.nextInt(5);
			System.out.println(name+ ". � ������");
			String s1="1";
			String s2="2";

			synchronized (s1) {
				Thread.yield();
				synchronized (s2) {

				}
			}
			synchronized (s2) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (s1) {

				}
			}
			System.out.println("� ������ ����� ����������"+ name);
			//?????????????
//			Thread.yield();
//			try {
//				Thread.sleep(10);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//				path=-1;
//			}
		}
		System.out.println(name);
		//       Thread.yield();
	}
	public Pony(String name) {
		super();
		this.name = name;
	}

}
