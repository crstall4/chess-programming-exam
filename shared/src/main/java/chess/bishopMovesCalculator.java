package chess;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class bishopMovesCalculator implements moveCalculator {

    @Override
    public Collection<ChessMove> possibleMoves(ChessBoard board, ChessPosition myPosition) {
        ArrayList<ChessMove> moves = new ArrayList<>();
        moves.add(new ChessMove(myPosition, new ChessPosition(1,1), null));
        return moves;
    }
}
