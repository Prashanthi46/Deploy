package com.samplerecipe.service;

import java.util.List;
import com.samplerecipe.entity.Recipe;
import com.samplerecipe.exceptions.IdNotFoundException;
import com.samplerecipe.exceptions.NoDataException;
import com.samplerecipe.exceptions.NoRecipefoundException;

public interface RecipeServiceInterface {
	public List<Recipe> getallrecipes() throws NoRecipefoundException;
	public Recipe addRecipes(Recipe r);
	public String deleteRecipe(int rId) throws NoDataException;
    public Recipe getRecipesbyId(int rId) throws IdNotFoundException; 
	public Recipe updateRecipe(int rId,Recipe r) ;

}
