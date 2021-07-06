# Doka Language


## Features

### Parser
- [x] Module Begin (S)
- [x] Constant Initialization
- [x] Constant Definition
- [x] Function Definition
- [x] Function Initialization
- [x] Arrays
- [x] Lambda Functions (One line)
- [x] Lambda Functions (Multiple lines)
- [x] Pipe Operator
- [x] If/Else
- [ ] Logical Expression
- [ ] Mathematical Expression
- [ ] List.map
- [ ] List.reduce
- [ ] Pattern Matching (?)
- [ ] IO module (?)
 
## Specifications


### Example

1. Calculate the average of an array of numbers:

```
module MyFirstApplication

    arr = [1, 2, 3, 4]

    sum = (a, b) => a + b
    divide = (a, b) => a / b

    fun calc_average(data):
        List.reduce 0, sum 
        |> divide List.length data
    end     
    
    IO.out "The avarage is"
    IO.out calc_average arr
```

### Backus–Naur form

```
<MAIN> ::= <MODULE> <MODULE_ID>
    <DEFINE_CONSTANT>  ::= <CONSTANT_ID> <EQUAL> <EXPRESSION>
    <DEFINE_FUNTION>   ::= <FUNCTION> <CONSTANT_ID> <START_PARAM> <PARAMS> <END_PARAM> <START_BLOCK> <STATMENT> <END_BLOCK>
<EXIT>
```

#### Terminals
- `<MODULE>`        ::= `module`
- `<EXIT>`          ::= `exit` `| <EOF>`
- `<FUNCTION>`      ::= `fun`
- `<EQUAL>`         ::= `=`
- `<ARROW>`         ::= `=>`
- `<UNDERLINE>`     ::= `_`
- `<SCAPE>`         ::= `\n`
- `<START_BLOCK>`   ::= `:`
- `<END_BLOCK>`     ::= `end`
- `<START_PARAM>`   ::= `(`
- `<END_PARAM>`     ::= `)`
- `<START_BRACKET>` ::= `[`
- `<END_BRACKET>`   ::= `]`
- `<QUOTE>`         ::= `"`
- `<COMMA>`         ::= `,`
- `<PIPE_OPERATOR>` ::= `|>`

#### Non-Terminals
- `<MAIN>`                  ::= `(<MODULE> <MODULE_ID> <EXIT>)`
 
##### Definitions
- `<DEFINE_CONSTANT>`       ::= `(<CONSTANT_ID> <EQUAL> <EXPRESSION>)`
- `<DEFINE_FUNTION>`        ::= `(<FUNCTION> <CONSTANT_ID> <START_PARAM> <PARAMS> <END_PARAM> <START_BLOCK> <STATMENT> <END_BLOCK>)`
- `<DEFINE_LAMBDA_FUNTION>` ::= `(<PARAMS><ARROW><STATMENT><SCAPE>)`

##### IDs
- `<MODULE_ID>`         ::= `(<UPPER_CASE_CHAR> (<UPPER_CASE_CHAR> | <LOWER_CASE_CHAR> | <DIGIT>)*)`
- `<CONSTANT_ID>`       ::= `(<CHAR>)(<CHAR> | <DIGIT>)*`
- `<UPPER_CASE_CHAR>`   ::= `[A-Z]`
- `<LOWER_CASE_CHAR>`   ::= `[a-z]`
- `<DIGIT>`             ::= `[0-9]`
- `<CHAR>`              ::= `(<UPPER_CASE_CHAR> | <LOWER_CASE_CHAR> | <UNDERLINE>)`

##### Types
- `<FLOAT>`             ::= `?`
- `<INT>`               ::= `?`
- `<STRING>`            ::= `?`
- `<PRIMARY_TYPE>`      ::= `(<FLOAT> | <INT> | <STRING>)` 
- `<ARRAY>`             ::= `(<START_BRACKET> (<PRIMARY_TYPE><COMMA>)* (<PRIMARY_TYPE>) <END_BRACKET>)`

##### Functions
- `<PARAMS>`            ::= `(<PRIMARY_TYPE> | <ARRAY>)*`

##### Expressions and Statements
- `<STATMENT>`   ::= `?`
- `<EXPRESSION>` ::= `?`


## Guide

### 1. Create a module
    ```
    module MyApplication
    ```
   
### 2. Define a constant
    ```
    hello = "world"
   
    # or define a list

    my_list = [1, "foo", hello, true, [10, 1.8, "bars"], []]
    ```

### 3.  Function
    ```
    fun calc(data):
        ...do something..
    end 
   
    calc()  # call function
    ```
   
#### 3.1 Lambda function
    ```
    sum = (a1, a2) => a1 + a2
    sum(2,2) # returns 4    
   
    addTwo =: (a1) => 
        a1
        |> sum(2)
    end

    add(2) # returns 4
    ```

#### 3.2 Pipe Operator (Works with every function)
    ```
    processData =: (data) => 
        data
        |> doProcess1()
        |> doProcess2()
    end
    ```

#### 4 Conditions

    ```
    if (expr):
        ...
    else if (expr2):
        ...
    else:
        ...
    end
    ```