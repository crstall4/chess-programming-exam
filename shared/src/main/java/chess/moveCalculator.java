package chess;

import java.util.Collection;

public interface moveCalculator {
    Collection<ChessMove> possibleMoves(ChessBoard board, ChessPosition myPosition);
}
