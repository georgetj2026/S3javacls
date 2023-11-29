 
// java program threads 
// thread method usage , multi threading and synchronization

class multiplication {
	synchronized void printmultiplication(int num) {   
		// synchronized the function-
	    // without using the block
		for (int i=1; i<=10;i++)
	  System.out.println(i+"x"+num+"="+i*num);
		
	}
}
class Mythread1 extends Thread{  
	multiplication t= new multiplication();
	Mythread1(multiplication t) {
	this.t=t;
	}
	
	public void run() {  // entry point of thread1
		System.out.println(Thread.currentThread().getName()); // to print thread name
		System.out.println(Thread.currentThread().getPriority());
		t.printmultiplication(5);
	}
}
class Mythread2 extends Thread{
	multiplication t;
	Mythread2(multiplication t) {
	this.t=t;
		}
	public void run() {  // entry point of thread2
		System.out.println(Thread.currentThread().getName()); // to print thread name
		System.out.println(Thread.currentThread().getPriority()); // to print priority
		t.printmultiplication(7);
	}
}
public class demo {
public static void main(String[]args) {
	multiplication m= new multiplication();
	Mythread1 t= new Mythread1(m);
    Mythread2 t2 = new Mythread2(m);
    t2.setPriority(2); //set priority 2 to thread2
    t2.start(); 
    t.start(); 
			
}}

