import java.io.IOException;

public class Multyplication extends Main{
    public static String multyply(String input) throws IOException {
        String[] numeral = {"1","2","3","4","5","6","7","8","9","10"};


        String[] data = input.split("\\*");
        int count = data[1].length();
        int numeralsecond = -1;
        for (int i = 0; i < numeral.length; i++)
        {
            if (data[1].equals(numeral[i]))
            {
                numeralsecond = i;
                break;
            }
        }
        if (numeralsecond == -1||count >2 )
            throw new NumberFormatException("Нельзя умножать строку на строку!");

        int index = Integer.parseInt(data[1]);
        if (index<1||index>10)
            throw new IOException("Множитель меньше 1 или больше 10");

        String result = data[0].repeat(index);
        int biglength = result.length();


        if(biglength<40) {
            result = '"'+result+'"';
        }
        else {
            String result1 = result.substring(0,40);
            result = '"' + result1 + "..." + '"';
        }
        return result;

    }
}
