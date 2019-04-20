package lesson4.gui;

import javax.swing.*;
import java.awt.*;

public class AboutGui extends JFrame{

    public AboutGui() throws HeadlessException {
        setTitle("About");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(250, 100);
        setResizable(false);
        setLocationByPlatform(true);

        JTextPane jTextPane = new JTextPane();
        jTextPane.setText("Made by me");

        JButton okButton = new JButton("OK");
        okButton.addActionListener(e -> dispose());

        getContentPane().add(BorderLayout.CENTER, jTextPane);
        JPanel grid = new JPanel(new GridLayout(1, 2, 5, 0) );
        grid.add(okButton);
        JPanel flow = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        flow.add(grid);
        getContentPane().add(flow, BorderLayout.SOUTH);

        setVisible(true);
    }
}
