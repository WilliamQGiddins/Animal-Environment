import java.util.Random;
public class Environment {
    public static void main(String[] args) {
        int size=900;
        char [] [] Grid = new char[30] [30];
        Inhabitants [] Environment= new Inhabitants[size];
        int j;
        int k=30;
        Random rand = new Random();
        for(int i=0; i<size;i++){                // creates environment
            j=rand.nextInt(6 - 0) + 0;
            if(j<=2)
                Environment[i]= new Plants();
            else if(j>2 && j<=4)
                Environment[i]= new Herbivore();
            else if (j==5)
                Environment[i]= new Carnivore();
            else
                Environment[i]= null;
            }
        Inhabitants.census(Environment, size);//checks for over lapping
        Inhabitants.printGrid(Environment,Grid,size); // prints initial grid
        while (k>0) {
            for (j = 0; j < size; j++) {
                if (Environment[j] != null)
                    Environment[j].move();
            }
            Inhabitants.randomPlants(Environment,size);
            Inhabitants.census(Environment, size);//checks for over lapping
            Inhabitants.populationGrowth(Environment,size);
            k--;
        }
        System.out.println();
        Inhabitants.printGrid(Environment,Grid,size);       //prints final grid


}

}
