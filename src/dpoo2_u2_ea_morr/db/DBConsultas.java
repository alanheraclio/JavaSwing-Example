package dpoo2_u2_ea_morr.db;

import com.mysql.jdbc.Connection;
import static dpoo2_u2_ea_morr.db.DBConexion.getConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

//SE CREA UNA CLASE QUE HEREDA DE LA QUE REALIZA LA CONEXION
public class DBConsultas extends DBConexion{
    
    public int obtenerRegistros(){
        int registros = 0;
         try{
            Connection connect = getConnection();
            PreparedStatement ps;
            ResultSet res;
            
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
    
    public int obtenerRegistrosBusqueda(String nombre){
        int registros = 0;
         try{
            Connection connect = getConnection();
            PreparedStatement ps;
            ResultSet res;
            
            ps = connect.prepareStatement("SELECT COUNT(*) AS registros FROM personal WHERE nombre = ?");
            ps.setString(1, nombre);
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
    
    //SE CREA LE METODO PARA BUSCAR CONSULTAS EN LA BASE DE DATOS
    public  String[][] obtenerConsultas(){
        int i = 0;
        String[][] datos = new String[obtenerRegistros()][5];
        try {
            Connection connect = getConnection();
            PreparedStatement ps;
            ResultSet res;

            ps = connect.prepareStatement("SELECT nombre, apellidos, incentivo, descuentos, total FROM personal INNER JOIN nomina ON personal.id = nomina.id;");
            res = ps.executeQuery();
            
            while (res.next()) {
                /*System.out.println("i:"+i);
                System.out.println("nombre:"+res.getString("nombre"));
                System.out.println("apellidos:"+res.getString("apellidos"));
                System.out.println("incentivo:"+res.getString("incentivo"));
                System.out.println("descuentos:"+res.getString("descuentos"));
                System.out.println("total:"+res.getString("total"));*/
                
                datos[i][0] = res.getString("nombre");
                datos[i][1] = res.getString("apellidos");
                datos[i][2] = res.getString("incentivo");
                datos[i][3] = res.getString("descuentos");
                datos[i][4] = res.getString("total");
                
                i++; 
                
            }
            connect.close();
            return datos;
        }
            
        catch (Exception e) {
            System.out.println("error en resultado: "+e);
            JOptionPane.showMessageDialog(null, "Hubo un error:"+e);
            return datos;
        }
    }
    
    //SE CREA LE METODO PARA BUSCAR UNA CONSULTA EN LA BASE DE DATOS
    public  String[][] obtenerConsultasBusqueda(String nombre){
        String[][] datos = new String[obtenerRegistrosBusqueda(nombre)][5];
        int i = 0;
        try {
            Connection connect = getConnection();
            PreparedStatement ps;
            ResultSet res;

            ps = connect.prepareStatement("SELECT nombre, apellidos, incentivo, descuentos, total FROM personal INNER JOIN nomina ON personal.id = nomina.id WHERE nombre = ?");
            ps.setString(1, nombre);
            res = ps.executeQuery();
            
            while (res.next()) {
                /*System.out.println("i:"+i);
                System.out.println("nombre:"+res.getString("nombre"));
                System.out.println("apellidos:"+res.getString("apellidos"));
                System.out.println("incentivo:"+res.getString("incentivo"));
                System.out.println("descuentos:"+res.getString("descuentos"));
                System.out.println("total:"+res.getString("total"));*/
                
                datos[i][0] = res.getString("nombre");
                datos[i][1] = res.getString("apellidos");
                datos[i][2] = res.getString("incentivo");
                datos[i][3] = res.getString("descuentos");
                datos[i][4] = res.getString("total");
                
                i++; 
                
            }
            connect.close();
            return datos;
        }
            
        catch (Exception e) {
            System.out.println("error en resultado: "+e);
            JOptionPane.showMessageDialog(null, "Hubo un error:"+e);
            return datos;
        }
    }
    
}
