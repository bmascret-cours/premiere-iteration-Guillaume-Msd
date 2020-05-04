package model;

public class Tour extends AbstractPiece {
//CONSTRUCTORS
	public Tour(Couleur color,Coord coord) {
		super(color,coord);
		this.setName("Tour");
	}
	
	
//METHODS
	@Override
	public boolean isMoveOk(int xFinal, int yFinal) {
		if ((this.getX()-xFinal!=0)&&(this.getY()-yFinal==0) ||
			(this.getX()-xFinal==0)&&(this.getY()-yFinal!=0)){
			return true;
		}
		return false;
	}
}
