package com.company.jsonOne;


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

    private String id;
    private String name;

    public DataOfDriver(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {

        return id + " |" + " " + name + "   |";

    }

    public static void writeJson(String object1) {
        Path writePath = Paths.get(String.valueOf(WRITE_PATH));
        try {
            Files.writeString(writePath, object1, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void getResultOfDriver() {
        System.out.println("#   Driver           |  Bus");
        System.out.println("***_*****************_******");
        DataOfDriver[] dataOfDrivers = {
                new DataOfDriver("1", "Petr"),
                new DataOfDriver("2", "Jenya"),
                new DataOfDriver("3", "Vova")
        };
        String gson1 = GSON.toJson(dataOfDrivers);
        writeJson(gson1);
        for (DataOfDriver d :
                dataOfDrivers) {
            System.out.println(d.toString());
        }
    }
}