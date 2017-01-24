import greenfoot.*;

/**
 * Facit Formler
 * 
 * @author Rikard Karlsson 
 * @version 2017-01-24
 */
public class Formler extends Actor
{
    public void printNumber()
    {
        //13, 10, 7, 4
        String text = "";
        int number = 13;
        while(number >=4 )
        {
            text = text + number + ", ";
            number = number - 3;
        }
        getWorld().showText(text, 300, 50);
    }
    //0, 5, 10, 15, 20, 25, 30, ...
    public void number(int n)
    {
        String text = "";
        int number = 0;
        while( number < n * 5)
        {
            text = text + number + ", ";
            number = number + 5;
        }
        getWorld().showText(text, 300, 150);
        
    }
    //1/1 + 1/2 + 1/3 + ... + 1/n
    public double invertedForSum(int n)
    {
       double sum = 0;
       int i = 1;
       while(i <= n)
       {
           sum = sum + 1.0 / i;
           i = i + 1;
       }
       return sum;
    }
} 

