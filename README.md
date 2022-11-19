# Programming Language Concepts - Lexical and Syntax Analyzer
Creating the lexical and syntax analyzer for a programming language. This language will be able to create variables, assign them value, calculate basic mathematic operations and relational operations for integers of different types, as well as variables that can be either.

## Token Codes Rules And Descriptions
These are the rules for recognizing all lexemes as their proper token and defines all the integer token codes for each token required in this language.

| Token | Description | Regular Expression | Token Code |
| ----- |    -----    |       -----        |    -----   |
| LETTER | Character Class: Letter | [a-zA-z] | 0 |
| DIGIT | Character Class: Number | \d | 1 |
| UNKNOWN | Unknown Characters: Symbols, Operators, keywords | N/A | 99 |
| BEGIN_KEY | Keyword to begin a program | launch | 28 |
| END_KEY | Keyword to end a program | terminate | 29 |
| LOOP_KEY | Keyword to declare a loop | reiterate | 22 | 
| IF_KEY | Keyword to declare an conditional statement | assume | 53 | 
| DECLARE_KEY | Keyword to declare a variable assignment | declare | 23 |
| INT_DT_KEY | Keyword to declare an 4 byte integer datatype (default) | NUM | 24 | 
| STR_DT_KEY | Keyword to declare a string datatype | WORD | 25 |
| LONG_DT_KEY | Keyword to declare a 8 byte integer datatype | BIG_NUM | 26 |
| BOOL_DT_KEY | Keyword to declare an boolean datatype | BOOL | 27 |
| INT_LIT | Token to identify integer literals | [0-9]+ | 20 |
| IDENT | Token for identifiers | [a-zA-z_]+ | 21 | 
| ASSIGN_OP | Token to identify the assignment operator | = | 30 |
| ADD_OP | Token to identify the addition operator | + | 31 |
| SUB_OP | Token to identify the subtraction operator | - | 32 |
| MULT_OP | Token to identify the multiplication operator | * | 33 |
| DIV_OP | Token to identify the division operator | / | 34 |
| MOD_OP | Token to identify the modulus operator | % | 35 |
| LESS_OP | Token to identify the less than operator | < | 40 |
| GREAT_OP | Token to identify the greater than operator | > | 41 |
| LESS_EQ_OP | Token to identify the less than or equal to operator | <= | 42 |
| GREAT_EQ_OP | Token to identify the greater than or equal to operator | >= | 43 |
| EQ_OP | Token to identify the equal to operator | == | 44 | 
| NOT_EQ_OP | Token to identify the not equal to operator | != | 45 |
| LEFT_PAREN | Token to identify a left parenthesis | ( | 50 |
| RIGHT_PAREN | Token to identify the right parenthesis | ) | 51 |
| END_STATE | Token to identify the symbol when the end of the statement/line was reached | ; | 52 |
| EOF | Token to identify the end of a file | EOF | -1 |


## Production Rules For Mathematical Syntax
Define production rules for implementing the mathematical syntax of operators and operands, loops, variable declaration, selection statements.
- Enforce a non PEMDAS (BODMAS) order of operation, must have at least 6 levels of precedence
- Keywords cannot use the words while, for, do ,if, int, short, long
 - Keywords should be unique, if otehrs share your same words, you may lose more points than this problem is worth
- You must clearly state the structure of your language with production rules

## Grammar
- Show whether every rule set in your language conforms to the standard of an LL Grammar
- Make sure it is not ambiguous grammar

## Assignment
- [ ] Write a program that process all lexemes in a file by recognizing all tokens in a file, and produces a list of those tokens in order.

- [ ] Write a program or an extension to the above program that determines if the tokens conform to the correct syntax.

- [ ] Create 4 test files that have different names where each should have 30 or more lexemes that can be converted into tokens

- [ ] Each program should have a clear beginning and end as well as a way to separate multiple statements

- [ ] For integer literals, you must be able to specify whether in memory this value should be saved as 1 byte, 2 bytes, 4 bytes, or 8 bytes.

- [ ] Variables should be able to be declared but on in separate lines from the assignment of value

- [ ] Variable names can only be 6-8 letters, cannot contain numbers, but may contain underscores.

- [ ] Language must be able to handle keywords to allow for loops, data type declarations, and selection statements.

## Testing
Create 4 test files that have different names where each should have 30 or more lexemes that can be converted into tokens
- 1 with at least 5 lexical errors based on the rules you defined
 - Detail each error and say why it doesn't work
- 1 with at least 5 syntax errors based on the rules you defined
 - Detail each error and say why it doesn't work
- 2 with no errors at all based on the language you created

## Parse Tables
Create a LR (1) parse table for yourlanguage. And show the trade of 4 code samples. Each must have 6 or more tokens.
- Table must be provided and the rules must be listed
- 2 code samples must have errors
- Show where these samples fail and pass the test

## Programming Language Documentation
- Will be written using Java

