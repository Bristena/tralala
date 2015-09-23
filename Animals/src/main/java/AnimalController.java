import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by bristena.vrancianu on 9/2/2015.
 */
@Controller
public class AnimalController {
    @RequestMapping("/animal/")
    public @ResponseBody List<Animal> getAnimals(){
        IRepositoryAnimal repo = new RepositoryAnimal();
       return repo.getAnimals();
    }

}
