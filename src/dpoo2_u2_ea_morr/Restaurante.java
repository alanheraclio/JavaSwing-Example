package dpoo2_u2_ea_morr;

import dpoo2_u2_ea_morr.inventarios.InventariosModulo;
import dpoo2_u2_ea_morr.rh.RHModulo;
import dpoo2_u2_ea_morr.nomina.NominaModulo;
import dpoo2_u2_ea_morr.consultas.ConsultasModulo;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

//METODO PARA CREAR EL JFRAME QUE CONTIENE TODA LA APLICACION
public class Restaurante extends JFrame implements ActionListener{
    //SE CREAN LOS ELEMENTOS QUE CONSTRUYEN EL MENU PRINCIPAL
    InventariosModulo inventarios = new InventariosModulo();
    RHModulo rh = new RHModulo();
    NominaModulo nomina = new NominaModulo();
    ConsultasModulo reportes = new ConsultasModulo();
    JButton boton_inventarios, boton_rh, boton_nomina, boton_consultas;
    JLabel titulo_panel;
    //CONTRUCTOR QUE ASIGNA LOS VALORES INICALES
    Restaurante(){
        setVisible(true);
        setBounds(700, 100, 500, 800);
        setTitle("Restaurante");
        setDefaultCloseOperation(Restaurante.DISPOSE_ON_CLOSE);
             
        Container contentpane = getContentPane();        
        contentpane.setLayout(new FlowLayout());
        
        //SE CREAN Y ASIGNAN VALORES A LOS ELEMENTOS DEL MENU INICIAL        
        boton_inventarios = new JButton("Inventarios");
        boton_inventarios.setPreferredSize(new Dimension(230, 30));
        boton_rh = new JButton("Recursos Humanos");
        boton_rh.setPreferredSize(new Dimension(230, 30));
        boton_nomina = new JButton("Nomina");
        boton_nomina.setPreferredSize(new Dimension(230, 30));
        boton_consultas = new JButton("Consultas");
        boton_consultas.setPreferredSize(new Dimension(230, 30));
        
        boton_inventarios.addActionListener(this);
        boton_rh.addActionListener(this);
        boton_nomina.addActionListener(this);
        boton_consultas.addActionListener(this);
        
        titulo_panel = new JLabel("Seleccione una Opcion");
        titulo_panel.setPreferredSize(new Dimension(460, 50));
        titulo_panel.setHorizontalAlignment(SwingConstants.CENTER);
        
        //SE AGREGAN LOS ELEMENTOS AL JFRAME
        contentpane.add(boton_inventarios);
        contentpane.add(boton_rh);
        contentpane.add(boton_nomina);
        contentpane.add(boton_consultas);      
        
        contentpane.add(titulo_panel);
        
        contentpane.add(inventarios);
        contentpane.add(rh);
        contentpane.add(nomina);
        contentpane.add(reportes);

    }
    //METODOS DE LOS BOTONES DEL MENU PRINCIPAL
    @Override
    public void actionPerformed(ActionEvent e) {
        //BOTON INVENTARIOS OCULTA LOS DEMAS SUBMUENUS Y MUESTRA EL SUBMENU INVENTARIOS
        if(e.getSource()==boton_inventarios){
            System.out.println("inventarios clicked");
            titulo_panel.setText("Inventarios");
            nomina.setVisible(false);
            rh.setVisible(false);
            reportes.setVisible(false);
            inventarios.setVisible(true);
        }
        //BOTON RH OCULTA LOS DEMAS SUBMUENUS Y MUESTRA EL SUBMENU RH
        if(e.getSource()==boton_rh){
            System.out.println("rh clicked");
            titulo_panel.setText("Recursos Humanos");
            nomina.setVisible(false);
            inventarios.setVisible(false);
            reportes.setVisible(false);
            rh.setVisible(true);

        }
        //BOTON NOMINA OCULTA LOS DEMAS SUBMUENUS Y MUESTRA EL SUBMENU NOMINA
        if(e.getSource()==boton_nomina){
            System.out.println("nomina clicked");
            titulo_panel.setText("Nomina");
            rh.setVisible(false);
            inventarios.setVisible(false);
            reportes.setVisible(false);
            nomina.setVisible(true);
        }
        //BOTON CONSULTAS OCULTA LOS DEMAS SUBMUENUS Y MUESTRA EL SUBMENU CONSULTAS
        if(e.getSource()==boton_consultas){
            System.out.println("reportes clicked");
            titulo_panel.setText("Consultas");
            nomina.setVisible(false);
            rh.setVisible(false);
            inventarios.setVisible(false);
            reportes.setVisible(true);
        }
        
    }
    
    //METODO MAIN PARA INICIAR LA INSTANCIA DE LA APLICACION
    public static void main(String[] args) {
        System.out.println("restaurante corriendo");
        Restaurante restaurante = new Restaurante();
    }
    
}
