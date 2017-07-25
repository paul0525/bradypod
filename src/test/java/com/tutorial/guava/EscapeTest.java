package com.tutorial.guava;


import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.google.common.html.HtmlEscapers;

public class EscapeTest{

    
    private static final String HTML_TO_ESCAPE = "<html><p>Escape this</p></html>";
    
    @Test
    public void test(){
    
        String escapedHTML = HtmlEscapers.htmlEscaper().escape(HTML_TO_ESCAPE);
       
        System.out.println(escapedHTML);
        
        assertEquals("&lt;html&gt;&lt;p&gt;Escape this&lt;/p&gt;&lt;/html&gt;", escapedHTML);
    }
    
    
}
