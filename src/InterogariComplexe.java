import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class InterogariComplexe extends  JFrame{
    private JRadioButton produseleCareAuFostRadioButton;
    private JRadioButton afiseazaNumeleSiPrenumeleRadioButton;
    private JRadioButton top3SalariiRadioButton;
    private JRadioButton aflatiAngajatiiCareAuRadioButton;
    private JButton afiseazaButton;
    private JButton inapoiButton;
    private JTable table1;
    private JPanel panel1;
    InterogariComplexe(){
        setTitle("Interogari Complexe");
        setContentPane(panel1);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(1000, 800));
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
                if(produseleCareAuFostRadioButton.isSelected()){
                    try {
                        Connection connection = DriverManager.getConnection(url, user, pass);
                        PreparedStatement preparedStatement = connection.prepareStatement("SELECT nume_produs,descriere,data_intrare_depozit FROM Marfa\n" +
                                "WHERE data_intrare_depozit <= (\n" +
                                "    SELECT data_intrare_depozit FROM Marfa WHERE nume_produs = 'Galaxy S22')\n" +
                                "ORDER BY data_intrare_depozit DESC;");
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

                        String nume_produs, descriere,data;
                        //DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        //Date data_intrare_depozit= formatter.parse();
                        while (resultSet.next()) {
                            nume_produs = resultSet.getString(1);
                            descriere = resultSet.getString(2);
                            data = resultSet.getString(3);
                            String[] row = {nume_produs,descriere,data};
                            model.addRow(row);
                        }

                    } catch (SQLException t) {
                        throw new RuntimeException(t);
                    }

                } else if (afiseazaNumeleSiPrenumeleRadioButton.isSelected()) {
                    try {
                        Connection connection = DriverManager.getConnection(url, user, pass);
                        PreparedStatement preparedStatement = connection.prepareStatement("SELECT A.Nume, A.Prenume,A.Id_hala\n" +
                                "FROM Angajati A, (SELECT A2.Id_angajat\n" +
                                "                  FROM Angajati A2\n" +
                                "                  WHERE A2.Id_hala = 3) AS AD\n" +
                                "WHERE A.Id_angajat = AD.Id_angajat\n" );

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

                        String nume,prenume;
                        int id_hala=0;
                        String id = Integer.toString(id_hala);
                        while (resultSet.next()) {
                            nume = resultSet.getString(1);
                            prenume = resultSet.getString(2);
                            id = resultSet.getString(3);

                            String[] row = {nume,prenume,id};
                            model.addRow(row);
                        }

                    } catch (SQLException t) {
                        throw new RuntimeException(t);
                    }

                } else if (top3SalariiRadioButton.isSelected()) {

                    try {
                        Connection connection = DriverManager.getConnection(url, user, pass);
                        PreparedStatement preparedStatement = connection.prepareStatement("SELECT I.Nume,I.Prenume, I. Salariu\n" +
                                "FROM (SELECT TOP 3 A.Nume as Nume, A.Prenume as Prenume, A.Salariu as\n" +
                                "                             Salariu\n" +
                                "      FROM Angajati A\n" +
                                "      ORDER BY A.Salariu DESC ) as I");
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

                        String nume,prenume;
                        int salariu=0;
                        String sal = Integer.toString(salariu);
                        while (resultSet.next()) {
                            nume = resultSet.getString(1);
                            prenume = resultSet.getString(2);
                            sal = resultSet.getString(3);

                            String[] row = {nume,prenume,sal};
                            model.addRow(row);
                        }

                    } catch (SQLException t) {
                        throw new RuntimeException(t);
                    }
                } else if (aflatiAngajatiiCareAuRadioButton.isSelected()) {
                    try {
                        Connection connection = DriverManager.getConnection(url, user, pass);
                        PreparedStatement preparedStatement = connection.prepareStatement("SELECT nume, prenume, Id_hala, salariu\n" +
                                "FROM angajati\n" +
                                "WHERE (salariu > ANY\n" +
                                "       (SELECT salariu\n" +
                                "        FROM angajati\n" +
                                "        WHERE Id_hala = 3))\n" +
                                "  AND Angajati.Id_hala <> 1");
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

                        String nume,prenume;
                        int salariu=0;
                        String sal = Integer.toString(salariu);
                        int id_hala = 0;
                        String id = Integer.toString(id_hala);
                        while (resultSet.next()) {
                            nume = resultSet.getString(1);
                            prenume = resultSet.getString(2);
                            id = resultSet.getString(3);
                            sal = resultSet.getString(4);

                            String[] row = {nume,prenume,id,sal};
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
