public class MagicSquare {

    public static void main(String[] args) {

        int[][] array2d = {
                {2,7,6},
                {9,5,1},
                {4,3,8}
        };

        int[][] array2d2 = {
                {4,9,2},
                {3,5,7},
                {8,1,6}
        };

        int[][] array2d3 = {
                {2,16,13,3},
                {11,5,8,10},
                {7,9,12,6},
                {14,4,1,15}
        };

        int[][] array2d4 = {
                {1,23,16,4,21},
                {15,14,7,18,11},
                {24,17,13,9,2},
                {20,8,19,12,6},
                {5,3,10,22,25}
        };

        int[][] array2d5 = {
                {7,6,2},
                {5,1,9},
                {3,8,4}
        };

        int[][] array2d6 = {
                {1,6,8},
                {9,2,4},
                {5,7,3}
        };

        int[][] array2d7 = {
                {2,16,13,3},
                {11,15,8,0},
                {7,9,12,6},
                {14,4,1,15}
        };

        int[][] array2d8 = {
                {1,23,16,4,21},
                {15,14,7,18,11},
                {24,0,13,9,2},
                {20,8,19,12,6},
                {5,3,10,22,25}
        };

        System.out.println("Testing check sum");

        System.out.println(calculateCheckSum(array2d));
        System.out.println(calculateCheckSum(array2d2));
        System.out.println(calculateCheckSum(array2d3));
        System.out.println(calculateCheckSum(array2d4));

        System.out.println(calculateCheckSum(array2d5));
        System.out.println(calculateCheckSum(array2d6));
        System.out.println(calculateCheckSum(array2d7));
        System.out.println(calculateCheckSum(array2d8));

        System.out.println("Testing magic rows");
        System.out.println(magicRows(array2d, calculateCheckSum((array2d))));
        System.out.println(magicRows(array2d2, calculateCheckSum(array2d2)));
        System.out.println(magicRows(array2d3, calculateCheckSum(array2d3)));
        System.out.println(magicRows(array2d4, calculateCheckSum(array2d4)));

        System.out.println(magicRows(array2d5, calculateCheckSum(array2d5)));
        System.out.println(magicRows(array2d6, calculateCheckSum(array2d6)));
        System.out.println(magicRows(array2d7, calculateCheckSum(array2d7)));
        System.out.println(magicRows(array2d8, calculateCheckSum(array2d8)));

        System.out.println("Testing magic columns");
        System.out.println(magicColumns(array2d, calculateCheckSum((array2d))));
        System.out.println(magicColumns(array2d2, calculateCheckSum(array2d2)));
        System.out.println(magicColumns(array2d3, calculateCheckSum(array2d3)));
        System.out.println(magicColumns(array2d4, calculateCheckSum(array2d4)));

        System.out.println(magicColumns(array2d5, calculateCheckSum(array2d5)));
        System.out.println(magicColumns(array2d6, calculateCheckSum(array2d6)));
        System.out.println(magicColumns(array2d7, calculateCheckSum(array2d7)));
        System.out.println(magicColumns(array2d8, calculateCheckSum(array2d8)));

        System.out.println("Testing magic diagonals");
        System.out.println(magicDiagonals(array2d, calculateCheckSum((array2d))));
        System.out.println(magicDiagonals(array2d2, calculateCheckSum(array2d2)));
        System.out.println(magicDiagonals(array2d3, calculateCheckSum(array2d3)));
        System.out.println(magicDiagonals(array2d4, calculateCheckSum(array2d4)));

        System.out.println(magicDiagonals(array2d5, calculateCheckSum(array2d5)));
        System.out.println(magicDiagonals(array2d6, calculateCheckSum(array2d6)));
        System.out.println(magicDiagonals(array2d7, calculateCheckSum(array2d7)));
        System.out.println(magicDiagonals(array2d8, calculateCheckSum(array2d8)));

        System.out.println("Testing magic 2d array");

        System.out.println(isMagic(array2d));
        System.out.println(isMagic(array2d2));
        System.out.println(isMagic(array2d3));
        System.out.println(isMagic(array2d4));

        System.out.println(isMagic(array2d5));
        System.out.println(isMagic(array2d6));
        System.out.println(isMagic(array2d7));
        System.out.println(isMagic(array2d8));
    }

    /**
     *
     * @param array2d
     * @return whether array2d is magic or not.
     */
    public static boolean isMagic(int[][] array2d) {
        int checkSum = calculateCheckSum(array2d);
        return magicRows(array2d, checkSum) && magicColumns(array2d, checkSum) && magicDiagonals(array2d, checkSum);
    }

    /**
     *
     * @param array2d
     * @return the sum of the first row in array2d.
     */
    public static int calculateCheckSum(int[][] array2d) {
        int checkSum = 0;
        for (int i = 0; i < array2d[0].length; i++) {
            checkSum += array2d[0][i];
        }
        return checkSum;
    }

    /**
     *
     * @param array2d
     * @param checkSum
     * @return whether the sum of each row in array2d is equal to checkSum or not.
     *         Because we have already determined the sum of the first row
     *         via the method 'calculateCheckSum', this method can begin
     *         iterating from the second row.
     */
    public static boolean magicRows(int[][] array2d, int checkSum) {
        int sum = 0;
        for (int i = 1; i < array2d.length; i++) {
            sum = 0;
            for (int j = 0; j < array2d[i].length; j++) {
                sum += array2d[i][j];
            }
            if (sum != checkSum) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param array2d
     * @param checkSum
     * @return whether the sum of each column in array2d is equal to checkSum or not.
     */
    public static boolean magicColumns(int[][] array2d, int checkSum) {
        int sum;
        for (int i = 0; i < array2d.length; i++) {
            sum = 0;
            for (int j = 0; j < array2d[i].length; j++) {
                sum += array2d[j][i];
            }
            if (sum != checkSum) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param array2d
     * @param checkSum
     * @return whether the sum of each of the two main diagonals is equal to checkSum or not.
     */
    public static boolean magicDiagonals(int[][] array2d, int checkSum) {
        int sum = 0;
        int sum2 = 0;
        for (int i = 0; i < array2d.length; i++) {
            sum += array2d[i][i];
            sum2 += array2d[i][array2d[0].length-1-i];
        }
        if (sum != checkSum || sum2 != checkSum) return false;

        return true;
    }

}
