class Solution {
    public static class Edge{
        int src,dest,wt;
        public Edge(int s, int d, int w){
            src=s;
            dest=d;
            wt=w;
        }
    }
    public static class Pair implements Comparable<Pair>{
        int node, dist;
        public Pair(int n, int d){
            node=n;
            dist=d;
        }
        @Override
        public int compareTo(Pair p2){
            return this.dist-p2.dist;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[], int V, int [][]ref){
        for(int i=0;i<V;i++)
            graph[i]=new ArrayList<Edge>();

        for(int []edge: ref){
            int src=edge[0]-1, dest=edge[1]-1, wt=edge[2];
            graph[src].add(new Edge(src, dest, wt));
        }
    }
    public static int dijkstra(ArrayList<Edge> graph[], int n, int src){
        PriorityQueue<Pair> pq=new PriorityQueue<Pair>();
        pq.offer(new Pair(src,0));

        boolean vis[]=new boolean[n];
        int dist[]=new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src]=0;

        while(!pq.isEmpty()){
            Pair p=pq.poll();
            if(!vis[p.node]){
                vis[p.node]=true;
                for(int i=0;i<graph[p.node].size();i++){
                    Edge e=graph[p.node].get(i);
                    int u=e.src;
                    int v=e.dest;
                    if(dist[u]!=Integer.MAX_VALUE && dist[u]+e.wt< dist[v]){
                        dist[v]=dist[u]+e.wt;
                        pq.offer(new Pair(v, dist[v]));
                    }
                }
            }
        }
        int ans=0;
        for(int k: dist){
            if(k==Integer.MAX_VALUE)return -1;
            ans=Math.max(ans, k);
        }
        return ans;
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        // create adjacency list
        // pair class amd edge class
        // dijkstra algo 
        // sum of shortest time to reach all nodes + check if any index is -1 then return -1
        ArrayList<Edge>graph[]=  new ArrayList[n];
        createGraph(graph, n, times);
        return dijkstra(graph, n, k-1);

    }

}