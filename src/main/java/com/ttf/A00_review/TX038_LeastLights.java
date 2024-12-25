package com.ttf.A00_review;

/**
 * For a given a string array with only 'X' and '.', 'X' represent a wall, and '.' represent a street.
 * We need to find the minimum number of lights to illuminate all the streets. The light can only be placed on the street.
 * and one light can illuminate all the streets on the left and right side of the light.
 */
public class TX038_LeastLights {

    private int leastLights(String[] streets) {
        int count = 0;
        int i = 0;
        while (i < streets.length) {
            if (streets[i].equals("X")) {
                i++;
            } else {
                count++;
                if (i+1 == streets.length) {
                    break;
                } else {
                    if (streets[i+1].equals("X")) {
                        i += 2;
                    } else {
                        i += 3;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        TX038_LeastLights leastLights = new TX038_LeastLights();
        String[] streets = {"X", ".", ".", ".", "X", ".", ".", "X","."};
        System.out.println(leastLights.leastLights(streets));

        String[] streets2 = {"X", ".", "X", ".", "X","."};
        System.out.println(leastLights.leastLights(streets2));
    }
}
