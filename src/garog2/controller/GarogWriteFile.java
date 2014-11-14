package garog2.controller;

import garog2.model.GarogModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GarogWriteFile implements ActionListener {

    File defaultFolder;

    private GarogModel m;

    public GarogWriteFile(GarogModel m) {
        this.m = m;
        //todo anpassen auf PI System
        defaultFolder = new File("/home/pi");
    }

    private void createFile() {
        try {
            // Dateipfad angeben, ggf. default
            FileWriter outFile = new FileWriter(checkFolder() + "/measuredvalues.csv");
            BufferedWriter outStream = new BufferedWriter(outFile);
            for (int k = 0; k < m.getListenLaenge(); k++) {
                //Zeilen in die Datei schreiben
                outStream.write(m.getZeitstemple(k).toString() + ";" + m.getMesserte(k).toString());
                outStream.newLine();
                outStream.flush();
            }
            outStream.close();
            // Statusfenster
            JOptionPane.showMessageDialog(null, "Data saved");
            //System.out.println("Data saved.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Den Ordner ausgeben
    private File checkFolder() {
        File folderpath;
        // prüfen ob der Standardpfad vorhaden ist
        if (defaultFolder.exists()) {
            folderpath = defaultFolder;
        } else {
            // ansonsten eine Ordnerauswahl treffen
            folderpath = new GarogFolder().selectOrdner();
        }

        return folderpath;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        createFile();
    }
}
