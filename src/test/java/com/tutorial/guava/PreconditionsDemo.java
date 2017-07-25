package com.tutorial.guava;

import org.testng.annotations.Test;

import com.google.common.base.Preconditions;

/**
 * 
 * @author paul
 *
 */
public class PreconditionsDemo {

    
    @Test(expectedExceptions = NullPointerException.class)
    public void testException(){
        String name = null;
        Preconditions.checkNotNull( name, "name may not be null");
    }
    
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testArgument(){
        int age =100;
        Preconditions.checkArgument(age>=18 && age<=99, "age must in range(18,99)");
    }
    
    
}
