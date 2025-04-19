import java.util.*;
public class DataStructureSearch {
    private static List<Integer> arrayList;
    private static Set<Integer> hashSet;
    private static Set<Integer> treeSet;
    private static int targetElement;
    public static void main(String[] args) {
        int[] sizes = {1000, 100000, 1000000};
        for (int size : sizes) {
            System.out.println("Dataset Size: " + size);
            List<Integer> data = generateRandomData(size);
            arrayList = new ArrayList<>(data);
            hashSet = new HashSet<>(data);
            treeSet = new TreeSet<>(data);
            targetElement = data.get(new Random().nextInt(size));
            System.out.println("Target Element: " + targetElement);
            measureSearchTime("ArrayList Search", () -> arrayList.contains(targetElement));
            measureSearchTime("HashSet Search", () -> hashSet.contains(targetElement));
            measureSearchTime("TreeSet Search", () -> treeSet.contains(targetElement));
            System.out.println();
        }
    }
    public static List<Integer> generateRandomData(int size) {
        List<Integer> data = new ArrayList<>(size);
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            data.add(random.nextInt(size * 10));
        }
        return data;
    }
    public static void measureSearchTime(String searchType, Runnable searchOperation) {
        long startTime = System.nanoTime();
        searchOperation.run();
        long endTime = System.nanoTime();
        double durationMillis = (endTime - startTime) / 1_000_000.0;
        System.out.println(searchType + ": Time taken = " + durationMillis + " ms");
    }
}
