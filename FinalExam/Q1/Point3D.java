
//Java Programming Exam Question

public class Point3D extends Point{
  private int z; 

  //constructs the point (0, 0,0)
  public Point3D(){
    super(0,0);
    this.z= 0;
  }
  //constructs a point with the given x/y/z coordinates
  public Point3D (int x, int y, int z){
    super(x,y);
    this.z=z;
  }

  //sets the coordinates to the given values when the parent method is called
  public void setLocation (int x, int y){  
    setLocation(x,y,0);
  }

  //returns the z-coordinate
  public int getZ(){
    return this.z;
  }
  //sets the coordinates to teh values when the setlocation is called with 3 parameters
  public void setLocation (int x, int y, int z){
    super.setPoint(x, y);
    this.z = z;
  }
  //returns the distance from the origin
  public double distancefromOrigin() {
    return Math.sqrt(getX()*getX()+getY()*getY()+getZ()*getZ());
  }

  @Override
  public String toString(){
    return ("("+this.x+","+this.y +","+this.z +")");
  }
}
