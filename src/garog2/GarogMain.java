package garog2;

import garog2.model.GarogModel;
import garog2.view.GarogViewerFrame;

public class GarogMain
{
    public static void main(String[] args)
    {
        GarogModel m = new GarogModel();
        new GarogViewerFrame(m);
    }
}
