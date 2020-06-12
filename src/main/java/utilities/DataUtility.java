package main.java.utilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Obiekt zarz¹dza zapisem danych z akwarium do dwóch plików: csv i tekstowego.
 * @author jakkard
 * @version
 */
public class DataUtility {
    
	/**
	 * Plik, który przechowuje dane zapisane w formacie csv.
	 */
	private File dataCsv;
	
	/**
	 * Plik, który przechowuje dane zapisane w formacie tekstowym.
	 */
	private File eventsTxt;
	
	/**
	 * Tworzy instancje klasy narzêdzi danych.
	 */
	public DataUtility() {}
	
	/**
	 * Usuwa zawartoœæ pliku.
	 * @param file plik do usuniêcia zawartoœci.
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
	 * Tworzy parê plików s³u¿¹cych do zapisu danych.
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
	 * Pozwalaja zapisaæ tablicê stringów do pliku csv. Wszystkie te stringi znajd¹ siê w jednym wierszu, oddzielone przecinkami.
	 * @param strings tablica stringów.
	 * @return true jeœli powiód³ siê zapis, tzn. nie wyrzucono wyj¹tku, false jeœli przechwycono wyj¹tek.
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
	 * Pozwala zapisaæ string do pliku tekstowego, w postaci jednego wiersza.
	 * @param string string do umieszczenia w pliku
	 * @return True jeœli powiod³o, tzn. nie wyrzucono wyj¹tku, false jeœli przechwycono wyj¹tek.
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
	 * Pozwala odpowiednio zatytu³owaæ (napisaæ na pierwszym wierszu) oba pliki: csv oraz tekstowy.
	 */
	private void makeTitles() {
		List<String> strings = Arrays.asList("i", "Fish", "RapaciousFish", "Snail", "Prawn", "Fodder", "Alga");
		this.saveToCsv(strings);
		String string = "Notatnik zdarzen:";
		this.saveToTxt(string);
	}
}
