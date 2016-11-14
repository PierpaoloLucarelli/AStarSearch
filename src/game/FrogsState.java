package game;
import cm3038.search.*;
import java.util.ArrayList;
import java.util.List;

public class FrogsState implements State{
    
    public char[] world;

    public FrogsState(String world) {
        this.world = world.toCharArray();
    }
    
    public FrogsState(char[] frogWorld){
        this.world = new char[frogWorld.length];
        for(int i = 0 ; i < frogWorld.length ; i++){
            this.world[i] = frogWorld[i];
        }
    }
    
    

    @Override
    public List<ActionStatePair> successor() {
        List<ActionStatePair> result = new ArrayList<ActionStatePair>();
        for(int i = 0 ; i < this.world.length ; i++){
            char frog = this.world[i];
            if(frog != '-'){
                if(frog == 'R'){
                    if(this.canJumpOne(i, FrogColor.RED)){
                        ActionStatePair child = this.generateChild(i, i+1, FrogColor.RED);
                        result.add(child);
                    }else if(this.canJumpTwo(i, FrogColor.RED)){
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
    
    public FrogsState applyAction(FrogAction a){
        char[] resWorld = new char[this.world.length];
        // make copy of origin state
        for(int i = 0 ; i < this.world.length ; i++)
            resWorld[i] = this.world[i];
        char frog = resWorld[a.fromPosition];
        resWorld[a.toPosition] = frog;
        resWorld[a.fromPosition] = '-';
        
        FrogsState result = new FrogsState(resWorld);
        return result;
    }
    
    public boolean canJumpOne(int position, FrogColor color){
        boolean response;
        switch(color){
            case RED:
                if(position+1 <= this.world.length-1 && this.world[position + 1] == '-' )
                    response = true;
                else response = false;
                break;
            case GREEN:
                if(position-1 >= 0 && this.world[position - 1] == '-')
                    response = true;    
                else response = false;
                break;
            default:
                response = false;
        }
        return response;
    }
    
    public ActionStatePair generateChild(int from, int to, FrogColor color){
        FrogAction action = new FrogAction(from, to, color);
        FrogsState nextState = this.applyAction(action);
        return new ActionStatePair(action, nextState);
    }
    
    public boolean canJumpTwo(int position, FrogColor color){
        boolean response;
        switch(color){
            case RED:
                if(position + 2 <= this.world.length-1 && this.world[position + 2] == '-')
                    response = true;
                else response = false;
                break;
            case GREEN:
                if(position - 2 >= 0 && this.world[position - 2] == '-')
                    response = true;
                else response = false;
                break;
            default:
                response = false;
        }
        return response;
    }

    @Override
    public String toString() {
        String output ="";
        for(char c : this.world){
            output += c;
        }
        return output;
    }
    
    
    
}
