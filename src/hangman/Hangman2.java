/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

/**
 *
 * @author hp
 */
import java.util.*;
import java.io.Console;
public class Hangman2 
{
    static String player1="";
    static char player2[];
    static String guessed="";
    static String nwstr="";
    static String poswrd="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String w;
    static int len;
    static int validity(String k)
    {
        if(k.length()==1)
        {
           char ch=k.charAt(0);
           if((ch>=65&&ch<=90)||(ch>=97&&ch<=122))
               return 1;
        }
        return 0;
    }
    static int guess(String k)
    {
      char ch=k.charAt(0);
      if(guessed.length()==0)
          return 1;
      else
      {
      for(int i=0;i<guessed.length();i++)
      {
          char ch2=guessed.charAt(i);
          if(ch==ch2)
           return 0;   
      }
      }
      return 1;
    }
    static int checked(String k)
    {
      String posguess="";
      int crct=0,i,p=0,j;
      char ch=k.charAt(0);
       if((int)ch>=97&&(int)ch<=122)
            poswrd=poswrd.toLowerCase();
          else if((int)ch>=65&&(int)ch<=90)
            poswrd=poswrd.toUpperCase();
      for(i=0;i<player1.length();i++)
      {
          char ch2=player1.charAt(i);
          if(ch==ch2)
          {
           player2[i]=ch2;
           crct=1;
      for(j=0;j<poswrd.length();j++)
      {
          char ch3=poswrd.charAt(j);
          if(ch==ch3)
              continue;
          else
              posguess=posguess+ch3;
      }
        poswrd=posguess.toUpperCase();
          }
      }
      return crct;
      }
    public static void main(String[] args) {
     int chances=0,i;
     Scanner scan=new Scanner(System.in);
     System.out.println("Player1");
     System.out.println("Enter the word ::");
     player1=scan.next(); 
     len=player1.length();
     player2=new char[len];
     for(i=0;i<player2.length;i++)
         player2[i]='-';
     chances=len;
     System.out.println("Player2");
     System.out.println("You have "+chances+" chances to guess the word.\nWith every wrong guess,you will lose 1 chance.");
     do
     {
     System.out.println("Chances Remaining ::"+chances);
     System.out.println("Possible Guesses ::"+poswrd);
     System.out.print("WORD :: ");
     for(i=0;i<player2.length-1;i++)
         System.out.print(player2[i]);
         System.out.println(player2[i]);
     nwstr=Arrays.toString(player2);
     nwstr=nwstr.substring(1,nwstr.length()-1).replace(",","").replace(" ","");
     if(nwstr.equals(player1))
     break;
     System.out.println("Enter the letter to guess the word");
     w=scan.next();
     if(validity(w)==0)
     System.out.println("The guessed letter should be a single character."
             + "The game supports enteries in both lowercase and uppercase");
     else if(guess(w)==0)
     System.out.println("letter id already guessed");
     else if((validity(w)==1)&&(guess(w)==1)){
     if(checked(w)==0)   //for wrong answer
     { chances--;
         System.out.println("Wrong answer");
     }
     }
     if(validity(w)==1)
         guessed=guessed+w;
     }while(chances>0); 
     if(nwstr.equals(player1))
         System.out.println("Congratulations!!!\nYou won the match");
     else
     {
         System.out.println("You lose the match.");
         System.out.println("WORD :: "+player1);
     }
}
}
