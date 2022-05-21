package functions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Database {
    private static final String kullanıcı_adi = "root";
    private static final String parola = "";
    private static final String db_ismi ="banka";
    private static final String host = "localhost";  
    private static final int port = 3306;
    
    public static Connection baglan(Connection con){
        String url = "jdbc:mysql://" +host + ":" + port + "/" + db_ismi;
        //?useUnicode=true&characterEncoding=utf8 
        try {
            con = DriverManager.getConnection(url, kullanıcı_adi, parola);
            System.out.println("Baglanti basarili...");
            return con;
        } catch (SQLException ex) {
            System.out.println("Baglanti basarisiz...");
            ex.printStackTrace();
            return null;
        }
    }
    
    
    
    
    
}
