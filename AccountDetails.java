package bankaccount;

public class AccountDetails {

	private String Acc_type;

	private String Acc_name;

	private long Acc_num;

	private double Acc_bal;

	private String currenc;

	
	public String getAccountType() {

		return Acc_type;

	}

	
	public void setAccountType(String AccountType) {

		this.Acc_type = AccountType;

	}

	public String getAccountName() {

		return Acc_name;

	}

	public void setAccountName(String AccountName) {

		this.Acc_name = AccountName;

	}

	public long getAccountNumber() {

		return Acc_num;

	}

	public void setAccountNumber(long AccountNumber) {

		this.Acc_num = AccountNumber;

	}

	public double getAccountBalance() {

		return Acc_bal;

	}

	public void setAccountBalance(double AccountBalance) {

		this.Acc_bal = AccountBalance;

	}

	public String getCurrency() {

		return currenc;

	}

	public void setCurrency(String currency) {

		this.currenc = currency;

	}

	

}