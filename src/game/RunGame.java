/*
 * CM3038 Artificial Intelligence for Problem Solving
 * Coursework - December 2016
 * -----------------------------------
 * Pierpaolo Lucarelli - 1400571
 * Robert Gordon University
 */
package game;

import cm3038.search.Path;

public class RunGame {

    public static void main(String[] args) {
        // chose the starting and goal state
        String start = "GG-GRRR";
        String goal  = "GGG-RRR";

        // generate states form start and goal
        FrogsState startState = new FrogsState(start);
        FrogsState goalState = new FrogsState(goal);

        System.out.println("Initial State: " + startState);
        System.out.println("Goal State: " + goalState + "\n\n");

        // run the search problem
        FrogSearchProblem game = new FrogSearchProblem(startState, goalState);
        Path result = game.search();

        if (result == null) // no result
        {
            System.out.println("No result");
        } else { // result found
            System.out.println("Nodes visited: " + game.nodeVisited);
            System.out.println("Cost: " + result.cost + "\n");
            result.print();
        }
    }
}
