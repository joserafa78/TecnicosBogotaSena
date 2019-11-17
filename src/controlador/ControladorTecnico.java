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
package controlador;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import modelo.Tecnico;
import modelo.TecnicoDAO;

import vistas.VistaTecnico;

public class ControladorTecnico implements ActionListener {

    //Variables de la Clase
    VistaTecnico vt = new VistaTecnico();
    Tecnico t = new Tecnico();
    TecnicoDAO tdao = new TecnicoDAO();
    DefaultTableModel modelo = new DefaultTableModel();
    //Para la el archivo de imagen
    private FileInputStream fis; //Tipo de archivo deonde Gurarda el flujo de Datos byte
    private int longitudBytes;// Variabel que guarda la longitud
    private String ruta_archivo;//ruta

//METODO CONSTRUCCTOR
    public ControladorTecnico(VistaTecnico vt) {
        this.vt = vt;
        //Botones
        vt.boton_guardar.addActionListener(this);
        vt.boton_nuevo.addActionListener(this);
        vt.boton_cancelar.addActionListener(this);
        vt.boton_editar.addActionListener(this);
        vt.boton_actualiar.addActionListener(this);
        vt.boton_eliminar.addActionListener(this);
        vt.boton_busca_cedula.addActionListener(this);
        vt.boton_selecion_foto.addActionListener(this);

    }

    public void busquedaporcedula() {
        int resultado = tdao.buscarPorDocuemto(vt.text_cc.getText());
        if (resultado == 1) {
            JOptionPane.showMessageDialog(vt, "Error..Este Docuemento de Identidad ya Se Encuentra Registrado");

            bloquear();
        } else {
            JOptionPane.showMessageDialog(vt, "Si Puede Registrar con este Documento.OK");

        }

    }

    public void agregar() {

        int res = tdao.buscarPorDocuemto(vt.text_cc.getText());
        if (res == 1) {
            JOptionPane.showMessageDialog(vt, "Error..Este Docuemento de Identidad ya Se Encuentra Registrado");
            bloquear();
        } else {
            t = new Tecnico();
            //------------------------------------------------------------
            //t.setId(0);
            t.setCc(vt.text_cc.getText());
            t.setNombres(vt.text_nombres.getText());
            t.setApellidos(vt.text_apellido.getText());
            t.setCelular(vt.text_celular.getText());
            t.setCorreo(vt.text_correo.getText());
            t.setAnio_servicio(Integer.parseInt(vt.text_anioservicio.getText()));
            t.setPais(vt.text_pais.getText());
            t.setCiudad(vt.text_ciudad.getText());
            t.setZona(vt.text_zona.getText());
            t.setFoto(fis);
            t.setDireccion(vt.text_direccion.getText());
            //t.setFecha(fecha);
            //--------------------------------------------------------------
            int r = tdao.agregar(t); // Aqui se envia los Datotos a la funcion Agregar y luego envia un entero 

            if (r == 1) {
                JOptionPane.showMessageDialog(vt, "Tecnico Agregado con Exito.");
                limpiar();
                bloquear();
                limpiarTabla();
                listar(vt.table);
            } else {
                JOptionPane.showMessageDialog(vt, "Error, Revisar");
            }

        }
    }

    public void actualizar() {

        if (vt.text_id.getText().equals("")) {
            JOptionPane.showMessageDialog(vt, "No se Identifica el Id debe selecionar la opcion Editar");
        } else {
            //-----------------------------------
            int id = Integer.parseInt(vt.text_id.getText());
            String cc = vt.text_cc.getText();
            String nombres = vt.text_nombres.getText();
            String apellidos = vt.text_apellido.getText();;
            String celular = vt.text_celular.getText();
            String correo = vt.text_correo.getText();;
            int anioservicio = Integer.parseInt(vt.text_anioservicio.getText());;
            String pais = vt.text_pais.getText();;
            String ciudad = vt.text_ciudad.getText();;
            String zona = vt.text_zona.getText();;
            String direccion = vt.text_direccion.getText();
            FileInputStream fis_v = fis;
            String fecha = vt.label_fecha.getText();
            //-----------------------------------

            t = new Tecnico(id, cc, nombres, apellidos, celular, correo, anioservicio, pais, ciudad, zona, direccion, fis_v, fecha);

            int r = tdao.actualizar(t);
            if (r == 1) {

                JOptionPane.showMessageDialog(vt, "Usuario Actualizado con Exito.");
                limpiar();
                bloquear();
                limpiarTabla();
                listar(vt.table);
            } else {

                JOptionPane.showMessageDialog(vt, "Error");

            }

        }

    }

    public void eliminar() {

        if (vt.text_id.getText().equals("")) {
            JOptionPane.showMessageDialog(vt, "Debe Seleccionar un Tecnico a Eliminar...!!!");
        } else {

            int id_v = Integer.parseInt(vt.text_id.getText());
            tdao.eliminar(id_v);
            JOptionPane.showMessageDialog(vt, "Los Datos del se han Eliminado...!!!");
            limpiar();
            limpiarTabla();
            bloquear();
            listar(vt.table);
        }
    }

    public void listar(JTable table) {//Metodo que Carga de la lista Clase DAO Y O ENVIA al Modelo

        modelo = (DefaultTableModel) table.getModel();
        List<Tecnico> lista = tdao.listar();//Carga los datos del cla clase FabricanteDao a la LISTA    
        Object objeto[] = new Object[12]; //Crea un Arreglo tipo Objeto de 2 Elementos.

        for (int i = 0; i < lista.size(); i++) {

            objeto[0] = lista.get(i).getId();
            objeto[1] = lista.get(i).getCc();
            objeto[2] = lista.get(i).getNombres();
            objeto[3] = lista.get(i).getApellidos();
            objeto[4] = lista.get(i).getCelular();
            objeto[5] = lista.get(i).getCorreo();
            objeto[6] = lista.get(i).getAnio_servicio();
            objeto[7] = lista.get(i).getPais();
            objeto[8] = lista.get(i).getCiudad();
            objeto[9] = lista.get(i).getZona();
            objeto[10] = lista.get(i).getDireccion();
            objeto[11] = lista.get(i).getFecha();
            modelo.addRow(objeto); //Agrega un Objeto tipo vector al modelo 

        }

        vt.label_cantidad.setText(String.valueOf(lista.size()));//Devuelve la Cantidad de Registros hallados
        table.setModel(modelo);

    }

    public void selecionaFoto() throws IOException {
        JFileChooser selec = new JFileChooser();//Objeto Selecionador de Archivo
        FileNameExtensionFilter fi = new FileNameExtensionFilter("jpg", "jpg");//Clase qeu crea una extencion . algo
        selec.setFileFilter(fi);//Filtra el Archivo Segun la Extension
        //selec.setFileSelectionMode(JFileChooser.FILES_ONLY);   //Obliga a que se seleccione solo archivo y no carpetas
        int estado = selec.showOpenDialog(null);
        if (estado == JFileChooser.APPROVE_OPTION) {

            try {
                fis = new FileInputStream(selec.getSelectedFile());//Objeto de Archivo Binario para entrada 
                this.longitudBytes = (int) selec.getSelectedFile().length();//Catura la longitud del Archivo

                vt.boton_selecion_foto.setText("" + selec.getSelectedFile().getName());//obtienele nombre del Archivo
                ruta_archivo = selec.getSelectedFile().getAbsolutePath();//obtienen la ruta

                //Crea un icono y lo Re-Dimensiona al tamaño exacto del label...
                Image icono = ImageIO.read(selec.getSelectedFile()).getScaledInstance(vt.lbFoto.getWidth(), vt.lbFoto.getHeight(), Image.SCALE_DEFAULT);
                vt.lbFoto.setIcon(new ImageIcon(icono));
                vt.lbFoto.updateUI(); //Actualiza el Label.

            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vt.boton_guardar) {//****Evento Oyente Boton Guardar           
            agregar();
        }
        if (e.getSource() == vt.boton_nuevo) {//****Evento Oyente Boton Nuevo           
            limpiar();
            desbloquear();
        }

        if (e.getSource() == vt.boton_cancelar) {//****Evento Oyente Boton Cancelar           
            limpiar();
            bloquear();
        }
        if (e.getSource() == vt.boton_editar) {//****Evento Oyente Boton Editar           

            int fila = vt.table.getSelectedRow(); //Debe haber Selecionado una Fila en la Tabla
            if (fila == -1) {

                JOptionPane.showMessageDialog(vt, "Debe Seleciconar Una Fila de La Tabla.");

            } else {
                //Pasa los Datos de la Tabla a cada uno de los Textx.     

                String id = vt.table.getValueAt(fila, 0).toString(); //Seleciona fila y columan 0
                String cc = (String) vt.table.getValueAt(fila, 1);
                String nombres = (String) vt.table.getValueAt(fila, 2);
                String apellidos = (String) vt.table.getValueAt(fila, 3);
                String celular = (String) vt.table.getValueAt(fila, 4);
                String correo = (String) vt.table.getValueAt(fila, 5);
                int anioservicio = (Integer) vt.table.getValueAt(fila, 6);
                String pais = (String) vt.table.getValueAt(fila, 7);
                String ciudad = (String) vt.table.getValueAt(fila, 8);
                String zona = (String) vt.table.getValueAt(fila, 9);
                String direccion = (String) vt.table.getValueAt(fila, 10);
                String fecha = (String) vt.table.getValueAt(fila, 11);
                ImageIcon foto = TecnicoDAO.getFoto(Integer.parseInt(id));//Llama al metodo mostrar foto
           

                //pasa a Vista
                vt.text_id.setText(id);
                vt.text_cc.setText(cc);
                vt.text_nombres.setText(nombres);
                vt.text_apellido.setText(apellidos);
                vt.text_celular.setText(celular);
                vt.text_correo.setText(correo);
                vt.text_anioservicio.setText(String.valueOf(anioservicio));
                vt.text_pais.setText(pais);
                vt.text_ciudad.setText(ciudad);
                vt.text_zona.setText(zona);
                vt.text_direccion.setText(direccion);
                vt.label_fecha.setText(fecha);
                if (foto != null) {
               //Crea un Nuevo icono y lo Re-Dimensiona al tamaño exacto del label.
                ImageIcon foto2=new ImageIcon( foto.getImage().getScaledInstance(vt.lbFoto.getWidth(), vt.lbFoto.getHeight(), Image.SCALE_SMOOTH) );  
                vt.lbFoto.setIcon(foto2);  //Carga la nueva imagen re-didimensionada al label    
                } else { 
                    vt.lbFoto.setIcon(null);
                }vt.lbFoto.updateUI();

                desbloquearDos();

            }

        }

        if (e.getSource() == vt.boton_actualiar) {//****Evento Oyente Boton Actualiza           
            actualizar();

        }

        if (e.getSource() == vt.boton_eliminar) {//****Evento Oyente Boton Eliminar
            int resp = JOptionPane.showConfirmDialog(null, "¿Desea Elimiar el Registro del Tecnico?", "Mensaje de Eliminar", JOptionPane.YES_NO_OPTION);
            if (resp == 0) {//Respuesta es igual a Si = 0
                eliminar();
            }
        }

        if (e.getSource() == vt.boton_busca_cedula) {//****Evento Oyente Boton Bus Cedu           
            busquedaporcedula();

        }
        if (e.getSource() == vt.boton_selecion_foto) {
            try {
                //****Evento Oyente Boton Selecionar Foto
                selecionaFoto();
            } catch (IOException ex) {
                Logger.getLogger(ControladorTecnico.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void limpiar() {
        vt.text_id.setText("");
        vt.text_cc.setText("");
        vt.text_nombres.setText("");
        vt.text_apellido.setText("");
        vt.text_celular.setText("");
        vt.text_correo.setText("");
        fis = null;
        vt.lbFoto.setIcon(null);
        vt.text_anioservicio.setText("");
        vt.text_pais.setText("Colombia");
        vt.text_ciudad.setText("Bogota");
        vt.text_zona.setText("");
        vt.text_direccion.setText("");
        vt.label_fecha.setText("");
        vt.boton_selecion_foto.setText("Seleciona Foto");

    }

    void limpiarTabla() {
        for (int i = 0; i < vt.table.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
        vt.label_cantidad.setText("0");
    }

    public void bloquear() {
        vt.text_id.setEnabled(false);
        vt.text_cc.setEnabled(false);
        vt.text_nombres.setEnabled(false);
        vt.text_apellido.setEnabled(false);
        vt.text_celular.setEnabled(false);
        vt.text_correo.setEnabled(false);
        vt.text_anioservicio.setEnabled(false);
        vt.text_pais.setEnabled(false);
        vt.text_ciudad.setEnabled(false);
        vt.text_zona.setEnabled(false);
        vt.text_direccion.setEnabled(false);
        vt.label_fecha.setEnabled(false);

        vt.boton_nuevo.setEnabled(true);
        vt.boton_cancelar.setEnabled(false);
        vt.boton_guardar.setEnabled(false);
        vt.boton_actualiar.setEnabled(false);
        vt.boton_busca_cedula.setEnabled(false);

    }

    public void desbloquear() {
        vt.text_id.setEnabled(false);
        vt.text_cc.setEnabled(true);
        vt.text_nombres.setEnabled(true);
        vt.text_apellido.setEnabled(true);
        vt.text_celular.setEnabled(true);
        vt.text_correo.setEnabled(true);
        vt.text_anioservicio.setEnabled(true);
        vt.text_pais.setEnabled(true);
        vt.text_ciudad.setEnabled(true);
        vt.text_zona.setEnabled(true);
        vt.text_direccion.setEnabled(true);
        vt.label_fecha.setEnabled(true);
        vt.boton_nuevo.setEnabled(false);
        vt.boton_cancelar.setEnabled(true);
        vt.boton_guardar.setEnabled(true);
        vt.boton_actualiar.setEnabled(false);
        vt.boton_busca_cedula.setEnabled(true);
    }

    public void desbloquearDos() {
        vt.text_id.setEnabled(false);
        vt.text_cc.setEnabled(true);
        vt.text_nombres.setEnabled(true);
        vt.text_apellido.setEnabled(true);
        vt.text_celular.setEnabled(true);
        vt.text_correo.setEnabled(true);
        vt.text_anioservicio.setEnabled(true);
        vt.text_pais.setEnabled(true);
        vt.text_ciudad.setEnabled(true);
        vt.text_zona.setEnabled(true);
        vt.text_direccion.setEnabled(true);
        vt.label_fecha.setEnabled(true);

        //---------bloquea---------------------
        vt.boton_nuevo.setEnabled(false);
        vt.boton_cancelar.setEnabled(true);
        vt.boton_guardar.setEnabled(false);
        vt.boton_actualiar.setEnabled(true);
        vt.boton_busca_cedula.setEnabled(true);
    }

    public void inicia() {
        vt.setTitle("Tecnicos de La Zona.- V:0.1");
        vt.setIconImage(new ImageIcon(getClass().getResource("../imagen/Microscopio.png")).getImage());
        vt.setLocationRelativeTo(null);
        vt.text_id.setEnabled(false);
        bloquear();
        listar(vt.table);
        vt.setVisible(true);//Se vuelve visible

    }

}
