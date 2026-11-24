class Solution {
    public static class Edge{
        int src, dest, wt;
        public Edge(int s, int d, int w){
            src=s;
            dest=d;
            wt=w;
        }
    }
    public static class Pair implements Comparable<Pair>{
        int node;
        long cost;
        public Pair(int n, long c){
            node=n;
            cost=c;
        }
        @Override
        public int compareTo(Pair p2){
            return Long.compare(cost, p2.cost);
        }
    }
    public long[] dijkstra(ArrayList<Edge> graph[], int n, int[] rs, int src) {
      PriorityQueue<Pair> q = new PriorityQueue<>();
    
         long[] dist =new long[n];
         int[] received =new int[n];
         boolean[] vis =new boolean[n];

        Arrays.fill(dist, -1);

        dist[src] =0;
        vis[src] =true;

        for (Edge e:graph[src]) {
            q.offer(new Pair(e.dest, e.wt));
        }

        while (!q.isEmpty()) {
            Pair curr =q.poll();
            int node =curr.node;
            long cost =curr.cost;

            if(vis[node])continue;

            received[node]++;

            if (received[node]==rs[node]) {
                vis[node] =true;
                dist[node] =cost;

                for (Edge e :graph[node]) {
                    q.offer(new Pair(e.dest, cost +e.wt));
                }
            }
        }

        return dist;
    }




    public long[] earliestActivationTimes(int n, int[][] edges, int[] rs) {
      ArrayList<Edge> graph[]=new ArrayList[n];
      for(int i=0;i<n;i++)
        graph[i]=new ArrayList<Edge>();

      for(int a[]: edges){
        int src=a[0];
        int dest=a[1];
        int wt=a[2];
        graph[src].add(new Edge(src, dest, wt));
      }  

     return dijkstra(graph, n, rs, 0);
    }
}