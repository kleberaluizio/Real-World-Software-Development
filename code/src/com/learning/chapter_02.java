package com.learning;

import com.learning.chapter_2.BankTransaction;
import com.learning.chapter_2.BankTransactionService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class chapter_02
{
	private static final String RESOURCES = "src/com/learning/data/data.csv";
	private static final BankTransactionService service = new BankTransactionService();

    public static void main(String[] args) throws IOException {
		List<BankTransaction> transactions = getTransactions_NO_LIB_();

		System.out.println("---- RESULTS ----");
		double balance = service.getBalance(transactions);
		System.out.println("balance: " + balance);
		int transactionsQuantity = service.calculateTransactionsQuantity(transactions);
		System.out.println("transactionsQuantity: " + transactionsQuantity);
	}

	// Get transactions from .csv, all lines are storage in memory during reading process. It's not the best approach!
	private static List<BankTransaction> getTransactions_NO_LIB_() throws IOException {
		List<BankTransaction> transactions = new ArrayList<>();

		Path path = Paths.get(RESOURCES );
		List<String> lines = Files.readAllLines(path);

		for(final String line: lines) {
			final String[] data = line.split(";");

			BankTransaction transaction = new BankTransaction();
			transaction.setDate(data[0]);
			transaction.setAmount(Double.parseDouble(data[1]));
			transaction.setType(data[2]);

			transactions.add(transaction);
		}
		return transactions;
	}


}


