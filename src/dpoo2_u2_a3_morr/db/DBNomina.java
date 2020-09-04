package dpoo2_u2_a3_morr.db;

import com.mysql.jdbc.Connection;
import static dpoo2_u2_a3_morr.db.DBConexion.getConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

//SE CREA UNA CLASE QUE HEREDA DE LA QUE REALIZA LA CONEXION
public class DBNomina extends DBConexion{
    //SE CREA LE METODO PARA BUSCAR INVENTARIO EN LA BASE DE DATOS
    public static String[] buscarNomina(String matricula){
        String[] datos = new String[8];
        try {
            Connection connect = getConnection();
            PreparedStatement ps;
            ResultSet res;

            ps = connect.prepareStatement("SELECT * FROM nomina WHERE matricula = ?");
            ps.setString(1, matricula);
            res = ps.executeQuery();
            
            if (res.next()) {
                System.out.println("id:"+res.getString("id"));
                System.out.println("matricula:"+res.getString("matricula"));
                System.out.println("area:"+res.getString("area"));
                System.out.println("salario:"+res.getString("salario"));
                System.out.println("incentivo:"+res.getString("incentivo"));
                System.out.println("dias:"+res.getString("dias"));
                System.out.println("descuentos:"+res.getString("descuentos"));
                System.out.println("total:"+res.getString("total"));
                
                datos[0] = res.getString("id");
                datos[1] = res.getString("matricula");
                datos[2] = res.getString("area");
                datos[3] = res.getString("salario");
                datos[4] = res.getString("incentivo");
                datos[5] = res.getString("dias"); 
                datos[6] = res.getString("descuentos");
                datos[7] = res.getString("total");    
                connect.close();
                return datos;
            }
            else{
                JOptionPane.showMessageDialog(null, "No se encontro ningun usuario con esa matricula");
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
    public static void insertarNomina(int matricula, String area, int salario, int incentivo, int dias, int descuentos, int total){
        //UTILIZA EL METODO DE CONEXION DE LA CALSE PADRE
        Connection connect = getConnection();
        PreparedStatement ps;
            
        try {
            //INTENTA INSERTAR LOS DATOS CON EL QUERY
            ps = connect.prepareStatement("INSERT INTO nomina(matricula,area,salario,incentivo,dias,descuentos,total) VALUES (?,?,?,?,?,?,?)");
            //SE INSERTA CADA VALOR QUE ENVIA EL FORMULARIO EN EL QUERY
            ps.setInt(1, matricula);
            ps.setString(2, area);
            ps.setInt(3, salario);
            ps.setInt(4, incentivo);
            ps.setInt(5, salario);
            ps.setInt(6, descuentos);
            ps.setInt(7, total);            
            int res = ps.executeUpdate();
            if (res > 0) {
                //SI LA INSERCION ES EXITOSA ENVIA ESTE MENSAJE
                System.out.println("guardado");     
                JOptionPane.showMessageDialog(null, "Nomina Guardada");
            }
            else{
                //SI LA INSERCION ES FLLIDA ENCIA ESTE MENSAJE
                System.out.println("no guardado");    
                JOptionPane.showMessageDialog(null, "Nomina no Guardada");
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
    public static void actualizarNomina(int matricula, String area, int salario, int incentivo, int dias, int descuentos, int total, int id){
           //UTILIZA EL METODO DE CONEXION DE LA CALSE PADRE
           Connection connect = getConnection();
           PreparedStatement ps;

           try {
               //INTENTA ACTUALIZAR LOS DATOS CON EL QUERY
               ps = connect.prepareStatement("UPDATE nomina SET matricula=?, area=?, salario=?, incentivo=?, dias=?, descuentos=?, total=? WHERE id=?");
               //SE ACTUALIZA CADA VALOR QUE ENVIA EL FORMULARIO EN EL QUERY

               ps.setInt(1, matricula);
               ps.setString(2, area);
               ps.setInt(3, salario);
               ps.setInt(4, incentivo);
               ps.setInt(5, dias); 
               ps.setInt(6, descuentos);
               ps.setInt(7, total);     
               ps.setInt(8, id);

               int res = ps.executeUpdate();
               if (res > 0) {
                   //SI LA ACTUALIZACION ES EXITOSA ENVIA ESTE MENSAJE
                   System.out.println("guardado");     
                   JOptionPane.showMessageDialog(null, "Nomina Actualizada");
               }
               else{
                   //SI LA ACTUALIZACION ES FLLIDA ENCIA ESTE MENSAJE
                   System.out.println("no guardado");    
                   JOptionPane.showMessageDialog(null, "Nomina no Actualizada");
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
    public static void borrarNomina(int id){
           //UTILIZA EL METODO DE CONEXION DE LA CALSE PADRE
           Connection connect = getConnection();
           PreparedStatement ps;

           try {
               //INTENTA BORRAR LOS DATOS CON EL QUERY
               ps = connect.prepareStatement("DELETE FROM nomina WHERE id=?");
               ps.setInt(1, id);

               int res = ps.executeUpdate();
               if (res > 0) {
                   //SI SE BORRA EL DATO ENVIA ESTE MENSAJE
                   System.out.println("eliminado");     
                   JOptionPane.showMessageDialog(null, "Nomina Borrada");
               }
               else{
                   //SI NO SE BORRA ENVIA ESTE MENSAJE
                   System.out.println("no guardado");    
                   JOptionPane.showMessageDialog(null, "Nomina no Borrada");
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
