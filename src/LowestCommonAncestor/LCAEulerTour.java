package LowestCommonAncestor;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LCAEulerTour {

//    public static void main(String[] args) {
//        TreeNode root = createFirstTree();
//        LCAEulerTour solve = new LCAEulerTour(root);
//
//        TreeNode lca = solve.lca(13,14);
//        System.out.println(lca);
//
//        if(lca.index() != 2){
//            System.out.println("Error, expected lca to be 2");
//        }
//
//    }
//
//    private static TreeNode createFirstTree() {
//        int n = 17;
//        List<List<Integer>> tree = createEmptyGraph(n);
//
//        addUndirectedEdge(tree, 0, 1);
//        addUndirectedEdge(tree, 0, 2);
//        addUndirectedEdge(tree, 1, 3);
//        addUndirectedEdge(tree, 1, 4);
//        addUndirectedEdge(tree, 2, 5);
//        addUndirectedEdge(tree, 2, 6);
//        addUndirectedEdge(tree, 2, 7);
//        addUndirectedEdge(tree, 3, 8);
//        addUndirectedEdge(tree, 3, 9);
//        addUndirectedEdge(tree, 5, 10);
//        addUndirectedEdge(tree, 5, 11);
//        addUndirectedEdge(tree, 7, 12);
//        addUndirectedEdge(tree, 7, 13);
//        addUndirectedEdge(tree, 11, 14);
//        addUndirectedEdge(tree, 11, 15);
//        addUndirectedEdge(tree, 11, 16);
//
//        return TreeNode.rootedTree(tree, 0);
//    }
//
//
//
//    private static List<List<Integer>> createEmptyGraph(int n) {
//        List<List<Integer>> graph = new ArrayList<>(n);
//        for (int i = 0; i < n; i++) graph.add(new LinkedList<>());
//        return graph;
//    }
//
//
//    private static void addUndirectedEdge(List<List<Integer>> graph, int from, int to) {
//        graph.get(from).add(to);
//        graph.get(to).add(from);
//    }
//
//
//    public static class TreeNode {
//
//        private int n;
//
//        private int data;
//        private TreeNode parent;
//        private List<TreeNode> children;
//
//        public TreeNode(int data){
//            this(data, null);
//        }
//
//        public TreeNode(int data, TreeNode parent){
//            this.parent = parent;
//            this.data = data;
//            children = new ArrayList<>();
//        }
//
//        public void addChilder(TreeNode... childrens){
//            for(TreeNode c : childrens)
//                this.children.add(c);
//        }
//
//        public int getData() {
//            return data;
//        }
//
//        public void setN(int n) {
//            this.n = n;
//        }
//
//        public int getN() {
//            return n;
//        }
//
//        public void setData(int data) {
//            this.data = data;
//        }
//
//        public TreeNode getParent() {
//            return parent;
//        }
//
//        public void setParent(TreeNode parent) {
//            this.parent = parent;
//        }
//
//        public List<TreeNode> getChildren() {
//            return children;
//        }
//
//        public void setChildren(List<TreeNode> children) {
//            this.children = children;
//        }
//
//        public static TreeNode rootedTree(List<List<Integer>> graph, int r){
//
//
//            TreeNode root = new TreeNode(r);
//            return buildTree(graph, root);
//        }
//
//        private static TreeNode buildTree(List<List<Integer>> graph, TreeNode root){
//            int subTreeNodeCount = 1;
//            for(int n : graph.get(root.getData())){
//
//                if (root.getParent() != null && n == root.getParent().getData()){
//                    continue;
//                }
//
//                TreeNode node = new TreeNode(n,root);
//                buildTree(graph,node);
//                subTreeNodeCount += node.size();
//            }
//            node.setSize(subTreeNodeCount);
//            return root;
//        }
}
