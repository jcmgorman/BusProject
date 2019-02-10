Project4
By: Jonathan Gorman
	with help from Dr. Dovolis at the University of Minnesota
Email: gorma232@umn.edu

Instructions for running Project4
	1. Open the command line and navigate to the folder with Project4
	2. Compile code and run
	3. Enter in the load of the simulation and the length of time you want the simulation to run
	4. The simulation will run through all the combinations of small and large buses. The simulation will then output different situations that have a positive profit.
	5. Do change different variables, navigate to the runSim function in Project4 class,
	   there different variables can be changed to alter the behavior of the simulation
	6. If you would like to see every situation that results in a positive profit change the displayAllData boolean variable to true.

Overview of Project4 organization and hierarchy
	For the simulation a priority queue was used to simulate the passage of time. A passenger arrival event was used to model when passengers arrive at a bus stop and wait in line. Certain stops had a higher frequency of 	passengers arriving to simulate downtown stops. The arrival event would schedule a new passenger event to keep the simulation running. The passenger class was used to store statistics of the passengers such as time on the bus, time off the bus, and stop to get off at. A bus arrival even was used to model what happens when a bus arrives at bus stop. The time the bus was at a bus stops was calculated by counting the time for 	passangers to get off and on the bus and the time to drive to the next stop. A new bus event was scheduled at the next stop to happen at the time in the future that was calculated. 

	The stop class stores two queues of passengers in an array to represent each stop on the route on the east and west bound stops. Since the last stops on each side of the east and west bound can't go any further the 		number of bus stops is 18 rather than 20. At the end of simulation if the stats collected through the bus and passengers were stored in a SimulationStats class if the profit that was generated from the runSim was positive. Then if the stats collected were better than one of the optimized solutions then it will replace the data in that pointer. 

Data structures and algorithms
	An array was used to store the queues of passengers because there is a known amount of stops and it makes pulling a stack for other functions an O(1) operation which helps to optimize the simulation.
	An array was also used in the bus class to simulate seats on the bus. This was good structure to use because there was a known number of seats. 
	A simulation stat class was used to be able to keep track of the stats gathered from running all the different combinations of small and large buses and be able to keep track of the best case scenarios that 	were found. 
	The RunSim function and algorithm was a good option because it allows for the simulation to be run with every possible combination of small and large buses easily by being able to send the function different values instead of having to manuly run every combination.
	To test to see if buses were clumping the timeline of bus events was printed out and if the buses events at the same spot were getting close together then clumbing was happening. To try and fix this the buses were added to the agenda a certain time distance apart to simulate the buses driving to route after leaving the bus depot. 

Known Bugs and Issues
	Sometiems buses can still clump up if the sumulation is ran for long enough.


