package com.example.gui;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class Database  {
    static Product[] products;

    private String file_path;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;
    private File file;

    public Database(String file_path) throws IOException {
        this.file_path = file_path;
    }

    public void start_write() throws IOException {
        this.objectOutputStream = new ObjectOutputStream(new FileOutputStream(file_path));
    }

    public void insert(ArrayList<Object> data) throws IOException {
        for(Object obj : data){
            this.objectOutputStream.writeObject(obj);
        }
    }

    public void start_read() throws IOException {
        this.objectInputStream = new ObjectInputStream(new FileInputStream(file_path));
    }

    public List<Object> read() throws IOException, ClassNotFoundException {
        List<Object> result = new ArrayList<>();
        try {
            while (true) {
                Object data = this.objectInputStream.readObject();
                result.add(data);
            }
        } catch (EOFException ignored) {
            // End of file reached
        }
        return result;
    }
    public void close_write() throws IOException {
        this.objectOutputStream.close();
    }

    public void close_read() throws IOException {
        this.objectInputStream.close();
    }
    public void displayContent() {
        try {
            start_read();

            List<Object> result = read();
            for (Object data : result) {
                    System.out.println(data);

            }

            close_read();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
// ma3mlnash interface bec. there is no class that extends database class
