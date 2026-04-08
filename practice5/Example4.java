import java.util.*;

public class Example4
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine())
        {
            String line = in.nextLine().trim();
            if (line.isEmpty()) break;

            // Split input line into individual expressions by whitespace
            String[] expressions = line.split("\\s+");

            for (String expr : expressions)
            {
                processExpression(expr);
            }
        }
    }

    private static void processExpression(String expr)
    {
        StringTokenizer tokenizer = new StringTokenizer(expr, "+-*/", true);

        try
        {
            String leftString  = tokenizer.nextToken();
            String operator    = tokenizer.nextToken();
            String rightString = tokenizer.nextToken();

            double leftOperand;
            double rightOperand;

            // Identify which operand is invalid
            try
            {
                leftOperand = Double.parseDouble(leftString);
            }
            catch (NumberFormatException e)
            {
                System.out.println("Left operand \"" + leftString + "\" is not a number");
                return;
            }

            try
            {
                rightOperand = Double.parseDouble(rightString);
            }
            catch (NumberFormatException e)
            {
                System.out.println("Right operand \"" + rightString + "\" is not a number");
                return;
            }

            double result;

            switch (operator)
            {
                case "+": result = leftOperand + rightOperand; break;
                case "-": result = leftOperand - rightOperand; break;
                case "*": result = leftOperand * rightOperand; break;
                case "/":
                    if (rightOperand == 0)
                    {
                        System.out.println("Error: division by zero in \"" + expr + "\"");
                        return;
                    }
                    result = leftOperand / rightOperand;
                    break;
                default:
                    System.out.println("Unknown operator: " + operator);
                    return;
            }

            System.out.println("Result: " + result);
        }
        catch (NoSuchElementException nsee)
        {
            System.out.println("Invalid syntax: \"" + expr + "\"");
        }
    }
}
