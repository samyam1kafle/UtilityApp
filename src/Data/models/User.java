package Data.models;

import Data.models.Constants.Constants;

/**
 * @Author : Samyam Kafle
 * @Portfolio : https://samyamkafle.com.np
 * @Project : UtilityApp
 * @CreatedDate : 19/09/2024, Thursday
 **/
public class User {

    private static int idCounter = 1;
    private int id;
    private String username;

    private String name;
    private String address;
    private String password;
    private String role;
    private String contactNumber;

    private int noOfBooksTaken;

    public User(){}
    public User(User user) {
        this.id = user.id;
        this.username = user.username;
        this.name = user.name;
        this.address = user.address;
        this.password = user.password;
        this.role = user.role;
        this.contactNumber = user.contactNumber;
        this.noOfBooksTaken = user.noOfBooksTaken;
    }

    public User(String username, String name, String address, String password, String role, String contactNumber, int noOfBooksTaken) {
        this.username = username;
        this.name = name;
        this.address = address;
        this.password = password;
        this.role = role;
        this.contactNumber = contactNumber;
        this.noOfBooksTaken = noOfBooksTaken;
        this.id = idCounter++;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public int getNoOfBooksTaken() {
        return noOfBooksTaken;
    }

    public void setNoOfBooksTaken(int noOfBooksTaken) {
        this.noOfBooksTaken = noOfBooksTaken;
    }

    @Override
    public String toString() {
        return "[%s] %s (%s)".formatted(id,username,role);
    }
}
