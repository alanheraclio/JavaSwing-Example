package dpoo2_u2_a3_morr.nomina;

import dpoo2_u2_a3_morr.db.DBNomina;
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

public class NominaSubModuloBajas extends JPanel implements ActionListener{
    //SE CREAN LOS ELEMENTOS QUE SE USARAN
    JLabel matricula_label, area_label, salario_label, incentivo_label, dias_label, descuentos_label, total_label;
    JTextField matricula_field, area_field, salario_field, incentivo_field, dias_field, descuentos_field, total_field;
    JButton buscar_boton, borrar_boton;
    int id_nomina, matricula_nomina;
    public NominaSubModuloBajas(){
        //SE AGREGAN LOS ATRIBUTOS AL CONSTRUCTOR
        setVisible(false);
        setPreferredSize(new Dimension(400, 700));
        setLayout(new FlowLayout());
        
        //SE CREAN LAS ETIQUETAS DEL MODULO
        matricula_label = new JLabel("matricula de Empleado:");
        matricula_label.setPreferredSize(new Dimension(385, 20));
        matricula_label.setHorizontalAlignment(SwingConstants.LEFT);
        matricula_field = new JTextField(35);
        
        area_label = new JLabel("area:");
        area_label.setPreferredSize(new Dimension(385, 20));
        area_label.setHorizontalAlignment(SwingConstants.LEFT);
        area_field = new JTextField(35);
        area_field.setEditable(false);
        
        salario_label = new JLabel("salario:");
        salario_label.setPreferredSize(new Dimension(385, 20));
        salario_label.setHorizontalAlignment(SwingConstants.LEFT);
        salario_field = new JTextField(35);
        salario_field.setEditable(false);
        
        incentivo_label = new JLabel("Fecha de incentivo:");
        incentivo_label.setPreferredSize(new Dimension(385, 20));
        incentivo_label.setHorizontalAlignment(SwingConstants.LEFT);
        incentivo_field = new JTextField(35);
        incentivo_field.setEditable(false);
        
        dias_label = new JLabel("dias:");
        dias_label.setPreferredSize(new Dimension(385, 20));
        dias_label.setHorizontalAlignment(SwingConstants.LEFT);
        dias_field = new JTextField(35);
        dias_field.setEditable(false);

        descuentos_label = new JLabel("descuentos:");
        descuentos_label.setPreferredSize(new Dimension(385, 20));
        descuentos_label.setHorizontalAlignment(SwingConstants.LEFT);
        descuentos_field = new JTextField(35);
        descuentos_field.setEditable(false);

        total_label = new JLabel("total Bruto:");
        total_label.setPreferredSize(new Dimension(385, 20));
        total_label.setHorizontalAlignment(SwingConstants.LEFT);
        total_field = new JTextField(35);
        total_field.setEditable(false);
      
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
        add(matricula_label);
        add(matricula_field);
        
        add(area_label);
        add(area_field);
        
        add(salario_label);
        add(salario_field);
        
        add(incentivo_label);
        add(incentivo_field);
        
        add(dias_label);
        add(dias_field);

        add(descuentos_label);
        add(descuentos_field);

        add(total_label);
        add(total_field);
        
        add(buscar_boton);
        add(borrar_boton);
        
    }
    
    //METODO PARA LIMPIAR EL FORMULARIO
    public void LimpiarFormulario(){
        matricula_field.setText(null);
        area_field.setText(null);
        salario_field.setText(null);
        incentivo_field.setText(null);
        dias_field.setText(null);
        descuentos_field.setText(null);
        total_field.setText(null);
    }

    //SE AGREGAN LAS ACCIONES A LOS BOTONES
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buscar_boton){
            System.out.println("Nomina buscar clicked"); 
            DBNomina db = new DBNomina();
            db.buscarNomina(matricula_field.getText());
            String[] datos =  db.buscarNomina(matricula_field.getText());
            if (datos[0] != null) {
                id_nomina = parseInt(datos[0]);
                matricula_field.setText(datos[1]);
                area_field.setText(datos[2]);
                salario_field.setText(datos[3]);
                incentivo_field.setText(datos[4]);
                dias_field.setText(datos[5]);
                descuentos_field.setText(datos[6]);
                total_field.setText(datos[7]);
            }
            else {
                matricula_field.setText(null);
                area_field.setText(null);
                salario_field.setText(null);
                incentivo_field.setText(null);
                dias_field.setText(null);
                descuentos_field.setText(null);
                total_field.setText(null);
            }
        }
        if(e.getSource()==borrar_boton){
            System.out.println("Nomina borrar clicked"); 
            //SE OBTIENEN LOS VALORES DE LOS CAMPOS DEL FORMULARIO
            //DE SER NCESARIO SE PARSENA DE STRING A INTEGER
            matricula_nomina = Integer.parseInt(matricula_field.getText());
            //SE CREA UNA INSTANCIA DE LA CLASE QUE INSERTA LOS CAMPOS Y SE LLAMA AL METODO QUE LO HACE
            DBNomina db = new DBNomina();
            db.borrarNomina(matricula_nomina);
            //SE LIMPIA EL FORMULARIO
            LimpiarFormulario();
        }
    }
    
}
