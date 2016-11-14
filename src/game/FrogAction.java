/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import cm3038.search.Action;

/**
 *
 * @author plucarelli
 */
public class FrogAction extends Action{
    
    public int fromPosition;
    public int toPosition;
    public FrogColor color;

    public FrogAction(int frogPosition, int steps, FrogColor color) {
        this.fromPosition = frogPosition;
        this.toPosition = steps;
        this.color = color;
    }
   

    @Override
    public String toString() {
        String output = "";
        switch(color){
                case RED:
                    output += "Moving " + this.color + " frog from position " + 
                            fromPosition + " to position " + toPosition;
                    break;
                case GREEN:
                    output += "Moving " + this.color + " frog from position " + 
                            fromPosition + " to position " + toPosition;
                    break;
        }
        
        return output;
    }
    
    
    
}
