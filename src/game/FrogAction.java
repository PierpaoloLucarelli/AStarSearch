/*
 * CM3038 Artificial Intelligence for Problem Solving
 * Coursework - December 2016
 * -----------------------------------
 * Pierpaolo Lucarelli - 1400571
 * Robert Gordon University
 */
package game;

import cm3038.search.Action;

/**
 *
 * @author plucarelli
 */
public class FrogAction extends Action{
    
    // The position of the frog to be moved
    public int fromPosition;
    // The position where the frog will land
    public int toPosition;
    // The color rof the frog
    public FrogColor color;

    public FrogAction(int frogPosition, int steps, FrogColor color) {
        this.fromPosition = frogPosition;
        this.toPosition = steps;
        this.color = color;
        // assign 1 or 3 to the cost of the action depeding on frog color
        this.cost = color == FrogColor.RED ? 3 : 1;
    }
   
    @Override
    public String toString() {
        String output = "";
        switch(color){
                case RED:
                    output += "Moving " + this.color + " frog from position " + 
                            fromPosition + " to position " + toPosition;
                    output += "\nMove cost: " + this.cost;
                    break;
                case GREEN:
                    output += "Moving " + this.color + " frog from position " + 
                            fromPosition + " to position " + toPosition;
                    output += "\nMove cost: " + this.cost;
                    break;
        }    
        return output;
    }
    
    
    
}
