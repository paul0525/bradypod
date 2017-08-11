package com.java.basic.tech.thread.example01;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * show 
 * @author paul
 *
 */
public class Executor {

    private String name;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private static ArrayList<String> list = new ArrayList<String>(){{
        
        add("paul");
        add("steven");
        add("jams");
        add("sophion");
    }};
    
   

    public void start(){
        
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        
        for( final String temp : list ){
           
            final  Executor exe = this;
            
            executorService.execute( new Thread() {
                @Override
                public void run() {

                    exe.execute(temp, this.getName());
                }
            });
        }/*end loop for */
        
        executorService.shutdown();
    }
    
    
    public void execute(String name, String threadName){
        
        System.out.println( String.format("name:%s,threadName:%s",name, threadName) );
    }
    
    
    public static void main(String[] args) {
        
        Executor demo = new Executor();
        
        demo.start();
        
        System.out.println(" It ends ");
    }
    
}
