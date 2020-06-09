package sample.Library;
import javafx.beans.property.SimpleIntegerProperty;

import javafx.beans.property.SimpleStringProperty;

public class MuayneTable {
    private SimpleIntegerProperty SiraNo;
    private SimpleStringProperty Kaynak,KontrolUzn,KaynakYon,Kalinlik,Cap,HataTipi,HataYeri,Sonuc;

    public MuayneTable(int SiraNo, String Kaynak,String KontrolUzn, String KaynakYon,String Kalinlik, String Cap, String HataTipi,String HataYeri,String Sonuc){
        this.SiraNo = new SimpleIntegerProperty(SiraNo);
        this.Kaynak = new SimpleStringProperty(Kaynak);
        this.KontrolUzn = new SimpleStringProperty(KontrolUzn);
        this.KaynakYon = new SimpleStringProperty(KaynakYon);
        this.Kalinlik = new SimpleStringProperty(Kalinlik);
        this.Cap = new SimpleStringProperty(Cap);
        this.HataTipi = new SimpleStringProperty(HataTipi);
        this.HataYeri = new SimpleStringProperty(HataYeri);
        this.Sonuc = new SimpleStringProperty(Sonuc);

    }

    public int getSiraNo() {
        return SiraNo.get();
    }

    public String getCap() {
        return Cap.get();
    }

    public String getKalinlik() {
        return Kalinlik.get();
    }

    public String getHataTipi() {
        return HataTipi.get();
    }

    public String getKaynak() {
        return Kaynak.get();
    }

    public String getHataYeri() {
        return HataYeri.get();
    }

    public String getKaynakYon() {
        return KaynakYon.get();
    }

    public String getKontrolUzn() {
        return KontrolUzn.get();
    }

    public String getSonuc() {
        return Sonuc.get();
    }
}
