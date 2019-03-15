package com.codingdojo.monopoly.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.monopoly.models.Player;
import com.codingdojo.monopoly.services.MonopolyService;

@Controller
public class PlayerCtrl{
	private final MonopolyService mS;
	
	public PlayerCtrl(MonopolyService mS) {
		this.mS = mS;
	}
	
	@RequestMapping("/")
	public String home(@ModelAttribute("player") Player player, Model model) {
		List<Player> players = mS.allPlayers();
		model.addAttribute("players", players);
		return "pages/home.jsp";
	}
	
	@PostMapping("create/player")
	public String createPlayer(@Valid @ModelAttribute("player") Player player, BindingResult result) {
		if(result.hasErrors()) {
			return "pages/home.jsp";
		} else {
			mS.createPlayer(player);
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		mS.deletePlayer(id);
		return "redirect:/";
	}
	
	
}
