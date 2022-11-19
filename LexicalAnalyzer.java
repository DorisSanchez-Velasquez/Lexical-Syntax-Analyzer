public class LexicalAnalyzer 
{
    /*GLOBAL DECLARATIONS*/
    //Character Classes
    static final int LETTER = 0;
    static final int DIGIT = 1;
    static final int UNKNOWN = 99; 

    /*Keywords*/
    //Loop Keywords
    static final int LOOP_KEY = 22; 
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



    public static void main (String args[])
    {
        System.out.println("Hello World!" + " Checking!");
    }
}
