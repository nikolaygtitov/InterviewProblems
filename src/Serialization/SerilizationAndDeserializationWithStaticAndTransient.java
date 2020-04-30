package Serialization;

import java.io.Serializable;

public class SerilizationAndDeserializationWithStaticAndTransient implements Serializable {
    private static final long seralversionUID = 129348939L;
    public transient int t;
    public static String s;
    public int age;
    public String name;
    public SerilizationAndDeserializationWithStaticAndTransient(int t, String s, int age, String name) {
        this.t = t;
        this.s = s;
        this.age = age;
        this.name = name;
    }
}
