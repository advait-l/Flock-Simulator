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
            return "L";
        return "002";
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
        
        double dx = 0.0;
        double dy = 0.0;
        int xt = this.getTarget().getX();
        int yt = this.getTarget().getY(); 
        double distance = Math.sqrt(Math.pow((xt-x),2) + Math.pow((yt-y),2));
        if(distance < 10.0)
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
            double mx = (double)(yt - y) / (xt - x);
            double my = (double)(xt - x) / (yt - y);
            if(xt > x)
                dx = 1.0;
            else
                dx = -1.0;

            if(mx >= 5 || mx <= -5)
            {
                dy *= this.getSpeed();
                dx = my * dy;
            }
            else
            {
                dx *= this.getSpeed();
                dy = mx * dx;
            }


        }


        

        int Dx = x + (int)dx;
        int Dy = y + (int)dy;
        Flock flock = this.getFlock();
        ArrayList<flockbase.Bird> birds = flock.getBirds();
        for(Bird b : birds)
        {
            //if(b != this)
           // {
                int xtemp = b.getPos().getX();
                int ytemp = b.getPos().getY();
                if(xtemp - Dx > -5.0 && xtemp - Dx < 5.0)
                {
                    if(ytemp - Dy > -5.0 && ytemp - Dy < 5.0)
                    {
                        if(this.isLeader())
                            b.setPos(xtemp + 20, ytemp + 20);
                        else
                        {
                            dx = 0; dy = 0;
                        }
                    }
                }
            //}           
        }

        this.setPos(x + (int)dx, y + (int)dy);   
    }


    private double speed = 9.0;
    private boolean isLeader;





}
