import java.io.IOException;
import java.lang.Exception;

public class Degree extends Main {
    public static String degree(String input) throws Exception,IOException{
        String[] numeral = {"1","2","3","4","5","6","7","8","9","10"};

        String[] data = input.split("/");
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
        if (numeralsecond == -1||count > 2)
            throw new NumberFormatException("Нельзя делить строку на строку!");

        int index = Integer.parseInt(data[1]);
        if (index<1||index>10)
            throw new IOException("Множитель меньше 1 или больше 10");

        int index1 = data[0].length()/Integer.parseInt(data[1]);



        String result = data[0].substring(0,index1);

        return '"'+result+'"';

    }
}