package org.example;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class App 
{
    public static void main( String[] args ) throws FileNotFoundException, UnsupportedEncodingException {
        Person Aldo = new Person('1',"Aldo", "Camerino",22);
        Person Giovanni = new Person('2',"Giovanni", "Cupramontana",50);

        Person[] people = new Person[] {Aldo, Giovanni};
        createFileJson(JsonConverter(people), "file.json");
    }

    public static String JsonConverter(Person[] people){
        Gson gson = new Gson();
        return gson.toJson(people);
    }

    public static void createFileJson(String peopleJson, String fileName) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter(fileName, "UTF-8");
        writer.println(peopleJson);
        writer.close();
        System.out.println(peopleJson);
    }
}
