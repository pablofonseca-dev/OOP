package Topics;

import ApplicationBoot.ApplicationStopStage;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
        TableColumn<Product, String> productNameColumn = new TableColumn<>("Name");
        TableColumn<Product, Double> productPriceColumn = new TableColumn<>("Price");
        TableColumn<Product, Integer> productQuantityColumn = new TableColumn<>("Quantity");
        productNameColumn.setMinWidth(200);
        productPriceColumn.setMinWidth(200);
        productQuantityColumn.setMinWidth(200);
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        productPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        productQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        table = new TableView<>();
        table.setItems(getProducts());
        table.getColumns().addAll(
                productNameColumn,
                productPriceColumn,
                productQuantityColumn
        );
        root.getChildren().addAll(table);
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
        stage.initStyle(StageStyle.TRANSPARENT);
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
}
