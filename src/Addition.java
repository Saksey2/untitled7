
    public class Addition extends Main{
        public static String addition(String input) {


            String[] result = input.split("\\+");

            return '"'+ result[0]+result[1]+'"';

        }
    }

