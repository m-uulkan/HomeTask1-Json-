package com.company.json;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import lombok.Setter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
@Getter
@Setter

public class DataOfDriver {
    public static  final GsonBuilder BUILDER = new GsonBuilder();
    public  static Gson GSON = BUILDER.setPrettyPrinting().create();
    private  static final Path WRITE_PATH = Paths.get("./dataframe.json");

    private int number;
    private String  id;
    private String driver;
    private String name;



    public DataOfDriver() {
    }

    public DataOfDriver(int number,String id, String driver) {
        this.number=number;
        this.id = id;
        this.driver = driver;

    }

    @Override
    public String toString() {
        return
                number+" " + id+" " +
                 "  "+driver +"   ";
    }

    public static void writeJson(String object1) {
        Path writePath = Paths.get(String.valueOf(WRITE_PATH));
        try {
            Files.writeString(writePath, object1, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}