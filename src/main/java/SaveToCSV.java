package sample;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;


public class SaveToCSV {

    private String filePatch="akwarium.txt";
    String a ;

    public static void saveFile(String a,String filePatch) {

        try {
            FileWriter fileWriter = new FileWriter(filePatch, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            printWriter.println(a);//tu co chemy wpisywac do txt
            printWriter.flush();
            printWriter.close();

            //JOptionPane.showMessageDialog(null, "Zapisano");
        } catch (Exception E) {
            JOptionPane.showMessageDialog(null, "Nie zapisano");
        }
    }
}
