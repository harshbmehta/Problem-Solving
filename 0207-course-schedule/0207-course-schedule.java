class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer> []adjList = new LinkedList[numCourses];
        int []visited = new int[numCourses]; // initialize with 0 by default

        // Initialize adjList
        for(int i=0;i<numCourses; i++) {
            adjList[i] = new LinkedList<>();
        }

        // Populate adjList
        for(int i=0; i<prerequisites.length; i++) {
            adjList[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        
        // For loop is required if the graph is not connected eg 0->10, 3->18
        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (isCyclic(adjList, visited, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isCyclic(List []adjList, int[] visited, int curr) {
        if(visited[curr] == 2) {
            return true;
        }
        visited[curr] = 2;
        Iterator<Integer> iter = adjList[curr].listIterator();
        while(iter.hasNext()) {
            int n = iter.next();
            if(visited[n] != 1) {
                if(isCyclic(adjList, visited, n)) {
                    return true;
                }
            }
        }
        visited[curr] = 1;
        return false;
    } 
}