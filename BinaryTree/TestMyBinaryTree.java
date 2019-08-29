package cn.datastructure.com;

public class TestMyBinaryTree {
    public static void main(String[] args) {
        Node node10 = new Node(10,null,null);
        Node node9 = new Node(9,null,null);
        Node node8 = new Node(8,null,node10);
        Node node7 = new Node(7,null,null);
        Node node6 = new Node(6,node9,null);
        Node node5 = new Node(5,node8,null);
        Node node1 = new Node(1,node7,node6);
        Node node2 = new Node(2,node1,node5);
        BinaryTree btree = new MyBinaryTree(node2);
        //BinaryTree btree = new MyBinaryTree();
        //System.out.println(btree.isEmpty());

        System.out.println(btree.size());
        System.out.println(btree.getHeight());
        System.out.println(btree.findKey(1));
        btree.preOrderTraverse();
        btree.inOrderTraverse();
        btree.postOredrTraverse();
        btree.levelOrderByQueue();
        btree.inOrderByStack();
        btree.preOrderByStack();
        btree.postOrderByStack();
    }
}
