package com.samplerecipe.service;

import java.util.List;
import com.samplerecipe.entity.RecipeEntity;
import com.samplerecipe.exceptions.IdNotFoundException;
import com.samplerecipe.exceptions.NoDataException;
import com.samplerecipe.exceptions.NoRecipefoundException;

public interface RecipeServiceInterface {
	public List<RecipeEntity> getallrecipes() throws NoRecipefoundException;
	public RecipeEntity addRecipes(RecipeEntity r);
	public String deleteRecipe(int rId) throws NoDataException;
    public RecipeEntity getRecipesbyId(int rId) throws IdNotFoundException; 
	public RecipeEntity updateRecipe(int rId,RecipeEntity r) ;

}
