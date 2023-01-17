import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AfisareProdusesiHale extends JFrame{
    private JTable table1;
    private JButton inapoiButton;
    private JPanel panel1;

    AfisareProdusesiHale(){
        inapoiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdaugareProduseGUI adaugareProduseGUI = new AdaugareProduseGUI();
                dispose();
            }
        });
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
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT m.nume_produs,h.Nume_hala FROM Marfa m\n" +
                    "INNER JOIN hale_marfa hm ON  m.id_marfa = hm.id_marfa\n" +
                    "INNER JOIN Hale h on h.Id_hala = hm.id_hala");
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

            String nume_produs, nume_hala;

            while (resultSet.next()) {
                nume_produs = resultSet.getString(1);
                nume_hala = resultSet.getString(2);

                String[] row = {nume_produs,nume_hala};
                model.addRow(row);
            }




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
