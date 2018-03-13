package be.rebero.ikimina.model.auth;

import be.rebero.ikimina.model.Auditable;
import be.rebero.ikimina.model.Member;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User extends Auditable<String> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false, length = 10, unique = true)
	private String username;

	@OneToOne(targetEntity = Member.class)
	private Member member;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "role_user",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id"),
			uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "role_id"}))
	private Set<Role> roles;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
