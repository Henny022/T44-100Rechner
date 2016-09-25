package de.henny022.T44100Rechner;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * T44-100Rechner, Created by Henny on 25.09.2016.
 */
public class Nation extends JPanel{

    private String name;
    private ENation nation;
    private int damage;

    private JLabel labelName;
    private JLabel labelDamage;
    private JLabel labelDamageMean;

    private JTextField textInputNewDamage;

    private JButton buttonAddDamage;
    private ActionListener addDamageListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Stats.getInstance().addDamageToNation(nation, Integer.parseInt(textInputNewDamage.getText()));
            Stats.getInstance().saveStats();
        }
    };

    public Nation (String name, ENation nation)
    {
        this.name = name;
        this.nation = nation;
        this.damage = Stats.getInstance().getDamageForNation(this.nation);

        setup();
        update();
    }

    public void update()
    {
        labelName.setText(name);
        labelDamage.setText(String.valueOf(damage));
        labelDamageMean.setText(String.valueOf(damage/ Stats.getInstance().getKillsForNation(nation)));

    }

    public void setup()
    {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(labelName);
        this.add(labelDamage);
        this.add(labelDamageMean);
        this.add(textInputNewDamage);
        this.add(buttonAddDamage);
    }

}
