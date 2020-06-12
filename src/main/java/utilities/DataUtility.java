package main.java.utilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Obiekt zarz�dza zapisem danych z akwarium do dw�ch plik�w: csv i tekstowego.
 * @author jakkard
 * @version
 */
public class DataUtility {
    
	/**
	 * Plik, kt�ry przechowuje dane zapisane w formacie csv.
	 */
	private File dataCsv;
	
	/**
	 * Plik, kt�ry przechowuje dane zapisane w formacie tekstowym.
	 */
	private File eventsTxt;
	
	/**
	 * Tworzy instancje klasy narz�dzi danych.
	 */
	public DataUtility() {}
	
	/**
	 * Usuwa zawarto�� pliku.
	 * @param file plik do usuni�cia zawarto�ci.
	 */
	private void clean(File file) {
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(file.getName());
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			System.out.println("Blad pliku");
			e.printStackTrace();
		}
	}
	
	/**
	 * Tworzy par� plik�w s�u��cych do zapisu danych.
	 * @param csvName nazwa pliku csv z rozszerzeniem .csv
	 * @param txtName nazwa pliku tekstowego z rozszerzeniem .txt
	 */
	public void createFiles(String csvName, String txtName){
		dataCsv = new File(csvName);
		eventsTxt = new File(txtName);
		try {
			dataCsv.createNewFile();
			clean(dataCsv);
			System.out.println("Stworzono plik: " + dataCsv.getName());
		} catch (IOException e) {
			System.out.println("Blad tworzenia pliku: " + dataCsv.getName());
			e.printStackTrace();
		}
		try {
			eventsTxt.createNewFile();
			clean(eventsTxt);
			System.out.println("Stworzono plik: " + eventsTxt.getName());
		} catch (IOException e)  {
			System.out.println("Blad pliku pliku: " + eventsTxt.getName());
			e.printStackTrace();
		}
		makeTitles();
	}
	
	/**
	 * Pozwalaja zapisa� tablic� string�w do pliku csv. Wszystkie te stringi znajd� si� w jednym wierszu, oddzielone przecinkami.
	 * @param strings tablica string�w.
	 * @return true je�li powi�d� si� zapis, tzn. nie wyrzucono wyj�tku, false je�li przechwycono wyj�tek.
	 */
	public boolean saveToCsv(List<String> strings) {
		FileWriter csvWriter;
		try {
			csvWriter = new FileWriter(dataCsv.getName(), true);
			for(int i=0; i<strings.size(); i++) {
				String string = strings.get(i);
				csvWriter.write(string);
				if(i==strings.size()-1) csvWriter.write('\n');
				else csvWriter.write(',');
			}
			csvWriter.flush();
			csvWriter.close();
			return true;
		} catch (IOException e) {
			System.out.println("Blad ladowania pliku: " + dataCsv.getName());
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Pozwala zapisa� string do pliku tekstowego, w postaci jednego wiersza.
	 * @param string string do umieszczenia w pliku
	 * @return True je�li powiod�o, tzn. nie wyrzucono wyj�tku, false je�li przechwycono wyj�tek.
	 */
	public boolean saveToTxt(String string) {
		FileWriter txtWriter;
		try {
			txtWriter = new FileWriter(eventsTxt.getName(), true);
			txtWriter.write(string + "\n");
			txtWriter.flush();
			txtWriter.close();
			return true;
		} catch (IOException e) {
			System.out.println("Blad ladowania pliku: " + eventsTxt.getName());
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Pozwala odpowiednio zatytu�owa� (napisa� na pierwszym wierszu) oba pliki: csv oraz tekstowy.
	 */
	private void makeTitles() {
		List<String> strings = Arrays.asList("i", "Fish", "RapaciousFish", "Snail", "Prawn", "Fodder", "Alga");
		this.saveToCsv(strings);
		String string = "Notatnik zdarzen:";
		this.saveToTxt(string);
	}
}
