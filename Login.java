import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame  {

    public String profesor;
    private JPanel loginPanel;
    private JButton administradorButton;
    private JButton estudianteButton;

    public Login(JFrame frame) {

       super();
       setTitle("Inicio");
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setBounds(100, 100, 450, 300);
       loginPanel = new JPanel();
       loginPanel.setLayout(null);


        administradorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(administradorButton != null){
                    dispose();
                    Administrador administrador = new Administrador(null);
                    administrador.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "No se puede acceder como administrador");
                }
            }
        });
        estudianteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(estudianteButton != null){
                    dispose();
                    Estudiante estudiante = new Estudiante(null);
                    estudiante.setVisible(true);
                }
            }
        });
    }
}
