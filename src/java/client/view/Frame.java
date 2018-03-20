package client.view;

import client.Controller;
import client.model.CurrentPage;
import client.model.EditingState;
import client.model.ServerType;

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
    private JLabel image;
    private JLabel name;
    private JLabel surname;
    private JLabel country;
    private JLabel date;

    public Frame() {
        frame = new JFrame();
        mainPanel = new JPanel();
        setFrame();

        header = new Header();
        setHeader();

        setButtonManager();

        tittle = new JLabel();
        body = new JTextArea();
        name = new JLabel();
        surname = new JLabel();
        country = new JLabel();
        date = new JLabel();
        image = new JLabel();

        setMainPanel();
    }

    public void show() {
        frame.setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        CurrentPage currentPage = CurrentPage.getInstance();

        tittle.setText("title: " + currentPage.getTitle() + "; ");
        body.setText(currentPage.getBody());

//        String imagePath = currentPage.getPath();
//        File file = new File(imagePath);
//        BufferedImage bufferedImage = new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB);
//        try {
//            bufferedImage = ImageIO.read(file);
//        } catch (IOException e) {
//            LOGGER.fatal(e);
//            throw new RuntimeException(e);
//        }
//        image = new JLabel(new ImageIcon(bufferedImage));

        name.setText("author name: " + currentPage.getName() + "; ");
        surname.setText("author surname: " + currentPage.getSurname() + "; ");
        country.setText("author country: " + currentPage.getCountry() + "; ");
        date.setText("date: " + currentPage.getDate().toString() + ";");
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

        JButton changeServerTypeButton = new JButton();
        changeServerTypeButton.setText("change server type");

        JLabel serverTypeLabel = new JLabel();
        serverTypeLabel.setText("RPC");

        panel.add(addButton);
        panel.add(editButton);
        panel.add(eraseButton);
        panel.add(changeServerTypeButton);
        panel.add(serverTypeLabel);
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
                if (CurrentPage.getInstance().getTitle().equals("")) {
                    return;
                }

                EditingState editingState = EditingState.getInstance();
                if (editingState.getState().equals(EditingState.State.ENABLE)) {
                    int id = CurrentPage.getInstance().getArticleId();
                    Controller.getInstance().update(id, body.getText());
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
                if (CurrentPage.getInstance().getTitle().equals("")) {
                    return;
                }

                EditingState editingState = EditingState.getInstance();
                if (editingState.getState().equals(EditingState.State.ENABLE)) {
                    return;
                }

                int result = JOptionPane.showConfirmDialog(frame, "Are you sure?");
                if (result == 0) {
                    int id = CurrentPage.getInstance().getArticleId();
                    String answer = Controller.getInstance().delete(id);
                    header.update();
                    JOptionPane.showMessageDialog(frame, answer);
                }
            }
        });

        changeServerTypeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditingState editingState = EditingState.getInstance();
                if (editingState.getState().equals(EditingState.State.ENABLE)) {
                    return;
                }

                ServerType serverType = ServerType.getInstance();
                serverType.changeServerType();
                serverTypeLabel.setText(serverType.getServerType().toString());
            }
        });
    }

    private void setMainPanel() {
        tittle.setFont(new Font("Times New Roman", Font.BOLD, 15));
        name.setFont(new Font("Times New Roman", Font.BOLD, 15));
        surname.setFont(new Font("Times New Roman", Font.BOLD, 15));
        country.setFont(new Font("Times New Roman", Font.BOLD, 15));
        date.setFont(new Font("Times New Roman", Font.BOLD, 15));

        body.setFont(new Font("Times New Roman", Font.ITALIC, 11));
        body.setEnabled(false);
        body.setBackground(Color.BLACK);

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout());
        titlePanel.setSize(new Dimension(0, 50));
        titlePanel.setPreferredSize(new Dimension(0, 50));

//        titlePanel.add(image);
        titlePanel.add(tittle);
        titlePanel.add(name);
        titlePanel.add(surname);
        titlePanel.add(country);
        titlePanel.add(date);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(titlePanel, BorderLayout.NORTH);
        panel.add(new JScrollPane(body), BorderLayout.CENTER);
        mainPanel.add(panel, BorderLayout.CENTER);
    }
}