# Network Delay Time

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given a network of `n` nodes, labeled from `1` to `n`. You are also given `times`, a list of travel times as directed edges `times[i] = (ui, vi, wi)`, where `ui` is the source node, `vi` is the target node, and `wi` is the time it takes for a signal to travel from source to target.

We will send a signal from a given node `k`. Return  *the  **minimum**  time it takes for all the*  `n`  *nodes to receive the signal*. If it is impossible for all the `n` nodes to receive the signal, return `-1`.

 

Original
Java
 **Example 1:** 

```
Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
Output: 2

```

 **Example 2:** 

```
Input: times = [[1,2,1]], n = 2, k = 1
Output: 1

```

 **Example 3:** 

```
Input: times = [[1,2,1]], n = 2, k = 2
Output: -1

```

 

 **Constraints:** 

- 1 <= k <= n <= 100
- 1 <= times.length <= 6000
- times[i].length == 3
- 1 <= ui, vi <= n
- ui != vi
- 0 <= wi <= 100
- All the pairs (ui, vi) are unique. (i.e., no multiple edges.)

## Solution

**Language:** Java  
**Runtime:** 35 ms (beats 5.26%)  
**Memory:** 46.5 MB (beats 99.98%)  
**Submitted:** 2026-11-13T13:59:26.851Z  

```java
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
        Arrays.fill(graph, new ArrayList<Edge>());
        createGraph(graph, n, times);
        return dijkstra(graph, n, k-1);

    }

}
```

---

[View on LeetCode](https://leetcode.com/problems/network-delay-time/)