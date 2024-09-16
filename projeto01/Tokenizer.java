// Nome: Alexandre Luppi Severo e Silva  RA: 10419724
//
//

/* Referencias
  bibliotecas List e ArrayList: https://www.devmedia.com.br/java-collections-set-list-e-iterator/29637;

*/

import java.util.ArrayList;
import java.util.List;

public class Tokenizer
  {
    private char[] userInput;
    private int index;
    
    public Tokenizer(String userInput)
    {
      this.userInput = userInput.toCharArray();
      index = 0;
    }

    private char getNextChar()
    {
      if (index >= userInput.length)
      {
        return '\0';
      }
      else
      {
        return userInput[index++];
      }
    }

    public List<String> tokenize()
    {
      List<String> tokens = new ArrayList<String>();
      StringBuilder sb = new StringBuilder();
      char currChar = getNextChar();

      boolean isTokenizing = true;
      while (isTokenizing)
        {
          while (Character.isWhitespace(currChar))
            {
              currChar = getNextChar();
            }

          if (Character.isDigit(currChar))
          {
            sb.setLength(0);
            while (Character.isDigit(currChar))
              {
                sb.append(currChar);
                currChar = getNextChar();
              }
          }
          else if (currChar == '+')
          {
            tokens.add("+");
            currChar = getNextChar();
          }
          else if (currChar == '-')
          {
            tokens.add("-");
            currChar = getNextChar();
          }
          else if (currChar == '*')
          {
            tokens.add("*");
            currChar = getNextChar();
          }
          else if (currChar == '/')
          {
            tokens.add("/");
            currChar = getNextChar();
          }
          else if (currChar == '\0')
          {
            System.out.println("Tokenizing complete.");
            isTokenizing = false;
          }
          else
          {
            System.out.println("Invalid character: " + currChar);
            isTokenizing = false;
          }
        }
      System.out.println("String lida!");
      return tokens;
    }
  }
