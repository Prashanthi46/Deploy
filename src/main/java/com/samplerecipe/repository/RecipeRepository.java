package com.samplerecipe.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.samplerecipe.entity.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer>{




	

}
