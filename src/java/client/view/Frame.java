package client.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Observable;
import java.util.Observer;

public class Frame implements Observer {
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

    @Override
    public void update(Observable o, Object arg) {
        CurrentPage currentPage = CurrentPage.getInstance();
        tittle.setText(currentPage.getCurrentTittle());
        body.setText(currentPage.getCurrentBody());
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

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditingState editingState = EditingState.getInstance();
                if (editingState.getState().equals(EditingState.State.ENABLE)) {
                    return;
                }

                AddReferenceDialog dialog = new AddReferenceDialog(header);
                dialog.show();
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (CurrentPage.getInstance().getCurrentTittle().equals("")) {
                    return;
                }

                EditingState editingState = EditingState.getInstance();
                if (editingState.getState().equals(EditingState.State.ENABLE)) {
                    // Controller change body

                    editingState.setState(EditingState.State.DISABLE);
                    editButton.setText("edit");
                    body.setEnabled(false);
                    body.setBackground(Color.BLACK);
                } else if (editingState.getState().equals(EditingState.State.DISABLE)) {
                    editingState.setState(EditingState.State.ENABLE);
                    editButton.setText("save");
                    body.setEnabled(true);
                    body.setBackground(Color.GRAY);
                }
            }
        });

        eraseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditingState editingState = EditingState.getInstance();
                if (editingState.getState().equals(EditingState.State.ENABLE)) {
                    return;
                }
                /////
            }
        });
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