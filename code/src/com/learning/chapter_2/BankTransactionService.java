package com.learning.chapter_2;

import com.learning.chapter_2.BankTransaction;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BankTransactionService {
	public BankTransactionService() {
	}

	public List<BankTransaction> getTopTenExpenses(List<BankTransaction> bankTransactions) {
		return bankTransactions.stream()
				.sorted(BankTransaction::compareTo)
				.limit(10)
				.toList();
	}

	public double getBalance(List<BankTransaction> bankTransactions) {
		return bankTransactions.stream().mapToDouble(BankTransaction::getAmount).sum();
	}

	public int calculateTransactionsQuantity(List<BankTransaction> bankTransactions) {
		return bankTransactions.size();
	}
}