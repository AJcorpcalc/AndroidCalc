package com.example.myapplication.ui.calculator.parser;

import com.example.myapplication.MathFeatures.accuracy;
public class ParserCalc {
    //  Объявление лексем
    final int NONE = 0;         //  FAIL
    final int DELIMITER = 1;    //  Разделитель
    final int NUMBER = 2;       //  Число
    final int FUNC=3;           //  функция

    //  Лексема, определяющая конец выражения
    final String EOF = "\0";

    private String text;     //  Ссылка на строку с выражением
    private int idText;     //  Текущий индекс в выражении
    private String token;   //  Сохранение текущей лексемы
    private int tokenType;    //  Сохранение типа лексемы
    private int textFunc; // Сохранение функции

    private final double pi=3.14159265359;
    private final int accuracy_order = 5;



    public String start(String textView){

        double result;
        text = textView;
        idText = 0;
        getToken();
        //  Анализ и вычисление выражения
        result =  binSumMin();
        result = new accuracy().val_round(result,accuracy_order);
        return ""+result;
    }
    private boolean isDelimiter(char charAt) {
        if(("+-/*=()^".indexOf(charAt)) != -1)
            return true;
        return false;
    }
    private boolean isFunc(char charAt) {
        if(("sctel".indexOf(charAt))!=-1){
            if(("scet".indexOf(charAt))!=-1)idText+=2;
            else idText+=1;
            switch(charAt){
                case 's': textFunc=1;break;
                case 'c': textFunc=2; break;
                case 'e': textFunc=3; break;
                case 't': textFunc=4; break;
                case 'l': textFunc=5; break;

            }
            return true;
        }
        return false;
    }
    // Handle token
    private void getToken() {
        tokenType = NONE;
        token = "";

        //  Проверка на окончание выражения
        if(idText == text.length()){
            token = EOF;
            tokenType=NONE;
            return;
        }
        if('p'==(text.charAt(idText))){
            token += pi;
            idText++;
            tokenType = NUMBER;
        }
        else
        if(isDelimiter(text.charAt(idText))){
            token += text.charAt(idText);
            idText++;
            tokenType = DELIMITER;
        }
        else
        if(isFunc(text.charAt(idText))){
            idText++;
            tokenType = FUNC;
        }
        else
        if (Character.isDigit(text.charAt(idText)))
        {
            while(idText<text.length()&&(!isDelimiter(text.charAt(idText))&&!isFunc(text.charAt(idText)))){
                token += text.charAt(idText);
                idText++;

            }
            tokenType = NUMBER;
        }
        else
        {
            token = EOF;
            tokenType=NONE;
            return;
        }
    }
    // Handle sign operations (addition and subtraction)
    private double binSumMin (){
        char delimiter;
        double result;
        double partialResult;
        result = binMultiDiv();

        while((delimiter = token.charAt(0)) == '+' || delimiter == '-'){

            getToken();
            partialResult = binMultiDiv();
            switch(delimiter){
                case '-':
                    result -= partialResult;
                    break;
                case '+':
                    result += partialResult;
                    break;
            }
        }
        return result;

    }

    // Handle sign operations (multiplication,division,exponentiation)
    private double binMultiDiv() {
        char delimiter;
        double result;
        double partialResult;

        result = unarMinus();
        while((delimiter = token.charAt(0)) == '*' ||  delimiter == '/'||delimiter=='^'){
            getToken();
            partialResult = unarMinus();
            switch(delimiter)
            {
                case '*':
                    result *= partialResult;
                    break;
                case '/':
                    result /= partialResult;
                    break;
                case'^': result=Math.pow(result,partialResult); break;

            }
        }
        return result;
    }

    // Handle mathematical functions
    private double func() {
        double result=0.0;

        int text_f=textFunc;
        while(text_f>0&&text_f<6){
            getToken();
            double partialresult =bracket();
            switch(text_f){
                case 1:  result=Math.sin(partialresult); break;
                case 2: result=Math.cos(partialresult); break;
                case 4: result=Math.tan(partialresult); break;
                case 3: result=Math.exp(partialresult); break;
                case 5: result=Math.log(partialresult); break;
            }
            text_f=0;


        }

        return result;
    }
    // Handle unary minus
    private double unarMinus(){
        double result;

        String operation;
        operation = "";

        if((tokenType == DELIMITER) &&token.equals("-"))
        {
            operation = token;
            getToken();
        }
        result = bracket();
        if(operation.equals("-"))
            result =  -result;
        return result;
    }

    //  Handle parenthesized expression
    private double bracket() {
        double result;

        if(token.equals("(")){
            getToken();
            result = binSumMin();
            getToken();
        }
        else{
            if(tokenType==FUNC) return func();
            else result = atom();
        }
        return result;
    }

    //  Get value of number
    private double atom()  {

        double result=0.0;
        if(tokenType==NUMBER)
        {
            result = Double.parseDouble(token);
            getToken();
        }
        return result;
    }
}
