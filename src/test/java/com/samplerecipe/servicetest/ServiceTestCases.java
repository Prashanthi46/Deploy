package com.samplerecipe.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import java.time.LocalDate;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import com.samplerecipe.entity.RecipeEntity;
import com.samplerecipe.exceptions.NoRecipefoundException;
import com.samplerecipe.service.RecipeServiceInterface;
@SpringBootTest
public class ServiceTestCases {
	
	
	@Mock
	RecipeServiceInterface recipeservice;
	
	@Mock
	RecipeEntity r;
	
	@BeforeEach
	void startup() {
		MockitoAnnotations.openMocks(this);

		r = new RecipeEntity(1, "Chicken 65",true, "Starters", "Bit Spicy", LocalDate.of(2022,05,16),null);
	}
	
	@Test
	public void getallrecipes() throws NoRecipefoundException {		
		Mockito.when(recipeservice.getallrecipes()).thenReturn(Arrays.asList(r));
		assertEquals(Arrays.asList(r),recipeservice.getallrecipes());
		Mockito.verify(recipeservice,times(1)).getallrecipes();
	}
	
	
	
}
