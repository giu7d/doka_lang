package recovery;

import parser.*;

public class Follow {

    static public final RecoverySet Main = new RecoverySet();
    static public final RecoverySet functional_block = new RecoverySet();
    static public final RecoverySet block = new RecoverySet()
            .union(Main).union(functional_block);

    static public final RecoverySet declaration_statements = block;
    static public final RecoverySet declare_assignment = declaration_statements;

    static public final RecoverySet return_expression = new RecoverySet()
            .union(functional_block);

    static public final RecoverySet common_expressions = new RecoverySet()
            .union(declare_assignment);

    static public final RecoverySet logical_expression =  new RecoverySet()
            .union(common_expressions)
            .union(return_expression);

    static public final RecoverySet list_expression = new RecoverySet().union(common_expressions);

    static public final RecoverySet numerical_expression =  new RecoverySet()
            .union(logical_expression)
            .union(list_expression);

    static public final RecoverySet expression = new RecoverySet()
            .union(list_expression)
            .union(declare_assignment)
            .union(return_expression);

    static public final RecoverySet declare_condition = declaration_statements;
    static public final RecoverySet declare_lambda_function = expression;
    static public final RecoverySet declare_function = declaration_statements;
    static public final RecoverySet declare_list = expression;
    static public final RecoverySet module_statements = expression.union(block);
    static public final RecoverySet module_io_params = module_statements;
    static public final RecoverySet id = new RecoverySet()
            .union(logical_expression)
            .union(numerical_expression)
            .union(common_expressions)
            .union(return_expression)
            .union(list_expression);

    static public final RecoverySet declare_conditional_params = new RecoverySet();

    static public final RecoverySet callable_expression = new RecoverySet()
            .union(list_expression)
            .union(common_expressions);

    static public final RecoverySet declare_function_params = new RecoverySet()
            .union(return_expression)
            .union(callable_expression)
            .union(declaration_statements)
            .union(module_statements);

    static public final RecoverySet string  = new RecoverySet()
            .union(return_expression)
            .union(logical_expression)
            .union(list_expression)
            .union(common_expressions);

    static public final RecoverySet bool  = string;
    static public final RecoverySet number  = new RecoverySet()
            .union(string).union(numerical_expression);

    static public final RecoverySet priority_expression = number;

    static public final RecoverySet brackets_expression = callable_expression;

    static public final RecoverySet math_operator = new RecoverySet();

    static public final RecoverySet logic_operator = new RecoverySet();

    static {
        Main.add(DokaConstants.EOF);
        Main.add(DokaConstants.EXIT);

        block.add(DokaConstants.RETURN_ARROW);
        block.add(DokaConstants.END_BLOCK);

        common_expressions.add(DokaConstants.COMMA);
        common_expressions.add(DokaConstants.END_PARAM);

        list_expression.add(DokaConstants.END_BRACKET);

        id.add(DokaConstants.ASSIGN);
        id.add(DokaConstants.START_PARAM);
        id.add(DokaConstants.START_BRACKET);
        id.add(DokaConstants.SUM);
        id.add(DokaConstants.SUBTRACT);
        id.add(DokaConstants.MULTIPLY);
        id.add(DokaConstants.DIVIDE);
        id.add(DokaConstants.REST);
        id.add(DokaConstants.AND);
        id.add(DokaConstants.OR);
        id.add(DokaConstants.GREATER);
        id.add(DokaConstants.SMALLER);
        id.add(DokaConstants.GREATER_OR_EQUAL);
        id.add(DokaConstants.SMALLER_OR_EQUAL);
        id.add(DokaConstants.DIFFERENT);
        id.add(DokaConstants.EQUAL);
        id.add(DokaConstants.END_PARAM);

        functional_block.add(DokaConstants.ELSEIF);
        functional_block.add(DokaConstants.END_BLOCK);
        functional_block.add(DokaConstants.ELSE);

        declare_conditional_params.add(DokaConstants.START_BLOCK);

        declare_function_params.add(DokaConstants.SUM);
        declare_function_params.add(DokaConstants.SUBTRACT);
        declare_function_params.add(DokaConstants.MULTIPLY);
        declare_function_params.add(DokaConstants.DIVIDE);
        declare_function_params.add(DokaConstants.REST);
        declare_function_params.add(DokaConstants.AND);
        declare_function_params.add(DokaConstants.OR);
        declare_function_params.add(DokaConstants.GREATER);
        declare_function_params.add(DokaConstants.SMALLER);
        declare_function_params.add(DokaConstants.GREATER_OR_EQUAL);
        declare_function_params.add(DokaConstants.SMALLER_OR_EQUAL);
        declare_function_params.add(DokaConstants.DIFFERENT);
        declare_function_params.add(DokaConstants.EQUAL);
        declare_function_params.add(DokaConstants.START_PARAM);
        declare_function_params.add(DokaConstants.ARROW);
        declare_function_params.add(DokaConstants.START_BLOCK);

        return_expression.add(DokaConstants.EOL);
        return_expression.add(DokaConstants.END_BLOCK);
        return_expression.add(DokaConstants.GENERIC_ID);
        return_expression.add(DokaConstants.NUMBER);
        return_expression.add(DokaConstants.BOOLEAN);
        return_expression.add(DokaConstants.STRING);
        return_expression.add(DokaConstants.START_BLOCK);
        return_expression.add(DokaConstants.START_BRACKET);
        return_expression.add(DokaConstants.LIST_MODULE);
        return_expression.add(DokaConstants.IO_MODULE);
        return_expression.add(DokaConstants.PIPE);

        string.add(DokaConstants.AND);
        string.add(DokaConstants.OR);
        string.add(DokaConstants.GREATER);
        string.add(DokaConstants.SMALLER);
        string.add(DokaConstants.GREATER_OR_EQUAL);
        string.add(DokaConstants.SMALLER_OR_EQUAL);
        string.add(DokaConstants.DIFFERENT);
        string.add(DokaConstants.EQUAL);

        number.add(DokaConstants.END_PARAM);
        number.add(DokaConstants.END_BRACKET);
        number.add(DokaConstants.SUM);
        number.add(DokaConstants.SUBTRACT);
        number.add(DokaConstants.MULTIPLY);
        number.add(DokaConstants.DIVIDE);
        number.add(DokaConstants.REST);

        logical_expression.add(DokaConstants.AND);
        logical_expression.add(DokaConstants.OR);
        logical_expression.add(DokaConstants.GREATER);
        logical_expression.add(DokaConstants.SMALLER);
        logical_expression.add(DokaConstants.GREATER_OR_EQUAL);
        logical_expression.add(DokaConstants.SMALLER_OR_EQUAL);
        logical_expression.add(DokaConstants.DIFFERENT);
        logical_expression.add(DokaConstants.EQUAL);
        logical_expression.add(DokaConstants.SUBTRACT);
        logical_expression.add(DokaConstants.MULTIPLY);
        logical_expression.add(DokaConstants.DIVIDE);
        logical_expression.add(DokaConstants.REST);
        logical_expression.add(DokaConstants.END_PARAM);

        callable_expression.add(DokaConstants.SUM);
        callable_expression.add(DokaConstants.SUBTRACT);
        callable_expression.add(DokaConstants.MULTIPLY);
        callable_expression.add(DokaConstants.DIVIDE);
        callable_expression.add(DokaConstants.REST);
        callable_expression.add(DokaConstants.AND);
        callable_expression.add(DokaConstants.OR);
        callable_expression.add(DokaConstants.GREATER);
        callable_expression.add(DokaConstants.SMALLER);
        callable_expression.add(DokaConstants.GREATER_OR_EQUAL);
        callable_expression.add(DokaConstants.SMALLER_OR_EQUAL);
        callable_expression.add(DokaConstants.DIFFERENT);
        callable_expression.add(DokaConstants.EQUAL);
        callable_expression.add(DokaConstants.END_PARAM);

        math_operator.add(DokaConstants.GENERIC_ID);
        math_operator.add(DokaConstants.START_PARAM);
        math_operator.add(DokaConstants.NUMBER);

        logic_operator.add(DokaConstants.GENERIC_ID);
        logic_operator.add(DokaConstants.NUMBER);
        logic_operator.add(DokaConstants.START_PARAM);
        logic_operator.add(DokaConstants.BOOLEAN);
        logic_operator.add(DokaConstants.STRING);
    }
}
