public class StringConcatenation {
    private static final int[] NUMBER_OF_STRINGS = {1000, 10000};
    private static final String STRING_TO_APPEND = "test";
    public static void main(String[] args) {
        for (int numberOfStrings : NUMBER_OF_STRINGS) {
            System.out.println("Testing with " + numberOfStrings + " strings:");
            testStringConcatenation(numberOfStrings);
            testStringBuilderConcatenation(numberOfStrings);
            testStringBufferConcatenation(numberOfStrings);
            System.out.println();
        }
    }
    public static void testStringConcatenation(int numberOfStrings) {
        long startTime = System.nanoTime();
        String result = "";
        for (int i = 0; i < numberOfStrings; i++) {
            result += STRING_TO_APPEND;
        }
        long endTime = System.nanoTime();
        long durationMillis = (endTime - startTime) / 1_000_000;
        System.out.println("Time taken for String concatenation: " +
                durationMillis + " ms");
    }
    public static void testStringBuilderConcatenation(int numberOfStrings) {
        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfStrings; i++) {
            sb.append(STRING_TO_APPEND);
        }
        String result = sb.toString();
        long endTime = System.nanoTime();
        long durationMillis = (endTime - startTime) / 1_000_000;
        System.out.println("Time taken for StringBuilder concatenation: " +
                durationMillis + " ms");
    }
    public static void testStringBufferConcatenation(int numberOfStrings) {
        long startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < numberOfStrings; i++) {
            sbf.append(STRING_TO_APPEND);
        }
        String result = sbf.toString();
        long endTime = System.nanoTime();
        long durationMillis = (endTime - startTime) / 1_000_000;
        System.out.println("Time taken for StringBuffer concatenation: " +
                durationMillis + " ms");
    }
}
