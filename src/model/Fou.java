package model;

public class Fou extends AbstractPiece{
//CONSTRUCTORS
	public Fou(Couleur color,Coord coord) {
		super(color,coord);
		this.setName("Fou");
	}
	
	
//METHODS
	@Override
	public boolean isMoveOk(int xFinal, int yFinal) {
		if ( (this.getX()-xFinal) == (this.getY()-yFinal) ){
			return true;
		}
		return false;
	}

}
