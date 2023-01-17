import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class menu extends JFrame{

    private JPanel adminPanel;
    private JButton interogariComplexeButton;
    private JButton updateButton;
    private JButton stergeProduseButton;
    private JButton adaugaAngajatiButton;
    private JButton VEDEMCEOFIButton;
    private JButton adaugaProdusButton;
    //private JButton adaugaProdusButton;






    public menu() {
        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=Depozit marfar;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String pass = "557477";
        setTitle("Admin page");
        setContentPane(adminPanel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(1000, 1000));
        setVisible(true);

        /*
        JFrame frame = new JFrame("Background Image Example");
        ImageIcon imageIcon = new ImageIcon("dog.bmp");
        JLabel imageLabel = new JLabel(imageIcon);

        adminPanel.add(imageLabel, BorderLayout.CENTER);
        frame.setContentPane(adminPanel);

        // Set the size and location of the frame
        frame.setPreferredSize(new Dimension(400, 300));
        frame.pack();
        frame.setLocationRelativeTo(null);

         */



        adaugaProdusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdaugareProduseGUI adaugareProduseGUI = new AdaugareProduseGUI();
                setVisible(false);
            }
        });

        stergeProduseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Stergere stergere = new Stergere();
                setVisible(false);
            }
        });
        adaugaAngajatiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdaugaAngajati adaugaAngajati = new AdaugaAngajati();
                setVisible(false);
            }
        });
        VEDEMCEOFIButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    VEDEMCEOFI vedemceofi = new VEDEMCEOFI();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Update update = new Update();
            }
        });

        interogariComplexeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterogariComplexe interogariComplexe = new InterogariComplexe();
            }
        });
    }
}
