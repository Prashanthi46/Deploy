package com.samplerecipe.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import com.samplerecipe.entity.Recipe;
import com.samplerecipe.exceptions.IdNotFoundException;
import com.samplerecipe.exceptions.NoDataException;
import com.samplerecipe.exceptions.NoRecipefoundException;
import com.samplerecipe.service.RecipeServiceInterface;
@SpringBootTest
public class ServiceTestCases {
	
	
	@Mock
	RecipeServiceInterface recipeservice;
	
	@Mock
	Recipe r;
	
	@BeforeEach
	void startup() {
		MockitoAnnotations.openMocks(this);

		r = new Recipe(1, "Chicken 65",true, "Starters", "Bit Spicy", LocalDate.of(2022,05,16),null);
	}
	
	@Test
	public void getallrecipes() throws NoRecipefoundException {		
		Mockito.when(recipeservice.getallrecipes()).thenReturn(Arrays.asList(r));
		assertEquals(Arrays.asList(r),recipeservice.getallrecipes());
		Mockito.verify(recipeservice,times(1)).getallrecipes();
	}
	

	@Test
	public void testgetRecipesbyId() throws IdNotFoundException {
		Recipe r2 = new Recipe(1, "Chicken 65",true, 
				"Starters", "Bit Spicy",
				LocalDate.of(2022,05,16),null);
		Mockito.when(recipeservice.getRecipesbyId(1)).thenReturn(r2);
		assertEquals(r2, recipeservice.getRecipesbyId(1));
		Mockito.verify(recipeservice).getRecipesbyId(1);
		}
	
	@Test
	public void testdeleteRecipe() throws NoDataException {
		Recipe r3 = new Recipe(1, "Chicken 65",true, "Starters", 
				"Bit Spicy", LocalDate.of(2022,05,16), null);
		when(recipeservice.deleteRecipe(r3.getRecipeId())).thenReturn("REMOVED");
		String status = recipeservice.deleteRecipe(1);
		assertEquals("REMOVED",status);

		}
	
	@Test
	public void testaddFeedBack() {
		Recipe r4 = new Recipe(1, "Chicken 65",true, 
				"Starters", "Bit Spicy",
				LocalDate.of(2022,05,16),null);
		  Mockito.when(recipeservice.addRecipes(r4)).thenReturn(r4);
		  assertEquals(r4,recipeservice.addRecipes(r4));
		  Mockito.verify(recipeservice).addRecipes(r4);
		  
		  }
	
	  
	
	
	
	
	
	
	
	
}
