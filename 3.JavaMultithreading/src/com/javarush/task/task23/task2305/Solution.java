package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution solution = new Solution();
        Solution solution2 = new Solution();
        Solution.InnerClass example1 = new Solution().new InnerClass();
        Solution.InnerClass example2 = new Solution().new InnerClass();
        solution.innerClasses[0] = example1;
        solution.innerClasses[1] = example2;
        solution2.innerClasses[0] = example1;
        solution2.innerClasses[1] = example2;
        return new Solution[] {solution, solution2};
    }

    public static void main(String[] args) {

    }
}
