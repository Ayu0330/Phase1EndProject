package com.main;

import java.io.File;
import java.util.Scanner;
import com.screens.*;
public class Main {
	
	private static final String ROOT_DIR = "file_storage";
	private static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		createRootDirectory();
		Screens.showWelcomeScreen();
		while(true) {
			Screens.showMainMenu();
		}
	}
	
	private static void createRootDirectory() {
		File dir = new File(ROOT_DIR);
		if(!dir.exists()) {
			dir.mkdir();
		}
	}
}