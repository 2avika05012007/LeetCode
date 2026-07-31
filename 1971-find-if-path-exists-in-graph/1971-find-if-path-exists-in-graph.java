class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        ArrayList<Integer>[] graph = new ArrayList[n];

        for(int i=0;i<n;i++)
            graph[i]=new ArrayList<>();

        for(int[] edge:edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        boolean[] visited=new boolean[n];

        return dfs(graph,visited,source,destination);
    }

    boolean dfs(ArrayList<Integer>[] graph, boolean[] visited,int node,int dest){

        if(node==dest)
            return true;

        visited[node]=true;

        for(int next:graph[node]){
            if(!visited[next]){
                if(dfs(graph,visited,next,dest))
                    return true;
            }
        }

        return false;
    }
}