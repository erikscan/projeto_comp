package org.xtext.java.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalJavaLexer extends Lexer {
    public static final int RULE_EXP=35;
    public static final int RULE_MINUS_EQUAL=20;
    public static final int RULE_PLUS_EQUAL=18;
    public static final int RULE_OR=33;
    public static final int RULE_WHILE=60;
    public static final int RULE_ID=7;
    public static final int RULE_EQUAL=10;
    public static final int RULE_MOD=54;
    public static final int RULE_RETURN=64;
    public static final int RULE_EOL=5;
    public static final int RULE_THIS=13;
    public static final int RULE_DOUBLE_OR_EQUAL=37;
    public static final int RULE_HEXA=46;
    public static final int RULE_COLON=39;
    public static final int RULE_ML_COMMENT=70;
    public static final int RULE_FALSE=53;
    public static final int RULE_WAT=38;
    public static final int RULE_IMPORT=69;
    public static final int RULE_DIVIDE=23;
    public static final int RULE_DECIMAL_DIGITS=45;
    public static final int RULE_DEFAULT=58;
    public static final int RULE_IF=62;
    public static final int RULE_STATIC=55;
    public static final int RULE_SUPER_SHIFT=43;
    public static final int RULE_EXCLAMATION=51;
    public static final int RULE_BT=27;
    public static final int RULE_SE=30;
    public static final int RULE_INSTANCEOF=14;
    public static final int RULE_MODULE_EQUAL=26;
    public static final int RULE_AMPERSAND=44;
    public static final int RULE_SWITCH=56;
    public static final int RULE_BE=29;
    public static final int RULE_DIFFERENT=32;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int RULE_NEW=49;
    public static final int T__90=90;
    public static final int RULE_CATCH=66;
    public static final int RULE_CHAR=48;
    public static final int RULE_ST=28;
    public static final int RULE_INCREMENT=15;
    public static final int RULE_L_SHIFT=41;
    public static final int RULE_SUPER=12;
    public static final int RULE_COMMA=9;
    public static final int RULE_EXTENDS=8;
    public static final int RULE_DOUBLE_EQUAL=31;
    public static final int RULE_INTERFACE=6;
    public static final int RULE_DOC_COMMENT=4;
    public static final int RULE_MULTIPLY=21;
    public static final int RULE_MULTIPLY_EQUAL=22;
    public static final int RULE_CASE=57;
    public static final int RULE_DO=61;
    public static final int RULE_FINALLY=67;
    public static final int RULE_PACKAGE=68;
    public static final int RULE_ELSE=63;
    public static final int RULE_R_SHIFT_EQUAL=40;
    public static final int RULE_R_SHIFT=42;
    public static final int RULE_EXP_EQUAL=36;
    public static final int RULE_STRING=47;
    public static final int RULE_NOT=50;
    public static final int RULE_NULL=11;
    public static final int RULE_OR_EQUAL=34;
    public static final int RULE_SL_COMMENT=71;
    public static final int RULE_DIVIDE_EQUAL=24;
    public static final int T__77=77;
    public static final int RULE_TRUE=52;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int RULE_PLUS=17;
    public static final int RULE_DECREMENT=16;
    public static final int RULE_FOR=59;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_TRY=65;
    public static final int RULE_WS=72;
    public static final int RULE_ANY_OTHER=73;
    public static final int RULE_MINUS=19;
    public static final int T__88=88;
    public static final int T__89=89;
    public static final int RULE_MODULE=25;
    public static final int T__84=84;
    public static final int T__85=85;
    public static final int T__86=86;
    public static final int T__87=87;

    // delegates
    // delegators

    public InternalJavaLexer() {;} 
    public InternalJavaLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalJavaLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalJava.g"; }

    // $ANTLR start "T__74"
    public final void mT__74() throws RecognitionException {
        try {
            int _type = T__74;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:11:7: ( '{' )
            // InternalJava.g:11:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__74"

    // $ANTLR start "T__75"
    public final void mT__75() throws RecognitionException {
        try {
            int _type = T__75;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:12:7: ( '}' )
            // InternalJava.g:12:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__75"

    // $ANTLR start "T__76"
    public final void mT__76() throws RecognitionException {
        try {
            int _type = T__76;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:13:7: ( 'class' )
            // InternalJava.g:13:9: 'class'
            {
            match("class"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__76"

    // $ANTLR start "T__77"
    public final void mT__77() throws RecognitionException {
        try {
            int _type = T__77;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:14:7: ( 'implements' )
            // InternalJava.g:14:9: 'implements'
            {
            match("implements"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__77"

    // $ANTLR start "T__78"
    public final void mT__78() throws RecognitionException {
        try {
            int _type = T__78;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:15:7: ( '(' )
            // InternalJava.g:15:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__78"

    // $ANTLR start "T__79"
    public final void mT__79() throws RecognitionException {
        try {
            int _type = T__79;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:16:7: ( ')' )
            // InternalJava.g:16:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__79"

    // $ANTLR start "T__80"
    public final void mT__80() throws RecognitionException {
        try {
            int _type = T__80;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:17:7: ( '[' )
            // InternalJava.g:17:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__80"

    // $ANTLR start "T__81"
    public final void mT__81() throws RecognitionException {
        try {
            int _type = T__81;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:18:7: ( ']' )
            // InternalJava.g:18:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__81"

    // $ANTLR start "T__82"
    public final void mT__82() throws RecognitionException {
        try {
            int _type = T__82;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:19:7: ( '[]' )
            // InternalJava.g:19:9: '[]'
            {
            match("[]"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__82"

    // $ANTLR start "T__83"
    public final void mT__83() throws RecognitionException {
        try {
            int _type = T__83;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:20:7: ( '.' )
            // InternalJava.g:20:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__83"

    // $ANTLR start "T__84"
    public final void mT__84() throws RecognitionException {
        try {
            int _type = T__84;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:21:7: ( 'boolean' )
            // InternalJava.g:21:9: 'boolean'
            {
            match("boolean"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__84"

    // $ANTLR start "T__85"
    public final void mT__85() throws RecognitionException {
        try {
            int _type = T__85;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:22:7: ( 'byte' )
            // InternalJava.g:22:9: 'byte'
            {
            match("byte"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__85"

    // $ANTLR start "T__86"
    public final void mT__86() throws RecognitionException {
        try {
            int _type = T__86;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:23:7: ( 'char' )
            // InternalJava.g:23:9: 'char'
            {
            match("char"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__86"

    // $ANTLR start "T__87"
    public final void mT__87() throws RecognitionException {
        try {
            int _type = T__87;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:24:7: ( 'short' )
            // InternalJava.g:24:9: 'short'
            {
            match("short"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__87"

    // $ANTLR start "T__88"
    public final void mT__88() throws RecognitionException {
        try {
            int _type = T__88;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:25:7: ( 'int' )
            // InternalJava.g:25:9: 'int'
            {
            match("int"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__88"

    // $ANTLR start "T__89"
    public final void mT__89() throws RecognitionException {
        try {
            int _type = T__89;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:26:7: ( 'float' )
            // InternalJava.g:26:9: 'float'
            {
            match("float"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__89"

    // $ANTLR start "T__90"
    public final void mT__90() throws RecognitionException {
        try {
            int _type = T__90;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:27:7: ( 'long' )
            // InternalJava.g:27:9: 'long'
            {
            match("long"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__90"

    // $ANTLR start "T__91"
    public final void mT__91() throws RecognitionException {
        try {
            int _type = T__91;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:28:7: ( 'double' )
            // InternalJava.g:28:9: 'double'
            {
            match("double"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__91"

    // $ANTLR start "T__92"
    public final void mT__92() throws RecognitionException {
        try {
            int _type = T__92;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:29:7: ( 'void' )
            // InternalJava.g:29:9: 'void'
            {
            match("void"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__92"

    // $ANTLR start "T__93"
    public final void mT__93() throws RecognitionException {
        try {
            int _type = T__93;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:30:7: ( 'break' )
            // InternalJava.g:30:9: 'break'
            {
            match("break"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__93"

    // $ANTLR start "T__94"
    public final void mT__94() throws RecognitionException {
        try {
            int _type = T__94;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:31:7: ( 'continue' )
            // InternalJava.g:31:9: 'continue'
            {
            match("continue"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__94"

    // $ANTLR start "RULE_INTERFACE"
    public final void mRULE_INTERFACE() throws RecognitionException {
        try {
            int _type = RULE_INTERFACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5454:16: ( 'interface' )
            // InternalJava.g:5454:18: 'interface'
            {
            match("interface"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INTERFACE"

    // $ANTLR start "RULE_EXTENDS"
    public final void mRULE_EXTENDS() throws RecognitionException {
        try {
            int _type = RULE_EXTENDS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5456:14: ( 'extends' )
            // InternalJava.g:5456:16: 'extends'
            {
            match("extends"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_EXTENDS"

    // $ANTLR start "RULE_COMMA"
    public final void mRULE_COMMA() throws RecognitionException {
        try {
            int _type = RULE_COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5458:12: ( ',' )
            // InternalJava.g:5458:14: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_COMMA"

    // $ANTLR start "RULE_EQUAL"
    public final void mRULE_EQUAL() throws RecognitionException {
        try {
            int _type = RULE_EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5460:12: ( '=' )
            // InternalJava.g:5460:14: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_EQUAL"

    // $ANTLR start "RULE_NULL"
    public final void mRULE_NULL() throws RecognitionException {
        try {
            int _type = RULE_NULL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5462:11: ( 'NULL' )
            // InternalJava.g:5462:13: 'NULL'
            {
            match("NULL"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_NULL"

    // $ANTLR start "RULE_THIS"
    public final void mRULE_THIS() throws RecognitionException {
        try {
            int _type = RULE_THIS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5464:11: ( 'this' )
            // InternalJava.g:5464:13: 'this'
            {
            match("this"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_THIS"

    // $ANTLR start "RULE_SUPER"
    public final void mRULE_SUPER() throws RecognitionException {
        try {
            int _type = RULE_SUPER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5466:12: ( 'super' )
            // InternalJava.g:5466:14: 'super'
            {
            match("super"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SUPER"

    // $ANTLR start "RULE_INSTANCEOF"
    public final void mRULE_INSTANCEOF() throws RecognitionException {
        try {
            int _type = RULE_INSTANCEOF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5468:17: ( 'instanceof' )
            // InternalJava.g:5468:19: 'instanceof'
            {
            match("instanceof"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INSTANCEOF"

    // $ANTLR start "RULE_L_SHIFT"
    public final void mRULE_L_SHIFT() throws RecognitionException {
        try {
            int _type = RULE_L_SHIFT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5470:14: ( '<<' )
            // InternalJava.g:5470:16: '<<'
            {
            match("<<"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_L_SHIFT"

    // $ANTLR start "RULE_R_SHIFT"
    public final void mRULE_R_SHIFT() throws RecognitionException {
        try {
            int _type = RULE_R_SHIFT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5472:14: ( '>>' )
            // InternalJava.g:5472:16: '>>'
            {
            match(">>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_R_SHIFT"

    // $ANTLR start "RULE_SUPER_SHIFT"
    public final void mRULE_SUPER_SHIFT() throws RecognitionException {
        try {
            int _type = RULE_SUPER_SHIFT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5474:18: ( '>>>' )
            // InternalJava.g:5474:20: '>>>'
            {
            match(">>>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SUPER_SHIFT"

    // $ANTLR start "RULE_R_SHIFT_EQUAL"
    public final void mRULE_R_SHIFT_EQUAL() throws RecognitionException {
        try {
            int _type = RULE_R_SHIFT_EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5476:20: ( '>>=' )
            // InternalJava.g:5476:22: '>>='
            {
            match(">>="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_R_SHIFT_EQUAL"

    // $ANTLR start "RULE_DOUBLE_OR_EQUAL"
    public final void mRULE_DOUBLE_OR_EQUAL() throws RecognitionException {
        try {
            int _type = RULE_DOUBLE_OR_EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5478:22: ( '||=' )
            // InternalJava.g:5478:24: '||='
            {
            match("||="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_DOUBLE_OR_EQUAL"

    // $ANTLR start "RULE_OR"
    public final void mRULE_OR() throws RecognitionException {
        try {
            int _type = RULE_OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5480:9: ( '|' )
            // InternalJava.g:5480:11: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_OR"

    // $ANTLR start "RULE_OR_EQUAL"
    public final void mRULE_OR_EQUAL() throws RecognitionException {
        try {
            int _type = RULE_OR_EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5482:15: ( '|=' )
            // InternalJava.g:5482:17: '|='
            {
            match("|="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_OR_EQUAL"

    // $ANTLR start "RULE_EXP"
    public final void mRULE_EXP() throws RecognitionException {
        try {
            int _type = RULE_EXP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5484:10: ( '^' )
            // InternalJava.g:5484:12: '^'
            {
            match('^'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_EXP"

    // $ANTLR start "RULE_EXP_EQUAL"
    public final void mRULE_EXP_EQUAL() throws RecognitionException {
        try {
            int _type = RULE_EXP_EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5486:16: ( '^=' )
            // InternalJava.g:5486:18: '^='
            {
            match("^="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_EXP_EQUAL"

    // $ANTLR start "RULE_DOUBLE_EQUAL"
    public final void mRULE_DOUBLE_EQUAL() throws RecognitionException {
        try {
            int _type = RULE_DOUBLE_EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5488:19: ( '==' )
            // InternalJava.g:5488:21: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_DOUBLE_EQUAL"

    // $ANTLR start "RULE_DIFFERENT"
    public final void mRULE_DIFFERENT() throws RecognitionException {
        try {
            int _type = RULE_DIFFERENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5490:16: ( '!=' )
            // InternalJava.g:5490:18: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_DIFFERENT"

    // $ANTLR start "RULE_BT"
    public final void mRULE_BT() throws RecognitionException {
        try {
            int _type = RULE_BT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5492:9: ( '>' )
            // InternalJava.g:5492:11: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BT"

    // $ANTLR start "RULE_ST"
    public final void mRULE_ST() throws RecognitionException {
        try {
            int _type = RULE_ST;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5494:9: ( '<' )
            // InternalJava.g:5494:11: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ST"

    // $ANTLR start "RULE_BE"
    public final void mRULE_BE() throws RecognitionException {
        try {
            int _type = RULE_BE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5496:9: ( '>=' )
            // InternalJava.g:5496:11: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BE"

    // $ANTLR start "RULE_SE"
    public final void mRULE_SE() throws RecognitionException {
        try {
            int _type = RULE_SE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5498:9: ( '<=' )
            // InternalJava.g:5498:11: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SE"

    // $ANTLR start "RULE_DIVIDE"
    public final void mRULE_DIVIDE() throws RecognitionException {
        try {
            int _type = RULE_DIVIDE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5500:13: ( '/' )
            // InternalJava.g:5500:15: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_DIVIDE"

    // $ANTLR start "RULE_DIVIDE_EQUAL"
    public final void mRULE_DIVIDE_EQUAL() throws RecognitionException {
        try {
            int _type = RULE_DIVIDE_EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5502:19: ( '/=' )
            // InternalJava.g:5502:21: '/='
            {
            match("/="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_DIVIDE_EQUAL"

    // $ANTLR start "RULE_MODULE"
    public final void mRULE_MODULE() throws RecognitionException {
        try {
            int _type = RULE_MODULE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5504:13: ( '%' )
            // InternalJava.g:5504:15: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_MODULE"

    // $ANTLR start "RULE_MODULE_EQUAL"
    public final void mRULE_MODULE_EQUAL() throws RecognitionException {
        try {
            int _type = RULE_MODULE_EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5506:19: ( '%=' )
            // InternalJava.g:5506:21: '%='
            {
            match("%="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_MODULE_EQUAL"

    // $ANTLR start "RULE_PLUS_EQUAL"
    public final void mRULE_PLUS_EQUAL() throws RecognitionException {
        try {
            int _type = RULE_PLUS_EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5508:17: ( '+=' )
            // InternalJava.g:5508:19: '+='
            {
            match("+="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_PLUS_EQUAL"

    // $ANTLR start "RULE_MINUS_EQUAL"
    public final void mRULE_MINUS_EQUAL() throws RecognitionException {
        try {
            int _type = RULE_MINUS_EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5510:18: ( '-=' )
            // InternalJava.g:5510:20: '-='
            {
            match("-="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_MINUS_EQUAL"

    // $ANTLR start "RULE_MULTIPLY"
    public final void mRULE_MULTIPLY() throws RecognitionException {
        try {
            int _type = RULE_MULTIPLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5512:15: ( '*' )
            // InternalJava.g:5512:17: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_MULTIPLY"

    // $ANTLR start "RULE_MULTIPLY_EQUAL"
    public final void mRULE_MULTIPLY_EQUAL() throws RecognitionException {
        try {
            int _type = RULE_MULTIPLY_EQUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5514:21: ( '*=' )
            // InternalJava.g:5514:23: '*='
            {
            match("*="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_MULTIPLY_EQUAL"

    // $ANTLR start "RULE_WAT"
    public final void mRULE_WAT() throws RecognitionException {
        try {
            int _type = RULE_WAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5516:10: ( '?' )
            // InternalJava.g:5516:12: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WAT"

    // $ANTLR start "RULE_AMPERSAND"
    public final void mRULE_AMPERSAND() throws RecognitionException {
        try {
            int _type = RULE_AMPERSAND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5518:16: ( 'ampersand' )
            // InternalJava.g:5518:18: 'ampersand'
            {
            match("ampersand"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_AMPERSAND"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5520:13: ( '\"' ( options {greedy=false; } : . )* '\"' )
            // InternalJava.g:5520:15: '\"' ( options {greedy=false; } : . )* '\"'
            {
            match('\"'); 
            // InternalJava.g:5520:19: ( options {greedy=false; } : . )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='\"') ) {
                    alt1=2;
                }
                else if ( ((LA1_0>='\u0000' && LA1_0<='!')||(LA1_0>='#' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalJava.g:5520:47: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_COLON"
    public final void mRULE_COLON() throws RecognitionException {
        try {
            int _type = RULE_COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5522:12: ( ':' )
            // InternalJava.g:5522:14: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_COLON"

    // $ANTLR start "RULE_NEW"
    public final void mRULE_NEW() throws RecognitionException {
        try {
            int _type = RULE_NEW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5524:10: ( 'new' )
            // InternalJava.g:5524:12: 'new'
            {
            match("new"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_NEW"

    // $ANTLR start "RULE_NOT"
    public final void mRULE_NOT() throws RecognitionException {
        try {
            int _type = RULE_NOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5526:10: ( '~' )
            // InternalJava.g:5526:12: '~'
            {
            match('~'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_NOT"

    // $ANTLR start "RULE_EXCLAMATION"
    public final void mRULE_EXCLAMATION() throws RecognitionException {
        try {
            int _type = RULE_EXCLAMATION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5528:18: ( '!' )
            // InternalJava.g:5528:20: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_EXCLAMATION"

    // $ANTLR start "RULE_FALSE"
    public final void mRULE_FALSE() throws RecognitionException {
        try {
            int _type = RULE_FALSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5530:12: ( 'false' )
            // InternalJava.g:5530:14: 'false'
            {
            match("false"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_FALSE"

    // $ANTLR start "RULE_TRUE"
    public final void mRULE_TRUE() throws RecognitionException {
        try {
            int _type = RULE_TRUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5532:11: ( 'true' )
            // InternalJava.g:5532:13: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_TRUE"

    // $ANTLR start "RULE_DECREMENT"
    public final void mRULE_DECREMENT() throws RecognitionException {
        try {
            int _type = RULE_DECREMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5534:16: ( '--' )
            // InternalJava.g:5534:18: '--'
            {
            match("--"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_DECREMENT"

    // $ANTLR start "RULE_INCREMENT"
    public final void mRULE_INCREMENT() throws RecognitionException {
        try {
            int _type = RULE_INCREMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5536:16: ( '++' )
            // InternalJava.g:5536:18: '++'
            {
            match("++"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INCREMENT"

    // $ANTLR start "RULE_STATIC"
    public final void mRULE_STATIC() throws RecognitionException {
        try {
            int _type = RULE_STATIC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5538:13: ( 'static' )
            // InternalJava.g:5538:15: 'static'
            {
            match("static"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STATIC"

    // $ANTLR start "RULE_DEFAULT"
    public final void mRULE_DEFAULT() throws RecognitionException {
        try {
            int _type = RULE_DEFAULT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5540:14: ( 'default' )
            // InternalJava.g:5540:16: 'default'
            {
            match("default"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_DEFAULT"

    // $ANTLR start "RULE_CASE"
    public final void mRULE_CASE() throws RecognitionException {
        try {
            int _type = RULE_CASE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5542:11: ( 'case' )
            // InternalJava.g:5542:13: 'case'
            {
            match("case"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_CASE"

    // $ANTLR start "RULE_SWITCH"
    public final void mRULE_SWITCH() throws RecognitionException {
        try {
            int _type = RULE_SWITCH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5544:13: ( 'switch' )
            // InternalJava.g:5544:15: 'switch'
            {
            match("switch"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SWITCH"

    // $ANTLR start "RULE_FOR"
    public final void mRULE_FOR() throws RecognitionException {
        try {
            int _type = RULE_FOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5546:10: ( 'for' )
            // InternalJava.g:5546:12: 'for'
            {
            match("for"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_FOR"

    // $ANTLR start "RULE_RETURN"
    public final void mRULE_RETURN() throws RecognitionException {
        try {
            int _type = RULE_RETURN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5548:13: ( 'return' )
            // InternalJava.g:5548:15: 'return'
            {
            match("return"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_RETURN"

    // $ANTLR start "RULE_EOL"
    public final void mRULE_EOL() throws RecognitionException {
        try {
            int _type = RULE_EOL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5550:10: ( ';' )
            // InternalJava.g:5550:12: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_EOL"

    // $ANTLR start "RULE_IF"
    public final void mRULE_IF() throws RecognitionException {
        try {
            int _type = RULE_IF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5552:9: ( 'if' )
            // InternalJava.g:5552:11: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_IF"

    // $ANTLR start "RULE_ELSE"
    public final void mRULE_ELSE() throws RecognitionException {
        try {
            int _type = RULE_ELSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5554:11: ( 'else' )
            // InternalJava.g:5554:13: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ELSE"

    // $ANTLR start "RULE_DO"
    public final void mRULE_DO() throws RecognitionException {
        try {
            int _type = RULE_DO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5556:9: ( 'do' )
            // InternalJava.g:5556:11: 'do'
            {
            match("do"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_DO"

    // $ANTLR start "RULE_WHILE"
    public final void mRULE_WHILE() throws RecognitionException {
        try {
            int _type = RULE_WHILE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5558:12: ( 'while' )
            // InternalJava.g:5558:14: 'while'
            {
            match("while"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WHILE"

    // $ANTLR start "RULE_PACKAGE"
    public final void mRULE_PACKAGE() throws RecognitionException {
        try {
            int _type = RULE_PACKAGE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5560:14: ( 'package' )
            // InternalJava.g:5560:16: 'package'
            {
            match("package"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_PACKAGE"

    // $ANTLR start "RULE_IMPORT"
    public final void mRULE_IMPORT() throws RecognitionException {
        try {
            int _type = RULE_IMPORT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5562:13: ( 'import' )
            // InternalJava.g:5562:15: 'import'
            {
            match("import"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_IMPORT"

    // $ANTLR start "RULE_CHAR"
    public final void mRULE_CHAR() throws RecognitionException {
        try {
            int _type = RULE_CHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5564:11: ( '\\'' . '\\'' )
            // InternalJava.g:5564:13: '\\'' . '\\''
            {
            match('\''); 
            matchAny(); 
            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_CHAR"

    // $ANTLR start "RULE_PLUS"
    public final void mRULE_PLUS() throws RecognitionException {
        try {
            int _type = RULE_PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5566:11: ( '+' )
            // InternalJava.g:5566:13: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_PLUS"

    // $ANTLR start "RULE_MINUS"
    public final void mRULE_MINUS() throws RecognitionException {
        try {
            int _type = RULE_MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5568:12: ( '-' )
            // InternalJava.g:5568:14: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_MINUS"

    // $ANTLR start "RULE_MOD"
    public final void mRULE_MOD() throws RecognitionException {
        try {
            int _type = RULE_MOD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5570:10: ( ( 'public' | 'private' | 'protected' | 'final' | 'native' | 'synchronized' | 'abstract' | 'threadsafe' | 'transient' ) )
            // InternalJava.g:5570:12: ( 'public' | 'private' | 'protected' | 'final' | 'native' | 'synchronized' | 'abstract' | 'threadsafe' | 'transient' )
            {
            // InternalJava.g:5570:12: ( 'public' | 'private' | 'protected' | 'final' | 'native' | 'synchronized' | 'abstract' | 'threadsafe' | 'transient' )
            int alt2=9;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // InternalJava.g:5570:13: 'public'
                    {
                    match("public"); 


                    }
                    break;
                case 2 :
                    // InternalJava.g:5570:22: 'private'
                    {
                    match("private"); 


                    }
                    break;
                case 3 :
                    // InternalJava.g:5570:32: 'protected'
                    {
                    match("protected"); 


                    }
                    break;
                case 4 :
                    // InternalJava.g:5570:44: 'final'
                    {
                    match("final"); 


                    }
                    break;
                case 5 :
                    // InternalJava.g:5570:52: 'native'
                    {
                    match("native"); 


                    }
                    break;
                case 6 :
                    // InternalJava.g:5570:61: 'synchronized'
                    {
                    match("synchronized"); 


                    }
                    break;
                case 7 :
                    // InternalJava.g:5570:76: 'abstract'
                    {
                    match("abstract"); 


                    }
                    break;
                case 8 :
                    // InternalJava.g:5570:87: 'threadsafe'
                    {
                    match("threadsafe"); 


                    }
                    break;
                case 9 :
                    // InternalJava.g:5570:100: 'transient'
                    {
                    match("transient"); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_MOD"

    // $ANTLR start "RULE_TRY"
    public final void mRULE_TRY() throws RecognitionException {
        try {
            int _type = RULE_TRY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5572:10: ( 'try' )
            // InternalJava.g:5572:12: 'try'
            {
            match("try"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_TRY"

    // $ANTLR start "RULE_CATCH"
    public final void mRULE_CATCH() throws RecognitionException {
        try {
            int _type = RULE_CATCH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5574:12: ( 'catch' )
            // InternalJava.g:5574:14: 'catch'
            {
            match("catch"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_CATCH"

    // $ANTLR start "RULE_FINALLY"
    public final void mRULE_FINALLY() throws RecognitionException {
        try {
            int _type = RULE_FINALLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5576:14: ( 'finally' )
            // InternalJava.g:5576:16: 'finally'
            {
            match("finally"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_FINALLY"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5578:9: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '$' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' | '$' | '\\u00C0' .. '\\uFFFF' )* )
            // InternalJava.g:5578:11: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '$' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' | '$' | '\\u00C0' .. '\\uFFFF' )*
            {
            if ( input.LA(1)=='$'||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalJava.g:5578:39: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' | '$' | '\\u00C0' .. '\\uFFFF' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='$'||(LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')||(LA3_0>='\u00C0' && LA3_0<='\uFFFF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalJava.g:
            	    {
            	    if ( input.LA(1)=='$'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||(input.LA(1)>='\u00C0' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_HEXA"
    public final void mRULE_HEXA() throws RecognitionException {
        try {
            int _type = RULE_HEXA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5580:11: ( '0' 'x' ( '0' .. '9' 'a' .. 'f' )* )
            // InternalJava.g:5580:13: '0' 'x' ( '0' .. '9' 'a' .. 'f' )*
            {
            match('0'); 
            match('x'); 
            // InternalJava.g:5580:21: ( '0' .. '9' 'a' .. 'f' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalJava.g:5580:22: '0' .. '9' 'a' .. 'f'
            	    {
            	    matchRange('0','9'); 
            	    matchRange('a','f'); 

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_HEXA"

    // $ANTLR start "RULE_DECIMAL_DIGITS"
    public final void mRULE_DECIMAL_DIGITS() throws RecognitionException {
        try {
            int _type = RULE_DECIMAL_DIGITS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5582:21: ( ( '0' .. '9' )+ )
            // InternalJava.g:5582:23: ( '0' .. '9' )+
            {
            // InternalJava.g:5582:23: ( '0' .. '9' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalJava.g:5582:24: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_DECIMAL_DIGITS"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5584:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalJava.g:5584:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalJava.g:5584:24: ( options {greedy=false; } : . )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='*') ) {
                    int LA6_1 = input.LA(2);

                    if ( (LA6_1=='/') ) {
                        alt6=2;
                    }
                    else if ( ((LA6_1>='\u0000' && LA6_1<='.')||(LA6_1>='0' && LA6_1<='\uFFFF')) ) {
                        alt6=1;
                    }


                }
                else if ( ((LA6_0>='\u0000' && LA6_0<=')')||(LA6_0>='+' && LA6_0<='\uFFFF')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalJava.g:5584:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5586:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalJava.g:5586:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalJava.g:5586:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='\u0000' && LA7_0<='\t')||(LA7_0>='\u000B' && LA7_0<='\f')||(LA7_0>='\u000E' && LA7_0<='\uFFFF')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalJava.g:5586:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            // InternalJava.g:5586:40: ( ( '\\r' )? '\\n' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='\n'||LA9_0=='\r') ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalJava.g:5586:41: ( '\\r' )? '\\n'
                    {
                    // InternalJava.g:5586:41: ( '\\r' )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0=='\r') ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // InternalJava.g:5586:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5588:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalJava.g:5588:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalJava.g:5588:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='\t' && LA10_0<='\n')||LA10_0=='\r'||LA10_0==' ') ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalJava.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5590:16: ( . )
            // InternalJava.g:5590:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    // $ANTLR start "RULE_DOC_COMMENT"
    public final void mRULE_DOC_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_DOC_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalJava.g:5592:18: ( '/**' )
            // InternalJava.g:5592:20: '/**'
            {
            match("/**"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_DOC_COMMENT"

    public void mTokens() throws RecognitionException {
        // InternalJava.g:1:8: ( T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | RULE_INTERFACE | RULE_EXTENDS | RULE_COMMA | RULE_EQUAL | RULE_NULL | RULE_THIS | RULE_SUPER | RULE_INSTANCEOF | RULE_L_SHIFT | RULE_R_SHIFT | RULE_SUPER_SHIFT | RULE_R_SHIFT_EQUAL | RULE_DOUBLE_OR_EQUAL | RULE_OR | RULE_OR_EQUAL | RULE_EXP | RULE_EXP_EQUAL | RULE_DOUBLE_EQUAL | RULE_DIFFERENT | RULE_BT | RULE_ST | RULE_BE | RULE_SE | RULE_DIVIDE | RULE_DIVIDE_EQUAL | RULE_MODULE | RULE_MODULE_EQUAL | RULE_PLUS_EQUAL | RULE_MINUS_EQUAL | RULE_MULTIPLY | RULE_MULTIPLY_EQUAL | RULE_WAT | RULE_AMPERSAND | RULE_STRING | RULE_COLON | RULE_NEW | RULE_NOT | RULE_EXCLAMATION | RULE_FALSE | RULE_TRUE | RULE_DECREMENT | RULE_INCREMENT | RULE_STATIC | RULE_DEFAULT | RULE_CASE | RULE_SWITCH | RULE_FOR | RULE_RETURN | RULE_EOL | RULE_IF | RULE_ELSE | RULE_DO | RULE_WHILE | RULE_PACKAGE | RULE_IMPORT | RULE_CHAR | RULE_PLUS | RULE_MINUS | RULE_MOD | RULE_TRY | RULE_CATCH | RULE_FINALLY | RULE_ID | RULE_HEXA | RULE_DECIMAL_DIGITS | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER | RULE_DOC_COMMENT )
        int alt11=91;
        alt11 = dfa11.predict(input);
        switch (alt11) {
            case 1 :
                // InternalJava.g:1:10: T__74
                {
                mT__74(); 

                }
                break;
            case 2 :
                // InternalJava.g:1:16: T__75
                {
                mT__75(); 

                }
                break;
            case 3 :
                // InternalJava.g:1:22: T__76
                {
                mT__76(); 

                }
                break;
            case 4 :
                // InternalJava.g:1:28: T__77
                {
                mT__77(); 

                }
                break;
            case 5 :
                // InternalJava.g:1:34: T__78
                {
                mT__78(); 

                }
                break;
            case 6 :
                // InternalJava.g:1:40: T__79
                {
                mT__79(); 

                }
                break;
            case 7 :
                // InternalJava.g:1:46: T__80
                {
                mT__80(); 

                }
                break;
            case 8 :
                // InternalJava.g:1:52: T__81
                {
                mT__81(); 

                }
                break;
            case 9 :
                // InternalJava.g:1:58: T__82
                {
                mT__82(); 

                }
                break;
            case 10 :
                // InternalJava.g:1:64: T__83
                {
                mT__83(); 

                }
                break;
            case 11 :
                // InternalJava.g:1:70: T__84
                {
                mT__84(); 

                }
                break;
            case 12 :
                // InternalJava.g:1:76: T__85
                {
                mT__85(); 

                }
                break;
            case 13 :
                // InternalJava.g:1:82: T__86
                {
                mT__86(); 

                }
                break;
            case 14 :
                // InternalJava.g:1:88: T__87
                {
                mT__87(); 

                }
                break;
            case 15 :
                // InternalJava.g:1:94: T__88
                {
                mT__88(); 

                }
                break;
            case 16 :
                // InternalJava.g:1:100: T__89
                {
                mT__89(); 

                }
                break;
            case 17 :
                // InternalJava.g:1:106: T__90
                {
                mT__90(); 

                }
                break;
            case 18 :
                // InternalJava.g:1:112: T__91
                {
                mT__91(); 

                }
                break;
            case 19 :
                // InternalJava.g:1:118: T__92
                {
                mT__92(); 

                }
                break;
            case 20 :
                // InternalJava.g:1:124: T__93
                {
                mT__93(); 

                }
                break;
            case 21 :
                // InternalJava.g:1:130: T__94
                {
                mT__94(); 

                }
                break;
            case 22 :
                // InternalJava.g:1:136: RULE_INTERFACE
                {
                mRULE_INTERFACE(); 

                }
                break;
            case 23 :
                // InternalJava.g:1:151: RULE_EXTENDS
                {
                mRULE_EXTENDS(); 

                }
                break;
            case 24 :
                // InternalJava.g:1:164: RULE_COMMA
                {
                mRULE_COMMA(); 

                }
                break;
            case 25 :
                // InternalJava.g:1:175: RULE_EQUAL
                {
                mRULE_EQUAL(); 

                }
                break;
            case 26 :
                // InternalJava.g:1:186: RULE_NULL
                {
                mRULE_NULL(); 

                }
                break;
            case 27 :
                // InternalJava.g:1:196: RULE_THIS
                {
                mRULE_THIS(); 

                }
                break;
            case 28 :
                // InternalJava.g:1:206: RULE_SUPER
                {
                mRULE_SUPER(); 

                }
                break;
            case 29 :
                // InternalJava.g:1:217: RULE_INSTANCEOF
                {
                mRULE_INSTANCEOF(); 

                }
                break;
            case 30 :
                // InternalJava.g:1:233: RULE_L_SHIFT
                {
                mRULE_L_SHIFT(); 

                }
                break;
            case 31 :
                // InternalJava.g:1:246: RULE_R_SHIFT
                {
                mRULE_R_SHIFT(); 

                }
                break;
            case 32 :
                // InternalJava.g:1:259: RULE_SUPER_SHIFT
                {
                mRULE_SUPER_SHIFT(); 

                }
                break;
            case 33 :
                // InternalJava.g:1:276: RULE_R_SHIFT_EQUAL
                {
                mRULE_R_SHIFT_EQUAL(); 

                }
                break;
            case 34 :
                // InternalJava.g:1:295: RULE_DOUBLE_OR_EQUAL
                {
                mRULE_DOUBLE_OR_EQUAL(); 

                }
                break;
            case 35 :
                // InternalJava.g:1:316: RULE_OR
                {
                mRULE_OR(); 

                }
                break;
            case 36 :
                // InternalJava.g:1:324: RULE_OR_EQUAL
                {
                mRULE_OR_EQUAL(); 

                }
                break;
            case 37 :
                // InternalJava.g:1:338: RULE_EXP
                {
                mRULE_EXP(); 

                }
                break;
            case 38 :
                // InternalJava.g:1:347: RULE_EXP_EQUAL
                {
                mRULE_EXP_EQUAL(); 

                }
                break;
            case 39 :
                // InternalJava.g:1:362: RULE_DOUBLE_EQUAL
                {
                mRULE_DOUBLE_EQUAL(); 

                }
                break;
            case 40 :
                // InternalJava.g:1:380: RULE_DIFFERENT
                {
                mRULE_DIFFERENT(); 

                }
                break;
            case 41 :
                // InternalJava.g:1:395: RULE_BT
                {
                mRULE_BT(); 

                }
                break;
            case 42 :
                // InternalJava.g:1:403: RULE_ST
                {
                mRULE_ST(); 

                }
                break;
            case 43 :
                // InternalJava.g:1:411: RULE_BE
                {
                mRULE_BE(); 

                }
                break;
            case 44 :
                // InternalJava.g:1:419: RULE_SE
                {
                mRULE_SE(); 

                }
                break;
            case 45 :
                // InternalJava.g:1:427: RULE_DIVIDE
                {
                mRULE_DIVIDE(); 

                }
                break;
            case 46 :
                // InternalJava.g:1:439: RULE_DIVIDE_EQUAL
                {
                mRULE_DIVIDE_EQUAL(); 

                }
                break;
            case 47 :
                // InternalJava.g:1:457: RULE_MODULE
                {
                mRULE_MODULE(); 

                }
                break;
            case 48 :
                // InternalJava.g:1:469: RULE_MODULE_EQUAL
                {
                mRULE_MODULE_EQUAL(); 

                }
                break;
            case 49 :
                // InternalJava.g:1:487: RULE_PLUS_EQUAL
                {
                mRULE_PLUS_EQUAL(); 

                }
                break;
            case 50 :
                // InternalJava.g:1:503: RULE_MINUS_EQUAL
                {
                mRULE_MINUS_EQUAL(); 

                }
                break;
            case 51 :
                // InternalJava.g:1:520: RULE_MULTIPLY
                {
                mRULE_MULTIPLY(); 

                }
                break;
            case 52 :
                // InternalJava.g:1:534: RULE_MULTIPLY_EQUAL
                {
                mRULE_MULTIPLY_EQUAL(); 

                }
                break;
            case 53 :
                // InternalJava.g:1:554: RULE_WAT
                {
                mRULE_WAT(); 

                }
                break;
            case 54 :
                // InternalJava.g:1:563: RULE_AMPERSAND
                {
                mRULE_AMPERSAND(); 

                }
                break;
            case 55 :
                // InternalJava.g:1:578: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 56 :
                // InternalJava.g:1:590: RULE_COLON
                {
                mRULE_COLON(); 

                }
                break;
            case 57 :
                // InternalJava.g:1:601: RULE_NEW
                {
                mRULE_NEW(); 

                }
                break;
            case 58 :
                // InternalJava.g:1:610: RULE_NOT
                {
                mRULE_NOT(); 

                }
                break;
            case 59 :
                // InternalJava.g:1:619: RULE_EXCLAMATION
                {
                mRULE_EXCLAMATION(); 

                }
                break;
            case 60 :
                // InternalJava.g:1:636: RULE_FALSE
                {
                mRULE_FALSE(); 

                }
                break;
            case 61 :
                // InternalJava.g:1:647: RULE_TRUE
                {
                mRULE_TRUE(); 

                }
                break;
            case 62 :
                // InternalJava.g:1:657: RULE_DECREMENT
                {
                mRULE_DECREMENT(); 

                }
                break;
            case 63 :
                // InternalJava.g:1:672: RULE_INCREMENT
                {
                mRULE_INCREMENT(); 

                }
                break;
            case 64 :
                // InternalJava.g:1:687: RULE_STATIC
                {
                mRULE_STATIC(); 

                }
                break;
            case 65 :
                // InternalJava.g:1:699: RULE_DEFAULT
                {
                mRULE_DEFAULT(); 

                }
                break;
            case 66 :
                // InternalJava.g:1:712: RULE_CASE
                {
                mRULE_CASE(); 

                }
                break;
            case 67 :
                // InternalJava.g:1:722: RULE_SWITCH
                {
                mRULE_SWITCH(); 

                }
                break;
            case 68 :
                // InternalJava.g:1:734: RULE_FOR
                {
                mRULE_FOR(); 

                }
                break;
            case 69 :
                // InternalJava.g:1:743: RULE_RETURN
                {
                mRULE_RETURN(); 

                }
                break;
            case 70 :
                // InternalJava.g:1:755: RULE_EOL
                {
                mRULE_EOL(); 

                }
                break;
            case 71 :
                // InternalJava.g:1:764: RULE_IF
                {
                mRULE_IF(); 

                }
                break;
            case 72 :
                // InternalJava.g:1:772: RULE_ELSE
                {
                mRULE_ELSE(); 

                }
                break;
            case 73 :
                // InternalJava.g:1:782: RULE_DO
                {
                mRULE_DO(); 

                }
                break;
            case 74 :
                // InternalJava.g:1:790: RULE_WHILE
                {
                mRULE_WHILE(); 

                }
                break;
            case 75 :
                // InternalJava.g:1:801: RULE_PACKAGE
                {
                mRULE_PACKAGE(); 

                }
                break;
            case 76 :
                // InternalJava.g:1:814: RULE_IMPORT
                {
                mRULE_IMPORT(); 

                }
                break;
            case 77 :
                // InternalJava.g:1:826: RULE_CHAR
                {
                mRULE_CHAR(); 

                }
                break;
            case 78 :
                // InternalJava.g:1:836: RULE_PLUS
                {
                mRULE_PLUS(); 

                }
                break;
            case 79 :
                // InternalJava.g:1:846: RULE_MINUS
                {
                mRULE_MINUS(); 

                }
                break;
            case 80 :
                // InternalJava.g:1:857: RULE_MOD
                {
                mRULE_MOD(); 

                }
                break;
            case 81 :
                // InternalJava.g:1:866: RULE_TRY
                {
                mRULE_TRY(); 

                }
                break;
            case 82 :
                // InternalJava.g:1:875: RULE_CATCH
                {
                mRULE_CATCH(); 

                }
                break;
            case 83 :
                // InternalJava.g:1:886: RULE_FINALLY
                {
                mRULE_FINALLY(); 

                }
                break;
            case 84 :
                // InternalJava.g:1:899: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 85 :
                // InternalJava.g:1:907: RULE_HEXA
                {
                mRULE_HEXA(); 

                }
                break;
            case 86 :
                // InternalJava.g:1:917: RULE_DECIMAL_DIGITS
                {
                mRULE_DECIMAL_DIGITS(); 

                }
                break;
            case 87 :
                // InternalJava.g:1:937: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 88 :
                // InternalJava.g:1:953: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 89 :
                // InternalJava.g:1:969: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 90 :
                // InternalJava.g:1:977: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;
            case 91 :
                // InternalJava.g:1:992: RULE_DOC_COMMENT
                {
                mRULE_DOC_COMMENT(); 

                }
                break;

        }

    }


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA11 dfa11 = new DFA11(this);
    static final String DFA2_eotS =
        "\15\uffff";
    static final String DFA2_eofS =
        "\15\uffff";
    static final String DFA2_minS =
        "\1\141\1\162\4\uffff\1\150\1\uffff\1\151\4\uffff";
    static final String DFA2_maxS =
        "\1\164\1\165\4\uffff\1\162\1\uffff\1\157\4\uffff";
    static final String DFA2_acceptS =
        "\2\uffff\1\4\1\5\1\6\1\7\1\uffff\1\1\1\uffff\1\10\1\11\1\2\1\3";
    static final String DFA2_specialS =
        "\15\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\5\4\uffff\1\2\7\uffff\1\3\1\uffff\1\1\2\uffff\1\4\1\6",
            "\1\10\2\uffff\1\7",
            "",
            "",
            "",
            "",
            "\1\11\11\uffff\1\12",
            "",
            "\1\13\5\uffff\1\14",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "5570:12: ( 'public' | 'private' | 'protected' | 'final' | 'native' | 'synchronized' | 'abstract' | 'threadsafe' | 'transient' )";
        }
    }
    static final String DFA11_eotS =
        "\3\uffff\2\65\2\uffff\1\74\2\uffff\7\65\1\uffff\1\123\2\65\1\131\1\134\1\137\1\141\1\143\1\147\1\151\1\154\1\157\1\161\1\uffff\1\65\1\56\1\uffff\1\65\1\uffff\1\65\1\uffff\2\65\1\56\1\uffff\1\u0082\5\uffff\4\65\1\uffff\2\65\1\u008c\6\uffff\15\65\1\u009b\4\65\3\uffff\3\65\3\uffff\1\u00a8\30\uffff\2\65\2\uffff\2\65\1\uffff\1\65\1\uffff\4\65\4\uffff\6\65\1\u00bd\1\65\1\uffff\12\65\1\u00c9\3\65\1\uffff\11\65\1\u00d6\3\uffff\1\u00d7\1\uffff\2\65\1\u00da\10\65\1\u00e3\1\65\1\u00e5\4\65\1\uffff\2\65\1\u00ec\10\65\1\uffff\1\65\1\u00f6\2\65\1\u00f9\1\65\1\u00fb\1\u00fc\1\u00fd\1\65\1\u00ff\1\65\2\uffff\2\65\1\uffff\7\65\1\u010a\1\uffff\1\65\1\uffff\1\u010c\5\65\1\uffff\1\u0112\1\u0113\1\u0114\3\65\1\u0118\1\u0119\1\u011b\1\uffff\2\65\1\uffff\1\65\3\uffff\1\65\1\uffff\5\65\1\u0125\4\65\1\uffff\1\65\1\uffff\1\65\1\u012c\3\65\3\uffff\1\u0130\1\u0131\1\65\2\uffff\1\65\1\uffff\1\u0134\6\65\1\u011b\1\u013b\1\uffff\1\65\1\u011b\4\65\1\uffff\2\65\1\u0143\2\uffff\1\65\1\u0145\1\uffff\1\u0146\1\u0147\4\65\1\uffff\1\u014c\1\u011b\1\65\1\u014e\3\65\1\uffff\1\65\3\uffff\3\65\1\u011b\1\uffff\1\65\1\uffff\1\65\1\u0158\3\65\1\u011b\1\u015c\1\u011b\1\u015d\1\uffff\1\u015e\1\65\1\u011b\3\uffff\1\65\1\u011b";
    static final String DFA11_eofS =
        "\u0161\uffff";
    static final String DFA11_minS =
        "\1\0\2\uffff\1\141\1\146\2\uffff\1\135\2\uffff\1\157\1\150\1\141\1\157\1\145\1\157\1\154\1\uffff\1\75\1\125\1\150\1\74\4\75\1\52\1\75\1\53\1\55\1\75\1\uffff\1\142\1\0\1\uffff\1\141\1\uffff\1\145\1\uffff\1\150\1\141\1\0\1\uffff\1\170\5\uffff\2\141\1\156\1\163\1\uffff\1\160\1\163\1\44\6\uffff\1\157\1\164\1\145\1\157\1\160\1\141\1\151\1\156\1\157\1\154\1\162\2\156\1\44\1\146\1\151\1\164\1\163\3\uffff\1\114\1\151\1\141\3\uffff\1\75\12\uffff\1\0\15\uffff\1\160\1\163\2\uffff\1\167\1\164\1\uffff\1\164\1\uffff\1\151\1\143\1\142\1\151\4\uffff\1\163\1\162\1\164\1\145\1\143\1\154\1\44\1\164\1\uffff\1\154\1\145\1\141\1\162\1\145\2\164\1\143\1\141\1\163\1\44\1\141\1\147\1\142\1\uffff\1\141\1\144\2\145\1\114\1\163\2\145\1\156\1\44\3\uffff\1\0\1\uffff\1\145\1\164\1\44\1\151\1\165\1\154\1\153\1\154\1\166\1\164\1\163\1\44\1\151\1\44\1\150\1\145\2\162\1\uffff\1\141\1\145\1\44\1\153\1\164\1\162\1\151\1\143\1\150\1\164\1\145\1\uffff\1\154\1\44\1\154\1\165\1\44\1\156\3\44\1\141\1\44\1\163\2\uffff\2\162\1\uffff\1\166\1\162\1\145\1\141\1\151\1\141\1\145\1\44\1\uffff\1\156\1\uffff\1\44\1\155\1\164\1\146\1\156\1\141\1\uffff\3\44\1\143\1\150\1\162\3\44\1\uffff\1\145\1\154\1\uffff\1\144\3\uffff\1\144\1\uffff\1\151\1\163\1\141\1\145\1\156\1\44\1\147\1\143\1\164\1\143\1\uffff\1\165\1\uffff\1\145\1\44\1\141\1\143\1\156\3\uffff\2\44\1\157\2\uffff\1\171\1\uffff\1\44\1\164\2\163\1\145\1\141\1\143\2\44\1\uffff\1\145\1\44\1\145\1\164\1\145\1\156\1\uffff\1\143\1\145\1\44\2\uffff\1\156\1\44\1\uffff\2\44\1\141\2\156\1\164\1\uffff\2\44\1\145\1\44\1\164\1\145\1\157\1\uffff\1\151\3\uffff\1\146\1\164\1\144\1\44\1\uffff\1\144\1\uffff\1\163\1\44\1\146\1\172\1\145\4\44\1\uffff\1\44\1\145\1\44\3\uffff\1\144\1\44";
    static final String DFA11_maxS =
        "\1\uffff\2\uffff\1\157\1\156\2\uffff\1\135\2\uffff\2\171\4\157\1\170\1\uffff\1\75\1\125\1\162\1\75\1\76\1\174\7\75\1\uffff\1\155\1\uffff\1\uffff\1\145\1\uffff\1\145\1\uffff\1\150\1\165\1\uffff\1\uffff\1\170\5\uffff\2\141\1\156\1\164\1\uffff\1\160\1\164\1\uffff\6\uffff\1\157\1\164\1\145\1\157\1\160\1\141\1\151\1\156\1\157\1\154\1\162\2\156\1\uffff\1\146\1\151\1\164\1\163\3\uffff\1\114\1\162\1\171\3\uffff\1\76\12\uffff\1\uffff\15\uffff\1\160\1\163\2\uffff\1\167\1\164\1\uffff\1\164\1\uffff\1\151\1\143\1\142\1\157\4\uffff\1\163\1\162\1\164\1\145\1\143\1\157\1\uffff\1\164\1\uffff\1\154\1\145\1\141\1\162\1\145\2\164\1\143\1\141\1\163\1\uffff\1\141\1\147\1\142\1\uffff\1\141\1\144\2\145\1\114\1\163\2\145\1\156\1\uffff\3\uffff\1\uffff\1\uffff\1\145\1\164\1\uffff\1\151\1\165\1\154\1\153\1\154\1\166\1\164\1\163\1\uffff\1\151\1\uffff\1\150\1\145\2\162\1\uffff\1\141\1\145\1\uffff\1\153\1\164\1\162\1\151\1\143\1\150\1\164\1\145\1\uffff\1\154\1\uffff\1\154\1\165\1\uffff\1\156\3\uffff\1\141\1\uffff\1\163\2\uffff\2\162\1\uffff\1\166\1\162\1\145\1\141\1\151\1\141\1\145\1\uffff\1\uffff\1\156\1\uffff\1\uffff\1\155\1\164\1\146\1\156\1\141\1\uffff\3\uffff\1\143\1\150\1\162\3\uffff\1\uffff\1\145\1\154\1\uffff\1\144\3\uffff\1\144\1\uffff\1\151\1\163\1\141\1\145\1\156\1\uffff\1\147\1\143\1\164\1\143\1\uffff\1\165\1\uffff\1\145\1\uffff\1\141\1\143\1\156\3\uffff\2\uffff\1\157\2\uffff\1\171\1\uffff\1\uffff\1\164\2\163\1\145\1\141\1\143\2\uffff\1\uffff\1\145\1\uffff\1\145\1\164\1\145\1\156\1\uffff\1\143\1\145\1\uffff\2\uffff\1\156\1\uffff\1\uffff\2\uffff\1\141\2\156\1\164\1\uffff\2\uffff\1\145\1\uffff\1\164\1\145\1\157\1\uffff\1\151\3\uffff\1\146\1\164\1\144\1\uffff\1\uffff\1\144\1\uffff\1\163\1\uffff\1\146\1\172\1\145\4\uffff\1\uffff\1\uffff\1\145\1\uffff\3\uffff\1\144\1\uffff";
    static final String DFA11_acceptS =
        "\1\uffff\1\1\1\2\2\uffff\1\5\1\6\1\uffff\1\10\1\12\7\uffff\1\30\15\uffff\1\65\2\uffff\1\70\1\uffff\1\72\1\uffff\1\106\3\uffff\1\124\1\uffff\1\126\1\131\1\132\1\1\1\2\4\uffff\1\124\3\uffff\1\5\1\6\1\11\1\7\1\10\1\12\22\uffff\1\30\1\47\1\31\3\uffff\1\36\1\54\1\52\1\uffff\1\53\1\51\1\42\1\44\1\43\1\46\1\45\1\50\1\73\1\56\1\uffff\1\130\1\55\1\60\1\57\1\61\1\77\1\116\1\62\1\76\1\117\1\64\1\63\1\65\2\uffff\1\67\1\70\2\uffff\1\72\1\uffff\1\106\4\uffff\1\115\1\125\1\126\1\131\10\uffff\1\107\16\uffff\1\111\12\uffff\1\40\1\41\1\37\1\uffff\1\127\22\uffff\1\17\13\uffff\1\104\14\uffff\1\121\1\133\2\uffff\1\71\10\uffff\1\15\1\uffff\1\102\6\uffff\1\14\11\uffff\1\21\2\uffff\1\23\1\uffff\1\110\1\32\1\33\1\uffff\1\75\12\uffff\1\3\1\uffff\1\122\5\uffff\1\24\1\16\1\34\3\uffff\1\20\1\74\1\uffff\1\120\11\uffff\1\112\6\uffff\1\114\3\uffff\1\100\1\103\2\uffff\1\22\6\uffff\1\105\7\uffff\1\13\1\uffff\1\123\1\101\1\27\4\uffff\1\113\1\uffff\1\25\11\uffff\1\26\3\uffff\1\66\1\4\1\35\2\uffff";
    static final String DFA11_specialS =
        "\1\3\40\uffff\1\0\7\uffff\1\2\73\uffff\1\4\103\uffff\1\1\u00b7\uffff}>";
    static final String[] DFA11_transitionS = {
            "\11\56\2\55\2\56\1\55\22\56\1\55\1\31\1\41\1\56\1\52\1\33\1\56\1\51\1\5\1\6\1\36\1\34\1\21\1\35\1\11\1\32\1\53\11\54\1\42\1\46\1\25\1\22\1\26\1\37\1\56\15\52\1\23\14\52\1\7\1\56\1\10\1\30\1\52\1\56\1\40\1\12\1\3\1\16\1\20\1\14\2\52\1\4\2\52\1\15\1\52\1\43\1\52\1\50\1\52\1\45\1\13\1\24\1\52\1\17\1\47\3\52\1\1\1\27\1\2\1\44\uff81\56",
            "",
            "",
            "\1\64\6\uffff\1\62\3\uffff\1\61\2\uffff\1\63",
            "\1\70\6\uffff\1\66\1\67",
            "",
            "",
            "\1\73",
            "",
            "",
            "\1\77\2\uffff\1\101\6\uffff\1\100",
            "\1\102\13\uffff\1\104\1\103\1\uffff\1\105\1\uffff\1\106",
            "\1\110\7\uffff\1\112\2\uffff\1\107\2\uffff\1\111",
            "\1\113",
            "\1\115\11\uffff\1\114",
            "\1\116",
            "\1\120\13\uffff\1\117",
            "",
            "\1\122",
            "\1\124",
            "\1\125\11\uffff\1\126",
            "\1\127\1\130",
            "\1\133\1\132",
            "\1\136\76\uffff\1\135",
            "\1\140",
            "\1\142",
            "\1\145\4\uffff\1\146\15\uffff\1\144",
            "\1\150",
            "\1\153\21\uffff\1\152",
            "\1\156\17\uffff\1\155",
            "\1\160",
            "",
            "\1\164\12\uffff\1\163",
            "\0\165",
            "",
            "\1\170\3\uffff\1\167",
            "",
            "\1\172",
            "",
            "\1\174",
            "\1\175\20\uffff\1\177\2\uffff\1\176",
            "\0\u0080",
            "",
            "\1\u0081",
            "",
            "",
            "",
            "",
            "",
            "\1\u0084",
            "\1\u0085",
            "\1\u0086",
            "\1\u0087\1\u0088",
            "",
            "\1\u0089",
            "\1\u008b\1\u008a",
            "\1\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65\105\uffff\uff40\65",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u008d",
            "\1\u008e",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099",
            "\1\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\24\65\1\u009a\5\65\105\uffff\uff40\65",
            "\1\u009c",
            "\1\u009d",
            "\1\u009e",
            "\1\u009f",
            "",
            "",
            "",
            "\1\u00a0",
            "\1\u00a1\10\uffff\1\u00a2",
            "\1\u00a4\23\uffff\1\u00a3\3\uffff\1\u00a5",
            "",
            "",
            "",
            "\1\u00a7\1\u00a6",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\52\u00aa\1\u00a9\uffd5\u00aa",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u00ab",
            "\1\u00ac",
            "",
            "",
            "\1\u00ad",
            "\1\u00ae",
            "",
            "\1\u00af",
            "",
            "\1\u00b0",
            "\1\u00b1",
            "\1\u00b2",
            "\1\u00b3\5\uffff\1\u00b4",
            "",
            "",
            "",
            "",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7",
            "\1\u00b8",
            "\1\u00b9",
            "\1\u00ba\2\uffff\1\u00bb",
            "\1\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\4\65\1\u00bc\25\65\105\uffff\uff40\65",
            "\1\u00be",
            "",
            "\1\u00bf",
            "\1\u00c0",
            "\1\u00c1",
            "\1\u00c2",
            "\1\u00c3",
            "\1\u00c4",
            "\1\u00c5",
            "\1\u00c6",
            "\1\u00c7",
            "\1\u00c8",
            "\1\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65\105\uffff\uff40\65",
            "\1\u00ca",
            "\1\u00cb",
            "\1\u00cc",
            "",
            "\1\u00cd",
            "\1\u00ce",
            "\1\u00cf",
            "\1\u00d0",
            "\1\u00d1",
            "\1\u00d2",
            "\1\u00d3",
            "\1\u00d4",
            "\1\u00d5",
            "\1\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65\105\uffff\uff40\65",
            "",
            "",
            "",
            "\0\u00aa",
            "",
            "\1\u00d8",
            "\1\u00d9",
            "\1\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65\105\uffff\uff40\65",
            "\1\u00db",
            "\1\u00dc",
            "\1\u00dd",
            "\1\u00de",
            "\1\u00df",
            "\1\u00e0",
            "\1\u00e1",
            "\1\u00e2",
            "\1\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65\105\uffff\uff40\65",
            "\1\u00e4",
            "\1\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65\105\uffff\uff40\65",
            "\1\u00e6",
            "\1\u00e7",
            "\1\u00e8",
            "\1\u00e9",
            "",
            "\1\u00ea",
            "\1\u00eb",
            "\1\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65\105\uffff\uff40\65",
            "\1\u00ed",
            "\1\u00ee",
            "\1\u00ef",
            "\1\u00f0",
            "\1\u00f1",
            "\1\u00f2",
            "\1\u00f3",
            "\1\u00f4",
            "",
            "\1\u00f5",
            "\1\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65\105\uffff\uff40\65",
            "\1\u00f7",
            "\1\u00f8",
            "\1\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65\105\uffff\uff40\65",
            "\1\u00fa",
            "\1\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65\105\uffff\uff40\65",
            "\1\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65\105\uffff\uff40\65",
            "\1\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65\105\uffff\uff40\65",
            "\1\u00fe",
            "\1\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65\105\uffff\uff40\65",
            "\1\u0100",
            "",
            "",
            "\1\u0101",
            "\1\u0102",
            "",
            "\1\u0103",
            "\1\u0104",
            "\1\u0105",
            "\1\u0106",
            "\1\u0107",
            "\1\u0108",
            "\1\u0109",
            "\1\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65\105\uffff\uff40\65",
            "",
            "\1\u010b",
            "",
            "\1\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65\105\uffff\uff40\65",
            "\1\u010d",
            "\1\u010e",
            "\1\u010f",
            "\1\u0110",
            "\1\u0111",
            "",
            "\1\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65\105\uffff\uff40\65",
            "\1\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65\105\uffff\uff40\65",
            "\1\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65\105\uffff\uff40\65",
            "\1\u0115",
            "\1\u0116",
            "\1\u0117",
            "\1\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65\105\uffff\uff40\65",
            "\1\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65\105\uffff\uff40\65",
            "\1\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\13\65\1\u011a\16\65\105\uffff\uff40\65",
            "",
            "\1\u011c",
            "\1\u011d",
            "",
            "\1\u011e",
            "",
            "",
            "",
            "\1\u011f",
            "",
            "\1\u0120",
            "\1\u0121",
            "\1\u0122",
            "\1\u0123",
            "\1\u0124",
            "\1\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65\105\uffff\uff40\65",
            "\1\u0126",
            "\1\u0127",
            "\1\u0128",
            "\1\u0129",
            "",
            "\1\u012a",
            "",
            "\1\u012b",
            "\1\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65\105\uffff\uff40\65",
            "\1\u012d",
            "\1\u012e",
            "\1\u012f",
            "",
            "",
            "",
            "\1\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65\105\uffff\uff40\65",
            "\1\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65\105\uffff\uff40\65",
            "\1\u0132",
            "",
            "",
            "\1\u0133",
            "",
            "\1\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65\105\uffff\uff40\65",
            "\1\u0135",
            "\1\u0136",
            "\1\u0137",
            "\1\u0138",
            "\1\u0139",
            "\1\u013a",
            "\1\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65\105\uffff\uff40\65",
            "\1\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65\105\uffff\uff40\65",
            "",
            "\1\u013c",
            "\1\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65\105\uffff\uff40\65",
            "\1\u013d",
            "\1\u013e",
            "\1\u013f",
            "\1\u0140",
            "",
            "\1\u0141",
            "\1\u0142",
            "\1\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65\105\uffff\uff40\65",
            "",
            "",
            "\1\u0144",
            "\1\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65\105\uffff\uff40\65",
            "",
            "\1\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65\105\uffff\uff40\65",
            "\1\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65\105\uffff\uff40\65",
            "\1\u0148",
            "\1\u0149",
            "\1\u014a",
            "\1\u014b",
            "",
            "\1\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65\105\uffff\uff40\65",
            "\1\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65\105\uffff\uff40\65",
            "\1\u014d",
            "\1\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65\105\uffff\uff40\65",
            "\1\u014f",
            "\1\u0150",
            "\1\u0151",
            "",
            "\1\u0152",
            "",
            "",
            "",
            "\1\u0153",
            "\1\u0154",
            "\1\u0155",
            "\1\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65\105\uffff\uff40\65",
            "",
            "\1\u0156",
            "",
            "\1\u0157",
            "\1\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65\105\uffff\uff40\65",
            "\1\u0159",
            "\1\u015a",
            "\1\u015b",
            "\1\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65\105\uffff\uff40\65",
            "\1\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65\105\uffff\uff40\65",
            "\1\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65\105\uffff\uff40\65",
            "\1\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65\105\uffff\uff40\65",
            "",
            "\1\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65\105\uffff\uff40\65",
            "\1\u015f",
            "\1\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65\105\uffff\uff40\65",
            "",
            "",
            "",
            "\1\u0160",
            "\1\65\13\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65\105\uffff\uff40\65"
    };

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | RULE_INTERFACE | RULE_EXTENDS | RULE_COMMA | RULE_EQUAL | RULE_NULL | RULE_THIS | RULE_SUPER | RULE_INSTANCEOF | RULE_L_SHIFT | RULE_R_SHIFT | RULE_SUPER_SHIFT | RULE_R_SHIFT_EQUAL | RULE_DOUBLE_OR_EQUAL | RULE_OR | RULE_OR_EQUAL | RULE_EXP | RULE_EXP_EQUAL | RULE_DOUBLE_EQUAL | RULE_DIFFERENT | RULE_BT | RULE_ST | RULE_BE | RULE_SE | RULE_DIVIDE | RULE_DIVIDE_EQUAL | RULE_MODULE | RULE_MODULE_EQUAL | RULE_PLUS_EQUAL | RULE_MINUS_EQUAL | RULE_MULTIPLY | RULE_MULTIPLY_EQUAL | RULE_WAT | RULE_AMPERSAND | RULE_STRING | RULE_COLON | RULE_NEW | RULE_NOT | RULE_EXCLAMATION | RULE_FALSE | RULE_TRUE | RULE_DECREMENT | RULE_INCREMENT | RULE_STATIC | RULE_DEFAULT | RULE_CASE | RULE_SWITCH | RULE_FOR | RULE_RETURN | RULE_EOL | RULE_IF | RULE_ELSE | RULE_DO | RULE_WHILE | RULE_PACKAGE | RULE_IMPORT | RULE_CHAR | RULE_PLUS | RULE_MINUS | RULE_MOD | RULE_TRY | RULE_CATCH | RULE_FINALLY | RULE_ID | RULE_HEXA | RULE_DECIMAL_DIGITS | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER | RULE_DOC_COMMENT );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA11_33 = input.LA(1);

                        s = -1;
                        if ( ((LA11_33>='\u0000' && LA11_33<='\uFFFF')) ) {s = 117;}

                        else s = 46;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA11_169 = input.LA(1);

                        s = -1;
                        if ( ((LA11_169>='\u0000' && LA11_169<='\uFFFF')) ) {s = 170;}

                        else s = 215;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA11_41 = input.LA(1);

                        s = -1;
                        if ( ((LA11_41>='\u0000' && LA11_41<='\uFFFF')) ) {s = 128;}

                        else s = 46;

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA11_0 = input.LA(1);

                        s = -1;
                        if ( (LA11_0=='{') ) {s = 1;}

                        else if ( (LA11_0=='}') ) {s = 2;}

                        else if ( (LA11_0=='c') ) {s = 3;}

                        else if ( (LA11_0=='i') ) {s = 4;}

                        else if ( (LA11_0=='(') ) {s = 5;}

                        else if ( (LA11_0==')') ) {s = 6;}

                        else if ( (LA11_0=='[') ) {s = 7;}

                        else if ( (LA11_0==']') ) {s = 8;}

                        else if ( (LA11_0=='.') ) {s = 9;}

                        else if ( (LA11_0=='b') ) {s = 10;}

                        else if ( (LA11_0=='s') ) {s = 11;}

                        else if ( (LA11_0=='f') ) {s = 12;}

                        else if ( (LA11_0=='l') ) {s = 13;}

                        else if ( (LA11_0=='d') ) {s = 14;}

                        else if ( (LA11_0=='v') ) {s = 15;}

                        else if ( (LA11_0=='e') ) {s = 16;}

                        else if ( (LA11_0==',') ) {s = 17;}

                        else if ( (LA11_0=='=') ) {s = 18;}

                        else if ( (LA11_0=='N') ) {s = 19;}

                        else if ( (LA11_0=='t') ) {s = 20;}

                        else if ( (LA11_0=='<') ) {s = 21;}

                        else if ( (LA11_0=='>') ) {s = 22;}

                        else if ( (LA11_0=='|') ) {s = 23;}

                        else if ( (LA11_0=='^') ) {s = 24;}

                        else if ( (LA11_0=='!') ) {s = 25;}

                        else if ( (LA11_0=='/') ) {s = 26;}

                        else if ( (LA11_0=='%') ) {s = 27;}

                        else if ( (LA11_0=='+') ) {s = 28;}

                        else if ( (LA11_0=='-') ) {s = 29;}

                        else if ( (LA11_0=='*') ) {s = 30;}

                        else if ( (LA11_0=='?') ) {s = 31;}

                        else if ( (LA11_0=='a') ) {s = 32;}

                        else if ( (LA11_0=='\"') ) {s = 33;}

                        else if ( (LA11_0==':') ) {s = 34;}

                        else if ( (LA11_0=='n') ) {s = 35;}

                        else if ( (LA11_0=='~') ) {s = 36;}

                        else if ( (LA11_0=='r') ) {s = 37;}

                        else if ( (LA11_0==';') ) {s = 38;}

                        else if ( (LA11_0=='w') ) {s = 39;}

                        else if ( (LA11_0=='p') ) {s = 40;}

                        else if ( (LA11_0=='\'') ) {s = 41;}

                        else if ( (LA11_0=='$'||(LA11_0>='A' && LA11_0<='M')||(LA11_0>='O' && LA11_0<='Z')||LA11_0=='_'||(LA11_0>='g' && LA11_0<='h')||(LA11_0>='j' && LA11_0<='k')||LA11_0=='m'||LA11_0=='o'||LA11_0=='q'||LA11_0=='u'||(LA11_0>='x' && LA11_0<='z')) ) {s = 42;}

                        else if ( (LA11_0=='0') ) {s = 43;}

                        else if ( ((LA11_0>='1' && LA11_0<='9')) ) {s = 44;}

                        else if ( ((LA11_0>='\t' && LA11_0<='\n')||LA11_0=='\r'||LA11_0==' ') ) {s = 45;}

                        else if ( ((LA11_0>='\u0000' && LA11_0<='\b')||(LA11_0>='\u000B' && LA11_0<='\f')||(LA11_0>='\u000E' && LA11_0<='\u001F')||LA11_0=='#'||LA11_0=='&'||LA11_0=='@'||LA11_0=='\\'||LA11_0=='`'||(LA11_0>='\u007F' && LA11_0<='\uFFFF')) ) {s = 46;}

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA11_101 = input.LA(1);

                        s = -1;
                        if ( (LA11_101=='*') ) {s = 169;}

                        else if ( ((LA11_101>='\u0000' && LA11_101<=')')||(LA11_101>='+' && LA11_101<='\uFFFF')) ) {s = 170;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 11, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}