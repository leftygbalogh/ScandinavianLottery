/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scandinavianlottery;

import java.util.Random;

/**
 *
 * @author lefty
 */
public class ScandinavianLottery {

    /**
     * @param args the command line arguments
     */
    public static void PrintLotteryNumbers(int[] numbers) {

        System.out.println("╔══════════════════════════════════╗");
        System.out.println("║   This Weeks Winning Numbers     ║");
        System.out.println("║   on the Scandinavian Lottery    ║");
        System.out.println("╠════╦════╦════╦════╦════╦════╦════╣");

//System.out.println("║  1 ║ 23 ║ 24 ║ 27 ║ 31 ║ 33 ║ 34 ║");
        System.out.print("║");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print((numbers[i] < 10 ? "  " : " ") + numbers[i] + " ║");
        }
        System.out.println();

        System.out.println("╠════╩════╩════╩════╩════╩════╩════╣");
        System.out.println("║ Special thanks to the members of ║");
        System.out.println("║     of Balazs' Java Course.      ║");
        System.out.println("╚══════════════════════════════════╝");

    }

    public static int[] RandomArray_i(int size, int lower, int upper) {
        Random ran = new Random();
        int[] numbers = new int[size];

        for (int i = 0; i < size; i++) {
            int tmp = ran.nextInt(upper - lower) + 1 + lower;
            if (IsNumberInArray(tmp, numbers)) {
                i--;
            } else {
                numbers[i] = tmp;
            }
        }
        
        BubbleSort(numbers);

        return numbers;

    }

    public static int[] BubbleSort(int[] array) {

        for (int j = 0; j < array.length; j++) {

            for (int i = 0; i < array.length - 1 - j; i++) {
                if (array[i] > array[i + 1]) {
                    int tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                }
            }
        }

        return array;
    }

    public static boolean IsNumberInArray(int number, int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (number == array[i]) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 17};
        PrintLotteryNumbers(a);

        int[] b = RandomArray_i(7, 1, 35);
        PrintLotteryNumbers(b);

        System.out.println(IsNumberInArray(17, a));
        System.out.println(IsNumberInArray(12, b));

    }

}
