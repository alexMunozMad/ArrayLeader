import java.util.ArrayList;

public class Solution {

	public static void main(String[] args) {
		

	}

	public int[] solution(int K, int M, int[] A) {
		int[] solved = new int[2];
		
		
		return solved;		
	}
	
	public int[] antiguo() {
		int arr[] = {10, 9, 14, 23, 15, 0, 9};
		int[] solution = new int[2];
	    int size = arr.length;
	    for (int i = 0; i < size; i++) 
	        {
	            int j;
	            for (j = i + 1; j < size; j++) 
	            {
	                if (arr[i] <= arr[j])
	                    break;
	            }
	            if (j == size) {
	                System.out.print(arr[i] + " ");
	            }
	            solution[0] = arr[i];
	            solution[1] = size;
	      }
	    return solution;
	}
	
	public int getPopularElement(int[] a)
	{
	  int count = 1, tempCount;
	  int popular = a[0];
	  int temp = 0;
	  for (int i = 0; i < (a.length - 1); i++)
	  {
	    temp = a[i];
	    tempCount = 0;
	    for (int j = 1; j < a.length; j++)
	    {
	      if (temp == a[j])
	        tempCount++;
	    }
	    if (tempCount > count)
	    {
	      popular = temp;
	      count = tempCount;
	    }
	  }
	  return popular;
	}
	
}
