package aglos5;


public class sortAlgos {

	private	int[] arr;
	
	public sortAlgos(int[] arr)
	{
		this.arr = arr;

	}
	
	public void printList()
	{
		int i = 0;
		String x = " ";
		
		while(i< arr.length)
		{
			if(i ==0)
			{
				x = x + arr[i];
			}
			else
			{
				x = x + " | " + arr[i];
			}
			i++;	
		}
		x = x + "\n";
		
		System.out.println(x);
	}
	
	
	public void BubbleSort()
	{

		int i, j, temp;
		for( i = (arr.length-1); i >= 0; i--)
		{
			for(j = 1; j<= i; j++)
			{
	
				if(arr[j-1] > arr[j])
				{
					temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
	
		}
	
	}
	
	public void SelectionSort()
	{
		int i, j, min, temp;
		for(i = 0; i < arr.length-1;i++)
		{
			min = i;
			for(j = i+1; j < arr.length; j++)
			{
				if(arr[j] < arr[min]) min = j;
			}
			temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
		}
		
	}
	
	public void InsertionSort()
	{
		int i, j, index;
		for(i = 1; i < arr.length; i++)
		{
			index = arr[i];
			j = i;
			while((j>0) && (arr[j-1] > index))
			{
				arr[j] = arr[j-1];
				j = j-1;
			}
			arr[j] = index;
		}
	}
	//recursive version, right most element as pivot
	public void QuickSort(int arr[], int left, int right)
	{
	       if (left < right)
	        {
	         
	            int pi = partition(arr, left, right);
	            
	            QuickSort(arr, left, pi-1);
	            QuickSort(arr, pi+1, right);
	        }
	}
	
	//partition algo
	public int partition(int arr[], int left, int right)
	{
	int pivot = arr[right];
        int i = (left-1); 
        for (int j=left; j<=right-1; j++)
        {
           
            if (arr[j] <= pivot)
            {
                i++;
 
                
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
 
       
        int temp = arr[i+1];
        arr[i+1] = arr[right];
        arr[right] = temp;
 
        return i+1;
	}
	// recursive median of the three as the pivot
	public void QuickSort1(int[] array, int left, int right)
	{
		if( left >= right)
		{
			return;
		}
		
		int first = left;
		int second;
		if( left < right)
		{
			second = left +1;
		}
		else
		{
			second = right;
		}
		int third;
		if( left+1 < right)
		{
			third = left+2;
		}
		else
		{
			third = right;
		}
		int pivot = Math.max(Math.min(array[first],array[second]), 
                Math.min(Math.max(array[first],array[second]),array[third]));
		while (left <= right) 
		   {
		        while (array[left] < pivot)
		        {
		             left++;
		        }

		        while (array[right] > pivot) 
		        {
		             right--;
		        }

		        if (left <= right)
		        {
		             int temp = array[left];
		             array[left] = array[right];
		             array[right] = temp;
		             left++;
		             right--;
		         }
		     }

		if (left < right)
		    QuickSort1(array, left, right);

		if (right > left)
		    QuickSort1(array, left, right);
	}
	
	//non-recursive version 
	public void QuickSort2(int arr[], int firstIndex, int lastIndex)
	{
	int stack[] = new int[lastIndex-firstIndex+1];
	
	int top = -1;
	
	stack[++top] = firstIndex;
	stack[++top] = lastIndex;
	
	while( top >= 0)
	{
		lastIndex = stack[top--];
		firstIndex = stack[top--];
		
		int pi = partition(arr, firstIndex, lastIndex);
		
		if( pi - 1 > 1)
		{
			stack[++top] = firstIndex;
			stack[++top] = pi-1;
		}
			
		if( pi	+ 1 < lastIndex)
		{
			stack[++top] = pi+1;
			stack[++top] = lastIndex;
		}
	
	}
			
	}
	
	
	
	public void MergeSort(int arr[], int firstIndex, int lastIndex)
	{
		 if (firstIndex < lastIndex) {
	            int middle = firstIndex + (lastIndex - firstIndex) / 2;

	            MergeSort(arr, firstIndex, middle);

	            MergeSort(arr, middle + 1, lastIndex);

	            Merge(arr, firstIndex, middle, lastIndex);
		 }
	}
	
	public void Merge(int arr[], int firstIndex, int middle, int lastIndex)
	{
		
		int[] tempMergArr = new int[arr.length];
		
		for (int i = firstIndex; i <= lastIndex; i++) {
            tempMergArr[i] = arr[i];
        }
        int i = firstIndex;
        int j = middle + 1;
        int k = firstIndex;
        while (i <= middle && j <= lastIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                arr[k] = tempMergArr[i];
                i++;
            } else {
                arr[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            arr[k] = tempMergArr[i];
            k++;
            i++;
        }
	}
	
	public void mergeSort1(int arr[], int n)
	{
	   int curr_size;  
	   int left_start; 
	   for (curr_size=1; curr_size<=n-1; curr_size = 2*curr_size)
	   {
	       
	       for (left_start=0; left_start<n-1; left_start += 2*curr_size)
	       {
	           int mid = left_start + curr_size - 1;
	           int min;
	           int lef = left_start + 2* curr_size-1;
	           if(lef < n-1)
	           {
	        	   min = lef;
	           }
	           else
	           {
	        	   min = n-1;
	           }
	           
	           int right_end = min;
	 
	           mergeOne(arr, left_start, mid, right_end);
	       }
	   }
	}
	
	public void mergeOne(int arr[], int l, int m, int r)
	{
		int i, j, k;
	    int nOne = m - l + 1;
	    int nTwo =  r - m;
	 

		int[] L = new int[nOne];
		int[] R = new int[nTwo];
	    
	    for (i = 0; i < nOne; i++)
	        L[i] = arr[l + i];
	    for (j = 0; j < nTwo; j++)
	        R[j] = arr[m + 1+ j];
	 

	    i = 0;
	    j = 0;
	    k = l;
	    while (i < nOne && j < nTwo)
	    {
	        if (L[i] <= R[j])
	        {
	            arr[k] = L[i];
	            i++;
	        }
	        else
	        {
	            arr[k] = R[j];
	            j++;
	        }
	        k++;
	    }
	 

	    while (i < nOne)
	    {
	        arr[k] = L[i];
	        i++;
	        k++;
	    }
	 

	    while (j < nTwo)
	    {
	        arr[k] = R[j];
	        j++;
	        k++;
	    }
	}
	
	public void HeapSort(int arr[], int array_size)
	{
		int i, temp;

		for(i = (array_size/2)-1; i >=0; i--)
		{
			HeapSiftDown(arr,i,array_size);
		}
		for(i = array_size-1; i >= 1; i --)
		{
			temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			HeapSiftDown(arr,0, i-1);
	
		}
	}
	
	public void HeapSiftDown(int arr[], int root, int bottom)
	{
		int done, maxChild, temp; 
		done = 0;
		
		while((root*2 <= bottom) && (done == 0))
		{
			if(root*2 == bottom || arr[root * 2+1] > arr[root * 2+2])
			{
				maxChild = root*2 +1;
			}
			else
			{
				maxChild = root * 2 + 2;
			}
			
			if(arr[root] < arr[maxChild])
			{
				temp = arr[root];
				arr[root] = arr[maxChild];
				arr[maxChild] = temp;
				root = maxChild;
			}
			else
			{
				done = 1;
			}
		
		}
		
	}
	
	public static void main(String[] args)
	{
		int a,b,c,d,e;
		a = (int) Math.floor(Math.random()* 100);
		b = (int) Math.floor(Math.random()* 100);
		c = (int) Math.floor(Math.random()* 100);
		d = (int) Math.floor(Math.random()* 100);
		e = (int) Math.floor(Math.random()* 100);
		
		
		int[] descArr = {5,4,3,2,1};
		int[] aescArr = {1,2,3,4,5};
		int[] sameArr = {1,1,1,1,1};		
		int[] randArr = {a,b,c,d,e};
		

		int[] tempArr = new int[5];
		
		
		//so I created the four test cases, how the main should be used
		//is to create a new array and copy the four cases above to the new array
		//in order to not accidently use a sorted array from a previous sorting method

		
		
		System.out.println(">>>Testing Bubble Sort<<<");
		System.out.println(" Descending: ");
		System.arraycopy(descArr, 0, tempArr, 0, descArr.length);
		sortAlgos x = new sortAlgos(tempArr);
		x.printList();
		long startTime = System.nanoTime();
		x.BubbleSort();
		long stopTime = System.nanoTime();
		x.printList();
		System.out.println("Nanoseconds:" + (stopTime - startTime));

		
		
		System.out.println(" Ascending: ");
		System.arraycopy(aescArr, 0, tempArr, 0, aescArr.length);
		x = new sortAlgos(tempArr);
		x.printList();
		startTime = System.nanoTime();
		x.BubbleSort();
		stopTime = System.nanoTime();
		x.printList();
		System.out.println("Nanoseconds:" + (stopTime - startTime));


		
		System.out.println(" Same: ");
		System.arraycopy(sameArr, 0, tempArr, 0, sameArr.length);
		x = new sortAlgos(tempArr);
		x.printList();
		startTime = System.nanoTime();
		x.BubbleSort();
		stopTime = System.nanoTime();
		x.printList();
		System.out.println("Nanoseconds:" + (stopTime - startTime));

		
		
		System.out.println(" Random: ");
		System.arraycopy(randArr, 0, tempArr, 0, randArr.length);
		x = new sortAlgos(tempArr);
		x.printList();
		startTime = System.nanoTime();
		x.BubbleSort();
		stopTime = System.nanoTime();
		x.printList();
		System.out.println("Nanoseconds:" + (stopTime - startTime));
		

		
		
		System.out.println(">>>Testing Selection Sort<<<");

		
		System.out.println(" Descending: ");
		System.arraycopy(descArr, 0, tempArr, 0, descArr.length);
		sortAlgos y = new sortAlgos(tempArr);
		y.printList();
		startTime = System.nanoTime();
		y.SelectionSort();
		stopTime = System.nanoTime();
		y.printList();
		System.out.println("Nanoseconds:" + (stopTime - startTime));

				
		System.out.println(" Ascending: ");
		System.arraycopy(aescArr, 0, tempArr, 0, aescArr.length);
		y = new sortAlgos(tempArr);
		y.printList();
		startTime = System.nanoTime();
		y.SelectionSort();
		stopTime = System.nanoTime();
		y.printList();
		System.out.println("Nanoseconds:" + (stopTime - startTime));


		System.out.println(" Same: ");
		System.arraycopy(sameArr, 0, tempArr, 0, sameArr.length);
		y = new sortAlgos(tempArr);
		y.printList();
		startTime = System.nanoTime();
		y.SelectionSort();
		stopTime = System.nanoTime();
		y.printList();
		System.out.println("Nanoseconds:" + (stopTime - startTime));

		
		System.out.println(" Random: ");
		System.arraycopy(randArr, 0, tempArr, 0, randArr.length);
		y = new sortAlgos(tempArr);
		y.printList();
		startTime = System.nanoTime();
		y.SelectionSort();
		stopTime = System.nanoTime();
		y.printList();
		System.out.println("Nanoseconds:" + (stopTime - startTime));

		
		
		System.out.println(">>>Testing Insertion Sort<<<");

		
		
		System.out.println(" Descending: ");
		System.arraycopy(descArr, 0, tempArr, 0, descArr.length);
		sortAlgos z = new sortAlgos(tempArr);
		z.printList();
		startTime = System.nanoTime();
		z.InsertionSort();
		stopTime = System.nanoTime();
		z.printList();
		System.out.println("Nanoseconds:" + (stopTime - startTime));

		
		System.out.println(" Ascending: ");
		System.arraycopy(aescArr, 0, tempArr, 0, aescArr.length);
		z = new sortAlgos(tempArr);
		z.printList();
		startTime = System.nanoTime();
		z.InsertionSort();
		stopTime = System.nanoTime();
		z.printList();
		System.out.println("Nanoseconds:" + (stopTime - startTime));


		System.out.println(" Same: ");
		System.arraycopy(sameArr, 0, tempArr, 0, sameArr.length);
		z = new sortAlgos(tempArr);
		z.printList();
		startTime = System.nanoTime();
		z.InsertionSort();
		stopTime = System.nanoTime();
		z.printList();
		System.out.println("Nanoseconds:" + (stopTime - startTime));


		System.out.println(" Random: ");
		System.arraycopy(randArr, 0, tempArr, 0, randArr.length);
		z = new sortAlgos(tempArr);
		z.printList();
		startTime = System.nanoTime();
		z.InsertionSort();
		stopTime = System.nanoTime();
		z.printList();
		System.out.println("Nanoseconds:" + (stopTime - startTime));

		
		
		System.out.println(">>>Testing Quick Sort Recursive Right-Most<<<");

		
		
		System.out.println(" Descending: ");
		System.arraycopy(descArr, 0, tempArr, 0, descArr.length);
		z = new sortAlgos(tempArr);
		z.printList();
		startTime = System.nanoTime();
		z.QuickSort(tempArr, 0, 4);
		stopTime = System.nanoTime();
		z.printList();
		System.out.println("Nanoseconds:" + (stopTime - startTime));

		
		System.out.println(" Ascending: ");
		System.arraycopy(aescArr, 0, tempArr, 0, aescArr.length);
		z = new sortAlgos(tempArr);
		z.printList();
		startTime = System.nanoTime();
		z.QuickSort(tempArr, 0, 4);
		stopTime = System.nanoTime();
		z.printList();
		System.out.println("Nanoseconds:" + (stopTime - startTime));

		
		System.out.println(" Same: ");
		System.arraycopy(sameArr, 0, tempArr, 0, sameArr.length);
		z = new sortAlgos(tempArr);
		z.printList();
		startTime = System.nanoTime(); 
		z.QuickSort(tempArr, 0, 4);
		stopTime = System.nanoTime();
		z.printList();
		System.out.println("Nanoseconds:" + (stopTime - startTime));

		
		System.out.println(" Random: ");
		System.arraycopy(randArr, 0, tempArr, 0, randArr.length);
		z = new sortAlgos(tempArr);
		z.printList();
		startTime = System.nanoTime();
		z.QuickSort(tempArr, 0, 4);
		stopTime = System.nanoTime();
		z.printList();
		System.out.println("Nanoseconds:" + (stopTime - startTime));

		
		
		System.out.println(">>>Testing Quick Sort Median of Three<<<");

		
		
		System.out.println(" Descending: ");
		System.arraycopy(descArr, 0, tempArr, 0, descArr.length);
		z = new sortAlgos(tempArr);
		z.printList();
		startTime = System.nanoTime();
		z.QuickSort1(tempArr, 0, 4);
		stopTime = System.nanoTime();
		z.printList();
		System.out.println("Nanoseconds:" + (stopTime - startTime));

		
		System.out.println(" Ascending: ");
		System.arraycopy(aescArr, 0, tempArr, 0, aescArr.length);
		z = new sortAlgos(tempArr);
		z.printList();
		startTime = System.nanoTime();
		z.QuickSort1(tempArr, 0, 4);
		stopTime = System.nanoTime();
		z.printList();
		System.out.println("Nanoseconds:" + (stopTime - startTime));

		
		System.out.println(" Same: ");
		System.arraycopy(sameArr, 0, tempArr, 0, sameArr.length);
		z = new sortAlgos(tempArr);
		z.printList();
		startTime = System.nanoTime();
		z.QuickSort1(tempArr, 0, 4);
		stopTime = System.nanoTime();
		z.printList();
		System.out.println("Nanoseconds:" + (stopTime - startTime));

		
		System.out.println(" Random: ");
		System.arraycopy(randArr, 0, tempArr, 0, randArr.length);
		z = new sortAlgos(tempArr);
		z.printList();
		startTime = System.nanoTime();
		z.QuickSort1(tempArr, 0, 4);
		stopTime = System.nanoTime();
		z.printList();
		System.out.println("Nanoseconds:" + (stopTime - startTime));

		
		
		System.out.println(">>>Testing Quick Sort Non-Recursive<<<");

		
		
		System.out.println(" Descending: ");
		System.arraycopy(descArr, 0, tempArr, 0, descArr.length);
		z = new sortAlgos(tempArr);
		z.printList();
		startTime = System.nanoTime();
		z.QuickSort2(tempArr, 0, 4);
		stopTime = System.nanoTime();
		z.printList();
		System.out.println("Nanoseconds:" + (stopTime - startTime));

		
		System.out.println(" Ascending: ");
		System.arraycopy(aescArr, 0, tempArr, 0, aescArr.length);
		z = new sortAlgos(tempArr);
		z.printList();
		startTime = System.nanoTime();
		z.QuickSort2(tempArr, 0, 4);
		stopTime = System.nanoTime();
		z.printList();
		System.out.println("Nanoseconds:" + (stopTime - startTime));

		
		System.out.println(" Same: ");
		System.arraycopy(sameArr, 0, tempArr, 0, sameArr.length);
		z = new sortAlgos(tempArr);
		z.printList();
		startTime = System.nanoTime();
		z.QuickSort2(tempArr, 0, 4);
		stopTime = System.nanoTime();
		z.printList();
		System.out.println("Nanoseconds:" + (stopTime - startTime));

		
		System.out.println(" Random: ");
		System.arraycopy(randArr, 0, tempArr, 0, randArr.length);
		z = new sortAlgos(tempArr);
		z.printList();
		startTime = System.nanoTime();
		z.QuickSort2(tempArr, 0, 4);
		stopTime = System.nanoTime();
		z.printList();
		System.out.println("Nanoseconds:" + (stopTime - startTime));

		
		
		System.out.println(">>>Testing Merge Recursive<<<");

		
		
		System.out.println(" Descending: ");
		System.arraycopy(descArr, 0, tempArr, 0, descArr.length);
		z = new sortAlgos(tempArr);
		z.printList();
		startTime = System.nanoTime();
		z.MergeSort(tempArr, 0, 4);
		stopTime = System.nanoTime();
		z.printList();
		System.out.println("Nanoseconds:" + (stopTime - startTime));

		
		System.out.println(" Ascending: ");
		System.arraycopy(aescArr, 0, tempArr, 0, aescArr.length);
		z = new sortAlgos(tempArr);
		z.printList();
		startTime = System.nanoTime();
		z.MergeSort(tempArr, 0, 4);
		stopTime = System.nanoTime();
		z.printList();
		System.out.println("Nanoseconds:" + (stopTime - startTime));


		System.out.println(" Same: ");
		System.arraycopy(sameArr, 0, tempArr, 0, sameArr.length);
		z = new sortAlgos(tempArr);
		z.printList();
		startTime = System.nanoTime();
		z.MergeSort(tempArr, 0, 4);
		stopTime = System.nanoTime();
		z.printList();
		System.out.println("Nanoseconds:" + (stopTime - startTime));


		System.out.println(" Random: ");
		System.arraycopy(randArr, 0, tempArr, 0, randArr.length);
		z = new sortAlgos(tempArr);
		z.printList();
		startTime = System.nanoTime();
		z.MergeSort(tempArr, 0, 4);
		stopTime = System.nanoTime();
		z.printList();
		System.out.println("Nanoseconds:" + (stopTime - startTime));

		
		
		System.out.println(">>>Testing Merge Recursive<<<");

		
		
		System.out.println(" Descending: ");
		System.arraycopy(descArr, 0, tempArr, 0, descArr.length);
		z = new sortAlgos(tempArr);
		z.printList();
		startTime = System.nanoTime();
		z.MergeSort(tempArr, 0, 4);
		stopTime = System.nanoTime();
		z.printList();
		System.out.println("Nanoseconds:" + (stopTime - startTime));

		
		System.out.println(" Ascending: ");
		System.arraycopy(aescArr, 0, tempArr, 0, aescArr.length);
		z = new sortAlgos(tempArr);
		z.printList();
		startTime = System.nanoTime();
		z.MergeSort(tempArr, 0, 4);
		stopTime = System.nanoTime();
		z.printList();
		System.out.println("Nanoseconds:" + (stopTime - startTime));


		System.out.println(" Same: ");
		System.arraycopy(sameArr, 0, tempArr, 0, sameArr.length);
		z = new sortAlgos(tempArr);
		z.printList();
		startTime = System.nanoTime();
		z.MergeSort(tempArr, 0, 4);
		stopTime = System.nanoTime();
		z.printList();
		System.out.println("Nanoseconds:" + (stopTime - startTime));


		System.out.println(" Random: ");
		System.arraycopy(randArr, 0, tempArr, 0, randArr.length);
		z = new sortAlgos(tempArr);
		z.printList();
		startTime = System.nanoTime();
		z.MergeSort(tempArr, 0, 4);
		stopTime = System.nanoTime();
		z.printList();
		System.out.println("Nanoseconds:" + (stopTime - startTime));

		
		
		System.out.println(">>>Testing Merge Non-Recursive version<<<");

		
		
		System.out.println(" Descending: ");
		System.arraycopy(descArr, 0, tempArr, 0, descArr.length);
		z = new sortAlgos(tempArr);
		z.printList();
		startTime = System.nanoTime();
		z.mergeSort1(tempArr, 5);
		stopTime = System.nanoTime();
		z.printList();
		System.out.println("Nanoseconds:" + (stopTime - startTime));

		
		System.out.println(" Ascending: ");
		System.arraycopy(aescArr, 0, tempArr, 0, aescArr.length);
		z = new sortAlgos(tempArr);
		z.printList();
		startTime = System.nanoTime();
		z.mergeSort1(tempArr, 5);
		stopTime = System.nanoTime();
		z.printList();
		System.out.println("Nanoseconds:" + (stopTime - startTime));

		
		System.out.println(" Same: ");
		System.arraycopy(sameArr, 0, tempArr, 0, sameArr.length);
		z = new sortAlgos(tempArr);
		z.printList();
		startTime = System.nanoTime();
		z.mergeSort1(tempArr, 5);
		stopTime = System.nanoTime();
		z.printList();
		System.out.println("Nanoseconds:" + (stopTime - startTime));

		
		System.out.println(" Random: ");
		System.arraycopy(randArr, 0, tempArr, 0, randArr.length);
		z = new sortAlgos(tempArr);
		z.printList();
		startTime = System.nanoTime();
		z.mergeSort1(tempArr, 5);
		stopTime = System.nanoTime();
		z.printList();
		System.out.println("Nanoseconds:" + (stopTime - startTime));

		
		
		System.out.println(">>>Testing Heapsort<<<");

		
		
		System.out.println(" Descending: ");
		System.arraycopy(descArr, 0, tempArr, 0, descArr.length);
		z = new sortAlgos(tempArr);
		z.printList();
		startTime = System.nanoTime();
		z.HeapSort(tempArr, 4);
		stopTime = System.nanoTime();
		z.printList();
		System.out.println("Nanoseconds:" + (stopTime - startTime));

		System.out.println(" Ascending: ");
		System.arraycopy(aescArr, 0, tempArr, 0, aescArr.length);
		z = new sortAlgos(tempArr);
		z.printList();
		startTime = System.nanoTime();
		z.HeapSort(tempArr, 4);
		stopTime = System.nanoTime();
		z.printList();
		System.out.println("Nanoseconds:" + (stopTime - startTime));

		System.out.println(" Same: ");
		System.arraycopy(sameArr, 0, tempArr, 0, sameArr.length);
		z = new sortAlgos(tempArr);
		z.printList();
		startTime = System.nanoTime();
		z.HeapSort(tempArr, 4);
		stopTime = System.nanoTime();
		z.printList();
		System.out.println("Nanoseconds:" + (stopTime - startTime));

		System.out.println(" Random: ");
		System.arraycopy(randArr, 0, tempArr, 0, randArr.length);
		z = new sortAlgos(tempArr);
		z.printList();
		startTime = System.nanoTime();
		z.HeapSort(tempArr, 4);
		stopTime = System.nanoTime();
		z.printList();
		System.out.println("Nanoseconds:" + (stopTime - startTime));

	}
}