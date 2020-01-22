We need to implement start method. Start method can be used to display the application queue. However, 
there is more to the life cycle of JavaFX Application. There are several stages in addition to start 
method. When we run a JavaFX Application JavaFX run-time calls init() method defined in application class. 
The Default init method is empty, givin you the choice of writing any inicialization statements that may be 
required for your application like opening a connection to a Database. It knows special initializations are 
required. There is no need to implement init method yourself. However, you wouln't have any reference to a 
stage object. Hece, this is no meant for constructing stage or scene. Once init method completes its execution, 
start() method will be called. As you've sen in the previus demo, start() method has a reference to a stage 
object which is a primary stage objet. We have to implement this method as this is an abstract method in 
Application Class. Once the stage and scene are constructed, the start method will have to make a call to 
Stage.show(). This is when the user sees the graphical user interface of the application. Once the 
application user interface is close by the user, stop method will be called. Just like init method, 
stop method is also an empty method by default. This provides a convenient placeholder to prepare for 
prepare for application exit and destroy resources. However, in addition to these init, start and stop methods,
you can also write main method to let the user pass command line arguments. Main method must pass the 
arguments to launch method so that they will be prepared for easy access through getParameters method. If 
we write a main method, this will be called before init