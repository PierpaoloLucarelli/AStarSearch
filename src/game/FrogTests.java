/*
 * CM3038 Artificial Intelligence for Problem Solving
 * Coursework - December 2016
 * -----------------------------------
 * Pierpaolo Lucarelli - 1400571
 * Robert Gordon University
 */
package game;

import cm3038.search.ActionStatePair;
import java.util.List;

public class FrogTests {
    public static void main(String[] args){
        // create test start and tets goal
        String start = "RRR-GGG";
        String goal =  "GGG-RRR";
        
        FrogsState s = new FrogsState(start);
        FrogsState s2 = new FrogsState(goal);
        
        // test the state toString method
        System.out.println("toString test\n----------------\n");
        System.out.println("Start state is : " + s);
        System.out.println("Goal state is: " + s2);
        
        // test the hashcode function
        System.out.println("\nHashCode test:\n------------\n");
        System.out.println("hash code for start is : " + s.hashCode());
        System.out.println("hash code for goal is : " + s2.hashCode());
        
        // test the apply action function
        // move green frog from position 1 to 3
        FrogAction a = new FrogAction(1, 3, FrogColor.GREEN);
        System.out.println("\nCreate and apply action test:\n----------------\n");
        System.out.println(a);
        System.out.println(s2.applyAction(a));

        // test the can jump methods
        int frogPos = 5;
        FrogColor col = FrogColor.GREEN;
        boolean result = s2.canJumpOne(frogPos, col);
        System.out.println("\nTest the can jump methods\n----------------\n");
        System.out.println("Can " + col + " frog at position "+ frogPos + " jump one space?");
        System.out.println(result);
        if(!result){ // if it cannot jump one spaces then check if ti can jump two
            System.out.println("Can " + col + " frog at position "+ frogPos + " jump two spaces?");
            System.out.println(s2.canJumpTwo(5, col) + "\n");
        } else System.out.println("False");
        
        
        // tets the successor function
        System.out.println("\nTest the successor method\n-----------------\n");
        List<ActionStatePair> children = s.successor();
        System.out.println("Child states of state " + s + " are:\n");
        children.stream().forEach((c) -> {
            System.out.println(c.state);
        });
        
        
        // test the equals function
        System.out.println("\nTest the equals function\n-----------\n");
        System.out.println("Is " + s + " equals to " + s2 + "?");
        System.out.println(s2.equals(s));
        System.out.println("Is " + s + " equals to " + s + "?");
        System.out.println(s.equals(s));
        
        // test the heuristic method
        System.out.println("\nTest the Heuristic method\n----------------\n");
        FrogSearchProblem p = new FrogSearchProblem(s, s2);
        FrogsState fs = new FrogsState("GG-GRRR");
        FrogsState fs2 = new FrogsState("GGG-RRR");
        FrogSearchProblem p2 = new FrogSearchProblem(fs,fs2);
        System.out.println("Herustic from " + s + " to " + s2 + " is: " + p.heuristic(s));
        System.out.println("Herustic from " + fs + " to " + fs2 + " is: " + p2.heuristic(fs));
    }
}
