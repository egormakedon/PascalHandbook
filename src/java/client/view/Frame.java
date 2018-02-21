package client.view;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Frame {
    private static final String IMAGE_ICON_PATH = File.separator + "img" + File.separator + "pascalIco.png";

    private JFrame frame;
    private JPanel mainPanel;
    private Header header;

    private JLabel tittle;
    private JTextArea body;

    public Frame() {
        frame = new JFrame();
        mainPanel = new JPanel();
        setFrame();

        header = new Header();
        setHeader();

        setButtonManager();

        tittle = new JLabel();
        body = new JTextArea();
        setTittleBody();
    }

    public void show() {
        frame.setVisible(true);
    }

    private void setFrame() {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Pascal Handbook");
        frame.setMinimumSize(new Dimension(1050, 700));
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setIconImage(new ImageIcon(this.getClass().getResource(IMAGE_ICON_PATH)).getImage());

        mainPanel.setLayout(new BorderLayout());
        frame.add(mainPanel, BorderLayout.CENTER);
    }

    private void setHeader() {
        header.update();
        frame.add(header.getScrollPane(), BorderLayout.WEST);
    }

    private void setButtonManager() {
        JPanel panel = new JPanel();
        JButton addButton = new JButton();
        addButton.setText("add");

        JButton editButton = new JButton();
        editButton.setText("edit");

        JButton eraseButton = new JButton();
        eraseButton.setText("erase");

        panel.add(addButton);
        panel.add(editButton);
        panel.add(eraseButton);
        mainPanel.add(panel, BorderLayout.NORTH);

        // add listeners
    }

    private void setTittleBody() {
        tittle.setFont(new Font("Times New Roman", Font.BOLD, 64));
        body.setFont(new Font("Times New Roman", Font.ITALIC, 32));
        body.setEnabled(false);
        body.setBackground(Color.BLACK);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(tittle, BorderLayout.NORTH);
        panel.add(new JScrollPane(body), BorderLayout.CENTER);
        mainPanel.add(panel, BorderLayout.CENTER);
    }
}