import java.io.*;
import java.util.*;

public class Graph {
    int [][] a; 
    int n;
    char v[];
    int deg[];
    int count = 0;
    static int INF = 99; // 99 is considered as infinite value
    
    Graph() {
        v = "ABCDEFGHIJKLMNOP".toCharArray();
        deg = new int[20];
        a = new int[20][20];
        n = 0;
    }
    
    //Load data from file
    void loadData(String data, int k) {
        RandomAccessFile f;int i,j,x;
        String s; StringTokenizer t;
        a = new int[20][20];
        try{
            f = new RandomAccessFile(data,"r");
            for(i = 0; i < k; i++) 
                f.readLine();//ignores the first k-1 lines
            
            s = f.readLine();//just use the data in the k-th line
            s = s.trim();
            n = Integer.parseInt(s);
            for(i = 0; i < n; i++) {
                s = f.readLine();
                s = s.trim();
                t = new StringTokenizer(s);
                for(j = 0; j < n; j++) { 
                    x = Integer.parseInt(t.nextToken().trim());
                    a[i][j] = x;
                }
            }
            
            f.close();
        }catch(Exception e) {}
    }

    void dispAdj() {
        int i,j;
        for(i = 0; i < n; i++) {
            System.out.println();
            for(j = 0; j < n; j++)
                System.out.printf("%4d",a[i][j]);
        }
    }
    
    void fvisit(int i, RandomAccessFile f) throws Exception {
        f.writeBytes("  " + v[i]);
    }
    
    void fvisit2(int i, RandomAccessFile f) throws Exception {
        f.writeBytes("\n  " + i);
    }
    
    void fvisit3(RandomAccessFile f) throws Exception {
        f.writeBytes("\n");
    }
    
    void fdispAdj(RandomAccessFile f) throws Exception { 
        int i,j;
        f.writeBytes("n = "+n+"\r\n");
        for(i = 0; i < n; i++) {
            f.writeBytes("\r\n");
            for(j = 0; j < n; j++) 
                f.writeBytes("  " + a[i][j]);
        }
        f.writeBytes("\r\n");
    }

    //Bread first traverse from vertex k  
    void breadth(int k, RandomAccessFile f) throws Exception {
        Queue q = new Queue();
        int i,h;
        boolean [] enqueued = new boolean[n];
        for(i = 0; i < n; i++) 
            enqueued[i] = false;
        
        q.enqueue(k);
        enqueued[k] = true;
        
        while(!q.isEmpty()){
            h = q.dequeue();
            fvisit(h, f); 
            
            for(i = 0; i < n; i++)
                if(!enqueued[i] && a[h][i]>0) {
                    q.enqueue(i);
                    enqueued[i] = true;
                }
        }      
    }
    
    void bfsTraversal(int k, RandomAccessFile f) throws Exception {
        //------ Start your code here----------------------------------------
        Queue q = new Queue();
        int i,h;
        count = 0;
        boolean [] enqueued = new boolean[n];
        for(i = 0; i < n; i++) 
            enqueued[i] = false;
        
        q.enqueue(k);
        enqueued[k] = true;
        
        while(count != 4){
            h = q.dequeue();
            fvisit(h, f); 
            count++;
            for(i = 0; i < n; i++)
                if(!enqueued[i] && a[h][i]>0) {
                    q.enqueue(i);
                    enqueued[i] = true;
                }
        }              //------ End your code here------------------------------------------
    }
    
    void depth_rec(boolean [] visited,int k, RandomAccessFile f) throws Exception {
        fvisit(k,f);
        visited[k] = true; 
        for(int i = 0; i < n; i++) {
            if(!visited[i] && a[k][i]>0 && a[k][i]<99) 
                depth_rec(visited,i,f);        
        }
    }
    
    void depth(int k, RandomAccessFile f) throws Exception {
        boolean [] visited = new boolean[20];
        int i; 
        for(i = 0; i < n; i++) 
            visited[i] = false;
        depth_rec(visited,k,f);
        for(i = 0; i < n; i++) 
            if(!visited[i]) 
                depth_rec(visited,i,f);
    }
    
    void dfsTraversal_rec(boolean [] visited,int k, RandomAccessFile f) throws Exception {
        if (count != 5) {
            count++;
            if (k != 1) {
                fvisit(k,f);
            }
            visited[k] = true; 
            for(int i = 0; i < n; i++) {
                if(!visited[i] && a[k][i]>0 && a[k][i]<99) 
                    dfsTraversal_rec(visited,i,f);        
            }
        }
    }
    
    void dfsTraversal(int k, RandomAccessFile f) throws Exception {
        boolean [] visited = new boolean[20];
        int i; 
        count = 0;
        for(i = 0; i < n; i++) 
            visited[i] = false;
        dfsTraversal_rec(visited,k,f);
        for(i = 0; i < n; i++) 
            if(!visited[i]) 
                dfsTraversal_rec(visited,i,f);
    }
    
    boolean isSafe(int v, int graph[][], int path[], int pos) {
        if (graph[path[pos - 1]][v] == 0)
            return false;
        for (int i = 0; i < pos; i++)
            if (path[i] == v)
                return false;
        return true;
    }

    boolean hamCycleUtil(int graph[][], int path[], int pos) {
        if (pos == n) {
            if(graph[path[pos-1]][path[0]] == 1) 
                return true;
            return false;
        }
        for (int v=1; v<n; v++) {
            if (isSafe(v, graph, path, pos)) {
                path[pos] = v;
                if (hamCycleUtil(graph, path, pos+1) == true)
                    return true;
                //If adding v doesn't lead to a solution 
                path[pos] = -1; //remove v
            }
        }
        //If no vertex can be added to Hamiltonian cycle
        return false;
    }
 
    void hamCycle(int graph[][], RandomAccessFile f) throws Exception {
        int path[] = new int[n];
        for (int i=0; i<n; i++)
            path[i] = -1;
        //Put vertex 0 as the first vertex in the path
        path[0] = 0;
        if (hamCycleUtil(graph, path, 1) == true) {
            //------ Start your code here----------------------------------
            for (int i = 0; i < n; i++) {
                fvisit(path[i], f);
            }
            fvisit(path[0], f);
            //------ End your code here------------------------------------
        }
    } 
    
    void dijkstra2(boolean [] selected, int [] dist, int [] path, int p, int q, 
            boolean [] stopDisplay, RandomAccessFile f) throws Exception {
        int curr; 
        for(int i=0; i<n; i++) {
            selected[i] = false;
            stopDisplay[i] = false;
            dist[i] = a[p][i]; 
            path[i] = p; 
        }
        int [] sele = new int[50];
        int nSele = 0; 
        selected[p] = true;
        sele[nSele++] = p;
        curr = p; 
        while(curr!=q) { 
            fvisit(curr, f);
            int t = INF; int k = -1;
            for(int i=0; i<n; i++) {
                if(i==p || selected[i]) continue;
                if(dist[i]<t) {t=dist[i];k=i;}
            }
            if(t==INF) { return; }
            selected[k] = true;
            curr = k;
            sele[nSele++] = k;         
            for(int i=0; i<n; i++) {
                if(i==p || selected[i]) continue;
                if(dist[i]>dist[k]+a[k][i]) {
                    dist[i] = dist[k]+a[k][i];
                    path[i] = k;
                }
            }
            
        }
        fvisit(curr, f);
        fvisit3(f);
    }
    
    void pathDijkstra(int [] dist, int [] path, int p, int q, 
            RandomAccessFile f) throws Exception {
        Stack s = new Stack();
        s.push(q);
        do {
            q=path[q];
            s.push(q);
        } while(q!=p);
        System.out.print(" ");
        while(!s.isEmpty()) {
            q = s.pop(); 
            fvisit(q, f);
        }
        fvisit2(dist[q], f);
    }
    
    void dijkstra(int p, int q, RandomAccessFile f) throws Exception {
        boolean [] selected = new boolean[n];
        boolean [] stopDisplay = new boolean[n];
        int [] dist = new int[n];
        int [] path = new int[n];
        //Shortest path from vertex p to vertex q
        dijkstra2(selected,dist,path,p,q,stopDisplay,f);
        pathDijkstra(dist,path,p,q,f);
    } 

    // This method is used for Question 1
    void f1() throws Exception {
        loadData("data1.txt", 1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if(g123.exists()) g123.delete();
        RandomAccessFile f = new RandomAccessFile(fname, "rw"); 
        breadth(3,f);
        f.writeBytes("\r\n");
    /**
     * Question 1: Perform breadth-first search algorithm on the graph.
     * Starting from the vertex D (which index is 3), ONLY display the vertex 
     * D and the next 3 vertices. 
     * Hint: copy breadth(...) to bfsTraversal(...) and modify the method 
     * bfsTraversal(...) appropriately.
     * The output f1() will be written into file 'f1.txt'. 
     * Therefore you should open this file to see/test your code output.
     * Example: With the graph provided in 'data1.txt', the content of 'f1.txt' 
     * after running this method is:
     *      D  A  G  B  C  E  F  H  I
     *      D  A  G  B
     */
        //-------------------------------------------------------------------
        //------ Start your code here----------------------------------------
        
        bfsTraversal(3,f);
        
        //------ End your code here------------------------------------------
        //-------------------------------------------------------------------       
        f.writeBytes("\r\n");
        f.close();
    }

    // This method is used for Question 2
    void f2() throws Exception {
        loadData("data1.txt", 1);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if(g123.exists()) g123.delete();
        RandomAccessFile f = new RandomAccessFile(fname, "rw"); 
        depth(1,f);
        f.writeBytes("\r\n");
    /**
     * Question 2: Perform depth-first search algorithm on the graph.
     * Starting from the second vertex B (the index of B is 1), ONLY display 
     * the vertex right after B and the next 3 vertices. 
     * Hint: use and modify dfsTraversal(...), dfsTraversal_rec(...) 
     * (provided in this class) appropriately, then call dfsTraversal(...) 
     * in f2().
     * The output f2() will be written into the file 'f2.txt'. 
     * Therefore you should open this file to see/test your code output.
     * Example: With the graph provided in 'data1.txt', the content of 'f2.txt' 
     * after running this method is:
     *      B  A  C  F  H  E  I  D  G
     *      A  C  F  H
     */
        //-------------------------------------------------------------------
        //------ Start your code here----------------------------------------
        
        dfsTraversal(1, f);
        
        //------ End your code here------------------------------------------
        //-------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }
    
    // This method is used for Question 3
    void f3() throws Exception {
        loadData("data2.txt", 1);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if(g123.exists()) g123.delete();
        RandomAccessFile f = new RandomAccessFile(fname, "rw"); 
    /**
     * Question 3: Perform the algorithm for finding the Hamilton cycle on 
     * the graph.
     * You are given a solution to solve the Hamilton cycle problem using 
     * Backtracking. It mainly uses hamCycleUtil(...) to solve the problem 
     * (it returns false if there is no Hamilton cycle, otherwise return 
     * true ...).
     * Your task: Complete the missing code in hamCycle(...) to print out the 
     * solution found with the graph G (given in the data2.txt file). 
     * Hint: Use the fvisit(...) given in this class to print out the solution.
     * The output f3() will be written into the file 'f3.txt'. 
     * Therefore you should open this file to see/test your code output.
     * Example: With the graph provided in 'data2.txt', the content of 'f3.txt' 
     * after running this method is:
     *      A  B  C  E  D  A
     */
        //-------------------------------------------------------------------
        //------ Start your code here----------------------------------------
          
        hamCycle(a,f);
       
        //------ End your code here------------------------------------------
        //-------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }
    
    // This method is used for Question 4
    void f4() throws Exception {
        loadData("data3.txt", 1);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if(g123.exists()) g123.delete();
        RandomAccessFile f = new RandomAccessFile(fname, "rw"); 
    /**
     * Question 4: Perform Dijkstra's algorithm on the graph.
     * Apply the Dijstra’s shortest path algorithm to find the shortest path 
     * from vertex A (the vertex A has an index of 0) to vertex D (the index 
     * of the vertex D is 3), then write 3 lines to the file f4.txt: 
     *      (1) Line 1: contains vertices selected into the set S until the 
     *          vertex D is selected. 
     *      (2) Line 2: contains vertices in shortest path from A to D, and 
     *      (3) Line 3: contains the shortest distance. 
     * Hint: use and modify dijkstra(...), dijkstra2(...), pathDijkstra(...), 
     * fvisit(...), fvisit2(...), fvisit3(...) (provided in this class) 
     * appropriately, then call dijkstra(...) in f4().
     * The output f4() will be written into the file 'f4.txt'. 
     * Therefore you should open this file to see/test your code output.
     * Example: With the graph provided in 'data3.txt', the content of 'f4.txt' 
     * after running these methods is:
     *      A  B  C  E  F  D
     *      A  C  D
     *      22  
     */
        //-------------------------------------------------------------------
        //------ Start your code here----------------------------------------
        
        dijkstra(0,3,f);
        
        //------ End your code here------------------------------------------
        //-------------------------------------------------------------------
        f.writeBytes("\r\n");
        f.close();
    }
}
