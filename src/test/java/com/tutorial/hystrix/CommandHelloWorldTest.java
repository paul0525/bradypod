package com.tutorial.hystrix;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;



import rx.Observable;

public class CommandHelloWorldTest {

   
    public static void main(String args[]) throws InterruptedException, ExecutionException {
       
        String s1 = new CommandHelloWorld("Bob").execute();
        Future<String> s2 = new CommandHelloWorld("Bob").queue();
        Observable<String> s3 = new CommandHelloWorld("Bob").observe();
        
        System.out.println("s1:" + s1);
        System.out.println("s2:" + s2.get());
        System.out.println("s3:" + s3);
    }

}
