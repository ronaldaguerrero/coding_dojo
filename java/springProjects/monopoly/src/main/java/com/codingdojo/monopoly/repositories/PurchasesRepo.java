package com.codingdojo.monopoly.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.monopoly.models.Purchases;

@Repository
public interface PurchasesRepo extends CrudRepository<Purchases, Long>{
	@Query(value="SELECT player_id\n" + 
			"FROM monopoly.purchases \n" + 
			"ORDER BY id DESC  \n" + 
			"LIMIT 1;", nativeQuery=true)
	Integer findPlayerIdOfLastPurchase(Long id);
}
