package com.codingdojo.products_categories.repositories;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.products_categories.models.CategoryProduct;

public interface CategoryProductRepo extends CrudRepository<CategoryProduct, Long>{

}
