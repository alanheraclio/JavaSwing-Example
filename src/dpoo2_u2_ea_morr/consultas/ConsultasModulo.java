package dpoo2_u2_ea_morr.consultas;

import dpoo2_u2_ea_morr.db.DBConsultas;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class ConsultasModulo extends JPanel implements ActionListener{
    //SE CREAN LAS VARIABLES NECESARIAS PARA CREAR EL MODULO
    JLabel buscar_label;
    JTextField buscar_field;
    JButton buscar_boton, actualizar_boton, eliminar_boton, imprimir_boton;   
    DBConsultas db = new DBConsultas();
    JScrollPane tabla;
    JTable consultas_tabla;
    String[] columnas = {"NOMBRE", "APELLIDOS", "INCENTIVOS", "DECUENTOS", "TOTAL"}; 
    
    //METODO PARA OBTNEER EL TOTAL DE REGISTROS DE LA BASE DE DATOS
    public void obtenerConsutlas(){   
        //SE USA LA CONEXION A LA BASE DE DATOS PARA OBTENER LOS VALORES Y SE ASEIGNAAN A LA TABLA
        Object[][] filas = db.obtenerConsultas();      
        consultas_tabla = new JTable(filas,columnas);
        tabla = new JScrollPane(consultas_tabla);
        this.add(tabla);          
    }
    
    //METODO PARA OBTENER LOS VALORES DE LA BUSQUEDA DE LA BASE DE DATOS
    public void obtenerConsutlasBusqueda(String busqueda){
        //SE USA LA CONEXION A LA BASE DE DATOS PARA OBTENER LOS VALORES Y SE ASEIGNAAN A LA TABLA
        Object[][] filas_busqueda = db.obtenerConsultasBusqueda(busqueda); 
        consultas_tabla = new JTable(filas_busqueda,columnas);
        tabla = new JScrollPane(consultas_tabla);
        this.tabla = tabla;   
    }
    
    //SE ASIGANAN LOS VALORES POR DEFAULT EN EL CONSTRUCTOR
    public ConsultasModulo(){
        setVisible(false);
        setPreferredSize(new Dimension(500, 500));
        setLayout(new FlowLayout());
        
        //SE CREAN LAS ETIQUETAS, CAMPOS Y BOTONES DEL MODULO
        buscar_label = new JLabel("Nombre:");
        buscar_label.setPreferredSize(new Dimension(70, 20));
        buscar_label.setHorizontalAlignment(SwingConstants.RIGHT);
        buscar_field = new JTextField(10);
              
        buscar_boton = new JButton("Buscar");
        buscar_boton.addActionListener(this);
        buscar_boton.setPreferredSize(new Dimension(110, 30));
        buscar_boton.setIcon(new ImageIcon(Class.class.getResource("/img/buscar2.png")));
        
        actualizar_boton = new JButton("Actualizar");
        actualizar_boton.addActionListener(this);
        actualizar_boton.setPreferredSize(new Dimension(140, 30));
        actualizar_boton.setIcon(new ImageIcon(Class.class.getResource("/img/cargar2.png")));
                      
        eliminar_boton = new JButton("Borrar Consulta");
        eliminar_boton.addActionListener(this);
        eliminar_boton.setPreferredSize(new Dimension(170, 30));
        eliminar_boton.setIcon(new ImageIcon(Class.class.getResource("/img/borrar_filtro2.png")));   
        
        imprimir_boton = new JButton("Imprimir Consulta");
        imprimir_boton.addActionListener(this);
        imprimir_boton.setPreferredSize(new Dimension(170, 30));
        imprimir_boton.setIcon(new ImageIcon(Class.class.getResource("/img/imprimir2.png")));
              
        //SE AGREGAN LOS ELEMENTOS CREADOS AL MODULO
        add(buscar_label);
        add(buscar_field);
        add(buscar_boton);
        add(actualizar_boton);
        obtenerConsutlas();
        add(imprimir_boton);
        add(eliminar_boton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buscar_boton){
            //EL BOTON DE BUSCAR CREA UNA NUEVA TALBA CON LOS CAMPOS SELECCIONADOS, ELIMINA LA ANTERIOR Y REIMPRIME LA TABLA EN EL JPANEL
            System.out.println("Consultas buscar boton clicked");     
            this.remove(tabla);
            this.remove(imprimir_boton);
            this.remove(eliminar_boton);            
            String busqueda = buscar_field.getText();
            System.out.println("busqueda: "+busqueda);     
            obtenerConsutlasBusqueda(busqueda);
            add(tabla); 
            add(imprimir_boton);
            add(eliminar_boton);
            this.revalidate();
            this.repaint();
        }
        if(e.getSource()==actualizar_boton){
            //EL BOTON DE ACTUALIZAR CREA UNA NUEVA TALBA CON EL TOTAL DE REGISTROS, ELIMINA LA ANTERIOR Y REIMPRIME LA TABLA EN EL JPANEL
            System.out.println("Actualizar boton clicked");     
            this.remove(tabla);
            this.remove(imprimir_boton);
            this.remove(eliminar_boton);  
            buscar_field.setText(null);
            obtenerConsutlas();
            add(tabla); 
            add(imprimir_boton);
            add(eliminar_boton);
            this.revalidate();
            this.repaint();
        }
        if(e.getSource()==eliminar_boton){
            //EL BOTON ELIMINAR ELIMINA LA BUSQUEDA Y VUELVE A IMPRIMIR EL TOTAL 
            System.out.println("Consultas eliminar boton clicked");
            buscar_field.setText(null);
            this.remove(tabla);
            obtenerConsutlas();
            add(imprimir_boton);
            add(eliminar_boton);
            this.revalidate();
            this.repaint();
        }
        if(e.getSource()==imprimir_boton){
            //EL BOTON IMPRIMIR IMPRIME LA TABLA MOSTRADA EN EL JPANEL LLAMANDO A LA CLASE IMPRIMIR CONSULTAS
            System.out.println("Consultas imprimir boton clicked");
            ImprimirConsultas.imprimirTabla(this.consultas_tabla);
        }
    }
    
}

