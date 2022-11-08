package org.example;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class App 
{
    public static void main( String[] args ) throws FileNotFoundException, UnsupportedEncodingException {
        Person Aldo = new Person('1',"Aldo", "Camerino",22);
        Person Giovanni = new Person('2',"Giovanni", "Jesi",50);

        Person[] people = new Person[] {Aldo, Giovanni};
        Gson gson = new Gson();

        PrintWriter writer = new PrintWriter("json.txt", "UTF-8");
        writer.println(gson.toJson(people));
        writer.close();
        System.out.println(gson.toJson(people));
    }
}
