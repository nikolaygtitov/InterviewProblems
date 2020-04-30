package Serialization;

import java.io.*;

public class SerializationTest {
    private static String fileName = "test_serializtion_and_deserialization.txt";
    public static void main (String []args) {
        testSerilizationAndDeserialization();
        System.out.println();
        testSerilizationAndDeserializationWithStaticAndTransient();
    }

    public static void testSerilizationAndDeserialization() {
        SerializationAndDeserialization sad = new SerializationAndDeserialization(33, "Nikolay");
        System.out.println("sad object before serialization: age = " + sad.age + " name = " + sad.name);

        doSerializationDeserialization(sad, null);
    }

    public static void testSerilizationAndDeserializationWithStaticAndTransient() {
        String fileName = "test_serializtion_and_deserialization.txt";
        SerilizationAndDeserializationWithStaticAndTransient sadwsat =
                new SerilizationAndDeserializationWithStaticAndTransient(100, "String", 33, "Nikolay");
        System.out.println("sadwsat object before serialization: t = " + sadwsat.t +" s = " + sadwsat.s + " age: " +
                sadwsat.age + " name: " + sadwsat.name);

        doSerializationDeserialization(null, sadwsat);
    }

    private static void doSerializationDeserialization(SerializationAndDeserialization sad,
                                                       SerilizationAndDeserializationWithStaticAndTransient sadwsat) {
        // Serialization
        try {
            if (sad != null && sadwsat == null) {
                serialization(sad, null);
            } else if (sad == null && sadwsat != null) {
                serialization(null, sadwsat);
            }
        } catch (IOException e) {
            System.out.println("IO Exception during serialization: " + e);
        }

        // Deserialization
        try {
            deserilization(sad, sadwsat);
        } catch (IOException e) {
            System.out.println("IO Exception deserialization: " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException Exception deserialization: " + e);
        }
    }

    private static void serialization(SerializationAndDeserialization sad,
                                      SerilizationAndDeserializationWithStaticAndTransient sadwsat) throws IOException {
        FileOutputStream file = new FileOutputStream(fileName);
        ObjectOutputStream out = new ObjectOutputStream(file);

        if (sad != null) {
            out.writeObject(sad);
            System.out.println("sad object has been serialized");
        } else if (sadwsat != null) {
            out.writeObject(sadwsat);
            System.out.println("sadwsat object has been serialized");
            System.out.println("sadwsat static string is modified from String to NULL");
            sadwsat.s = "NULL";
        }
        out.close();
        file.close();
    }

    private static void deserilization(SerializationAndDeserialization sad,
                                       SerilizationAndDeserializationWithStaticAndTransient sadwsat)
            throws IOException, ClassNotFoundException {
        // New SAD object
        SerializationAndDeserialization sadNew = null;
        SerilizationAndDeserializationWithStaticAndTransient sadwsatNew = null;

        FileInputStream file = new FileInputStream(fileName);
        ObjectInputStream in = new ObjectInputStream(file);
        if (sad != null && sadwsat == null) {
            sadNew = (SerializationAndDeserialization) in.readObject();
            in.close();
            file.close();
            System.out.println("sad object has been deserialized into sadNew");
            System.out.println("sadNew object after deserialization of sad object: " + sadNew.age + " " + sadNew.name);
        } else if (sad == null && sadwsat != null) {
            sadwsatNew = (SerilizationAndDeserializationWithStaticAndTransient) in.readObject();
            in.close();
            file.close();
            System.out.println("sadwsat object has been deserialized ino sadwsatNew");
            System.out.println("sadwsat object before serialization: t = " + sadwsatNew.t +" s = " + sadwsatNew.s +
                    " age: " + sadwsatNew.age + " name: " + sadwsatNew.name);
        }
    }
}
