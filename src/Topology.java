import java.util.List;

public class Topology {

    //A topology has an id and a List of electronic components that are connected together.
    private String id;
    private List<ElectronicComponent> components;

    //Constructor
    public Topology(String id, List<ElectronicComponent> components) {
        this.id = id;
        this.components = components;
    }

    //Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ElectronicComponent> getComponents() {
        return components;
    }

    public void setComponents(List<ElectronicComponent> components) {
        this.components = components;
    }

    //ToString
    @Override
    public String toString() {
        return "Topology\n{\n" +
                "id='" + id + "',\n" +
                "components= \n" + components +
                "\n}";
    }


}
