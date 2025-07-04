import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class SudokuTable {
    SudokuNumber[][] sudokuTable;

    public SudokuTable() {
        this.sudokuTable = new SudokuNumber[9][9];
    }

    // Processamento da entrada dos valores padrões
    public void defaultValues(String[] values) {
        for(String argsNumber : values) {
            String[] cleaning = argsNumber.split(";");
            String[] positionXAndY = cleaning[0].split(",");
            String[] valueAndFixed = cleaning[1].split(",");

            int positionX = Integer.parseInt(positionXAndY[0]);
            int positionY = Integer.parseInt(positionXAndY[1]);

            int expectedValue = Integer.parseInt(valueAndFixed[0]);
            boolean fixed = Boolean.parseBoolean(valueAndFixed[1]);

            this.addDefaultNumbers(positionX, positionY, expectedValue, fixed);
        }
    }

    // Método auxiliar para adicionar os números padrões do Sudoku
    private void addDefaultNumbers(int x, int y, int expectedValue, boolean fixed) {
        SudokuNumber sudokuNumber = new SudokuNumber(x, y, expectedValue, fixed);
        sudokuTable[x][y] = sudokuNumber;
    }

    // Exibindo Sudoko no Console
    public void showSudokuTable() {
        List<String> listToPrint = new ArrayList<>();

        for(int x = 0; x < sudokuTable.length; x++) {
            for(int y = 0; y < sudokuTable.length; y++) {
                if(sudokuTable[x][y].value == 0) {
                    listToPrint.add("-");
                } else {
                    listToPrint.add(String.valueOf(sudokuTable[x][y].value));
                }
            }
        }

        System.out.printf((TableTemplate.TABLE_TEMPLATE), listToPrint.toArray());
    }

    // Alterando Valores no Sudoku
    public void changeValue(int x, int y, int value) {
        if(validateUserInput(x, y, value)) {
            this.sudokuTable[x-1][y-1].changeNumber(value);
        }
    }

    // Método Auxiliar para validar a entrada no usuário
    private boolean validateUserInput(int x, int y, int value) {
        if(x > 9 || x < 1) {
            System.out.println("O 'x' precisa ser entre 1 e 9");
            return false;
        }

        if(y > 9 || y < 1) {
            System.out.println("O 'y' precisa ser entre 1 e 9");
            return false;
        }

        if(value < 1 || value > 9) {
            System.out.println("O valor precisa ser entre 1 e 9");
            return false;
        }

        if(this.sudokuTable[x-1][y-1].getIsFixed()) {
            System.out.println("Esse número não pode ser alterado.");
            return false;
        }

        return true;
    }

    // Validando Sudoku
    public boolean finishSudoku() {
        boolean result = false;

        if(validateColumns() && validateLines() && allNumberCombine()) {
            System.out.println("O Sudoku está correto. Parabéns!");
            result = true;
        } else {
            System.out.println("O Sudoku está incorreto. Dê uma olhada nos números...");
        }

        return result;
    }
    private boolean validateLines() {
        boolean areCorrected = true;

        for(int x = 0; x < sudokuTable.length; x++) {
            List<Integer> line = new ArrayList<>();
            for(int y = 0; y < sudokuTable.length; y++) {
                line.add(sudokuTable[x][y].value);
            }
            List<Integer> lineWithoutSameNumbers = line.stream().distinct().toList();
            if(!line.equals(lineWithoutSameNumbers)) {
                areCorrected = false;
                break;
            }
        }

        return areCorrected;
    }
    private boolean validateColumns() {
        boolean areCorrected = true;

        for(int x = 0; x < sudokuTable.length; x++) {
            List<Integer> column = new ArrayList<>();
            for(int y = 0; y < sudokuTable.length; y++) {
                column.add(sudokuTable[y][x].value);
            }
            List<Integer> columnWithoutSameNumbers = column.stream().distinct().toList();
            if(!column.equals(columnWithoutSameNumbers)) {
                areCorrected = false;
                break;
            }
        }

        return areCorrected;
    }
    private boolean allNumberCombine() {
        boolean allNumbersCombine = false;

        for(int x = 0; x < sudokuTable.length; x++) {
            for(int y =0; y < sudokuTable.length; y++) {
                if(sudokuTable[x][y].expectedValueEqualsValue()) {
                    allNumbersCombine = true;
                }
            }
        }

        return allNumbersCombine;
    }
}
