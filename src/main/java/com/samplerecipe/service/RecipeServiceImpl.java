package com.samplerecipe.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samplerecipe.controller.RecipeController;
import com.samplerecipe.entity.Recipe;
import com.samplerecipe.exceptions.IdNotFoundException;
import com.samplerecipe.exceptions.NoDataException;
import com.samplerecipe.exceptions.NoRecipefoundException;
import com.samplerecipe.repository.RecipeRepository;

@Service
public class RecipeServiceImpl implements RecipeServiceInterface {
	@Autowired
	RecipeRepository rs;
	Logger logger = LoggerFactory.getLogger(RecipeController.class);

	@Override
	public List<Recipe> getallrecipes() throws NoRecipefoundException {
		List<Recipe> m = rs.findAll();
		if (m.isEmpty()) {
			logger.error("No recipes in Database");
			throw new NoRecipefoundException("No recipes found");
		}
		int i;
		logger.warn("i is not used in anywhere");
		logger.info("Fetch all Recipes from the database");
		return rs.findAll();
	}

	@Override
	public Recipe addRecipes(Recipe r) {
		logger.info("Successfully created the recipe");
		return rs.save(r);
	}

	@Override
	public String deleteRecipe(int rId) throws NoDataException {
		Optional<Recipe> m = rs.findById(rId);
		if (!m.isPresent()) {
			logger.error("There is no recipe with the Id {} to delete", rId);
			throw new NoDataException("Sorry we can't find this Id!!");
		}
		rs.deleteById(rId);
		logger.info("Successfully deleted the recipe with Id {}", rId);
		return "Removed";
	}

	@Override
	public Recipe updateRecipe(int rId, Recipe r) {
		Recipe m = rs.findById(rId).get();
		if (m != null) {
			logger.error("Recipe with the Id {} is not in database to update", rId);
			m.setRecipeName(r.getRecipeName());
			m.setVeg(r.isVeg());
			m.setRecipeType(r.getRecipeType());
			m.setInstructions(r.getInstructions());
			m.setIngredients(r.getIngredients());
			m.setDate(r.getDate());
		}
		return rs.save(m);
	}

	@Override

	public Recipe getRecipesbyId(int rId) throws IdNotFoundException {
		Optional<Recipe> m = rs.findById(rId);
		if (!m.isPresent()) {
			logger.error("recipe with the Id {} is not in database", rId);
			throw new IdNotFoundException("Recipe Id not present!!");
		}
		logger.info("fetch all details of the recipe with the Id of {}", rId);
		return m.get();
	}

}
