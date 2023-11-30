package Java_fahad;
  
//date:30-11-2023 MultiThreadOddEven

//write a java program that creates  three threads. First thread generates a random
//positive number(>1) every 1 second. if the number is even , the second thread
//prints all the even numbers between 1 and the generated number if the number is odd, 
//the third thread will print all odd numbers between 1 and the generated number

import java.util.Random;  //-package to create random number
class Numbermanager 
  {
	private int GenerateNo;
	private boolean No_generated=false;
	public synchronized void generatenumber()
	    {	    
		GenerateNo = new Random().nextInt(99)+2;
	    System.out.println("Generated random number:"+GenerateNo);
	    No_generated= true;
	    notifyAll();
	    }
	public synchronized void printeven() throws InterruptedException
	    {
		while(!No_generated||GenerateNo%2!=0) 
	    wait();
		for (int i=2;i<GenerateNo;i++) {
			System.out.print(i+" "); }
		
		No_generated=false;
	    }
   public synchronized void printodd() throws InterruptedException 
        {
	    while(!No_generated||GenerateNo%2==0) 
        wait();
	    for (int i=1;i<GenerateNo;i++) 
		System.out.print(i+" ");
	
	    No_generated=false;
        } 
   }
class NumberGenerator extends Thread {
    Numbermanager numberManager;
    public NumberGenerator(Numbermanager numbermanager)
      { 
      this.numberManager = numbermanager;
       }
   public void run() 
       {
	   while(true) {
		numberManager.generatenumber();  
    	try {
        	Thread.sleep(1000);
    	}
      catch(InterruptedException e) {
    		 e.printStackTrace();
      }
    }}}
class EvenPrinterThread extends Thread {  //thread for printing even numbers
    Numbermanager numberManager;
    public EvenPrinterThread (Numbermanager numbermanager)
      { 
      this.numberManager = numbermanager;
       }
   public void run() 
       {
	   while(true) {
       try {
		numberManager.printeven();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}}}}
class OddPrinterThread extends Thread {  //thread for printing even numbers
    Numbermanager numberManager;
    public OddPrinterThread (Numbermanager numbermanager)
      { 
      this.numberManager = numbermanager;
       }
   public void run() 
       {
	   while(true) {
       try {
		numberManager.printodd();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}}}}
    
public class threadscls2 {
  public static void main(String []args) {
	  Numbermanager numberManager = new Numbermanager();
	  NumberGenerator numbergenerator = new NumberGenerator(numberManager);
	  EvenPrinterThread evenprinter = new EvenPrinterThread(numberManager);
	  numbergenerator.start();
	  evenprinter.start();
}
}









