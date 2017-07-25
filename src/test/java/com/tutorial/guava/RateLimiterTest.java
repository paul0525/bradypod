package com.tutorial.guava;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.testng.annotations.Test;

import com.google.common.util.concurrent.RateLimiter;

public class RateLimiterTest {
  
    
  @Test(enabled = false)
  public void test() {
      
     RateLimiter rateLimiter = RateLimiter.create(2);
     
     double d1 = rateLimiter.acquire();
     assertEquals(0.0, d1);
  }

  
  public static  void main(String args[]) {
      
//      RateLimiter rateLimiter = RateLimiter.create(5);
//      double d1 = rateLimiter.acquire(100);
//      assertNotEquals(0.0, d1);
//      System.out.println("result:" + rateLimiter.acquire());
//      System.out.println("result:" + rateLimiter.acquire());
//      System.out.println("result:" + rateLimiter.acquire());
//      System.out.println("result:" + rateLimiter.acquire());
//      System.out.println("result:" + rateLimiter.acquire());
//      System.out.println("result:" + rateLimiter.acquire());
      
      
      RateLimiter rateLimiter = RateLimiter.create(5);
      
      System.out.println( rateLimiter.acquire(1));
      System.out.println( rateLimiter.acquire(1));
      System.out.println( "100 permits "+rateLimiter.acquire(100));   //why is it excuted immediately
  }
}
