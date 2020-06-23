package edu.gtu;


import java.util.*;

public class GtuGraph extends AbstractGraph {


    boolean insertionCheck;
    boolean deletionCheck;

    /**
     * The number of vertices that was allocated by the constructor.
     */
    private int numV;

    /**
     * Queue that keeps the deleted vertex as an interger.
     */
    Queue<Integer> deletedVertexQueue;

    /**
     * Raw vertex keeper.
     */
    private Node[] firstR;

    /**
     * Column vertex keeper.
     */
    private Node[] firstC;

    /**
     * Node that keeps edges of graph.
     */
    protected static class Node {

        private Node rPrev;
        private Node rNext;
        private Node cPrev;
        private Node cNext;

        private Edge edge;

        public Node( Edge edge ,
                     Node rPrev,
                     Node rNext,
                     Node cPrev,
                     Node cNext) {

            this.edge = edge;

            this.rPrev = rPrev;
            this.rNext = rNext;
            this.cPrev = cPrev;
            this.cNext = cNext;

        }


        @Override
        public String toString() {
            return edge.toString();
        }

        @Override
        public boolean equals(Object obj) {

            if( obj == this ) {
                return true;
            }

            if( !(obj instanceof Node) ) {
                return false;
            }

            return ( (Node) obj ).edge.equals( this.edge );

        }
    }

    /**
     * Graph constructor.
     * @param numV number of vertices.
     * @throws Exception
     */
    public GtuGraph( int numV , boolean directed ) throws Exception {

        super( directed );

        if( numV < 0 ) {
            throw new Exception("Invalid size of graph.");
        }

        this.numV = numV;

        deletedVertexQueue = new LinkedList<>();

        firstR = new Node[ numV ];
        Arrays.fill( firstR , null );

        firstC = new Node[ numV ];
        Arrays.fill( firstC , null );

    }

    /**
     * Return used number of vertices.
     * @return used number of vertices.
     */
    @Override
    public int getNumV() {
        return numV - deletedVertexQueue.size();
    }

    /**
     * Insert a given edge.
     * @param edge The new edge
     * @throws Exception
     */
    @Override
    public void insert( Edge edge ) throws Exception {

        insertWrapper( edge );

        if( !isDirected() ) {
            insertWrapper( new Edge( edge.getDest() , edge.getSource() ) );
        }

    }

    /**
     * Insert a given edge. (Wrapper class)
     * @param edge The new edge
     * @throws Exception
     */
    private void insertWrapper( Edge edge ) throws Exception {


        if( edge == null ) {
            throw new UnsupportedOperationException("Null edge cannot be added.");
        }

        if( edge.getSource() == edge.getDest() ) {
            throw new UnsupportedOperationException("Loop is not allowed on targeted graph.");
        }

        if( edge.getSource() < 0 || edge.getDest() < 0 ) {
            throw new Exception("Vertex cannot be represented with negative number.");
        }

        if( edge.getSource() > (numV - 1)  || edge.getDest() > (numV - 1) ) {
            throw new Exception("Overflowed vertex index. More vertex can be added with insertion operation.");
        }

        if( deletedVertexQueue.contains( edge.getSource() )
                || deletedVertexQueue.contains( edge.getDest() )  ) {

            throw new Exception("Edge contains invalid vertex index as a source or a destination.");
        }

        int source = edge.getSource();
        int dest = edge.getDest();

        Node newNode = getNewNode( edge );
        Node tempFirstR = firstR[ source ];
        Node tempFirstC = firstC[ dest ];

        /* Row Setting */

        if( firstR[ source ] == null ) {
            firstR[ source ] = newNode;
        }
        else {

            boolean insertedR = false;
            while ( tempFirstR.rNext != null && !insertedR ) {

                if( dest < tempFirstR.edge.getDest() ) {
                    insertedR = true;
                }

                if( !insertedR )
                    tempFirstR = tempFirstR.rNext;
            }

            if( !insertedR && tempFirstR.edge.getDest() < dest ) {

                newNode.rPrev = tempFirstR;
                tempFirstR.rNext = newNode;

            } else {

                Node rPrev = tempFirstR.rPrev;
                newNode.rPrev = rPrev;
                newNode.rNext = tempFirstR;

                tempFirstR.rPrev = newNode;

                if( rPrev == null ) {
                    firstR[source] = newNode;
                } else {
                    rPrev.rNext = newNode;
                }
            }
        }

        /* End of row setting */

        /* Column Setting */

        if( firstC[ dest ] == null ) {
            firstC[ dest ] = newNode;
        }
        else {

            boolean insertedC = false;

            while ( tempFirstC.cNext != null && !insertedC ) {

                if( source < tempFirstC.edge.getSource()) {
                    insertedC = true;
                }

                if( !insertedC )
                    tempFirstC = tempFirstC.cNext;
            }

            if( !insertedC && tempFirstC.edge.getSource() < source ) {

                newNode.cPrev = tempFirstC;
                tempFirstC.cNext = newNode;

            } else {

                Node cPrev = tempFirstC.cPrev;
                newNode.cPrev = cPrev;
                newNode.cNext = tempFirstC;

                tempFirstC.cPrev = newNode;

                if( cPrev == null ) {
                    firstC[dest] = newNode;
                } else {
                    cPrev.cNext = newNode;
                }
            }
        }

        /* End of column setting */
    }

    /**
     * Return a new raw edge.
     * @param edge edge
     * @return new raw edge that has no reference.
     */
    private Node getNewNode( Edge edge ) {
        return new Node( edge , null , null,
                null , null );
    }


    /**
     * String representation of specific vertex.
     * @param vertex vertex as integer.
     * @return String representation of given vertex list.
     */
    public String rowListOfVertexAsString( int vertex ) {

        if( vertex < 0 || vertex > (numV - 1)  ) {
            throw new IndexOutOfBoundsException("Invalid vertex index.");
        }

        if( firstR[ vertex ] == null ) {
            return "";
        }

        StringBuilder str = new StringBuilder();

        Node tempFirstR = firstR[ vertex ];

        while (  tempFirstR != null  ) {

            if( tempFirstR.rNext != null ) {
                str.append( tempFirstR ).append(" ->");
            } else {
                str.append( tempFirstR );
            }

            tempFirstR = tempFirstR.rNext;
        }

        return str.toString();
    }


    /**
     * String representation of specific row vertex.
     * @param vertex vertex as integer.
     * @return String representation of given column vertex list.
     */
    public String columnListOfVertexAsString( int vertex ) {

        if( vertex < 0 || vertex > (numV - 1) ) {
            throw new IndexOutOfBoundsException("Invalid vertex index.");
        }

        if( firstC[ vertex ] == null ) {
            return "";
        }

        StringBuilder str = new StringBuilder();

        Node tempFirstC = firstC[ vertex ];

        while (  tempFirstC != null  ) {

            if( tempFirstC.cNext != null ) {
                str.append( tempFirstC ).append("\n").append("\t\t\t\u2193").append("\n");
            } else {
                str.append( tempFirstC );
            }

            tempFirstC = tempFirstC.cNext;
        }

        return str.toString();
    }


    /**
     * Check whether edge which exists with given source and dest.
     * @param source The source vertex
     * @param dest The destination vertex
     * @return true if given edge exists otherwise return false.
     */
    @Override
    public boolean isEdge(int source, int dest) {

        if( source < 0 || source > (numV - 1)  || dest < 0 || dest > (numV - 1) ) {
            return false;
        }

        if(  firstR[ source ] == null || firstC[ dest ] == null ) {
            return false;
        }

        Node tempFirstR = firstR[source];
        Node tempFirstC = firstC[dest];

        while( tempFirstR != null && tempFirstR.edge.getDest() != dest ) {
            tempFirstR = tempFirstR.rNext;
        }

        while( tempFirstC != null && tempFirstC.edge.getSource() != source ) {
            tempFirstC = tempFirstC.cNext;
        }

        return (tempFirstR != null) && ( tempFirstR == tempFirstC );
    }


    /**
     * Return the given edge.
     * @param source The source vertex
     * @param dest The destination vertex
     * @return edge with given source and destination otherwise null.
     */
    @Override
    public Edge getEdge(int source, int dest) {

        if( !isEdge( source , dest )) {
            return null;
        }

        Edge returnedEdge = null;
        Node tempFirstR = firstR[source];

        while ( tempFirstR != null && returnedEdge == null ) {

            if( tempFirstR.edge.getDest() == dest ) {
                returnedEdge = tempFirstR.edge;
            }

            tempFirstR = tempFirstR.rNext;
        }

        return returnedEdge;
    }

    /**
     * Delete given edge from graph.
     * @param edge The edge that will be deleted.
     * @return true if it is deleted otherwise return false.
     */
    @Override
    public boolean deleteEdge(Edge edge) {

        boolean first = deleteEdgeWrapper( new Edge( edge.getDest() , edge.getSource() ));

        if( !isDirected() ) {
            first = deleteEdgeWrapper( new Edge( edge.getDest() , edge.getSource() )) && first;
        }

        return first;
    }

    /**
     * Delete given edge from graph.(Wrapper Class)
     * @param edge The edge that will be deleted.
     * @return true if it is deleted otherwise return false.
     */
    public boolean deleteEdgeWrapper(Edge edge) {

        if( !isEdge( edge.getSource() , edge.getDest()) ) {
            return false;
        }

        Node removedNode = getNewNode( edge );

        Node tempNextNodeR;
        Node tempFirstR = firstR[ edge.getSource() ];

        if( removedNode.equals( tempFirstR ) ) {

            tempNextNodeR = tempFirstR.rNext;

            if( tempNextNodeR != null  ) {
                tempNextNodeR.rPrev = null;
            }

            tempFirstR.rNext = null;
            firstR[ edge.getSource() ] = tempNextNodeR;

        } else {

            while ( !tempFirstR.rNext .equals( removedNode )  ) {
                tempFirstR = tempFirstR.rNext;
            }

            removedNode = tempFirstR.rNext;
            tempNextNodeR = tempFirstR.rNext.rNext;

            tempFirstR.rNext = tempNextNodeR;

            if( tempNextNodeR != null ) {
                tempNextNodeR.rPrev = tempFirstR;
            }

            removedNode.rPrev = removedNode.rNext = null;

        }


        Node tempNextNodeC;
        Node tempFirstC = firstC[ edge.getDest() ];

        if( removedNode.equals( tempFirstC ) ) {

            tempNextNodeC = tempFirstC.cNext;

            if( tempNextNodeC != null  ) {
                tempNextNodeC.cPrev = null;
            }

            tempFirstC.cNext = null;
            firstC[ edge.getDest() ] = tempNextNodeC;

        } else {

            while ( !tempFirstC.cNext .equals( removedNode )  ) {
                tempFirstC = tempFirstC.cNext;
            }

            removedNode = tempFirstC.cNext;
            tempNextNodeC = tempFirstC.cNext.cNext;
            tempFirstC.cNext = tempNextNodeC;

            if( tempNextNodeC != null ) {
                tempNextNodeC.cPrev = tempFirstC;
            }

            removedNode.cPrev = removedNode.cNext = null;

        }

        return true;
    }

    /**
     * Insert an vertex and return new vertex id.
     * @return new vertex id as an integer.
     */
    @Override
    public int insertVertex( ) {

        if( !deletedVertexQueue.isEmpty() ) {
            return deletedVertexQueue.poll();
        }

        int index = numV;
        Node[] newFirstR = new Node[ numV + 1 ];
        Node[] newFirstC = new Node[ numV + 1 ];

        System.arraycopy( firstR , 0 , newFirstR , 0 , numV );
        System.arraycopy( firstC , 0 , newFirstC , 0 , numV );

        Arrays.fill( newFirstR , numV , (newFirstR.length - 1) , null );
        Arrays.fill( newFirstC , numV , (newFirstR.length - 1) , null );

        firstR = newFirstR;
        firstC = newFirstC;

        numV += 1;

        return index;
    }

    /**
     * Delete given vertex.
     * @param vertex vertex that will be deleted.
     * @return true if it is deleted otherwise return false.
     * @throws Exception
     */
    @Override
    public boolean deleteVertex( int vertex ) throws Exception {

        if( vertex < 0 || vertex > (numV - 1) ) {
            return false;
        }

        if( deletedVertexQueue.contains( vertex ) ) {
            throw new Exception("This vertex has been already deleted before.");
        }

        Edge removedEdge;

        Node tempFirstR = firstR[ vertex ];
        while ( tempFirstR != null ) {

            removedEdge = tempFirstR.edge;
            tempFirstR = tempFirstR.rNext;

            if( !deleteEdge( removedEdge ) ) {
                return false;
            }
        }
        firstR[ vertex ] = null;


        Node tempFirstC = firstC[ vertex ];
        while ( tempFirstC != null ) {

            removedEdge = tempFirstC.edge;
            tempFirstC = tempFirstC.rNext;

            if( !deleteEdge( removedEdge ) ) {
                return false;
            }
        }

        firstC[ vertex ] = null;
        deletedVertexQueue.offer( vertex );

        return true;
    }

    /**
     * Return an iterator on given source vertex to iterate over edges.
     * @param source The source vertex
     * @return iterator with given source vertex.
     * @throws Exception
     */
    @Override
    public Iterator<Edge> edgeIterator( int source ) throws Exception {

        if( source < 0 || source > numV ) {
            throw new Exception("Invalid vertex index.");
        }

        if( deletedVertexQueue.contains( source ) ) {
            throw new Exception("This vertex has been deleted before.");
        }

        return new GtuGraphIter( source );
    }

    /**
     * Iterator class that will iterate over edges.
     */
    protected class GtuGraphIter implements Iterator<Edge> {

        private Node list;

        public GtuGraphIter( final int source ) {
            list = firstR[ source ];
        }

         @Override
         public boolean hasNext() {
            return list != null;
         }

         @Override
         public Edge next() {

             Edge returned = null;

            if( list == null ) {
                return null;
            } else {
               returned = list.edge;
            }

            list = list.rNext;

            return returned;
         }
     }
}
