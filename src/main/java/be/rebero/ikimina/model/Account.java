package be.rebero.ikimina.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Account extends Auditable<String> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Debtor> debts;

	public List<Debtor> getDebts() {
		return debts;
	}

	public void setDebts(List<Debtor> debts) {
		this.debts = debts;
	}
}
