/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Estudiantes
 */
public class Usuarios {
   private String nombre;
        private String apellido;
        private String username;
        private String clave;

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }
        
    public boolean verificarCredenciales(String pUsername, String pPassword) {
            Conector db = new Conector();
        
            try {
                db.conectar();
                String query = "SELECT * FROM usuarios WHERE username = ? AND clave = ?";
                ResultSet rs = db.executeSelect(query, pUsername, pPassword);
             return rs.next();
            
           }catch (SQLException e) {
                System.err.println("Error al verificar las credenciales: " + e.getMessage());
                return false;
           }finally {
                 db.desconectar();
            }
       
    }
        
}



