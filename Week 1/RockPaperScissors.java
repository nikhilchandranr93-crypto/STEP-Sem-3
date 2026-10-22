import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    private static final String[] MOVES = {"Rock", "Paper", "Scissors"};

    public static String playRound(String playerMove, String computerMove) {
        String player = normalize(playerMove);
        String computer = normalize(computerMove);
        if (player == null || computer == null) {
            return "Invalid Round";
        }
        if (player.equals(computer)) {
            return "Draw";
        }
        boolean playerWins =
                (player.equals("Rock") && computer.equals("Scissors"))
                || (player.equals("Paper") && computer.equals("Rock"))
                || (player.equals("Scissors") && computer.equals("Paper"));
        return playerWins ? "Player Wins" : "Computer Wins";
    }

    private static String normalize(String move) {
        if (move == null) {
            return null;
        }
        switch (move.trim().toLowerCase()) {
            case "rock":
            case "r":
                return "Rock";
            case "paper":
            case "p":
                return "Paper";
            case "scissors":
            case "s":
                return "Scissors";
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        String[] playerMoves = args.length > 0 ? args : readMoves(5);
        int rounds = playerMoves.length;
        Random random = new Random();

        String[] computerMoves = new String[rounds];
        String[] results = new String[rounds];

        for (int i = 0; i < rounds; i++) {
            computerMoves[i] = MOVES[random.nextInt(MOVES.length)];
            results[i] = playRound(playerMoves[i], computerMoves[i]);
        }

        System.out.println("Round | Player Move | Computer Move | Result");
        System.out.println("--------------------------------------------------");

        int wins = 0;
        int losses = 0;
        int draws = 0;

        for (int i = 0; i < rounds; i++) {
            System.out.printf("%-5d | %-11s | %-13s | %s%n",
                    i + 1, playerMoves[i], computerMoves[i], results[i]);
            if (results[i].equals("Player Wins")) {
                wins++;
            } else if (results[i].equals("Computer Wins")) {
                losses++;
            } else if (results[i].equals("Draw")) {
                draws++;
            }
        }

        double winPercentage = rounds == 0 ? 0.0 : (wins * 100.0) / rounds;

        System.out.println("--------------------------------------------------");
        System.out.printf("Final Summary: Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n",
                wins, losses, draws, winPercentage);
    }

    private static String[] readMoves(int rounds) {
        List<String> moves = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            while (moves.size() < rounds && scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (!line.isEmpty()) {
                    moves.add(line);
                }
            }
        } catch (Exception ignored) {
        }
        if (moves.isEmpty()) {
            return new String[]{"Rock", "Paper", "Scissors", "Rock", "Paper"};
        }
        return moves.toArray(new String[0]);
    }
}
