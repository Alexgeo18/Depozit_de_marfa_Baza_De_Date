import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AfisareAngajati extends JFrame{
    private JTable table1;
    private JPanel jpanel1;
    private JButton inapoiButton;

    public AfisareAngajati(){
        setTitle("Afisare");
        setContentPane(jpanel1);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(500, 300));
        setVisible(true);
        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=Depozit marfar;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String pass = "557477";
        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT Nume,Prenume FROM Angajati");
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

            String nume, prenume;

            while (resultSet.next()) {
                nume = resultSet.getString(1);
                prenume = resultSet.getString(2);

                String[] row = {nume, prenume};
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
