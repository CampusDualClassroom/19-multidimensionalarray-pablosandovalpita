package com.campusdual.classroom;

class Exercise {

    public static int[] createAndPopulateUnidimensionalArray(int columns) {
        int[] uniArray = new int[columns];
        for(int i = 0; i < columns; i++){
            uniArray[i] = i + 1;
        }
        return uniArray;
    }

    public static int[][] createAndPopulateBidimensionalArray(int rows, int columns) {
        int[][] biArray = new int[rows][columns];
        int value = 1;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                biArray[i][j] = value;
                value++;
            }
        }
        return biArray;
    }

    public static int[][][] createAndPopulateTridimensionalArray(int depth, int rows, int columns) {
        int[][][] triArray = new int[depth][rows][columns];
        int value = 1;
        for(int i = 0; i < depth; i++){
            for(int j = 0; j < rows; j++){
                for(int k = 0; k < columns; k++){
                    triArray[i][j][k] = value;
                    value++;
                }
            }
        }
        return triArray;
    }

    public static String getUnidimensionalString(int[] uniArray) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < uniArray.length; i++){
            sb.append(uniArray[i]);
            if(i < uniArray.length - 1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    private static String stringFlatMatrixRow(int[][] flatMatrix, int row) {
        return getUnidimensionalString(flatMatrix[row]);
    }

    public static String getBidimensionalString(int[][] biArray) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < biArray.length; i++){
            sb.append(stringFlatMatrixRow(biArray, i));
            if(i < biArray.length - 1){
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public static int[][] flatTridimensionalArray(int[][][] triArray) {
        int rows = triArray[0].length;
        int cols = triArray[0][0].length;
        int[][] flat = new int[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                int sum = 0;
                for(int k = 0; k < triArray.length; k++){
                    sum += triArray[k][i][j];
                }
                flat[i][j] = sum;
            }
        }
        return flat;
    }

    public static void main(String[] args) {
        int[] uniArray = createAndPopulateUnidimensionalArray(5);
        System.out.println(getUnidimensionalString(uniArray));

        int[][] biArray = createAndPopulateBidimensionalArray(3, 3);
        System.out.println(getBidimensionalString(biArray));

        int[][][] triArray = createAndPopulateTridimensionalArray(2, 2, 2);
        int[][] flatMatrix = flatTridimensionalArray(triArray);
        for(int i = 0; i < flatMatrix.length; i++){
            for(int j = 0; j < flatMatrix[0].length; j++){
                System.out.print(flatMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
