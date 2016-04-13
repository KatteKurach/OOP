import java.io.*;
import java.lang.*;
import java.util.*;

class Mouse_Jerry
{
    private int age;
    private int x;
    private int y;

    private int speed;

    public void setSpeed(int value)
    {
        speed = value;
    }

    public int getSpeed()
    {
        return speed;
    }

    public void setAge(int value)
    {
        age = value;
    }

    public int getAge()
    {
        return speed;
    }
    public void setX(int value)
    {
        x = value;
    }

    public int getX()
    {
        return x;
    }

    public void setY(int value)
    {
        y = value;
    }

    public int getY()
    {
        return y;
    }

    public Mouse_Jerry(int x, int y)
    {
        setX(x);
        setY(y);
        System.out.println("Jerry is ready to start eat a cheeese ;)");
    }

    protected void finalize()
    {
        System.out.println("Object mouse is deleted");
    }

    public void  Move(int x1, int y1)
    {
        if(x1 > x)
        {
            while (x < x1 )
            {
                x += getSpeed();
            }
        
        }else
        {
            while (x > x1)
            {
                x -= getSpeed();
            }
        }

        if(y1 > y)
        {
            while(y < y1)
            {
                y += getSpeed();
            }
        }else
        {
            while(y > y1)
            {
                y -= getSpeed();
            }
        }
    }

    void Get_age(int age)
    {
        System.out.println("Jerry age: "+ age);
    }

    public void eat_cheese(Cheese_tasty chees)
    {
        if( x == chees.getX() && y == chees.getY())
        {
            chees.setEaten(true);
            System.out.println("Jerry is so happy, he eats a yammy cheese\n");
        }else
        {
            System.out.println("Jerry can't find a cheese :( \n");
        }
    }

}



class Cat_Tom
{
    private int x;
    private int y;

    public void setX(int value)
    {
        x = value;
    }

    public int getX()
    {
        return x;
    }
    public void setY(int value)
    {
        y = value;
    }

    public int getY()
    {
        return y;
    }

    public Cat_Tom(int x, int y)
    {
        setX(x);
        setY(y);
        System.out.println("Tom is ready to run for a mouse");
    }

    protected void finalize()
    {
        System.out.println("Object Tom is deleted");
    }
    
    public void signal(Mouse_Jerry jer)
    {
        int distance = dist(getX(), getY(), jer.getX(), jer.getY());

        if( distance <= 10 )
        {
            System.out.println("Tom see Jerry, start run\n");
        }else
        {
            System.out.println("Tom doesn't see Jerry\n");
        }
    }

    public int dist(int x1, int y1, int x2, int y2)
    {
        return (int)Math.sqrt((double)((x1 - x2) * (x1 - x2)  + (y1 - y2) * (y1 - y2))); 
    }

}


class Cheese_tasty
{
    private boolean eaten;
    private int x, y;

    public void setEaten(boolean value)
    {
        eaten = value;
    }

    public boolean getEaten()
    {
        return eaten;
    }

    public void setX(int value)
    {
        x = value;
    }

    public int getX()
    {
        return x;
    }

    public void setY(int value)
    {
        y = value;
    }

    public int getY()
    {
        return y;
    }

    public Cheese_tasty(int x,int  y)
    {
        setX(x);
        setY(y);
        System.out.println("Don't eat me");
    }

    protected void finalize()
    {
        System.out.println("Object cheese is deleted");
    }

}


class Little_cheese extends Cheese_tasty
{
    private int score;

    public Little_cheese(int x, int y)
    {
        super(x, y);
        setScore(25);
    }

    public void setScore(int value)
    {
        score = value;
    }

    public int getScore()
    {
        return score;
    }
}


class Big_cheese extends Cheese_tasty
{
    private int score;

    public Big_cheese(int x, int y)
    {
        super(x, y);
        setScore(100);
    }

    public void setScore(int value)
    {
        score = value;
    }

    public int getScore()
    {
        return score;
    }
}


class Program
{
    public static void main(String[] args) throws IOException
    {   
        Scanner sc = new Scanner(System.in);
 
        int x, y;

        System.out.println("Please, write a position of Tom, Jerry\n");
        System.out.println("Tom x, y: ");
        x = sc.nextInt();
        y = sc.nextInt();
        Cat_Tom kitten = new Cat_Tom(x, y);

        System.out.println("Jerry x, y: ");
        x = sc.nextInt();
        y = sc.nextInt();
        Mouse_Jerry mim = new Mouse_Jerry(x, y);
        mim.Get_age(4);

        kitten.signal(mim);

        System.out.println("Cheese location: ");
        x = sc.nextInt();
        y = sc.nextInt();
        Cheese_tasty cheese = new Cheese_tasty(x, y);

        mim.eat_cheese(cheese);

        mim = null;
        cheese = null;
        kitten = null;
        
        System.gc();
        for(int i = 0; i < 1000000; i++)
        {
            i++;
        }
    }
}
