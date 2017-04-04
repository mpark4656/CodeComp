class GfG
{
    /* This function takes last element as pivot, places  the pivot element 
    at its correct position in sorted  array, and places all smaller (smaller
    than pivot) to left of pivot and all greater elements to right  of pivot */
    int partition(int arr[], int low, int high)
    {
        // Choose the middle element as the pivot point. Place this element at the end
    	int mid = ( low + high + 1 ) / 2;
    	int temp = arr[high];
    	arr[high] = arr[mid];
    	arr[mid] = temp;
    	
    	// The last element is the pivot element
    	int pivot = arr[high];
    	
    	// i is an index right before the first element
    	int index = low - 1;
    	
    	for( int i = 0 ; i < high ; i++ ) {
    		if( arr[i] < pivot ) {
    			index++;
    			temp = arr[i];
    			arr[i] = arr[index];
    			arr[index] = temp;
    		}
    	}
    	
    	temp = arr[high];
    	arr[high] = arr[index + 1];
    	arr[index + 1] = temp;
    	
    	return ( index + 1 );
    }
}

/* The main function that implements QuickSort() (present in a class 
   different from GfG)
   arr[] --> Array to be sorted,   low  --> Starting index,  high  --> Ending index 
static void quickSort(int arr[], int low, int high)
{
    if (low < high)
    {
        GfG g = new GfG();

        // pi is partitioning index, arr[pi] is
        //  now at right place 
        int pi = g.partition(arr, low, high);

        // Recursively sort elements before
        // partition and after partition
        quickSort(arr, low, pi-1);
        quickSort(arr, pi+1, high);
    }
}*/
