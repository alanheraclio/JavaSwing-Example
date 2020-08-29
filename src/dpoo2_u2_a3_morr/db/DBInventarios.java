package dpoo2_u2_a3_morr.db;

import com.mysql.jdbc.Connection;
import static dpoo2_u2_a3_morr.db.DBConexion.getConnection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

//SE CREA UNA CLASE QUE HEREDA DE LA QUE REALIZA LA CONEXION
public class DBInventarios extends DBConexion{
    //SE CREA UN METODO PARA INSERTAR DATOS A LA TABLA INVENTARIOS
    public static void insertarInventario(int codigo, String articulo, String sucursal, int existencia, String marca){
        //UTILIZA EL METODO DE CONEXION DE LA CALSE PADRE
        Connection connect = getConnection();
        PreparedStatement ps;
            
        try {
            //INTENTA INSERTAR LOS DATOS CON EL QUERY
            ps = connect.prepareStatement("INSERT INTO inventario VALUES (?,?,?,?,?)");
            //SE INSERTA CADA VALOR QUE ENVIA EL FORMULARIO EN EL QUERY
            ps.setInt(1, codigo);
            ps.setString(2, articulo);
            ps.setString(3, sucursal);
            ps.setInt(4, existencia);
            ps.setString(5, marca);            
            int res = ps.executeUpdate();
            if (res > 0) {
                //SI LA INSERCION ES EXITOSA ENVIA ESTE MENSAJE
                System.out.println("guardado");     
                JOptionPane.showMessageDialog(null, "Inventario Guardado");
            }
            else{
                //SI LA INSERCION ES FLLIDA ENCIA ESTE MENSAJE
                System.out.println("no guardado");    
                JOptionPane.showMessageDialog(null, "Inventario no Guardado");
            }
            //SE CIERRA LA CONEXION
            connect.close();
            
        } 
        catch (Exception e) {
            //SI LA CONEXION ES FALLIDA SE ENVIA ESTE MENSAJE
            System.out.println("error al insertar: "+e);
            JOptionPane.showMessageDialog(null, "Error al Guardar");
        }       
    
    }
    
}
