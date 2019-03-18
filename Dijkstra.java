import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

class readerFast {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                    reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }

    static long nextLong() throws IOException {
        return Long.parseLong( next() );
    }
}

//Vertex class for vertices with edge weight, used in addEdge();
class Vertex{
    int vertex;
    int weight;
    public Vertex(int vertex,int weight ){
        this.vertex=vertex;
        this.weight=weight;
    }

    public int getVertex() {
        return vertex;
    }

    public int getWeight() {
        return weight;
    }
}

class Graph{
    public int distance[];          //initialized with infinite
    ArrayList<ArrayList<Vertex>> adjList;
    int no_V;
    //Set S contains the vertices whose distances have been finalized
    Set<Integer> S;

    PriorityQueue<Vertex> minHeap;

    public Graph(int no_V){
      //initializing adjacency list
      this.no_V=no_V;
      S=new HashSet<Integer>();
      adjList=new ArrayList<ArrayList<Vertex>>(no_V+1);
      adjList.add(new ArrayList<Vertex>());         //ignore
      distance=new int[no_V+1];
      for(int i=1;i<=no_V;i++) {
          ArrayList<Vertex> temp = new ArrayList<Vertex>();
          temp.add(new Vertex(0,0));
          adjList.add(temp);
          distance[i] = Integer.MAX_VALUE;
      }
      minHeap=new PriorityQueue<Vertex>(1,new Comparator<Vertex>() {
            @Override
            public int compare(Vertex o1, Vertex o2) {
                return o1.weight-o2.weight;
            }
        });

    }

    void addEdge(int V1,int V2,int weight){
      //adding an edge in the graph
      adjList.get(V1).add(new Vertex(V2,weight));
    }

    public void dijkstra(int source){
        distance[source]=0;
        //add source to min heap/priority queue
        minHeap.add(new Vertex(source,distance[source]));
        //while set S doesn't contain all the vertices in the graph
        while(S.size()!=no_V){
           // System.out.println("Iteration ");
            int u=minHeap.remove().vertex;     //removing the node with minimum distance
            S.add(u);
            //for all neighbours v of u
            for(int i=1;i<adjList.get(u).size();i++){
               // System.out.println("Inner Iteration");
                int v=adjList.get(u).get(i).vertex;
                //if distance of v hasn't been finalized
                if(S.contains(v)==false){
                    //if distance of v can be decreased
                    if(distance[v]>(distance[u]+adjList.get(u).get(i).weight)){
                        distance[v]=distance[u]+adjList.get(u).get(i).weight;
                    }
                    //add v to minheap/priority queue
                    minHeap.add(new Vertex(v,distance[v]));
                }

            }

        }
    }

}

public class Dijkstra {

    public static void main(String[] args) throws IOException{

        System.out.println("Indexing starts from 1 for everything...");

        readerFast.init(System.in);
        //reading number of vertices,edges,and the source vertex
        System.out.print("Enter number of vertices:  ");
        int no_of_vertices=readerFast.nextInt();
        System.out.print("Enter number of edges:  ");
        int no_of_edges=readerFast.nextInt();
        System.out.print("Enter the source vertex:  ");
        int source=readerFast.nextInt();

        //creating a graph with given number of vertices
        Graph obj=new Graph(no_of_vertices);

        //add edges in the graph
        for(int i=0;i<no_of_edges;i++){
            System.out.print("Enter the source, destination and weight of the edge "+(i+1)+":  ");
            int V1=readerFast.nextInt();
            int V2=readerFast.nextInt();
            int weight=readerFast.nextInt();
            obj.addEdge(V1,V2,weight);
        }

        obj.dijkstra(source);

        System.out.println("\nDijkstra is Starting\n");
        for(int i=1;i<=no_of_vertices;i++){
            System.out.println("The shortest path from node "+ source +" to vertex "+i+" is "+obj.distance[i]);
        }

    }

}
