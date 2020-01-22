# Stage and Scene | Scene Graph Theory and Nodes 

Stage is a top level container which defines the entire space for the app. 
Every app has at least one stage. It is typically referred as primary stage. The
primary stage object is constructed by the Java runtime when we started the JavaFX
Application. We can see that the stage is a container for scenes, and also provides 
varius appearance related features like ability to always keep our application on 
top, open the application in the middle of the screen on startup, visibility size,
maximize, etcetera. Stage object acts as a mediator between the application and 
platform on which it is running. Scene is attached to a stage. A scene can be 
attached to only one stage and a stage can host one scene at a time. Scene is a 
container for nodes which comprise a scene graph. Nodes are the elements placed in a 
scene. Only one Node can be placed in a scene. However, there are nodes that can contain 
other nodes. So a parent node can contain multiple child nodes. All of them are 
subclasses of Node class. This forms a hierarchical data structure called Scene 
graph. They can be represented in a Tree Structure. The nodes that can act as a parent
node including root node can contain other nodes. There are varius container nodes in 
Java FX. HBox, VBox, GridPane and many more, these are typically called layouts. 
The leaf nodes that are intented for interacting or communicating with user are called 
controls. Text box, password fill, check box, radio button are examples for this 
leaf nodes, or in short, controls. 


