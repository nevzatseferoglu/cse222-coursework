package edu.gtu;
import java.util.Iterator;

/** Interface to specify a Graph ADT. A graph is a set of vertices and
 a set of edges. Vertices are represented by integers
 from 0 to n minus 1. Edges are ordered pairs of vertices.
 Each implementation of the Graph interface should
 provide a constructor that specifies the number of
 vertices and whether or not the graph is directed.
 */
public interface Graph {

    // Accessor Methods

    /** Return the number of vertices.
     @return The number of vertices
     */
    int getNumV();

    /** Determine whether this is a directed graph.
     @return true if this is a directed graph
     */
    boolean isDirected();

    /** Insert a new edge into the graph.
     @param edge The new edge
     */
    void insert(Edge edge) throws Exception;

    /** Determine whether an edge exists.
     @param source The source vertex
     @param dest The destination vertex
     @return true if there is an edge from source to dest
     */
    boolean isEdge(int source, int dest);

    /** Get the edge between two vertices.
     @param source The source vertex
     @param dest The destination vertex
     @return The Edge between these two vertices
     or null if there is no edge
     */
    Edge getEdge(int source, int dest);

    /**
     * Delete the the given edge
     * @param edge The edge that will be deleted.
     * @return true if edge successfully deleted , otherwise return false.
     */
    boolean deleteEdge( Edge edge );

    /**
     * Insert an index to graph automatically.
     * @return assigned vertexID otherwise return -1.
     */
    int insertVertex( );

    /**
     * Delete a vertex to graph
     * @param vertexID The id that will be belong to graph.
     * @return true if vertex successfully deleted , otherwise return false.
     */
    boolean deleteVertex( int vertexID ) throws Exception;



    /** Return an iterator to the edges connected to a given vertex.
     @param source The source vertex
     @return An Iterator<Edge> to the vertices connected to source
     */
    Iterator<Edge> edgeIterator(int source) throws Exception;
}


