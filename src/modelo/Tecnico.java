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

import java.io.FileInputStream;

public class Tecnico {
//Variables de la Clase

    private int id;
    private String cc;
    private String nombres;
    private String apellidos;
    private String celular;
    private String correo;
    private int anio_servicio;
    private String pais;
    private String ciudad;
    private String zona;
    private String direccion;  
    private FileInputStream foto;
    private String fecha;


//Metodo Vaicio
    public Tecnico() {
    }

//Metodo Dos    
    public Tecnico(int id, String cc, String nombres, String apellidos, String celular, String correo, int anio_servicio, String pais, String ciudad, String zona, String direccion,FileInputStream foto,String fecha) {
        this.id = id;
        this.cc = cc;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.celular = celular;
        this.correo = correo;
        this.anio_servicio = anio_servicio;
        this.pais = pais;
        this.ciudad = ciudad;
        this.zona = zona;
        this.direccion = direccion;
        this.foto=foto;
        this.fecha = fecha;
    }
    //Metodo tres  
    public Tecnico(int id, String cc, String nombres, String apellidos, String celular, String correo, int anio_servicio, String pais, String ciudad, String zona, String direccion,String fecha) {
        this.id = id;
        this.cc = cc;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.celular = celular;
        this.correo = correo;
        this.anio_servicio = anio_servicio;
        this.pais = pais;
        this.ciudad = ciudad;
        this.zona = zona;
        this.direccion = direccion;
      
        this.fecha = fecha;
    }
    
    //Metodo Setter

    public void setId(int id) {
        this.id = id;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setAnio_servicio(int anio_servicio) {
        this.anio_servicio = anio_servicio;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setFoto(FileInputStream foto) {
        this.foto = foto;
    }
    
    //Metodos Getter

    public int getId() {
        return id;
    }

    public String getCc() {
        return cc;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCelular() {
        return celular;
    }

    public String getCorreo() {
        return correo;
    }

    public int getAnio_servicio() {
        return anio_servicio;
    }

    public String getPais() {
        return pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getZona() {
        return zona;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getFecha() {
        return fecha;
    }

    public FileInputStream getFoto() {
        return foto;
    }
    

    @Override
    public String toString() {
        return  cc +  nombres + apellidos ;
    }
    
    

}
