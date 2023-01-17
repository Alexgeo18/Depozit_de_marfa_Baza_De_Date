import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Update extends JFrame{
    private JTextField numeProdusTextField;
    private JTextField numeAngajatTextField;
    private JTextField cantitateTextField;
    private JTextField salariuTextField;
    private JTextField costStocareTextField;
    private JButton updateProdusButton;
    private JButton updateAngajatButton;
    private JButton inapoiButton;
    private JPanel panel1;
    private JTable table1;
    private JTable table2;

    Update(){
        setTitle("Update");
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
        updateProdusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Connection connection = DriverManager.getConnection(url, user, pass);
                    System.out.println("Messi");
                    String query = " Update Marfa\n" +
                            "SET cantitate = " + cantitateTextField.getText() +  ",cost_stocare = " + costStocareTextField.getText() +  "\n" +
                            "where nume_produs =" + "'" + numeProdusTextField.getText()+"'";
                    System.out.println("Maluma");
                    PreparedStatement statement = connection.prepareStatement(query);

                    /*int cant = Integer.valueOf(update.this.cantitateTextField.getText());
                    int cost_stocare = Integer.valueOf(update.this.costStocareTextField.getText());
                    String nume_produs = numeProdusTextField.getText();
                    statement.setInt(1, cant);
                    statement.setInt(2, cost_stocare);
                    statement.setString(3, nume_produs);*/

                    statement.execute();
                    String query2 = " select nume_produs,cantitate,cost_stocare from Marfa";
                    System.out.println("Maluma");
                    PreparedStatement statement1 = connection.prepareStatement(query2);
                    ResultSet resultSet = statement1.executeQuery();
                    ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                    DefaultTableModel model = (DefaultTableModel) table1.getModel();
                    model.setRowCount(0);
                    int cols = resultSetMetaData.getColumnCount();
                    String[] colName = new String[cols];

                    for (int i = 0; i < cols; i++) {
                        colName[i] = resultSetMetaData.getColumnName(i + 1);
                    }
                    model.setColumnIdentifiers(colName);

                    String nume_produs;
                    int cantitate = 0;
                    String cant = String.valueOf(cantitate);
                    int cost_stocare = 0;
                    String cost = String.valueOf(cost_stocare);

                    while (resultSet.next()) {
                        nume_produs = resultSet.getString(1);
                        cant = resultSet.getString(2);
                        cost = resultSet.getString(3);
                        String[] row = {nume_produs,cant,cost};
                        model.addRow(row);
                    }

            }
                catch(SQLException t){
                    t.printStackTrace();
                }

            }
        });
        updateAngajatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection connection = DriverManager.getConnection(url, user, pass);
                    System.out.println("Messi");
                    String query = " Update Angajati\n" +
                            "SET salariu = " + salariuTextField.getText() + "\n" +
                            "where nume =" + "'" + numeAngajatTextField.getText() + "'";
                    System.out.println("Maluma");
                    PreparedStatement statement = connection.prepareStatement(query);


                    statement.execute();

                    String query2 = " select nume,prenume,salariu from Angajati";
                    System.out.println("Maluma");
                    PreparedStatement statement1 = connection.prepareStatement(query2);
                    ResultSet resultSet = statement1.executeQuery();
                    ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                    DefaultTableModel model = (DefaultTableModel) table2.getModel();
                    model.setRowCount(0);
                    int cols = resultSetMetaData.getColumnCount();
                    String[] colName = new String[cols];

                    for (int i = 0; i < cols; i++) {
                        colName[i] = resultSetMetaData.getColumnName(i + 1);
                    }
                    model.setColumnIdentifiers(colName);

                    String nume, prenume;
                    int salariu = 0;
                    String sal = String.valueOf(salariu);

                    while (resultSet.next()) {
                        nume = resultSet.getString(1);
                        prenume = resultSet.getString(2);
                        sal = resultSet.getString(3);
                        String[] row = {nume, prenume,sal};
                        model.addRow(row);
                    }

                }
                catch (SQLException t){
                    t.printStackTrace();
                }
            }
        });


    }


}
