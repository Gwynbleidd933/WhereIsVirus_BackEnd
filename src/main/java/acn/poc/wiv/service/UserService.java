package acn.poc.wiv.service;

import acn.poc.wiv.beans.GetAllUsersResponse;
import acn.poc.wiv.beans.RegisterUserRequest;
import acn.poc.wiv.beans.UserLoginRequest;
import acn.poc.wiv.beans.UserLoginResponse;
import acn.poc.wiv.entity.User;

import java.util.Optional;

public interface UserService {

    public GetAllUsersResponse findAll();

    public Optional<User> findById(int id);

    public void save(User user);

    public void deleteById(int id);

    public void register(RegisterUserRequest request) throws Exception;

    public UserLoginResponse login(UserLoginRequest request);
}
