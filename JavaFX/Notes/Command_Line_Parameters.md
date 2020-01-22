# Using Command Line Parameters 

Time to see these concepts in practice. We shall to understand how to use command line
arguments by updating the previous program from where we left off. Let us create a 
traditional main method. It doesn't take to much to use the command line arguments. You 
may already be aware of how to use command line arguments. Args parameter of main 
method contains all the parameters. JavaFX Simplifies it even further by introducing
named and unnamed parameters to the mix. In order to use the new parameter's mechanism, 
you have to call Application.launch(args). Now, to use these parameters we can use 
getParameters.getName. getName method returns a map on which you can execute get method using name of 
the parameter. Let us read width and height from the command line. 
We have to compile and then enter the values in this format --height=200 --width=300


One important thing about named parameters is that the order does not matter. 
getParameters.getUnnamed returns list of parameters which doesn't have any name. 
getParameters.getRaw method returns list of all parameters. Try using these methods 
and explore their return values 
