package model;

public class Pion extends AbstractPiece{
//CONSTRUCTORS
	public Pion(Couleur color,Coord coord) {
		super(color,coord);
		this.setName("Pion");
	}
	
	
//METHODS
	@Override
	public boolean isMoveOk(int xFinal, int yFinal) {
		if (this.getX()-xFinal==0){
			if ( ((this.getY()==1) && (yFinal==3))  || 
				((this.getY()==6) && (yFinal==4)) ) { // le pion effectue son premier deplacement
				return true;
			}
			if ( (this.getY()-yFinal) == 1) {
				return true;
			}
		}
		if ( (Math.abs(this.getX()-xFinal)==1) && (Math.abs(this.getY()-yFinal)==0) ) {
			return true;
		}
		return false;
	}
}