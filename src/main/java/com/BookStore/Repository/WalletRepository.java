package com.BookStore.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.BookStore.Model.Wallet;

public interface WalletRepository extends JpaRepository<Wallet,Integer> {
	@Query(value = "Select * from bookstore.wallet w where w.user_id=?1", nativeQuery = true)
	List<Wallet> findAllWalletTransaction(int user_id);
}
