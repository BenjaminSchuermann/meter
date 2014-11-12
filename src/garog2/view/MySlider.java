package garog2.view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by Menog on 12.11.2014.
 */
public class MySlider extends JSlider {

    public MySlider(int orientation, int min, int max, int value) {
        this.setOrientation(orientation);
        this.setMinimum(min);
        this.setMaximum(max);
        this.setValue(value);
        this.setForeground(Color.BLACK);
        this.setBackground(Color.WHITE);
        Border line = new LineBorder(Color.BLACK);
        Border margin = new EmptyBorder(5, 15, 5, 15);
        Border compound = new CompoundBorder(line, margin);
        this.setBorder(compound);
    }


}
