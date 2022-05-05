import java.util.ArrayList;
import java.util.List;

//a class to test the Topology_Api
public class ManualAPITest {
    public static void main(String[] args) {

        //Topology object
        Topology topology = null;

        //List of topologies
        List<Topology> topologies = new ArrayList<Topology>();

        //create a new instance of the Topology_Api
        Topology_Api api = new Topology_Api();

        //Testing reading the topology from the file
        //
        //read the topology from the file topology.json
        topology = api.readTopology("topology.json");

        System.out.println("Reading Topology from file: ");

        //print the topology
        System.out.println(topology);

        //Testing writing the topology to the file
        //
        //write the topology to the file topology_new.json
        api.writeTopology(topology, "topology_new.json");

        System.out.println("Done Writing Topology to file:  topology_new.json ");

        //add the topology to the list of topologies
        topologies.add(topology);

        //Testing Topology query about topologies in the system
        //
        //get the ids of all topologies in the list
        List<String> ids = api.getTopologyIds(topologies);

        System.out.println("Getting the ids of all topologies in the list: ");

        //print the ids
        System.out.println(ids);

        //create a new temp list of topologies
        System.out.println("Creating a new temp list of topologies: ");
        List<Topology> temp = new ArrayList<Topology>(topologies);

        //Testing deletion of topologies
        //
        //delete the topology from the list
        api.deleteTopology(topology.getId(), temp);

        System.out.println("Deleting the topology from temp list: ");

        //print the topology
        System.out.println(temp);

        //Testing Topology query about components in a topology
        //
        //get the ids of all components in the topology
        List<String> componentIds = api.getComponentIds(topology);

        System.out.println("Getting the ids of all components in the topology: ");

        //print the ids
        System.out.println(componentIds);

        //Testing Topology query about devices connected to a component's netList
        //
        //get the ids of all devices connected to the component's netList
        List<String> deviceIds = api.getDeviceIds(topology, "m1");

        System.out.println("Getting the ids of all devices connected to the component m1's netList: ");

        //print the ids
        System.out.println(deviceIds);

        waitForUserInput();

    }

    //wait for user input to exit
    public static void waitForUserInput() {
        System.out.println("Press enter to exit...");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
