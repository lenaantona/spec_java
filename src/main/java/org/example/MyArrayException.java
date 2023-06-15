package org.example;

public abstract class MyArrayException extends Exception{
    private String name;

    public MyArrayException(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
