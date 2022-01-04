package DayTwo;

import static com.company.Main.getInput;

public class SecondDay {
    public static void main(String[] args) {
       String[] input = getInput("/Users/gerdinventura/Desktop/Projects/Java/AdventOfCode/src/DayTwo/input.txt");
       int answer = calculatePositionTotal(input);
       System.out.println(answer);
    }

    /**
     * This method calculates the horizontal position and depth after following a planned course (series of directions)
     * @param input A list of all the directions that the submarine can take
     * @return Returns the product of the final horizontal position and final depth.
     */
    public static int calculatePositionTotal(String[] input) {
        int horizontalPosition = 0, depth = 0;
        for(int i = 0; i <= input.length - 2; i += 2) {
            String direction = input[i];
            int amount = Integer.parseInt(input[i + 1]);
            if(direction.equals("forward")) horizontalPosition += amount;
            if(direction.equals("down")) depth += amount;
            if(direction.equals("up")) depth -= amount;
        }
        return horizontalPosition * depth;
    }
}
