package tacos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import tacos.model.Ingredient;
import tacos.model.Ingredient.Type;
import tacos.model.Taco;
import tacos.model.User;
import tacos.repository.IngredientRepository;
import tacos.repository.TacoRepository;
import tacos.repository.UserRepository;

import java.util.Arrays;

@SpringBootApplication
public class TacoCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(TacoCloudApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner dataLoader(IngredientRepository ingredientRepository, UserRepository userRepository, PasswordEncoder passwordEncoder, TacoRepository tacoRepo) {
//        return args -> {
//            ingredientRepository.deleteAll(); // TODO: Quick hack to avoid tests from stepping on each other with constraint violations
//            ingredientRepository.save(new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
//            ingredientRepository.save(new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
//            ingredientRepository.save(new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
//            ingredientRepository.save(new Ingredient("CARN", "Carnitas", Type.PROTEIN));
//            ingredientRepository.save(new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES));
//            ingredientRepository.save(new Ingredient("LETC", "Lettuce", Type.VEGGIES));
//            ingredientRepository.save(new Ingredient("CHED", "Cheddar", Type.CHEESE));
//            ingredientRepository.save(new Ingredient("JACK", "Monterrey Jack", Type.CHEESE));
//            ingredientRepository.save(new Ingredient("SLSA", "Salsa", Type.SAUCE));
//            ingredientRepository.save(new Ingredient("SRCR", "Sour Cream", Type.SAUCE));
//            userRepository.deleteAll();
//            userRepository.save(new User("tbcarus", passwordEncoder.encode("qaz"), "fullName", "street", "Москва", "LA", "111223", "1234567890"));
//            userRepository.save(new User("user", passwordEncoder.encode("pass"), "FN", "Lenina", "Москва", "МО", "123455", "0987654321"));
//        };
//    }
}
