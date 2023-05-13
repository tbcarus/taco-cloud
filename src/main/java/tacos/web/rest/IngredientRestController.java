package tacos.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tacos.model.Ingredient;
import tacos.repository.IngredientRepository;

@RestController
@RequestMapping(path="/api/ingredients", produces="application/json")
@CrossOrigin(origins="http://localhost:8080")
public class IngredientRestController {

  private IngredientRepository ingredientRepository;

  @Autowired
  public IngredientRestController(IngredientRepository repo) {
    this.ingredientRepository = repo;
  }

  @GetMapping
  public Iterable<Ingredient> allIngredients() {
    return ingredientRepository.findAll();
  }

}
