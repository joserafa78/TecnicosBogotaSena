
package conexionSQL;
import java.sql.*;
import javax.swing.*;

public class Conexion {

    Connection conect ;

    public Connection getConnection(){//fuencon que Devuelve

        String url = "jdbc:mysql://localhost:3306/tecnicosbogota";
        String user = "root";
        String pass = "";
        //Connection conect = null;

        try {

            Class.forName("org.gjt.mm.mysql.Driver");//"com.mysql.jdbc.Driver"
            conect=DriverManager.getConnection(url,user,pass);
           // JOptionPane.showMessageDialog(null,"Conectado OK");

        } catch (ClassNotFoundException | SQLException e) {

            JOptionPane.showMessageDialog(null, "!!Error de conexion, Revice el Servidor!!  " + e);
        }
        return conect;
    }
}
