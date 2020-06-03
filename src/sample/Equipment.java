package sample;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
public class Equipment {
    private SimpleStringProperty  Cihaz, MpOrtam, MagnetTeknik,LightMesafesi,UV;
    private SimpleIntegerProperty KutupMesafesi,Cihaz_ID;
    public Equipment(int Cihaz_ID,int KutupMesafesi,String Cihaz,String MpOrtam,String MagnetTeknik,String UV,String LightMesafesi){
        this.Cihaz_ID = new SimpleIntegerProperty(Cihaz_ID);
        this.KutupMesafesi = new SimpleIntegerProperty(KutupMesafesi);
        this.Cihaz = new SimpleStringProperty(Cihaz);
        this.MpOrtam = new SimpleStringProperty(MpOrtam);
        this.MagnetTeknik=new SimpleStringProperty(MagnetTeknik);
        this.UV=new SimpleStringProperty(UV);
        this.LightMesafesi= new SimpleStringProperty(LightMesafesi);


    }


    public int getCihaz_ID() {
        return Cihaz_ID.get();
    }

    public String getCihaz() {
        return Cihaz.get();
    }

    public int getKutupMesafesi() {
        return KutupMesafesi.get();
    }

    public String getMpOrtam() {
        return MpOrtam.get();
    }

    public String getMagnetTeknik() {
        return MagnetTeknik.get();
    }

    public String getLightMesafesi() {
        return LightMesafesi.get();
    }

    public String getUV() {
        return UV.get();
    }
}
