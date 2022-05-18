package functions;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import functions.Database;

 
public class CustomerOperations {
    private Connection con;    
    private Statement statement;
    private ResultSet rs;
    private PreparedStatement preparedStatement;
    
    
    public CustomerOperations(){
        con = Database.baglan(con);
    }
    
    public Customer musteriBilgileriniGetir(int id){
        String sorgu = "Select * from musteriler where id = "+id;
        
        try {
            statement = con.createStatement();
            rs = statement.executeQuery(sorgu);
            
            while(rs.next()){
                String ad = rs.getNString("Ad");
                String soyad = rs.getString("Soyad");
                String tel_no = rs.getString("Tel_no");
                String tc = rs.getString("Tc");
                int bakiye = rs.getInt("bakiye");
                int kredi_borcu = rs.getInt("kredi_borcu");
                String para_birimi = rs.getString("para_birimi");
                int Mt_id = rs.getInt("Mt_id");
                
                Customer musteri = new Customer(id, ad, soyad, tel_no, tc, bakiye, kredi_borcu, para_birimi,Mt_id);
                return musteri;
         
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomerOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
   
    public void paraCekme(int miktar,int id){
        String sorgu = "Update musteriler Set bakiye = bakiye - "+ miktar +" where id = " + id;
        
        try {
            statement = con.createStatement();
            statement.executeUpdate(sorgu);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
        LocalDate tarih = LocalDate.now();  
        Date bugun = Date.valueOf(tarih);
        
        Customer mus = musteriBilgileriniGetir(id);   
      
        String sorgu2 = "Insert Into islem_tablosu (kaynak, kaynak_id, hedef, islem ,tutar, kaynak_bakiye, tarih) VALUES (?,?,?,?,?,?,?)";  
            
        try { 
            preparedStatement = con.prepareStatement(sorgu2);
            preparedStatement.setString(1, mus.getAd()+" hesap");
            preparedStatement.setInt(2, mus.getId());
            preparedStatement.setString(3, mus.getAd());
            preparedStatement.setString(4, "para çekme");
            preparedStatement.setInt(5, miktar);
            preparedStatement.setInt(6, mus.getBakiye());
            preparedStatement.setDate(7, bugun);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void paraYatirma(int miktar,int id){
        String sorgu = "Update musteriler Set bakiye = bakiye + "+ miktar +" where id = " + id;
        
        try {
            statement = con.createStatement();
            statement.executeUpdate(sorgu);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
        LocalDate tarih = LocalDate.now();  
        Date bugun = Date.valueOf(tarih);
        
        Customer mus = musteriBilgileriniGetir(id);   
      
        String sorgu2 = "Insert Into islem_tablosu (kaynak, hedef_id, hedef, islem ,tutar, hedef_bakiye, tarih) VALUES (?,?,?,?,?,?,?)";  
            
        try { 
            preparedStatement = con.prepareStatement(sorgu2);
            preparedStatement.setString(1, mus.getAd());
            preparedStatement.setInt(2, mus.getId());
            preparedStatement.setString(3, mus.getAd()+ " hesap");
            preparedStatement.setString(4, "para yatırma");
            preparedStatement.setInt(5, miktar);
            preparedStatement.setInt(6, mus.getBakiye());
            preparedStatement.setDate(7, bugun);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void paraTransferi(int gonderen_id,int alan_id, int miktar){
        String sorgu = "Update musteriler Set bakiye = bakiye - "+ miktar +" where id = "+gonderen_id;
        String sorgu2 = "Update musteriler Set bakiye = bakiye + "+ miktar +" where id = "+alan_id;
        
        try {
            statement = con.createStatement();
            statement.executeUpdate(sorgu);
            statement.executeUpdate(sorgu2);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        LocalDate tarih = LocalDate.now();  
        Date bugun = Date.valueOf(tarih);
        
        Customer gonderen = musteriBilgileriniGetir(gonderen_id); 
        Customer alici = musteriBilgileriniGetir(alan_id);
        
        String sorgu3 = "Insert Into islem_tablosu (kaynak, kaynak_id, hedef, hedef_id, islem ,tutar, kaynak_bakiye ,hedef_bakiye, tarih) VALUES (?,?,?,?,?,?,?,?,?)";
        
        try {
            preparedStatement = con.prepareStatement(sorgu3);
            preparedStatement.setString(1, gonderen.getAd()+" hesap");
            preparedStatement.setInt(2, gonderen.getId());
            preparedStatement.setString(3, alici.getAd() +" hesap");
            preparedStatement.setInt(4, alici.getId());
            preparedStatement.setString(5, "para gonderme");
            preparedStatement.setInt(6, miktar);
            preparedStatement.setInt(7, gonderen.getBakiye());
            preparedStatement.setInt(8, alici.getBakiye());
            preparedStatement.setDate(9, bugun);
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomerOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    public void krediBorcuOdeme(int miktar,int id){
        String sorgu = "Update musteriler Set kredi_borcu = kredi_borcu - "+ miktar +" , bakiye = bakiye - "+ miktar +" where id = " + id;
        
        try {
            statement = con.createStatement();
            statement.executeUpdate(sorgu);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
        LocalDate tarih = LocalDate.now();  
        Date bugun = Date.valueOf(tarih);
        
        Customer mus = musteriBilgileriniGetir(id);   
      
        String sorgu2 = "Insert Into islem_tablosu (kaynak, kaynak_id, hedef, islem ,tutar, kaynak_bakiye, tarih) VALUES (?,?,?,?,?,?,?)";  
            
        try { 
            preparedStatement = con.prepareStatement(sorgu2);
            preparedStatement.setString(1, mus.getAd()+ " hesap");
            preparedStatement.setInt(2, mus.getId());
            preparedStatement.setString(3, "banka");
            preparedStatement.setString(4, "kredi borcu ödeme");
            preparedStatement.setInt(5, miktar);
            preparedStatement.setInt(6, mus.getBakiye());
            preparedStatement.setDate(7, bugun);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    
    
    
    
    
}

    public void bilgiGuncelleme(int id,String y_ad,String y_soyad,String y_tel_no,String y_tc){
        String sorgu = "Update musteriler Set ad = ? ,soyad = ? , Tel_no = ? , Tc = ?  where id =?";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1,y_ad);
            preparedStatement.setString(2,y_soyad);
            preparedStatement.setString(3,y_tel_no);
            preparedStatement.setString(4,y_tc);
            preparedStatement.setInt(5,id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(WorkerOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}






