import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input expression: ");
        String input = scanner.nextLine();

        String result = calc(input);
        System.out.println(result);
    }
    public static String calc(String input)
    {
        input = input.replace(" ","") .trim();
        String[] digits = input.split("[+--*/]");
        if (digits.length > 2 )
        {
            throw new ArithmeticException("the format of the mathematical operation does not satisfy the task");
        }
        if (digits.length == 1 || digits.length == 0)
        {
            throw new ArithmeticException("a string is not a mathematical operation");
        }

        int[] dig = new int[digits.length];

        Scanner scan = new Scanner(input);
        String sign = scan.findInLine("\\W");

        if (digits[0].matches("[0-9]*") && digits[1].matches("[0-9]*"))
        {
            dig[0] = Integer.parseInt(digits[0]);
            dig[1] = Integer.parseInt(digits[1]);

            if (dig[0] <= 10 && dig[1] <= 10 && dig[0] > 0 && dig[1] > 0)
            {
                int result = switch (sign)
                {
                    case "+" -> dig[0] + dig[1];
                    case "-" -> dig[0] - dig[1];
                    case "*" -> dig[0] * dig[1];
                    case "/" -> dig[0] / dig[1];
                    default -> 0;
                };
                return "result: " + result;
            }
            else throw new ArithmeticException("the values must be between 1 and 10 inclusive");
        }
        else if (digits[0].matches("[IVX]*") && digits[1].matches("[IVX]*"))
        {
            dig[0] = RomanToArabic.convert(digits[0]);
            dig[1] = RomanToArabic.convert(digits[1]);

            if (dig[0] <= 10 && dig[1] <= 10)
            {
                int result = switch (sign)
                {
                    case "+" -> dig[0] + dig[1];
                    case "-" -> dig[0] - dig[1];
                    case "*" -> dig[0] * dig[1];
                    case "/" -> dig[0] / dig[1];
                    default -> 0;
                };
                if (result >= 1)
                {
                    return "result: " + ArabicToRoman.convert(result);
                }
                else throw new ArithmeticException("the result is less than or equal to Zero");
            }
            else throw new ArithmeticException("the values must be between I and X inclusive");
        }
        else if (digits[0].matches("[0-9]*") && digits[1].matches("[IVX]*") || digits[0].matches("[IVX]*") && digits[1].matches("[0-9]*"))
        {
            throw new ArithmeticException("the values must be of the same format");
        }
        else
        {
            throw new ArithmeticException("the values must be of the same format and between 1(I) and 10(X) inclusive");
        }
    }
}
