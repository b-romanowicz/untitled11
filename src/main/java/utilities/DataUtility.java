package main.java.utilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class DataUtility {
    
	private File dataCsv;
	private File eventsTxt;
	
	public DataUtility() {}
	
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
	
	private void makeTitles() {
		List<String> strings = Arrays.asList("i", "Fish", "RapaciousFish", "Snail", "Prawn", "Fodder", "Alga");
		this.saveToCsv(strings);
		String string = "Notatnik zdarzen:";
		this.saveToTxt(string);
	}
}
