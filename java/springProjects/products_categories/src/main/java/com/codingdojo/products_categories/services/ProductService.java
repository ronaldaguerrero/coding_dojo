package com.codingdojo.products_categories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.products_categories.models.Category;
import com.codingdojo.products_categories.models.Product;
import com.codingdojo.products_categories.repositories.CategoryRepo;
import com.codingdojo.products_categories.repositories.ProductRepo;

@Service
public class ProductService {

	private final ProductRepo prodRepo;
	private final CategoryRepo catRepo;
	
	public ProductService(ProductRepo prodRepo, CategoryRepo catRepo) {
		this.prodRepo = prodRepo;
		this.catRepo = catRepo;
	}
	
	public Long createProd(Product p) {
		return prodRepo.save(p).getId();
	}
	
	public List<Product> allProds(){
		return prodRepo.findAll();
	}
	
	public Product findProd(long id) {
		Optional<Product> optionalProd = prodRepo.findById(id);
		if(optionalProd.isPresent()) {
			return optionalProd.get();
		} else {
			return null;
		}
	}
	
	public List<Product> allExcept(long id){
		List<Product> prod = this.allProds(); // lists all products
		Optional<Category> c = catRepo.findById(id); // finds category
		if(c.isPresent()) {
			List<Product> catProd = c.get().getProducts(); // lists all products associated w/ category
			prod.removeAll(catProd); // removes all associated products w/ category
			return prod;
		} else {
			return null;
		}
	}

}
