/**
 * 
 */
package com.github.CynthiaYang88.blackJack;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Cindi
 *
 */
public class IO {
	private String name = "";
	private double bank = 0;
	private String bankString = "";
	private int afterComma = 0;
	private int counter = 0;

	public void readFromCSV(String fileName) {
		FileReader inputStream = null;
		System.out.println("one" + fileName);

		try {
			inputStream = new FileReader(fileName); // input file

			int c; // ?
			while ((c = inputStream.read()) != -1) { // read and process one character
				System.out.println("c" + (char) c);

				if ((char) c == ',') {
					afterComma = counter;
					continue;
				}

				if (afterComma > 0) {
					bankString += (char) c;
				} else {
					name += (char) c;// c
				}

				counter++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 
	 * @return
	 */
	public double getBank() {
		bank = Double.parseDouble(bankString);
		return bank;
	}

	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

}
