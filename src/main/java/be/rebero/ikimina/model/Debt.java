package be.rebero.ikimina.model;

import be.rebero.ikimina.model.Type.DebtType;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Debt extends Auditable<String> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private Date startDate;

	private Date endDate;

	@Enumerated(EnumType.STRING)
	private DebtType type;

	@OneToMany(mappedBy = "debt", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Debtor> accounts;

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

	public List<Debtor> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Debtor> accounts) {
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
