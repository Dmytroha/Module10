package org.example;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  Validate phone numbers according template and out to console
 */
public class ValidPhoneNumberConsolePrinter {
    public ValidPhoneNumberConsolePrinter() throws FileNotFoundException {
    }

    private String phoneNumberRegexp = "^\\(?\\{3}\\)?[- ]?\\d{3}[- ]?\\d{4}$";
    private String stringFromFile = "";
    private FileReader file1 = new FileReader("src\\main\\resources\\file.txt");
    //private final File sourceFile = new File(".\\resoursces\\file.txt");

    public FileReader getFile1() {
        return file1;
    }

    public void validateAndPrint(String text){
        // исполььзуем возможности класса Pattern

        // скомпилируем регулярное віражение регулярное выражение
        String regex = "hfjwbqpweb";
        Pattern pattern = Pattern.compile(regex);
        // сосздаем экземпляр matcher, который будет искать построку согласно шаблону regex
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {  //ищем
          System.out.println("Соответствие найдено: " + matcher.group());
            System.out.println(file1);
            return; // нашли
        } else {
            return ; // не нашли
        }

    }


}

