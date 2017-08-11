package com.example.cr.matrixmincost;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[][] matrix = {{3, 4, 1, 2, 8, 6}, {6, 1, 8, 2, 7, 4}, {5, 9, 3, 9, 9, 5}, {8, 4, 1, 3, 2, 6}, {3, 7, 2, 8, 6, 4}};

        findMinCost(matrix);
    }

    public void findMinCost(int[][] matrix)
    {
        int a = matrix.length;
        int b = matrix[0].length;

        List<Integer> result = new ArrayList<>();
        result.add(1);
        int j=1;

        for(int i=1;i<a-1;i++,j++)
        {
            while(j<b )
            {
                if (matrix[i+1][j+1] < matrix[i][j+1] && matrix[i+1][j+1] < matrix[i+1][j])   //  verify  a[2][2] with  a[1][2] , a[2][1]
                {
                    result.add(j+1);
                    //j=j+1;
                    break;
                }
                else if(matrix[i][j+1] < matrix[i+1][j+1] && matrix[i][j+1] <  matrix[i+1][j])//   verify a[1][2]  <   a[2][2]   a[2][1]
                {
                    result.add(j);
                    i++;
                    break;
                }
                else if(matrix[i+1][j] < matrix[i+1][j+1] && matrix[i+1][j] <  matrix[i][j+1]) //   verify  a[2][1]  <    a[2][2]   a[1][2]
                {
                    result.add(j);
                    break;
                }
            }
        }
        Toast.makeText(MainActivity.this,"the values are" + result,Toast.LENGTH_LONG).show();
    }
}