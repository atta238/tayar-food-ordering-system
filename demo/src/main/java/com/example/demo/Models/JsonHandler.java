package com.example.demo.Models;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.util.Scanner;


public class JsonHandler {
    private static final String FILE_PATH_admin = "src/Files/Admins.json";
    private static final String File_path_capitals = "src/Files/Capitals.json";
    private static final Gson GSON = new GsonBuilder()
            .create();

    public static List<Admin>  loadAdmins() {
        try (FileReader reader = new FileReader(FILE_PATH_admin)) {
            Type ListType = new TypeToken<ArrayList<Admin>>() {}.getType();
            return GSON.fromJson(reader, ListType);
        } catch (IOException e) {
            System.out.println("Error reading users file: " + e.getMessage());
            return new ArrayList<>();
        } catch (JsonSyntaxException e) {
            System.out.println("Error parsing JSON file: " + e.getMessage());
            return new ArrayList<>();
        }
    }


    public static void  saveAdmins(List<Admin> admins) {
        try (FileWriter writer = new FileWriter(FILE_PATH_admin)) {
            GSON.toJson(admins, writer);
        } catch (IOException e) {
            System.out.println("Error writing users file: " + e.getMessage());
        }
    }
    public static <T> void writecapitalsFile( List<Governorate> data, Class<Governorate[]> clazz) {
        try (FileWriter writer = new FileWriter(File_path_capitals)) {
            Gson gson = new Gson();
            T[] array = data.toArray((T[]) java.lang.reflect.Array.newInstance(clazz.getComponentType(), data.size()));
            gson.toJson(array, clazz, writer);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static <T> ArrayList<T> readJsonFile( Class<T[]> clazz) {
        try (FileReader reader = new FileReader(File_path_capitals)) {
            Gson gson = new Gson();
            T[] array = gson.fromJson(reader, clazz);
            if (array != null) {
                return new ArrayList<>(List.of(array));
            }
        } catch (IOException e) {
            System.err.println("Error reading JSON from file: " + e.getMessage());
        }
        return new ArrayList<>();
    }

        public static void writeOrderid(int id) {
            try {
                FileWriter fw = new FileWriter("src/Files/Orderid.txt",false);
                fw.write(String.valueOf(id));
                fw.close();
            } catch (IOException e) {
                throw new RuntimeException("Error writing Order ID", e);
            }
        }

        public static int readOrderid() {
            try {
                File file = Paths.get("src", "Files", "Orderid.txt").toFile();
                Scanner sc = new Scanner(file);
                if (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    return Integer.parseInt(line);
                } else {
                    throw new RuntimeException("Order ID file is empty");
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException("Order ID file not found", e);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Invalid Order ID format", e);
            }
        }
    }




