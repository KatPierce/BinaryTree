/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytree;

/**
 *
 * @author Eugenia
 */

import java.util.Arrays;
import java.util.List;
public class MainBinaryTree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
//        List<Integer> list = Arrays.asList(2, 1, 4, 6, 5, 7, 0);
//        List<Integer> list = Arrays.asList(2,1,6,4,3,5,9,8,10);
//        List<Integer> list = Arrays.asList(3,1,2,4,3,6,5,7);
List<Integer> list = Arrays.asList(3);
        tree.addAll(list);
//        tree.print();
        tree.remove(3);
//        tree.print();

        

    }
    
}
