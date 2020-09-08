package dpoo2_u2_ea_morr.consultas;

import dpoo2_u2_ea_morr.db.DBConsultas;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class ConsultasModulo extends JPanel implements ActionListener{
    
    JLabel buscar_label;
    JTextField buscar_field;
    JButton buscar_boton, eliminar_boton, imprimir_boton;   
    DBConsultas db = new DBConsultas();
    JScrollPane tabla;
    JTable consultas_tabla;
    String[] columnas = {"NOMBRE", "APELLIDOS", "INCENTIVOS", "DECUENTOS", "TOTAL"}; 
    
    
    public void obtenerConsutlas(){      
        Object[][] filas = db.obtenerConsultas();      
        consultas_tabla = new JTable(filas,columnas);
        tabla = new JScrollPane(consultas_tabla);
        this.add(tabla);          
    }
    
    public void obtenerConsutlasBusqueda(String busqueda){
        Object[][] filas_busqueda = db.obtenerConsultasBusqueda(busqueda); 
        JTable consultas_tabla = new JTable(filas_busqueda,columnas);
        tabla = new JScrollPane(consultas_tabla);
        this.add(tabla);     
    }
    
    public ConsultasModulo(){
        setVisible(false);
        setPreferredSize(new Dimension(500, 500));
        setLayout(new FlowLayout());
        
        //SE CREAN LAS ETIQUETAS DEL MODULO
        buscar_label = new JLabel("Bucar por nombre:");
        buscar_label.setPreferredSize(new Dimension(120, 20));
        buscar_label.setHorizontalAlignment(SwingConstants.RIGHT);
        buscar_field = new JTextField(10);
              
        buscar_boton = new JButton("Buscar");
        buscar_boton.addActionListener(this);
        buscar_boton.setPreferredSize(new Dimension(126, 30));
        buscar_boton.setIcon(new ImageIcon(Class.class.getResource("/img/buscar2.png")));
                      
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
        obtenerConsutlas();
        add(imprimir_boton);
        add(eliminar_boton);
        
    }
    
    public void utilJTablePrint(JTable jTable, String header, String footer, boolean showPrintDialog){        
        boolean fitWidth = true;        
        boolean interactive = true;
        // We define the print mode (Definimos el modo de impresión)
        JTable.PrintMode mode = fitWidth ? JTable.PrintMode.FIT_WIDTH : JTable.PrintMode.NORMAL;
        try {
            // Print the table (Imprimo la tabla)             
            boolean complete = jTable.print(mode,
                    new MessageFormat(header),
                    new MessageFormat(footer),
                    showPrintDialog,
                    null,
                    interactive);                 
            if (complete) {
                // Mostramos el mensaje de impresión existosa
                JOptionPane.showMessageDialog(jTable,
                        "Print complete (Impresión completa)",
                        "Print result (Resultado de la impresión)",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                // Mostramos un mensaje indicando que la impresión fue cancelada                 
                JOptionPane.showMessageDialog(jTable,
                        "Print canceled (Impresión cancelada)",
                        "Print result (Resultado de la impresión)",
                        JOptionPane.WARNING_MESSAGE);
            }
        } catch (PrinterException pe) {
            JOptionPane.showMessageDialog(jTable, 
                    "Print fail (Fallo de impresión): " + pe.getMessage(), 
                    "Print result (Resultado de la impresión)", 
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buscar_boton){
            System.out.println("Consultas buscar boton clicked");     
            this.remove(tabla);
            this.remove(imprimir_boton);
            this.remove(eliminar_boton);            
            String busqueda = buscar_field.getText();
            System.out.println("busqueda: "+busqueda);     
            obtenerConsutlasBusqueda(busqueda);
            add(imprimir_boton);
            add(eliminar_boton);
            this.revalidate();
            this.repaint();
        }
        if(e.getSource()==eliminar_boton){
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
            System.out.println("Consultas imprimir boton clicked");
            MessageFormat headerFormat = new MessageFormat("MI CABECERA");
            MessageFormat footerFormat = new MessageFormat("- Página {0} -");
            //tabla.print(PrintMode.FIT_WIDTH, headerFormat, footerFormat);
            utilJTablePrint(consultas_tabla, "header", "footer", true);
        }
    }
    
}

