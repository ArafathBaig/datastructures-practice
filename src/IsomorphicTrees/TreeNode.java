package IsomorphicTrees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TreeNode {
    private int data;
    private TreeNode parent;
    private List<TreeNode> children;

    public TreeNode(int data){
        this(data, null);
    }

    public TreeNode(int data, TreeNode parent){
        this.parent = parent;
        this.data = data;
        children = new ArrayList<>();
    }

    public void addChilder(TreeNode... childrens){
        for(TreeNode c : childrens)
            this.children.add(c);
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    public static boolean treesAreIsomorphic(List<List<Integer>> tree1, List<List<Integer>> tree2){
        if(tree1.isEmpty() || tree2.isEmpty())
            throw new IllegalArgumentException("Tree shouldnt be empty");

        List<Integer> center1 = findTreeCenter(tree1);
        List<Integer> center2 = findTreeCenter(tree1);

        TreeNode rooted1 = rootedTree(tree1, center1.get(0));
        String tree1Encode = encode(rooted1);

        for(int c : center2){

            TreeNode rooted2 = rootedTree(tree2, c);
            String tree2Encode = encode(rooted2);

            if(tree2Encode.equals(tree1Encode))
                return true;

        }

        return false;
    }

    private static List<Integer> findTreeCenter(List<List<Integer>> tree){
        int n  = tree.size();

        int [] degree = new int[n];

        List<Integer> leaves = new ArrayList<>();

        for(int i = 0; i < n ;i++){
            List<Integer> edge = tree.get(i);
            degree[i] = edge.size();

            if(degree[i] <= 1){
                leaves.add(i);
                degree[i] = 0;
            }
        }

        int count = leaves.size();

        while(count < n ){
            List<Integer> newLeaves = new ArrayList<>();
            for(int node : leaves){
                for(int nei : tree.get(node)){
                    if(--degree[nei] == 1 ){
                        newLeaves.add(nei);
                    }
                }
                degree[node] = 0;

            }
            count+= newLeaves.size();
            leaves = newLeaves;
        }
        return leaves;
    }

    private static TreeNode rootedTree(List<List<Integer>> graph, int r){
        TreeNode root = new TreeNode(r);
        return buildTree(graph, root);
    }

    private static TreeNode buildTree(List<List<Integer>> graph, TreeNode root){

        for(int n : graph.get(root.getData())){

            if (root.getParent() != null && n == root.getParent().getData()){
                continue;
            }

            TreeNode node = new TreeNode(n,root);
            buildTree(graph,node);
        }
        return root;
    }

    private static String encode(TreeNode root){

        if(root == null)
            return "";

        List<String> label = new LinkedList<>();

        for(TreeNode child : root.getChildren()){
            label.add(encode(child));
        }

        Collections.sort(label);
        StringBuilder sb = new StringBuilder();
        for(String s : label){
            sb.append(s);
        }

        return "(" + sb.toString() + ")";
    }

    private static void addUndirectedEdge(List<List<Integer>> graph, int from, int to) {
        graph.get(from).add(to);
        graph.get(to).add(from);
    }

    private static List<List<Integer>> createEmptyGraph(int n) {
        List<List<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) graph.add(new LinkedList<>());
        return graph;
    }

    public static void main(String[] args) {
        simpleIsomorphicTree();
    }

    private static void simpleIsomorphicTree() {
        int n = 10;
        List<List<Integer>> tree1 = createEmptyGraph(n);
        List<List<Integer>> tree2 = createEmptyGraph(n);
        List<List<Integer>> tree3 = createEmptyGraph(n);

        addUndirectedEdge(tree1, 0, 1);
        addUndirectedEdge(tree1, 1, 3);
        addUndirectedEdge(tree1, 3, 5);
        addUndirectedEdge(tree1, 5, 7);
        addUndirectedEdge(tree1, 7, 8);
        addUndirectedEdge(tree1, 8, 9);
        addUndirectedEdge(tree1, 2, 1);
        addUndirectedEdge(tree1, 4, 3);
        addUndirectedEdge(tree1, 6, 5);

        addUndirectedEdge(tree2, 0, 1);
        addUndirectedEdge(tree2, 1, 3);
        addUndirectedEdge(tree2, 3, 5);
        addUndirectedEdge(tree2, 5, 6);
        addUndirectedEdge(tree2, 6, 8);
        addUndirectedEdge(tree2, 8, 9);
        addUndirectedEdge(tree2, 6, 7);
        addUndirectedEdge(tree2, 4, 3);
        addUndirectedEdge(tree2, 2, 1);

        addUndirectedEdge(tree3, 0, 1);
        addUndirectedEdge(tree3, 1, 8);
        addUndirectedEdge(tree3, 1, 6);
        addUndirectedEdge(tree3, 6, 4);
        addUndirectedEdge(tree3, 6, 5);
        addUndirectedEdge(tree3, 5, 3);
        addUndirectedEdge(tree3, 5, 7);
        addUndirectedEdge(tree3, 7, 2);
        addUndirectedEdge(tree3, 2, 9);

        check(tree1, tree2);
        check(tree1,tree3);
        check(tree2, tree3);
    }

    private static void check(List<List<Integer>> tree1, List<List<Integer>> tree2 ){

        if(treesAreIsomorphic(tree1,tree2)){
            System.out.println("Both are isomorphic");
        }else{
            System.out.println("Nope");
        }
    }
}
