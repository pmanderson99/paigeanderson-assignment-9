package com.coderscampus.assignment9.web;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.assignment9.domain.Recipes;
import com.coderscampus.assignment9.service.FileService;

@RestController
public class RecipeController {
	
	@Autowired
	private FileService fileService;
	
	@GetMapping("/all-recipes")
	public List<Recipes> readRecipes () throws IOException {
		return fileService.readRecipes();
	}
 	
	@GetMapping("/gluten-free")
	public List<Recipes> glutenFreeRecipes() throws IOException {
		return fileService.readRecipes()
						  .stream()
						  .filter(Recipes::getGlutenFree)
						  .collect(Collectors.toList());
	}
	
	@GetMapping("/vegan")
	public List<Recipes> veganRecipes() throws IOException {
		return fileService.readRecipes()
						  .stream()
						  .filter(Recipes::getVegan)
						  .collect(Collectors.toList());
	}

	@GetMapping("/vegan-and-gluten-free")
	public List<Recipes> veganAndGlutenFreeRecipes() throws IOException {
		return fileService.readRecipes()
						  .stream()
						  .filter(Recipes::getVegan)
						  .filter(Recipes::getGlutenFree)
						  .collect(Collectors.toList());
	}

	@GetMapping("/vegetarian")
	public List<Recipes> vegetarianRecipes() throws IOException {
		return fileService.readRecipes()
						  .stream()
						  .filter(Recipes::getVegetarian)
						  .collect(Collectors.toList());
	}

}
