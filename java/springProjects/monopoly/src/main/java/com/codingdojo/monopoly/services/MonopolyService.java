package com.codingdojo.monopoly.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.monopoly.models.Player;
import com.codingdojo.monopoly.models.Property;
import com.codingdojo.monopoly.models.Purchases;
import com.codingdojo.monopoly.repositories.PlayerRepo;
import com.codingdojo.monopoly.repositories.PropertyRepo;
import com.codingdojo.monopoly.repositories.PurchasesRepo;

// add features
// buy house
// if house is on property increase rent
// add max houses to 5
// add chance and community cards
// add 3 consecutive doubles leads to jail
// if user lands on go to jail, change position to jail
// if in jail, need to roll double or pay $50 to be released w/ max 3 rolls
// display money
// display player list of properties
// history tracker of events

@Service
public class MonopolyService {
	private final PlayerRepo pR;
	private final PropertyRepo propR;
	private final PurchasesRepo purchR;
	
	public MonopolyService(PlayerRepo pR, PropertyRepo propR, PurchasesRepo purchR) {
		this.pR = pR;
		this.propR = propR;
		this.purchR = purchR;
	}

	public Player createPlayer(Player player) {
		return pR.save(player);
	}
	
	public List<Player> allPlayers() {
		return pR.findAll();
	}

	public void deletePlayer(Long id) {
		pR.deleteById(id);
	}

	public List<Property> allProperties() {
		return propR.findAll();
	}
	
	public List<Object[]> allUnownedProperties(){
		return pR.findUnownedProps();
	}

	public void linkPropToPlayer(Purchases purch) {
		purchR.save(purch);
	}

	public Player findPlayerById(Long id) {
		Optional<Player> u = pR.findById(id);
    	if(u.isPresent()) {
            return u.get();
    	} else {
    	    return null;
    	}
    }
	
	public int findPropertyOwnerID(int property) {
		return pR.findPropOwnerId(property);
	}
	
	public int setPlayerPosition(Integer diceRoll, Long pId) {
		Integer pPos = pR.findPPosition(pId);
		if(pPos + diceRoll > 40) {
			int posTo40 = 40 - pPos;
			int rollDiff = diceRoll - posTo40;
			return pR.setPPosition(rollDiff, pId);
		} else {
			int newPost = diceRoll + pPos;
			return pR.setPPosition(newPost, pId);
		}
	}
	
	public int setPlayerMoney(Integer money, Long pId) {
		return pR.setPMoney(money, pId);
	}
	
	public String findPropertyName(Integer position) {
		return pR.findPName(position);
	}

	public int findLastPurchaseOwnerId() {
		return pR.findLPOId();
	}

	public int findLastPurchasePropertyId() {
		return pR.findLPPid();
	}

	public int findPropPrice(int pId) {
		return pR.findPPrice(pId);
	}
	
	public int findPlayerMoney(int pId) {
		return pR.findPmoney(pId);
	}

	public int setPlayerMoney(int newMoney, int playerId) {
		return pR.setPlayMoney(newMoney, playerId);
		
	}
	
	public int chargeRent(int playerId, int tilePosition) {
		Optional<Integer> ownerId = pR.oFindPropOwnerId(tilePosition);
		if(ownerId.isPresent()) {
			int oId = pR.findPropOwnerId(tilePosition);
			if(oId == playerId) {
				System.out.println("you own this property");
				return 0;
			} else {
				int propertyRent = pR.findPRent(tilePosition);
				System.out.println("property rent: " + propertyRent);
				int renterMoney = pR.findPmoney(playerId);
				System.out.println("renter's money: " + renterMoney);
				int newRenterBal = renterMoney - propertyRent;
				int ownerMoney = pR.findPmoney(oId);
				int newOwnerBal = ownerMoney + propertyRent;
				pR.setPlayMoney(newRenterBal, playerId);
				return pR.setPlayMoney(newOwnerBal, oId);
			}
		} else if(tilePosition == 4){
				int propertyRent = pR.findPRent(tilePosition);
				int renterMoney = pR.findPmoney(playerId);
				int newRenterBal = renterMoney - propertyRent;
				return pR.setPlayMoney(newRenterBal, playerId);
		} else if (tilePosition == 3 || tilePosition == 18 || tilePosition == 34){
			int propertyRent = pR.findPRent(tilePosition);
			int renterMoney = pR.findPmoney(playerId);
			int newRenterBal = renterMoney + propertyRent;
			System.out.println("community chest");
			return pR.setPlayMoney(newRenterBal, playerId);
		}else if (tilePosition == 8 || tilePosition == 23 || tilePosition == 37){
			int propertyRent = pR.findPRent(tilePosition);
			int renterMoney = pR.findPmoney(playerId);
			int newRenterBal = renterMoney - propertyRent;
			System.out.println("chance");
			return pR.setPlayMoney(newRenterBal, playerId);
		} else {
			return 0;
		}
	}
		

	public int findPlayerOnProp(int onProp) {
		return pR.findPonP(onProp);
	}
	
	public int findPlayerPosition(int pId) {
		return pR.iFindPPosition(pId);
	}
	
	public String findPlayerName(int pId) {
		return pR.findPlayerName(pId);
	}

	public Integer findPlayerPosition(Long pId) {
		return pR.findPPosition(pId);
	}

	public String findPlayerName(Long pId) {
		return pR.LfindPlayerName(pId);
	}

	public int findPlayerMoney(Long pId) {
		return pR.LfindPlayerMoney(pId);
	}

	public List<Object[]> allPurchasesByP(Long pId) {
		return pR.LallPurchasesByP(pId);
	}
	
}
