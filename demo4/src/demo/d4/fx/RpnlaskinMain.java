package demo.d4.fx;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;


/**
 * @author Henri
 * @version 29.1.2021
 *
 */
public class RpnlaskinMain extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader ldr = new FXMLLoader(getClass().getResource("RpnlaskinGUIView.fxml"));
            final Pane root = ldr.load();
            //final RpnlaskinGUIController rpnlaskinCtrl = (RpnlaskinGUIController) ldr.getController();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("rpnlaskin.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("rpnlaskin");
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