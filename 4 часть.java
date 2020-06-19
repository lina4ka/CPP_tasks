public class Fourth {
    public static String textChanger(int numWord, int symbolsInLine, String text)
    {
        StringBuilder resultText = new StringBuilder();
        boolean error = true;
        int count = 0;
        while (text.indexOf(" ")==0)
            text=text.substring(1);
        while (text.indexOf("  ")!=-1)
            text=text.substring(0,text.indexOf("  "))+text.substring(text.indexOf("  ")+1);
        while (text.indexOf(9)!=-1)
            text=text.substring(0,text.indexOf(9))+text.substring(text.indexOf(9)+1);
        String[] esseText = text.split(" ");
        if (esseText.length == numWord)
            for (String cWord:esseText)
                if (cWord.length()>symbolsInLine)
                {
                    error = false;
                    break;
                }
                else
                if (count+cWord.length()<=symbolsInLine)
                {
                    count+=cWord.length();
                    resultText.append(cWord).append(" ");
                }
                else
                {
                    resultText.delete(resultText.length()-1,resultText.length());
                    count=cWord.length();
                    resultText.append("\n").append(cWord).append(" ");
                }
        else
            error = false;
        return error ? (resultText.charAt(resultText.length()-1)==' ' ? resultText.substring(0,resultText.length()-1) : resultText.toString()) : "I cann`t split line";
    }
    public static String split(String line)
    {
        int l = 0;
        String result="\"";
        for (char cChar:line.toCharArray()) {
            if ((cChar == '(') || (cChar == ')')) {
                l += cChar == '(' ? 1 : -1;
                if (l < 0)
                    break;
                result += l == 0 ? cChar + "\" \"" : cChar;
            }
        }
        return l == 0 ? result.substring(0,result.length()-2) : "I can`t split it";
    }
    public static String toCamelCase(String snakeCase)
    {
        String[] massiveOfSnakeCase = snakeCase.split("_");
        StringBuilder result= new StringBuilder(massiveOfSnakeCase[0]);
        for (String cWord:massiveOfSnakeCase)
            if (!result.toString().equals(cWord))
                result.append(Character.toUpperCase(cWord.charAt(0))).append(cWord.substring(1));
        return result.toString();
    }
    public static String toSnakeCase(String camelCase)
    {
        String result="";
        for (char cChar:camelCase.toCharArray()) {
            if ((cChar!= ' ')&&(cChar!= '\t')&&(cChar!= '\n'))
                if (Character.isLetter(cChar))
                    result+=Character.isUpperCase(cChar) ? "_"+Character.toLowerCase(cChar) : cChar;
                else
                    result+=cChar;
        }
        return result;
    }
    public static double overTime(double startTime, double endTime, double hourlyPayed, double factor)
    {
        return  endTime <=17 ? (endTime-startTime)*hourlyPayed : ((17-startTime)*hourlyPayed+(endTime-17)*hourlyPayed*factor);
    }
    public static String BMI(String weight, String height)
    {
        double growth,heft;
        try {
            heft = Double.parseDouble(height.substring(0,height.indexOf(' ')));
        } catch(NumberFormatException e){
            heft = 0;
        }
        try {
            growth = Double.parseDouble(weight.substring(0,weight.indexOf(' ')));
        } catch(NumberFormatException e){
            growth = 0;
        }
        heft= height.contains("inches") ? 0.0254*heft : (height.contains("meters") ? heft : 0);
        growth = weight.contains("pounds") ? 0.453592*growth : (weight.contains("kilos") ? growth : 0);
        double result = heft != 0 ? Math.round(10*growth/(heft*heft)) : 0;
        result=result/10;
        return  result==0 ? "Incorrect line" : (result < 18.5 ? result + " Underweight" : (result > 25 ? result + " Overweight" : result + " Normal weight"));
    }
    public static int bugger(int value)
    {
        int count = 0;
        while(value>=10)
        {
            int rValue = 1;
            for (char cChar:String.valueOf(value).toCharArray())
                rValue*= Integer.parseInt(String.valueOf(cChar));
            value=rValue;
            count++;
        }
        return  count;
    }
    public static String toStarShorthand(String line)
    {
        int count = 1;
        String result = "";
        for (int i = 0; i<line.length()-1;i++)
        {
            if(line.charAt(i)==line.charAt(i+1))
                count++;
            else {
                result += count == 1 ? line.charAt(i) :line.charAt(i) + "*" + count;
                count=1;
            }
        }
        if (line.length()!=0)
            result+=count!=1 ?line.charAt(line.length()-1)+"*"+count : line.charAt(line.length()-1);
        return  result;
    }
    public static boolean doesRhyme(String fWord, String sWord)
    {
        boolean isRhyme = true;
        
        while (!Character.isLetter(fWord.charAt(fWord.length()-1)))
            fWord=fWord.substring(0,fWord.length()-1);
        while (fWord.indexOf(" ")==0)
            fWord=fWord.substring(1);
        while (fWord.indexOf("  ")!=-1)
            fWord=fWord.substring(0,fWord.indexOf("  "))+fWord.substring(fWord.indexOf("  ")+1);
        while (!Character.isLetter(sWord.charAt(sWord.length()-1)))
            sWord=sWord.substring(0,sWord.length()-1);
        while (sWord.indexOf(" ")==0)
            sWord=sWord.substring(1);
        while (sWord.indexOf("  ")!=-1)
            sWord=sWord.substring(0,sWord.indexOf("  "))+sWord.substring(sWord.indexOf("  ")+1);
       
        String endOfFirstLine = fWord.lastIndexOf(' ')!= -1 ? (fWord.lastIndexOf(' ')!= 0 ? fWord.substring(fWord.lastIndexOf(' ')+1) : fWord.substring(1)) : fWord;
        String endOfSecondLine = sWord.lastIndexOf(' ')!= -1 ? (sWord.lastIndexOf(' ')!= 0 ? sWord.substring(sWord.lastIndexOf(' ')+1) : sWord.substring(1)) : fWord;
        String fVowel="";
        for (char cChar:endOfFirstLine.toLowerCase().toCharArray())
            fVowel+= (cChar=='a' || cChar=='e' ||cChar=='i' || cChar=='o' || cChar=='u') ? cChar : "";
        for (char cChar:endOfSecondLine.toLowerCase().toCharArray())
            if (cChar=='a' || cChar=='e' ||cChar=='i' || cChar=='o' || cChar=='u')
                if (fVowel.length()!=0)
                    if (fVowel.indexOf(cChar)!=-1)
                        fVowel=fWord.substring(0,fVowel.indexOf(cChar))+fVowel.substring(fVowel.indexOf(cChar)+1);
                    else
                        isRhyme=false;
                else
                    isRhyme=false;
        return  fVowel.length() == 0 ? isRhyme : false;
    }
    public static boolean trouble(long firstValue, long secondValue)
    /*9-the function takes two integers and returns true if
    the number is repeated three times in a row anywhere in firstValue and the same number
    repeated twice in a row in secondValue.*/
    {
        boolean hasDigit = false;
        int numOfDigit=1;
        String firstValueInString = String.valueOf(firstValue);
        String secondValueInString = String.valueOf(secondValue);
        for (int i = 0; i<firstValueInString.length()-1;i++)
        {
            numOfDigit+= firstValueInString.charAt(i)==firstValueInString.charAt(i+1) ? 1 : -numOfDigit+1;
            if (numOfDigit == 3)
                hasDigit = secondValueInString.contains(firstValueInString.charAt(i) +""+ firstValueInString.charAt(i)) ? true : hasDigit;
        }
        return hasDigit;
    }
    public static int countUniqueBooks(String bookText, char endOfBooks)
    {
        String listOfUniqueCharacters = "";
        while ((bookText.indexOf(endOfBooks)!=-1)&&(bookText.indexOf(endOfBooks,bookText.indexOf(endOfBooks)+1)!=-1))
        {
            String tempLine = bookText.substring(bookText.indexOf(endOfBooks)+1,bookText.indexOf(endOfBooks,bookText.indexOf(endOfBooks)+1));
            bookText=bookText.substring(bookText.indexOf(endOfBooks,bookText.indexOf(endOfBooks)+1)+1);
            for (char cChar:tempLine.toCharArray())
            {
                listOfUniqueCharacters += listOfUniqueCharacters.indexOf(cChar)==-1 ? cChar : "";
            }

        }
        return listOfUniqueCharacters.length();
    }