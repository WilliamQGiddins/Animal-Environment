import java.util.Random;
public class Carnivore extends Animals {
    public Carnivore(){
        label='C';
    }


    public boolean canMate(){           //returns true if Carnivore can reproduce
        if(age<=15 && energy>=80)
            return true;
        else
            return false;
    }

    public boolean isDead(){        //returns true if Carnivore had died
        if (age>=30)
            return true;
        else
            return false;
    }


    public void move(){                     //randomly moves carnivore
        Random rand = new Random();
        if(locationX>=1 && locationX<=29)
        locationX+=rand.nextInt(1 + 1 + 1) - 1;
        if(locationY>=1 && locationY<=29)
            locationY+=rand.nextInt(1 + 1+ 1) - 1;
        if(locationX==0)
            locationX+=4;
        if(locationX==30)
            locationX-=4;
        if (locationY==0)
            locationY+=3;
        if (locationY==30)
            locationY-=3;
        energy-=15;
        age++;
    };
}
