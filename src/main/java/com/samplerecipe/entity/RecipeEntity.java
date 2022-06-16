package com.samplerecipe.entity;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class RecipeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	int recipeId;
	String recipeName;
	boolean isVeg;
	String recipeType;
	String instructions;
	LocalDate date;
	 
	@OneToMany(targetEntity = IngredientsEntity.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "fk", referencedColumnName = "recipeId")
	 public List<IngredientsEntity> ingredients;

	
	public int getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public boolean isVeg() {
		return isVeg;
	}

	public void setVeg(boolean isVeg) {
		this.isVeg = isVeg;
	}

	public String getRecipeType() {
		return recipeType;
	}

	public void setRecipeType(String recipeType) {
		this.recipeType = recipeType;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public List<IngredientsEntity> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<IngredientsEntity> ingredients) {
		this.ingredients = ingredients;
	}

	public RecipeEntity(int recipeId, String recipeName, boolean isVeg, String recipeType, String instructions,
			LocalDate date, List<IngredientsEntity> ingredients) {
		super();
		this.recipeId = recipeId;
		this.recipeName = recipeName;
		this.isVeg = isVeg;
		this.recipeType = recipeType;
		this.instructions = instructions;
		this.date = date;
		this.ingredients = ingredients;
	}

	public RecipeEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public String toString() {
		return "RecipeEntity [recipeId=" + recipeId + ", recipeName=" + recipeName + ", isVeg=" + isVeg
				+ ", recipeType=" + recipeType + ", instructions=" + instructions + ", date=" + date + ", ingredients="
				+ ingredients + "]";
	}
	
}
