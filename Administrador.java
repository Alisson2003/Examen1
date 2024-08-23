import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Administrador extends JFrame {
    private JPanel administradorPanel;
    private JTextField Usuario;
    private JPasswordField password;
    private JButton accederButton;

    public Administrador(JFrame frame) {
        setTitle("Login");
        setContentPane(administradorPanel);
        setMinimumSize(new Dimension(475, 474));
        setLocationRelativeTo(frame);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        accederButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = Usuario.getText();
                String Password = String.valueOf(password.getPassword());

                profesor = getAuthenticatedUser(Usuario, password);
                if(profesor != null){
                    dispose();
                    Reportes reportes = new Reportes(null);
                    reportes.setMo(true);
                }else{
                    JOptionPane.showMessageDialog(Administrador.this,
                            "Usuario o Password incorrecto",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    public Profesor profesor;
    private Profesor getAuthenticatedUser(String usuario, String password){
        Profesor profesor = null;

        String URL = "jdbc:mysql://localhost:3306/productos";
        String USER = "root";
        String PASSWORD = "123456";
        try{
            Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);

            String sql = "SELECT * FROM usuario WHERE username =? AND password =? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,usuario);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                profesor = new Profesor();
                profesor.setUsuario(resultSet.getString("username"));
            }
            preparedStatement.close();
            resultSet.close();
            connection.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return profesor;
    }
}

