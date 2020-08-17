package dpoo2_u2_a3_morr;

import dpoo2_u2_a3_morr.inventarios.InventariosModulo;
import dpoo2_u2_a3_morr.rh.RHModulo;
import dpoo2_u2_a3_morr.nomina.NominaModulo;
import dpoo2_u2_a3_morr.reportes.ReportesModulo;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Restaurante extends JFrame implements ActionListener{
    InventariosModulo inventarios = new InventariosModulo();
    RHModulo rh = new RHModulo();
    NominaModulo nomina = new NominaModulo();
    ReportesModulo reportes = new ReportesModulo();
    JButton boton_inventarios, boton_rh, boton_nomina, boton_reportes;
    JLabel titulo_panel;
    Restaurante(){
        setVisible(true);
        setBounds(700, 100, 500, 800);
        setTitle("Restaurante");
        setDefaultCloseOperation(Restaurante.DISPOSE_ON_CLOSE);
             
        Container contentpane = getContentPane();
        
        contentpane.setLayout(new FlowLayout());
        
        boton_inventarios = new JButton("Inventarios");
        boton_inventarios.setPreferredSize(new Dimension(230, 30));
        boton_rh = new JButton("Recursos Humanos");
        boton_rh.setPreferredSize(new Dimension(230, 30));
        boton_nomina = new JButton("Nomina");
        boton_nomina.setPreferredSize(new Dimension(230, 30));
        boton_reportes = new JButton("Reportes");
        boton_reportes.setPreferredSize(new Dimension(230, 30));
        
        boton_inventarios.addActionListener(this);
        boton_rh.addActionListener(this);
        boton_nomina.addActionListener(this);
        boton_reportes.addActionListener(this);
        
        titulo_panel = new JLabel("Seleccione una Opcion");
        titulo_panel.setPreferredSize(new Dimension(460, 50));
        titulo_panel.setHorizontalAlignment(SwingConstants.CENTER);
        
        contentpane.add(boton_inventarios);
        contentpane.add(boton_rh);
        contentpane.add(boton_nomina);
        contentpane.add(boton_reportes);      
        
        contentpane.add(titulo_panel);
        
        contentpane.add(inventarios);
        contentpane.add(rh);
        contentpane.add(nomina);
        contentpane.add(reportes);

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==boton_inventarios){
            System.out.println("inventarios clicked");
            titulo_panel.setText("Inventarios");
            nomina.setVisible(false);
            rh.setVisible(false);
            reportes.setVisible(false);
            inventarios.setVisible(true);
        }
        if(e.getSource()==boton_rh){
            System.out.println("rh clicked");
            titulo_panel.setText("Recursos Humanos");
            nomina.setVisible(false);
            inventarios.setVisible(false);
            reportes.setVisible(false);
            rh.setVisible(true);

        }
        if(e.getSource()==boton_nomina){
            System.out.println("nomina clicked");
            titulo_panel.setText("Nomina");
            rh.setVisible(false);
            inventarios.setVisible(false);
            reportes.setVisible(false);
            nomina.setVisible(true);
        }
        if(e.getSource()==boton_reportes){
            System.out.println("reportes clicked");
            titulo_panel.setText("Reportes");
            nomina.setVisible(false);
            rh.setVisible(false);
            inventarios.setVisible(false);
            reportes.setVisible(true);
        }
        
    }
    
    public static void main(String[] args) {
        System.out.println("restaurante corriendo");
        Restaurante restaurante = new Restaurante();
    }
    
}
