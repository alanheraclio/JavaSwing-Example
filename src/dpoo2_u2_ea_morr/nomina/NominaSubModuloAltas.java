package dpoo2_u2_ea_morr.nomina;

import dpoo2_u2_ea_morr.db.DBNomina;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class NominaSubModuloAltas extends JPanel implements ActionListener{
    //SE CREAN LOS ELEMENTOS QUE SE USARAN
    JLabel matricula_label, area_label, salario_label, incentivo_label, dias_label, descuentos_label, total_label;
    JTextField matricula_field, area_field, salario_field, incentivo_field, dias_field, descuentos_field, total_field;
    JButton guardar_boton, limpiar_boton;
    public NominaSubModuloAltas(){
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
        
        salario_label = new JLabel("salario:");
        salario_label.setPreferredSize(new Dimension(385, 20));
        salario_label.setHorizontalAlignment(SwingConstants.LEFT);
        salario_field = new JTextField(35);
        
        incentivo_label = new JLabel("incentivo:");
        incentivo_label.setPreferredSize(new Dimension(385, 20));
        incentivo_label.setHorizontalAlignment(SwingConstants.LEFT);
        incentivo_field = new JTextField(35);
        
        dias_label = new JLabel("dias:");
        dias_label.setPreferredSize(new Dimension(385, 20));
        dias_label.setHorizontalAlignment(SwingConstants.LEFT);
        dias_field = new JTextField(35);

        descuentos_label = new JLabel("descuentos:");
        descuentos_label.setPreferredSize(new Dimension(385, 20));
        descuentos_label.setHorizontalAlignment(SwingConstants.LEFT);
        descuentos_field = new JTextField(35);

        total_label = new JLabel("total:");
        total_label.setPreferredSize(new Dimension(385, 20));
        total_label.setHorizontalAlignment(SwingConstants.LEFT);
        total_field = new JTextField(35);
        
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
        
        add(guardar_boton);
        add(limpiar_boton);
        
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
        if(e.getSource()==guardar_boton){
            //SE OBTIENEN LOS VALORES DE LOS CAMPOS DEL FORMULARIO
            //DE SER NCESARIO SE PARSENA DE STRING A INTEGER
            int matricula = Integer.parseInt(matricula_field.getText());
            String area = area_field.getText();
            float salario = Float.parseFloat(salario_field.getText());
            float incentivo = Float.parseFloat(incentivo_field.getText());
            int dias  = Integer.parseInt(dias_field.getText());
            float descuentos = Float.parseFloat(descuentos_field.getText());
            float total = Float.parseFloat(total_field.getText());
            //SE CREA UNA INSTANCIA DE LA CLASE QUE INSERTA LOS CAMPOS Y SE LLAMA AL METODO QUE LO HACE
            DBNomina db = new DBNomina();
            db.insertarNomina(matricula, area, salario, incentivo, dias, descuentos, total);
            //SE LIMPIA EL FORMULARIO
            LimpiarFormulario();
        }
        if(e.getSource()==limpiar_boton){
            System.out.println("Nomina modificar clicked");
            //SE LIMPIA EL FORMULARIO
            LimpiarFormulario();
        }
    }
    
}
