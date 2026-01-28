package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class pawnMovesCalculator implements moveCalculator {

    private void calculate(ChessBoard board, ChessPosition myPosition, ArrayList<ChessMove> output, ChessGame.TeamColor myTeam, int testRow, int testCol, boolean mustKill){
        if(testRow <= 8 && testRow >= 1 && testCol <= 8 && testCol >= 1) {
            ChessPosition testPos = new ChessPosition(testRow, testCol);
            if (board.getPiece(testPos) == null) {
                if(!mustKill) {
                    if ((myTeam == ChessGame.TeamColor.WHITE && testPos.getRow() != 8) || (myTeam == ChessGame.TeamColor.BLACK && testPos.getRow() != 1)) {
                        output.add(new ChessMove(myPosition, testPos, null));
                    } else {
                        output.add(new ChessMove(myPosition, testPos, ChessPiece.PieceType.ROOK));
                        output.add(new ChessMove(myPosition, testPos, ChessPiece.PieceType.KNIGHT));
                        output.add(new ChessMove(myPosition, testPos, ChessPiece.PieceType.BISHOP));
                        output.add(new ChessMove(myPosition, testPos, ChessPiece.PieceType.QUEEN));
                    }
                }
            }
            else {
                if (board.getPiece(testPos).getTeamColor() != myTeam) {
                    if(mustKill) {
                        if ((myTeam == ChessGame.TeamColor.WHITE && testPos.getRow() != 8) || (myTeam == ChessGame.TeamColor.BLACK && testPos.getRow() != 1)) {
                            output.add(new ChessMove(myPosition, testPos, null));
                        } else {
                            output.add(new ChessMove(myPosition, testPos, ChessPiece.PieceType.ROOK));
                            output.add(new ChessMove(myPosition, testPos, ChessPiece.PieceType.KNIGHT));
                            output.add(new ChessMove(myPosition, testPos, ChessPiece.PieceType.BISHOP));
                            output.add(new ChessMove(myPosition, testPos, ChessPiece.PieceType.QUEEN));
                        }
                    }
                }
            }

        }
    }

    @Override
    public Collection<ChessMove> possibleMoves(ChessBoard board, ChessPosition myPosition) {
        int myRow = myPosition.getRow();
        int myCol = myPosition.getColumn();
        ChessGame.TeamColor myTeam = board.getPiece(myPosition).getTeamColor();
        int forwards = 1;
        if(myTeam == ChessGame.TeamColor.BLACK){
            forwards = -1;
        }

        ArrayList<ChessMove> moves = new ArrayList<>();
        calculate(board,myPosition,moves,myTeam,myRow+forwards,myCol,false);
        calculate(board,myPosition,moves,myTeam,myRow+forwards,myCol+1,true);
        calculate(board,myPosition,moves,myTeam,myRow+forwards,myCol-1,true);
        if(myTeam == ChessGame.TeamColor.WHITE && myPosition.getRow() == 2){
            if(board.getPiece(new ChessPosition(myRow+forwards,myCol)) == null) {
                calculate(board, myPosition, moves, myTeam, myRow + forwards + forwards, myCol, false);
            }
        }
        if(myTeam == ChessGame.TeamColor.BLACK && myPosition.getRow() == 7){
            if(board.getPiece(new ChessPosition(myRow+forwards,myCol)) == null) {
                calculate(board, myPosition, moves, myTeam, myRow + forwards + forwards, myCol, false);
            }
        }
        return moves;
    }
}
