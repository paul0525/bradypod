package com.tutorial.guava;

import static org.testng.Assert.assertEquals;

import java.nio.charset.Charset;

import org.testng.annotations.Test;

import com.google.common.base.Ascii;
import com.google.common.base.Charsets;
import com.google.common.base.Converter;
import com.google.common.base.Defaults;
import com.google.common.base.Objects;



/**
 * 
 * @author paul
 *
 */
public class ObjectEquals {

    
    @Test(enabled=false)
    public void testObjectsEquals(){
        
        String str = null;
        
        //throw NullPointerException
//        System.out.println( str.equals("a"));
        
        boolean flag1 = Objects.equal(str, "a");
        assertEquals(false, flag1);
        
        boolean flag2 = Objects.equal("a",  str);
        assertEquals(false, flag2);
        
        boolean flag3 = Objects.equal(str, null);
        assertEquals(true, flag3);
        
        boolean flag4 = Objects.equal(null, str);
        assertEquals(true, flag4);
        
        
    }
    
    @Test(enabled = false)
    public void testObjectToString(){
        Person person = new Person("paul",32);
        
//        String str = Objects.toStringHelper(person).add("name", "dong").toString();
//        System.out.println("str is " + str);
    }
    
    @Test(enabled = false)
    public void testConvert(){
        
        Converter<String, Integer> converter = new Converter<String, Integer>() {

            @Override
            protected Integer doForward(String a) {
                return Integer.parseInt(a);
            }

            @Override
            protected String doBackward(Integer b) {
                return b.toString(); 
            }
        };
        
        String str = "10";
        Integer temp = converter.convert( str );
        assertEquals(10, temp.intValue());
    }
    
    @Test
    public void testDefault(){
        boolean bool  = Defaults.defaultValue(boolean.class);
       assertEquals(bool,false);
    }
    
    
    public static void main( String args[] ){
        byte b1 = Ascii.ACK;
        System.out.println( "ack of ascii is " + b1);
        
        Charset charset = Charsets.ISO_8859_1;
        System.out.println( charset );
        
       Person p = new Person();
        System.out.println("java base type 's default is " + p.isBool());
        
    }
    
}
