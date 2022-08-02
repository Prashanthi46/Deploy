package com.samplerecipe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.samplerecipe.entity.Recipe;
import com.samplerecipe.exceptions.IdNotFoundException;
import com.samplerecipe.exceptions.NoDataException;
import com.samplerecipe.exceptions.NoRecipefoundException;
import com.samplerecipe.service.RecipeServiceInterface;

import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
public class RecipeController {
	@Autowired
	RecipeServiceInterface rs;

	@GetMapping("/showAllRecipes") // viewall
	@ApiOperation(value = "Show all recipes", httpMethod = "GET")
	public List<Recipe> getallrecipes() throws NoRecipefoundException {

		return rs.getallrecipes();
	}

	@GetMapping("/recipes/{rId}") // getbyid
	@ApiOperation(value = "get recipes  through their id's", httpMethod = "GET")
	public Recipe getRecipesbyId(@PathVariable("rId") int rId) throws IdNotFoundException {

		return rs.getRecipesbyId(rId);
	}

	@PostMapping("/createrecipes") // add
	@ApiOperation(value = "add recipes", httpMethod = "POST")
	public Recipe addRecipes(@RequestBody Recipe r) {

		return rs.addRecipes(r);
	}

	@DeleteMapping("/recipes/{rId}") // delete
	@ApiOperation(value = "delete recipes", httpMethod = "DELETE")
	public String deleteRecipe(@PathVariable("rId") int rId) throws NoDataException {
		rs.deleteRecipe(rId);
		return "Deleted Successfully";
	}

	@PutMapping("/updaterecipe/{rId}") // update
	@ApiOperation(value = "update the recipe", httpMethod = "PUT")
	public Recipe updateRecipe(@PathVariable("rId") int rId, @RequestBody Recipe r) {
		return rs.updateRecipe(rId, r);
	}
}
