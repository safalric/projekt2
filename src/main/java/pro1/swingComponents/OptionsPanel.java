package pro1.swingComponents;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionsPanel extends JPanel {

    private final MainFrame rodic;

    public OptionsPanel(MainFrame rodicMainFrame) {
        this.rodic = rodicMainFrame;

        // Nastav layout a sirku panelu
        this.setPreferredSize(new Dimension(250, 0));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Vytvor prvky ovladani
        JLabel popisekTloustky = new JLabel("Tloustka cary:");
        final JSlider posuvnikTlousky = new JSlider(JSlider.HORIZONTAL, 1, 20, 2);
        posuvnikTlousky.setMajorTickSpacing(1);
        posuvnikTlousky.setPaintTicks(true);
        posuvnikTlousky.setPaintLabels(true);

        final JCheckBox zaskrtavatkoCervene = new JCheckBox("Cervena cara");

        JButton tlacitkoZpet = new JButton("Zpet");
        JButton tlacitkoReset = new JButton("Reset");

        // Registruj posluchace pro zmeny
        posuvnikTlousky.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int hodnota = posuvnikTlousky.getValue();
                OptionsPanel.this.rodic.nastavTloustku(hodnota);
            }
        });

        zaskrtavatkoCervene.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean zvoleno = zaskrtavatkoCervene.isSelected();
                if (zvoleno) {
                    OptionsPanel.this.rodic.nastavBarvu(Color.RED);
                } else {
                    OptionsPanel.this.rodic.nastavBarvu(Color.GRAY);
                }
            }
        });

        tlacitkoZpet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OptionsPanel.this.rodic.zpet();
            }
        });

        tlacitkoReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OptionsPanel.this.rodic.reset();
            }
        });

        // Nastav zarovnani prvku vlevo
        popisekTloustky.setAlignmentX(Component.LEFT_ALIGNMENT);
        posuvnikTlousky.setAlignmentX(Component.LEFT_ALIGNMENT);
        zaskrtavatkoCervene.setAlignmentX(Component.LEFT_ALIGNMENT);
        tlacitkoZpet.setAlignmentX(Component.LEFT_ALIGNMENT);
        tlacitkoReset.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Pridej prvky do panelu s odstupy
        this.add(popisekTloustky);
        this.add(Box.createVerticalStrut(8));
        this.add(posuvnikTlousky);
        this.add(Box.createVerticalStrut(20));
        this.add(zaskrtavatkoCervene);
        this.add(Box.createVerticalStrut(20));
        this.add(tlacitkoZpet);
        this.add(Box.createVerticalStrut(8));
        this.add(tlacitkoReset);
        this.add(Box.createVerticalGlue());
    }
}
