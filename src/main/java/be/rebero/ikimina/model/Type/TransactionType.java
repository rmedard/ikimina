package be.rebero.ikimina.model.Type;

import java.util.ArrayList;
import java.util.List;

public enum TransactionType {

	MEMBERSHIP_FEE(TransactionDirection.CREDIT),
	DEBT_PAYBACK(TransactionDirection.CREDIT),
	DIVIDEND(TransactionDirection.DEBIT),
	EXPENSE(TransactionDirection.DEBIT);

	private TransactionDirection direction;

	TransactionType(TransactionDirection direction) {
		this.direction = direction;
	}

	public TransactionDirection getDirection() {
		return direction;
	}

	public List<TransactionType> getByDirection(TransactionDirection direction) {
		List<TransactionType> types = new ArrayList<>();
		for (TransactionType type : TransactionType.values()){
			if (type.direction.equals(direction)){
				types.add(type);
			}
		}
		return types;
	}
}
