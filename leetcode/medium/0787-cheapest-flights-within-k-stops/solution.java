class Solution {
    public class Edge{
        int src, dest, wt;
        public Edge(int s, int d, int w){
            src=s;
            dest=d;
            wt=w;
        }
    }
    public class Pair{
        int src, cost, stops;
        public Pair(int n,int c, int s){
            src=n;
            cost=c;
            stops=s;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
       ArrayList<Edge> graph[]=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<Edge>();
        }

        for(int s[]: flights){
            int sr= s[0];
            int dest= s[1];
            int wt= s[2];

            graph[sr].add(new Edge(sr, dest, wt));
        }

        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(src, 0, -1));

        int dist[]=new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src]=0;

        while(!q.isEmpty()){
            Pair p=q.poll();
            int u=p.src;
            int cost= p.cost;
            int stops=p.stops;

            for(int i=0;i<graph[u].size();i++){
                Edge e=graph[u].get(i);
                int v= e.dest;
                // verify later
                int wt= e.wt;
                if(dist[v]>cost+ wt && stops +1 <= k){
                    dist[v]=cost + wt;
                    q.offer(new Pair(v, dist[v], stops+1));
                }
            }
        }

       if(dist[dst]==Integer.MAX_VALUE)return -1;
       return dist[dst];
    }
}