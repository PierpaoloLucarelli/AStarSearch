/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import cm3038.search.Node;
import cm3038.search.State;
import cm3038.search.informed.BestFirstSearchProblem;

/**
 *
 * @author plucarelli
 */
public class FrogSearchProblem extends BestFirstSearchProblem{

    public FrogSearchProblem(State start, State goal) {
        super(start, goal);
    }

    @Override
    public double evaluation(Node node) {
        return node.getCost() * this.heuristic(node.state);   
    }
    
    public double heuristic(State state){
        double result = 0.0;
        char[] frogState = ((FrogsState)state).world;
        char[] frogGoal = ((FrogsState)this.goalState).world;
        
        for(int i = 0 ; i < frogState.length ; i++){
            if(frogState[i] != '-' && frogState[i] != frogGoal[i])
                result += frogState[i] == 'R' ? 1 : 1;
        } 
        return result;
    }

    @Override
    public boolean isGoal(State state) {
        return state.equals(this.goalState);
    }
    
}
