package pro1.swingComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class DisplayPanel extends JPanel {

    private final ArrayList<Point> seznamBodu;
    private int tloustka;
    private Color barva;

    public DisplayPanel() {
        this.seznamBodu = new ArrayList<>();
        this.tloustka = 2;
        this.barva = Color.GRAY;
        this.setBackground(Color.WHITE);

        // Naslouchaci pro klikani do displeje - prida bod pouze pokud kliknu do tohoto panelu
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                seznamBodu.add(new Point(e.getX(), e.getY()));
                repaint();
            }
        });
    }

    public void nastavTloustku(int novaTloustka) {
        this.tloustka = Math.max(1, novaTloustka);
        repaint();
    }

    public void nastavBarvu(Color novaBarva) {
        this.barva = novaBarva;
        repaint();
    }

    public void odeberPosledniBod() {
        // Osetri pripad, kdy je seznam jiz prazdny
        if (!this.seznamBodu.isEmpty()) {
            this.seznamBodu.remove(this.seznamBodu.size() - 1);
        }
        repaint();
    }

    public void resetujBody() {
        this.seznamBodu.clear();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(this.barva);
        g2.setStroke(new BasicStroke(this.tloustka));

        // Vykresli lomenou caru ze seznamu bodu - toto zajistuje persistenci
        for (int i = 1; i < this.seznamBodu.size(); i++) {
            Point prvniBod = this.seznamBodu.get(i - 1);
            Point druhyBod = this.seznamBodu.get(i);
            g2.drawLine(prvniBod.x, prvniBod.y, druhyBod.x, druhyBod.y);
        }
    }
}