package demo.d3.fx;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;


/**
 * @author Henri
 * @version 27.1.2021
 *
 */
public class HuoneMain extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader ldr = new FXMLLoader(getClass().getResource("HuoneGUIView.fxml"));
            final Pane root = ldr.load();
            //final HuoneGUIController huoneCtrl = (HuoneGUIController) ldr.getController();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("huone.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("Huone");
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args Ei k�yt�ss�
     */
    public static void main(String[] args) {
        launch(args);
    }
}