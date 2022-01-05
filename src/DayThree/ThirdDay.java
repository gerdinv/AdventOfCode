package DayThree;

import static com.company.Main.getInput;

public class ThirdDay {

    static class Energy {
        int zeros;
        int ones;

        public Energy() {
            zeros = 0;
            ones = 0;
        }
    }

    public static void main(String[] args) {
        String[] input = getInput("/Users/gerdinventura/Desktop/Projects/Java/AdventOfCode/src/DayThree/input.txt");
        int answer = getPowerConsumption(input);
        System.out.println(answer);
    }

    /**
     * This method calculates the total power consumption of the submarine by multiplying the gamma rate by the
     * epsilon rate.
     * @param input A list of all the binary bits from the diagnostic report.
     * @return Returns the total power consumption of the submarine
     */
    public static int getPowerConsumption(String[] input) {
        Energy[] data = new Energy[12];
        int[] gamma = new int[12];
        int[] epsilon = new int[12];

        for(String bits : input) {
            for(int i = 0; i < 12; i++) {
                char bit = bits.charAt(i);
                if(data[i] == null) data[i] = new Energy();
                if(bit == '0') data[i].zeros++;
                if(bit == '1') data[i].ones++;
            }
        }

        for(int i = 0; i < 12; i++) {
            int min = data[i].zeros < data[i].ones ? 0 : 1;
            int max = data[i].zeros > data[i].ones ? 0 : 1;
            gamma[i] = max;
            epsilon[i] = min;
        }

        int gammaCount = binaryToDecimal(gamma);
        int epislonCount = binaryToDecimal(epsilon);

        return gammaCount * epislonCount;
    }

    /**
     * This method converts an array of integers that represents a binary number to a decimal number
     * @param arr A list of bits that represents a number
     * @return Returns the decimal representation of a binary number.
     */
    private static int  binaryToDecimal(int[] arr) {
        int ans = 0, size = arr.length;
        for(int num : arr) {
            size--;
            if(num == 0) continue;
            int toAdd = (int) Math.pow(2, size);
            ans += toAdd;
        }
        return ans;
    }

}