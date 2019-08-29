package cn.datastructure.com;

public interface BinaryTree {
    //是否是空树
    boolean isEmpty();

    //树的节点数量
    int size();

    //获取二叉树的高度
    int getHeight();

    //查找key
    Node findKey(int key);

    //前序遍历递归
    void preOrderTraverse();

    //中序遍历递归
    void inOrderTraverse();

    //后序遍历递归
    void postOredrTraverse();

    //前序遍历非递归
    void preOrderByStack();

    //中序遍历非递归
    void inOrderByStack();

    //后序遍历非递归
    void postOrderByStack();

    //按照层次遍历二叉树
    void levelOrderByQueue();

}
