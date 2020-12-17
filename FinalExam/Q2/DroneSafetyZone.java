import java.util.Random;

/*


Writes the following prototype of the method:
String SafteyAlert(Circle[] swarm)
which takes as input an array of Circle objects and returns a String as follows:
- "Red": if at least two circles intersect
- "Yellow": If no circles intersect AND at least two circles become tangential
- "Green" : if there are no tangential or intersecting circles at all
**Two safety zones of two drones are:
- "not intersecting" (Green) if the summation of their radii is smaller than the distance between their centers. 
- "tangential" (Yellow) if the summation of their radii is exactly equal to the distance between their centers. 
- "intersecting" (Red) if the summation of their radii is larger than the distance between their centers.
 
*/

	
public class DroneSafetyZone{

 public String SafetyAlert(MyCircle[] swarm){
    int flagIntersect = 0;
    int flagTang =0;
    for (int i=0; i<swarm.length;i++){
      for (int j =i+1; j<swarm.length; j++){
        //calculate the change in x and y between two circles
        int deltaX = swarm[i].getX()-swarm[j].getX(); 
        int deltaY = swarm[i].getY()-swarm[j].getY();
        //calculate the radius of each 
        double r1 = swarm[i].getRadius();
        double r2 = swarm[j].getRadius();
        //distance between two circles 
        double distXY = Math.sqrt(deltaX*deltaX+deltaY*deltaY);
        //sum of radii between the two circles
        double sumR = r1 + r2;
        //check the following conditions
        if (distXY<sumR){
          flagIntersect++;
        }
        else if (distXY==sumR){
          flagTang++;
        }
      }
    }

    if (flagIntersect > 0) {
      return "Red";
    }
    else if (flagTang>0 && flagIntersect==0){
      return "Yellow";    
    }
    return "Green";
 }	
}
