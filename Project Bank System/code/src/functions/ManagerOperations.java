package functions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

import functions.Database;


public class ManagerOperations {
    private Connection con;    
    private Statement statement;
    private ResultSet rs;
    private PreparedStatement preparedStatement;
    
    public ManagerOperations(){
        con = Database.baglan(con);
    }
    
    public ArrayList<OperationsTable> IslemTablosunuGoruntuleme(int islem_miktari){
        ArrayList<OperationsTable> musteri_islemleri = new ArrayList<OperationsTable>();
        
        String sorgu = "Select * from islem_tablosu order by islem_no desc LIMIT " + islem_miktari;
        
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
    
    public void Mt_temsilcilerininMaasi(int maas){
        String sorgu = "Update musteri_temsilcisi Set maas = "+maas;
        
        try {
            statement = con.createStatement();
            statement.executeUpdate(sorgu);
            
        } catch (SQLException ex) {
            Logger.getLogger(ManagerOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void yeniParaBirimiEkleme(String yeni_birim,int deger){
        String sorgu = "Insert Into kur (para_birimi,degeri) VALUES (?,?)";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, yeni_birim);
            preparedStatement.setInt(2, deger);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ManagerOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void kurDegerleriniGuncelleme(String para_birimi, int yeni_deger){
        String sorgu = "Update kur Set degeri = ? where para_birimi = ?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setInt(1, yeni_deger);
            preparedStatement.setString(2, para_birimi);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ManagerOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public int[] bankaninGenelDurumu(){
        String sorgu1 = "select sum(bakiye) as 'bakiye',sum(kredi_borcu) as 'kredi_borcu' from musteriler";
        String sorgu2 = "select sum(maas) as 'maas' from musteri_temsilcisi";
                      
        try {
            int toplam_bakiye = 0,borc=0,toplam_gider=0;
            statement = con.createStatement();
            rs = statement.executeQuery(sorgu1);
            
            while(rs.next()){
                toplam_bakiye = rs.getInt("bakiye");
                borc = rs.getInt("kredi_borcu");
                break;
            }
            rs = statement.executeQuery(sorgu2);
            
            while(rs.next()){
                toplam_gider = rs.getInt("maas");
                break;
            }
            
            int kar = borc-toplam_gider;
            int[] durum = {borc,toplam_gider,kar,toplam_bakiye};
            
            return durum;
            
        } catch (SQLException ex) {
            Logger.getLogger(ManagerOperations.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    
    }
        
    public void SistemiIlerletme(int ay){
        String sorgu  = "Update islem_tablosu set tarih = DATEADD(month," + ay + ",tarih)";
        
        try {
            statement = con.createStatement();
            statement.executeUpdate(sorgu);
        } catch (SQLException ex) {
            Logger.getLogger(ManagerOperations.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
    
    
}

