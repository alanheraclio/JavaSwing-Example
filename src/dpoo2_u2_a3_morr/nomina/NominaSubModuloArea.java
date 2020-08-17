package dpoo2_u2_a3_morr.nomina;

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

public class NominaSubModuloArea extends JPanel implements ActionListener{
    //SE CREAN LOS ELEMENTOS QUE SE USARAN
    JLabel departamento_label, area_label, jefe_label, extension_label, estudio_label;
    JTextField departamento_field, area_field, jefe_field, extension_field, estudio_field;
    JButton guardar_boton, editar_boton, limpiar_boton;
    public NominaSubModuloArea(){
        //SE AGREGAN LOS ATRIBUTOS AL CONSTRUCTOR
        setVisible(false);
        setPreferredSize(new Dimension(400, 700));
        setLayout(new FlowLayout());
        
        //SE CREAN LAS ETIQUETAS DEL MODULO        
        departamento_label = new JLabel("Departamento:");
        departamento_label.setPreferredSize(new Dimension(385, 20));
        departamento_label.setHorizontalAlignment(SwingConstants.LEFT);
        departamento_field = new JTextField(35);
        
        area_label = new JLabel("Area:");
        area_label.setPreferredSize(new Dimension(385, 20));
        area_label.setHorizontalAlignment(SwingConstants.LEFT);
        area_field = new JTextField(35);
        
        jefe_label = new JLabel("Jefe:");
        jefe_label.setPreferredSize(new Dimension(385, 20));
        jefe_label.setHorizontalAlignment(SwingConstants.LEFT);
        jefe_field = new JTextField(35);
        
        extension_label = new JLabel("Extension:");
        extension_label.setPreferredSize(new Dimension(385, 20));
        extension_label.setHorizontalAlignment(SwingConstants.LEFT);
        extension_field = new JTextField(35);

        estudio_label = new JLabel("Estudio:");
        estudio_label.setPreferredSize(new Dimension(385, 20));
        estudio_label.setHorizontalAlignment(SwingConstants.LEFT);
        estudio_field = new JTextField(35);
        
        //SE CREAN LOS BOTONES DEL MODULO
        guardar_boton = new JButton("Guardar");
        guardar_boton.addActionListener(this);
        guardar_boton.setPreferredSize(new Dimension(126, 30));
        guardar_boton.setIcon(new ImageIcon(Class.class.getResource("/img/guardar2.png")));

        editar_boton = new JButton("Editar");
        editar_boton.addActionListener(this);
        editar_boton.setPreferredSize(new Dimension(126, 30));
        editar_boton.setIcon(new ImageIcon(Class.class.getResource("/img/limpiar2.png")));
        
        limpiar_boton = new JButton("Limpiar");
        limpiar_boton.addActionListener(this);
        limpiar_boton.setPreferredSize(new Dimension(126, 30));
        limpiar_boton.setIcon(new ImageIcon(Class.class.getResource("/img/limpiar2.png")));
        
        //SE AGREGAN LOS ELEMENTOS CREADOS AL MODULO      
        add(departamento_label);
        add(departamento_field);
        
        add(area_label);
        add(area_field);
        
        add(jefe_label);
        add(jefe_field);
               
        add(extension_label);
        add(extension_field);
        
        add(estudio_label);
        add(estudio_field);
        
        add(guardar_boton);
        add(editar_boton);
        add(limpiar_boton);
        
    }

    //SE AGREGAN LAS ACCIONES A LOS BOTONES
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==guardar_boton){
            System.out.println("Area guardar clicked"); 
            JOptionPane.showMessageDialog(null, "Area Guardada");
        }
        if(e.getSource()==editar_boton){
            System.out.println("Area editar clicked");
        }
        if(e.getSource()==limpiar_boton){
            System.out.println("Area limpiar clicked");
        }
    }
    
}

