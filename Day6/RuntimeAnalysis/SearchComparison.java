import java.util.*;
public class SearchComparison {
    public static int linearSearch(List<Integer> data, int target) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i) == target) {
                return i;
            }
        }
        return -1;
    }
    public static int binarySearch(List<Integer> data, int target) {
        int low = 0;
        int high = data.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midVal = data.get(mid);
            if (midVal == target) {
                return mid;
            } else if (midVal < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    public static void mergeSort(List<Integer> data) {
        if (data.size() <= 1) return;
        int mid = data.size() / 2;
        List<Integer> left = new ArrayList<>(data.subList(0, mid));
        List<Integer> right = new ArrayList<>(data.subList(mid, data.size()));
        mergeSort(left);
        mergeSort(right);
        merge(data, left, right);
    }
    public static void merge(List<Integer> data, List<Integer> left, List<Integer> right) {
        int i = 0, j = 0, k = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
                data.set(k++, left.get(i++));
            } else {
                data.set(k++, right.get(j++));
            }
        }
        while (i < left.size()) {
            data.set(k++, left.get(i++));
        }
        while (j < right.size()) {
            data.set(k++, right.get(j++));
        }
    }
    public static void main(String[] args) {
        List<Integer> data1K = generateUnsortedList(1000);
        List<Integer> data10K = generateUnsortedList(10000);
        List<Integer> data1M = generateUnsortedList(1000000);
        int target1K = data1K.get(new Random().nextInt(1000));
        int target10K = data10K.get(new Random().nextInt(10000));
        int target1M = data1M.get(new Random().nextInt(1000000));
        mergeSort(data1K);
        mergeSort(data10K);
        mergeSort(data1M);
        System.out.println("Dataset Size: 1,000 :");
        measureSearchTime("Linear Search", data1K, target1K);
        measureSearchTime("Binary Search", data1K, target1K);
        System.out.println("\nDataset Size: 10,000 :");
        measureSearchTime("Linear Search", data10K, target10K);
        measureSearchTime("Binary Search", data10K, target10K);
        System.out.println("\nDataset Size: 1,000,000 :");
        measureSearchTime("Linear Search", data1M, target1M);
        measureSearchTime("Binary Search", data1M, target1M);
    }
    public static List<Integer> generateUnsortedList(int size) {
        List<Integer> data = new ArrayList<>(size);
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            data.add(random.nextInt(size * 10));  // Adding random integers
        }
        return data;
    }
    public static void measureSearchTime(String searchType, List<Integer> data, int target) {
        long startTime = System.nanoTime();
        int result = -1;
        if (searchType.equals("Linear Search")) {
            result = linearSearch(data, target);
        } else if (searchType.equals("Binary Search")) {
            result = binarySearch(data, target);
        }
        long endTime = System.nanoTime();
        long durationMillis = (endTime - startTime) / 1_000_000;
        System.out.println(searchType + ": Target found at index " + result + ", Time taken: " + durationMillis + " ms");
    }
}
