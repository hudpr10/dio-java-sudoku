import java.io.Console;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Bem-vindo(a) ao Sudoku feito em Java ===");
        System.out.println("Esta é a tabela de hoje, pronto para jogar?");

        SudokuTable sudokuTable = new SudokuTable();
        sudokuTable.defaultValues(args);
        sudokuTable.showSudokuTable();

        System.out.println("Por favor siga o padrão para jogar:\nposiçãoY,posiçãoX,valor --> (3,1,9)");
        System.out.println("Digite 'resultado' quando a tabela estiver pronta para verificar se a solução está correta");

        Scanner input = new Scanner(System.in);
        boolean isRunning = true;

        while(isRunning) {
            System.out.print("Digite: ");
            String userValue = input.next();
            if(userValue.equalsIgnoreCase("resultado")) {
                if(sudokuTable.finishSudoku()) {
                    isRunning = false;
                } else {
                    continue;
                }
            }

            try {
                String[] userValueSplit = userValue.split(",");
                int posX = Integer.parseInt(userValueSplit[0]);
                int posY = Integer.parseInt(userValueSplit[1]);
                int value = Integer.parseInt(userValueSplit[2]);
                sudokuTable.changeValue(posX, posY, value);
            } catch (Exception e) {
                System.out.println("Por favor, siga o padrão proposto.");
            }

            sudokuTable.showSudokuTable();
        }
    }
}