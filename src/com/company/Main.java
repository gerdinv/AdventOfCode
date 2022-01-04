package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

    }

    /**
     * This method allows us to get input from a text file, and format it into an array of strings.
     * @param path A String that represents the path to the file where the data is stored.
     * @return Returns an array of Strings where each element is an input
     */
    public static String[] getInput(String path) {
        File file = new File(path);
        Scanner sc = null;
        StringBuilder input = new StringBuilder();

        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (sc.hasNextLine()) {
            input.append(sc.nextLine() + " ");
        }

        return input.toString().split(" ");
    }

}