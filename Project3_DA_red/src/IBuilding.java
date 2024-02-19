
import java.util.ArrayList;

public interface IBuilding{

        public int getX();

        public int getY();

        public String getName();

        public ArrayList<IBuilding> getDestinations();

        public boolean isBus();
        
        public void addDestination(IBuilding dest);
}
