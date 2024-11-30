package ramStudio.chessGame;

import ramStudio.enums.Colors;
import java.util.Scanner;

public class ChessGame {
    private static Colors currentPlayer;

    public static void main(String[] args) {
        var board = new Board();
        var scanner = new Scanner(System.in);
        currentPlayer = Colors.White;

        System.out.println("""
               Чтобы проверить игру надо вводить команды:
               'exit' - для выхода
               'replay' - для перезапуска игры
               'castling0' или 'castling7' - для рокировки по соответствующей линии
               'move 1 1 2 3' - для передвижения фигуры с позиции 1 1 на 2 3(поле это двумерный массив от 0 до 7)
               Проверьте могут ли фигуры ходить друг сквозь друга, корректно ли съедают друг друга, можно ли поставить шах и сделать рокировку?""");

        System.out.println();

        while (true) {
            board.draw();
            System.out.println("Ход " + currentPlayer);
            String s = scanner.nextLine();
            if (s.equals("exit")) break;
            else if (s.equals("replay")) {
                System.out.println("Заново");
                board = new Board();
            } else {
                if (s.equals("castling0")) {
                    if (board.castling0()) {
                        System.out.println("Рокировка удалась");
                    } else {
                        System.out.println("Рокировка не удалась");
                    }
                } else if (s.equals("castling7")) {
                    if (board.castling7()) {
                        System.out.println("Рокировка удалась");
                    } else {
                        System.out.println("Рокировка не удалась");
                    }
                } else if (s.contains("move")) {
                    String[] a = s.split(" ");
                    try {
                        int line = Integer.parseInt(a[1]) - 1;
                        int column = Integer.parseInt(a[2]) - 1;
                        int toLine = Integer.parseInt(a[3]) - 1;
                        int toColumn = Integer.parseInt(a[4]) - 1;

                        if (board.moveToPosition(line, column, toLine, toColumn)) {
                            System.out.println("Успешно передвинулись");
                            changePlayer();
                        } else System.out.println("Передвижение не удалось");
                    } catch (Exception e) {
                        System.out.println("Вы что-то ввели не так, попробуйте ещё раз");
                    }
                }
            }
        }
    }

    private static void changePlayer() {
        currentPlayer = currentPlayer == Colors.White ? Colors.Black : Colors.White;
    }
}