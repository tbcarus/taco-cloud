package tacos.web.rest;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
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

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @PreAuthorize("hasRole('USER')")
  public Ingredient saveIngredient(@RequestBody Ingredient ingredient) {
    return ingredientRepository.save(ingredient);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
//  @PreAuthorize("hasRole('ADMIN')")
  public void deleteIngredient(@PathVariable String id) {
    ingredientRepository.deleteById(id);
  }

}
