package TestForAlgorithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CourseTable {

    public static void main(String[] args) {

        int[][] input = new int[][]{{1,0}};
        System.out.println(canFinish(2, input));

    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> edges = new ArrayList<>();
        for(int i=0; i<numCourses; i++){     // 用来记录课程的关系
            edges.add(new ArrayList<Integer>());   // edges.get(i)  返回 所有前置课程有i的课程
        }

        int[] degree = new int[numCourses]; //用来记录度数，度数这门课的前置课程数量
        for(int[] edge : prerequisites){
            edges.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
        }

        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=0; i<degree.length; i++){
            if(degree[i] == 0){   //把没有前置课程的可加入deque进行BFS遍历
                deque.offerLast(i);
            }
        }

        int complete = 0;
        while(!deque.isEmpty()){
            int cur = deque.pollFirst();
            // 遍历前置课程有cur的课程
            complete++;
            for(int course : edges.get(cur)){

                degree[course]--;  //把这门课的度数-1,前置课程(cur)修掉了
                if(degree[course] == 0){ //如果这门课程所有前置课程修完了，
                    deque.offerLast(course);
                }
            }
        }
        return complete == numCourses;
    }
}
