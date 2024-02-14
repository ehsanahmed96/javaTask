package javatask;

import java.util.List;

public class Users {

    private int ID;
    private String Name;
    private String Email;
    private String Phone;
    private String roles;
     private String permission;

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public Users(int ID, String Name, String Email, String Phone, String roles , String permission) {
        this.ID = ID;
        this.Name = Name;
        this.Email = Email;
        this.Phone = Phone;
        this.roles = roles;
        this.permission = permission;
    }

    public Users() {

    }

}
