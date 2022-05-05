import org.json.JSONException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TopologyAPITest {
    //create a new instance of the Topology_Api
    Topology_Api api = new Topology_Api();

    @org.junit.jupiter.api.Test
    void readTopology() {

        //create a new topology
        Topology topology = null;

        topology = api.readTopology("topology.json");

        //check if the topology is not null
        assertNotNull(topology);

        //check if the topology has the correct name
        assertEquals("top1", topology.getId());

        //check if the topology has the correct number of components
        assertEquals(2, topology.getComponents().size());

        //check if the topology has the correct name of the components
        assertEquals("res1", topology.getComponents().get(0).getId());
        assertEquals("m1", topology.getComponents().get(1).getId());

        //check if the topology has correct netlist of the components
        try {
            assertEquals("vdd", topology.getComponents().get(0).getNetList().get("t1"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @org.junit.jupiter.api.Test
    void writeTopology() {
        //create a new topology
        Topology topology =  api.readTopology("topology.json");

        //check if the topology is not null
        assertNotNull(topology);

        //writing to file and checking if the file is created
        api.writeTopology(topology, "topology_new.json");
        assertTrue(new File("topology_new.json").exists());

        //reading the file and checking if the topology is the same
        Topology topology_new = api.readTopology("topology_new.json");
        assertEquals(topology.toString(), topology_new.toString());

    }

    @org.junit.jupiter.api.Test
    void getTopologyIds() {
        //create a list of topologies and add a new topology to it
        List<Topology> topologies = new ArrayList<>();
        topologies.add(api.readTopology("topology.json"));

        //get the topology ids
        List<String> topologyIds = api.getTopologyIds(topologies);

        //list of ids to assert
        List<String> ids = new ArrayList<>();
        ids.add("top1");

        //check if the topology ids are correct
        assertEquals(ids, topologyIds);
    }

    @org.junit.jupiter.api.Test
    void deleteTopology() {
        //create a list of topologies and add a new topology to it
        List<Topology> topologies = new ArrayList<>();
        topologies.add(api.readTopology("topology.json"));

        //delete the topology
        api.deleteTopology("top1", topologies);

        //check if the topology is deleted
        assertEquals(0, topologies.size());

    }

    @org.junit.jupiter.api.Test
    void getComponentIds() {

        //create a new topology
        Topology topology =  api.readTopology("topology.json");

        //get the component ids
        List<String> componentIds = api.getComponentIds(topology);

        //list of ids to assert
        List<String> ids = new ArrayList<>();
        ids.add("res1");
        ids.add("m1");

        //check if the component ids are correct
        assertEquals(ids, componentIds);

    }

    @org.junit.jupiter.api.Test
    void getDeviceIds() {

        //create a new topology
        Topology topology =  api.readTopology("topology.json");

        //get the device ids
        List<String> deviceIds = api.getDeviceIds(topology, "m1");

        //list of ids to assert
        List<String> ids = new ArrayList<>();
        ids.add("drain");
        ids.add("gate");
        ids.add("source");

        //check if deviceIds contains the correct ids in a for loop
        for (String id : ids) {
            assertTrue(deviceIds.contains(id));
        }

    }
}