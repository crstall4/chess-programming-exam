package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class queenMovesCalculator implements moveCalculator {

    private void calculate(ChessBoard board, ChessPosition myPosition, ArrayList<ChessMove> output, ChessGame.TeamColor myTeam, int myRow, int myCol, int rowdir, int coldir){
        int testRow = myRow;
        int testCol = myCol;
        testRow+=rowdir;
        testCol+=coldir;
        boolean taken = false;
        while(testRow <= 8 && testRow >= 1 && testCol <= 8 && testCol >= 1 && !taken){
            ChessPosition testPos = new ChessPosition(testRow,testCol);
            if(board.getPiece(testPos) == null){
                output.add(new ChessMove(myPosition, testPos, null));
                testRow+=rowdir;
                testCol+=coldir;
            }
            else{
                if(board.getPiece(testPos).getTeamColor() != myTeam){
                    output.add(new ChessMove(myPosition, testPos, null));
                }
                taken = true;
            }
        }

    }

    @Override
    public Collection<ChessMove> possibleMoves(ChessBoard board, ChessPosition myPosition) {
        int myRow = myPosition.getRow();
        int myCol = myPosition.getColumn();
        ChessGame.TeamColor myTeam = board.getPiece(myPosition).getTeamColor();

        ArrayList<ChessMove> moves = new ArrayList<>();
        calculate(board,myPosition,moves,myTeam,myRow,myCol,1,1);
        calculate(board,myPosition,moves,myTeam,myRow,myCol,-1,1);
        calculate(board,myPosition,moves,myTeam,myRow,myCol,1,-1);
        calculate(board,myPosition,moves,myTeam,myRow,myCol,-1,-1);
        calculate(board,myPosition,moves,myTeam,myRow,myCol,1,0);
        calculate(board,myPosition,moves,myTeam,myRow,myCol,0,1);
        calculate(board,myPosition,moves,myTeam,myRow,myCol,-1,0);
        calculate(board,myPosition,moves,myTeam,myRow,myCol,0,-1);

        return moves;
    }
}
