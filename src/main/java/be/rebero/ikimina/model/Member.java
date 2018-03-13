package be.rebero.ikimina.model;

import be.rebero.ikimina.model.Type.MemberStatus;
import be.rebero.ikimina.model.Type.MemberType;
import be.rebero.ikimina.model.auth.User;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Member extends Auditable<String> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@OneToOne(targetEntity = Account.class)
	private Account account;

	@OneToOne(targetEntity = User.class)
	private User user;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private MemberType type;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date since;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private MemberStatus status;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public MemberType getType() {
		return type;
	}

	public void setType(MemberType type) {
		this.type = type;
	}

	public Date getSince() {
		return since;
	}

	public void setSince(Date since) {
		this.since = since;
	}

	public MemberStatus getStatus() {
		return status;
	}

	public void setStatus(MemberStatus status) {
		this.status = status;
	}
}
