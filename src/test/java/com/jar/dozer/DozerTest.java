package com.jar.dozer;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.testng.annotations.Test;

import com.jar.dozer.bean.DifferentProperties;
import com.jar.dozer.bean.SourceObj;
import com.jar.dozer.bean.TargetObj;



public class DozerTest {
    
    
    @Test(enabled = false)
    public void testCopy1(){
    
        SourceObj so = SourceObj.getInstance();
        Mapper mapper = new DozerBeanMapper();
        TargetObj to = mapper.map(so, TargetObj.class);
        
        assertNotNull(to);
        assertEquals(18, to.getAge());
        System.out.println( String.format("My name is %s, and my age is %d", to.getName(), to.getAge()));
    }
    
    @Test
    public void testDifferentProperties(){

        List myMappingFile = new ArrayList();
        myMappingFile.add("dozer_cfg.xml");
        
        DozerBeanMapper  mapper = new DozerBeanMapper();
        mapper.setMappingFiles(myMappingFile);
        
        SourceObj so = SourceObj.getInstance();
        DifferentProperties target = mapper.map(so, DifferentProperties.class );
        assertNotNull(target);
        assertEquals(18, target.getAgeDiff());
        
        System.out.println( String.format("My nameDiff is %s, and my ageDiff is %d, my longValue is %d", target.getNameDiff(), target.getAgeDiff(),target.getLongValue()));
    }

}
