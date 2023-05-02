package org.example;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // test task1: phone number validation
        (new ValidPhoneNumberConsolePrinter()).validateAndPrint();
        // test task2: TxtToJSON
        (new TxtToJSON()).convert();
        (new wordFrequencyCounter()).calculateAndPrint();

    }
}

