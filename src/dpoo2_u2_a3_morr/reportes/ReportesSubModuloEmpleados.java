package dpoo2_u2_a3_morr.reportes;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ReportesSubModuloEmpleados extends JPanel implements ActionListener{
    //SE CREAN LOS ELEMENTOS QUE SE USARAN
    JLabel numero_label, nombre_label, apellidos_label;
    JTextField numero_field, nombre_field, apellidos_field;
    JButton buscar_boton, visualizar_boton;
    public ReportesSubModuloEmpleados(){
        //SE AGREGAN LOS ATRIBUTOS AL CONSTRUCTOR
        setVisible(false);
        setPreferredSize(new Dimension(400, 400));
        setLayout(new FlowLayout());
        
        //SE CREAN LAS ETIQUETAS DEL MODULO
        numero_label = new JLabel("Numero de Empleado:");
        numero_label.setPreferredSize(new Dimension(385, 20));
        numero_label.setHorizontalAlignment(SwingConstants.LEFT);
        numero_field = new JTextField(35);
        
        nombre_label = new JLabel("Nombre de Empleado:");
        nombre_label.setPreferredSize(new Dimension(385, 20));
        nombre_label.setHorizontalAlignment(SwingConstants.LEFT);
        nombre_field = new JTextField(35);
        
        apellidos_label = new JLabel("Apellidos de Empleado:");
        apellidos_label.setPreferredSize(new Dimension(385, 20));
        apellidos_label.setHorizontalAlignment(SwingConstants.LEFT);
        apellidos_field = new JTextField(35);
            
        //SE CREAN LOS BOTONES DEL MODULO
        buscar_boton = new JButton("Buscar");
        buscar_boton.addActionListener(this);
        buscar_boton.setPreferredSize(new Dimension(126, 30));
        buscar_boton.setIcon(new ImageIcon(Class.class.getResource("/img/buscar2.png")));
        
        visualizar_boton = new JButton("Visualizar");
        visualizar_boton.addActionListener(this);
        visualizar_boton.setPreferredSize(new Dimension(126, 30));
        visualizar_boton.setIcon(new ImageIcon(Class.class.getResource("/img/visualizar2.png")));
        
        //SE AGREGAN LOS ELEMENTOS CREADOS AL MODULO
        add(numero_label);
        add(numero_field);
        
        add(nombre_label);
        add(nombre_field);
        
        add(apellidos_label);
        add(apellidos_field);
               
        add(buscar_boton);
        add(visualizar_boton);
        
    }

    //SE AGREGAN LAS ACCIONES A LOS BOTONES
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buscar_boton){
            System.out.println("Reportes buscar clicked"); 
            JOptionPane.showMessageDialog(null, "rh Guardado");
        }
        if(e.getSource()==visualizar_boton){
            System.out.println("Reportes visualizar clicked");
        }
    }
    
}
