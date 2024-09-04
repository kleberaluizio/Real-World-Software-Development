package com.learning;

import java.util.List;
import java.util.Objects;

public class chapter_02
{
	public static void main(String[] args)
	{

	}

	private List<BankTransaction> getTopTenExpenses(List<BankTransaction> bankTransactions)
	{
		return bankTransactions.stream().sorted((a,b) -> a.getAmount() >= b.getAmount())
	}

	private double getBalance(List<BankTransaction> bankTransactions)
	{
		return bankTransactions.stream().mapToDouble(BankTransaction::getAmount).sum();
	}

	private int calculateTransactionsQuantity(List<BankTransaction> bankTransactions)
	{
		return bankTransactions.size() - 1;
	}

}

class BankTransaction{
	String date;
	private double amount;
	String type;

	public double getAmount(){
		return this.amount;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (o == null || getClass() != o.getClass())
		{
			return false;
		}
		BankTransaction that = (BankTransaction) o;
		return Double.compare(amount, that.amount) == 0;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(date, amount, type);
	}
}

