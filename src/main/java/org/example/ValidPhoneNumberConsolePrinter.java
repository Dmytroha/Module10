package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  Validate phone numbers according template and out to console
 */
public class ValidPhoneNumberConsolePrinter {
    public ValidPhoneNumberConsolePrinter() throws FileNotFoundException {
    }

    private String phoneNumberValidationRegexp = "^\\(?\\{3}\\)?[- ]?\\d{3}[- ]?\\d{4}$";
    private String stringFromFile = "";
    private String filePath = "src\\main\\resources\\task1\\file.txt";



    public void validateAndPrint(){

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            // compile regexp to apply matcher
           Pattern pattern = Pattern.compile("^\\(\\d{3}\\) \\d{3}-\\d{4}$|^\\d{3}-\\d{3}-\\d{4}$");
           // read data from file validate and out to console
            while ((stringFromFile = bufferedReader.readLine()) != null) {
                //validate with matcher
                Matcher matcher = pattern.matcher(stringFromFile);
                if (matcher.matches()) {
                    System.out.println(stringFromFile);
                }
            }

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }


    }


}

