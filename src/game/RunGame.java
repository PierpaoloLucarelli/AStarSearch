package game;

import cm3038.search.ActionStatePair;
import cm3038.search.Path;
import java.util.List;

public class RunGame {
    
    
    public static void main(String[] args){
        String start = "RRRR-GGGG";
        String goal = "GGGG-RRRR";
        
        FrogsState s = new FrogsState(start);
        FrogsState s2 = new FrogsState(goal);
        
        FrogSearchProblem game = new FrogSearchProblem(s, s2);
        Path result = game.search();
        
        if(result==null)
            System.out.println("No result");
        else{
            result.print();
            System.out.println("Nodes visited: "+game.nodeVisited);
            System.out.println("Cost: "+result.cost+"\n");
        }
    }
}
