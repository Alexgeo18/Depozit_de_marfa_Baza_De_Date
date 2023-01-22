import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Stergere extends JFrame{
    private JTextField numeProdustextField;
    private JTextField numeAngajatTextField;
    private JButton stergeProdusButton;
    private JButton afiseazaProduseButton;
    private JButton stergeAngajatButton;
    private JButton afiseazaAngajatiButton;
    private JButton inapoiButton;
    private JPanel panel1;

    public Stergere(){
        setTitle("Afisare");
        setContentPane(panel1);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(500, 300));
        setVisible(true);
        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=Depozit marfar;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String pass = "557477";

        inapoiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //menu m= new menu();
                dispose();
            }
        });
        afiseazaProduseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AfisareProduse afisareProduse = new AfisareProduse();
            }

        });

        stergeProdusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try( Connection connection = DriverManager.getConnection(url, user, pass)){


                    //String query = "DELETE FROM Marfa WHERE nume_produs = " + "'" + numeProdustextField.getText()+"'";
                    String query = "DELETE FROM Marfa WHERE nume_produs = ? ";
                    //System.out.println(query);


                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setString(1, numeProdustextField.getText());
                    statement.execute();


                }
                catch(SQLException t){
                    t.printStackTrace();
                }
            }

        });
        afiseazaAngajatiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AfisareAngajati afisareAngajati = new AfisareAngajati();
            }
        });
        stergeAngajatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{

                    Connection connection = DriverManager.getConnection(url, user, pass);
                    String query = "DELETE FROM Angajat WHERE Nume = ?";
                    System.out.println(query);
                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setString(1, numeAngajatTextField.getText());
                    statement.execute();


                }
                catch(SQLException t){
                    t.printStackTrace();
                }
            }
        });
    }
}
