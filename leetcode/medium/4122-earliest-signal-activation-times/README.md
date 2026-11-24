# Earliest Signal Activation Times

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given an integer `n` and a  **directed**  graph with `n` nodes labeled from 0 to `n - 1`. The graph is represented by a 2D array `edges`, where `edges[i] = [ui, vi, delayi]` indicates an edge from node `ui` to `vi` along which a signal takes `delayi` units of time to arrive.

Node `u` is an  **incoming neighbor**  of node `v` if there is an edge from `u` to `v`.

Node 0 is  **active**  at time 0, and all other nodes are initially inactive.

When a node becomes active at time `t`, it  **immediately**  sends one signal along each of its  **outgoing**  edges. Once active, a node remains active and does not send its signals again. A signal sent along an edge with delay `d` arrives at time `t + d`.

You are also given an integer array `requiredSignals` of length `n`, where `requiredSignals[i]` is the number of  **distinct incoming**  neighbors of node `i` from which a signal  **must**  arrive before node `i` can activate.

An inactive node `i` becomes active at the  **earliest**  time `t` at which signals have arrived from  **at least**  `requiredSignals[i]`  **distinct incoming**  neighbors.

Return an array `ans` of length `n` where `ans[i]` is the  **earliest**  time node `i` becomes active. If node `i`  **never**  becomes active, `ans[i]` should be -1.

 **Note:**  The value of `requiredSignals[0]` is irrelevant, since node 0 is active at time 0 and sends its outgoing signals at that time.

 

Original
Java
 **Example 1:** 

 **Input:**  n = 3, edges = [[0,1,1],[0,2,1]], requiredSignals = [1,1,2]

 **Output:**  [0,1,-1]

 **Explanation:** 

- Node 0 is active at time 0 and sends signals to nodes 1 and 2.
- At time 1, both signals arrive. Node 1 has received its required 1 signal, so it activates.
- Node 2 requires signals from 2 distinct incoming neighbors, but it has only one incoming neighbor. It never activates.
- Therefore, ans = [0, 1, -1].

 **Example 2:** 

 **Input:**  n = 4, edges = [[0,1,1],[0,2,1],[1,3,2],[2,3,2]], requiredSignals = [3,1,1,2]

 **Output:**  [0,1,1,3]

 **Explanation:** 

- Node 0 is active at time 0, regardless of requiredSignals[0] = 3, and sends signals to nodes 1 and 2.
- At time 1, nodes 1 and 2 each receive their required 1 signal and activate. Each immediately sends a signal to node 3.
- Both signals reach node 3 at time 1 + 2 = 3. They come from two distinct incoming neighbors, so node 3 activates at time 3.
- Therefore, ans = [0, 1, 1, 3].

 **Example 3:** 

 **Input:**  n = 4, edges = [[0,1,2],[1,2,3],[0,2,5],[2,3,1]], requiredSignals = [3,1,2,1]

 **Output:**  [0,2,5,6]

 **Explanation:** 

- Node 0 is active at time 0 and sends signals to nodes 1 and 2.
- Node 1 receives its signal at time 2, activates, and sends a signal to node 2.
- At time 5, node 2 receives the signal from node 0 and the signal from node 1, whose arrival time is 2 + 3 = 5. Its requirement of 2 distinct incoming neighbors is met, so it activates and sends a signal to node 3.
- Node 3 receives that signal at time 5 + 1 = 6 and activates.
- Therefore, ans = [0, 2, 5, 6].

 **Example 4:** 

 **Input:**  n = 4, edges = [[0,1,2],[1,0,1],[1,2,1],[2,3,1],[3,2,1]], requiredSignals = [3,1,2,1]

 **Output:**  [0,2,-1,-1]

 **Explanation:** 

- Node 0 is active at time 0 and sends a signal to node 1.
- Node 1 activates at time 2 and sends signals to nodes 0 and 2, which arrive at time 3.
- Node 0 is already active, so receiving another signal does not cause it to send its signals again.
- Node 2 requires signals from both nodes 1 and 3. It receives only the signal from node 1. Node 3 is waiting for a signal from node 2, so neither node activates.
- Therefore, ans = [0, 2, -1, -1].

 

 **Constraints:** 

- 2 <= n == requiredSignals.length <= 105
- 0 <= edges.length <= 105
- edges[i] = [ui, vi, delayi]
- 0 <= ui, vi <= n - 1
- ui != vi
- 1 <= delayi <= 109
- There is at most one directed edge from any node ui to any node vi.
- 1 <= requiredSignals[i] <= n - 1

## Solution

**Language:** Java  
**Runtime:** 142 ms (beats 51.74%)  
**Memory:** 280.5 MB (beats 53.66%)  
**Submitted:** 2026-11-24T19:52:07.035Z  

```java
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
```

---

[View on LeetCode](https://leetcode.com/problems/earliest-signal-activation-times/)