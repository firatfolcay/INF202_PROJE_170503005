//--------------------------
//Fırat Fuat Olcay 170503005
//--------------------------
package sample;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Firma {
    private SimpleStringProperty  Firma_Name, Il,Ilce, JobOrder_No,Offer_No;
    private SimpleIntegerProperty Firma_ID;

    public Firma(String Firma_Name, String Il,String Ilce, String JobOrder_No, String Offer_No,int Firma_ID){
        this.Firma_ID = new SimpleIntegerProperty(Firma_ID);
        this.Firma_Name = new SimpleStringProperty(Firma_Name);
        this.Il = new SimpleStringProperty(Il);
        this.Ilce = new SimpleStringProperty(Ilce);
        this.JobOrder_No=new SimpleStringProperty(JobOrder_No);
        this.Offer_No=new SimpleStringProperty(Offer_No);


    }
    public Firma(String Firma_Name, String Il,String Ilce, String JobOrder_No, String Offer_No){

        this.Firma_Name = new SimpleStringProperty(Firma_Name);
        this.Il = new SimpleStringProperty(Il);
        this.Ilce = new SimpleStringProperty(Ilce);
        this.JobOrder_No=new SimpleStringProperty(JobOrder_No);
        this.Offer_No=new SimpleStringProperty(Offer_No);


    }

    public String getFirma_Name() {
        return Firma_Name.get();
    }

    public String getIl() {
        return Il.get();
    }

    public String getIlce() {
        return Ilce.get();
    }

    public int getFirma_ID() {
        return Firma_ID.get();
    }

    public String getJobOrder_No() {
        return JobOrder_No.get();
    }

    public String getOffer_No() {
        return Offer_No.get();
    }
}
