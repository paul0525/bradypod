package com.jar.dozer.bean;



public class SourceObj {

    private String name;

    private int age;
    
    private Long longValue;
    
    private Double doubleValue;
    
    public SourceObj() {
        super();
    }

    public SourceObj(String name, int age, Long longValue, Double doubleValue) {
        super();
        this.name = name;
        this.age = age;
        this.longValue = longValue;
        this.doubleValue = doubleValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getLongValue() {
        return longValue;
    }

    public void setLongValue(Long longValue) {
        this.longValue = longValue;
    }

    public Double getDoubleValue() {
        return doubleValue;
    }

    public void setDoubleValue(Double doubleValue) {
        this.doubleValue = doubleValue;
    }
    
    private static SourceObj instance = new SourceObj("paul", 18, 190L, 18.6);
    
    public static SourceObj getInstance(){
        
        return  instance;
    }
    
    
}
