# Doka Language

## TO DO:

### Parser

-[x] Module Begin (S)
-[x] Constant Definition
-[] Funtion Definition
-[] Constant inicialization
-[] Arrays
-[] Lambda Functions
-[] Function inicialization
-[] Pipe operator
-[] Pattern matching
-[] IO module
-[] List module
 
## Specifications

### Example

```
module MyFirstApplication

    arr = [1, 2, 3, 4]

    sum = a, b => a + b end
    divide = a, b => a / b end

    fun calc_average(data):
        List.reduce 0, sum 
        > divide List.length data
    end     
    
    IO.out "The avarage is"
    IO.out calc_average arr
```

### Backus–Naur form
```
<MAIN> ::= <MODULE> <MODULE_ID>
    <DEFINE_CONSTANT>   ::= <CONSTANT_ID> <EQUAL> <TYPES>
    <DEFINE_FUNTION>    ::= <FUNCTION><CONSTANT_ID><START_PARAM><PARAMS><END_PARAM><START_BLOCK> <EXPR> <END_BLOCK>
<EXIT>
```

### Terminals
- `<MODULE>`        ::= `module`
- `<EQUAL>`         ::= `=`
- `<EXIT>`          ::= `exit` `| <EOF>`
- `<FUNCTION>`      ::= `fun`
- `<ARROW>`         ::= `=>`
- `<SCAPE>`         ::= `\n`
- `<START_BLOCK>`   ::= `:`
- `<END_BLOCK>`     ::= `end`
- `<START_PARAM>`   ::= `(`
- `<END_PARAM>`     ::= `)`

### Non-Terminals

#### Ids
- `<MODULE_ID>`     ::= `<UPPER_CASE_CHAR> (<UPPER_CASE_CHAR> | <LOWER_CASE_CHAR> | <DIGIT>)*`
- `<CONSTANT_ID>`   ::= `(<CHAR>)(<CHAR> | <DIGIT>)*`

#### Chars
- `<UPPER_CASE_CHAR>`   ::= `[A-Z]`
- `<LOWER_CASE_CHAR>`   ::= `[a-z]`
- `<CHAR>`              ::= `<UPPER_CASE_CHAR> | <LOWER_CASE_CHAR> | "_"`

#### Types
- `<FLOAT>`             ::= ?
- `<INT>`               ::= ?
- `<STRING>`            ::= ?
- `<PARAMS>`            ::= (<TYPES>)*
- `<BASIC_TYPE>`        ::= `<FLOAT> | <INT> | <STRING>` 
- `<ARRAY>`             ::= `("[" (<BASIC_TYPE>)* "]")`
- `<TYPE>`              ::= `<ARRAY> | <BASIC_TYPE> | <LAMBDA_FUNCTION>`
- `<LAMBDA_FUNCTION>`   ::= `(<PARAMS><ARROW><EXPR><SCAPE>)`
    
#### TO DO  
- `<EXPR>` ::= ?
