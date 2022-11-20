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
These are the production rules for implementing the mathematical syntax of operators and operands, loops, variable declaration, and selection statements. 

PROGRAM -> launch STATEMENTS terminate   <br />

STATEMENTS -> ASSIGN | CONDITIONAL | LOOP | MATH  <br />

CONDITIONAL -> assume ( RELATIONAL ) { STATEMENTS }  <br />

RELATIONAL -> TERM {( <= | >= | < | > | != | == ) TERM}  <br />

TERM -> identifier | int_literal | ( MATH )  <br />

ASSIGN -> declare DATATYPE  <br />

DATATYPE -> {(WORD | NUM | BIG_NUM | BOOL) = DATA}  <br />

DATA -> " identifier " | int_literal

LOOP reiterate ( RELATIONAL ) { STATEMENTS }  <br />

MATH -> EXPR {(* | / | %) EXPR}  <br />

EXPR -> FACTOR {( + | - ) FACTOR}  <br />

FACTOR -> EQUALITY {( == | != ) EQUALITY}   <br />

EQUALITY -> RELATE {( < | > ) RELATE}   <br />

RELATE -> TERM {( <= | >= ) TERM}  <br />

## Grammar
Show whether every rule set in the language conforms to the standard of an LL Grammar.

Pairwise Disjointness Test:

- FIRST( PROGRAM ) -> {launch} <br />
- FIRST( STATEMENTS ) -> {declare} {assume} {reiterate} {id} <br />
- FIRST( CONDITIONAL ) -> {assume} <br />
- FIRST( RELATIONAL ) -> {id} <br />
- FIRST( TERM ) -> {identifier} {int_literal} { ( } <br />
- FIRST( ASSIGN ) -> {declare} <br />
- FIRST( DATATYPE ) -> {WORD} {NUM} {BIG_NUM} {BOOL} <br />
- FIRST( DATA ) -> {" identifier "} {int_literal}
- FIRST( LOOP ) -> {reiterate} <br />
- FIRST( MATH ) -> {identifier} {int_literal} { ( } <br />
- FIRST( EXPR ) -> {identifier} {int_literal} { ( } <br />
- FIRST( FACTOR ) -> {identifier} {int_literal} { ( } <br />
- FIRST( EQUALITY ) -> {identifier} {int_literal} { ( } <br />
- FIRST( RELATE ) -> {identifier} {int_literal} { ( } <br />

Note: All the rules pass the pairwise disjointness test and can be parsed in a top down fashion.

Additionally, this production rules are not ambiguous grammar because there are no two ways to make the same statements.

## Assignment
- [X] Write a program that process all lexemes in a file by recognizing all tokens in a file, and produces a list of those tokens in order.

- [ ] Write a program or an extension to the above program that determines if the tokens conform to the correct syntax.

- [ ] Create 4 test files that have different names where each should have 30 or more lexemes that can be converted into tokens

- [X] Each program should have a clear beginning and end as well as a way to separate multiple statements

- [X] For integer literals, you must be able to specify whether in memory this value should be saved as 1 byte, 2 bytes, 4 bytes, or 8 bytes.

- [X] Variables should be able to be declared but on in separate lines from the assignment of value

- [X] Variable names can only be 6-8 letters, cannot contain numbers, but may contain underscores.

- [X] Language must be able to handle keywords to allow for loops, data type declarations, and selection statements.

## Testing
These test files should have 30 or more lexemes that can be converted into tokens:

- Test files with no errors at all based on the language
1. test_NoErrors_1.txt
2. test_NoErrors_2.txt

- Test file with at least 5 lexical errors based on the defined rules 
Name: test_LexErrors.txt
Errors:
1. declare WORD description = " Sahara';

The word variable name 'description' is too long of a variable name than what is required within the language and would result in an error. This is because the language enforces a variable names between the length of 6-8.

2. The next error is in the quotations enclosing the word literal "Sahara". The word ends with the wrong quotation having it continue until the end of the file without ending. The lexical analyzer wouldn't be able to determine the token for all the characters in the quotations.

3. title = 'Fun Facts About the World'

This word litral 'Fun Facts About the Word' is encased within the wrong quotations  and would result in the lexical analyzer reading all the character up until the end of the file because the correct quotations were not given to end the variable declaration.

4. myNum = 2a

In this integer variable declaration, the 2a would not be considered a number nor an identifier which would result in a lexical error where the data type for the variable could not be determined.

5. title = "Fun Fact';

This is another lexical error where the string literal "Fun fact' ends with the wrong quotation which with have the lexical analyzer continuously read all the characters without an end point until it reaches the end of the file.

There are two lexical errors in this one statement. 



-Test file with at least 5 syntax errors based on the defined rules
1. test_SynErrors.txt

## Parse Tables
Create a LR (1) parse table for yourlanguage. And show the trade of 4 code samples. Each must have 6 or more tokens.
- Table must be provided and the rules must be listed
- 2 code samples must have errors
- Show where these samples fail and pass the test

## Programming Language Documentation
- Will be written using Java

