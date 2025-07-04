public class SudokuNumber {
    public int posX;
    public int posY;

    public int value;

    private final int expectedValue;
    private final boolean isFixed;

    public SudokuNumber(int posX, int posY, int expectedValue, boolean isFixed) {
        this.posX = posX;
        this.posY = posY;
        this.value = isFixed ? expectedValue : 0;
        this.expectedValue = expectedValue;
        this.isFixed = isFixed;
    }

    public boolean getIsFixed() {
        return this.isFixed;
    }

    public void changeNumber(int value) {
        this.value = value;
    }

    public int getExpectedValue() {
        return expectedValue;
    }

    public int getValue() {
        return value;
    }

    public boolean expectedValueEqualsValue() {
        return this.value == this.expectedValue;
    }
}
