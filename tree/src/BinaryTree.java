public class BinaryTree {
    class Node{
        Object data;
        Node left;
        Node right;
        int height;

        Node(Object data){
            this.data = data;
            this.left = null;
            this.right = null;
            height = 0;
        }

        boolean isLeaf(){
            return left == null && right == null;
        }
    }

    Node root;
    BinaryTree(){
        root = null;
    }

    public boolean isFullBinaryTree(Node node){
        if (node == null) {
            return true;
        }

        if (node.isLeaf()) {
            return true;
        }

        if (node.left != null && node.right != null) {
            return isFullBinaryTree(node.left) && isFullBinaryTree(node.right);
        }

        return false;
    }

    public boolean isBalancedBinaryTree(Node node){
        if (node == null) {
            return true;
        }

        int balanceFactor = Math.abs(balanceFactor(node));
        if (balanceFactor > 1) {
            return false;
        }

        return isBalancedBinaryTree(node.left) && isBalancedBinaryTree(node.right);
    }

    public void insert(Object value){
        root = insert(root, value);
    }

    public void delete(Object value){
        root = delete(root, value);
    }

    public void printPreOrder(Node leaf){
        if(leaf == null) return;
        System.out.print(leaf.data + " ");
        printPreOrder(leaf.left);
        printPreOrder(leaf.right);
    }

    public void printInOrder(Node leaf){
        if(leaf == null) return;
        printInOrder(leaf.left);
        System.out.print(leaf.data + " ");
        printInOrder(leaf.right);
    }
    public void printPostOrder(Node leaf){
        if(leaf == null) return;
        printPostOrder(leaf.left);
        printPostOrder(leaf.right);
        System.out.print(leaf.data + " ");
    }

    public boolean search(Object value){
        return  search(root, value);
    }
    public void destroyTree(Node leaf){
        if (leaf == null) return;
        // find left
        if (leaf.left != null) {
            destroyTree(leaf.left);
            // process
            leaf.left = null;
        }
        // find right
        if (leaf.right != null) {
            destroyTree(leaf.right);
            // process
            leaf.right = null;
        }
        // set root is null
        if(root.isLeaf()){
            root = null;
        }
    }


    private int height(Node Node) {
        if (Node == null) return 0;
        return Node.height;
    }

    private int balanceFactor(Node Node) {
        if (Node == null) return 0;
        return height(Node.left) - height(Node.right);
    }

    private void updateHeight(Node node) {
        if (node != null) {
            node.height = 1 + Math.max(height(node.left), height(node.right));
        }
    }


    private Node rotateRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        updateHeight(y);
        updateHeight(x);

        return x;
    }

    private Node rotateLeft(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        updateHeight(x);
        updateHeight(y);

        return y;
    }

    private Node balance(Node node) {
        updateHeight(node);

        int balanceFactorNode = balanceFactor(node);

        if (balanceFactorNode > 1) {
            if (balanceFactor(node.left) < 0) {
                node.left = rotateLeft(node.left);
            }
            return rotateRight(node);
        }

        if (balanceFactorNode < -1) {
            if (balanceFactor(node.right) > 0) {
                node.right = rotateRight(node.right);
            }
            return rotateLeft(node);
        }

        return node;
    }

    private Node insert(Node node, Object value) {
        if (node == null) {
            return new Node(value);
        }

        if (Integer.parseInt(value.toString()) < Integer.parseInt(node.data.toString())) {
            node.left = insert(node.left, value);
        } else if (Integer.parseInt(value.toString()) > Integer.parseInt(node.data.toString())) {
            node.right = insert(node.right, value);
        } else {
            return node;  // Duplicate keys not allowed
        }

        // Update height and balance the node
        updateHeight(node);
        return balance(node);
    }



    private Node delete(Node node, Object value) {
        if (node == null) {
            return null;
        }

        if (Integer.parseInt(value.toString()) < Integer.parseInt(node.data.toString())) {
            node.left = delete(node.left, value);
        } else if (Integer.parseInt(value.toString()) > Integer.parseInt(node.data.toString())) {
            node.right = delete(node.right, value);
        } else {
            if (node.left == null || node.right == null) {
                Node temp = (node.left != null) ? node.left : node.right;

                if (temp == null) {
                    temp = node;
                    node = null;
                } else {
                    node = temp;
                }
            } else {
                Node temp = findMin(node.right);
                node.data = temp.data;
                node.right = delete(node.right, temp.data);
            }
        }

        if (node == null) {
            return null;
        }

        return balance(node);
    }

    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private boolean search(Node current, Object value){
        if(current.data.equals(value)){
            return true;
        }else if(Integer.parseInt(value.toString()) > Integer.parseInt(current.data.toString())){
            if(current.right != null){
                return search(current.right, value);
            }else {
                return false;
            }
        }else{
            if(current.left != null){
                return search(current.left, value);
            }else {
                return false;
            }
        }
    }
}
