package com.coderscampus.assignment9.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import com.coderscampus.assignment9.domain.Recipes;

@Service
public class FileService {
	
	
	public List<Recipes> readRecipes() throws IOException{
		List <Recipes> recipeList = new ArrayList<>();
		
		Reader in = new FileReader("recipes.txt");
		@SuppressWarnings("deprecation")
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withDelimiter(',')
													   .withEscape('\\')
													   .withFirstRecordAsHeader()
													   .withSkipHeaderRecord()
													   .withIgnoreSurroundingSpaces()
													   .parse(in);
											   
			for (CSVRecord record : records) {	       
		        Integer cookingMinutes = Integer.parseInt(record.get(0));
		        Boolean dairyFree = Boolean.parseBoolean(record.get(1));
		        Boolean glutenFree = Boolean.parseBoolean(record.get(2));
		        String instructions  = record.get(3);
		        Double preparationMinutes = Double.parseDouble(record.get(4));
		        Double pricePerServing = Double.parseDouble(record.get(5));
		        Integer readyInMinutes = Integer.parseInt(record.get(6));
		        Integer servings = Integer.parseInt(record.get(7));
		        Double spoonacularScore = Double.parseDouble(record.get(8));
		        String title = record.get(9);
		        Boolean vegan = Boolean.parseBoolean(record.get(10));
		        Boolean vegatarian = Boolean.parseBoolean(record.get(11));
		        Recipes recipe = new Recipes
		        		(cookingMinutes, dairyFree, glutenFree,
		        		 instructions, preparationMinutes,
		        		 pricePerServing, readyInMinutes,
		        		 servings, spoonacularScore, title,
		        		 vegan, vegatarian);
		        recipeList.add(recipe);
		    }
		
		return recipeList;
	}
	
}
