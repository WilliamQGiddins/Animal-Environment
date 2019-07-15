import java.util.Random;
public abstract class Animals extends Inhabitants {

    protected int energy;

    public Animals (){              //initializes animal with random energy and age
        Random rand = new Random();
        age=rand.nextInt(15 - 0) + 0;
        energy=rand.nextInt(100 - 0);

    }


}

