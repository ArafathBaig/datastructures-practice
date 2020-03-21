package DFSwithRecursion;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public int maxDepth(Node root) {
        if(root == null) return 0;

        Queue<Node> q = new LinkedList();
        int level = 1, current =0;
        q.add(root);
        int max =0;
        while(!q.isEmpty()){

            Node t = q.remove();
            level--;
            List<Node> a = t.children;
            for(int i = 0; i < t.children.size();i++){
                q.add(t.children.get(i));
                current++;
            }

            if(level == 0){
                max++;
                level= current;
                current = 0;
            }
        }
        return max;
    }
}
