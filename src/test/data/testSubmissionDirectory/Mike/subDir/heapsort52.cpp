#include <iostream>
#include <algorithm>


void heapify( int arr[] , int n , int i )
{
    int largest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;

    if( left < n && arr[left] > arr[largest] ) {
        largest = left;
    }

    if( right < n && arr[right] > arr[largest] ) {
        largest = right;
    }

    if( largest != i ) {
        std::swap( arr[i] , arr[largest] );
        heapify( arr , n , largest );
    }
}

int main()
{
    int n = 3;
    int arr[3] = { 9 , 5 , 6 };


    for( int x : arr ) {
        std::cout << x << " ";
    }
    std::cout << std::endl;

    // Build Heap (Rearrange)
    for( int i = n / 2 - 1 ; i >= 0 ; i-- ) {
        heapify( arr , n , i );
    }

    // Place the largest element at the end and keep heapifying
    // to get the next largest element at arr[0]
    for( int i = n - 1 ; i >= 0 ; i-- ) {
        std::swap( arr[0] , arr[i] );
        heapify( arr , i , 0 );
    }

    for( int x : arr ) {
        std::cout << x << " ";
    }
    std::cout << std::endl;
}
