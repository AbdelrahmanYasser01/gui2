package com.example.gui;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class Database {
    static Product[] products;

    private String file_path;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;
    private File file;

    public Database(String file_path) throws IOException {
        this.file_path = file_path;
    }

    public void start_write() throws IOException {
        this.objectOutputStream = new ObjectOutputStream(new FileOutputStream(file_path, true));
    }

    public void insert(Object data) throws IOException {
        this.objectOutputStream.writeObject(data);
    }

    public void start_read() throws IOException {
        this.objectInputStream = new ObjectInputStream(new FileInputStream(file_path));
    }

    public ArrayList<Object> read(String type) throws IOException, ClassNotFoundException {
        ArrayList<Object> result = new ArrayList<>();
        try {
            while (true) {
                Object data = this.objectInputStream.readObject();

                if (Objects.equals(type, "product") && data instanceof Product) {
                    result.add(data);
                } else if (Objects.equals(type, "customer") && data instanceof Customer) {
                    // Add logic for customer
                    result.add(data);
                } else if (Objects.equals(type, "seller") && data instanceof Seller) {
                    // Add logic for seller
                    result.add(data);
                }
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
}
// ma3mlnash interface bec. there is no class that extends database class
