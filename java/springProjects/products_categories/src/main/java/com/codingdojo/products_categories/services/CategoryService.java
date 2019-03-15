package com.codingdojo.products_categories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.products_categories.models.Category;
import com.codingdojo.products_categories.models.Product;
import com.codingdojo.products_categories.repositories.CategoryRepo;
import com.codingdojo.products_categories.repositories.ProductRepo;

@Service
public class CategoryService {
	
	private final CategoryRepo catRepo;
	private final ProductRepo prodRepo;
	
	public CategoryService(CategoryRepo catRepo, ProductRepo prodRepo) {
		this.catRepo = catRepo;
		this.prodRepo = prodRepo;
	}
	
	public Long createCat(Category c) {
		return catRepo.save(c).getId();
	}
	
	public List<Category> allCats(){
		return catRepo.findAll();
	}
	
	public Category findCat(long id) {
		Optional<Category> optionalCat = catRepo.findById(id);
		if(optionalCat.isPresent()) {
			return optionalCat.get();
		} else {
			return null;
		}
	}

	public List<Category> allExcept(long id) {
		List<Category> cat = this.allCats(); // lists call categories
		Optional<Product> p = prodRepo.findById(id); // finds product
		if(p.isPresent()) {
			List<Category> prodCat = p.get().getCategories(); // lists all categories associated w/ product
			cat.removeAll(prodCat); // removes all associated categories w/ product
			return cat;
		}else {
			return null;
		}
	}
}
