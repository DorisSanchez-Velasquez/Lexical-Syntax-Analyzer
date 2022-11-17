# Programming Language Concepts - Lexical and Syntax Analyzer
Creating the lexical and syntax analyzer for a programming language. This language will be able to create variables, assign them value, calculate basic mathematic operations and relational operations for integers of different types, as well as variables that can be either.

## Integer Token Codes
Defines the rules for recognizing all lexemes as their proper token and clearly define integer token codes for each token required for this language.
- Should have regular grammar, regular expression, or finite automata defined

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

