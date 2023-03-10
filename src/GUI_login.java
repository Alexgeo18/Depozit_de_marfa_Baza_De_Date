import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public  class GUI_login {
    private static JLabel userLabel;
    private static JTextField userText;
    private static JLabel passwordLabel;
    private static JPasswordField passText;
    private static JButton buttonLogin ;
    private static JLabel success;
    private static JFrame frame ;
    private static GUI_login window;


    public static void main(String[] args){
        String url = "jdbc:sqlserver://localhost:1433;DatabaseName=Depozit marfar;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String pass = "557477";
        try {
            Connection connection = DriverManager.getConnection(url,user,pass);

            window = new GUI_login(connection);

        } catch (SQLException e){
            e.printStackTrace();
        }


    }



    public GUI_login(Connection con) {
        initialize(con);
    }

    private void initialize(Connection con) {
        JPanel panel = new JPanel();
        frame = new JFrame();

        frame.setSize(300,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(100, 60, 60));      //lighter shade of black cu RGB values
        frame.setLayout(new BorderLayout());




        panel.setLayout(null);
        userLabel = new JLabel(" User");
        userLabel.setBackground(new Color(25, 25, 25));
        userLabel.setForeground(new Color(125, 100, 0));

        userLabel.setBounds(10,20,80,25);
        panel.add(userLabel);


        userText = new JTextField();
        userText.setBounds(100,20,165,25);
        panel.add(userText);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10,50,80,25);
        passwordLabel.setBackground(new Color(25, 25, 25));
        passwordLabel.setForeground(new Color(125, 100, 0));

        panel.add(passwordLabel);

        passText = new JPasswordField();
        passText.setBounds(100,50,165,25);
        panel.add(passText);

        buttonLogin = new JButton("Login");
        buttonLogin.setBounds(100,100,80,25);
        buttonLogin.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String user = userText.getText();
                char[] passwordAsChars = passText.getPassword();
                String password = String.valueOf(passwordAsChars);


                if (user.equalsIgnoreCase("admin") && password.equals("admin")) {


               menu m = new menu();

                //frame.setVisible(false);


                 } else {
                   success.setText("!!!! Try it again !!!!");

                }

            }
        });
        panel.add(buttonLogin);

        success = new JLabel("") ;
        success.setBounds(105,130,130,25);
        panel.add(success);
        frame.add(panel);
        frame.setVisible(true);
    }


}
