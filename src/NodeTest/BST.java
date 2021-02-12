package NodeTest;

public class BST {

    public class Node{
        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
            this.left = null;
            this.right = null;

        }
    }

    Node root;

    private Node addRecursively(Node current, int value){
        if (current == null) return new Node(value);

        if (value < current.value) current.left = addRecursively(current.left, value);
        else if (value > current.value) current.right = addRecursively(current.right, value);
        else return current;

        return current;
    }
    public void add(int value){
        root = addRecursively(root, value);
    }

    public void traverseTree(Node node){
        if(node != null){
            traverseTree(node.left);
            System.out.print(" " + node.value);
            traverseTree(node.right);
        }
    }

    public Node invertTree(Node node){
        if (node == null){
            return null;
        }

        Node left = invertTree(node.left);
        Node right = invertTree(node.right);

        node.left = right;
        node.right = left;
        return node;
    }
}
