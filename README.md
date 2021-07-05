# Doka Language

## Specifications

### Example

```
module MyFirstApplication

    arr = [1, 2, 3, 4]

    sum = a, b => a + b
    divide = a, b => a / b

    def calc_average(data):
        List.reduce 0, sum 
        > divide List.length data
    end     
    
    IO.out "The avarage is"
    IO.out calc_average arr
```

### Backus–Naur form
```
<MAIN> ::= <MODULE> <MODULE_ID>
    <DEFINE_CONSTANT> ::= <CONSTANT_ID> <EQUAL> <?>
<EXIT>
```

### Terminals
`<MODULE>` ::= `module`
`<EQUAL>` ::= `=`
`<EXIT>` ::= `exit` `| <EOF>`

### Non-Terminals

### Ids
`<MODULE_ID>` ::= `<UPPER_CASE_CHAR> (<UPPER_CASE_CHAR> | <LOWER_CASE_CHAR> | <DIGIT>)*`
`<CONSTANT_ID>` ::= `(<CHAR>)(<CHAR> | <DIGIT>)*`

### Chars
`<UPPER_CASE_CHAR>` ::= `[A-Z]`
`<LOWER_CASE_CHAR>` ::= `[a-z]`
`<CHAR>` ::= `<UPPER_CASE_CHAR> | <LOWER_CASE_CHAR> | "_"`