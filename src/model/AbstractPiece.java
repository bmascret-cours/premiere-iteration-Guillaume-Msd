package model;

public abstract class AbstractPiece extends java.lang.Object implements Pieces{
	private String name = "";
	private Coord coord = null;
	private Couleur color = Couleur.NOIRBLANC;
	
//CONSTRUCTORS
	public AbstractPiece(Couleur color,Coord coord) {
		this.coord = coord;
		this.color = color;
	}
	
	@Override
	public boolean capture() {
		this.coord = new Coord(-1,-1);
		return true;
	}
	
	@Override
	public Couleur getCouleur() {
		return this.color;
	}
	
	@Override
	public int getX() {
		return this.coord.x;
	}
	
	@Override
	public int getY() {
		return this.coord.y;
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public abstract boolean isMoveOk(int xFinal, int yFinal);
	
	@Override
	public boolean move(int xFinal, int yFinal) {
		this.coord.x = xFinal;
		this.coord.y = yFinal;
		return true;
	}
	
	@Override
	public String toString() {
		return "["+ this.getName() + ", " +  this.getCouleur() + ", ("
					+ this.getX() + "," + this.getY() + ")]";
	}

}
