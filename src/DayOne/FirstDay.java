package DayOne;

import static com.company.Main.getInput;

public class FirstDay {

    public static void main(String[] args) {
        String[] inputList = getInput("/Users/gerdinventura/Desktop/Projects/Java/AdventOfCode/src/DayOne/input.txt");
        int counts = DayOne.FirstDay.getCount(inputList);
        System.out.println(counts);
    }

    /**
     *  This method tells us the number of times a depth measurement increased over time.
     * @param inputList A list of all the depths as strings.
     * @return Returns the number of times a depth measurement increases
     */
    public static int getCount(String[] inputList) {
        int count = 0;
        for(int i = 0; i < inputList.length - 1; i++) {
            String curr = inputList[i];
            String next = inputList[i+ 1];
            int currNum = Integer.parseInt(curr);
            int nextNum = Integer.parseInt(next);
            if(currNum < nextNum) count++;
        }
        return count;
    }
}
