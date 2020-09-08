package dpoo2_u2_ea_morr.db;

import com.mysql.jdbc.Connection;
import static dpoo2_u2_ea_morr.db.DBConexion.getConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

//SE CREA UNA CLASE QUE HEREDA DE LA QUE REALIZA LA CONEXION
public class DBPersonal extends DBConexion{
    //SE CREA LE METODO PARA BUSCAR INVENTARIO EN LA BASE DE DATOS
    public static String[] buscarPersonal(String numero_empleado){
        String[] datos = new String[11];
        try {
            Connection connect = getConnection();
            PreparedStatement ps;
            ResultSet res;

            ps = connect.prepareStatement("SELECT * FROM personal WHERE numero_empleado = ?");
            ps.setString(1, numero_empleado);
            res = ps.executeQuery();
            
            if (res.next()) {
                //SE AGREGAN TODOS LOS RESULTADOS A LA VARIABLE DATOS                
                datos[0] = res.getString("id");
                datos[1] = res.getString("numero_empleado");
                datos[2] = res.getString("nombre");
                datos[3] = res.getString("apellidos");
                datos[4] = res.getString("fecha_nacimiento");
                datos[5] = res.getString("curp"); 
                datos[6] = res.getString("rfc");
                datos[7] = res.getString("sueldo");  
                datos[8] = res.getString("puesto"); 
                datos[9] = res.getString("sucursal");
                datos[10] = res.getString("fecha_ingreso");     
                connect.close();
                return datos;
            }
            else{
                JOptionPane.showMessageDialog(null, "No se encontro ningun empleado");
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
    public static void insertarPersonal(int numero_empleado, String nombre, String apellidos, String fecha_nacimiento, String curp, String rfc, float sueldo, String puesto, String sucursal, String fecha_ingreso){
        //UTILIZA EL METODO DE CONEXION DE LA CALSE PADRE
        Connection connect = getConnection();
        PreparedStatement ps;
            
        try {
            //INTENTA INSERTAR LOS DATOS CON EL QUERY
            ps = connect.prepareStatement("INSERT INTO personal(numero_empleado,nombre,apellidos,fecha_nacimiento,curp,rfc,sueldo,puesto,sucursal,fecha_ingreso) VALUES (?,?,?,?,?,?,?,?,?,?)");
            //SE INSERTA CADA VALOR QUE ENVIA EL FORMULARIO EN EL QUERY
            ps.setInt(1, numero_empleado);
            ps.setString(2, nombre);
            ps.setString(3, apellidos);
            ps.setString(4, fecha_nacimiento);
            ps.setString(5, apellidos);
            ps.setString(6, rfc);
            ps.setFloat(7, sueldo);   
            ps.setString(8, puesto);
            ps.setString(9, sucursal);
            ps.setString(10, fecha_nacimiento);           
            int res = ps.executeUpdate();
            if (res > 0) {
                //SI LA INSERCION ES EXITOSA ENVIA ESTE MENSAJE
                System.out.println("guardado");     
                JOptionPane.showMessageDialog(null, "Personal Guardado");
            }
            else{
                //SI LA INSERCION ES FLLIDA ENCIA ESTE MENSAJE
                System.out.println("no guardado");    
                JOptionPane.showMessageDialog(null, "Personal no Guardado");
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
    public static void actualizarPersonal(int numero_empleado, String nombre, String apellidos, String fecha_nacimiento, String curp, String rfc, float sueldo, String puesto, String sucursal, String fecha_ingreso, int id){
           //UTILIZA EL METODO DE CONEXION DE LA CALSE PADRE
           Connection connect = getConnection();
           PreparedStatement ps;

           try {
               //INTENTA ACTUALIZAR LOS DATOS CON EL QUERY
               ps = connect.prepareStatement("UPDATE personal SET numero_empleado=?, nombre=?, apellidos=?, fecha_nacimiento=?, curp=?, rfc=?, sueldo=?, puesto=?, sucursal=?, fecha_ingreso=?  WHERE id=?");
               //SE ACTUALIZA CADA VALOR QUE ENVIA EL FORMULARIO EN EL QUERY

               ps.setInt(1, numero_empleado);
               ps.setString(2, nombre);
               ps.setString(3, apellidos);
               ps.setString(4, fecha_nacimiento);
               ps.setString(5, curp); 
               ps.setString(6, rfc);
               ps.setFloat(7, sueldo);  
               ps.setString(8, puesto); 
               ps.setString(9, sucursal);
               ps.setString(10, fecha_ingreso);      
               ps.setInt(11, id);

               int res = ps.executeUpdate();
               if (res > 0) {
                   //SI LA ACTUALIZACION ES EXITOSA ENVIA ESTE MENSAJE
                   System.out.println("guardado");     
                   JOptionPane.showMessageDialog(null, "Personal Actualizado");
               }
               else{
                   //SI LA ACTUALIZACION ES FLLIDA ENCIA ESTE MENSAJE
                   System.out.println("no guardado");    
                   JOptionPane.showMessageDialog(null, "Personal no Actualizado");
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
    public static void borrarPersonal(int numero){
           //UTILIZA EL METODO DE CONEXION DE LA CALSE PADRE
           Connection connect = getConnection();
           PreparedStatement ps;

           try {
               //INTENTA BORRAR LOS DATOS CON EL QUERY
               ps = connect.prepareStatement("DELETE FROM personal WHERE numero_empleado=?");
               ps.setInt(1, numero);

               int res = ps.executeUpdate();
               if (res > 0) {
                   //SI SE BORRA EL DATO ENVIA ESTE MENSAJE
                   System.out.println("eliminado");     
                   JOptionPane.showMessageDialog(null, "Personal Borrado");
               }
               else{
                   //SI NO SE BORRA ENVIA ESTE MENSAJE
                   System.out.println("no guardado");    
                   JOptionPane.showMessageDialog(null, "Personal no Borrado");
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
