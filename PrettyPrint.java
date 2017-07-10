import java.util.ArrayList;

public class PrettyPrint {
    public ArrayList<ArrayList<Integer>> prettyPrint(int a) {
        ArrayList<ArrayList<Integer>> container = new ArrayList<>();

        //initialize
        for (int i = 0; i < 2 * a - 1; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < 2 * a - 1; j++) {
                row.add(a);
            }
            container.add(row);
        }

        int halfEnd = (2 * a - 1) / 2;
        int slider = 1;
        int height = 2 * a - 2;

        while (slider <= halfEnd) {
            int top = slider;
            int bottom = height - 1;
            int left = slider;
            int right = height - 1;
            a--;
            while (top <= bottom) {
                ArrayList<Integer> row = container.get(top);
                for (int i = left; i <= right; i++) {
                    row.set(i, a);
                }
                top++;
            }
            slider++;
            height--;
        }
        return container;
    }
}
