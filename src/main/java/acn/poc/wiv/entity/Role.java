package acn.poc.wiv.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="roles")
@JsonIgnoreProperties({"users"})
public class Role
{
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(nullable=false)
	private String name;
		
	@ManyToMany(mappedBy="roles")
	private List<User> users = new ArrayList<>();

	public Role() {}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void addUser(User user) {
		//prevent endless loop
		if (users.contains(user))
			return ;
		//add new user
		users.add(user);
		//set myself into the user
		user.addRole(this);
	}

	public void removeUser(User user) {
		//prevent endless loop
		if (!users.contains(user))
			return ;
		//remove the user
		users.remove(user);
		//remove myself from the user
		user.removeRole(this);
	}

	@Override
	public String toString() {
		return "Role{" +
				"id=" + id +
				", name='" + name + '\'' +
				", users=" + users +
				'}';
	}
}
