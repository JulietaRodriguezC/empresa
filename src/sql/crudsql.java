package sql;

import getset.variables;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class crudsql extends conexionsql {

    java.sql.Statement st;
    ResultSet rs;
    variables var = new variables();

    public void insertar(String nombre, String apellido, String puesto) {
        try {
            Connection conexion = conectar(); //conecta directamente con la BD
            st = conexion.createStatement(); //crea objeto para poder ejecutar sentencia sql
            String sql = "insert into empleados(nombre,apellido,puesto) values ('" + nombre + "','" + apellido + "','" + puesto + "');";
            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "El registro se guardó correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El registro no se guardó " + e, "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void mostrar(String idempleado){
        try {
            Connection conexion = conectar(); 
            st = conexion.createStatement();
            String sql = "select * from empleados where idempleado = '"+idempleado+"';";
            rs = st.executeQuery(sql);
            if(rs.next()){
                var.setIdempleado(rs.getString("idempleado"));
                var.setNombre(rs.getString("nombre"));
                var.setApellido(rs.getString("apellido"));
                var.setPuesto(rs.getString("puesto"));
            } else {
                var.setIdempleado("");
                var.setNombre("");
                var.setApellido("");
                var.setPuesto("");
                JOptionPane.showMessageDialog(null, "No se encontró registro", "Sin registro", JOptionPane.INFORMATION_MESSAGE);
            }
            st.close();
            conexion.close();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error en el sistema de búsqueda", "Error búsqueda", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void actualizar(String nombre, String apellido, String puesto, String idempleado){
        try {
            Connection conexion = conectar(); 
            st = conexion.createStatement();
            String sql = "update empleados set nombre = '"+nombre+"', apellido = '"+apellido+"', puesto = '"+puesto+"' where idempleado = '"+idempleado+"';";
            st.executeUpdate(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "El registro se actualizó", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al actualizar "+e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void eliminar(String idempleado){
        try{
           Connection conexion = conectar(); 
           st = conexion.createStatement();
           String sql = "delete from empleados where idempleado = '"+idempleado+"';";
           st.executeUpdate(sql);
           st.close();
           conexion.close();
           JOptionPane.showMessageDialog(null, "Registro eliminado correctamente", "Eliminado", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e){
           JOptionPane.showMessageDialog(null, "Error al eliminar registro "+e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
