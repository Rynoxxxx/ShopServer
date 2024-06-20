import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
   A simple class to read from the keyboard. Methods for reading an 
   integer, a double and line are provided. Each method reads the 
   entire line: this is the "one-input-per-line" input model. This is 
   easiest for beginners. If the input stream is read as lines (strings)
   then the end of input can also be detected so input redirection can
   be used to read a line at a time from a file.
   @author Barry G. Adams
   @version 1.1 July 2000
*/
public class KeyboardReader
{
   private BufferedReader in; 
   private boolean endState; // true at end of stream

   /**
      Construct a KeyboardReader object.
   */
   public KeyboardReader()
   {
      in = new BufferedReader(new InputStreamReader(System.in));
      endState = false;
   }

   /**
      Test for end of input on terminal or file (if input is redirected).
      @return true if end of input else false
   */
   public boolean endOfInput()
   {
      // If we are at end of stream we need to reset endState
      // before returning true;
      if (endState)
      {
         endState = false;
         return true;
      }
      return false;
   }  

   /** 
      Read a line containing only an integer.
      Invalid input results in program termination with an error message.
      @return the integer read
   */
   public int readInt()
   {
      String s = null;
      int i = 0;
      try 
      {
         s = readLine();
         if (s != null) 
            i = Integer.parseInt(s.trim());
      }  
      catch (NumberFormatException e)
      { 
         throw new NumberFormatException(s + " is an invalid integer");
      }
      return i;
   }

   /** 
      Read a line containing only a long integer.
      Invalid input results in program termination with an error message.
      @return the long integer read
   */
   public long readLong()
   {
      String s = null;
      long i = 0;
      try 
      {
         s = readLine();
         if (s != null) 
            i = Long.parseLong(s.trim());
      }  
      catch (NumberFormatException e)
      {
         throw new NumberFormatException(s + " is an invalid long integer");
      }
      return i;
   }

   /** 
      Read a line containing only a double.
      Invalid input results in program termination with an error message.
      @return the double number read
   */
   public double readDouble()
   {
      String s = null;
      double d = 0;
      try 
      {
         s = readLine();
         if (s != null)
            d = Double.parseDouble(s.trim());
      }  
      catch (NumberFormatException e)
      { 
         throw new NumberFormatException(s + " is an invalid double");
      }
      return d;
   }

   /** 
      Read a line as a string. 
      The end of line character is read but not stored in the string.
      @return the string read or null if end of input.

   */
   public String readLine()
   {
      String s = null;
      try
      {
         s = in.readLine(); // will return null at end of stream
         if (s == null) endState = true;
      }
      catch (IOException e)
      {
         System.out.println("ERROR:  cannot read a line");
         System.exit(1);
      }
      return s;
   }
}
