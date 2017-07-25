package com.tutorial.guava;

public class Person {

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }
    
    public Person(){}

    protected String name;
    
    protected int  age;
    
    protected boolean bool;

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

    public boolean isBool() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }
    
    
    
    
}
