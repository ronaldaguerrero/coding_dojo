Tasks:
1)
What query would you run to get all the countries that speak Slovene?
Your query should return the name of the country, language, and language percentage. 
Your query should arrange the result by language percentage in descending order.

SELECT name, languages.language, languages.percentage FROM world.countries LEFT JOIN world.languages on world.countries.id = world.languages.country_id where language="Slovene" order by languages.percentage DESC;

2)
What query would you run to display the total number of cities for each country? 
Your query should return the name of the country and the total number of cities. 
Your query should arrange the result by the number of cities in descending order.

SELECT COUNT(world.cities.name) as "# of cities", world.countries.name FROM world.countries LEFT JOIN world.cities ON world.countries.id = world.cities.country_id GROUP BY world.countries.name ORDER BY COUNT(world.cities.name) DESC;

3)
What query would you run to get all the cities in Mexico with a population of greater than 500,000? 
Your query should arrange the result by population in descending order.

SELECT world.countries.name, world.cities.name, world.cities.population FROM world.countries LEFT JOIN world.cities ON world.countries.id = world.cities.country_id WHERE world.countries.name = "Mexico" AND world.cities.population > "500,000";

4)
What query would you run to get all languages in each country with a percentage greater than 89%? 
Your query should arrange the result by percentage in descending order.

SELECT world.countries.name, world.languages.language, world.languages.percentage FROM world.countries LEFT JOIN world.languages on world.countries.id = world.languages.country_id WHERE world.languages.percentage > "89" ORDER BY world.languages.percentage DESC;

5)
What query would you run to get all the countries with Surface Area below 501 and Population greater than 100,000?

SELECT world.countries.name, world.countries.surface_area, world.countries.population FROM world.countries WHERE world.countries.population > "100,000" and world.countries.surface_area < "501";

6)
What query would you run to get countries with only Constitutional Monarchy with a surface area of more than 200 and a life expectancy greater than 75 years?

SELECT world.countries.name, world.countries.government_form, world.countries.surface_area, world.countries.life_expectancy FROM world.countries WHERE world.countries.government_form = "Constitutional Monarchy" AND world.countries.surface_area > "200" AND world.countries.life_expectancy > "75";

7)
What query would you run to get all the cities of Argentina inside the Buenos Aires district and have the population greater than 500, 000? The query should return the Country Name, City Name, District, and Population.

SELECT world.countries.name, world.cities.name, world.cities.district, world.cities.population FROM world.countries LEFT JOIN world.cities ON world.countries.id = world.cities.country_id WHERE world.countries.name = "Argentina" AND world.cities.district = "Buenos Aires" AND world.cities.population > "500,000";

8)
What query would you run to summarize the number of countries in each region? The query should display the name of the region and the number of countries. Also, the query should arrange the result by the number of countries in descending order.

SELECT COUNT(world.countries.name) as "# of countries", world.countries.region FROM world.countries GROUP BY world.countries.region ORDER BY COUNT(world.countries.name) DESC;