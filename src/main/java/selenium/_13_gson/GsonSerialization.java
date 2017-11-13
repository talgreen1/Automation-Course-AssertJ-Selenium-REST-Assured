package selenium._13_gson;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GsonSerialization {
    public static void main(String[] args) throws IOException {
        Person person = new Person("Gidi", "1234");
        String path = "c:/temp/person.json";

        //saveAsJson(person, path);
        person = readFromJson(path);
        System.out.println("Person from file: " + person);

    }

    private static void saveAsJson(Person person, String path) throws IOException {
        Gson gson = new Gson();
        FileWriter fileWriter = new FileWriter(path);
        String personAsJson = gson.toJson(person);
        fileWriter.write(personAsJson);
        fileWriter.close();

    }

    private static Person readFromJson(String path) throws IOException {
        Person result = null;

        Gson gson = new Gson();

        result = gson.fromJson(new FileReader(path), Person.class);

        return result;


    }

}
