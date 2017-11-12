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
//import org.jetbrains.annotations.NotNull;
//import org.jetbrains.annotations.Nullable;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import java.util.*;

// Attention: comparable supported but comparator is not
@SuppressWarnings("WeakerAccess")
public class BinaryTree<T extends Comparable<T>> extends AbstractSet<T> implements SortedSet<T> {

    private static class Node<T> {
        final T value;

        Node<T> left = null;

        Node<T> right = null;

        Node(T value) {
            this.value = value;
        }
        Node (T value, Node<T> left, Node<T> right) {
            this.value = value;
            this.right = right;
            this.left = left;
        }
        @Override
    public String toString() {
        return " "+ (T) value + " ";
    }
    }

    private Node<T> root = null;

    private int size = 0;
    public Queue q1, q2;

    @Override
    public boolean add(T t) {
        Node<T> closest = find(t);
        int comparison = closest == null ? -1 : t.compareTo(closest.value);
        if (comparison == 0) {
            return false;
        }
        Node<T> newNode = new Node<>(t);
        if (closest == null) {
            root = newNode;
        }
        else if (comparison < 0) {
            assert closest.left == null;
            closest.left = newNode;
        }
        else {
            assert closest.right == null;
            closest.right = newNode;
        }
        size++;
        return true;
    }

    boolean checkInvariant() {
        return root == null || checkInvariant(root);
    }

    private boolean checkInvariant(Node<T> node) {
        Node<T> left = node.left;
        if (left != null && (left.value.compareTo(node.value) >= 0 || !checkInvariant(left))) return false;
        Node<T> right = node.right;
        return right == null || right.value.compareTo(node.value) > 0 && checkInvariant(right);
    }

    @Override
    public boolean remove(Object o) {
        T t = (T) o;
        if (root == null)
            return false;
        else {
            if( remove(null, root, t)) {
                size--;
                return true;
            }
            else return false;
        }        
    }    
   
    private boolean remove(Node<T> parent, Node<T> node, T value) {
        if (node == null)
            return false;
        int comparison = value.compareTo(node.value);
        if (comparison == 0) {                                                         // remove node from parent            
            if (parent != null) {
                boolean isLeftSubtree = node.value.compareTo(parent.value) < 0;
                if (node.left == null || node.right == null) {                          // is leaf or single child
                    Node<T> replacement = node.left != null ? node.left : node.right;
                    if (isLeftSubtree)
                        parent.left = replacement;
                    else
                        parent.right = replacement;
                    return true;
                } else {
                    Node<T> replacementNodeParent = node.left;
                    if (replacementNodeParent.right != null) {                        //если есть, где искать max
                        while (replacementNodeParent.right.right != null) {
                            replacementNodeParent = replacementNodeParent.right;
                        }
                        Node<T> insertedNode = new Node<>(replacementNodeParent.right.value, node.left,node.right);
                        if (isLeftSubtree)
                            parent.left = insertedNode;
                        else
                            parent.right = insertedNode;
                        replacementNodeParent.right = null;
                        return true;
                    } else {
                        Node<T> insertedNode = new Node(node.left.value, null, node.right);         
                        if (isLeftSubtree)
                            parent.left = insertedNode;
                        else
                            parent.right = insertedNode;                       
                        return true;
                    }
                }

            } else {                                            // we are deleting tree root
                if (node.left == null || node.right == null) {    // is leaf or single child
                    Node<T> replacement = node.left != null ? node.left : node.right;
                    root = replacement;
                    return true;
                } else {
                    Node<T> replacementNodeParent = node.left;
                    if (replacementNodeParent.right != null) {                        //если есть, где искать max
                        while (replacementNodeParent.right.right != null) {
                            replacementNodeParent = replacementNodeParent.right;
                        }
                        Node<T> insertedNode = new Node<>(replacementNodeParent.right.value, node.left,node.right);
                        root = insertedNode;
                        replacementNodeParent.right = null;
                        return true;
                    } else {
                        Node<T> insertedNode = new Node(node.left.value, null, node.right); 
                        root = insertedNode;
                        return true;                                                   
                        
                    }
                }


            }

        } else
            return remove(node, comparison < 0 ? node.left : node.right, value);


    }              

    @Override
    public boolean contains(Object o) {
        @SuppressWarnings("unchecked")
        T t = (T) o;
        Node<T> closest = find(t);
        return closest != null && t.compareTo(closest.value) == 0;
    }

    private Node<T> find(T value) {
        if (root == null) return null;
        return find(root, value);
    }

    private Node<T> find(Node<T> start, T value) {
        int comparison = value.compareTo(start.value);
        if (comparison == 0) {
            return start;
        }
        else if (comparison < 0) {
            if (start.left == null) return start;
            return find(start.left, value);
        }
        else {
            if (start.right == null) return start;
            return find(start.right, value);
        }
    }    
   

    public class BinaryTreeIterator implements Iterator<T> {

        private Node<T> current = null;

        private BinaryTreeIterator() {}

        private Node<T> findNext() {
//            throw new UnsupportedOperationException();
         return null;

        }

        @Override
        public boolean hasNext() {
            return findNext() != null;
        }

        @Override
        public T next() {
            current = findNext();
            if (current == null) throw new NoSuchElementException();
            return current.value;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new BinaryTreeIterator();
    }

    @Override
    public int size() {
        return size;
    }


    @Nullable
    @Override
    public Comparator<? super T> comparator() {
        return null;
    }

    @NotNull
    @Override
    public SortedSet<T> subSet(T fromElement, T toElement) {
        throw new UnsupportedOperationException();
    }

    @NotNull
    @Override
    public SortedSet<T> headSet(T toElement) {
        throw new UnsupportedOperationException();
    }

    @NotNull
    @Override
    public SortedSet<T> tailSet(T fromElement) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T first() {
        if (root == null) throw new NoSuchElementException();
        Node<T> current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.value;
    }

    @Override
    public T last() {
        if (root == null) throw new NoSuchElementException();
        Node<T> current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.value;
    }   
}
