package Stacks;// PW Raghav

import java.util.Stack;

public class CelebrityProblem {
    public static void main(String[] args) {
        int[][] people = {
                {0,0,1,0},
                {0,0,1,0},
                {0,0,0,0},
                {0,0,1,0}
        };
        // Here, 2nd person is celebrity, not 0th, 1st, & 3rd;

        System.out.println(solve(people));
    }

    static int solve(int[][] people) {
        Stack<Integer> st = new Stack<>();
        int n = people.length;
        for(int i = 0; i < n; i++) {
            st.push(i);
        }

        while(st.size() > 1) {
            int p1 = st.pop();
            int p2 = st.pop();

            if(people[p1][p2] == 0) {
                st.push(p1);
            }
            else if(people[p2][p1] == 0) {
                st.push(p2);
            }
        }

        if(st.size() == 0) return -1; // No celebrity

        int potential = st.pop();

        for(int i = 0; i < n; i++) {
            if(i == potential) continue;

            if(people[potential][i] == 1) return -1;
            if(people[i][potential] == 0) return -1;
        }

        return potential;
    }
}
