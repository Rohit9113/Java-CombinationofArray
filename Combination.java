import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Combination {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the numbers of the array (using comma): ");
        String inpt = sc.nextLine();
        int[] arr = Arrays.stream(inpt.split(",")).mapToInt(Integer::parseInt).toArray();
        System.out.print("Enter the target value: ");
        int tValue = sc.nextInt();

        List<List<Integer>> cValue = checkCombinations(arr, tValue);
        System.out.println("First Combination For " + tValue + ": " + cValue);

        int[] mrgarr = mergeAndSortArray(arr);
        System.out.println("Merged into a single Array: " + Arrays.toString(mrgarr));

        int doubleTValue = tValue * 2;

        List<List<Integer>> doubleCValue = checkCombinations(mrgarr, doubleTValue);
        System.out.println("Second Combinations For " + doubleTValue + ": " + doubleCValue);
    }

    private static List<List<Integer>> checkCombinations(int[] arr, int tValue) {
        List<List<Integer>> arrcombination = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == tValue) {
                	arrcombination.add(Arrays.asList(arr[i], arr[j]));
                }
            }
        }
        return arrcombination;
    }

    private static int[] mergeAndSortArray(int[] arr) {
        int[] mrgarr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(mrgarr);
        return mrgarr;
    }
}
