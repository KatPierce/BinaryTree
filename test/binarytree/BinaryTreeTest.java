/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytree;

import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Eugenia
 */
public class BinaryTreeTest {
    @Test
    public void removeTest(){
        System.out.println("remove");
        BinaryTree tree = new BinaryTree<>();
        List<Integer> list = Arrays.asList(2,1,6,4,3,5,9,8,10);
        tree.addAll(list);
        tree.remove(6);
        BinaryTree<Integer> expTree = new BinaryTree<>();
        List<Integer> expList = Arrays.asList(2,1,5,4,3,9,8,10);
        expTree.addAll(expList);
        assertEquals(expTree, tree);
    }
//    @Test
//    public void st() {
//        assertEquals(1,1);
//    }
//    
}
