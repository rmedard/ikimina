package be.rebero.ikimina.model;

import be.rebero.ikimina.model.Type.DebtType;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Debt extends Auditable<String> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private Date startDate;

	private Date endDate;

	@Enumerated(EnumType.STRING)
	private DebtType type;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "debtor",
			joinColumns = @JoinColumn(name = "debt_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "account_id", referencedColumnName = "id"))
	private Set<Account> accounts;

	private boolean closed;

	@Lob
	private String description;

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public DebtType getType() {
		return type;
	}

	public void setType(DebtType type) {
		this.type = type;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

	public boolean isClosed() {
		return closed;
	}

	public void setClosed(boolean closed) {
		this.closed = closed;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
