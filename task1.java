public class Main {
    int remainder(int x,int y)
    {
        return  x%y;
    }

//[2]
    int triArea(int b, int h)
    {
        return (b * h) / 2;
    }
//[3]
    int animals(int x,int y,int z)
    {
        int chicken = 2;
        int cows = 4;
        int pigs = 4;
        return x * chicken + y * cows + z * pigs;
    }
//[4]
    boolean profitableGamble(double prob, double prize, double pay)
    {
        if ((prob * prize) > pay) {
            return true;
        } else return false;
    }

//[5]
    String operation(int N, int a, int b)
    {
        if ((a * b) == N) {
            return "óìíîæèòü";
        } else {
            if ((a / b) == N) {
                return "ïîäåëèòü";
            } else {
                if ((a + b) == N) {
                    return "ïðèáàâèòü";
                } else {
                    if ((a - b) == N) {
                        return "âû÷åñòü";
                    } else {
                        return "none";
                    }
                }
            }
        }
    }
 //[6]
    int ctoa(char c)
    {
        return (int) c;
    }

//[7]
    int addUpTo (int x)
    {
        int exit = 0;
        for (int i = 1; i <= x; i++){
            exit += i;
        }
    return exit;
    }
//[8]
    int nextEdge (int x, int y) {
        return x + y - 1;
    }
//[9]
    int sumOfCubes (int[] x) {
        int exit = 0;
        for (int i : x) {
            exit += i * i * i;
        }
    return exit;
    }
//[10]
    boolean abcmath (int a, int b, int c) {
        boolean exit = true;
        for (int i = 0; i < b; i++) {
            a += a;
        }
    return a % c == 0;
    }
}
