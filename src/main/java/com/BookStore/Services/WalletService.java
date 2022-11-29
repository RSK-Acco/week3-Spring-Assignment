package com.BookStore.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.BookStore.Model.Wallet;
import com.BookStore.Repository.WalletRepository;

@Service
@Transactional
public class WalletService {
	@Autowired private WalletRepository wr;
	 private Wallet w;
	public void addToWallet(int uid, double moneyToAdd) {
		w=new Wallet();
		w.setAdd_or_deduct(true);
		w.setBalance(moneyToAdd);
		w.setUser_id(uid);
		 this.wr.save(w);
	}
	public void deductWallet(int uid, double moneyTodeduct) {
		w=new Wallet();
		w.setAdd_or_deduct(false);
		w.setBalance(moneyTodeduct);
		w.setUser_id(uid);
		 this.wr.save(w);
	}
	public List<String> returnWallet(int uid) {
		List<String> transac=new ArrayList<>();
		List<Wallet> users=this.wr.findAllWalletTransaction(uid);
		for(Wallet o:users) {
			if(o.isAdd_or_deduct()) transac.add(o.toString() + "---Money After Added---");
			else transac.add(o.toString() + "---Money After Deducted---");
		}
		return transac;
	}
}
