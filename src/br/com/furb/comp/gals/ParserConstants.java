package br.com.furb.comp.gals;

public interface ParserConstants
{
    int START_SYMBOL = 42;

    int FIRST_NON_TERMINAL    = 42;
    int FIRST_SEMANTIC_ACTION = 78;

    int[][] PARSER_TABLE =
    {
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1,  1,  1,  1,  1, -1, -1, -1, -1, -1,  1,  1, -1, -1, -1,  2, -1, -1,  1, -1, -1,  1, -1,  1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1,  3,  3,  3,  3, -1, -1, -1, -1, -1,  3,  3, -1, -1, -1, -1, -1, -1,  3, -1, -1,  3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1,  5,  5,  5,  5, -1, -1, -1, -1, -1,  5,  5, -1, -1, -1, -1, -1, -1,  5, -1, -1,  5, -1, -1, -1, -1,  4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  6, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1,  8,  8,  8,  8, -1, -1, -1, -1, -1,  8,  8, -1, -1, -1, -1, -1, -1,  8,  7, -1,  8, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1,  9, 10, 11, 12, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, 14, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 15, 15, 15, 15, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 17, -1, 16, 16, -1, -1, 16, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 18, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 19, 19, 19, 19, -1, -1, -1, -1, -1, 19, 19, -1, -1, -1, -1, -1, -1, 19, 19, -1, 19, -1, 20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 21, 21, 21, 21, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 22, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 23, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 24, 24, 24, 24, 24, 24, 24, -1, 24, -1, -1, -1, -1, -1, -1, 24, -1, -1, -1, 24, -1, -1, -1, -1, -1, -1, 24, -1, 24, 24, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 26, -1, -1, -1, -1, -1, 25, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 27, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 28, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 29, 29, 29, 29, -1, -1, -1, -1, -1, 29, 29, 30, -1, -1, -1, -1, -1, 29, 29, -1, 29, -1, -1, -1, -1, 29, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 31, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 33, 32, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 34, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 35, 35, 35, 35, -1, -1, -1, -1, -1, 38, 36, -1, -1, -1, -1, -1, -1, 37, -1, -1, 39, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 40, 40, 40, 40, 40, 40, 40, -1, 40, -1, -1, -1, -1, -1, -1, 40, -1, -1, -1, 40, -1, -1, -1, -1, -1, -1, 40, -1, 40, 40, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, 43, -1, -1, -1, -1, -1, -1, -1, -1, 42, -1, -1, -1, -1, 41, -1, 41, -1, -1, -1, 41, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 44, 44, 44, 44, 44, 44, 44, -1, 46, -1, -1, -1, -1, -1, -1, 47, -1, -1, -1, 45, -1, -1, -1, -1, -1, -1, 44, -1, 44, 44, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 48, 48, 48, 48, 48, 48, 48, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 48, -1, 48, 48, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 57, 57, 57, 57, 57, 57, 57, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 57, -1, 57, 57, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, 58, -1, -1, -1, -1, -1, -1, -1, -1, 58, -1, -1, -1, -1, 58, -1, 58, -1, -1, -1, 58, 59, 60, -1, -1, -1, 58, 58, 58, 58, 58, 58 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 51, 52, 53, 54, 55, 56 },
        { -1, -1, 61, 61, 61, 61, 61, 61, 61, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 61, -1, 61, 61, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, -1, 62, -1, 62, -1, -1, -1, 62, 62, 62, 63, 64, -1, 62, 62, 62, 62, 62, 62 },
        { -1, -1, 65, 65, 65, 65, 66, 67, 68, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 69, -1, 70, 71, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, 72, -1, -1, -1, -1, -1, -1, -1, -1, 72, -1, -1, -1, -1, 72, -1, 72, -1, -1, 73, 72, 72, 72, 72, 72, -1, 72, 72, 72, 72, 72, 72 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, 49, -1, -1, -1, -1, -1, -1, -1, -1, 49, -1, -1, -1, -1, 49, -1, 49, -1, -1, -1, 49, -1, -1, -1, -1, -1, 50, 50, 50, 50, 50, 50 }
    };

    int[][] PRODUCTIONS = 
    {
        { 16, 17, 27, 43, 53, 44, 28 },
        {  0 },
        { 46, 43 },
        { 65, 45 },
        {  0 },
        { 44 },
        { 17, 48, 49, 27, 53, 47, 21, 66, 26, 28 },
        {  0 },
        { 65, 47 },
        {  3 },
        {  4 },
        {  5 },
        {  6 },
        { 25, 50 },
        {  0 },
        { 48, 51 },
        {  0 },
        { 24, 50 },
        { 25, 50, 26 },
        {  0 },
        { 52, 53 },
        { 48, 35, 66, 26 },
        { 13, 29, 50, 30, 26 },
        { 20, 29, 57, 30, 26 },
        { 66, 58 },
        {  0 },
        { 24, 57 },
        { 15, 25, 27, 44, 28 },
        { 14, 25, 27, 44, 28 },
        {  0 },
        { 60 },
        { 12, 29, 66, 30, 59, 61 },
        { 59 },
        { 60 },
        { 23, 29, 66, 30, 63 },
        { 54 },
        { 55 },
        { 56 },
        { 62 },
        { 64 },
        { 68, 67 },
        {  0 },
        { 19, 68, 67 },
        { 10, 68, 67 },
        { 69 },
        { 22 },
        { 11 },
        { 18, 68 },
        { 70, 77 },
        {  0 },
        { 72, 70 },
        { 36 },
        { 37 },
        { 38 },
        { 39 },
        { 40 },
        { 41 },
        { 73, 71 },
        {  0 },
        { 31, 73, 71 },
        { 32, 73, 71 },
        { 75, 74 },
        {  0 },
        { 33, 75, 74 },
        { 34, 75, 74 },
        { 48, 76 },
        {  7 },
        {  8 },
        {  9 },
        { 29, 66, 30 },
        { 31, 75 },
        { 32, 75 },
        {  0 },
        { 29, 57, 30 }
    };

    String[] PARSER_ERROR =
    {
        "",
        "fim de programa", //"era esperado fim de programa",
        "palavra reservada", //"era esperado palavra_reservada",
        "identificador", //"era esperado id_int",
        "identificador", //"era esperado id_float",
        "identificador", //"era esperado id_string",
        "identificador", //"era esperado id_bool",
        "constante inteira", //"era esperado const_int",
        "constante real", //"era esperado const_float",
        "constante literal", //"era esperado const_string",
        "and", //"era esperado and",
        "false", //"era esperado false",
        "if", //"era esperado if",
        "in", //"era esperado in",
        "isFalseDo", //"era esperado isFalseDo",
        "isTrueDo", //"era esperado isTrueDo",
        "main", //"era esperado main",
        "module", //"era esperado module",
        "not", //"era esperado not",
        "or", //"era esperado or",
        "out", //"era esperado out",
        "return", //"era esperado return",
        "true", //"era esperado true",
        "while", //"era esperado while",
        ",", //"era esperado \",\"",
        ":", //"era esperado \":\"",
        ";", //"era esperado \";\"",
        "[", //"era esperado \"[\"",
        "]", //"era esperado \"]\"",
        "(", //"era esperado \"(\"",
        ")", //"era esperado \")\"",
        "+", //"era esperado \"+\"",
        "-", //"era esperado \"-\"",
        "*", //"era esperado \"*\"",
        "/", //"era esperado \"/\"",
        "<-", //"era esperado \"<-\"",
        "=", //"era esperado \"=\"",
        "!=", //"era esperado \"!=\"",
        "<", //"era esperado \"<\"",
        "<=", //"era esperado \"<=\"",
        ">", //"era esperado \">\"",
        ">=", //"era esperado \">=\"",
        "main", //"<main_module> inv?lido",
        "module", //"<lista_de_modulos> inv?lido",
        "<-, in, out, if ou while", //"<lista_comandos> inv?lido",
        "<-, in, out, if ou while", //"<lista_comandos1> inv?lido",
        "module", //"<modulo> inv?lido",
        "<-, in, out, if ou while", //"<lista_cmd_mod> inv?lido",
        "identificador", //"<identificador> inv?lido",
        ":", //"<parametros> inv?lido",
        "identificador", //"<lista_de_identificadores> inv?lido",
        ",", //"<lista_de_identificadores1> inv?lido",
        ":", //"<declaracao_variavel> inv?lido",
        ":", //"<lista_de_variaveis> inv?lido",
        "<-", //"<atribuicao> inv?lido",
        "in", //"<entrada> inv?lido",
        "out", //"<saida> inv?lido",
        "express�o", //"<lista_de_expressoes> inv?lido",
        "express�o", //"<lista_de_expressoes1> inv?lido",
        "isTrueDo", //"<true_do> inv?lido",
        "isFalseDo", //"<false_do> inv?lido",
        "isFalseDo", //"<false_do_op> inv?lido",
        "if", //"<if> inv?lido",
        "isTrueDo ou isFalseDo", //"<true_or_false_do> inv?lido",
        "while", //"<while> inv?lido",
        "<-, in, out, if ou while", //"<comando> inv?lido",
        "express�o", //"<expressao> inv?lido",
        "express�o", //"<expressao1> inv?lido",
        "express�o", //"<valor> inv?lido",
        "express�o", //"<relacional> inv?lido",
        "express�o", //"<aritmetica> inv?lido",
        "express�o", //"<aritmetica1> inv?lido",
        "express�o", //"<operador_relacional> inv?lido",
        "express�o", //"<termo> inv?lido",
        "express�o", //"<termo1> inv?lido",
        "express�o", //"<fator> inv?lido",
        "express�o", //"<fator1> inv?lido",
        "express�o", //"<relacional1> inv?lido"
    };
}
