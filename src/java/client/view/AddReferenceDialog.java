package client.view;

import client.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AddReferenceDialog {
    private static final String IMAGE_ICON_PATH = File.separator + "img" + File.separator + "pascalIco.png";

    private Header header;

    private JDialog dialog;
    private JTextField title;
    private JTextArea body;

    AddReferenceDialog(Header header) {
        this.header = header;

        dialog = new JDialog();
        setDialog();

        title = new JTextField();
        body = new JTextArea();
        setMainContent();

        setButton();
    }

    public void show() {
        dialog.setVisible(true);
    }

    private void setDialog() {
        dialog.setLayout(new BorderLayout());
        dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        dialog.setMinimumSize(new Dimension(500, 500));
        dialog.setResizable(true);
        dialog.setTitle("Add reference");
        dialog.setIconImage(new ImageIcon(this.getClass().getResource(IMAGE_ICON_PATH)).getImage());
        dialog.setLocationRelativeTo(null);
    }

    private void setMainContent() {
        title.setToolTipText("Title");
        body.setToolTipText("Body");

        dialog.add(title, BorderLayout.NORTH);
        dialog.add(new JScrollPane(body), BorderLayout.CENTER);
    }

    private void setButton() {
        JButton button = new JButton();
        button.setText("add");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditingState editingState = EditingState.getInstance();
                if (editingState.getState().equals(EditingState.State.ENABLE)) {
                    return;
                }

                int result = JOptionPane.showConfirmDialog(dialog, "Are you sure?");
                if (result == 0) {
                    String currentTitle = title.getText();
                    String currentBody = body.getText();

                    String answer = Controller.getInstance().add(currentTitle, currentBody);
                    header.update();
                    JOptionPane.showMessageDialog(dialog, answer);
                }
            }
        });

        dialog.add(button, BorderLayout.SOUTH);
    }
}
