/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import cm3038.search.ActionStatePair;
import java.util.List;

/**
 *
 * @author plucarelli
 */
public class FrogTests {
    public static void main(String[] args){
        String start = "RRRR-GGGG";
        String goal = "GGGG-RRRR";
        
        FrogsState s = new FrogsState(start);
        FrogsState s2 = new FrogsState(goal);
        
        // tets the apply action function
        FrogAction a = new FrogAction(1, 3, FrogColor.GREEN);
        System.out.println(a);
        System.out.println(s2.applyAction(a));

        // test the can jump one method
        boolean result = s2.canJumpOne(5, FrogColor.RED);
        System.out.println(result);
        if(!result)
            System.out.println(s2.canJumpTwo(5, FrogColor.RED));
        else System.out.println("False");
        
        
        // tets the successor function
        List<ActionStatePair> children = s2.successor();
        for(ActionStatePair c : children){
            System.out.println(c.state);
        }
        
        // test the equals function
        System.out.println(s2.equals(s));
    }
}
