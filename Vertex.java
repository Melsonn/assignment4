package com.company;

import java.util.Map;

public class Vertex<T> {
    private T data;
    private Map<T, Double> adjacentVertices;

    public Vertex(T data) {
        this.data = data;
    }
    public Vertex() {
    }

    public void addAdjacentVertices(T destination, double weight){
        adjacentVertices.put(destination, weight);
    }


    public void add(T destination) {
        adjacentVertices.put(destination, null);
    }

    public int size() {
        return adjacentVertices.size();
    }


    public boolean contains(T connectedVertex) {
        return adjacentVertices.containsKey(connectedVertex);
    }


    public T getData(){
        return data;
    }

    public void setData(T data){
        this.data = data;
    }

    public T containsData(Vertex<T> vertex){
        return vertex.getData();
    }

}
