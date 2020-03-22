package acn.poc.wiv.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
//@JsonIgnoreProperties({"createdEvents", "confirmedEvents"})
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;

	@Column(name="full_name")
	private String fullName;

	@Column(name="nick_name")
	private String nickName;

	@Column(name="email")
	@Pattern(regexp = "^[a-zA-Z0-9.-]+@[a-zA-Z0-9.]+$")
	private String email;

	@Column(name="password")
	private String password;

	@ManyToMany(cascade = {
			CascadeType.PERSIST,
			CascadeType.MERGE,
			CascadeType.DETACH,
			CascadeType.REFRESH
	})
	@JoinTable(
			name="user_role",
			joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="ID")},
			inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ID")})
	private List<Role> roles = new ArrayList<>();

//	@OneToMany(targetEntity = Event.class,
//			mappedBy = "creator"
//	)
	@OneToMany
	@JoinColumn(name = "user_id")
	private List<Event> createdEvents = new ArrayList<>();


	@ManyToMany(cascade = {
			CascadeType.PERSIST,
			CascadeType.MERGE,
			CascadeType.DETACH,
			CascadeType.REFRESH
	})
	@JoinTable(name="event_confirming_users", joinColumns=@JoinColumn(name="user_id"), inverseJoinColumns=@JoinColumn(name="event_id"))
	private List<Event> confirmedEvents = new ArrayList<>();

	public User() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void addRole(Role role) {
		//prevent endless loop
		if (roles.contains(role))
			return ;
		//add new role
		roles.add(role);
		//set myself into the role
		role.addUser(this);
	}

	public void removeRole(Role role) {
		//prevent endless loop
		if (!roles.contains(role))
			return ;
		//remove the role
		roles.remove(role);
		//remove myself from the role
		role.removeUser(this);
	}

	public List<Event> getCreatedEvents() {
		//defensive copy, nobody will be able to change the
		//list from the outside
		return new ArrayList<>(createdEvents);
	}

	public void addCreatedEvent(Event newEvent) {
		//prevent endless loop
		if (createdEvents.contains(newEvent))
			return ;
		//add new event
		createdEvents.add(newEvent);

		/**Unidirectional association*/
		//	set myself into the event
		//	newEvent.setCreator(this);
	}

	public void removeCreatedEvent(Event event) {
		//prevent endless loop
		if (!createdEvents.contains(event))
			return ;
		//remove the event
		createdEvents.remove(event);

		/**Unidirectional association*/
		//remove myself from the event
		//event.setCreator(null);
	}

	public List<Event> getConfirmedEvents() {

		//defensive copy, nobody will be able to change the
		//list from the outside
		return new ArrayList<>(confirmedEvents);
	}

	public void addConfirmedEvent(Event newConfirmedEvent) {
		//prevent endless loop
		if (confirmedEvents.contains(newConfirmedEvent))
			return ;
		//add new newConfirmedEvent
		confirmedEvents.add(newConfirmedEvent);


		/**Unidirectional association*/
		//set myself into the newConfirmedEvent
		//newConfirmedEvent.addConfirmingUser(this);
	}

	public void removeConfirmedEvent(Event confirmedEvent) {
		//prevent endless loop
		if (!confirmedEvents.contains(confirmedEvent))
			return ;
		//remove the confirmedEvent
		confirmedEvents.remove(confirmedEvent);


		/**Unidirectional association*/
		//remove myself from the confirmedEvent
		//confirmedEvent.removeConfirmingUser(this);
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", fullName='" + fullName + '\'' +
				", nickName='" + nickName + '\'' +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}











