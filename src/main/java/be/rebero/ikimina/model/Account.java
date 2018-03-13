package be.rebero.ikimina.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Account extends Auditable<String> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private BigDecimal balance;

	@OneToOne(targetEntity = Member.class)
	private Member member;

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Debtor> debts;

	public List<Debtor> getDebts() {
		return debts;
	}

	public void setDebts(List<Debtor> debts) {
		this.debts = debts;
	}
}
