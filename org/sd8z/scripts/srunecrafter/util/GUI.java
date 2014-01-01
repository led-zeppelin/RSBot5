package org.sd8z.scripts.srunecrafter.util;

import org.sd8z.scripts.srunecrafter.SRunecrafter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {

    private JPanel contentPane;

    public GUI(final SRunecrafter script) {
        setTitle("sRunecrafter");
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 237, 156);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("sRunecrafter");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(10, 11, 211, 14);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("AIO F2P Runecrafter");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(10, 36, 211, 14);
        contentPane.add(lblNewLabel_1);

        final JComboBox<Data> cmbRune = new JComboBox<Data>(Data.values());
        cmbRune.setBounds(65, 61, 98, 20);
        contentPane.add(cmbRune);

        JButton btnStart = new JButton("Start");
        btnStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                script.submit((Data) cmbRune.getSelectedItem());
                dispose();
            }
        });
        btnStart.setBounds(65, 92, 98, 23);
        contentPane.add(btnStart);
    }
}
