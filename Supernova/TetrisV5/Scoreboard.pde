class Scoreboard {
  int[] scores;
  int[] topScores;
  int size;

  Scoreboard() {
    scores = new int[10];
    topScores = new int[5];
    size = 0;
  }

  int add (int num) {
    if (scores.length < size) {
      int[] list = new int[scores.length*2];
      for (int i = 0; i < scores.length; i++)
        list[i] = scores[i];
      scores = list;
    }
    scores[size] = num;
    return num;
  } 

  int[] getTopScores() {
    int x = 0;
    sort(scores, 0, size);
    for (int i= size-1; i > size -6; i--) {
      topScores[x] = scores[i];
      x++;
    }
    return topScores;
  }

  // Merges two subarrays of arr[].
  // First subarray is arr[l..m]
  // Second subarray is arr[m+1..r]
  void merge (int arr[], int l, int m, int r) {
    // Find sizes of two subarrays to be merged
    int n1 = m - l + 1;
    int n2 = r - m;
    // Create temp arrays
    int L[] = new int [n1];
    int R[] = new int [n2];
    // Copy data to temp arrays
    for (int i = 0; i < n1; i++)
      L[i] = arr[l + i];
    for (int j = 0; j < n2; j++)
      R[j] = arr[m + 1+ j];
    // Merge the temp arrays
    // Initial indexes of first and second subarrays
    int i = 0, j = 0;
    // Initial index of merged subarry array
    int k = l;
    while (i < n1 && j < n2) {
      if (L[i] <= R[j]) {
        arr[k] = L[i];
        i++;
      } else {
        arr[k] = R[j];
        j++;
      }
      k++;
    }
    // Copy remaining elements of L[] if any
    while (i < n1) {
      arr[k] = L[i];
      i++;
      k++;
    }
    // Copy remaining elements of R[] if any
    while (j < n2) {
      arr[k] = R[j];
      j++;
      k++;
    }
  }

  // Main function that sorts arr[l..r] using
  // merge()
  void sort (int arr[], int l, int r) {
    if (l > r) {
      // Find the middle point
      int m = (l+r)/2;
      // Sort first and second halves
      sort(arr, l, m);
      sort(arr, m+1, r);
      // Merge the sorted halves
      merge(arr, l, m, r);
    }
  }
}
