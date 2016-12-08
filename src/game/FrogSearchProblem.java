/*
 * CM3038 Artificial Intelligence for Problem Solving
 * Coursework - December 2016
 * -----------------------------------
 * Pierpaolo Lucarelli - 1400571
 * Robert Gordon University
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

    @Override // evaluation function: cost(n) + heuristic(n)
    public double evaluation(Node node){
        return node.getCost() + this.heuristic(node.state);   
    }
   
    
    public double heuristic(State state){
        double result = 0.0;
        char[] frogState = ((FrogsState)state).world;
        char[] frogGoal = ((FrogsState)this.goalState).world;
        // Iterate the current state and add 3 or 1 for every misplaecd frog 
        // Red = 3, Green = 1
        for(int i = 0 ; i < frogState.length ; i++){
            if(frogState[i] != '-' && frogState[i] != frogGoal[i])
                result += frogState[i] == 'R' ? 3 : 1;
        } 
        return result;
    }

    @Override
    public boolean isGoal(State state) {
        return state.equals(this.goalState);
    }
    
    //    Slower but more efficent heuristic that also considers distance from cloa sest goal state
    //    public double heuristic(State state){
    //    double result = 0.0;
    //    char[] frogState = ((FrogsState)state).world;
    //    char[] frogGoal = ((FrogsState)this.goalState).world;
    //    for(int i = 0 ; i < frogState.length ; i++){
    //       char frog = frogState[i];
    //        if(frog != '-'){
    //            if(frog == 'R'){
    //                for(int j = i ; j < frogGoal.length ; j++){
    //                    if(frog == frogGoal[j]){
    //                        int diff = Math.abs(i-j);
    //                        result += diff % 2 == 0 ? (diff/2) * 3 : (diff/2+1)*3;
    //                       break;
    //                    }
    //                }
    //            } else {
    //                for(int j = i ; j >= 0 ; j--){
    //                    if(frog == frogGoal[j]){
    //                        int diff = Math.abs(i-j);
    //                        result += diff% 2 == 0 ? (diff/2) : (diff/2+1);
    //                        break;
    //                    }
    //                }
    //            }
    //        }
    //    }
    //    return result;
    // }
    
}
