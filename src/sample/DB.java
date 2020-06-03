package sample;

import com.mysql.cj.util.DnsSrv;

import java.sql.*;

public class DB {
    public static void AddCihaz(Equipment a,Connection conn){
        try{
            String query2="insert into cihazlar(cihaz_name,kutup_mesafesi,mp_ortam,magnet_teknik,uv,light_mesafesi)"
                    + "values (?,?,?,?,?,?)";
            PreparedStatement preparedStmt2 = conn.prepareStatement(query2);

            preparedStmt2.setString(1, a.getCihaz());

            preparedStmt2.setInt(2, a.getKutupMesafesi());


            preparedStmt2.setString(3, a.getMpOrtam());

            preparedStmt2.setString(4, a.getMagnetTeknik());

            preparedStmt2.setString(5, a.getUV());
            preparedStmt2.setString(6, a.getLightMesafesi());




            preparedStmt2.execute();
        }
        catch (Exception e){}
    }

    public static void UpdateCihaz(Equipment a,Connection conn)throws Exception{
        String query2="update cihazlar set cihaz_name=?,kutup_mesafesi=?,mp_ortam=?,magnet_teknik=?,uv=?,light_mesafesi=? where id=?";
        PreparedStatement preparedStmt2 = conn.prepareStatement(query2);

        preparedStmt2.setString(1, a.getCihaz());

        preparedStmt2.setInt(2, a.getKutupMesafesi());


        preparedStmt2.setString(3, a.getMpOrtam());

        preparedStmt2.setString(4, a.getMagnetTeknik());

        preparedStmt2.setString(5, a.getUV());
        preparedStmt2.setString(6, a.getLightMesafesi());
        preparedStmt2.setInt(7,a.getCihaz_ID());




        preparedStmt2.execute();
    }
    public static void AddFirma(Firma a, Connection conn) {
        try {
            String query2 = " insert into firmalar (firma_name, firma_Il, firma_Ilce,firma_OfferNo,firma_JobOrderNo)"
                    + " values (?, ?, ?, ?, ?)";

            PreparedStatement preparedStmt2 = conn.prepareStatement(query2);

            preparedStmt2.setString(1, a.getFirma_Name());

            preparedStmt2.setString(2, a.getIl());


            preparedStmt2.setString(3, a.getIlce());

            preparedStmt2.setString(4, a.getOffer_No());

            preparedStmt2.setString(5, a.getJobOrder_No());


            preparedStmt2.execute();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }

    public static void UpdateFirma(Firma a, Connection conn) {
        try {
            String query2 = " update firmalar set firma_name=?, firma_Il=?, firma_Ilce=?,firma_OfferNo=?,firma_JobOrderNo=? where id=?";



        PreparedStatement preparedStmt2 = conn.prepareStatement(query2);

        preparedStmt2.setString(1, a.getFirma_Name());

        preparedStmt2.setString(2, a.getIl());


        preparedStmt2.setString(3, a.getIlce());

        preparedStmt2.setString(4, a.getOffer_No());

        preparedStmt2.setString(5, a.getJobOrder_No());
        preparedStmt2.setInt(6,a.getFirma_ID());


        preparedStmt2.execute();}
        catch (Exception e){
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }

    public static void AddUser(User a, Connection conn) {
        try {
            String query2 = " insert into users (first_name, last_name, is_admin,password)"
                    + " values (?, ?, ?, ?)";

            PreparedStatement preparedStmt2 = conn.prepareStatement(query2);
            preparedStmt2.setString(1, a.getName());
            preparedStmt2.setString(2, a.getSurname());

            preparedStmt2.setInt(3, a.getLevel());
            preparedStmt2.setString(4, a.getPassword());
            preparedStmt2.execute();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }

    public static void UpdateUser(User a, Connection conn) {
        try {
            System.out.println("Açıldım");
            String query2 = " update users set first_name= ?, last_name=?, is_admin= ?, password=? where id= ?";
            PreparedStatement preparedStmt2 = conn.prepareStatement(query2);
            preparedStmt2.setString(1, a.getName());
            preparedStmt2.setString(2, a.getSurname());

            preparedStmt2.setInt(3, a.getLevel());
            preparedStmt2.setString(4, a.getPassword());
            preparedStmt2.setInt(5, a.getID());

            preparedStmt2.execute();
            System.out.println("EXECUTELADIM");
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }


    /*public static void ShowUsers() {
        try {
            String myUrl = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey";
            Connection conn = DriverManager.getConnection(myUrl, "root", "root");
            String query3 = "SELECT * FROM users";

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query3);

            // iterate through the java resultset
            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");

                int isAdmin = rs.getInt("is_Admin");


                // print the results
                System.out.format("%s, %s, %s, %s, \n", id, firstName, lastName, isAdmin);

            }

            st.close();
            conn.close();



        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());

        }



    }
    */
}
