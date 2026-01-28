package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class knightMovesCalculator implements moveCalculator {

    private void calculate(ChessBoard board, ChessPosition myPosition, ArrayList<ChessMove> output, ChessGame.TeamColor myTeam, int testRow, int testCol){
        if(testRow <= 8 && testRow >= 1 && testCol <= 8 && testCol >= 1) {
            ChessPosition testPos = new ChessPosition(testRow, testCol);
            if (board.getPiece(testPos) == null) {
                output.add(new ChessMove(myPosition, testPos, null));
            } else {
                if (board.getPiece(testPos).getTeamColor() != myTeam) {
                    output.add(new ChessMove(myPosition, testPos, null));
                }
            }

        }
    }

    @Override
    public Collection<ChessMove> possibleMoves(ChessBoard board, ChessPosition myPosition) {
        int myRow = myPosition.getRow();
        int myCol = myPosition.getColumn();
        ChessGame.TeamColor myTeam = board.getPiece(myPosition).getTeamColor();

        ArrayList<ChessMove> moves = new ArrayList<>();
        calculate(board,myPosition,moves,myTeam,myRow+1,myCol+2);
        calculate(board,myPosition,moves,myTeam,myRow-1,myCol+2);
        calculate(board,myPosition,moves,myTeam,myRow+1,myCol-2);
        calculate(board,myPosition,moves,myTeam,myRow-1,myCol-2);
        calculate(board,myPosition,moves,myTeam,myRow+2,myCol+1);
        calculate(board,myPosition,moves,myTeam,myRow+2,myCol-1);
        calculate(board,myPosition,moves,myTeam,myRow-2,myCol+1);
        calculate(board,myPosition,moves,myTeam,myRow-2,myCol-1);
        return moves;
    }
}
