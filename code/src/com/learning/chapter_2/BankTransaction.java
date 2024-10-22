package com.learning.chapter_2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class BankTransaction implements Comparable<BankTransaction>
{
	private LocalDate date;
	private double amount;
	private String type;

	public double getAmount(){
		return this.amount;
	}

	public void setAmount(double amount){
		this.amount = amount;
	}

	public String getType(){return this.type;}

	public void setType(String type){
		this.type = type;
	}

	public LocalDate getDate(){return this.date;}

	public void setDate(String date){
		this.date = getLocalDateFrom(date);
	}

	private LocalDate getLocalDateFrom(String dateString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		if (dateString.startsWith("\uFEFF")) {
			dateString = dateString.substring(1);
		}
		return LocalDate.parse(dateString, formatter);
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
