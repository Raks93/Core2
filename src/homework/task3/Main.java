package homework.task3;

import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        System.out.println(fuzzySearch("car", "ca6$$#_rtwheel")); // true
        System.out.println(fuzzySearch("cwhl", "cartwheel")); // true
        System.out.println(fuzzySearch("cwhee", "cartwheel")); // true
        System.out.println(fuzzySearch("cartwheel", "cartwheel")); // true
        System.out.println(fuzzySearch("cwheeel", "cartwheel")); // false
        System.out.println(fuzzySearch("lw", "cartwheel")); // false
    }

    public static boolean fuzzySearch (String goal, String line) {

        if (Objects.isNull(goal) || Objects.isNull(line) || goal.isEmpty()
                || line.isEmpty() || goal.length() > line.length()
                || (goal.length() == line.length() && !goal.equals(line))
        ) {
            return false;
        }

        if (goal.length() == line.length()) {
            return true;
        }

        char[] chars = goal.toCharArray();
        StringBuilder lineBuilder = new StringBuilder(line);
        int index;

        for (char aChar : chars) {
            index = lineBuilder.indexOf(String.valueOf(aChar));
            if (index == -1) {
                return false;
            }
            else {
                lineBuilder.delete(0, index + 1);
            }
        }

        return true;
    }
}
