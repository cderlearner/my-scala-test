package com.example.myscalatest;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class MyReflactor {

    private Map<String, String> stringMap = new HashMap<String, String>(){{
        put("1", "1");
    }};

    public Map<String, String> get() {
        return stringMap;
    }

    public static void main(String[] args) throws Exception{
        MyReflactor mr = new MyReflactor();
        Field field = mr.getClass().getDeclaredField("stringMap");
        field.setAccessible(true);
        Map<String, String> stringMap = (Map<String, String>) field.get(mr);
        stringMap.put("2", "2");
        System.out.println(mr.get());
    }
}
