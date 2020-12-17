public class MyCircle{
    private double radius; 	
    private Point  centre; 

	/** The implementation of the Point class in Point.java file **/
	
	public double getRadius(){
		return radius;
	}
	
	public int getX() {
		return centre.getX();
	}
  
  public int getY(){
		return centre.getY();
	}
	public Point getCentre(){
		 return new Point(centre.getX(), centre.getY());
	}

	public MyCircle(int x,int y, double radius){
    this.radius = radius;
    this.centre = new Point (x,y);
  }
  public MyCircle(){
    radius = 0;
    centre = new Point (0,0);
  }
}
