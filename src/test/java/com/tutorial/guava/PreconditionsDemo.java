package com.tutorial.guava;

import org.testng.internal.Nullable;
import com.google.common.base.Preconditions;

/**
 * 
 * @author paul
 *
 */
public class PreconditionsDemo {

    
    public static void  main(String args[] ){
        
        PreconditionsDemo demo = new PreconditionsDemo();
        
        demo.doSomething("Jam", 19, "hello world, hello java");
    }
    
    
    public void doSomething(String name, int age, String desc){
        Preconditions.checkNotNull( name, "name may not be null ");
        Preconditions.checkArgument(age>=18 && age<=99, "age must in range(18,99)");
        Preconditions.checkArgument( desc != null && desc.length() < 10, "desc too long ");
        
    }
    
    
    public  String  test(String name){
        
        return "";
    } 
    
}
