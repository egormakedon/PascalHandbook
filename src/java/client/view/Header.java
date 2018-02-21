package client.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Header {
    private JScrollPane scrollPane;
    private JPanel panel;
    private int headerCount;

    Header() {
        panel = new JPanel();
        scrollPane = new JScrollPane(panel);
        setHeader();
    }

    public void update() {
        panel.removeAll();
        headerCount = 0;
        // controller take headers
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    private void setHeader() {
        panel.setLayout(new GridBagLayout());

        scrollPane.setPreferredSize(new Dimension(350,0));
        scrollPane.setSize(new Dimension(350,0));
    }

    private void addHeader(String headerName) {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = headerCount;
        c.weightx = 1.0;
        c.insets = new Insets(0, 0, 20, 0);
        c.anchor = GridBagConstraints.NORTH;
        c.fill = GridBagConstraints.HORIZONTAL;
        headerCount++;

        JButton button = new JButton();
        button.setText(headerName);
        addButtonListener(button);
        panel.add(button, c);
    }

    private void addButtonListener(JButton button) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //   sheck changind state
                ///// add action
            }
        });
    }
}