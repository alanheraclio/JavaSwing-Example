package dpoo2_u2_ea_morr.db;

import com.mysql.jdbc.Connection;
import static dpoo2_u2_ea_morr.db.DBConexion.getConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

//SE CREA UNA CLASE QUE HEREDA DE LA QUE REALIZA LA CONEXION
public class DBConsultas extends DBConexion{
    
    //METODO PARA OBTENER EL TOTAL DE REGISTROS
    public int obtenerRegistros(){
        int registros = 0;
         try{
            //METODOS DE CONEXION
            Connection connect = getConnection();
            PreparedStatement ps;
            ResultSet res;
            
            //QUERY PARA OBTENER LOS VALORES
            ps = connect.prepareStatement("SELECT COUNT(*) AS registros FROM personal");
            res = ps.executeQuery();
            
            while(res.next()){
                System.out.println("numero de registros en tabla personal"+res.getInt("registros"));
                registros = res.getInt("registros");
            }   
        }
        catch(Exception e){
            System.out.println("No fue posible obtener el numero de registros de personal error"+e);
            JOptionPane.showMessageDialog(null, "Hubo un error:"+e); 
        }
        return registros;
    }
    
    //METODO PARA OBTENER TODOS LOS VALORES CON LA BUSQUEDA SELECCIONADA
    public int obtenerRegistrosBusqueda(String nombre){
        int registros = 0;
        //SE INTENTA HACE LA CONEXION Y OBTENER LOS RSULTDOS
         try{
            //METODOS DE CONEXION
            Connection connect = getConnection();
            PreparedStatement ps;
            ResultSet res;
            
            //QUERY PARA OBTENER LOS VALORES
            ps = connect.prepareStatement("SELECT COUNT(*) AS registros FROM personal WHERE nombre = ?");
            ps.setString(1, nombre);
            res = ps.executeQuery();
            
            while(res.next()){
                System.out.println("numero de registros en tabla personal"+res.getInt("registros"));
                registros = res.getInt("registros");
                if (registros == 0) {
                   JOptionPane.showMessageDialog(null,"No hay registro con ese nombre");  
                }
            }   
        }
        catch(Exception e){
            System.out.println("No fue posible obtener el numero de registros de personal error"+e);
            JOptionPane.showMessageDialog(null, "Hubo un error:"+e); 
        }
        return registros;
    }
    
    //SE CREA LE METODO PARA BUSCAR CONSULTAS EN LA BASE DE DATOS
    public  String[][] obtenerConsultas(){
        //VARIABLES PARA ALMACENAR LOS DATOS DE LA BASE DE DATOS
        int i = 0;
        String[][] datos = new String[obtenerRegistros()][5];
        //SE INTENTA HACE LA CONEXION Y OBTENER LOS RSULTDOS
        try {
            //METODOS DE CONEXION
            Connection connect = getConnection();
            PreparedStatement ps;
            ResultSet res;

            //QUERY PARA OBTENER LOS VALORES
            ps = connect.prepareStatement("SELECT nombre, apellidos, incentivo, descuentos, total FROM personal INNER JOIN nomina ON personal.id = nomina.id;");
            res = ps.executeQuery();
            
            while (res.next()) {
                //SE ALMACENANAN LOS DATOS DE LA BASE DE DATOS EN EL ARREGLO
                datos[i][0] = res.getString("nombre");
                datos[i][1] = res.getString("apellidos");
                datos[i][2] = res.getString("incentivo");
                datos[i][3] = res.getString("descuentos");
                datos[i][4] = res.getString("total");  
                i++;   
            }
            //SE CIERRA LA CONEXION Y SE RETORNAN LOS DATOS OBTENIDOS
            connect.close();
            return datos;
        }
        //EN CASO DE ERROR SE MUESTRA EL MENSAJE 
        catch (Exception e) {
            System.out.println("error en resultado: "+e);
            JOptionPane.showMessageDialog(null, "Hubo un error:"+e);
            return datos;
        }
    }
    
    //SE CREA LE METODO PARA BUSCAR UNA CONSULTA EN LA BASE DE DATOS
    public  String[][] obtenerConsultasBusqueda(String nombre){
        //VARIABLES PARA ALMACENAR LOS DATOS DE LA BASE DE DATOS
        String[][] datos = new String[obtenerRegistrosBusqueda(nombre)][5];
        int i = 0;
        //SE INTENTA HACE LA CONEXION Y OBTENER LOS RSULTDOS
        try {
            //METODOS DE CONEXION
            Connection connect = getConnection();
            PreparedStatement ps;
            ResultSet res;
            
            //QUERY PARA OBTENER LOS VALORES
            ps = connect.prepareStatement("SELECT nombre, apellidos, incentivo, descuentos, total FROM personal INNER JOIN nomina ON personal.id = nomina.id WHERE nombre = ?");
            ps.setString(1, nombre);
            res = ps.executeQuery();
            
            while (res.next()) {
                //SE ALMACENANAN LOS DATOS DE LA BASE DE DATOS EN EL ARREGLO
                datos[i][0] = res.getString("nombre");
                datos[i][1] = res.getString("apellidos");
                datos[i][2] = res.getString("incentivo");
                datos[i][3] = res.getString("descuentos");
                datos[i][4] = res.getString("total");
                i++; 
            }
            //SE CIERRA LA CONEXION Y SE RETORNAN LOS DATOS OBTENIDOS
            connect.close();
            return datos;
        }
        //EN CASO DE ERROR SE MUESTRA EL MENSAJE    
        catch (Exception e) {
            System.out.println("error en resultado: "+e);
            JOptionPane.showMessageDialog(null, "Hubo un error:"+e);
            return datos;
        }
    }
    
}
