import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Locale;
import java.util.ResourceBundle;

public class Home extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;

    public Home() {
        super("Home");
        createGUI();
    }

    public void createGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton button1 = new JButton();
        ImageIcon icon1 = new ImageIcon("D:\\ITEA66613\\lesson2\\Номе_pic\\ukraine_flag_labels_03_64.png");
        button1.setIcon(icon1);
        button1.setActionCommand("Кнопка натиснута!");
        panel.add(button1);

        textField1 = new JTextField();
        textField1.setColumns(23);
        panel.add(textField1);

        JButton button2 = new JButton();
        ImageIcon icon2 = new ImageIcon("D:\\ITEA66613\\lesson2\\Номе_pic\\united_kingdom_flag_labels_03_64.png");
        button2.setIcon(icon2);
        button2.setActionCommand("Button was pressed!");
        panel.add(button2);
        textField2 = new JTextField();
        textField2.setColumns(23);
        panel.add(textField2);

        JButton button3 = new JButton();
        ImageIcon icon3 = new ImageIcon("D:\\ITEA66613\\lesson2\\Номе_pic\\russia_flag_labels_03_64.png");
        button3.setIcon(icon3);

        button3.setActionCommand("Кнопка нажата!");
        panel.add(button3);
        textField3 = new JTextField();
        textField3.setColumns(23);
        panel.add(textField3);

        ActionListener actionListener = new TestActionListener();
        button1.addActionListener(e -> {
            String language = "ua";
            String country = "UA";
            Locale locale = new Locale(language, country);
            ResourceBundle bundle =
                    ResourceBundle.getBundle("Ua",
                            locale);
            System.out.println(locale + "; Name=" +
                    bundle.getString("name"));
            textField1.setText(e.getActionCommand());
        });

        button2.addActionListener(e -> {
            String language = "en";
            String country = "EN";
            Locale locale = new Locale(language, country);
            ResourceBundle bundle =
                    ResourceBundle.getBundle("Eng",
                            locale);
            System.out.println(locale + "; Name=" +
                    bundle.getString("name"));
            textField2.setText(e.getActionCommand());
        });

        button3.addActionListener(e -> {
            String language = "ru";
            String country = "Ru";
            Locale locale = new Locale(language, country);
            ResourceBundle bundle =
                    ResourceBundle.getBundle("Ru",
                            locale);
            System.out.println(locale + "; Name=" +
                    bundle.getString("name"));
            textField3.setText(e.getActionCommand());
        });
        JButton button4 = new JButton("Load");
        button4.addActionListener(e -> {
            JFileChooser fileopen = new JFileChooser();
            int ret1 = fileopen.showDialog(fileopen, "Відкрити файл");
            try {
                FileInputStream fis = new FileInputStream(String.valueOf(ret1));
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            //FileReader reader = new FileReader();
        });
        panel.add(button4);
        JButton button5 = new JButton("Save");
        button5.addActionListener(e -> {
            JFileChooser filesave = new JFileChooser();
            int ret2 = filesave.showDialog(filesave, "Зберегти файл");
            try {
                FileOutputStream fos = new FileOutputStream(String.valueOf(ret2)) ;
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            // FileWriter writer = new FileWriter();
        });
        panel.add(button5);
        getContentPane().add(panel);
        setPreferredSize(new Dimension(400, 300));
    }

    public class TestActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            textField1.setText(e.getActionCommand());
            textField2.setText(e.getActionCommand());
            textField3.setText(e.getActionCommand());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                JFrame.setDefaultLookAndFeelDecorated(true);
                Home frame = new Home();
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}

