package functions;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class OperationsTable {
    private int islem_no;
    private String kaynak;
    private int kaynak_id;
    private String hedef;
    private int hedef_id;
    private String islem;
    private int tutar;
    private int kaynak_bakiye;
    private int hedef_bakiye;
    private Date tarih;

    public OperationsTable(int islem_no, String kaynak, int kaynak_id, String hedef, int hedef_id, String islem, int tutar, int kaynak_bakiye, int hedef_bakiye, Date tarih) {
        this.islem_no = islem_no;
        this.kaynak = kaynak;
        this.kaynak_id = kaynak_id;
        this.hedef = hedef;
        this.hedef_id = hedef_id;
        this.islem = islem;
        this.tutar = tutar;
        this.kaynak_bakiye = kaynak_bakiye;
        this.hedef_bakiye = hedef_bakiye;
        this.tarih = tarih;
    }

    public int getIslem_no() {
        return islem_no;
    }

    public void setIslem_no(int islem_no) {
        this.islem_no = islem_no;
    }

    public String getKaynak() {
        return kaynak;
    }

    public void setKaynak(String kaynak) {
        this.kaynak = kaynak;
    }

    public int getKaynak_id() {
        return kaynak_id;
    }

    public void setKaynak_id(int kaynak_id) {
        this.kaynak_id = kaynak_id;
    }

    public String getHedef() {
        return hedef;
    }

    public void setHedef(String hedef) {
        this.hedef = hedef;
    }

    public int getHedef_id() {
        return hedef_id;
    }

    public void setHedef_id(int hedef_id) {
        this.hedef_id = hedef_id;
    }

    public String getIslem() {
        return islem;
    }

    public void setIslem(String islem) {
        this.islem = islem;
    }

    public int getTutar() {
        return tutar;
    }

    public void setTutar(int tutar) {
        this.tutar = tutar;
    }

    public int getKaynak_bakiye() {
        return kaynak_bakiye;
    }

    public void setKaynak_bakiye(int kaynak_bakiye) {
        this.kaynak_bakiye = kaynak_bakiye;
    }

    public int getHedef_bakiye() {
        return hedef_bakiye;
    }

    public void setHedef_bakiye(int hedef_bakiye) {
        this.hedef_bakiye = hedef_bakiye;
    }

    public Date getTarih() {
        return tarih;
    }

    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }

    
    
    
    
}
