package com.bradypod.utils;

import java.lang.reflect.Field;

import com.bradypod.annotation.FieldSpace;


public class StringUtils {

    
    /**
     * remve the space( it includs \t \s \n) from the object 
     * @param b
     */
    public static void trimSpace( Object b){
        
        Field[] arrFields = b.getClass().getDeclaredFields();
        
        for( Field f : arrFields ){
            
            if( hasAnnotation(f) == false) continue;
            
             f.setAccessible(true);
             
             Object value = null;
            try {
                value = f.get(b);
            } catch (IllegalArgumentException e1) {
                e1.printStackTrace();
            } catch (IllegalAccessException e1) {
                e1.printStackTrace();
            }
             
             if( null == value) continue;
             
             if( !(value instanceof String) ) 
                 continue;
             
             String temp = (String)value;
             
             try {
                f.set(b, temp.replaceAll("\\s+", ""));
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        
    }

    /**
     * It contants FieldSpace.class
     * @param f
     * @return
     */
    private static boolean hasAnnotation(Field f) {
        
        FieldSpace type = f.getAnnotation( FieldSpace.class );
        
        return type==null?false:true;
    }
    
}
