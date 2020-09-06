package dpoo2_u2_a3_morr.db;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

//SE CREA LA CLASE DE CONEXION PARA CONECTARSE A LA BASE DE DATOS
public class DBConexion {
    //SE DECLARAN LAS CARACTERISTICAS DE LA CONEXION
    public static final String URL = "jdbc:mysql://localhost/restaurante";
    public static final String USER = "root";
    public static final String PASS = "";
    //SE CREA UN METODO DE TIPO CONNECTION PARA CONNECTARSE 
    public static Connection getConnection(){
        Connection con = null;
        //SE REQUIRE UTILIZAR EL TRY CATCH PARA DECLARAR LO QUE PASE SE CONECTE A LA BASE DE DATOS O NO
        try {
            //SE INTENTA CONECTAR A LA BASE DE DATOS CON EL CONECTOR DE MYSQL
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL,USER,PASS);
            System.out.println("conexion exitosa");
        } catch (Exception e) {
            //EN CASE DE FALLA SE IMPRIME EL ERROR
            System.out.println("error de conexion: "+e);
        }
        //SE RETORNA LA CONEXION PARA USARLA EN OTROS METODOS
        return con;
    }
           
}
