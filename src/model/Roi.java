package model;

public class Roi extends AbstractPiece{
	
//CONSTRUCTORS
	public Roi(Couleur color,Coord coord) {
		super(color,coord);
		this.setName("Roi");
	}
	
	
//METHODS
	@Override
	public boolean isMoveOk(int xFinal, int yFinal) {
		if ( (Math.abs(this.getX()-xFinal)==1) && (Math.abs(this.getY()-yFinal)==0) ) {
			return true;
		}
		if ( (Math.abs(this.getX()-xFinal)==0) && (Math.abs(this.getY()-yFinal)==1) ) {
			return true;
		}
		if ( (Math.abs(this.getX()-xFinal)==1) && (Math.abs(this.getY()-yFinal)==1) ) {
			return true;
		}
		return false;
	}

}
