package com.codingdojo.products_categories.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.products_categories.models.Category;
import com.codingdojo.products_categories.models.Product;
import com.codingdojo.products_categories.services.CategoryService;
import com.codingdojo.products_categories.services.InventoryService;
import com.codingdojo.products_categories.services.ProductService;

@Controller
public class CategoryController {
	private final ProductService prodService;
	private final CategoryService catService;
	private final InventoryService iS;
	
	public CategoryController(ProductService prodService, CategoryService catService, InventoryService iS) {
		this.catService = catService;
		this.prodService = prodService;
		this.iS = iS;
	}
	
	@RequestMapping("categories/new")
	public String index(@ModelAttribute("catObj") Category cat) {
		return "pro_cat/category.jsp";
	}
	
	@PostMapping(value="create/cat")
	public String newCat(@ModelAttribute("catObj") Category cat, Model model) {
		Long catId = catService.createCat(cat);
		return "redirect:/categories/" + catId;
	}
	
	@RequestMapping("categories/{id}")
	public String show(@PathVariable("id") long id, Model model) {
		Category cat = catService.findCat(id); // finds category
		model.addAttribute("cat", cat); // adds category to model
		List<Product> prod = prodService.allExcept(id); // runs prod service
		model.addAttribute("prod", prod); // adds product to model
		return "/pro_cat/showC.jsp";
	}
	
	@PostMapping(value="linkP/{id}")
	public String linkProd(@RequestParam("prodChoice") long p, @PathVariable("id") long catId) {
		Category cat = catService.findCat(catId); //finds category
		Product prod = prodService.findProd(p); // finds product
		List<Product> products = cat.getProducts(); // gets all products associated w/ category
		products.add(prod); // adds product to existing list
		catService.createCat(cat); // links category
		return "redirect:/categories/{id}";
	}
}
