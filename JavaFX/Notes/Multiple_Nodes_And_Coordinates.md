# Adding Multiple Nodes in Children

All nodes added to the group are by default added at coordinates zero comma zero. Which happens to the top left corner of the container. In order to fix this, let us separate the creation of button objects, and name them b1 and b2. To fix the issue, all we have to do is give coordinates to one of them. However the problem with the coordinates 
is that the elementsare placed at the space five coordinates, irrespective of 
size of other elements. This will present a problem in dynamic situations. 
Coordinates base placement of nodes doesn't solve all the problems. We have to 
use layouts in order to fix this problem and make aware of the placement 
of other nodes. 

To make our application float on top of all other applications we can use
the method setAlwaysOnTop

setResizable prevents from changing the width and height
