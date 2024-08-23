import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Estudiante extends JFrame{

    private JPanel estudiantePanel;
    private JTextArea textArea1;
    private JButton salirButton;

    public Estudiante(JFrame frame) {
        super("Estudiante");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        estudiantePanel  = new JPanel();
        estudiantePanel.setLayout(null);

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
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
