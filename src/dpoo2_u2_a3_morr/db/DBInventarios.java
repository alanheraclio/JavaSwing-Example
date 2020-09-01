package dpoo2_u2_a3_morr.db;

import com.mysql.jdbc.Connection;
import static dpoo2_u2_a3_morr.db.DBConexion.getConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

//SE CREA UNA CLASE QUE HEREDA DE LA QUE REALIZA LA CONEXION
public class DBInventarios extends DBConexion{
    //SE CREA LE METODO PARA BUSCAR INVENTARIO EN LA BASE DE DATOS
    public static String[] buscarInventario(String codigo){
        String[] datos = new String[6];
        try {
            Connection connect = getConnection();
            PreparedStatement ps;
            ResultSet res;

            ps = connect.prepareStatement("SELECT * FROM inventario WHERE codigo = ?");
            ps.setString(1, codigo);
            res = ps.executeQuery();
            
            if (res.next()) {
                System.out.println("id:"+res.getString("id"));
                System.out.println("codigo:"+res.getString("codigo"));
                System.out.println("articulo:"+res.getString("articulo"));
                System.out.println("sucursal:"+res.getString("sucursal"));
                System.out.println("existencia:"+res.getString("existencia"));
                System.out.println("marca:"+res.getString("marca"));
                
                datos[0] = res.getString("id");
                datos[1] = res.getString("codigo");
                datos[2] = res.getString("articulo");
                datos[3] = res.getString("sucursal");
                datos[4] = res.getString("existencia");
                datos[5] = res.getString("marca");   
                connect.close();
                return datos;
            }
            else{
                JOptionPane.showMessageDialog(null, "No se encontro ningun articulo");
                connect.close();
                return datos;
            }  
            
        } catch (Exception e) {
            System.out.println("error en resultado: "+e);
            JOptionPane.showMessageDialog(null, "Hubo un error:"+e);
            return datos;
        }
    }
    //SE CREA UN METODO PARA INSERTAR DATOS A LA TABLA INVENTARIOS
    public static void insertarInventario(int codigo, String articulo, String sucursal, int existencia, String marca){
        //UTILIZA EL METODO DE CONEXION DE LA CALSE PADRE
        Connection connect = getConnection();
        PreparedStatement ps;
            
        try {
            //INTENTA INSERTAR LOS DATOS CON EL QUERY
            ps = connect.prepareStatement("INSERT INTO inventario(codigo,articulo,sucursal,existencia,marca) VALUES (?,?,?,?,?)");
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
 
    //SE CREA UN METODO PARA ACTUALIZAR DATOS A LA TABLA INVENTARIOS
    public static void actualizarInventario(int codigo, String articulo, String sucursal, int existencia, String marca, int id){
           //UTILIZA EL METODO DE CONEXION DE LA CALSE PADRE
           Connection connect = getConnection();
           PreparedStatement ps;

           try {
               //INTENTA ACTUALIZAR LOS DATOS CON EL QUERY
               ps = connect.prepareStatement("UPDATE inventario SET codigo=?, articulo=?, sucursal=?, existencia=?, marca=? WHERE id=?");
               //SE ACTUALIZA CADA VALOR QUE ENVIA EL FORMULARIO EN EL QUERY

               ps.setInt(1, codigo);
               ps.setString(2, articulo);
               ps.setString(3, sucursal);
               ps.setInt(4, existencia);
               ps.setString(5, marca);    
               ps.setInt(6, id);

               int res = ps.executeUpdate();
               if (res > 0) {
                   //SI LA ACTUALIZACION ES EXITOSA ENVIA ESTE MENSAJE
                   System.out.println("guardado");     
                   JOptionPane.showMessageDialog(null, "Inventario Actualizado");
               }
               else{
                   //SI LA ACTUALIZACION ES FLLIDA ENCIA ESTE MENSAJE
                   System.out.println("no guardado");    
                   JOptionPane.showMessageDialog(null, "Inventario no Actualizado");
               }
               //SE CIERRA LA CONEXION
               connect.close();

           } 
           catch (Exception e) {
               //SI LA CONEXION ES FALLIDA SE ENVIA ESTE MENSAJE
               System.out.println("error al actualizar: "+e);
               JOptionPane.showMessageDialog(null, "Error al Actualizar");
           }       

       }
    
    //SE CREA UN METODO PARA BORRAR DATOS A LA TABLA INVENTARIOS
    public static void borrarInventario(int id){
           //UTILIZA EL METODO DE CONEXION DE LA CALSE PADRE
           Connection connect = getConnection();
           PreparedStatement ps;

           try {
               //INTENTA BORRAR LOS DATOS CON EL QUERY
               ps = connect.prepareStatement("DELETE FROM inventario WHERE id=?");
               ps.setInt(1, id);

               int res = ps.executeUpdate();
               if (res > 0) {
                   //SI SE BORRA EL DATO ENVIA ESTE MENSAJE
                   System.out.println("eliminado");     
                   JOptionPane.showMessageDialog(null, "Inventario Borrado");
               }
               else{
                   //SI NO SE BORRA ENVIA ESTE MENSAJE
                   System.out.println("no guardado");    
                   JOptionPane.showMessageDialog(null, "Inventario no Borrado");
               }
               //SE CIERRA LA CONEXION
               connect.close();

           } 
           catch (Exception e) {
               //SI LA CONEXION ES FALLIDA SE ENVIA ESTE MENSAJE
               System.out.println("error al borrar: "+e);
               JOptionPane.showMessageDialog(null, "Error al borrar");
           }       

       }
    
}
