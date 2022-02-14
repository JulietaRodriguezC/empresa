package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class conexionsql {
    Connection conn = null;
    String url = "jdbc:postgresql://localhost:5432/empresa";
    String usuario = "postgres";
    String clave = "sql2806";
    
    public Connection conectar(){
        try{
            Class.forName("org.postgresql.Driver"); //inicializar driver de librería
            conn = DriverManager.getConnection(url,usuario,clave);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error al conectar "+e,"Error",JOptionPane.ERROR_MESSAGE);
        }  
    return conn;
    }
}
