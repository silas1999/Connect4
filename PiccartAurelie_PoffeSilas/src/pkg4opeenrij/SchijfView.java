/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4opeenrij;

import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
/*
 * @author Gebruiker
 */
public class SchijfView extends Region{
    /**
     * model van een schijf meegeven
     */
    private final Schijf model;
    
    /**
     * constructor voor schijfview 
     * @param model
     */
    public SchijfView(Schijf model){
        this.model = model;
        
        Color kleur;

        if (model.rood()){
            kleur = Color.RED;
        }
        else {
            kleur = Color.YELLOW;}
        
        Circle vorm = new Circle(40, kleur);
        getChildren().add(vorm);
       
        }
        
        
        
        
        
        
        
}

   