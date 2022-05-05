

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class Topology_Api {
    
    //method that reads a topology from a json file and returns a topology object
    //input: file name
    //output: topology object
    public static Topology readTopology(String fileName) {
        Topology topology = null;
        //read file contents as a string
        try {
            String fileContents = new String(Files.readAllBytes(Paths.get(fileName)));
            JSONObject json = new JSONObject(fileContents);
            String id = json.getString("id");
            JSONArray allComponentsJson = json.getJSONArray("components");

            //a list of components to be added to the topology
            List<ElectronicComponent> components = new ArrayList<ElectronicComponent>();
            //for each component in the json array, create a component object and add it to the topology
            for (int i = 0; i < allComponentsJson.length(); i++) {
                JSONObject componentJson = allComponentsJson.getJSONObject(i); //get the component json object
                String componentId = componentJson.getString("id"); //get the component id
                String componentType = componentJson.getString("type"); //get the component type
                //get the component's JSONArray netList
                JSONObject netListJson = componentJson.getJSONObject("netlist");
                //create a new component object
                ElectronicComponent component = new ElectronicComponent(componentType, componentId, netListJson);
                //add component to the list
                components.add(component);
            }

            //TODO: add the component's properties (ex: resistance) to the topology , depends on the component type

            //create a new topology object
            topology = new Topology(id, components);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return topology;
    }

    //method that writes a topology to a json file
    //input: topology object, file name
    //output: void
    public static void writeTopology(Topology topology, String fileName) {
        //create a new JSONObject
        JSONObject json = new JSONObject();
        try {

            //create a new JSONArray to hold the components
            JSONArray componentsJson = new JSONArray();
            //for each component in the topology, add it to the JSONArray
            for (ElectronicComponent component : topology.getComponents()) {
                JSONObject componentJson = new JSONObject();
                //create a new JSONObject to hold the component's netlist
                JSONObject netListJson = new JSONObject();
                netListJson = component.getNetList();
                //add the component's netlist to the JSONObject
                componentJson.put("netlist", netListJson);
                //add the component to the JSONArray
                componentsJson.put(componentJson);
                componentJson.put("id", component.getId());
                componentJson.put("type", component.getType());
            }
            //add the components to the JSONObject
            json.put("components", componentsJson);
            //add the topology's id to the JSONObject
            json.put("id", topology.getId());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //write the JSONObject to the file

        try {
            FileWriter file = new FileWriter(fileName); //create a new file writer
            file.write(json.toString()); //write the JSONObject to the file
            file.flush(); //flush the file
            file.close(); //close the file
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    //method that returns a list of all the ids of topologies in a list
    //input: List of topologies
    //output: List of topology ids
    public List<String> getTopologyIds(List<Topology> topologies) {
        List<String> topologyIds = new ArrayList<>();
        for (Topology topology : topologies) {
            topologyIds.add(topology.getId());
        }
        return topologyIds;
    }

    //method that deletes a topology from a list given the topology ID and the list
    //input: topology id, list of topologies
    //output: void
    public void deleteTopology(String topologyId, List<Topology> topologies) {
        for (Topology topology : topologies) {
            if (topology.getId().equals(topologyId)) {
                topologies.remove(topology);
                break;
            }
        }
    }

    //method that returns a list of all components in a topology
    //input: topology object
    //output: list of ids of components
    public List<String> getComponentIds(Topology topology) {
        List<String> componentIds = new ArrayList<>();
        for (ElectronicComponent component : topology.getComponents()) {
            componentIds.add(component.getId());
        }
        return componentIds;
    }

    //method that returns list of devices connected to netlist of a component
    //input: topology object, component id
    //output: list of device ids
    public List<String> getDeviceIds(Topology topology, String m1) {
        List<String> deviceIds = new ArrayList<>();
        for (ElectronicComponent component : topology.getComponents()) {
            if (component.getId().equals(m1)) {
                for (Iterator it = component.getNetList().keys(); it.hasNext(); ) {
                    String deviceId = it.next().toString();
                    deviceIds.add(deviceId);
                }
            }
        }

        //TODO: Return list of devices instead of device IDs, by creating a new Device class
        return deviceIds;
    }
}
