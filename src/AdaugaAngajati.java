import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AdaugaAngajati extends JFrame{
    private JTextField numeField;
    private JTextField prenumeField;
    private JTextField dataNasteriiField;
    private JTextField sexField;
    private JTextField cnpField;
    private JTextField nrDeTelefonField6;
    private JTextField idAngajatField;
    private JTextField idHalaField;
    private JButton adaugaAngajatButton;
    private JButton inapoiButton;
    private JButton afiseazaAngajatiButton;
    private JPanel adaugaAngajati;

    public AdaugaAngajati(){
        setTitle("Adaugare Angajati");
        setContentPane(adaugaAngajati);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(500, 650));
        setVisible(true);

        adaugaAngajatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String url = "jdbc:sqlserver://localhost:1433;DatabaseName=Depozit marfar;encrypt=true;trustServerCertificate=true";
                    String user = "sa";
                    String pass = "557477";
                    Connection connection = DriverManager.getConnection(url, user, pass);

                    String query = " SET IDENTITY_INSERT Angajati ON\n" +
                            "INSERT INTO Angajati (Id_angajat, Nume, Prenume, Id_hala, Data_nasterii, Sex, CNP, nr_telefon) Values (?,?,?,?,?,?,?,?)";
                    PreparedStatement statement = connection.prepareStatement(query);

                    int id_angajat = Integer.valueOf(AdaugaAngajati.this.idAngajatField.getText());
                    String nume  = numeField.getText();
                    String prenume = prenumeField.getText();
                    int id_hala = Integer.valueOf(AdaugaAngajati.this.idHalaField.getText());
                    String sex = sexField.getText();
                    String data = dataNasteriiField.getText();
                    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    Date data1 = formatter.parse(data);
                    java.sql.Date sqlData = new java.sql.Date(data1.getTime());

                    String cnp = cnpField.getText();
                    String nrtelefon = nrDeTelefonField6.getText();

                    statement.setInt(1, id_angajat);
                    statement.setString(2, nume);
                    statement.setString(3, prenume);
                    statement.setInt(4, id_hala);
                    statement.setString(6, sex);
                    statement.setDate(5, sqlData);
                    statement.setString(7, cnp);
                    statement.setString(8, nrtelefon);
                    statement.execute();



                }
                catch(SQLException | ParseException t){
                    t.printStackTrace();
                }
            }



        });

        inapoiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu m= new menu();
                dispose();
            }
        });
        afiseazaAngajatiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AfisareAngajati afisareAngajati = new AfisareAngajati();

            }
        });
    }

    }


