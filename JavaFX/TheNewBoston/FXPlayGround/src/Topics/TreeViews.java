package Topics;

import ApplicationBoot.ApplicationStopStage;
import com.jfoenix.controls.JFXButton;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TreeViews implements GetStages{

    public TreeViews(Stage stage) throws Exception{
        this.getStage(stage);
    }

    TreeView<String> treeView;
    @Override
    public void getStage(Stage stage) throws Exception {
        VBox root = new VBox();

        TreeItem<String> treeRoot, bucky, megan;

        //Root> Container for all our branches.
        treeRoot = new TreeItem<>();
        treeRoot.setExpanded(true);

        //Bucky Branch
        bucky = makeBranch("Bucky", treeRoot);
        makeBranch("TheNewBoston", bucky);
        makeBranch("YouTube", bucky);
        makeBranch("Chicken", bucky);


        //Megan Branch
        megan = makeBranch("Megan", treeRoot);
        makeBranch("Hello Dolly", megan);
        makeBranch("Lorem Ipsum", megan);
        makeBranch("Integer Overflow", megan);

        //Create Tree
        treeView = new TreeView<String>(treeRoot);
        treeView.setShowRoot(false); //Force the user to expand the tree :)
        treeView.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            if(newValue != null){
                System.out.println(newValue.getValue());
            }
        });
        root.getChildren().addAll(treeView);


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

    private TreeItem<String> makeBranch(String name, TreeItem<String> parentTreeRoot){
        TreeItem<String> item = new TreeItem<>(name);
        item.setExpanded(true);
        parentTreeRoot.getChildren().add(item);
        return item;
    }
}
