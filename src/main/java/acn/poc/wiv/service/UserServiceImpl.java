package acn.poc.wiv.service;

import acn.poc.wiv.beans.GetAllUsersResponse;
import acn.poc.wiv.beans.RegisterUserRequest;
import acn.poc.wiv.beans.UserLoginRequest;
import acn.poc.wiv.beans.UserLoginResponse;
import acn.poc.wiv.dao.RoleRepository;
import acn.poc.wiv.dao.UserRepository;
import acn.poc.wiv.entity.Role;
import acn.poc.wiv.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import acn.poc.wiv.utils.Constants;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private RoleRepository roleRepository;
	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	private Environment env;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, Environment env, RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.env = env;
		this.roleRepository = roleRepository;
	}

	@Override
	public GetAllUsersResponse findAll() {
		return new GetAllUsersResponse(userRepository.findAll());
	}

	@Override
	public Optional<User> findById(int id) {
		return userRepository.findById(id);
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
	}

	@Override
	public void deleteById(int id) {
		userRepository.deleteById(id);
	}

	@Override
	public void register(RegisterUserRequest request) throws Exception {
		logger.info("START register");

		List<User> res = userRepository.findByEmail(request.getEmail());

		if (res.size() > 0){
			throw new Exception("User already exists");
		}

		Role registeredUserRole = roleRepository.findByName(Constants.REGISTERED_USER_ROLE_NAME).get(0);

		User registrationUser = new User();
		//TODO handle nulls in request
		registrationUser.setNickName(request.getNickName());
		registrationUser.setFullName(request.getFullName());
		registrationUser.setPassword(request.getPassword());
		registrationUser.setEmail(request.getEmail());
		registrationUser.addRole(registeredUserRole);

		userRepository.save(registrationUser);

		logger.info("END register");
	}


	@Override
	public UserLoginResponse login(UserLoginRequest request) {
		logger.info("START login");

		List<User> res = userRepository.findByEmail(request.getEmail());

		UserLoginResponse response = new UserLoginResponse();
		response.setEmail(request.getEmail());

		if (res.size() > 0 && res.get(0).getPassword().equals(request.getPassword())){

			response.setAuthenticated(true);
			/** role array should never be empty */
			response.setRole(res.get(0).getRoles().get(0).getName());


		} else {
			response.setAuthenticated(false);
			response.setDescription("Invalid email or password");
		}

		logger.info("END login");
		return response;
	}
}






