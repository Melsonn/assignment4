package com.company;

import java.util.Map;

public class Vertex<V> {
    private V data;
    private Map<Vertex<V>, Double> adjacentVertices;

    public Vertex(V data) {

        this.data = data;
    }
    public Vertex() {
    }

    public void addAdjacentVertices(Vertex<V> destination, double weight){

        adjacentVertices.put(destination, weight);
    }


    public void add(Vertex<V> destination) {
        adjacentVertices.put(destination, null);
    }

    public int size() {
        return adjacentVertices.size();
    }


    public boolean contains(V connectedVertex) {
        return adjacentVertices.containsKey(connectedVertex);
    }


    public V getData(){
        return data;
    }

    public void setData(V data){
        this.data = data;
    }

    public V containsData(Vertex<V> vertex){
        return vertex.getData();
    }

}
