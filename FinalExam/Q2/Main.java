class Main {  
	public static void main(String[] args) {
    MyCircle swarm[] = new MyCircle[100]; //an array of 100 circles 
    
		for (int i=0; i<100; i++){
      //random array generator
      swarm[i] = new MyCircle((int)(Math.random()*100),(int)(Math.random()*100),(double)Math.round(rand * 100) / 100);
      
    }
    DroneSafetyZone zone = new DroneSafetyZone(); 
    System.out.println(zone.SafetyAlert(swarm));  //print the answer
	}
}
