//--------------------------
//Fırat Fuat Olcay 170503005
//--------------------------
package sample;

import javafx.beans.Observable;
import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Library.MuayneTable;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.aspose.cells.SaveFormat;
import com.aspose.cells.Workbook;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Controller implements Initializable {
    public static int SceneName = 0;
    //table view variables
    @FXML
    private TableView<User> tableView;
    @FXML
    private TableColumn<User, Integer> ID;
    @FXML
    private TableColumn<User, String> NameColumn;
    @FXML
    private TableColumn<User, String> SurnameColumn;
    @FXML
    private TableColumn<User, Integer> Level;


    //text field variables
    @FXML
    private TextField NameTextField;
    @FXML
    private TextField SurnameTextField;
    @FXML
    private ChoiceBox LevelChoiceBox;
    @FXML
    private TextField DeletIDTextField;
    @FXML
    private PasswordField PasswordTextField;
    @FXML
    private TextField UpdateNameTextField;
    @FXML
    private TextField UpdateSurnameTextField;
    @FXML
    private PasswordField UpdatePasswordField;
    @FXML
    private ComboBox UpdateLevelChoiceBox;
    @FXML
    private TextField IdUpdateTextField;
    // Firma-------------------------------------------------------
    //textfieldFirma
    @FXML
    private TextField FirmaAdiTextField;
    @FXML
    private TextField IlTextField;
    @FXML
    private TextField IlceTextField;
    @FXML
    private TextField TeklifNoTextField;
    @FXML
    private TextField JobOrderNoTextField;
    @FXML
    private TextField DeletFirmaIdTextField;
    @FXML
    private TextField FirmaAdiUpdateTextField;
    @FXML
    private TextField IlUpdateTextField;
    @FXML
    private TextField IlceUpdateTextField;
    @FXML
    private TextField TeklifNoUpdateTextField;
    @FXML
    private TextField JobOrderNoUpdateTextField;

    //tableview Firma
    @FXML
    private TableView<Firma> tableViewFirma;
    @FXML
    private TableColumn<Firma, Integer> Firma_IDColumn;
    @FXML
    private TableColumn<Firma, String> Firma_NameColumn;
    @FXML
    private TableColumn<Firma, String> Firma_IlColumn;
    @FXML
    private TableColumn<Firma, String> Firma_IlceColumn;
    @FXML
    private TableColumn<Firma, String> Firma_IsEmriNoColumn;
    @FXML
    private TableColumn<Firma, String> Firma_TeklifNoColumn;

    //Equipment

    //tableview Equipment---------------
    @FXML
    private TableView<Equipment> tableViewCihaz;
    @FXML
    private TableColumn<Equipment, Integer> Cihaz_IDColumn;
    @FXML
    private TableColumn<Equipment, String> Cihaz_NameColumn;
    @FXML
    private TableColumn<Equipment, Integer> Cihaz_KutupMesafeColumn;
    @FXML
    private TableColumn<Equipment, String> Cihaz_MpOrtamColumn;
    @FXML
    private TableColumn<Equipment, String> Cihaz_MagnetikColumn;
    @FXML
    private TableColumn<Equipment, String> Cihaz_UVColumn;
    @FXML
    private TableColumn<Equipment, String> Cihaz_LightMesafesi;
    //Equipment---------------------------------
    @FXML
    private TextField CihazAdiTextField;
    @FXML
    private TextField KutupMesafesiTextField;
    @FXML
    private TextField MPTasiyiciOrtamTextField;
    @FXML
    private TextField MiknatislamaTeknikTextField;
    @FXML
    private TextField IsikMesafesiTextField;
    @FXML
    private TextField UVTextField;
    @FXML
    private TextField UpdateCihazAdiTextField;
    @FXML
    private TextField UpdateKutupMesafesiTextField;
    @FXML
    private TextField UpdateMPTasiyiciOrtamTextField;
    @FXML
    private TextField UpdateMiknatislamaTeknikTextField;
    @FXML
    private TextField UpdateIsikMesafesiTextField;
    @FXML
    private TextField UpdateUVTextField;
    @FXML
    private TextField DeleteCihazIDTextField;
    @FXML
    private TextField UpdateCihazIDTextField;

    //RAPOR SIDE---------------------------------
    //  Genel bilgiler -----------------------
    @FXML
    private ComboBox RaporCustomerName;
    @FXML
    private TextField RaporProjeAdi;
    @FXML
    private TextField RaporTestYeri;
    @FXML
    private TextField RaporMuayneStand;
    @FXML
    private TextField RaporDegerlenStand;
    @FXML
    private TextField RaporMuaynePros;
    @FXML
    private TextField RaporMuayneKapsam;
    @FXML
    private TextField RaporResimNo;
    @FXML
    private TextField RaporYuzeyDurum;
    @FXML
    private TextField RaporMuayneAsama;
    @FXML
    private TextField RaporSayfaNo;
    @FXML
    private TextField RaporRaporNo;
    @FXML
    private TextField RaporRaporTarihi;
    @FXML
    private TextField RaporIsEmriNo;
    @FXML
    private TextField RaporTeklifNo;
    //Ekipman Bilgileri--------------------
    @FXML
    private TextField RaporKutupMesafesi;
    @FXML
    private TextField RaporCihaz;
    @FXML
    private TextField RaporMPTasiyici;
    @FXML
    private TextField RaporMiknatisTek;
    @FXML
    private TextField RaporUVIsik;
    @FXML
    private TextField RaporMuayneBolg;
    @FXML
    private TextField RaporLuxmetre;
    @FXML
    private TextField RaporMuayneOrt;
    @FXML
    private TextField RaporMagnetGiderim;
    @FXML
    private TextField RaporIsikMesafe;
    @FXML
    private TextField RaporYuzekSicaklik;
    @FXML
    private TextField RaporAlanSiddeti;
    @FXML
    private TextField RaporYuzey;
    @FXML
    private TextField RaporIsikCihazTanim;
    @FXML
    private TextField RaporKaldirmaTesti;
    @FXML
    private TextField RaporIsilIslem;
    @FXML
    private ComboBox RaporEkipman;
    @FXML
    private ComboBox RaporAkimTipi;
    @FXML
    private TextField RaporStandartSapma;
    @FXML
    private TextField RaporMuayneTarih;
    @FXML
    private TextArea Ekler;
    @FXML
    private CheckBox RaporButtWeld;
    @FXML
    private CheckBox RaporFilletWeld;
    //Muayne Sonuçları------------
    @FXML
    private TextField RaporSiraNo;
    @FXML
    private TextField RaporKaynakParcaNo;
    @FXML
    private TextField RaporKontrolUzn;
    @FXML
    private TextField RaporKaynakYon;
    @FXML
    private TextField RaporKalin;
    @FXML
    private TextField RaporCap;
    @FXML
    private TextField RaporHataTipi;
    @FXML
    private TextField RaporHataYeri;
    @FXML
    private ComboBox<String> RaporSonuc;
    @FXML
    private TableView<MuayneTable> tableViewMuayne;
    @FXML
    private TableColumn<MuayneTable, Integer> SiraNoColumn;
    @FXML
    private TableColumn<MuayneTable, String> KaynakColumn;
    @FXML
    private TableColumn<MuayneTable, String> KontrolUznColumn;
    @FXML
    private TableColumn<MuayneTable, String> KaynakYonColumn;
    @FXML
    private TableColumn<MuayneTable, String> KalinlikColumn;
    @FXML
    private TableColumn<MuayneTable, String> CapColumn;
    @FXML
    private TableColumn<MuayneTable, String> HataTipiColumn;
    @FXML
    private TableColumn<MuayneTable, String> HataYeriColumn;
    @FXML
    private TableColumn<MuayneTable, String> SonucColumn;
    //Personel Bilgileri -----------------
    @FXML
    private ComboBox RaporOperatorCombobox;
    @FXML
    private ComboBox RaporDegerlendirenCombobox;
    @FXML
    private ComboBox RaporOnayCombobox;
    @FXML
    private TextField RaporOperatorName;
    @FXML
    private TextField RaporOperatorSeviye;
    @FXML
    private TextField RaporOperatorTarih;
    @FXML
    private TextField RaporDegerlendirenName;
    @FXML
    private TextField RaporDegerlendirenSeviye;
    @FXML
    private TextField RaporDegerlendirenTarih;
    @FXML
    private TextField RaporOnayName;
    @FXML
    private TextField RaporOnaySeviye;
    @FXML
    private TextField RaporOnayTarih;
    @FXML
    private TextField RaporKayitAdi;
    private String TempName;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            if (SceneName == 2) {
                setFirmaTableView();
            } else if (SceneName == 1) {
                setuserTableView();
            } else if (SceneName == 3) {
                System.out.println("setliom");
                setCihazTableView();
                System.out.println("setledim be gari");

            } else if (SceneName == 4) {

                setGenelbilgiler();
                setEkipmanBilgileri();
                setPersonelBilgileri();
                setMuayneTableView();


                System.out.println("Rapor Sayfası Açıldı");

            }
            System.out.println("Sahne no: " + SceneName);


        } catch (Exception a) {
            System.out.println(a);
        }
    }

    public void setMuayneTableView() throws Exception {
        RaporSonuc.setItems(FXCollections.observableArrayList("OK", "RED"));

        SiraNoColumn.setCellValueFactory(new PropertyValueFactory<MuayneTable, Integer>("SiraNo"));

        KaynakColumn.setCellValueFactory(new PropertyValueFactory<MuayneTable, String>("Kaynak"));

        KontrolUznColumn.setCellValueFactory(new PropertyValueFactory<MuayneTable, String>("KontrolUzn"));

        KaynakYonColumn.setCellValueFactory(new PropertyValueFactory<MuayneTable, String>("KaynakYon"));

        KalinlikColumn.setCellValueFactory(new PropertyValueFactory<MuayneTable, String>("Kalinlik"));

        CapColumn.setCellValueFactory(new PropertyValueFactory<MuayneTable, String>("Cap"));

        HataTipiColumn.setCellValueFactory(new PropertyValueFactory<MuayneTable, String>("HataTipi"));

        HataYeriColumn.setCellValueFactory(new PropertyValueFactory<MuayneTable, String>("HataYeri"));

        SonucColumn.setCellValueFactory(new PropertyValueFactory<MuayneTable, String>("Sonuc"));
        tableViewMuayne.setItems(getMuayneTable());


    }

    public void setuserTableView() throws Exception {
        NameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("Name"));

        SurnameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("Surname"));

        ID.setCellValueFactory(new PropertyValueFactory<User, Integer>("ID"));

        Level.setCellValueFactory(new PropertyValueFactory<User, Integer>("Level"));

        tableView.setItems(getUser());
    }

    public void setCihazTableView() throws Exception {
        Cihaz_NameColumn.setCellValueFactory(new PropertyValueFactory<Equipment, String>("Cihaz"));

        Cihaz_IDColumn.setCellValueFactory(new PropertyValueFactory<Equipment, Integer>("Cihaz_ID"));

        Cihaz_KutupMesafeColumn.setCellValueFactory(new PropertyValueFactory<Equipment, Integer>("KutupMesafesi"));

        Cihaz_MagnetikColumn.setCellValueFactory(new PropertyValueFactory<Equipment, String>("MagnetTeknik"));
        Cihaz_UVColumn.setCellValueFactory(new PropertyValueFactory<Equipment, String>("UV"));
        Cihaz_LightMesafesi.setCellValueFactory(new PropertyValueFactory<Equipment, String>("LightMesafesi"));
        Cihaz_MpOrtamColumn.setCellValueFactory(new PropertyValueFactory<Equipment, String>("MpOrtam"));

        tableViewCihaz.setItems(getEquipment());
    }

    public void setFirmaTableView() throws Exception {
        Firma_IDColumn.setCellValueFactory(new PropertyValueFactory<Firma, Integer>("Firma_ID"));
        Firma_NameColumn.setCellValueFactory(new PropertyValueFactory<Firma, String>("Firma_Name"));
        Firma_IlColumn.setCellValueFactory(new PropertyValueFactory<Firma, String>("Il"));
        Firma_IlceColumn.setCellValueFactory(new PropertyValueFactory<Firma, String>("Ilce"));
        Firma_IsEmriNoColumn.setCellValueFactory(new PropertyValueFactory<Firma, String>("JobOrder_No"));
        Firma_TeklifNoColumn.setCellValueFactory(new PropertyValueFactory<Firma, String>("Offer_No"));
        tableViewFirma.setItems(getFirma());
    }


    public void refreshTableview() throws Exception {

        tableView.setItems(getUser());
    }

    public void refreshFirmaTableview() throws Exception {

        tableViewFirma.setItems(getFirma());
    }

    public void refreshCihazTableview() throws Exception {

        tableViewCihaz.setItems(getEquipment());
    }

    public ObservableList<MuayneTable> getMuayneTable() throws Exception {
        String myUrl = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
        Connection conn = DriverManager.getConnection(myUrl, "root", "root");
        ObservableList<MuayneTable> Muayneler = FXCollections.observableArrayList();
        String query = "SELECT * FROM muayne";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            int SiraNo = rs.getInt("SiraNo");
            String Kaynak = rs.getString("Kaynak");
            String KontrolUzn = rs.getString("KontrolUzn");
            String KaynakYon = rs.getString("KaynakYon");
            String Kalinlik = rs.getString("Kalinlik");
            String Cap = rs.getString("Cap");
            String HataTipi = rs.getString("HataTipi");
            String HataYeri = rs.getString("HataYeri");
            String Sonuc = rs.getString("Sonuc");
            Muayneler.add(new MuayneTable(SiraNo, Kaynak, KontrolUzn, KaynakYon, Kalinlik, Cap, HataTipi, HataYeri, Sonuc));

        }
        st.close();
        conn.close();
        return Muayneler;
    }


    public ObservableList<Firma> getFirma() throws Exception {
        String myUrl = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
        Connection conn = DriverManager.getConnection(myUrl, "root", "root");

        ObservableList<Firma> firmas = FXCollections.observableArrayList();
        String query3 = "SELECT * FROM firmalar";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query3);
        firmas.removeAll(firmas);
        while (rs.next()) {
            int id = rs.getInt("id");
            String firmaname = rs.getString("firma_name");
            String firmaili = rs.getString("firma_Il");
            String firmailce = rs.getString("firma_Ilce");
            String firmateklifno = rs.getString("firma_OfferNo");
            String firmajoborderno = rs.getString("firma_JobOrderNo");


            // print the results
            firmas.add(new Firma(firmaname, firmaili, firmailce, firmajoborderno, firmateklifno, id));


        }

        st.close();
        conn.close();
        // create the mysql insert preparedstatement


        // execute the preparedstatement
        return firmas;

    }


    // public void ObservableList<Firma> getFirma() throws Exception {

    // return firmas;

    //}
    public ObservableList<Equipment> getEquipment() throws Exception {
        ObservableList<Equipment> cihazlar = FXCollections.observableArrayList();
        String myUrl = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
        Connection conn = DriverManager.getConnection(myUrl, "root", "root");
        String query3 = "SELECT * FROM cihazlar";

        // create the java statement
        Statement st = conn.createStatement();

        // execute the query, and get a java resultset
        ResultSet rs = st.executeQuery(query3);

        // iterate through the java resultset
        cihazlar.removeAll(cihazlar);
        while (rs.next()) {
            int id = rs.getInt("id");
            String cihaz_name = rs.getString("cihaz_name");
            int kutup_mesafesi = rs.getInt("kutup_mesafesi");

            String mp_ortam = rs.getString("mp_ortam");
            String magnet_teknik = rs.getString("magnet_teknik");
            String uv = rs.getString("uv");
            String light_mesafesi = rs.getString("light_mesafesi");


            // print the results
            cihazlar.add(new Equipment(id, kutup_mesafesi, cihaz_name, mp_ortam, magnet_teknik, uv, light_mesafesi));


        }

        st.close();
        conn.close();
        return cihazlar;


    }

    public ObservableList<User> getUser() throws Exception {
        ObservableList<User> people = FXCollections.observableArrayList();
        try {
            String myUrl = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
            Connection conn = DriverManager.getConnection(myUrl, "root", "root");
            String query3 = "SELECT id,first_name,last_name,is_Admin FROM users";

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query3);

            // iterate through the java resultset
            people.removeAll(people);
            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");

                int isAdmin = rs.getInt("is_Admin");


                // print the results
                people.add(new User(id, firstName, lastName, isAdmin));

            }

            st.close();
            conn.close();


        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
        return people;


    }

    public void setPersonelBilgileriDegerlendirenFromCombobox() {
        try {
            char SelectedId, SelectedId2;
            String a = (String) RaporDegerlendirenCombobox.getValue();
            SelectedId = a.charAt(0);
            SelectedId2 = a.charAt(1);
            System.out.println(SelectedId);
            String myUrl = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
            Connection conn = DriverManager.getConnection(myUrl, "root", "root");
            String query = "SELECT first_name,last_name,is_admin FROM users where id=" + SelectedId + SelectedId2;
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                RaporDegerlendirenName.setText(rs.getString("first_name") + " " + rs.getString("last_name"));
                RaporDegerlendirenSeviye.setText(rs.getString("is_admin"));


            }

            st.close();
            conn.close();
        } catch (Exception a) {

        }
    }

    public void setPersonelBilgileriOnayFromCombobox() {
        try {
            char SelectedId, SelectedId2;
            String a = (String) RaporOnayCombobox.getValue();
            SelectedId = a.charAt(0);
            SelectedId2 = a.charAt(1);
            System.out.println(SelectedId);
            String myUrl = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
            Connection conn = DriverManager.getConnection(myUrl, "root", "root");
            String query = "SELECT first_name,last_name,is_admin FROM users where id=" + SelectedId + SelectedId2;
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                RaporOnayName.setText(rs.getString("first_name") + " " + rs.getString("last_name"));
                RaporOnaySeviye.setText(rs.getString("is_admin"));


            }

            st.close();
            conn.close();
        } catch (Exception a) {

        }
    }

    public void setPersonelBilgileriOperatorFromCombobox() {
        try {
            char SelectedId, SelectedId2;
            String a = (String) RaporOperatorCombobox.getValue();
            SelectedId = a.charAt(0);
            SelectedId2 = a.charAt(1);
            System.out.println(SelectedId);
            String myUrl = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
            Connection conn = DriverManager.getConnection(myUrl, "root", "root");
            String query = "SELECT first_name,last_name,is_admin FROM users where id=" + SelectedId + SelectedId2;
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                RaporOperatorName.setText(rs.getString("first_name") + " " + rs.getString("last_name"));
                RaporOperatorSeviye.setText(rs.getString("is_admin"));


            }

            st.close();
            conn.close();
        } catch (Exception a) {

        }
    }

    public void setEkipmanBilgileriFromCombobox() {
        try {
            char SelectedId, SelectedId2;
            String a = (String) RaporEkipman.getValue();
            SelectedId = a.charAt(0);
            SelectedId2 = a.charAt(1);
            System.out.println(SelectedId);
            String myUrl = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
            Connection conn = DriverManager.getConnection(myUrl, "root", "root");
            String query = "SELECT * FROM cihazlar where id=" + SelectedId + SelectedId2;
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                RaporKutupMesafesi.setText(rs.getString("kutup_mesafesi"));
                RaporCihaz.setText(rs.getString("cihaz_name"));
                RaporMPTasiyici.setText(rs.getString("mp_ortam"));
                RaporMiknatisTek.setText(rs.getString("magnet_teknik"));
                RaporUVIsik.setText(rs.getString("uv"));
                RaporIsikMesafe.setText(rs.getString("light_mesafesi"));


            }

            st.close();
            conn.close();

        } catch (Exception a) {
        }
    }

    public void setPersonelBilgileri() {
        try {
            String myUrl = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
            Connection conn = DriverManager.getConnection(myUrl, "root", "root");
            String query = "SELECT * FROM users";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            ObservableList<String> a = FXCollections.observableArrayList();
            while (rs.next()) {
                String cihazName = rs.getInt("id") + " - " + rs.getString("first_name") + " " + rs.getString("last_name");


                a.add(cihazName);

            }
            RaporOnayCombobox.setItems(a);
            RaporOperatorCombobox.setItems(a);
            RaporDegerlendirenCombobox.setItems(a);

        } catch (Exception e) {
        }
    }

    public void setEkipmanBilgileri() {
        try {
            String myUrl = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
            Connection conn = DriverManager.getConnection(myUrl, "root", "root");
            String query = "SELECT * FROM cihazlar";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            ObservableList<String> a = FXCollections.observableArrayList();
            RaporMuayneBolg.setText("KAYNAK+HAZ");
            RaporLuxmetre.setText("1266 Lux");
            RaporAlanSiddeti.setText("3.2 kA/m");
            RaporYuzey.setText("TAŞLANMIŞ / GRINDING");
            RaporIsikCihazTanim.setText("***");
            RaporStandartSapma.setText("Standarttan sapma yoktur.");

            while (rs.next()) {


                String cihazName = rs.getInt("id") + " - " + rs.getString("cihaz_name");


                System.out.println(cihazName);
                a.add(cihazName);


            }

            RaporEkipman.setItems(a);
            RaporAkimTipi.setItems(FXCollections.observableArrayList("AC", "DC"));
            st.close();
            conn.close();
        } catch (Exception a) {
        }
    }//a

    public void setGenelbilgilerfromcombobox() {
        try {
            char SelectedId, SelectedId2;
            String a = (String) RaporCustomerName.getValue();
            SelectedId = a.charAt(0);
            SelectedId2 = a.charAt(1);
            System.out.println(SelectedId);
            String myUrl = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
            Connection conn = DriverManager.getConnection(myUrl, "root", "root");
            String query = "SELECT * FROM firmalar where id=" + SelectedId + SelectedId2;
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                TempName = rs.getString("firma_name"); //excel basarken proje adı için
                RaporTestYeri.setText(rs.getString("firma_Ilce") + " " + rs.getString("firma_Il"));
                RaporIsEmriNo.setText(rs.getString("firma_JobOrderNo"));
                RaporTeklifNo.setText(rs.getString("firma_OfferNo"));

            }

            st.close();
            conn.close();
        } catch (Exception a) {

        }

    }

    //set choicebox
    public void setGenelbilgiler() {
        try {
            String myUrl = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
            Connection conn = DriverManager.getConnection(myUrl, "root", "root");
            String query = "SELECT id, firma_name FROM firmalar";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            ObservableList<String> a = FXCollections.observableArrayList();
            RaporMuayneStand.setText("TS EN ISO 17638");
            RaporDegerlenStand.setText("TS EN ISO 23278 Class B");
            RaporMuaynePros.setText("P-161-664");
            RaporMuayneKapsam.setText("100");
            RaporResimNo.setText("-");
            RaporSayfaNo.setText("1");

            while (rs.next()) {


                String firmaName = rs.getInt("id") + " - " + rs.getString("firma_name");


                System.out.println(firmaName);
                a.add(firmaName);


            }

            RaporCustomerName.setItems(a);
            st.close();
            conn.close();

        } catch (Exception e) {

        }
    }

    // select user from table
    public void selectUser() {
        try {


            User SelectedUser = tableView.getSelectionModel().getSelectedItem();
            String myUrl = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
            Connection conn = DriverManager.getConnection(myUrl, "root", "root");
            String query3 = "SELECT * FROM users WHERE id=" + SelectedUser.getID();
            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query3);

            // iterate through the java resultset
            while (rs.next()) {
                int id = rs.getInt("id");

                IdUpdateTextField.setText("" + id);
                DeletIDTextField.setText("" + id);
                String firstName = rs.getString("first_name");
                UpdateNameTextField.setText(firstName);

                String lastName = rs.getString("last_name");
                UpdateSurnameTextField.setText(lastName);

                int isAdmin = rs.getInt("is_Admin");
                UpdateLevelChoiceBox.setValue(isAdmin);
                String password = rs.getString("password");
                UpdatePasswordField.setText(password);

            }
            st.close();
            conn.close();
        } catch (Exception e) {

        }


    }

    public void selectCihaz() throws Exception {
        try {
            Equipment SelectedEquipment = tableViewCihaz.getSelectionModel().getSelectedItem();
            String myUrl = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
            Connection conn = DriverManager.getConnection(myUrl, "root", "root");
            String query3 = "SELECT * FROM cihazlar WHERE id=" + SelectedEquipment.getCihaz_ID();
            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query3);
            while (rs.next()) {
                int id = rs.getInt("id");

                UpdateCihazIDTextField.setText("" + id);
                DeleteCihazIDTextField.setText("" + id);
                String firmaName = rs.getString("cihaz_name");
                UpdateCihazAdiTextField.setText(firmaName);

                int kutup_mesafesi = rs.getInt("kutup_mesafesi");
                UpdateKutupMesafesiTextField.setText("" + kutup_mesafesi);
                String mp_ortam = rs.getString("mp_ortam");
                UpdateMPTasiyiciOrtamTextField.setText(mp_ortam);


                String magnet_teknik = rs.getString("magnet_teknik");
                UpdateMiknatislamaTeknikTextField.setText(magnet_teknik);
                String uv = rs.getString("uv");
                UpdateUVTextField.setText(uv);


                String light_mesafesi = rs.getString("light_mesafesi");
                UpdateIsikMesafesiTextField.setText(light_mesafesi);

            }
            st.close();
            conn.close();
        } catch (Exception e) {
        }
    }

    public void selectFirma() throws Exception {
        try {
            Firma SelectedFirma = tableViewFirma.getSelectionModel().getSelectedItem();
            String myUrl = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
            Connection conn = DriverManager.getConnection(myUrl, "root", "root");
            String query3 = "SELECT * FROM firmalar WHERE id=" + SelectedFirma.getFirma_ID();
            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query3);

            // iterate through the java resultset
            while (rs.next()) {
                int id = rs.getInt("id");


                DeletFirmaIdTextField.setText("" + id);
                String firmaName = rs.getString("firma_name");
                FirmaAdiUpdateTextField.setText(firmaName);

                String lastName = rs.getString("firma_Il");
                IlUpdateTextField.setText(lastName);

                String firma_Ilce = rs.getString("firma_Ilce");
                IlceUpdateTextField.setText(firma_Ilce);
                String firma_joborderno = rs.getString("firma_JobOrderNo");
                JobOrderNoUpdateTextField.setText(firma_joborderno);

                String firma_OfferNo = rs.getString("firma_OfferNo");
                TeklifNoUpdateTextField.setText(firma_OfferNo);

            }
            st.close();
            conn.close();
        } catch (Exception e) {

        }
    }

    //Update Equipment
    public void updateCihazButtonPushed() throws Exception {
        String myUrl = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
        Connection conn = DriverManager.getConnection(myUrl, "root", "root");

        ;

        int i = Integer.parseInt(UpdateCihazIDTextField.getText());
        int b = Integer.parseInt(UpdateKutupMesafesiTextField.getText());

        Equipment newCihaz = new Equipment(i, b, UpdateCihazAdiTextField.getText(), UpdateMPTasiyiciOrtamTextField.getText(), UpdateMiknatislamaTeknikTextField.getText(), UpdateUVTextField.getText(), UpdateIsikMesafesiTextField.getText());

        DB.UpdateCihaz(newCihaz, conn);

        conn.close();
        refreshCihazTableview();
    }

    //Update User
    public void updateUserButtonPushed() throws Exception {
        System.out.println("Çalışıom");
        String myUrl = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
        Connection conn = DriverManager.getConnection(myUrl, "root", "root");

        int i = Integer.parseInt((String) UpdateLevelChoiceBox.getValue());


        int b = Integer.parseInt(IdUpdateTextField.getText());

        User newUser = new User(b, UpdateNameTextField.getText(), UpdateSurnameTextField.getText(), i, UpdatePasswordField.getText());

        DB.UpdateUser(newUser, conn);

        conn.close();
        refreshTableview();

    }

    //Update Firma
    public void updateFirmaButtonPushed() throws Exception {
        String myUrl = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
        Connection conn = DriverManager.getConnection(myUrl, "root", "root");
        int b = Integer.parseInt(DeletFirmaIdTextField.getText());


        Firma newFirma = new Firma(FirmaAdiUpdateTextField.getText(), IlUpdateTextField.getText(), IlceUpdateTextField.getText(), JobOrderNoUpdateTextField.getText(), TeklifNoUpdateTextField.getText(), b);

        DB.UpdateFirma(newFirma, conn);

        conn.close();
        refreshFirmaTableview();
    }

    public void newMuayneButtonPushed() throws Exception {
        String myUrl = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
        Connection conn = DriverManager.getConnection(myUrl, "root", "root");
        MuayneTable a = new MuayneTable(Integer.parseInt(RaporSiraNo.getText()), RaporKaynakParcaNo.getText(), RaporKontrolUzn.getText(), RaporKaynakYon.getText(), RaporKalin.getText(), RaporCap.getText(), RaporHataTipi.getText(), RaporHataYeri.getText(), RaporSonuc.getValue());
        DB.AddMuayne(a, conn);
        conn.close();
        tableViewMuayne.setItems(getMuayneTable());

    }
    // Add New user

    public void newUserButtonPushed() throws Exception {
        String myUrl = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
        Connection conn = DriverManager.getConnection(myUrl, "root", "root");
        int i = Integer.parseInt((String) LevelChoiceBox.getValue());
        User newUser = new User(0, NameTextField.getText(), SurnameTextField.getText(), i, PasswordTextField.getText());
        DB.AddUser(newUser, conn);
        getUser();

        conn.close();
        refreshTableview();

    }

    public void newCihazButtonPushed() throws Exception {
        String myUrl = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
        Connection conn = DriverManager.getConnection(myUrl, "root", "root");
        int b = Integer.parseInt(KutupMesafesiTextField.getText());
        Equipment newCihaz = new Equipment(0, b, CihazAdiTextField.getText(), MPTasiyiciOrtamTextField.getText(), MiknatislamaTeknikTextField.getText(), UVTextField.getText(), IsikMesafesiTextField.getText());
        DB.AddCihaz(newCihaz, conn);


        conn.close();
        refreshCihazTableview();
    }

    public void newFirmaButtonPushed() throws Exception {
        String myUrl = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
        Connection conn = DriverManager.getConnection(myUrl, "root", "root");


        Firma newFirma = new Firma(FirmaAdiTextField.getText(), IlTextField.getText(), IlceTextField.getText(), JobOrderNoTextField.getText(), TeklifNoTextField.getText(), 0);
        System.out.println("NEW firma actim");
        DB.AddFirma(newFirma, conn);
        System.out.println("Db ye ekledim");


        conn.close();
        refreshFirmaTableview();
    }


    //table config


    //Kullanıcı ayarları için sahne değiştirme
    public void changeScreenButtonPushed(ActionEvent event) throws Exception {
        SceneName = 1;
        Parent UserSettingsParent = FXMLLoader.load(getClass().getResource("usersettings.fxml"));

        Scene UserSettingsScene = new Scene(UserSettingsParent, 1000, 500);

        //Sahne ayarları
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(UserSettingsScene);
        window.show();
        System.out.println(SceneName);


    }

    public void changeScreenToFirmaButtonPushed(ActionEvent event) throws Exception {

        SceneName = 2;
        Parent UserSettingsParent = FXMLLoader.load(getClass().getResource("FirmaSettings.fxml"));
        Scene UserSettingsScene = new Scene(UserSettingsParent, 1000, 500);

        //Sahne ayarları
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(UserSettingsScene);

        window.show();

        System.out.println(SceneName);


    }

    public void changeScreenToCihazButtonPushed(ActionEvent event) throws Exception {
        SceneName = 3;
        Parent UserSettingsParent = FXMLLoader.load(getClass().getResource("CihazSettings.fxml"));
        Scene UserSettingsScene2 = new Scene(UserSettingsParent, 1000, 500);

        //Sahne ayarları
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(UserSettingsScene2);


        window.show();
    }

    public void changeScreenToMainMenu(ActionEvent event) throws Exception {
        SceneName = 0;
        Parent UserSettingsParent = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene UserSettingsScene = new Scene(UserSettingsParent);

        //Sahne ayarları
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(UserSettingsScene);
        window.show();
    }

    public void changeScreenToRapor(ActionEvent event) throws Exception {
        SceneName = 4;
        Parent UserSettingsParent = FXMLLoader.load(getClass().getResource("Raporpartone.fxml"));
        Scene UserSettingsScene = new Scene(UserSettingsParent);

        //Sahne ayarları
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(UserSettingsScene);
        window.show();
    }

    //Delete User by ID
    public void DeletUserButtonPushed() throws Exception {
        String myUrl = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
        Connection conn = DriverManager.getConnection(myUrl, "root", "root");
        String query = "delete from users where id = ?";
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        int i = Integer.parseInt(DeletIDTextField.getText());
        preparedStmt.setInt(1, i);
        preparedStmt.execute();


        conn.close();
        refreshTableview();

    }

    public void DeleteMuayneButtonPushed() throws Exception {
        String myUrl = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
        Connection conn = DriverManager.getConnection(myUrl, "root", "root");
        String query = "delete from muayne where SiraNo = ?";
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        int i = Integer.parseInt(RaporSiraNo.getText());
        preparedStmt.setInt(1, i);
        preparedStmt.execute();
        tableViewMuayne.setItems(getMuayneTable());
    }
    public void DeleteFirstMuayne(int i) throws Exception {
        String myUrl = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
        Connection conn = DriverManager.getConnection(myUrl, "root", "root");
        String query = "delete from muayne where SiraNo = ?";
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        preparedStmt.setInt(1, i);
        preparedStmt.execute();
        tableViewMuayne.setItems(getMuayneTable());
    }

    public void DeleteCihazButtonPushed() throws Exception {
        String myUrl = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
        Connection conn = DriverManager.getConnection(myUrl, "root", "root");
        String query = "delete from cihazlar where id = ?";
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        int i = Integer.parseInt(DeleteCihazIDTextField.getText());
        preparedStmt.setInt(1, i);
        preparedStmt.execute();


        conn.close();
        refreshCihazTableview();
    }

    public void DeleteFirmaButtonPushed() throws Exception {
        String myUrl = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
        Connection conn = DriverManager.getConnection(myUrl, "root", "root");
        String query = "delete from firmalar where id = ?";
        PreparedStatement preparedStmt = conn.prepareStatement(query);
        int i = Integer.parseInt(DeletFirmaIdTextField.getText());
        preparedStmt.setInt(1, i);
        preparedStmt.execute();


        conn.close();
        refreshFirmaTableview();
    }

    @SuppressWarnings({"java:S106", "java:S4823", "java:S1192"})
    public void ExcelCiktisiButtonPushed() throws Exception {

        InputStream inputStream = this.getClass().getResourceAsStream("FR_02_MT.xlsx");
        XSSFWorkbook workbook = (XSSFWorkbook) WorkbookFactory.create(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Row row1 = sheet.getRow(2);//row
        Cell musteriAdi = row1.getCell(3);//column
        Cell muayeneProseduru = row1.getCell(19);//column
        Cell sayfaNo = row1.getCell(26);//column
        musteriAdi.setCellValue(TempName);
        muayeneProseduru.setCellValue(RaporMuaynePros.getText());
        sayfaNo.setCellValue(RaporSayfaNo.getText());

        Row row2 = sheet.getRow(3);//row
        Cell projeAdi = row2.getCell(3);//column
        Cell muayeneKapsami = row2.getCell(19);//column
        Cell raporNo = row2.getCell(26);//column
        projeAdi.setCellValue(RaporProjeAdi.getText());
        muayeneKapsami.setCellValue(RaporMuayneKapsam.getText()+" %");
        raporNo.setCellValue(RaporRaporNo.getText());

        Row row3 = sheet.getRow(4);//row
        Cell testYeri = row3.getCell(3);//column
        Cell resimNo = row3.getCell(19);//column
        Cell raporTarihi = row3.getCell(26);//column
        testYeri.setCellValue(RaporTestYeri.getText());
        resimNo.setCellValue(RaporResimNo.getText());
        raporTarihi.setCellValue(RaporRaporTarihi.getText());

        Row row4 = sheet.getRow(5);//row
        Cell muayeneStandart = row4.getCell(3);//column
        Cell yuzeyDurumu = row4.getCell(19);//column
        Cell isEmriNo = row4.getCell(26);//column
        muayeneStandart.setCellValue(RaporMuayneStand.getText());
        yuzeyDurumu.setCellValue(RaporYuzeyDurum.getText());
        isEmriNo.setCellValue(RaporIsEmriNo.getText());

        Row row6 = sheet.getRow(6);//row
        Cell degerlendirmeStandarti = row6.getCell(3);//column
        Cell muayeneAsamasi = row6.getCell(19);//column
        Cell teklifNo = row6.getCell(26);//column
        degerlendirmeStandarti.setCellValue(RaporDegerlenStand.getText());
        muayeneAsamasi.setCellValue(RaporMuayneAsama.getText());
        teklifNo.setCellValue(RaporTeklifNo.getText());

        Row row7 = sheet.getRow(8);//row
        Cell kutupMesafesi = row7.getCell(4);
        Cell muayeneBolgesi = row7.getCell(16);
        Cell yuzeySicakligi = row7.getCell(25);
        kutupMesafesi.setCellValue(RaporKutupMesafesi.getText());
        muayeneBolgesi.setCellValue(RaporMuayneBolg.getText());
        yuzeySicakligi.setCellValue(RaporYuzekSicaklik.getText());

        Row row9 = sheet.getRow(9);//row
        Cell cihazAdi = row9.getCell(4);
        Cell akimTipi = row9.getCell(16);
        Cell muayeneBolgesiAlan = row9.getCell(25);
        cihazAdi.setCellValue(RaporCihaz.getText());
        akimTipi.setCellValue((String) RaporAkimTipi.getValue());
        muayeneBolgesiAlan.setCellValue(RaporMuayneBolg.getText());

        Row row10 = sheet.getRow(10);//row
        Cell MPTasiyiciOrtam = row10.getCell(4);
        Cell luxMetre = row10.getCell(16);
        MPTasiyiciOrtam.setCellValue(RaporMPTasiyici.getText());
        luxMetre.setCellValue(RaporLuxmetre.getText());

        Row row11 = sheet.getRow(11);//row
        Cell miknatislamaTeknigi = row11.getCell(4);
        Cell muayeneOrtami = row11.getCell(16);
        Cell yuzey = row11.getCell(25);
        miknatislamaTeknigi.setCellValue(RaporMiknatisTek.getText());
        muayeneOrtami.setCellValue(RaporMuayneOrt.getText());
        yuzey.setCellValue(RaporYuzey.getText());

        Row row12 = sheet.getRow(12);//row
        Cell UVIsikSiddeti = row12.getCell(4);
        Cell miknatisGiderimi = row12.getCell(16);
        Cell isikCihazTanimi = row12.getCell(25);
        UVIsikSiddeti.setCellValue(RaporUVIsik.getText());
        miknatisGiderimi.setCellValue(RaporMagnetGiderim.getText());
        isikCihazTanimi.setCellValue(RaporIsikCihazTanim.getText());


        Row row13 = sheet.getRow(13);//row
        Cell isikMesafesi = row13.getCell(4);
        Cell isilIslem = row13.getCell(16);
        Cell kaldirmaTesti = row13.getCell(25);
        isikMesafesi.setCellValue(RaporIsikMesafe.getText());
        isilIslem.setCellValue(RaporIsilIslem.getText());
        kaldirmaTesti.setCellValue(RaporKaldirmaTesti.getText());

        Row row19 = sheet.getRow(19);//row
        Cell standartSapmalar = row19.getCell(7);
        standartSapmalar.setCellValue(RaporStandartSapma.getText());

        Row row20 = sheet.getRow(20);//row
        Cell muayeneTarihleri = row20.getCell(7);
        muayeneTarihleri.setCellValue(RaporMuayneTarih.getText());

        Row row21 = sheet.getRow(21);//row
        Cell aciklamalarEkler = row21.getCell(7);
        aciklamalarEkler.setCellValue(Ekler.getText());


        Row row39 = sheet.getRow(39);//row
        Cell operatorIsim = row39.getCell(5);
        Cell degerlendirenIsim = row39.getCell(15);
        Cell onayIsim = row39.getCell(20);

        operatorIsim.setCellValue(RaporOperatorName.getText());
        degerlendirenIsim.setCellValue(RaporDegerlendirenName.getText());
        onayIsim.setCellValue(RaporOnayName.getText());

        Row row40 = sheet.getRow(40);//row
        Cell operatorSeviye = row40.getCell(5);
        Cell degerlendirenSeviye = row40.getCell(15);
        Cell onaySeviye = row40.getCell(20);
        operatorSeviye.setCellValue(RaporOperatorSeviye.getText());
        degerlendirenSeviye.setCellValue(RaporDegerlendirenSeviye.getText());
        onaySeviye.setCellValue(RaporOnaySeviye.getText());

        int i = 1;
        while (!getMuayneTable().isEmpty() && i <= 14) {
            Row rowTable = sheet.getRow(i + 23);
            Cell sira = rowTable.getCell(0);
            Cell kaynakParca = rowTable.getCell(1);
            Cell kontrolUzun = rowTable.getCell(8);
            Cell kaynakYon = rowTable.getCell(11);
            Cell kalinlik = rowTable.getCell(17);
            Cell cap = rowTable.getCell(18);
            Cell hataTip = rowTable.getCell(22);
            Cell hataninYeri = rowTable.getCell(24);
            Cell sonuc = rowTable.getCell(27);
            sira.setCellValue(i);
            kaynakParca.setCellValue(getMuayneTable().get(0).getKaynak());
            kontrolUzun.setCellValue(getMuayneTable().get(0).getKontrolUzn());
            kaynakYon.setCellValue(getMuayneTable().get(0).getKaynakYon());
            kalinlik.setCellValue(getMuayneTable().get(0).getKalinlik());
            cap.setCellValue(getMuayneTable().get(0).getCap());
            hataTip.setCellValue(getMuayneTable().get(0).getHataTipi());
            hataninYeri.setCellValue(getMuayneTable().get(0).getHataYeri());
            sonuc.setCellValue(getMuayneTable().get(0).getSonuc());
            DeleteFirstMuayne(i);
            i++;
        }


        Row row41 = sheet.getRow(41);//row
        Cell operatorTarih = row41.getCell(5);
        Cell degerlendirenTarih = row41.getCell(15);
        Cell onayTarih = row41.getCell(20);
        operatorTarih.setCellValue(RaporOperatorTarih.getText());
        degerlendirenTarih.setCellValue(RaporDegerlendirenTarih.getText());
        onayTarih.setCellValue(RaporOnayTarih.getText());


        String ExcelName = "C:\\Users\\Firat\\IdeaProjects\\Formprojesi\\src\\sample\\ExcelPrints\\"+RaporKayitAdi.getText()+ "xlsx";
        FileOutputStream output = new FileOutputStream(ExcelName);
        workbook.write(output);
        output.close();


    }
    public void PDFButtonPushed() throws Exception {
        try {
        //Burcu Yıldız'dan Alınmıştır
            ExcelCiktisiButtonPushed();

            String fileexcel = "C:\\Users\\Firat\\IdeaProjects\\Formprojesi\\src\\sample\\ExcelPrints\\"+RaporKayitAdi.getText()+ "xlsx";


            Workbook workbook = new Workbook(fileexcel);


            String filepdf = "C:\\Users\\Firat\\IdeaProjects\\Formprojesi\\src\\sample\\ExcelPrints\\"+RaporKayitAdi.getText()+".pdf";
            workbook.save(filepdf, SaveFormat.PDF);

        } catch (Exception e) {
            System.out.println(e);
        }
    }



}
/* ====================================================================
   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
==================================================================== */


