package com.codingdojo.products_categories.services;

import org.springframework.stereotype.Service;

import com.codingdojo.products_categories.models.CategoryProduct;
import com.codingdojo.products_categories.repositories.CategoryProductRepo;

@Service
public class InventoryService {
	private final CategoryProductRepo cPR;
	
	public InventoryService(CategoryProductRepo cPR) {
		this.cPR = cPR;
	}
	

	public void addCatToProd(CategoryProduct catProd) {
		 cPR.save(catProd);
	}


	

}
