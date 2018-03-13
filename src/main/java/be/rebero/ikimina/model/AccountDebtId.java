package be.rebero.ikimina.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AccountDebtId implements Serializable {

	@Column(name = "account_id")
	private Long accountId;

	@Column(name = "debt_id")
	private Long debtId;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AccountDebtId that = (AccountDebtId) o;
		return Objects.equals(accountId, that.accountId) &&
				Objects.equals(debtId, that.debtId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountId, debtId);
	}
}
