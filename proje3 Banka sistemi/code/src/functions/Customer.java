package functions;

public class Customer {
    private int id;
    private String ad;
    private String soyad;
    private String Telno;
    private String Tc;
    private int Bakiye;
    private int kredi_borcu;
    private String para_birimi;
    private int mt_id;

    public Customer(int id, String ad, String soyad, String Telno, String Tc, int Bakiye, int kredi_borcu, String para_birimi, int mt_id) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.Telno = Telno;
        this.Tc = Tc;
        this.Bakiye = Bakiye;
        this.kredi_borcu = kredi_borcu;
        this.para_birimi = para_birimi;
        this.mt_id = mt_id;
    }

    public int getKredi_borcu() {
        return kredi_borcu;
    }

    public void setKredi_borcu(int kredi_borcu) {
        this.kredi_borcu = kredi_borcu;
    }

    public String getPara_birimi() {
        return para_birimi;
    }

    public void setPara_birimi(String para_birimi) {
        this.para_birimi = para_birimi;
    }

    public int getMt_id() {
        return mt_id;
    }

    public void setMt_id(int mt_id) {
        this.mt_id = mt_id;
    }

 
    public void ParaYatir(int miktar){
        this.Bakiye += miktar;
    }
    
    public void ParaCekme(int miktar){
        this.Bakiye -= miktar;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String isim) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyisim) {
        this.soyad = soyad;
    }

    public String getTelno() {
        return Telno;
    }

    public void setTelno(String Telno) {
        this.Telno = Telno;
    }

    public String getTc() {
        return Tc;
    }

    public void setTc(String Tc) {
        this.Tc = Tc;
    }

    public int getBakiye() {
        return Bakiye;
    }

    public void setBakiye(int Bakiye) {
        this.Bakiye = Bakiye;
    }
    
    
    
    
    
    
}
