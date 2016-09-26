package de.henny022.T44100Rechner;

import com.blogspot.debukkitsblog.Util.FileStorage;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * T44-100Rechner, Created by Henny on 25.09.2016.
 */
public class Stats {
    private static Stats ourInstance = new Stats();

    public static Stats getInstance() {
        return ourInstance;
    }

    File file = new File("T44-100.stats");


    private Map<ENation, Integer> damagePerNation = new HashMap<>();
    private Map<ENation, Integer> killsPerNation = new HashMap<>();
    private int daysPast;

    private Stats() {
        loadStats();
    }

    public int getDamageForNation(ENation nation)
    {
        return damagePerNation.get(nation);
    }

    public int getKillsForNation(ENation nation)
    {
        return killsPerNation.get(nation);
    }

    public int getDaysPast() {
        return daysPast;
    }

    public int getTotalDamage()
    {
        int damage = 0;
        for (Map.Entry<ENation, Integer> entry : damagePerNation.entrySet())
        {
            damage += entry.getValue();
        }
        return damage;
    }

    public int getTotalKills()
    {
        int kills = 0;
        for (Map.Entry<ENation, Integer> entry : killsPerNation.entrySet())
        {
            kills += entry.getValue();
        }
        return kills;
    }

    public void addDamageToNation(ENation nation, int damage)
    {
        int newDamage = getDamageForNation(nation) + damage;
        if (newDamage > 150000) newDamage = 150000;
        damagePerNation.put(nation, newDamage);
    }

    public void addKillsToNation(ENation nation, int kills)
    {
        int newKills = getKillsForNation(nation) + kills;
        if (newKills > 150) newKills = 150;
        killsPerNation.put(nation, newKills);
    }

    public void incrementDaysPast()
    {
        daysPast++;
    }

    public void saveStats()
    {
        try {
            FileStorage fs = new FileStorage(file);
            fs.store("damagePerNation", damagePerNation);
            fs.store("killsPerNation", killsPerNation);
            fs.store("daysPast", daysPast);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "FileStorage could not be created");
            e.printStackTrace();
        }
    }

    private void loadStats()
    {
        if (file.exists()){
            try {
                FileStorage fs = new FileStorage(file);
                damagePerNation = (Map<ENation, Integer>) fs.get("damagePerNation");
                killsPerNation = (Map<ENation, Integer>) fs.get("killsPerNation");
                daysPast = (int) fs.get("daysPast");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "FileStorage could not be created");
                e.printStackTrace();
            }
        } else {
            damagePerNation.put(ENation.AMERIKA, 0);
            damagePerNation.put(ENation.BRITTEN, 0);
            damagePerNation.put(ENation.CHINA, 0);
            damagePerNation.put(ENation.DEUTSCHLAND, 0);
            damagePerNation.put(ENation.FRANKREICH, 0);
            damagePerNation.put(ENation.JAPAN, 0);
            damagePerNation.put(ENation.RUSSLAND, 0);
            damagePerNation.put(ENation.TSCHECHIEN, 0);

            killsPerNation.put(ENation.AMERIKA, 0);
            killsPerNation.put(ENation.BRITTEN, 0);
            killsPerNation.put(ENation.CHINA, 0);
            killsPerNation.put(ENation.DEUTSCHLAND, 0);
            killsPerNation.put(ENation.FRANKREICH, 0);
            killsPerNation.put(ENation.JAPAN, 0);
            killsPerNation.put(ENation.RUSSLAND, 0);
            killsPerNation.put(ENation.TSCHECHIEN, 0);

            daysPast = 1;
            saveStats();
        }



    }
}
