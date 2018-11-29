package sample;

import flockbase.Bird;
import flockbase.Flock;
import flockbase.Position;
import java.util.*;
import java.lang.*;
import java.io.*;

public class BirdX extends Bird
{   
    public BirdX()
    {

    }

    public double getSpeed()
    { 
        return speed;
    }

    public void setSpeed(double spd)
    {
        speed = spd;
    }
    
    public boolean isLeader()
    {
        return isLeader;
    }

    public String getName()
    {
        if(isLeader)
            return "IMT2017002(Leader)";
        return "IMT2017002";
    }

    public void becomeLeader()
    {
        this.isLeader = true;
    }

    public void retireLead()
    {
        this.isLeader = false;
    }

    protected void updatePos()
    {
        Position currentPosition = this.getPos();
        int x = currentPosition.getX();
        int y = currentPosition.getY();
        if(!this.isLeader)
        {
            Position leaderPosition = this.getFlock().getLeader().getPos();
            setTarget(leaderPosition.getX(), leaderPosition.getY());
        }
        
        double dx;
        double dy;
        int xt = this.getTarget().getX();
        int yt = this.getTarget().getY();        
        if(xt == x && yt == y)
        {
            dx = 0.0;
            dy = 0.0;
        }
        else if(xt == x)
        {
            if(yt > y)
                dy = 1.0;
            else
                dy = -1.0;
            dx = 0.0;
        }
        else if(yt == y)
        {
            if(xt > x)
                dx = 1.0;
            else
                dx = -1.0;
            dy = 0.0;
        }
        else
        {
            double m = (double)(yt - y) / (xt - x);
            if(xt > x)
                dx = 1.0;
            else
                dx = -1.0;

            dx *= this.getSpeed();
            dy = m * (dx);
        }

        int Dx = x + (int)dx;
        int Dy = y + (int)dy;
        Flock flock = this.getFlock();
        ArrayList<flockbase.Bird> birds = flock.getBirds();
        for(Bird b : birds)
        {
            if(b != this)
            {
                int xtemp = b.getPos().getX();
                int ytemp = b.getPos().getY();
                if(xtemp - Dx > -5.0 && xtemp - Dx < 5.0)
                {
                    if(ytemp - Dy > -5.0 && ytemp - Dy < 5.0)
                    {
                        if(this.isLeader())
                            b.setPos(xtemp + 10, ytemp + 10);
                        else
                        {
                            dx = 0; dy = 0;
                        }
                    }
                }
            }           
        }

        this.setPos(x + (int)dx, y + (int)dy);   
    }


    private double speed = 10.0;
    private boolean isLeader;





}
