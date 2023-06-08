package Graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Graph<V> {

    private HashMap<V, HashMap<V, Integer>> weightedGraph;

    public Graph() {
        weightedGraph = new HashMap<>();
    }

    public void addVertex(V vertex) {
        if (weightedGraph.containsKey(vertex)) return;
        weightedGraph.put(vertex, new HashMap<>());
    }

    public boolean containsVertex(V vertex) {
        return weightedGraph.containsKey(vertex);
    }

    public void addEdge(V fromVertex, V toVertex, Integer weight) {
        if (!weightedGraph.containsKey(fromVertex)) return;
        HashMap<V, Integer> listOfEdges = weightedGraph.get(fromVertex);
        listOfEdges.put(toVertex, weight);
    }

    public Integer getWeight (V fromVertex, V toVertex) {
        if (!containsVertex(fromVertex) || !containsVertex(toVertex)) throw new IllegalArgumentException("Vertex supplied is not found in graph!");
        return weightedGraph.get(fromVertex).get(toVertex);
    }

    public HashMap<V, Integer> getNeighbors(V vertex) {
        if(!containsVertex(vertex)) throw new IllegalArgumentException("Vertex supplied is not found in graph!");
        return weightedGraph.get(vertex);
    }

    public Integer smallestPath(V fromVertex, V toVertex) {
        if (!containsVertex(fromVertex) || !containsVertex(toVertex)) {
            throw new IllegalArgumentException("Vertex supplied is not found in graph!");
        }

        HashMap<V, Integer> verticesSeen = new HashMap<>();
        Queue<V> edgesToProcess = new LinkedList<>();
        verticesSeen.put(fromVertex, 0);
        edgesToProcess.add(fromVertex);

        while(!edgesToProcess.isEmpty()) {
            V currentVertex = edgesToProcess.poll();
            HashMap<V, Integer> neighbors = getNeighbors(currentVertex);

            for(Map.Entry<V, Integer> neighborEntry : neighbors.entrySet()) {
                V neighborVertex = neighborEntry.getKey();
                Integer edgeCost = getWeight(currentVertex, neighborVertex);
                Integer totalCost = verticesSeen.get(currentVertex) + edgeCost;
                if (verticesSeen.containsKey(neighborVertex) && totalCost < verticesSeen.get(neighborVertex)) {
                    verticesSeen.put(neighborVertex, totalCost);
                } else {
                    verticesSeen.put(neighborVertex, totalCost);
                    edgesToProcess.add(neighborVertex);
                }
            }
        }
        return verticesSeen.get(toVertex);
    }

    @Override
    public String toString() {
        return weightedGraph.toString();
    }
}
