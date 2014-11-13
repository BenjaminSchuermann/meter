package garog2.view;

import garog2.model.GarogModel;

import javax.swing.*;
import java.awt.*;

public class GarogViewerGraph extends JComponent {
    private GarogModel m;

    private int[] graphValues;
    private int lv;
    private long startzeit;

    public GarogViewerGraph(GarogModel m) {
        // Daten initialisieren
        this.m = m;
        graphValues = new int[900];
        startzeit = m.getStartzeit();
        lv=0;
    }

    private void tick() {
        // Die Werte einen weiter schieben
        System.arraycopy(graphValues, 1, graphValues, 0, graphValues.length - 1);
        // in den letzten Wert den Wert des Sliders setzen todo analogwert
        graphValues[graphValues.length - 1] = m.getValue();
        // und in den Daten den Messwert und Zeitstempel setzen
        m.setMesswerte((int) (System.currentTimeMillis() - startzeit), m.getValue());

        //PI Ressourcen... -.-*
        lv++;
        if(lv>5) {
            repaint();
            lv = 0;
        }
    }

    private void restart() {
        // zu Beginn alles zurücksetzen für die Kurve
        m.resetListen();
        m.setStartzeit(System.currentTimeMillis());
        startzeit = m.getStartzeit();
        for (int i = 0; i < graphValues.length; i++) {
            graphValues[i] = 0;
        }
    }

    public Runnable getTimerTask() {
        return new Runnable() {
            @Override
            public void run() {
                //Das 10ms "Programm"
                //Zum ersten starten jeweils alle nötige zurücksetzen
                if (m.isStartstop()) {
                    restart();
                    m.setStartstop(false);
                }
                //und los gehts
                tick();
            }
        };
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Tracefeld anlegen
        g.setColor(Color.DARK_GRAY);
        g.fillRect(46, 40, 900, 360);
        // schwarze Tracefeldumrand anlegen
        g.setColor(Color.BLACK);
        g.drawLine(45, 40, 45, 400);
        g.drawLine(45, 400, 945, 400);
        // Beschriftung erzeugen
        // Zeitleiste Achse x
        for (Double timeline = 0.0; timeline >= -9.0; timeline = timeline - 0.5) {
            g.drawString(timeline.toString(), 930 + (int) (timeline * 100), 415);
        }
        // Gradleiste Achse y
        for (Integer degree = 30; degree <= 360; degree = degree + 30) {
            if (degree < 100) {
                // Um den Text "rechtsbündig" darzustellen
                g.drawString(degree.toString(), 20, 405 - degree);
            } else {
                g.drawString(degree.toString(), 10, 405 - degree);
            }
        }
        // Hilfslinienfarbe
        g.setColor(Color.GRAY);
        // Die Hilfslinien für Zeit (vertikal)
        for (int i = 0; i < 18; i++) {
            g.drawLine(95 + (i * 50), 40, 95 + (i * 50), 400);
        }
        // Die Hilfslinien für Grad (horizontal)
        for (int i = 0; i < 6; i++) {
            g.drawLine(45, 40 + (i * 60), 945, 40 + (i * 60));
        }
        // zu guter Letzt die Kurve zeichnen
        g.setColor(Color.GREEN);
        for (int i = 1; i < graphValues.length; i++) {
            g.drawLine(i + 46, (360 - graphValues[i - 1]) + 40, i + 46, (360 - graphValues[i]) + 40);
        }
    }
}
