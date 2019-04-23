package lesson4.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChatGui extends JFrame {

    public ChatGui() throws HeadlessException {
        setTitle("MyChat");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setResizable(false);
        setLocationByPlatform(true);

        JMenuBar jMenuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        JMenu menuHelp = new JMenu("Help");
        jMenuBar.add(menuFile);
        jMenuBar.add(menuHelp);

        JMenuItem menuFileItem1 = new JMenuItem("Exit");
        menuFile.add(menuFileItem1);
        menuFileItem1.addActionListener(e -> System.exit(0));
        JMenuItem menuHelpItem1 = new JMenuItem("About");
        menuHelp.add(menuHelpItem1);
        menuHelpItem1.addActionListener(e -> {AboutGui aboutGui = new AboutGui();});

        JTextArea jTextArea = new JTextArea();
        JScrollPane jScrollPane = new JScrollPane(jTextArea);
        JTextField jTextField = new JTextField(25);

        ActionListener sendListener = e -> {
                jTextArea.append(getDate("HH:mm:ss") + " Me: " + jTextField.getText() + "\n");
                jTextField.setText(null);
        };
        jTextField.addActionListener(sendListener);

        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(sendListener);

        JPanel flow = new JPanel(new FlowLayout(FlowLayout.LEFT));
        flow.add(jTextField);
        flow.add(sendButton);
        getContentPane().add(flow, BorderLayout.SOUTH);
        getContentPane().add(BorderLayout.NORTH, jMenuBar);
        getContentPane().add(BorderLayout.CENTER, jScrollPane);

        setVisible(true);
    }

    private String getDate(String format){
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(new Date());
    }
}
