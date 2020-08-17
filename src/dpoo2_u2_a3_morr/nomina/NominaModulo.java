package dpoo2_u2_a3_morr.nomina;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class NominaModulo extends JPanel implements ActionListener{
    
    //SE CREA EL CONTENEDOR DEL MENU DEL MODULO
    public JPanel module = new JPanel();
    JButton boton_personal, boton_area, salir_boton;
    
    //SE CREAN LOS MENUS A PARTIR DE LAS CLASES CON LOS FORMULARIOS
    NominaSubModulePersonal personal = new NominaSubModulePersonal();
    NominaSubModuloArea area = new NominaSubModuloArea(); 
    
    public NominaModulo(){
        //SE INICIALIZA LA CLASE CON LOS ATRIBUTOS
        setVisible(false);
        module.setLayout(new GridLayout(2,1,0,5));
        
        //SE CREAN LOS BOTONES PARA EL MENU DE MODULO
        boton_personal = new JButton("PERSONAL");
        boton_personal.setPreferredSize(new Dimension(460, 50));
        boton_personal.addActionListener(this);
        
        boton_area = new JButton("AREA");
        boton_area.setPreferredSize(new Dimension(460, 50));
        boton_area.addActionListener(this);
        
        salir_boton = new JButton("Salir");
        salir_boton.addActionListener(this);
        salir_boton.setVisible(false);
        
        //SE AGREGAN LOS BOTONES AL MODULO
        module.add(boton_personal);
        module.add(boton_area);
        
        //SE AGREGAN TODOS LOS ELEMENTOS A LA VENTANA PRINCIPAL DEL MODULO
        add(module);
        add(personal);
        add(area);
        add(salir_boton);
    }

    //SE AGREGAN LAS ACCIONES A LOS BOTONES PARA OCULTAR O MOSTRAR LOS ELEMENTOS
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==boton_personal){
            System.out.println("Nomina personal clicked");
            module.setVisible(false);
            area.setVisible(false);
            personal.setVisible(true);
            salir_boton.setVisible(true);
            
        }
        if(e.getSource()==boton_area){
            System.out.println("Nomina area clicked");
            module.setVisible(false);
            personal.setVisible(false);
            area.setVisible(true);
            salir_boton.setVisible(true);
        }
        if(e.getSource()==salir_boton){
            System.out.println("Nomina salir clicked");
            personal.setVisible(false);
            area.setVisible(false);
            module.setVisible(true);
            salir_boton.setVisible(false);
        }
    }
    
}
