/**
 * 
 */
package com.countrylist;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * @author Brandon Spencer
 *
 */
public class CountriesTextFile {

	public static void createFile() {

		String fileName = "countries.txt";
		Path filePath = Paths.get(fileName);

		if (Files.notExists(filePath)) {
			try {
				Files.createFile(filePath);
				System.out.println("File created successfully!");
			} catch (IOException e) {
				System.out.println("Something went wrong!");
			}
		}
	}

	public static void readFromFile() {

		
		String fileName = "countries.txt";

		Path filePath = Paths.get(fileName);
		File file = filePath.toFile();

		try {
			FileReader fr = new FileReader(file);
			BufferedReader reader = new BufferedReader(fr);

			String line = reader.readLine();

			while (line != null) {
				System.out.println(line);
				line = reader.readLine();

			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Something went wrong!");
		}
	

	}

	public static void writeToFile(String country) {
		String fileName = "countries.txt";
		//CountriesTextFile country = new CountriesTextFile();

		Path writeFile = Paths.get(fileName);
		File file = writeFile.toFile();

		try {
			PrintWriter outW = new PrintWriter(new FileOutputStream(file, true));
			outW.println(country);
			outW.close();
		} catch (FileNotFoundException e1) {
			System.out.println("File not found.");
		}
	}

}
