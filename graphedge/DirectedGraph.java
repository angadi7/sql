package graphedge;

import java.util.*;

public class DirectedGraph {
    private final Map<Integer, List<Integer>> adjacencyList;

    public DirectedGraph() {
        adjacencyList = new HashMap<>();
    }

    
    public void addNode(int node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    
    public boolean addEdgeAndCheckCycle(int from, int to) {
        addNode(from);
        addNode(to);

        
        adjacencyList.get(from).add(to);

        
        if (hasCycle()) {
           
            adjacencyList.get(from).remove((Integer) to);
            return false;
        }

        
        return true;
    }

    
    private boolean hasCycle() {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> recStack = new HashSet<>();

        for (Integer node : adjacencyList.keySet()) {
            if (hasCycleUtil(node, visited, recStack)) {
                return true;
            }
        }

        return false;
    }


    private boolean hasCycleUtil(int node, Set<Integer> visited, Set<Integer> recStack) {
        if (recStack.contains(node)) {
            return true;
        }

        if (visited.contains(node)) {
            return false;
        }

        visited.add(node);
        recStack.add(node);

        List<Integer> neighbors = adjacencyList.get(node);
        if (neighbors != null) {
            for (Integer neighbor : neighbors) {
                if (hasCycleUtil(neighbor, visited, recStack)) {
                    return true;
                }
            }
        }

        recStack.remove(node);
        return false;
    }

    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph();
        
        System.out.println(graph.addEdgeAndCheckCycle(1, 2)); // Output: true
        System.out.println(graph.addEdgeAndCheckCycle(2, 3)); // Output: true
        System.out.println(graph.addEdgeAndCheckCycle(3, 4)); // Output: true
        System.out.println(graph.addEdgeAndCheckCycle(4, 2)); // Output: false, cycle created
        System.out.println(graph.addEdgeAndCheckCycle(4, 5)); // Output: true
    }
}

