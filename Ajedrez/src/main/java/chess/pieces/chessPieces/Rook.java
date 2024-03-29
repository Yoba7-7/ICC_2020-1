package chess.pieces.chessPieces;

import java.util.LinkedList;
import java.util.List;
import chess.items.Board;
import chess.items.Position;
import chess.pieces.ColorEnum;
import chess.pieces.Piece;
import chess.pieces.PiecesTypeEnum;

/**
*Clase Rook. Define una pieza de tipo Rook. Es clase hija de Piece.
*/
public class Rook extends Piece {
	
/**
*Constructor de Rook. Llama al constructor de Piece y suma su tipo de pieza.
*/
    public Rook(Position p, ColorEnum color) {
        super(p, color);
        this.type = PiecesTypeEnum.ROOK;
    }

/**
*Metodo getLegalMoves. Implementa el metodo abstracto de Piece.Llena una lista con los posibles 
*movimientos de la pieza Rook.
@return legalMoves. La lista con los movimientos permitidos.
*/

@Override
    public List<Position> getLegalMoves() {
        Board board = Board.getInstance();
        this.legalMoves = new LinkedList<Position>();
        
		//for para el movimiento hacia abajo.
		for (int i = this.position.getX() + 1; i < 8; i++) {
            Position nextLegalPosition = new Position(i, this.position.getY());
			if (this.isAppendable(nextLegalPosition) == -1)
                break;
            if (this.isAppendable(nextLegalPosition) == 0) {
                this.legalMoves.add(nextLegalPosition);
                break;
            }
            this.legalMoves.add(nextLegalPosition);
        }

		//for para el movimiento hacia arriba.
        for (int i = this.position.getX() - 1; i >= 0; i--) {
            Position nextLegalPosition = new Position(i, this.position.getY());
            Piece piece = board.getPiece(nextLegalPosition);
			if (piece.getColor() == this.getColor())
                break;
            if (piece.getColor() != ColorEnum.NONE) {
                this.legalMoves.add(nextLegalPosition);
                break;
            }
            this.legalMoves.add(nextLegalPosition);

        }

		//for para el movimiento hacia la derecha.
        for (int i = this.position.getY() + 1; i < 8; i++) {
            Position nextLegalPosition = new Position(this.position.getX(), i);
            Piece piece = board.getPiece(nextLegalPosition);
            if (piece.getColor() == this.getColor())
                break;
            if (piece.getColor() != ColorEnum.NONE) {
                this.legalMoves.add(nextLegalPosition);
                break;
            }
            this.legalMoves.add(nextLegalPosition);

        }

		//for para el movimiento hacia la izquierda.
        for (int i = this.position.getY() - 1; i >= 0; i--) {
            Position nextLegalPosition = new Position(this.position.getX(), i);
            Piece piece = board.getPiece(nextLegalPosition);
            if (piece.getColor() == this.getColor())
                break;
            if (piece.getColor() != ColorEnum.NONE) {
                this.legalMoves.add(nextLegalPosition);
                break;
            }
            this.legalMoves.add(nextLegalPosition);

        }

        return this.legalMoves;
    }

}