# Getting Started with FXML Technology

An XML based markup language for defining the user interface of a JAVA FX Application 

...FXML is a declarative XML based markup

FXML doesn´t have any schema, however, it does follow a predefined 
structure. 

## Code API Version

```java
	HBox box = new HBox();
	box.getChildren().addAll(
		new Label("User Name"), 
		new TextField(), 
		new Button("Connect")
	);	
```

## FXML Version 

###FXML Code
```fxml 
	<HBox> 
		<children> 
			<Label text="User Name" />
			<TextField />
			<Button text="Connect" />
		</children>
	</HBox>  
```

###Configuring FXML Code 
```java
	HBox box = FXMLLoader.<HBox>load(this.getClass().getResource("simpleui.fxml"));
```

Using an FXML approach usually involves using three components. 

1. **FXML Source**, this is the FXML file typically saved in the class path. It can declare UI Elements of 
an entire scene or part of the UI.
2. **FXML Loader**, utility class for loading an FXML file. It has many implementations of load method, 
using which we can load the FXML Source File to our application class.
3. **Controller** class, which can be used to write behaviors to the elements. We have not given any on 
click action to the buttons we created so far. We can do that and many more using Controller class with 
ease, however, writing action with us will be explained in future modules. We can specify a Controller 
class using FX ColumnController attribute of the root element in FXML file. This object is 
instantiaded by the FXMLLoader while loading the FXML file. Controller can contain references to UI elements 
defined in the corresponding nodes based on their fx:id attributes. We can mark these references using @FXML annotation. 
An FXML file can at most have one controller. Controller can be used to place all the event Handler methods of the elements in 
the FXML file. Controller class can contain an initialize method which will be executed once the FXML file is loaded. 
Controller's default constructor must be public, othewise FXML loader will fail to create a controller object and 
set references. 



