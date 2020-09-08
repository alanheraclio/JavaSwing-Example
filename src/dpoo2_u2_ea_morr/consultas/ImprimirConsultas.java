package dpoo2_u2_ea_morr.consultas;

import java.awt.print.PrinterException;
import java.text.MessageFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class ImprimirConsultas {
    
    //SE CREA EL METODO ESTATICO PARA IMPRIMIR SIN NECESIDAD DE INSTANCIAR LA CLASE
    public static void imprimirTabla(JTable tabla){    
        
        //SE DEFINE EL MODO DE IMPRESION
        boolean fitWidth = true;        
        boolean interactive = true;
        JTable.PrintMode mode = fitWidth ? JTable.PrintMode.FIT_WIDTH : JTable.PrintMode.NORMAL;

        try {
            //SE INTENTA IMPRIMIR LA TABLA Y SE ALMACENA EL RESULTADO EN UNA VARIABLE          
            boolean completo = tabla.print(mode,
                new MessageFormat("Impreison de Consultas"),
                new MessageFormat("Base de Datos Restaurante"),
                true,
                null,
                interactive); 
            //SI SE COMPLETO LA IMPRESION SE MUESTRA EL MENSAJE
            if (completo) {
                JOptionPane.showMessageDialog(tabla,
                "Impresion Terminada",
                "Resultado de la Impresion",
                JOptionPane.INFORMATION_MESSAGE);
            } 
            //SI NO SE COMPLETO LA IMPRESION SE MUESTRA EL MENSAJE
            else {             
                JOptionPane.showMessageDialog(tabla,
                "Impresion Terminada",
                "Resultado de la Impresion",
                JOptionPane.WARNING_MESSAGE);
            }
        } 
        
        //DE HABER UN ERROR EN LA IMPRESION SE MUESTRA EL MENSAJE
        catch (PrinterException pe) {
            JOptionPane.showMessageDialog(tabla, 
                "Error en la impresion: " + pe.getMessage(), 
                "Resultado de la impresion", 
                JOptionPane.ERROR_MESSAGE);
            }
    }   
}
