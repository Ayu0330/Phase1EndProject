package com.screens;

import java.util.Scanner;
import com.services.*;

public class Screens {
	private static final Scanner scanner = new Scanner(System.in);
	private static FileServices fls = new FileServices();
	
	public static void showWelcomeScreen() {
		System.out.println("=======================================");
        System.out.println("  Welcome to Virtual Key Application  ");
        System.out.println("  Developer: Ayush Anand               ");
        System.out.println("=======================================\n");
    }

    public static void showMainMenu() {
    	System.out.println("\nMain Menu:");
        System.out.println("1. Display all files in ascending order");
        System.out.println("2. Business-level operations");
        System.out.println("3. Exit");

        System.out.print("Choose an option: ");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                fls.listFilesAscending();
                break;
            case "2":
                showBusinessMenu();
                break;
            case "3":
                System.out.println("Exiting application...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid input. Please try again.");
        }
    }
    
    public static void showBusinessMenu() {
    	while (true) {
            System.out.println("\nBusiness Operations:");
            System.out.println("1. Add a file");
            System.out.println("2. Delete a file");
            System.out.println("3. Search for a file");
            System.out.println("4. Return to main menu");

            System.out.print("Choose an option: ");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    fls.addFile();
                    break;
                case "2":
                    fls.deleteFile();
                    break;
                case "3":
                    fls.searchFile();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }
}
