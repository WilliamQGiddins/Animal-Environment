import java.util.Random;
public class Herbivore extends Animals {
    public Herbivore(){
        label='H';
    }

    public boolean canMate(){           //returns true if Herbivore reproduce
        if(age<=15 && energy>=70)
            return true;
        else
            return false;
    }

    public boolean isDead(){                //returns true if Herbivore had died
        if (age>=36)
            return true;
        else
            return false;
    }




    public void move(){                 // randomly moves Herbivore
        Random rand = new Random();
        if(locationX>=1 && locationX<=29)
            locationX+=rand.nextInt(1 +1 + 1) - 1;
        if(locationY>=1 && locationY<=29)
            locationY+=rand.nextInt(1 + 1 +1) - 1;
        if(locationX==0)
            locationX+=2;
        if(locationX==30)
            locationX-=2;
        if (locationY==0)
            locationY+=1;
        if (locationY==30)
            locationY-=1;
        energy-=20;
        age++;
    };             
}
