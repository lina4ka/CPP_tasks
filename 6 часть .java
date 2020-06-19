import java.util.Arrays;

public class Sixth {
    public static int bell(int arrayCount)
    {
        int[][] array = new int[arrayCount+2][arrayCount+2];
        for (int i = 0;i<arrayCount;i++)
            for (int j = 0;j<arrayCount;j++)
                array[i][j]=-1;
        array[0][0]=1;
        int currentLast=0;
        for (int i = 1;i<arrayCount;i++)
        {
            array[i][0]=array[i-1][currentLast];
            currentLast=0;
            for (int j = 1;j<arrayCount;j++)
                if (array[i-1][j-1]!=-1)
                {
                    array[i][j] = array[i][j - 1] + array[i - 1][j - 1];
                    currentLast++;
                }
        }
        return array[arrayCount-1][currentLast];
    }
    public static String translateWord(String word)
    {
        String result = "Not word";
        String cWord="";
        boolean isLetter = false;
        if(word.length()!=0) {
            for (char cChar : word.toCharArray())
                if (Character.isLetter(cChar)) {
                    cWord += Character.toLowerCase(cChar);
                    isLetter = true;
                } else
                    cWord += cChar;
            isLetter = Character.isLetter(cWord.charAt(0)) ? isLetter : false;
        }
        if (!word.contains(" ")&&(word.length()>1||isLetter))
        {
            if (cWord.charAt(0)=='a'||cWord.charAt(0)=='e'||cWord.charAt(0)=='o'||cWord.charAt(0)=='i'||cWord.charAt(0)=='u')
                result=word+"yay";
            else
            {
                int vowelPos = 0;
                while (vowelPos<cWord.length()&&cWord.charAt(vowelPos)!='a'&&cWord.charAt(vowelPos)!='e'&&cWord.charAt(vowelPos)!='o'&&cWord.charAt(vowelPos)!='i'&&cWord.charAt(vowelPos)!='u')
                    vowelPos++;
                result = word.substring(vowelPos) + word.substring(0,vowelPos) + "ay";
            }
        }
        return isLetter ? result : word;
    }
    public static String translateSentence(String line) 
    {
        StringBuilder result = new StringBuilder();
        if ((line.charAt(line.length()-1)=='.'&&line.indexOf(".")==line.length()-1)||(line.charAt(line.length()-1)=='!'&&line.indexOf("!")==line.length()-1)||(line.charAt(line.length()-1)=='?'&&line.indexOf("?")==line.length()-1))
        {
            line=line.substring(0,line.length()-1);
            for (String cString : line.split(" "))
            {
                char ch = 0;
                if (cString.length()!=0)
                    if (cString.charAt(cString.length()-1)==',')
                    {
                        cString = cString.substring(0, cString.length() - 1);
                        ch=',';
                    }
                if (!translateWord(cString).equals("Not word"))
                    result.append( ch == 0 ? translateWord(cString)+" " : translateWord(cString)+ch+" ");
            }
            result.replace(0,result.length(), result.substring(0,result.length()-1));
        }
        else
            result.replace(0,result.length(),"Incorrect line");
        return result+".";
    }
    public static boolean validColor(String rgbCode)
    {
        while (rgbCode.indexOf(' ')!=-1)
            rgbCode=rgbCode.substring(0,rgbCode.indexOf(' '))+rgbCode.substring(rgbCode.indexOf(' '));
        boolean isColor=false;
        if ((rgbCode.indexOf('(')==3||rgbCode.indexOf('(')==4)&&rgbCode.indexOf(')')==rgbCode.length()-1)
        {
            String code = rgbCode.substring(0,rgbCode.indexOf('('));
            isColor = code.equals("rgb") ? true : code.equals("rgba");
            rgbCode=rgbCode.substring(rgbCode.indexOf('(')+1,rgbCode.length()-1);
            String[] value =rgbCode.split(",");
            isColor = isColor ? code.length()==value.length : false;
            for (int i = 0; i < value.length&&isColor;i++)
            {
                for (char c : value[i].toCharArray())
                    if (!Character.isDigit(c)&&c!='.') return false;
                try{
                    double cValue = Double.parseDouble(value[i]);
                    if (i!=3)
                        isColor= cValue>=0&&cValue<=255&&(cValue-(int)cValue==0);
                    else
                        isColor= cValue>=0&&cValue<=1;
                }
                catch (Exception e)
                {
                    isColor=false;
                }
            }
        }
        return isColor;
    }
    public static String stripUrlParams(String url, String ... parameters)
    {
        String parametersLine ="";
        if (url.contains("?") &&url.indexOf("?")!=url.length())
        {
            parametersLine = url.substring(url.indexOf("?") + 1) + "&";
            url = url.substring(0, url.indexOf("?"));
        }
        String resultP ="?";
        int i = 0;
        String tempP="";
        while (i<parametersLine.length())
        {
            if (parametersLine.charAt(i)!='&')
                tempP+=parametersLine.charAt(i);
            else if (parametersLine.indexOf(tempP.split("=")[0],i+1)==-1)
            {
                if (parameters.length!=0) {
                    if (!Arrays.asList(parameters).contains(tempP.split("=")[0]))
                        resultP += tempP + "&";
                }
                else
                    resultP += tempP + "&";
                tempP="";
            }
            else
                tempP="";
            i++;
        }
        resultP=resultP.substring(0,resultP.length()-1);
        return url+resultP;
    }

    public static String[] getHashTags(String line)
    {
        StringBuilder cLine= new StringBuilder();
        for (char ch : line.toCharArray())
                if (Character.isLetter(ch))
                    cLine.append(Character.toLowerCase(ch));
                else if (ch==' ')
                    cLine.append(ch);
        int size = cLine.toString().split(" ").length>2 ? 3 : cLine.toString().split(" ").length;
        String[] result = new String[size];
        for (int i = 0;i<size;i++ )
            result[i]="";
        for (String cString : cLine.toString().split(" "))
            for (int i = 0; i<size; i++)
                if(result[i].length()<cString.length())
                {
                    for (int j = size-1; j >= 0; j--)
                    {
                        if (j != i)
                            result[j] = result[j - 1];
                        else {
                            result[j] = cString;
                            break;
                        }
                    }
                    break;
                }
        for (int i = 0;i<size;i++ )
            result[i]="#"+result[i];
        return result;
    }

    public static int ulam(int num)
    {
        int[] ulamList = new int[num>1 ? num : 2];
        ulamList[0]=1;
        ulamList[1]=2;
        for (int i = 2;i<ulamList.length;i++)
            ulamList[i]=-1;
        int curPos = 1;
        String forbiddenValue = " ";
        while (curPos<num-1)
        {
            int minSum = Integer.MAX_VALUE;
            int i = 0;
            while (ulamList[i]!=-1)
            {
                int j=i+1;
                while (ulamList[j]!=-1)
                {
                    if (i!=j)
                        if(ulamList[i]+ulamList[j]<minSum&&(ulamList[i]+ulamList[j])>ulamList[curPos]&& !forbiddenValue.contains(" " + String.valueOf(ulamList[i]+ulamList[j]) + " "))
                            /*find minimum sum, that not forbidden*/
                            minSum = ulamList[i] + ulamList[j];
                        else if (minSum==ulamList[i]+ulamList[j]) {
                            if (!forbiddenValue.contains(" " + String.valueOf(ulamList[i] + ulamList[j]) + " "))
                                forbiddenValue += minSum + " ";
                            j=0;
                            i=0;
                            minSum = Integer.MAX_VALUE;
                        }
                    j++;

                }
                i++;
            }
            curPos++;
            ulamList[curPos]=minSum;
        }
        return num>0 ? ulamList[num-1] : -1;
    }
    public static String convertToRoman(int value)
    {
        StringBuilder result = new StringBuilder();
        if (value>0&&value<4000)
        {
            String[] array = new String[]{"I", "X", "C", "M", "V", "L", "D"};
            String v = String.valueOf(value);
            int pos = 0;
            for (int j = v.length() - 1; j > -1; j--) {
                int cValue = Integer.parseInt(String.valueOf((char) v.charAt(j)));
               
                if (cValue < 4)
                    result.insert(0, array[pos].repeat(cValue));
                else if (cValue == 4)
                    result.insert(0, array[pos] + array[pos + 4]);
                else if (cValue == 5)
                    result.insert(0, array[pos + 4]);
                else if (cValue == 9)
                    result.insert(0, array[pos] + array[pos + 1]);
                else
                {
                    StringBuilder tr = new StringBuilder();
                    tr.append(array[pos].repeat(cValue - 5));
                    result.insert(0, array[pos + 4] + tr);
                }
                pos++;
            }
        }
        return result.toString();
    }
    public static String mathResult(String v1,String v2,char move)
    {
        int fValue = Integer.parseInt(v1);
        int result=-1;
        if (!v2.equals("")) {
            int sValue = Integer.parseInt(v2);
            switch (move) {
                case '+':
                    result = fValue + sValue;
                    break;
                case '-':
                    result = fValue - sValue;
                    break;
                case '*':
                    result = fValue * sValue;
                    break;
                case '/':
                    result = fValue / sValue;
                    break;
            }
        }
        else
            result=fValue;
        return String.valueOf(result);
    }
    public static boolean formula(String line)
    {
        boolean isCorrect = true;
        while (line.contains(" "))
            line=line.substring(0,line.indexOf(" "))+line.substring(line.indexOf(" ")+1);
        int pValue=0;
        int cValue=0;
        int i =0;
        for (String cPart : line.split("="))
        {
            pValue=cValue;
            if (isCorrect)
            {
                StringBuilder v1 = new StringBuilder();
                StringBuilder v2 = new StringBuilder();
                char move = 0;
                for (char c : cPart.toCharArray())
                {
                    if (Character.isDigit(c))
                    {
                        if (move == 0)
                            v1.append(c);
                        else
                            v2.append(c);
                    }
                    else if (c=='+'||c=='*'||c=='/'||c=='-')
                    {
                        if (move==0)
                            move = c;
                        else
                        {
                            v1.replace(0,v1.length(),mathResult(v1.toString(),v2.toString(),move));
                            v2.delete(0,v2.length());
                            move=c;
                        }
                    }
                    else
                        isCorrect=false;
                }

                v1.replace(0,v1.length(),mathResult(v1.toString(),v2.toString(),move));
                v2.delete(0,v2.length());
                cValue=Integer.parseInt(v1.toString());
            }
            else
                break;
            if (i!=0)
                isCorrect = pValue==cValue;
            else
                i++;
        }
        return isCorrect;
    }
    public static String reverseString(String word)
    {
        StringBuilder result= new StringBuilder();
        for(char c : word.toCharArray())
            result.insert(0, c);
        return result.toString();
    }
    public static boolean palindromedescendant(int value)
    {
        boolean isPalindrome = false;
        String line = String.valueOf(value);
        while (line.length()>1&&!isPalindrome)
        {
            isPalindrome=reverseString(line).equals(line);
            if (!isPalindrome)
            {
                StringBuilder tLine = new StringBuilder();
                for (int i = 0;i<line.length()-1;i=i+2)
                {
                    int v1 = Integer.parseInt(String.valueOf(line.charAt(i)));
                    int v2 = Integer.parseInt(String.valueOf(line.charAt(i+1)));
                    tLine.append((v1 + v2));
                }
                line= tLine.toString();
            }
        }
        return isPalindrome;
    }
    public static String longestNonrepeatingSubstring(String line)
    {
        String cLine="";
        String pLine="";
        cLine+=line.charAt(0);
        for (int i = 1 ; i<line.length();i++)
        {
            if (cLine.indexOf(line.charAt(i))!=-1)
            {
                pLine=pLine.length()<cLine.length()? cLine : pLine;
                if (cLine.indexOf(line.charAt(i))>cLine.length()-1)
                    cLine=cLine.substring(cLine.indexOf(line.charAt(i)+1));
                else
                    cLine="";
            }
            cLine+=line.charAt(i);
        }
        return pLine.length()<cLine.length()? cLine : pLine;
    }