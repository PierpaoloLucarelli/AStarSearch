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
public class GameTests {
    
    
    public static void main(String[] args){
        // test the construction of a world
        String world = "RRR---GGG";
        char[] frogWorld = {'R','R','R','-','-','-','G','G','G'};
        FrogsState s = new FrogsState(world);
        FrogsState s2 = new FrogsState(frogWorld);
        System.out.println(s2);
        
        // testing the action
        FrogAction a = new FrogAction(1, 3, FrogColor.RED);
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
        
       
    }
    
}
