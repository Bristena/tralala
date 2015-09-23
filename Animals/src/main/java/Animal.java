/**
 * Created by bristena.vrancianu on 9/2/2015.
 */
public class Animal {
    private String denumire;
    private int id;

    public Animal(int id, String denumire) {
        this.id = id;
        this.denumire = denumire;
    }

    public int getId() {
        return id;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "denumire='" + denumire + '\'' +
                ", id=" + id +
                '}';
    }
}
