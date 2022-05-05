import java.util.Map;

public class ElectronicComponent {
    // The electronic component has a type, an id, a netList, a property (resistance, capacitance, etc.)

    private String type;
    private String id;
    //a netlist map that can be accessed by a key string
    private Map<String, Map<String,String>> netList;
    private Map<String, Map<String,String>> property;

    // Constructors
    public ElectronicComponent(String type, String id, Map<String, Map<String,String>> netList, Map<String, Map<String,String>> property) {
        this.type = type;
        this.id = id;
        this.netList = netList;
        this.property = property;
    }
    public ElectronicComponent(String type, String id) {
        this.type = type;
        this.id = id;
    }
    public ElectronicComponent(String type, String id, Map<String, Map<String,String>> netList) {
        this.type = type;
        this.id = id;
        this.netList = netList;
    }

    // Getters
    public String getType() {
        return type;
    }
    public String getId() {
        return id;
    }
    public Map<String, Map<String,String>> getNetList() {
        return netList;
    }
    public Map<String, Map<String,String>> getProperty() {
        return property;
    }

    // Setters
    public void setType(String type) {
        this.type = type;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setNetList(Map<String, Map<String,String>> netList) {
        this.netList = netList;
    }
    public void setProperty(Map<String, Map<String,String>> property) {
        this.property = property;
    }

    // toString
    public String toString() {
        return "ElectronicComponent [type=" + type + ", id=" + id + ", netList=" + netList + ", property=" + property + "]";
    }

}
