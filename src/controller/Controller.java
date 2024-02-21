/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import util.InputUtils;

/**
 *
 * @author nhs
 */
public class Controller {

    public static void main(String[] args) {
        int option;
        while (true) {
            option = Menu.chooseInputOption();
            switch (option) {
                case 1 -> {
                    System.out.println("Enter path: ");
                    checkFileExist(InputUtils.inputString());
                }
                case 2 -> {
                    System.out.println("Enter path: ");
                    try {
                        List<String> fileName = getAllFileNameJavaInDirectory((InputUtils.inputString()));
                        for (String name : fileName) {
                            System.out.println(fileName);
                        }
                    } catch (Exception e) {
                        System.out.println("Path does not exist!");
                    }
                }
                case 3 -> {
                    System.out.println("Enter path: ");
                    String n = InputUtils.inputString();
                    System.out.println("Enter integer number: ");
                    List<String> fileName = getAllFileWithConditionSize(n, InputUtils.inputInt());
                    if (fileName != null) {
                        for (String name : fileName) {
                            System.out.println(name);
                        }
                    } else {
                        System.out.println("Path does not exist");
                    }
                }
                case 4 -> {
                    System.out.println("Enter path: ");
                    String path = InputUtils.inputString();
                    System.out.println("Enter content: ");
                    String content = InputUtils.inputString();
                    try {
                        if (appendContentToFile(path, content)) {
                            System.out.println("Successfully!");
                        } else {
                            System.out.println("Failed to append.");
                        }
                    } catch (Exception e) {
                        System.out.println("Path does not exist");
                    }
                }
                case 5 -> {
                    System.out.println("Enter path: ");
                    try {
                        int count = countWord(InputUtils.inputString());
                        System.out.println("count word: " + count);
                    } catch (Exception e) {
                        System.out.println("Failed to reach file.");
                    }
                }
                case 6 -> {
                    System.out.println("You selected to exit the program.");
                    System.exit(0);
                }
            }
        }
    }

    public static void checkFileExist(String path) {
        File f1 = new File(path);
        if (f1.exists()) {
            if (f1.isDirectory()) {
                System.out.println("Path directory");
            }
            if (f1.isFile()) {
                System.out.println("Path to file");
            }
        } else {
            System.out.println("Path doesn't exist");
        }
    }

    public static List<String> getAllFileNameJavaInDirectory(String path) throws Exception {
        List<String> fileJava = new ArrayList<>();
        File f1 = new File(path);
        if (f1.exists()) {
            if (f1.isDirectory()) {
                File[] files = f1.listFiles();
                if (files != null) {
                    for (File file : files) {
                        if (file.isFile() && file.getName().endsWith(".java")) {
                            fileJava.add(file.getName());
                        }
                    }
                    return fileJava;
                }
            }

        }
        return null;

    }

    public static List<String> getAllFileWithConditionSize(String path, int n) {
        List<String> fileResult = new ArrayList<>();
        File f1 = new File(path);
        if (f1.exists()) {
            if (f1.isDirectory()) {
                File[] files = f1.listFiles();
                if (files != null) {
                    for (File file : files) {
                        double size = file.length() / 1024;
                        if (size > n) {
                            fileResult.add(file.getName());
                        }
                    }
                    return fileResult;
                }
            }
        }
        return null;
    }

    public static boolean appendContentToFile(String path, String contentInput) throws Exception {
        File file = new File(path);
        if (file.exists()) {
            if (file.isFile()) {
                FileWriter fileWriter = new FileWriter(file);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                System.out.println("Enter content to append: ");
                bufferedWriter.write(contentInput);
                bufferedWriter.close();
                fileWriter.close();
                return true;
            }
        }
        return false;
    }

    public static int countWord(String path) throws Exception {
        int length = 0;
        File file = new File(path);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            String[] parts;
            while (line != null) {
                parts = line.split("\\s+");
                length = parts.length;
                line = bufferedReader.readLine();
                line = bufferedReader.readLine();
            }

        } catch (FileNotFoundException ex) {
            System.err.println("File not found.");
        } finally {
            bufferedReader.close();
            fileReader.close();
        }
        return length;
    }

}
