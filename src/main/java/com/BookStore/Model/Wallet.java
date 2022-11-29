package com.BookStore.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="wallet")
public class Wallet {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int wallet_id;
	private int user_id;
	private double balance;
	private boolean add_or_deduct;
	public int getWallet_id() {
		return wallet_id;
	}
	public void setWallet_id(int wallet_id) {
		this.wallet_id = wallet_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public boolean isAdd_or_deduct() {
		return add_or_deduct;
	}
	public void setAdd_or_deduct(boolean add_or_deduct) {
		this.add_or_deduct = add_or_deduct;
	}
	@Override
	public String toString() {
		return "Wallet [wallet_id=" + wallet_id + ", user_id=" + user_id  + ", balance="
				+ balance + ", add_or_deduct=" + add_or_deduct + "]";
	}
	
	
}
