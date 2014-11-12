package garog2.controller;

import javax.swing.*;
import java.io.File;

public class GarogFolder extends JComponent {

    private JFileChooser fc;
    private File folder;

    public GarogFolder() {
        //FileChooser anlegen
        fc = new JFileChooser();
        //und nur auf Ordner beschränken
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    }

    public File selectOrdner() {
        //Auswahl anzeigen
        int returnVal = fc.showSaveDialog(GarogFolder.this);
        //und prüfen ob ok
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            //wenn ok, Ordnerpfad übergeben
            folder = fc.getSelectedFile();
        } else {
            //wenn nicht, todo später im Linux
            folder = new File(".");
        }
        return folder;
    }
}
