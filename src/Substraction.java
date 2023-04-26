public class Substraction extends Main{
    public static String substraction(String input) {

        String[] data = input.split("-");
        String result = data[0];
        String result1 =new String();
        int index = result.indexOf(data[1]);

        return switch (index) {
            case -1 -> {
                yield '"'+result+'"';
            }
            default -> {
                result1 = result.substring(0, index);
                result1 += result.substring(index + data[1].length());
                yield '"'+result1+'"';
            }
        };

    }
}
