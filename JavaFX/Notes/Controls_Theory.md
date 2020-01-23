# Controls 

Specialized nodes that are suited for reuse in different 
application contexts and mainly intended for interacting 
and communicating with Users. 

The following elements are controls: 
TextField, Button, CheckBox, ComboBox, Table, ProgressBar. 

Label is a simple control which can be create by instantiating
label class in JavaFX.scene.control package. It is just intended for 
displaying some text beside other controls to indicate
what control is for.

## Label 

### Class
* javafx.scene.control.Label
### User Interaction 
* Non editable content 
### Accessing from code 
1. **setText()** to change label text 
2. **setCursor()** to set cursor icon 
3. **setGraphic()** to use an image as label

## Text Field 

### Class
* javafx.scene.control.TextField

### User Interaction 
* Accepts textual input from user

### Accesing from code 

1. **getText()** method returns text 
2. **setText()** to set value programatically
3. **setPromptText("Enter name.")** text when field is empty 
..* We can write validators

### Variations

* Password Field is a variation of Text Field tha hides 
the characters typed into it. 

## Combo Box 

### Class
* javafx.scene.control.ComboBox 

### User Interaction 
* Lets user choose from list of values 

### Accessing from code 
1. **getItems().addAll()** to add options
2. **setValue()** to selects a value 
3. **getValue()** returns selected value

### Variations 
* ChoiceBox: ChoiceBox object instantiation is pretty strightforward. Created with the 
default constructor. Add list of values as strings, and add it to any layout as you
work for any other control. If you want to set the value programmatically, call 
the setValue method. 

## Check Box 

### Class

* javafx.scene.control.CheckBox 

### User Interaction 

* Delselect or select 

### Accesing from code

1. **setSelected()** to change state
2. **getSelected()** method will return current state. 
3. **setIndeterminate(true)**

JavaFX provides an advanced CheckBox that can have three
states insted of just two. We just need to set the indeterminate value 
to true, by calling set indeterminate method with true as parameter. 

CheckBox can be created without any label calling default constructor. 
Or you can pass the string to the constructor while creating the object. 
If we want to change the text, we can call set text method. To change
the state, call **setSelected()** method. Passing true to **setSelect()**
method will selected the CheckBox, false will uncheck it. 

## Table View 

Table View is a control, as well as a container.
It can contain other nodes. Also, user interact with 

### Class

* javafx.scene.control.TableView

### User Interaction 

* Select rows, cells, reorder, sort and many more. 

## Accessing from code

1. **setEditable()** to change read only status 
2. **getColumns().addAll()** to add columns 
3. **setCellFactory()** for complicated cells

## Other Controls

### Progress Bar Control

Progress Bar is for showing the progress to the user. 

### Spinner 

Is for letting the user change values incrementally.
