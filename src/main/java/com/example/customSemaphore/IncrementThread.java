package com.example.customSemaphore;

public class IncrementThread implements Runnable{
 
    CustomSemaphore CustomSemaphore;
    
    public IncrementThread(CustomSemaphore CustomSemaphore) {
           this.CustomSemaphore=CustomSemaphore;        
    }
    
    public void run(){
           System.out.println(Thread.currentThread().getName()+
                        " is waiting for permit");
           try {
                  CustomSemaphore.acquire();
                  System.out.println(Thread.currentThread().getName()+
                               " has got permit");
           
                  for(int i=0;i<5;i++){
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName()+
                                      " > "+SemaphoreCustomTest.SharedValue++);
                  }
                  
           } catch (InterruptedException e) {
                  e.printStackTrace();
           }
           
           System.out.println(Thread.currentThread().getName()+
                        " has released permit");
           CustomSemaphore.release();
    
    }
    
}