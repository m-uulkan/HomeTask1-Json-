package com.company.jsonOne;

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
    private static final Path WRITE_PATH = Paths.get("./dataframe.json");
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
}
