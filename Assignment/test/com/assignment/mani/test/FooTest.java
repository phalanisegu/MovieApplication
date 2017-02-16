package com.assignment.mani.test;

class Example {  
   public static void main(String args[]) 
   {
	   Child c1 = new Child();
	   Thread t = new Thread(c1);
	   t.start();
	   }
}

class Child implements Runnable
{
	public void run()
	{
		System.out.println("hello new thread");
	}
}