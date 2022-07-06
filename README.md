# Simple Topology API


Topology Api Task built in java, where the api provides some functionality for dealing with Topology Jsons

Supported Functionalities:

- Read topology from JSON file
- write topology to JSON file
- Provided a list of topologies, get a list of topology Ids
- Delete a topology from list by Id
- Get a list of Components given a certain topology
- Get a list of device Ids for devices conected to a certain component's netlist given a certain topology and the desired component  


The project includes both automatic Unit tests (JUnit 5) and a manual test compiled to a jar file.

## To Run the Manual Test

 Open a command window and move to the Repository's Folder, in this folder you should find a topology.json and a SEI_T02_Topology.jar, Type this command in the cmd:
```
java -jar SEI_T02_Topology.jar
```


## License


    The MIT License (MIT)

    Copyright (c) 2022 Youssef Zakaria

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
    

