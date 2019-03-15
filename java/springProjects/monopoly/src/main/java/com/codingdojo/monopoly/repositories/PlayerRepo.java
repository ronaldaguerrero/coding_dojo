package com.codingdojo.monopoly.repositories;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.monopoly.models.Player;
import com.codingdojo.monopoly.models.Purchases;

//organize queries by Repo
@Repository
public interface PlayerRepo extends CrudRepository<Player, Long>{

	List<Player> findAll();
	
	@Query(value="Select players.position FROM monopoly.players WHERE players.id = ?1", nativeQuery = true)
	Integer findPPosition(Long pId);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE monopoly.players SET position = ?1 WHERE id = ?2", nativeQuery = true)
	int setPPosition(Integer position, Long pId);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE monopoly.players SET money = ?1 WHERE id = ?2", nativeQuery = true)
	int setPMoney(Integer money, Long pId);
	
	@Query(value="SELECT properties.name FROM monopoly.properties WHERE properties.position = ?1", nativeQuery = true)
	String findPName(Integer position);	
	
	@Query(value="SELECT money FROM monopoly.players where id = ?1", nativeQuery = true)
	int findPmoney(int id);
	
	@Query(value="SELECT money FROM monopoly.players where id = ?1", nativeQuery = true)
	Optional<Integer> oFindPmoney(int id);
	
	@Query(value="SELECT player_id FROM monopoly.purchases where property_id = ?1", nativeQuery = true)
	Optional<Integer> oFindPropOwnerId(int property);
	
	@Query(value="SELECT player_id FROM monopoly.purchases where property_id = ?1", nativeQuery = true)
	int findPropOwnerId(int property);
	
	@Query(value="SELECT monopoly.properties.id, monopoly.properties.name FROM monopoly.properties WHERE NOT EXISTS (SELECT * FROM monopoly.purchases WHERE monopoly.purchases.property_id = monopoly.properties.id) AND monopoly.properties.price != 0", nativeQuery= true)
	List<Object[]> findUnownedProps();

	@Query(value="SELECT player_id FROM monopoly.purchases ORDER BY id DESC LIMIT 1", nativeQuery = true)
	int findLPOId();
	
	@Query(value="SELECT property_id FROM monopoly.purchases ORDER BY id DESC LIMIT 1", nativeQuery = true)
	int findLPPid();
	
	@Query(value="SELECT price FROM monopoly.properties WHERE id = ?1", nativeQuery = true)
	int findPPrice(int pId);
	
	@Transactional
	@Modifying
	@Query(value="Update monopoly.players SET money = ?1 WHERE id = ?2", nativeQuery = true)
	int setPlayMoney(int newMoney, int playerId);
	
	@Query(value="Select id FROM monopoly.players WHERE position = ?1", nativeQuery = true)
	int findPonP(Integer onProp);

	@Query(value="SELECT rent FROM monopoly.properties WHERE id = ?1", nativeQuery = true)
	int findPRent(int tilePosition);
	
	@Query(value="Select players.position FROM monopoly.players WHERE players.id = ?1", nativeQuery = true)
	int iFindPPosition(int pId);
	
	@Query(value="Select players.name FROM monopoly.players WHERE players.id = ?1", nativeQuery = true)
	String findPlayerName(int pId);
	
	@Query(value="Select players.name FROM monopoly.players WHERE players.id = ?1", nativeQuery = true)
	String LfindPlayerName(Long pId);
	
	@Query(value="Select players.money FROM monopoly.players WHERE players.id = ?1", nativeQuery = true)
	int LfindPlayerMoney(Long pId);
	
	@Query(value="SELECT monopoly.properties.name, monopoly.properties.rent FROM monopoly.purchases LEFT JOIN monopoly.properties ON monopoly.properties.id = monopoly.purchases.property_id WHERE monopoly.purchases.player_id = ?1", nativeQuery = true)
	List<Object[]> LallPurchasesByP(Long Pid);
}
