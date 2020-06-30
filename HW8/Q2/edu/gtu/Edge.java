package edu.gtu;

import java.util.Objects;

public class Edge {

    private int dest;
    private int source;
    private double weight;

    public Edge( int source , int dest ) {

        this.source = source;
        this.dest = dest;
        this.weight = Double.POSITIVE_INFINITY;

    }

    public Edge( int source , int dest, double w) {
        this(source , dest);
        this.weight = w;
    }

    public double getWeight() {
        return weight;
    }

    public int getDest() {
        return dest;
    }

    public int getSource() {
        return source;
    }

    @Override
    public int hashCode() {
        return Objects.hash( getDest() , getSource() , getWeight() );
    }


    @Override
    public boolean equals(Object obj) {

        if( obj == this ) {
            return true;
        }

        if( !(obj instanceof Edge) ) {
            return false;
        }

        Edge edge = (Edge)obj;

        return edge.dest == getDest() &&
                edge.source == getSource() &&
                edge.weight == getWeight();

    }

    public void setDest(int dest) {
        this.dest = dest;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {

        return " ( source : " + source + ", dest : " + dest + " )";
    }
}
