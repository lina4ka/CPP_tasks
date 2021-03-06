import java.util.Arrays;

public class Main {
 //[21]
    public static int solutions (int a, int b, int c) {
        int D = b * b - 4 * a * c;
        return  D < 0 ? 0 : (D > 0 ? 2 : 1);
    }

//[22]
    public static int FindZip (String a) {
        return !a.contains("zip") ? -1 : a.indexOf("zip", a.indexOf("zip") + 1);
    }

//[23]
    public static boolean checkPerfect (int a) {
        int x = a == 0 ? -1 : 0;
        for (int i = 1; i < a; i++) {
            x += (a % i) == 0 ? i : 0;
        }
        return x == a;
    }

//[24]
    public static String flipEndChars (String a) {
        return (a.length() <= 2) ? "Несовместимо. " : (a.charAt(0) == a.charAt(a.length() -1)) ? "Два - это пара. " : a.charAt(a.length() -1) + a.substring(1, a.length() -1) + a.charAt(0);
    }


//[25]
    public static boolean isValidHexCode (String a) {
        boolean code = true;
        //Проверка что бы начаналось с #
        if ((a.charAt(0) != '#') || (a.length() != 7)) {
            code = false;
        }
        for (int i = 1; i < a.length(); i++) {
            if (!(Character.isDigit(a.charAt(i)))) {
                // Проверка чтобы были буквы от A до F (и строчные)
                if ((Character.toUpperCase(a.charAt(i)) < 65) || (Character.toUpperCase(a.charAt(i))) > 70) {
                    code = false;
                }
            }
        }
        return code;
    }

//[26]
    public static boolean same (int[] array1, int[] array2) {
        int exit = 0;
        //Сортировка для 1 массива
        Arrays.sort(array1);
        //Сортировка для 2 массива
        Arrays.sort(array2);
        int max = (array1.length -1 > array2.length) ? array1.length -1 : array2.length -1;
        for (int i = 0; i < max; i++) {
            if (i < array1.length -1) {
                if (Arrays.binarySearch(array1, i + 1, array1.length -1, array1[i]) < 0) {
                    exit++;
                }
            }
            if (i < array2.length -1) {
                if (Arrays.binarySearch(array2, i + 1, array2.length -1, array2[i]) < 0) {
                    exit--;
                }
            }
        }
        //
        exit += (array1.length == 1) ? 1 : (array1[array1.length -2] != array1[array1.length -1]) ? 1 : 0;
        exit -= (array2.length == 1) ? 1 : (array2[array2.length -2] != array2[array2.length -1]) ? 1 : 0;
        return exit == 0;
}

//[27]
    public static boolean isKaprekar (int a) {
        int d = a * a;
        String a1 = Integer.toString(d).substring(0, Integer.toString(d).length() / 2).length() == 0 ? "0" : Integer.toString(d).substring(0, Integer.toString(d).length() / 2);
        String a2 = Integer.toString(d).substring(Integer.toString(d).length() / 2);
        return Integer.parseInt(a1) + Integer.parseInt(a2) == a;
    }


//[28]
    public class some {
        public static String longestZero (String a) {
            StringBuilder v = new StringBuilder();
            while (a.indexOf(v + "0") != -1) {
                v.append("0");
            }
            return v.toString();
        }
        public static void main (String[] args) {
            System.out.println(longestZero("100100100"));
        }
    }

//[29]
    public static int nextPrime (int a) {
        boolean Prime = true;
        int v = a;
        //проверка на простое число
        for (int i = 2; i < a && Prime; i++){
            Prime = a % i != 0;
        }
        //Расчет следующего числа
        while (!Prime){
            v++;
            Prime = true;
            for (int i = 2; i < v && Prime; i++){
                Prime = v % i != 0;
            }
        }
        return v;
    }


//[30]
    public static boolean rightTriangle (int x, int y, int z) {
        //Находим гипотенузу
        int gip = Math.max(x, Math.max(y, z));
        //И два катета
        int kat1 = (gip != x) ? x : (gip != y) ? y : z;
        int kat2 = x + y + z - gip - kat1;
        // Формула прямоугольного треугольника
        return (kat1 * kat1 + kat2 * kat2 == gip * gip);
    }


}
