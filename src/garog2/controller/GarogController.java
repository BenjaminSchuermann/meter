package garog2.controller;

import garog2.model.GarogModel;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GarogController implements ChangeListener
{

    private GarogModel m;

    public GarogController(GarogModel m)
    {
        this.m = m;
    }

    @Override
    public void stateChanged(ChangeEvent e)
    {
        // Wenn der Sliderwert sich verändert hat, dann den aktuellen Wert in
        // die Daten schreiben
        m.setValue(((JSlider) e.getSource()).getValue());
    }
}