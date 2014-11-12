package garog2.model;

import java.util.ArrayList;

//Die "Daten" welche an den unterschiedlichsten Stellen gebraucht werden
//per getter und setter zur Verfügung stellen inkl. extra Methoden wie dem leeren von Arrays

public class GarogModel
{
    private int value;

    private ArrayList<Integer> messwerte;

    private ArrayList<Integer> zeitstempel;

    private long startzeit;

    private boolean startstop;

    public GarogModel()
    {
        value = 0; // init
        messwerte = new ArrayList<Integer>();
        zeitstempel = new ArrayList<Integer>();
        startzeit = 0;
        startstop = false;
    }

    public void setMesswerte(int zeitstempel, int messwert)
    {
        this.zeitstempel.add(zeitstempel);
        this.messwerte.add(messwert);
    }

    public Integer getZeitstemple(int index)
    {
        return zeitstempel.get(index);
    }

    public Integer getMesserte(int index)
    {
        return messwerte.get(index);
    }

    public void resetListen()
    {
        messwerte.clear();
        zeitstempel.clear();
    }

    public int getListenLaenge()
    {
        return messwerte.size();
    }

    public int getValue()
    {
        return value;
    }

    public void setValue(int value)
    {
        this.value = value;
    }

    public long getStartzeit()
    {
        return startzeit;
    }

    public void setStartzeit(long startzeit)
    {
        this.startzeit = startzeit;
    }

    public boolean isStartstop() {
        return startstop;
    }

    public void setStartstop(boolean startstop) {
        this.startstop = startstop;
    }
}
