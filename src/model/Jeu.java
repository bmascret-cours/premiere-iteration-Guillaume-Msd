package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import tools.ChessPiecePos;
import tools.ChessPiecesFactory;

public class Jeu extends java.lang.Object {
//PARAMETERS
	private List<Pieces> lPieces = new ArrayList<Pieces>();
	private Couleur color;
	
//MAIN
	/*
	 public static void main(String[] args) {
		 Jeu jeuBlanc = new Jeu(Couleur.BLANC);
		 Jeu jeuNoir = new Jeu(Couleur.NOIR);
		 System.out.println(jeuNoir.toString());
		 System.out.println(jeuNoir.move(1,0,2,2));
		 System.out.println(jeuNoir.toString());
		 System.out.println(jeuNoir.move(2,2,4,2));
		 System.out.println(jeuNoir.toString());
	 }
	 */
	
//CONSTRUCTORS
	public Jeu(Couleur color) {
		this.lPieces = ChessPiecesFactory.newPieces(color);
		this.color = color;
	}
	
//METHODS
	public boolean capture(int xCatch,int yCatch) {
		this.findPiece(xCatch, yCatch).capture();
		return true;
	}
	
	public Pieces findPiece(int x,int y) {
		for (Pieces piece : this.lPieces) {
			if ((piece.getX()==x)&&(piece.getY()==y)) {
				return piece;
			}
		}
		return null;
	}
	
	public Couleur getPieceColor(int x,int y) {
		//on verifie qu'il y a bien une piece a la position voulue (afin d'eviter d'avoir des resultats 'null')
		//on retourne la couleur de la piece en faisant appel a la methode 'getCouleur' de l'interface 'Pieces'
		if (this.isPieceHere(x, y)==true) {
			return this.findPiece(x,y).getCouleur();
		}
		return null;
	}
	
	public String getPieceType(int x,int y) {
		//on verifie qu'il y a bien une piece et on retourne son nom avec la methode 'getName' de l'interface 'Pieces'
		if (this.isPieceHere(x, y)==true) {
			return this.findPiece(x,y).getName();
		}
		return null;
	}
	
	public Couleur getColor() {
		//renvoie la couleur du jeu (parametre de la classe)
		return this.color;
	}
	
	public Coord getKingCoord() {
		Coord coordK = new Coord(0,0);
		return coordK;
	}
	
	/**
	* @return une vue de la liste des pièces en cours
	* ne donnant que des accès en lecture sur des PieceIHM
	* (type piece + couleur + liste de coordonnées)
	*/
	public List<PieceIHM> getPiecesIHM(){
		PieceIHM newPieceIHM = null;
		List<PieceIHM> list = new LinkedList<PieceIHM>();
		

		for (Pieces piece : this.lPieces){
			boolean existe = false;
			// si le type de piece existe déjà dans la liste de PieceIHM
			// ajout des coordonnées de la pièce dans la liste de Coord de ce type
			// si elle est toujours en jeu (x et y != -1)
			for ( PieceIHM pieceIHM : list){
				if ((pieceIHM.getTypePiece()).equals(piece.getClass().getSimpleName())){
					existe = true;
					if (piece.getX() != -1){
						pieceIHM.add(new Coord(piece.getX(), piece.getY()));
					}
				}
			}
			// sinon, création d'une nouvelle PieceIHM si la pièce est toujours en jeu
			if (! existe) {
				if (piece.getX() != -1){
					newPieceIHM = new PieceIHM(piece.getClass().getSimpleName(),piece.getCouleur());
					newPieceIHM.add(new Coord(piece.getX(), piece.getY()));
					list.add(newPieceIHM);
				}
			}
		}
		return list;
	}
	
	public boolean isPawnPromotion(int xFinal,int yfinal) {
		return false;
	}
	
	
	public boolean isPieceHere(int x,int y) {
		for (Pieces piece : this.lPieces) {
			if ((piece.getX()==x)&&(piece.getY()==y)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isMoveOk(int xInit,int yInit,int xFinal,int yFinal) {
		//on verifie que la piece que l'on souhaite deplacer existe
		if ( (this.isPieceHere(xInit, yInit)==true)
			//on verifie qu'il n'y a pas de piece allié sur la case destination
			&& (this.isPieceHere(xFinal,yFinal)==false)
				//on verifie que le mouvement est possible pour la piece choisie
				&& (this.findPiece(xInit, yInit).isMoveOk(xFinal, yFinal)) ) {
					return true;
				}
		return false;
	}
	
	public boolean move(int xInit,int yInit,int xFinal,int yFinal) {
		this.findPiece(xInit, yInit).move(xFinal, yFinal);
		return true;
	}
	
	public boolean pawnPromotion(int xFinal,int yfinal,java.lang.String type) {
		return false;
	}
	
	public void setCastling() {
		
	}
	
	public void setPossibleCapture() {
		//TODO
	}
	
	public String toString() {
		ListIterator<Pieces> it = this.lPieces.listIterator();
		String result ="..";
		while(it.hasNext()){
			result = result + (String)it.next().toString() + "; ";
		}
		return result;
	}
	
	public void undoMove() {
		
	}
	
	public void undoCapture() {
		
	}
}
