package com.services;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FileServices {
	
	private static final String ROOT_DIR = "file_storage"; // folder to manage files
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void listFilesAscending() {
        File folder = new File(ROOT_DIR);
        String[] files = folder.list();
        if (files == null || files.length == 0) {
            System.out.println("No files found.");
            return;
        }

        List<String> fileList = Arrays.asList(files);
        Collections.sort(fileList, String.CASE_INSENSITIVE_ORDER);
        System.out.println("\nFiles in directory:");
        for (String file : fileList) {
            System.out.println(file);
        }
    }
    
    public static void addFile() {
        System.out.print("Enter file name to add: ");
        String fileName = scanner.nextLine().trim();

        if (fileName.isEmpty()) {
            System.out.println("Invalid file name.");
            return;
        }

        File file = new File(ROOT_DIR + "/" + fileName);
        try {
            if (file.createNewFile()) {
                System.out.println("File created successfully.");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
        }
    }

    public static void deleteFile() {
        System.out.print("Enter file name to delete (case-sensitive): ");
        String fileName = scanner.nextLine().trim();

        File file = new File(ROOT_DIR + "/" + fileName);
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                System.out.println("File deleted successfully.");
            } else {
                System.out.println("Unable to delete the file.");
            }
        } else {
            System.out.println("File not found.");
        }
    }

    public static void searchFile() {
        System.out.print("Enter file name to search (case-sensitive): ");
        String fileName = scanner.nextLine().trim();

        File folder = new File(ROOT_DIR);
        String[] files = folder.list();

        if (files != null) {
            boolean found = Arrays.asList(files).contains(fileName);
            if (found) {
                System.out.println("File found in the directory.");
            } else {
                System.out.println("File not found.");
            }
        } else {
            System.out.println("Error reading directory.");
        }
    }

}
