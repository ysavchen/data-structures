package org.example.data.structures.tree;

import org.example.data.structures.stack.DynamicArrayStack;
import org.example.data.structures.stack.Stack;

import java.util.function.Consumer;

/**
 * Двоичное дерево поиска
 */
public class BinarySearchTree<T extends Comparable<T>> {

    private Node<T> root = null;

    public BinarySearchTree() {
    }

    public void insert(T data) {
        var currentNode = root;
        if (currentNode == null) {
            root = new Node<>(data);
        } else {
            while (currentNode != null) {
                if (data.compareTo(currentNode.data) <= 0) {
                    if (currentNode.left == null) {
                        currentNode.left = new Node<>(data);
                        break;
                    } else {
                        currentNode = currentNode.left;
                    }
                } else if (currentNode.right == null) {
                    currentNode.right = new Node<>(data);
                } else {
                    currentNode = currentNode.right;
                }
            }
        }
    }

    /**
     * Обход двоичного дерева и выполнение операции с каждым элементом
     */
    public void traverse(Consumer<T> consumer) {
        Node<T> currentNode = root;
        Stack<Node<T>> stack = new DynamicArrayStack<>();
        while (currentNode != null || !stack.isEmpty()) {
            if (currentNode == null) {
                currentNode = stack.pop();

                currentNode = currentNode.right;
            } else {
                while (currentNode.left != null) {
                    stack.push(currentNode);
                    currentNode = currentNode.left;

                    currentNode = currentNode.right;
                }
            }
        }
    }

    public void delete(T data) {
        //todo: implement
    }

    private NodeSearchResult<T> searchNode(T data) {
        Node<T> parentNode = null;
        Node<T> currentNode = root;
        while (currentNode != null) {
            if (data.equals(currentNode.data)) {
                return new NodeSearchResult<>(parentNode, currentNode);
            } else if (data.compareTo(currentNode.data) < 0) {
                parentNode = currentNode;
                currentNode = currentNode.left;
            } else {
                parentNode = currentNode;
                currentNode = currentNode.right;
            }
        }
        return null;
    }

    private static class Node<T> {

        private final T data;
        private Node<T> left = null;
        private Node<T> right = null;

        Node(T data) {
            this.data = data;
        }
    }

    private static class NodeSearchResult<T> {
        private final Node<T> parentNode;
        private final Node<T> node;

        NodeSearchResult(Node<T> parentNode, Node<T> node) {
            this.parentNode = parentNode;
            this.node = node;
        }
    }
}
