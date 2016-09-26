package de.henny022.T44100Rechner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * T44-100Rechner, Created by Henny on 25.09.2016.
 */
public class Nation extends JPanel{

    private String name;
    private ENation nation;

    private JLabel labelName = new JLabel();
    private JLabel labelDamage = new JLabel();
    private JLabel labelDamageMean = new JLabel();
    private JLabel labelKills = new JLabel();

    private JTextField textInputNewDamage = new JTextField();

    private ActionListener addDamageListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Stats.getInstance().addDamageToNation(nation, Integer.parseInt(textInputNewDamage.getText()));
            Stats.getInstance().saveStats();
            textInputNewDamage.setText("");
            update();
        }
    };
    private JButton buttonAddDamage = new JButton("<html>Schaden<br>hinzufügen");

    private JTextField textInputNewKills = new JTextField();

    private ActionListener addKillsListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Stats.getInstance().addKillsToNation(nation, Integer.parseInt(textInputNewKills.getText()));
            Stats.getInstance().saveStats();
            textInputNewKills.setText("");
            update();
        }
    };
    private JButton buttonAddKills = new JButton("<html>Kills<br>hinzufügen");

    private ActionListener listenerTimer = e -> update();

    private Timer timer = new Timer(1*1000, listenerTimer);

    public Nation (String name, ENation nation)
    {
        this.name = name;
        this.nation = nation;

        this.textInputNewDamage.addActionListener(addDamageListener);
        this.buttonAddDamage.addActionListener(addDamageListener);
        this.textInputNewKills.addActionListener(addKillsListener);
        this.buttonAddKills.addActionListener(addKillsListener);

        setup();
        timer.start();
    }

    public void update()
    {
        labelName.setText(name);
        labelDamage.setText("<html>Schaden:<br>" + Utils.textColorByProgress(Stats.getInstance().getDamageForNation(nation), (150000*Stats.getInstance().getDaysPast())/38, 150000) + String.valueOf(Stats.getInstance().getDamageForNation(nation)));
        labelDamageMean.setText("<html>Durchschnitt:<br>" + Utils.textColorByProgress(Stats.getInstance().getDamageForNation(nation), (150000*Stats.getInstance().getDaysPast())/38, 150000) + String.valueOf(Stats.getInstance().getDamageForNation(nation)/ Stats.getInstance().getDaysPast()));
        labelKills.setText("<html>Kills:<br>" + Utils.textColorByProgress(Stats.getInstance().getKillsForNation(nation), (150*Stats.getInstance().getDaysPast())/38, 150) + String.valueOf(Stats.getInstance().getKillsForNation(nation)));
    }

    public void setup()
    {
        this.setLayout(new GridLayout(0,1));

        this.add(labelName);
        this.add(labelDamage);
        this.add(labelDamageMean);
        this.add(labelKills);
        this.add(textInputNewDamage);
        this.add(buttonAddDamage);
        this.add(textInputNewKills);
        this.add(buttonAddKills);
    }

}
