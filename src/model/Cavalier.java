package model;

public class Cavalier extends AbstractPiece {
//CONSTRUCTORS
	public Cavalier(Couleur color,Coord coord) {
		super(color,coord);
		this.setName("Cavalier");
	}
	
	
//METHODS
	@Override
	public boolean isMoveOk(int xFinal, int yFinal) {
		if ( ( Math.abs(this.getX()-xFinal) ==2) && (Math.abs(this.getY()-yFinal) ==1 ) ||
				( Math.abs(this.getX()-xFinal) ==1) && (Math.abs(this.getY()-yFinal) ==2)){
				return true;
		}
		return false;
	}
}
