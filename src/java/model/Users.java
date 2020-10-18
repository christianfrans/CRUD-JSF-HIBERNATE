package model;
// Generated Oct 18, 2020 5:08:44 PM by Hibernate Tools 4.3.1

import controller.userController;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 * Users generated by hbm2java
 */
@ManagedBean
public class Users implements java.io.Serializable {

    private Integer id;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String phone;
    private String username;
    private String password;

    public Users() {
    }

    public Users(String firstName, String lastName, String address, String email, String phone, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void delete() {
        userController controller = new userController();
        controller.deleteUsers(id);
    }
    
    public void save() {
        userController controller = new userController();
        controller.register(this);
    }

    public List<Users> readUsers() {
        userController controller = new userController();
        List<Users> readusers = controller.readUsers();
        return readusers;
    }

    public List<Users> getByUsername() {
        userController controller = new userController();
        List<Users> searchUsername = controller.getByUsername(username); //Class yang ada di DAO/CONTROLLER
        id = searchUsername.get(0).id;
        firstName = searchUsername.get(0).firstName;
        lastName = searchUsername.get(0).lastName;
        address = searchUsername.get(0).address;
        email = searchUsername.get(0).email;
        phone = searchUsername.get(0).phone;
        return searchUsername;
    }

    public void update() {
        userController controller = new userController();
        controller.updateUsers(this);
    }
    
    public List<Users> getbyid() {
        userController controller = new userController();
        List<Users> users = controller.getbyID(id);
        firstName = users.get(0).firstName;
        lastName = users.get(0).lastName;
        address = users.get(0).address;
        email = users.get(0).email;
        phone = users.get(0).phone;
        username = users.get(0).username;
        password = users.get(0).password;
        return users;
    }

}