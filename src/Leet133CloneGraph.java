import java.util.*;

/**
 * Created by Liuxz on 2017/7/11.
 */

class UndirectedGraphNode {
     int label;
     List<UndirectedGraphNode> neighbors;
     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 };

public class Leet133CloneGraph {
    HashMap<Integer, UndirectedGraphNode> visit = new HashMap<>();
    public static void main(String[] args){
        UndirectedGraphNode root  = new UndirectedGraphNode(1);
        root.neighbors.add(new UndirectedGraphNode(2));
        root.neighbors.add(new UndirectedGraphNode(3));
        root.neighbors.add(new UndirectedGraphNode(4));
        root.neighbors.add(new UndirectedGraphNode(5));
        root.neighbors.get(1).neighbors.add(root.neighbors.get(3));
        Leet133CloneGraph xx = new Leet133CloneGraph();
        xx.cloneGraph(root);
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null){
            return null;
        }
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        visit.put(node.label, root);
        dfs(node,root);
        return root;
    }

    private void dfs(UndirectedGraphNode node, UndirectedGraphNode copyNode){
        for(UndirectedGraphNode x: node.neighbors){
            if (visit.keySet().contains(x.label)){
                copyNode.neighbors.add(visit.get(x.label));
            }else{
                UndirectedGraphNode t = new UndirectedGraphNode(x.label);
                visit.put(x.label, t);
                copyNode.neighbors.add(t);
                dfs(x, copyNode.neighbors.get(copyNode.neighbors.size()-1));
            }
        }
    }

}
