package com.company;

import java.util.*;

public class WeightedGraph<T> {
    private final boolean undirected;
    private Map<T,Vertex<T>> map = new HashMap<>();

    public WeightedGraph() {
        this.undirected = true;
    }

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(T vertex) {
        map.put(vertex, new Vertex<>(vertex));
    }

    public void addEdge(T source, T dest, double weight) {
        if (!hasVertex(source))
            addVertex(source);

        if (!hasVertex(dest))
            addVertex(dest);

        if (hasEdge(source, dest) || source.equals(dest))
            return; // reject parallels & self-loops

        map.get(source).addAdjacentVertices(map.get(dest),weight);

        if (undirected)
            map.get(dest).addAdjacentVertices( map.get(source),weight);
    }

    public int getVerticesCount() {
        return map.size();
    }

    public int getEdgesCount() {
        int count = 0;
        for (T v : map.keySet()) {
            count += map.get(v).size();
        }

        if (undirected)
            count /= 2;

        return count;
    }


    public boolean hasVertex(T v) {return map.containsKey(v);}

    public boolean hasEdge(T source, T dest) {
        if (!hasVertex(source)) return false;
        return map.get(source).contains(new T<>(dest));
    }
}
