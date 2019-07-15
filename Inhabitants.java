import java.util.Random;

public abstract class Inhabitants {
    protected int locationX;
    protected int locationY;
    protected int age;
    protected char label;

    public Inhabitants(){   //Initializes objects with a location on the grid
        Random rand = new Random();
        locationX=rand.nextInt(30 - 0) + 0;
        locationY=rand.nextInt(30 - 0) + 0;
    }

    public abstract void move();

    public abstract boolean isDead();

    private char getLabel(){  //returns label of object for grid
        return label;
    }

    public abstract boolean canMate();


    public static void census(Inhabitants [] A,int size){ // updates population based off of moves
        for (int i=0;i<size;i++){
            for(int j=i+1;j<size;j++){
                if(A[i]!=null && A[j]!=null){
                if(A[i].locationX==A[j].locationX && A[i].locationY==A[j].locationY)
                    interaction(A[i],A[j]);}
            }

    }}

    private static void interaction(Inhabitants A,Inhabitants B){ //updates inhabitants based on their overlapping
        if(A.getLabel()=='P' && B.getLabel()!='P'){
            A=null; return;}
        else if (B.getLabel()=='P' && A.getLabel()!='P'){
            B=null; return;}
        else if(B.getLabel()=='P' && A.getLabel()=='P'){
            B=null;return;}

        if(A.getLabel()=='H' && B.getLabel()=='H')
            B=null;
        else if (A.getLabel()=='H' && B.getLabel() =='C')
            A=null;
        else if (A.getLabel()=='C' && B.getLabel() =='H')
            B=null;
        else
            A=null;
    }

    public static void populationGrowth(Inhabitants [] A, int size){ //checks if animals can reproduce or have died and
        Random rand= new Random();                                     //updates grid
        int n_H =0,n_C=0,k=0;
            checkDeaths(A,size);
        for(int i=0;i<size;i++){
            if(A[i]!=null && A[i].getLabel()!='P'){
                if(A[i].canMate()){
                    if(A[i].getLabel()=='C')
                        n_C++;
                    else
                        n_H++;
                    }
                }
            }

             while(n_C!=0){
                 k=rand.nextInt(450 - 0) + 0;
                if(A[k]==null)
                 A[k]= new Carnivore();
                else
                    k++;
                n_C--;
            }


             while(n_H!=0){
                 k=rand.nextInt(450 - 0) + 0;
             if(A[k]==null)
                A[k]= new Herbivore();
                else
                    k++;
              n_H--;
        }
    }

    private static void checkDeaths(Inhabitants [] A, int size){ //checks if animals have died
        for(int i=0; i<size; i++){
            if(A[i]!=null){
            if(A[i].isDead())
            A[i]=null;
            }}
    }

    public static void printGrid(Inhabitants [] A, char [][] B, int size){ //prints grid
        for (int i=0;i<size;i++){
            if(A[i]!=null)
                B [A[i].locationX] [A[i].locationY]= A[i].getLabel();
            }
        for (int j=0;j<30;j++){
            for(int k=0;k<30;k++){
                if(B[k][j]==0)
                    System.out.printf("%c ", '_');
                else
                System.out.printf("%c ", B[k][j]);
            }
                System.out.println();
        }


    }

    public static void randomPlants(Inhabitants[] A,int size){  // adds a random number of plants to grid
        Random rand= new Random();
        int k=rand.nextInt(6-0)+0;
        int j;
        while(k!=0){
            j=rand.nextInt(450 -0 )+0;
            if(A[j]==null)
                A[j]=new Plants();
            else
                j++;
            k--;
        }

    }
}
