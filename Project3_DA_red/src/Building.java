import java.util.ArrayList;

public class Building implements IBuilding{

  //NOTE:: Destinations are END points, buses routes are one way, building to building are both ways
  ArrayList<IBuilding> destinations;
  String name;
  int x;
  int y;
  boolean isBus;

  
  public Building(String name) {
    this.name = name;
  }
  
  public Building(String name, int x, int y, boolean isBus) {
    this.name = name;
    this.x = x;
    this.y = y;
    this.isBus = isBus;
  }
  
  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public String getName() {
    return name;
  }

  public void addDestination(IBuilding dest) {
    destinations.add(dest);
  }
  
  public ArrayList<IBuilding> getDestinations(){
    return destinations;
  }

  public boolean isBus() {
    return isBus;
  }
  
}
