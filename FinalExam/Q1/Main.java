class Main {  
  public static void main(String args[]){
    int x,y,z;
    Point3D pnt3D = new Point3D(5,4,5);
    
    x = pnt3D.getX();
    y = pnt3D.getY();
    z = pnt3D.getZ();
    //print the coordinates using toString
    System.out.println(pnt3D.toString());
    //print the coordinates individually
    System.out.println("x:"+x+"\ny:"+y+"\nz:"+z);

    //get the distance from origin
    double dist = pnt3D.distancefromOrigin();
    System.out.println(dist);
  }
}
