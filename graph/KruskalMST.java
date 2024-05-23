package com.graph;

import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    // Comparator function used for sorting edges based on their weight
    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
}

class Subset {
    int parent, rank;
}

public class KruskalMST {

    int V, E;    // V-> Number of vertices & E-> Number of edges
    Edge edge[]; // Collection of all edges

    // Create a graph with V vertices and E edges
    KruskalMST(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }

    // A utility function to find set of an element i (uses path compression technique)
    int find(Subset subsets[], int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);

        return subsets[i].parent;
    }

    // A function that does union of two sets of x and y (uses union by rank)
    void union(Subset subsets[], int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        // Attach smaller rank tree under root of high rank tree (Union by Rank)
        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;

        // If ranks are same, then make one as root and increment its rank by one
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    // The main function to construct MST using Kruskal's algorithm
    void kruskalMST() {
        
        Edge result[] = new Edge[V];
        int e = 0;  
        int i = 0;  
        for (i = 0; i < V; ++i)
            result[i] = new Edge();

        
        Arrays.sort(edge);

        
        Subset subsets[] = new Subset[V];
        for (i = 0; i < V; ++i)
            subsets[i] = new Subset();

        
        for (int v = 0; v < V; ++v) {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        i = 0;  

        
        while (e < V - 1) {
            
            Edge next_edge = edge[i++];

            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);

                        if (x != y) {
                result[e++] = next_edge;
                union(subsets, x, y);
            }
            
        }

        
        System.out.println("Following are the edges in the constructed MST");
        for (i = 0; i < e; ++i)
            System.out.println(result[i].src + " -- " + result[i].dest + " == " + result[i].weight);
    }

    // Driver method
    public static void main(String[] args) {

        int V = 4; 
        int E = 5; 
        KruskalMST graph = new KruskalMST(V, E);

        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 10;

        // add edge 0-2
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 6;

        // add edge 0-3
        graph.edge[2].src = 0;
        graph.edge[2].dest = 3;
        graph.edge[2].weight = 5;

        // add edge 1-3
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 15;

        // add edge 2-3
        graph.edge[4].src = 2;
        graph.edge[4].dest = 3;
        graph.edge[4].weight = 4;

        // Function call
        graph.kruskalMST();
    }
}
