package be.rebero.ikimina.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Account extends Auditable<String> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@OneToMany(mappedBy = "accounts")
	private Set<Debtor> debtors;
}
