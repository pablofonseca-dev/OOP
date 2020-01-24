# Benefits of FXML

1. Scene Graph is more transparent in FXML and correlates easily 
with the hierarchical structure of an XML. It also becomes 
easy to maintain and test the applications 
developed using this approach. 

2. FXML is a file which is loaded 
at run time, hence there is no need to recompile after change. 
Any changes in FXML can be instantly verified by simply rerunning 
the application. 

3. FXML also provides ability to paramaterize attributes, which
enables localization through resource bundles. This makes it 
very easy to develop applications that can be translated into 
different languages without changing any code.

There are numerous other advantages as well. Many developers 
are familiar with this type of declarative UI development and 
JAVA FX coupled with FXML seems like any easy transition. As
FXML is not typed to JAVA alone, it can be used with any JVM 
language like Scala. As FXML is not a compiled language, we 
can develop third party tools that can understand and display
how the UI is going to look like even before the program
is run. **Scene Builder** is one such application. 