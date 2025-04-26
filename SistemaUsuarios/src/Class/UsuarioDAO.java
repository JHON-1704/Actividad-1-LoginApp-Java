package Class;

import java.sql.SQLException;

public class UsuarioDAO {

    public static boolean registrarUsuario(Usuarios usuario) {
        Conector db = new Conector();
        try {
            db.conectar();

            String query = "INSERT INTO usuarios (nombre, email, username, clave) VALUES (?, ?, ?, ?)";
           
            int resultado = db.executeUpdate(query,
                    usuario.getNombre(),
                    usuario.getApellido(), 
                    usuario.getUsername(),
                    usuario.getClave()
            );

            return resultado > 0;
        } catch (SQLException e) {
            System.err.println("Error al registrar usuario: " + e.getMessage());
            return false;
        } finally {
            db.desconectar(); 
        }
    }
}
