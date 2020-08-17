package dpoo2_u2_a3_morr.reportes;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ReportesModulo extends JPanel implements ActionListener{
    
    public JPanel module = new JPanel();
    JButton boton_empleados, boton_inventario, boton_rh, salir_boton;
    ReportesSubModuloEmpleados empleados = new ReportesSubModuloEmpleados();
    ReportesSubModuloInventario inventario = new ReportesSubModuloInventario();
    ReportesSubModuloRH rh = new ReportesSubModuloRH();    
    
    public ReportesModulo(){
        setVisible(false);
        module.setLayout(new GridLayout(3,1,0,5));
              
        boton_empleados = new JButton("REPORTES ALTAS");
        boton_empleados.setPreferredSize(new Dimension(460, 50));
        boton_empleados.addActionListener(this);
        
        boton_inventario = new JButton("REPORTES BAJAS");
        boton_inventario.setPreferredSize(new Dimension(460, 50));
        boton_inventario.addActionListener(this);
        
        boton_rh = new JButton("REPORTES MODIFICACIONES");
        boton_rh.setPreferredSize(new Dimension(460, 50));
        boton_rh.addActionListener(this);
        
        salir_boton = new JButton("Salir");
        salir_boton.addActionListener(this);
        salir_boton.setVisible(false);
        
        
        module.add(boton_empleados);
        module.add(boton_inventario);
        module.add(boton_rh);
        
        add(module);
        add(empleados);
        add(inventario);
        add(rh);
        add(salir_boton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==boton_empleados){
            System.out.println("inventarios altas clicked");
            module.setVisible(false);
            rh.setVisible(false);
            inventario.setVisible(false);
            empleados.setVisible(true);
            salir_boton.setVisible(true);
            
        }
        if(e.getSource()==boton_inventario){
            System.out.println("inventarios bajas clicked");
            module.setVisible(false);
            empleados.setVisible(false);
            rh.setVisible(false);
            inventario.setVisible(true);
            salir_boton.setVisible(true);
        }
        if(e.getSource()==boton_rh){
            System.out.println("inventarios modificaciones clicked");
            module.setVisible(false);
            empleados.setVisible(false);
            inventario.setVisible(false);
            salir_boton.setVisible(true);
            rh.setVisible(true);
        }
        if(e.getSource()==salir_boton){
            System.out.println("inventarios salir clicked");
            empleados.setVisible(false);
            rh.setVisible(false);
            inventario.setVisible(false);
            module.setVisible(true);
            salir_boton.setVisible(false);
        }
    }
    
}

