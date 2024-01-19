package com.example.allPracticeProgram.customeSemaphore;

public class SemaphoreCustomTest {

static int SharedValue=0;
    
    public static void main(String[] args) {
           SemaphoreCustom semaphore=new SemaphoreCustom(1);
           System.out.println("Semaphore with 1 permit has been created");
           
           IncrementThread incrementThread=new IncrementThread(semaphore);
           new Thread(incrementThread,"incrementThread").start();
           
           IncrementThread incrementThread1=new IncrementThread(semaphore);
           new Thread(incrementThread1,"incrementThread").start();
           
//           decrementThread decrementThread=new DecrementThread(semaphore);
//           new Thread(decrementThread,"decrementThread").start();
           
    }

}
