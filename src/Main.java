public class Main {
    public static void main(String[] args) {
        int[] S = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int x = 5;
        int location = BinSearch(S, x);
        System.out.println("Location of " + x + " is " + location);
        int locationRec = BinSearchRec(S, x, 0, S.length - 1);
        System.out.println("Location of " + x + " is " + locationRec);
        int[] A = { 2, 8, 7, 1, 3, 5, 6, 4 };
        QUICKSORT(A, 0, A.length - 1);
        System.out.println("Sorted array is: ");
        for (int j : A) {
            System.out.print(j + " ");
        }
    }
    public static int BinSearch(int[] S, int x) {
        int low = 0;
        int high = S.length - 1;
        int location = -1;
        int mid;
        while (low <= high && location == -1) {
            mid = (low + high) / 2;
            if (x == S[mid]) {
                location = mid;
            } else if (x < S[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return location;
    }
    public static int BinSearchRec(int[] S, int x, int low, int high) {
        int mid;
        if (low < high) {
            mid = (low + high) / 2;
            if (x == S[mid]) {
                return mid;
            } else if (x < S[mid]) {
                return BinSearchRec(S, x, low, mid - 1);
            } else {
                return BinSearchRec(S, x, mid + 1, high);
            }
        }
        return -1;
    }
    public static void QUICKSORT(int[] A, int p, int r) {
        if (p < r) {
            int q = PARTITION(A, p, r);
            QUICKSORT(A, p, q );
            QUICKSORT(A, q + 1, r);
        }
    }
    public static int PARTITION(int[] A, int p, int r) {
        int x = A[p];
        int i = p - 1;
        int j = r + 1;
        int temp;
        while (true) {
            do {
                j--;
            } while (A[j] > x);
            do {
                i++;
            } while (A[i] < x);
            if (i < j) {
                temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            } else {
                return j;
            }
        }
    }
}