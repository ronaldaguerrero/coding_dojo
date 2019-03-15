package com.codingdojo.monopoly.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.monopoly.models.Player;
import com.codingdojo.monopoly.services.MonopolyService;

@Controller
public class DiceCtrl {     
   	private int die1;   // Number showing on the first die.
    private int die2;   // Number showing on the second die.
    private final MonopolyService mS;
	
    
    public DiceCtrl(MonopolyService mS) {
    	this.mS = mS;
    }
    
    public void roll() {
    	die1 = (int)(Math.random()*6) + 1;
        die2 = (int)(Math.random()*6) + 1;
    }
    
    @RequestMapping("/tester")
    public String tester(@ModelAttribute("playerPos") Player player, Model model) {
    	List<Player> players = mS.allPlayers();
		model.addAttribute("players", players);
    	return "/pages/tester.jsp";
    }
    
    @PostMapping(value="/roll/dice")
    public String rollDice(@ModelAttribute("playerPos") Player player, HttpSession session, Model model) {
            // Roll the dice by setting each of the dice to be
            // a random number between 1 and 6.
        die1 = (int)(Math.random()*6) + 1;
        die2 = (int)(Math.random()*6) + 1;
        if (die1 == die2) {
        	Integer total = die1 + die2;
	        session.setAttribute("die1", die1);
	        session.setAttribute("die2", die2);
	        Long pId = player.getId();
	        mS.setPlayerPosition(total, pId);
	        Player p = mS.findPlayerById(pId);
	        int landedOn = p.getPosition();
	        session.setAttribute("pId", p.getId());
	        session.setAttribute("landedOnId", landedOn);
	        String propertyName = mS.findPropertyName(landedOn);
	        session.setAttribute("propName", propertyName);
	        int pOnP = mS.findPlayerOnProp(landedOn);
	        mS.chargeRent(pOnP, landedOn);
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
	        String p1Name = mS.findPlayerName(p1);
	        String p2Name = mS.findPlayerName(p2);
	        String p3Name = mS.findPlayerName(p3);
	        session.setAttribute("p1Name", p1Name);
	        session.setAttribute("p2Name", p2Name);
	        session.setAttribute("p3Name", p3Name);
	        String rollerName = mS.findPlayerName(pId);
	        session.setAttribute("rollerName", rollerName);
        	session.setAttribute("doubles", "You rolled doubles! Roll again.");
        	return "redirect:/monopoly";
        } else {
        	session.setAttribute("doubles", "");
        	Integer total = die1 + die2;
	        session.setAttribute("die1", die1);
	        session.setAttribute("die2", die2);
	        Long pId = player.getId();
	        mS.setPlayerPosition(total, pId);
	        Player p = mS.findPlayerById(pId);
	        String rollerName = mS.findPlayerName(pId);
	        session.setAttribute("rollerName", rollerName);
	        int landedOn = p.getPosition();
	        session.setAttribute("pId", p.getId());
	        session.setAttribute("landedOnId", landedOn);
	        String propertyName = mS.findPropertyName(landedOn);
	        session.setAttribute("propName", propertyName);
	        int pOnP = mS.findPlayerOnProp(landedOn);
	        mS.chargeRent(pOnP, landedOn);
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
	        String p1Name = mS.findPlayerName(p1);
	        String p2Name = mS.findPlayerName(p2);
	        String p3Name = mS.findPlayerName(p3);
	        session.setAttribute("p1Name", p1Name);
	        session.setAttribute("p2Name", p2Name);
	        session.setAttribute("p3Name", p3Name);
	        return "redirect:/monopoly";
        }
    }
             
    public int getDie1() {
          // Return the number showing on the first die.
       return die1;
    }
    
    public int getDie2() {
          // Return the number showing on the second die.
       return die2;
    }
    
    public int getTotal() {
          // Return the total showing on the two dice.
       return die1 + die2;
    }
  
    
 }  // end class PairOfDice