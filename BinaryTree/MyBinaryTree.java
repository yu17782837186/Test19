package cn.datastructure.com;

import java.util.*;

public class MyBinaryTree implements BinaryTree {
    private Node root;

    public MyBinaryTree() {

    }

    public MyBinaryTree(Node root) {
        this.root = root;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        System.out.println("二叉树的节点个数：");
        return this.size(root);
    }
    private int size(Node root) {
        if (root == null) {
            return 0;
        }else {
            //获取左子树的size
            int nLeft = size(root.getLeftChild());
            //获取右子树的size
            int nRight = size(root.getRightChild());
            //返回左子树的size和右子树的size之和并加1
            return nLeft+nRight+1;
        }
     }
    @Override
    public int getHeight() {
        System.out.println("二叉树的高度：");
        return getHirht(root);
    }
    private int getHirht(Node root) {
        if (root == null) {
            return 0;
        }else {
            //获取左子树的高度
            int HL = getHirht(root.getLeftChild());
            //获取右子树的高度
            int HR = getHirht(root.getRightChild());
            //返回左子树，右子树中较大的高度并加1
            return HL > HR ? HL+1:HR+1;
        }
    }
    @Override
    public Node findKey(int key) {
        return this.findKey(key,root) ;
    }
    private Node findKey(int key,Node root) {
        if (root == null) {
            return null;
        }else if(root.getData()== key) {
            return root;
        }else {
            Node node1 = this.findKey(key,root.getLeftChild());
            Node node2 = this.findKey(key,root.getRightChild());
            if (node1 != null && node1.getData() == key) {
                return node1;
            }else if(node2 != null && node2.getData() == key) {
                return node2;
            }else {
                return null;
            }
        }
    }
    @Override
    public void preOrderTraverse() {
//        if (root != null) {
//            //前序遍历  先输出根节点的值
//            System.out.print(root.getData()+" ");
//            //对左子树进行先序遍历
//            BinaryTree leftTree = new MyBinaryTree(root.getLeftChild());
//            leftTree.preOrderTraverse();
//            //对右子树进行先序遍历
//            BinaryTree rightTree = new MyBinaryTree(root.getRightChild());
//            rightTree.preOrderTraverse();
//        }
        System.out.println("前序遍历;");
        this.preOrderTraverse(root);
        System.out.println();
    }
    private void preOrderTraverse(Node root) {
        if (root != null) {
            //前序遍历
            System.out.print(root.getData()+" ");
            this.preOrderTraverse(root.getLeftChild());
            this.preOrderTraverse(root.getRightChild());
        }
    }

    @Override
    public void inOrderTraverse() {
        System.out.println("中序遍历：");
        this.inOrderTraverse(root);
        System.out.println();
    }
    private void inOrderTraverse(Node root) {
        if (root != null) {
            //中序遍历
            this.inOrderTraverse(root.getLeftChild());
            System.out.print(root.getData()+" ");
            this.inOrderTraverse(root.getRightChild());
        }
    }
    @Override
    public void postOredrTraverse() {
        System.out.println("后序遍历：");
        this.postOrderTraverse(root);
        System.out.println();
    }
    private void postOrderTraverse(Node root) {
        if (root != null) {
            //后序遍历
            this.postOrderTraverse(root.getLeftChild());
            this.postOrderTraverse(root.getRightChild());
            System.out.print(root.getData()+" ");
        }
    }
    @Override
    public void preOrderByStack() {
        //前序遍历的非递归
        System.out.println("前序遍历非递归:");
        Deque<Node> satck = new LinkedList<>();
        Node current = root;
        //先将根节点压入栈中
        satck.push(current);
        while(current != null && !satck.isEmpty()) {
            Node p = satck.poll();
            System.out.print(p.getData()+" ");
            if (p.getRightChild() != null) {
                satck.push(p.getRightChild());
            }
            if (p.getLeftChild() != null) {
                satck.push(p.getLeftChild());
            }
        }
        System.out.println();
    }

    @Override
    public void inOrderByStack() {
        //中序遍历非递归
        System.out.println("中序遍历非递归：");
        Deque<Node> stack = new LinkedList<>();
        Node current = root;
        while(current != null || !stack.isEmpty()) {
            while(current != null) {
                stack.push(current);
                current = current.getLeftChild();
            }
            if (!stack.isEmpty()) {
                current = stack.poll();
                System.out.print(current.getData()+" ");
                current = current.getRightChild();
            }
        }
        System.out.println();
    }

    @Override
    public void postOrderByStack() {
        System.out.println("后序遍历的非递归：");
        Deque<Node> stack = new LinkedList<>();
        Deque<Node> output = new LinkedList<>();
        Node node = root;
        while(node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                output.push(node);
                node = node.getRightChild();
            }else {
                node = stack.pop();
                node = node.getLeftChild();
            }
        }
        while(output.size() > 0) {
             Node n = output.pop();
            System.out.print(n.getData()+" ");
        }
    }

    @Override
    public void levelOrderByQueue() {
        //层次遍历 需要使用队列
        System.out.println("层次遍历：");
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size() != 0) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node tmp = queue.poll();
                System.out.print(tmp.getData()+" ");
                if (tmp.getLeftChild() != null) {
                    queue.add(tmp.getLeftChild());
                }
                if (tmp.getRightChild() != null) {
                    queue.add(tmp.getRightChild());
                }
            }
        }
        System.out.println();
    }
}
