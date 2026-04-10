import java.util.*;

public class Example4
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine())
        {
            String line = in.nextLine().trim();
            if (line.isEmpty())
                continue;

            StringTokenizer expressions = new StringTokenizer(line, " ", false);

            while (expressions.hasMoreTokens())
            {
                String expression = expressions.nextToken();
                processExpression(expression);
            }
        }
    }

    private static void processExpression(String expression)
    {
        double         leftOperand, rightOperand, result;
        String         leftString, operator, rightString;
        StringTokenizer tokenizer;

        tokenizer = new StringTokenizer(expression, "+-*/", true);

        try
        {
            leftString  = tokenizer.nextToken();
            operator    = tokenizer.nextToken();
            rightString = tokenizer.nextToken();

            try
            {
                leftOperand = Double.parseDouble(leftString);
            }
            catch (NumberFormatException nfe)
            {
                System.out.println("Left operand '" + leftString + "' is not a number");
                return;
            }

            try
            {
                rightOperand = Double.parseDouble(rightString);
            }
            catch (NumberFormatException nfe)
            {
                System.out.println("Right operand '" + rightString + "' is not a number");
                return;
            }

            if (operator.equals("+"))
                result = leftOperand + rightOperand;
            else if (operator.equals("-"))
                result = leftOperand - rightOperand;
            else if (operator.equals("*"))
                result = leftOperand * rightOperand;
            else if (operator.equals("/"))
            {
                if (rightOperand == 0.0)
                {
                    System.out.println("Division by zero");
                    return;
                }
                result = leftOperand / rightOperand;
            }
            else
            {
                System.out.println("Unknown operator: " + operator);
                return;
            }

            System.out.println("Result: " + result);
        }
        catch (NoSuchElementException nsee)
        {
            System.out.println("Invalid syntax: " + expression);
        }
    }
}
