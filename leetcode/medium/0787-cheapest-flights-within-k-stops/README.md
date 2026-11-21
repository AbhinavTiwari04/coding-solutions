# Cheapest Flights Within K Stops

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

There are `n` cities connected by some number of flights. You are given an array `flights` where `flights[i] = [fromi, toi, pricei]` indicates that there is a flight from city `fromi` to city `toi` with cost `pricei`.

You are also given three integers `src`, `dst`, and `k`, return  ***the cheapest price**  from  *`src`*  to  *`dst`*  with at most  *`k`*  stops. *If there is no such route, return `-1`.

 

Original
Java
 **Example 1:** 

```
Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
Output: 700
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.

```

 **Example 2:** 

```
Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
Output: 200
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 2 is marked in red and has cost 100 + 100 = 200.

```

 **Example 3:** 

```
Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
Output: 500
Explanation:
The graph is shown above.
The optimal path with no stops from city 0 to 2 is marked in red and has cost 500.

```

 

 **Constraints:** 

- 2 <= n <= 100
- 0 <= flights.length <= (n * (n - 1) / 2)
- flights[i].length == 3
- 0 <= fromi, toi < n
- fromi != toi
- 1 <= pricei <= 104
- There will not be any multiple flights between two cities.
- 0 <= src, dst, k < n
- src != dst

## Solution

**Language:** Java  
**Runtime:** 6 ms (beats 85.26%)  
**Memory:** 46 MB (beats 83.58%)  
**Submitted:** 2026-11-21T13:53:47.031Z  

```java
class Solution {
    // for building own adjacency arraylist
    public class Edge{
        int src, dest, wt;
        public Edge(int s, int d, int w){
            src=s;
            dest=d;
            wt=w;
        }
    }
    // for processing the BFS on each nodes and there unnderlying information
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
```

---

[View on LeetCode](https://leetcode.com/problems/cheapest-flights-within-k-stops/)