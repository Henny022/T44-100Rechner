package de.henny022.T44100Rechner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by henny on 26.09.16.
 */
public class Total extends JPanel
{
    private String name;

    private JLabel labelName = new JLabel();
    private JLabel labelDamage = new JLabel();
    private JLabel labelDamageMean = new JLabel();
    private JLabel labelKills = new JLabel();
    private JLabel labelDaysPast = new JLabel();

    private ActionListener listenerIncrementDaysPast = e -> {
        Stats.getInstance().incrementDaysPast();
        update();
        Stats.getInstance().saveStats();
    };
    private JButton buttonIncrementDaysPast = new JButton("<html>Nächster<br>Tag");

    private ActionListener listenerTimer = e -> update();

    private Timer timer = new Timer(1*1000, listenerTimer);

    public Total() {
        name = "Gesamt";
        setup();
        update();
        timer.start();
    }

    private void setup()
    {
        this.setLayout(new GridLayout(0,1));
        labelName.setText(name);

        this.add(labelName);
        this.add(labelDamage);
        this.add(labelDamageMean);
        this.add(labelKills);
        this.add(Box.createHorizontalBox());
        this.add(Box.createHorizontalBox());
        this.add(labelDaysPast);
        this.add(buttonIncrementDaysPast);

        buttonIncrementDaysPast.addActionListener(listenerIncrementDaysPast);
    }

    public void update()
    {
        labelDamage.setText("<html>Schaden:<br>" + Utils.textColorByProgress(Stats.getInstance().getTotalDamage(), (150000*8*Stats.getInstance().getDaysPast())/38, 150000*8) + String.valueOf(Stats.getInstance().getTotalDamage()));
        labelDamageMean.setText("<html>Durchschnitt:<br>" + Utils.textColorByProgress(Stats.getInstance().getTotalDamage(), (150000*8*Stats.getInstance().getDaysPast())/38, Integer.MAX_VALUE) + String.valueOf(Stats.getInstance().getTotalDamage()/Stats.getInstance().getDaysPast()));
        labelKills.setText("<html>Kills:<br>" + Utils.textColorByProgress(Stats.getInstance().getTotalKills(), (150*8*Stats.getInstance().getDaysPast())/38, 150*8) + String.valueOf(Stats.getInstance().getTotalKills()));
        labelDaysPast.setText("<html>Tag " + String.valueOf(Stats.getInstance().getDaysPast()));
    }

}
