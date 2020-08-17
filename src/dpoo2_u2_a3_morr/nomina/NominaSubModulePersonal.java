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

public class NominaSubModulePersonal extends JPanel implements ActionListener{
    //SE CREAN LOS ELEMENTOS QUE SE USARAN
    JLabel nombre_label, salario_label, desempeno_label, edad_label, puesto_label, area_label, sueldo_label, incentivo_label;
    JTextField nombre_field, salario_field, desempeno_field, edad_field, puesto_field, area_field, sueldo_field, incentivo_field;
    JButton guardar_boton, editar_boton, limpiar_boton;
    public NominaSubModulePersonal(){
        //SE AGREGAN LOS ATRIBUTOS AL CONSTRUCTOR
        setVisible(false);
        setPreferredSize(new Dimension(400, 700));
        setLayout(new FlowLayout());
        
        //SE CREAN LAS ETIQUETAS DEL MODULO        
        nombre_label = new JLabel("Nombre:");
        nombre_label.setPreferredSize(new Dimension(385, 20));
        nombre_label.setHorizontalAlignment(SwingConstants.LEFT);
        nombre_field = new JTextField(35);
        
        salario_label = new JLabel("Salario:");
        salario_label.setPreferredSize(new Dimension(385, 20));
        salario_label.setHorizontalAlignment(SwingConstants.LEFT);
        salario_field = new JTextField(35);
        
        desempeno_label = new JLabel("Desempeno:");
        desempeno_label.setPreferredSize(new Dimension(385, 20));
        desempeno_label.setHorizontalAlignment(SwingConstants.LEFT);
        desempeno_field = new JTextField(35);
        
        edad_label = new JLabel("Edad:");
        edad_label.setPreferredSize(new Dimension(385, 20));
        edad_label.setHorizontalAlignment(SwingConstants.LEFT);
        edad_field = new JTextField(35);

        puesto_label = new JLabel("Puesto:");
        puesto_label.setPreferredSize(new Dimension(385, 20));
        puesto_label.setHorizontalAlignment(SwingConstants.LEFT);
        puesto_field = new JTextField(35);

        area_label = new JLabel("Area:");
        area_label.setPreferredSize(new Dimension(385, 20));
        area_label.setHorizontalAlignment(SwingConstants.LEFT);
        area_field = new JTextField(35);

        sueldo_label = new JLabel("Sueldo Bruto:");
        sueldo_label.setPreferredSize(new Dimension(385, 20));
        sueldo_label.setHorizontalAlignment(SwingConstants.LEFT);
        sueldo_field = new JTextField(35);

        incentivo_label = new JLabel("Incentivo:");
        incentivo_label.setPreferredSize(new Dimension(385, 20));
        incentivo_label.setHorizontalAlignment(SwingConstants.LEFT);
        incentivo_field = new JTextField(35);
        
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
        add(nombre_label);
        add(nombre_field);
        
        add(salario_label);
        add(salario_field);
        
        add(desempeno_label);
        add(desempeno_field);
        
        add(edad_label);
        add(edad_field);

        add(puesto_label);
        add(puesto_field);

        add(area_label);
        add(area_field);

        add(sueldo_label);
        add(sueldo_field);

        add(incentivo_label);
        add(incentivo_field);
        
        add(guardar_boton);
        add(editar_boton);
        add(limpiar_boton);
        
    }

    //SE AGREGAN LAS ACCIONES A LOS BOTONES
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==guardar_boton){
            System.out.println("Personal guardar clicked"); 
            JOptionPane.showMessageDialog(null, "Personal Guardado");
        }
        if(e.getSource()==editar_boton){
            System.out.println("Personal editar clicked");
        }
        if(e.getSource()==limpiar_boton){
            System.out.println("Personal limpiar clicked");
        }
    }
    
}

