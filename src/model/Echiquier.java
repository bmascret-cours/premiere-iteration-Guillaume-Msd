package model;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import model.observable.ChessGame;

public class Echiquier extends java.lang.Object implements BoardGames  {
//PARAMETERS
	private Jeu jeuCourrant;
	private Jeu jeuAdverse;
	private String message = "";
	private Jeu jeuBlanc;
	private Jeu jeuNoir;
	
	
/*
//MAIN	
	public static void main(String[] args) {
		 Echiquier echiquier = new Echiquier();
		 System.out.println(echiquier.toString());
		 echiquier.jeuCourrant = echiquier.jeuBlanc;
		 System.out.println(echiquier.getPiecesIHM());
	}
*/
		 
	
//CONSTRUCTOR
	public Echiquier() {
		super();
		this.jeuBlanc = new Jeu(Couleur.BLANC);
		this.jeuNoir = new Jeu(Couleur.NOIR);
		this.jeuCourrant = this.jeuBlanc;
		this.jeuAdverse = this.jeuNoir;
	}
	
//METHODS
	@Override
	public String getMessage() {
		return this.message;
	}
	
	private void setMessage(String message) {
		this.message = message;
	}

	@Override
	public Couleur getColorCurrentPlayer() {
		return this.jeuCourrant.getColor();
	}

	@Override
	public Couleur getPieceColor(int x, int y) {
		if (this.jeuBlanc.isPieceHere(x, y)==true) {
			return Couleur.BLANC;
		}
		if (this.jeuNoir.isPieceHere(x, y)==true) {
			return Couleur.NOIR;
		}
		return null;
	}
	
	public List<PieceIHM> getPiecesIHM(){
		PieceIHM newPieceIHM = null;
		List<PieceIHM> list = new LinkedList<PieceIHM>();
		list.addAll(this.jeuNoir.getPiecesIHM());
		list.addAll(this.jeuBlanc.getPiecesIHM());
		return list;
	}
	
	@Override
	public boolean isEnd() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean isMoveOk(int xInit,int yInit,int xFinal,int yFinal) {
		if (this.jeuCourrant.isMoveOk(xInit, yInit, xFinal, yFinal) == true) {
			System.out.println("deplacement OK");
			return true;
		}
		System.out.println("deplacement impossible");	
		return false;
	}

	@Override
	public boolean move(int xInit, int yInit, int xFinal, int yFinal) {
		if(this.jeuAdverse.isPieceHere(xFinal, yFinal)) {
			this.jeuAdverse.capture(xFinal, yFinal);
		}
		this.jeuCourrant.move(xInit, yInit, xFinal, yFinal);	
		return true;
	}
	
	public String toString() {
		return this.jeuBlanc.toString() + "\n" 
				+ this.jeuNoir.toString();
	}
	
	public void switchPlayer() {
		if (this.getColorCurrentPlayer()==Couleur.BLANC){
			this.jeuCourrant = this.jeuNoir;
			this.jeuAdverse = this.jeuBlanc;
			return;
		}
		else if (this.getColorCurrentPlayer()==Couleur.NOIR){
			this.jeuCourrant = this.jeuBlanc;
			this.jeuAdverse = this.jeuNoir;
			return;
		}
	}
}
