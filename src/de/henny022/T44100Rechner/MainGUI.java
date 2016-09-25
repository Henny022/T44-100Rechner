package de.henny022.T44100Rechner;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * T44-100Rechner, Created by Henny on 25.09.2016.
 */
public class MainGUI extends JFrame
{
    private List<Nation> nations = new ArrayList<>(8);


    public MainGUI()
    {
        setup();
        update();
    }

    public void setup()
    {
        nations.add(new Nation("Deutschland", ENation.DEUTSCHLAND));
        nations.add(new Nation("Russland", ENation.RUSSLAND));
        nations.add(new Nation("Amerika", ENation.AMERIKA));
        nations.add(new Nation("Frankreich", ENation.FRANKREICH));
        nations.add(new Nation("Britten", ENation.BRITTEN));
        nations.add(new Nation("China", ENation.CHINA));
        nations.add(new Nation("Japan", ENation.JAPAN));
        nations.add(new Nation("Tschechen", ENation.TSCHECHIEN));

        Container container = this.getContentPane();

        container.setLayout(new GridLayout(1, 0));

        for (Nation nation : nations)
        {
            container.add(nation);
        }

        this.setVisible(true);
    }

    public void update()
    {
        for (Nation nation : nations )
        {
            nation.update();
        }
    }

}
