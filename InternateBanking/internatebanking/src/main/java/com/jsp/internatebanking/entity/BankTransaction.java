package com.jsp.internatebanking.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import net.bytebuddy.build.HashCodeAndEqualsPlugin.Enhance;

@Entity
public class BankTransaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int senderID;
	private int reciverID;
	private double amount;
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDate transactionTime;
	
	public BankTransaction() {
		 
	}

	public BankTransaction(int senderID, int reciverID, double amount) {
		this.senderID = senderID;
		this.reciverID = reciverID;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSenderID() {
		return senderID;
	}

	public void setSenderID(int senderID) {
		this.senderID = senderID;
	}

	public int getReciverID() {
		return reciverID;
	}

	public void setReciverID(int reciverID) {
		this.reciverID = reciverID;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(LocalDate transactionTime) {
		this.transactionTime = transactionTime;
	}
	
}
