package edu.gtu;

import java.util.*;

public class BreadthFirstSearch {

    /**
     * Perform a breadthFirst search of a graph.
     * <p>The array parent will contain the predecessor
     * of each vertex in the breadthFirst search tree.</p>
     * @param graph The graph to be searched
     * @param start_vertex The start vertex
     * @return The array of parents
     */

    public static int[] breadthFirstSearch( Graph graph , int start_vertex ) throws Exception {
        
        Queue<Integer> theQueue = new LinkedList<>();

        int[] parent  = new int[ graph.getNumV() ];
        Arrays.fill(parent, -1);

        boolean[] identified = new boolean[ graph.getNumV() ];
        Arrays.fill( identified , false );

        identified[ start_vertex ] = true;
        theQueue.offer( start_vertex );

        while ( !theQueue.isEmpty() ) {

            int currentVertex = theQueue.remove();
            Iterator<Edge> iter = graph.edgeIterator( currentVertex );

            while ( iter.hasNext() ) {
                Edge edge = iter.next();
                int neighbor = edge.getDest();

                if( !identified[ neighbor ] ) {
                    identified[ neighbor ] = true;
                    theQueue.offer( neighbor );
                    parent[ neighbor ] = currentVertex;
                }
            }
        }

        return parent;
    }
}
