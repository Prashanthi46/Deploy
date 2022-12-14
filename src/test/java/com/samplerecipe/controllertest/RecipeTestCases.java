package com.samplerecipe.controllertest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.samplerecipe.controller.RecipeController;
import com.samplerecipe.entity.Recipe;
import com.samplerecipe.exceptions.IdNotFoundException;
import com.samplerecipe.exceptions.NoDataException;
import com.samplerecipe.exceptions.NoRecipefoundException;
import com.samplerecipe.service.RecipeServiceInterface;

public class RecipeTestCases {
	
	@InjectMocks
	RecipeController recipecontroller;
	@Mock
	RecipeServiceInterface rs;
	@Mock
	Recipe re;
	@Mock
	Recipe r;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void startup() {
		MockitoAnnotations.initMocks(this);
		r = new Recipe(1, "Chicken 65",true, "Starters", "Bit Spicy", LocalDate.of(2022,05,16), null);
	}
	
	@Test
	public void getallrecipes() throws NoRecipefoundException {
		Mockito.when(rs.getallrecipes()).thenReturn(Arrays.asList(re));
		assertEquals(Arrays.asList(re), recipecontroller.getallrecipes());
		Mockito.verify(rs).getallrecipes();
		}
	@Test
	public void testgetRecipesbyId() throws IdNotFoundException {
		Mockito.when(rs.getRecipesbyId(1)).thenReturn(re);
		assertEquals(re, recipecontroller.getRecipesbyId(1));
		Mockito.verify(rs).getRecipesbyId(1);
		}
	
	@Test
	public void testdeleteRecipe() throws NoDataException {
		Recipe r1 = new Recipe(1, "Chicken 65",true, "Starters", "Bit Spicy", LocalDate.of(2022,05,16), null);
		when(rs.deleteRecipe(r1.getRecipeId())).thenReturn("REMOVED");
		String status = rs.deleteRecipe(1);
		assertEquals("REMOVED",status);

		}
	
	@Test
	public void testaddFeedBack() {
		  Mockito.when(rs.addRecipes(re)).thenReturn(r);
		  assertEquals(r,recipecontroller.addRecipes(re));
		  Mockito.verify(rs).addRecipes(re);
		  
		  }
	
	@Test
	public void testupdateRecipe() throws IdNotFoundException {
		  Mockito.when(rs.updateRecipe(1, re)).thenReturn(r);
		  assertEquals(r,recipecontroller.updateRecipe(1, re));
		  Mockito.verify(rs).updateRecipe(1, re);
		  
		  }


	
	

}
