package com.codingdojo.countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.countries.models.Country;

@Repository
public interface CountryRepo extends CrudRepository<Country, Long>{
	
//	@Query("SELECT c.name, l.language, l.percentage FROM Country c JOIN c.languages l WHERE l.language = 'Slovene' ORDER BY l.percentage DESC")
//	List<Object[]> allCountriesWhereLangSolvene();
//	
//	@Query("SELECT COUNT(ci.name), c.name FROM Country c JOIN c.cities ci GROUP BY c.name ORDER BY COUNT(ci.name) DESC")
//	List<Object[]>  countOfCitiesByCountry();
//	
//	@Query("SELECT c.name, ci.name, ci.population FROM Country c JOIN c.cities ci WHERE c.name = 'Mexico' AND ci.population > '500,000'")
//	List<Object[]> citiesInMexicoWithPopG500k();
//	
//	@Query("SELECT c.name, l.language, l.percentage FROM Country c JOIN c.languages l WHERE l.percentage > '89' ORDER BY l.percentage DESC")
//	List<Object[]> showLangG89p();
//	
//	@Query("SELECT c.name, c.surfaceArea, c.population FROM Country c WHERE c.population > '100,000' AND c.surfaceArea < '501'")
//	List<Object[]> showCountriesWPopAndSA();
//	
//	@Query("SELECT c.name, c.governmentForm, c.surfaceArea, c.lifeExpectancy FROM Country c WHERE c.governmentForm = 'Constitutional Monarchy' AND c.surfaceArea > '200' AND c.lifeExpectancy > '75'")
//	List<Object[]> showCountriesWCMaSAaLE();
//	
//	@Query("SELECT c.name, ci.name, ci.district, ci.population FROM Country c JOIN c.cities ci WHERE c.name = 'Argentina' AND ci.district = 'Buenos Aires' AND ci.population > '500,000'")
//	List<Object[]> showCitiesInArgWhereDistrictBAandP();
//	
	@Query("SELECT COUNT(c.name), c.region FROM Country c GROUP BY c.region ORDER BY COUNT(c.name) DESC")
	List<Object[]> countOfCountriesByRegion(); 
	
}
