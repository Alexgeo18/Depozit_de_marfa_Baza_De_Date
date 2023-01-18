import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Informatii extends JFrame{
    private JPanel panel1;
    private JRadioButton radioButton1;
    private JRadioButton afiseazaProduseleSiCategoriaRadioButton;
    private JRadioButton afiseazaAngajatiiSiHalaRadioButton;
    private JButton afiseazaButton;
    private JRadioButton afiseazaMarfaSiFurnizorulRadioButton;
    private JButton inapoiButton;
    private JTable table1;
    private JRadioButton afiseazaSefiiDeHalaRadioButton;
    private JRadioButton afiseazaAngajatiiTineri2002RadioButton;

    Informatii(){
        setTitle("Altele");
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
                dispose();
            }
        });

        afiseazaButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(radioButton1.isSelected()){
                    try {
                        Connection connection = DriverManager.getConnection(url, user, pass);
                        PreparedStatement preparedStatement = connection.prepareStatement("SELECT m.nume_produs,h.Nume_hala FROM Marfa m\n" +
                                "INNER JOIN hale_marfa hm ON  m.id_marfa = hm.id_marfa\n" +
                                "INNER JOIN Hale h on h.Id_hala = hm.id_hala");
                        ResultSet resultSet = preparedStatement.executeQuery();
                        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                        DefaultTableModel model = (DefaultTableModel) table1.getModel();
                        model.setRowCount(1);
                        int cols = resultSetMetaData.getColumnCount();
                        String[] colName = new String[cols];

                        for (int i = 0; i < cols; i++) {
                            colName[i] = resultSetMetaData.getColumnName(i + 1);
                        }
                        model.setColumnIdentifiers(colName);

                        String nume_produs, nume_hala;

                        while (resultSet.next()) {
                            nume_produs = resultSet.getString(1);
                            nume_hala = resultSet.getString(2);

                            String[] row = {nume_produs,nume_hala};
                            model.addRow(row);
                        }




                    } catch (SQLException t) {
                        throw new RuntimeException(t);
                    }

                }
                else if(afiseazaAngajatiiSiHalaRadioButton.isSelected()){
                    try {
                        Connection connection = DriverManager.getConnection(url, user, pass);
                        PreparedStatement preparedStatement = connection.prepareStatement("SELECT  a.Nume,a.Prenume,a.CNP ,h.Nume_hala FROM Angajati a\n" +
                                "                     INNER JOIN Hale h on h.Id_hala = a.id_hala");
                        ResultSet resultSet = preparedStatement.executeQuery();
                        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                        DefaultTableModel model = (DefaultTableModel) table1.getModel();
                        model.setRowCount(0);
                        int cols = resultSetMetaData.getColumnCount();
                        String[] colName = new String[cols];

                        for (int i = 0; i < cols; i++) {
                            colName[i] = resultSetMetaData.getColumnName(i + 1);
                        }
                        model.setColumnIdentifiers(colName);

                        String nume,prenume,cnp, nume_hala;

                        while (resultSet.next()) {
                            nume = resultSet.getString(1);
                            prenume = resultSet.getString(2);
                            cnp = resultSet.getString(3);
                            nume_hala = resultSet.getString(4);

                            String[] row = {nume,prenume,cnp,nume_hala};
                            model.addRow(row);
                        }

                    } catch (SQLException t) {
                        throw new RuntimeException(t);
                    }
                }
                else if (afiseazaProduseleSiCategoriaRadioButton.isSelected()) {
                    try {
                        Connection connection = DriverManager.getConnection(url, user, pass);
                        PreparedStatement preparedStatement = connection.prepareStatement("SELECT m.nume_produs,c.denumire_categorie FROM Marfa m\n" +
                                "INNER JOIN [Categorie Marfa] c ON m.id_categorie = c.id_categorie");
                        ResultSet resultSet = preparedStatement.executeQuery();
                        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                        DefaultTableModel model = (DefaultTableModel) table1.getModel();
                        model.setRowCount(0);
                        int cols = resultSetMetaData.getColumnCount();
                        String[] colName = new String[cols];

                        for (int i = 0; i < cols; i++) {
                            colName[i] = resultSetMetaData.getColumnName(i + 1);
                        }
                        model.setColumnIdentifiers(colName);

                        String nume,denumire;

                        while (resultSet.next()) {
                            nume = resultSet.getString(1);
                            denumire = resultSet.getString(2);
                            String[] row = {nume,denumire};
                            model.addRow(row);
                        }

                    } catch (SQLException t) {
                        throw new RuntimeException(t);
                    }
                }
                else if(afiseazaMarfaSiFurnizorulRadioButton.isSelected()){
                    try {
                        Connection connection = DriverManager.getConnection(url, user, pass);
                        PreparedStatement preparedStatement = connection.prepareStatement("SELECT m.nume_produs,f.nume_furnizor,f.adresa,f.nr_telefon FROM Marfa m\n" +
                                "INNER JOIN Furnizor F on m.id_furnizor = F.id_furnizor");
                        ResultSet resultSet = preparedStatement.executeQuery();
                        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                        DefaultTableModel model = (DefaultTableModel) table1.getModel();
                        model.setRowCount(0);
                        int cols = resultSetMetaData.getColumnCount();
                        String[] colName = new String[cols];

                        for (int i = 0; i < cols; i++) {
                            colName[i] = resultSetMetaData.getColumnName(i + 1);
                        }
                        model.setColumnIdentifiers(colName);

                        String nume_produs,nume_furnizor,adresa,telefon;

                        while (resultSet.next()) {
                            nume_produs = resultSet.getString(1);
                            nume_furnizor = resultSet.getString(2);
                            adresa = resultSet.getString(3);
                            telefon = resultSet.getString(4);
                            String[] row = {nume_produs,nume_furnizor,adresa,telefon};
                            model.addRow(row);
                        }

                    } catch (SQLException t) {
                        throw new RuntimeException(t);
                    }
                }
                else if (afiseazaSefiiDeHalaRadioButton.isSelected()) {

                    try {
                        Connection connection = DriverManager.getConnection(url, user, pass);
                        PreparedStatement preparedStatement = connection.prepareStatement("SELECT h.Nume_hala,A.Nume,A.Prenume  FROM Hale h\n" +
                                "INNER JOIN Angajati A on h.Id_sef_hala = A.Id_angajat");
                        ResultSet resultSet = preparedStatement.executeQuery();
                        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                        DefaultTableModel model = (DefaultTableModel) table1.getModel();
                        model.setRowCount(0);
                        int cols = resultSetMetaData.getColumnCount();
                        String[] colName = new String[cols];

                        for (int i = 0; i < cols; i++) {
                            colName[i] = resultSetMetaData.getColumnName(i + 1);
                        }
                        model.setColumnIdentifiers(colName);

                        String nume_hala,nume,prenume;

                        while (resultSet.next()) {
                            nume_hala = resultSet.getString(1);
                            nume = resultSet.getString(2);
                            prenume = resultSet.getString(3);

                            String[] row = {nume_hala,nume,prenume};
                            model.addRow(row);
                        }

                    } catch (SQLException t) {
                        throw new RuntimeException(t);
                    }
                }
                else if(afiseazaAngajatiiTineri2002RadioButton.isSelected()){
                    try {
                        Connection connection = DriverManager.getConnection(url, user, pass);
                        PreparedStatement preparedStatement = connection.prepareStatement("SELECT  a.Nume,a.Prenume,a.CNP ,h.Nume_hala,CAST(a.Data_nasterii as VARCHAR) FROM Angajati a\n" +
                                "                     INNER JOIN Hale h on h.Id_hala = a.id_hala\n" +
                                "where a.Data_nasterii > '2002-01-01'");
                        ResultSet resultSet = preparedStatement.executeQuery();
                        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                        DefaultTableModel model = (DefaultTableModel) table1.getModel();
                        model.setRowCount(0);
                        int cols = resultSetMetaData.getColumnCount();
                        String[] colName = new String[cols];

                        for (int i = 0; i < cols; i++) {
                            colName[i] = resultSetMetaData.getColumnName(i + 1);
                        }
                        model.setColumnIdentifiers(colName);

                        String cnp,nume,prenume,data;

                        while (resultSet.next()) {

                            nume = resultSet.getString(1);
                            prenume = resultSet.getString(2);
                            cnp = resultSet.getString(3);
                            data = resultSet.getString(4);

                            String[] row = {nume,prenume,cnp,data};
                            model.addRow(row);
                        }

                    } catch (SQLException t) {
                        throw new RuntimeException(t);
                    }
                }

            }
        });

    }

}
