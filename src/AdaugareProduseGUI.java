
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class AdaugareProduseGUI extends JFrame{
    private JTextField idFurnizorTextField;
    private JTextField idCategorieTextField;
    private JTextField numeProdusTextField;
    private JTextField descriereTextField;
    private JTextField costStocareTextField;
    private JTextField cantitateTextField;
    private JTextField dataDeIntrareInDepozitTextField;
    private JPanel adaugareProduse;
    private JButton adaugaProdusButton;
    private JButton inapoiButton;
    private JTextField idMarfaTextField;
    private JButton afiseazaProduseButton;
    private JButton afiseazaProduseSiHalaButton;

    public AdaugareProduseGUI(){
        setTitle("Adaugare");
        setContentPane(adaugareProduse);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(500, 650));
        setVisible(true);

        adaugaProdusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String url = "jdbc:sqlserver://localhost:1433;DatabaseName=Depozit marfar;encrypt=true;trustServerCertificate=true";
                    String user = "sa";
                    String pass = "557477";
                    Connection connection = DriverManager.getConnection(url, user, pass);

                    String query = " SET IDENTITY_INSERT Marfa ON\n" +
                            "INSERT INTO Marfa (id_marfa,id_furnizor, id_categorie, nume_produs, descriere, cost_stocare, cantitate, data_intrare_depozit)VALUES (?,?,?,?,?,?,?,?)";
                    PreparedStatement statement = connection.prepareStatement(query);

                    int id_marfa = Integer.valueOf(AdaugareProduseGUI.this.idMarfaTextField.getText());

                    int id_furnizor = Integer.valueOf(AdaugareProduseGUI.this.idFurnizorTextField.getText());
                    int id_categorie = Integer.valueOf(AdaugareProduseGUI.this.idCategorieTextField.getText());
                    String nume_produs = numeProdusTextField.getText();
                    String descriere = descriereTextField.getText();
                    float cost_stocare = Float.parseFloat(costStocareTextField.getText());
                    float cantitate = Float.parseFloat(cantitateTextField.getText());
                    String data = dataDeIntrareInDepozitTextField.getText();
                    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    Date data1 = formatter.parse(data);
                    java.sql.Date sqlData = new java.sql.Date(data1.getTime());

                    statement.setInt(1, id_marfa);
                    statement.setInt(2, id_furnizor);
                    statement.setInt(3, id_categorie);
                    statement.setString(4, nume_produs);
                    statement.setString(5, descriere);
                    statement.setFloat(6, cost_stocare);
                    statement.setFloat(7, cantitate);
                    statement.setDate(8, sqlData);
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
        afiseazaProduseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    AfisareProduse afisareProduse = new AfisareProduse();

            }
        });

        afiseazaProduseSiHalaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    AfisareProdusesiHale afisareProdusesiHale = new AfisareProdusesiHale();
            }
        });
    }



}
