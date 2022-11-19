import java.util.*;
import java.io.*;

public class LexicalAnalyzer 
{
    /*GLOBAL DECLARATIONS*/
    /* Variables */
    static String lexeme = "";
    static char nextChar;
    static int lexemeLen;
    static int charClass;
    static int currentChar;
    static int nextToken;
    static int token;
    static File myInputFile;
    static BufferedReader myReader;



    //Character Classes
    static final int LETTER = 0;
    static final int DIGIT = 1;
    static final int UNKNOWN = 99; 

    /*Keywords*/
    //Loop Keywords
    static final int LOOP_KEY = 22; 
    //Conditional Keywords
    static final int IF_KEY = 28;
    // Data Type Declaration Keywords
    static final int DECLARE_KEY = 23;
    //Data Type Keywords
    static final int INT_DT_KEY = 24;
    static final int STR_DT_KEY = 25;
    static final int LONG_DT_KEY = 26;
    static final int BOOL_DT_KEY = 27;

    /* Token Codes */
    static final int INT_LIT = 20;
    static final int IDENT = 21;
    static final int ASSIGN_OP = 30;
    static final int ADD_OP = 31;
    static final int SUB_OP = 32;
    static final int MULT_OP = 33;
    static final int DIV_OP = 34;
    static final int MOD_OP = 35;
    static final int LESS_OP = 40;
    static final int GREAT_OP = 41; 
    static final int LESS_EQ_OP = 42;
    static final int GREAT_EQ_OP = 43;
    static final int EQ_OP = 44;
    static final int NOT_EQ_OP = 45;
    static final int LEFT_PAREN = 50;
    static final int RIGHT_PAREN = 51;
    static final int END_STATE = 52;
    static final int EOF = -1;


/* ************************************************************************************************ */
    /* MAIN FUNCTION DRIVER*/
    public static void main (String args[])
    {
        //Open a file and if you can't open it then send an error message
        //Else run the getchar function
        try{
            myInputFile = new File("tester.txt");
            FileReader readFileObj = new FileReader(myInputFile);
            myReader = new BufferedReader(readFileObj);

            getChar();
            while(nextToken != EOF)
            {
                lexAnalyzer();
                lexeme = "";
            }
        } 
        catch(FileNotFoundException error) {
            System.out.println("ERROR - Unable to open your file!");
        }
    }


/* ************************************************************************************************ */
    /* getChar: This is a function to get the next character from the input file and find out the character class */
    public static void getChar()
    {
        try {
            if((currentChar = myReader.read()) != EOF){
                nextChar = (char) currentChar;
                if(Character.isLetter(nextChar)){
                    charClass = LETTER;
                }
                else if(Character.isDigit(nextChar)){
                    charClass = DIGIT;
                }
                else{
                    charClass = UNKNOWN;
                }
            }
            else {
                charClass = EOF;
            }
        } catch (IOException e) {
            System.out.println("ERROR: Unable to read the character in your file!");
        }
    }


/* ************************************************************************************************ */
    /* addChar: this is the function that add the new character to the existing lexeme*/
    public static void addChar()
    {
        lexeme += nextChar;
    }

/* ************************************************************************************************ */
    /* getNonBlankSpace: This is a function to keeping calling for new a character from get char until it is a non-whitespace character */
    public static void getNonBlankSpace(){
        while(Character.isWhitespace(nextChar)){
            getChar();
        }
    }

/* ************************************************************************************************ */
    /* identifyUnknown: This function will match the unknown characters with operators, paranthesis, relational operators, and end statement symbols etc. and return token code*/
    public static int identifyUnknown(char myChar){
        switch(myChar){
            case '+':
                addChar();
                nextToken = ADD_OP;
                break;
            case '-':
                addChar();
                nextToken = SUB_OP;
                break;
            case '*':
                addChar();
                nextToken = MULT_OP;
                break;
            case '/':
                addChar();
                nextToken = DIV_OP;
                break;
            case '%':
                addChar();
                nextToken = MOD_OP;
                break;
            case '<':
                addChar();
                if(!Character.isWhitespace((char) currentChar++)){
                    getChar();
                    addChar();
                    nextToken = LESS_EQ_OP;
                    break;
                }
                nextToken = LESS_OP;
                break;
            case '>':
                addChar();
                if(!Character.isWhitespace((char) currentChar++)){
                    getChar();
                    addChar();
                    nextToken = GREAT_EQ_OP;
                    break;
                }
                nextToken = GREAT_OP;
                break;
            case '(':
                addChar();
                nextToken = LEFT_PAREN;
                break;
            case ')':
                addChar();
                nextToken = RIGHT_PAREN;
                break;
            case '=':
                addChar();
                if(!Character.isWhitespace((char) currentChar++)){
                    getChar();
                    addChar();
                    nextToken = EQ_OP;
                    break;
                }
                nextToken = ASSIGN_OP;
                break;
            case '!':
                addChar();
                getChar();
                addChar();
                nextToken = NOT_EQ_OP;
                break;
            case ';':
                addChar();
                nextToken = END_STATE;
                break;
            default:
                addChar();
                nextToken = EOF;
                break;
        }
        return nextToken;
    }
/* ************************************************************************************************ */
    /* identifyKeyword: This function will check if the current lexeme is equal to any keyword in the language and match the token code */
    public static void identifyKeyword(){
        switch(lexeme){
            case "reiterate":
                nextToken = LOOP_KEY;
                break;
            case "declare":
                nextToken = DECLARE_KEY;
                break;
            case "assume":
                nextToken = IF_KEY;
                break;
            case "NUM":
                nextToken = INT_DT_KEY;
                break;
            case "WORD":
                nextToken = STR_DT_KEY;
                break;
            case "BIG_NUM":
                nextToken = LONG_DT_KEY;
                break;
            case "BOOL":
                nextToken = BOOL_DT_KEY;
                break;
            default:
                nextToken = IDENT;
                break;
        }
    }

/* ************************************************************************************************ */
    /* lexAnalyzer: this is the main function for the lexical analyzer to get the token codes for each character class until the end of file is reached*/
    public static void lexAnalyzer()
    {
        lexemeLen = 0;
        getNonBlankSpace();
        switch(charClass){
            case LETTER:
                addChar();
                getChar();
                while(charClass == LETTER || charClass == UNKNOWN && nextChar == '_'){
                    addChar();
                    getChar();
                }
                identifyKeyword();
                break;
            case DIGIT:
                addChar();
                getChar();
                while(charClass == DIGIT){
                    addChar();
                    getChar();
                }
                nextToken = INT_LIT;
                break;
            case UNKNOWN:
                identifyUnknown(nextChar);
                getChar();
                break;
            case EOF:
                nextToken = EOF;
                lexeme = "EOF";
                break;
        }
        System.out.println("Token: " + nextToken + ", Lexeme: " + lexeme);
    }
}
