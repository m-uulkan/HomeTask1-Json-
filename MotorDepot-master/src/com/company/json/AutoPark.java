package com.company.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.Setter;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;


@Getter
    @Setter
    public class AutoPark {

    public static  final GsonBuilder BUILDER = new GsonBuilder();
    public  static Gson GSON = BUILDER.setPrettyPrinting().create();
    private static final Path WRITE_PATH = Paths.get("./autoPark.json");

    private int id;
    private String name;
    private String driver;
    private String state;


    public AutoPark() {
    }



    public AutoPark(int id, String name, String driver, String state) {
        this.id = id;
        this.name = name;
        this.driver = driver;
        this.state = state;
    }

    @Override
    public String toString() {
        return id + "    " +
                name + "|   " +
                driver + "|   " +
                state + "  ";
    }

    public static void writeJson(String object1) {
        Path writePath = Paths.get(String.valueOf(WRITE_PATH));
        try {
            Files.writeString(writePath, object1, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static String readJson() {
        String json = "";
        try {
            FileReader reader = new FileReader("./autoPark.json");
            int c;
            while ((c = reader.read()) != -1) {
                json += (char) c;
            }
            return json;
        } catch (IOException e) {
            e.printStackTrace();
        }return json;
    }
           public static void getInfoAuto(){
               System.out.println("#  | Bus     |  Driver  |  State");
               System.out.println("***_*********_**********_********");
               AutoPark[] parks = {
                       new AutoPark(1, "Renault", "", "base"),
                       new AutoPark(2, "Volvo", "", "base"),
                       new AutoPark(3, "DAF XT", "", "base")
               };
               String gson = GSON.toJson(parks);
               AutoPark.writeJson(gson);
               AutoPark[] parks1 = GSON.fromJson(AutoPark.readJson(), AutoPark[].class);
               for (AutoPark p :
                       parks1) {
                   System.out.println(p.toString());
               }

           }
           }


