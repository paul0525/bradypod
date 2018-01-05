package com.java.basic.tech.thread;

public class HookThread extends Thread {

    @Override
    public void run() {
       
        System.out.println(">>>> HookThread begin >>>");
        
        for( int i = 0 ; i < 5; i++ ){
            System.out.println( "I am HookThread:" + i );
        }
        
        System.out.println("<<<< HookThread end <<<<");
    }

    
    
    
}
