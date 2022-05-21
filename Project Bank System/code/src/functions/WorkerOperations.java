package functions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import functions.Database;


public class WorkerOperations {
    private Connection con;    
    private Statement statement;
    private ResultSet rs; 
    private PreparedStatement preparedStatement;
    
    public WorkerOperations(){
        con = Database.baglan(con);
    }
    
    public void musteriEkleme(String ad,String soyad,String tel_no,String tc,int musteri_temsilcisi_id,int bakiye ,int kredi_borcu,String para_birimi){
        String sorgu = "Insert Into musteriler (Ad, Soyad, Tel_no, Tc,bakiye, kredi_borcu ,para_birimi,Mt_id) VALUES (?,?,?,?,?,?,?,?)"; 
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1,ad);
            preparedStatement.setString(2,soyad);
            preparedStatement.setString(3,tel_no);
            preparedStatement.setString(4,tc);
            preparedStatement.setInt(5,bakiye);
            preparedStatement.setInt(6,kredi_borcu);
            preparedStatement.setString(7,para_birimi);
            preparedStatement.setInt(8,musteri_temsilcisi_id);
            preparedStatement.executeUpdate();    
        } catch (SQLException ex) {
            Logger.getLogger(WorkerOperations.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    public void musteriSilme(int id){
        String sorgu = "Delete from musteriler where id = "+id;
        
        try {
            statement = con.createStatement();
            statement.executeUpdate(sorgu);
        } catch (SQLException ex) {
            Logger.getLogger(WorkerOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void musteriGuncelleme(int id,String y_ad,String y_soyad,String y_tel_no,String y_tc,int y_bakiye ,int y_kredi_borcu,String y_para_birimi){
        String sorgu = "Update musteriler Set ad = ? ,soyad = ? , Tel_no = ? , Tc = ? , bakiye = ? , kredi_borcu = ? , para_birimi = ? where id =?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1,y_ad);
            preparedStatement.setString(2,y_soyad);
            preparedStatement.setString(3,y_tel_no);
            preparedStatement.setString(4,y_tc);
            preparedStatement.setInt(5,y_bakiye);
            preparedStatement.setInt(6,y_kredi_borcu);
            preparedStatement.setString(7,y_para_birimi);
            preparedStatement.setInt(8,id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(WorkerOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    public ArrayList<Customer> SorumluOlduguMusteriler(int Mt_id){
        ArrayList<Customer> musteriler = new ArrayList<Customer>();
        
        String sorgu = "Select * from musteriler where Mt_id = "+Mt_id;
        
        try {
            statement = con.createStatement();
            rs = statement.executeQuery(sorgu);
            
            while(rs.next()){
                int id = rs.getInt("id");
                String ad = rs.getNString("Ad");
                String soyad = rs.getString("Soyad");
                String tel_no = rs.getString("Tel_no");
                String tc = rs.getString("Tc");
                int bakiye = rs.getInt("bakiye");
                int kredi_borcu = rs.getInt("kredi_borcu");
                String para_birimi = rs.getString("para_birimi"); 
                
                musteriler.add(new Customer(id, ad, soyad, tel_no, tc, bakiye, kredi_borcu, para_birimi, Mt_id));
            }
            return musteriler;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(WorkerOperations.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public ArrayList<OperationsTable> musterininIslemleriGetir(int musteri_id){
        ArrayList<OperationsTable> musteri_islemleri = new ArrayList<OperationsTable>();
        
        String sorgu = "Select * from islem_tablosu where hedef_id = "+musteri_id + " or kaynak_id = " + musteri_id;
        
        
        try {
            statement = con.createStatement();
            rs = statement.executeQuery(sorgu);
            
            while(rs.next()){
                int islem_no = rs.getInt("islem_no");
                String kaynak = rs.getNString("kaynak");
                int kaynak_id = rs.getInt("kaynak_id");
                String hedef = rs.getString("hedef");
                int hedef_id = rs.getInt("hedef_id");
                String islem = rs.getString("islem");
                int tutar = rs.getInt("tutar");
                int kaynak_bakiye = rs.getInt("kaynak_bakiye");
                int hedef_bakiye = rs.getInt("hedef_bakiye");
                
                musteri_islemleri.add(new OperationsTable(islem_no, kaynak, kaynak_id, hedef, hedef_id, islem, tutar, kaynak_bakiye, hedef_bakiye, rs.getDate("tarih")));
            }
            return musteri_islemleri;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(WorkerOperations.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }    
    }
    
    
    
    
    
    
    
}
