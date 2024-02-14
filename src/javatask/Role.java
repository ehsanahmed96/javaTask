package javatask;

import java.util.List;

public class Role {

    private int ID;
    private String name;
    private String permissions;

    public Role(int ID, String name , String permissions) {
        this.ID = ID;
        this.name = name;
        this.permissions = permissions;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public Role() {

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
