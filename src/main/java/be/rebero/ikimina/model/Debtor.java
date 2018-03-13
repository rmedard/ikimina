package be.rebero.ikimina.model;

import be.rebero.ikimina.model.Type.DebtorType;

import javax.persistence.*;

@Entity
public class Debtor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "account_id")
	@OneToMany(mappedBy = "debts")
	private Account account;

	@Column(name = "debt_id")
	@OneToMany(mappedBy = "accounts")
	private Debt debt;

	@Enumerated(EnumType.STRING)
	private DebtorType type;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Debt getDebt() {
		return debt;
	}

	public void setDebt(Debt debt) {
		this.debt = debt;
	}

	public DebtorType getType() {
		return type;
	}

	public void setType(DebtorType type) {
		this.type = type;
	}
}
