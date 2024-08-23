import javax.swing.*;


public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        Login login = new Login(null );
        login.setVisible(true);

        if(login.profesor != null){

            System.out.println("Inicio de sesion correctamente");
            Administrador administrador = new Administrador(null);

        }else{
            Estudiante estudiante = new Estudiante(null);
        }


    }
}