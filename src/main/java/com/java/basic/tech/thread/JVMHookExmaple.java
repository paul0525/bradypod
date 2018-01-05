package com.java.basic.tech.thread;

import java.util.Map;

/**
 * It show how to use jvm hook
 * @author paul
 *
 */
public class JVMHookExmaple {

    
    private static int EXIT_FLAG = 2;
    
    public static void main(String args[]){
        
        System.out.println(">>> it begins in main. >>>");
        
        HookThread hookThread = new HookThread();
        hookThread.setName("hookThread");
        Runtime.getRuntime().addShutdownHook( hookThread );
        
        TestThread tt = new TestThread();
        tt.setName("testThread-object");
        tt.start();
        
        for( int i = 0; i < 5; i++ ){
            
            printMe(i);
            
            if(i== EXIT_FLAG){
                printHookThread();
                System.out.println("execute the system exit");
                System.exit(0);
            }
        }
        
        System.out.println("<<<< it ends in main. <<<<");
    }

    
    
    private static void printHookThread() {
        
        Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
        
        for( Thread thread : map.keySet()){
            System.out.println( "*** Thread'Name :" + thread.getName());
        }
    }



    private static void printMe(int i) {
        
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        System.out.println(" I am in main thread:" + i );
    }
    
    
    public static class TestThread extends Thread{

        @Override
        public void run() {
            System.out.println("I am testThread!!!");
            
            while(true){
                try {
                    Thread.sleep(3000l);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            
        }
        
        
        
    }
    
}
