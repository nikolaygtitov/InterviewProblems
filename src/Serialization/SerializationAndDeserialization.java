package Serialization;

import java.io.Serializable;

public class SerializationAndDeserialization implements Serializable {
    public int age;
    public String name;
    public SerializationAndDeserialization(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
