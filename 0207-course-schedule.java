/*
  There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

  For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
  Return true if you can finish all courses. Otherwise, return false.

  Time: O(n)
  Space: O(n^2)
*/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> prerequisitesMap = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        for (int[] pair : prerequisites) {
            if (!prerequisitesMap.containsKey(pair[0])) {
                prerequisitesMap.put(pair[0], new ArrayList<Integer>());
            }
            prerequisitesMap.get(pair[0]).add(pair[1]);
        }

        for (int currCourse = 0; currCourse < numCourses; currCourse++) {
            if (!dfs(currCourse, prerequisitesMap, visited)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int currCourse, Map<Integer, List<Integer>> prerequisitesMap, Set<Integer> visited) {
        if (visited.contains(currCourse)) {
            return false;
        }

        List<Integer> prerequisites = prerequisitesMap.get(currCourse);

        if (prerequisites == null || prerequisites.isEmpty()) {
            return true;
        }

        visited.add(currCourse);
        for (int prerequisite : prerequisites) {
            if (!dfs(prerequisite, prerequisitesMap, visited)) {
                return false;
            }
        }

        visited.remove(currCourse);
        prerequisitesMap.put(currCourse, new ArrayList<Integer>());

        return true;
    }
}
