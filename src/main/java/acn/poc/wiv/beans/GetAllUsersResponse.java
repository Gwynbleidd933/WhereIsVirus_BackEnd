package acn.poc.wiv.beans;

import acn.poc.wiv.entity.User;

import java.io.Serializable;
import java.util.List;

public class GetAllUsersResponse implements Serializable {

    private List<User> allUsers;

    public GetAllUsersResponse (){}

    public GetAllUsersResponse(List<User> allUsers) {
        this.allUsers = allUsers;
    }

    public List<User> getAllUsers() {
        return allUsers;
    }

    public void setAllUsers(List<User> allUsers) {
        this.allUsers = allUsers;
    }
}
