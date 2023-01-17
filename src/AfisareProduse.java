import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AfisareProduse extends JFrame{
    private JTable table1;
    private JPanel panel1;
    private JButton inapoiButton;

    public AfisareProduse(){
        setTitle("Afisare");
        setContentPane(panel1);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(500, 300));
        setVisible(true);
        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=Depozit marfar;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String pass = "557477";
        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT nume_produs,descriere,cost_stocare,cantitate FROM Marfa");
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

            String nume_produs, descriere;
            int cost_stocare,cantitate;
            while (resultSet.next()) {
                nume_produs = resultSet.getString(1);
                descriere = resultSet.getString(2);
                cost_stocare = resultSet.getInt(3);
                cantitate = resultSet.getInt(4);
                String cs1 = Integer.toString(cost_stocare);
                String cant1 = Integer.toString(cantitate);
                String[] row = {nume_produs,descriere,cs1,cant1};
                model.addRow(row);
            }




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        inapoiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }


}
