import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //List<Integer> q = List.of(2, 1, 5, 4, 3);
        //List<Integer> q = List.of(2, 1, 5, 3, 4);
        List<Integer> q = new ArrayList<>(List.of(1, 2, 5, 3, 7, 8, 6, 4));
        //List<Integer> q = List.of(5, 1, 2, 3, 7, 8, 6, 4);
        minimumBribes(q);
    }

    public static void minimumBribes(List<Integer> q) {
        int bribes = getMinimumBribes(q);
        System.out.println(bribes == -1 ? "Too chaotic" : bribes);
    }

    public static int getMinimumBribes(List<Integer> q) {        
        int bribes = 0;
        for (int i = q.size() - 1; i >= 0; i--) {
            int shouldIndex = q.get(i) - 1;
            if (shouldIndex - i > 2) return -1;

            for (int j = Math.max(0, shouldIndex - 1); j < i; j++) {
                if (q.get(j) > q.get(i)) bribes++;
            }
        }
        return bribes;
    }

    /*
    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        int bribes = 0;
        while (!q.isEmpty()) {
            int current = q.get(0);
            int shouldBe = getIndex(new ArrayList<>(q), current);            
            if (shouldBe != 0) {
                int steps = shouldBe;
                if (steps > 2) {
                    System.out.println("Too chaotic");
                    return;
                }
                bribes += steps;
            }
            q.remove(0);
        }
        System.out.println(bribes);
    }

    public static int getIndex(List<Integer> q, int element) {
        Collections.sort(q);
        return q.indexOf(element);
    }
    */
}
