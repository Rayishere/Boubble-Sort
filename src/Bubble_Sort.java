import java.util.Arrays;	
import java.util.Scanner;
import java.io.*;

public class Bubble_Sort {
	static int temporary, oot , random = 1000;
		public static void BoubbleSort(int[ ] arr1) {
			
			for ( int i = 0 ; i < arr1.length - 1 ; i++ )
				for ( int j = 0 ; j < arr1.length - 1 - i ; j++)
					if ( arr1 [ j ] > arr1 [ j + 1 ])
					{
						Exchange (arr1,j, j+1);
					}
			for(int i=0;i<arr1.length;i++) System.out.print(arr1[i]+" ");
			System.out.println();
		}
		
		public static void QuickSort (int[ ] arr2 , int L, int R)
		{
				if  (L <= R)
					{return;}
					int pivotIndex = (L + R ) / 2;
					int pivot = arr2[pivotIndex];
					Exchange (arr2 ,   pivotIndex, R);
					int swapIndex = L ;
					for (int i = L;i < R ; i++)
						if (arr2[i] <= pivot) 
						{
							Exchange(arr2, i, swapIndex);
							swapIndex++;
						}
					Exchange(arr2, swapIndex, R);
					QuickSort(arr2, L, swapIndex - 1);
					QuickSort(arr2, swapIndex + 1, R);
			}
		public static void Exchange (int [ ] arr3, int i , int j)
		{
			temporary = arr3[ i ];
			arr3 [ i ] = arr3 [ j ];
			arr3[ j ] = temporary;
		}	
		public static void main(String[] args) throws IOException {

			BufferedWriter in = new BufferedWriter(new FileWriter("B0244139_result.txt"));
			
			// Enter the Amounts of Data
			System.out.println("Enter the Amounts of Data:");
			oot = new Scanner(System.in).nextInt();
			System.out.println("Amounts of Data:" + oot);
			in.write("Amounts of Data:" + oot);
			int array1[] = new int[oot];
			for (int i = 0; i < oot; i++)
				array1[i] = (int) (Math.random() * random + 1);

			// Before Sort
			if (oot <= 7500) {
				System.out.println("Before Sort:");
				in.write("\r\n\r\nBefore Sort:\r\n");
				for (int i = 0; i < oot; i++) {
					System.out.print(array1[i] + ",");
					in.write(array1[i] + ",");
				}
			}
			int array2[] = Arrays.copyOf(array1, array1.length);
			System.out.println();

			// After QuickSort
			long start2 = System.currentTimeMillis();
			System.out.println("QuickSort:");
			in.write("\r\n\r\nQuickSort:\r\n");
			QuickSort(array2, 0, array1.length - 1);
			long end2 = System.currentTimeMillis();
			if (oot <= 7500)
				for (int i = 0; i <oot; i++) {
					System.out.print(array2[i] + ",");
					in.write(array2[i] + ",");
				}
			System.out.println("\nUsing Time:" + (end2 - start2) + " ms");
			in.write("\r\n\r\nUsing Time:" + (end2 - start2) + " ms");
			
			// After BubbleSort
			long start = System.currentTimeMillis();
			System.out.println("BubbleSort:");
			in.write("\r\n\r\nBubbleSort:\r\n");
			BoubbleSort(array1);
			long end = System.currentTimeMillis();
			if (oot <= 7500)
				for (int i = 0; i < oot; i++) {
					System.out.print(array1[i] + ",");
					in.write(array1[i] + ",");
				}
			System.out.println("\nUsing Time:" + (end - start) + " ms");
			in.write("\r\n\r\nUsing Time:" + (end - start) + " ms");

			// Close BufferedWriter
			in.close();
		}
	}				

	

