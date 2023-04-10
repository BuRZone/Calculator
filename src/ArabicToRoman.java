public class ArabicToRoman
{
    private static int[] arabic = {100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static String[] roman = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    public static String convert(int arabicNumber)
    {
        StringBuilder romanNumerals = new StringBuilder();
        int remainder = arabicNumber;

        for (int i = 0; i < arabic.length; i++)
        {
            while (remainder >= arabic[i])
            {
                romanNumerals.append(roman[i]);
                remainder -= arabic[i];
            }
        }
        return romanNumerals.toString();
    }
}
