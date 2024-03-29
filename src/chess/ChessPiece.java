package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

/*
 * Esta � a classe pe�a de xadrez, que pode ser Preta ou branca, al�m de ser uma subclasse
 * da classe Piece, pois tamb�m possui acesso ao tabuleiro, locomovendo-se por ele.
 */

public abstract class ChessPiece extends Piece {

	private Color color;
	private int moveCount;

	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	// A cor de uma pe�a pode apenas ser acessada.
	public Color getColor() {
		return color;
	}
	
	public int getMoveCount() {
		return moveCount;
	}
	
	public void increaseMoveCount() {
		moveCount++;
	}
	
	public void decreaseMoveCount() {
		moveCount--;
	}

	// M�todo para retornar a posi��o da pe�a no tabuleiro "Ex: c2"
	public ChessPosition getChessPosition() {
		return ChessPosition.fromPosition(position);
	}

	/*
	 * Este m�todo verifica se a pe�a que est� no tabuleiro � de um oponente ou n�o.
	 * Criamos uma vari�vel do tipo ChessPiece e verificamos se a posi��o �
	 * diferente de nula e se a cor da pe�a � diferente da nossa.
	 */
	protected boolean isThereOpponentPiece(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return p != null && p.getColor() != color;
	}

}
