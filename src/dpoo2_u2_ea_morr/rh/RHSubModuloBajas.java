package dpoo2_u2_ea_morr.rh;

import dpoo2_u2_ea_morr.db.DBPersonal;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class RHSubModuloBajas extends JPanel implements ActionListener{
    //SE CREAN LOS ELEMENTOS QUE SE USARAN
    JLabel numero_label, nombre_label, apellidos_label, nacimiento_label, CURP_label, RFC_label, sueldo_label, puesto_label, sucursal_label, ingreso_label;
    JTextField numero_field, nombre_field, apellidos_field, nacimiento_field, CURP_field, RFC_field, sueldo_field, puesto_field, sucursal_field, ingreso_field;
    JButton buscar_boton, borrar_boton;
    int id_personal, numero;
    public RHSubModuloBajas(){
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
        nombre_field.setEditable(false);
        
        apellidos_label = new JLabel("Apellidos:");
        apellidos_label.setPreferredSize(new Dimension(385, 20));
        apellidos_label.setHorizontalAlignment(SwingConstants.LEFT);
        apellidos_field = new JTextField(35);
        apellidos_field.setEditable(false);
        
        nacimiento_label = new JLabel("Fecha de Nacimiento:");
        nacimiento_label.setPreferredSize(new Dimension(385, 20));
        nacimiento_label.setHorizontalAlignment(SwingConstants.LEFT);
        nacimiento_field = new JTextField(35);
        nacimiento_field.setEditable(false);
        
        CURP_label = new JLabel("CURP:");
        CURP_label.setPreferredSize(new Dimension(385, 20));
        CURP_label.setHorizontalAlignment(SwingConstants.LEFT);
        CURP_field = new JTextField(35);
        CURP_field.setEditable(false);

        RFC_label = new JLabel("RFC:");
        RFC_label.setPreferredSize(new Dimension(385, 20));
        RFC_label.setHorizontalAlignment(SwingConstants.LEFT);
        RFC_field = new JTextField(35);
        RFC_field.setEditable(false);

        sueldo_label = new JLabel("Sueldo Bruto:");
        sueldo_label.setPreferredSize(new Dimension(385, 20));
        sueldo_label.setHorizontalAlignment(SwingConstants.LEFT);
        sueldo_field = new JTextField(35);
        sueldo_field.setEditable(false);

        puesto_label = new JLabel("Puesto:");
        puesto_label.setPreferredSize(new Dimension(385, 20));
        puesto_label.setHorizontalAlignment(SwingConstants.LEFT);
        puesto_field = new JTextField(35);
        puesto_field.setEditable(false);

        sucursal_label = new JLabel("Sucursal:");
        sucursal_label.setPreferredSize(new Dimension(385, 20));
        sucursal_label.setHorizontalAlignment(SwingConstants.LEFT);
        sucursal_field = new JTextField(35);
        sucursal_field.setEditable(false);

        ingreso_label = new JLabel("Fecha de Ingreso:");
        ingreso_label.setPreferredSize(new Dimension(385, 20));
        ingreso_label.setHorizontalAlignment(SwingConstants.LEFT);
        ingreso_field = new JTextField(35);
        ingreso_field.setEditable(false);
        
        //SE CREAN LOS BOTONES DEL MODULO    
        buscar_boton = new JButton("Buscar");
        buscar_boton.addActionListener(this);
        buscar_boton.setPreferredSize(new Dimension(126, 30));
        buscar_boton.setIcon(new ImageIcon(Class.class.getResource("/img/buscar2.png")));
        
        borrar_boton = new JButton("Borrar");
        borrar_boton.addActionListener(this);
        borrar_boton.setPreferredSize(new Dimension(126, 30));
        borrar_boton.setIcon(new ImageIcon(Class.class.getResource("/img/borrar2.png")));
        
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
        
        add(buscar_boton);
        add(borrar_boton);
        
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
        if(e.getSource()==buscar_boton){
            System.out.println("Personal buscar clicked"); 
            DBPersonal db = new DBPersonal();
            db.buscarPersonal(numero_field.getText());
            String[] datos =  db.buscarPersonal(numero_field.getText());
            if (datos[0] != null) {
                id_personal = parseInt(datos[0]);
                numero_field.setText(datos[1]);
                nombre_field.setText(datos[2]);
                apellidos_field.setText(datos[3]);
                nacimiento_field.setText(datos[4]);
                CURP_field.setText(datos[5]);
                RFC_field.setText(datos[6]);
                sueldo_field.setText(datos[7]);
                puesto_field.setText(datos[8]);
                sucursal_field.setText(datos[9]);
                ingreso_field.setText(datos[10]);
            }
            else {
                LimpiarFormulario();
            }
        }
        if(e.getSource()==borrar_boton){
            System.out.println("RH borrar clicked"); 
            //SE OBTIENEN LOS VALORES DE LOS CAMPOS DEL FORMULARIO
            //DE SER NCESARIO SE PARSENA DE STRING A INTEGER
            numero = Integer.parseInt(numero_field.getText());
            //SE CREA UNA INSTANCIA DE LA CLASE QUE INSERTA LOS CAMPOS Y SE LLAMA AL METODO QUE LO HACE
            DBPersonal db = new DBPersonal();
            db.borrarPersonal(numero);
            //SE LIMPIA EL FORMULARIO
            LimpiarFormulario();
        }
    }
    
}
