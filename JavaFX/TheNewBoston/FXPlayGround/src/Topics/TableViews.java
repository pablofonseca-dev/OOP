package Topics;

import ApplicationBoot.ApplicationStopStage;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TableViews implements GetStages{
    public TableViews(Stage stage) throws Exception{
        this.getStage(stage);
    }

    @Override
    public void getStage(Stage stage) throws Exception {
        VBox root = new VBox();

        //The custom code goes here :)
        TableView<Product> table;
        table = new TableView<>();
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE); //Select Multiple Elements with SHIFT
        // Keyboard Key.
        //Text Fields
        TextField nameInput, priceInput, quantityInput;

        TableColumn<Product, String> productNameColumn = new TableColumn<>("Name");
        productNameColumn.setMinWidth(333);
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));


        TableColumn<Product, Double> productPriceColumn = new TableColumn<>("Price");
        productPriceColumn.setMinWidth(333);
        productPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Product, Integer> productQuantityColumn = new TableColumn<>("Quantity");
        productQuantityColumn.setMinWidth(333);
        productQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        //Name Input
        nameInput = new TextField();
        nameInput.setPromptText("Name");
        nameInput.setMinWidth(150);

        //Price Input
        priceInput = new TextField();
        priceInput.setPromptText("Price");
        priceInput.setMinWidth(150);

        //Quantity Input
        quantityInput = new TextField();
        quantityInput.setPromptText("Quantity");
        quantityInput.setMinWidth(150);

        //Create and Delete Buttons
        JFXButton addButton = new JFXButton("Add");
        addButton.setOnAction(actionEvent -> {
            addProduct(nameInput, priceInput, quantityInput, table);
        });

        JFXButton deleteButton = new JFXButton("Delete");
        deleteButton.setOnAction(actionEvent -> {
            deleteProduct(table);
        });

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10, 10, 10, 10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(
                nameInput,
                priceInput,
                quantityInput,
                addButton,
                deleteButton
        );

        table.setItems(getProducts());
        table.getColumns().addAll(
                productNameColumn,
                productPriceColumn,
                productQuantityColumn
        );

        root.getChildren().addAll(
                table,
                hBox
        );

        //Don't modify this if you don't fucking know what to do :)
        //Always remember to add a root layout.
        root.setSpacing(10);
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setAlignment(Pos.CENTER);
        JFXButton closeStage = new JFXButton();
        closeStage.setText("Close");
        closeStage.setOnAction(actionEvent -> {
            ApplicationStopStage.finishLifeCycle(stage);});
        root.getChildren().addAll(closeStage);
        Scene scene = new Scene(root);
        stage.setOnCloseRequest(windowEvent -> {
            windowEvent.consume();
            ApplicationStopStage.finishLifeCycle(stage);
        });
        stage.setTitle("This is the primary stage!");
        stage.setScene(scene);
    }

    //Is gonna get all of the products
    public ObservableList<Product> getProducts(){
        //FXCollections is a type of ObservableList where you can store objects.
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add(new Product("Camera", 1900.50, 1000));
        products.add(new Product("Smart Pen", 500.50, 100));
        products.add(new Product("Smart Watch", 600.50, 5000));
        products.add(new Product("Robot Clean", 190.50, 8000));
        products.add(new Product("iPhone XR Max", 1900.50, 50));
        return products;
    }

    public void addProduct(TextField name, TextField price, TextField quantity, TableView table){
        try {
            Product temporalProduct = new Product(name.getText(), Double.parseDouble(price.getText()), Integer.parseInt(quantity.getText()));
            table.getItems().add(temporalProduct);
            name.clear();
            price.clear();
            quantity.clear();
        }catch(NumberFormatException ignored){};
    }

    public void deleteProduct(TableView table){
        ObservableList<Product> productsSelected, allProducts = FXCollections.observableArrayList();
        allProducts = table.getItems();
        productsSelected = table.getSelectionModel().getSelectedItems(); //Return any items the user have selected
        productsSelected.forEach(allProducts::remove);
    }
}
