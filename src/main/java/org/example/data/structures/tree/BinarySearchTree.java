package org.example.data.structures.tree;

import org.example.data.structures.stack.DynamicArrayStack;

import java.util.function.Consumer;

/**
 * Двоичное дерево поиска
 */
public class BinarySearchTree<T extends Comparable<T>> {

    private Node<T> root = null;

    public BinarySearchTree() {
    }

    public void insert(T data) {
        var node = root;   // current node
        if (node == null) {
            root = new Node<>(data);
        } else {
            while (node != null) {
                if (data.compareTo(node.data) <= 0) {
                    if (node.left == null) {
                        node.left = new Node<>(data);
                        break;
                    } else {
                        node = node.left;
                    }
                } else if (node.right == null) {
                    node.right = new Node<>(data);
                } else {
                    node = node.right;
                }
            }
        }
    }

    /**
     * Обход двоичного дерева и выполнение операции с каждым элементом
     */
    public void traverse(Consumer<T> consumer) {
        Node<T> node = root;   // current node
        DynamicArrayStack stack = new DynamicArrayStack(15);
        while (node != null || !stack.isEmpty()) {
            if (node == null) {
                // todo: implement
            }
        }
    }

    public void delete(T data) {
        //todo: implement
    }

    private NodeSearchResult<T> searchNode(T data) {
        Node<T> parentNode = null;
        Node<T> node = root;   // current node
        while (node != null) {
            if (data.equals(node.data)) {
                return new NodeSearchResult<>(parentNode, node);
            } else if (data.compareTo(node.data) < 0) {
                parentNode = node;
                node = node.left;
            } else {
                parentNode = node;
                node = node.right;
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
