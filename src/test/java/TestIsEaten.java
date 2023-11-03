import com.example.grasshopper.Frog;
import com.example.grasshopper.Grasshopper;
import com.example.grasshopper.HelloController;
import com.example.grasshopper.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestIsEaten {
@Test
    public void isAliveTest1() {
        Frog frog = new Frog(new Point(0,0),1);
         ArrayList< Point > destinations =new ArrayList< Point >();
        destinations.add(new Point(2, 0));
        destinations.add(new Point(1, 1));
        destinations.add(new Point(0, 1));
        Grasshopper g =new Grasshopper(destinations);
        Assertions.assertEquals("3", g.isAlive(frog));
    }
    @Test
    public void isAliveTest2() {
        Frog frog = new Frog(new Point(0,0),100);
        ArrayList< Point > destinations =new ArrayList< Point >();
        destinations.add(new Point(1, 1));
        destinations.add(new Point(2, 2));
        Grasshopper g =new Grasshopper(destinations);
        Assertions.assertEquals("1", g.isAlive(frog));
    }

    @Test
    public void isAliveTest3() {
        Frog frog = new Frog(new Point(0,0),1);
        ArrayList< Point > destinations =new ArrayList< Point >();
        destinations.add(new Point(1, 1));
        destinations.add(new Point(2, 2));
        destinations.add(new Point(3, 3));
        Grasshopper g =new Grasshopper(destinations);
        Assertions.assertEquals("Yes", g.isAlive(frog));
    }
}
