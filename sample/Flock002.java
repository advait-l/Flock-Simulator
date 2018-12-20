package sample;

import flockbase.Bird;
import flockbase.Flock;
import flockbase.Position;
//import sample.Bird002;
import java.util.*;
import java.lang.*;
import java.io.*;

public class Flock002 extends Flock
{
    public Bird getLeader()
    {
        return leader;
    }

    public void setLeader(Bird b)
    {
        if(leader != null)
            leader.retireLead();
        leader = b;
        leader.becomeLeader();
    }

    public void addBird(Bird b)
    {
        birds.add(b);
        b.setFlock(this);
    }

    public ArrayList<Bird> getBirds()
    {
        return birds;
    }

    public Flock split(int pos)
    {
        Flock002 myBirds = new Flock002();
        Bird bird = birds.get(pos);
        bird.becomeLeader();
        myBirds.setLeader(bird);
        myBirds.addBird(bird);
        bird.setTarget(900,10);
        birds.remove(pos);
        for(int i = 0; i < pos; i++)
            myBirds.addBird(birds.get(0));
        for(int i = 0; i < pos-1; i++)
            birds.remove(0);
        return myBirds;
    }

    public void joinFlock(Flock f)
    { 
        getLeader().retireLead();
        for (Bird bird : getBirds()) 
            f.addBird(bird);
    }


    private ArrayList<Bird> birds = new ArrayList<Bird>();
    Bird leader;

}
