# marsrover
My solution to the famous MarsRover problem given by ThoughtWorks

The current implementation assumes that the plateau is a rectangular grid that
can accomodate more than one rover in the same cell. That is, one or more
rovers can occupy the same cell in the plateau. If this is not the case, then
the current Plateau implementation can be extended - specifically by adding a
new method 'isOccupied' to determine whether a grid is occupied and can be
called from Rover's 'canMove' method before making a 'move'.

Instructions
------------
mvn clean compile test ("To compile and run the tests")

or

mvn clean compile exec:java ("To run the main method")
