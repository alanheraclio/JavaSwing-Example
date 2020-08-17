package dpoo2_u2_a3_morr.inventarios;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class InventariosModulo extends JPanel implements ActionListener{
    
    public JPanel module = new JPanel();
    JButton boton_altas, boton_bajas, boton_modificaciones, salir_boton;
    InventariosSubModuleAltas altas = new InventariosSubModuleAltas();
    InventariosSubModuloModificaciones modificaciones = new InventariosSubModuloModificaciones();
    InventariosSubModuloBajas bajas = new InventariosSubModuloBajas();    
    
    public InventariosModulo(){
        setVisible(false);
        module.setLayout(new GridLayout(3,1,0,5));
              
        boton_altas = new JButton("INVENTARIOS ALTAS");
        boton_altas.setPreferredSize(new Dimension(460, 50));
        boton_altas.addActionListener(this);
        
        boton_bajas = new JButton("INVENTARIOS BAJAS");
        boton_bajas.setPreferredSize(new Dimension(460, 50));
        boton_bajas.addActionListener(this);
        
        boton_modificaciones = new JButton("INVENTARIOS MODIFICACIONES");
        boton_modificaciones.setPreferredSize(new Dimension(460, 50));
        boton_modificaciones.addActionListener(this);
        
        salir_boton = new JButton("Salir");
        salir_boton.addActionListener(this);
        //salir_boton.setPreferredSize(new Dimension(50, 60));
        //salir_boton.setIcon(new ImageIcon(Class.class.getResource("/img/salir2.png")));
        salir_boton.setVisible(false);
        
        
        module.add(boton_altas);
        module.add(boton_bajas);
        module.add(boton_modificaciones);
        
        add(module);
        add(altas);
        add(bajas);
        add(modificaciones);
        add(salir_boton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==boton_altas){
            System.out.println("inventarios altas clicked");
            module.setVisible(false);
            modificaciones.setVisible(false);
            altas.setVisible(true);
            salir_boton.setVisible(true);
            
        }
        if(e.getSource()==boton_bajas){
            System.out.println("inventarios bajas clicked");
            module.setVisible(false);
            altas.setVisible(false);
            modificaciones.setVisible(false);
            bajas.setVisible(true);
            salir_boton.setVisible(true);
        }
        if(e.getSource()==boton_modificaciones){
            System.out.println("inventarios modificaciones clicked");
            module.setVisible(false);
            altas.setVisible(false);
            bajas.setVisible(false);
            salir_boton.setVisible(true);
            modificaciones.setVisible(true);
        }
        if(e.getSource()==salir_boton){
            System.out.println("inventarios salir clicked");
            altas.setVisible(false);
            modificaciones.setVisible(false);
            bajas.setVisible(false);
            module.setVisible(true);
            salir_boton.setVisible(false);
        }
    }
    
}
