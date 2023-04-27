package org.example;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println();
        System.out.println("Hello world!");

        ValidPhoneNumberConsolePrinter v = new ValidPhoneNumberConsolePrinter();
        v.validateAndPrint("hfjwbqpweb");
    }
}