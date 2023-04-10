import java.util.Arrays;
public class RomanToArabic
{
    public static String[] roman = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    public static int convert(String romanNumerals)
    {
        if (Arrays.asList(roman).contains(romanNumerals))
        {
            return Arrays.asList(roman).indexOf(romanNumerals);
        }
        else throw new ArithmeticException("the values must be less than or equal to X");
    }
}
