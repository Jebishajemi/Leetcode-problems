public class Spreadsheet {
    private int[][] grid;

    public Spreadsheet(int rows) {
        // Initialize grid with given rows and 26 columns (A-Z)
        grid = new int[rows][26];
    }

    public void setCell(String cell, int value) {
        int[] pos = parseCell(cell);
        int row = pos[0];
        int col = pos[1];
        grid[row][col] = value;
    }

    public void resetCell(String cell) {
        int[] pos = parseCell(cell);
        int row = pos[0];
        int col = pos[1];
        grid[row][col] = 0;
    }

    public int getValue(String formula) {
        if (!formula.startsWith("=")) {
            throw new IllegalArgumentException("Formula must start with '='");
        }

        formula = formula.substring(1); // remove '='
        String[] parts = formula.split("\\+");

        return getOperandValue(parts[0]) + getOperandValue(parts[1]);
    }

    private int getOperandValue(String operand) {
        // Check if operand starts with a letter => cell reference
        if (Character.isLetter(operand.charAt(0))) {
            int[] pos = parseCell(operand);
            int row = pos[0];
            int col = pos[1];
            return grid[row][col];
        } else {
            return Integer.parseInt(operand);
        }
    }

    private int[] parseCell(String cell) {
        // First character is column (A-Z)
        char colChar = cell.charAt(0);
        int col = colChar - 'A';

        // Remaining characters are row number
        int row = Integer.parseInt(cell.substring(1)) - 1; // Convert 1-indexed to 0-indexed

        return new int[]{row, col};
    }
}
