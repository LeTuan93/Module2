package exercises;

public class TennisGame {
    private static final int ADVANTAGE_SCORE = 4;
    private static final String[] SCORE_NAMES = {"Love", "Fifteen", "Thirty", "Forty"};

    public static String getScore(String player1Name, String player2Name, int player1Score, int player2Score) {
        if (isDraw(player1Score, player2Score)) {
            return getDrawScore(player1Score);
        }

        if (isEndGame(player1Score, player2Score)) {
            return getEndGameScore(player1Score, player2Score);
        }

        return getStandardScore(player1Score, player2Score);
    }

    private static boolean isDraw(int player1Score, int player2Score) {
        return player1Score == player2Score;
    }

    private static String getDrawScore(int score) {
        if (score >= 3) return "Deuce";
        return SCORE_NAMES[score] + "-All";
    }

    private static boolean isEndGame(int player1Score, int player2Score) {
        return player1Score >= ADVANTAGE_SCORE || player2Score >= ADVANTAGE_SCORE;
    }

    private static String getEndGameScore(int player1Score, int player2Score) {
        int scoreDifference = player1Score - player2Score;
        String leadingPlayer = scoreDifference > 0 ? "player1" : "player2";

        if (Math.abs(scoreDifference) == 1) return "Advantage " + leadingPlayer;
        return "Win for " + leadingPlayer;
    }

    private static String getStandardScore(int player1Score, int player2Score) {
        return SCORE_NAMES[player1Score] + "-" + SCORE_NAMES[player2Score];
    }
}
