/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg4opeenrij;

import java.util.ArrayList;
import java.util.Iterator;
import javafx.geometry.Point2D;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author Gebruiker
 */ 
public class VierOpEenRij {
  /**
   * de hoeveelste kolom van de schijf
   */
  private int kolom;
  /**
   * de hoeveelste rij van de schijf in het rooster
   */
  private int rij;
  /**
   * 2D array van de schijven vormen het rooster
   */
  private Schijf [][] rooster = new Schijf[kolom][rij];  
  private ArrayList<Schijf> schijvenLijst;
  /**
   * aantal kolommen in rooster
   */
  private int aantKolommen = 7; 
  /**
   * aantal rijen in rooster
   */ 
  private int aantRijen =6;
  /**
   * is het de beurt aan rood
  */
  private boolean beurtRood=true; 
 
  /**
  * constructor for objects of class VierOpEenRij
  */
   public VierOpEenRij(){
   schijvenLijst = new ArrayList<>();
   schijvenLijst.add(new Schijf(true));
   }
   /**
   * getter voor coordinaten van vakje van schijf
     * @param kolom
     * @param rij
     * @return 
   */
   public Optional <Schijf> getSchijf(int kolom, int rij) {
       if (kolom<0 || kolom>= aantKolommen || rij<0 ||rij>aantRijen){
           return Optional.empty();
       }
       else return Optional.ofNullable(rooster[kolom][rij]);
     
   }

    public Iterator<Schijf> getSchijven() {
        return schijvenLijst.iterator();
    }
   
   
   /**
    * methode om een schijf te gooien 
    * @param s
    * @param kolom 
    */
    public void gooiSchijf(Schijf s, int kolom){
      int rijSchijf = aantRijen -1;
      do{
          if (!getSchijf(kolom, rijSchijf).isPresent())
              break;
          
          rijSchijf --;   
        } 
        while (rijSchijf==0);
        if (rijSchijf<0){
          return;
        }
      rooster[kolom][rijSchijf]= s;
      beurtRood =!beurtRood;
      }
    
    /**
     * methode om einde van een spel te bepalen, maw of er al 4 op een rij is
     * @param kolom
     * @param rij
     * @return 
     */
  
public boolean spelEinde(int kolom, int rij){
        List<Point2D> verticaal = IntStream.rangeClosed(rij - 3, rij + 3)
                .mapToObj(r -> new Point2D(kolom, r))
                .collect(Collectors.toList());
        
        List<Point2D> horizontaal = IntStream.rangeClosed(kolom - 3, kolom + 3)
                .mapToObj(c -> new Point2D(c, rij))
                .collect(Collectors.toList());
        
        Point2D linksBoven = new Point2D(kolom - 3, rij - 3);
        List<Point2D> diagonaal1 = IntStream.rangeClosed(0, 6)
                .mapToObj(i -> linksBoven.add(i, i))
                .collect(Collectors.toList());
        
        Point2D linksOnder = new Point2D(kolom - 3, rij + 3);
        List<Point2D> diagonaal2 = IntStream.rangeClosed(0, 6)
                .mapToObj(i -> linksOnder.add(i, -i))
                .collect(Collectors.toList());
    
        return controle(verticaal) || controle(horizontaal)
                || controle(diagonaal1) || controle(diagonaal2);
    }

/**
 * methode om te contoleren of er 4 op een rij is 
 * @param puntjes
 * @return 
 */
public boolean controle(List<Point2D> puntjes){
        int opEenRij = 0;
        for(Point2D p : puntjes){
            int kolomX = (int) p.getX();
            int rijY = (int) p.getY();
            
            Schijf schijf = getSchijf(kolomX, rijY).orElse(new Schijf(!beurtRood));
            if(schijf.rood == beurtRood){
                opEenRij++;
                if(opEenRij == 4){
                    return true;
                }
            } else {
                opEenRij = 0;
            }
        }
        return false;
    }
}
	