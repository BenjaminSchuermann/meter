package garog2.view;

import garog2.controller.GarogController;
import garog2.controller.GarogStartController;
import garog2.controller.GarogWriteFile;
import garog2.model.GarogModel;

import javax.swing.*;
import java.awt.*;

import static javax.swing.SwingConstants.HORIZONTAL;

public class GarogViewerFrame extends JFrame {

    public GarogViewerFrame(GarogModel m) {
        setSize(1024, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(Color.lightGray);

        final GarogViewerGraph system = new GarogViewerGraph(m);
        setContentPane(system);

        //Überschrift
        JLabel ueberschift = new JLabel("Meter");
        ueberschift.setBounds(46, 10, 300, 28);
        ueberschift.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));
        add(ueberschift);

        // Slider anzeigen, zum testen, später durch Analogsignal zu ersetzen
        MySlider slider = new MySlider(HORIZONTAL, 0, 360, 15);
        slider.setBounds(450, 450, 200, 30);
        slider.setValue(m.getValue());
        slider.addChangeListener(new GarogController(m));
        add(slider);

        // Start/Stop Toggle Button anlegen
        MyToggle buttonstart = new MyToggle("Start");
        buttonstart.setBounds(46, 460, 200, 60);
        buttonstart.addActionListener(new GarogStartController(system.getTimerTask(), m));
        add(buttonstart);

        // Save Button anlegen
        MyButton buttonsave = new MyButton("Save");
        buttonsave.setBounds(746, 460, 200, 60);
        buttonsave.addActionListener(new GarogWriteFile(m));
        add(buttonsave);

        setVisible(true);
    }
}
