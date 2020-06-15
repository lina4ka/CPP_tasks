//[11]
public class Main {

    String repeat (String a, int b) {
        String exit = "";
        for (char Char : a.toCharArray()) {
            exit += Character.toString(Char).repeat(b);
        }
        return exit;
    }

//[12]
    int differenceMaxMin (int[] array) {
        int min = array[0];
        int max = min;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max){
                max = array[i];
            } else {
                if (array[i] < min) {
                    min = array[i];
                }
            }
        }
        return (max - min);
    }


//[13]
    boolean isAvgWhole (int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += i;
        }
        return sum % array.length == 0;
    }
//[14]
    int[] cumulativeSum (int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            array[i] = sum;
        }
        return array;
    }


//[15]
    int getDecimalPlaces (String x) {
        return x.indexOf(".")!=-1 ? x.length()-x.indexOf(".")-1 : 0;
    }


//[16]
    int Fibonacci (int x) {
        int i = (int) ((Math.pow ( (1 + (Math.sqrt(5) ) ) / 2, x + 1) - Math.pow ((1 - (Math.sqrt(5) )) / 2, x + 1)) / (Math.sqrt(5)));
        return i;
    }


//[17]
    boolean isValid (String x) {
        boolean index = x.length() == 5;
        for (int i = 0; i < x.length() && index; i++){
            index = Character.isDigit(x.charAt(i));
        }
        return index;
    }

//[18]
    public static boolean isStrangePair (String x, String y) {
        return ((x.length() == 0) || (y.length()==0)) ? x.equals(y) : (x.charAt(0) == y.charAt(y.length() - 1)) && (y.charAt(0) == x.charAt(x.length() - 1));
    }

//[19]
    boolean isPrefix (String x, String y) {
        return x.indexOf (y.substring (0, y.length() - 1)) == 0;
    }
    boolean isSuffix (String x, String y) {
        return x.lastIndexOf (y.substring(1)) + y.substring(1).length() == x.length();
    }

//[20]
    int boxSeq (int s) {
        return  s % 2 == 0 ? s : s + 2;
    }
}
