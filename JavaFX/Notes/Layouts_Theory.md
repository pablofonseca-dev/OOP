# Layouts Theory 

Layouts are container nodes. It provides simple approach to arrange nodes. 
JavaFX provides many default layouts. HBox, VBox, FlowPane, GridPane, Border Pane
are typical examples. Why so many layouts? Each layout provides option to place
element in a specific fashion. You may not see any difference for the first node
placed in these layouts. Insert second node to observe the difference. HBox 
arrange all the nodes horizonatlly, and VBox arrange them vertically. FlowPane
initially starts horizontally. As more nodes enter FlowPane, the will be adjusted into 
the next rows. FlowPane will also adjust nodes if scene is resized. One important thing 
about layouts is that they can contain other layouts. 
HBox, VBox and FlowPane don't limit the number of nodes that cand be placed in them. 
However, BorderPane splits the region into five parts. Top, Bottom, Left, Center and
Right. Each region is optional and can have different sizes. Each region can 
only have one node. Keep in mind that the node can be another layout that contain on 
or more child nodes. Grid Pane is a bit advanced layout, it divides the area into 
cells.The nodes can be placed in any cell by means of constraints. 
Various other contraints like cell sizes can be set. Grid Pane is very 
good for form based applications. There are various othe layouts that serve different purposes.


 