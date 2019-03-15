package com.codingdojo.products_categories.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.products_categories.models.Category;
import com.codingdojo.products_categories.models.CategoryProduct;
import com.codingdojo.products_categories.models.Product;
import com.codingdojo.products_categories.services.CategoryService;
import com.codingdojo.products_categories.services.InventoryService;
import com.codingdojo.products_categories.services.ProductService;

@Controller
public class ProductController {
	private final ProductService prodService;
	private final CategoryService catService;
	private final InventoryService iS;
	
	public ProductController(ProductService prodService, CategoryService catService, InventoryService iS) {
		this.catService = catService;
		this.prodService = prodService;
		this.iS = iS;
	}
	
	@RequestMapping("products/new")
	public String index(@ModelAttribute("prodObj") Product prod) {
		return "pro_cat/index.jsp";
	}
	
	@PostMapping(value="create/prod")
	public String newProd(@ModelAttribute("prodObj") Product prod, Model model) {
		Long prodId = prodService.createProd(prod);
		return "redirect:/products/" + prodId;
	}
	
	@RequestMapping("products/{id}")
	public String show(@ModelAttribute("prodObj") CategoryProduct catProd, @PathVariable("id") long id, Model model) {
		Product prod = prodService.findProd(id); // finds product
		model.addAttribute("prod", prod); // adds product to model
		List<Category> cat = catService.allExcept(id); // runs category service
		model.addAttribute("cat", cat); // adds categories to model
		return "/pro_cat/showP.jsp";
	}
	
//	@PostMapping(value="link/{id}")
//	public String linkCat(@RequestParam("catChoice") long c, @PathVariable("id") long prodId) {
//		Product prod = prodService.findProd(prodId); // finds product
//		Category cat = catService.findCat(c); // finds category
//		List<Category> categories = prod.getCategories(); // gets all categories associated w/ product
//		categories.add(cat); //  adds category to existing list 
//		prodService.createProd(prod); // links product
//		return "redirect:/products/{id}";
//	}
	
	@PostMapping(value="linkC")
	public String linkCat(@ModelAttribute("prodObj") CategoryProduct catProd) {
		iS.addCatToProd(catProd);
		return "redirect:/products/" + catProd.getProduct().getId();
	}
}
