package de.henny022.T44100Rechner;

import javax.swing.*;

/**
 * T44-100Rechner, Created by Henny on 25.09.2016.
 */
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainGUI();
            }
        });
    }

}
