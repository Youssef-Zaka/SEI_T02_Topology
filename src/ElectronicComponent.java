import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Map;

public class ElectronicComponent {
    // The electronic component has a type, an id, a netList, a property (resistance, capacitance, etc.)

    private String type;
    private String id;
    //a netlist JSONArray that can be accessed by a key string
    private JSONObject netList;
    //a property JSONArray that can be accessed by a key string
    private JSONObject property;

    // Constructor
    public ElectronicComponent(String type, String id,  JSONObject netList) {
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
    public JSONObject getNetList() {
        return netList;
    }
    // toString
    @Override
    public String toString() {
        return "ElectronicComponent{\n" +
                "type='" + type + "',\n" +
                "id='" + id + "',\n" +
                "netList= \n" + netList +
                "\n}";
    }

}
