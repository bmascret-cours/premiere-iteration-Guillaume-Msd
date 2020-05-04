package model;

public class Reine extends AbstractPiece{
//CONSTRUCTORS
	public Reine(Couleur color,Coord coord) {
		super(color,coord);
		this.setName("Reine");
	}
	
	
//METHODS
	@Override
	public boolean isMoveOk(int xFinal, int yFinal) {
		if ( (this.getX()-xFinal) == (this.getY()-yFinal) ){
			return true;
		}
		if ((this.getX()-xFinal!=0)&&(this.getY()-yFinal==0) ||
				(this.getX()-xFinal==0)&&(this.getY()-yFinal!=0)){
				return true;
		}
		return false;
	}
}

