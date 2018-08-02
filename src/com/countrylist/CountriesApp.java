/**
 * 
 */
package com.countrylist;

import java.util.Scanner;

/**
 * @author Brandon Spencer
 *
 */
public class CountriesApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int choice = 0;
		String cont = "y";
		CountriesTextFile.createFile();
		System.out.println("Welcome to the Countries Maintenance Application!");
		do {
			System.out.println("1- See the list of countries \n2- Add a country \n3- Exit");
			choice = Validator.getInt(scan, "Enter a menu number: ", 1, 4);

			if (choice == 1) {
				CountriesTextFile.readFromFile();

			} else if (choice == 2) {
				String country = Validator.getString(scan, "Enter a country: ");
				CountriesTextFile.writeToFile(country);
				CountriesTextFile.readFromFile();

			} else if (choice == 3) {
				System.out.println("Peace out!");
				return;
			}
			System.out.println("Continue? (y/n) ");
			cont = scan.nextLine();
			if (cont.equalsIgnoreCase("n")) {
				System.out.println("Bye!");
			}
		} while (cont.equalsIgnoreCase("y"));

	}

}
