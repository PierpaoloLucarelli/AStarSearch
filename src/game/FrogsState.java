/*
 * CM3038 Artificial Intelligence for Problem Solving
 * Coursework - December 2016
 * -----------------------------------
 * Pierpaolo Lucarelli - 1400571
 * Robert Gordon University
 */
package game;
import cm3038.search.*;
import java.util.ArrayList;
import java.util.List;

public class FrogsState implements State{
    
    public char[] world;

    // constructor from string
    public FrogsState(String world) {
        this.world = world.toCharArray();
    }
    
    // constructor from char[]
    public FrogsState(char[] frogWorld){
        this.world = new char[frogWorld.length];
        System.arraycopy(frogWorld, 0, this.world, 0, frogWorld.length);
    }
    
    // generates all possible children states of the current state
    @Override
    public List<ActionStatePair> successor() {
        List<ActionStatePair> result = new ArrayList<>();
        for(int i = 0 ; i < this.world.length ; i++){
            char frog = this.world[i];
            if(frog != '-'){ // skip empty spaces
                if(frog == 'R'){
                    // check if frog can jump one space, if not then it may be able to jump two spaces
                    // if frog can jump one space then it means it cannot jump two spaces
                    if(this.canJumpOne(i, FrogColor.RED)){
                        ActionStatePair child = this.generateChild(i, i+1, FrogColor.RED);
                        result.add(child);
                    }else if(this.canJumpTwo(i, FrogColor.RED)){ //
                        ActionStatePair child = this.generateChild(i, i+2, FrogColor.RED);
                        result.add(child);
                    }
                } else if(frog == 'G'){
                    if(this.canJumpOne(i, FrogColor.GREEN)){
                        ActionStatePair child = this.generateChild(i, i-1, FrogColor.GREEN);
                        result.add(child);
                    }else if(this.canJumpTwo(i, FrogColor.GREEN)){
                        ActionStatePair child = this.generateChild(i, i-2, FrogColor.GREEN);
                        result.add(child);
                    }
                }
            }
        }
        return result;
    }
    
    // create the child action and state pair
    public ActionStatePair generateChild(int from, int to, FrogColor color){
        FrogAction action = new FrogAction(from, to, color);
        FrogsState nextState = this.applyAction(action);
        return new ActionStatePair(action, nextState);
    }
    
    // applies the changes to copy of the current state and returns child state
    public FrogsState applyAction(FrogAction a){
        char[] resWorld = new char[this.world.length];
        // make copy of origin state to not overwrite this state
        System.arraycopy(this.world, 0, resWorld, 0, this.world.length);
        char frog = resWorld[a.fromPosition];
        resWorld[a.toPosition] = frog; // move frog
        resWorld[a.fromPosition] = '-'; // replace frog with empty space
        
        FrogsState result = new FrogsState(resWorld);
        return result;
    }
    
    // check if frog can jump one space by checking if next space is empty and within boundaries
    public boolean canJumpOne(int position, FrogColor color){
        boolean response;
        switch(color){
            case RED: // if red check next space of frog
                response = position+1 <= this.world.length-1 && this.world[position + 1] == '-';
                break;
            case GREEN: // if green check previous space of frog
                response = position-1 >= 0 && this.world[position - 1] == '-';
                break;
            default:
                response = false;
        }
        return response;
    }
    
    // check if frog can jump one space by checking if second next space is empty and within boundaries
    public boolean canJumpTwo(int position, FrogColor color){
        boolean response;
        switch(color){
            case RED: // if red check second next space of frog
                response = position + 2 <= this.world.length-1 && this.world[position + 2] == '-';
                break;
            case GREEN: // if green check second previous space of frog
                response = position - 2 >= 0 && this.world[position - 2] == '-';
                break;
            default:
                response = false;
        }
        return response;
    }

    // generate hashcode, used to retirve from hashMap visited nodes
    @Override
    public int hashCode() {
        int hash = 0;
        for(int i = 0 ; i < this.world.length ; i++){
            if(this.world[i]=='R')
                hash += (i+1)*17;
            else if(this.world[i]=='G')
                hash += (i+1)*31;
            else
                hash += (i+1)*73;
        }
        return hash;
    }

    // test if two states are equal by comparing array content
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof FrogsState))
            return false;
        FrogsState frogsState = (FrogsState)obj;
        for(int i = 0 ; i < this.world.length ; i++ ){
            if(this.world[i] != frogsState.world[i])
                return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        String output = "";
        for(char c : this.world){
            output += c;
        }
        return output;
    }
    
    
    
}
