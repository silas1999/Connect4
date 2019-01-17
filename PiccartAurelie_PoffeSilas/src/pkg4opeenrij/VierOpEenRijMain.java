/*
 * Taakverdeling: Aurelie:65 /Silas: 35
 * Bronvermelding: 
 * http://www.halict.nl/lcinformatica/klas6/h18/h18_6.htm, 
 */
package pkg4opeenrij;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Gebruiker
 */
public class VierOpEenRijMain extends Application {
     @Override
    public void start(Stage stage) throws Exception {
        VierOpEenRij model = new VierOpEenRij();
        
        FXMLLoader lader = new FXMLLoader(getClass().getResource("FXML4OpEenRijView.fxml"));
        Parent root = lader.load();
        FXML4OpEenRijViewController controller = lader.getController();
        
        controller.setModel(model);
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

    