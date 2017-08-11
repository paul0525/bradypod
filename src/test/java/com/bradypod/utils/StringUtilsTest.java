package com.bradypod.utils;

import static org.junit.Assert.*;

import org.junit.Test;


public class StringUtilsTest {

    @Test
    public void test() {
        Student bin = new Student();
        StringUtils.trimSpace(bin);
    }
    
    
    @Test
    public void testFeild() {
        
        String card = " 0000 1111 3333 4444 ";
        
        Student bin = new Student();
        bin.setCardno( card );
        bin.setBankCode(" abc ");
        StringUtils.trimSpace(bin);
        
        assertEquals("0000111133334444", bin.getCardno());
        assertEquals(" abc ", bin.getBankCode());
    }
    
    @Test
    public void testFeild02() {
        
        String card = " 0000 1111   3333      4444\n";
        
        Student bin = new Student();
        bin.setCardno( card );
        StringUtils.trimSpace(bin);
        
        assertEquals("0000111133334444", bin.getCardno());
    }

}
