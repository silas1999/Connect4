/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4opeenrij;

import java.util.ArrayList;
import java.util.Iterator;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 *
 * @author Gebruiker
 */
public class BordView extends Region {

    /**
     * grootte van de vakjes
     */
    private static final int vakjeGrootte = 80;

    /**
     * aantal kolommen van het bord
     */
    private static final int aantKolommen = 7;

    /**
     * aantal rijen van het bord
     */
    private static final int aantRijen = 6;

    /**
     * welke kolom zitten we
     */
    private int kolom;

    private VierOpEenRij model;
    
    public int getKolom(int kolom){
        return kolom/7;
    }
    
    public int getRij(int rij){
        return rij/6;
    }

   
    

    /**
     * constructor for objects of class Bordview
     */
    /*public Parent BordView(){
     Pane root = new Pane();
        
     Shape rooster = maakRooster();
     root.getChildren().add(rooster);
     root.getChildren().addAll(maakBalken());
        
        
     return root;
     }*/
    public BordView(VierOpEenRij model) {
        this.model = model;
        update();
    }

    public void update() {
        Shape rooster = maakRooster();
        this.getChildren().add(rooster);
        this.getChildren().addAll(maakBalken());
        Iterator<Schijf> schijvenLijst = model.getSchijven();
        while (schijvenLijst.hasNext()){
            Schijf s = schijvenLijst.next();
            SchijfView sView = new SchijfView(s);
            sView.setTranslateX(60);
            sView.setTranslateY(60);
            this.getChildren().add(sView);
        }
    }
    

    /**
     * methode om het rooster te maken
     */
    public Shape maakRooster() {
        Shape bord = new Rectangle((aantKolommen + 1) * vakjeGrootte, (aantRijen + 1) * vakjeGrootte);
        for (int y = 0; y < aantRijen; y++) {
            for (int x = 0; x < aantKolommen; x++) {
                Circle cirkel = new Circle(vakjeGrootte / 2);
                cirkel.setCenterX(vakjeGrootte / 2);
                cirkel.setCenterY(vakjeGrootte / 2);
                cirkel.setTranslateX(x * (vakjeGrootte + 5) + vakjeGrootte / 4);
                cirkel.setTranslateY(y * (vakjeGrootte + 5) + vakjeGrootte / 4);

                bord = Shape.subtract(bord, cirkel);
            }
        }
        bord.setFill(Color.BLUE);

        return bord;
    }
    private ArrayList<Rectangle> balkenLijst;
    public BordView(){
        balkenLijst = new ArrayList<>();
        
   }
    
    public ArrayList<Rectangle> getBalk() {
        return balkenLijst;
    }
    /**
     * methode om transparante balken over de kolom te maken
     *
     * @return
     */
    public ArrayList<Rectangle> maakBalken() {
        ArrayList<Rectangle> lijst = new ArrayList<>();
        for (int x = 0; x < aantKolommen; x++) {
            Rectangle r = new Rectangle(vakjeGrootte, (aantRijen + 1) * vakjeGrootte);
            r.setTranslateX(x * (vakjeGrootte + 5) + vakjeGrootte / 4);
            r.setFill(Color.TRANSPARENT);

            r.setOnMouseEntered(e -> r.setFill(Color.rgb(200, 200, 50, 0.3)));
            r.setOnMouseExited(e -> r.setFill(Color.TRANSPARENT));

            lijst.add(r);
        }
        return lijst;
    }

    Schijf getSchijven() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
