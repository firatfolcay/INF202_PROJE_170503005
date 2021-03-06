//--------------------------
//Fırat Fuat Olcay 170503005
//--------------------------
package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class User {
    private SimpleStringProperty Name, Surname, Password;
    private SimpleIntegerProperty Level, ID;

    /*
        public User(int ID, int Level) {//for instant user creation
            this.ID = new SimpleIntegerProperty(ID);
            this.Level = new SimpleIntegerProperty(Level);
        }
    */
    public User(int ID, String Name, String Surname, int Level) {//for complex user creation
        this.ID = new SimpleIntegerProperty(ID);
        this.Name = new SimpleStringProperty(Name);
        this.Surname = new SimpleStringProperty(Surname);
        this.Level = new SimpleIntegerProperty(Level);

    }

    public User(int ID, String Name, String Surname, int Level, String Password) {//for complex user creation
        this.ID = new SimpleIntegerProperty(ID);
        this.Name = new SimpleStringProperty(Name);
        this.Surname = new SimpleStringProperty(Surname);
        this.Level = new SimpleIntegerProperty(Level);
        this.Password = new SimpleStringProperty(Password);
    }

    public int getID() {
        return ID.get();
    }

    public String getName() {
        return Name.get();
    }

    public int getLevel() {
        return Level.get();
    }

    public String getSurname() {
        return Surname.get();
    }

    public String getPassword() {
        return Password.get();
    }
}
