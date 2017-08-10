package com.example.cr.matrixmincost;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[][] matrix = {{3, 4, 1, 2, 8, 6}, {6, 1, 8, 2, 7, 4}, {5, 9, 3, 9, 9, 5}, {8, 4, 1, 3, 2, 6}, {3, 7, 2, 8, 6, 4}};

        findMinCost(matrix);
    }

    private int findMinCost(int[][] matrix)
    {
        int a = matrix.length;
        int b = matrix[0].length;

        int[][] minCost = new int[a+1][b];
        minCost[0][0] = matrix[0][0];

        //intialize the top row
        for (int i = 1; i < b; i++) {
            minCost[0][i] = minCost[0][i - 1] + matrix[0][i];
        }

        //intilaize the left column
        for (int j = 1; j < a; j++) {
            minCost[j][0] = minCost[j - 1][0] + minCost[j][0];
        }

        //fill up the matrix
        for (int i = 1; i < a; i++) {
            for (int j = 1; j < b; j++) {
                if (minCost[i - 1][j] > minCost[i][j - 1]) {
                    minCost[i][j] = minCost[i][j - 1] + minCost[i][j];
                } else {
                    minCost[i][j] = minCost[i - 1][j] + minCost[i][j];
                }
            }
        }
        return minCost[a-1][b-1];
    }
}