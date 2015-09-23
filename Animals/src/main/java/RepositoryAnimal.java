import java.util.ArrayList;
import java.util.List;

/**
 * Created by bristena.vrancianu on 9/2/2015.
 */
public class RepositoryAnimal implements  IRepositoryAnimal {
    private List<Animal> list;
    public RepositoryAnimal (){
        list = new ArrayList<Animal>();
    }

    @Override
    public List<Animal> getAnimals() {

        Animal a1 = new Animal(1, "caine");
        Animal a2 = new Animal(2, "cal");
        Animal a3 = new Animal(3, "pisica");
        list.add(a1);
        list.add(a2);
        list.add(a3);
        return  list;
    }

    @Override
    public void delete(int id) {
        Animal a = getAnimalById(id);
        list.remove(a);
    }

    @Override
    public void update(int id,String denumire) {
        Animal a = getAnimalById(id);

        a.setDenumire(denumire);

    }

    @Override
    public Animal getAnimalById(int id) {
        for(int i=0;i<list.size();i++){
            if(list.get(i).getId() == id)
                return list.get(i);
        }
        return null;
    }

    @Override
    public void insert(Animal a) {
        list.add(a);
    }
}
