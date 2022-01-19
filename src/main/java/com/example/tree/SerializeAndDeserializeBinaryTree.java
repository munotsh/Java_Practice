package com.example.tree;

public class SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree bt = new SerializeAndDeserializeBinaryTree();
        Node root = new Node(6);
        root.left = new Node(4);
        root.right = new Node(8);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(7);
        root.right.right = new Node(9);

        String preOrd = bt.serialize(root,new StringBuffer());
        System.out.println(preOrd);
        Node root1 = bt.deserialize(preOrd);
        bt.printTree(root1);
    }


    public String serialize(Node root, StringBuffer sb) {
        if (root == null)
            return "";

        sb.append(root.value).append(",");
        serialize(root.left,sb);
        serialize(root.right,sb);
        return sb.toString();
    }
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
    String[] preOrd = data.split(",");
    return construct(preOrd,0,preOrd.length-1);
    }

    public Node construct(String[] pre, int start, int end)
    {
        if (start > end) {
            return null;
        }
        Node node = new Node(Integer.parseInt(pre[start]));
        int i;
        for (i = start; i <= end; i++)
        {
            if (Integer.parseInt(pre[i]) > node.value) {
                break;
            }
        }
        node.left = construct(pre, start + 1, i - 1);
        node.right = construct(pre, i, end);
        return node;
    }
    void printTree(Node root) {
        if (root == null) {
            return;
        }
        System.out.printf("%d ", root.value);
        printTree(root.left);
        printTree(root.right);
    }


}
