package com.javarush.task.task20.task2020;

import java.io.*;
import java.util.logging.Logger;

/* 
Сериализация человека
*/
public class Solution {

    public static class Person implements Serializable{
        String firstName;
        String lastName;
        transient String fullName;
        transient final String greetingString;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }

        public void writeObject (ObjectOutputStream out) throws IOException {
            out.defaultWriteObject();
            out.writeObject(firstName);
            out.writeObject(lastName);
            out.writeObject(country);
            out.writeObject(sex);
        }

        public void readObject (ObjectInputStream in) throws IOException, ClassNotFoundException {
            in.defaultReadObject();
            firstName = (String) in.readObject();
            lastName = (String) in.readObject();
            country = (String) in.readObject();
            sex = (Sex) in.readObject();
        }
    }

    enum Sex {
        MALE,
        FEMALE
    }



    public static void main(String[] args) {

    }
}
