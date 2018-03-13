package be.rebero.ikimina.model;

import be.rebero.ikimina.model.Type.DebtorType;

import javax.persistence.*;

@Entity
public class Debtor {

	@EmbeddedId
	private AccountDebtId id;

	@MapsId("account_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Account account;

	@MapsId("debt_id")
	@ManyToOne(fetch = FetchType.LAZY)
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
