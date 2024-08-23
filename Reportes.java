import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Reportes {
    private JPanel reportesPanel;
    private JTextField nombre;
    private JTextField apellido;
    private JButton crearButton;
    private JButton modificarButton;
    private JTextField textField3;
    private JTextArea textArea1;
    private JButton visualizarButton;
    private JButton eliminarButton;
    private JTextField textField4;
    private JTextField nota;
    private JTextField materia;

    public Reportes(JFrame frame) {

        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textfiel4 = textField4.getText();

                String URL = "jdbc:mysql://localhost:3306/productos";
                String USER = "root";
                String PASSWORD = "123456";

                try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
                    String sql = "DELETE FROM cliente WHERE codigo =?";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                        preparedStatement.setString(1, textField4.getText());

                        int statement = preparedStatement.executeUpdate();
                        if (statement > 0) {
                            JOptionPane.showMessageDialog(null, "Calificacion eliminada exitosamente");
                        } else {
                            JOptionPane.showMessageDialog(null, "Error al eliminar la calificacion");
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Error al eliminar los datos" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Nombre = nombre.getText();
                String Apellido = apellido.getText();
                String Materia = materia.getText();
                String Nota = nota.getText();

                String URL = "jdbc:mysql://localhost:3306/productos";
                String USER = "root";
                String PASSWORD = "123456";

                try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
                    String sql = "INSERT INTO CLIENTE (nombre, apellido, materia, nota) VALUES (?,?,?,?)";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                        preparedStatement.setString(1, Nombre);
                        preparedStatement.setString(2, Apellido);
                        preparedStatement.setString(3, Materia);
                        preparedStatement.setString(4, Nota);

                        preparedStatement.executeUpdate();
                        JOptionPane.showMessageDialog(null, " Estudiante creado correctamente");

                        String report = generarReport(Nombre,Apellido,Materia,Nota);
                        textArea1.setText(report);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Error al registrar la compra" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        visualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("");
            }
        });
    }
    private String generarReport(String nombre, String apellido, String materia, String nota) {
        return "\n ------------- EPN -------------" +
                "\n ------- CALIFICACIONES -------" +
                "\n  ---- SISTEMA DE REPORTES ----" +
                "\n " +
                "\n Nombre: " + nombre +
                "\n Apellido: " + apellido +
                "\n Cedula: " + materia +
                "\n Codigo: " + nota;
    }
}
