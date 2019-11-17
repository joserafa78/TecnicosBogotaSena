/*
SISTEMA "TECNICO ZONAL "
Es Una Herramienta Informatica exclusiva para Tecnicos en Dispositivos Moviles
de la Zona Bogota.
que reune informacion como: Datos de cada Tecnico,
                            Fotografia
                            Contactos
------------------------------------------------------------------------------------------------------
Author  Jose rafael Jimenez Instagram: @joserafa78
------------------------------------------------------------------------------------------------------
 */
package modelo;

import conexionSQL.Conexion;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class TecnicoDAO {

    //Variables de la Clase
    Tecnico t = new Tecnico();

    //Variables de Conexion
   static Conexion conectar = new Conexion();
    static  PreparedStatement ps;
   static Connection con;
    static ResultSet rs;
    //-----


//-------------------------------
    //Constructor no hay
//-------------------------------  
    public int buscarPorDocuemto(String cc) {

        String sql = "select * from tecnico where identificacion=" + cc;
        int r = 0;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();//Ejecuta la Consulta
            while (rs.next()) {     //Mietras halla filla hacer.           
                Tecnico t = new Tecnico();
                t.setId(rs.getInt("id"));
                t.setCc(rs.getString("identificacion"));
                t.setNombres(rs.getString("nombres"));
                t.setApellidos(rs.getString("apellidos"));
                t.setCelular(rs.getString("celular"));
                t.setCorreo(rs.getString("correo"));
                t.setAnio_servicio(rs.getInt("anos_servicio"));
                t.setPais(rs.getString("pais"));
                t.setCiudad(rs.getString("ciudad"));
                t.setZona(rs.getString("zona"));
                t.setDireccion(rs.getString("direccion"));
                t.setFecha(rs.getString("fecha_registro"));
                r = 1;

            }

        } catch (Exception e) {
        }

        return r;
    }

    public Vector<Tecnico> listar() {
        Vector<Tecnico> datos = new Vector<>();
        String sql = "select * from tecnico";

        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();//Ejecuta la Consulta
            while (rs.next()) {     //Mietras halla filla hacer.           
                Tecnico t = new Tecnico();
                t.setId(rs.getInt("id"));
                t.setCc(rs.getString("identificacion"));
                t.setNombres(rs.getString("nombres"));
                t.setApellidos(rs.getString("apellidos"));
                t.setCelular(rs.getString("celular"));
                t.setCorreo(rs.getString("correo"));
                t.setAnio_servicio(rs.getInt("anos_servicio"));
                t.setPais(rs.getString("pais"));
                t.setCiudad(rs.getString("ciudad"));
                t.setZona(rs.getString("zona"));
                t.setDireccion(rs.getString("direccion"));
                t.setFecha(rs.getString("fecha_registro"));
                datos.add(t);

            }

        } catch (Exception e) {
        }

        return datos;
    }

    public int agregar(Tecnico t) {
        int r = 0;
        String sql = "INSERT INTO tecnico( identificacion,nombres,apellidos,celular,correo,anos_servicio,pais,ciudad,zona,direccion,foto) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, t.getCc());
            ps.setString(2, t.getNombres());
            ps.setString(3, t.getApellidos());
            ps.setString(4, t.getCelular());
            ps.setString(5, t.getCorreo());
            ps.setInt(6, t.getAnio_servicio());
            ps.setString(7, t.getPais());
            ps.setString(8, t.getCiudad());
            ps.setString(9, t.getZona());
            ps.setString(10, t.getDireccion());
            ps.setBinaryStream(11, t.getFoto());
            //ps.setString(10, t.getFecha());

            r = ps.executeUpdate();
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }

        } catch (Exception e) {
        }
        return r;
    }

    public int actualizar(Tecnico t) {
        int r = 0;
//esplus =?,
        String sql = "UPDATE `tecnico` SET `identificacion`=?,`nombres`=?,`apellidos`=?,`celular`=?,`correo`=?,`anos_servicio`=?,`pais`=?,`ciudad`=?,`zona`=?,`direccion`=?,`foto`=?,`fecha_registro`=? WHERE id =?";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            //--------------------------------------------------   
            ps.setString(1, t.getCc());
            ps.setString(2, t.getNombres());
            ps.setString(3, t.getApellidos());
            ps.setString(4, t.getCelular());
            ps.setString(5, t.getCorreo());
            ps.setInt(6, t.getAnio_servicio());
            ps.setString(7, t.getPais());
            ps.setString(8, t.getCiudad());
            ps.setString(9, t.getZona());
            ps.setString(10, t.getDireccion());
            ps.setBlob(11, t.getFoto());
            ps.setString(12, t.getFecha());
            ps.setInt(13, t.getId());//Identificador para actualizar
            r = ps.executeUpdate();
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
        }
        return r;

    }

    public int eliminar(int id) {
        int r = 0;
        //DELETE FROM `lineaproducto` WHERE 1
        String sql = "DELETE FROM `tecnico` WHERE Id=" + id;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            r = ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    public static ImageIcon getFoto(int id) {
        String sql = "select `foto` from `tecnico` where id=" + id;
         ImageIcon ii = null;
        InputStream is = null;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();//Ejecuta la Consulta 
         if(rs.next()){   
 
                  is = rs.getBinaryStream(1);
                   BufferedImage bi = ImageIO.read(is);
                   ii = new ImageIcon(bi);
        
        }
        } catch (Exception e) {
        }

        return ii;
    }

}
