package org.xtext.java.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.xtext.java.services.JavaGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalJavaParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_DOC_COMMENT", "RULE_EOL", "RULE_INTERFACE", "RULE_ID", "RULE_EXTENDS", "RULE_COMMA", "RULE_EQUAL", "RULE_NULL", "RULE_SUPER", "RULE_THIS", "RULE_INSTANCEOF", "RULE_INCREMENT", "RULE_DECREMENT", "RULE_PLUS", "RULE_PLUS_EQUAL", "RULE_MINUS", "RULE_MINUS_EQUAL", "RULE_MULTIPLY", "RULE_MULTIPLY_EQUAL", "RULE_DIVIDE", "RULE_DIVIDE_EQUAL", "RULE_MODULE", "RULE_MODULE_EQUAL", "RULE_BT", "RULE_ST", "RULE_BE", "RULE_SE", "RULE_DOUBLE_EQUAL", "RULE_DIFFERENT", "RULE_OR", "RULE_OR_EQUAL", "RULE_EXP", "RULE_EXP_EQUAL", "RULE_DOUBLE_OR_EQUAL", "RULE_WAT", "RULE_COLON", "RULE_R_SHIFT_EQUAL", "RULE_L_SHIFT", "RULE_R_SHIFT", "RULE_SUPER_SHIFT", "RULE_AMPERSAND", "RULE_DECIMAL_DIGITS", "RULE_HEXA", "RULE_STRING", "RULE_CHAR", "RULE_NEW", "RULE_NOT", "RULE_EXCLAMATION", "RULE_TRUE", "RULE_FALSE", "RULE_MOD", "RULE_STATIC", "RULE_SWITCH", "RULE_CASE", "RULE_DEFAULT", "RULE_FOR", "RULE_WHILE", "RULE_DO", "RULE_IF", "RULE_ELSE", "RULE_RETURN", "RULE_TRY", "RULE_CATCH", "RULE_FINALLY", "RULE_PACKAGE", "RULE_IMPORT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'{'", "'}'", "'class'", "'implements'", "'('", "')'", "'['", "']'", "'[]'", "'.'", "'boolean'", "'byte'", "'char'", "'short'", "'int'", "'float'", "'long'", "'double'", "'void'", "'break'", "'continue'"
    };
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


        public InternalJavaParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalJavaParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalJavaParser.tokenNames; }
    public String getGrammarFileName() { return "InternalJava.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */
     
     	private JavaGrammarAccess grammarAccess;
     	
        public InternalJavaParser(TokenStream input, JavaGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Head";	
       	}
       	
       	@Override
       	protected JavaGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleHead"
    // InternalJava.g:73:1: entryRuleHead returns [EObject current=null] : iv_ruleHead= ruleHead EOF ;
    public final EObject entryRuleHead() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHead = null;


        try {
            // InternalJava.g:74:2: (iv_ruleHead= ruleHead EOF )
            // InternalJava.g:75:2: iv_ruleHead= ruleHead EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getHeadRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleHead=ruleHead();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleHead; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleHead"


    // $ANTLR start "ruleHead"
    // InternalJava.g:82:1: ruleHead returns [EObject current=null] : ( (lv_elements_0_0= ruleCompilation_unit ) ) ;
    public final EObject ruleHead() throws RecognitionException {
        EObject current = null;

        EObject lv_elements_0_0 = null;


         enterRule(); 
            
        try {
            // InternalJava.g:85:28: ( ( (lv_elements_0_0= ruleCompilation_unit ) ) )
            // InternalJava.g:86:1: ( (lv_elements_0_0= ruleCompilation_unit ) )
            {
            // InternalJava.g:86:1: ( (lv_elements_0_0= ruleCompilation_unit ) )
            // InternalJava.g:87:1: (lv_elements_0_0= ruleCompilation_unit )
            {
            // InternalJava.g:87:1: (lv_elements_0_0= ruleCompilation_unit )
            // InternalJava.g:88:3: lv_elements_0_0= ruleCompilation_unit
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getHeadAccess().getElementsCompilation_unitParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_elements_0_0=ruleCompilation_unit();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getHeadRule());
              	        }
                     		add(
                     			current, 
                     			"elements",
                      		lv_elements_0_0, 
                      		"org.xtext.java.Java.Compilation_unit");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleHead"


    // $ANTLR start "entryRuleCompilation_unit"
    // InternalJava.g:112:1: entryRuleCompilation_unit returns [EObject current=null] : iv_ruleCompilation_unit= ruleCompilation_unit EOF ;
    public final EObject entryRuleCompilation_unit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompilation_unit = null;


        try {
            // InternalJava.g:113:2: (iv_ruleCompilation_unit= ruleCompilation_unit EOF )
            // InternalJava.g:114:2: iv_ruleCompilation_unit= ruleCompilation_unit EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCompilation_unitRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCompilation_unit=ruleCompilation_unit();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCompilation_unit; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCompilation_unit"


    // $ANTLR start "ruleCompilation_unit"
    // InternalJava.g:121:1: ruleCompilation_unit returns [EObject current=null] : ( () ( (lv_package_1_0= rulePackage_statement ) )? ( (lv_imports_2_0= ruleImport_statement ) )* ( (lv_type_declarations_3_0= ruleType_declaration ) )* ) ;
    public final EObject ruleCompilation_unit() throws RecognitionException {
        EObject current = null;

        EObject lv_package_1_0 = null;

        EObject lv_imports_2_0 = null;

        EObject lv_type_declarations_3_0 = null;


         enterRule(); 
            
        try {
            // InternalJava.g:124:28: ( ( () ( (lv_package_1_0= rulePackage_statement ) )? ( (lv_imports_2_0= ruleImport_statement ) )* ( (lv_type_declarations_3_0= ruleType_declaration ) )* ) )
            // InternalJava.g:125:1: ( () ( (lv_package_1_0= rulePackage_statement ) )? ( (lv_imports_2_0= ruleImport_statement ) )* ( (lv_type_declarations_3_0= ruleType_declaration ) )* )
            {
            // InternalJava.g:125:1: ( () ( (lv_package_1_0= rulePackage_statement ) )? ( (lv_imports_2_0= ruleImport_statement ) )* ( (lv_type_declarations_3_0= ruleType_declaration ) )* )
            // InternalJava.g:125:2: () ( (lv_package_1_0= rulePackage_statement ) )? ( (lv_imports_2_0= ruleImport_statement ) )* ( (lv_type_declarations_3_0= ruleType_declaration ) )*
            {
            // InternalJava.g:125:2: ()
            // InternalJava.g:126:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getCompilation_unitAccess().getCompilation_unitAction_0(),
                          current);
                  
            }

            }

            // InternalJava.g:134:2: ( (lv_package_1_0= rulePackage_statement ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_PACKAGE) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalJava.g:135:1: (lv_package_1_0= rulePackage_statement )
                    {
                    // InternalJava.g:135:1: (lv_package_1_0= rulePackage_statement )
                    // InternalJava.g:136:3: lv_package_1_0= rulePackage_statement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCompilation_unitAccess().getPackagePackage_statementParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_3);
                    lv_package_1_0=rulePackage_statement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCompilation_unitRule());
                      	        }
                             		set(
                             			current, 
                             			"package",
                              		lv_package_1_0, 
                              		"org.xtext.java.Java.Package_statement");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // InternalJava.g:152:3: ( (lv_imports_2_0= ruleImport_statement ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RULE_IMPORT) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalJava.g:153:1: (lv_imports_2_0= ruleImport_statement )
            	    {
            	    // InternalJava.g:153:1: (lv_imports_2_0= ruleImport_statement )
            	    // InternalJava.g:154:3: lv_imports_2_0= ruleImport_statement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getCompilation_unitAccess().getImportsImport_statementParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_3);
            	    lv_imports_2_0=ruleImport_statement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getCompilation_unitRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"imports",
            	              		lv_imports_2_0, 
            	              		"org.xtext.java.Java.Import_statement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // InternalJava.g:170:3: ( (lv_type_declarations_3_0= ruleType_declaration ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_DOC_COMMENT||LA3_0==RULE_INTERFACE||(LA3_0>=RULE_MOD && LA3_0<=RULE_STATIC)||LA3_0==76) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalJava.g:171:1: (lv_type_declarations_3_0= ruleType_declaration )
            	    {
            	    // InternalJava.g:171:1: (lv_type_declarations_3_0= ruleType_declaration )
            	    // InternalJava.g:172:3: lv_type_declarations_3_0= ruleType_declaration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getCompilation_unitAccess().getType_declarationsType_declarationParserRuleCall_3_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_4);
            	    lv_type_declarations_3_0=ruleType_declaration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getCompilation_unitRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"type_declarations",
            	              		lv_type_declarations_3_0, 
            	              		"org.xtext.java.Java.Type_declaration");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCompilation_unit"


    // $ANTLR start "entryRuleType_declaration"
    // InternalJava.g:196:1: entryRuleType_declaration returns [EObject current=null] : iv_ruleType_declaration= ruleType_declaration EOF ;
    public final EObject entryRuleType_declaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType_declaration = null;


        try {
            // InternalJava.g:197:2: (iv_ruleType_declaration= ruleType_declaration EOF )
            // InternalJava.g:198:2: iv_ruleType_declaration= ruleType_declaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getType_declarationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleType_declaration=ruleType_declaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleType_declaration; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleType_declaration"


    // $ANTLR start "ruleType_declaration"
    // InternalJava.g:205:1: ruleType_declaration returns [EObject current=null] : ( ( (lv_doc_0_0= RULE_DOC_COMMENT ) )? ( ( (lv_name_1_0= ruleClass_declaration ) ) | ( (lv_name_2_0= ruleInterface_declaration ) ) ) (this_EOL_3= RULE_EOL )? ) ;
    public final EObject ruleType_declaration() throws RecognitionException {
        EObject current = null;

        Token lv_doc_0_0=null;
        Token this_EOL_3=null;
        EObject lv_name_1_0 = null;

        EObject lv_name_2_0 = null;


         enterRule(); 
            
        try {
            // InternalJava.g:208:28: ( ( ( (lv_doc_0_0= RULE_DOC_COMMENT ) )? ( ( (lv_name_1_0= ruleClass_declaration ) ) | ( (lv_name_2_0= ruleInterface_declaration ) ) ) (this_EOL_3= RULE_EOL )? ) )
            // InternalJava.g:209:1: ( ( (lv_doc_0_0= RULE_DOC_COMMENT ) )? ( ( (lv_name_1_0= ruleClass_declaration ) ) | ( (lv_name_2_0= ruleInterface_declaration ) ) ) (this_EOL_3= RULE_EOL )? )
            {
            // InternalJava.g:209:1: ( ( (lv_doc_0_0= RULE_DOC_COMMENT ) )? ( ( (lv_name_1_0= ruleClass_declaration ) ) | ( (lv_name_2_0= ruleInterface_declaration ) ) ) (this_EOL_3= RULE_EOL )? )
            // InternalJava.g:209:2: ( (lv_doc_0_0= RULE_DOC_COMMENT ) )? ( ( (lv_name_1_0= ruleClass_declaration ) ) | ( (lv_name_2_0= ruleInterface_declaration ) ) ) (this_EOL_3= RULE_EOL )?
            {
            // InternalJava.g:209:2: ( (lv_doc_0_0= RULE_DOC_COMMENT ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_DOC_COMMENT) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalJava.g:210:1: (lv_doc_0_0= RULE_DOC_COMMENT )
                    {
                    // InternalJava.g:210:1: (lv_doc_0_0= RULE_DOC_COMMENT )
                    // InternalJava.g:211:3: lv_doc_0_0= RULE_DOC_COMMENT
                    {
                    lv_doc_0_0=(Token)match(input,RULE_DOC_COMMENT,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_doc_0_0, grammarAccess.getType_declarationAccess().getDocDOC_COMMENTTerminalRuleCall_0_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getType_declarationRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"doc",
                              		lv_doc_0_0, 
                              		"org.xtext.java.Java.DOC_COMMENT");
                      	    
                    }

                    }


                    }
                    break;

            }

            // InternalJava.g:227:3: ( ( (lv_name_1_0= ruleClass_declaration ) ) | ( (lv_name_2_0= ruleInterface_declaration ) ) )
            int alt5=2;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // InternalJava.g:227:4: ( (lv_name_1_0= ruleClass_declaration ) )
                    {
                    // InternalJava.g:227:4: ( (lv_name_1_0= ruleClass_declaration ) )
                    // InternalJava.g:228:1: (lv_name_1_0= ruleClass_declaration )
                    {
                    // InternalJava.g:228:1: (lv_name_1_0= ruleClass_declaration )
                    // InternalJava.g:229:3: lv_name_1_0= ruleClass_declaration
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getType_declarationAccess().getNameClass_declarationParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_6);
                    lv_name_1_0=ruleClass_declaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getType_declarationRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_1_0, 
                              		"org.xtext.java.Java.Class_declaration");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalJava.g:246:6: ( (lv_name_2_0= ruleInterface_declaration ) )
                    {
                    // InternalJava.g:246:6: ( (lv_name_2_0= ruleInterface_declaration ) )
                    // InternalJava.g:247:1: (lv_name_2_0= ruleInterface_declaration )
                    {
                    // InternalJava.g:247:1: (lv_name_2_0= ruleInterface_declaration )
                    // InternalJava.g:248:3: lv_name_2_0= ruleInterface_declaration
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getType_declarationAccess().getNameInterface_declarationParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_6);
                    lv_name_2_0=ruleInterface_declaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getType_declarationRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_2_0, 
                              		"org.xtext.java.Java.Interface_declaration");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalJava.g:264:3: (this_EOL_3= RULE_EOL )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_EOL) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalJava.g:264:4: this_EOL_3= RULE_EOL
                    {
                    this_EOL_3=(Token)match(input,RULE_EOL,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_EOL_3, grammarAccess.getType_declarationAccess().getEOLTerminalRuleCall_2()); 
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleType_declaration"


    // $ANTLR start "entryRuleInterface_declaration"
    // InternalJava.g:276:1: entryRuleInterface_declaration returns [EObject current=null] : iv_ruleInterface_declaration= ruleInterface_declaration EOF ;
    public final EObject entryRuleInterface_declaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInterface_declaration = null;


        try {
            // InternalJava.g:277:2: (iv_ruleInterface_declaration= ruleInterface_declaration EOF )
            // InternalJava.g:278:2: iv_ruleInterface_declaration= ruleInterface_declaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInterface_declarationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleInterface_declaration=ruleInterface_declaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInterface_declaration; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInterface_declaration"


    // $ANTLR start "ruleInterface_declaration"
    // InternalJava.g:285:1: ruleInterface_declaration returns [EObject current=null] : ( ( (lv_modifiers_0_0= ruleModifier ) )* this_INTERFACE_1= RULE_INTERFACE ( (lv_interfaceName_2_0= RULE_ID ) ) (this_EXTENDS_3= RULE_EXTENDS ( (lv_extend_4_0= ruleInterface_name ) ) (this_COMMA_5= RULE_COMMA ( (lv_extends_6_0= ruleInterface_name ) ) )* )? otherlv_7= '{' ( (lv_fields_8_0= ruleField_declaration ) )* otherlv_9= '}' ) ;
    public final EObject ruleInterface_declaration() throws RecognitionException {
        EObject current = null;

        Token this_INTERFACE_1=null;
        Token lv_interfaceName_2_0=null;
        Token this_EXTENDS_3=null;
        Token this_COMMA_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        AntlrDatatypeRuleToken lv_modifiers_0_0 = null;

        AntlrDatatypeRuleToken lv_extend_4_0 = null;

        AntlrDatatypeRuleToken lv_extends_6_0 = null;

        EObject lv_fields_8_0 = null;


         enterRule(); 
            
        try {
            // InternalJava.g:288:28: ( ( ( (lv_modifiers_0_0= ruleModifier ) )* this_INTERFACE_1= RULE_INTERFACE ( (lv_interfaceName_2_0= RULE_ID ) ) (this_EXTENDS_3= RULE_EXTENDS ( (lv_extend_4_0= ruleInterface_name ) ) (this_COMMA_5= RULE_COMMA ( (lv_extends_6_0= ruleInterface_name ) ) )* )? otherlv_7= '{' ( (lv_fields_8_0= ruleField_declaration ) )* otherlv_9= '}' ) )
            // InternalJava.g:289:1: ( ( (lv_modifiers_0_0= ruleModifier ) )* this_INTERFACE_1= RULE_INTERFACE ( (lv_interfaceName_2_0= RULE_ID ) ) (this_EXTENDS_3= RULE_EXTENDS ( (lv_extend_4_0= ruleInterface_name ) ) (this_COMMA_5= RULE_COMMA ( (lv_extends_6_0= ruleInterface_name ) ) )* )? otherlv_7= '{' ( (lv_fields_8_0= ruleField_declaration ) )* otherlv_9= '}' )
            {
            // InternalJava.g:289:1: ( ( (lv_modifiers_0_0= ruleModifier ) )* this_INTERFACE_1= RULE_INTERFACE ( (lv_interfaceName_2_0= RULE_ID ) ) (this_EXTENDS_3= RULE_EXTENDS ( (lv_extend_4_0= ruleInterface_name ) ) (this_COMMA_5= RULE_COMMA ( (lv_extends_6_0= ruleInterface_name ) ) )* )? otherlv_7= '{' ( (lv_fields_8_0= ruleField_declaration ) )* otherlv_9= '}' )
            // InternalJava.g:289:2: ( (lv_modifiers_0_0= ruleModifier ) )* this_INTERFACE_1= RULE_INTERFACE ( (lv_interfaceName_2_0= RULE_ID ) ) (this_EXTENDS_3= RULE_EXTENDS ( (lv_extend_4_0= ruleInterface_name ) ) (this_COMMA_5= RULE_COMMA ( (lv_extends_6_0= ruleInterface_name ) ) )* )? otherlv_7= '{' ( (lv_fields_8_0= ruleField_declaration ) )* otherlv_9= '}'
            {
            // InternalJava.g:289:2: ( (lv_modifiers_0_0= ruleModifier ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=RULE_MOD && LA7_0<=RULE_STATIC)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalJava.g:290:1: (lv_modifiers_0_0= ruleModifier )
            	    {
            	    // InternalJava.g:290:1: (lv_modifiers_0_0= ruleModifier )
            	    // InternalJava.g:291:3: lv_modifiers_0_0= ruleModifier
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getInterface_declarationAccess().getModifiersModifierParserRuleCall_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_7);
            	    lv_modifiers_0_0=ruleModifier();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getInterface_declarationRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"modifiers",
            	              		lv_modifiers_0_0, 
            	              		"org.xtext.java.Java.Modifier");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            this_INTERFACE_1=(Token)match(input,RULE_INTERFACE,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_INTERFACE_1, grammarAccess.getInterface_declarationAccess().getINTERFACETerminalRuleCall_1()); 
                  
            }
            // InternalJava.g:311:1: ( (lv_interfaceName_2_0= RULE_ID ) )
            // InternalJava.g:312:1: (lv_interfaceName_2_0= RULE_ID )
            {
            // InternalJava.g:312:1: (lv_interfaceName_2_0= RULE_ID )
            // InternalJava.g:313:3: lv_interfaceName_2_0= RULE_ID
            {
            lv_interfaceName_2_0=(Token)match(input,RULE_ID,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_interfaceName_2_0, grammarAccess.getInterface_declarationAccess().getInterfaceNameIDTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getInterface_declarationRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"interfaceName",
                      		lv_interfaceName_2_0, 
                      		"org.xtext.java.Java.ID");
              	    
            }

            }


            }

            // InternalJava.g:329:2: (this_EXTENDS_3= RULE_EXTENDS ( (lv_extend_4_0= ruleInterface_name ) ) (this_COMMA_5= RULE_COMMA ( (lv_extends_6_0= ruleInterface_name ) ) )* )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_EXTENDS) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalJava.g:329:3: this_EXTENDS_3= RULE_EXTENDS ( (lv_extend_4_0= ruleInterface_name ) ) (this_COMMA_5= RULE_COMMA ( (lv_extends_6_0= ruleInterface_name ) ) )*
                    {
                    this_EXTENDS_3=(Token)match(input,RULE_EXTENDS,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_EXTENDS_3, grammarAccess.getInterface_declarationAccess().getEXTENDSTerminalRuleCall_3_0()); 
                          
                    }
                    // InternalJava.g:333:1: ( (lv_extend_4_0= ruleInterface_name ) )
                    // InternalJava.g:334:1: (lv_extend_4_0= ruleInterface_name )
                    {
                    // InternalJava.g:334:1: (lv_extend_4_0= ruleInterface_name )
                    // InternalJava.g:335:3: lv_extend_4_0= ruleInterface_name
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getInterface_declarationAccess().getExtendInterface_nameParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_10);
                    lv_extend_4_0=ruleInterface_name();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getInterface_declarationRule());
                      	        }
                             		set(
                             			current, 
                             			"extend",
                              		lv_extend_4_0, 
                              		"org.xtext.java.Java.Interface_name");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalJava.g:351:2: (this_COMMA_5= RULE_COMMA ( (lv_extends_6_0= ruleInterface_name ) ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==RULE_COMMA) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // InternalJava.g:351:3: this_COMMA_5= RULE_COMMA ( (lv_extends_6_0= ruleInterface_name ) )
                    	    {
                    	    this_COMMA_5=(Token)match(input,RULE_COMMA,FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_COMMA_5, grammarAccess.getInterface_declarationAccess().getCOMMATerminalRuleCall_3_2_0()); 
                    	          
                    	    }
                    	    // InternalJava.g:355:1: ( (lv_extends_6_0= ruleInterface_name ) )
                    	    // InternalJava.g:356:1: (lv_extends_6_0= ruleInterface_name )
                    	    {
                    	    // InternalJava.g:356:1: (lv_extends_6_0= ruleInterface_name )
                    	    // InternalJava.g:357:3: lv_extends_6_0= ruleInterface_name
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getInterface_declarationAccess().getExtendsInterface_nameParserRuleCall_3_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_10);
                    	    lv_extends_6_0=ruleInterface_name();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getInterface_declarationRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"extends",
                    	              		lv_extends_6_0, 
                    	              		"org.xtext.java.Java.Interface_name");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_7=(Token)match(input,74,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getInterface_declarationAccess().getLeftCurlyBracketKeyword_4());
                  
            }
            // InternalJava.g:377:1: ( (lv_fields_8_0= ruleField_declaration ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>=RULE_DOC_COMMENT && LA10_0<=RULE_EOL)||LA10_0==RULE_ID||(LA10_0>=RULE_MOD && LA10_0<=RULE_STATIC)||(LA10_0>=84 && LA10_0<=92)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalJava.g:378:1: (lv_fields_8_0= ruleField_declaration )
            	    {
            	    // InternalJava.g:378:1: (lv_fields_8_0= ruleField_declaration )
            	    // InternalJava.g:379:3: lv_fields_8_0= ruleField_declaration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getInterface_declarationAccess().getFieldsField_declarationParserRuleCall_5_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_11);
            	    lv_fields_8_0=ruleField_declaration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getInterface_declarationRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"fields",
            	              		lv_fields_8_0, 
            	              		"org.xtext.java.Java.Field_declaration");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            otherlv_9=(Token)match(input,75,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_9, grammarAccess.getInterface_declarationAccess().getRightCurlyBracketKeyword_6());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInterface_declaration"


    // $ANTLR start "entryRuleClass_declaration"
    // InternalJava.g:407:1: entryRuleClass_declaration returns [EObject current=null] : iv_ruleClass_declaration= ruleClass_declaration EOF ;
    public final EObject entryRuleClass_declaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClass_declaration = null;


        try {
            // InternalJava.g:408:2: (iv_ruleClass_declaration= ruleClass_declaration EOF )
            // InternalJava.g:409:2: iv_ruleClass_declaration= ruleClass_declaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getClass_declarationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleClass_declaration=ruleClass_declaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleClass_declaration; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClass_declaration"


    // $ANTLR start "ruleClass_declaration"
    // InternalJava.g:416:1: ruleClass_declaration returns [EObject current=null] : ( ( (lv_modifiers_0_0= ruleModifier ) )* otherlv_1= 'class' ( (lv_className_2_0= RULE_ID ) ) (this_EXTENDS_3= RULE_EXTENDS ( (lv_extend_4_0= ruleClass_name ) ) )? (otherlv_5= 'implements' ( (lv_implement_6_0= ruleInterface_name ) ) (this_COMMA_7= RULE_COMMA ( (lv_implements_8_0= ruleInterface_name ) ) )* )? otherlv_9= '{' ( (lv_fields_10_0= ruleField_declaration ) )* otherlv_11= '}' ) ;
    public final EObject ruleClass_declaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_className_2_0=null;
        Token this_EXTENDS_3=null;
        Token otherlv_5=null;
        Token this_COMMA_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        AntlrDatatypeRuleToken lv_modifiers_0_0 = null;

        AntlrDatatypeRuleToken lv_extend_4_0 = null;

        AntlrDatatypeRuleToken lv_implement_6_0 = null;

        AntlrDatatypeRuleToken lv_implements_8_0 = null;

        EObject lv_fields_10_0 = null;


         enterRule(); 
            
        try {
            // InternalJava.g:419:28: ( ( ( (lv_modifiers_0_0= ruleModifier ) )* otherlv_1= 'class' ( (lv_className_2_0= RULE_ID ) ) (this_EXTENDS_3= RULE_EXTENDS ( (lv_extend_4_0= ruleClass_name ) ) )? (otherlv_5= 'implements' ( (lv_implement_6_0= ruleInterface_name ) ) (this_COMMA_7= RULE_COMMA ( (lv_implements_8_0= ruleInterface_name ) ) )* )? otherlv_9= '{' ( (lv_fields_10_0= ruleField_declaration ) )* otherlv_11= '}' ) )
            // InternalJava.g:420:1: ( ( (lv_modifiers_0_0= ruleModifier ) )* otherlv_1= 'class' ( (lv_className_2_0= RULE_ID ) ) (this_EXTENDS_3= RULE_EXTENDS ( (lv_extend_4_0= ruleClass_name ) ) )? (otherlv_5= 'implements' ( (lv_implement_6_0= ruleInterface_name ) ) (this_COMMA_7= RULE_COMMA ( (lv_implements_8_0= ruleInterface_name ) ) )* )? otherlv_9= '{' ( (lv_fields_10_0= ruleField_declaration ) )* otherlv_11= '}' )
            {
            // InternalJava.g:420:1: ( ( (lv_modifiers_0_0= ruleModifier ) )* otherlv_1= 'class' ( (lv_className_2_0= RULE_ID ) ) (this_EXTENDS_3= RULE_EXTENDS ( (lv_extend_4_0= ruleClass_name ) ) )? (otherlv_5= 'implements' ( (lv_implement_6_0= ruleInterface_name ) ) (this_COMMA_7= RULE_COMMA ( (lv_implements_8_0= ruleInterface_name ) ) )* )? otherlv_9= '{' ( (lv_fields_10_0= ruleField_declaration ) )* otherlv_11= '}' )
            // InternalJava.g:420:2: ( (lv_modifiers_0_0= ruleModifier ) )* otherlv_1= 'class' ( (lv_className_2_0= RULE_ID ) ) (this_EXTENDS_3= RULE_EXTENDS ( (lv_extend_4_0= ruleClass_name ) ) )? (otherlv_5= 'implements' ( (lv_implement_6_0= ruleInterface_name ) ) (this_COMMA_7= RULE_COMMA ( (lv_implements_8_0= ruleInterface_name ) ) )* )? otherlv_9= '{' ( (lv_fields_10_0= ruleField_declaration ) )* otherlv_11= '}'
            {
            // InternalJava.g:420:2: ( (lv_modifiers_0_0= ruleModifier ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=RULE_MOD && LA11_0<=RULE_STATIC)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalJava.g:421:1: (lv_modifiers_0_0= ruleModifier )
            	    {
            	    // InternalJava.g:421:1: (lv_modifiers_0_0= ruleModifier )
            	    // InternalJava.g:422:3: lv_modifiers_0_0= ruleModifier
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getClass_declarationAccess().getModifiersModifierParserRuleCall_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_12);
            	    lv_modifiers_0_0=ruleModifier();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getClass_declarationRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"modifiers",
            	              		lv_modifiers_0_0, 
            	              		"org.xtext.java.Java.Modifier");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            otherlv_1=(Token)match(input,76,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getClass_declarationAccess().getClassKeyword_1());
                  
            }
            // InternalJava.g:442:1: ( (lv_className_2_0= RULE_ID ) )
            // InternalJava.g:443:1: (lv_className_2_0= RULE_ID )
            {
            // InternalJava.g:443:1: (lv_className_2_0= RULE_ID )
            // InternalJava.g:444:3: lv_className_2_0= RULE_ID
            {
            lv_className_2_0=(Token)match(input,RULE_ID,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_className_2_0, grammarAccess.getClass_declarationAccess().getClassNameIDTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getClass_declarationRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"className",
                      		lv_className_2_0, 
                      		"org.xtext.java.Java.ID");
              	    
            }

            }


            }

            // InternalJava.g:460:2: (this_EXTENDS_3= RULE_EXTENDS ( (lv_extend_4_0= ruleClass_name ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_EXTENDS) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalJava.g:460:3: this_EXTENDS_3= RULE_EXTENDS ( (lv_extend_4_0= ruleClass_name ) )
                    {
                    this_EXTENDS_3=(Token)match(input,RULE_EXTENDS,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_EXTENDS_3, grammarAccess.getClass_declarationAccess().getEXTENDSTerminalRuleCall_3_0()); 
                          
                    }
                    // InternalJava.g:464:1: ( (lv_extend_4_0= ruleClass_name ) )
                    // InternalJava.g:465:1: (lv_extend_4_0= ruleClass_name )
                    {
                    // InternalJava.g:465:1: (lv_extend_4_0= ruleClass_name )
                    // InternalJava.g:466:3: lv_extend_4_0= ruleClass_name
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getClass_declarationAccess().getExtendClass_nameParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_15);
                    lv_extend_4_0=ruleClass_name();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getClass_declarationRule());
                      	        }
                             		set(
                             			current, 
                             			"extend",
                              		lv_extend_4_0, 
                              		"org.xtext.java.Java.Class_name");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalJava.g:482:4: (otherlv_5= 'implements' ( (lv_implement_6_0= ruleInterface_name ) ) (this_COMMA_7= RULE_COMMA ( (lv_implements_8_0= ruleInterface_name ) ) )* )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==77) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalJava.g:482:6: otherlv_5= 'implements' ( (lv_implement_6_0= ruleInterface_name ) ) (this_COMMA_7= RULE_COMMA ( (lv_implements_8_0= ruleInterface_name ) ) )*
                    {
                    otherlv_5=(Token)match(input,77,FOLLOW_8); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getClass_declarationAccess().getImplementsKeyword_4_0());
                          
                    }
                    // InternalJava.g:486:1: ( (lv_implement_6_0= ruleInterface_name ) )
                    // InternalJava.g:487:1: (lv_implement_6_0= ruleInterface_name )
                    {
                    // InternalJava.g:487:1: (lv_implement_6_0= ruleInterface_name )
                    // InternalJava.g:488:3: lv_implement_6_0= ruleInterface_name
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getClass_declarationAccess().getImplementInterface_nameParserRuleCall_4_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_10);
                    lv_implement_6_0=ruleInterface_name();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getClass_declarationRule());
                      	        }
                             		set(
                             			current, 
                             			"implement",
                              		lv_implement_6_0, 
                              		"org.xtext.java.Java.Interface_name");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalJava.g:504:2: (this_COMMA_7= RULE_COMMA ( (lv_implements_8_0= ruleInterface_name ) ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==RULE_COMMA) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalJava.g:504:3: this_COMMA_7= RULE_COMMA ( (lv_implements_8_0= ruleInterface_name ) )
                    	    {
                    	    this_COMMA_7=(Token)match(input,RULE_COMMA,FOLLOW_8); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	          newLeafNode(this_COMMA_7, grammarAccess.getClass_declarationAccess().getCOMMATerminalRuleCall_4_2_0()); 
                    	          
                    	    }
                    	    // InternalJava.g:508:1: ( (lv_implements_8_0= ruleInterface_name ) )
                    	    // InternalJava.g:509:1: (lv_implements_8_0= ruleInterface_name )
                    	    {
                    	    // InternalJava.g:509:1: (lv_implements_8_0= ruleInterface_name )
                    	    // InternalJava.g:510:3: lv_implements_8_0= ruleInterface_name
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getClass_declarationAccess().getImplementsInterface_nameParserRuleCall_4_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_10);
                    	    lv_implements_8_0=ruleInterface_name();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getClass_declarationRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"implements",
                    	              		lv_implements_8_0, 
                    	              		"org.xtext.java.Java.Interface_name");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_9=(Token)match(input,74,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_9, grammarAccess.getClass_declarationAccess().getLeftCurlyBracketKeyword_5());
                  
            }
            // InternalJava.g:530:1: ( (lv_fields_10_0= ruleField_declaration ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>=RULE_DOC_COMMENT && LA15_0<=RULE_EOL)||LA15_0==RULE_ID||(LA15_0>=RULE_MOD && LA15_0<=RULE_STATIC)||(LA15_0>=84 && LA15_0<=92)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalJava.g:531:1: (lv_fields_10_0= ruleField_declaration )
            	    {
            	    // InternalJava.g:531:1: (lv_fields_10_0= ruleField_declaration )
            	    // InternalJava.g:532:3: lv_fields_10_0= ruleField_declaration
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getClass_declarationAccess().getFieldsField_declarationParserRuleCall_6_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_11);
            	    lv_fields_10_0=ruleField_declaration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getClass_declarationRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"fields",
            	              		lv_fields_10_0, 
            	              		"org.xtext.java.Java.Field_declaration");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            otherlv_11=(Token)match(input,75,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_11, grammarAccess.getClass_declarationAccess().getRightCurlyBracketKeyword_7());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClass_declaration"


    // $ANTLR start "entryRuleField_declaration"
    // InternalJava.g:560:1: entryRuleField_declaration returns [EObject current=null] : iv_ruleField_declaration= ruleField_declaration EOF ;
    public final EObject entryRuleField_declaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleField_declaration = null;


        try {
            // InternalJava.g:561:2: (iv_ruleField_declaration= ruleField_declaration EOF )
            // InternalJava.g:562:2: iv_ruleField_declaration= ruleField_declaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getField_declarationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleField_declaration=ruleField_declaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleField_declaration; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleField_declaration"


    // $ANTLR start "ruleField_declaration"
    // InternalJava.g:569:1: ruleField_declaration returns [EObject current=null] : ( ( ( (lv_doc_0_0= RULE_DOC_COMMENT ) )? ( ( (lv_name_1_0= ruleVariable_declaration ) ) | ( (lv_name_2_0= ruleConstructor_declaration ) ) | ( (lv_name_3_0= ruleMethod_declaration ) ) ) ) | ( (lv_name_4_0= ruleStatic_initializer ) ) | ( (lv_debug_5_0= RULE_EOL ) ) ) ;
    public final EObject ruleField_declaration() throws RecognitionException {
        EObject current = null;

        Token lv_doc_0_0=null;
        Token lv_debug_5_0=null;
        EObject lv_name_1_0 = null;

        EObject lv_name_2_0 = null;

        EObject lv_name_3_0 = null;

        EObject lv_name_4_0 = null;


         enterRule(); 
            
        try {
            // InternalJava.g:572:28: ( ( ( ( (lv_doc_0_0= RULE_DOC_COMMENT ) )? ( ( (lv_name_1_0= ruleVariable_declaration ) ) | ( (lv_name_2_0= ruleConstructor_declaration ) ) | ( (lv_name_3_0= ruleMethod_declaration ) ) ) ) | ( (lv_name_4_0= ruleStatic_initializer ) ) | ( (lv_debug_5_0= RULE_EOL ) ) ) )
            // InternalJava.g:573:1: ( ( ( (lv_doc_0_0= RULE_DOC_COMMENT ) )? ( ( (lv_name_1_0= ruleVariable_declaration ) ) | ( (lv_name_2_0= ruleConstructor_declaration ) ) | ( (lv_name_3_0= ruleMethod_declaration ) ) ) ) | ( (lv_name_4_0= ruleStatic_initializer ) ) | ( (lv_debug_5_0= RULE_EOL ) ) )
            {
            // InternalJava.g:573:1: ( ( ( (lv_doc_0_0= RULE_DOC_COMMENT ) )? ( ( (lv_name_1_0= ruleVariable_declaration ) ) | ( (lv_name_2_0= ruleConstructor_declaration ) ) | ( (lv_name_3_0= ruleMethod_declaration ) ) ) ) | ( (lv_name_4_0= ruleStatic_initializer ) ) | ( (lv_debug_5_0= RULE_EOL ) ) )
            int alt18=3;
            switch ( input.LA(1) ) {
            case RULE_DOC_COMMENT:
            case RULE_ID:
            case RULE_MOD:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 92:
                {
                alt18=1;
                }
                break;
            case RULE_STATIC:
                {
                int LA18_2 = input.LA(2);

                if ( (LA18_2==RULE_ID||(LA18_2>=RULE_MOD && LA18_2<=RULE_STATIC)||(LA18_2>=84 && LA18_2<=92)) ) {
                    alt18=1;
                }
                else if ( (LA18_2==74) ) {
                    alt18=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 18, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_EOL:
                {
                alt18=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // InternalJava.g:573:2: ( ( (lv_doc_0_0= RULE_DOC_COMMENT ) )? ( ( (lv_name_1_0= ruleVariable_declaration ) ) | ( (lv_name_2_0= ruleConstructor_declaration ) ) | ( (lv_name_3_0= ruleMethod_declaration ) ) ) )
                    {
                    // InternalJava.g:573:2: ( ( (lv_doc_0_0= RULE_DOC_COMMENT ) )? ( ( (lv_name_1_0= ruleVariable_declaration ) ) | ( (lv_name_2_0= ruleConstructor_declaration ) ) | ( (lv_name_3_0= ruleMethod_declaration ) ) ) )
                    // InternalJava.g:573:3: ( (lv_doc_0_0= RULE_DOC_COMMENT ) )? ( ( (lv_name_1_0= ruleVariable_declaration ) ) | ( (lv_name_2_0= ruleConstructor_declaration ) ) | ( (lv_name_3_0= ruleMethod_declaration ) ) )
                    {
                    // InternalJava.g:573:3: ( (lv_doc_0_0= RULE_DOC_COMMENT ) )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==RULE_DOC_COMMENT) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // InternalJava.g:574:1: (lv_doc_0_0= RULE_DOC_COMMENT )
                            {
                            // InternalJava.g:574:1: (lv_doc_0_0= RULE_DOC_COMMENT )
                            // InternalJava.g:575:3: lv_doc_0_0= RULE_DOC_COMMENT
                            {
                            lv_doc_0_0=(Token)match(input,RULE_DOC_COMMENT,FOLLOW_16); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_doc_0_0, grammarAccess.getField_declarationAccess().getDocDOC_COMMENTTerminalRuleCall_0_0_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getField_declarationRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"doc",
                                      		lv_doc_0_0, 
                                      		"org.xtext.java.Java.DOC_COMMENT");
                              	    
                            }

                            }


                            }
                            break;

                    }

                    // InternalJava.g:591:3: ( ( (lv_name_1_0= ruleVariable_declaration ) ) | ( (lv_name_2_0= ruleConstructor_declaration ) ) | ( (lv_name_3_0= ruleMethod_declaration ) ) )
                    int alt17=3;
                    alt17 = dfa17.predict(input);
                    switch (alt17) {
                        case 1 :
                            // InternalJava.g:591:4: ( (lv_name_1_0= ruleVariable_declaration ) )
                            {
                            // InternalJava.g:591:4: ( (lv_name_1_0= ruleVariable_declaration ) )
                            // InternalJava.g:592:1: (lv_name_1_0= ruleVariable_declaration )
                            {
                            // InternalJava.g:592:1: (lv_name_1_0= ruleVariable_declaration )
                            // InternalJava.g:593:3: lv_name_1_0= ruleVariable_declaration
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getField_declarationAccess().getNameVariable_declarationParserRuleCall_0_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_2);
                            lv_name_1_0=ruleVariable_declaration();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getField_declarationRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"name",
                                      		lv_name_1_0, 
                                      		"org.xtext.java.Java.Variable_declaration");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalJava.g:610:6: ( (lv_name_2_0= ruleConstructor_declaration ) )
                            {
                            // InternalJava.g:610:6: ( (lv_name_2_0= ruleConstructor_declaration ) )
                            // InternalJava.g:611:1: (lv_name_2_0= ruleConstructor_declaration )
                            {
                            // InternalJava.g:611:1: (lv_name_2_0= ruleConstructor_declaration )
                            // InternalJava.g:612:3: lv_name_2_0= ruleConstructor_declaration
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getField_declarationAccess().getNameConstructor_declarationParserRuleCall_0_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_2);
                            lv_name_2_0=ruleConstructor_declaration();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getField_declarationRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"name",
                                      		lv_name_2_0, 
                                      		"org.xtext.java.Java.Constructor_declaration");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 3 :
                            // InternalJava.g:629:6: ( (lv_name_3_0= ruleMethod_declaration ) )
                            {
                            // InternalJava.g:629:6: ( (lv_name_3_0= ruleMethod_declaration ) )
                            // InternalJava.g:630:1: (lv_name_3_0= ruleMethod_declaration )
                            {
                            // InternalJava.g:630:1: (lv_name_3_0= ruleMethod_declaration )
                            // InternalJava.g:631:3: lv_name_3_0= ruleMethod_declaration
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getField_declarationAccess().getNameMethod_declarationParserRuleCall_0_1_2_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_2);
                            lv_name_3_0=ruleMethod_declaration();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getField_declarationRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"name",
                                      		lv_name_3_0, 
                                      		"org.xtext.java.Java.Method_declaration");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalJava.g:648:6: ( (lv_name_4_0= ruleStatic_initializer ) )
                    {
                    // InternalJava.g:648:6: ( (lv_name_4_0= ruleStatic_initializer ) )
                    // InternalJava.g:649:1: (lv_name_4_0= ruleStatic_initializer )
                    {
                    // InternalJava.g:649:1: (lv_name_4_0= ruleStatic_initializer )
                    // InternalJava.g:650:3: lv_name_4_0= ruleStatic_initializer
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getField_declarationAccess().getNameStatic_initializerParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_name_4_0=ruleStatic_initializer();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getField_declarationRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_4_0, 
                              		"org.xtext.java.Java.Static_initializer");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalJava.g:667:6: ( (lv_debug_5_0= RULE_EOL ) )
                    {
                    // InternalJava.g:667:6: ( (lv_debug_5_0= RULE_EOL ) )
                    // InternalJava.g:668:1: (lv_debug_5_0= RULE_EOL )
                    {
                    // InternalJava.g:668:1: (lv_debug_5_0= RULE_EOL )
                    // InternalJava.g:669:3: lv_debug_5_0= RULE_EOL
                    {
                    lv_debug_5_0=(Token)match(input,RULE_EOL,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_debug_5_0, grammarAccess.getField_declarationAccess().getDebugEOLTerminalRuleCall_2_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getField_declarationRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"debug",
                              		lv_debug_5_0, 
                              		"org.xtext.java.Java.EOL");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleField_declaration"


    // $ANTLR start "entryRuleMethod_declaration"
    // InternalJava.g:693:1: entryRuleMethod_declaration returns [EObject current=null] : iv_ruleMethod_declaration= ruleMethod_declaration EOF ;
    public final EObject entryRuleMethod_declaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethod_declaration = null;


        try {
            // InternalJava.g:694:2: (iv_ruleMethod_declaration= ruleMethod_declaration EOF )
            // InternalJava.g:695:2: iv_ruleMethod_declaration= ruleMethod_declaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMethod_declarationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMethod_declaration=ruleMethod_declaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMethod_declaration; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMethod_declaration"


    // $ANTLR start "ruleMethod_declaration"
    // InternalJava.g:702:1: ruleMethod_declaration returns [EObject current=null] : ( ( (lv_modifiers_0_0= ruleModifier ) )* ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_parameter_4_0= ruleParameter_list ) )? otherlv_5= ')' ( (otherlv_6= '[' otherlv_7= ']' ) | otherlv_8= '[]' )* ( ( (lv_statement_9_0= ruleStatement_block ) ) | ( (lv_debug_10_0= RULE_EOL ) ) ) ) ;
    public final EObject ruleMethod_declaration() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token lv_debug_10_0=null;
        AntlrDatatypeRuleToken lv_modifiers_0_0 = null;

        EObject lv_type_1_0 = null;

        EObject lv_parameter_4_0 = null;

        EObject lv_statement_9_0 = null;


         enterRule(); 
            
        try {
            // InternalJava.g:705:28: ( ( ( (lv_modifiers_0_0= ruleModifier ) )* ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_parameter_4_0= ruleParameter_list ) )? otherlv_5= ')' ( (otherlv_6= '[' otherlv_7= ']' ) | otherlv_8= '[]' )* ( ( (lv_statement_9_0= ruleStatement_block ) ) | ( (lv_debug_10_0= RULE_EOL ) ) ) ) )
            // InternalJava.g:706:1: ( ( (lv_modifiers_0_0= ruleModifier ) )* ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_parameter_4_0= ruleParameter_list ) )? otherlv_5= ')' ( (otherlv_6= '[' otherlv_7= ']' ) | otherlv_8= '[]' )* ( ( (lv_statement_9_0= ruleStatement_block ) ) | ( (lv_debug_10_0= RULE_EOL ) ) ) )
            {
            // InternalJava.g:706:1: ( ( (lv_modifiers_0_0= ruleModifier ) )* ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_parameter_4_0= ruleParameter_list ) )? otherlv_5= ')' ( (otherlv_6= '[' otherlv_7= ']' ) | otherlv_8= '[]' )* ( ( (lv_statement_9_0= ruleStatement_block ) ) | ( (lv_debug_10_0= RULE_EOL ) ) ) )
            // InternalJava.g:706:2: ( (lv_modifiers_0_0= ruleModifier ) )* ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '(' ( (lv_parameter_4_0= ruleParameter_list ) )? otherlv_5= ')' ( (otherlv_6= '[' otherlv_7= ']' ) | otherlv_8= '[]' )* ( ( (lv_statement_9_0= ruleStatement_block ) ) | ( (lv_debug_10_0= RULE_EOL ) ) )
            {
            // InternalJava.g:706:2: ( (lv_modifiers_0_0= ruleModifier ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>=RULE_MOD && LA19_0<=RULE_STATIC)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalJava.g:707:1: (lv_modifiers_0_0= ruleModifier )
            	    {
            	    // InternalJava.g:707:1: (lv_modifiers_0_0= ruleModifier )
            	    // InternalJava.g:708:3: lv_modifiers_0_0= ruleModifier
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMethod_declarationAccess().getModifiersModifierParserRuleCall_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_14);
            	    lv_modifiers_0_0=ruleModifier();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getMethod_declarationRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"modifiers",
            	              		lv_modifiers_0_0, 
            	              		"org.xtext.java.Java.Modifier");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            // InternalJava.g:724:3: ( (lv_type_1_0= ruleType ) )
            // InternalJava.g:725:1: (lv_type_1_0= ruleType )
            {
            // InternalJava.g:725:1: (lv_type_1_0= ruleType )
            // InternalJava.g:726:3: lv_type_1_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMethod_declarationAccess().getTypeTypeParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_8);
            lv_type_1_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMethod_declarationRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_1_0, 
                      		"org.xtext.java.Java.Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalJava.g:742:2: ( (lv_name_2_0= RULE_ID ) )
            // InternalJava.g:743:1: (lv_name_2_0= RULE_ID )
            {
            // InternalJava.g:743:1: (lv_name_2_0= RULE_ID )
            // InternalJava.g:744:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_2_0, grammarAccess.getMethod_declarationAccess().getNameIDTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getMethod_declarationRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_2_0, 
                      		"org.xtext.java.Java.ID");
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,78,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getMethod_declarationAccess().getLeftParenthesisKeyword_3());
                  
            }
            // InternalJava.g:764:1: ( (lv_parameter_4_0= ruleParameter_list ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_ID||(LA20_0>=84 && LA20_0<=92)) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalJava.g:765:1: (lv_parameter_4_0= ruleParameter_list )
                    {
                    // InternalJava.g:765:1: (lv_parameter_4_0= ruleParameter_list )
                    // InternalJava.g:766:3: lv_parameter_4_0= ruleParameter_list
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMethod_declarationAccess().getParameterParameter_listParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_19);
                    lv_parameter_4_0=ruleParameter_list();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getMethod_declarationRule());
                      	        }
                             		set(
                             			current, 
                             			"parameter",
                              		lv_parameter_4_0, 
                              		"org.xtext.java.Java.Parameter_list");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,79,FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getMethod_declarationAccess().getRightParenthesisKeyword_5());
                  
            }
            // InternalJava.g:786:1: ( (otherlv_6= '[' otherlv_7= ']' ) | otherlv_8= '[]' )*
            loop21:
            do {
                int alt21=3;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==80) ) {
                    alt21=1;
                }
                else if ( (LA21_0==82) ) {
                    alt21=2;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalJava.g:786:2: (otherlv_6= '[' otherlv_7= ']' )
            	    {
            	    // InternalJava.g:786:2: (otherlv_6= '[' otherlv_7= ']' )
            	    // InternalJava.g:786:4: otherlv_6= '[' otherlv_7= ']'
            	    {
            	    otherlv_6=(Token)match(input,80,FOLLOW_21); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_6, grammarAccess.getMethod_declarationAccess().getLeftSquareBracketKeyword_6_0_0());
            	          
            	    }
            	    otherlv_7=(Token)match(input,81,FOLLOW_20); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_7, grammarAccess.getMethod_declarationAccess().getRightSquareBracketKeyword_6_0_1());
            	          
            	    }

            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalJava.g:795:7: otherlv_8= '[]'
            	    {
            	    otherlv_8=(Token)match(input,82,FOLLOW_20); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_8, grammarAccess.getMethod_declarationAccess().getLeftSquareBracketRightSquareBracketKeyword_6_1());
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            // InternalJava.g:799:3: ( ( (lv_statement_9_0= ruleStatement_block ) ) | ( (lv_debug_10_0= RULE_EOL ) ) )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==74) ) {
                alt22=1;
            }
            else if ( (LA22_0==RULE_EOL) ) {
                alt22=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // InternalJava.g:799:4: ( (lv_statement_9_0= ruleStatement_block ) )
                    {
                    // InternalJava.g:799:4: ( (lv_statement_9_0= ruleStatement_block ) )
                    // InternalJava.g:800:1: (lv_statement_9_0= ruleStatement_block )
                    {
                    // InternalJava.g:800:1: (lv_statement_9_0= ruleStatement_block )
                    // InternalJava.g:801:3: lv_statement_9_0= ruleStatement_block
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMethod_declarationAccess().getStatementStatement_blockParserRuleCall_7_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_statement_9_0=ruleStatement_block();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getMethod_declarationRule());
                      	        }
                             		set(
                             			current, 
                             			"statement",
                              		lv_statement_9_0, 
                              		"org.xtext.java.Java.Statement_block");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalJava.g:818:6: ( (lv_debug_10_0= RULE_EOL ) )
                    {
                    // InternalJava.g:818:6: ( (lv_debug_10_0= RULE_EOL ) )
                    // InternalJava.g:819:1: (lv_debug_10_0= RULE_EOL )
                    {
                    // InternalJava.g:819:1: (lv_debug_10_0= RULE_EOL )
                    // InternalJava.g:820:3: lv_debug_10_0= RULE_EOL
                    {
                    lv_debug_10_0=(Token)match(input,RULE_EOL,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_debug_10_0, grammarAccess.getMethod_declarationAccess().getDebugEOLTerminalRuleCall_7_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getMethod_declarationRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"debug",
                              		lv_debug_10_0, 
                              		"org.xtext.java.Java.EOL");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMethod_declaration"


    // $ANTLR start "entryRuleMethod_call"
    // InternalJava.g:844:1: entryRuleMethod_call returns [EObject current=null] : iv_ruleMethod_call= ruleMethod_call EOF ;
    public final EObject entryRuleMethod_call() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethod_call = null;


        try {
            // InternalJava.g:845:2: (iv_ruleMethod_call= ruleMethod_call EOF )
            // InternalJava.g:846:2: iv_ruleMethod_call= ruleMethod_call EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMethod_callRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMethod_call=ruleMethod_call();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMethod_call; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMethod_call"


    // $ANTLR start "ruleMethod_call"
    // InternalJava.g:853:1: ruleMethod_call returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( (lv_parameter_2_0= ruleParameter_list_method_call ) )? otherlv_3= ')' ) ;
    public final EObject ruleMethod_call() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_parameter_2_0 = null;


         enterRule(); 
            
        try {
            // InternalJava.g:856:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( (lv_parameter_2_0= ruleParameter_list_method_call ) )? otherlv_3= ')' ) )
            // InternalJava.g:857:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( (lv_parameter_2_0= ruleParameter_list_method_call ) )? otherlv_3= ')' )
            {
            // InternalJava.g:857:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( (lv_parameter_2_0= ruleParameter_list_method_call ) )? otherlv_3= ')' )
            // InternalJava.g:857:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '(' ( (lv_parameter_2_0= ruleParameter_list_method_call ) )? otherlv_3= ')'
            {
            // InternalJava.g:857:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalJava.g:858:1: (lv_name_0_0= RULE_ID )
            {
            // InternalJava.g:858:1: (lv_name_0_0= RULE_ID )
            // InternalJava.g:859:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getMethod_callAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getMethod_callRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"org.xtext.java.Java.ID");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,78,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getMethod_callAccess().getLeftParenthesisKeyword_1());
                  
            }
            // InternalJava.g:879:1: ( (lv_parameter_2_0= ruleParameter_list_method_call ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==RULE_ID) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalJava.g:880:1: (lv_parameter_2_0= ruleParameter_list_method_call )
                    {
                    // InternalJava.g:880:1: (lv_parameter_2_0= ruleParameter_list_method_call )
                    // InternalJava.g:881:3: lv_parameter_2_0= ruleParameter_list_method_call
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getMethod_callAccess().getParameterParameter_list_method_callParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_19);
                    lv_parameter_2_0=ruleParameter_list_method_call();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getMethod_callRule());
                      	        }
                             		set(
                             			current, 
                             			"parameter",
                              		lv_parameter_2_0, 
                              		"org.xtext.java.Java.Parameter_list_method_call");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,79,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getMethod_callAccess().getRightParenthesisKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMethod_call"


    // $ANTLR start "entryRuleConstructor_declaration"
    // InternalJava.g:909:1: entryRuleConstructor_declaration returns [EObject current=null] : iv_ruleConstructor_declaration= ruleConstructor_declaration EOF ;
    public final EObject entryRuleConstructor_declaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstructor_declaration = null;


        try {
            // InternalJava.g:910:2: (iv_ruleConstructor_declaration= ruleConstructor_declaration EOF )
            // InternalJava.g:911:2: iv_ruleConstructor_declaration= ruleConstructor_declaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstructor_declarationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleConstructor_declaration=ruleConstructor_declaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstructor_declaration; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstructor_declaration"


    // $ANTLR start "ruleConstructor_declaration"
    // InternalJava.g:918:1: ruleConstructor_declaration returns [EObject current=null] : ( ( (lv_modifiers_0_0= ruleModifier ) )* ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_parameters_3_0= ruleParameter_list ) )? otherlv_4= ')' ( (lv_statement_5_0= ruleStatement_block ) ) ) ;
    public final EObject ruleConstructor_declaration() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_modifiers_0_0 = null;

        EObject lv_parameters_3_0 = null;

        EObject lv_statement_5_0 = null;


         enterRule(); 
            
        try {
            // InternalJava.g:921:28: ( ( ( (lv_modifiers_0_0= ruleModifier ) )* ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_parameters_3_0= ruleParameter_list ) )? otherlv_4= ')' ( (lv_statement_5_0= ruleStatement_block ) ) ) )
            // InternalJava.g:922:1: ( ( (lv_modifiers_0_0= ruleModifier ) )* ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_parameters_3_0= ruleParameter_list ) )? otherlv_4= ')' ( (lv_statement_5_0= ruleStatement_block ) ) )
            {
            // InternalJava.g:922:1: ( ( (lv_modifiers_0_0= ruleModifier ) )* ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_parameters_3_0= ruleParameter_list ) )? otherlv_4= ')' ( (lv_statement_5_0= ruleStatement_block ) ) )
            // InternalJava.g:922:2: ( (lv_modifiers_0_0= ruleModifier ) )* ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_parameters_3_0= ruleParameter_list ) )? otherlv_4= ')' ( (lv_statement_5_0= ruleStatement_block ) )
            {
            // InternalJava.g:922:2: ( (lv_modifiers_0_0= ruleModifier ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>=RULE_MOD && LA24_0<=RULE_STATIC)) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalJava.g:923:1: (lv_modifiers_0_0= ruleModifier )
            	    {
            	    // InternalJava.g:923:1: (lv_modifiers_0_0= ruleModifier )
            	    // InternalJava.g:924:3: lv_modifiers_0_0= ruleModifier
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getConstructor_declarationAccess().getModifiersModifierParserRuleCall_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_23);
            	    lv_modifiers_0_0=ruleModifier();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getConstructor_declarationRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"modifiers",
            	              		lv_modifiers_0_0, 
            	              		"org.xtext.java.Java.Modifier");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

            // InternalJava.g:940:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalJava.g:941:1: (lv_name_1_0= RULE_ID )
            {
            // InternalJava.g:941:1: (lv_name_1_0= RULE_ID )
            // InternalJava.g:942:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getConstructor_declarationAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getConstructor_declarationRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"org.xtext.java.Java.ID");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,78,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getConstructor_declarationAccess().getLeftParenthesisKeyword_2());
                  
            }
            // InternalJava.g:962:1: ( (lv_parameters_3_0= ruleParameter_list ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_ID||(LA25_0>=84 && LA25_0<=92)) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalJava.g:963:1: (lv_parameters_3_0= ruleParameter_list )
                    {
                    // InternalJava.g:963:1: (lv_parameters_3_0= ruleParameter_list )
                    // InternalJava.g:964:3: lv_parameters_3_0= ruleParameter_list
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConstructor_declarationAccess().getParametersParameter_listParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_19);
                    lv_parameters_3_0=ruleParameter_list();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getConstructor_declarationRule());
                      	        }
                             		set(
                             			current, 
                             			"parameters",
                              		lv_parameters_3_0, 
                              		"org.xtext.java.Java.Parameter_list");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,79,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getConstructor_declarationAccess().getRightParenthesisKeyword_4());
                  
            }
            // InternalJava.g:984:1: ( (lv_statement_5_0= ruleStatement_block ) )
            // InternalJava.g:985:1: (lv_statement_5_0= ruleStatement_block )
            {
            // InternalJava.g:985:1: (lv_statement_5_0= ruleStatement_block )
            // InternalJava.g:986:3: lv_statement_5_0= ruleStatement_block
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConstructor_declarationAccess().getStatementStatement_blockParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_statement_5_0=ruleStatement_block();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getConstructor_declarationRule());
              	        }
                     		set(
                     			current, 
                     			"statement",
                      		lv_statement_5_0, 
                      		"org.xtext.java.Java.Statement_block");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstructor_declaration"


    // $ANTLR start "entryRuleParameter_list_method_call"
    // InternalJava.g:1010:1: entryRuleParameter_list_method_call returns [EObject current=null] : iv_ruleParameter_list_method_call= ruleParameter_list_method_call EOF ;
    public final EObject entryRuleParameter_list_method_call() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter_list_method_call = null;


        try {
            // InternalJava.g:1011:2: (iv_ruleParameter_list_method_call= ruleParameter_list_method_call EOF )
            // InternalJava.g:1012:2: iv_ruleParameter_list_method_call= ruleParameter_list_method_call EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameter_list_method_callRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParameter_list_method_call=ruleParameter_list_method_call();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameter_list_method_call; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameter_list_method_call"


    // $ANTLR start "ruleParameter_list_method_call"
    // InternalJava.g:1019:1: ruleParameter_list_method_call returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (this_COMMA_1= RULE_COMMA ( (lv_parameters_2_0= RULE_ID ) ) )* ) ;
    public final EObject ruleParameter_list_method_call() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token this_COMMA_1=null;
        Token lv_parameters_2_0=null;

         enterRule(); 
            
        try {
            // InternalJava.g:1022:28: ( ( ( (lv_name_0_0= RULE_ID ) ) (this_COMMA_1= RULE_COMMA ( (lv_parameters_2_0= RULE_ID ) ) )* ) )
            // InternalJava.g:1023:1: ( ( (lv_name_0_0= RULE_ID ) ) (this_COMMA_1= RULE_COMMA ( (lv_parameters_2_0= RULE_ID ) ) )* )
            {
            // InternalJava.g:1023:1: ( ( (lv_name_0_0= RULE_ID ) ) (this_COMMA_1= RULE_COMMA ( (lv_parameters_2_0= RULE_ID ) ) )* )
            // InternalJava.g:1023:2: ( (lv_name_0_0= RULE_ID ) ) (this_COMMA_1= RULE_COMMA ( (lv_parameters_2_0= RULE_ID ) ) )*
            {
            // InternalJava.g:1023:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalJava.g:1024:1: (lv_name_0_0= RULE_ID )
            {
            // InternalJava.g:1024:1: (lv_name_0_0= RULE_ID )
            // InternalJava.g:1025:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getParameter_list_method_callAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getParameter_list_method_callRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"org.xtext.java.Java.ID");
              	    
            }

            }


            }

            // InternalJava.g:1041:2: (this_COMMA_1= RULE_COMMA ( (lv_parameters_2_0= RULE_ID ) ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==RULE_COMMA) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalJava.g:1041:3: this_COMMA_1= RULE_COMMA ( (lv_parameters_2_0= RULE_ID ) )
            	    {
            	    this_COMMA_1=(Token)match(input,RULE_COMMA,FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_COMMA_1, grammarAccess.getParameter_list_method_callAccess().getCOMMATerminalRuleCall_1_0()); 
            	          
            	    }
            	    // InternalJava.g:1045:1: ( (lv_parameters_2_0= RULE_ID ) )
            	    // InternalJava.g:1046:1: (lv_parameters_2_0= RULE_ID )
            	    {
            	    // InternalJava.g:1046:1: (lv_parameters_2_0= RULE_ID )
            	    // InternalJava.g:1047:3: lv_parameters_2_0= RULE_ID
            	    {
            	    lv_parameters_2_0=(Token)match(input,RULE_ID,FOLLOW_25); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      			newLeafNode(lv_parameters_2_0, grammarAccess.getParameter_list_method_callAccess().getParametersIDTerminalRuleCall_1_1_0()); 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElement(grammarAccess.getParameter_list_method_callRule());
            	      	        }
            	             		addWithLastConsumed(
            	             			current, 
            	             			"parameters",
            	              		lv_parameters_2_0, 
            	              		"org.xtext.java.Java.ID");
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameter_list_method_call"


    // $ANTLR start "entryRuleParameter_list"
    // InternalJava.g:1071:1: entryRuleParameter_list returns [EObject current=null] : iv_ruleParameter_list= ruleParameter_list EOF ;
    public final EObject entryRuleParameter_list() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter_list = null;


        try {
            // InternalJava.g:1072:2: (iv_ruleParameter_list= ruleParameter_list EOF )
            // InternalJava.g:1073:2: iv_ruleParameter_list= ruleParameter_list EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameter_listRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParameter_list=ruleParameter_list();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameter_list; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameter_list"


    // $ANTLR start "ruleParameter_list"
    // InternalJava.g:1080:1: ruleParameter_list returns [EObject current=null] : ( ( (lv_parameter_0_0= ruleParameter ) ) (this_COMMA_1= RULE_COMMA ( (lv_parameters_2_0= ruleParameter ) ) )* ) ;
    public final EObject ruleParameter_list() throws RecognitionException {
        EObject current = null;

        Token this_COMMA_1=null;
        EObject lv_parameter_0_0 = null;

        EObject lv_parameters_2_0 = null;


         enterRule(); 
            
        try {
            // InternalJava.g:1083:28: ( ( ( (lv_parameter_0_0= ruleParameter ) ) (this_COMMA_1= RULE_COMMA ( (lv_parameters_2_0= ruleParameter ) ) )* ) )
            // InternalJava.g:1084:1: ( ( (lv_parameter_0_0= ruleParameter ) ) (this_COMMA_1= RULE_COMMA ( (lv_parameters_2_0= ruleParameter ) ) )* )
            {
            // InternalJava.g:1084:1: ( ( (lv_parameter_0_0= ruleParameter ) ) (this_COMMA_1= RULE_COMMA ( (lv_parameters_2_0= ruleParameter ) ) )* )
            // InternalJava.g:1084:2: ( (lv_parameter_0_0= ruleParameter ) ) (this_COMMA_1= RULE_COMMA ( (lv_parameters_2_0= ruleParameter ) ) )*
            {
            // InternalJava.g:1084:2: ( (lv_parameter_0_0= ruleParameter ) )
            // InternalJava.g:1085:1: (lv_parameter_0_0= ruleParameter )
            {
            // InternalJava.g:1085:1: (lv_parameter_0_0= ruleParameter )
            // InternalJava.g:1086:3: lv_parameter_0_0= ruleParameter
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParameter_listAccess().getParameterParameterParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_25);
            lv_parameter_0_0=ruleParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getParameter_listRule());
              	        }
                     		set(
                     			current, 
                     			"parameter",
                      		lv_parameter_0_0, 
                      		"org.xtext.java.Java.Parameter");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalJava.g:1102:2: (this_COMMA_1= RULE_COMMA ( (lv_parameters_2_0= ruleParameter ) ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==RULE_COMMA) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalJava.g:1102:3: this_COMMA_1= RULE_COMMA ( (lv_parameters_2_0= ruleParameter ) )
            	    {
            	    this_COMMA_1=(Token)match(input,RULE_COMMA,FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_COMMA_1, grammarAccess.getParameter_listAccess().getCOMMATerminalRuleCall_1_0()); 
            	          
            	    }
            	    // InternalJava.g:1106:1: ( (lv_parameters_2_0= ruleParameter ) )
            	    // InternalJava.g:1107:1: (lv_parameters_2_0= ruleParameter )
            	    {
            	    // InternalJava.g:1107:1: (lv_parameters_2_0= ruleParameter )
            	    // InternalJava.g:1108:3: lv_parameters_2_0= ruleParameter
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getParameter_listAccess().getParametersParameterParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_25);
            	    lv_parameters_2_0=ruleParameter();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getParameter_listRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"parameters",
            	              		lv_parameters_2_0, 
            	              		"org.xtext.java.Java.Parameter");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameter_list"


    // $ANTLR start "entryRuleParameter"
    // InternalJava.g:1132:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalJava.g:1133:2: (iv_ruleParameter= ruleParameter EOF )
            // InternalJava.g:1134:2: iv_ruleParameter= ruleParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParameter=ruleParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameter; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // InternalJava.g:1141:1: ruleParameter returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= '[' otherlv_3= ']' ) | otherlv_4= '[]' )* ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_type_0_0 = null;


         enterRule(); 
            
        try {
            // InternalJava.g:1144:28: ( ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= '[' otherlv_3= ']' ) | otherlv_4= '[]' )* ) )
            // InternalJava.g:1145:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= '[' otherlv_3= ']' ) | otherlv_4= '[]' )* )
            {
            // InternalJava.g:1145:1: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= '[' otherlv_3= ']' ) | otherlv_4= '[]' )* )
            // InternalJava.g:1145:2: ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= '[' otherlv_3= ']' ) | otherlv_4= '[]' )*
            {
            // InternalJava.g:1145:2: ( (lv_type_0_0= ruleType ) )
            // InternalJava.g:1146:1: (lv_type_0_0= ruleType )
            {
            // InternalJava.g:1146:1: (lv_type_0_0= ruleType )
            // InternalJava.g:1147:3: lv_type_0_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getParameterAccess().getTypeTypeParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_8);
            lv_type_0_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getParameterRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_0_0, 
                      		"org.xtext.java.Java.Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalJava.g:1163:2: ( (lv_name_1_0= RULE_ID ) )
            // InternalJava.g:1164:1: (lv_name_1_0= RULE_ID )
            {
            // InternalJava.g:1164:1: (lv_name_1_0= RULE_ID )
            // InternalJava.g:1165:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getParameterRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"org.xtext.java.Java.ID");
              	    
            }

            }


            }

            // InternalJava.g:1181:2: ( (otherlv_2= '[' otherlv_3= ']' ) | otherlv_4= '[]' )*
            loop28:
            do {
                int alt28=3;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==80) ) {
                    alt28=1;
                }
                else if ( (LA28_0==82) ) {
                    alt28=2;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalJava.g:1181:3: (otherlv_2= '[' otherlv_3= ']' )
            	    {
            	    // InternalJava.g:1181:3: (otherlv_2= '[' otherlv_3= ']' )
            	    // InternalJava.g:1181:5: otherlv_2= '[' otherlv_3= ']'
            	    {
            	    otherlv_2=(Token)match(input,80,FOLLOW_21); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getParameterAccess().getLeftSquareBracketKeyword_2_0_0());
            	          
            	    }
            	    otherlv_3=(Token)match(input,81,FOLLOW_26); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getParameterAccess().getRightSquareBracketKeyword_2_0_1());
            	          
            	    }

            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalJava.g:1190:7: otherlv_4= '[]'
            	    {
            	    otherlv_4=(Token)match(input,82,FOLLOW_26); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_4, grammarAccess.getParameterAccess().getLeftSquareBracketRightSquareBracketKeyword_2_1());
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleVariable_declaration"
    // InternalJava.g:1202:1: entryRuleVariable_declaration returns [EObject current=null] : iv_ruleVariable_declaration= ruleVariable_declaration EOF ;
    public final EObject entryRuleVariable_declaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable_declaration = null;


        try {
            // InternalJava.g:1203:2: (iv_ruleVariable_declaration= ruleVariable_declaration EOF )
            // InternalJava.g:1204:2: iv_ruleVariable_declaration= ruleVariable_declaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariable_declarationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVariable_declaration=ruleVariable_declaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariable_declaration; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariable_declaration"


    // $ANTLR start "ruleVariable_declaration"
    // InternalJava.g:1211:1: ruleVariable_declaration returns [EObject current=null] : ( ( (lv_modifiers_0_0= ruleModifier ) )* ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleVariable_declarator ) ) (this_COMMA_3= RULE_COMMA ( (lv_names_4_0= ruleVariable_declarator ) ) )* this_EOL_5= RULE_EOL ) ;
    public final EObject ruleVariable_declaration() throws RecognitionException {
        EObject current = null;

        Token this_COMMA_3=null;
        Token this_EOL_5=null;
        AntlrDatatypeRuleToken lv_modifiers_0_0 = null;

        EObject lv_type_1_0 = null;

        EObject lv_name_2_0 = null;

        EObject lv_names_4_0 = null;


         enterRule(); 
            
        try {
            // InternalJava.g:1214:28: ( ( ( (lv_modifiers_0_0= ruleModifier ) )* ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleVariable_declarator ) ) (this_COMMA_3= RULE_COMMA ( (lv_names_4_0= ruleVariable_declarator ) ) )* this_EOL_5= RULE_EOL ) )
            // InternalJava.g:1215:1: ( ( (lv_modifiers_0_0= ruleModifier ) )* ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleVariable_declarator ) ) (this_COMMA_3= RULE_COMMA ( (lv_names_4_0= ruleVariable_declarator ) ) )* this_EOL_5= RULE_EOL )
            {
            // InternalJava.g:1215:1: ( ( (lv_modifiers_0_0= ruleModifier ) )* ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleVariable_declarator ) ) (this_COMMA_3= RULE_COMMA ( (lv_names_4_0= ruleVariable_declarator ) ) )* this_EOL_5= RULE_EOL )
            // InternalJava.g:1215:2: ( (lv_modifiers_0_0= ruleModifier ) )* ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= ruleVariable_declarator ) ) (this_COMMA_3= RULE_COMMA ( (lv_names_4_0= ruleVariable_declarator ) ) )* this_EOL_5= RULE_EOL
            {
            // InternalJava.g:1215:2: ( (lv_modifiers_0_0= ruleModifier ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( ((LA29_0>=RULE_MOD && LA29_0<=RULE_STATIC)) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalJava.g:1216:1: (lv_modifiers_0_0= ruleModifier )
            	    {
            	    // InternalJava.g:1216:1: (lv_modifiers_0_0= ruleModifier )
            	    // InternalJava.g:1217:3: lv_modifiers_0_0= ruleModifier
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getVariable_declarationAccess().getModifiersModifierParserRuleCall_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_14);
            	    lv_modifiers_0_0=ruleModifier();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getVariable_declarationRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"modifiers",
            	              		lv_modifiers_0_0, 
            	              		"org.xtext.java.Java.Modifier");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

            // InternalJava.g:1233:3: ( (lv_type_1_0= ruleType ) )
            // InternalJava.g:1234:1: (lv_type_1_0= ruleType )
            {
            // InternalJava.g:1234:1: (lv_type_1_0= ruleType )
            // InternalJava.g:1235:3: lv_type_1_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariable_declarationAccess().getTypeTypeParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_8);
            lv_type_1_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getVariable_declarationRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_1_0, 
                      		"org.xtext.java.Java.Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalJava.g:1251:2: ( (lv_name_2_0= ruleVariable_declarator ) )
            // InternalJava.g:1252:1: (lv_name_2_0= ruleVariable_declarator )
            {
            // InternalJava.g:1252:1: (lv_name_2_0= ruleVariable_declarator )
            // InternalJava.g:1253:3: lv_name_2_0= ruleVariable_declarator
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVariable_declarationAccess().getNameVariable_declaratorParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_27);
            lv_name_2_0=ruleVariable_declarator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getVariable_declarationRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_2_0, 
                      		"org.xtext.java.Java.Variable_declarator");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalJava.g:1269:2: (this_COMMA_3= RULE_COMMA ( (lv_names_4_0= ruleVariable_declarator ) ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==RULE_COMMA) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalJava.g:1269:3: this_COMMA_3= RULE_COMMA ( (lv_names_4_0= ruleVariable_declarator ) )
            	    {
            	    this_COMMA_3=(Token)match(input,RULE_COMMA,FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_COMMA_3, grammarAccess.getVariable_declarationAccess().getCOMMATerminalRuleCall_3_0()); 
            	          
            	    }
            	    // InternalJava.g:1273:1: ( (lv_names_4_0= ruleVariable_declarator ) )
            	    // InternalJava.g:1274:1: (lv_names_4_0= ruleVariable_declarator )
            	    {
            	    // InternalJava.g:1274:1: (lv_names_4_0= ruleVariable_declarator )
            	    // InternalJava.g:1275:3: lv_names_4_0= ruleVariable_declarator
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getVariable_declarationAccess().getNamesVariable_declaratorParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_27);
            	    lv_names_4_0=ruleVariable_declarator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getVariable_declarationRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"names",
            	              		lv_names_4_0, 
            	              		"org.xtext.java.Java.Variable_declarator");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

            this_EOL_5=(Token)match(input,RULE_EOL,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_EOL_5, grammarAccess.getVariable_declarationAccess().getEOLTerminalRuleCall_4()); 
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariable_declaration"


    // $ANTLR start "entryRuleVariable_declarator"
    // InternalJava.g:1303:1: entryRuleVariable_declarator returns [EObject current=null] : iv_ruleVariable_declarator= ruleVariable_declarator EOF ;
    public final EObject entryRuleVariable_declarator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable_declarator = null;


        try {
            // InternalJava.g:1304:2: (iv_ruleVariable_declarator= ruleVariable_declarator EOF )
            // InternalJava.g:1305:2: iv_ruleVariable_declarator= ruleVariable_declarator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariable_declaratorRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVariable_declarator=ruleVariable_declarator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariable_declarator; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariable_declarator"


    // $ANTLR start "ruleVariable_declarator"
    // InternalJava.g:1312:1: ruleVariable_declarator returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= '[' otherlv_2= ']' ) | otherlv_3= '[]' )* (this_EQUAL_4= RULE_EQUAL ( (lv_initializer_5_0= ruleVariable_initializer ) ) )? ) ;
    public final EObject ruleVariable_declarator() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token this_EQUAL_4=null;
        EObject lv_initializer_5_0 = null;


         enterRule(); 
            
        try {
            // InternalJava.g:1315:28: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= '[' otherlv_2= ']' ) | otherlv_3= '[]' )* (this_EQUAL_4= RULE_EQUAL ( (lv_initializer_5_0= ruleVariable_initializer ) ) )? ) )
            // InternalJava.g:1316:1: ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= '[' otherlv_2= ']' ) | otherlv_3= '[]' )* (this_EQUAL_4= RULE_EQUAL ( (lv_initializer_5_0= ruleVariable_initializer ) ) )? )
            {
            // InternalJava.g:1316:1: ( ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= '[' otherlv_2= ']' ) | otherlv_3= '[]' )* (this_EQUAL_4= RULE_EQUAL ( (lv_initializer_5_0= ruleVariable_initializer ) ) )? )
            // InternalJava.g:1316:2: ( (lv_name_0_0= RULE_ID ) ) ( (otherlv_1= '[' otherlv_2= ']' ) | otherlv_3= '[]' )* (this_EQUAL_4= RULE_EQUAL ( (lv_initializer_5_0= ruleVariable_initializer ) ) )?
            {
            // InternalJava.g:1316:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalJava.g:1317:1: (lv_name_0_0= RULE_ID )
            {
            // InternalJava.g:1317:1: (lv_name_0_0= RULE_ID )
            // InternalJava.g:1318:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_28); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getVariable_declaratorAccess().getNameIDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getVariable_declaratorRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"org.xtext.java.Java.ID");
              	    
            }

            }


            }

            // InternalJava.g:1334:2: ( (otherlv_1= '[' otherlv_2= ']' ) | otherlv_3= '[]' )*
            loop31:
            do {
                int alt31=3;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==80) ) {
                    alt31=1;
                }
                else if ( (LA31_0==82) ) {
                    alt31=2;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalJava.g:1334:3: (otherlv_1= '[' otherlv_2= ']' )
            	    {
            	    // InternalJava.g:1334:3: (otherlv_1= '[' otherlv_2= ']' )
            	    // InternalJava.g:1334:5: otherlv_1= '[' otherlv_2= ']'
            	    {
            	    otherlv_1=(Token)match(input,80,FOLLOW_21); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getVariable_declaratorAccess().getLeftSquareBracketKeyword_1_0_0());
            	          
            	    }
            	    otherlv_2=(Token)match(input,81,FOLLOW_28); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getVariable_declaratorAccess().getRightSquareBracketKeyword_1_0_1());
            	          
            	    }

            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalJava.g:1343:7: otherlv_3= '[]'
            	    {
            	    otherlv_3=(Token)match(input,82,FOLLOW_28); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getVariable_declaratorAccess().getLeftSquareBracketRightSquareBracketKeyword_1_1());
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

            // InternalJava.g:1347:3: (this_EQUAL_4= RULE_EQUAL ( (lv_initializer_5_0= ruleVariable_initializer ) ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==RULE_EQUAL) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalJava.g:1347:4: this_EQUAL_4= RULE_EQUAL ( (lv_initializer_5_0= ruleVariable_initializer ) )
                    {
                    this_EQUAL_4=(Token)match(input,RULE_EQUAL,FOLLOW_29); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_EQUAL_4, grammarAccess.getVariable_declaratorAccess().getEQUALTerminalRuleCall_2_0()); 
                          
                    }
                    // InternalJava.g:1351:1: ( (lv_initializer_5_0= ruleVariable_initializer ) )
                    // InternalJava.g:1352:1: (lv_initializer_5_0= ruleVariable_initializer )
                    {
                    // InternalJava.g:1352:1: (lv_initializer_5_0= ruleVariable_initializer )
                    // InternalJava.g:1353:3: lv_initializer_5_0= ruleVariable_initializer
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getVariable_declaratorAccess().getInitializerVariable_initializerParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_initializer_5_0=ruleVariable_initializer();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getVariable_declaratorRule());
                      	        }
                             		set(
                             			current, 
                             			"initializer",
                              		lv_initializer_5_0, 
                              		"org.xtext.java.Java.Variable_initializer");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariable_declarator"


    // $ANTLR start "entryRuleVariable_initializer"
    // InternalJava.g:1377:1: entryRuleVariable_initializer returns [EObject current=null] : iv_ruleVariable_initializer= ruleVariable_initializer EOF ;
    public final EObject entryRuleVariable_initializer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable_initializer = null;


        try {
            // InternalJava.g:1378:2: (iv_ruleVariable_initializer= ruleVariable_initializer EOF )
            // InternalJava.g:1379:2: iv_ruleVariable_initializer= ruleVariable_initializer EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariable_initializerRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVariable_initializer=ruleVariable_initializer();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariable_initializer; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariable_initializer"


    // $ANTLR start "ruleVariable_initializer"
    // InternalJava.g:1386:1: ruleVariable_initializer returns [EObject current=null] : ( ( (lv_expression_0_0= ruleExpression ) ) | ( () ( ( '{' )=>otherlv_2= '{' ) ( ( (lv_variableInitializer1_3_0= ruleVariable_initializer ) ) (this_COMMA_4= RULE_COMMA ( (lv_variableIniatializer2_5_0= ruleVariable_initializer ) ) )* (this_COMMA_6= RULE_COMMA )? )? otherlv_7= '}' ) ) ;
    public final EObject ruleVariable_initializer() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token this_COMMA_4=null;
        Token this_COMMA_6=null;
        Token otherlv_7=null;
        EObject lv_expression_0_0 = null;

        EObject lv_variableInitializer1_3_0 = null;

        EObject lv_variableIniatializer2_5_0 = null;


         enterRule(); 
            
        try {
            // InternalJava.g:1389:28: ( ( ( (lv_expression_0_0= ruleExpression ) ) | ( () ( ( '{' )=>otherlv_2= '{' ) ( ( (lv_variableInitializer1_3_0= ruleVariable_initializer ) ) (this_COMMA_4= RULE_COMMA ( (lv_variableIniatializer2_5_0= ruleVariable_initializer ) ) )* (this_COMMA_6= RULE_COMMA )? )? otherlv_7= '}' ) ) )
            // InternalJava.g:1390:1: ( ( (lv_expression_0_0= ruleExpression ) ) | ( () ( ( '{' )=>otherlv_2= '{' ) ( ( (lv_variableInitializer1_3_0= ruleVariable_initializer ) ) (this_COMMA_4= RULE_COMMA ( (lv_variableIniatializer2_5_0= ruleVariable_initializer ) ) )* (this_COMMA_6= RULE_COMMA )? )? otherlv_7= '}' ) )
            {
            // InternalJava.g:1390:1: ( ( (lv_expression_0_0= ruleExpression ) ) | ( () ( ( '{' )=>otherlv_2= '{' ) ( ( (lv_variableInitializer1_3_0= ruleVariable_initializer ) ) (this_COMMA_4= RULE_COMMA ( (lv_variableIniatializer2_5_0= ruleVariable_initializer ) ) )* (this_COMMA_6= RULE_COMMA )? )? otherlv_7= '}' ) )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==RULE_ID||(LA36_0>=RULE_NULL && LA36_0<=RULE_THIS)||(LA36_0>=RULE_INCREMENT && LA36_0<=RULE_DECREMENT)||LA36_0==RULE_MINUS||(LA36_0>=RULE_DECIMAL_DIGITS && LA36_0<=RULE_FALSE)||LA36_0==78) ) {
                alt36=1;
            }
            else if ( (LA36_0==74) ) {
                alt36=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // InternalJava.g:1390:2: ( (lv_expression_0_0= ruleExpression ) )
                    {
                    // InternalJava.g:1390:2: ( (lv_expression_0_0= ruleExpression ) )
                    // InternalJava.g:1391:1: (lv_expression_0_0= ruleExpression )
                    {
                    // InternalJava.g:1391:1: (lv_expression_0_0= ruleExpression )
                    // InternalJava.g:1392:3: lv_expression_0_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getVariable_initializerAccess().getExpressionExpressionParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_expression_0_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getVariable_initializerRule());
                      	        }
                             		set(
                             			current, 
                             			"expression",
                              		lv_expression_0_0, 
                              		"org.xtext.java.Java.Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalJava.g:1409:6: ( () ( ( '{' )=>otherlv_2= '{' ) ( ( (lv_variableInitializer1_3_0= ruleVariable_initializer ) ) (this_COMMA_4= RULE_COMMA ( (lv_variableIniatializer2_5_0= ruleVariable_initializer ) ) )* (this_COMMA_6= RULE_COMMA )? )? otherlv_7= '}' )
                    {
                    // InternalJava.g:1409:6: ( () ( ( '{' )=>otherlv_2= '{' ) ( ( (lv_variableInitializer1_3_0= ruleVariable_initializer ) ) (this_COMMA_4= RULE_COMMA ( (lv_variableIniatializer2_5_0= ruleVariable_initializer ) ) )* (this_COMMA_6= RULE_COMMA )? )? otherlv_7= '}' )
                    // InternalJava.g:1409:7: () ( ( '{' )=>otherlv_2= '{' ) ( ( (lv_variableInitializer1_3_0= ruleVariable_initializer ) ) (this_COMMA_4= RULE_COMMA ( (lv_variableIniatializer2_5_0= ruleVariable_initializer ) ) )* (this_COMMA_6= RULE_COMMA )? )? otherlv_7= '}'
                    {
                    // InternalJava.g:1409:7: ()
                    // InternalJava.g:1410:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getVariable_initializerAccess().getVariable_initializerAction_1_0(),
                                  current);
                          
                    }

                    }

                    // InternalJava.g:1418:2: ( ( '{' )=>otherlv_2= '{' )
                    // InternalJava.g:1418:3: ( '{' )=>otherlv_2= '{'
                    {
                    otherlv_2=(Token)match(input,74,FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getVariable_initializerAccess().getLeftCurlyBracketKeyword_1_1());
                          
                    }

                    }

                    // InternalJava.g:1423:2: ( ( (lv_variableInitializer1_3_0= ruleVariable_initializer ) ) (this_COMMA_4= RULE_COMMA ( (lv_variableIniatializer2_5_0= ruleVariable_initializer ) ) )* (this_COMMA_6= RULE_COMMA )? )?
                    int alt35=2;
                    int LA35_0 = input.LA(1);

                    if ( (LA35_0==RULE_ID||(LA35_0>=RULE_NULL && LA35_0<=RULE_THIS)||(LA35_0>=RULE_INCREMENT && LA35_0<=RULE_DECREMENT)||LA35_0==RULE_MINUS||(LA35_0>=RULE_DECIMAL_DIGITS && LA35_0<=RULE_FALSE)||LA35_0==74||LA35_0==78) ) {
                        alt35=1;
                    }
                    switch (alt35) {
                        case 1 :
                            // InternalJava.g:1423:3: ( (lv_variableInitializer1_3_0= ruleVariable_initializer ) ) (this_COMMA_4= RULE_COMMA ( (lv_variableIniatializer2_5_0= ruleVariable_initializer ) ) )* (this_COMMA_6= RULE_COMMA )?
                            {
                            // InternalJava.g:1423:3: ( (lv_variableInitializer1_3_0= ruleVariable_initializer ) )
                            // InternalJava.g:1424:1: (lv_variableInitializer1_3_0= ruleVariable_initializer )
                            {
                            // InternalJava.g:1424:1: (lv_variableInitializer1_3_0= ruleVariable_initializer )
                            // InternalJava.g:1425:3: lv_variableInitializer1_3_0= ruleVariable_initializer
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getVariable_initializerAccess().getVariableInitializer1Variable_initializerParserRuleCall_1_2_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_31);
                            lv_variableInitializer1_3_0=ruleVariable_initializer();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getVariable_initializerRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"variableInitializer1",
                                      		lv_variableInitializer1_3_0, 
                                      		"org.xtext.java.Java.Variable_initializer");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // InternalJava.g:1441:2: (this_COMMA_4= RULE_COMMA ( (lv_variableIniatializer2_5_0= ruleVariable_initializer ) ) )*
                            loop33:
                            do {
                                int alt33=2;
                                int LA33_0 = input.LA(1);

                                if ( (LA33_0==RULE_COMMA) ) {
                                    int LA33_1 = input.LA(2);

                                    if ( (LA33_1==RULE_ID||(LA33_1>=RULE_NULL && LA33_1<=RULE_THIS)||(LA33_1>=RULE_INCREMENT && LA33_1<=RULE_DECREMENT)||LA33_1==RULE_MINUS||(LA33_1>=RULE_DECIMAL_DIGITS && LA33_1<=RULE_FALSE)||LA33_1==74||LA33_1==78) ) {
                                        alt33=1;
                                    }


                                }


                                switch (alt33) {
                            	case 1 :
                            	    // InternalJava.g:1441:3: this_COMMA_4= RULE_COMMA ( (lv_variableIniatializer2_5_0= ruleVariable_initializer ) )
                            	    {
                            	    this_COMMA_4=(Token)match(input,RULE_COMMA,FOLLOW_29); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {
                            	       
                            	          newLeafNode(this_COMMA_4, grammarAccess.getVariable_initializerAccess().getCOMMATerminalRuleCall_1_2_1_0()); 
                            	          
                            	    }
                            	    // InternalJava.g:1445:1: ( (lv_variableIniatializer2_5_0= ruleVariable_initializer ) )
                            	    // InternalJava.g:1446:1: (lv_variableIniatializer2_5_0= ruleVariable_initializer )
                            	    {
                            	    // InternalJava.g:1446:1: (lv_variableIniatializer2_5_0= ruleVariable_initializer )
                            	    // InternalJava.g:1447:3: lv_variableIniatializer2_5_0= ruleVariable_initializer
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getVariable_initializerAccess().getVariableIniatializer2Variable_initializerParserRuleCall_1_2_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_31);
                            	    lv_variableIniatializer2_5_0=ruleVariable_initializer();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getVariable_initializerRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"variableIniatializer2",
                            	              		lv_variableIniatializer2_5_0, 
                            	              		"org.xtext.java.Java.Variable_initializer");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop33;
                                }
                            } while (true);

                            // InternalJava.g:1463:4: (this_COMMA_6= RULE_COMMA )?
                            int alt34=2;
                            int LA34_0 = input.LA(1);

                            if ( (LA34_0==RULE_COMMA) ) {
                                alt34=1;
                            }
                            switch (alt34) {
                                case 1 :
                                    // InternalJava.g:1463:5: this_COMMA_6= RULE_COMMA
                                    {
                                    this_COMMA_6=(Token)match(input,RULE_COMMA,FOLLOW_32); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {
                                       
                                          newLeafNode(this_COMMA_6, grammarAccess.getVariable_initializerAccess().getCOMMATerminalRuleCall_1_2_2()); 
                                          
                                    }

                                    }
                                    break;

                            }


                            }
                            break;

                    }

                    otherlv_7=(Token)match(input,75,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getVariable_initializerAccess().getRightCurlyBracketKeyword_1_3());
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariable_initializer"


    // $ANTLR start "entryRuleExpression"
    // InternalJava.g:1479:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalJava.g:1480:2: (iv_ruleExpression= ruleExpression EOF )
            // InternalJava.g:1481:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalJava.g:1488:1: ruleExpression returns [EObject current=null] : ( ( ( ( ( ( ruleNumeric_Expression_NR ) ) )=> ( (lv_numericExpression3_0_0= ruleNumeric_Expression_NR ) ) ) ( (lv_aux_1_0= ruleExpression_aux ) ) ) | ( ( (lv_logicalExpression_2_0= ruleLogical_Expression_NR ) ) ( (lv_aux_3_0= ruleExpression_aux ) ) ) | ( ( (lv_bitExpression_4_0= ruleBit_Expression_NR ) ) ( (lv_aux_5_0= ruleExpression_aux ) ) ) | ( ( ( ( ( ruleCast_Expression ) ) )=> ( (lv_castExpression_6_0= ruleCast_Expression ) ) ) ( (lv_aux_7_0= ruleExpression_aux ) ) ) | ( ( ( ( ( ruleCreating_Expression ) ) )=> ( (lv_creatingExpression_8_0= ruleCreating_Expression ) ) ) ( (lv_aux_9_0= ruleExpression_aux ) ) ) | ( ( (lv_literalExpression_10_0= ruleLiteral_Expression ) ) ( (lv_aux_11_0= ruleExpression_aux ) ) ) | ( ( (lv_null_12_0= RULE_NULL ) ) ( (lv_aux_13_0= ruleExpression_aux ) ) ) | ( ( (lv_super_14_0= RULE_SUPER ) ) ( (lv_aux_15_0= ruleExpression_aux ) ) ) | ( ( (lv_this_16_0= RULE_THIS ) ) ( (lv_aux_17_0= ruleExpression_aux ) ) ) | ( ( (lv_name_18_0= RULE_ID ) ) ( (lv_aux_19_0= ruleExpression_aux ) ) ) ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        Token lv_null_12_0=null;
        Token lv_super_14_0=null;
        Token lv_this_16_0=null;
        Token lv_name_18_0=null;
        EObject lv_numericExpression3_0_0 = null;

        EObject lv_aux_1_0 = null;

        EObject lv_logicalExpression_2_0 = null;

        EObject lv_aux_3_0 = null;

        EObject lv_bitExpression_4_0 = null;

        EObject lv_aux_5_0 = null;

        EObject lv_castExpression_6_0 = null;

        EObject lv_aux_7_0 = null;

        EObject lv_creatingExpression_8_0 = null;

        EObject lv_aux_9_0 = null;

        EObject lv_literalExpression_10_0 = null;

        EObject lv_aux_11_0 = null;

        EObject lv_aux_13_0 = null;

        EObject lv_aux_15_0 = null;

        EObject lv_aux_17_0 = null;

        EObject lv_aux_19_0 = null;


         enterRule(); 
            
        try {
            // InternalJava.g:1491:28: ( ( ( ( ( ( ( ruleNumeric_Expression_NR ) ) )=> ( (lv_numericExpression3_0_0= ruleNumeric_Expression_NR ) ) ) ( (lv_aux_1_0= ruleExpression_aux ) ) ) | ( ( (lv_logicalExpression_2_0= ruleLogical_Expression_NR ) ) ( (lv_aux_3_0= ruleExpression_aux ) ) ) | ( ( (lv_bitExpression_4_0= ruleBit_Expression_NR ) ) ( (lv_aux_5_0= ruleExpression_aux ) ) ) | ( ( ( ( ( ruleCast_Expression ) ) )=> ( (lv_castExpression_6_0= ruleCast_Expression ) ) ) ( (lv_aux_7_0= ruleExpression_aux ) ) ) | ( ( ( ( ( ruleCreating_Expression ) ) )=> ( (lv_creatingExpression_8_0= ruleCreating_Expression ) ) ) ( (lv_aux_9_0= ruleExpression_aux ) ) ) | ( ( (lv_literalExpression_10_0= ruleLiteral_Expression ) ) ( (lv_aux_11_0= ruleExpression_aux ) ) ) | ( ( (lv_null_12_0= RULE_NULL ) ) ( (lv_aux_13_0= ruleExpression_aux ) ) ) | ( ( (lv_super_14_0= RULE_SUPER ) ) ( (lv_aux_15_0= ruleExpression_aux ) ) ) | ( ( (lv_this_16_0= RULE_THIS ) ) ( (lv_aux_17_0= ruleExpression_aux ) ) ) | ( ( (lv_name_18_0= RULE_ID ) ) ( (lv_aux_19_0= ruleExpression_aux ) ) ) ) )
            // InternalJava.g:1492:1: ( ( ( ( ( ( ruleNumeric_Expression_NR ) ) )=> ( (lv_numericExpression3_0_0= ruleNumeric_Expression_NR ) ) ) ( (lv_aux_1_0= ruleExpression_aux ) ) ) | ( ( (lv_logicalExpression_2_0= ruleLogical_Expression_NR ) ) ( (lv_aux_3_0= ruleExpression_aux ) ) ) | ( ( (lv_bitExpression_4_0= ruleBit_Expression_NR ) ) ( (lv_aux_5_0= ruleExpression_aux ) ) ) | ( ( ( ( ( ruleCast_Expression ) ) )=> ( (lv_castExpression_6_0= ruleCast_Expression ) ) ) ( (lv_aux_7_0= ruleExpression_aux ) ) ) | ( ( ( ( ( ruleCreating_Expression ) ) )=> ( (lv_creatingExpression_8_0= ruleCreating_Expression ) ) ) ( (lv_aux_9_0= ruleExpression_aux ) ) ) | ( ( (lv_literalExpression_10_0= ruleLiteral_Expression ) ) ( (lv_aux_11_0= ruleExpression_aux ) ) ) | ( ( (lv_null_12_0= RULE_NULL ) ) ( (lv_aux_13_0= ruleExpression_aux ) ) ) | ( ( (lv_super_14_0= RULE_SUPER ) ) ( (lv_aux_15_0= ruleExpression_aux ) ) ) | ( ( (lv_this_16_0= RULE_THIS ) ) ( (lv_aux_17_0= ruleExpression_aux ) ) ) | ( ( (lv_name_18_0= RULE_ID ) ) ( (lv_aux_19_0= ruleExpression_aux ) ) ) )
            {
            // InternalJava.g:1492:1: ( ( ( ( ( ( ruleNumeric_Expression_NR ) ) )=> ( (lv_numericExpression3_0_0= ruleNumeric_Expression_NR ) ) ) ( (lv_aux_1_0= ruleExpression_aux ) ) ) | ( ( (lv_logicalExpression_2_0= ruleLogical_Expression_NR ) ) ( (lv_aux_3_0= ruleExpression_aux ) ) ) | ( ( (lv_bitExpression_4_0= ruleBit_Expression_NR ) ) ( (lv_aux_5_0= ruleExpression_aux ) ) ) | ( ( ( ( ( ruleCast_Expression ) ) )=> ( (lv_castExpression_6_0= ruleCast_Expression ) ) ) ( (lv_aux_7_0= ruleExpression_aux ) ) ) | ( ( ( ( ( ruleCreating_Expression ) ) )=> ( (lv_creatingExpression_8_0= ruleCreating_Expression ) ) ) ( (lv_aux_9_0= ruleExpression_aux ) ) ) | ( ( (lv_literalExpression_10_0= ruleLiteral_Expression ) ) ( (lv_aux_11_0= ruleExpression_aux ) ) ) | ( ( (lv_null_12_0= RULE_NULL ) ) ( (lv_aux_13_0= ruleExpression_aux ) ) ) | ( ( (lv_super_14_0= RULE_SUPER ) ) ( (lv_aux_15_0= ruleExpression_aux ) ) ) | ( ( (lv_this_16_0= RULE_THIS ) ) ( (lv_aux_17_0= ruleExpression_aux ) ) ) | ( ( (lv_name_18_0= RULE_ID ) ) ( (lv_aux_19_0= ruleExpression_aux ) ) ) )
            int alt37=10;
            alt37 = dfa37.predict(input);
            switch (alt37) {
                case 1 :
                    // InternalJava.g:1492:2: ( ( ( ( ( ruleNumeric_Expression_NR ) ) )=> ( (lv_numericExpression3_0_0= ruleNumeric_Expression_NR ) ) ) ( (lv_aux_1_0= ruleExpression_aux ) ) )
                    {
                    // InternalJava.g:1492:2: ( ( ( ( ( ruleNumeric_Expression_NR ) ) )=> ( (lv_numericExpression3_0_0= ruleNumeric_Expression_NR ) ) ) ( (lv_aux_1_0= ruleExpression_aux ) ) )
                    // InternalJava.g:1492:3: ( ( ( ( ruleNumeric_Expression_NR ) ) )=> ( (lv_numericExpression3_0_0= ruleNumeric_Expression_NR ) ) ) ( (lv_aux_1_0= ruleExpression_aux ) )
                    {
                    // InternalJava.g:1492:3: ( ( ( ( ruleNumeric_Expression_NR ) ) )=> ( (lv_numericExpression3_0_0= ruleNumeric_Expression_NR ) ) )
                    // InternalJava.g:1492:4: ( ( ( ruleNumeric_Expression_NR ) ) )=> ( (lv_numericExpression3_0_0= ruleNumeric_Expression_NR ) )
                    {
                    // InternalJava.g:1496:5: ( (lv_numericExpression3_0_0= ruleNumeric_Expression_NR ) )
                    // InternalJava.g:1497:1: (lv_numericExpression3_0_0= ruleNumeric_Expression_NR )
                    {
                    // InternalJava.g:1497:1: (lv_numericExpression3_0_0= ruleNumeric_Expression_NR )
                    // InternalJava.g:1498:3: lv_numericExpression3_0_0= ruleNumeric_Expression_NR
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getNumericExpression3Numeric_Expression_NRParserRuleCall_0_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_33);
                    lv_numericExpression3_0_0=ruleNumeric_Expression_NR();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"numericExpression3",
                              		lv_numericExpression3_0_0, 
                              		"org.xtext.java.Java.Numeric_Expression_NR");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }

                    // InternalJava.g:1514:3: ( (lv_aux_1_0= ruleExpression_aux ) )
                    // InternalJava.g:1515:1: (lv_aux_1_0= ruleExpression_aux )
                    {
                    // InternalJava.g:1515:1: (lv_aux_1_0= ruleExpression_aux )
                    // InternalJava.g:1516:3: lv_aux_1_0= ruleExpression_aux
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getAuxExpression_auxParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_aux_1_0=ruleExpression_aux();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"aux",
                              		lv_aux_1_0, 
                              		"org.xtext.java.Java.Expression_aux");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalJava.g:1533:6: ( ( (lv_logicalExpression_2_0= ruleLogical_Expression_NR ) ) ( (lv_aux_3_0= ruleExpression_aux ) ) )
                    {
                    // InternalJava.g:1533:6: ( ( (lv_logicalExpression_2_0= ruleLogical_Expression_NR ) ) ( (lv_aux_3_0= ruleExpression_aux ) ) )
                    // InternalJava.g:1533:7: ( (lv_logicalExpression_2_0= ruleLogical_Expression_NR ) ) ( (lv_aux_3_0= ruleExpression_aux ) )
                    {
                    // InternalJava.g:1533:7: ( (lv_logicalExpression_2_0= ruleLogical_Expression_NR ) )
                    // InternalJava.g:1534:1: (lv_logicalExpression_2_0= ruleLogical_Expression_NR )
                    {
                    // InternalJava.g:1534:1: (lv_logicalExpression_2_0= ruleLogical_Expression_NR )
                    // InternalJava.g:1535:3: lv_logicalExpression_2_0= ruleLogical_Expression_NR
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getLogicalExpressionLogical_Expression_NRParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_33);
                    lv_logicalExpression_2_0=ruleLogical_Expression_NR();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"logicalExpression",
                              		lv_logicalExpression_2_0, 
                              		"org.xtext.java.Java.Logical_Expression_NR");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalJava.g:1551:2: ( (lv_aux_3_0= ruleExpression_aux ) )
                    // InternalJava.g:1552:1: (lv_aux_3_0= ruleExpression_aux )
                    {
                    // InternalJava.g:1552:1: (lv_aux_3_0= ruleExpression_aux )
                    // InternalJava.g:1553:3: lv_aux_3_0= ruleExpression_aux
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getAuxExpression_auxParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_aux_3_0=ruleExpression_aux();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"aux",
                              		lv_aux_3_0, 
                              		"org.xtext.java.Java.Expression_aux");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalJava.g:1570:6: ( ( (lv_bitExpression_4_0= ruleBit_Expression_NR ) ) ( (lv_aux_5_0= ruleExpression_aux ) ) )
                    {
                    // InternalJava.g:1570:6: ( ( (lv_bitExpression_4_0= ruleBit_Expression_NR ) ) ( (lv_aux_5_0= ruleExpression_aux ) ) )
                    // InternalJava.g:1570:7: ( (lv_bitExpression_4_0= ruleBit_Expression_NR ) ) ( (lv_aux_5_0= ruleExpression_aux ) )
                    {
                    // InternalJava.g:1570:7: ( (lv_bitExpression_4_0= ruleBit_Expression_NR ) )
                    // InternalJava.g:1571:1: (lv_bitExpression_4_0= ruleBit_Expression_NR )
                    {
                    // InternalJava.g:1571:1: (lv_bitExpression_4_0= ruleBit_Expression_NR )
                    // InternalJava.g:1572:3: lv_bitExpression_4_0= ruleBit_Expression_NR
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getBitExpressionBit_Expression_NRParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_33);
                    lv_bitExpression_4_0=ruleBit_Expression_NR();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"bitExpression",
                              		lv_bitExpression_4_0, 
                              		"org.xtext.java.Java.Bit_Expression_NR");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalJava.g:1588:2: ( (lv_aux_5_0= ruleExpression_aux ) )
                    // InternalJava.g:1589:1: (lv_aux_5_0= ruleExpression_aux )
                    {
                    // InternalJava.g:1589:1: (lv_aux_5_0= ruleExpression_aux )
                    // InternalJava.g:1590:3: lv_aux_5_0= ruleExpression_aux
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getAuxExpression_auxParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_aux_5_0=ruleExpression_aux();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"aux",
                              		lv_aux_5_0, 
                              		"org.xtext.java.Java.Expression_aux");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalJava.g:1607:6: ( ( ( ( ( ruleCast_Expression ) ) )=> ( (lv_castExpression_6_0= ruleCast_Expression ) ) ) ( (lv_aux_7_0= ruleExpression_aux ) ) )
                    {
                    // InternalJava.g:1607:6: ( ( ( ( ( ruleCast_Expression ) ) )=> ( (lv_castExpression_6_0= ruleCast_Expression ) ) ) ( (lv_aux_7_0= ruleExpression_aux ) ) )
                    // InternalJava.g:1607:7: ( ( ( ( ruleCast_Expression ) ) )=> ( (lv_castExpression_6_0= ruleCast_Expression ) ) ) ( (lv_aux_7_0= ruleExpression_aux ) )
                    {
                    // InternalJava.g:1607:7: ( ( ( ( ruleCast_Expression ) ) )=> ( (lv_castExpression_6_0= ruleCast_Expression ) ) )
                    // InternalJava.g:1607:8: ( ( ( ruleCast_Expression ) ) )=> ( (lv_castExpression_6_0= ruleCast_Expression ) )
                    {
                    // InternalJava.g:1611:5: ( (lv_castExpression_6_0= ruleCast_Expression ) )
                    // InternalJava.g:1612:1: (lv_castExpression_6_0= ruleCast_Expression )
                    {
                    // InternalJava.g:1612:1: (lv_castExpression_6_0= ruleCast_Expression )
                    // InternalJava.g:1613:3: lv_castExpression_6_0= ruleCast_Expression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getCastExpressionCast_ExpressionParserRuleCall_3_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_33);
                    lv_castExpression_6_0=ruleCast_Expression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"castExpression",
                              		lv_castExpression_6_0, 
                              		"org.xtext.java.Java.Cast_Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }

                    // InternalJava.g:1629:3: ( (lv_aux_7_0= ruleExpression_aux ) )
                    // InternalJava.g:1630:1: (lv_aux_7_0= ruleExpression_aux )
                    {
                    // InternalJava.g:1630:1: (lv_aux_7_0= ruleExpression_aux )
                    // InternalJava.g:1631:3: lv_aux_7_0= ruleExpression_aux
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getAuxExpression_auxParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_aux_7_0=ruleExpression_aux();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"aux",
                              		lv_aux_7_0, 
                              		"org.xtext.java.Java.Expression_aux");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalJava.g:1648:6: ( ( ( ( ( ruleCreating_Expression ) ) )=> ( (lv_creatingExpression_8_0= ruleCreating_Expression ) ) ) ( (lv_aux_9_0= ruleExpression_aux ) ) )
                    {
                    // InternalJava.g:1648:6: ( ( ( ( ( ruleCreating_Expression ) ) )=> ( (lv_creatingExpression_8_0= ruleCreating_Expression ) ) ) ( (lv_aux_9_0= ruleExpression_aux ) ) )
                    // InternalJava.g:1648:7: ( ( ( ( ruleCreating_Expression ) ) )=> ( (lv_creatingExpression_8_0= ruleCreating_Expression ) ) ) ( (lv_aux_9_0= ruleExpression_aux ) )
                    {
                    // InternalJava.g:1648:7: ( ( ( ( ruleCreating_Expression ) ) )=> ( (lv_creatingExpression_8_0= ruleCreating_Expression ) ) )
                    // InternalJava.g:1648:8: ( ( ( ruleCreating_Expression ) ) )=> ( (lv_creatingExpression_8_0= ruleCreating_Expression ) )
                    {
                    // InternalJava.g:1652:5: ( (lv_creatingExpression_8_0= ruleCreating_Expression ) )
                    // InternalJava.g:1653:1: (lv_creatingExpression_8_0= ruleCreating_Expression )
                    {
                    // InternalJava.g:1653:1: (lv_creatingExpression_8_0= ruleCreating_Expression )
                    // InternalJava.g:1654:3: lv_creatingExpression_8_0= ruleCreating_Expression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getCreatingExpressionCreating_ExpressionParserRuleCall_4_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_33);
                    lv_creatingExpression_8_0=ruleCreating_Expression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"creatingExpression",
                              		lv_creatingExpression_8_0, 
                              		"org.xtext.java.Java.Creating_Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }

                    // InternalJava.g:1670:3: ( (lv_aux_9_0= ruleExpression_aux ) )
                    // InternalJava.g:1671:1: (lv_aux_9_0= ruleExpression_aux )
                    {
                    // InternalJava.g:1671:1: (lv_aux_9_0= ruleExpression_aux )
                    // InternalJava.g:1672:3: lv_aux_9_0= ruleExpression_aux
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getAuxExpression_auxParserRuleCall_4_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_aux_9_0=ruleExpression_aux();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"aux",
                              		lv_aux_9_0, 
                              		"org.xtext.java.Java.Expression_aux");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalJava.g:1689:6: ( ( (lv_literalExpression_10_0= ruleLiteral_Expression ) ) ( (lv_aux_11_0= ruleExpression_aux ) ) )
                    {
                    // InternalJava.g:1689:6: ( ( (lv_literalExpression_10_0= ruleLiteral_Expression ) ) ( (lv_aux_11_0= ruleExpression_aux ) ) )
                    // InternalJava.g:1689:7: ( (lv_literalExpression_10_0= ruleLiteral_Expression ) ) ( (lv_aux_11_0= ruleExpression_aux ) )
                    {
                    // InternalJava.g:1689:7: ( (lv_literalExpression_10_0= ruleLiteral_Expression ) )
                    // InternalJava.g:1690:1: (lv_literalExpression_10_0= ruleLiteral_Expression )
                    {
                    // InternalJava.g:1690:1: (lv_literalExpression_10_0= ruleLiteral_Expression )
                    // InternalJava.g:1691:3: lv_literalExpression_10_0= ruleLiteral_Expression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getLiteralExpressionLiteral_ExpressionParserRuleCall_5_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_33);
                    lv_literalExpression_10_0=ruleLiteral_Expression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"literalExpression",
                              		lv_literalExpression_10_0, 
                              		"org.xtext.java.Java.Literal_Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalJava.g:1707:2: ( (lv_aux_11_0= ruleExpression_aux ) )
                    // InternalJava.g:1708:1: (lv_aux_11_0= ruleExpression_aux )
                    {
                    // InternalJava.g:1708:1: (lv_aux_11_0= ruleExpression_aux )
                    // InternalJava.g:1709:3: lv_aux_11_0= ruleExpression_aux
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getAuxExpression_auxParserRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_aux_11_0=ruleExpression_aux();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"aux",
                              		lv_aux_11_0, 
                              		"org.xtext.java.Java.Expression_aux");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalJava.g:1726:6: ( ( (lv_null_12_0= RULE_NULL ) ) ( (lv_aux_13_0= ruleExpression_aux ) ) )
                    {
                    // InternalJava.g:1726:6: ( ( (lv_null_12_0= RULE_NULL ) ) ( (lv_aux_13_0= ruleExpression_aux ) ) )
                    // InternalJava.g:1726:7: ( (lv_null_12_0= RULE_NULL ) ) ( (lv_aux_13_0= ruleExpression_aux ) )
                    {
                    // InternalJava.g:1726:7: ( (lv_null_12_0= RULE_NULL ) )
                    // InternalJava.g:1727:1: (lv_null_12_0= RULE_NULL )
                    {
                    // InternalJava.g:1727:1: (lv_null_12_0= RULE_NULL )
                    // InternalJava.g:1728:3: lv_null_12_0= RULE_NULL
                    {
                    lv_null_12_0=(Token)match(input,RULE_NULL,FOLLOW_33); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_null_12_0, grammarAccess.getExpressionAccess().getNullNULLTerminalRuleCall_6_0_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getExpressionRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"null",
                              		lv_null_12_0, 
                              		"org.xtext.java.Java.NULL");
                      	    
                    }

                    }


                    }

                    // InternalJava.g:1744:2: ( (lv_aux_13_0= ruleExpression_aux ) )
                    // InternalJava.g:1745:1: (lv_aux_13_0= ruleExpression_aux )
                    {
                    // InternalJava.g:1745:1: (lv_aux_13_0= ruleExpression_aux )
                    // InternalJava.g:1746:3: lv_aux_13_0= ruleExpression_aux
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getAuxExpression_auxParserRuleCall_6_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_aux_13_0=ruleExpression_aux();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"aux",
                              		lv_aux_13_0, 
                              		"org.xtext.java.Java.Expression_aux");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalJava.g:1763:6: ( ( (lv_super_14_0= RULE_SUPER ) ) ( (lv_aux_15_0= ruleExpression_aux ) ) )
                    {
                    // InternalJava.g:1763:6: ( ( (lv_super_14_0= RULE_SUPER ) ) ( (lv_aux_15_0= ruleExpression_aux ) ) )
                    // InternalJava.g:1763:7: ( (lv_super_14_0= RULE_SUPER ) ) ( (lv_aux_15_0= ruleExpression_aux ) )
                    {
                    // InternalJava.g:1763:7: ( (lv_super_14_0= RULE_SUPER ) )
                    // InternalJava.g:1764:1: (lv_super_14_0= RULE_SUPER )
                    {
                    // InternalJava.g:1764:1: (lv_super_14_0= RULE_SUPER )
                    // InternalJava.g:1765:3: lv_super_14_0= RULE_SUPER
                    {
                    lv_super_14_0=(Token)match(input,RULE_SUPER,FOLLOW_33); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_super_14_0, grammarAccess.getExpressionAccess().getSuperSUPERTerminalRuleCall_7_0_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getExpressionRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"super",
                              		lv_super_14_0, 
                              		"org.xtext.java.Java.SUPER");
                      	    
                    }

                    }


                    }

                    // InternalJava.g:1781:2: ( (lv_aux_15_0= ruleExpression_aux ) )
                    // InternalJava.g:1782:1: (lv_aux_15_0= ruleExpression_aux )
                    {
                    // InternalJava.g:1782:1: (lv_aux_15_0= ruleExpression_aux )
                    // InternalJava.g:1783:3: lv_aux_15_0= ruleExpression_aux
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getAuxExpression_auxParserRuleCall_7_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_aux_15_0=ruleExpression_aux();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"aux",
                              		lv_aux_15_0, 
                              		"org.xtext.java.Java.Expression_aux");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 9 :
                    // InternalJava.g:1800:6: ( ( (lv_this_16_0= RULE_THIS ) ) ( (lv_aux_17_0= ruleExpression_aux ) ) )
                    {
                    // InternalJava.g:1800:6: ( ( (lv_this_16_0= RULE_THIS ) ) ( (lv_aux_17_0= ruleExpression_aux ) ) )
                    // InternalJava.g:1800:7: ( (lv_this_16_0= RULE_THIS ) ) ( (lv_aux_17_0= ruleExpression_aux ) )
                    {
                    // InternalJava.g:1800:7: ( (lv_this_16_0= RULE_THIS ) )
                    // InternalJava.g:1801:1: (lv_this_16_0= RULE_THIS )
                    {
                    // InternalJava.g:1801:1: (lv_this_16_0= RULE_THIS )
                    // InternalJava.g:1802:3: lv_this_16_0= RULE_THIS
                    {
                    lv_this_16_0=(Token)match(input,RULE_THIS,FOLLOW_33); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_this_16_0, grammarAccess.getExpressionAccess().getThisTHISTerminalRuleCall_8_0_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getExpressionRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"this",
                              		lv_this_16_0, 
                              		"org.xtext.java.Java.THIS");
                      	    
                    }

                    }


                    }

                    // InternalJava.g:1818:2: ( (lv_aux_17_0= ruleExpression_aux ) )
                    // InternalJava.g:1819:1: (lv_aux_17_0= ruleExpression_aux )
                    {
                    // InternalJava.g:1819:1: (lv_aux_17_0= ruleExpression_aux )
                    // InternalJava.g:1820:3: lv_aux_17_0= ruleExpression_aux
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getAuxExpression_auxParserRuleCall_8_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_aux_17_0=ruleExpression_aux();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"aux",
                              		lv_aux_17_0, 
                              		"org.xtext.java.Java.Expression_aux");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 10 :
                    // InternalJava.g:1837:6: ( ( (lv_name_18_0= RULE_ID ) ) ( (lv_aux_19_0= ruleExpression_aux ) ) )
                    {
                    // InternalJava.g:1837:6: ( ( (lv_name_18_0= RULE_ID ) ) ( (lv_aux_19_0= ruleExpression_aux ) ) )
                    // InternalJava.g:1837:7: ( (lv_name_18_0= RULE_ID ) ) ( (lv_aux_19_0= ruleExpression_aux ) )
                    {
                    // InternalJava.g:1837:7: ( (lv_name_18_0= RULE_ID ) )
                    // InternalJava.g:1838:1: (lv_name_18_0= RULE_ID )
                    {
                    // InternalJava.g:1838:1: (lv_name_18_0= RULE_ID )
                    // InternalJava.g:1839:3: lv_name_18_0= RULE_ID
                    {
                    lv_name_18_0=(Token)match(input,RULE_ID,FOLLOW_33); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_18_0, grammarAccess.getExpressionAccess().getNameIDTerminalRuleCall_9_0_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getExpressionRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_18_0, 
                              		"org.xtext.java.Java.ID");
                      	    
                    }

                    }


                    }

                    // InternalJava.g:1855:2: ( (lv_aux_19_0= ruleExpression_aux ) )
                    // InternalJava.g:1856:1: (lv_aux_19_0= ruleExpression_aux )
                    {
                    // InternalJava.g:1856:1: (lv_aux_19_0= ruleExpression_aux )
                    // InternalJava.g:1857:3: lv_aux_19_0= ruleExpression_aux
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpressionAccess().getAuxExpression_auxParserRuleCall_9_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_aux_19_0=ruleExpression_aux();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"aux",
                              		lv_aux_19_0, 
                              		"org.xtext.java.Java.Expression_aux");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleExpression_aux"
    // InternalJava.g:1881:1: entryRuleExpression_aux returns [EObject current=null] : iv_ruleExpression_aux= ruleExpression_aux EOF ;
    public final EObject entryRuleExpression_aux() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression_aux = null;


        try {
            // InternalJava.g:1882:2: (iv_ruleExpression_aux= ruleExpression_aux EOF )
            // InternalJava.g:1883:2: iv_ruleExpression_aux= ruleExpression_aux EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpression_auxRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExpression_aux=ruleExpression_aux();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression_aux; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression_aux"


    // $ANTLR start "ruleExpression_aux"
    // InternalJava.g:1890:1: ruleExpression_aux returns [EObject current=null] : ( ( (otherlv_0= '(' ( (lv_argList_1_0= ruleArg_List ) )? otherlv_2= ')' ) ( (lv_aux_3_0= ruleExpression_aux ) ) ) | ( (otherlv_4= '[' ( (lv_expression2_5_0= ruleExpression ) ) otherlv_6= ']' ) ( (lv_aux_7_0= ruleExpression_aux ) ) ) | ( (otherlv_8= '.' ( (lv_expression2_9_0= ruleExpression ) ) ) ( (lv_aux_10_0= ruleExpression_aux ) ) ) | ( (this_COMMA_11= RULE_COMMA ( (lv_expressionComma_12_0= ruleExpression ) ) ) ( (lv_aux_13_0= ruleExpression_aux ) ) ) | ( (this_INSTANCEOF_14= RULE_INSTANCEOF ( (lv_name_15_0= ruleClass_name ) ) ) ( (lv_aux_16_0= ruleExpression_aux ) ) ) | ( ( ( (lv_sgin_17_1= RULE_INCREMENT | lv_sgin_17_2= RULE_DECREMENT ) ) ) ( (lv_aux_18_0= ruleExpression_aux ) ) ) | ( ( ( (lv_numericSign_19_1= RULE_PLUS | lv_numericSign_19_2= RULE_PLUS_EQUAL | lv_numericSign_19_3= RULE_MINUS | lv_numericSign_19_4= RULE_MINUS_EQUAL | lv_numericSign_19_5= RULE_MULTIPLY | lv_numericSign_19_6= RULE_MULTIPLY_EQUAL | lv_numericSign_19_7= RULE_DIVIDE | lv_numericSign_19_8= RULE_DIVIDE_EQUAL | lv_numericSign_19_9= RULE_MODULE | lv_numericSign_19_10= RULE_MODULE_EQUAL ) ) ) ( (lv_exp2_20_0= ruleExpression ) ) ( (lv_aux_21_0= ruleExpression_aux ) ) ) | ( ( ( (lv_testingSign_22_1= RULE_BT | lv_testingSign_22_2= RULE_ST | lv_testingSign_22_3= RULE_BE | lv_testingSign_22_4= RULE_SE | lv_testingSign_22_5= RULE_DOUBLE_EQUAL | lv_testingSign_22_6= RULE_DIFFERENT ) ) ) ( (lv_exp1_23_0= ruleExpression ) ) ( (lv_aux_24_0= ruleExpression_aux ) ) ) | ( ( ( ( (lv_logicalSign_25_1= RULE_OR | lv_logicalSign_25_2= RULE_OR_EQUAL | lv_logicalSign_25_3= RULE_EXP | lv_logicalSign_25_4= RULE_EXP_EQUAL | lv_logicalSign_25_5= RULE_DOUBLE_OR_EQUAL | lv_logicalSign_25_6= RULE_MODULE | lv_logicalSign_25_7= RULE_MODULE_EQUAL ) ) ) | ( (lv_ampersand_26_0= ruleAmpersand_Rule ) ) ) ( (lv_exp1_27_0= ruleExpression ) ) ( (lv_aux_28_0= ruleExpression_aux ) ) ) | (this_WAT_29= RULE_WAT ( (lv_exp1_30_0= ruleExpression ) ) this_COLON_31= RULE_COLON ( (lv_exp2_32_0= ruleExpression ) ) ( (lv_aux_33_0= ruleExpression_aux ) ) ) | ( ( ( (lv_stringSign_34_1= RULE_PLUS | lv_stringSign_34_2= RULE_PLUS_EQUAL ) ) ) ( (lv_exp1_35_0= ruleExpression ) ) ( (lv_aux_36_0= ruleExpression_aux ) ) ) | ( ( ( (lv_bitSign_37_1= RULE_R_SHIFT_EQUAL | lv_bitSign_37_2= RULE_L_SHIFT | lv_bitSign_37_3= RULE_R_SHIFT | lv_bitSign_37_4= RULE_SUPER_SHIFT ) ) ) ( (lv_expressionBit_38_0= ruleExpression ) ) ( (lv_aux_39_0= ruleExpression_aux ) ) ) | () ) ;
    public final EObject ruleExpression_aux() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token this_COMMA_11=null;
        Token this_INSTANCEOF_14=null;
        Token lv_sgin_17_1=null;
        Token lv_sgin_17_2=null;
        Token lv_numericSign_19_1=null;
        Token lv_numericSign_19_2=null;
        Token lv_numericSign_19_3=null;
        Token lv_numericSign_19_4=null;
        Token lv_numericSign_19_5=null;
        Token lv_numericSign_19_6=null;
        Token lv_numericSign_19_7=null;
        Token lv_numericSign_19_8=null;
        Token lv_numericSign_19_9=null;
        Token lv_numericSign_19_10=null;
        Token lv_testingSign_22_1=null;
        Token lv_testingSign_22_2=null;
        Token lv_testingSign_22_3=null;
        Token lv_testingSign_22_4=null;
        Token lv_testingSign_22_5=null;
        Token lv_testingSign_22_6=null;
        Token lv_logicalSign_25_1=null;
        Token lv_logicalSign_25_2=null;
        Token lv_logicalSign_25_3=null;
        Token lv_logicalSign_25_4=null;
        Token lv_logicalSign_25_5=null;
        Token lv_logicalSign_25_6=null;
        Token lv_logicalSign_25_7=null;
        Token this_WAT_29=null;
        Token this_COLON_31=null;
        Token lv_stringSign_34_1=null;
        Token lv_stringSign_34_2=null;
        Token lv_bitSign_37_1=null;
        Token lv_bitSign_37_2=null;
        Token lv_bitSign_37_3=null;
        Token lv_bitSign_37_4=null;
        EObject lv_argList_1_0 = null;

        EObject lv_aux_3_0 = null;

        EObject lv_expression2_5_0 = null;

        EObject lv_aux_7_0 = null;

        EObject lv_expression2_9_0 = null;

        EObject lv_aux_10_0 = null;

        EObject lv_expressionComma_12_0 = null;

        EObject lv_aux_13_0 = null;

        AntlrDatatypeRuleToken lv_name_15_0 = null;

        EObject lv_aux_16_0 = null;

        EObject lv_aux_18_0 = null;

        EObject lv_exp2_20_0 = null;

        EObject lv_aux_21_0 = null;

        EObject lv_exp1_23_0 = null;

        EObject lv_aux_24_0 = null;

        EObject lv_ampersand_26_0 = null;

        EObject lv_exp1_27_0 = null;

        EObject lv_aux_28_0 = null;

        EObject lv_exp1_30_0 = null;

        EObject lv_exp2_32_0 = null;

        EObject lv_aux_33_0 = null;

        EObject lv_exp1_35_0 = null;

        EObject lv_aux_36_0 = null;

        EObject lv_expressionBit_38_0 = null;

        EObject lv_aux_39_0 = null;


         enterRule(); 
            
        try {
            // InternalJava.g:1893:28: ( ( ( (otherlv_0= '(' ( (lv_argList_1_0= ruleArg_List ) )? otherlv_2= ')' ) ( (lv_aux_3_0= ruleExpression_aux ) ) ) | ( (otherlv_4= '[' ( (lv_expression2_5_0= ruleExpression ) ) otherlv_6= ']' ) ( (lv_aux_7_0= ruleExpression_aux ) ) ) | ( (otherlv_8= '.' ( (lv_expression2_9_0= ruleExpression ) ) ) ( (lv_aux_10_0= ruleExpression_aux ) ) ) | ( (this_COMMA_11= RULE_COMMA ( (lv_expressionComma_12_0= ruleExpression ) ) ) ( (lv_aux_13_0= ruleExpression_aux ) ) ) | ( (this_INSTANCEOF_14= RULE_INSTANCEOF ( (lv_name_15_0= ruleClass_name ) ) ) ( (lv_aux_16_0= ruleExpression_aux ) ) ) | ( ( ( (lv_sgin_17_1= RULE_INCREMENT | lv_sgin_17_2= RULE_DECREMENT ) ) ) ( (lv_aux_18_0= ruleExpression_aux ) ) ) | ( ( ( (lv_numericSign_19_1= RULE_PLUS | lv_numericSign_19_2= RULE_PLUS_EQUAL | lv_numericSign_19_3= RULE_MINUS | lv_numericSign_19_4= RULE_MINUS_EQUAL | lv_numericSign_19_5= RULE_MULTIPLY | lv_numericSign_19_6= RULE_MULTIPLY_EQUAL | lv_numericSign_19_7= RULE_DIVIDE | lv_numericSign_19_8= RULE_DIVIDE_EQUAL | lv_numericSign_19_9= RULE_MODULE | lv_numericSign_19_10= RULE_MODULE_EQUAL ) ) ) ( (lv_exp2_20_0= ruleExpression ) ) ( (lv_aux_21_0= ruleExpression_aux ) ) ) | ( ( ( (lv_testingSign_22_1= RULE_BT | lv_testingSign_22_2= RULE_ST | lv_testingSign_22_3= RULE_BE | lv_testingSign_22_4= RULE_SE | lv_testingSign_22_5= RULE_DOUBLE_EQUAL | lv_testingSign_22_6= RULE_DIFFERENT ) ) ) ( (lv_exp1_23_0= ruleExpression ) ) ( (lv_aux_24_0= ruleExpression_aux ) ) ) | ( ( ( ( (lv_logicalSign_25_1= RULE_OR | lv_logicalSign_25_2= RULE_OR_EQUAL | lv_logicalSign_25_3= RULE_EXP | lv_logicalSign_25_4= RULE_EXP_EQUAL | lv_logicalSign_25_5= RULE_DOUBLE_OR_EQUAL | lv_logicalSign_25_6= RULE_MODULE | lv_logicalSign_25_7= RULE_MODULE_EQUAL ) ) ) | ( (lv_ampersand_26_0= ruleAmpersand_Rule ) ) ) ( (lv_exp1_27_0= ruleExpression ) ) ( (lv_aux_28_0= ruleExpression_aux ) ) ) | (this_WAT_29= RULE_WAT ( (lv_exp1_30_0= ruleExpression ) ) this_COLON_31= RULE_COLON ( (lv_exp2_32_0= ruleExpression ) ) ( (lv_aux_33_0= ruleExpression_aux ) ) ) | ( ( ( (lv_stringSign_34_1= RULE_PLUS | lv_stringSign_34_2= RULE_PLUS_EQUAL ) ) ) ( (lv_exp1_35_0= ruleExpression ) ) ( (lv_aux_36_0= ruleExpression_aux ) ) ) | ( ( ( (lv_bitSign_37_1= RULE_R_SHIFT_EQUAL | lv_bitSign_37_2= RULE_L_SHIFT | lv_bitSign_37_3= RULE_R_SHIFT | lv_bitSign_37_4= RULE_SUPER_SHIFT ) ) ) ( (lv_expressionBit_38_0= ruleExpression ) ) ( (lv_aux_39_0= ruleExpression_aux ) ) ) | () ) )
            // InternalJava.g:1894:1: ( ( (otherlv_0= '(' ( (lv_argList_1_0= ruleArg_List ) )? otherlv_2= ')' ) ( (lv_aux_3_0= ruleExpression_aux ) ) ) | ( (otherlv_4= '[' ( (lv_expression2_5_0= ruleExpression ) ) otherlv_6= ']' ) ( (lv_aux_7_0= ruleExpression_aux ) ) ) | ( (otherlv_8= '.' ( (lv_expression2_9_0= ruleExpression ) ) ) ( (lv_aux_10_0= ruleExpression_aux ) ) ) | ( (this_COMMA_11= RULE_COMMA ( (lv_expressionComma_12_0= ruleExpression ) ) ) ( (lv_aux_13_0= ruleExpression_aux ) ) ) | ( (this_INSTANCEOF_14= RULE_INSTANCEOF ( (lv_name_15_0= ruleClass_name ) ) ) ( (lv_aux_16_0= ruleExpression_aux ) ) ) | ( ( ( (lv_sgin_17_1= RULE_INCREMENT | lv_sgin_17_2= RULE_DECREMENT ) ) ) ( (lv_aux_18_0= ruleExpression_aux ) ) ) | ( ( ( (lv_numericSign_19_1= RULE_PLUS | lv_numericSign_19_2= RULE_PLUS_EQUAL | lv_numericSign_19_3= RULE_MINUS | lv_numericSign_19_4= RULE_MINUS_EQUAL | lv_numericSign_19_5= RULE_MULTIPLY | lv_numericSign_19_6= RULE_MULTIPLY_EQUAL | lv_numericSign_19_7= RULE_DIVIDE | lv_numericSign_19_8= RULE_DIVIDE_EQUAL | lv_numericSign_19_9= RULE_MODULE | lv_numericSign_19_10= RULE_MODULE_EQUAL ) ) ) ( (lv_exp2_20_0= ruleExpression ) ) ( (lv_aux_21_0= ruleExpression_aux ) ) ) | ( ( ( (lv_testingSign_22_1= RULE_BT | lv_testingSign_22_2= RULE_ST | lv_testingSign_22_3= RULE_BE | lv_testingSign_22_4= RULE_SE | lv_testingSign_22_5= RULE_DOUBLE_EQUAL | lv_testingSign_22_6= RULE_DIFFERENT ) ) ) ( (lv_exp1_23_0= ruleExpression ) ) ( (lv_aux_24_0= ruleExpression_aux ) ) ) | ( ( ( ( (lv_logicalSign_25_1= RULE_OR | lv_logicalSign_25_2= RULE_OR_EQUAL | lv_logicalSign_25_3= RULE_EXP | lv_logicalSign_25_4= RULE_EXP_EQUAL | lv_logicalSign_25_5= RULE_DOUBLE_OR_EQUAL | lv_logicalSign_25_6= RULE_MODULE | lv_logicalSign_25_7= RULE_MODULE_EQUAL ) ) ) | ( (lv_ampersand_26_0= ruleAmpersand_Rule ) ) ) ( (lv_exp1_27_0= ruleExpression ) ) ( (lv_aux_28_0= ruleExpression_aux ) ) ) | (this_WAT_29= RULE_WAT ( (lv_exp1_30_0= ruleExpression ) ) this_COLON_31= RULE_COLON ( (lv_exp2_32_0= ruleExpression ) ) ( (lv_aux_33_0= ruleExpression_aux ) ) ) | ( ( ( (lv_stringSign_34_1= RULE_PLUS | lv_stringSign_34_2= RULE_PLUS_EQUAL ) ) ) ( (lv_exp1_35_0= ruleExpression ) ) ( (lv_aux_36_0= ruleExpression_aux ) ) ) | ( ( ( (lv_bitSign_37_1= RULE_R_SHIFT_EQUAL | lv_bitSign_37_2= RULE_L_SHIFT | lv_bitSign_37_3= RULE_R_SHIFT | lv_bitSign_37_4= RULE_SUPER_SHIFT ) ) ) ( (lv_expressionBit_38_0= ruleExpression ) ) ( (lv_aux_39_0= ruleExpression_aux ) ) ) | () )
            {
            // InternalJava.g:1894:1: ( ( (otherlv_0= '(' ( (lv_argList_1_0= ruleArg_List ) )? otherlv_2= ')' ) ( (lv_aux_3_0= ruleExpression_aux ) ) ) | ( (otherlv_4= '[' ( (lv_expression2_5_0= ruleExpression ) ) otherlv_6= ']' ) ( (lv_aux_7_0= ruleExpression_aux ) ) ) | ( (otherlv_8= '.' ( (lv_expression2_9_0= ruleExpression ) ) ) ( (lv_aux_10_0= ruleExpression_aux ) ) ) | ( (this_COMMA_11= RULE_COMMA ( (lv_expressionComma_12_0= ruleExpression ) ) ) ( (lv_aux_13_0= ruleExpression_aux ) ) ) | ( (this_INSTANCEOF_14= RULE_INSTANCEOF ( (lv_name_15_0= ruleClass_name ) ) ) ( (lv_aux_16_0= ruleExpression_aux ) ) ) | ( ( ( (lv_sgin_17_1= RULE_INCREMENT | lv_sgin_17_2= RULE_DECREMENT ) ) ) ( (lv_aux_18_0= ruleExpression_aux ) ) ) | ( ( ( (lv_numericSign_19_1= RULE_PLUS | lv_numericSign_19_2= RULE_PLUS_EQUAL | lv_numericSign_19_3= RULE_MINUS | lv_numericSign_19_4= RULE_MINUS_EQUAL | lv_numericSign_19_5= RULE_MULTIPLY | lv_numericSign_19_6= RULE_MULTIPLY_EQUAL | lv_numericSign_19_7= RULE_DIVIDE | lv_numericSign_19_8= RULE_DIVIDE_EQUAL | lv_numericSign_19_9= RULE_MODULE | lv_numericSign_19_10= RULE_MODULE_EQUAL ) ) ) ( (lv_exp2_20_0= ruleExpression ) ) ( (lv_aux_21_0= ruleExpression_aux ) ) ) | ( ( ( (lv_testingSign_22_1= RULE_BT | lv_testingSign_22_2= RULE_ST | lv_testingSign_22_3= RULE_BE | lv_testingSign_22_4= RULE_SE | lv_testingSign_22_5= RULE_DOUBLE_EQUAL | lv_testingSign_22_6= RULE_DIFFERENT ) ) ) ( (lv_exp1_23_0= ruleExpression ) ) ( (lv_aux_24_0= ruleExpression_aux ) ) ) | ( ( ( ( (lv_logicalSign_25_1= RULE_OR | lv_logicalSign_25_2= RULE_OR_EQUAL | lv_logicalSign_25_3= RULE_EXP | lv_logicalSign_25_4= RULE_EXP_EQUAL | lv_logicalSign_25_5= RULE_DOUBLE_OR_EQUAL | lv_logicalSign_25_6= RULE_MODULE | lv_logicalSign_25_7= RULE_MODULE_EQUAL ) ) ) | ( (lv_ampersand_26_0= ruleAmpersand_Rule ) ) ) ( (lv_exp1_27_0= ruleExpression ) ) ( (lv_aux_28_0= ruleExpression_aux ) ) ) | (this_WAT_29= RULE_WAT ( (lv_exp1_30_0= ruleExpression ) ) this_COLON_31= RULE_COLON ( (lv_exp2_32_0= ruleExpression ) ) ( (lv_aux_33_0= ruleExpression_aux ) ) ) | ( ( ( (lv_stringSign_34_1= RULE_PLUS | lv_stringSign_34_2= RULE_PLUS_EQUAL ) ) ) ( (lv_exp1_35_0= ruleExpression ) ) ( (lv_aux_36_0= ruleExpression_aux ) ) ) | ( ( ( (lv_bitSign_37_1= RULE_R_SHIFT_EQUAL | lv_bitSign_37_2= RULE_L_SHIFT | lv_bitSign_37_3= RULE_R_SHIFT | lv_bitSign_37_4= RULE_SUPER_SHIFT ) ) ) ( (lv_expressionBit_38_0= ruleExpression ) ) ( (lv_aux_39_0= ruleExpression_aux ) ) ) | () )
            int alt46=13;
            alt46 = dfa46.predict(input);
            switch (alt46) {
                case 1 :
                    // InternalJava.g:1894:2: ( (otherlv_0= '(' ( (lv_argList_1_0= ruleArg_List ) )? otherlv_2= ')' ) ( (lv_aux_3_0= ruleExpression_aux ) ) )
                    {
                    // InternalJava.g:1894:2: ( (otherlv_0= '(' ( (lv_argList_1_0= ruleArg_List ) )? otherlv_2= ')' ) ( (lv_aux_3_0= ruleExpression_aux ) ) )
                    // InternalJava.g:1894:3: (otherlv_0= '(' ( (lv_argList_1_0= ruleArg_List ) )? otherlv_2= ')' ) ( (lv_aux_3_0= ruleExpression_aux ) )
                    {
                    // InternalJava.g:1894:3: (otherlv_0= '(' ( (lv_argList_1_0= ruleArg_List ) )? otherlv_2= ')' )
                    // InternalJava.g:1894:5: otherlv_0= '(' ( (lv_argList_1_0= ruleArg_List ) )? otherlv_2= ')'
                    {
                    otherlv_0=(Token)match(input,78,FOLLOW_34); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getExpression_auxAccess().getLeftParenthesisKeyword_0_0_0());
                          
                    }
                    // InternalJava.g:1898:1: ( (lv_argList_1_0= ruleArg_List ) )?
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0==RULE_ID||(LA38_0>=RULE_NULL && LA38_0<=RULE_THIS)||(LA38_0>=RULE_INCREMENT && LA38_0<=RULE_DECREMENT)||LA38_0==RULE_MINUS||(LA38_0>=RULE_DECIMAL_DIGITS && LA38_0<=RULE_FALSE)||LA38_0==78) ) {
                        alt38=1;
                    }
                    switch (alt38) {
                        case 1 :
                            // InternalJava.g:1899:1: (lv_argList_1_0= ruleArg_List )
                            {
                            // InternalJava.g:1899:1: (lv_argList_1_0= ruleArg_List )
                            // InternalJava.g:1900:3: lv_argList_1_0= ruleArg_List
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getExpression_auxAccess().getArgListArg_ListParserRuleCall_0_0_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_19);
                            lv_argList_1_0=ruleArg_List();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getExpression_auxRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"argList",
                                      		lv_argList_1_0, 
                                      		"org.xtext.java.Java.Arg_List");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }
                            break;

                    }

                    otherlv_2=(Token)match(input,79,FOLLOW_33); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getExpression_auxAccess().getRightParenthesisKeyword_0_0_2());
                          
                    }

                    }

                    // InternalJava.g:1920:2: ( (lv_aux_3_0= ruleExpression_aux ) )
                    // InternalJava.g:1921:1: (lv_aux_3_0= ruleExpression_aux )
                    {
                    // InternalJava.g:1921:1: (lv_aux_3_0= ruleExpression_aux )
                    // InternalJava.g:1922:3: lv_aux_3_0= ruleExpression_aux
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpression_auxAccess().getAuxExpression_auxParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_aux_3_0=ruleExpression_aux();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpression_auxRule());
                      	        }
                             		set(
                             			current, 
                             			"aux",
                              		lv_aux_3_0, 
                              		"org.xtext.java.Java.Expression_aux");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalJava.g:1939:6: ( (otherlv_4= '[' ( (lv_expression2_5_0= ruleExpression ) ) otherlv_6= ']' ) ( (lv_aux_7_0= ruleExpression_aux ) ) )
                    {
                    // InternalJava.g:1939:6: ( (otherlv_4= '[' ( (lv_expression2_5_0= ruleExpression ) ) otherlv_6= ']' ) ( (lv_aux_7_0= ruleExpression_aux ) ) )
                    // InternalJava.g:1939:7: (otherlv_4= '[' ( (lv_expression2_5_0= ruleExpression ) ) otherlv_6= ']' ) ( (lv_aux_7_0= ruleExpression_aux ) )
                    {
                    // InternalJava.g:1939:7: (otherlv_4= '[' ( (lv_expression2_5_0= ruleExpression ) ) otherlv_6= ']' )
                    // InternalJava.g:1939:9: otherlv_4= '[' ( (lv_expression2_5_0= ruleExpression ) ) otherlv_6= ']'
                    {
                    otherlv_4=(Token)match(input,80,FOLLOW_35); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getExpression_auxAccess().getLeftSquareBracketKeyword_1_0_0());
                          
                    }
                    // InternalJava.g:1943:1: ( (lv_expression2_5_0= ruleExpression ) )
                    // InternalJava.g:1944:1: (lv_expression2_5_0= ruleExpression )
                    {
                    // InternalJava.g:1944:1: (lv_expression2_5_0= ruleExpression )
                    // InternalJava.g:1945:3: lv_expression2_5_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpression_auxAccess().getExpression2ExpressionParserRuleCall_1_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_21);
                    lv_expression2_5_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpression_auxRule());
                      	        }
                             		set(
                             			current, 
                             			"expression2",
                              		lv_expression2_5_0, 
                              		"org.xtext.java.Java.Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_6=(Token)match(input,81,FOLLOW_33); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getExpression_auxAccess().getRightSquareBracketKeyword_1_0_2());
                          
                    }

                    }

                    // InternalJava.g:1965:2: ( (lv_aux_7_0= ruleExpression_aux ) )
                    // InternalJava.g:1966:1: (lv_aux_7_0= ruleExpression_aux )
                    {
                    // InternalJava.g:1966:1: (lv_aux_7_0= ruleExpression_aux )
                    // InternalJava.g:1967:3: lv_aux_7_0= ruleExpression_aux
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpression_auxAccess().getAuxExpression_auxParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_aux_7_0=ruleExpression_aux();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpression_auxRule());
                      	        }
                             		set(
                             			current, 
                             			"aux",
                              		lv_aux_7_0, 
                              		"org.xtext.java.Java.Expression_aux");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalJava.g:1984:6: ( (otherlv_8= '.' ( (lv_expression2_9_0= ruleExpression ) ) ) ( (lv_aux_10_0= ruleExpression_aux ) ) )
                    {
                    // InternalJava.g:1984:6: ( (otherlv_8= '.' ( (lv_expression2_9_0= ruleExpression ) ) ) ( (lv_aux_10_0= ruleExpression_aux ) ) )
                    // InternalJava.g:1984:7: (otherlv_8= '.' ( (lv_expression2_9_0= ruleExpression ) ) ) ( (lv_aux_10_0= ruleExpression_aux ) )
                    {
                    // InternalJava.g:1984:7: (otherlv_8= '.' ( (lv_expression2_9_0= ruleExpression ) ) )
                    // InternalJava.g:1984:9: otherlv_8= '.' ( (lv_expression2_9_0= ruleExpression ) )
                    {
                    otherlv_8=(Token)match(input,83,FOLLOW_35); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getExpression_auxAccess().getFullStopKeyword_2_0_0());
                          
                    }
                    // InternalJava.g:1988:1: ( (lv_expression2_9_0= ruleExpression ) )
                    // InternalJava.g:1989:1: (lv_expression2_9_0= ruleExpression )
                    {
                    // InternalJava.g:1989:1: (lv_expression2_9_0= ruleExpression )
                    // InternalJava.g:1990:3: lv_expression2_9_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpression_auxAccess().getExpression2ExpressionParserRuleCall_2_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_33);
                    lv_expression2_9_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpression_auxRule());
                      	        }
                             		set(
                             			current, 
                             			"expression2",
                              		lv_expression2_9_0, 
                              		"org.xtext.java.Java.Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }

                    // InternalJava.g:2006:3: ( (lv_aux_10_0= ruleExpression_aux ) )
                    // InternalJava.g:2007:1: (lv_aux_10_0= ruleExpression_aux )
                    {
                    // InternalJava.g:2007:1: (lv_aux_10_0= ruleExpression_aux )
                    // InternalJava.g:2008:3: lv_aux_10_0= ruleExpression_aux
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpression_auxAccess().getAuxExpression_auxParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_aux_10_0=ruleExpression_aux();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpression_auxRule());
                      	        }
                             		set(
                             			current, 
                             			"aux",
                              		lv_aux_10_0, 
                              		"org.xtext.java.Java.Expression_aux");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalJava.g:2025:6: ( (this_COMMA_11= RULE_COMMA ( (lv_expressionComma_12_0= ruleExpression ) ) ) ( (lv_aux_13_0= ruleExpression_aux ) ) )
                    {
                    // InternalJava.g:2025:6: ( (this_COMMA_11= RULE_COMMA ( (lv_expressionComma_12_0= ruleExpression ) ) ) ( (lv_aux_13_0= ruleExpression_aux ) ) )
                    // InternalJava.g:2025:7: (this_COMMA_11= RULE_COMMA ( (lv_expressionComma_12_0= ruleExpression ) ) ) ( (lv_aux_13_0= ruleExpression_aux ) )
                    {
                    // InternalJava.g:2025:7: (this_COMMA_11= RULE_COMMA ( (lv_expressionComma_12_0= ruleExpression ) ) )
                    // InternalJava.g:2025:8: this_COMMA_11= RULE_COMMA ( (lv_expressionComma_12_0= ruleExpression ) )
                    {
                    this_COMMA_11=(Token)match(input,RULE_COMMA,FOLLOW_35); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_COMMA_11, grammarAccess.getExpression_auxAccess().getCOMMATerminalRuleCall_3_0_0()); 
                          
                    }
                    // InternalJava.g:2029:1: ( (lv_expressionComma_12_0= ruleExpression ) )
                    // InternalJava.g:2030:1: (lv_expressionComma_12_0= ruleExpression )
                    {
                    // InternalJava.g:2030:1: (lv_expressionComma_12_0= ruleExpression )
                    // InternalJava.g:2031:3: lv_expressionComma_12_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpression_auxAccess().getExpressionCommaExpressionParserRuleCall_3_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_33);
                    lv_expressionComma_12_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpression_auxRule());
                      	        }
                             		set(
                             			current, 
                             			"expressionComma",
                              		lv_expressionComma_12_0, 
                              		"org.xtext.java.Java.Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }

                    // InternalJava.g:2047:3: ( (lv_aux_13_0= ruleExpression_aux ) )
                    // InternalJava.g:2048:1: (lv_aux_13_0= ruleExpression_aux )
                    {
                    // InternalJava.g:2048:1: (lv_aux_13_0= ruleExpression_aux )
                    // InternalJava.g:2049:3: lv_aux_13_0= ruleExpression_aux
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpression_auxAccess().getAuxExpression_auxParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_aux_13_0=ruleExpression_aux();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpression_auxRule());
                      	        }
                             		set(
                             			current, 
                             			"aux",
                              		lv_aux_13_0, 
                              		"org.xtext.java.Java.Expression_aux");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalJava.g:2066:6: ( (this_INSTANCEOF_14= RULE_INSTANCEOF ( (lv_name_15_0= ruleClass_name ) ) ) ( (lv_aux_16_0= ruleExpression_aux ) ) )
                    {
                    // InternalJava.g:2066:6: ( (this_INSTANCEOF_14= RULE_INSTANCEOF ( (lv_name_15_0= ruleClass_name ) ) ) ( (lv_aux_16_0= ruleExpression_aux ) ) )
                    // InternalJava.g:2066:7: (this_INSTANCEOF_14= RULE_INSTANCEOF ( (lv_name_15_0= ruleClass_name ) ) ) ( (lv_aux_16_0= ruleExpression_aux ) )
                    {
                    // InternalJava.g:2066:7: (this_INSTANCEOF_14= RULE_INSTANCEOF ( (lv_name_15_0= ruleClass_name ) ) )
                    // InternalJava.g:2066:8: this_INSTANCEOF_14= RULE_INSTANCEOF ( (lv_name_15_0= ruleClass_name ) )
                    {
                    this_INSTANCEOF_14=(Token)match(input,RULE_INSTANCEOF,FOLLOW_14); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_INSTANCEOF_14, grammarAccess.getExpression_auxAccess().getINSTANCEOFTerminalRuleCall_4_0_0()); 
                          
                    }
                    // InternalJava.g:2070:1: ( (lv_name_15_0= ruleClass_name ) )
                    // InternalJava.g:2071:1: (lv_name_15_0= ruleClass_name )
                    {
                    // InternalJava.g:2071:1: (lv_name_15_0= ruleClass_name )
                    // InternalJava.g:2072:3: lv_name_15_0= ruleClass_name
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpression_auxAccess().getNameClass_nameParserRuleCall_4_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_33);
                    lv_name_15_0=ruleClass_name();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpression_auxRule());
                      	        }
                             		set(
                             			current, 
                             			"name",
                              		lv_name_15_0, 
                              		"org.xtext.java.Java.Class_name");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }

                    // InternalJava.g:2088:3: ( (lv_aux_16_0= ruleExpression_aux ) )
                    // InternalJava.g:2089:1: (lv_aux_16_0= ruleExpression_aux )
                    {
                    // InternalJava.g:2089:1: (lv_aux_16_0= ruleExpression_aux )
                    // InternalJava.g:2090:3: lv_aux_16_0= ruleExpression_aux
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpression_auxAccess().getAuxExpression_auxParserRuleCall_4_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_aux_16_0=ruleExpression_aux();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpression_auxRule());
                      	        }
                             		set(
                             			current, 
                             			"aux",
                              		lv_aux_16_0, 
                              		"org.xtext.java.Java.Expression_aux");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalJava.g:2107:6: ( ( ( (lv_sgin_17_1= RULE_INCREMENT | lv_sgin_17_2= RULE_DECREMENT ) ) ) ( (lv_aux_18_0= ruleExpression_aux ) ) )
                    {
                    // InternalJava.g:2107:6: ( ( ( (lv_sgin_17_1= RULE_INCREMENT | lv_sgin_17_2= RULE_DECREMENT ) ) ) ( (lv_aux_18_0= ruleExpression_aux ) ) )
                    // InternalJava.g:2107:7: ( ( (lv_sgin_17_1= RULE_INCREMENT | lv_sgin_17_2= RULE_DECREMENT ) ) ) ( (lv_aux_18_0= ruleExpression_aux ) )
                    {
                    // InternalJava.g:2107:7: ( ( (lv_sgin_17_1= RULE_INCREMENT | lv_sgin_17_2= RULE_DECREMENT ) ) )
                    // InternalJava.g:2108:1: ( (lv_sgin_17_1= RULE_INCREMENT | lv_sgin_17_2= RULE_DECREMENT ) )
                    {
                    // InternalJava.g:2108:1: ( (lv_sgin_17_1= RULE_INCREMENT | lv_sgin_17_2= RULE_DECREMENT ) )
                    // InternalJava.g:2109:1: (lv_sgin_17_1= RULE_INCREMENT | lv_sgin_17_2= RULE_DECREMENT )
                    {
                    // InternalJava.g:2109:1: (lv_sgin_17_1= RULE_INCREMENT | lv_sgin_17_2= RULE_DECREMENT )
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==RULE_INCREMENT) ) {
                        alt39=1;
                    }
                    else if ( (LA39_0==RULE_DECREMENT) ) {
                        alt39=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 39, 0, input);

                        throw nvae;
                    }
                    switch (alt39) {
                        case 1 :
                            // InternalJava.g:2110:3: lv_sgin_17_1= RULE_INCREMENT
                            {
                            lv_sgin_17_1=(Token)match(input,RULE_INCREMENT,FOLLOW_33); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_sgin_17_1, grammarAccess.getExpression_auxAccess().getSginINCREMENTTerminalRuleCall_5_0_0_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getExpression_auxRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"sgin",
                                      		lv_sgin_17_1, 
                                      		"org.xtext.java.Java.INCREMENT");
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // InternalJava.g:2125:8: lv_sgin_17_2= RULE_DECREMENT
                            {
                            lv_sgin_17_2=(Token)match(input,RULE_DECREMENT,FOLLOW_33); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_sgin_17_2, grammarAccess.getExpression_auxAccess().getSginDECREMENTTerminalRuleCall_5_0_0_1()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getExpression_auxRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"sgin",
                                      		lv_sgin_17_2, 
                                      		"org.xtext.java.Java.DECREMENT");
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }

                    // InternalJava.g:2143:2: ( (lv_aux_18_0= ruleExpression_aux ) )
                    // InternalJava.g:2144:1: (lv_aux_18_0= ruleExpression_aux )
                    {
                    // InternalJava.g:2144:1: (lv_aux_18_0= ruleExpression_aux )
                    // InternalJava.g:2145:3: lv_aux_18_0= ruleExpression_aux
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpression_auxAccess().getAuxExpression_auxParserRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_aux_18_0=ruleExpression_aux();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpression_auxRule());
                      	        }
                             		set(
                             			current, 
                             			"aux",
                              		lv_aux_18_0, 
                              		"org.xtext.java.Java.Expression_aux");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalJava.g:2162:6: ( ( ( (lv_numericSign_19_1= RULE_PLUS | lv_numericSign_19_2= RULE_PLUS_EQUAL | lv_numericSign_19_3= RULE_MINUS | lv_numericSign_19_4= RULE_MINUS_EQUAL | lv_numericSign_19_5= RULE_MULTIPLY | lv_numericSign_19_6= RULE_MULTIPLY_EQUAL | lv_numericSign_19_7= RULE_DIVIDE | lv_numericSign_19_8= RULE_DIVIDE_EQUAL | lv_numericSign_19_9= RULE_MODULE | lv_numericSign_19_10= RULE_MODULE_EQUAL ) ) ) ( (lv_exp2_20_0= ruleExpression ) ) ( (lv_aux_21_0= ruleExpression_aux ) ) )
                    {
                    // InternalJava.g:2162:6: ( ( ( (lv_numericSign_19_1= RULE_PLUS | lv_numericSign_19_2= RULE_PLUS_EQUAL | lv_numericSign_19_3= RULE_MINUS | lv_numericSign_19_4= RULE_MINUS_EQUAL | lv_numericSign_19_5= RULE_MULTIPLY | lv_numericSign_19_6= RULE_MULTIPLY_EQUAL | lv_numericSign_19_7= RULE_DIVIDE | lv_numericSign_19_8= RULE_DIVIDE_EQUAL | lv_numericSign_19_9= RULE_MODULE | lv_numericSign_19_10= RULE_MODULE_EQUAL ) ) ) ( (lv_exp2_20_0= ruleExpression ) ) ( (lv_aux_21_0= ruleExpression_aux ) ) )
                    // InternalJava.g:2162:7: ( ( (lv_numericSign_19_1= RULE_PLUS | lv_numericSign_19_2= RULE_PLUS_EQUAL | lv_numericSign_19_3= RULE_MINUS | lv_numericSign_19_4= RULE_MINUS_EQUAL | lv_numericSign_19_5= RULE_MULTIPLY | lv_numericSign_19_6= RULE_MULTIPLY_EQUAL | lv_numericSign_19_7= RULE_DIVIDE | lv_numericSign_19_8= RULE_DIVIDE_EQUAL | lv_numericSign_19_9= RULE_MODULE | lv_numericSign_19_10= RULE_MODULE_EQUAL ) ) ) ( (lv_exp2_20_0= ruleExpression ) ) ( (lv_aux_21_0= ruleExpression_aux ) )
                    {
                    // InternalJava.g:2162:7: ( ( (lv_numericSign_19_1= RULE_PLUS | lv_numericSign_19_2= RULE_PLUS_EQUAL | lv_numericSign_19_3= RULE_MINUS | lv_numericSign_19_4= RULE_MINUS_EQUAL | lv_numericSign_19_5= RULE_MULTIPLY | lv_numericSign_19_6= RULE_MULTIPLY_EQUAL | lv_numericSign_19_7= RULE_DIVIDE | lv_numericSign_19_8= RULE_DIVIDE_EQUAL | lv_numericSign_19_9= RULE_MODULE | lv_numericSign_19_10= RULE_MODULE_EQUAL ) ) )
                    // InternalJava.g:2163:1: ( (lv_numericSign_19_1= RULE_PLUS | lv_numericSign_19_2= RULE_PLUS_EQUAL | lv_numericSign_19_3= RULE_MINUS | lv_numericSign_19_4= RULE_MINUS_EQUAL | lv_numericSign_19_5= RULE_MULTIPLY | lv_numericSign_19_6= RULE_MULTIPLY_EQUAL | lv_numericSign_19_7= RULE_DIVIDE | lv_numericSign_19_8= RULE_DIVIDE_EQUAL | lv_numericSign_19_9= RULE_MODULE | lv_numericSign_19_10= RULE_MODULE_EQUAL ) )
                    {
                    // InternalJava.g:2163:1: ( (lv_numericSign_19_1= RULE_PLUS | lv_numericSign_19_2= RULE_PLUS_EQUAL | lv_numericSign_19_3= RULE_MINUS | lv_numericSign_19_4= RULE_MINUS_EQUAL | lv_numericSign_19_5= RULE_MULTIPLY | lv_numericSign_19_6= RULE_MULTIPLY_EQUAL | lv_numericSign_19_7= RULE_DIVIDE | lv_numericSign_19_8= RULE_DIVIDE_EQUAL | lv_numericSign_19_9= RULE_MODULE | lv_numericSign_19_10= RULE_MODULE_EQUAL ) )
                    // InternalJava.g:2164:1: (lv_numericSign_19_1= RULE_PLUS | lv_numericSign_19_2= RULE_PLUS_EQUAL | lv_numericSign_19_3= RULE_MINUS | lv_numericSign_19_4= RULE_MINUS_EQUAL | lv_numericSign_19_5= RULE_MULTIPLY | lv_numericSign_19_6= RULE_MULTIPLY_EQUAL | lv_numericSign_19_7= RULE_DIVIDE | lv_numericSign_19_8= RULE_DIVIDE_EQUAL | lv_numericSign_19_9= RULE_MODULE | lv_numericSign_19_10= RULE_MODULE_EQUAL )
                    {
                    // InternalJava.g:2164:1: (lv_numericSign_19_1= RULE_PLUS | lv_numericSign_19_2= RULE_PLUS_EQUAL | lv_numericSign_19_3= RULE_MINUS | lv_numericSign_19_4= RULE_MINUS_EQUAL | lv_numericSign_19_5= RULE_MULTIPLY | lv_numericSign_19_6= RULE_MULTIPLY_EQUAL | lv_numericSign_19_7= RULE_DIVIDE | lv_numericSign_19_8= RULE_DIVIDE_EQUAL | lv_numericSign_19_9= RULE_MODULE | lv_numericSign_19_10= RULE_MODULE_EQUAL )
                    int alt40=10;
                    switch ( input.LA(1) ) {
                    case RULE_PLUS:
                        {
                        alt40=1;
                        }
                        break;
                    case RULE_PLUS_EQUAL:
                        {
                        alt40=2;
                        }
                        break;
                    case RULE_MINUS:
                        {
                        alt40=3;
                        }
                        break;
                    case RULE_MINUS_EQUAL:
                        {
                        alt40=4;
                        }
                        break;
                    case RULE_MULTIPLY:
                        {
                        alt40=5;
                        }
                        break;
                    case RULE_MULTIPLY_EQUAL:
                        {
                        alt40=6;
                        }
                        break;
                    case RULE_DIVIDE:
                        {
                        alt40=7;
                        }
                        break;
                    case RULE_DIVIDE_EQUAL:
                        {
                        alt40=8;
                        }
                        break;
                    case RULE_MODULE:
                        {
                        alt40=9;
                        }
                        break;
                    case RULE_MODULE_EQUAL:
                        {
                        alt40=10;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 40, 0, input);

                        throw nvae;
                    }

                    switch (alt40) {
                        case 1 :
                            // InternalJava.g:2165:3: lv_numericSign_19_1= RULE_PLUS
                            {
                            lv_numericSign_19_1=(Token)match(input,RULE_PLUS,FOLLOW_35); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_numericSign_19_1, grammarAccess.getExpression_auxAccess().getNumericSignPLUSTerminalRuleCall_6_0_0_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getExpression_auxRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"numericSign",
                                      		lv_numericSign_19_1, 
                                      		"org.xtext.java.Java.PLUS");
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // InternalJava.g:2180:8: lv_numericSign_19_2= RULE_PLUS_EQUAL
                            {
                            lv_numericSign_19_2=(Token)match(input,RULE_PLUS_EQUAL,FOLLOW_35); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_numericSign_19_2, grammarAccess.getExpression_auxAccess().getNumericSignPLUS_EQUALTerminalRuleCall_6_0_0_1()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getExpression_auxRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"numericSign",
                                      		lv_numericSign_19_2, 
                                      		"org.xtext.java.Java.PLUS_EQUAL");
                              	    
                            }

                            }
                            break;
                        case 3 :
                            // InternalJava.g:2195:8: lv_numericSign_19_3= RULE_MINUS
                            {
                            lv_numericSign_19_3=(Token)match(input,RULE_MINUS,FOLLOW_35); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_numericSign_19_3, grammarAccess.getExpression_auxAccess().getNumericSignMINUSTerminalRuleCall_6_0_0_2()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getExpression_auxRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"numericSign",
                                      		lv_numericSign_19_3, 
                                      		"org.xtext.java.Java.MINUS");
                              	    
                            }

                            }
                            break;
                        case 4 :
                            // InternalJava.g:2210:8: lv_numericSign_19_4= RULE_MINUS_EQUAL
                            {
                            lv_numericSign_19_4=(Token)match(input,RULE_MINUS_EQUAL,FOLLOW_35); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_numericSign_19_4, grammarAccess.getExpression_auxAccess().getNumericSignMINUS_EQUALTerminalRuleCall_6_0_0_3()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getExpression_auxRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"numericSign",
                                      		lv_numericSign_19_4, 
                                      		"org.xtext.java.Java.MINUS_EQUAL");
                              	    
                            }

                            }
                            break;
                        case 5 :
                            // InternalJava.g:2225:8: lv_numericSign_19_5= RULE_MULTIPLY
                            {
                            lv_numericSign_19_5=(Token)match(input,RULE_MULTIPLY,FOLLOW_35); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_numericSign_19_5, grammarAccess.getExpression_auxAccess().getNumericSignMULTIPLYTerminalRuleCall_6_0_0_4()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getExpression_auxRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"numericSign",
                                      		lv_numericSign_19_5, 
                                      		"org.xtext.java.Java.MULTIPLY");
                              	    
                            }

                            }
                            break;
                        case 6 :
                            // InternalJava.g:2240:8: lv_numericSign_19_6= RULE_MULTIPLY_EQUAL
                            {
                            lv_numericSign_19_6=(Token)match(input,RULE_MULTIPLY_EQUAL,FOLLOW_35); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_numericSign_19_6, grammarAccess.getExpression_auxAccess().getNumericSignMULTIPLY_EQUALTerminalRuleCall_6_0_0_5()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getExpression_auxRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"numericSign",
                                      		lv_numericSign_19_6, 
                                      		"org.xtext.java.Java.MULTIPLY_EQUAL");
                              	    
                            }

                            }
                            break;
                        case 7 :
                            // InternalJava.g:2255:8: lv_numericSign_19_7= RULE_DIVIDE
                            {
                            lv_numericSign_19_7=(Token)match(input,RULE_DIVIDE,FOLLOW_35); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_numericSign_19_7, grammarAccess.getExpression_auxAccess().getNumericSignDIVIDETerminalRuleCall_6_0_0_6()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getExpression_auxRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"numericSign",
                                      		lv_numericSign_19_7, 
                                      		"org.xtext.java.Java.DIVIDE");
                              	    
                            }

                            }
                            break;
                        case 8 :
                            // InternalJava.g:2270:8: lv_numericSign_19_8= RULE_DIVIDE_EQUAL
                            {
                            lv_numericSign_19_8=(Token)match(input,RULE_DIVIDE_EQUAL,FOLLOW_35); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_numericSign_19_8, grammarAccess.getExpression_auxAccess().getNumericSignDIVIDE_EQUALTerminalRuleCall_6_0_0_7()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getExpression_auxRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"numericSign",
                                      		lv_numericSign_19_8, 
                                      		"org.xtext.java.Java.DIVIDE_EQUAL");
                              	    
                            }

                            }
                            break;
                        case 9 :
                            // InternalJava.g:2285:8: lv_numericSign_19_9= RULE_MODULE
                            {
                            lv_numericSign_19_9=(Token)match(input,RULE_MODULE,FOLLOW_35); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_numericSign_19_9, grammarAccess.getExpression_auxAccess().getNumericSignMODULETerminalRuleCall_6_0_0_8()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getExpression_auxRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"numericSign",
                                      		lv_numericSign_19_9, 
                                      		"org.xtext.java.Java.MODULE");
                              	    
                            }

                            }
                            break;
                        case 10 :
                            // InternalJava.g:2300:8: lv_numericSign_19_10= RULE_MODULE_EQUAL
                            {
                            lv_numericSign_19_10=(Token)match(input,RULE_MODULE_EQUAL,FOLLOW_35); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_numericSign_19_10, grammarAccess.getExpression_auxAccess().getNumericSignMODULE_EQUALTerminalRuleCall_6_0_0_9()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getExpression_auxRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"numericSign",
                                      		lv_numericSign_19_10, 
                                      		"org.xtext.java.Java.MODULE_EQUAL");
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }

                    // InternalJava.g:2318:2: ( (lv_exp2_20_0= ruleExpression ) )
                    // InternalJava.g:2319:1: (lv_exp2_20_0= ruleExpression )
                    {
                    // InternalJava.g:2319:1: (lv_exp2_20_0= ruleExpression )
                    // InternalJava.g:2320:3: lv_exp2_20_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpression_auxAccess().getExp2ExpressionParserRuleCall_6_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_33);
                    lv_exp2_20_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpression_auxRule());
                      	        }
                             		set(
                             			current, 
                             			"exp2",
                              		lv_exp2_20_0, 
                              		"org.xtext.java.Java.Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalJava.g:2336:2: ( (lv_aux_21_0= ruleExpression_aux ) )
                    // InternalJava.g:2337:1: (lv_aux_21_0= ruleExpression_aux )
                    {
                    // InternalJava.g:2337:1: (lv_aux_21_0= ruleExpression_aux )
                    // InternalJava.g:2338:3: lv_aux_21_0= ruleExpression_aux
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpression_auxAccess().getAuxExpression_auxParserRuleCall_6_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_aux_21_0=ruleExpression_aux();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpression_auxRule());
                      	        }
                             		set(
                             			current, 
                             			"aux",
                              		lv_aux_21_0, 
                              		"org.xtext.java.Java.Expression_aux");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalJava.g:2355:6: ( ( ( (lv_testingSign_22_1= RULE_BT | lv_testingSign_22_2= RULE_ST | lv_testingSign_22_3= RULE_BE | lv_testingSign_22_4= RULE_SE | lv_testingSign_22_5= RULE_DOUBLE_EQUAL | lv_testingSign_22_6= RULE_DIFFERENT ) ) ) ( (lv_exp1_23_0= ruleExpression ) ) ( (lv_aux_24_0= ruleExpression_aux ) ) )
                    {
                    // InternalJava.g:2355:6: ( ( ( (lv_testingSign_22_1= RULE_BT | lv_testingSign_22_2= RULE_ST | lv_testingSign_22_3= RULE_BE | lv_testingSign_22_4= RULE_SE | lv_testingSign_22_5= RULE_DOUBLE_EQUAL | lv_testingSign_22_6= RULE_DIFFERENT ) ) ) ( (lv_exp1_23_0= ruleExpression ) ) ( (lv_aux_24_0= ruleExpression_aux ) ) )
                    // InternalJava.g:2355:7: ( ( (lv_testingSign_22_1= RULE_BT | lv_testingSign_22_2= RULE_ST | lv_testingSign_22_3= RULE_BE | lv_testingSign_22_4= RULE_SE | lv_testingSign_22_5= RULE_DOUBLE_EQUAL | lv_testingSign_22_6= RULE_DIFFERENT ) ) ) ( (lv_exp1_23_0= ruleExpression ) ) ( (lv_aux_24_0= ruleExpression_aux ) )
                    {
                    // InternalJava.g:2355:7: ( ( (lv_testingSign_22_1= RULE_BT | lv_testingSign_22_2= RULE_ST | lv_testingSign_22_3= RULE_BE | lv_testingSign_22_4= RULE_SE | lv_testingSign_22_5= RULE_DOUBLE_EQUAL | lv_testingSign_22_6= RULE_DIFFERENT ) ) )
                    // InternalJava.g:2356:1: ( (lv_testingSign_22_1= RULE_BT | lv_testingSign_22_2= RULE_ST | lv_testingSign_22_3= RULE_BE | lv_testingSign_22_4= RULE_SE | lv_testingSign_22_5= RULE_DOUBLE_EQUAL | lv_testingSign_22_6= RULE_DIFFERENT ) )
                    {
                    // InternalJava.g:2356:1: ( (lv_testingSign_22_1= RULE_BT | lv_testingSign_22_2= RULE_ST | lv_testingSign_22_3= RULE_BE | lv_testingSign_22_4= RULE_SE | lv_testingSign_22_5= RULE_DOUBLE_EQUAL | lv_testingSign_22_6= RULE_DIFFERENT ) )
                    // InternalJava.g:2357:1: (lv_testingSign_22_1= RULE_BT | lv_testingSign_22_2= RULE_ST | lv_testingSign_22_3= RULE_BE | lv_testingSign_22_4= RULE_SE | lv_testingSign_22_5= RULE_DOUBLE_EQUAL | lv_testingSign_22_6= RULE_DIFFERENT )
                    {
                    // InternalJava.g:2357:1: (lv_testingSign_22_1= RULE_BT | lv_testingSign_22_2= RULE_ST | lv_testingSign_22_3= RULE_BE | lv_testingSign_22_4= RULE_SE | lv_testingSign_22_5= RULE_DOUBLE_EQUAL | lv_testingSign_22_6= RULE_DIFFERENT )
                    int alt41=6;
                    switch ( input.LA(1) ) {
                    case RULE_BT:
                        {
                        alt41=1;
                        }
                        break;
                    case RULE_ST:
                        {
                        alt41=2;
                        }
                        break;
                    case RULE_BE:
                        {
                        alt41=3;
                        }
                        break;
                    case RULE_SE:
                        {
                        alt41=4;
                        }
                        break;
                    case RULE_DOUBLE_EQUAL:
                        {
                        alt41=5;
                        }
                        break;
                    case RULE_DIFFERENT:
                        {
                        alt41=6;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 41, 0, input);

                        throw nvae;
                    }

                    switch (alt41) {
                        case 1 :
                            // InternalJava.g:2358:3: lv_testingSign_22_1= RULE_BT
                            {
                            lv_testingSign_22_1=(Token)match(input,RULE_BT,FOLLOW_35); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_testingSign_22_1, grammarAccess.getExpression_auxAccess().getTestingSignBTTerminalRuleCall_7_0_0_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getExpression_auxRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"testingSign",
                                      		lv_testingSign_22_1, 
                                      		"org.xtext.java.Java.BT");
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // InternalJava.g:2373:8: lv_testingSign_22_2= RULE_ST
                            {
                            lv_testingSign_22_2=(Token)match(input,RULE_ST,FOLLOW_35); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_testingSign_22_2, grammarAccess.getExpression_auxAccess().getTestingSignSTTerminalRuleCall_7_0_0_1()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getExpression_auxRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"testingSign",
                                      		lv_testingSign_22_2, 
                                      		"org.xtext.java.Java.ST");
                              	    
                            }

                            }
                            break;
                        case 3 :
                            // InternalJava.g:2388:8: lv_testingSign_22_3= RULE_BE
                            {
                            lv_testingSign_22_3=(Token)match(input,RULE_BE,FOLLOW_35); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_testingSign_22_3, grammarAccess.getExpression_auxAccess().getTestingSignBETerminalRuleCall_7_0_0_2()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getExpression_auxRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"testingSign",
                                      		lv_testingSign_22_3, 
                                      		"org.xtext.java.Java.BE");
                              	    
                            }

                            }
                            break;
                        case 4 :
                            // InternalJava.g:2403:8: lv_testingSign_22_4= RULE_SE
                            {
                            lv_testingSign_22_4=(Token)match(input,RULE_SE,FOLLOW_35); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_testingSign_22_4, grammarAccess.getExpression_auxAccess().getTestingSignSETerminalRuleCall_7_0_0_3()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getExpression_auxRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"testingSign",
                                      		lv_testingSign_22_4, 
                                      		"org.xtext.java.Java.SE");
                              	    
                            }

                            }
                            break;
                        case 5 :
                            // InternalJava.g:2418:8: lv_testingSign_22_5= RULE_DOUBLE_EQUAL
                            {
                            lv_testingSign_22_5=(Token)match(input,RULE_DOUBLE_EQUAL,FOLLOW_35); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_testingSign_22_5, grammarAccess.getExpression_auxAccess().getTestingSignDOUBLE_EQUALTerminalRuleCall_7_0_0_4()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getExpression_auxRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"testingSign",
                                      		lv_testingSign_22_5, 
                                      		"org.xtext.java.Java.DOUBLE_EQUAL");
                              	    
                            }

                            }
                            break;
                        case 6 :
                            // InternalJava.g:2433:8: lv_testingSign_22_6= RULE_DIFFERENT
                            {
                            lv_testingSign_22_6=(Token)match(input,RULE_DIFFERENT,FOLLOW_35); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_testingSign_22_6, grammarAccess.getExpression_auxAccess().getTestingSignDIFFERENTTerminalRuleCall_7_0_0_5()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getExpression_auxRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"testingSign",
                                      		lv_testingSign_22_6, 
                                      		"org.xtext.java.Java.DIFFERENT");
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }

                    // InternalJava.g:2451:2: ( (lv_exp1_23_0= ruleExpression ) )
                    // InternalJava.g:2452:1: (lv_exp1_23_0= ruleExpression )
                    {
                    // InternalJava.g:2452:1: (lv_exp1_23_0= ruleExpression )
                    // InternalJava.g:2453:3: lv_exp1_23_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpression_auxAccess().getExp1ExpressionParserRuleCall_7_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_33);
                    lv_exp1_23_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpression_auxRule());
                      	        }
                             		set(
                             			current, 
                             			"exp1",
                              		lv_exp1_23_0, 
                              		"org.xtext.java.Java.Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalJava.g:2469:2: ( (lv_aux_24_0= ruleExpression_aux ) )
                    // InternalJava.g:2470:1: (lv_aux_24_0= ruleExpression_aux )
                    {
                    // InternalJava.g:2470:1: (lv_aux_24_0= ruleExpression_aux )
                    // InternalJava.g:2471:3: lv_aux_24_0= ruleExpression_aux
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpression_auxAccess().getAuxExpression_auxParserRuleCall_7_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_aux_24_0=ruleExpression_aux();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpression_auxRule());
                      	        }
                             		set(
                             			current, 
                             			"aux",
                              		lv_aux_24_0, 
                              		"org.xtext.java.Java.Expression_aux");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 9 :
                    // InternalJava.g:2488:6: ( ( ( ( (lv_logicalSign_25_1= RULE_OR | lv_logicalSign_25_2= RULE_OR_EQUAL | lv_logicalSign_25_3= RULE_EXP | lv_logicalSign_25_4= RULE_EXP_EQUAL | lv_logicalSign_25_5= RULE_DOUBLE_OR_EQUAL | lv_logicalSign_25_6= RULE_MODULE | lv_logicalSign_25_7= RULE_MODULE_EQUAL ) ) ) | ( (lv_ampersand_26_0= ruleAmpersand_Rule ) ) ) ( (lv_exp1_27_0= ruleExpression ) ) ( (lv_aux_28_0= ruleExpression_aux ) ) )
                    {
                    // InternalJava.g:2488:6: ( ( ( ( (lv_logicalSign_25_1= RULE_OR | lv_logicalSign_25_2= RULE_OR_EQUAL | lv_logicalSign_25_3= RULE_EXP | lv_logicalSign_25_4= RULE_EXP_EQUAL | lv_logicalSign_25_5= RULE_DOUBLE_OR_EQUAL | lv_logicalSign_25_6= RULE_MODULE | lv_logicalSign_25_7= RULE_MODULE_EQUAL ) ) ) | ( (lv_ampersand_26_0= ruleAmpersand_Rule ) ) ) ( (lv_exp1_27_0= ruleExpression ) ) ( (lv_aux_28_0= ruleExpression_aux ) ) )
                    // InternalJava.g:2488:7: ( ( ( (lv_logicalSign_25_1= RULE_OR | lv_logicalSign_25_2= RULE_OR_EQUAL | lv_logicalSign_25_3= RULE_EXP | lv_logicalSign_25_4= RULE_EXP_EQUAL | lv_logicalSign_25_5= RULE_DOUBLE_OR_EQUAL | lv_logicalSign_25_6= RULE_MODULE | lv_logicalSign_25_7= RULE_MODULE_EQUAL ) ) ) | ( (lv_ampersand_26_0= ruleAmpersand_Rule ) ) ) ( (lv_exp1_27_0= ruleExpression ) ) ( (lv_aux_28_0= ruleExpression_aux ) )
                    {
                    // InternalJava.g:2488:7: ( ( ( (lv_logicalSign_25_1= RULE_OR | lv_logicalSign_25_2= RULE_OR_EQUAL | lv_logicalSign_25_3= RULE_EXP | lv_logicalSign_25_4= RULE_EXP_EQUAL | lv_logicalSign_25_5= RULE_DOUBLE_OR_EQUAL | lv_logicalSign_25_6= RULE_MODULE | lv_logicalSign_25_7= RULE_MODULE_EQUAL ) ) ) | ( (lv_ampersand_26_0= ruleAmpersand_Rule ) ) )
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( ((LA43_0>=RULE_MODULE && LA43_0<=RULE_MODULE_EQUAL)||(LA43_0>=RULE_OR && LA43_0<=RULE_DOUBLE_OR_EQUAL)) ) {
                        alt43=1;
                    }
                    else if ( (LA43_0==RULE_AMPERSAND) ) {
                        alt43=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 43, 0, input);

                        throw nvae;
                    }
                    switch (alt43) {
                        case 1 :
                            // InternalJava.g:2488:8: ( ( (lv_logicalSign_25_1= RULE_OR | lv_logicalSign_25_2= RULE_OR_EQUAL | lv_logicalSign_25_3= RULE_EXP | lv_logicalSign_25_4= RULE_EXP_EQUAL | lv_logicalSign_25_5= RULE_DOUBLE_OR_EQUAL | lv_logicalSign_25_6= RULE_MODULE | lv_logicalSign_25_7= RULE_MODULE_EQUAL ) ) )
                            {
                            // InternalJava.g:2488:8: ( ( (lv_logicalSign_25_1= RULE_OR | lv_logicalSign_25_2= RULE_OR_EQUAL | lv_logicalSign_25_3= RULE_EXP | lv_logicalSign_25_4= RULE_EXP_EQUAL | lv_logicalSign_25_5= RULE_DOUBLE_OR_EQUAL | lv_logicalSign_25_6= RULE_MODULE | lv_logicalSign_25_7= RULE_MODULE_EQUAL ) ) )
                            // InternalJava.g:2489:1: ( (lv_logicalSign_25_1= RULE_OR | lv_logicalSign_25_2= RULE_OR_EQUAL | lv_logicalSign_25_3= RULE_EXP | lv_logicalSign_25_4= RULE_EXP_EQUAL | lv_logicalSign_25_5= RULE_DOUBLE_OR_EQUAL | lv_logicalSign_25_6= RULE_MODULE | lv_logicalSign_25_7= RULE_MODULE_EQUAL ) )
                            {
                            // InternalJava.g:2489:1: ( (lv_logicalSign_25_1= RULE_OR | lv_logicalSign_25_2= RULE_OR_EQUAL | lv_logicalSign_25_3= RULE_EXP | lv_logicalSign_25_4= RULE_EXP_EQUAL | lv_logicalSign_25_5= RULE_DOUBLE_OR_EQUAL | lv_logicalSign_25_6= RULE_MODULE | lv_logicalSign_25_7= RULE_MODULE_EQUAL ) )
                            // InternalJava.g:2490:1: (lv_logicalSign_25_1= RULE_OR | lv_logicalSign_25_2= RULE_OR_EQUAL | lv_logicalSign_25_3= RULE_EXP | lv_logicalSign_25_4= RULE_EXP_EQUAL | lv_logicalSign_25_5= RULE_DOUBLE_OR_EQUAL | lv_logicalSign_25_6= RULE_MODULE | lv_logicalSign_25_7= RULE_MODULE_EQUAL )
                            {
                            // InternalJava.g:2490:1: (lv_logicalSign_25_1= RULE_OR | lv_logicalSign_25_2= RULE_OR_EQUAL | lv_logicalSign_25_3= RULE_EXP | lv_logicalSign_25_4= RULE_EXP_EQUAL | lv_logicalSign_25_5= RULE_DOUBLE_OR_EQUAL | lv_logicalSign_25_6= RULE_MODULE | lv_logicalSign_25_7= RULE_MODULE_EQUAL )
                            int alt42=7;
                            switch ( input.LA(1) ) {
                            case RULE_OR:
                                {
                                alt42=1;
                                }
                                break;
                            case RULE_OR_EQUAL:
                                {
                                alt42=2;
                                }
                                break;
                            case RULE_EXP:
                                {
                                alt42=3;
                                }
                                break;
                            case RULE_EXP_EQUAL:
                                {
                                alt42=4;
                                }
                                break;
                            case RULE_DOUBLE_OR_EQUAL:
                                {
                                alt42=5;
                                }
                                break;
                            case RULE_MODULE:
                                {
                                alt42=6;
                                }
                                break;
                            case RULE_MODULE_EQUAL:
                                {
                                alt42=7;
                                }
                                break;
                            default:
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 42, 0, input);

                                throw nvae;
                            }

                            switch (alt42) {
                                case 1 :
                                    // InternalJava.g:2491:3: lv_logicalSign_25_1= RULE_OR
                                    {
                                    lv_logicalSign_25_1=(Token)match(input,RULE_OR,FOLLOW_35); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      			newLeafNode(lv_logicalSign_25_1, grammarAccess.getExpression_auxAccess().getLogicalSignORTerminalRuleCall_8_0_0_0_0()); 
                                      		
                                    }
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElement(grammarAccess.getExpression_auxRule());
                                      	        }
                                             		setWithLastConsumed(
                                             			current, 
                                             			"logicalSign",
                                              		lv_logicalSign_25_1, 
                                              		"org.xtext.java.Java.OR");
                                      	    
                                    }

                                    }
                                    break;
                                case 2 :
                                    // InternalJava.g:2506:8: lv_logicalSign_25_2= RULE_OR_EQUAL
                                    {
                                    lv_logicalSign_25_2=(Token)match(input,RULE_OR_EQUAL,FOLLOW_35); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      			newLeafNode(lv_logicalSign_25_2, grammarAccess.getExpression_auxAccess().getLogicalSignOR_EQUALTerminalRuleCall_8_0_0_0_1()); 
                                      		
                                    }
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElement(grammarAccess.getExpression_auxRule());
                                      	        }
                                             		setWithLastConsumed(
                                             			current, 
                                             			"logicalSign",
                                              		lv_logicalSign_25_2, 
                                              		"org.xtext.java.Java.OR_EQUAL");
                                      	    
                                    }

                                    }
                                    break;
                                case 3 :
                                    // InternalJava.g:2521:8: lv_logicalSign_25_3= RULE_EXP
                                    {
                                    lv_logicalSign_25_3=(Token)match(input,RULE_EXP,FOLLOW_35); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      			newLeafNode(lv_logicalSign_25_3, grammarAccess.getExpression_auxAccess().getLogicalSignEXPTerminalRuleCall_8_0_0_0_2()); 
                                      		
                                    }
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElement(grammarAccess.getExpression_auxRule());
                                      	        }
                                             		setWithLastConsumed(
                                             			current, 
                                             			"logicalSign",
                                              		lv_logicalSign_25_3, 
                                              		"org.xtext.java.Java.EXP");
                                      	    
                                    }

                                    }
                                    break;
                                case 4 :
                                    // InternalJava.g:2536:8: lv_logicalSign_25_4= RULE_EXP_EQUAL
                                    {
                                    lv_logicalSign_25_4=(Token)match(input,RULE_EXP_EQUAL,FOLLOW_35); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      			newLeafNode(lv_logicalSign_25_4, grammarAccess.getExpression_auxAccess().getLogicalSignEXP_EQUALTerminalRuleCall_8_0_0_0_3()); 
                                      		
                                    }
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElement(grammarAccess.getExpression_auxRule());
                                      	        }
                                             		setWithLastConsumed(
                                             			current, 
                                             			"logicalSign",
                                              		lv_logicalSign_25_4, 
                                              		"org.xtext.java.Java.EXP_EQUAL");
                                      	    
                                    }

                                    }
                                    break;
                                case 5 :
                                    // InternalJava.g:2551:8: lv_logicalSign_25_5= RULE_DOUBLE_OR_EQUAL
                                    {
                                    lv_logicalSign_25_5=(Token)match(input,RULE_DOUBLE_OR_EQUAL,FOLLOW_35); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      			newLeafNode(lv_logicalSign_25_5, grammarAccess.getExpression_auxAccess().getLogicalSignDOUBLE_OR_EQUALTerminalRuleCall_8_0_0_0_4()); 
                                      		
                                    }
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElement(grammarAccess.getExpression_auxRule());
                                      	        }
                                             		setWithLastConsumed(
                                             			current, 
                                             			"logicalSign",
                                              		lv_logicalSign_25_5, 
                                              		"org.xtext.java.Java.DOUBLE_OR_EQUAL");
                                      	    
                                    }

                                    }
                                    break;
                                case 6 :
                                    // InternalJava.g:2566:8: lv_logicalSign_25_6= RULE_MODULE
                                    {
                                    lv_logicalSign_25_6=(Token)match(input,RULE_MODULE,FOLLOW_35); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      			newLeafNode(lv_logicalSign_25_6, grammarAccess.getExpression_auxAccess().getLogicalSignMODULETerminalRuleCall_8_0_0_0_5()); 
                                      		
                                    }
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElement(grammarAccess.getExpression_auxRule());
                                      	        }
                                             		setWithLastConsumed(
                                             			current, 
                                             			"logicalSign",
                                              		lv_logicalSign_25_6, 
                                              		"org.xtext.java.Java.MODULE");
                                      	    
                                    }

                                    }
                                    break;
                                case 7 :
                                    // InternalJava.g:2581:8: lv_logicalSign_25_7= RULE_MODULE_EQUAL
                                    {
                                    lv_logicalSign_25_7=(Token)match(input,RULE_MODULE_EQUAL,FOLLOW_35); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      			newLeafNode(lv_logicalSign_25_7, grammarAccess.getExpression_auxAccess().getLogicalSignMODULE_EQUALTerminalRuleCall_8_0_0_0_6()); 
                                      		
                                    }
                                    if ( state.backtracking==0 ) {

                                      	        if (current==null) {
                                      	            current = createModelElement(grammarAccess.getExpression_auxRule());
                                      	        }
                                             		setWithLastConsumed(
                                             			current, 
                                             			"logicalSign",
                                              		lv_logicalSign_25_7, 
                                              		"org.xtext.java.Java.MODULE_EQUAL");
                                      	    
                                    }

                                    }
                                    break;

                            }


                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalJava.g:2600:6: ( (lv_ampersand_26_0= ruleAmpersand_Rule ) )
                            {
                            // InternalJava.g:2600:6: ( (lv_ampersand_26_0= ruleAmpersand_Rule ) )
                            // InternalJava.g:2601:1: (lv_ampersand_26_0= ruleAmpersand_Rule )
                            {
                            // InternalJava.g:2601:1: (lv_ampersand_26_0= ruleAmpersand_Rule )
                            // InternalJava.g:2602:3: lv_ampersand_26_0= ruleAmpersand_Rule
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getExpression_auxAccess().getAmpersandAmpersand_RuleParserRuleCall_8_0_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_35);
                            lv_ampersand_26_0=ruleAmpersand_Rule();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getExpression_auxRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"ampersand",
                                      		lv_ampersand_26_0, 
                                      		"org.xtext.java.Java.Ampersand_Rule");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }

                    // InternalJava.g:2618:3: ( (lv_exp1_27_0= ruleExpression ) )
                    // InternalJava.g:2619:1: (lv_exp1_27_0= ruleExpression )
                    {
                    // InternalJava.g:2619:1: (lv_exp1_27_0= ruleExpression )
                    // InternalJava.g:2620:3: lv_exp1_27_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpression_auxAccess().getExp1ExpressionParserRuleCall_8_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_33);
                    lv_exp1_27_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpression_auxRule());
                      	        }
                             		set(
                             			current, 
                             			"exp1",
                              		lv_exp1_27_0, 
                              		"org.xtext.java.Java.Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalJava.g:2636:2: ( (lv_aux_28_0= ruleExpression_aux ) )
                    // InternalJava.g:2637:1: (lv_aux_28_0= ruleExpression_aux )
                    {
                    // InternalJava.g:2637:1: (lv_aux_28_0= ruleExpression_aux )
                    // InternalJava.g:2638:3: lv_aux_28_0= ruleExpression_aux
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpression_auxAccess().getAuxExpression_auxParserRuleCall_8_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_aux_28_0=ruleExpression_aux();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpression_auxRule());
                      	        }
                             		set(
                             			current, 
                             			"aux",
                              		lv_aux_28_0, 
                              		"org.xtext.java.Java.Expression_aux");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 10 :
                    // InternalJava.g:2655:6: (this_WAT_29= RULE_WAT ( (lv_exp1_30_0= ruleExpression ) ) this_COLON_31= RULE_COLON ( (lv_exp2_32_0= ruleExpression ) ) ( (lv_aux_33_0= ruleExpression_aux ) ) )
                    {
                    // InternalJava.g:2655:6: (this_WAT_29= RULE_WAT ( (lv_exp1_30_0= ruleExpression ) ) this_COLON_31= RULE_COLON ( (lv_exp2_32_0= ruleExpression ) ) ( (lv_aux_33_0= ruleExpression_aux ) ) )
                    // InternalJava.g:2655:7: this_WAT_29= RULE_WAT ( (lv_exp1_30_0= ruleExpression ) ) this_COLON_31= RULE_COLON ( (lv_exp2_32_0= ruleExpression ) ) ( (lv_aux_33_0= ruleExpression_aux ) )
                    {
                    this_WAT_29=(Token)match(input,RULE_WAT,FOLLOW_35); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_WAT_29, grammarAccess.getExpression_auxAccess().getWATTerminalRuleCall_9_0()); 
                          
                    }
                    // InternalJava.g:2659:1: ( (lv_exp1_30_0= ruleExpression ) )
                    // InternalJava.g:2660:1: (lv_exp1_30_0= ruleExpression )
                    {
                    // InternalJava.g:2660:1: (lv_exp1_30_0= ruleExpression )
                    // InternalJava.g:2661:3: lv_exp1_30_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpression_auxAccess().getExp1ExpressionParserRuleCall_9_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_36);
                    lv_exp1_30_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpression_auxRule());
                      	        }
                             		set(
                             			current, 
                             			"exp1",
                              		lv_exp1_30_0, 
                              		"org.xtext.java.Java.Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    this_COLON_31=(Token)match(input,RULE_COLON,FOLLOW_35); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_COLON_31, grammarAccess.getExpression_auxAccess().getCOLONTerminalRuleCall_9_2()); 
                          
                    }
                    // InternalJava.g:2681:1: ( (lv_exp2_32_0= ruleExpression ) )
                    // InternalJava.g:2682:1: (lv_exp2_32_0= ruleExpression )
                    {
                    // InternalJava.g:2682:1: (lv_exp2_32_0= ruleExpression )
                    // InternalJava.g:2683:3: lv_exp2_32_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpression_auxAccess().getExp2ExpressionParserRuleCall_9_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_33);
                    lv_exp2_32_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpression_auxRule());
                      	        }
                             		set(
                             			current, 
                             			"exp2",
                              		lv_exp2_32_0, 
                              		"org.xtext.java.Java.Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalJava.g:2699:2: ( (lv_aux_33_0= ruleExpression_aux ) )
                    // InternalJava.g:2700:1: (lv_aux_33_0= ruleExpression_aux )
                    {
                    // InternalJava.g:2700:1: (lv_aux_33_0= ruleExpression_aux )
                    // InternalJava.g:2701:3: lv_aux_33_0= ruleExpression_aux
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpression_auxAccess().getAuxExpression_auxParserRuleCall_9_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_aux_33_0=ruleExpression_aux();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpression_auxRule());
                      	        }
                             		set(
                             			current, 
                             			"aux",
                              		lv_aux_33_0, 
                              		"org.xtext.java.Java.Expression_aux");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 11 :
                    // InternalJava.g:2718:6: ( ( ( (lv_stringSign_34_1= RULE_PLUS | lv_stringSign_34_2= RULE_PLUS_EQUAL ) ) ) ( (lv_exp1_35_0= ruleExpression ) ) ( (lv_aux_36_0= ruleExpression_aux ) ) )
                    {
                    // InternalJava.g:2718:6: ( ( ( (lv_stringSign_34_1= RULE_PLUS | lv_stringSign_34_2= RULE_PLUS_EQUAL ) ) ) ( (lv_exp1_35_0= ruleExpression ) ) ( (lv_aux_36_0= ruleExpression_aux ) ) )
                    // InternalJava.g:2718:7: ( ( (lv_stringSign_34_1= RULE_PLUS | lv_stringSign_34_2= RULE_PLUS_EQUAL ) ) ) ( (lv_exp1_35_0= ruleExpression ) ) ( (lv_aux_36_0= ruleExpression_aux ) )
                    {
                    // InternalJava.g:2718:7: ( ( (lv_stringSign_34_1= RULE_PLUS | lv_stringSign_34_2= RULE_PLUS_EQUAL ) ) )
                    // InternalJava.g:2719:1: ( (lv_stringSign_34_1= RULE_PLUS | lv_stringSign_34_2= RULE_PLUS_EQUAL ) )
                    {
                    // InternalJava.g:2719:1: ( (lv_stringSign_34_1= RULE_PLUS | lv_stringSign_34_2= RULE_PLUS_EQUAL ) )
                    // InternalJava.g:2720:1: (lv_stringSign_34_1= RULE_PLUS | lv_stringSign_34_2= RULE_PLUS_EQUAL )
                    {
                    // InternalJava.g:2720:1: (lv_stringSign_34_1= RULE_PLUS | lv_stringSign_34_2= RULE_PLUS_EQUAL )
                    int alt44=2;
                    int LA44_0 = input.LA(1);

                    if ( (LA44_0==RULE_PLUS) ) {
                        alt44=1;
                    }
                    else if ( (LA44_0==RULE_PLUS_EQUAL) ) {
                        alt44=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 44, 0, input);

                        throw nvae;
                    }
                    switch (alt44) {
                        case 1 :
                            // InternalJava.g:2721:3: lv_stringSign_34_1= RULE_PLUS
                            {
                            lv_stringSign_34_1=(Token)match(input,RULE_PLUS,FOLLOW_35); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_stringSign_34_1, grammarAccess.getExpression_auxAccess().getStringSignPLUSTerminalRuleCall_10_0_0_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getExpression_auxRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"stringSign",
                                      		lv_stringSign_34_1, 
                                      		"org.xtext.java.Java.PLUS");
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // InternalJava.g:2736:8: lv_stringSign_34_2= RULE_PLUS_EQUAL
                            {
                            lv_stringSign_34_2=(Token)match(input,RULE_PLUS_EQUAL,FOLLOW_35); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_stringSign_34_2, grammarAccess.getExpression_auxAccess().getStringSignPLUS_EQUALTerminalRuleCall_10_0_0_1()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getExpression_auxRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"stringSign",
                                      		lv_stringSign_34_2, 
                                      		"org.xtext.java.Java.PLUS_EQUAL");
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }

                    // InternalJava.g:2754:2: ( (lv_exp1_35_0= ruleExpression ) )
                    // InternalJava.g:2755:1: (lv_exp1_35_0= ruleExpression )
                    {
                    // InternalJava.g:2755:1: (lv_exp1_35_0= ruleExpression )
                    // InternalJava.g:2756:3: lv_exp1_35_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpression_auxAccess().getExp1ExpressionParserRuleCall_10_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_33);
                    lv_exp1_35_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpression_auxRule());
                      	        }
                             		set(
                             			current, 
                             			"exp1",
                              		lv_exp1_35_0, 
                              		"org.xtext.java.Java.Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalJava.g:2772:2: ( (lv_aux_36_0= ruleExpression_aux ) )
                    // InternalJava.g:2773:1: (lv_aux_36_0= ruleExpression_aux )
                    {
                    // InternalJava.g:2773:1: (lv_aux_36_0= ruleExpression_aux )
                    // InternalJava.g:2774:3: lv_aux_36_0= ruleExpression_aux
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpression_auxAccess().getAuxExpression_auxParserRuleCall_10_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_aux_36_0=ruleExpression_aux();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpression_auxRule());
                      	        }
                             		set(
                             			current, 
                             			"aux",
                              		lv_aux_36_0, 
                              		"org.xtext.java.Java.Expression_aux");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 12 :
                    // InternalJava.g:2791:6: ( ( ( (lv_bitSign_37_1= RULE_R_SHIFT_EQUAL | lv_bitSign_37_2= RULE_L_SHIFT | lv_bitSign_37_3= RULE_R_SHIFT | lv_bitSign_37_4= RULE_SUPER_SHIFT ) ) ) ( (lv_expressionBit_38_0= ruleExpression ) ) ( (lv_aux_39_0= ruleExpression_aux ) ) )
                    {
                    // InternalJava.g:2791:6: ( ( ( (lv_bitSign_37_1= RULE_R_SHIFT_EQUAL | lv_bitSign_37_2= RULE_L_SHIFT | lv_bitSign_37_3= RULE_R_SHIFT | lv_bitSign_37_4= RULE_SUPER_SHIFT ) ) ) ( (lv_expressionBit_38_0= ruleExpression ) ) ( (lv_aux_39_0= ruleExpression_aux ) ) )
                    // InternalJava.g:2791:7: ( ( (lv_bitSign_37_1= RULE_R_SHIFT_EQUAL | lv_bitSign_37_2= RULE_L_SHIFT | lv_bitSign_37_3= RULE_R_SHIFT | lv_bitSign_37_4= RULE_SUPER_SHIFT ) ) ) ( (lv_expressionBit_38_0= ruleExpression ) ) ( (lv_aux_39_0= ruleExpression_aux ) )
                    {
                    // InternalJava.g:2791:7: ( ( (lv_bitSign_37_1= RULE_R_SHIFT_EQUAL | lv_bitSign_37_2= RULE_L_SHIFT | lv_bitSign_37_3= RULE_R_SHIFT | lv_bitSign_37_4= RULE_SUPER_SHIFT ) ) )
                    // InternalJava.g:2792:1: ( (lv_bitSign_37_1= RULE_R_SHIFT_EQUAL | lv_bitSign_37_2= RULE_L_SHIFT | lv_bitSign_37_3= RULE_R_SHIFT | lv_bitSign_37_4= RULE_SUPER_SHIFT ) )
                    {
                    // InternalJava.g:2792:1: ( (lv_bitSign_37_1= RULE_R_SHIFT_EQUAL | lv_bitSign_37_2= RULE_L_SHIFT | lv_bitSign_37_3= RULE_R_SHIFT | lv_bitSign_37_4= RULE_SUPER_SHIFT ) )
                    // InternalJava.g:2793:1: (lv_bitSign_37_1= RULE_R_SHIFT_EQUAL | lv_bitSign_37_2= RULE_L_SHIFT | lv_bitSign_37_3= RULE_R_SHIFT | lv_bitSign_37_4= RULE_SUPER_SHIFT )
                    {
                    // InternalJava.g:2793:1: (lv_bitSign_37_1= RULE_R_SHIFT_EQUAL | lv_bitSign_37_2= RULE_L_SHIFT | lv_bitSign_37_3= RULE_R_SHIFT | lv_bitSign_37_4= RULE_SUPER_SHIFT )
                    int alt45=4;
                    switch ( input.LA(1) ) {
                    case RULE_R_SHIFT_EQUAL:
                        {
                        alt45=1;
                        }
                        break;
                    case RULE_L_SHIFT:
                        {
                        alt45=2;
                        }
                        break;
                    case RULE_R_SHIFT:
                        {
                        alt45=3;
                        }
                        break;
                    case RULE_SUPER_SHIFT:
                        {
                        alt45=4;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 45, 0, input);

                        throw nvae;
                    }

                    switch (alt45) {
                        case 1 :
                            // InternalJava.g:2794:3: lv_bitSign_37_1= RULE_R_SHIFT_EQUAL
                            {
                            lv_bitSign_37_1=(Token)match(input,RULE_R_SHIFT_EQUAL,FOLLOW_35); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_bitSign_37_1, grammarAccess.getExpression_auxAccess().getBitSignR_SHIFT_EQUALTerminalRuleCall_11_0_0_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getExpression_auxRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"bitSign",
                                      		lv_bitSign_37_1, 
                                      		"org.xtext.java.Java.R_SHIFT_EQUAL");
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // InternalJava.g:2809:8: lv_bitSign_37_2= RULE_L_SHIFT
                            {
                            lv_bitSign_37_2=(Token)match(input,RULE_L_SHIFT,FOLLOW_35); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_bitSign_37_2, grammarAccess.getExpression_auxAccess().getBitSignL_SHIFTTerminalRuleCall_11_0_0_1()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getExpression_auxRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"bitSign",
                                      		lv_bitSign_37_2, 
                                      		"org.xtext.java.Java.L_SHIFT");
                              	    
                            }

                            }
                            break;
                        case 3 :
                            // InternalJava.g:2824:8: lv_bitSign_37_3= RULE_R_SHIFT
                            {
                            lv_bitSign_37_3=(Token)match(input,RULE_R_SHIFT,FOLLOW_35); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_bitSign_37_3, grammarAccess.getExpression_auxAccess().getBitSignR_SHIFTTerminalRuleCall_11_0_0_2()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getExpression_auxRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"bitSign",
                                      		lv_bitSign_37_3, 
                                      		"org.xtext.java.Java.R_SHIFT");
                              	    
                            }

                            }
                            break;
                        case 4 :
                            // InternalJava.g:2839:8: lv_bitSign_37_4= RULE_SUPER_SHIFT
                            {
                            lv_bitSign_37_4=(Token)match(input,RULE_SUPER_SHIFT,FOLLOW_35); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_bitSign_37_4, grammarAccess.getExpression_auxAccess().getBitSignSUPER_SHIFTTerminalRuleCall_11_0_0_3()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getExpression_auxRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"bitSign",
                                      		lv_bitSign_37_4, 
                                      		"org.xtext.java.Java.SUPER_SHIFT");
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }

                    // InternalJava.g:2857:2: ( (lv_expressionBit_38_0= ruleExpression ) )
                    // InternalJava.g:2858:1: (lv_expressionBit_38_0= ruleExpression )
                    {
                    // InternalJava.g:2858:1: (lv_expressionBit_38_0= ruleExpression )
                    // InternalJava.g:2859:3: lv_expressionBit_38_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpression_auxAccess().getExpressionBitExpressionParserRuleCall_11_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_33);
                    lv_expressionBit_38_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpression_auxRule());
                      	        }
                             		set(
                             			current, 
                             			"expressionBit",
                              		lv_expressionBit_38_0, 
                              		"org.xtext.java.Java.Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalJava.g:2875:2: ( (lv_aux_39_0= ruleExpression_aux ) )
                    // InternalJava.g:2876:1: (lv_aux_39_0= ruleExpression_aux )
                    {
                    // InternalJava.g:2876:1: (lv_aux_39_0= ruleExpression_aux )
                    // InternalJava.g:2877:3: lv_aux_39_0= ruleExpression_aux
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getExpression_auxAccess().getAuxExpression_auxParserRuleCall_11_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_aux_39_0=ruleExpression_aux();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getExpression_auxRule());
                      	        }
                             		set(
                             			current, 
                             			"aux",
                              		lv_aux_39_0, 
                              		"org.xtext.java.Java.Expression_aux");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 13 :
                    // InternalJava.g:2894:6: ()
                    {
                    // InternalJava.g:2894:6: ()
                    // InternalJava.g:2895:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getExpression_auxAccess().getExpression_auxAction_12(),
                                  current);
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpression_aux"


    // $ANTLR start "entryRuleAmpersand_Rule"
    // InternalJava.g:2911:1: entryRuleAmpersand_Rule returns [EObject current=null] : iv_ruleAmpersand_Rule= ruleAmpersand_Rule EOF ;
    public final EObject entryRuleAmpersand_Rule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAmpersand_Rule = null;


        try {
            // InternalJava.g:2912:2: (iv_ruleAmpersand_Rule= ruleAmpersand_Rule EOF )
            // InternalJava.g:2913:2: iv_ruleAmpersand_Rule= ruleAmpersand_Rule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAmpersand_RuleRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAmpersand_Rule=ruleAmpersand_Rule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAmpersand_Rule; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAmpersand_Rule"


    // $ANTLR start "ruleAmpersand_Rule"
    // InternalJava.g:2920:1: ruleAmpersand_Rule returns [EObject current=null] : ( ( (lv_a1_0_0= RULE_AMPERSAND ) ) ( ( (lv_a2_1_0= RULE_AMPERSAND ) ) | this_EQUAL_2= RULE_EQUAL )? ) ;
    public final EObject ruleAmpersand_Rule() throws RecognitionException {
        EObject current = null;

        Token lv_a1_0_0=null;
        Token lv_a2_1_0=null;
        Token this_EQUAL_2=null;

         enterRule(); 
            
        try {
            // InternalJava.g:2923:28: ( ( ( (lv_a1_0_0= RULE_AMPERSAND ) ) ( ( (lv_a2_1_0= RULE_AMPERSAND ) ) | this_EQUAL_2= RULE_EQUAL )? ) )
            // InternalJava.g:2924:1: ( ( (lv_a1_0_0= RULE_AMPERSAND ) ) ( ( (lv_a2_1_0= RULE_AMPERSAND ) ) | this_EQUAL_2= RULE_EQUAL )? )
            {
            // InternalJava.g:2924:1: ( ( (lv_a1_0_0= RULE_AMPERSAND ) ) ( ( (lv_a2_1_0= RULE_AMPERSAND ) ) | this_EQUAL_2= RULE_EQUAL )? )
            // InternalJava.g:2924:2: ( (lv_a1_0_0= RULE_AMPERSAND ) ) ( ( (lv_a2_1_0= RULE_AMPERSAND ) ) | this_EQUAL_2= RULE_EQUAL )?
            {
            // InternalJava.g:2924:2: ( (lv_a1_0_0= RULE_AMPERSAND ) )
            // InternalJava.g:2925:1: (lv_a1_0_0= RULE_AMPERSAND )
            {
            // InternalJava.g:2925:1: (lv_a1_0_0= RULE_AMPERSAND )
            // InternalJava.g:2926:3: lv_a1_0_0= RULE_AMPERSAND
            {
            lv_a1_0_0=(Token)match(input,RULE_AMPERSAND,FOLLOW_37); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_a1_0_0, grammarAccess.getAmpersand_RuleAccess().getA1AMPERSANDTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getAmpersand_RuleRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"a1",
                      		lv_a1_0_0, 
                      		"org.xtext.java.Java.AMPERSAND");
              	    
            }

            }


            }

            // InternalJava.g:2942:2: ( ( (lv_a2_1_0= RULE_AMPERSAND ) ) | this_EQUAL_2= RULE_EQUAL )?
            int alt47=3;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==RULE_AMPERSAND) ) {
                alt47=1;
            }
            else if ( (LA47_0==RULE_EQUAL) ) {
                alt47=2;
            }
            switch (alt47) {
                case 1 :
                    // InternalJava.g:2942:3: ( (lv_a2_1_0= RULE_AMPERSAND ) )
                    {
                    // InternalJava.g:2942:3: ( (lv_a2_1_0= RULE_AMPERSAND ) )
                    // InternalJava.g:2943:1: (lv_a2_1_0= RULE_AMPERSAND )
                    {
                    // InternalJava.g:2943:1: (lv_a2_1_0= RULE_AMPERSAND )
                    // InternalJava.g:2944:3: lv_a2_1_0= RULE_AMPERSAND
                    {
                    lv_a2_1_0=(Token)match(input,RULE_AMPERSAND,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_a2_1_0, grammarAccess.getAmpersand_RuleAccess().getA2AMPERSANDTerminalRuleCall_1_0_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getAmpersand_RuleRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"a2",
                              		lv_a2_1_0, 
                              		"org.xtext.java.Java.AMPERSAND");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalJava.g:2961:6: this_EQUAL_2= RULE_EQUAL
                    {
                    this_EQUAL_2=(Token)match(input,RULE_EQUAL,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_EQUAL_2, grammarAccess.getAmpersand_RuleAccess().getEQUALTerminalRuleCall_1_1()); 
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAmpersand_Rule"


    // $ANTLR start "entryRuleFloat_Literal"
    // InternalJava.g:2973:1: entryRuleFloat_Literal returns [EObject current=null] : iv_ruleFloat_Literal= ruleFloat_Literal EOF ;
    public final EObject entryRuleFloat_Literal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFloat_Literal = null;


        try {
            // InternalJava.g:2974:2: (iv_ruleFloat_Literal= ruleFloat_Literal EOF )
            // InternalJava.g:2975:2: iv_ruleFloat_Literal= ruleFloat_Literal EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFloat_LiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFloat_Literal=ruleFloat_Literal();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFloat_Literal; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFloat_Literal"


    // $ANTLR start "ruleFloat_Literal"
    // InternalJava.g:2982:1: ruleFloat_Literal returns [EObject current=null] : ( ( (lv_decimalDigits1_0_0= RULE_DECIMAL_DIGITS ) ) otherlv_1= '.' ( (lv_decimalDigits2_2_0= RULE_DECIMAL_DIGITS ) )? ( (lv_exp_3_0= ruleEXPOENT_PART ) )? ) ;
    public final EObject ruleFloat_Literal() throws RecognitionException {
        EObject current = null;

        Token lv_decimalDigits1_0_0=null;
        Token otherlv_1=null;
        Token lv_decimalDigits2_2_0=null;
        AntlrDatatypeRuleToken lv_exp_3_0 = null;


         enterRule(); 
            
        try {
            // InternalJava.g:2985:28: ( ( ( (lv_decimalDigits1_0_0= RULE_DECIMAL_DIGITS ) ) otherlv_1= '.' ( (lv_decimalDigits2_2_0= RULE_DECIMAL_DIGITS ) )? ( (lv_exp_3_0= ruleEXPOENT_PART ) )? ) )
            // InternalJava.g:2986:1: ( ( (lv_decimalDigits1_0_0= RULE_DECIMAL_DIGITS ) ) otherlv_1= '.' ( (lv_decimalDigits2_2_0= RULE_DECIMAL_DIGITS ) )? ( (lv_exp_3_0= ruleEXPOENT_PART ) )? )
            {
            // InternalJava.g:2986:1: ( ( (lv_decimalDigits1_0_0= RULE_DECIMAL_DIGITS ) ) otherlv_1= '.' ( (lv_decimalDigits2_2_0= RULE_DECIMAL_DIGITS ) )? ( (lv_exp_3_0= ruleEXPOENT_PART ) )? )
            // InternalJava.g:2986:2: ( (lv_decimalDigits1_0_0= RULE_DECIMAL_DIGITS ) ) otherlv_1= '.' ( (lv_decimalDigits2_2_0= RULE_DECIMAL_DIGITS ) )? ( (lv_exp_3_0= ruleEXPOENT_PART ) )?
            {
            // InternalJava.g:2986:2: ( (lv_decimalDigits1_0_0= RULE_DECIMAL_DIGITS ) )
            // InternalJava.g:2987:1: (lv_decimalDigits1_0_0= RULE_DECIMAL_DIGITS )
            {
            // InternalJava.g:2987:1: (lv_decimalDigits1_0_0= RULE_DECIMAL_DIGITS )
            // InternalJava.g:2988:3: lv_decimalDigits1_0_0= RULE_DECIMAL_DIGITS
            {
            lv_decimalDigits1_0_0=(Token)match(input,RULE_DECIMAL_DIGITS,FOLLOW_38); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_decimalDigits1_0_0, grammarAccess.getFloat_LiteralAccess().getDecimalDigits1DECIMAL_DIGITSTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getFloat_LiteralRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"decimalDigits1",
                      		lv_decimalDigits1_0_0, 
                      		"org.xtext.java.Java.DECIMAL_DIGITS");
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,83,FOLLOW_39); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFloat_LiteralAccess().getFullStopKeyword_1());
                  
            }
            // InternalJava.g:3008:1: ( (lv_decimalDigits2_2_0= RULE_DECIMAL_DIGITS ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==RULE_DECIMAL_DIGITS) ) {
                int LA48_1 = input.LA(2);

                if ( (synpred96_InternalJava()) ) {
                    alt48=1;
                }
            }
            switch (alt48) {
                case 1 :
                    // InternalJava.g:3009:1: (lv_decimalDigits2_2_0= RULE_DECIMAL_DIGITS )
                    {
                    // InternalJava.g:3009:1: (lv_decimalDigits2_2_0= RULE_DECIMAL_DIGITS )
                    // InternalJava.g:3010:3: lv_decimalDigits2_2_0= RULE_DECIMAL_DIGITS
                    {
                    lv_decimalDigits2_2_0=(Token)match(input,RULE_DECIMAL_DIGITS,FOLLOW_39); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_decimalDigits2_2_0, grammarAccess.getFloat_LiteralAccess().getDecimalDigits2DECIMAL_DIGITSTerminalRuleCall_2_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getFloat_LiteralRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"decimalDigits2",
                              		lv_decimalDigits2_2_0, 
                              		"org.xtext.java.Java.DECIMAL_DIGITS");
                      	    
                    }

                    }


                    }
                    break;

            }

            // InternalJava.g:3026:3: ( (lv_exp_3_0= ruleEXPOENT_PART ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==RULE_DECIMAL_DIGITS) ) {
                int LA49_1 = input.LA(2);

                if ( (synpred97_InternalJava()) ) {
                    alt49=1;
                }
            }
            switch (alt49) {
                case 1 :
                    // InternalJava.g:3027:1: (lv_exp_3_0= ruleEXPOENT_PART )
                    {
                    // InternalJava.g:3027:1: (lv_exp_3_0= ruleEXPOENT_PART )
                    // InternalJava.g:3028:3: lv_exp_3_0= ruleEXPOENT_PART
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFloat_LiteralAccess().getExpEXPOENT_PARTParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_exp_3_0=ruleEXPOENT_PART();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getFloat_LiteralRule());
                      	        }
                             		set(
                             			current, 
                             			"exp",
                              		lv_exp_3_0, 
                              		"org.xtext.java.Java.EXPOENT_PART");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFloat_Literal"


    // $ANTLR start "entryRuleLiteral_Expression"
    // InternalJava.g:3052:1: entryRuleLiteral_Expression returns [EObject current=null] : iv_ruleLiteral_Expression= ruleLiteral_Expression EOF ;
    public final EObject entryRuleLiteral_Expression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral_Expression = null;


        try {
            // InternalJava.g:3053:2: (iv_ruleLiteral_Expression= ruleLiteral_Expression EOF )
            // InternalJava.g:3054:2: iv_ruleLiteral_Expression= ruleLiteral_Expression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteral_ExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLiteral_Expression=ruleLiteral_Expression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteral_Expression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLiteral_Expression"


    // $ANTLR start "ruleLiteral_Expression"
    // InternalJava.g:3061:1: ruleLiteral_Expression returns [EObject current=null] : ( ( ( (lv_exp_0_0= RULE_HEXA ) ) | ( (lv_exp1_1_0= RULE_DECIMAL_DIGITS ) ) ) | ( (lv_exp2_2_0= ruleFloat_Literal ) ) | ( (lv_string_3_0= RULE_STRING ) ) | ( (lv_char_4_0= RULE_CHAR ) ) ) ;
    public final EObject ruleLiteral_Expression() throws RecognitionException {
        EObject current = null;

        Token lv_exp_0_0=null;
        Token lv_exp1_1_0=null;
        Token lv_string_3_0=null;
        Token lv_char_4_0=null;
        EObject lv_exp2_2_0 = null;


         enterRule(); 
            
        try {
            // InternalJava.g:3064:28: ( ( ( ( (lv_exp_0_0= RULE_HEXA ) ) | ( (lv_exp1_1_0= RULE_DECIMAL_DIGITS ) ) ) | ( (lv_exp2_2_0= ruleFloat_Literal ) ) | ( (lv_string_3_0= RULE_STRING ) ) | ( (lv_char_4_0= RULE_CHAR ) ) ) )
            // InternalJava.g:3065:1: ( ( ( (lv_exp_0_0= RULE_HEXA ) ) | ( (lv_exp1_1_0= RULE_DECIMAL_DIGITS ) ) ) | ( (lv_exp2_2_0= ruleFloat_Literal ) ) | ( (lv_string_3_0= RULE_STRING ) ) | ( (lv_char_4_0= RULE_CHAR ) ) )
            {
            // InternalJava.g:3065:1: ( ( ( (lv_exp_0_0= RULE_HEXA ) ) | ( (lv_exp1_1_0= RULE_DECIMAL_DIGITS ) ) ) | ( (lv_exp2_2_0= ruleFloat_Literal ) ) | ( (lv_string_3_0= RULE_STRING ) ) | ( (lv_char_4_0= RULE_CHAR ) ) )
            int alt51=4;
            switch ( input.LA(1) ) {
            case RULE_HEXA:
                {
                alt51=1;
                }
                break;
            case RULE_DECIMAL_DIGITS:
                {
                int LA51_2 = input.LA(2);

                if ( (synpred99_InternalJava()) ) {
                    alt51=1;
                }
                else if ( (synpred100_InternalJava()) ) {
                    alt51=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 51, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_STRING:
                {
                alt51=3;
                }
                break;
            case RULE_CHAR:
                {
                alt51=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }

            switch (alt51) {
                case 1 :
                    // InternalJava.g:3065:2: ( ( (lv_exp_0_0= RULE_HEXA ) ) | ( (lv_exp1_1_0= RULE_DECIMAL_DIGITS ) ) )
                    {
                    // InternalJava.g:3065:2: ( ( (lv_exp_0_0= RULE_HEXA ) ) | ( (lv_exp1_1_0= RULE_DECIMAL_DIGITS ) ) )
                    int alt50=2;
                    int LA50_0 = input.LA(1);

                    if ( (LA50_0==RULE_HEXA) ) {
                        alt50=1;
                    }
                    else if ( (LA50_0==RULE_DECIMAL_DIGITS) ) {
                        alt50=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 50, 0, input);

                        throw nvae;
                    }
                    switch (alt50) {
                        case 1 :
                            // InternalJava.g:3065:3: ( (lv_exp_0_0= RULE_HEXA ) )
                            {
                            // InternalJava.g:3065:3: ( (lv_exp_0_0= RULE_HEXA ) )
                            // InternalJava.g:3066:1: (lv_exp_0_0= RULE_HEXA )
                            {
                            // InternalJava.g:3066:1: (lv_exp_0_0= RULE_HEXA )
                            // InternalJava.g:3067:3: lv_exp_0_0= RULE_HEXA
                            {
                            lv_exp_0_0=(Token)match(input,RULE_HEXA,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_exp_0_0, grammarAccess.getLiteral_ExpressionAccess().getExpHEXATerminalRuleCall_0_0_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getLiteral_ExpressionRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"exp",
                                      		lv_exp_0_0, 
                                      		"org.xtext.java.Java.HEXA");
                              	    
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalJava.g:3084:6: ( (lv_exp1_1_0= RULE_DECIMAL_DIGITS ) )
                            {
                            // InternalJava.g:3084:6: ( (lv_exp1_1_0= RULE_DECIMAL_DIGITS ) )
                            // InternalJava.g:3085:1: (lv_exp1_1_0= RULE_DECIMAL_DIGITS )
                            {
                            // InternalJava.g:3085:1: (lv_exp1_1_0= RULE_DECIMAL_DIGITS )
                            // InternalJava.g:3086:3: lv_exp1_1_0= RULE_DECIMAL_DIGITS
                            {
                            lv_exp1_1_0=(Token)match(input,RULE_DECIMAL_DIGITS,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_exp1_1_0, grammarAccess.getLiteral_ExpressionAccess().getExp1DECIMAL_DIGITSTerminalRuleCall_0_1_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getLiteral_ExpressionRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"exp1",
                                      		lv_exp1_1_0, 
                                      		"org.xtext.java.Java.DECIMAL_DIGITS");
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // InternalJava.g:3103:6: ( (lv_exp2_2_0= ruleFloat_Literal ) )
                    {
                    // InternalJava.g:3103:6: ( (lv_exp2_2_0= ruleFloat_Literal ) )
                    // InternalJava.g:3104:1: (lv_exp2_2_0= ruleFloat_Literal )
                    {
                    // InternalJava.g:3104:1: (lv_exp2_2_0= ruleFloat_Literal )
                    // InternalJava.g:3105:3: lv_exp2_2_0= ruleFloat_Literal
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLiteral_ExpressionAccess().getExp2Float_LiteralParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_exp2_2_0=ruleFloat_Literal();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLiteral_ExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"exp2",
                              		lv_exp2_2_0, 
                              		"org.xtext.java.Java.Float_Literal");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalJava.g:3122:6: ( (lv_string_3_0= RULE_STRING ) )
                    {
                    // InternalJava.g:3122:6: ( (lv_string_3_0= RULE_STRING ) )
                    // InternalJava.g:3123:1: (lv_string_3_0= RULE_STRING )
                    {
                    // InternalJava.g:3123:1: (lv_string_3_0= RULE_STRING )
                    // InternalJava.g:3124:3: lv_string_3_0= RULE_STRING
                    {
                    lv_string_3_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_string_3_0, grammarAccess.getLiteral_ExpressionAccess().getStringSTRINGTerminalRuleCall_2_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getLiteral_ExpressionRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"string",
                              		lv_string_3_0, 
                              		"org.xtext.java.Java.STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalJava.g:3141:6: ( (lv_char_4_0= RULE_CHAR ) )
                    {
                    // InternalJava.g:3141:6: ( (lv_char_4_0= RULE_CHAR ) )
                    // InternalJava.g:3142:1: (lv_char_4_0= RULE_CHAR )
                    {
                    // InternalJava.g:3142:1: (lv_char_4_0= RULE_CHAR )
                    // InternalJava.g:3143:3: lv_char_4_0= RULE_CHAR
                    {
                    lv_char_4_0=(Token)match(input,RULE_CHAR,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_char_4_0, grammarAccess.getLiteral_ExpressionAccess().getCharCHARTerminalRuleCall_3_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getLiteral_ExpressionRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"char",
                              		lv_char_4_0, 
                              		"org.xtext.java.Java.CHAR");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLiteral_Expression"


    // $ANTLR start "entryRuleCreating_Expression"
    // InternalJava.g:3167:1: entryRuleCreating_Expression returns [EObject current=null] : iv_ruleCreating_Expression= ruleCreating_Expression EOF ;
    public final EObject entryRuleCreating_Expression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCreating_Expression = null;


        try {
            // InternalJava.g:3168:2: (iv_ruleCreating_Expression= ruleCreating_Expression EOF )
            // InternalJava.g:3169:2: iv_ruleCreating_Expression= ruleCreating_Expression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCreating_ExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCreating_Expression=ruleCreating_Expression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCreating_Expression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCreating_Expression"


    // $ANTLR start "ruleCreating_Expression"
    // InternalJava.g:3176:1: ruleCreating_Expression returns [EObject current=null] : (this_NEW_0= RULE_NEW ( ( ( (lv_className_1_0= ruleClass_name ) ) otherlv_2= '(' ( (lv_argList_3_0= ruleArg_List ) ) otherlv_4= ')' ) | ( ( (lv_typeSpecifier_5_0= ruleType_specifier ) ) (otherlv_6= '[' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= ']' )? ( (otherlv_9= '[' otherlv_10= ']' ) | otherlv_11= '[]' )* ) | (otherlv_12= '(' ( (lv_expression_13_0= ruleExpression ) ) otherlv_14= ')' ) ) ) ;
    public final EObject ruleCreating_Expression() throws RecognitionException {
        EObject current = null;

        Token this_NEW_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        AntlrDatatypeRuleToken lv_className_1_0 = null;

        EObject lv_argList_3_0 = null;

        AntlrDatatypeRuleToken lv_typeSpecifier_5_0 = null;

        EObject lv_expression_7_0 = null;

        EObject lv_expression_13_0 = null;


         enterRule(); 
            
        try {
            // InternalJava.g:3179:28: ( (this_NEW_0= RULE_NEW ( ( ( (lv_className_1_0= ruleClass_name ) ) otherlv_2= '(' ( (lv_argList_3_0= ruleArg_List ) ) otherlv_4= ')' ) | ( ( (lv_typeSpecifier_5_0= ruleType_specifier ) ) (otherlv_6= '[' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= ']' )? ( (otherlv_9= '[' otherlv_10= ']' ) | otherlv_11= '[]' )* ) | (otherlv_12= '(' ( (lv_expression_13_0= ruleExpression ) ) otherlv_14= ')' ) ) ) )
            // InternalJava.g:3180:1: (this_NEW_0= RULE_NEW ( ( ( (lv_className_1_0= ruleClass_name ) ) otherlv_2= '(' ( (lv_argList_3_0= ruleArg_List ) ) otherlv_4= ')' ) | ( ( (lv_typeSpecifier_5_0= ruleType_specifier ) ) (otherlv_6= '[' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= ']' )? ( (otherlv_9= '[' otherlv_10= ']' ) | otherlv_11= '[]' )* ) | (otherlv_12= '(' ( (lv_expression_13_0= ruleExpression ) ) otherlv_14= ')' ) ) )
            {
            // InternalJava.g:3180:1: (this_NEW_0= RULE_NEW ( ( ( (lv_className_1_0= ruleClass_name ) ) otherlv_2= '(' ( (lv_argList_3_0= ruleArg_List ) ) otherlv_4= ')' ) | ( ( (lv_typeSpecifier_5_0= ruleType_specifier ) ) (otherlv_6= '[' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= ']' )? ( (otherlv_9= '[' otherlv_10= ']' ) | otherlv_11= '[]' )* ) | (otherlv_12= '(' ( (lv_expression_13_0= ruleExpression ) ) otherlv_14= ')' ) ) )
            // InternalJava.g:3180:2: this_NEW_0= RULE_NEW ( ( ( (lv_className_1_0= ruleClass_name ) ) otherlv_2= '(' ( (lv_argList_3_0= ruleArg_List ) ) otherlv_4= ')' ) | ( ( (lv_typeSpecifier_5_0= ruleType_specifier ) ) (otherlv_6= '[' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= ']' )? ( (otherlv_9= '[' otherlv_10= ']' ) | otherlv_11= '[]' )* ) | (otherlv_12= '(' ( (lv_expression_13_0= ruleExpression ) ) otherlv_14= ')' ) )
            {
            this_NEW_0=(Token)match(input,RULE_NEW,FOLLOW_40); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_NEW_0, grammarAccess.getCreating_ExpressionAccess().getNEWTerminalRuleCall_0()); 
                  
            }
            // InternalJava.g:3184:1: ( ( ( (lv_className_1_0= ruleClass_name ) ) otherlv_2= '(' ( (lv_argList_3_0= ruleArg_List ) ) otherlv_4= ')' ) | ( ( (lv_typeSpecifier_5_0= ruleType_specifier ) ) (otherlv_6= '[' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= ']' )? ( (otherlv_9= '[' otherlv_10= ']' ) | otherlv_11= '[]' )* ) | (otherlv_12= '(' ( (lv_expression_13_0= ruleExpression ) ) otherlv_14= ')' ) )
            int alt54=3;
            alt54 = dfa54.predict(input);
            switch (alt54) {
                case 1 :
                    // InternalJava.g:3184:2: ( ( (lv_className_1_0= ruleClass_name ) ) otherlv_2= '(' ( (lv_argList_3_0= ruleArg_List ) ) otherlv_4= ')' )
                    {
                    // InternalJava.g:3184:2: ( ( (lv_className_1_0= ruleClass_name ) ) otherlv_2= '(' ( (lv_argList_3_0= ruleArg_List ) ) otherlv_4= ')' )
                    // InternalJava.g:3184:3: ( (lv_className_1_0= ruleClass_name ) ) otherlv_2= '(' ( (lv_argList_3_0= ruleArg_List ) ) otherlv_4= ')'
                    {
                    // InternalJava.g:3184:3: ( (lv_className_1_0= ruleClass_name ) )
                    // InternalJava.g:3185:1: (lv_className_1_0= ruleClass_name )
                    {
                    // InternalJava.g:3185:1: (lv_className_1_0= ruleClass_name )
                    // InternalJava.g:3186:3: lv_className_1_0= ruleClass_name
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCreating_ExpressionAccess().getClassNameClass_nameParserRuleCall_1_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_17);
                    lv_className_1_0=ruleClass_name();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCreating_ExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"className",
                              		lv_className_1_0, 
                              		"org.xtext.java.Java.Class_name");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_2=(Token)match(input,78,FOLLOW_35); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getCreating_ExpressionAccess().getLeftParenthesisKeyword_1_0_1());
                          
                    }
                    // InternalJava.g:3206:1: ( (lv_argList_3_0= ruleArg_List ) )
                    // InternalJava.g:3207:1: (lv_argList_3_0= ruleArg_List )
                    {
                    // InternalJava.g:3207:1: (lv_argList_3_0= ruleArg_List )
                    // InternalJava.g:3208:3: lv_argList_3_0= ruleArg_List
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCreating_ExpressionAccess().getArgListArg_ListParserRuleCall_1_0_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_19);
                    lv_argList_3_0=ruleArg_List();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCreating_ExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"argList",
                              		lv_argList_3_0, 
                              		"org.xtext.java.Java.Arg_List");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_4=(Token)match(input,79,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getCreating_ExpressionAccess().getRightParenthesisKeyword_1_0_3());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalJava.g:3229:6: ( ( (lv_typeSpecifier_5_0= ruleType_specifier ) ) (otherlv_6= '[' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= ']' )? ( (otherlv_9= '[' otherlv_10= ']' ) | otherlv_11= '[]' )* )
                    {
                    // InternalJava.g:3229:6: ( ( (lv_typeSpecifier_5_0= ruleType_specifier ) ) (otherlv_6= '[' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= ']' )? ( (otherlv_9= '[' otherlv_10= ']' ) | otherlv_11= '[]' )* )
                    // InternalJava.g:3229:7: ( (lv_typeSpecifier_5_0= ruleType_specifier ) ) (otherlv_6= '[' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= ']' )? ( (otherlv_9= '[' otherlv_10= ']' ) | otherlv_11= '[]' )*
                    {
                    // InternalJava.g:3229:7: ( (lv_typeSpecifier_5_0= ruleType_specifier ) )
                    // InternalJava.g:3230:1: (lv_typeSpecifier_5_0= ruleType_specifier )
                    {
                    // InternalJava.g:3230:1: (lv_typeSpecifier_5_0= ruleType_specifier )
                    // InternalJava.g:3231:3: lv_typeSpecifier_5_0= ruleType_specifier
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCreating_ExpressionAccess().getTypeSpecifierType_specifierParserRuleCall_1_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_26);
                    lv_typeSpecifier_5_0=ruleType_specifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCreating_ExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"typeSpecifier",
                              		lv_typeSpecifier_5_0, 
                              		"org.xtext.java.Java.Type_specifier");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // InternalJava.g:3247:2: (otherlv_6= '[' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= ']' )?
                    int alt52=2;
                    alt52 = dfa52.predict(input);
                    switch (alt52) {
                        case 1 :
                            // InternalJava.g:3247:4: otherlv_6= '[' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= ']'
                            {
                            otherlv_6=(Token)match(input,80,FOLLOW_35); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_6, grammarAccess.getCreating_ExpressionAccess().getLeftSquareBracketKeyword_1_1_1_0());
                                  
                            }
                            // InternalJava.g:3251:1: ( (lv_expression_7_0= ruleExpression ) )
                            // InternalJava.g:3252:1: (lv_expression_7_0= ruleExpression )
                            {
                            // InternalJava.g:3252:1: (lv_expression_7_0= ruleExpression )
                            // InternalJava.g:3253:3: lv_expression_7_0= ruleExpression
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getCreating_ExpressionAccess().getExpressionExpressionParserRuleCall_1_1_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_21);
                            lv_expression_7_0=ruleExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getCreating_ExpressionRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"expression",
                                      		lv_expression_7_0, 
                                      		"org.xtext.java.Java.Expression");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            otherlv_8=(Token)match(input,81,FOLLOW_26); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_8, grammarAccess.getCreating_ExpressionAccess().getRightSquareBracketKeyword_1_1_1_2());
                                  
                            }

                            }
                            break;

                    }

                    // InternalJava.g:3273:3: ( (otherlv_9= '[' otherlv_10= ']' ) | otherlv_11= '[]' )*
                    loop53:
                    do {
                        int alt53=3;
                        int LA53_0 = input.LA(1);

                        if ( (LA53_0==80) ) {
                            int LA53_2 = input.LA(2);

                            if ( (LA53_2==81) ) {
                                alt53=1;
                            }


                        }
                        else if ( (LA53_0==82) ) {
                            alt53=2;
                        }


                        switch (alt53) {
                    	case 1 :
                    	    // InternalJava.g:3273:4: (otherlv_9= '[' otherlv_10= ']' )
                    	    {
                    	    // InternalJava.g:3273:4: (otherlv_9= '[' otherlv_10= ']' )
                    	    // InternalJava.g:3273:6: otherlv_9= '[' otherlv_10= ']'
                    	    {
                    	    otherlv_9=(Token)match(input,80,FOLLOW_21); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_9, grammarAccess.getCreating_ExpressionAccess().getLeftSquareBracketKeyword_1_1_2_0_0());
                    	          
                    	    }
                    	    otherlv_10=(Token)match(input,81,FOLLOW_26); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_10, grammarAccess.getCreating_ExpressionAccess().getRightSquareBracketKeyword_1_1_2_0_1());
                    	          
                    	    }

                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalJava.g:3282:7: otherlv_11= '[]'
                    	    {
                    	    otherlv_11=(Token)match(input,82,FOLLOW_26); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_11, grammarAccess.getCreating_ExpressionAccess().getLeftSquareBracketRightSquareBracketKeyword_1_1_2_1());
                    	          
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop53;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 3 :
                    // InternalJava.g:3287:6: (otherlv_12= '(' ( (lv_expression_13_0= ruleExpression ) ) otherlv_14= ')' )
                    {
                    // InternalJava.g:3287:6: (otherlv_12= '(' ( (lv_expression_13_0= ruleExpression ) ) otherlv_14= ')' )
                    // InternalJava.g:3287:8: otherlv_12= '(' ( (lv_expression_13_0= ruleExpression ) ) otherlv_14= ')'
                    {
                    otherlv_12=(Token)match(input,78,FOLLOW_35); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getCreating_ExpressionAccess().getLeftParenthesisKeyword_1_2_0());
                          
                    }
                    // InternalJava.g:3291:1: ( (lv_expression_13_0= ruleExpression ) )
                    // InternalJava.g:3292:1: (lv_expression_13_0= ruleExpression )
                    {
                    // InternalJava.g:3292:1: (lv_expression_13_0= ruleExpression )
                    // InternalJava.g:3293:3: lv_expression_13_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCreating_ExpressionAccess().getExpressionExpressionParserRuleCall_1_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_19);
                    lv_expression_13_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCreating_ExpressionRule());
                      	        }
                             		set(
                             			current, 
                             			"expression",
                              		lv_expression_13_0, 
                              		"org.xtext.java.Java.Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_14=(Token)match(input,79,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_14, grammarAccess.getCreating_ExpressionAccess().getRightParenthesisKeyword_1_2_2());
                          
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCreating_Expression"


    // $ANTLR start "entryRuleCast_Expression"
    // InternalJava.g:3321:1: entryRuleCast_Expression returns [EObject current=null] : iv_ruleCast_Expression= ruleCast_Expression EOF ;
    public final EObject entryRuleCast_Expression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCast_Expression = null;


        try {
            // InternalJava.g:3322:2: (iv_ruleCast_Expression= ruleCast_Expression EOF )
            // InternalJava.g:3323:2: iv_ruleCast_Expression= ruleCast_Expression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCast_ExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCast_Expression=ruleCast_Expression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCast_Expression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCast_Expression"


    // $ANTLR start "ruleCast_Expression"
    // InternalJava.g:3330:1: ruleCast_Expression returns [EObject current=null] : (otherlv_0= '(' ( (lv_type_1_0= ruleType ) ) otherlv_2= ')' ( (lv_expression_3_0= ruleExpression ) ) ) ;
    public final EObject ruleCast_Expression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_type_1_0 = null;

        EObject lv_expression_3_0 = null;


         enterRule(); 
            
        try {
            // InternalJava.g:3333:28: ( (otherlv_0= '(' ( (lv_type_1_0= ruleType ) ) otherlv_2= ')' ( (lv_expression_3_0= ruleExpression ) ) ) )
            // InternalJava.g:3334:1: (otherlv_0= '(' ( (lv_type_1_0= ruleType ) ) otherlv_2= ')' ( (lv_expression_3_0= ruleExpression ) ) )
            {
            // InternalJava.g:3334:1: (otherlv_0= '(' ( (lv_type_1_0= ruleType ) ) otherlv_2= ')' ( (lv_expression_3_0= ruleExpression ) ) )
            // InternalJava.g:3334:3: otherlv_0= '(' ( (lv_type_1_0= ruleType ) ) otherlv_2= ')' ( (lv_expression_3_0= ruleExpression ) )
            {
            otherlv_0=(Token)match(input,78,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getCast_ExpressionAccess().getLeftParenthesisKeyword_0());
                  
            }
            // InternalJava.g:3338:1: ( (lv_type_1_0= ruleType ) )
            // InternalJava.g:3339:1: (lv_type_1_0= ruleType )
            {
            // InternalJava.g:3339:1: (lv_type_1_0= ruleType )
            // InternalJava.g:3340:3: lv_type_1_0= ruleType
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCast_ExpressionAccess().getTypeTypeParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_19);
            lv_type_1_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getCast_ExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"type",
                      		lv_type_1_0, 
                      		"org.xtext.java.Java.Type");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,79,FOLLOW_35); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getCast_ExpressionAccess().getRightParenthesisKeyword_2());
                  
            }
            // InternalJava.g:3360:1: ( (lv_expression_3_0= ruleExpression ) )
            // InternalJava.g:3361:1: (lv_expression_3_0= ruleExpression )
            {
            // InternalJava.g:3361:1: (lv_expression_3_0= ruleExpression )
            // InternalJava.g:3362:3: lv_expression_3_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCast_ExpressionAccess().getExpressionExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_expression_3_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getCast_ExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_3_0, 
                      		"org.xtext.java.Java.Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCast_Expression"


    // $ANTLR start "entryRuleBit_Expression_NR"
    // InternalJava.g:3386:1: entryRuleBit_Expression_NR returns [EObject current=null] : iv_ruleBit_Expression_NR= ruleBit_Expression_NR EOF ;
    public final EObject entryRuleBit_Expression_NR() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBit_Expression_NR = null;


        try {
            // InternalJava.g:3387:2: (iv_ruleBit_Expression_NR= ruleBit_Expression_NR EOF )
            // InternalJava.g:3388:2: iv_ruleBit_Expression_NR= ruleBit_Expression_NR EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBit_Expression_NRRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBit_Expression_NR=ruleBit_Expression_NR();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBit_Expression_NR; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBit_Expression_NR"


    // $ANTLR start "ruleBit_Expression_NR"
    // InternalJava.g:3395:1: ruleBit_Expression_NR returns [EObject current=null] : (this_NOT_0= RULE_NOT ( (lv_expression_1_0= ruleExpression ) ) ) ;
    public final EObject ruleBit_Expression_NR() throws RecognitionException {
        EObject current = null;

        Token this_NOT_0=null;
        EObject lv_expression_1_0 = null;


         enterRule(); 
            
        try {
            // InternalJava.g:3398:28: ( (this_NOT_0= RULE_NOT ( (lv_expression_1_0= ruleExpression ) ) ) )
            // InternalJava.g:3399:1: (this_NOT_0= RULE_NOT ( (lv_expression_1_0= ruleExpression ) ) )
            {
            // InternalJava.g:3399:1: (this_NOT_0= RULE_NOT ( (lv_expression_1_0= ruleExpression ) ) )
            // InternalJava.g:3399:2: this_NOT_0= RULE_NOT ( (lv_expression_1_0= ruleExpression ) )
            {
            this_NOT_0=(Token)match(input,RULE_NOT,FOLLOW_35); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_NOT_0, grammarAccess.getBit_Expression_NRAccess().getNOTTerminalRuleCall_0()); 
                  
            }
            // InternalJava.g:3403:1: ( (lv_expression_1_0= ruleExpression ) )
            // InternalJava.g:3404:1: (lv_expression_1_0= ruleExpression )
            {
            // InternalJava.g:3404:1: (lv_expression_1_0= ruleExpression )
            // InternalJava.g:3405:3: lv_expression_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getBit_Expression_NRAccess().getExpressionExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_expression_1_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getBit_Expression_NRRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_1_0, 
                      		"org.xtext.java.Java.Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBit_Expression_NR"


    // $ANTLR start "entryRuleLogical_Expression_NR"
    // InternalJava.g:3429:1: entryRuleLogical_Expression_NR returns [EObject current=null] : iv_ruleLogical_Expression_NR= ruleLogical_Expression_NR EOF ;
    public final EObject entryRuleLogical_Expression_NR() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogical_Expression_NR = null;


        try {
            // InternalJava.g:3430:2: (iv_ruleLogical_Expression_NR= ruleLogical_Expression_NR EOF )
            // InternalJava.g:3431:2: iv_ruleLogical_Expression_NR= ruleLogical_Expression_NR EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogical_Expression_NRRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLogical_Expression_NR=ruleLogical_Expression_NR();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogical_Expression_NR; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLogical_Expression_NR"


    // $ANTLR start "ruleLogical_Expression_NR"
    // InternalJava.g:3438:1: ruleLogical_Expression_NR returns [EObject current=null] : ( (this_EXCLAMATION_0= RULE_EXCLAMATION ( (lv_expression_1_0= ruleExpression ) ) ) | ( (lv_true_2_0= RULE_TRUE ) ) | ( (lv_false_3_0= RULE_FALSE ) ) ) ;
    public final EObject ruleLogical_Expression_NR() throws RecognitionException {
        EObject current = null;

        Token this_EXCLAMATION_0=null;
        Token lv_true_2_0=null;
        Token lv_false_3_0=null;
        EObject lv_expression_1_0 = null;


         enterRule(); 
            
        try {
            // InternalJava.g:3441:28: ( ( (this_EXCLAMATION_0= RULE_EXCLAMATION ( (lv_expression_1_0= ruleExpression ) ) ) | ( (lv_true_2_0= RULE_TRUE ) ) | ( (lv_false_3_0= RULE_FALSE ) ) ) )
            // InternalJava.g:3442:1: ( (this_EXCLAMATION_0= RULE_EXCLAMATION ( (lv_expression_1_0= ruleExpression ) ) ) | ( (lv_true_2_0= RULE_TRUE ) ) | ( (lv_false_3_0= RULE_FALSE ) ) )
            {
            // InternalJava.g:3442:1: ( (this_EXCLAMATION_0= RULE_EXCLAMATION ( (lv_expression_1_0= ruleExpression ) ) ) | ( (lv_true_2_0= RULE_TRUE ) ) | ( (lv_false_3_0= RULE_FALSE ) ) )
            int alt55=3;
            switch ( input.LA(1) ) {
            case RULE_EXCLAMATION:
                {
                alt55=1;
                }
                break;
            case RULE_TRUE:
                {
                alt55=2;
                }
                break;
            case RULE_FALSE:
                {
                alt55=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }

            switch (alt55) {
                case 1 :
                    // InternalJava.g:3442:2: (this_EXCLAMATION_0= RULE_EXCLAMATION ( (lv_expression_1_0= ruleExpression ) ) )
                    {
                    // InternalJava.g:3442:2: (this_EXCLAMATION_0= RULE_EXCLAMATION ( (lv_expression_1_0= ruleExpression ) ) )
                    // InternalJava.g:3442:3: this_EXCLAMATION_0= RULE_EXCLAMATION ( (lv_expression_1_0= ruleExpression ) )
                    {
                    this_EXCLAMATION_0=(Token)match(input,RULE_EXCLAMATION,FOLLOW_35); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_EXCLAMATION_0, grammarAccess.getLogical_Expression_NRAccess().getEXCLAMATIONTerminalRuleCall_0_0()); 
                          
                    }
                    // InternalJava.g:3446:1: ( (lv_expression_1_0= ruleExpression ) )
                    // InternalJava.g:3447:1: (lv_expression_1_0= ruleExpression )
                    {
                    // InternalJava.g:3447:1: (lv_expression_1_0= ruleExpression )
                    // InternalJava.g:3448:3: lv_expression_1_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLogical_Expression_NRAccess().getExpressionExpressionParserRuleCall_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_expression_1_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLogical_Expression_NRRule());
                      	        }
                             		set(
                             			current, 
                             			"expression",
                              		lv_expression_1_0, 
                              		"org.xtext.java.Java.Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalJava.g:3465:6: ( (lv_true_2_0= RULE_TRUE ) )
                    {
                    // InternalJava.g:3465:6: ( (lv_true_2_0= RULE_TRUE ) )
                    // InternalJava.g:3466:1: (lv_true_2_0= RULE_TRUE )
                    {
                    // InternalJava.g:3466:1: (lv_true_2_0= RULE_TRUE )
                    // InternalJava.g:3467:3: lv_true_2_0= RULE_TRUE
                    {
                    lv_true_2_0=(Token)match(input,RULE_TRUE,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_true_2_0, grammarAccess.getLogical_Expression_NRAccess().getTrueTRUETerminalRuleCall_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getLogical_Expression_NRRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"true",
                              		lv_true_2_0, 
                              		"org.xtext.java.Java.TRUE");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalJava.g:3484:6: ( (lv_false_3_0= RULE_FALSE ) )
                    {
                    // InternalJava.g:3484:6: ( (lv_false_3_0= RULE_FALSE ) )
                    // InternalJava.g:3485:1: (lv_false_3_0= RULE_FALSE )
                    {
                    // InternalJava.g:3485:1: (lv_false_3_0= RULE_FALSE )
                    // InternalJava.g:3486:3: lv_false_3_0= RULE_FALSE
                    {
                    lv_false_3_0=(Token)match(input,RULE_FALSE,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_false_3_0, grammarAccess.getLogical_Expression_NRAccess().getFalseFALSETerminalRuleCall_2_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getLogical_Expression_NRRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"false",
                              		lv_false_3_0, 
                              		"org.xtext.java.Java.FALSE");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLogical_Expression_NR"


    // $ANTLR start "entryRuleArg_List"
    // InternalJava.g:3510:1: entryRuleArg_List returns [EObject current=null] : iv_ruleArg_List= ruleArg_List EOF ;
    public final EObject entryRuleArg_List() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArg_List = null;


        try {
            // InternalJava.g:3511:2: (iv_ruleArg_List= ruleArg_List EOF )
            // InternalJava.g:3512:2: iv_ruleArg_List= ruleArg_List EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArg_ListRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleArg_List=ruleArg_List();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArg_List; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArg_List"


    // $ANTLR start "ruleArg_List"
    // InternalJava.g:3519:1: ruleArg_List returns [EObject current=null] : ( ( (lv_expression_0_0= ruleExpression ) ) (this_COMMA_1= RULE_COMMA ( (lv_expressions_2_0= ruleExpression ) ) )* ) ;
    public final EObject ruleArg_List() throws RecognitionException {
        EObject current = null;

        Token this_COMMA_1=null;
        EObject lv_expression_0_0 = null;

        EObject lv_expressions_2_0 = null;


         enterRule(); 
            
        try {
            // InternalJava.g:3522:28: ( ( ( (lv_expression_0_0= ruleExpression ) ) (this_COMMA_1= RULE_COMMA ( (lv_expressions_2_0= ruleExpression ) ) )* ) )
            // InternalJava.g:3523:1: ( ( (lv_expression_0_0= ruleExpression ) ) (this_COMMA_1= RULE_COMMA ( (lv_expressions_2_0= ruleExpression ) ) )* )
            {
            // InternalJava.g:3523:1: ( ( (lv_expression_0_0= ruleExpression ) ) (this_COMMA_1= RULE_COMMA ( (lv_expressions_2_0= ruleExpression ) ) )* )
            // InternalJava.g:3523:2: ( (lv_expression_0_0= ruleExpression ) ) (this_COMMA_1= RULE_COMMA ( (lv_expressions_2_0= ruleExpression ) ) )*
            {
            // InternalJava.g:3523:2: ( (lv_expression_0_0= ruleExpression ) )
            // InternalJava.g:3524:1: (lv_expression_0_0= ruleExpression )
            {
            // InternalJava.g:3524:1: (lv_expression_0_0= ruleExpression )
            // InternalJava.g:3525:3: lv_expression_0_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getArg_ListAccess().getExpressionExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_25);
            lv_expression_0_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getArg_ListRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_0_0, 
                      		"org.xtext.java.Java.Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalJava.g:3541:2: (this_COMMA_1= RULE_COMMA ( (lv_expressions_2_0= ruleExpression ) ) )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==RULE_COMMA) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // InternalJava.g:3541:3: this_COMMA_1= RULE_COMMA ( (lv_expressions_2_0= ruleExpression ) )
            	    {
            	    this_COMMA_1=(Token)match(input,RULE_COMMA,FOLLOW_35); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_COMMA_1, grammarAccess.getArg_ListAccess().getCOMMATerminalRuleCall_1_0()); 
            	          
            	    }
            	    // InternalJava.g:3545:1: ( (lv_expressions_2_0= ruleExpression ) )
            	    // InternalJava.g:3546:1: (lv_expressions_2_0= ruleExpression )
            	    {
            	    // InternalJava.g:3546:1: (lv_expressions_2_0= ruleExpression )
            	    // InternalJava.g:3547:3: lv_expressions_2_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getArg_ListAccess().getExpressionsExpressionParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_25);
            	    lv_expressions_2_0=ruleExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getArg_ListRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"expressions",
            	              		lv_expressions_2_0, 
            	              		"org.xtext.java.Java.Expression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop56;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArg_List"


    // $ANTLR start "entryRuleNumeric_Expression_NR"
    // InternalJava.g:3571:1: entryRuleNumeric_Expression_NR returns [EObject current=null] : iv_ruleNumeric_Expression_NR= ruleNumeric_Expression_NR EOF ;
    public final EObject entryRuleNumeric_Expression_NR() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumeric_Expression_NR = null;


        try {
            // InternalJava.g:3572:2: (iv_ruleNumeric_Expression_NR= ruleNumeric_Expression_NR EOF )
            // InternalJava.g:3573:2: iv_ruleNumeric_Expression_NR= ruleNumeric_Expression_NR EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumeric_Expression_NRRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNumeric_Expression_NR=ruleNumeric_Expression_NR();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumeric_Expression_NR; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumeric_Expression_NR"


    // $ANTLR start "ruleNumeric_Expression_NR"
    // InternalJava.g:3580:1: ruleNumeric_Expression_NR returns [EObject current=null] : ( ( ( (lv_sinal_numeric_0_1= RULE_MINUS | lv_sinal_numeric_0_2= RULE_INCREMENT | lv_sinal_numeric_0_3= RULE_DECREMENT ) ) ) ( (lv_expression_1_0= ruleExpression ) ) ) ;
    public final EObject ruleNumeric_Expression_NR() throws RecognitionException {
        EObject current = null;

        Token lv_sinal_numeric_0_1=null;
        Token lv_sinal_numeric_0_2=null;
        Token lv_sinal_numeric_0_3=null;
        EObject lv_expression_1_0 = null;


         enterRule(); 
            
        try {
            // InternalJava.g:3583:28: ( ( ( ( (lv_sinal_numeric_0_1= RULE_MINUS | lv_sinal_numeric_0_2= RULE_INCREMENT | lv_sinal_numeric_0_3= RULE_DECREMENT ) ) ) ( (lv_expression_1_0= ruleExpression ) ) ) )
            // InternalJava.g:3584:1: ( ( ( (lv_sinal_numeric_0_1= RULE_MINUS | lv_sinal_numeric_0_2= RULE_INCREMENT | lv_sinal_numeric_0_3= RULE_DECREMENT ) ) ) ( (lv_expression_1_0= ruleExpression ) ) )
            {
            // InternalJava.g:3584:1: ( ( ( (lv_sinal_numeric_0_1= RULE_MINUS | lv_sinal_numeric_0_2= RULE_INCREMENT | lv_sinal_numeric_0_3= RULE_DECREMENT ) ) ) ( (lv_expression_1_0= ruleExpression ) ) )
            // InternalJava.g:3584:2: ( ( (lv_sinal_numeric_0_1= RULE_MINUS | lv_sinal_numeric_0_2= RULE_INCREMENT | lv_sinal_numeric_0_3= RULE_DECREMENT ) ) ) ( (lv_expression_1_0= ruleExpression ) )
            {
            // InternalJava.g:3584:2: ( ( (lv_sinal_numeric_0_1= RULE_MINUS | lv_sinal_numeric_0_2= RULE_INCREMENT | lv_sinal_numeric_0_3= RULE_DECREMENT ) ) )
            // InternalJava.g:3585:1: ( (lv_sinal_numeric_0_1= RULE_MINUS | lv_sinal_numeric_0_2= RULE_INCREMENT | lv_sinal_numeric_0_3= RULE_DECREMENT ) )
            {
            // InternalJava.g:3585:1: ( (lv_sinal_numeric_0_1= RULE_MINUS | lv_sinal_numeric_0_2= RULE_INCREMENT | lv_sinal_numeric_0_3= RULE_DECREMENT ) )
            // InternalJava.g:3586:1: (lv_sinal_numeric_0_1= RULE_MINUS | lv_sinal_numeric_0_2= RULE_INCREMENT | lv_sinal_numeric_0_3= RULE_DECREMENT )
            {
            // InternalJava.g:3586:1: (lv_sinal_numeric_0_1= RULE_MINUS | lv_sinal_numeric_0_2= RULE_INCREMENT | lv_sinal_numeric_0_3= RULE_DECREMENT )
            int alt57=3;
            switch ( input.LA(1) ) {
            case RULE_MINUS:
                {
                alt57=1;
                }
                break;
            case RULE_INCREMENT:
                {
                alt57=2;
                }
                break;
            case RULE_DECREMENT:
                {
                alt57=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }

            switch (alt57) {
                case 1 :
                    // InternalJava.g:3587:3: lv_sinal_numeric_0_1= RULE_MINUS
                    {
                    lv_sinal_numeric_0_1=(Token)match(input,RULE_MINUS,FOLLOW_35); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_sinal_numeric_0_1, grammarAccess.getNumeric_Expression_NRAccess().getSinal_numericMINUSTerminalRuleCall_0_0_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getNumeric_Expression_NRRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"sinal_numeric",
                              		lv_sinal_numeric_0_1, 
                              		"org.xtext.java.Java.MINUS");
                      	    
                    }

                    }
                    break;
                case 2 :
                    // InternalJava.g:3602:8: lv_sinal_numeric_0_2= RULE_INCREMENT
                    {
                    lv_sinal_numeric_0_2=(Token)match(input,RULE_INCREMENT,FOLLOW_35); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_sinal_numeric_0_2, grammarAccess.getNumeric_Expression_NRAccess().getSinal_numericINCREMENTTerminalRuleCall_0_0_1()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getNumeric_Expression_NRRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"sinal_numeric",
                              		lv_sinal_numeric_0_2, 
                              		"org.xtext.java.Java.INCREMENT");
                      	    
                    }

                    }
                    break;
                case 3 :
                    // InternalJava.g:3617:8: lv_sinal_numeric_0_3= RULE_DECREMENT
                    {
                    lv_sinal_numeric_0_3=(Token)match(input,RULE_DECREMENT,FOLLOW_35); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_sinal_numeric_0_3, grammarAccess.getNumeric_Expression_NRAccess().getSinal_numericDECREMENTTerminalRuleCall_0_0_2()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getNumeric_Expression_NRRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"sinal_numeric",
                              		lv_sinal_numeric_0_3, 
                              		"org.xtext.java.Java.DECREMENT");
                      	    
                    }

                    }
                    break;

            }


            }


            }

            // InternalJava.g:3635:2: ( (lv_expression_1_0= ruleExpression ) )
            // InternalJava.g:3636:1: (lv_expression_1_0= ruleExpression )
            {
            // InternalJava.g:3636:1: (lv_expression_1_0= ruleExpression )
            // InternalJava.g:3637:3: lv_expression_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getNumeric_Expression_NRAccess().getExpressionExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_expression_1_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getNumeric_Expression_NRRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_1_0, 
                      		"org.xtext.java.Java.Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumeric_Expression_NR"


    // $ANTLR start "entryRuleType"
    // InternalJava.g:3661:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // InternalJava.g:3662:2: (iv_ruleType= ruleType EOF )
            // InternalJava.g:3663:2: iv_ruleType= ruleType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleType=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleType; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // InternalJava.g:3670:1: ruleType returns [EObject current=null] : ( ( (lv_name_0_0= ruleType_specifier ) ) ( (otherlv_1= '[' otherlv_2= ']' ) | otherlv_3= '[]' )* ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // InternalJava.g:3673:28: ( ( ( (lv_name_0_0= ruleType_specifier ) ) ( (otherlv_1= '[' otherlv_2= ']' ) | otherlv_3= '[]' )* ) )
            // InternalJava.g:3674:1: ( ( (lv_name_0_0= ruleType_specifier ) ) ( (otherlv_1= '[' otherlv_2= ']' ) | otherlv_3= '[]' )* )
            {
            // InternalJava.g:3674:1: ( ( (lv_name_0_0= ruleType_specifier ) ) ( (otherlv_1= '[' otherlv_2= ']' ) | otherlv_3= '[]' )* )
            // InternalJava.g:3674:2: ( (lv_name_0_0= ruleType_specifier ) ) ( (otherlv_1= '[' otherlv_2= ']' ) | otherlv_3= '[]' )*
            {
            // InternalJava.g:3674:2: ( (lv_name_0_0= ruleType_specifier ) )
            // InternalJava.g:3675:1: (lv_name_0_0= ruleType_specifier )
            {
            // InternalJava.g:3675:1: (lv_name_0_0= ruleType_specifier )
            // InternalJava.g:3676:3: lv_name_0_0= ruleType_specifier
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTypeAccess().getNameType_specifierParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_26);
            lv_name_0_0=ruleType_specifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTypeRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"org.xtext.java.Java.Type_specifier");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalJava.g:3692:2: ( (otherlv_1= '[' otherlv_2= ']' ) | otherlv_3= '[]' )*
            loop58:
            do {
                int alt58=3;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==80) ) {
                    alt58=1;
                }
                else if ( (LA58_0==82) ) {
                    alt58=2;
                }


                switch (alt58) {
            	case 1 :
            	    // InternalJava.g:3692:3: (otherlv_1= '[' otherlv_2= ']' )
            	    {
            	    // InternalJava.g:3692:3: (otherlv_1= '[' otherlv_2= ']' )
            	    // InternalJava.g:3692:5: otherlv_1= '[' otherlv_2= ']'
            	    {
            	    otherlv_1=(Token)match(input,80,FOLLOW_21); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getTypeAccess().getLeftSquareBracketKeyword_1_0_0());
            	          
            	    }
            	    otherlv_2=(Token)match(input,81,FOLLOW_26); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_2, grammarAccess.getTypeAccess().getRightSquareBracketKeyword_1_0_1());
            	          
            	    }

            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalJava.g:3701:7: otherlv_3= '[]'
            	    {
            	    otherlv_3=(Token)match(input,82,FOLLOW_26); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getTypeAccess().getLeftSquareBracketRightSquareBracketKeyword_1_1());
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop58;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRuleType_specifier"
    // InternalJava.g:3713:1: entryRuleType_specifier returns [String current=null] : iv_ruleType_specifier= ruleType_specifier EOF ;
    public final String entryRuleType_specifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleType_specifier = null;


        try {
            // InternalJava.g:3714:2: (iv_ruleType_specifier= ruleType_specifier EOF )
            // InternalJava.g:3715:2: iv_ruleType_specifier= ruleType_specifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getType_specifierRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleType_specifier=ruleType_specifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleType_specifier.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleType_specifier"


    // $ANTLR start "ruleType_specifier"
    // InternalJava.g:3722:1: ruleType_specifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'boolean' | kw= 'byte' | kw= 'char' | kw= 'short' | kw= 'int' | kw= 'float' | kw= 'long' | kw= 'double' | kw= 'void' | this_Class_name_9= ruleClass_name ) ;
    public final AntlrDatatypeRuleToken ruleType_specifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_Class_name_9 = null;


         enterRule(); 
            
        try {
            // InternalJava.g:3725:28: ( (kw= 'boolean' | kw= 'byte' | kw= 'char' | kw= 'short' | kw= 'int' | kw= 'float' | kw= 'long' | kw= 'double' | kw= 'void' | this_Class_name_9= ruleClass_name ) )
            // InternalJava.g:3726:1: (kw= 'boolean' | kw= 'byte' | kw= 'char' | kw= 'short' | kw= 'int' | kw= 'float' | kw= 'long' | kw= 'double' | kw= 'void' | this_Class_name_9= ruleClass_name )
            {
            // InternalJava.g:3726:1: (kw= 'boolean' | kw= 'byte' | kw= 'char' | kw= 'short' | kw= 'int' | kw= 'float' | kw= 'long' | kw= 'double' | kw= 'void' | this_Class_name_9= ruleClass_name )
            int alt59=10;
            switch ( input.LA(1) ) {
            case 84:
                {
                alt59=1;
                }
                break;
            case 85:
                {
                alt59=2;
                }
                break;
            case 86:
                {
                alt59=3;
                }
                break;
            case 87:
                {
                alt59=4;
                }
                break;
            case 88:
                {
                alt59=5;
                }
                break;
            case 89:
                {
                alt59=6;
                }
                break;
            case 90:
                {
                alt59=7;
                }
                break;
            case 91:
                {
                alt59=8;
                }
                break;
            case 92:
                {
                alt59=9;
                }
                break;
            case RULE_ID:
                {
                alt59=10;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }

            switch (alt59) {
                case 1 :
                    // InternalJava.g:3727:2: kw= 'boolean'
                    {
                    kw=(Token)match(input,84,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getType_specifierAccess().getBooleanKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalJava.g:3734:2: kw= 'byte'
                    {
                    kw=(Token)match(input,85,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getType_specifierAccess().getByteKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalJava.g:3741:2: kw= 'char'
                    {
                    kw=(Token)match(input,86,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getType_specifierAccess().getCharKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // InternalJava.g:3748:2: kw= 'short'
                    {
                    kw=(Token)match(input,87,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getType_specifierAccess().getShortKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // InternalJava.g:3755:2: kw= 'int'
                    {
                    kw=(Token)match(input,88,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getType_specifierAccess().getIntKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // InternalJava.g:3762:2: kw= 'float'
                    {
                    kw=(Token)match(input,89,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getType_specifierAccess().getFloatKeyword_5()); 
                          
                    }

                    }
                    break;
                case 7 :
                    // InternalJava.g:3769:2: kw= 'long'
                    {
                    kw=(Token)match(input,90,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getType_specifierAccess().getLongKeyword_6()); 
                          
                    }

                    }
                    break;
                case 8 :
                    // InternalJava.g:3776:2: kw= 'double'
                    {
                    kw=(Token)match(input,91,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getType_specifierAccess().getDoubleKeyword_7()); 
                          
                    }

                    }
                    break;
                case 9 :
                    // InternalJava.g:3783:2: kw= 'void'
                    {
                    kw=(Token)match(input,92,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getType_specifierAccess().getVoidKeyword_8()); 
                          
                    }

                    }
                    break;
                case 10 :
                    // InternalJava.g:3790:5: this_Class_name_9= ruleClass_name
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getType_specifierAccess().getClass_nameParserRuleCall_9()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_Class_name_9=ruleClass_name();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_Class_name_9);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleType_specifier"


    // $ANTLR start "entryRuleModifier"
    // InternalJava.g:3808:1: entryRuleModifier returns [String current=null] : iv_ruleModifier= ruleModifier EOF ;
    public final String entryRuleModifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleModifier = null;


        try {
            // InternalJava.g:3809:2: (iv_ruleModifier= ruleModifier EOF )
            // InternalJava.g:3810:2: iv_ruleModifier= ruleModifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModifierRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleModifier=ruleModifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModifier.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModifier"


    // $ANTLR start "ruleModifier"
    // InternalJava.g:3817:1: ruleModifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_MOD_0= RULE_MOD | this_STATIC_1= RULE_STATIC ) ;
    public final AntlrDatatypeRuleToken ruleModifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_MOD_0=null;
        Token this_STATIC_1=null;

         enterRule(); 
            
        try {
            // InternalJava.g:3820:28: ( (this_MOD_0= RULE_MOD | this_STATIC_1= RULE_STATIC ) )
            // InternalJava.g:3821:1: (this_MOD_0= RULE_MOD | this_STATIC_1= RULE_STATIC )
            {
            // InternalJava.g:3821:1: (this_MOD_0= RULE_MOD | this_STATIC_1= RULE_STATIC )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==RULE_MOD) ) {
                alt60=1;
            }
            else if ( (LA60_0==RULE_STATIC) ) {
                alt60=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }
            switch (alt60) {
                case 1 :
                    // InternalJava.g:3821:6: this_MOD_0= RULE_MOD
                    {
                    this_MOD_0=(Token)match(input,RULE_MOD,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_MOD_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_MOD_0, grammarAccess.getModifierAccess().getMODTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // InternalJava.g:3829:10: this_STATIC_1= RULE_STATIC
                    {
                    this_STATIC_1=(Token)match(input,RULE_STATIC,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_STATIC_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_STATIC_1, grammarAccess.getModifierAccess().getSTATICTerminalRuleCall_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModifier"


    // $ANTLR start "entryRuleStatic_initializer"
    // InternalJava.g:3844:1: entryRuleStatic_initializer returns [EObject current=null] : iv_ruleStatic_initializer= ruleStatic_initializer EOF ;
    public final EObject entryRuleStatic_initializer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatic_initializer = null;


        try {
            // InternalJava.g:3845:2: (iv_ruleStatic_initializer= ruleStatic_initializer EOF )
            // InternalJava.g:3846:2: iv_ruleStatic_initializer= ruleStatic_initializer EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStatic_initializerRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStatic_initializer=ruleStatic_initializer();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStatic_initializer; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStatic_initializer"


    // $ANTLR start "ruleStatic_initializer"
    // InternalJava.g:3853:1: ruleStatic_initializer returns [EObject current=null] : ( ( (lv_static_0_0= RULE_STATIC ) ) ( (lv_name_1_0= ruleStatement_block ) ) ) ;
    public final EObject ruleStatic_initializer() throws RecognitionException {
        EObject current = null;

        Token lv_static_0_0=null;
        EObject lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // InternalJava.g:3856:28: ( ( ( (lv_static_0_0= RULE_STATIC ) ) ( (lv_name_1_0= ruleStatement_block ) ) ) )
            // InternalJava.g:3857:1: ( ( (lv_static_0_0= RULE_STATIC ) ) ( (lv_name_1_0= ruleStatement_block ) ) )
            {
            // InternalJava.g:3857:1: ( ( (lv_static_0_0= RULE_STATIC ) ) ( (lv_name_1_0= ruleStatement_block ) ) )
            // InternalJava.g:3857:2: ( (lv_static_0_0= RULE_STATIC ) ) ( (lv_name_1_0= ruleStatement_block ) )
            {
            // InternalJava.g:3857:2: ( (lv_static_0_0= RULE_STATIC ) )
            // InternalJava.g:3858:1: (lv_static_0_0= RULE_STATIC )
            {
            // InternalJava.g:3858:1: (lv_static_0_0= RULE_STATIC )
            // InternalJava.g:3859:3: lv_static_0_0= RULE_STATIC
            {
            lv_static_0_0=(Token)match(input,RULE_STATIC,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_static_0_0, grammarAccess.getStatic_initializerAccess().getStaticSTATICTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getStatic_initializerRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"static",
                      		lv_static_0_0, 
                      		"org.xtext.java.Java.STATIC");
              	    
            }

            }


            }

            // InternalJava.g:3875:2: ( (lv_name_1_0= ruleStatement_block ) )
            // InternalJava.g:3876:1: (lv_name_1_0= ruleStatement_block )
            {
            // InternalJava.g:3876:1: (lv_name_1_0= ruleStatement_block )
            // InternalJava.g:3877:3: lv_name_1_0= ruleStatement_block
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getStatic_initializerAccess().getNameStatement_blockParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_name_1_0=ruleStatement_block();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getStatic_initializerRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"org.xtext.java.Java.Statement_block");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStatic_initializer"


    // $ANTLR start "entryRuleStatement_block"
    // InternalJava.g:3901:1: entryRuleStatement_block returns [EObject current=null] : iv_ruleStatement_block= ruleStatement_block EOF ;
    public final EObject entryRuleStatement_block() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement_block = null;


        try {
            // InternalJava.g:3902:2: (iv_ruleStatement_block= ruleStatement_block EOF )
            // InternalJava.g:3903:2: iv_ruleStatement_block= ruleStatement_block EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStatement_blockRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStatement_block=ruleStatement_block();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStatement_block; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStatement_block"


    // $ANTLR start "ruleStatement_block"
    // InternalJava.g:3910:1: ruleStatement_block returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}' ) ;
    public final EObject ruleStatement_block() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_statements_2_0 = null;


         enterRule(); 
            
        try {
            // InternalJava.g:3913:28: ( ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}' ) )
            // InternalJava.g:3914:1: ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}' )
            {
            // InternalJava.g:3914:1: ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}' )
            // InternalJava.g:3914:2: () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}'
            {
            // InternalJava.g:3914:2: ()
            // InternalJava.g:3915:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getStatement_blockAccess().getStatement_blockAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,74,FOLLOW_41); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getStatement_blockAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // InternalJava.g:3927:1: ( (lv_statements_2_0= ruleStatement ) )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==RULE_EOL||LA61_0==RULE_ID||(LA61_0>=RULE_NULL && LA61_0<=RULE_THIS)||(LA61_0>=RULE_INCREMENT && LA61_0<=RULE_DECREMENT)||LA61_0==RULE_MINUS||(LA61_0>=RULE_DECIMAL_DIGITS && LA61_0<=RULE_SWITCH)||(LA61_0>=RULE_FOR && LA61_0<=RULE_IF)||(LA61_0>=RULE_RETURN && LA61_0<=RULE_TRY)||LA61_0==74||LA61_0==78||(LA61_0>=84 && LA61_0<=94)) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // InternalJava.g:3928:1: (lv_statements_2_0= ruleStatement )
            	    {
            	    // InternalJava.g:3928:1: (lv_statements_2_0= ruleStatement )
            	    // InternalJava.g:3929:3: lv_statements_2_0= ruleStatement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getStatement_blockAccess().getStatementsStatementParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_41);
            	    lv_statements_2_0=ruleStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getStatement_blockRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"statements",
            	              		lv_statements_2_0, 
            	              		"org.xtext.java.Java.Statement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop61;
                }
            } while (true);

            otherlv_3=(Token)match(input,75,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getStatement_blockAccess().getRightCurlyBracketKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStatement_block"


    // $ANTLR start "entryRuleStatement"
    // InternalJava.g:3957:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // InternalJava.g:3958:2: (iv_ruleStatement= ruleStatement EOF )
            // InternalJava.g:3959:2: iv_ruleStatement= ruleStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStatement=ruleStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStatement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStatement"


    // $ANTLR start "ruleStatement"
    // InternalJava.g:3966:1: ruleStatement returns [EObject current=null] : ( ( (lv_returnSmt_0_0= ruleReturn_Statement ) ) | ( (lv_variable_1_0= ruleVariable_declaration ) ) | ( (lv_expressionx_2_0= ruleExpression ) ) | ( (lv_ifStatement_3_0= ruleIf_Statement ) ) | ( (lv_doStatement_4_0= ruleDo_Statement ) ) | ( (lv_whileStatement_5_0= ruleWhile_Statement ) ) | ( (lv_forStatement_6_0= ruleFor_Statement ) ) | ( (lv_switchStatement_7_0= ruleSwitch_Statement ) ) | ( ( ( ( ruleStatement_block ) ) )=> ( (lv_statementBlock_8_0= ruleStatement_block ) ) ) | ( (lv_try_9_0= ruleTry_statement ) ) | ( ( (lv_name_10_0= RULE_ID ) ) this_COLON_11= RULE_COLON ( (lv_statement_12_0= ruleStatement ) ) ) | ( () otherlv_14= 'break' ( (lv_name_15_0= RULE_ID ) )? this_EOL_16= RULE_EOL ) | ( () otherlv_18= 'continue' ( (lv_name_19_0= RULE_ID ) )? this_EOL_20= RULE_EOL ) | ( () this_EOL_22= RULE_EOL ) | ( ( (lv_variableDeclarator_23_0= ruleVariable_declarator ) ) this_EOL_24= RULE_EOL ) ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        Token lv_name_10_0=null;
        Token this_COLON_11=null;
        Token otherlv_14=null;
        Token lv_name_15_0=null;
        Token this_EOL_16=null;
        Token otherlv_18=null;
        Token lv_name_19_0=null;
        Token this_EOL_20=null;
        Token this_EOL_22=null;
        Token this_EOL_24=null;
        EObject lv_returnSmt_0_0 = null;

        EObject lv_variable_1_0 = null;

        EObject lv_expressionx_2_0 = null;

        EObject lv_ifStatement_3_0 = null;

        EObject lv_doStatement_4_0 = null;

        EObject lv_whileStatement_5_0 = null;

        EObject lv_forStatement_6_0 = null;

        EObject lv_switchStatement_7_0 = null;

        EObject lv_statementBlock_8_0 = null;

        EObject lv_try_9_0 = null;

        EObject lv_statement_12_0 = null;

        EObject lv_variableDeclarator_23_0 = null;


         enterRule(); 
            
        try {
            // InternalJava.g:3969:28: ( ( ( (lv_returnSmt_0_0= ruleReturn_Statement ) ) | ( (lv_variable_1_0= ruleVariable_declaration ) ) | ( (lv_expressionx_2_0= ruleExpression ) ) | ( (lv_ifStatement_3_0= ruleIf_Statement ) ) | ( (lv_doStatement_4_0= ruleDo_Statement ) ) | ( (lv_whileStatement_5_0= ruleWhile_Statement ) ) | ( (lv_forStatement_6_0= ruleFor_Statement ) ) | ( (lv_switchStatement_7_0= ruleSwitch_Statement ) ) | ( ( ( ( ruleStatement_block ) ) )=> ( (lv_statementBlock_8_0= ruleStatement_block ) ) ) | ( (lv_try_9_0= ruleTry_statement ) ) | ( ( (lv_name_10_0= RULE_ID ) ) this_COLON_11= RULE_COLON ( (lv_statement_12_0= ruleStatement ) ) ) | ( () otherlv_14= 'break' ( (lv_name_15_0= RULE_ID ) )? this_EOL_16= RULE_EOL ) | ( () otherlv_18= 'continue' ( (lv_name_19_0= RULE_ID ) )? this_EOL_20= RULE_EOL ) | ( () this_EOL_22= RULE_EOL ) | ( ( (lv_variableDeclarator_23_0= ruleVariable_declarator ) ) this_EOL_24= RULE_EOL ) ) )
            // InternalJava.g:3970:1: ( ( (lv_returnSmt_0_0= ruleReturn_Statement ) ) | ( (lv_variable_1_0= ruleVariable_declaration ) ) | ( (lv_expressionx_2_0= ruleExpression ) ) | ( (lv_ifStatement_3_0= ruleIf_Statement ) ) | ( (lv_doStatement_4_0= ruleDo_Statement ) ) | ( (lv_whileStatement_5_0= ruleWhile_Statement ) ) | ( (lv_forStatement_6_0= ruleFor_Statement ) ) | ( (lv_switchStatement_7_0= ruleSwitch_Statement ) ) | ( ( ( ( ruleStatement_block ) ) )=> ( (lv_statementBlock_8_0= ruleStatement_block ) ) ) | ( (lv_try_9_0= ruleTry_statement ) ) | ( ( (lv_name_10_0= RULE_ID ) ) this_COLON_11= RULE_COLON ( (lv_statement_12_0= ruleStatement ) ) ) | ( () otherlv_14= 'break' ( (lv_name_15_0= RULE_ID ) )? this_EOL_16= RULE_EOL ) | ( () otherlv_18= 'continue' ( (lv_name_19_0= RULE_ID ) )? this_EOL_20= RULE_EOL ) | ( () this_EOL_22= RULE_EOL ) | ( ( (lv_variableDeclarator_23_0= ruleVariable_declarator ) ) this_EOL_24= RULE_EOL ) )
            {
            // InternalJava.g:3970:1: ( ( (lv_returnSmt_0_0= ruleReturn_Statement ) ) | ( (lv_variable_1_0= ruleVariable_declaration ) ) | ( (lv_expressionx_2_0= ruleExpression ) ) | ( (lv_ifStatement_3_0= ruleIf_Statement ) ) | ( (lv_doStatement_4_0= ruleDo_Statement ) ) | ( (lv_whileStatement_5_0= ruleWhile_Statement ) ) | ( (lv_forStatement_6_0= ruleFor_Statement ) ) | ( (lv_switchStatement_7_0= ruleSwitch_Statement ) ) | ( ( ( ( ruleStatement_block ) ) )=> ( (lv_statementBlock_8_0= ruleStatement_block ) ) ) | ( (lv_try_9_0= ruleTry_statement ) ) | ( ( (lv_name_10_0= RULE_ID ) ) this_COLON_11= RULE_COLON ( (lv_statement_12_0= ruleStatement ) ) ) | ( () otherlv_14= 'break' ( (lv_name_15_0= RULE_ID ) )? this_EOL_16= RULE_EOL ) | ( () otherlv_18= 'continue' ( (lv_name_19_0= RULE_ID ) )? this_EOL_20= RULE_EOL ) | ( () this_EOL_22= RULE_EOL ) | ( ( (lv_variableDeclarator_23_0= ruleVariable_declarator ) ) this_EOL_24= RULE_EOL ) )
            int alt64=15;
            alt64 = dfa64.predict(input);
            switch (alt64) {
                case 1 :
                    // InternalJava.g:3970:2: ( (lv_returnSmt_0_0= ruleReturn_Statement ) )
                    {
                    // InternalJava.g:3970:2: ( (lv_returnSmt_0_0= ruleReturn_Statement ) )
                    // InternalJava.g:3971:1: (lv_returnSmt_0_0= ruleReturn_Statement )
                    {
                    // InternalJava.g:3971:1: (lv_returnSmt_0_0= ruleReturn_Statement )
                    // InternalJava.g:3972:3: lv_returnSmt_0_0= ruleReturn_Statement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStatementAccess().getReturnSmtReturn_StatementParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_returnSmt_0_0=ruleReturn_Statement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getStatementRule());
                      	        }
                             		set(
                             			current, 
                             			"returnSmt",
                              		lv_returnSmt_0_0, 
                              		"org.xtext.java.Java.Return_Statement");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalJava.g:3989:6: ( (lv_variable_1_0= ruleVariable_declaration ) )
                    {
                    // InternalJava.g:3989:6: ( (lv_variable_1_0= ruleVariable_declaration ) )
                    // InternalJava.g:3990:1: (lv_variable_1_0= ruleVariable_declaration )
                    {
                    // InternalJava.g:3990:1: (lv_variable_1_0= ruleVariable_declaration )
                    // InternalJava.g:3991:3: lv_variable_1_0= ruleVariable_declaration
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStatementAccess().getVariableVariable_declarationParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_variable_1_0=ruleVariable_declaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getStatementRule());
                      	        }
                             		set(
                             			current, 
                             			"variable",
                              		lv_variable_1_0, 
                              		"org.xtext.java.Java.Variable_declaration");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalJava.g:4008:6: ( (lv_expressionx_2_0= ruleExpression ) )
                    {
                    // InternalJava.g:4008:6: ( (lv_expressionx_2_0= ruleExpression ) )
                    // InternalJava.g:4009:1: (lv_expressionx_2_0= ruleExpression )
                    {
                    // InternalJava.g:4009:1: (lv_expressionx_2_0= ruleExpression )
                    // InternalJava.g:4010:3: lv_expressionx_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStatementAccess().getExpressionxExpressionParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_expressionx_2_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getStatementRule());
                      	        }
                             		set(
                             			current, 
                             			"expressionx",
                              		lv_expressionx_2_0, 
                              		"org.xtext.java.Java.Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalJava.g:4027:6: ( (lv_ifStatement_3_0= ruleIf_Statement ) )
                    {
                    // InternalJava.g:4027:6: ( (lv_ifStatement_3_0= ruleIf_Statement ) )
                    // InternalJava.g:4028:1: (lv_ifStatement_3_0= ruleIf_Statement )
                    {
                    // InternalJava.g:4028:1: (lv_ifStatement_3_0= ruleIf_Statement )
                    // InternalJava.g:4029:3: lv_ifStatement_3_0= ruleIf_Statement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStatementAccess().getIfStatementIf_StatementParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_ifStatement_3_0=ruleIf_Statement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getStatementRule());
                      	        }
                             		set(
                             			current, 
                             			"ifStatement",
                              		lv_ifStatement_3_0, 
                              		"org.xtext.java.Java.If_Statement");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalJava.g:4046:6: ( (lv_doStatement_4_0= ruleDo_Statement ) )
                    {
                    // InternalJava.g:4046:6: ( (lv_doStatement_4_0= ruleDo_Statement ) )
                    // InternalJava.g:4047:1: (lv_doStatement_4_0= ruleDo_Statement )
                    {
                    // InternalJava.g:4047:1: (lv_doStatement_4_0= ruleDo_Statement )
                    // InternalJava.g:4048:3: lv_doStatement_4_0= ruleDo_Statement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStatementAccess().getDoStatementDo_StatementParserRuleCall_4_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_doStatement_4_0=ruleDo_Statement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getStatementRule());
                      	        }
                             		set(
                             			current, 
                             			"doStatement",
                              		lv_doStatement_4_0, 
                              		"org.xtext.java.Java.Do_Statement");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalJava.g:4065:6: ( (lv_whileStatement_5_0= ruleWhile_Statement ) )
                    {
                    // InternalJava.g:4065:6: ( (lv_whileStatement_5_0= ruleWhile_Statement ) )
                    // InternalJava.g:4066:1: (lv_whileStatement_5_0= ruleWhile_Statement )
                    {
                    // InternalJava.g:4066:1: (lv_whileStatement_5_0= ruleWhile_Statement )
                    // InternalJava.g:4067:3: lv_whileStatement_5_0= ruleWhile_Statement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStatementAccess().getWhileStatementWhile_StatementParserRuleCall_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_whileStatement_5_0=ruleWhile_Statement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getStatementRule());
                      	        }
                             		set(
                             			current, 
                             			"whileStatement",
                              		lv_whileStatement_5_0, 
                              		"org.xtext.java.Java.While_Statement");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalJava.g:4084:6: ( (lv_forStatement_6_0= ruleFor_Statement ) )
                    {
                    // InternalJava.g:4084:6: ( (lv_forStatement_6_0= ruleFor_Statement ) )
                    // InternalJava.g:4085:1: (lv_forStatement_6_0= ruleFor_Statement )
                    {
                    // InternalJava.g:4085:1: (lv_forStatement_6_0= ruleFor_Statement )
                    // InternalJava.g:4086:3: lv_forStatement_6_0= ruleFor_Statement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStatementAccess().getForStatementFor_StatementParserRuleCall_6_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_forStatement_6_0=ruleFor_Statement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getStatementRule());
                      	        }
                             		set(
                             			current, 
                             			"forStatement",
                              		lv_forStatement_6_0, 
                              		"org.xtext.java.Java.For_Statement");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 8 :
                    // InternalJava.g:4103:6: ( (lv_switchStatement_7_0= ruleSwitch_Statement ) )
                    {
                    // InternalJava.g:4103:6: ( (lv_switchStatement_7_0= ruleSwitch_Statement ) )
                    // InternalJava.g:4104:1: (lv_switchStatement_7_0= ruleSwitch_Statement )
                    {
                    // InternalJava.g:4104:1: (lv_switchStatement_7_0= ruleSwitch_Statement )
                    // InternalJava.g:4105:3: lv_switchStatement_7_0= ruleSwitch_Statement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStatementAccess().getSwitchStatementSwitch_StatementParserRuleCall_7_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_switchStatement_7_0=ruleSwitch_Statement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getStatementRule());
                      	        }
                             		set(
                             			current, 
                             			"switchStatement",
                              		lv_switchStatement_7_0, 
                              		"org.xtext.java.Java.Switch_Statement");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 9 :
                    // InternalJava.g:4122:6: ( ( ( ( ruleStatement_block ) ) )=> ( (lv_statementBlock_8_0= ruleStatement_block ) ) )
                    {
                    // InternalJava.g:4122:6: ( ( ( ( ruleStatement_block ) ) )=> ( (lv_statementBlock_8_0= ruleStatement_block ) ) )
                    // InternalJava.g:4122:7: ( ( ( ruleStatement_block ) ) )=> ( (lv_statementBlock_8_0= ruleStatement_block ) )
                    {
                    // InternalJava.g:4126:5: ( (lv_statementBlock_8_0= ruleStatement_block ) )
                    // InternalJava.g:4127:1: (lv_statementBlock_8_0= ruleStatement_block )
                    {
                    // InternalJava.g:4127:1: (lv_statementBlock_8_0= ruleStatement_block )
                    // InternalJava.g:4128:3: lv_statementBlock_8_0= ruleStatement_block
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStatementAccess().getStatementBlockStatement_blockParserRuleCall_8_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_statementBlock_8_0=ruleStatement_block();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getStatementRule());
                      	        }
                             		set(
                             			current, 
                             			"statementBlock",
                              		lv_statementBlock_8_0, 
                              		"org.xtext.java.Java.Statement_block");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 10 :
                    // InternalJava.g:4145:6: ( (lv_try_9_0= ruleTry_statement ) )
                    {
                    // InternalJava.g:4145:6: ( (lv_try_9_0= ruleTry_statement ) )
                    // InternalJava.g:4146:1: (lv_try_9_0= ruleTry_statement )
                    {
                    // InternalJava.g:4146:1: (lv_try_9_0= ruleTry_statement )
                    // InternalJava.g:4147:3: lv_try_9_0= ruleTry_statement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStatementAccess().getTryTry_statementParserRuleCall_9_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_try_9_0=ruleTry_statement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getStatementRule());
                      	        }
                             		set(
                             			current, 
                             			"try",
                              		lv_try_9_0, 
                              		"org.xtext.java.Java.Try_statement");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 11 :
                    // InternalJava.g:4164:6: ( ( (lv_name_10_0= RULE_ID ) ) this_COLON_11= RULE_COLON ( (lv_statement_12_0= ruleStatement ) ) )
                    {
                    // InternalJava.g:4164:6: ( ( (lv_name_10_0= RULE_ID ) ) this_COLON_11= RULE_COLON ( (lv_statement_12_0= ruleStatement ) ) )
                    // InternalJava.g:4164:7: ( (lv_name_10_0= RULE_ID ) ) this_COLON_11= RULE_COLON ( (lv_statement_12_0= ruleStatement ) )
                    {
                    // InternalJava.g:4164:7: ( (lv_name_10_0= RULE_ID ) )
                    // InternalJava.g:4165:1: (lv_name_10_0= RULE_ID )
                    {
                    // InternalJava.g:4165:1: (lv_name_10_0= RULE_ID )
                    // InternalJava.g:4166:3: lv_name_10_0= RULE_ID
                    {
                    lv_name_10_0=(Token)match(input,RULE_ID,FOLLOW_36); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_10_0, grammarAccess.getStatementAccess().getNameIDTerminalRuleCall_10_0_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getStatementRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_10_0, 
                              		"org.xtext.java.Java.ID");
                      	    
                    }

                    }


                    }

                    this_COLON_11=(Token)match(input,RULE_COLON,FOLLOW_42); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_COLON_11, grammarAccess.getStatementAccess().getCOLONTerminalRuleCall_10_1()); 
                          
                    }
                    // InternalJava.g:4186:1: ( (lv_statement_12_0= ruleStatement ) )
                    // InternalJava.g:4187:1: (lv_statement_12_0= ruleStatement )
                    {
                    // InternalJava.g:4187:1: (lv_statement_12_0= ruleStatement )
                    // InternalJava.g:4188:3: lv_statement_12_0= ruleStatement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStatementAccess().getStatementStatementParserRuleCall_10_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_statement_12_0=ruleStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getStatementRule());
                      	        }
                             		set(
                             			current, 
                             			"statement",
                              		lv_statement_12_0, 
                              		"org.xtext.java.Java.Statement");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 12 :
                    // InternalJava.g:4205:6: ( () otherlv_14= 'break' ( (lv_name_15_0= RULE_ID ) )? this_EOL_16= RULE_EOL )
                    {
                    // InternalJava.g:4205:6: ( () otherlv_14= 'break' ( (lv_name_15_0= RULE_ID ) )? this_EOL_16= RULE_EOL )
                    // InternalJava.g:4205:7: () otherlv_14= 'break' ( (lv_name_15_0= RULE_ID ) )? this_EOL_16= RULE_EOL
                    {
                    // InternalJava.g:4205:7: ()
                    // InternalJava.g:4206:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getStatementAccess().getStatementAction_11_0(),
                                  current);
                          
                    }

                    }

                    otherlv_14=(Token)match(input,93,FOLLOW_43); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_14, grammarAccess.getStatementAccess().getBreakKeyword_11_1());
                          
                    }
                    // InternalJava.g:4218:1: ( (lv_name_15_0= RULE_ID ) )?
                    int alt62=2;
                    int LA62_0 = input.LA(1);

                    if ( (LA62_0==RULE_ID) ) {
                        alt62=1;
                    }
                    switch (alt62) {
                        case 1 :
                            // InternalJava.g:4219:1: (lv_name_15_0= RULE_ID )
                            {
                            // InternalJava.g:4219:1: (lv_name_15_0= RULE_ID )
                            // InternalJava.g:4220:3: lv_name_15_0= RULE_ID
                            {
                            lv_name_15_0=(Token)match(input,RULE_ID,FOLLOW_44); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_name_15_0, grammarAccess.getStatementAccess().getNameIDTerminalRuleCall_11_2_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getStatementRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"name",
                                      		lv_name_15_0, 
                                      		"org.xtext.java.Java.ID");
                              	    
                            }

                            }


                            }
                            break;

                    }

                    this_EOL_16=(Token)match(input,RULE_EOL,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_EOL_16, grammarAccess.getStatementAccess().getEOLTerminalRuleCall_11_3()); 
                          
                    }

                    }


                    }
                    break;
                case 13 :
                    // InternalJava.g:4241:6: ( () otherlv_18= 'continue' ( (lv_name_19_0= RULE_ID ) )? this_EOL_20= RULE_EOL )
                    {
                    // InternalJava.g:4241:6: ( () otherlv_18= 'continue' ( (lv_name_19_0= RULE_ID ) )? this_EOL_20= RULE_EOL )
                    // InternalJava.g:4241:7: () otherlv_18= 'continue' ( (lv_name_19_0= RULE_ID ) )? this_EOL_20= RULE_EOL
                    {
                    // InternalJava.g:4241:7: ()
                    // InternalJava.g:4242:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getStatementAccess().getStatementAction_12_0(),
                                  current);
                          
                    }

                    }

                    otherlv_18=(Token)match(input,94,FOLLOW_43); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_18, grammarAccess.getStatementAccess().getContinueKeyword_12_1());
                          
                    }
                    // InternalJava.g:4254:1: ( (lv_name_19_0= RULE_ID ) )?
                    int alt63=2;
                    int LA63_0 = input.LA(1);

                    if ( (LA63_0==RULE_ID) ) {
                        alt63=1;
                    }
                    switch (alt63) {
                        case 1 :
                            // InternalJava.g:4255:1: (lv_name_19_0= RULE_ID )
                            {
                            // InternalJava.g:4255:1: (lv_name_19_0= RULE_ID )
                            // InternalJava.g:4256:3: lv_name_19_0= RULE_ID
                            {
                            lv_name_19_0=(Token)match(input,RULE_ID,FOLLOW_44); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_name_19_0, grammarAccess.getStatementAccess().getNameIDTerminalRuleCall_12_2_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getStatementRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"name",
                                      		lv_name_19_0, 
                                      		"org.xtext.java.Java.ID");
                              	    
                            }

                            }


                            }
                            break;

                    }

                    this_EOL_20=(Token)match(input,RULE_EOL,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_EOL_20, grammarAccess.getStatementAccess().getEOLTerminalRuleCall_12_3()); 
                          
                    }

                    }


                    }
                    break;
                case 14 :
                    // InternalJava.g:4277:6: ( () this_EOL_22= RULE_EOL )
                    {
                    // InternalJava.g:4277:6: ( () this_EOL_22= RULE_EOL )
                    // InternalJava.g:4277:7: () this_EOL_22= RULE_EOL
                    {
                    // InternalJava.g:4277:7: ()
                    // InternalJava.g:4278:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getStatementAccess().getStatementAction_13_0(),
                                  current);
                          
                    }

                    }

                    this_EOL_22=(Token)match(input,RULE_EOL,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_EOL_22, grammarAccess.getStatementAccess().getEOLTerminalRuleCall_13_1()); 
                          
                    }

                    }


                    }
                    break;
                case 15 :
                    // InternalJava.g:4291:6: ( ( (lv_variableDeclarator_23_0= ruleVariable_declarator ) ) this_EOL_24= RULE_EOL )
                    {
                    // InternalJava.g:4291:6: ( ( (lv_variableDeclarator_23_0= ruleVariable_declarator ) ) this_EOL_24= RULE_EOL )
                    // InternalJava.g:4291:7: ( (lv_variableDeclarator_23_0= ruleVariable_declarator ) ) this_EOL_24= RULE_EOL
                    {
                    // InternalJava.g:4291:7: ( (lv_variableDeclarator_23_0= ruleVariable_declarator ) )
                    // InternalJava.g:4292:1: (lv_variableDeclarator_23_0= ruleVariable_declarator )
                    {
                    // InternalJava.g:4292:1: (lv_variableDeclarator_23_0= ruleVariable_declarator )
                    // InternalJava.g:4293:3: lv_variableDeclarator_23_0= ruleVariable_declarator
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getStatementAccess().getVariableDeclaratorVariable_declaratorParserRuleCall_14_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_44);
                    lv_variableDeclarator_23_0=ruleVariable_declarator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getStatementRule());
                      	        }
                             		set(
                             			current, 
                             			"variableDeclarator",
                              		lv_variableDeclarator_23_0, 
                              		"org.xtext.java.Java.Variable_declarator");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    this_EOL_24=(Token)match(input,RULE_EOL,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_EOL_24, grammarAccess.getStatementAccess().getEOLTerminalRuleCall_14_1()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStatement"


    // $ANTLR start "entryRuleSwitch_Statement"
    // InternalJava.g:4321:1: entryRuleSwitch_Statement returns [EObject current=null] : iv_ruleSwitch_Statement= ruleSwitch_Statement EOF ;
    public final EObject entryRuleSwitch_Statement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSwitch_Statement = null;


        try {
            // InternalJava.g:4322:2: (iv_ruleSwitch_Statement= ruleSwitch_Statement EOF )
            // InternalJava.g:4323:2: iv_ruleSwitch_Statement= ruleSwitch_Statement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSwitch_StatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSwitch_Statement=ruleSwitch_Statement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSwitch_Statement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSwitch_Statement"


    // $ANTLR start "ruleSwitch_Statement"
    // InternalJava.g:4330:1: ruleSwitch_Statement returns [EObject current=null] : ( () this_SWITCH_1= RULE_SWITCH otherlv_2= '(' ( (lv_sw_exp_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= '{' ( (this_CASE_6= RULE_CASE ( (lv_case_exp_7_0= ruleExpression ) ) this_COLON_8= RULE_COLON ) | ( (lv_statements_9_0= ruleStatement ) ) )* (this_DEFAULT_10= RULE_DEFAULT this_COLON_11= RULE_COLON )? ( (this_CASE_12= RULE_CASE ( (lv_case_exp_13_0= ruleExpression ) ) this_COLON_14= RULE_COLON ) | ( (lv_statements_15_0= ruleStatement ) ) )* otherlv_16= '}' ) ;
    public final EObject ruleSwitch_Statement() throws RecognitionException {
        EObject current = null;

        Token this_SWITCH_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token this_CASE_6=null;
        Token this_COLON_8=null;
        Token this_DEFAULT_10=null;
        Token this_COLON_11=null;
        Token this_CASE_12=null;
        Token this_COLON_14=null;
        Token otherlv_16=null;
        EObject lv_sw_exp_3_0 = null;

        EObject lv_case_exp_7_0 = null;

        EObject lv_statements_9_0 = null;

        EObject lv_case_exp_13_0 = null;

        EObject lv_statements_15_0 = null;


         enterRule(); 
            
        try {
            // InternalJava.g:4333:28: ( ( () this_SWITCH_1= RULE_SWITCH otherlv_2= '(' ( (lv_sw_exp_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= '{' ( (this_CASE_6= RULE_CASE ( (lv_case_exp_7_0= ruleExpression ) ) this_COLON_8= RULE_COLON ) | ( (lv_statements_9_0= ruleStatement ) ) )* (this_DEFAULT_10= RULE_DEFAULT this_COLON_11= RULE_COLON )? ( (this_CASE_12= RULE_CASE ( (lv_case_exp_13_0= ruleExpression ) ) this_COLON_14= RULE_COLON ) | ( (lv_statements_15_0= ruleStatement ) ) )* otherlv_16= '}' ) )
            // InternalJava.g:4334:1: ( () this_SWITCH_1= RULE_SWITCH otherlv_2= '(' ( (lv_sw_exp_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= '{' ( (this_CASE_6= RULE_CASE ( (lv_case_exp_7_0= ruleExpression ) ) this_COLON_8= RULE_COLON ) | ( (lv_statements_9_0= ruleStatement ) ) )* (this_DEFAULT_10= RULE_DEFAULT this_COLON_11= RULE_COLON )? ( (this_CASE_12= RULE_CASE ( (lv_case_exp_13_0= ruleExpression ) ) this_COLON_14= RULE_COLON ) | ( (lv_statements_15_0= ruleStatement ) ) )* otherlv_16= '}' )
            {
            // InternalJava.g:4334:1: ( () this_SWITCH_1= RULE_SWITCH otherlv_2= '(' ( (lv_sw_exp_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= '{' ( (this_CASE_6= RULE_CASE ( (lv_case_exp_7_0= ruleExpression ) ) this_COLON_8= RULE_COLON ) | ( (lv_statements_9_0= ruleStatement ) ) )* (this_DEFAULT_10= RULE_DEFAULT this_COLON_11= RULE_COLON )? ( (this_CASE_12= RULE_CASE ( (lv_case_exp_13_0= ruleExpression ) ) this_COLON_14= RULE_COLON ) | ( (lv_statements_15_0= ruleStatement ) ) )* otherlv_16= '}' )
            // InternalJava.g:4334:2: () this_SWITCH_1= RULE_SWITCH otherlv_2= '(' ( (lv_sw_exp_3_0= ruleExpression ) ) otherlv_4= ')' otherlv_5= '{' ( (this_CASE_6= RULE_CASE ( (lv_case_exp_7_0= ruleExpression ) ) this_COLON_8= RULE_COLON ) | ( (lv_statements_9_0= ruleStatement ) ) )* (this_DEFAULT_10= RULE_DEFAULT this_COLON_11= RULE_COLON )? ( (this_CASE_12= RULE_CASE ( (lv_case_exp_13_0= ruleExpression ) ) this_COLON_14= RULE_COLON ) | ( (lv_statements_15_0= ruleStatement ) ) )* otherlv_16= '}'
            {
            // InternalJava.g:4334:2: ()
            // InternalJava.g:4335:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getSwitch_StatementAccess().getSwitch_StatementAction_0(),
                          current);
                  
            }

            }

            this_SWITCH_1=(Token)match(input,RULE_SWITCH,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_SWITCH_1, grammarAccess.getSwitch_StatementAccess().getSWITCHTerminalRuleCall_1()); 
                  
            }
            otherlv_2=(Token)match(input,78,FOLLOW_35); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getSwitch_StatementAccess().getLeftParenthesisKeyword_2());
                  
            }
            // InternalJava.g:4351:1: ( (lv_sw_exp_3_0= ruleExpression ) )
            // InternalJava.g:4352:1: (lv_sw_exp_3_0= ruleExpression )
            {
            // InternalJava.g:4352:1: (lv_sw_exp_3_0= ruleExpression )
            // InternalJava.g:4353:3: lv_sw_exp_3_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSwitch_StatementAccess().getSw_expExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_19);
            lv_sw_exp_3_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getSwitch_StatementRule());
              	        }
                     		set(
                     			current, 
                     			"sw_exp",
                      		lv_sw_exp_3_0, 
                      		"org.xtext.java.Java.Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,79,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getSwitch_StatementAccess().getRightParenthesisKeyword_4());
                  
            }
            otherlv_5=(Token)match(input,74,FOLLOW_45); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getSwitch_StatementAccess().getLeftCurlyBracketKeyword_5());
                  
            }
            // InternalJava.g:4377:1: ( (this_CASE_6= RULE_CASE ( (lv_case_exp_7_0= ruleExpression ) ) this_COLON_8= RULE_COLON ) | ( (lv_statements_9_0= ruleStatement ) ) )*
            loop65:
            do {
                int alt65=3;
                alt65 = dfa65.predict(input);
                switch (alt65) {
            	case 1 :
            	    // InternalJava.g:4377:2: (this_CASE_6= RULE_CASE ( (lv_case_exp_7_0= ruleExpression ) ) this_COLON_8= RULE_COLON )
            	    {
            	    // InternalJava.g:4377:2: (this_CASE_6= RULE_CASE ( (lv_case_exp_7_0= ruleExpression ) ) this_COLON_8= RULE_COLON )
            	    // InternalJava.g:4377:3: this_CASE_6= RULE_CASE ( (lv_case_exp_7_0= ruleExpression ) ) this_COLON_8= RULE_COLON
            	    {
            	    this_CASE_6=(Token)match(input,RULE_CASE,FOLLOW_35); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_CASE_6, grammarAccess.getSwitch_StatementAccess().getCASETerminalRuleCall_6_0_0()); 
            	          
            	    }
            	    // InternalJava.g:4381:1: ( (lv_case_exp_7_0= ruleExpression ) )
            	    // InternalJava.g:4382:1: (lv_case_exp_7_0= ruleExpression )
            	    {
            	    // InternalJava.g:4382:1: (lv_case_exp_7_0= ruleExpression )
            	    // InternalJava.g:4383:3: lv_case_exp_7_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSwitch_StatementAccess().getCase_expExpressionParserRuleCall_6_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_36);
            	    lv_case_exp_7_0=ruleExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSwitch_StatementRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"case_exp",
            	              		lv_case_exp_7_0, 
            	              		"org.xtext.java.Java.Expression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    this_COLON_8=(Token)match(input,RULE_COLON,FOLLOW_45); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_COLON_8, grammarAccess.getSwitch_StatementAccess().getCOLONTerminalRuleCall_6_0_2()); 
            	          
            	    }

            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalJava.g:4404:6: ( (lv_statements_9_0= ruleStatement ) )
            	    {
            	    // InternalJava.g:4404:6: ( (lv_statements_9_0= ruleStatement ) )
            	    // InternalJava.g:4405:1: (lv_statements_9_0= ruleStatement )
            	    {
            	    // InternalJava.g:4405:1: (lv_statements_9_0= ruleStatement )
            	    // InternalJava.g:4406:3: lv_statements_9_0= ruleStatement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSwitch_StatementAccess().getStatementsStatementParserRuleCall_6_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_45);
            	    lv_statements_9_0=ruleStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSwitch_StatementRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"statements",
            	              		lv_statements_9_0, 
            	              		"org.xtext.java.Java.Statement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop65;
                }
            } while (true);

            // InternalJava.g:4422:4: (this_DEFAULT_10= RULE_DEFAULT this_COLON_11= RULE_COLON )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==RULE_DEFAULT) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // InternalJava.g:4422:5: this_DEFAULT_10= RULE_DEFAULT this_COLON_11= RULE_COLON
                    {
                    this_DEFAULT_10=(Token)match(input,RULE_DEFAULT,FOLLOW_36); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_DEFAULT_10, grammarAccess.getSwitch_StatementAccess().getDEFAULTTerminalRuleCall_7_0()); 
                          
                    }
                    this_COLON_11=(Token)match(input,RULE_COLON,FOLLOW_46); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_COLON_11, grammarAccess.getSwitch_StatementAccess().getCOLONTerminalRuleCall_7_1()); 
                          
                    }

                    }
                    break;

            }

            // InternalJava.g:4430:3: ( (this_CASE_12= RULE_CASE ( (lv_case_exp_13_0= ruleExpression ) ) this_COLON_14= RULE_COLON ) | ( (lv_statements_15_0= ruleStatement ) ) )*
            loop67:
            do {
                int alt67=3;
                int LA67_0 = input.LA(1);

                if ( (LA67_0==RULE_CASE) ) {
                    alt67=1;
                }
                else if ( (LA67_0==RULE_EOL||LA67_0==RULE_ID||(LA67_0>=RULE_NULL && LA67_0<=RULE_THIS)||(LA67_0>=RULE_INCREMENT && LA67_0<=RULE_DECREMENT)||LA67_0==RULE_MINUS||(LA67_0>=RULE_DECIMAL_DIGITS && LA67_0<=RULE_SWITCH)||(LA67_0>=RULE_FOR && LA67_0<=RULE_IF)||(LA67_0>=RULE_RETURN && LA67_0<=RULE_TRY)||LA67_0==74||LA67_0==78||(LA67_0>=84 && LA67_0<=94)) ) {
                    alt67=2;
                }


                switch (alt67) {
            	case 1 :
            	    // InternalJava.g:4430:4: (this_CASE_12= RULE_CASE ( (lv_case_exp_13_0= ruleExpression ) ) this_COLON_14= RULE_COLON )
            	    {
            	    // InternalJava.g:4430:4: (this_CASE_12= RULE_CASE ( (lv_case_exp_13_0= ruleExpression ) ) this_COLON_14= RULE_COLON )
            	    // InternalJava.g:4430:5: this_CASE_12= RULE_CASE ( (lv_case_exp_13_0= ruleExpression ) ) this_COLON_14= RULE_COLON
            	    {
            	    this_CASE_12=(Token)match(input,RULE_CASE,FOLLOW_35); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_CASE_12, grammarAccess.getSwitch_StatementAccess().getCASETerminalRuleCall_8_0_0()); 
            	          
            	    }
            	    // InternalJava.g:4434:1: ( (lv_case_exp_13_0= ruleExpression ) )
            	    // InternalJava.g:4435:1: (lv_case_exp_13_0= ruleExpression )
            	    {
            	    // InternalJava.g:4435:1: (lv_case_exp_13_0= ruleExpression )
            	    // InternalJava.g:4436:3: lv_case_exp_13_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSwitch_StatementAccess().getCase_expExpressionParserRuleCall_8_0_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_36);
            	    lv_case_exp_13_0=ruleExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSwitch_StatementRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"case_exp",
            	              		lv_case_exp_13_0, 
            	              		"org.xtext.java.Java.Expression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    this_COLON_14=(Token)match(input,RULE_COLON,FOLLOW_46); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_COLON_14, grammarAccess.getSwitch_StatementAccess().getCOLONTerminalRuleCall_8_0_2()); 
            	          
            	    }

            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalJava.g:4457:6: ( (lv_statements_15_0= ruleStatement ) )
            	    {
            	    // InternalJava.g:4457:6: ( (lv_statements_15_0= ruleStatement ) )
            	    // InternalJava.g:4458:1: (lv_statements_15_0= ruleStatement )
            	    {
            	    // InternalJava.g:4458:1: (lv_statements_15_0= ruleStatement )
            	    // InternalJava.g:4459:3: lv_statements_15_0= ruleStatement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSwitch_StatementAccess().getStatementsStatementParserRuleCall_8_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_46);
            	    lv_statements_15_0=ruleStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSwitch_StatementRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"statements",
            	              		lv_statements_15_0, 
            	              		"org.xtext.java.Java.Statement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop67;
                }
            } while (true);

            otherlv_16=(Token)match(input,75,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_16, grammarAccess.getSwitch_StatementAccess().getRightCurlyBracketKeyword_9());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSwitch_Statement"


    // $ANTLR start "entryRuleFor_Statement"
    // InternalJava.g:4487:1: entryRuleFor_Statement returns [EObject current=null] : iv_ruleFor_Statement= ruleFor_Statement EOF ;
    public final EObject entryRuleFor_Statement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFor_Statement = null;


        try {
            // InternalJava.g:4488:2: (iv_ruleFor_Statement= ruleFor_Statement EOF )
            // InternalJava.g:4489:2: iv_ruleFor_Statement= ruleFor_Statement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFor_StatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFor_Statement=ruleFor_Statement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFor_Statement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFor_Statement"


    // $ANTLR start "ruleFor_Statement"
    // InternalJava.g:4496:1: ruleFor_Statement returns [EObject current=null] : (this_FOR_0= RULE_FOR otherlv_1= '(' ( ( (lv_variable_2_0= ruleVariable_declaration ) ) | ( ( (lv_expression_3_0= ruleExpression ) ) this_EOL_4= RULE_EOL ) | ( (lv_pv_5_0= RULE_EOL ) ) ) ( (lv_expression2_6_0= ruleExpression ) )? this_EOL_7= RULE_EOL ( (lv_expression3_8_0= ruleExpression ) )? otherlv_9= ')' ( (lv_statement_10_0= ruleStatement ) ) ) ;
    public final EObject ruleFor_Statement() throws RecognitionException {
        EObject current = null;

        Token this_FOR_0=null;
        Token otherlv_1=null;
        Token this_EOL_4=null;
        Token lv_pv_5_0=null;
        Token this_EOL_7=null;
        Token otherlv_9=null;
        EObject lv_variable_2_0 = null;

        EObject lv_expression_3_0 = null;

        EObject lv_expression2_6_0 = null;

        EObject lv_expression3_8_0 = null;

        EObject lv_statement_10_0 = null;


         enterRule(); 
            
        try {
            // InternalJava.g:4499:28: ( (this_FOR_0= RULE_FOR otherlv_1= '(' ( ( (lv_variable_2_0= ruleVariable_declaration ) ) | ( ( (lv_expression_3_0= ruleExpression ) ) this_EOL_4= RULE_EOL ) | ( (lv_pv_5_0= RULE_EOL ) ) ) ( (lv_expression2_6_0= ruleExpression ) )? this_EOL_7= RULE_EOL ( (lv_expression3_8_0= ruleExpression ) )? otherlv_9= ')' ( (lv_statement_10_0= ruleStatement ) ) ) )
            // InternalJava.g:4500:1: (this_FOR_0= RULE_FOR otherlv_1= '(' ( ( (lv_variable_2_0= ruleVariable_declaration ) ) | ( ( (lv_expression_3_0= ruleExpression ) ) this_EOL_4= RULE_EOL ) | ( (lv_pv_5_0= RULE_EOL ) ) ) ( (lv_expression2_6_0= ruleExpression ) )? this_EOL_7= RULE_EOL ( (lv_expression3_8_0= ruleExpression ) )? otherlv_9= ')' ( (lv_statement_10_0= ruleStatement ) ) )
            {
            // InternalJava.g:4500:1: (this_FOR_0= RULE_FOR otherlv_1= '(' ( ( (lv_variable_2_0= ruleVariable_declaration ) ) | ( ( (lv_expression_3_0= ruleExpression ) ) this_EOL_4= RULE_EOL ) | ( (lv_pv_5_0= RULE_EOL ) ) ) ( (lv_expression2_6_0= ruleExpression ) )? this_EOL_7= RULE_EOL ( (lv_expression3_8_0= ruleExpression ) )? otherlv_9= ')' ( (lv_statement_10_0= ruleStatement ) ) )
            // InternalJava.g:4500:2: this_FOR_0= RULE_FOR otherlv_1= '(' ( ( (lv_variable_2_0= ruleVariable_declaration ) ) | ( ( (lv_expression_3_0= ruleExpression ) ) this_EOL_4= RULE_EOL ) | ( (lv_pv_5_0= RULE_EOL ) ) ) ( (lv_expression2_6_0= ruleExpression ) )? this_EOL_7= RULE_EOL ( (lv_expression3_8_0= ruleExpression ) )? otherlv_9= ')' ( (lv_statement_10_0= ruleStatement ) )
            {
            this_FOR_0=(Token)match(input,RULE_FOR,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_FOR_0, grammarAccess.getFor_StatementAccess().getFORTerminalRuleCall_0()); 
                  
            }
            otherlv_1=(Token)match(input,78,FOLLOW_47); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFor_StatementAccess().getLeftParenthesisKeyword_1());
                  
            }
            // InternalJava.g:4508:1: ( ( (lv_variable_2_0= ruleVariable_declaration ) ) | ( ( (lv_expression_3_0= ruleExpression ) ) this_EOL_4= RULE_EOL ) | ( (lv_pv_5_0= RULE_EOL ) ) )
            int alt68=3;
            alt68 = dfa68.predict(input);
            switch (alt68) {
                case 1 :
                    // InternalJava.g:4508:2: ( (lv_variable_2_0= ruleVariable_declaration ) )
                    {
                    // InternalJava.g:4508:2: ( (lv_variable_2_0= ruleVariable_declaration ) )
                    // InternalJava.g:4509:1: (lv_variable_2_0= ruleVariable_declaration )
                    {
                    // InternalJava.g:4509:1: (lv_variable_2_0= ruleVariable_declaration )
                    // InternalJava.g:4510:3: lv_variable_2_0= ruleVariable_declaration
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFor_StatementAccess().getVariableVariable_declarationParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_48);
                    lv_variable_2_0=ruleVariable_declaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getFor_StatementRule());
                      	        }
                             		set(
                             			current, 
                             			"variable",
                              		lv_variable_2_0, 
                              		"org.xtext.java.Java.Variable_declaration");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalJava.g:4527:6: ( ( (lv_expression_3_0= ruleExpression ) ) this_EOL_4= RULE_EOL )
                    {
                    // InternalJava.g:4527:6: ( ( (lv_expression_3_0= ruleExpression ) ) this_EOL_4= RULE_EOL )
                    // InternalJava.g:4527:7: ( (lv_expression_3_0= ruleExpression ) ) this_EOL_4= RULE_EOL
                    {
                    // InternalJava.g:4527:7: ( (lv_expression_3_0= ruleExpression ) )
                    // InternalJava.g:4528:1: (lv_expression_3_0= ruleExpression )
                    {
                    // InternalJava.g:4528:1: (lv_expression_3_0= ruleExpression )
                    // InternalJava.g:4529:3: lv_expression_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFor_StatementAccess().getExpressionExpressionParserRuleCall_2_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_44);
                    lv_expression_3_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getFor_StatementRule());
                      	        }
                             		set(
                             			current, 
                             			"expression",
                              		lv_expression_3_0, 
                              		"org.xtext.java.Java.Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    this_EOL_4=(Token)match(input,RULE_EOL,FOLLOW_48); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_EOL_4, grammarAccess.getFor_StatementAccess().getEOLTerminalRuleCall_2_1_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalJava.g:4550:6: ( (lv_pv_5_0= RULE_EOL ) )
                    {
                    // InternalJava.g:4550:6: ( (lv_pv_5_0= RULE_EOL ) )
                    // InternalJava.g:4551:1: (lv_pv_5_0= RULE_EOL )
                    {
                    // InternalJava.g:4551:1: (lv_pv_5_0= RULE_EOL )
                    // InternalJava.g:4552:3: lv_pv_5_0= RULE_EOL
                    {
                    lv_pv_5_0=(Token)match(input,RULE_EOL,FOLLOW_48); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_pv_5_0, grammarAccess.getFor_StatementAccess().getPvEOLTerminalRuleCall_2_2_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getFor_StatementRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"pv",
                              		lv_pv_5_0, 
                              		"org.xtext.java.Java.EOL");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalJava.g:4568:3: ( (lv_expression2_6_0= ruleExpression ) )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==RULE_ID||(LA69_0>=RULE_NULL && LA69_0<=RULE_THIS)||(LA69_0>=RULE_INCREMENT && LA69_0<=RULE_DECREMENT)||LA69_0==RULE_MINUS||(LA69_0>=RULE_DECIMAL_DIGITS && LA69_0<=RULE_FALSE)||LA69_0==78) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalJava.g:4569:1: (lv_expression2_6_0= ruleExpression )
                    {
                    // InternalJava.g:4569:1: (lv_expression2_6_0= ruleExpression )
                    // InternalJava.g:4570:3: lv_expression2_6_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFor_StatementAccess().getExpression2ExpressionParserRuleCall_3_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_44);
                    lv_expression2_6_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getFor_StatementRule());
                      	        }
                             		set(
                             			current, 
                             			"expression2",
                              		lv_expression2_6_0, 
                              		"org.xtext.java.Java.Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            this_EOL_7=(Token)match(input,RULE_EOL,FOLLOW_34); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_EOL_7, grammarAccess.getFor_StatementAccess().getEOLTerminalRuleCall_4()); 
                  
            }
            // InternalJava.g:4590:1: ( (lv_expression3_8_0= ruleExpression ) )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==RULE_ID||(LA70_0>=RULE_NULL && LA70_0<=RULE_THIS)||(LA70_0>=RULE_INCREMENT && LA70_0<=RULE_DECREMENT)||LA70_0==RULE_MINUS||(LA70_0>=RULE_DECIMAL_DIGITS && LA70_0<=RULE_FALSE)||LA70_0==78) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // InternalJava.g:4591:1: (lv_expression3_8_0= ruleExpression )
                    {
                    // InternalJava.g:4591:1: (lv_expression3_8_0= ruleExpression )
                    // InternalJava.g:4592:3: lv_expression3_8_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFor_StatementAccess().getExpression3ExpressionParserRuleCall_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_19);
                    lv_expression3_8_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getFor_StatementRule());
                      	        }
                             		set(
                             			current, 
                             			"expression3",
                              		lv_expression3_8_0, 
                              		"org.xtext.java.Java.Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,79,FOLLOW_42); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_9, grammarAccess.getFor_StatementAccess().getRightParenthesisKeyword_6());
                  
            }
            // InternalJava.g:4612:1: ( (lv_statement_10_0= ruleStatement ) )
            // InternalJava.g:4613:1: (lv_statement_10_0= ruleStatement )
            {
            // InternalJava.g:4613:1: (lv_statement_10_0= ruleStatement )
            // InternalJava.g:4614:3: lv_statement_10_0= ruleStatement
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFor_StatementAccess().getStatementStatementParserRuleCall_7_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_statement_10_0=ruleStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFor_StatementRule());
              	        }
                     		set(
                     			current, 
                     			"statement",
                      		lv_statement_10_0, 
                      		"org.xtext.java.Java.Statement");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFor_Statement"


    // $ANTLR start "entryRuleWhile_Statement"
    // InternalJava.g:4638:1: entryRuleWhile_Statement returns [EObject current=null] : iv_ruleWhile_Statement= ruleWhile_Statement EOF ;
    public final EObject entryRuleWhile_Statement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhile_Statement = null;


        try {
            // InternalJava.g:4639:2: (iv_ruleWhile_Statement= ruleWhile_Statement EOF )
            // InternalJava.g:4640:2: iv_ruleWhile_Statement= ruleWhile_Statement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getWhile_StatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleWhile_Statement=ruleWhile_Statement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleWhile_Statement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWhile_Statement"


    // $ANTLR start "ruleWhile_Statement"
    // InternalJava.g:4647:1: ruleWhile_Statement returns [EObject current=null] : (this_WHILE_0= RULE_WHILE otherlv_1= '(' ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_statement_4_0= ruleStatement ) ) ) ;
    public final EObject ruleWhile_Statement() throws RecognitionException {
        EObject current = null;

        Token this_WHILE_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_expression_2_0 = null;

        EObject lv_statement_4_0 = null;


         enterRule(); 
            
        try {
            // InternalJava.g:4650:28: ( (this_WHILE_0= RULE_WHILE otherlv_1= '(' ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_statement_4_0= ruleStatement ) ) ) )
            // InternalJava.g:4651:1: (this_WHILE_0= RULE_WHILE otherlv_1= '(' ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_statement_4_0= ruleStatement ) ) )
            {
            // InternalJava.g:4651:1: (this_WHILE_0= RULE_WHILE otherlv_1= '(' ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_statement_4_0= ruleStatement ) ) )
            // InternalJava.g:4651:2: this_WHILE_0= RULE_WHILE otherlv_1= '(' ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_statement_4_0= ruleStatement ) )
            {
            this_WHILE_0=(Token)match(input,RULE_WHILE,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_WHILE_0, grammarAccess.getWhile_StatementAccess().getWHILETerminalRuleCall_0()); 
                  
            }
            otherlv_1=(Token)match(input,78,FOLLOW_35); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getWhile_StatementAccess().getLeftParenthesisKeyword_1());
                  
            }
            // InternalJava.g:4659:1: ( (lv_expression_2_0= ruleExpression ) )
            // InternalJava.g:4660:1: (lv_expression_2_0= ruleExpression )
            {
            // InternalJava.g:4660:1: (lv_expression_2_0= ruleExpression )
            // InternalJava.g:4661:3: lv_expression_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getWhile_StatementAccess().getExpressionExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_19);
            lv_expression_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getWhile_StatementRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_2_0, 
                      		"org.xtext.java.Java.Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,79,FOLLOW_42); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getWhile_StatementAccess().getRightParenthesisKeyword_3());
                  
            }
            // InternalJava.g:4681:1: ( (lv_statement_4_0= ruleStatement ) )
            // InternalJava.g:4682:1: (lv_statement_4_0= ruleStatement )
            {
            // InternalJava.g:4682:1: (lv_statement_4_0= ruleStatement )
            // InternalJava.g:4683:3: lv_statement_4_0= ruleStatement
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getWhile_StatementAccess().getStatementStatementParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_2);
            lv_statement_4_0=ruleStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getWhile_StatementRule());
              	        }
                     		set(
                     			current, 
                     			"statement",
                      		lv_statement_4_0, 
                      		"org.xtext.java.Java.Statement");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWhile_Statement"


    // $ANTLR start "entryRuleDo_Statement"
    // InternalJava.g:4707:1: entryRuleDo_Statement returns [EObject current=null] : iv_ruleDo_Statement= ruleDo_Statement EOF ;
    public final EObject entryRuleDo_Statement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDo_Statement = null;


        try {
            // InternalJava.g:4708:2: (iv_ruleDo_Statement= ruleDo_Statement EOF )
            // InternalJava.g:4709:2: iv_ruleDo_Statement= ruleDo_Statement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDo_StatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDo_Statement=ruleDo_Statement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDo_Statement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDo_Statement"


    // $ANTLR start "ruleDo_Statement"
    // InternalJava.g:4716:1: ruleDo_Statement returns [EObject current=null] : (this_DO_0= RULE_DO ( (lv_statement_1_0= ruleStatement ) ) this_WHILE_2= RULE_WHILE otherlv_3= '(' ( (lv_expression_4_0= ruleExpression ) ) otherlv_5= ')' this_EOL_6= RULE_EOL ) ;
    public final EObject ruleDo_Statement() throws RecognitionException {
        EObject current = null;

        Token this_DO_0=null;
        Token this_WHILE_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token this_EOL_6=null;
        EObject lv_statement_1_0 = null;

        EObject lv_expression_4_0 = null;


         enterRule(); 
            
        try {
            // InternalJava.g:4719:28: ( (this_DO_0= RULE_DO ( (lv_statement_1_0= ruleStatement ) ) this_WHILE_2= RULE_WHILE otherlv_3= '(' ( (lv_expression_4_0= ruleExpression ) ) otherlv_5= ')' this_EOL_6= RULE_EOL ) )
            // InternalJava.g:4720:1: (this_DO_0= RULE_DO ( (lv_statement_1_0= ruleStatement ) ) this_WHILE_2= RULE_WHILE otherlv_3= '(' ( (lv_expression_4_0= ruleExpression ) ) otherlv_5= ')' this_EOL_6= RULE_EOL )
            {
            // InternalJava.g:4720:1: (this_DO_0= RULE_DO ( (lv_statement_1_0= ruleStatement ) ) this_WHILE_2= RULE_WHILE otherlv_3= '(' ( (lv_expression_4_0= ruleExpression ) ) otherlv_5= ')' this_EOL_6= RULE_EOL )
            // InternalJava.g:4720:2: this_DO_0= RULE_DO ( (lv_statement_1_0= ruleStatement ) ) this_WHILE_2= RULE_WHILE otherlv_3= '(' ( (lv_expression_4_0= ruleExpression ) ) otherlv_5= ')' this_EOL_6= RULE_EOL
            {
            this_DO_0=(Token)match(input,RULE_DO,FOLLOW_42); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_DO_0, grammarAccess.getDo_StatementAccess().getDOTerminalRuleCall_0()); 
                  
            }
            // InternalJava.g:4724:1: ( (lv_statement_1_0= ruleStatement ) )
            // InternalJava.g:4725:1: (lv_statement_1_0= ruleStatement )
            {
            // InternalJava.g:4725:1: (lv_statement_1_0= ruleStatement )
            // InternalJava.g:4726:3: lv_statement_1_0= ruleStatement
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDo_StatementAccess().getStatementStatementParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_49);
            lv_statement_1_0=ruleStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getDo_StatementRule());
              	        }
                     		set(
                     			current, 
                     			"statement",
                      		lv_statement_1_0, 
                      		"org.xtext.java.Java.Statement");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            this_WHILE_2=(Token)match(input,RULE_WHILE,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_WHILE_2, grammarAccess.getDo_StatementAccess().getWHILETerminalRuleCall_2()); 
                  
            }
            otherlv_3=(Token)match(input,78,FOLLOW_35); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getDo_StatementAccess().getLeftParenthesisKeyword_3());
                  
            }
            // InternalJava.g:4750:1: ( (lv_expression_4_0= ruleExpression ) )
            // InternalJava.g:4751:1: (lv_expression_4_0= ruleExpression )
            {
            // InternalJava.g:4751:1: (lv_expression_4_0= ruleExpression )
            // InternalJava.g:4752:3: lv_expression_4_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDo_StatementAccess().getExpressionExpressionParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_19);
            lv_expression_4_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getDo_StatementRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_4_0, 
                      		"org.xtext.java.Java.Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_5=(Token)match(input,79,FOLLOW_44); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getDo_StatementAccess().getRightParenthesisKeyword_5());
                  
            }
            this_EOL_6=(Token)match(input,RULE_EOL,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_EOL_6, grammarAccess.getDo_StatementAccess().getEOLTerminalRuleCall_6()); 
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDo_Statement"


    // $ANTLR start "entryRuleIf_Statement"
    // InternalJava.g:4784:1: entryRuleIf_Statement returns [EObject current=null] : iv_ruleIf_Statement= ruleIf_Statement EOF ;
    public final EObject entryRuleIf_Statement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIf_Statement = null;


        try {
            // InternalJava.g:4785:2: (iv_ruleIf_Statement= ruleIf_Statement EOF )
            // InternalJava.g:4786:2: iv_ruleIf_Statement= ruleIf_Statement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIf_StatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIf_Statement=ruleIf_Statement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIf_Statement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIf_Statement"


    // $ANTLR start "ruleIf_Statement"
    // InternalJava.g:4793:1: ruleIf_Statement returns [EObject current=null] : (this_IF_0= RULE_IF otherlv_1= '(' ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_statement_4_0= ruleStatement ) ) ( ( ( RULE_ELSE )=>this_ELSE_5= RULE_ELSE ) ( (lv_elseStatement_6_0= ruleStatement ) ) )? ) ;
    public final EObject ruleIf_Statement() throws RecognitionException {
        EObject current = null;

        Token this_IF_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token this_ELSE_5=null;
        EObject lv_expression_2_0 = null;

        EObject lv_statement_4_0 = null;

        EObject lv_elseStatement_6_0 = null;


         enterRule(); 
            
        try {
            // InternalJava.g:4796:28: ( (this_IF_0= RULE_IF otherlv_1= '(' ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_statement_4_0= ruleStatement ) ) ( ( ( RULE_ELSE )=>this_ELSE_5= RULE_ELSE ) ( (lv_elseStatement_6_0= ruleStatement ) ) )? ) )
            // InternalJava.g:4797:1: (this_IF_0= RULE_IF otherlv_1= '(' ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_statement_4_0= ruleStatement ) ) ( ( ( RULE_ELSE )=>this_ELSE_5= RULE_ELSE ) ( (lv_elseStatement_6_0= ruleStatement ) ) )? )
            {
            // InternalJava.g:4797:1: (this_IF_0= RULE_IF otherlv_1= '(' ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_statement_4_0= ruleStatement ) ) ( ( ( RULE_ELSE )=>this_ELSE_5= RULE_ELSE ) ( (lv_elseStatement_6_0= ruleStatement ) ) )? )
            // InternalJava.g:4797:2: this_IF_0= RULE_IF otherlv_1= '(' ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_statement_4_0= ruleStatement ) ) ( ( ( RULE_ELSE )=>this_ELSE_5= RULE_ELSE ) ( (lv_elseStatement_6_0= ruleStatement ) ) )?
            {
            this_IF_0=(Token)match(input,RULE_IF,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_IF_0, grammarAccess.getIf_StatementAccess().getIFTerminalRuleCall_0()); 
                  
            }
            otherlv_1=(Token)match(input,78,FOLLOW_35); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getIf_StatementAccess().getLeftParenthesisKeyword_1());
                  
            }
            // InternalJava.g:4805:1: ( (lv_expression_2_0= ruleExpression ) )
            // InternalJava.g:4806:1: (lv_expression_2_0= ruleExpression )
            {
            // InternalJava.g:4806:1: (lv_expression_2_0= ruleExpression )
            // InternalJava.g:4807:3: lv_expression_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIf_StatementAccess().getExpressionExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_19);
            lv_expression_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getIf_StatementRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_2_0, 
                      		"org.xtext.java.Java.Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,79,FOLLOW_42); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getIf_StatementAccess().getRightParenthesisKeyword_3());
                  
            }
            // InternalJava.g:4827:1: ( (lv_statement_4_0= ruleStatement ) )
            // InternalJava.g:4828:1: (lv_statement_4_0= ruleStatement )
            {
            // InternalJava.g:4828:1: (lv_statement_4_0= ruleStatement )
            // InternalJava.g:4829:3: lv_statement_4_0= ruleStatement
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIf_StatementAccess().getStatementStatementParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_50);
            lv_statement_4_0=ruleStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getIf_StatementRule());
              	        }
                     		set(
                     			current, 
                     			"statement",
                      		lv_statement_4_0, 
                      		"org.xtext.java.Java.Statement");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalJava.g:4845:2: ( ( ( RULE_ELSE )=>this_ELSE_5= RULE_ELSE ) ( (lv_elseStatement_6_0= ruleStatement ) ) )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==RULE_ELSE) ) {
                int LA71_1 = input.LA(2);

                if ( (synpred152_InternalJava()) ) {
                    alt71=1;
                }
            }
            switch (alt71) {
                case 1 :
                    // InternalJava.g:4845:3: ( ( RULE_ELSE )=>this_ELSE_5= RULE_ELSE ) ( (lv_elseStatement_6_0= ruleStatement ) )
                    {
                    // InternalJava.g:4845:3: ( ( RULE_ELSE )=>this_ELSE_5= RULE_ELSE )
                    // InternalJava.g:4845:4: ( RULE_ELSE )=>this_ELSE_5= RULE_ELSE
                    {
                    this_ELSE_5=(Token)match(input,RULE_ELSE,FOLLOW_42); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ELSE_5, grammarAccess.getIf_StatementAccess().getELSETerminalRuleCall_5_0()); 
                          
                    }

                    }

                    // InternalJava.g:4849:2: ( (lv_elseStatement_6_0= ruleStatement ) )
                    // InternalJava.g:4850:1: (lv_elseStatement_6_0= ruleStatement )
                    {
                    // InternalJava.g:4850:1: (lv_elseStatement_6_0= ruleStatement )
                    // InternalJava.g:4851:3: lv_elseStatement_6_0= ruleStatement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getIf_StatementAccess().getElseStatementStatementParserRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_elseStatement_6_0=ruleStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getIf_StatementRule());
                      	        }
                             		set(
                             			current, 
                             			"elseStatement",
                              		lv_elseStatement_6_0, 
                              		"org.xtext.java.Java.Statement");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIf_Statement"


    // $ANTLR start "entryRuleReturn_Statement"
    // InternalJava.g:4875:1: entryRuleReturn_Statement returns [EObject current=null] : iv_ruleReturn_Statement= ruleReturn_Statement EOF ;
    public final EObject entryRuleReturn_Statement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReturn_Statement = null;


        try {
            // InternalJava.g:4876:2: (iv_ruleReturn_Statement= ruleReturn_Statement EOF )
            // InternalJava.g:4877:2: iv_ruleReturn_Statement= ruleReturn_Statement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReturn_StatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleReturn_Statement=ruleReturn_Statement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReturn_Statement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReturn_Statement"


    // $ANTLR start "ruleReturn_Statement"
    // InternalJava.g:4884:1: ruleReturn_Statement returns [EObject current=null] : ( () this_RETURN_1= RULE_RETURN ( (lv_rv_2_0= ruleReturn_value ) )? this_EOL_3= RULE_EOL ) ;
    public final EObject ruleReturn_Statement() throws RecognitionException {
        EObject current = null;

        Token this_RETURN_1=null;
        Token this_EOL_3=null;
        EObject lv_rv_2_0 = null;


         enterRule(); 
            
        try {
            // InternalJava.g:4887:28: ( ( () this_RETURN_1= RULE_RETURN ( (lv_rv_2_0= ruleReturn_value ) )? this_EOL_3= RULE_EOL ) )
            // InternalJava.g:4888:1: ( () this_RETURN_1= RULE_RETURN ( (lv_rv_2_0= ruleReturn_value ) )? this_EOL_3= RULE_EOL )
            {
            // InternalJava.g:4888:1: ( () this_RETURN_1= RULE_RETURN ( (lv_rv_2_0= ruleReturn_value ) )? this_EOL_3= RULE_EOL )
            // InternalJava.g:4888:2: () this_RETURN_1= RULE_RETURN ( (lv_rv_2_0= ruleReturn_value ) )? this_EOL_3= RULE_EOL
            {
            // InternalJava.g:4888:2: ()
            // InternalJava.g:4889:2: 
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getReturn_StatementAccess().getReturn_StatementAction_0(),
                          current);
                  
            }

            }

            this_RETURN_1=(Token)match(input,RULE_RETURN,FOLLOW_51); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_RETURN_1, grammarAccess.getReturn_StatementAccess().getRETURNTerminalRuleCall_1()); 
                  
            }
            // InternalJava.g:4901:1: ( (lv_rv_2_0= ruleReturn_value ) )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==RULE_ID||(LA72_0>=RULE_DECIMAL_DIGITS && LA72_0<=RULE_CHAR)) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // InternalJava.g:4902:1: (lv_rv_2_0= ruleReturn_value )
                    {
                    // InternalJava.g:4902:1: (lv_rv_2_0= ruleReturn_value )
                    // InternalJava.g:4903:3: lv_rv_2_0= ruleReturn_value
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getReturn_StatementAccess().getRvReturn_valueParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_44);
                    lv_rv_2_0=ruleReturn_value();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getReturn_StatementRule());
                      	        }
                             		set(
                             			current, 
                             			"rv",
                              		lv_rv_2_0, 
                              		"org.xtext.java.Java.Return_value");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            this_EOL_3=(Token)match(input,RULE_EOL,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_EOL_3, grammarAccess.getReturn_StatementAccess().getEOLTerminalRuleCall_3()); 
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReturn_Statement"


    // $ANTLR start "entryRuleReturn_value"
    // InternalJava.g:4931:1: entryRuleReturn_value returns [EObject current=null] : iv_ruleReturn_value= ruleReturn_value EOF ;
    public final EObject entryRuleReturn_value() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReturn_value = null;


        try {
            // InternalJava.g:4932:2: (iv_ruleReturn_value= ruleReturn_value EOF )
            // InternalJava.g:4933:2: iv_ruleReturn_value= ruleReturn_value EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReturn_valueRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleReturn_value=ruleReturn_value();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReturn_value; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReturn_value"


    // $ANTLR start "ruleReturn_value"
    // InternalJava.g:4940:1: ruleReturn_value returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) | this_Method_call_1= ruleMethod_call | this_Literal_Expression_2= ruleLiteral_Expression ) ;
    public final EObject ruleReturn_value() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject this_Method_call_1 = null;

        EObject this_Literal_Expression_2 = null;


         enterRule(); 
            
        try {
            // InternalJava.g:4943:28: ( ( ( (lv_name_0_0= RULE_ID ) ) | this_Method_call_1= ruleMethod_call | this_Literal_Expression_2= ruleLiteral_Expression ) )
            // InternalJava.g:4944:1: ( ( (lv_name_0_0= RULE_ID ) ) | this_Method_call_1= ruleMethod_call | this_Literal_Expression_2= ruleLiteral_Expression )
            {
            // InternalJava.g:4944:1: ( ( (lv_name_0_0= RULE_ID ) ) | this_Method_call_1= ruleMethod_call | this_Literal_Expression_2= ruleLiteral_Expression )
            int alt73=3;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==RULE_ID) ) {
                int LA73_1 = input.LA(2);

                if ( (LA73_1==EOF||LA73_1==RULE_EOL) ) {
                    alt73=1;
                }
                else if ( (LA73_1==78) ) {
                    alt73=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 73, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA73_0>=RULE_DECIMAL_DIGITS && LA73_0<=RULE_CHAR)) ) {
                alt73=3;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                throw nvae;
            }
            switch (alt73) {
                case 1 :
                    // InternalJava.g:4944:2: ( (lv_name_0_0= RULE_ID ) )
                    {
                    // InternalJava.g:4944:2: ( (lv_name_0_0= RULE_ID ) )
                    // InternalJava.g:4945:1: (lv_name_0_0= RULE_ID )
                    {
                    // InternalJava.g:4945:1: (lv_name_0_0= RULE_ID )
                    // InternalJava.g:4946:3: lv_name_0_0= RULE_ID
                    {
                    lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_0_0, grammarAccess.getReturn_valueAccess().getNameIDTerminalRuleCall_0_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getReturn_valueRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_0_0, 
                              		"org.xtext.java.Java.ID");
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalJava.g:4964:2: this_Method_call_1= ruleMethod_call
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getReturn_valueAccess().getMethod_callParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_Method_call_1=ruleMethod_call();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Method_call_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // InternalJava.g:4977:2: this_Literal_Expression_2= ruleLiteral_Expression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getReturn_valueAccess().getLiteral_ExpressionParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_2);
                    this_Literal_Expression_2=ruleLiteral_Expression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_Literal_Expression_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReturn_value"


    // $ANTLR start "entryRuleTry_statement"
    // InternalJava.g:4996:1: entryRuleTry_statement returns [EObject current=null] : iv_ruleTry_statement= ruleTry_statement EOF ;
    public final EObject entryRuleTry_statement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTry_statement = null;


        try {
            // InternalJava.g:4997:2: (iv_ruleTry_statement= ruleTry_statement EOF )
            // InternalJava.g:4998:2: iv_ruleTry_statement= ruleTry_statement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTry_statementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTry_statement=ruleTry_statement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTry_statement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTry_statement"


    // $ANTLR start "ruleTry_statement"
    // InternalJava.g:5005:1: ruleTry_statement returns [EObject current=null] : ( ( (lv_try_0_0= RULE_TRY ) ) ( (lv_tryStatement_1_0= ruleStatement ) ) ( ( ( ( RULE_CATCH ) )=> (lv_catchs_2_0= RULE_CATCH ) ) otherlv_3= '(' ( (lv_parameters_4_0= ruleParameter ) ) otherlv_5= ')' ( (lv_catchStatements_6_0= ruleStatement ) ) )* ( ( ( ( RULE_FINALLY ) )=> (lv_finally_7_0= RULE_FINALLY ) ) ( (lv_finallyStatement_8_0= ruleStatement ) ) )? ) ;
    public final EObject ruleTry_statement() throws RecognitionException {
        EObject current = null;

        Token lv_try_0_0=null;
        Token lv_catchs_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token lv_finally_7_0=null;
        EObject lv_tryStatement_1_0 = null;

        EObject lv_parameters_4_0 = null;

        EObject lv_catchStatements_6_0 = null;

        EObject lv_finallyStatement_8_0 = null;


         enterRule(); 
            
        try {
            // InternalJava.g:5008:28: ( ( ( (lv_try_0_0= RULE_TRY ) ) ( (lv_tryStatement_1_0= ruleStatement ) ) ( ( ( ( RULE_CATCH ) )=> (lv_catchs_2_0= RULE_CATCH ) ) otherlv_3= '(' ( (lv_parameters_4_0= ruleParameter ) ) otherlv_5= ')' ( (lv_catchStatements_6_0= ruleStatement ) ) )* ( ( ( ( RULE_FINALLY ) )=> (lv_finally_7_0= RULE_FINALLY ) ) ( (lv_finallyStatement_8_0= ruleStatement ) ) )? ) )
            // InternalJava.g:5009:1: ( ( (lv_try_0_0= RULE_TRY ) ) ( (lv_tryStatement_1_0= ruleStatement ) ) ( ( ( ( RULE_CATCH ) )=> (lv_catchs_2_0= RULE_CATCH ) ) otherlv_3= '(' ( (lv_parameters_4_0= ruleParameter ) ) otherlv_5= ')' ( (lv_catchStatements_6_0= ruleStatement ) ) )* ( ( ( ( RULE_FINALLY ) )=> (lv_finally_7_0= RULE_FINALLY ) ) ( (lv_finallyStatement_8_0= ruleStatement ) ) )? )
            {
            // InternalJava.g:5009:1: ( ( (lv_try_0_0= RULE_TRY ) ) ( (lv_tryStatement_1_0= ruleStatement ) ) ( ( ( ( RULE_CATCH ) )=> (lv_catchs_2_0= RULE_CATCH ) ) otherlv_3= '(' ( (lv_parameters_4_0= ruleParameter ) ) otherlv_5= ')' ( (lv_catchStatements_6_0= ruleStatement ) ) )* ( ( ( ( RULE_FINALLY ) )=> (lv_finally_7_0= RULE_FINALLY ) ) ( (lv_finallyStatement_8_0= ruleStatement ) ) )? )
            // InternalJava.g:5009:2: ( (lv_try_0_0= RULE_TRY ) ) ( (lv_tryStatement_1_0= ruleStatement ) ) ( ( ( ( RULE_CATCH ) )=> (lv_catchs_2_0= RULE_CATCH ) ) otherlv_3= '(' ( (lv_parameters_4_0= ruleParameter ) ) otherlv_5= ')' ( (lv_catchStatements_6_0= ruleStatement ) ) )* ( ( ( ( RULE_FINALLY ) )=> (lv_finally_7_0= RULE_FINALLY ) ) ( (lv_finallyStatement_8_0= ruleStatement ) ) )?
            {
            // InternalJava.g:5009:2: ( (lv_try_0_0= RULE_TRY ) )
            // InternalJava.g:5010:1: (lv_try_0_0= RULE_TRY )
            {
            // InternalJava.g:5010:1: (lv_try_0_0= RULE_TRY )
            // InternalJava.g:5011:3: lv_try_0_0= RULE_TRY
            {
            lv_try_0_0=(Token)match(input,RULE_TRY,FOLLOW_42); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_try_0_0, grammarAccess.getTry_statementAccess().getTryTRYTerminalRuleCall_0_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getTry_statementRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"try",
                      		lv_try_0_0, 
                      		"org.xtext.java.Java.TRY");
              	    
            }

            }


            }

            // InternalJava.g:5027:2: ( (lv_tryStatement_1_0= ruleStatement ) )
            // InternalJava.g:5028:1: (lv_tryStatement_1_0= ruleStatement )
            {
            // InternalJava.g:5028:1: (lv_tryStatement_1_0= ruleStatement )
            // InternalJava.g:5029:3: lv_tryStatement_1_0= ruleStatement
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTry_statementAccess().getTryStatementStatementParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_52);
            lv_tryStatement_1_0=ruleStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTry_statementRule());
              	        }
                     		set(
                     			current, 
                     			"tryStatement",
                      		lv_tryStatement_1_0, 
                      		"org.xtext.java.Java.Statement");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalJava.g:5045:2: ( ( ( ( RULE_CATCH ) )=> (lv_catchs_2_0= RULE_CATCH ) ) otherlv_3= '(' ( (lv_parameters_4_0= ruleParameter ) ) otherlv_5= ')' ( (lv_catchStatements_6_0= ruleStatement ) ) )*
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==RULE_CATCH) ) {
                    int LA74_2 = input.LA(2);

                    if ( (synpred157_InternalJava()) ) {
                        alt74=1;
                    }


                }


                switch (alt74) {
            	case 1 :
            	    // InternalJava.g:5045:3: ( ( ( RULE_CATCH ) )=> (lv_catchs_2_0= RULE_CATCH ) ) otherlv_3= '(' ( (lv_parameters_4_0= ruleParameter ) ) otherlv_5= ')' ( (lv_catchStatements_6_0= ruleStatement ) )
            	    {
            	    // InternalJava.g:5045:3: ( ( ( RULE_CATCH ) )=> (lv_catchs_2_0= RULE_CATCH ) )
            	    // InternalJava.g:5045:4: ( ( RULE_CATCH ) )=> (lv_catchs_2_0= RULE_CATCH )
            	    {
            	    // InternalJava.g:5051:1: (lv_catchs_2_0= RULE_CATCH )
            	    // InternalJava.g:5052:3: lv_catchs_2_0= RULE_CATCH
            	    {
            	    lv_catchs_2_0=(Token)match(input,RULE_CATCH,FOLLOW_17); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      			newLeafNode(lv_catchs_2_0, grammarAccess.getTry_statementAccess().getCatchsCATCHTerminalRuleCall_2_0_0()); 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElement(grammarAccess.getTry_statementRule());
            	      	        }
            	             		addWithLastConsumed(
            	             			current, 
            	             			"catchs",
            	              		lv_catchs_2_0, 
            	              		"org.xtext.java.Java.CATCH");
            	      	    
            	    }

            	    }


            	    }

            	    otherlv_3=(Token)match(input,78,FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getTry_statementAccess().getLeftParenthesisKeyword_2_1());
            	          
            	    }
            	    // InternalJava.g:5072:1: ( (lv_parameters_4_0= ruleParameter ) )
            	    // InternalJava.g:5073:1: (lv_parameters_4_0= ruleParameter )
            	    {
            	    // InternalJava.g:5073:1: (lv_parameters_4_0= ruleParameter )
            	    // InternalJava.g:5074:3: lv_parameters_4_0= ruleParameter
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTry_statementAccess().getParametersParameterParserRuleCall_2_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_19);
            	    lv_parameters_4_0=ruleParameter();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTry_statementRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"parameters",
            	              		lv_parameters_4_0, 
            	              		"org.xtext.java.Java.Parameter");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    otherlv_5=(Token)match(input,79,FOLLOW_42); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_5, grammarAccess.getTry_statementAccess().getRightParenthesisKeyword_2_3());
            	          
            	    }
            	    // InternalJava.g:5094:1: ( (lv_catchStatements_6_0= ruleStatement ) )
            	    // InternalJava.g:5095:1: (lv_catchStatements_6_0= ruleStatement )
            	    {
            	    // InternalJava.g:5095:1: (lv_catchStatements_6_0= ruleStatement )
            	    // InternalJava.g:5096:3: lv_catchStatements_6_0= ruleStatement
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTry_statementAccess().getCatchStatementsStatementParserRuleCall_2_4_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_52);
            	    lv_catchStatements_6_0=ruleStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTry_statementRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"catchStatements",
            	              		lv_catchStatements_6_0, 
            	              		"org.xtext.java.Java.Statement");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop74;
                }
            } while (true);

            // InternalJava.g:5112:4: ( ( ( ( RULE_FINALLY ) )=> (lv_finally_7_0= RULE_FINALLY ) ) ( (lv_finallyStatement_8_0= ruleStatement ) ) )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==RULE_FINALLY) ) {
                int LA75_1 = input.LA(2);

                if ( (synpred159_InternalJava()) ) {
                    alt75=1;
                }
            }
            switch (alt75) {
                case 1 :
                    // InternalJava.g:5112:5: ( ( ( RULE_FINALLY ) )=> (lv_finally_7_0= RULE_FINALLY ) ) ( (lv_finallyStatement_8_0= ruleStatement ) )
                    {
                    // InternalJava.g:5112:5: ( ( ( RULE_FINALLY ) )=> (lv_finally_7_0= RULE_FINALLY ) )
                    // InternalJava.g:5112:6: ( ( RULE_FINALLY ) )=> (lv_finally_7_0= RULE_FINALLY )
                    {
                    // InternalJava.g:5118:1: (lv_finally_7_0= RULE_FINALLY )
                    // InternalJava.g:5119:3: lv_finally_7_0= RULE_FINALLY
                    {
                    lv_finally_7_0=(Token)match(input,RULE_FINALLY,FOLLOW_42); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_finally_7_0, grammarAccess.getTry_statementAccess().getFinallyFINALLYTerminalRuleCall_3_0_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getTry_statementRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"finally",
                              		lv_finally_7_0, 
                              		"org.xtext.java.Java.FINALLY");
                      	    
                    }

                    }


                    }

                    // InternalJava.g:5135:2: ( (lv_finallyStatement_8_0= ruleStatement ) )
                    // InternalJava.g:5136:1: (lv_finallyStatement_8_0= ruleStatement )
                    {
                    // InternalJava.g:5136:1: (lv_finallyStatement_8_0= ruleStatement )
                    // InternalJava.g:5137:3: lv_finallyStatement_8_0= ruleStatement
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTry_statementAccess().getFinallyStatementStatementParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_2);
                    lv_finallyStatement_8_0=ruleStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTry_statementRule());
                      	        }
                             		set(
                             			current, 
                             			"finallyStatement",
                              		lv_finallyStatement_8_0, 
                              		"org.xtext.java.Java.Statement");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTry_statement"


    // $ANTLR start "entryRulePackage_statement"
    // InternalJava.g:5161:1: entryRulePackage_statement returns [EObject current=null] : iv_rulePackage_statement= rulePackage_statement EOF ;
    public final EObject entryRulePackage_statement() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackage_statement = null;


        try {
            // InternalJava.g:5162:2: (iv_rulePackage_statement= rulePackage_statement EOF )
            // InternalJava.g:5163:2: iv_rulePackage_statement= rulePackage_statement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPackage_statementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePackage_statement=rulePackage_statement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePackage_statement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePackage_statement"


    // $ANTLR start "rulePackage_statement"
    // InternalJava.g:5170:1: rulePackage_statement returns [EObject current=null] : (this_PACKAGE_0= RULE_PACKAGE ( (lv_name_1_0= rulePackage_name ) ) (this_EOL_2= RULE_EOL )+ ) ;
    public final EObject rulePackage_statement() throws RecognitionException {
        EObject current = null;

        Token this_PACKAGE_0=null;
        Token this_EOL_2=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // InternalJava.g:5173:28: ( (this_PACKAGE_0= RULE_PACKAGE ( (lv_name_1_0= rulePackage_name ) ) (this_EOL_2= RULE_EOL )+ ) )
            // InternalJava.g:5174:1: (this_PACKAGE_0= RULE_PACKAGE ( (lv_name_1_0= rulePackage_name ) ) (this_EOL_2= RULE_EOL )+ )
            {
            // InternalJava.g:5174:1: (this_PACKAGE_0= RULE_PACKAGE ( (lv_name_1_0= rulePackage_name ) ) (this_EOL_2= RULE_EOL )+ )
            // InternalJava.g:5174:2: this_PACKAGE_0= RULE_PACKAGE ( (lv_name_1_0= rulePackage_name ) ) (this_EOL_2= RULE_EOL )+
            {
            this_PACKAGE_0=(Token)match(input,RULE_PACKAGE,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_PACKAGE_0, grammarAccess.getPackage_statementAccess().getPACKAGETerminalRuleCall_0()); 
                  
            }
            // InternalJava.g:5178:1: ( (lv_name_1_0= rulePackage_name ) )
            // InternalJava.g:5179:1: (lv_name_1_0= rulePackage_name )
            {
            // InternalJava.g:5179:1: (lv_name_1_0= rulePackage_name )
            // InternalJava.g:5180:3: lv_name_1_0= rulePackage_name
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPackage_statementAccess().getNamePackage_nameParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_44);
            lv_name_1_0=rulePackage_name();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPackage_statementRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"org.xtext.java.Java.Package_name");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // InternalJava.g:5196:2: (this_EOL_2= RULE_EOL )+
            int cnt76=0;
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==RULE_EOL) ) {
                    alt76=1;
                }


                switch (alt76) {
            	case 1 :
            	    // InternalJava.g:5196:3: this_EOL_2= RULE_EOL
            	    {
            	    this_EOL_2=(Token)match(input,RULE_EOL,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_EOL_2, grammarAccess.getPackage_statementAccess().getEOLTerminalRuleCall_2()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt76 >= 1 ) break loop76;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(76, input);
                        throw eee;
                }
                cnt76++;
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePackage_statement"


    // $ANTLR start "entryRulePackage_name"
    // InternalJava.g:5208:1: entryRulePackage_name returns [String current=null] : iv_rulePackage_name= rulePackage_name EOF ;
    public final String entryRulePackage_name() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePackage_name = null;


        try {
            // InternalJava.g:5209:2: (iv_rulePackage_name= rulePackage_name EOF )
            // InternalJava.g:5210:2: iv_rulePackage_name= rulePackage_name EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPackage_nameRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePackage_name=rulePackage_name();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePackage_name.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePackage_name"


    // $ANTLR start "rulePackage_name"
    // InternalJava.g:5217:1: rulePackage_name returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID this_Package_name_aux_1= rulePackage_name_aux ) ;
    public final AntlrDatatypeRuleToken rulePackage_name() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        AntlrDatatypeRuleToken this_Package_name_aux_1 = null;


         enterRule(); 
            
        try {
            // InternalJava.g:5220:28: ( (this_ID_0= RULE_ID this_Package_name_aux_1= rulePackage_name_aux ) )
            // InternalJava.g:5221:1: (this_ID_0= RULE_ID this_Package_name_aux_1= rulePackage_name_aux )
            {
            // InternalJava.g:5221:1: (this_ID_0= RULE_ID this_Package_name_aux_1= rulePackage_name_aux )
            // InternalJava.g:5221:6: this_ID_0= RULE_ID this_Package_name_aux_1= rulePackage_name_aux
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_38); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getPackage_nameAccess().getIDTerminalRuleCall_0()); 
                  
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getPackage_nameAccess().getPackage_name_auxParserRuleCall_1()); 
                  
            }
            pushFollow(FOLLOW_2);
            this_Package_name_aux_1=rulePackage_name_aux();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_Package_name_aux_1);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePackage_name"


    // $ANTLR start "entryRulePackage_name_aux"
    // InternalJava.g:5247:1: entryRulePackage_name_aux returns [String current=null] : iv_rulePackage_name_aux= rulePackage_name_aux EOF ;
    public final String entryRulePackage_name_aux() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePackage_name_aux = null;


        try {
            // InternalJava.g:5248:2: (iv_rulePackage_name_aux= rulePackage_name_aux EOF )
            // InternalJava.g:5249:2: iv_rulePackage_name_aux= rulePackage_name_aux EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPackage_name_auxRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePackage_name_aux=rulePackage_name_aux();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePackage_name_aux.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePackage_name_aux"


    // $ANTLR start "rulePackage_name_aux"
    // InternalJava.g:5256:1: rulePackage_name_aux returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '.' this_ID_1= RULE_ID )* ;
    public final AntlrDatatypeRuleToken rulePackage_name_aux() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // InternalJava.g:5259:28: ( (kw= '.' this_ID_1= RULE_ID )* )
            // InternalJava.g:5260:1: (kw= '.' this_ID_1= RULE_ID )*
            {
            // InternalJava.g:5260:1: (kw= '.' this_ID_1= RULE_ID )*
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( (LA77_0==83) ) {
                    int LA77_2 = input.LA(2);

                    if ( (LA77_2==RULE_ID) ) {
                        int LA77_3 = input.LA(3);

                        if ( (synpred161_InternalJava()) ) {
                            alt77=1;
                        }


                    }


                }


                switch (alt77) {
            	case 1 :
            	    // InternalJava.g:5261:2: kw= '.' this_ID_1= RULE_ID
            	    {
            	    kw=(Token)match(input,83,FOLLOW_8); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getPackage_name_auxAccess().getFullStopKeyword_0()); 
            	          
            	    }
            	    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_53); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ID_1);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ID_1, grammarAccess.getPackage_name_auxAccess().getIDTerminalRuleCall_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop77;
                }
            } while (true);


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePackage_name_aux"


    // $ANTLR start "entryRuleImport_statement"
    // InternalJava.g:5281:1: entryRuleImport_statement returns [EObject current=null] : iv_ruleImport_statement= ruleImport_statement EOF ;
    public final EObject entryRuleImport_statement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport_statement = null;


        try {
            // InternalJava.g:5282:2: (iv_ruleImport_statement= ruleImport_statement EOF )
            // InternalJava.g:5283:2: iv_ruleImport_statement= ruleImport_statement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImport_statementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleImport_statement=ruleImport_statement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImport_statement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImport_statement"


    // $ANTLR start "ruleImport_statement"
    // InternalJava.g:5290:1: ruleImport_statement returns [EObject current=null] : (this_IMPORT_0= RULE_IMPORT ( ( ( (lv_classname_1_0= ruleClass_name ) ) this_EOL_2= RULE_EOL ) | ( ( (lv_packagename_3_0= rulePackage_name ) ) otherlv_4= '.' this_MULTIPLY_5= RULE_MULTIPLY this_EOL_6= RULE_EOL this_EOL_7= RULE_EOL ) ) ) ;
    public final EObject ruleImport_statement() throws RecognitionException {
        EObject current = null;

        Token this_IMPORT_0=null;
        Token this_EOL_2=null;
        Token otherlv_4=null;
        Token this_MULTIPLY_5=null;
        Token this_EOL_6=null;
        Token this_EOL_7=null;
        AntlrDatatypeRuleToken lv_classname_1_0 = null;

        AntlrDatatypeRuleToken lv_packagename_3_0 = null;


         enterRule(); 
            
        try {
            // InternalJava.g:5293:28: ( (this_IMPORT_0= RULE_IMPORT ( ( ( (lv_classname_1_0= ruleClass_name ) ) this_EOL_2= RULE_EOL ) | ( ( (lv_packagename_3_0= rulePackage_name ) ) otherlv_4= '.' this_MULTIPLY_5= RULE_MULTIPLY this_EOL_6= RULE_EOL this_EOL_7= RULE_EOL ) ) ) )
            // InternalJava.g:5294:1: (this_IMPORT_0= RULE_IMPORT ( ( ( (lv_classname_1_0= ruleClass_name ) ) this_EOL_2= RULE_EOL ) | ( ( (lv_packagename_3_0= rulePackage_name ) ) otherlv_4= '.' this_MULTIPLY_5= RULE_MULTIPLY this_EOL_6= RULE_EOL this_EOL_7= RULE_EOL ) ) )
            {
            // InternalJava.g:5294:1: (this_IMPORT_0= RULE_IMPORT ( ( ( (lv_classname_1_0= ruleClass_name ) ) this_EOL_2= RULE_EOL ) | ( ( (lv_packagename_3_0= rulePackage_name ) ) otherlv_4= '.' this_MULTIPLY_5= RULE_MULTIPLY this_EOL_6= RULE_EOL this_EOL_7= RULE_EOL ) ) )
            // InternalJava.g:5294:2: this_IMPORT_0= RULE_IMPORT ( ( ( (lv_classname_1_0= ruleClass_name ) ) this_EOL_2= RULE_EOL ) | ( ( (lv_packagename_3_0= rulePackage_name ) ) otherlv_4= '.' this_MULTIPLY_5= RULE_MULTIPLY this_EOL_6= RULE_EOL this_EOL_7= RULE_EOL ) )
            {
            this_IMPORT_0=(Token)match(input,RULE_IMPORT,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_IMPORT_0, grammarAccess.getImport_statementAccess().getIMPORTTerminalRuleCall_0()); 
                  
            }
            // InternalJava.g:5298:1: ( ( ( (lv_classname_1_0= ruleClass_name ) ) this_EOL_2= RULE_EOL ) | ( ( (lv_packagename_3_0= rulePackage_name ) ) otherlv_4= '.' this_MULTIPLY_5= RULE_MULTIPLY this_EOL_6= RULE_EOL this_EOL_7= RULE_EOL ) )
            int alt78=2;
            alt78 = dfa78.predict(input);
            switch (alt78) {
                case 1 :
                    // InternalJava.g:5298:2: ( ( (lv_classname_1_0= ruleClass_name ) ) this_EOL_2= RULE_EOL )
                    {
                    // InternalJava.g:5298:2: ( ( (lv_classname_1_0= ruleClass_name ) ) this_EOL_2= RULE_EOL )
                    // InternalJava.g:5298:3: ( (lv_classname_1_0= ruleClass_name ) ) this_EOL_2= RULE_EOL
                    {
                    // InternalJava.g:5298:3: ( (lv_classname_1_0= ruleClass_name ) )
                    // InternalJava.g:5299:1: (lv_classname_1_0= ruleClass_name )
                    {
                    // InternalJava.g:5299:1: (lv_classname_1_0= ruleClass_name )
                    // InternalJava.g:5300:3: lv_classname_1_0= ruleClass_name
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getImport_statementAccess().getClassnameClass_nameParserRuleCall_1_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_44);
                    lv_classname_1_0=ruleClass_name();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getImport_statementRule());
                      	        }
                             		set(
                             			current, 
                             			"classname",
                              		lv_classname_1_0, 
                              		"org.xtext.java.Java.Class_name");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    this_EOL_2=(Token)match(input,RULE_EOL,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_EOL_2, grammarAccess.getImport_statementAccess().getEOLTerminalRuleCall_1_0_1()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalJava.g:5321:6: ( ( (lv_packagename_3_0= rulePackage_name ) ) otherlv_4= '.' this_MULTIPLY_5= RULE_MULTIPLY this_EOL_6= RULE_EOL this_EOL_7= RULE_EOL )
                    {
                    // InternalJava.g:5321:6: ( ( (lv_packagename_3_0= rulePackage_name ) ) otherlv_4= '.' this_MULTIPLY_5= RULE_MULTIPLY this_EOL_6= RULE_EOL this_EOL_7= RULE_EOL )
                    // InternalJava.g:5321:7: ( (lv_packagename_3_0= rulePackage_name ) ) otherlv_4= '.' this_MULTIPLY_5= RULE_MULTIPLY this_EOL_6= RULE_EOL this_EOL_7= RULE_EOL
                    {
                    // InternalJava.g:5321:7: ( (lv_packagename_3_0= rulePackage_name ) )
                    // InternalJava.g:5322:1: (lv_packagename_3_0= rulePackage_name )
                    {
                    // InternalJava.g:5322:1: (lv_packagename_3_0= rulePackage_name )
                    // InternalJava.g:5323:3: lv_packagename_3_0= rulePackage_name
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getImport_statementAccess().getPackagenamePackage_nameParserRuleCall_1_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_38);
                    lv_packagename_3_0=rulePackage_name();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getImport_statementRule());
                      	        }
                             		set(
                             			current, 
                             			"packagename",
                              		lv_packagename_3_0, 
                              		"org.xtext.java.Java.Package_name");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_4=(Token)match(input,83,FOLLOW_54); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getImport_statementAccess().getFullStopKeyword_1_1_1());
                          
                    }
                    this_MULTIPLY_5=(Token)match(input,RULE_MULTIPLY,FOLLOW_44); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_MULTIPLY_5, grammarAccess.getImport_statementAccess().getMULTIPLYTerminalRuleCall_1_1_2()); 
                          
                    }
                    this_EOL_6=(Token)match(input,RULE_EOL,FOLLOW_44); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_EOL_6, grammarAccess.getImport_statementAccess().getEOLTerminalRuleCall_1_1_3()); 
                          
                    }
                    this_EOL_7=(Token)match(input,RULE_EOL,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_EOL_7, grammarAccess.getImport_statementAccess().getEOLTerminalRuleCall_1_1_4()); 
                          
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImport_statement"


    // $ANTLR start "entryRuleClass_name"
    // InternalJava.g:5363:1: entryRuleClass_name returns [String current=null] : iv_ruleClass_name= ruleClass_name EOF ;
    public final String entryRuleClass_name() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleClass_name = null;


        try {
            // InternalJava.g:5364:2: (iv_ruleClass_name= ruleClass_name EOF )
            // InternalJava.g:5365:2: iv_ruleClass_name= ruleClass_name EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getClass_nameRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleClass_name=ruleClass_name();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleClass_name.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClass_name"


    // $ANTLR start "ruleClass_name"
    // InternalJava.g:5372:1: ruleClass_name returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_Package_name_0= rulePackage_name ;
    public final AntlrDatatypeRuleToken ruleClass_name() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_Package_name_0 = null;


         enterRule(); 
            
        try {
            // InternalJava.g:5375:28: (this_Package_name_0= rulePackage_name )
            // InternalJava.g:5377:5: this_Package_name_0= rulePackage_name
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getClass_nameAccess().getPackage_nameParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_2);
            this_Package_name_0=rulePackage_name();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_Package_name_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClass_name"


    // $ANTLR start "entryRuleInterface_name"
    // InternalJava.g:5395:1: entryRuleInterface_name returns [String current=null] : iv_ruleInterface_name= ruleInterface_name EOF ;
    public final String entryRuleInterface_name() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleInterface_name = null;


        try {
            // InternalJava.g:5396:2: (iv_ruleInterface_name= ruleInterface_name EOF )
            // InternalJava.g:5397:2: iv_ruleInterface_name= ruleInterface_name EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInterface_nameRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleInterface_name=ruleInterface_name();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInterface_name.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInterface_name"


    // $ANTLR start "ruleInterface_name"
    // InternalJava.g:5404:1: ruleInterface_name returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_Package_name_0= rulePackage_name ;
    public final AntlrDatatypeRuleToken ruleInterface_name() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_Package_name_0 = null;


         enterRule(); 
            
        try {
            // InternalJava.g:5407:28: (this_Package_name_0= rulePackage_name )
            // InternalJava.g:5409:5: this_Package_name_0= rulePackage_name
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getInterface_nameAccess().getPackage_nameParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_2);
            this_Package_name_0=rulePackage_name();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_Package_name_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInterface_name"


    // $ANTLR start "entryRuleEXPOENT_PART"
    // InternalJava.g:5427:1: entryRuleEXPOENT_PART returns [String current=null] : iv_ruleEXPOENT_PART= ruleEXPOENT_PART EOF ;
    public final String entryRuleEXPOENT_PART() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEXPOENT_PART = null;


        try {
            // InternalJava.g:5428:2: (iv_ruleEXPOENT_PART= ruleEXPOENT_PART EOF )
            // InternalJava.g:5429:2: iv_ruleEXPOENT_PART= ruleEXPOENT_PART EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEXPOENT_PARTRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEXPOENT_PART=ruleEXPOENT_PART();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEXPOENT_PART.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEXPOENT_PART"


    // $ANTLR start "ruleEXPOENT_PART"
    // InternalJava.g:5436:1: ruleEXPOENT_PART returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_DECIMAL_DIGITS_0= RULE_DECIMAL_DIGITS ;
    public final AntlrDatatypeRuleToken ruleEXPOENT_PART() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DECIMAL_DIGITS_0=null;

         enterRule(); 
            
        try {
            // InternalJava.g:5439:28: (this_DECIMAL_DIGITS_0= RULE_DECIMAL_DIGITS )
            // InternalJava.g:5440:5: this_DECIMAL_DIGITS_0= RULE_DECIMAL_DIGITS
            {
            this_DECIMAL_DIGITS_0=(Token)match(input,RULE_DECIMAL_DIGITS,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_DECIMAL_DIGITS_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_DECIMAL_DIGITS_0, grammarAccess.getEXPOENT_PARTAccess().getDECIMAL_DIGITSTerminalRuleCall()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEXPOENT_PART"

    // $ANTLR start synpred56_InternalJava
    public final void synpred56_InternalJava_fragment() throws RecognitionException {   
        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_argList_1_0 = null;

        EObject lv_aux_3_0 = null;


        // InternalJava.g:1894:2: ( ( (otherlv_0= '(' ( (lv_argList_1_0= ruleArg_List ) )? otherlv_2= ')' ) ( (lv_aux_3_0= ruleExpression_aux ) ) ) )
        // InternalJava.g:1894:2: ( (otherlv_0= '(' ( (lv_argList_1_0= ruleArg_List ) )? otherlv_2= ')' ) ( (lv_aux_3_0= ruleExpression_aux ) ) )
        {
        // InternalJava.g:1894:2: ( (otherlv_0= '(' ( (lv_argList_1_0= ruleArg_List ) )? otherlv_2= ')' ) ( (lv_aux_3_0= ruleExpression_aux ) ) )
        // InternalJava.g:1894:3: (otherlv_0= '(' ( (lv_argList_1_0= ruleArg_List ) )? otherlv_2= ')' ) ( (lv_aux_3_0= ruleExpression_aux ) )
        {
        // InternalJava.g:1894:3: (otherlv_0= '(' ( (lv_argList_1_0= ruleArg_List ) )? otherlv_2= ')' )
        // InternalJava.g:1894:5: otherlv_0= '(' ( (lv_argList_1_0= ruleArg_List ) )? otherlv_2= ')'
        {
        otherlv_0=(Token)match(input,78,FOLLOW_34); if (state.failed) return ;
        // InternalJava.g:1898:1: ( (lv_argList_1_0= ruleArg_List ) )?
        int alt85=2;
        int LA85_0 = input.LA(1);

        if ( (LA85_0==RULE_ID||(LA85_0>=RULE_NULL && LA85_0<=RULE_THIS)||(LA85_0>=RULE_INCREMENT && LA85_0<=RULE_DECREMENT)||LA85_0==RULE_MINUS||(LA85_0>=RULE_DECIMAL_DIGITS && LA85_0<=RULE_FALSE)||LA85_0==78) ) {
            alt85=1;
        }
        switch (alt85) {
            case 1 :
                // InternalJava.g:1899:1: (lv_argList_1_0= ruleArg_List )
                {
                // InternalJava.g:1899:1: (lv_argList_1_0= ruleArg_List )
                // InternalJava.g:1900:3: lv_argList_1_0= ruleArg_List
                {
                if ( state.backtracking==0 ) {
                   
                  	        newCompositeNode(grammarAccess.getExpression_auxAccess().getArgListArg_ListParserRuleCall_0_0_1_0()); 
                  	    
                }
                pushFollow(FOLLOW_19);
                lv_argList_1_0=ruleArg_List();

                state._fsp--;
                if (state.failed) return ;

                }


                }
                break;

        }

        otherlv_2=(Token)match(input,79,FOLLOW_33); if (state.failed) return ;

        }

        // InternalJava.g:1920:2: ( (lv_aux_3_0= ruleExpression_aux ) )
        // InternalJava.g:1921:1: (lv_aux_3_0= ruleExpression_aux )
        {
        // InternalJava.g:1921:1: (lv_aux_3_0= ruleExpression_aux )
        // InternalJava.g:1922:3: lv_aux_3_0= ruleExpression_aux
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getExpression_auxAccess().getAuxExpression_auxParserRuleCall_0_1_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
        lv_aux_3_0=ruleExpression_aux();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred56_InternalJava

    // $ANTLR start synpred57_InternalJava
    public final void synpred57_InternalJava_fragment() throws RecognitionException {   
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_expression2_5_0 = null;

        EObject lv_aux_7_0 = null;


        // InternalJava.g:1939:6: ( ( (otherlv_4= '[' ( (lv_expression2_5_0= ruleExpression ) ) otherlv_6= ']' ) ( (lv_aux_7_0= ruleExpression_aux ) ) ) )
        // InternalJava.g:1939:6: ( (otherlv_4= '[' ( (lv_expression2_5_0= ruleExpression ) ) otherlv_6= ']' ) ( (lv_aux_7_0= ruleExpression_aux ) ) )
        {
        // InternalJava.g:1939:6: ( (otherlv_4= '[' ( (lv_expression2_5_0= ruleExpression ) ) otherlv_6= ']' ) ( (lv_aux_7_0= ruleExpression_aux ) ) )
        // InternalJava.g:1939:7: (otherlv_4= '[' ( (lv_expression2_5_0= ruleExpression ) ) otherlv_6= ']' ) ( (lv_aux_7_0= ruleExpression_aux ) )
        {
        // InternalJava.g:1939:7: (otherlv_4= '[' ( (lv_expression2_5_0= ruleExpression ) ) otherlv_6= ']' )
        // InternalJava.g:1939:9: otherlv_4= '[' ( (lv_expression2_5_0= ruleExpression ) ) otherlv_6= ']'
        {
        otherlv_4=(Token)match(input,80,FOLLOW_35); if (state.failed) return ;
        // InternalJava.g:1943:1: ( (lv_expression2_5_0= ruleExpression ) )
        // InternalJava.g:1944:1: (lv_expression2_5_0= ruleExpression )
        {
        // InternalJava.g:1944:1: (lv_expression2_5_0= ruleExpression )
        // InternalJava.g:1945:3: lv_expression2_5_0= ruleExpression
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getExpression_auxAccess().getExpression2ExpressionParserRuleCall_1_0_1_0()); 
          	    
        }
        pushFollow(FOLLOW_21);
        lv_expression2_5_0=ruleExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_6=(Token)match(input,81,FOLLOW_33); if (state.failed) return ;

        }

        // InternalJava.g:1965:2: ( (lv_aux_7_0= ruleExpression_aux ) )
        // InternalJava.g:1966:1: (lv_aux_7_0= ruleExpression_aux )
        {
        // InternalJava.g:1966:1: (lv_aux_7_0= ruleExpression_aux )
        // InternalJava.g:1967:3: lv_aux_7_0= ruleExpression_aux
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getExpression_auxAccess().getAuxExpression_auxParserRuleCall_1_1_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
        lv_aux_7_0=ruleExpression_aux();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred57_InternalJava

    // $ANTLR start synpred58_InternalJava
    public final void synpred58_InternalJava_fragment() throws RecognitionException {   
        Token otherlv_8=null;
        EObject lv_expression2_9_0 = null;

        EObject lv_aux_10_0 = null;


        // InternalJava.g:1984:6: ( ( (otherlv_8= '.' ( (lv_expression2_9_0= ruleExpression ) ) ) ( (lv_aux_10_0= ruleExpression_aux ) ) ) )
        // InternalJava.g:1984:6: ( (otherlv_8= '.' ( (lv_expression2_9_0= ruleExpression ) ) ) ( (lv_aux_10_0= ruleExpression_aux ) ) )
        {
        // InternalJava.g:1984:6: ( (otherlv_8= '.' ( (lv_expression2_9_0= ruleExpression ) ) ) ( (lv_aux_10_0= ruleExpression_aux ) ) )
        // InternalJava.g:1984:7: (otherlv_8= '.' ( (lv_expression2_9_0= ruleExpression ) ) ) ( (lv_aux_10_0= ruleExpression_aux ) )
        {
        // InternalJava.g:1984:7: (otherlv_8= '.' ( (lv_expression2_9_0= ruleExpression ) ) )
        // InternalJava.g:1984:9: otherlv_8= '.' ( (lv_expression2_9_0= ruleExpression ) )
        {
        otherlv_8=(Token)match(input,83,FOLLOW_35); if (state.failed) return ;
        // InternalJava.g:1988:1: ( (lv_expression2_9_0= ruleExpression ) )
        // InternalJava.g:1989:1: (lv_expression2_9_0= ruleExpression )
        {
        // InternalJava.g:1989:1: (lv_expression2_9_0= ruleExpression )
        // InternalJava.g:1990:3: lv_expression2_9_0= ruleExpression
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getExpression_auxAccess().getExpression2ExpressionParserRuleCall_2_0_1_0()); 
          	    
        }
        pushFollow(FOLLOW_33);
        lv_expression2_9_0=ruleExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }

        // InternalJava.g:2006:3: ( (lv_aux_10_0= ruleExpression_aux ) )
        // InternalJava.g:2007:1: (lv_aux_10_0= ruleExpression_aux )
        {
        // InternalJava.g:2007:1: (lv_aux_10_0= ruleExpression_aux )
        // InternalJava.g:2008:3: lv_aux_10_0= ruleExpression_aux
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getExpression_auxAccess().getAuxExpression_auxParserRuleCall_2_1_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
        lv_aux_10_0=ruleExpression_aux();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred58_InternalJava

    // $ANTLR start synpred59_InternalJava
    public final void synpred59_InternalJava_fragment() throws RecognitionException {   
        Token this_COMMA_11=null;
        EObject lv_expressionComma_12_0 = null;

        EObject lv_aux_13_0 = null;


        // InternalJava.g:2025:6: ( ( (this_COMMA_11= RULE_COMMA ( (lv_expressionComma_12_0= ruleExpression ) ) ) ( (lv_aux_13_0= ruleExpression_aux ) ) ) )
        // InternalJava.g:2025:6: ( (this_COMMA_11= RULE_COMMA ( (lv_expressionComma_12_0= ruleExpression ) ) ) ( (lv_aux_13_0= ruleExpression_aux ) ) )
        {
        // InternalJava.g:2025:6: ( (this_COMMA_11= RULE_COMMA ( (lv_expressionComma_12_0= ruleExpression ) ) ) ( (lv_aux_13_0= ruleExpression_aux ) ) )
        // InternalJava.g:2025:7: (this_COMMA_11= RULE_COMMA ( (lv_expressionComma_12_0= ruleExpression ) ) ) ( (lv_aux_13_0= ruleExpression_aux ) )
        {
        // InternalJava.g:2025:7: (this_COMMA_11= RULE_COMMA ( (lv_expressionComma_12_0= ruleExpression ) ) )
        // InternalJava.g:2025:8: this_COMMA_11= RULE_COMMA ( (lv_expressionComma_12_0= ruleExpression ) )
        {
        this_COMMA_11=(Token)match(input,RULE_COMMA,FOLLOW_35); if (state.failed) return ;
        // InternalJava.g:2029:1: ( (lv_expressionComma_12_0= ruleExpression ) )
        // InternalJava.g:2030:1: (lv_expressionComma_12_0= ruleExpression )
        {
        // InternalJava.g:2030:1: (lv_expressionComma_12_0= ruleExpression )
        // InternalJava.g:2031:3: lv_expressionComma_12_0= ruleExpression
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getExpression_auxAccess().getExpressionCommaExpressionParserRuleCall_3_0_1_0()); 
          	    
        }
        pushFollow(FOLLOW_33);
        lv_expressionComma_12_0=ruleExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }

        // InternalJava.g:2047:3: ( (lv_aux_13_0= ruleExpression_aux ) )
        // InternalJava.g:2048:1: (lv_aux_13_0= ruleExpression_aux )
        {
        // InternalJava.g:2048:1: (lv_aux_13_0= ruleExpression_aux )
        // InternalJava.g:2049:3: lv_aux_13_0= ruleExpression_aux
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getExpression_auxAccess().getAuxExpression_auxParserRuleCall_3_1_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
        lv_aux_13_0=ruleExpression_aux();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred59_InternalJava

    // $ANTLR start synpred60_InternalJava
    public final void synpred60_InternalJava_fragment() throws RecognitionException {   
        Token this_INSTANCEOF_14=null;
        AntlrDatatypeRuleToken lv_name_15_0 = null;

        EObject lv_aux_16_0 = null;


        // InternalJava.g:2066:6: ( ( (this_INSTANCEOF_14= RULE_INSTANCEOF ( (lv_name_15_0= ruleClass_name ) ) ) ( (lv_aux_16_0= ruleExpression_aux ) ) ) )
        // InternalJava.g:2066:6: ( (this_INSTANCEOF_14= RULE_INSTANCEOF ( (lv_name_15_0= ruleClass_name ) ) ) ( (lv_aux_16_0= ruleExpression_aux ) ) )
        {
        // InternalJava.g:2066:6: ( (this_INSTANCEOF_14= RULE_INSTANCEOF ( (lv_name_15_0= ruleClass_name ) ) ) ( (lv_aux_16_0= ruleExpression_aux ) ) )
        // InternalJava.g:2066:7: (this_INSTANCEOF_14= RULE_INSTANCEOF ( (lv_name_15_0= ruleClass_name ) ) ) ( (lv_aux_16_0= ruleExpression_aux ) )
        {
        // InternalJava.g:2066:7: (this_INSTANCEOF_14= RULE_INSTANCEOF ( (lv_name_15_0= ruleClass_name ) ) )
        // InternalJava.g:2066:8: this_INSTANCEOF_14= RULE_INSTANCEOF ( (lv_name_15_0= ruleClass_name ) )
        {
        this_INSTANCEOF_14=(Token)match(input,RULE_INSTANCEOF,FOLLOW_14); if (state.failed) return ;
        // InternalJava.g:2070:1: ( (lv_name_15_0= ruleClass_name ) )
        // InternalJava.g:2071:1: (lv_name_15_0= ruleClass_name )
        {
        // InternalJava.g:2071:1: (lv_name_15_0= ruleClass_name )
        // InternalJava.g:2072:3: lv_name_15_0= ruleClass_name
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getExpression_auxAccess().getNameClass_nameParserRuleCall_4_0_1_0()); 
          	    
        }
        pushFollow(FOLLOW_33);
        lv_name_15_0=ruleClass_name();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }

        // InternalJava.g:2088:3: ( (lv_aux_16_0= ruleExpression_aux ) )
        // InternalJava.g:2089:1: (lv_aux_16_0= ruleExpression_aux )
        {
        // InternalJava.g:2089:1: (lv_aux_16_0= ruleExpression_aux )
        // InternalJava.g:2090:3: lv_aux_16_0= ruleExpression_aux
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getExpression_auxAccess().getAuxExpression_auxParserRuleCall_4_1_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
        lv_aux_16_0=ruleExpression_aux();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred60_InternalJava

    // $ANTLR start synpred62_InternalJava
    public final void synpred62_InternalJava_fragment() throws RecognitionException {   
        Token lv_sgin_17_1=null;
        Token lv_sgin_17_2=null;
        EObject lv_aux_18_0 = null;


        // InternalJava.g:2107:6: ( ( ( ( (lv_sgin_17_1= RULE_INCREMENT | lv_sgin_17_2= RULE_DECREMENT ) ) ) ( (lv_aux_18_0= ruleExpression_aux ) ) ) )
        // InternalJava.g:2107:6: ( ( ( (lv_sgin_17_1= RULE_INCREMENT | lv_sgin_17_2= RULE_DECREMENT ) ) ) ( (lv_aux_18_0= ruleExpression_aux ) ) )
        {
        // InternalJava.g:2107:6: ( ( ( (lv_sgin_17_1= RULE_INCREMENT | lv_sgin_17_2= RULE_DECREMENT ) ) ) ( (lv_aux_18_0= ruleExpression_aux ) ) )
        // InternalJava.g:2107:7: ( ( (lv_sgin_17_1= RULE_INCREMENT | lv_sgin_17_2= RULE_DECREMENT ) ) ) ( (lv_aux_18_0= ruleExpression_aux ) )
        {
        // InternalJava.g:2107:7: ( ( (lv_sgin_17_1= RULE_INCREMENT | lv_sgin_17_2= RULE_DECREMENT ) ) )
        // InternalJava.g:2108:1: ( (lv_sgin_17_1= RULE_INCREMENT | lv_sgin_17_2= RULE_DECREMENT ) )
        {
        // InternalJava.g:2108:1: ( (lv_sgin_17_1= RULE_INCREMENT | lv_sgin_17_2= RULE_DECREMENT ) )
        // InternalJava.g:2109:1: (lv_sgin_17_1= RULE_INCREMENT | lv_sgin_17_2= RULE_DECREMENT )
        {
        // InternalJava.g:2109:1: (lv_sgin_17_1= RULE_INCREMENT | lv_sgin_17_2= RULE_DECREMENT )
        int alt86=2;
        int LA86_0 = input.LA(1);

        if ( (LA86_0==RULE_INCREMENT) ) {
            alt86=1;
        }
        else if ( (LA86_0==RULE_DECREMENT) ) {
            alt86=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 86, 0, input);

            throw nvae;
        }
        switch (alt86) {
            case 1 :
                // InternalJava.g:2110:3: lv_sgin_17_1= RULE_INCREMENT
                {
                lv_sgin_17_1=(Token)match(input,RULE_INCREMENT,FOLLOW_33); if (state.failed) return ;

                }
                break;
            case 2 :
                // InternalJava.g:2125:8: lv_sgin_17_2= RULE_DECREMENT
                {
                lv_sgin_17_2=(Token)match(input,RULE_DECREMENT,FOLLOW_33); if (state.failed) return ;

                }
                break;

        }


        }


        }

        // InternalJava.g:2143:2: ( (lv_aux_18_0= ruleExpression_aux ) )
        // InternalJava.g:2144:1: (lv_aux_18_0= ruleExpression_aux )
        {
        // InternalJava.g:2144:1: (lv_aux_18_0= ruleExpression_aux )
        // InternalJava.g:2145:3: lv_aux_18_0= ruleExpression_aux
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getExpression_auxAccess().getAuxExpression_auxParserRuleCall_5_1_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
        lv_aux_18_0=ruleExpression_aux();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred62_InternalJava

    // $ANTLR start synpred72_InternalJava
    public final void synpred72_InternalJava_fragment() throws RecognitionException {   
        Token lv_numericSign_19_1=null;
        Token lv_numericSign_19_2=null;
        Token lv_numericSign_19_3=null;
        Token lv_numericSign_19_4=null;
        Token lv_numericSign_19_5=null;
        Token lv_numericSign_19_6=null;
        Token lv_numericSign_19_7=null;
        Token lv_numericSign_19_8=null;
        Token lv_numericSign_19_9=null;
        Token lv_numericSign_19_10=null;
        EObject lv_exp2_20_0 = null;

        EObject lv_aux_21_0 = null;


        // InternalJava.g:2162:6: ( ( ( ( (lv_numericSign_19_1= RULE_PLUS | lv_numericSign_19_2= RULE_PLUS_EQUAL | lv_numericSign_19_3= RULE_MINUS | lv_numericSign_19_4= RULE_MINUS_EQUAL | lv_numericSign_19_5= RULE_MULTIPLY | lv_numericSign_19_6= RULE_MULTIPLY_EQUAL | lv_numericSign_19_7= RULE_DIVIDE | lv_numericSign_19_8= RULE_DIVIDE_EQUAL | lv_numericSign_19_9= RULE_MODULE | lv_numericSign_19_10= RULE_MODULE_EQUAL ) ) ) ( (lv_exp2_20_0= ruleExpression ) ) ( (lv_aux_21_0= ruleExpression_aux ) ) ) )
        // InternalJava.g:2162:6: ( ( ( (lv_numericSign_19_1= RULE_PLUS | lv_numericSign_19_2= RULE_PLUS_EQUAL | lv_numericSign_19_3= RULE_MINUS | lv_numericSign_19_4= RULE_MINUS_EQUAL | lv_numericSign_19_5= RULE_MULTIPLY | lv_numericSign_19_6= RULE_MULTIPLY_EQUAL | lv_numericSign_19_7= RULE_DIVIDE | lv_numericSign_19_8= RULE_DIVIDE_EQUAL | lv_numericSign_19_9= RULE_MODULE | lv_numericSign_19_10= RULE_MODULE_EQUAL ) ) ) ( (lv_exp2_20_0= ruleExpression ) ) ( (lv_aux_21_0= ruleExpression_aux ) ) )
        {
        // InternalJava.g:2162:6: ( ( ( (lv_numericSign_19_1= RULE_PLUS | lv_numericSign_19_2= RULE_PLUS_EQUAL | lv_numericSign_19_3= RULE_MINUS | lv_numericSign_19_4= RULE_MINUS_EQUAL | lv_numericSign_19_5= RULE_MULTIPLY | lv_numericSign_19_6= RULE_MULTIPLY_EQUAL | lv_numericSign_19_7= RULE_DIVIDE | lv_numericSign_19_8= RULE_DIVIDE_EQUAL | lv_numericSign_19_9= RULE_MODULE | lv_numericSign_19_10= RULE_MODULE_EQUAL ) ) ) ( (lv_exp2_20_0= ruleExpression ) ) ( (lv_aux_21_0= ruleExpression_aux ) ) )
        // InternalJava.g:2162:7: ( ( (lv_numericSign_19_1= RULE_PLUS | lv_numericSign_19_2= RULE_PLUS_EQUAL | lv_numericSign_19_3= RULE_MINUS | lv_numericSign_19_4= RULE_MINUS_EQUAL | lv_numericSign_19_5= RULE_MULTIPLY | lv_numericSign_19_6= RULE_MULTIPLY_EQUAL | lv_numericSign_19_7= RULE_DIVIDE | lv_numericSign_19_8= RULE_DIVIDE_EQUAL | lv_numericSign_19_9= RULE_MODULE | lv_numericSign_19_10= RULE_MODULE_EQUAL ) ) ) ( (lv_exp2_20_0= ruleExpression ) ) ( (lv_aux_21_0= ruleExpression_aux ) )
        {
        // InternalJava.g:2162:7: ( ( (lv_numericSign_19_1= RULE_PLUS | lv_numericSign_19_2= RULE_PLUS_EQUAL | lv_numericSign_19_3= RULE_MINUS | lv_numericSign_19_4= RULE_MINUS_EQUAL | lv_numericSign_19_5= RULE_MULTIPLY | lv_numericSign_19_6= RULE_MULTIPLY_EQUAL | lv_numericSign_19_7= RULE_DIVIDE | lv_numericSign_19_8= RULE_DIVIDE_EQUAL | lv_numericSign_19_9= RULE_MODULE | lv_numericSign_19_10= RULE_MODULE_EQUAL ) ) )
        // InternalJava.g:2163:1: ( (lv_numericSign_19_1= RULE_PLUS | lv_numericSign_19_2= RULE_PLUS_EQUAL | lv_numericSign_19_3= RULE_MINUS | lv_numericSign_19_4= RULE_MINUS_EQUAL | lv_numericSign_19_5= RULE_MULTIPLY | lv_numericSign_19_6= RULE_MULTIPLY_EQUAL | lv_numericSign_19_7= RULE_DIVIDE | lv_numericSign_19_8= RULE_DIVIDE_EQUAL | lv_numericSign_19_9= RULE_MODULE | lv_numericSign_19_10= RULE_MODULE_EQUAL ) )
        {
        // InternalJava.g:2163:1: ( (lv_numericSign_19_1= RULE_PLUS | lv_numericSign_19_2= RULE_PLUS_EQUAL | lv_numericSign_19_3= RULE_MINUS | lv_numericSign_19_4= RULE_MINUS_EQUAL | lv_numericSign_19_5= RULE_MULTIPLY | lv_numericSign_19_6= RULE_MULTIPLY_EQUAL | lv_numericSign_19_7= RULE_DIVIDE | lv_numericSign_19_8= RULE_DIVIDE_EQUAL | lv_numericSign_19_9= RULE_MODULE | lv_numericSign_19_10= RULE_MODULE_EQUAL ) )
        // InternalJava.g:2164:1: (lv_numericSign_19_1= RULE_PLUS | lv_numericSign_19_2= RULE_PLUS_EQUAL | lv_numericSign_19_3= RULE_MINUS | lv_numericSign_19_4= RULE_MINUS_EQUAL | lv_numericSign_19_5= RULE_MULTIPLY | lv_numericSign_19_6= RULE_MULTIPLY_EQUAL | lv_numericSign_19_7= RULE_DIVIDE | lv_numericSign_19_8= RULE_DIVIDE_EQUAL | lv_numericSign_19_9= RULE_MODULE | lv_numericSign_19_10= RULE_MODULE_EQUAL )
        {
        // InternalJava.g:2164:1: (lv_numericSign_19_1= RULE_PLUS | lv_numericSign_19_2= RULE_PLUS_EQUAL | lv_numericSign_19_3= RULE_MINUS | lv_numericSign_19_4= RULE_MINUS_EQUAL | lv_numericSign_19_5= RULE_MULTIPLY | lv_numericSign_19_6= RULE_MULTIPLY_EQUAL | lv_numericSign_19_7= RULE_DIVIDE | lv_numericSign_19_8= RULE_DIVIDE_EQUAL | lv_numericSign_19_9= RULE_MODULE | lv_numericSign_19_10= RULE_MODULE_EQUAL )
        int alt87=10;
        switch ( input.LA(1) ) {
        case RULE_PLUS:
            {
            alt87=1;
            }
            break;
        case RULE_PLUS_EQUAL:
            {
            alt87=2;
            }
            break;
        case RULE_MINUS:
            {
            alt87=3;
            }
            break;
        case RULE_MINUS_EQUAL:
            {
            alt87=4;
            }
            break;
        case RULE_MULTIPLY:
            {
            alt87=5;
            }
            break;
        case RULE_MULTIPLY_EQUAL:
            {
            alt87=6;
            }
            break;
        case RULE_DIVIDE:
            {
            alt87=7;
            }
            break;
        case RULE_DIVIDE_EQUAL:
            {
            alt87=8;
            }
            break;
        case RULE_MODULE:
            {
            alt87=9;
            }
            break;
        case RULE_MODULE_EQUAL:
            {
            alt87=10;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 87, 0, input);

            throw nvae;
        }

        switch (alt87) {
            case 1 :
                // InternalJava.g:2165:3: lv_numericSign_19_1= RULE_PLUS
                {
                lv_numericSign_19_1=(Token)match(input,RULE_PLUS,FOLLOW_35); if (state.failed) return ;

                }
                break;
            case 2 :
                // InternalJava.g:2180:8: lv_numericSign_19_2= RULE_PLUS_EQUAL
                {
                lv_numericSign_19_2=(Token)match(input,RULE_PLUS_EQUAL,FOLLOW_35); if (state.failed) return ;

                }
                break;
            case 3 :
                // InternalJava.g:2195:8: lv_numericSign_19_3= RULE_MINUS
                {
                lv_numericSign_19_3=(Token)match(input,RULE_MINUS,FOLLOW_35); if (state.failed) return ;

                }
                break;
            case 4 :
                // InternalJava.g:2210:8: lv_numericSign_19_4= RULE_MINUS_EQUAL
                {
                lv_numericSign_19_4=(Token)match(input,RULE_MINUS_EQUAL,FOLLOW_35); if (state.failed) return ;

                }
                break;
            case 5 :
                // InternalJava.g:2225:8: lv_numericSign_19_5= RULE_MULTIPLY
                {
                lv_numericSign_19_5=(Token)match(input,RULE_MULTIPLY,FOLLOW_35); if (state.failed) return ;

                }
                break;
            case 6 :
                // InternalJava.g:2240:8: lv_numericSign_19_6= RULE_MULTIPLY_EQUAL
                {
                lv_numericSign_19_6=(Token)match(input,RULE_MULTIPLY_EQUAL,FOLLOW_35); if (state.failed) return ;

                }
                break;
            case 7 :
                // InternalJava.g:2255:8: lv_numericSign_19_7= RULE_DIVIDE
                {
                lv_numericSign_19_7=(Token)match(input,RULE_DIVIDE,FOLLOW_35); if (state.failed) return ;

                }
                break;
            case 8 :
                // InternalJava.g:2270:8: lv_numericSign_19_8= RULE_DIVIDE_EQUAL
                {
                lv_numericSign_19_8=(Token)match(input,RULE_DIVIDE_EQUAL,FOLLOW_35); if (state.failed) return ;

                }
                break;
            case 9 :
                // InternalJava.g:2285:8: lv_numericSign_19_9= RULE_MODULE
                {
                lv_numericSign_19_9=(Token)match(input,RULE_MODULE,FOLLOW_35); if (state.failed) return ;

                }
                break;
            case 10 :
                // InternalJava.g:2300:8: lv_numericSign_19_10= RULE_MODULE_EQUAL
                {
                lv_numericSign_19_10=(Token)match(input,RULE_MODULE_EQUAL,FOLLOW_35); if (state.failed) return ;

                }
                break;

        }


        }


        }

        // InternalJava.g:2318:2: ( (lv_exp2_20_0= ruleExpression ) )
        // InternalJava.g:2319:1: (lv_exp2_20_0= ruleExpression )
        {
        // InternalJava.g:2319:1: (lv_exp2_20_0= ruleExpression )
        // InternalJava.g:2320:3: lv_exp2_20_0= ruleExpression
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getExpression_auxAccess().getExp2ExpressionParserRuleCall_6_1_0()); 
          	    
        }
        pushFollow(FOLLOW_33);
        lv_exp2_20_0=ruleExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // InternalJava.g:2336:2: ( (lv_aux_21_0= ruleExpression_aux ) )
        // InternalJava.g:2337:1: (lv_aux_21_0= ruleExpression_aux )
        {
        // InternalJava.g:2337:1: (lv_aux_21_0= ruleExpression_aux )
        // InternalJava.g:2338:3: lv_aux_21_0= ruleExpression_aux
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getExpression_auxAccess().getAuxExpression_auxParserRuleCall_6_2_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
        lv_aux_21_0=ruleExpression_aux();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred72_InternalJava

    // $ANTLR start synpred78_InternalJava
    public final void synpred78_InternalJava_fragment() throws RecognitionException {   
        Token lv_testingSign_22_1=null;
        Token lv_testingSign_22_2=null;
        Token lv_testingSign_22_3=null;
        Token lv_testingSign_22_4=null;
        Token lv_testingSign_22_5=null;
        Token lv_testingSign_22_6=null;
        EObject lv_exp1_23_0 = null;

        EObject lv_aux_24_0 = null;


        // InternalJava.g:2355:6: ( ( ( ( (lv_testingSign_22_1= RULE_BT | lv_testingSign_22_2= RULE_ST | lv_testingSign_22_3= RULE_BE | lv_testingSign_22_4= RULE_SE | lv_testingSign_22_5= RULE_DOUBLE_EQUAL | lv_testingSign_22_6= RULE_DIFFERENT ) ) ) ( (lv_exp1_23_0= ruleExpression ) ) ( (lv_aux_24_0= ruleExpression_aux ) ) ) )
        // InternalJava.g:2355:6: ( ( ( (lv_testingSign_22_1= RULE_BT | lv_testingSign_22_2= RULE_ST | lv_testingSign_22_3= RULE_BE | lv_testingSign_22_4= RULE_SE | lv_testingSign_22_5= RULE_DOUBLE_EQUAL | lv_testingSign_22_6= RULE_DIFFERENT ) ) ) ( (lv_exp1_23_0= ruleExpression ) ) ( (lv_aux_24_0= ruleExpression_aux ) ) )
        {
        // InternalJava.g:2355:6: ( ( ( (lv_testingSign_22_1= RULE_BT | lv_testingSign_22_2= RULE_ST | lv_testingSign_22_3= RULE_BE | lv_testingSign_22_4= RULE_SE | lv_testingSign_22_5= RULE_DOUBLE_EQUAL | lv_testingSign_22_6= RULE_DIFFERENT ) ) ) ( (lv_exp1_23_0= ruleExpression ) ) ( (lv_aux_24_0= ruleExpression_aux ) ) )
        // InternalJava.g:2355:7: ( ( (lv_testingSign_22_1= RULE_BT | lv_testingSign_22_2= RULE_ST | lv_testingSign_22_3= RULE_BE | lv_testingSign_22_4= RULE_SE | lv_testingSign_22_5= RULE_DOUBLE_EQUAL | lv_testingSign_22_6= RULE_DIFFERENT ) ) ) ( (lv_exp1_23_0= ruleExpression ) ) ( (lv_aux_24_0= ruleExpression_aux ) )
        {
        // InternalJava.g:2355:7: ( ( (lv_testingSign_22_1= RULE_BT | lv_testingSign_22_2= RULE_ST | lv_testingSign_22_3= RULE_BE | lv_testingSign_22_4= RULE_SE | lv_testingSign_22_5= RULE_DOUBLE_EQUAL | lv_testingSign_22_6= RULE_DIFFERENT ) ) )
        // InternalJava.g:2356:1: ( (lv_testingSign_22_1= RULE_BT | lv_testingSign_22_2= RULE_ST | lv_testingSign_22_3= RULE_BE | lv_testingSign_22_4= RULE_SE | lv_testingSign_22_5= RULE_DOUBLE_EQUAL | lv_testingSign_22_6= RULE_DIFFERENT ) )
        {
        // InternalJava.g:2356:1: ( (lv_testingSign_22_1= RULE_BT | lv_testingSign_22_2= RULE_ST | lv_testingSign_22_3= RULE_BE | lv_testingSign_22_4= RULE_SE | lv_testingSign_22_5= RULE_DOUBLE_EQUAL | lv_testingSign_22_6= RULE_DIFFERENT ) )
        // InternalJava.g:2357:1: (lv_testingSign_22_1= RULE_BT | lv_testingSign_22_2= RULE_ST | lv_testingSign_22_3= RULE_BE | lv_testingSign_22_4= RULE_SE | lv_testingSign_22_5= RULE_DOUBLE_EQUAL | lv_testingSign_22_6= RULE_DIFFERENT )
        {
        // InternalJava.g:2357:1: (lv_testingSign_22_1= RULE_BT | lv_testingSign_22_2= RULE_ST | lv_testingSign_22_3= RULE_BE | lv_testingSign_22_4= RULE_SE | lv_testingSign_22_5= RULE_DOUBLE_EQUAL | lv_testingSign_22_6= RULE_DIFFERENT )
        int alt88=6;
        switch ( input.LA(1) ) {
        case RULE_BT:
            {
            alt88=1;
            }
            break;
        case RULE_ST:
            {
            alt88=2;
            }
            break;
        case RULE_BE:
            {
            alt88=3;
            }
            break;
        case RULE_SE:
            {
            alt88=4;
            }
            break;
        case RULE_DOUBLE_EQUAL:
            {
            alt88=5;
            }
            break;
        case RULE_DIFFERENT:
            {
            alt88=6;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 88, 0, input);

            throw nvae;
        }

        switch (alt88) {
            case 1 :
                // InternalJava.g:2358:3: lv_testingSign_22_1= RULE_BT
                {
                lv_testingSign_22_1=(Token)match(input,RULE_BT,FOLLOW_35); if (state.failed) return ;

                }
                break;
            case 2 :
                // InternalJava.g:2373:8: lv_testingSign_22_2= RULE_ST
                {
                lv_testingSign_22_2=(Token)match(input,RULE_ST,FOLLOW_35); if (state.failed) return ;

                }
                break;
            case 3 :
                // InternalJava.g:2388:8: lv_testingSign_22_3= RULE_BE
                {
                lv_testingSign_22_3=(Token)match(input,RULE_BE,FOLLOW_35); if (state.failed) return ;

                }
                break;
            case 4 :
                // InternalJava.g:2403:8: lv_testingSign_22_4= RULE_SE
                {
                lv_testingSign_22_4=(Token)match(input,RULE_SE,FOLLOW_35); if (state.failed) return ;

                }
                break;
            case 5 :
                // InternalJava.g:2418:8: lv_testingSign_22_5= RULE_DOUBLE_EQUAL
                {
                lv_testingSign_22_5=(Token)match(input,RULE_DOUBLE_EQUAL,FOLLOW_35); if (state.failed) return ;

                }
                break;
            case 6 :
                // InternalJava.g:2433:8: lv_testingSign_22_6= RULE_DIFFERENT
                {
                lv_testingSign_22_6=(Token)match(input,RULE_DIFFERENT,FOLLOW_35); if (state.failed) return ;

                }
                break;

        }


        }


        }

        // InternalJava.g:2451:2: ( (lv_exp1_23_0= ruleExpression ) )
        // InternalJava.g:2452:1: (lv_exp1_23_0= ruleExpression )
        {
        // InternalJava.g:2452:1: (lv_exp1_23_0= ruleExpression )
        // InternalJava.g:2453:3: lv_exp1_23_0= ruleExpression
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getExpression_auxAccess().getExp1ExpressionParserRuleCall_7_1_0()); 
          	    
        }
        pushFollow(FOLLOW_33);
        lv_exp1_23_0=ruleExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // InternalJava.g:2469:2: ( (lv_aux_24_0= ruleExpression_aux ) )
        // InternalJava.g:2470:1: (lv_aux_24_0= ruleExpression_aux )
        {
        // InternalJava.g:2470:1: (lv_aux_24_0= ruleExpression_aux )
        // InternalJava.g:2471:3: lv_aux_24_0= ruleExpression_aux
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getExpression_auxAccess().getAuxExpression_auxParserRuleCall_7_2_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
        lv_aux_24_0=ruleExpression_aux();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred78_InternalJava

    // $ANTLR start synpred86_InternalJava
    public final void synpred86_InternalJava_fragment() throws RecognitionException {   
        Token lv_logicalSign_25_1=null;
        Token lv_logicalSign_25_2=null;
        Token lv_logicalSign_25_3=null;
        Token lv_logicalSign_25_4=null;
        Token lv_logicalSign_25_5=null;
        Token lv_logicalSign_25_6=null;
        Token lv_logicalSign_25_7=null;
        EObject lv_ampersand_26_0 = null;

        EObject lv_exp1_27_0 = null;

        EObject lv_aux_28_0 = null;


        // InternalJava.g:2488:6: ( ( ( ( ( (lv_logicalSign_25_1= RULE_OR | lv_logicalSign_25_2= RULE_OR_EQUAL | lv_logicalSign_25_3= RULE_EXP | lv_logicalSign_25_4= RULE_EXP_EQUAL | lv_logicalSign_25_5= RULE_DOUBLE_OR_EQUAL | lv_logicalSign_25_6= RULE_MODULE | lv_logicalSign_25_7= RULE_MODULE_EQUAL ) ) ) | ( (lv_ampersand_26_0= ruleAmpersand_Rule ) ) ) ( (lv_exp1_27_0= ruleExpression ) ) ( (lv_aux_28_0= ruleExpression_aux ) ) ) )
        // InternalJava.g:2488:6: ( ( ( ( (lv_logicalSign_25_1= RULE_OR | lv_logicalSign_25_2= RULE_OR_EQUAL | lv_logicalSign_25_3= RULE_EXP | lv_logicalSign_25_4= RULE_EXP_EQUAL | lv_logicalSign_25_5= RULE_DOUBLE_OR_EQUAL | lv_logicalSign_25_6= RULE_MODULE | lv_logicalSign_25_7= RULE_MODULE_EQUAL ) ) ) | ( (lv_ampersand_26_0= ruleAmpersand_Rule ) ) ) ( (lv_exp1_27_0= ruleExpression ) ) ( (lv_aux_28_0= ruleExpression_aux ) ) )
        {
        // InternalJava.g:2488:6: ( ( ( ( (lv_logicalSign_25_1= RULE_OR | lv_logicalSign_25_2= RULE_OR_EQUAL | lv_logicalSign_25_3= RULE_EXP | lv_logicalSign_25_4= RULE_EXP_EQUAL | lv_logicalSign_25_5= RULE_DOUBLE_OR_EQUAL | lv_logicalSign_25_6= RULE_MODULE | lv_logicalSign_25_7= RULE_MODULE_EQUAL ) ) ) | ( (lv_ampersand_26_0= ruleAmpersand_Rule ) ) ) ( (lv_exp1_27_0= ruleExpression ) ) ( (lv_aux_28_0= ruleExpression_aux ) ) )
        // InternalJava.g:2488:7: ( ( ( (lv_logicalSign_25_1= RULE_OR | lv_logicalSign_25_2= RULE_OR_EQUAL | lv_logicalSign_25_3= RULE_EXP | lv_logicalSign_25_4= RULE_EXP_EQUAL | lv_logicalSign_25_5= RULE_DOUBLE_OR_EQUAL | lv_logicalSign_25_6= RULE_MODULE | lv_logicalSign_25_7= RULE_MODULE_EQUAL ) ) ) | ( (lv_ampersand_26_0= ruleAmpersand_Rule ) ) ) ( (lv_exp1_27_0= ruleExpression ) ) ( (lv_aux_28_0= ruleExpression_aux ) )
        {
        // InternalJava.g:2488:7: ( ( ( (lv_logicalSign_25_1= RULE_OR | lv_logicalSign_25_2= RULE_OR_EQUAL | lv_logicalSign_25_3= RULE_EXP | lv_logicalSign_25_4= RULE_EXP_EQUAL | lv_logicalSign_25_5= RULE_DOUBLE_OR_EQUAL | lv_logicalSign_25_6= RULE_MODULE | lv_logicalSign_25_7= RULE_MODULE_EQUAL ) ) ) | ( (lv_ampersand_26_0= ruleAmpersand_Rule ) ) )
        int alt91=2;
        int LA91_0 = input.LA(1);

        if ( ((LA91_0>=RULE_MODULE && LA91_0<=RULE_MODULE_EQUAL)||(LA91_0>=RULE_OR && LA91_0<=RULE_DOUBLE_OR_EQUAL)) ) {
            alt91=1;
        }
        else if ( (LA91_0==RULE_AMPERSAND) ) {
            alt91=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 91, 0, input);

            throw nvae;
        }
        switch (alt91) {
            case 1 :
                // InternalJava.g:2488:8: ( ( (lv_logicalSign_25_1= RULE_OR | lv_logicalSign_25_2= RULE_OR_EQUAL | lv_logicalSign_25_3= RULE_EXP | lv_logicalSign_25_4= RULE_EXP_EQUAL | lv_logicalSign_25_5= RULE_DOUBLE_OR_EQUAL | lv_logicalSign_25_6= RULE_MODULE | lv_logicalSign_25_7= RULE_MODULE_EQUAL ) ) )
                {
                // InternalJava.g:2488:8: ( ( (lv_logicalSign_25_1= RULE_OR | lv_logicalSign_25_2= RULE_OR_EQUAL | lv_logicalSign_25_3= RULE_EXP | lv_logicalSign_25_4= RULE_EXP_EQUAL | lv_logicalSign_25_5= RULE_DOUBLE_OR_EQUAL | lv_logicalSign_25_6= RULE_MODULE | lv_logicalSign_25_7= RULE_MODULE_EQUAL ) ) )
                // InternalJava.g:2489:1: ( (lv_logicalSign_25_1= RULE_OR | lv_logicalSign_25_2= RULE_OR_EQUAL | lv_logicalSign_25_3= RULE_EXP | lv_logicalSign_25_4= RULE_EXP_EQUAL | lv_logicalSign_25_5= RULE_DOUBLE_OR_EQUAL | lv_logicalSign_25_6= RULE_MODULE | lv_logicalSign_25_7= RULE_MODULE_EQUAL ) )
                {
                // InternalJava.g:2489:1: ( (lv_logicalSign_25_1= RULE_OR | lv_logicalSign_25_2= RULE_OR_EQUAL | lv_logicalSign_25_3= RULE_EXP | lv_logicalSign_25_4= RULE_EXP_EQUAL | lv_logicalSign_25_5= RULE_DOUBLE_OR_EQUAL | lv_logicalSign_25_6= RULE_MODULE | lv_logicalSign_25_7= RULE_MODULE_EQUAL ) )
                // InternalJava.g:2490:1: (lv_logicalSign_25_1= RULE_OR | lv_logicalSign_25_2= RULE_OR_EQUAL | lv_logicalSign_25_3= RULE_EXP | lv_logicalSign_25_4= RULE_EXP_EQUAL | lv_logicalSign_25_5= RULE_DOUBLE_OR_EQUAL | lv_logicalSign_25_6= RULE_MODULE | lv_logicalSign_25_7= RULE_MODULE_EQUAL )
                {
                // InternalJava.g:2490:1: (lv_logicalSign_25_1= RULE_OR | lv_logicalSign_25_2= RULE_OR_EQUAL | lv_logicalSign_25_3= RULE_EXP | lv_logicalSign_25_4= RULE_EXP_EQUAL | lv_logicalSign_25_5= RULE_DOUBLE_OR_EQUAL | lv_logicalSign_25_6= RULE_MODULE | lv_logicalSign_25_7= RULE_MODULE_EQUAL )
                int alt90=7;
                switch ( input.LA(1) ) {
                case RULE_OR:
                    {
                    alt90=1;
                    }
                    break;
                case RULE_OR_EQUAL:
                    {
                    alt90=2;
                    }
                    break;
                case RULE_EXP:
                    {
                    alt90=3;
                    }
                    break;
                case RULE_EXP_EQUAL:
                    {
                    alt90=4;
                    }
                    break;
                case RULE_DOUBLE_OR_EQUAL:
                    {
                    alt90=5;
                    }
                    break;
                case RULE_MODULE:
                    {
                    alt90=6;
                    }
                    break;
                case RULE_MODULE_EQUAL:
                    {
                    alt90=7;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 90, 0, input);

                    throw nvae;
                }

                switch (alt90) {
                    case 1 :
                        // InternalJava.g:2491:3: lv_logicalSign_25_1= RULE_OR
                        {
                        lv_logicalSign_25_1=(Token)match(input,RULE_OR,FOLLOW_35); if (state.failed) return ;

                        }
                        break;
                    case 2 :
                        // InternalJava.g:2506:8: lv_logicalSign_25_2= RULE_OR_EQUAL
                        {
                        lv_logicalSign_25_2=(Token)match(input,RULE_OR_EQUAL,FOLLOW_35); if (state.failed) return ;

                        }
                        break;
                    case 3 :
                        // InternalJava.g:2521:8: lv_logicalSign_25_3= RULE_EXP
                        {
                        lv_logicalSign_25_3=(Token)match(input,RULE_EXP,FOLLOW_35); if (state.failed) return ;

                        }
                        break;
                    case 4 :
                        // InternalJava.g:2536:8: lv_logicalSign_25_4= RULE_EXP_EQUAL
                        {
                        lv_logicalSign_25_4=(Token)match(input,RULE_EXP_EQUAL,FOLLOW_35); if (state.failed) return ;

                        }
                        break;
                    case 5 :
                        // InternalJava.g:2551:8: lv_logicalSign_25_5= RULE_DOUBLE_OR_EQUAL
                        {
                        lv_logicalSign_25_5=(Token)match(input,RULE_DOUBLE_OR_EQUAL,FOLLOW_35); if (state.failed) return ;

                        }
                        break;
                    case 6 :
                        // InternalJava.g:2566:8: lv_logicalSign_25_6= RULE_MODULE
                        {
                        lv_logicalSign_25_6=(Token)match(input,RULE_MODULE,FOLLOW_35); if (state.failed) return ;

                        }
                        break;
                    case 7 :
                        // InternalJava.g:2581:8: lv_logicalSign_25_7= RULE_MODULE_EQUAL
                        {
                        lv_logicalSign_25_7=(Token)match(input,RULE_MODULE_EQUAL,FOLLOW_35); if (state.failed) return ;

                        }
                        break;

                }


                }


                }


                }
                break;
            case 2 :
                // InternalJava.g:2600:6: ( (lv_ampersand_26_0= ruleAmpersand_Rule ) )
                {
                // InternalJava.g:2600:6: ( (lv_ampersand_26_0= ruleAmpersand_Rule ) )
                // InternalJava.g:2601:1: (lv_ampersand_26_0= ruleAmpersand_Rule )
                {
                // InternalJava.g:2601:1: (lv_ampersand_26_0= ruleAmpersand_Rule )
                // InternalJava.g:2602:3: lv_ampersand_26_0= ruleAmpersand_Rule
                {
                if ( state.backtracking==0 ) {
                   
                  	        newCompositeNode(grammarAccess.getExpression_auxAccess().getAmpersandAmpersand_RuleParserRuleCall_8_0_1_0()); 
                  	    
                }
                pushFollow(FOLLOW_35);
                lv_ampersand_26_0=ruleAmpersand_Rule();

                state._fsp--;
                if (state.failed) return ;

                }


                }


                }
                break;

        }

        // InternalJava.g:2618:3: ( (lv_exp1_27_0= ruleExpression ) )
        // InternalJava.g:2619:1: (lv_exp1_27_0= ruleExpression )
        {
        // InternalJava.g:2619:1: (lv_exp1_27_0= ruleExpression )
        // InternalJava.g:2620:3: lv_exp1_27_0= ruleExpression
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getExpression_auxAccess().getExp1ExpressionParserRuleCall_8_1_0()); 
          	    
        }
        pushFollow(FOLLOW_33);
        lv_exp1_27_0=ruleExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // InternalJava.g:2636:2: ( (lv_aux_28_0= ruleExpression_aux ) )
        // InternalJava.g:2637:1: (lv_aux_28_0= ruleExpression_aux )
        {
        // InternalJava.g:2637:1: (lv_aux_28_0= ruleExpression_aux )
        // InternalJava.g:2638:3: lv_aux_28_0= ruleExpression_aux
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getExpression_auxAccess().getAuxExpression_auxParserRuleCall_8_2_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
        lv_aux_28_0=ruleExpression_aux();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred86_InternalJava

    // $ANTLR start synpred87_InternalJava
    public final void synpred87_InternalJava_fragment() throws RecognitionException {   
        Token this_WAT_29=null;
        Token this_COLON_31=null;
        EObject lv_exp1_30_0 = null;

        EObject lv_exp2_32_0 = null;

        EObject lv_aux_33_0 = null;


        // InternalJava.g:2655:6: ( (this_WAT_29= RULE_WAT ( (lv_exp1_30_0= ruleExpression ) ) this_COLON_31= RULE_COLON ( (lv_exp2_32_0= ruleExpression ) ) ( (lv_aux_33_0= ruleExpression_aux ) ) ) )
        // InternalJava.g:2655:6: (this_WAT_29= RULE_WAT ( (lv_exp1_30_0= ruleExpression ) ) this_COLON_31= RULE_COLON ( (lv_exp2_32_0= ruleExpression ) ) ( (lv_aux_33_0= ruleExpression_aux ) ) )
        {
        // InternalJava.g:2655:6: (this_WAT_29= RULE_WAT ( (lv_exp1_30_0= ruleExpression ) ) this_COLON_31= RULE_COLON ( (lv_exp2_32_0= ruleExpression ) ) ( (lv_aux_33_0= ruleExpression_aux ) ) )
        // InternalJava.g:2655:7: this_WAT_29= RULE_WAT ( (lv_exp1_30_0= ruleExpression ) ) this_COLON_31= RULE_COLON ( (lv_exp2_32_0= ruleExpression ) ) ( (lv_aux_33_0= ruleExpression_aux ) )
        {
        this_WAT_29=(Token)match(input,RULE_WAT,FOLLOW_35); if (state.failed) return ;
        // InternalJava.g:2659:1: ( (lv_exp1_30_0= ruleExpression ) )
        // InternalJava.g:2660:1: (lv_exp1_30_0= ruleExpression )
        {
        // InternalJava.g:2660:1: (lv_exp1_30_0= ruleExpression )
        // InternalJava.g:2661:3: lv_exp1_30_0= ruleExpression
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getExpression_auxAccess().getExp1ExpressionParserRuleCall_9_1_0()); 
          	    
        }
        pushFollow(FOLLOW_36);
        lv_exp1_30_0=ruleExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        this_COLON_31=(Token)match(input,RULE_COLON,FOLLOW_35); if (state.failed) return ;
        // InternalJava.g:2681:1: ( (lv_exp2_32_0= ruleExpression ) )
        // InternalJava.g:2682:1: (lv_exp2_32_0= ruleExpression )
        {
        // InternalJava.g:2682:1: (lv_exp2_32_0= ruleExpression )
        // InternalJava.g:2683:3: lv_exp2_32_0= ruleExpression
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getExpression_auxAccess().getExp2ExpressionParserRuleCall_9_3_0()); 
          	    
        }
        pushFollow(FOLLOW_33);
        lv_exp2_32_0=ruleExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // InternalJava.g:2699:2: ( (lv_aux_33_0= ruleExpression_aux ) )
        // InternalJava.g:2700:1: (lv_aux_33_0= ruleExpression_aux )
        {
        // InternalJava.g:2700:1: (lv_aux_33_0= ruleExpression_aux )
        // InternalJava.g:2701:3: lv_aux_33_0= ruleExpression_aux
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getExpression_auxAccess().getAuxExpression_auxParserRuleCall_9_4_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
        lv_aux_33_0=ruleExpression_aux();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred87_InternalJava

    // $ANTLR start synpred89_InternalJava
    public final void synpred89_InternalJava_fragment() throws RecognitionException {   
        Token lv_stringSign_34_1=null;
        Token lv_stringSign_34_2=null;
        EObject lv_exp1_35_0 = null;

        EObject lv_aux_36_0 = null;


        // InternalJava.g:2718:6: ( ( ( ( (lv_stringSign_34_1= RULE_PLUS | lv_stringSign_34_2= RULE_PLUS_EQUAL ) ) ) ( (lv_exp1_35_0= ruleExpression ) ) ( (lv_aux_36_0= ruleExpression_aux ) ) ) )
        // InternalJava.g:2718:6: ( ( ( (lv_stringSign_34_1= RULE_PLUS | lv_stringSign_34_2= RULE_PLUS_EQUAL ) ) ) ( (lv_exp1_35_0= ruleExpression ) ) ( (lv_aux_36_0= ruleExpression_aux ) ) )
        {
        // InternalJava.g:2718:6: ( ( ( (lv_stringSign_34_1= RULE_PLUS | lv_stringSign_34_2= RULE_PLUS_EQUAL ) ) ) ( (lv_exp1_35_0= ruleExpression ) ) ( (lv_aux_36_0= ruleExpression_aux ) ) )
        // InternalJava.g:2718:7: ( ( (lv_stringSign_34_1= RULE_PLUS | lv_stringSign_34_2= RULE_PLUS_EQUAL ) ) ) ( (lv_exp1_35_0= ruleExpression ) ) ( (lv_aux_36_0= ruleExpression_aux ) )
        {
        // InternalJava.g:2718:7: ( ( (lv_stringSign_34_1= RULE_PLUS | lv_stringSign_34_2= RULE_PLUS_EQUAL ) ) )
        // InternalJava.g:2719:1: ( (lv_stringSign_34_1= RULE_PLUS | lv_stringSign_34_2= RULE_PLUS_EQUAL ) )
        {
        // InternalJava.g:2719:1: ( (lv_stringSign_34_1= RULE_PLUS | lv_stringSign_34_2= RULE_PLUS_EQUAL ) )
        // InternalJava.g:2720:1: (lv_stringSign_34_1= RULE_PLUS | lv_stringSign_34_2= RULE_PLUS_EQUAL )
        {
        // InternalJava.g:2720:1: (lv_stringSign_34_1= RULE_PLUS | lv_stringSign_34_2= RULE_PLUS_EQUAL )
        int alt92=2;
        int LA92_0 = input.LA(1);

        if ( (LA92_0==RULE_PLUS) ) {
            alt92=1;
        }
        else if ( (LA92_0==RULE_PLUS_EQUAL) ) {
            alt92=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 92, 0, input);

            throw nvae;
        }
        switch (alt92) {
            case 1 :
                // InternalJava.g:2721:3: lv_stringSign_34_1= RULE_PLUS
                {
                lv_stringSign_34_1=(Token)match(input,RULE_PLUS,FOLLOW_35); if (state.failed) return ;

                }
                break;
            case 2 :
                // InternalJava.g:2736:8: lv_stringSign_34_2= RULE_PLUS_EQUAL
                {
                lv_stringSign_34_2=(Token)match(input,RULE_PLUS_EQUAL,FOLLOW_35); if (state.failed) return ;

                }
                break;

        }


        }


        }

        // InternalJava.g:2754:2: ( (lv_exp1_35_0= ruleExpression ) )
        // InternalJava.g:2755:1: (lv_exp1_35_0= ruleExpression )
        {
        // InternalJava.g:2755:1: (lv_exp1_35_0= ruleExpression )
        // InternalJava.g:2756:3: lv_exp1_35_0= ruleExpression
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getExpression_auxAccess().getExp1ExpressionParserRuleCall_10_1_0()); 
          	    
        }
        pushFollow(FOLLOW_33);
        lv_exp1_35_0=ruleExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // InternalJava.g:2772:2: ( (lv_aux_36_0= ruleExpression_aux ) )
        // InternalJava.g:2773:1: (lv_aux_36_0= ruleExpression_aux )
        {
        // InternalJava.g:2773:1: (lv_aux_36_0= ruleExpression_aux )
        // InternalJava.g:2774:3: lv_aux_36_0= ruleExpression_aux
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getExpression_auxAccess().getAuxExpression_auxParserRuleCall_10_2_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
        lv_aux_36_0=ruleExpression_aux();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred89_InternalJava

    // $ANTLR start synpred93_InternalJava
    public final void synpred93_InternalJava_fragment() throws RecognitionException {   
        Token lv_bitSign_37_1=null;
        Token lv_bitSign_37_2=null;
        Token lv_bitSign_37_3=null;
        Token lv_bitSign_37_4=null;
        EObject lv_expressionBit_38_0 = null;

        EObject lv_aux_39_0 = null;


        // InternalJava.g:2791:6: ( ( ( ( (lv_bitSign_37_1= RULE_R_SHIFT_EQUAL | lv_bitSign_37_2= RULE_L_SHIFT | lv_bitSign_37_3= RULE_R_SHIFT | lv_bitSign_37_4= RULE_SUPER_SHIFT ) ) ) ( (lv_expressionBit_38_0= ruleExpression ) ) ( (lv_aux_39_0= ruleExpression_aux ) ) ) )
        // InternalJava.g:2791:6: ( ( ( (lv_bitSign_37_1= RULE_R_SHIFT_EQUAL | lv_bitSign_37_2= RULE_L_SHIFT | lv_bitSign_37_3= RULE_R_SHIFT | lv_bitSign_37_4= RULE_SUPER_SHIFT ) ) ) ( (lv_expressionBit_38_0= ruleExpression ) ) ( (lv_aux_39_0= ruleExpression_aux ) ) )
        {
        // InternalJava.g:2791:6: ( ( ( (lv_bitSign_37_1= RULE_R_SHIFT_EQUAL | lv_bitSign_37_2= RULE_L_SHIFT | lv_bitSign_37_3= RULE_R_SHIFT | lv_bitSign_37_4= RULE_SUPER_SHIFT ) ) ) ( (lv_expressionBit_38_0= ruleExpression ) ) ( (lv_aux_39_0= ruleExpression_aux ) ) )
        // InternalJava.g:2791:7: ( ( (lv_bitSign_37_1= RULE_R_SHIFT_EQUAL | lv_bitSign_37_2= RULE_L_SHIFT | lv_bitSign_37_3= RULE_R_SHIFT | lv_bitSign_37_4= RULE_SUPER_SHIFT ) ) ) ( (lv_expressionBit_38_0= ruleExpression ) ) ( (lv_aux_39_0= ruleExpression_aux ) )
        {
        // InternalJava.g:2791:7: ( ( (lv_bitSign_37_1= RULE_R_SHIFT_EQUAL | lv_bitSign_37_2= RULE_L_SHIFT | lv_bitSign_37_3= RULE_R_SHIFT | lv_bitSign_37_4= RULE_SUPER_SHIFT ) ) )
        // InternalJava.g:2792:1: ( (lv_bitSign_37_1= RULE_R_SHIFT_EQUAL | lv_bitSign_37_2= RULE_L_SHIFT | lv_bitSign_37_3= RULE_R_SHIFT | lv_bitSign_37_4= RULE_SUPER_SHIFT ) )
        {
        // InternalJava.g:2792:1: ( (lv_bitSign_37_1= RULE_R_SHIFT_EQUAL | lv_bitSign_37_2= RULE_L_SHIFT | lv_bitSign_37_3= RULE_R_SHIFT | lv_bitSign_37_4= RULE_SUPER_SHIFT ) )
        // InternalJava.g:2793:1: (lv_bitSign_37_1= RULE_R_SHIFT_EQUAL | lv_bitSign_37_2= RULE_L_SHIFT | lv_bitSign_37_3= RULE_R_SHIFT | lv_bitSign_37_4= RULE_SUPER_SHIFT )
        {
        // InternalJava.g:2793:1: (lv_bitSign_37_1= RULE_R_SHIFT_EQUAL | lv_bitSign_37_2= RULE_L_SHIFT | lv_bitSign_37_3= RULE_R_SHIFT | lv_bitSign_37_4= RULE_SUPER_SHIFT )
        int alt93=4;
        switch ( input.LA(1) ) {
        case RULE_R_SHIFT_EQUAL:
            {
            alt93=1;
            }
            break;
        case RULE_L_SHIFT:
            {
            alt93=2;
            }
            break;
        case RULE_R_SHIFT:
            {
            alt93=3;
            }
            break;
        case RULE_SUPER_SHIFT:
            {
            alt93=4;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 93, 0, input);

            throw nvae;
        }

        switch (alt93) {
            case 1 :
                // InternalJava.g:2794:3: lv_bitSign_37_1= RULE_R_SHIFT_EQUAL
                {
                lv_bitSign_37_1=(Token)match(input,RULE_R_SHIFT_EQUAL,FOLLOW_35); if (state.failed) return ;

                }
                break;
            case 2 :
                // InternalJava.g:2809:8: lv_bitSign_37_2= RULE_L_SHIFT
                {
                lv_bitSign_37_2=(Token)match(input,RULE_L_SHIFT,FOLLOW_35); if (state.failed) return ;

                }
                break;
            case 3 :
                // InternalJava.g:2824:8: lv_bitSign_37_3= RULE_R_SHIFT
                {
                lv_bitSign_37_3=(Token)match(input,RULE_R_SHIFT,FOLLOW_35); if (state.failed) return ;

                }
                break;
            case 4 :
                // InternalJava.g:2839:8: lv_bitSign_37_4= RULE_SUPER_SHIFT
                {
                lv_bitSign_37_4=(Token)match(input,RULE_SUPER_SHIFT,FOLLOW_35); if (state.failed) return ;

                }
                break;

        }


        }


        }

        // InternalJava.g:2857:2: ( (lv_expressionBit_38_0= ruleExpression ) )
        // InternalJava.g:2858:1: (lv_expressionBit_38_0= ruleExpression )
        {
        // InternalJava.g:2858:1: (lv_expressionBit_38_0= ruleExpression )
        // InternalJava.g:2859:3: lv_expressionBit_38_0= ruleExpression
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getExpression_auxAccess().getExpressionBitExpressionParserRuleCall_11_1_0()); 
          	    
        }
        pushFollow(FOLLOW_33);
        lv_expressionBit_38_0=ruleExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // InternalJava.g:2875:2: ( (lv_aux_39_0= ruleExpression_aux ) )
        // InternalJava.g:2876:1: (lv_aux_39_0= ruleExpression_aux )
        {
        // InternalJava.g:2876:1: (lv_aux_39_0= ruleExpression_aux )
        // InternalJava.g:2877:3: lv_aux_39_0= ruleExpression_aux
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getExpression_auxAccess().getAuxExpression_auxParserRuleCall_11_2_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
        lv_aux_39_0=ruleExpression_aux();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred93_InternalJava

    // $ANTLR start synpred96_InternalJava
    public final void synpred96_InternalJava_fragment() throws RecognitionException {   
        Token lv_decimalDigits2_2_0=null;

        // InternalJava.g:3009:1: ( (lv_decimalDigits2_2_0= RULE_DECIMAL_DIGITS ) )
        // InternalJava.g:3009:1: (lv_decimalDigits2_2_0= RULE_DECIMAL_DIGITS )
        {
        // InternalJava.g:3009:1: (lv_decimalDigits2_2_0= RULE_DECIMAL_DIGITS )
        // InternalJava.g:3010:3: lv_decimalDigits2_2_0= RULE_DECIMAL_DIGITS
        {
        lv_decimalDigits2_2_0=(Token)match(input,RULE_DECIMAL_DIGITS,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred96_InternalJava

    // $ANTLR start synpred97_InternalJava
    public final void synpred97_InternalJava_fragment() throws RecognitionException {   
        AntlrDatatypeRuleToken lv_exp_3_0 = null;


        // InternalJava.g:3027:1: ( (lv_exp_3_0= ruleEXPOENT_PART ) )
        // InternalJava.g:3027:1: (lv_exp_3_0= ruleEXPOENT_PART )
        {
        // InternalJava.g:3027:1: (lv_exp_3_0= ruleEXPOENT_PART )
        // InternalJava.g:3028:3: lv_exp_3_0= ruleEXPOENT_PART
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getFloat_LiteralAccess().getExpEXPOENT_PARTParserRuleCall_3_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
        lv_exp_3_0=ruleEXPOENT_PART();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred97_InternalJava

    // $ANTLR start synpred99_InternalJava
    public final void synpred99_InternalJava_fragment() throws RecognitionException {   
        Token lv_exp_0_0=null;
        Token lv_exp1_1_0=null;

        // InternalJava.g:3065:2: ( ( ( (lv_exp_0_0= RULE_HEXA ) ) | ( (lv_exp1_1_0= RULE_DECIMAL_DIGITS ) ) ) )
        // InternalJava.g:3065:2: ( ( (lv_exp_0_0= RULE_HEXA ) ) | ( (lv_exp1_1_0= RULE_DECIMAL_DIGITS ) ) )
        {
        // InternalJava.g:3065:2: ( ( (lv_exp_0_0= RULE_HEXA ) ) | ( (lv_exp1_1_0= RULE_DECIMAL_DIGITS ) ) )
        int alt94=2;
        int LA94_0 = input.LA(1);

        if ( (LA94_0==RULE_HEXA) ) {
            alt94=1;
        }
        else if ( (LA94_0==RULE_DECIMAL_DIGITS) ) {
            alt94=2;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 94, 0, input);

            throw nvae;
        }
        switch (alt94) {
            case 1 :
                // InternalJava.g:3065:3: ( (lv_exp_0_0= RULE_HEXA ) )
                {
                // InternalJava.g:3065:3: ( (lv_exp_0_0= RULE_HEXA ) )
                // InternalJava.g:3066:1: (lv_exp_0_0= RULE_HEXA )
                {
                // InternalJava.g:3066:1: (lv_exp_0_0= RULE_HEXA )
                // InternalJava.g:3067:3: lv_exp_0_0= RULE_HEXA
                {
                lv_exp_0_0=(Token)match(input,RULE_HEXA,FOLLOW_2); if (state.failed) return ;

                }


                }


                }
                break;
            case 2 :
                // InternalJava.g:3084:6: ( (lv_exp1_1_0= RULE_DECIMAL_DIGITS ) )
                {
                // InternalJava.g:3084:6: ( (lv_exp1_1_0= RULE_DECIMAL_DIGITS ) )
                // InternalJava.g:3085:1: (lv_exp1_1_0= RULE_DECIMAL_DIGITS )
                {
                // InternalJava.g:3085:1: (lv_exp1_1_0= RULE_DECIMAL_DIGITS )
                // InternalJava.g:3086:3: lv_exp1_1_0= RULE_DECIMAL_DIGITS
                {
                lv_exp1_1_0=(Token)match(input,RULE_DECIMAL_DIGITS,FOLLOW_2); if (state.failed) return ;

                }


                }


                }
                break;

        }


        }
    }
    // $ANTLR end synpred99_InternalJava

    // $ANTLR start synpred100_InternalJava
    public final void synpred100_InternalJava_fragment() throws RecognitionException {   
        EObject lv_exp2_2_0 = null;


        // InternalJava.g:3103:6: ( ( (lv_exp2_2_0= ruleFloat_Literal ) ) )
        // InternalJava.g:3103:6: ( (lv_exp2_2_0= ruleFloat_Literal ) )
        {
        // InternalJava.g:3103:6: ( (lv_exp2_2_0= ruleFloat_Literal ) )
        // InternalJava.g:3104:1: (lv_exp2_2_0= ruleFloat_Literal )
        {
        // InternalJava.g:3104:1: (lv_exp2_2_0= ruleFloat_Literal )
        // InternalJava.g:3105:3: lv_exp2_2_0= ruleFloat_Literal
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getLiteral_ExpressionAccess().getExp2Float_LiteralParserRuleCall_1_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
        lv_exp2_2_0=ruleFloat_Literal();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred100_InternalJava

    // $ANTLR start synpred102_InternalJava
    public final void synpred102_InternalJava_fragment() throws RecognitionException {   
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_className_1_0 = null;

        EObject lv_argList_3_0 = null;


        // InternalJava.g:3184:2: ( ( ( (lv_className_1_0= ruleClass_name ) ) otherlv_2= '(' ( (lv_argList_3_0= ruleArg_List ) ) otherlv_4= ')' ) )
        // InternalJava.g:3184:2: ( ( (lv_className_1_0= ruleClass_name ) ) otherlv_2= '(' ( (lv_argList_3_0= ruleArg_List ) ) otherlv_4= ')' )
        {
        // InternalJava.g:3184:2: ( ( (lv_className_1_0= ruleClass_name ) ) otherlv_2= '(' ( (lv_argList_3_0= ruleArg_List ) ) otherlv_4= ')' )
        // InternalJava.g:3184:3: ( (lv_className_1_0= ruleClass_name ) ) otherlv_2= '(' ( (lv_argList_3_0= ruleArg_List ) ) otherlv_4= ')'
        {
        // InternalJava.g:3184:3: ( (lv_className_1_0= ruleClass_name ) )
        // InternalJava.g:3185:1: (lv_className_1_0= ruleClass_name )
        {
        // InternalJava.g:3185:1: (lv_className_1_0= ruleClass_name )
        // InternalJava.g:3186:3: lv_className_1_0= ruleClass_name
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getCreating_ExpressionAccess().getClassNameClass_nameParserRuleCall_1_0_0_0()); 
          	    
        }
        pushFollow(FOLLOW_17);
        lv_className_1_0=ruleClass_name();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_2=(Token)match(input,78,FOLLOW_35); if (state.failed) return ;
        // InternalJava.g:3206:1: ( (lv_argList_3_0= ruleArg_List ) )
        // InternalJava.g:3207:1: (lv_argList_3_0= ruleArg_List )
        {
        // InternalJava.g:3207:1: (lv_argList_3_0= ruleArg_List )
        // InternalJava.g:3208:3: lv_argList_3_0= ruleArg_List
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getCreating_ExpressionAccess().getArgListArg_ListParserRuleCall_1_0_2_0()); 
          	    
        }
        pushFollow(FOLLOW_19);
        lv_argList_3_0=ruleArg_List();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_4=(Token)match(input,79,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred102_InternalJava

    // $ANTLR start synpred103_InternalJava
    public final void synpred103_InternalJava_fragment() throws RecognitionException {   
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_expression_7_0 = null;


        // InternalJava.g:3247:4: (otherlv_6= '[' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= ']' )
        // InternalJava.g:3247:4: otherlv_6= '[' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= ']'
        {
        otherlv_6=(Token)match(input,80,FOLLOW_35); if (state.failed) return ;
        // InternalJava.g:3251:1: ( (lv_expression_7_0= ruleExpression ) )
        // InternalJava.g:3252:1: (lv_expression_7_0= ruleExpression )
        {
        // InternalJava.g:3252:1: (lv_expression_7_0= ruleExpression )
        // InternalJava.g:3253:3: lv_expression_7_0= ruleExpression
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getCreating_ExpressionAccess().getExpressionExpressionParserRuleCall_1_1_1_1_0()); 
          	    
        }
        pushFollow(FOLLOW_21);
        lv_expression_7_0=ruleExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_8=(Token)match(input,81,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred103_InternalJava

    // $ANTLR start synpred106_InternalJava
    public final void synpred106_InternalJava_fragment() throws RecognitionException {   
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        AntlrDatatypeRuleToken lv_typeSpecifier_5_0 = null;

        EObject lv_expression_7_0 = null;


        // InternalJava.g:3229:6: ( ( ( (lv_typeSpecifier_5_0= ruleType_specifier ) ) (otherlv_6= '[' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= ']' )? ( (otherlv_9= '[' otherlv_10= ']' ) | otherlv_11= '[]' )* ) )
        // InternalJava.g:3229:6: ( ( (lv_typeSpecifier_5_0= ruleType_specifier ) ) (otherlv_6= '[' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= ']' )? ( (otherlv_9= '[' otherlv_10= ']' ) | otherlv_11= '[]' )* )
        {
        // InternalJava.g:3229:6: ( ( (lv_typeSpecifier_5_0= ruleType_specifier ) ) (otherlv_6= '[' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= ']' )? ( (otherlv_9= '[' otherlv_10= ']' ) | otherlv_11= '[]' )* )
        // InternalJava.g:3229:7: ( (lv_typeSpecifier_5_0= ruleType_specifier ) ) (otherlv_6= '[' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= ']' )? ( (otherlv_9= '[' otherlv_10= ']' ) | otherlv_11= '[]' )*
        {
        // InternalJava.g:3229:7: ( (lv_typeSpecifier_5_0= ruleType_specifier ) )
        // InternalJava.g:3230:1: (lv_typeSpecifier_5_0= ruleType_specifier )
        {
        // InternalJava.g:3230:1: (lv_typeSpecifier_5_0= ruleType_specifier )
        // InternalJava.g:3231:3: lv_typeSpecifier_5_0= ruleType_specifier
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getCreating_ExpressionAccess().getTypeSpecifierType_specifierParserRuleCall_1_1_0_0()); 
          	    
        }
        pushFollow(FOLLOW_26);
        lv_typeSpecifier_5_0=ruleType_specifier();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // InternalJava.g:3247:2: (otherlv_6= '[' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= ']' )?
        int alt95=2;
        int LA95_0 = input.LA(1);

        if ( (LA95_0==80) ) {
            int LA95_1 = input.LA(2);

            if ( (LA95_1==RULE_ID||(LA95_1>=RULE_NULL && LA95_1<=RULE_THIS)||(LA95_1>=RULE_INCREMENT && LA95_1<=RULE_DECREMENT)||LA95_1==RULE_MINUS||(LA95_1>=RULE_DECIMAL_DIGITS && LA95_1<=RULE_FALSE)||LA95_1==78) ) {
                alt95=1;
            }
        }
        switch (alt95) {
            case 1 :
                // InternalJava.g:3247:4: otherlv_6= '[' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= ']'
                {
                otherlv_6=(Token)match(input,80,FOLLOW_35); if (state.failed) return ;
                // InternalJava.g:3251:1: ( (lv_expression_7_0= ruleExpression ) )
                // InternalJava.g:3252:1: (lv_expression_7_0= ruleExpression )
                {
                // InternalJava.g:3252:1: (lv_expression_7_0= ruleExpression )
                // InternalJava.g:3253:3: lv_expression_7_0= ruleExpression
                {
                if ( state.backtracking==0 ) {
                   
                  	        newCompositeNode(grammarAccess.getCreating_ExpressionAccess().getExpressionExpressionParserRuleCall_1_1_1_1_0()); 
                  	    
                }
                pushFollow(FOLLOW_21);
                lv_expression_7_0=ruleExpression();

                state._fsp--;
                if (state.failed) return ;

                }


                }

                otherlv_8=(Token)match(input,81,FOLLOW_26); if (state.failed) return ;

                }
                break;

        }

        // InternalJava.g:3273:3: ( (otherlv_9= '[' otherlv_10= ']' ) | otherlv_11= '[]' )*
        loop96:
        do {
            int alt96=3;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==80) ) {
                alt96=1;
            }
            else if ( (LA96_0==82) ) {
                alt96=2;
            }


            switch (alt96) {
        	case 1 :
        	    // InternalJava.g:3273:4: (otherlv_9= '[' otherlv_10= ']' )
        	    {
        	    // InternalJava.g:3273:4: (otherlv_9= '[' otherlv_10= ']' )
        	    // InternalJava.g:3273:6: otherlv_9= '[' otherlv_10= ']'
        	    {
        	    otherlv_9=(Token)match(input,80,FOLLOW_21); if (state.failed) return ;
        	    otherlv_10=(Token)match(input,81,FOLLOW_26); if (state.failed) return ;

        	    }


        	    }
        	    break;
        	case 2 :
        	    // InternalJava.g:3282:7: otherlv_11= '[]'
        	    {
        	    otherlv_11=(Token)match(input,82,FOLLOW_26); if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop96;
            }
        } while (true);


        }


        }
    }
    // $ANTLR end synpred106_InternalJava

    // $ANTLR start synpred126_InternalJava
    public final void synpred126_InternalJava_fragment() throws RecognitionException {   
        EObject lv_variable_1_0 = null;


        // InternalJava.g:3989:6: ( ( (lv_variable_1_0= ruleVariable_declaration ) ) )
        // InternalJava.g:3989:6: ( (lv_variable_1_0= ruleVariable_declaration ) )
        {
        // InternalJava.g:3989:6: ( (lv_variable_1_0= ruleVariable_declaration ) )
        // InternalJava.g:3990:1: (lv_variable_1_0= ruleVariable_declaration )
        {
        // InternalJava.g:3990:1: (lv_variable_1_0= ruleVariable_declaration )
        // InternalJava.g:3991:3: lv_variable_1_0= ruleVariable_declaration
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getStatementAccess().getVariableVariable_declarationParserRuleCall_1_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
        lv_variable_1_0=ruleVariable_declaration();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred126_InternalJava

    // $ANTLR start synpred127_InternalJava
    public final void synpred127_InternalJava_fragment() throws RecognitionException {   
        EObject lv_expressionx_2_0 = null;


        // InternalJava.g:4008:6: ( ( (lv_expressionx_2_0= ruleExpression ) ) )
        // InternalJava.g:4008:6: ( (lv_expressionx_2_0= ruleExpression ) )
        {
        // InternalJava.g:4008:6: ( (lv_expressionx_2_0= ruleExpression ) )
        // InternalJava.g:4009:1: (lv_expressionx_2_0= ruleExpression )
        {
        // InternalJava.g:4009:1: (lv_expressionx_2_0= ruleExpression )
        // InternalJava.g:4010:3: lv_expressionx_2_0= ruleExpression
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getStatementAccess().getExpressionxExpressionParserRuleCall_2_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
        lv_expressionx_2_0=ruleExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred127_InternalJava

    // $ANTLR start synpred136_InternalJava
    public final void synpred136_InternalJava_fragment() throws RecognitionException {   
        Token lv_name_10_0=null;
        Token this_COLON_11=null;
        EObject lv_statement_12_0 = null;


        // InternalJava.g:4164:6: ( ( ( (lv_name_10_0= RULE_ID ) ) this_COLON_11= RULE_COLON ( (lv_statement_12_0= ruleStatement ) ) ) )
        // InternalJava.g:4164:6: ( ( (lv_name_10_0= RULE_ID ) ) this_COLON_11= RULE_COLON ( (lv_statement_12_0= ruleStatement ) ) )
        {
        // InternalJava.g:4164:6: ( ( (lv_name_10_0= RULE_ID ) ) this_COLON_11= RULE_COLON ( (lv_statement_12_0= ruleStatement ) ) )
        // InternalJava.g:4164:7: ( (lv_name_10_0= RULE_ID ) ) this_COLON_11= RULE_COLON ( (lv_statement_12_0= ruleStatement ) )
        {
        // InternalJava.g:4164:7: ( (lv_name_10_0= RULE_ID ) )
        // InternalJava.g:4165:1: (lv_name_10_0= RULE_ID )
        {
        // InternalJava.g:4165:1: (lv_name_10_0= RULE_ID )
        // InternalJava.g:4166:3: lv_name_10_0= RULE_ID
        {
        lv_name_10_0=(Token)match(input,RULE_ID,FOLLOW_36); if (state.failed) return ;

        }


        }

        this_COLON_11=(Token)match(input,RULE_COLON,FOLLOW_42); if (state.failed) return ;
        // InternalJava.g:4186:1: ( (lv_statement_12_0= ruleStatement ) )
        // InternalJava.g:4187:1: (lv_statement_12_0= ruleStatement )
        {
        // InternalJava.g:4187:1: (lv_statement_12_0= ruleStatement )
        // InternalJava.g:4188:3: lv_statement_12_0= ruleStatement
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getStatementAccess().getStatementStatementParserRuleCall_10_2_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
        lv_statement_12_0=ruleStatement();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred136_InternalJava

    // $ANTLR start synpred142_InternalJava
    public final void synpred142_InternalJava_fragment() throws RecognitionException {   
        Token this_CASE_6=null;
        Token this_COLON_8=null;
        EObject lv_case_exp_7_0 = null;


        // InternalJava.g:4377:2: ( (this_CASE_6= RULE_CASE ( (lv_case_exp_7_0= ruleExpression ) ) this_COLON_8= RULE_COLON ) )
        // InternalJava.g:4377:2: (this_CASE_6= RULE_CASE ( (lv_case_exp_7_0= ruleExpression ) ) this_COLON_8= RULE_COLON )
        {
        // InternalJava.g:4377:2: (this_CASE_6= RULE_CASE ( (lv_case_exp_7_0= ruleExpression ) ) this_COLON_8= RULE_COLON )
        // InternalJava.g:4377:3: this_CASE_6= RULE_CASE ( (lv_case_exp_7_0= ruleExpression ) ) this_COLON_8= RULE_COLON
        {
        this_CASE_6=(Token)match(input,RULE_CASE,FOLLOW_35); if (state.failed) return ;
        // InternalJava.g:4381:1: ( (lv_case_exp_7_0= ruleExpression ) )
        // InternalJava.g:4382:1: (lv_case_exp_7_0= ruleExpression )
        {
        // InternalJava.g:4382:1: (lv_case_exp_7_0= ruleExpression )
        // InternalJava.g:4383:3: lv_case_exp_7_0= ruleExpression
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getSwitch_StatementAccess().getCase_expExpressionParserRuleCall_6_0_1_0()); 
          	    
        }
        pushFollow(FOLLOW_36);
        lv_case_exp_7_0=ruleExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        this_COLON_8=(Token)match(input,RULE_COLON,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred142_InternalJava

    // $ANTLR start synpred143_InternalJava
    public final void synpred143_InternalJava_fragment() throws RecognitionException {   
        EObject lv_statements_9_0 = null;


        // InternalJava.g:4404:6: ( ( (lv_statements_9_0= ruleStatement ) ) )
        // InternalJava.g:4404:6: ( (lv_statements_9_0= ruleStatement ) )
        {
        // InternalJava.g:4404:6: ( (lv_statements_9_0= ruleStatement ) )
        // InternalJava.g:4405:1: (lv_statements_9_0= ruleStatement )
        {
        // InternalJava.g:4405:1: (lv_statements_9_0= ruleStatement )
        // InternalJava.g:4406:3: lv_statements_9_0= ruleStatement
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getSwitch_StatementAccess().getStatementsStatementParserRuleCall_6_1_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
        lv_statements_9_0=ruleStatement();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred143_InternalJava

    // $ANTLR start synpred147_InternalJava
    public final void synpred147_InternalJava_fragment() throws RecognitionException {   
        EObject lv_variable_2_0 = null;


        // InternalJava.g:4508:2: ( ( (lv_variable_2_0= ruleVariable_declaration ) ) )
        // InternalJava.g:4508:2: ( (lv_variable_2_0= ruleVariable_declaration ) )
        {
        // InternalJava.g:4508:2: ( (lv_variable_2_0= ruleVariable_declaration ) )
        // InternalJava.g:4509:1: (lv_variable_2_0= ruleVariable_declaration )
        {
        // InternalJava.g:4509:1: (lv_variable_2_0= ruleVariable_declaration )
        // InternalJava.g:4510:3: lv_variable_2_0= ruleVariable_declaration
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getFor_StatementAccess().getVariableVariable_declarationParserRuleCall_2_0_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
        lv_variable_2_0=ruleVariable_declaration();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred147_InternalJava

    // $ANTLR start synpred148_InternalJava
    public final void synpred148_InternalJava_fragment() throws RecognitionException {   
        Token this_EOL_4=null;
        EObject lv_expression_3_0 = null;


        // InternalJava.g:4527:6: ( ( ( (lv_expression_3_0= ruleExpression ) ) this_EOL_4= RULE_EOL ) )
        // InternalJava.g:4527:6: ( ( (lv_expression_3_0= ruleExpression ) ) this_EOL_4= RULE_EOL )
        {
        // InternalJava.g:4527:6: ( ( (lv_expression_3_0= ruleExpression ) ) this_EOL_4= RULE_EOL )
        // InternalJava.g:4527:7: ( (lv_expression_3_0= ruleExpression ) ) this_EOL_4= RULE_EOL
        {
        // InternalJava.g:4527:7: ( (lv_expression_3_0= ruleExpression ) )
        // InternalJava.g:4528:1: (lv_expression_3_0= ruleExpression )
        {
        // InternalJava.g:4528:1: (lv_expression_3_0= ruleExpression )
        // InternalJava.g:4529:3: lv_expression_3_0= ruleExpression
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getFor_StatementAccess().getExpressionExpressionParserRuleCall_2_1_0_0()); 
          	    
        }
        pushFollow(FOLLOW_44);
        lv_expression_3_0=ruleExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        this_EOL_4=(Token)match(input,RULE_EOL,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred148_InternalJava

    // $ANTLR start synpred152_InternalJava
    public final void synpred152_InternalJava_fragment() throws RecognitionException {   
        Token this_ELSE_5=null;
        EObject lv_elseStatement_6_0 = null;


        // InternalJava.g:4845:3: ( ( ( RULE_ELSE )=>this_ELSE_5= RULE_ELSE ) ( (lv_elseStatement_6_0= ruleStatement ) ) )
        // InternalJava.g:4845:3: ( ( RULE_ELSE )=>this_ELSE_5= RULE_ELSE ) ( (lv_elseStatement_6_0= ruleStatement ) )
        {
        // InternalJava.g:4845:3: ( ( RULE_ELSE )=>this_ELSE_5= RULE_ELSE )
        // InternalJava.g:4845:4: ( RULE_ELSE )=>this_ELSE_5= RULE_ELSE
        {
        this_ELSE_5=(Token)match(input,RULE_ELSE,FOLLOW_42); if (state.failed) return ;

        }

        // InternalJava.g:4849:2: ( (lv_elseStatement_6_0= ruleStatement ) )
        // InternalJava.g:4850:1: (lv_elseStatement_6_0= ruleStatement )
        {
        // InternalJava.g:4850:1: (lv_elseStatement_6_0= ruleStatement )
        // InternalJava.g:4851:3: lv_elseStatement_6_0= ruleStatement
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getIf_StatementAccess().getElseStatementStatementParserRuleCall_5_1_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
        lv_elseStatement_6_0=ruleStatement();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred152_InternalJava

    // $ANTLR start synpred157_InternalJava
    public final void synpred157_InternalJava_fragment() throws RecognitionException {   
        Token lv_catchs_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_parameters_4_0 = null;

        EObject lv_catchStatements_6_0 = null;


        // InternalJava.g:5045:3: ( ( ( ( RULE_CATCH ) )=> (lv_catchs_2_0= RULE_CATCH ) ) otherlv_3= '(' ( (lv_parameters_4_0= ruleParameter ) ) otherlv_5= ')' ( (lv_catchStatements_6_0= ruleStatement ) ) )
        // InternalJava.g:5045:3: ( ( ( RULE_CATCH ) )=> (lv_catchs_2_0= RULE_CATCH ) ) otherlv_3= '(' ( (lv_parameters_4_0= ruleParameter ) ) otherlv_5= ')' ( (lv_catchStatements_6_0= ruleStatement ) )
        {
        // InternalJava.g:5045:3: ( ( ( RULE_CATCH ) )=> (lv_catchs_2_0= RULE_CATCH ) )
        // InternalJava.g:5045:4: ( ( RULE_CATCH ) )=> (lv_catchs_2_0= RULE_CATCH )
        {
        // InternalJava.g:5051:1: (lv_catchs_2_0= RULE_CATCH )
        // InternalJava.g:5052:3: lv_catchs_2_0= RULE_CATCH
        {
        lv_catchs_2_0=(Token)match(input,RULE_CATCH,FOLLOW_17); if (state.failed) return ;

        }


        }

        otherlv_3=(Token)match(input,78,FOLLOW_14); if (state.failed) return ;
        // InternalJava.g:5072:1: ( (lv_parameters_4_0= ruleParameter ) )
        // InternalJava.g:5073:1: (lv_parameters_4_0= ruleParameter )
        {
        // InternalJava.g:5073:1: (lv_parameters_4_0= ruleParameter )
        // InternalJava.g:5074:3: lv_parameters_4_0= ruleParameter
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getTry_statementAccess().getParametersParameterParserRuleCall_2_2_0()); 
          	    
        }
        pushFollow(FOLLOW_19);
        lv_parameters_4_0=ruleParameter();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        otherlv_5=(Token)match(input,79,FOLLOW_42); if (state.failed) return ;
        // InternalJava.g:5094:1: ( (lv_catchStatements_6_0= ruleStatement ) )
        // InternalJava.g:5095:1: (lv_catchStatements_6_0= ruleStatement )
        {
        // InternalJava.g:5095:1: (lv_catchStatements_6_0= ruleStatement )
        // InternalJava.g:5096:3: lv_catchStatements_6_0= ruleStatement
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getTry_statementAccess().getCatchStatementsStatementParserRuleCall_2_4_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
        lv_catchStatements_6_0=ruleStatement();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred157_InternalJava

    // $ANTLR start synpred159_InternalJava
    public final void synpred159_InternalJava_fragment() throws RecognitionException {   
        Token lv_finally_7_0=null;
        EObject lv_finallyStatement_8_0 = null;


        // InternalJava.g:5112:5: ( ( ( ( RULE_FINALLY ) )=> (lv_finally_7_0= RULE_FINALLY ) ) ( (lv_finallyStatement_8_0= ruleStatement ) ) )
        // InternalJava.g:5112:5: ( ( ( RULE_FINALLY ) )=> (lv_finally_7_0= RULE_FINALLY ) ) ( (lv_finallyStatement_8_0= ruleStatement ) )
        {
        // InternalJava.g:5112:5: ( ( ( RULE_FINALLY ) )=> (lv_finally_7_0= RULE_FINALLY ) )
        // InternalJava.g:5112:6: ( ( RULE_FINALLY ) )=> (lv_finally_7_0= RULE_FINALLY )
        {
        // InternalJava.g:5118:1: (lv_finally_7_0= RULE_FINALLY )
        // InternalJava.g:5119:3: lv_finally_7_0= RULE_FINALLY
        {
        lv_finally_7_0=(Token)match(input,RULE_FINALLY,FOLLOW_42); if (state.failed) return ;

        }


        }

        // InternalJava.g:5135:2: ( (lv_finallyStatement_8_0= ruleStatement ) )
        // InternalJava.g:5136:1: (lv_finallyStatement_8_0= ruleStatement )
        {
        // InternalJava.g:5136:1: (lv_finallyStatement_8_0= ruleStatement )
        // InternalJava.g:5137:3: lv_finallyStatement_8_0= ruleStatement
        {
        if ( state.backtracking==0 ) {
           
          	        newCompositeNode(grammarAccess.getTry_statementAccess().getFinallyStatementStatementParserRuleCall_3_1_0()); 
          	    
        }
        pushFollow(FOLLOW_2);
        lv_finallyStatement_8_0=ruleStatement();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred159_InternalJava

    // $ANTLR start synpred161_InternalJava
    public final void synpred161_InternalJava_fragment() throws RecognitionException {   
        Token kw=null;
        Token this_ID_1=null;

        // InternalJava.g:5261:2: (kw= '.' this_ID_1= RULE_ID )
        // InternalJava.g:5261:2: kw= '.' this_ID_1= RULE_ID
        {
        kw=(Token)match(input,83,FOLLOW_8); if (state.failed) return ;
        this_ID_1=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred161_InternalJava

    // Delegated rules

    public final boolean synpred152_InternalJava() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred152_InternalJava_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred100_InternalJava() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred100_InternalJava_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred78_InternalJava() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred78_InternalJava_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred59_InternalJava() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred59_InternalJava_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred136_InternalJava() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred136_InternalJava_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred57_InternalJava() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred57_InternalJava_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred58_InternalJava() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred58_InternalJava_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred93_InternalJava() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred93_InternalJava_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred60_InternalJava() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred60_InternalJava_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred96_InternalJava() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred96_InternalJava_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred106_InternalJava() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred106_InternalJava_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred157_InternalJava() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred157_InternalJava_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred97_InternalJava() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred97_InternalJava_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred102_InternalJava() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred102_InternalJava_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred159_InternalJava() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred159_InternalJava_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred62_InternalJava() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred62_InternalJava_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred99_InternalJava() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred99_InternalJava_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred103_InternalJava() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred103_InternalJava_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred147_InternalJava() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred147_InternalJava_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred86_InternalJava() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred86_InternalJava_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred142_InternalJava() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred142_InternalJava_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred87_InternalJava() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred87_InternalJava_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred127_InternalJava() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred127_InternalJava_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred143_InternalJava() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred143_InternalJava_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred161_InternalJava() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred161_InternalJava_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred126_InternalJava() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred126_InternalJava_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred56_InternalJava() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred56_InternalJava_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred89_InternalJava() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred89_InternalJava_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred72_InternalJava() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred72_InternalJava_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred148_InternalJava() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred148_InternalJava_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA5 dfa5 = new DFA5(this);
    protected DFA17 dfa17 = new DFA17(this);
    protected DFA37 dfa37 = new DFA37(this);
    protected DFA46 dfa46 = new DFA46(this);
    protected DFA54 dfa54 = new DFA54(this);
    protected DFA52 dfa52 = new DFA52(this);
    protected DFA64 dfa64 = new DFA64(this);
    protected DFA65 dfa65 = new DFA65(this);
    protected DFA68 dfa68 = new DFA68(this);
    protected DFA78 dfa78 = new DFA78(this);
    static final String dfa_1s = "\5\uffff";
    static final String dfa_2s = "\3\6\2\uffff";
    static final String dfa_3s = "\3\114\2\uffff";
    static final String dfa_4s = "\3\uffff\1\1\1\2";
    static final String dfa_5s = "\5\uffff}>";
    static final String[] dfa_6s = {
            "\1\4\57\uffff\1\1\1\2\24\uffff\1\3",
            "\1\4\57\uffff\1\1\1\2\24\uffff\1\3",
            "\1\4\57\uffff\1\1\1\2\24\uffff\1\3",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "227:3: ( ( (lv_name_1_0= ruleClass_declaration ) ) | ( (lv_name_2_0= ruleInterface_declaration ) ) )";
        }
    }
    static final String dfa_7s = "\26\uffff";
    static final String dfa_8s = "\15\7\1\121\1\7\1\5\1\7\1\uffff\1\7\2\uffff\1\7";
    static final String dfa_9s = "\3\134\11\122\1\123\1\121\2\122\1\7\1\uffff\1\122\2\uffff\1\123";
    static final String dfa_10s = "\21\uffff\1\2\1\uffff\1\1\1\3\1\uffff";
    static final String dfa_11s = "\26\uffff}>";
    static final String[] dfa_12s = {
            "\1\14\56\uffff\1\1\1\2\34\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13",
            "\1\14\56\uffff\1\1\1\2\34\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13",
            "\1\14\56\uffff\1\1\1\2\34\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13",
            "\1\17\110\uffff\1\15\1\uffff\1\16",
            "\1\17\110\uffff\1\15\1\uffff\1\16",
            "\1\17\110\uffff\1\15\1\uffff\1\16",
            "\1\17\110\uffff\1\15\1\uffff\1\16",
            "\1\17\110\uffff\1\15\1\uffff\1\16",
            "\1\17\110\uffff\1\15\1\uffff\1\16",
            "\1\17\110\uffff\1\15\1\uffff\1\16",
            "\1\17\110\uffff\1\15\1\uffff\1\16",
            "\1\17\110\uffff\1\15\1\uffff\1\16",
            "\1\17\106\uffff\1\21\1\uffff\1\15\1\uffff\1\16\1\20",
            "\1\22",
            "\1\17\110\uffff\1\15\1\uffff\1\16",
            "\1\23\3\uffff\2\23\103\uffff\1\24\1\uffff\1\23\1\uffff\1\23",
            "\1\25",
            "",
            "\1\17\110\uffff\1\15\1\uffff\1\16",
            "",
            "",
            "\1\17\110\uffff\1\15\1\uffff\1\16\1\20"
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final char[] dfa_8 = DFA.unpackEncodedStringToUnsignedChars(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final short[] dfa_10 = DFA.unpackEncodedString(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[][] dfa_12 = unpackEncodedStringArray(dfa_12s);

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_8;
            this.max = dfa_9;
            this.accept = dfa_10;
            this.special = dfa_11;
            this.transition = dfa_12;
        }
        public String getDescription() {
            return "591:3: ( ( (lv_name_1_0= ruleVariable_declaration ) ) | ( (lv_name_2_0= ruleConstructor_declaration ) ) | ( (lv_name_3_0= ruleMethod_declaration ) ) )";
        }
    }
    static final String dfa_13s = "\13\uffff";
    static final String dfa_14s = "\1\7\12\uffff";
    static final String dfa_15s = "\1\116\12\uffff";
    static final String dfa_16s = "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12";
    static final String dfa_17s = "\13\uffff}>";
    static final String[] dfa_18s = {
            "\1\12\3\uffff\1\7\1\10\1\11\1\uffff\2\1\2\uffff\1\1\31\uffff\4\6\1\5\1\3\3\2\30\uffff\1\4",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final char[] dfa_14 = DFA.unpackEncodedStringToUnsignedChars(dfa_14s);
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final short[] dfa_16 = DFA.unpackEncodedString(dfa_16s);
    static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
    static final short[][] dfa_18 = unpackEncodedStringArray(dfa_18s);

    class DFA37 extends DFA {

        public DFA37(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 37;
            this.eot = dfa_13;
            this.eof = dfa_13;
            this.min = dfa_14;
            this.max = dfa_15;
            this.accept = dfa_16;
            this.special = dfa_17;
            this.transition = dfa_18;
        }
        public String getDescription() {
            return "1492:1: ( ( ( ( ( ( ruleNumeric_Expression_NR ) ) )=> ( (lv_numericExpression3_0_0= ruleNumeric_Expression_NR ) ) ) ( (lv_aux_1_0= ruleExpression_aux ) ) ) | ( ( (lv_logicalExpression_2_0= ruleLogical_Expression_NR ) ) ( (lv_aux_3_0= ruleExpression_aux ) ) ) | ( ( (lv_bitExpression_4_0= ruleBit_Expression_NR ) ) ( (lv_aux_5_0= ruleExpression_aux ) ) ) | ( ( ( ( ( ruleCast_Expression ) ) )=> ( (lv_castExpression_6_0= ruleCast_Expression ) ) ) ( (lv_aux_7_0= ruleExpression_aux ) ) ) | ( ( ( ( ( ruleCreating_Expression ) ) )=> ( (lv_creatingExpression_8_0= ruleCreating_Expression ) ) ) ( (lv_aux_9_0= ruleExpression_aux ) ) ) | ( ( (lv_literalExpression_10_0= ruleLiteral_Expression ) ) ( (lv_aux_11_0= ruleExpression_aux ) ) ) | ( ( (lv_null_12_0= RULE_NULL ) ) ( (lv_aux_13_0= ruleExpression_aux ) ) ) | ( ( (lv_super_14_0= RULE_SUPER ) ) ( (lv_aux_15_0= ruleExpression_aux ) ) ) | ( ( (lv_this_16_0= RULE_THIS ) ) ( (lv_aux_17_0= ruleExpression_aux ) ) ) | ( ( (lv_name_18_0= RULE_ID ) ) ( (lv_aux_19_0= ruleExpression_aux ) ) ) )";
        }
    }
    static final String dfa_19s = "\60\uffff";
    static final String dfa_20s = "\1\43\57\uffff";
    static final String dfa_21s = "\1\5\42\0\15\uffff";
    static final String dfa_22s = "\1\136\42\0\15\uffff";
    static final String dfa_23s = "\43\uffff\1\15\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\13\1\11\1\10\1\12\1\14";
    static final String dfa_24s = "\1\uffff\1\27\1\33\1\5\1\7\1\37\1\11\1\14\1\15\1\26\1\24\1\2\1\36\1\10\1\4\1\20\1\23\1\31\1\12\1\6\1\21\1\16\1\32\1\30\1\17\1\34\1\25\1\3\1\41\1\13\1\0\1\22\1\1\1\35\1\40\15\uffff}>";
    static final String[] dfa_25s = {
            "\1\43\1\uffff\1\43\1\uffff\1\4\1\uffff\3\43\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\36\1\43\1\37\1\40\1\41\1\42\1\35\27\43\6\uffff\2\43\2\uffff\1\1\1\43\1\2\1\43\1\uffff\1\3\13\43",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
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
            ""
    };

    static final short[] dfa_19 = DFA.unpackEncodedString(dfa_19s);
    static final short[] dfa_20 = DFA.unpackEncodedString(dfa_20s);
    static final char[] dfa_21 = DFA.unpackEncodedStringToUnsignedChars(dfa_21s);
    static final char[] dfa_22 = DFA.unpackEncodedStringToUnsignedChars(dfa_22s);
    static final short[] dfa_23 = DFA.unpackEncodedString(dfa_23s);
    static final short[] dfa_24 = DFA.unpackEncodedString(dfa_24s);
    static final short[][] dfa_25 = unpackEncodedStringArray(dfa_25s);

    class DFA46 extends DFA {

        public DFA46(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 46;
            this.eot = dfa_19;
            this.eof = dfa_20;
            this.min = dfa_21;
            this.max = dfa_22;
            this.accept = dfa_23;
            this.special = dfa_24;
            this.transition = dfa_25;
        }
        public String getDescription() {
            return "1894:1: ( ( (otherlv_0= '(' ( (lv_argList_1_0= ruleArg_List ) )? otherlv_2= ')' ) ( (lv_aux_3_0= ruleExpression_aux ) ) ) | ( (otherlv_4= '[' ( (lv_expression2_5_0= ruleExpression ) ) otherlv_6= ']' ) ( (lv_aux_7_0= ruleExpression_aux ) ) ) | ( (otherlv_8= '.' ( (lv_expression2_9_0= ruleExpression ) ) ) ( (lv_aux_10_0= ruleExpression_aux ) ) ) | ( (this_COMMA_11= RULE_COMMA ( (lv_expressionComma_12_0= ruleExpression ) ) ) ( (lv_aux_13_0= ruleExpression_aux ) ) ) | ( (this_INSTANCEOF_14= RULE_INSTANCEOF ( (lv_name_15_0= ruleClass_name ) ) ) ( (lv_aux_16_0= ruleExpression_aux ) ) ) | ( ( ( (lv_sgin_17_1= RULE_INCREMENT | lv_sgin_17_2= RULE_DECREMENT ) ) ) ( (lv_aux_18_0= ruleExpression_aux ) ) ) | ( ( ( (lv_numericSign_19_1= RULE_PLUS | lv_numericSign_19_2= RULE_PLUS_EQUAL | lv_numericSign_19_3= RULE_MINUS | lv_numericSign_19_4= RULE_MINUS_EQUAL | lv_numericSign_19_5= RULE_MULTIPLY | lv_numericSign_19_6= RULE_MULTIPLY_EQUAL | lv_numericSign_19_7= RULE_DIVIDE | lv_numericSign_19_8= RULE_DIVIDE_EQUAL | lv_numericSign_19_9= RULE_MODULE | lv_numericSign_19_10= RULE_MODULE_EQUAL ) ) ) ( (lv_exp2_20_0= ruleExpression ) ) ( (lv_aux_21_0= ruleExpression_aux ) ) ) | ( ( ( (lv_testingSign_22_1= RULE_BT | lv_testingSign_22_2= RULE_ST | lv_testingSign_22_3= RULE_BE | lv_testingSign_22_4= RULE_SE | lv_testingSign_22_5= RULE_DOUBLE_EQUAL | lv_testingSign_22_6= RULE_DIFFERENT ) ) ) ( (lv_exp1_23_0= ruleExpression ) ) ( (lv_aux_24_0= ruleExpression_aux ) ) ) | ( ( ( ( (lv_logicalSign_25_1= RULE_OR | lv_logicalSign_25_2= RULE_OR_EQUAL | lv_logicalSign_25_3= RULE_EXP | lv_logicalSign_25_4= RULE_EXP_EQUAL | lv_logicalSign_25_5= RULE_DOUBLE_OR_EQUAL | lv_logicalSign_25_6= RULE_MODULE | lv_logicalSign_25_7= RULE_MODULE_EQUAL ) ) ) | ( (lv_ampersand_26_0= ruleAmpersand_Rule ) ) ) ( (lv_exp1_27_0= ruleExpression ) ) ( (lv_aux_28_0= ruleExpression_aux ) ) ) | (this_WAT_29= RULE_WAT ( (lv_exp1_30_0= ruleExpression ) ) this_COLON_31= RULE_COLON ( (lv_exp2_32_0= ruleExpression ) ) ( (lv_aux_33_0= ruleExpression_aux ) ) ) | ( ( ( (lv_stringSign_34_1= RULE_PLUS | lv_stringSign_34_2= RULE_PLUS_EQUAL ) ) ) ( (lv_exp1_35_0= ruleExpression ) ) ( (lv_aux_36_0= ruleExpression_aux ) ) ) | ( ( ( (lv_bitSign_37_1= RULE_R_SHIFT_EQUAL | lv_bitSign_37_2= RULE_L_SHIFT | lv_bitSign_37_3= RULE_R_SHIFT | lv_bitSign_37_4= RULE_SUPER_SHIFT ) ) ) ( (lv_expressionBit_38_0= ruleExpression ) ) ( (lv_aux_39_0= ruleExpression_aux ) ) ) | () )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA46_30 = input.LA(1);

                         
                        int index46_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred87_InternalJava()) ) {s = 46;}

                        else if ( (true) ) {s = 35;}

                         
                        input.seek(index46_30);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA46_32 = input.LA(1);

                         
                        int index46_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred93_InternalJava()) ) {s = 47;}

                        else if ( (true) ) {s = 35;}

                         
                        input.seek(index46_32);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA46_11 = input.LA(1);

                         
                        int index46_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred72_InternalJava()) ) {s = 42;}

                        else if ( (true) ) {s = 35;}

                         
                        input.seek(index46_11);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA46_27 = input.LA(1);

                         
                        int index46_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalJava()) ) {s = 44;}

                        else if ( (true) ) {s = 35;}

                         
                        input.seek(index46_27);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA46_14 = input.LA(1);

                         
                        int index46_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred72_InternalJava()) ) {s = 42;}

                        else if ( (true) ) {s = 35;}

                         
                        input.seek(index46_14);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA46_3 = input.LA(1);

                         
                        int index46_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred58_InternalJava()) ) {s = 38;}

                        else if ( (true) ) {s = 35;}

                         
                        input.seek(index46_3);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA46_19 = input.LA(1);

                         
                        int index46_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred78_InternalJava()) ) {s = 45;}

                        else if ( (true) ) {s = 35;}

                         
                        input.seek(index46_19);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA46_4 = input.LA(1);

                         
                        int index46_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred59_InternalJava()) ) {s = 39;}

                        else if ( (true) ) {s = 35;}

                         
                        input.seek(index46_4);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA46_13 = input.LA(1);

                         
                        int index46_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred72_InternalJava()) ) {s = 42;}

                        else if ( (true) ) {s = 35;}

                         
                        input.seek(index46_13);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA46_6 = input.LA(1);

                         
                        int index46_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred62_InternalJava()) ) {s = 41;}

                        else if ( (true) ) {s = 35;}

                         
                        input.seek(index46_6);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA46_18 = input.LA(1);

                         
                        int index46_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred78_InternalJava()) ) {s = 45;}

                        else if ( (true) ) {s = 35;}

                         
                        input.seek(index46_18);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA46_29 = input.LA(1);

                         
                        int index46_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalJava()) ) {s = 44;}

                        else if ( (true) ) {s = 35;}

                         
                        input.seek(index46_29);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA46_7 = input.LA(1);

                         
                        int index46_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred62_InternalJava()) ) {s = 41;}

                        else if ( (true) ) {s = 35;}

                         
                        input.seek(index46_7);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA46_8 = input.LA(1);

                         
                        int index46_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred72_InternalJava()) ) {s = 42;}

                        else if ( (synpred89_InternalJava()) ) {s = 43;}

                        else if ( (true) ) {s = 35;}

                         
                        input.seek(index46_8);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA46_21 = input.LA(1);

                         
                        int index46_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred78_InternalJava()) ) {s = 45;}

                        else if ( (true) ) {s = 35;}

                         
                        input.seek(index46_21);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA46_24 = input.LA(1);

                         
                        int index46_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalJava()) ) {s = 44;}

                        else if ( (true) ) {s = 35;}

                         
                        input.seek(index46_24);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA46_15 = input.LA(1);

                         
                        int index46_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred72_InternalJava()) ) {s = 42;}

                        else if ( (true) ) {s = 35;}

                         
                        input.seek(index46_15);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA46_20 = input.LA(1);

                         
                        int index46_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred78_InternalJava()) ) {s = 45;}

                        else if ( (true) ) {s = 35;}

                         
                        input.seek(index46_20);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA46_31 = input.LA(1);

                         
                        int index46_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred93_InternalJava()) ) {s = 47;}

                        else if ( (true) ) {s = 35;}

                         
                        input.seek(index46_31);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA46_16 = input.LA(1);

                         
                        int index46_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred72_InternalJava()) ) {s = 42;}

                        else if ( (synpred86_InternalJava()) ) {s = 44;}

                        else if ( (true) ) {s = 35;}

                         
                        input.seek(index46_16);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA46_10 = input.LA(1);

                         
                        int index46_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred72_InternalJava()) ) {s = 42;}

                        else if ( (true) ) {s = 35;}

                         
                        input.seek(index46_10);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA46_26 = input.LA(1);

                         
                        int index46_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalJava()) ) {s = 44;}

                        else if ( (true) ) {s = 35;}

                         
                        input.seek(index46_26);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA46_9 = input.LA(1);

                         
                        int index46_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred72_InternalJava()) ) {s = 42;}

                        else if ( (synpred89_InternalJava()) ) {s = 43;}

                        else if ( (true) ) {s = 35;}

                         
                        input.seek(index46_9);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA46_1 = input.LA(1);

                         
                        int index46_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred56_InternalJava()) ) {s = 36;}

                        else if ( (true) ) {s = 35;}

                         
                        input.seek(index46_1);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA46_23 = input.LA(1);

                         
                        int index46_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred78_InternalJava()) ) {s = 45;}

                        else if ( (true) ) {s = 35;}

                         
                        input.seek(index46_23);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA46_17 = input.LA(1);

                         
                        int index46_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred72_InternalJava()) ) {s = 42;}

                        else if ( (synpred86_InternalJava()) ) {s = 44;}

                        else if ( (true) ) {s = 35;}

                         
                        input.seek(index46_17);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA46_22 = input.LA(1);

                         
                        int index46_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred78_InternalJava()) ) {s = 45;}

                        else if ( (true) ) {s = 35;}

                         
                        input.seek(index46_22);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA46_2 = input.LA(1);

                         
                        int index46_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred57_InternalJava()) ) {s = 37;}

                        else if ( (true) ) {s = 35;}

                         
                        input.seek(index46_2);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA46_25 = input.LA(1);

                         
                        int index46_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalJava()) ) {s = 44;}

                        else if ( (true) ) {s = 35;}

                         
                        input.seek(index46_25);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA46_33 = input.LA(1);

                         
                        int index46_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred93_InternalJava()) ) {s = 47;}

                        else if ( (true) ) {s = 35;}

                         
                        input.seek(index46_33);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA46_12 = input.LA(1);

                         
                        int index46_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred72_InternalJava()) ) {s = 42;}

                        else if ( (true) ) {s = 35;}

                         
                        input.seek(index46_12);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA46_5 = input.LA(1);

                         
                        int index46_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred60_InternalJava()) ) {s = 40;}

                        else if ( (true) ) {s = 35;}

                         
                        input.seek(index46_5);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA46_34 = input.LA(1);

                         
                        int index46_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred93_InternalJava()) ) {s = 47;}

                        else if ( (true) ) {s = 35;}

                         
                        input.seek(index46_34);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA46_28 = input.LA(1);

                         
                        int index46_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred86_InternalJava()) ) {s = 44;}

                        else if ( (true) ) {s = 35;}

                         
                        input.seek(index46_28);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 46, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_26s = "\15\uffff";
    static final String dfa_27s = "\1\7\1\0\13\uffff";
    static final String dfa_28s = "\1\134\1\0\13\uffff";
    static final String dfa_29s = "\2\uffff\1\2\10\uffff\1\3\1\1";
    static final String dfa_30s = "\1\uffff\1\0\13\uffff}>";
    static final String[] dfa_31s = {
            "\1\1\106\uffff\1\13\5\uffff\11\2",
            "\1\uffff",
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
            ""
    };

    static final short[] dfa_26 = DFA.unpackEncodedString(dfa_26s);
    static final char[] dfa_27 = DFA.unpackEncodedStringToUnsignedChars(dfa_27s);
    static final char[] dfa_28 = DFA.unpackEncodedStringToUnsignedChars(dfa_28s);
    static final short[] dfa_29 = DFA.unpackEncodedString(dfa_29s);
    static final short[] dfa_30 = DFA.unpackEncodedString(dfa_30s);
    static final short[][] dfa_31 = unpackEncodedStringArray(dfa_31s);

    class DFA54 extends DFA {

        public DFA54(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 54;
            this.eot = dfa_26;
            this.eof = dfa_26;
            this.min = dfa_27;
            this.max = dfa_28;
            this.accept = dfa_29;
            this.special = dfa_30;
            this.transition = dfa_31;
        }
        public String getDescription() {
            return "3184:1: ( ( ( (lv_className_1_0= ruleClass_name ) ) otherlv_2= '(' ( (lv_argList_3_0= ruleArg_List ) ) otherlv_4= ')' ) | ( ( (lv_typeSpecifier_5_0= ruleType_specifier ) ) (otherlv_6= '[' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= ']' )? ( (otherlv_9= '[' otherlv_10= ']' ) | otherlv_11= '[]' )* ) | (otherlv_12= '(' ( (lv_expression_13_0= ruleExpression ) ) otherlv_14= ')' ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA54_1 = input.LA(1);

                         
                        int index54_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred102_InternalJava()) ) {s = 12;}

                        else if ( (synpred106_InternalJava()) ) {s = 2;}

                         
                        input.seek(index54_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 54, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_32s = "\122\uffff";
    static final String dfa_33s = "\1\2\121\uffff";
    static final String dfa_34s = "\1\5\1\0\120\uffff";
    static final String dfa_35s = "\1\136\1\0\120\uffff";
    static final String dfa_36s = "\2\uffff\1\2\116\uffff\1\1";
    static final String dfa_37s = "\1\uffff\1\0\120\uffff}>";
    static final String[] dfa_38s = {
            "\1\2\1\uffff\1\2\1\uffff\1\2\1\uffff\71\2\6\uffff\2\2\2\uffff\2\2\1\1\16\2",
            "\1\uffff",
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
            "",
            ""
    };

    static final short[] dfa_32 = DFA.unpackEncodedString(dfa_32s);
    static final short[] dfa_33 = DFA.unpackEncodedString(dfa_33s);
    static final char[] dfa_34 = DFA.unpackEncodedStringToUnsignedChars(dfa_34s);
    static final char[] dfa_35 = DFA.unpackEncodedStringToUnsignedChars(dfa_35s);
    static final short[] dfa_36 = DFA.unpackEncodedString(dfa_36s);
    static final short[] dfa_37 = DFA.unpackEncodedString(dfa_37s);
    static final short[][] dfa_38 = unpackEncodedStringArray(dfa_38s);

    class DFA52 extends DFA {

        public DFA52(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 52;
            this.eot = dfa_32;
            this.eof = dfa_33;
            this.min = dfa_34;
            this.max = dfa_35;
            this.accept = dfa_36;
            this.special = dfa_37;
            this.transition = dfa_38;
        }
        public String getDescription() {
            return "3247:2: (otherlv_6= '[' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= ']' )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA52_1 = input.LA(1);

                         
                        int index52_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred103_InternalJava()) ) {s = 81;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index52_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 52, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_39s = "\52\uffff";
    static final String dfa_40s = "\1\5\14\uffff\1\0\34\uffff";
    static final String dfa_41s = "\1\136\14\uffff\1\0\34\uffff";
    static final String dfa_42s = "\1\uffff\1\1\1\2\13\uffff\1\3\17\uffff\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\14\1\15\1\16\1\13\1\17";
    static final String dfa_43s = "\15\uffff\1\0\34\uffff}>";
    static final String[] dfa_44s = {
            "\1\47\1\uffff\1\15\3\uffff\3\16\1\uffff\2\16\2\uffff\1\16\31\uffff\11\16\2\2\1\42\2\uffff\1\41\1\40\1\37\1\36\1\uffff\1\1\1\44\10\uffff\1\43\3\uffff\1\16\5\uffff\11\2\1\45\1\46",
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
            "\1\uffff",
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
            "",
            ""
    };

    static final short[] dfa_39 = DFA.unpackEncodedString(dfa_39s);
    static final char[] dfa_40 = DFA.unpackEncodedStringToUnsignedChars(dfa_40s);
    static final char[] dfa_41 = DFA.unpackEncodedStringToUnsignedChars(dfa_41s);
    static final short[] dfa_42 = DFA.unpackEncodedString(dfa_42s);
    static final short[] dfa_43 = DFA.unpackEncodedString(dfa_43s);
    static final short[][] dfa_44 = unpackEncodedStringArray(dfa_44s);

    class DFA64 extends DFA {

        public DFA64(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 64;
            this.eot = dfa_39;
            this.eof = dfa_39;
            this.min = dfa_40;
            this.max = dfa_41;
            this.accept = dfa_42;
            this.special = dfa_43;
            this.transition = dfa_44;
        }
        public String getDescription() {
            return "3970:1: ( ( (lv_returnSmt_0_0= ruleReturn_Statement ) ) | ( (lv_variable_1_0= ruleVariable_declaration ) ) | ( (lv_expressionx_2_0= ruleExpression ) ) | ( (lv_ifStatement_3_0= ruleIf_Statement ) ) | ( (lv_doStatement_4_0= ruleDo_Statement ) ) | ( (lv_whileStatement_5_0= ruleWhile_Statement ) ) | ( (lv_forStatement_6_0= ruleFor_Statement ) ) | ( (lv_switchStatement_7_0= ruleSwitch_Statement ) ) | ( ( ( ( ruleStatement_block ) ) )=> ( (lv_statementBlock_8_0= ruleStatement_block ) ) ) | ( (lv_try_9_0= ruleTry_statement ) ) | ( ( (lv_name_10_0= RULE_ID ) ) this_COLON_11= RULE_COLON ( (lv_statement_12_0= ruleStatement ) ) ) | ( () otherlv_14= 'break' ( (lv_name_15_0= RULE_ID ) )? this_EOL_16= RULE_EOL ) | ( () otherlv_18= 'continue' ( (lv_name_19_0= RULE_ID ) )? this_EOL_20= RULE_EOL ) | ( () this_EOL_22= RULE_EOL ) | ( ( (lv_variableDeclarator_23_0= ruleVariable_declarator ) ) this_EOL_24= RULE_EOL ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA64_13 = input.LA(1);

                         
                        int index64_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred126_InternalJava()) ) {s = 2;}

                        else if ( (synpred127_InternalJava()) ) {s = 14;}

                        else if ( (synpred136_InternalJava()) ) {s = 40;}

                        else if ( (true) ) {s = 41;}

                         
                        input.seek(index64_13);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 64, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_45s = "\55\uffff";
    static final String dfa_46s = "\1\5\1\uffff\50\0\3\uffff";
    static final String dfa_47s = "\1\136\1\uffff\50\0\3\uffff";
    static final String dfa_48s = "\1\uffff\1\3\51\uffff\1\1\1\2";
    static final String dfa_49s = "\2\uffff\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46\1\47\3\uffff}>";
    static final String[] dfa_50s = {
            "\1\51\1\uffff\1\17\3\uffff\1\35\1\36\1\37\1\uffff\1\21\1\22\2\uffff\1\20\31\uffff\1\32\1\31\1\33\1\34\1\30\1\26\1\23\1\24\1\25\1\4\1\5\1\44\1\2\1\1\1\43\1\42\1\41\1\40\1\uffff\1\3\1\46\10\uffff\1\45\1\1\2\uffff\1\27\5\uffff\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\47\1\50",
            "",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            ""
    };

    static final short[] dfa_45 = DFA.unpackEncodedString(dfa_45s);
    static final char[] dfa_46 = DFA.unpackEncodedStringToUnsignedChars(dfa_46s);
    static final char[] dfa_47 = DFA.unpackEncodedStringToUnsignedChars(dfa_47s);
    static final short[] dfa_48 = DFA.unpackEncodedString(dfa_48s);
    static final short[] dfa_49 = DFA.unpackEncodedString(dfa_49s);
    static final short[][] dfa_50 = unpackEncodedStringArray(dfa_50s);

    class DFA65 extends DFA {

        public DFA65(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 65;
            this.eot = dfa_45;
            this.eof = dfa_45;
            this.min = dfa_46;
            this.max = dfa_47;
            this.accept = dfa_48;
            this.special = dfa_49;
            this.transition = dfa_50;
        }
        public String getDescription() {
            return "()* loopback of 4377:1: ( (this_CASE_6= RULE_CASE ( (lv_case_exp_7_0= ruleExpression ) ) this_COLON_8= RULE_COLON ) | ( (lv_statements_9_0= ruleStatement ) ) )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA65_2 = input.LA(1);

                         
                        int index65_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred142_InternalJava()) ) {s = 43;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index65_2);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA65_3 = input.LA(1);

                         
                        int index65_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred143_InternalJava()) ) {s = 44;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index65_3);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA65_4 = input.LA(1);

                         
                        int index65_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred143_InternalJava()) ) {s = 44;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index65_4);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA65_5 = input.LA(1);

                         
                        int index65_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred143_InternalJava()) ) {s = 44;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index65_5);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA65_6 = input.LA(1);

                         
                        int index65_6 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred143_InternalJava()) ) {s = 44;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index65_6);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA65_7 = input.LA(1);

                         
                        int index65_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred143_InternalJava()) ) {s = 44;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index65_7);
                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA65_8 = input.LA(1);

                         
                        int index65_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred143_InternalJava()) ) {s = 44;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index65_8);
                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA65_9 = input.LA(1);

                         
                        int index65_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred143_InternalJava()) ) {s = 44;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index65_9);
                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA65_10 = input.LA(1);

                         
                        int index65_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred143_InternalJava()) ) {s = 44;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index65_10);
                        if ( s>=0 ) return s;
                        break;
                    case 9 : 
                        int LA65_11 = input.LA(1);

                         
                        int index65_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred143_InternalJava()) ) {s = 44;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index65_11);
                        if ( s>=0 ) return s;
                        break;
                    case 10 : 
                        int LA65_12 = input.LA(1);

                         
                        int index65_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred143_InternalJava()) ) {s = 44;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index65_12);
                        if ( s>=0 ) return s;
                        break;
                    case 11 : 
                        int LA65_13 = input.LA(1);

                         
                        int index65_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred143_InternalJava()) ) {s = 44;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index65_13);
                        if ( s>=0 ) return s;
                        break;
                    case 12 : 
                        int LA65_14 = input.LA(1);

                         
                        int index65_14 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred143_InternalJava()) ) {s = 44;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index65_14);
                        if ( s>=0 ) return s;
                        break;
                    case 13 : 
                        int LA65_15 = input.LA(1);

                         
                        int index65_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred143_InternalJava()) ) {s = 44;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index65_15);
                        if ( s>=0 ) return s;
                        break;
                    case 14 : 
                        int LA65_16 = input.LA(1);

                         
                        int index65_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred143_InternalJava()) ) {s = 44;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index65_16);
                        if ( s>=0 ) return s;
                        break;
                    case 15 : 
                        int LA65_17 = input.LA(1);

                         
                        int index65_17 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred143_InternalJava()) ) {s = 44;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index65_17);
                        if ( s>=0 ) return s;
                        break;
                    case 16 : 
                        int LA65_18 = input.LA(1);

                         
                        int index65_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred143_InternalJava()) ) {s = 44;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index65_18);
                        if ( s>=0 ) return s;
                        break;
                    case 17 : 
                        int LA65_19 = input.LA(1);

                         
                        int index65_19 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred143_InternalJava()) ) {s = 44;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index65_19);
                        if ( s>=0 ) return s;
                        break;
                    case 18 : 
                        int LA65_20 = input.LA(1);

                         
                        int index65_20 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred143_InternalJava()) ) {s = 44;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index65_20);
                        if ( s>=0 ) return s;
                        break;
                    case 19 : 
                        int LA65_21 = input.LA(1);

                         
                        int index65_21 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred143_InternalJava()) ) {s = 44;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index65_21);
                        if ( s>=0 ) return s;
                        break;
                    case 20 : 
                        int LA65_22 = input.LA(1);

                         
                        int index65_22 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred143_InternalJava()) ) {s = 44;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index65_22);
                        if ( s>=0 ) return s;
                        break;
                    case 21 : 
                        int LA65_23 = input.LA(1);

                         
                        int index65_23 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred143_InternalJava()) ) {s = 44;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index65_23);
                        if ( s>=0 ) return s;
                        break;
                    case 22 : 
                        int LA65_24 = input.LA(1);

                         
                        int index65_24 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred143_InternalJava()) ) {s = 44;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index65_24);
                        if ( s>=0 ) return s;
                        break;
                    case 23 : 
                        int LA65_25 = input.LA(1);

                         
                        int index65_25 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred143_InternalJava()) ) {s = 44;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index65_25);
                        if ( s>=0 ) return s;
                        break;
                    case 24 : 
                        int LA65_26 = input.LA(1);

                         
                        int index65_26 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred143_InternalJava()) ) {s = 44;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index65_26);
                        if ( s>=0 ) return s;
                        break;
                    case 25 : 
                        int LA65_27 = input.LA(1);

                         
                        int index65_27 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred143_InternalJava()) ) {s = 44;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index65_27);
                        if ( s>=0 ) return s;
                        break;
                    case 26 : 
                        int LA65_28 = input.LA(1);

                         
                        int index65_28 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred143_InternalJava()) ) {s = 44;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index65_28);
                        if ( s>=0 ) return s;
                        break;
                    case 27 : 
                        int LA65_29 = input.LA(1);

                         
                        int index65_29 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred143_InternalJava()) ) {s = 44;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index65_29);
                        if ( s>=0 ) return s;
                        break;
                    case 28 : 
                        int LA65_30 = input.LA(1);

                         
                        int index65_30 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred143_InternalJava()) ) {s = 44;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index65_30);
                        if ( s>=0 ) return s;
                        break;
                    case 29 : 
                        int LA65_31 = input.LA(1);

                         
                        int index65_31 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred143_InternalJava()) ) {s = 44;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index65_31);
                        if ( s>=0 ) return s;
                        break;
                    case 30 : 
                        int LA65_32 = input.LA(1);

                         
                        int index65_32 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred143_InternalJava()) ) {s = 44;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index65_32);
                        if ( s>=0 ) return s;
                        break;
                    case 31 : 
                        int LA65_33 = input.LA(1);

                         
                        int index65_33 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred143_InternalJava()) ) {s = 44;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index65_33);
                        if ( s>=0 ) return s;
                        break;
                    case 32 : 
                        int LA65_34 = input.LA(1);

                         
                        int index65_34 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred143_InternalJava()) ) {s = 44;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index65_34);
                        if ( s>=0 ) return s;
                        break;
                    case 33 : 
                        int LA65_35 = input.LA(1);

                         
                        int index65_35 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred143_InternalJava()) ) {s = 44;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index65_35);
                        if ( s>=0 ) return s;
                        break;
                    case 34 : 
                        int LA65_36 = input.LA(1);

                         
                        int index65_36 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred143_InternalJava()) ) {s = 44;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index65_36);
                        if ( s>=0 ) return s;
                        break;
                    case 35 : 
                        int LA65_37 = input.LA(1);

                         
                        int index65_37 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred143_InternalJava()) ) {s = 44;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index65_37);
                        if ( s>=0 ) return s;
                        break;
                    case 36 : 
                        int LA65_38 = input.LA(1);

                         
                        int index65_38 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred143_InternalJava()) ) {s = 44;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index65_38);
                        if ( s>=0 ) return s;
                        break;
                    case 37 : 
                        int LA65_39 = input.LA(1);

                         
                        int index65_39 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred143_InternalJava()) ) {s = 44;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index65_39);
                        if ( s>=0 ) return s;
                        break;
                    case 38 : 
                        int LA65_40 = input.LA(1);

                         
                        int index65_40 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred143_InternalJava()) ) {s = 44;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index65_40);
                        if ( s>=0 ) return s;
                        break;
                    case 39 : 
                        int LA65_41 = input.LA(1);

                         
                        int index65_41 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred143_InternalJava()) ) {s = 44;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index65_41);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 65, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_51s = "\21\uffff";
    static final String dfa_52s = "\1\5\1\uffff\1\5\2\uffff\2\7\1\5\2\7\1\5\2\7\1\5\2\7\1\0";
    static final String dfa_53s = "\1\134\1\uffff\1\123\2\uffff\1\121\1\116\1\123\1\121\1\116\1\123\1\121\1\116\1\123\1\121\1\116\1\0";
    static final String dfa_54s = "\1\uffff\1\1\1\uffff\1\2\1\3\14\uffff";
    static final String dfa_55s = "\20\uffff\1\0}>";
    static final String[] dfa_56s = {
            "\1\4\1\uffff\1\2\3\uffff\3\3\1\uffff\2\3\2\uffff\1\3\31\uffff\11\3\2\1\26\uffff\1\3\5\uffff\11\1",
            "",
            "\1\3\1\uffff\1\1\1\uffff\1\3\4\uffff\31\3\1\uffff\5\3\41\uffff\1\3\1\uffff\1\5\1\uffff\1\1\1\6",
            "",
            "",
            "\1\3\3\uffff\3\3\1\uffff\2\3\2\uffff\1\3\31\uffff\11\3\30\uffff\1\3\2\uffff\1\1",
            "\1\7\3\uffff\3\3\1\uffff\2\3\2\uffff\1\3\31\uffff\11\3\30\uffff\1\3",
            "\1\3\1\uffff\1\1\1\uffff\1\3\4\uffff\31\3\1\uffff\5\3\41\uffff\1\3\1\uffff\1\10\1\uffff\1\1\1\11",
            "\1\3\3\uffff\3\3\1\uffff\2\3\2\uffff\1\3\31\uffff\11\3\30\uffff\1\3\2\uffff\1\1",
            "\1\12\3\uffff\3\3\1\uffff\2\3\2\uffff\1\3\31\uffff\11\3\30\uffff\1\3",
            "\1\3\1\uffff\1\1\1\uffff\1\3\4\uffff\31\3\1\uffff\5\3\41\uffff\1\3\1\uffff\1\13\1\uffff\1\1\1\14",
            "\1\3\3\uffff\3\3\1\uffff\2\3\2\uffff\1\3\31\uffff\11\3\30\uffff\1\3\2\uffff\1\1",
            "\1\15\3\uffff\3\3\1\uffff\2\3\2\uffff\1\3\31\uffff\11\3\30\uffff\1\3",
            "\1\3\1\uffff\1\1\1\uffff\1\3\4\uffff\31\3\1\uffff\5\3\41\uffff\1\3\1\uffff\1\16\1\uffff\1\1\1\17",
            "\1\3\3\uffff\3\3\1\uffff\2\3\2\uffff\1\3\31\uffff\11\3\30\uffff\1\3\2\uffff\1\1",
            "\1\20\3\uffff\3\3\1\uffff\2\3\2\uffff\1\3\31\uffff\11\3\30\uffff\1\3",
            "\1\uffff"
    };

    static final short[] dfa_51 = DFA.unpackEncodedString(dfa_51s);
    static final char[] dfa_52 = DFA.unpackEncodedStringToUnsignedChars(dfa_52s);
    static final char[] dfa_53 = DFA.unpackEncodedStringToUnsignedChars(dfa_53s);
    static final short[] dfa_54 = DFA.unpackEncodedString(dfa_54s);
    static final short[] dfa_55 = DFA.unpackEncodedString(dfa_55s);
    static final short[][] dfa_56 = unpackEncodedStringArray(dfa_56s);

    class DFA68 extends DFA {

        public DFA68(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 68;
            this.eot = dfa_51;
            this.eof = dfa_51;
            this.min = dfa_52;
            this.max = dfa_53;
            this.accept = dfa_54;
            this.special = dfa_55;
            this.transition = dfa_56;
        }
        public String getDescription() {
            return "4508:1: ( ( (lv_variable_2_0= ruleVariable_declaration ) ) | ( ( (lv_expression_3_0= ruleExpression ) ) this_EOL_4= RULE_EOL ) | ( (lv_pv_5_0= RULE_EOL ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA68_16 = input.LA(1);

                         
                        int index68_16 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred147_InternalJava()) ) {s = 1;}

                        else if ( (synpred148_InternalJava()) ) {s = 3;}

                         
                        input.seek(index68_16);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 68, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_57s = "\6\uffff";
    static final String dfa_58s = "\1\7\1\5\1\7\1\uffff\1\5\1\uffff";
    static final String dfa_59s = "\1\7\1\123\1\25\1\uffff\1\123\1\uffff";
    static final String dfa_60s = "\3\uffff\1\1\1\uffff\1\2";
    static final String dfa_61s = "\6\uffff}>";
    static final String[] dfa_62s = {
            "\1\1",
            "\1\3\115\uffff\1\2",
            "\1\4\15\uffff\1\5",
            "",
            "\1\3\115\uffff\1\2",
            ""
    };

    static final short[] dfa_57 = DFA.unpackEncodedString(dfa_57s);
    static final char[] dfa_58 = DFA.unpackEncodedStringToUnsignedChars(dfa_58s);
    static final char[] dfa_59 = DFA.unpackEncodedStringToUnsignedChars(dfa_59s);
    static final short[] dfa_60 = DFA.unpackEncodedString(dfa_60s);
    static final short[] dfa_61 = DFA.unpackEncodedString(dfa_61s);
    static final short[][] dfa_62 = unpackEncodedStringArray(dfa_62s);

    class DFA78 extends DFA {

        public DFA78(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 78;
            this.eot = dfa_57;
            this.eof = dfa_57;
            this.min = dfa_58;
            this.max = dfa_59;
            this.accept = dfa_60;
            this.special = dfa_61;
            this.transition = dfa_62;
        }
        public String getDescription() {
            return "5298:1: ( ( ( (lv_classname_1_0= ruleClass_name ) ) this_EOL_2= RULE_EOL ) | ( ( (lv_packagename_3_0= rulePackage_name ) ) otherlv_4= '.' this_MULTIPLY_5= RULE_MULTIPLY this_EOL_6= RULE_EOL this_EOL_7= RULE_EOL ) )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x00C0000000000052L,0x0000000000001020L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x00C0000000000052L,0x0000000000001000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x00C0000000000050L,0x0000000000001000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x00C0000000000040L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000100L,0x0000000000000400L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000200L,0x0000000000000400L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x00C00000000000B0L,0x000000001FF00800L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x00C0000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000100L,0x0000000000002400L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x00C0000000000080L,0x000000001FF00000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002400L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x00C0000000000090L,0x000000001FF00000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x00C0000000000080L,0x000000001FF08000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000020L,0x0000000000050400L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000080L,0x0000000000008000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x00C0000000000080L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000000002L,0x0000000000050000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000220L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000402L,0x0000000000050000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x003FE0000009B880L,0x0000000000004400L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x003FE0000009B880L,0x0000000000004C00L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000200L,0x0000000000000800L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x00001F7FFFFFC200L,0x0000000000094000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x003FE0000009B880L,0x000000000000C000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x003FE0000009B880L,0x0000000000004000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000100000000402L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x00C0000000000080L,0x000000001FF04000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x79FFE0000009B8A0L,0x000000007FF04C03L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x79FFE0000009B8A0L,0x000000007FF04403L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x00000000000000A0L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x7FFFE0000009B8A0L,0x000000007FF04C03L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x7BFFE0000009B8A0L,0x000000007FF04C03L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x00FFE0000009B8A0L,0x000000001FF04000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x003FE0000009B8A0L,0x0000000000004000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0001E000000000A0L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000002L,0x000000000000000CL});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000200000L});

}