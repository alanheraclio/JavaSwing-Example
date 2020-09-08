package dpoo2_u2_ea_morr.rh;

import dpoo2_u2_ea_morr.db.DBPersonal;
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

public class RHSubModuleAltas extends JPanel implements ActionListener{
    //SE CREAN LOS ELEMENTOS QUE SE USARAN
    JLabel numero_label, nombre_label, apellidos_label, nacimiento_label, CURP_label, RFC_label, sueldo_label, puesto_label, sucursal_label, ingreso_label;
    JTextField numero_field, nombre_field, apellidos_field, nacimiento_field, CURP_field, RFC_field, sueldo_field, puesto_field, sucursal_field, ingreso_field;
    JButton guardar_boton, limpiar_boton;
    public RHSubModuleAltas(){
        //SE AGREGAN LOS ATRIBUTOS AL CONSTRUCTOR
        setVisible(false);
        setPreferredSize(new Dimension(400, 700));
        setLayout(new FlowLayout());
        
        //SE CREAN LAS ETIQUETAS DEL MODULO
        numero_label = new JLabel("Numero de Empleado:");
        numero_label.setPreferredSize(new Dimension(385, 20));
        numero_label.setHorizontalAlignment(SwingConstants.LEFT);
        numero_field = new JTextField(35);
        
        nombre_label = new JLabel("Nombre:");
        nombre_label.setPreferredSize(new Dimension(385, 20));
        nombre_label.setHorizontalAlignment(SwingConstants.LEFT);
        nombre_field = new JTextField(35);
        
        apellidos_label = new JLabel("Apellidos:");
        apellidos_label.setPreferredSize(new Dimension(385, 20));
        apellidos_label.setHorizontalAlignment(SwingConstants.LEFT);
        apellidos_field = new JTextField(35);
        
        nacimiento_label = new JLabel("Fecha de Nacimiento:");
        nacimiento_label.setPreferredSize(new Dimension(385, 20));
        nacimiento_label.setHorizontalAlignment(SwingConstants.LEFT);
        nacimiento_field = new JTextField(35);
        
        CURP_label = new JLabel("CURP:");
        CURP_label.setPreferredSize(new Dimension(385, 20));
        CURP_label.setHorizontalAlignment(SwingConstants.LEFT);
        CURP_field = new JTextField(35);

        RFC_label = new JLabel("RFC:");
        RFC_label.setPreferredSize(new Dimension(385, 20));
        RFC_label.setHorizontalAlignment(SwingConstants.LEFT);
        RFC_field = new JTextField(35);

        sueldo_label = new JLabel("Sueldo Bruto:");
        sueldo_label.setPreferredSize(new Dimension(385, 20));
        sueldo_label.setHorizontalAlignment(SwingConstants.LEFT);
        sueldo_field = new JTextField(35);

        puesto_label = new JLabel("Puesto:");
        puesto_label.setPreferredSize(new Dimension(385, 20));
        puesto_label.setHorizontalAlignment(SwingConstants.LEFT);
        puesto_field = new JTextField(35);

        sucursal_label = new JLabel("Sucursal:");
        sucursal_label.setPreferredSize(new Dimension(385, 20));
        sucursal_label.setHorizontalAlignment(SwingConstants.LEFT);
        sucursal_field = new JTextField(35);

        ingreso_label = new JLabel("Fecha de Ingreso:");
        ingreso_label.setPreferredSize(new Dimension(385, 20));
        ingreso_label.setHorizontalAlignment(SwingConstants.LEFT);
        ingreso_field = new JTextField(35);
        
        //SE CREAN LOS BOTONES DEL MODULO
        guardar_boton = new JButton("Guardar");
        guardar_boton.addActionListener(this);
        guardar_boton.setPreferredSize(new Dimension(126, 30));
        guardar_boton.setIcon(new ImageIcon(Class.class.getResource("/img/guardar2.png")));
        
        limpiar_boton = new JButton("Limpiar");
        limpiar_boton.addActionListener(this);
        limpiar_boton.setPreferredSize(new Dimension(126, 30));
        limpiar_boton.setIcon(new ImageIcon(Class.class.getResource("/img/limpiar2.png")));
        
        //SE AGREGAN LOS ELEMENTOS CREADOS AL MODULO
        add(numero_label);
        add(numero_field);
        
        add(nombre_label);
        add(nombre_field);
        
        add(apellidos_label);
        add(apellidos_field);
        
        add(nacimiento_label);
        add(nacimiento_field);
        
        add(CURP_label);
        add(CURP_field);

        add(RFC_label);
        add(RFC_field);

        add(sueldo_label);
        add(sueldo_field);

        add(puesto_label);
        add(puesto_field);

        add(sucursal_label);
        add(sucursal_field);

        add(ingreso_label);
        add(ingreso_field);
        
        add(guardar_boton);
        add(limpiar_boton);
        
    }
    
    //METODO PARA LIMPIAR EL FORMULARIO
    public void LimpiarFormulario(){
        numero_field.setText(null);
        nombre_field.setText(null);
        apellidos_field.setText(null);
        nacimiento_field.setText(null);
        CURP_field.setText(null);
        RFC_field.setText(null);
        sueldo_field.setText(null);
        puesto_field.setText(null);
        sucursal_field.setText(null);
        ingreso_field.setText(null);
    }

    //SE AGREGAN LAS ACCIONES A LOS BOTONES
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==guardar_boton){
            //SE OBTIENEN LOS VALORES DE LOS CAMPOS DEL FORMULARIO
            //DE SER NCESARIO SE PARSENA DE STRING A INTEGER
            int numero = Integer.parseInt(numero_field.getText());
            String nombre = nombre_field.getText();
            String apellidos = apellidos_field.getText();
            String nacimiento = nacimiento_field.getText();
            String curp  = CURP_field.getText();
            String rfc = RFC_field.getText();
            float sueldo = Float.parseFloat(sueldo_field.getText());
            String puesto = puesto_field.getText();
            String sucursal = sucursal_field.getText();
            String ingreso = ingreso_field.getText();
            //SE CREA UNA INSTANCIA DE LA CLASE QUE INSERTA LOS CAMPOS Y SE LLAMA AL METODO QUE LO HACE
            DBPersonal db = new DBPersonal();
            db.insertarPersonal(numero, nombre, apellidos, nacimiento, curp, rfc, sueldo, puesto, sucursal, ingreso);
            //SE LIMPIA EL FORMULARIO
            LimpiarFormulario();
        }
        if(e.getSource()==limpiar_boton){
            System.out.println("RH modificar clicked");
            //SE LIMPIA EL FORMULARIO
            LimpiarFormulario();
        }
    }
    
}
