package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner{

        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {

            String firstName = "";
            String middleName = "";
            String lastName = "";
            Date birthDate = new Date(0, 0, 0);

            fileScanner.useDelimiter(" ");

            while (fileScanner.hasNext()){
                firstName = fileScanner.next();
                middleName = fileScanner.next();
                lastName = fileScanner.next();
                birthDate = new Date(Integer.parseInt(fileScanner.next()), Integer.parseInt(fileScanner.next()), Integer.parseInt(fileScanner.next()));
            }
            return new Person(firstName, middleName, lastName, birthDate);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
