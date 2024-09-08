package com.learning.chapter_2;

import java.util.Objects;

public class BankTransaction implements Comparable<BankTransaction>
{
	private String date;
	private double amount;
	private String type;

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

	@Override
	public int compareTo(BankTransaction that)
	{
		// Comparando pelas despesas (maior despesa primeiro)
		return Double.compare(that.amount, this.amount);
	}
}
