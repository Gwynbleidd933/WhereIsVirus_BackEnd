package acn.poc.wiv.beans;

import java.io.Serializable;

public class UserLoginRequest implements Serializable {

    private String email;

    private String password;

    public UserLoginRequest(){}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
