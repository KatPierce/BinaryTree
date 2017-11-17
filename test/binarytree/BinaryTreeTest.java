/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytree;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

/**
 *
 * @author Eugenia
 */
public class BinaryTreeTest {
    @Test
    public void removeTest(){
        System.out.println("remove");
        //remove a node with two children
        BinaryTree<Integer> tree = new BinaryTree<>();
        List<Integer> list = Arrays.asList(2,1,6,4,3,5,9,8,10);
        tree.addAll(list);
        tree.remove(6);        
        BinaryTree<Integer> expTree = new BinaryTree<>();
        List<Integer> expList = Arrays.asList(2,1,5,4,3,9,8,10);
        expTree.addAll(expList);
        assertEquals(expTree, tree);
        //remove a leaf
        BinaryTree<Integer> tree1 = new BinaryTree<>();
        List<Integer> list1 = Arrays.asList(2,1,6,4,3,5,9,8,10);
        tree1.addAll(list1);
        tree1.remove(8);        
        BinaryTree<Integer> expTree1 = new BinaryTree<>();
        List<Integer> expList1 = Arrays.asList(2,1,6,4,3,5,9,10);
        expTree1.addAll(expList1);
        assertEquals(expTree1, tree1);
        //remove a node with one child
        BinaryTree<Integer> tree2 = new BinaryTree<>();
        List<Integer> list2 = Arrays.asList(2,1,0,4,3,6,5,7);
        tree2.addAll(list2);
        tree2.remove(4);        
        BinaryTree<Integer> expTree2 = new BinaryTree<>();
        List<Integer> expList2 = Arrays.asList(2,1,0,3,6,5,7);
        expTree2.addAll(expList2);
        assertEquals(expTree2, tree2);
        //remove a root
        BinaryTree<Integer> tree3 = new BinaryTree<>();        
        tree3.add(3);
        tree3.remove(3);        
        BinaryTree<Integer> expTree3 = new BinaryTree<>();
        List<Integer> expList3 = Collections.emptyList();
        expTree3.addAll(expList3);
        assertEquals(expTree3, tree3);
        //remove nonexistent node
        BinaryTree<Integer> tree4 = new BinaryTree<>();
        List<Integer> list4 = Arrays.asList(2,1,0,4,3,6,5,7);
        tree4.addAll(list4);
        tree4.remove(9);        
        BinaryTree<Integer> expTree4 = new BinaryTree<>();
        List<Integer> expList4 = Arrays.asList(2,1,0,4,3,6,5,7);
        expTree4.addAll(expList4);
        assertEquals(expTree4, tree4);
        //remove with replacememt from leftSubtree
        BinaryTree<Integer> tree5 = new BinaryTree<>();
        List<Integer> list5 = Arrays.asList(71, 92, 1, 47, 28, 51, 31, 3, 69, 51, 90, 33, 64, 82, 92, 32, 83, 62, 76, 61);
        tree5.addAll(list5);
        tree5.remove(71);        
        BinaryTree<Integer> expTree5 = new BinaryTree<>();
        List<Integer> expList5 = Arrays.asList(92, 1, 47, 28, 51, 31, 3, 69, 51, 90, 33, 64, 82, 92, 32, 83, 62, 76, 61);
        expTree5.addAll(expList5);
        assertEquals(expTree5, tree5);
        BinaryTree<Integer> tree6 = new BinaryTree<>();
        List<Integer> list6 = Arrays.asList(7,4,9,3,6,8,10);
        tree6.addAll(list6);
        tree6.remove(7);        
        BinaryTree<Integer> expTree6 = new BinaryTree<>();
        List<Integer> expList6 = Arrays.asList(6,4,9,3,8,10);
        expTree6.addAll(expList6);
        assertEquals(expTree6, tree6);
    }
    
}
