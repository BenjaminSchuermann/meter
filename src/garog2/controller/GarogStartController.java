package garog2.controller;

import garog2.model.GarogModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import javax.swing.JToggleButton;

public class GarogStartController implements ActionListener

{
    private GarogModel m;

    private Runnable task;

    private ScheduledExecutorService executor;

    private ScheduledFuture<?> future;

    public GarogStartController(Runnable task, GarogModel m)
    {
        this.m = m;
        this.task = task;
        executor = Executors.newSingleThreadScheduledExecutor();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        // Je nach Zustand den Text des Buttons ändern und den Timer
        // starten/stoppen
        m.setStartstop(((JToggleButton) e.getSource()).isSelected());
        if (((JToggleButton) e.getSource()).isSelected())
        {
            ((JToggleButton) e.getSource()).setText("Stop");
            future = executor.scheduleAtFixedRate(task, 0, 10, TimeUnit.MILLISECONDS);
        }
        else
        {
            ((JToggleButton) e.getSource()).setText("Start");
            future.cancel(true);
        }
    }
}