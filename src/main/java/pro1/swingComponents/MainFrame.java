package pro1.swingComponents;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private final DisplayPanel displayPanel;

    public MainFrame() {
        this.setTitle("PRO1 - Projekt 3: Lomena cara");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        // Vytvor hlavni kreslici panel
        this.displayPanel = new DisplayPanel();
        this.add(this.displayPanel, BorderLayout.CENTER);

        // Vytvor ovladaci panel vlevo
        OptionsPanel levyPanel = new OptionsPanel(this);
        this.add(levyPanel, BorderLayout.WEST);

        // Zobraz okno v celem stavu obrazovky
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
    }

    public void nastavTloustku(int tloustka) {
        this.displayPanel.nastavTloustku(tloustka);
        this.showExample();
    }

    public void nastavBarvu(Color barva) {
        this.displayPanel.nastavBarvu(barva);
        this.showExample();
    }

    public void zpet() {
        this.displayPanel.odeberPosledniBod();
        this.showExample();
    }

    public void reset() {
        this.displayPanel.resetujBody();
        this.showExample();
    }

    public void showExample() {
        this.displayPanel.repaint();
    }
}