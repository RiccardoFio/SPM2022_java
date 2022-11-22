package org.example;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest
{
    @Test
    public void jsonConverterTest()
    {
        Person Aldo = new Person('1',"Aldo", "Camerino",22);
        Person Giovanni = new Person('2',"Giovanni", "Jesi",50);

        Person[] people = new Person[] {Aldo, Giovanni};
        String json = "[{\"id\":49,\"name\":\"Aldo\",\"city\":\"Camerino\",\"age\":22},{\"id\":50,\"name\":\"Giovanni\",\"city\":\"Jesi\",\"age\":50}]";

        assertEquals( json, App.JsonConverter(people) );
    }
    @Test
    public void fileCreationTest() throws IOException {
        App.createFileJson("TEST", "src/test/file_test.json");

        File file = new File("src/test/file_test.json");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        assertEquals("TEST", br.readLine());
    }
}
