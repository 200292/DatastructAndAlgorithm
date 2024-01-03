package com.test.datastruct.tree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        HeroNode root = new HeroNode(1,"宋江");
        root.left = new HeroNode(2,"a");
        root.right = new HeroNode(3,"a");
        root.left.left = new HeroNode(4,"a");
        root.left.right = new HeroNode(5,"a");
        root.right.left = new HeroNode(6,"a");
        root.right.right = new HeroNode(7,"a");
        root.postOrderList();
        System.out.println("hello world");
        System.out.println("hello world");
    }
}
//二叉树
class BinaryTree{
    public HeroNode root;
    //先序遍历
    public void preOrderList(){
        if(root != null){
            root.preOrderList();
        }else {
            System.out.println("二叉树为空,无法遍历");
        }
    }
    //中序遍历
    public void infixOrderList(){
        if(root != null){
            root.infixOrderList();
        }else {
            System.out.println("二叉树为空,无法遍历");
        }
    }
    //后序遍历
    public void postOrderList(){
        if(root != null){
            root.postOrderList();
        }else {
            System.out.println("二叉树为空,无法遍历");
        }
    }
}
class HeroNode{
    private int id;
    private String name;
    public HeroNode left;
    public HeroNode right;

    public HeroNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //先序遍历，一个节点调用该方法表示以该节点作为根节点来先序遍历
    public void preOrderList(){
        System.out.println(this);
        //如果根节点的左节点存在，则向左递归
        if(this.left != null){
            this.left.preOrderList();
        }
        //如果根节点的右节点存在，则向右递归
        if(this.right != null){
            this.right.preOrderList();
        }
    }
    //中序遍历
    public void infixOrderList(){
        //如果根节点的左节点存在，则向左递归
        if(this.left != null){
            this.left.infixOrderList();
        }
        System.out.println(this);
        //如果根节点的右节点存在，则向右递归
        if(this.right != null){
            this.right.infixOrderList();
        }
    }

    //中序遍历
    public void postOrderList(){
        //如果根节点的左节点存在，则向左递归
        if(this.left != null){
            this.left.postOrderList();
        }
        //如果根节点的右节点存在，则向右递归
        if(this.right != null){
            this.right.postOrderList();
        }
        System.out.println(this);
    }
}
