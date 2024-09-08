package com.learning.chapter_2;

import com.learning.chapter_2.BankTransaction;
import java.util.List;

public class BankTransactionService
{
	private List<BankTransaction> getTopTenExpenses(List<BankTransaction> bankTransactions)
	{
		return bankTransactions.stream()
			.sorted(BankTransaction::compareTo)
			.limit(10)
			.toList();
	}

	private double getBalance(List<BankTransaction> bankTransactions)
	{
		return bankTransactions.stream().mapToDouble(BankTransaction::getAmount).sum();
	}

	private int calculateTransactionsQuantity(List<BankTransaction> bankTransactions)
	{

	}
