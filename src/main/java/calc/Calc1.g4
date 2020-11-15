grammar Calc;
// 下面是语法
prog:   stat+ ;


stat:   expr ';'                # printExpr
    |   ID '=' expr ';'         # assign
    |   NEWLINE                 # blank
    ;


expr:   expr op=('*'|'/') expr      # MulDiv
    |   expr op=('+'|'-') expr      # AddSub
    |   INT                         # int
    |   ID                          # id
    |   '(' expr ')'                # parens
    ;
// 下面是词法
MUL :   '*' ;
DIV :   '/' ;
ADD :   '+' ;
SUB :   '-' ;
ID  :   [a-zA-Z]+ ;      // 匹配标识符
INT :   [0-9]+ ;         // 匹配整数
WS  :   [ \t]+ -> skip ; // 忽略空白符
NEWLINE:'\r'? '\n' ;     // 空行