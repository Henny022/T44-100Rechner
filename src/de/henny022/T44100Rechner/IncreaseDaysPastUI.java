package de.henny022.T44100Rechner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * T44-100Rechner, Created by Henny on 26.09.2016.
 */
public class IncreaseDaysPastUI extends JFrame
{
    private JLabel labelConfirm = new JLabel("Wirkich den Tag erhöhen?");
    private JButton buttonOK = new JButton("Ja");
    private JButton buttonNein = new JButton("NEIN");
    private ActionListener listenerOK = e -> {
        Stats.getInstance().incrementDaysPast();
        Stats.getInstance().saveStats();
        this.dispose();
    };
    private ActionListener listenerNein = e -> {
        this.dispose();
    };
    public IncreaseDaysPastUI()
    {
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.add(labelConfirm);
        buttonOK.addActionListener(listenerOK);
        this.add(buttonOK);
        buttonNein.addActionListener(listenerNein);
        this.add(buttonNein);
        this.setLocationRelativeTo(null);
        this.setSize(200, 100);
        this.setVisible(true);
    }
}
