public class Spreadsheet {
    private Cell[][] cells;
    private int width;
    private int height;

    public Spreadsheet(int x, int y) {
        this.width = x;
        this.height = y;
        this.cells = new Cell[x][y];
    }
    public Cell get(int x, int y) {
        if (isValid(x, y)) {
            return cells[x][y];
        } else {
            throw new IllegalArgumentException("Invalid cell coordinates: (" + x + ", " + y + ")");
        }
    }

    public void setCell(Cell cellIn ,int x, int y) {
        this.cells[x][y] = cellIn;
    }

    public int width() {
        return this.width;
    }
    public int height() {
        return this.height;
    }
    public int xCell(String c) {
        String columnPart = c.replaceAll("[^A-Za-z]", ""); // Extract the column letters
        int x = 0;
        for (int i = 0; i < columnPart.length(); i++) {
            char letter = columnPart.charAt(i);
            if (letter < 'A' || letter > 'Z') {
                return -1; // Invalid column name
            }
            x = x * 26 + (letter - 'A' + 1); // Convert column letters to a number
        }
        return x - 1; // Convert to zero-based index
    }
    public int yCell(String c) {
        String rowPart = c.replaceAll("[^0-9]", ""); // Extract the row numbers
        if (rowPart.isEmpty()) {
            return -1; // Invalid row
        }
        int y = Integer.parseInt(rowPart);
        return y;
    }
    private boolean isValid(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }
}
