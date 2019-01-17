/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4opeenrij;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FXML4OpEenRijViewController{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
   @FXML
   private BordView bordView;   //view != model
    
    @FXML
    private Button btnHerstart;
    
    private VierOpEenRij model;

    @FXML
    private AnchorPane spelPane;
    
    @FXML
    void handleButtonAction() {
        System.out.println("button clicked");
    }

    @FXML
    void initialize() {
        assert btnHerstart != null : "fx:id=\"btnHerstart\" was not injected: check your FXML file 'FXML4OpEenRijView.fxml'.";
        assert spelPane != null : "fx:id=\"spelPane\" was not injected: check your FXML file 'FXML4OpEenRijView.fxml'.";
        
        btnHerstart.setOnAction(event -> handleButtonAction());
        //spelPane.setOnMouseClicked(event -> handleMouseClick(event)); 
    }

    void setModel(VierOpEenRij model) {
        this.model = model;
        bordView = new BordView(model);
        spelPane.getChildren().add(bordView);
    }
    
    //public void handleMouseClick(MouseEvent mouseEvent) 



}
