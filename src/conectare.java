import java.sql.*;

public class conectare {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=Depozit marfar;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String pass = "557477";


        try{
            Connection connection = DriverManager.getConnection(url, user, pass);
            String sql = "SELECT nume_produs FROM Marfa";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                System.out.println(result.getString(1));
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }

    }

}