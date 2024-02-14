package javatask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import org.apache.derby.jdbc.ClientDriver;

public class DataAccessLayer {

    public static Users selectAll() throws SQLException {

        DriverManager.registerDriver(new ClientDriver());
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/javaTask", "root", "root");
        Users result = null;
        PreparedStatement pstmt = con.prepareStatement("select* from USERS FETCH FIRST 1 ROW ONLY");
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            result = new Users();
            result.setID(rs.getInt("userid"));
            result.setName(rs.getString("username"));
            result.setEmail(rs.getString("emailadd"));
            result.setPhone(rs.getString("contactnum"));

            String sql = "SELECT r.rolename\n"
                    + "FROM users u\n"
                    + "JOIN user_role ur ON u.userid = ur.userid\n"
                    + "JOIN role r ON ur.roleid = r.roleid\n"
                    + "WHERE u.userid = ?";
            PreparedStatement pstmt2 = con.prepareStatement(sql);
            pstmt2.setInt(1, result.getID());
            ResultSet rs2 = pstmt2.executeQuery();
            if (rs2.next()) {
                result.setRoles(rs2.getString("rolename"));

                String sql2 = "SELECT p.permissionname "
                        + "FROM users u "
                        + "JOIN user_role ur ON u.userid = ur.userid "
                        + "JOIN role_permission rp ON ur.roleid = rp.roleid "
                        + "JOIN permission p ON rp.permissionid = p.permissionid "
                        + "WHERE u.userid = ?";
                PreparedStatement ps3 = con.prepareStatement(sql2);
                ps3.setInt(1, result.getID());
                ResultSet rs3 = ps3.executeQuery();
                if (rs3.next()) {
                    result.setPermission(rs3.getString("permissionname"));
                    System.out.println(result.getPermission());
                }

            }

        }
        rs.close();
        pstmt.close();
        con.close();
        return result;

    }

    public static int addUser(Users user) throws SQLException {
        DriverManager.registerDriver(new ClientDriver());
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/javaTask", "root", "root");
        int result = 0;
        PreparedStatement pstmt = con.prepareStatement("INSERT INTO users VALUES(? , ? , ? , ? )");
        pstmt.setInt(1, user.getID());
        pstmt.setString(2, user.getName());
        pstmt.setString(3, user.getPhone());
        pstmt.setString(4, user.getEmail());

        result = pstmt.executeUpdate();

        if (result == 1) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        pstmt.close();
        con.close();
        return result;

    }

    public static int editUser(Users contact) throws SQLException {
        DriverManager.registerDriver(new ClientDriver());
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/javaTask", "root", "root");
        int result = 0;
        PreparedStatement pstmt = con.prepareStatement("update users set username=? ,  contactnum=? , emailadd=? where id=? ");

        pstmt.setString(1, contact.getName());
        pstmt.setString(2, contact.getPhone());
        pstmt.setString(3, contact.getEmail());

        pstmt.setInt(4, contact.getID());
        result = pstmt.executeUpdate();
        pstmt.close();
        con.close();
        return result;

    }

    public static Users next(Users c) throws SQLException {
        DriverManager.registerDriver(new ClientDriver());
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/javaTask", "root", "root");
        Users result = null;

        PreparedStatement pstmt = con.prepareStatement("select * from USERS ", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            if (rs.getInt("userid") == c.getID()) {
                if (rs.next()) {
                    result = new Users();
                    result.setID(rs.getInt("userid"));
                    result.setName(rs.getString("username"));
                    result.setEmail(rs.getString("emailadd"));
                    result.setPhone(rs.getString("contactnum"));

                    String sql = "SELECT r.rolename\n"
                            + "FROM users u\n"
                            + "JOIN user_role ur ON u.userid = ur.userid\n"
                            + "JOIN role r ON ur.roleid = r.roleid\n"
                            + "WHERE u.userid = ?";

                    PreparedStatement pstmt2 = con.prepareStatement(sql);
                    pstmt2.setInt(1, result.getID());
                    ResultSet rs2 = pstmt2.executeQuery();
                    System.out.println(result.getRoles() + "roleeeeee");
                    if (rs2.next()) {
                        result.setRoles(rs2.getString("rolename"));

                        String sql2 = "SELECT p.permissionname "
                                + "FROM users u "
                                + "JOIN user_role ur ON u.userid = ur.userid "
                                + "JOIN role_permission rp ON ur.roleid = rp.roleid "
                                + "JOIN permission p ON rp.permissionid = p.permissionid "
                                + "WHERE u.userid = ?";
                        PreparedStatement ps3 = con.prepareStatement(sql2);
                        ps3.setInt(1, result.getID());
                        ResultSet rs3 = ps3.executeQuery();
                        if (rs3.next()) {
                            result.setPermission(rs3.getString("permissionname"));
                            System.out.println(result.getPermission() + "permissssssssssssion");
                        }

                    }

                } else {
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setTitle("Error");
                    a.setContentText("no next data to show");
                    a.show();
                }
                break;
            }
        }
        rs.close();
        pstmt.close();
        con.close();

        return result;

    }

    public static Users previous(Users c) throws SQLException {
        DriverManager.registerDriver(new ClientDriver());
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/javaTask", "root", "root");
        Users result = null;

        PreparedStatement pstmt = con.prepareStatement("select * from USERS ", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            if (rs.getInt("userid") == c.getID()) {
                if (rs.previous()) {
                    result = new Users();
                    result.setID(rs.getInt("userid"));
                    result.setName(rs.getString("username"));
                    result.setEmail(rs.getString("emailadd"));
                    result.setPhone(rs.getString("contactnum"));

                    String sql = "SELECT r.rolename\n"
                            + "FROM users u\n"
                            + "JOIN user_role ur ON u.userid = ur.userid\n"
                            + "JOIN role r ON ur.roleid = r.roleid\n"
                            + "WHERE u.userid = ?";

                    PreparedStatement pstmt2 = con.prepareStatement(sql);
                    pstmt2.setInt(1, result.getID());
                    ResultSet rs2 = pstmt2.executeQuery();
                    System.out.println(result.getRoles() + "roleeeeee");
                    if (rs2.next()) {
                        result.setRoles(rs2.getString("rolename"));

                        String sql2 = "SELECT p.permissionname "
                                + "FROM users u "
                                + "JOIN user_role ur ON u.userid = ur.userid "
                                + "JOIN role_permission rp ON ur.roleid = rp.roleid "
                                + "JOIN permission p ON rp.permissionid = p.permissionid "
                                + "WHERE u.userid = ?";
                        PreparedStatement ps3 = con.prepareStatement(sql2);
                        ps3.setInt(1, result.getID());
                        ResultSet rs3 = ps3.executeQuery();
                        if (rs3.next()) {
                            result.setPermission(rs3.getString("permissionname"));
                            System.out.println(result.getPermission() + "permissssssssssssion");
                        }

                    }

                } else {
                    Alert a = new Alert(Alert.AlertType.ERROR);
                    a.setTitle("Error");
                    a.setContentText("no previous data to show");
                    a.show();
                }
                break;
            }
        }
        rs.close();
        pstmt.close();
        con.close();

        return result;

    }

    public static int delete(int id) throws SQLException {
        int temp = id;
        Users obj = new Users();
        obj.setID(temp);
        next(obj);
        DriverManager.registerDriver(new ClientDriver());
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/javaTask", "root", "root");
        PreparedStatement pstmt = con.prepareStatement("DELETE FROM USERS WHERE userid = ?");
        pstmt.setInt(1, temp);
        int result = pstmt.executeUpdate();
        System.out.println(result);
        pstmt.close();
        con.close();

        return result;

    }

    public static int addRole(Role role) throws SQLException {
        DriverManager.registerDriver(new ClientDriver());
        int result = 0;
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/javaTask", "root", "root");
        PreparedStatement pstmt = con.prepareStatement("INSERT INTO role VALUES(? , ? )");
        pstmt.setInt(1, role.getID());
        pstmt.setString(2, role.getName());

        result = pstmt.executeUpdate();

        if (result == 1) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        pstmt.close();
        con.close();
        return result;
    }
       public static int addPermission(Permission permission) throws SQLException {
        DriverManager.registerDriver(new ClientDriver());
        int result = 0;
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/javaTask", "root", "root");
        PreparedStatement pstmt = con.prepareStatement("INSERT INTO permission VALUES(? , ? ,? )");
        pstmt.setInt(1, permission.getID());
        pstmt.setString(2, permission.getName());
        pstmt.setString(3, permission.getDescription());

        result = pstmt.executeUpdate();

        if (result == 1) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        pstmt.close();
        con.close();
        return result;
    }

}
