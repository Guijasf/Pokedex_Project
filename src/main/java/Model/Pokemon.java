package Model;

public class Pokemon {
    private String name;
    private int id;
    private int weight;

    public String getName() { return name; }
    public int getId() { return id; }
    public double getWeightKg() { return weight / 10.0; }

    @Override
    public String toString() {
        return String.format("Nº %d - %s (%.1f kg)", id, name.toUpperCase(), getWeightKg());
    }
}