package com.codingdojo.monopoly.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.monopoly.models.Player;
import com.codingdojo.monopoly.models.Property;
import com.codingdojo.monopoly.models.Purchases;
import com.codingdojo.monopoly.services.MonopolyService;

@Controller
public class GameCtrl {
	private final MonopolyService mS;
		
	public GameCtrl(MonopolyService mS) {
		this.mS = mS;
	}
	
	@RequestMapping("/monopoly")
	public String start(@ModelAttribute("buyProp") Purchases purch, @ModelAttribute("playerPos") Player player, Model model, HttpSession session) {
		List<Property> properties = mS.allProperties();
		model.addAttribute("properties", properties);
		List<Player> players = mS.allPlayers();
		model.addAttribute("players", players);
		List<Object[]> unO = mS.allUnownedProperties();
		model.addAttribute("unO", unO);
		List<Player> allPlayers = mS.allPlayers();
        allPlayers.toArray();
        Long p1 = allPlayers.get(0).getId();
        Long p2 = allPlayers.get(1).getId();
        Long p3 = allPlayers.get(2).getId();
        // customize input param based on player id  
        int p1Pos = mS.findPlayerPosition(p1);
        int p2Pos = mS.findPlayerPosition(p2);
        int p3Pos = mS.findPlayerPosition(p3);
        session.setAttribute("p1Pos", p1Pos);
        session.setAttribute("p2Pos", p2Pos);
        session.setAttribute("p3Pos", p3Pos);
        int p1Money = mS.findPlayerMoney(p1);
        int p2Money = mS.findPlayerMoney(p2);
        int p3Money = mS.findPlayerMoney(p3);
        session.setAttribute("p1Money", p1Money);
        session.setAttribute("p2Money", p2Money);
        session.setAttribute("p3Money", p3Money);
        String p1Name = mS.findPlayerName(p1);
        String p2Name = mS.findPlayerName(p2);
        String p3Name = mS.findPlayerName(p3);
        session.setAttribute("p1Name", p1Name);
        session.setAttribute("p2Name", p2Name);
        session.setAttribute("p3Name", p3Name);
        List<Object[]> allPurchasesbyP1 = mS.allPurchasesByP(p1);
        List<Object[]> allPurchasesbyP2 = mS.allPurchasesByP(p2);
        List<Object[]> allPurchasesbyP3 = mS.allPurchasesByP(p3);
        model.addAttribute("p1Props", allPurchasesbyP1);
        model.addAttribute("p2Props", allPurchasesbyP2);
        model.addAttribute("p3Props", allPurchasesbyP3);
		return "pages/game.jsp";
	}
	
	// add validation to check players money before purchase
	@PostMapping(value="/buy")
	public String buyProperty(@ModelAttribute("buyProp") Purchases purch) {
		mS.linkPropToPlayer(purch);
		//place in service and change service method name to repo method name
		int playerId = mS.findLastPurchaseOwnerId();
		int pId = mS.findLastPurchasePropertyId();
		int price = mS.findPropPrice(pId);
		int money = mS.findPlayerMoney(playerId);
		int newMoney = money - price;
		mS.setPlayerMoney(newMoney, playerId);
		return "redirect:/monopoly";
	}
	
	@RequestMapping("end/game")
	public String endGame(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	
}
