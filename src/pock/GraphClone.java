/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pock;

import java.util.HashMap;
import leetcode.UndirectedGraphNode;

/**
 *
 * @author SONGSONG
 */
public class GraphClone {

    HashMap<UndirectedGraphNode, UndirectedGraphNode> hash = new HashMap<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        UndirectedGraphNode copy_node = new UndirectedGraphNode(node.label);
        hash.put(node, copy_node);
        for (UndirectedGraphNode nei : node.neighbors) {
            if (hash.containsKey(nei)) {
                copy_node.neighbors.add(hash.get(nei));
            } else {
                copy_node.neighbors.add(cloneGraph(nei));
            }
        }
        return copy_node;
    }
}
