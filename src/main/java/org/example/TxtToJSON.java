package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TxtToJSON {


    private String filePath = "src\\main\\resources\\task2\\file.txt";
    private String jsonFilePath = "src\\main\\resources\\task2\\user.json";

    private ArrayList<UserInfo> userInfoList = new ArrayList<>();
    private String stringFromFile;
    private GsonBuilder gsonBuilder = new GsonBuilder();
    private Gson gson = gsonBuilder.setPrettyPrinting().create();

    //private Gson gson1 = new Gson();

    //private Gson gson = new GsonBuilder().setPrettyPrinting().create();




    public TxtToJSON()  {
    }
    public void convert(){
        //ArrayList <UserInfo> userInfoArrayList = new ArrayList<>(); // create UserInfo objects array list
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            // read first string from source file
            stringFromFile = bufferedReader.readLine();
            System.out.println("Read header string: "+stringFromFile);
            // fill userInfos with file content
            while ((stringFromFile = bufferedReader.readLine()) != null) {
                String[] s = stringFromFile.split(" ");
                try{
                    userInfoList.add(new UserInfo(s[0], Integer.parseInt(s[1])));
                } catch (NumberFormatException ex){
                  System.out.println(ex.getMessage());
                }
               // System.out.println(userInfoArrayList);
            }
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }
        try(FileWriter writerForJson = new FileWriter(jsonFilePath)){
            gson.toJson(userInfoList,writerForJson);
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
class UserInfo {
   private  String name;
    private int age;

    public UserInfo(String name, int age) {
        this.name = name;
        this.age = age;
    }

}

