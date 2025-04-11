import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private static final String FILE_NAME = "users.txt";
    private List<UserData> usuarios;

    public UserManager() {
        usuarios = new ArrayList<>();
        cargarUsuarios();
    }

    public void cargarUsuarios() {
        File archivo = new File(FILE_NAME);
        if (!archivo.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                try {
                    usuarios.add(UserData.fromFile(linea));
                } catch (Exception e) {
                    System.out.println("Error en línea: " + linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar usuarios: " + e.getMessage());
        }
    }

    public void guardarUsuarios() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (UserData user : usuarios) {
                pw.println(user.toFile());
            }
        } catch (IOException e) {
            System.out.println("Error al guardar usuarios: " + e.getMessage());
        }
    }

    public boolean existeUsuario(String nombre) {
        for (UserData user : usuarios) {
            if (user.getNombre().equalsIgnoreCase(nombre)) return true;
        }
        return false;
    }

    public void registrarUsuario(String nombre, String pin) {
        UserData nuevo = new UserData(nombre, pin, 0.0);
        usuarios.add(nuevo);
        guardarUsuarios();
    }

    public UserData login(String nombre, String pin) {
        for (UserData user : usuarios) {
            if (user.getNombre().equalsIgnoreCase(nombre) && user.verificarPin(pin)) {
                return user;
            }
        }
        return null;
    }
}
