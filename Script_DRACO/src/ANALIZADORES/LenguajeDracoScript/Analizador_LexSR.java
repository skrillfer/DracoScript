/* The following code was generated by JFlex 1.4.3 on 3/11/18 08:11 PM */


package ANALIZADORES.LenguajeDracoScript;
import ESTRUCTURAS.*;
import java.util.LinkedList;
import java_cup.runtime.*;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 3/11/18 08:11 PM from the specification file
 * <tt>src/ANALIZADORES/LenguajeDracoScript/SRLexico.flex</tt>
 */
public class Analizador_LexSR implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\7\1\3\1\2\1\0\1\3\1\1\16\7\4\0\1\3\1\31"+
    "\1\10\1\0\1\6\1\25\1\33\1\11\1\34\1\35\1\20\1\21"+
    "\1\42\1\22\1\5\1\23\1\17\11\4\1\41\1\40\1\27\1\26"+
    "\1\30\2\0\1\44\2\6\1\57\1\50\1\47\1\61\1\54\1\46"+
    "\2\6\1\14\1\53\1\12\1\15\1\56\1\60\1\45\1\52\1\51"+
    "\1\13\1\43\1\55\3\6\1\0\1\16\1\0\1\24\1\6\1\0"+
    "\1\44\2\6\1\57\1\50\1\47\1\61\1\54\1\46\2\6\1\14"+
    "\1\53\1\12\1\15\1\56\1\60\1\45\1\52\1\51\1\13\1\43"+
    "\1\55\3\6\1\36\1\32\1\37\1\0\41\7\2\0\4\6\4\0"+
    "\1\6\2\0\1\7\7\0\1\6\4\0\1\6\5\0\27\6\1\0"+
    "\37\6\1\0\u01ca\6\4\0\14\6\16\0\5\6\7\0\1\6\1\0"+
    "\1\6\21\0\160\7\5\6\1\0\2\6\2\0\4\6\10\0\1\6"+
    "\1\0\3\6\1\0\1\6\1\0\24\6\1\0\123\6\1\0\213\6"+
    "\1\0\5\7\2\0\236\6\11\0\46\6\2\0\1\6\7\0\47\6"+
    "\7\0\1\6\1\0\55\7\1\0\1\7\1\0\2\7\1\0\2\7"+
    "\1\0\1\7\10\0\33\6\5\0\3\6\15\0\5\7\6\0\1\6"+
    "\4\0\13\7\5\0\53\6\25\7\12\4\4\0\2\6\1\7\143\6"+
    "\1\0\1\6\10\7\1\0\6\7\2\6\2\7\1\0\4\7\2\6"+
    "\12\4\3\6\2\0\1\6\17\0\1\7\1\6\1\7\36\6\33\7"+
    "\2\0\131\6\13\7\1\6\16\0\12\4\41\6\11\7\2\6\4\0"+
    "\1\6\5\0\26\6\4\7\1\6\11\7\1\6\3\7\1\6\5\7"+
    "\22\0\31\6\3\7\104\0\1\6\1\0\13\6\67\0\33\7\1\0"+
    "\4\7\66\6\3\7\1\6\22\7\1\6\7\7\12\6\2\7\2\0"+
    "\12\4\1\0\7\6\1\0\7\6\1\0\3\7\1\0\10\6\2\0"+
    "\2\6\2\0\26\6\1\0\7\6\1\0\1\6\3\0\4\6\2\0"+
    "\1\7\1\6\7\7\2\0\2\7\2\0\3\7\1\6\10\0\1\7"+
    "\4\0\2\6\1\0\3\6\2\7\2\0\12\4\4\6\7\0\1\6"+
    "\5\0\3\7\1\0\6\6\4\0\2\6\2\0\26\6\1\0\7\6"+
    "\1\0\2\6\1\0\2\6\1\0\2\6\2\0\1\7\1\0\5\7"+
    "\4\0\2\7\2\0\3\7\3\0\1\7\7\0\4\6\1\0\1\6"+
    "\7\0\12\4\2\7\3\6\1\7\13\0\3\7\1\0\11\6\1\0"+
    "\3\6\1\0\26\6\1\0\7\6\1\0\2\6\1\0\5\6\2\0"+
    "\1\7\1\6\10\7\1\0\3\7\1\0\3\7\2\0\1\6\17\0"+
    "\2\6\2\7\2\0\12\4\1\0\1\6\17\0\3\7\1\0\10\6"+
    "\2\0\2\6\2\0\26\6\1\0\7\6\1\0\2\6\1\0\5\6"+
    "\2\0\1\7\1\6\7\7\2\0\2\7\2\0\3\7\10\0\2\7"+
    "\4\0\2\6\1\0\3\6\2\7\2\0\12\4\1\0\1\6\20\0"+
    "\1\7\1\6\1\0\6\6\3\0\3\6\1\0\4\6\3\0\2\6"+
    "\1\0\1\6\1\0\2\6\3\0\2\6\3\0\3\6\3\0\14\6"+
    "\4\0\5\7\3\0\3\7\1\0\4\7\2\0\1\6\6\0\1\7"+
    "\16\0\12\4\11\0\1\6\7\0\3\7\1\0\10\6\1\0\3\6"+
    "\1\0\27\6\1\0\12\6\1\0\5\6\3\0\1\6\7\7\1\0"+
    "\3\7\1\0\4\7\7\0\2\7\1\0\2\6\6\0\2\6\2\7"+
    "\2\0\12\4\22\0\2\7\1\0\10\6\1\0\3\6\1\0\27\6"+
    "\1\0\12\6\1\0\5\6\2\0\1\7\1\6\7\7\1\0\3\7"+
    "\1\0\4\7\7\0\2\7\7\0\1\6\1\0\2\6\2\7\2\0"+
    "\12\4\1\0\2\6\17\0\2\7\1\0\10\6\1\0\3\6\1\0"+
    "\51\6\2\0\1\6\7\7\1\0\3\7\1\0\4\7\1\6\10\0"+
    "\1\7\10\0\2\6\2\7\2\0\12\4\12\0\6\6\2\0\2\7"+
    "\1\0\22\6\3\0\30\6\1\0\11\6\1\0\1\6\2\0\7\6"+
    "\3\0\1\7\4\0\6\7\1\0\1\7\1\0\10\7\22\0\2\7"+
    "\15\0\60\6\1\7\2\6\7\7\4\0\10\6\10\7\1\0\12\4"+
    "\47\0\2\6\1\0\1\6\2\0\2\6\1\0\1\6\2\0\1\6"+
    "\6\0\4\6\1\0\7\6\1\0\3\6\1\0\1\6\1\0\1\6"+
    "\2\0\2\6\1\0\4\6\1\7\2\6\6\7\1\0\2\7\1\6"+
    "\2\0\5\6\1\0\1\6\1\0\6\7\2\0\12\4\2\0\4\6"+
    "\40\0\1\6\27\0\2\7\6\0\12\4\13\0\1\7\1\0\1\7"+
    "\1\0\1\7\4\0\2\7\10\6\1\0\44\6\4\0\24\7\1\0"+
    "\2\7\5\6\13\7\1\0\44\7\11\0\1\7\71\0\53\6\24\7"+
    "\1\6\12\4\6\0\6\6\4\7\4\6\3\7\1\6\3\7\2\6"+
    "\7\7\3\6\4\7\15\6\14\7\1\6\1\7\12\4\4\7\2\0"+
    "\46\6\1\0\1\6\5\0\1\6\2\0\53\6\1\0\u014d\6\1\0"+
    "\4\6\2\0\7\6\1\0\1\6\1\0\4\6\2\0\51\6\1\0"+
    "\4\6\2\0\41\6\1\0\4\6\2\0\7\6\1\0\1\6\1\0"+
    "\4\6\2\0\17\6\1\0\71\6\1\0\4\6\2\0\103\6\2\0"+
    "\3\7\40\0\20\6\20\0\125\6\14\0\u026c\6\2\0\21\6\1\0"+
    "\32\6\5\0\113\6\3\0\3\6\17\0\15\6\1\0\4\6\3\7"+
    "\13\0\22\6\3\7\13\0\22\6\2\7\14\0\15\6\1\0\3\6"+
    "\1\0\2\7\14\0\64\6\40\7\3\0\1\6\3\0\2\6\1\7"+
    "\2\0\12\4\41\0\3\7\2\0\12\4\6\0\130\6\10\0\51\6"+
    "\1\7\1\6\5\0\106\6\12\0\35\6\3\0\14\7\4\0\14\7"+
    "\12\0\12\4\36\6\2\0\5\6\13\0\54\6\4\0\21\7\7\6"+
    "\2\7\6\0\12\4\46\0\27\6\5\7\4\0\65\6\12\7\1\0"+
    "\35\7\2\0\1\7\12\4\6\0\12\4\15\0\1\6\130\0\5\7"+
    "\57\6\21\7\7\6\4\0\12\4\21\0\11\7\14\0\3\7\36\6"+
    "\15\7\2\6\12\4\54\6\16\7\14\0\44\6\24\7\10\0\12\4"+
    "\3\0\3\6\12\4\44\6\122\0\3\7\1\0\25\7\4\6\1\7"+
    "\4\6\3\7\2\6\11\0\300\6\47\7\25\0\4\7\u0116\6\2\0"+
    "\6\6\2\0\46\6\2\0\6\6\2\0\10\6\1\0\1\6\1\0"+
    "\1\6\1\0\1\6\1\0\37\6\2\0\65\6\1\0\7\6\1\0"+
    "\1\6\3\0\3\6\1\0\7\6\3\0\4\6\2\0\6\6\4\0"+
    "\15\6\5\0\3\6\1\0\7\6\16\0\5\7\32\0\5\7\20\0"+
    "\2\6\23\0\1\6\13\0\5\7\5\0\6\7\1\0\1\6\15\0"+
    "\1\6\20\0\15\6\3\0\33\6\25\0\15\7\4\0\1\7\3\0"+
    "\14\7\21\0\1\6\4\0\1\6\2\0\12\6\1\0\1\6\3\0"+
    "\5\6\6\0\1\6\1\0\1\6\1\0\1\6\1\0\4\6\1\0"+
    "\13\6\2\0\4\6\5\0\5\6\4\0\1\6\21\0\51\6\u0a77\0"+
    "\57\6\1\0\57\6\1\0\205\6\6\0\4\6\3\7\2\6\14\0"+
    "\46\6\1\0\1\6\5\0\1\6\2\0\70\6\7\0\1\6\17\0"+
    "\1\7\27\6\11\0\7\6\1\0\7\6\1\0\7\6\1\0\7\6"+
    "\1\0\7\6\1\0\7\6\1\0\7\6\1\0\7\6\1\0\40\7"+
    "\57\0\1\6\u01d5\0\3\6\31\0\11\6\6\7\1\0\5\6\2\0"+
    "\5\6\4\0\126\6\2\0\2\7\2\0\3\6\1\0\132\6\1\0"+
    "\4\6\5\0\51\6\3\0\136\6\21\0\33\6\65\0\20\6\u0200\0"+
    "\u19b6\6\112\0\u51cd\6\63\0\u048d\6\103\0\56\6\2\0\u010d\6\3\0"+
    "\20\6\12\4\2\6\24\0\57\6\1\7\4\0\12\7\1\0\31\6"+
    "\7\0\1\7\120\6\2\7\45\0\11\6\2\0\147\6\2\0\4\6"+
    "\1\0\4\6\14\0\13\6\115\0\12\6\1\7\3\6\1\7\4\6"+
    "\1\7\27\6\5\7\20\0\1\6\7\0\64\6\14\0\2\7\62\6"+
    "\21\7\13\0\12\4\6\0\22\7\6\6\3\0\1\6\4\0\12\4"+
    "\34\6\10\7\2\0\27\6\15\7\14\0\35\6\3\0\4\7\57\6"+
    "\16\7\16\0\1\6\12\4\46\0\51\6\16\7\11\0\3\6\1\7"+
    "\10\6\2\7\2\0\12\4\6\0\27\6\3\0\1\6\1\7\4\0"+
    "\60\6\1\7\1\6\3\7\2\6\2\7\5\6\2\7\1\6\1\7"+
    "\1\6\30\0\3\6\2\0\13\6\5\7\2\0\3\6\2\7\12\0"+
    "\6\6\2\0\6\6\2\0\6\6\11\0\7\6\1\0\7\6\221\0"+
    "\43\6\10\7\1\0\2\7\2\0\12\4\6\0\u2ba4\6\14\0\27\6"+
    "\4\0\61\6\u2104\0\u016e\6\2\0\152\6\46\0\7\6\14\0\5\6"+
    "\5\0\1\6\1\7\12\6\1\0\15\6\1\0\5\6\1\0\1\6"+
    "\1\0\2\6\1\0\2\6\1\0\154\6\41\0\u016b\6\22\0\100\6"+
    "\2\0\66\6\50\0\15\6\3\0\20\7\20\0\7\7\14\0\2\6"+
    "\30\0\3\6\31\0\1\6\6\0\5\6\1\0\207\6\2\0\1\7"+
    "\4\0\1\6\13\0\12\4\7\0\32\6\4\0\1\6\1\0\32\6"+
    "\13\0\131\6\3\0\6\6\2\0\6\6\2\0\6\6\2\0\3\6"+
    "\3\0\2\6\3\0\2\6\22\0\3\7\1\0\1\7\2\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\1\1\2\3\3\1\4\1\2\1\5\2\2\3\5"+
    "\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15"+
    "\1\16\1\17\2\2\1\20\1\21\1\22\1\23\1\24"+
    "\1\25\1\26\12\5\1\0\1\1\1\0\1\27\1\0"+
    "\1\30\1\0\4\5\1\31\1\32\1\33\1\34\1\35"+
    "\1\36\1\37\1\40\2\5\1\41\12\5\1\0\1\5"+
    "\1\42\2\5\1\43\1\5\1\44\11\5\1\0\1\45"+
    "\1\46\1\47\2\5\1\50\1\51\6\5\1\0\1\5"+
    "\1\52\1\5\1\53\1\54\1\55\1\56\1\5\1\0"+
    "\1\5\1\57\1\5\1\0\2\5\1\45\1\5\1\60"+
    "\2\5\1\61";

  private static int [] zzUnpackAction() {
    int [] result = new int[127];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\62\0\144\0\226\0\62\0\310\0\372\0\u012c"+
    "\0\u015e\0\u0190\0\u01c2\0\u01f4\0\u0226\0\62\0\u0258\0\u028a"+
    "\0\62\0\62\0\62\0\u02bc\0\u02ee\0\u0320\0\u0352\0\u0384"+
    "\0\u03b6\0\62\0\62\0\62\0\62\0\62\0\62\0\62"+
    "\0\u03e8\0\u041a\0\u044c\0\u047e\0\u04b0\0\u04e2\0\u0514\0\u0546"+
    "\0\u0578\0\u05aa\0\372\0\372\0\u015e\0\62\0\u05dc\0\62"+
    "\0\u060e\0\u0640\0\u0672\0\u06a4\0\u06d6\0\62\0\62\0\62"+
    "\0\62\0\62\0\62\0\62\0\62\0\u0708\0\u073a\0\u012c"+
    "\0\u076c\0\u079e\0\u07d0\0\u0802\0\u0834\0\u0866\0\u0898\0\u08ca"+
    "\0\u08fc\0\u092e\0\u0960\0\u0992\0\u012c\0\u09c4\0\u09f6\0\u012c"+
    "\0\u0a28\0\u012c\0\u0a5a\0\u0a8c\0\u0abe\0\u0af0\0\u0b22\0\u0b54"+
    "\0\u0b86\0\u0bb8\0\u0bea\0\u0c1c\0\u012c\0\u012c\0\u012c\0\u0c4e"+
    "\0\u0c80\0\u012c\0\u012c\0\u0cb2\0\u0ce4\0\u0d16\0\u0d48\0\u0d7a"+
    "\0\u0dac\0\u0dde\0\u0e10\0\u012c\0\u0e42\0\u012c\0\u012c\0\u012c"+
    "\0\u012c\0\u0e74\0\u0ea6\0\u0ed8\0\u012c\0\u0f0a\0\u0f3c\0\u0f6e"+
    "\0\u0fa0\0\62\0\u0fd2\0\u012c\0\u1004\0\u1036\0\u012c";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[127];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\2"+
    "\1\11\1\12\1\13\1\10\1\14\1\15\1\2\1\6"+
    "\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25"+
    "\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35"+
    "\1\36\1\37\1\40\1\41\1\10\1\42\1\43\1\44"+
    "\1\45\1\46\1\47\2\10\1\50\1\51\1\10\1\52"+
    "\1\10\64\0\1\5\60\0\1\5\64\0\1\6\1\53"+
    "\11\0\1\6\46\0\1\54\12\0\1\54\46\0\1\10"+
    "\1\0\2\10\2\0\4\10\1\0\1\10\12\0\1\10"+
    "\10\0\17\10\10\55\1\56\51\55\11\57\1\60\4\57"+
    "\1\61\43\57\4\0\1\10\1\0\2\10\2\0\1\10"+
    "\1\62\1\10\1\63\1\0\1\10\12\0\1\10\10\0"+
    "\17\10\4\0\1\10\1\0\2\10\2\0\4\10\1\0"+
    "\1\10\12\0\1\10\10\0\3\10\1\64\13\10\4\0"+
    "\1\10\1\0\2\10\2\0\4\10\1\0\1\10\12\0"+
    "\1\10\10\0\1\65\16\10\21\0\1\66\62\0\1\67"+
    "\65\0\1\70\61\0\1\71\61\0\1\72\61\0\1\73"+
    "\65\0\1\74\62\0\1\75\32\0\1\10\1\0\2\10"+
    "\2\0\4\10\1\0\1\10\12\0\1\10\10\0\1\10"+
    "\1\76\15\10\4\0\1\10\1\0\2\10\2\0\1\10"+
    "\1\77\2\10\1\0\1\10\12\0\1\10\10\0\17\10"+
    "\4\0\1\10\1\0\2\10\2\0\4\10\1\0\1\10"+
    "\12\0\1\10\10\0\4\10\1\100\12\10\4\0\1\10"+
    "\1\0\2\10\2\0\3\10\1\101\1\0\1\10\12\0"+
    "\1\10\10\0\1\10\1\102\15\10\4\0\1\10\1\0"+
    "\2\10\2\0\2\10\1\103\1\10\1\0\1\10\12\0"+
    "\1\10\10\0\17\10\4\0\1\10\1\0\2\10\2\0"+
    "\4\10\1\0\1\10\12\0\1\10\10\0\2\10\1\104"+
    "\14\10\4\0\1\10\1\0\2\10\2\0\4\10\1\0"+
    "\1\10\12\0\1\10\10\0\6\10\1\105\1\10\1\106"+
    "\6\10\4\0\1\10\1\0\2\10\2\0\4\10\1\0"+
    "\1\10\12\0\1\10\10\0\11\10\1\107\5\10\4\0"+
    "\1\10\1\0\2\10\2\0\3\10\1\110\1\0\1\10"+
    "\12\0\1\10\10\0\2\10\1\111\14\10\4\0\1\10"+
    "\1\0\2\10\2\0\1\10\1\112\2\10\1\0\1\10"+
    "\12\0\1\10\10\0\17\10\11\57\1\60\61\57\1\60"+
    "\1\57\1\113\46\57\4\0\1\10\1\0\2\10\2\0"+
    "\2\10\1\114\1\10\1\0\1\10\12\0\1\10\10\0"+
    "\17\10\4\0\1\10\1\0\2\10\2\0\4\10\1\0"+
    "\1\10\12\0\1\10\10\0\6\10\1\115\10\10\4\0"+
    "\1\10\1\0\2\10\2\0\1\116\3\10\1\0\1\10"+
    "\12\0\1\10\10\0\17\10\4\0\1\10\1\0\2\10"+
    "\2\0\4\10\1\0\1\10\12\0\1\10\10\0\1\10"+
    "\1\117\15\10\4\0\1\10\1\0\2\10\2\0\4\10"+
    "\1\0\1\10\12\0\1\10\10\0\2\10\1\120\14\10"+
    "\4\0\1\10\1\0\2\10\2\0\1\121\3\10\1\0"+
    "\1\10\12\0\1\10\10\0\17\10\4\0\1\10\1\0"+
    "\2\10\2\0\4\10\1\0\1\10\12\0\1\10\10\0"+
    "\2\10\1\122\14\10\4\0\1\10\1\0\2\10\2\0"+
    "\2\10\1\123\1\10\1\0\1\10\12\0\1\10\10\0"+
    "\17\10\4\0\1\10\1\0\2\10\2\0\4\10\1\0"+
    "\1\10\12\0\1\10\10\0\3\10\1\124\13\10\4\0"+
    "\1\10\1\0\2\10\2\0\1\10\1\125\2\10\1\0"+
    "\1\10\12\0\1\10\10\0\17\10\4\0\1\10\1\0"+
    "\2\10\2\0\4\10\1\0\1\10\12\0\1\10\10\0"+
    "\2\10\1\126\14\10\4\0\1\10\1\0\2\10\2\0"+
    "\4\10\1\0\1\10\12\0\1\10\10\0\1\10\1\127"+
    "\15\10\4\0\1\10\1\0\2\10\2\0\4\10\1\0"+
    "\1\10\12\0\1\10\10\0\3\10\1\130\13\10\4\0"+
    "\1\10\1\0\2\10\2\0\4\10\1\0\1\10\12\0"+
    "\1\10\10\0\3\10\1\131\13\10\4\0\1\10\1\0"+
    "\2\10\2\0\4\10\1\0\1\10\12\0\1\10\10\0"+
    "\3\10\1\132\13\10\4\0\1\10\1\0\2\10\2\0"+
    "\4\10\1\0\1\10\12\0\1\10\10\0\1\10\1\133"+
    "\15\10\11\57\1\60\5\57\1\134\42\57\4\0\1\10"+
    "\1\0\2\10\2\0\3\10\1\135\1\0\1\10\12\0"+
    "\1\10\10\0\17\10\4\0\1\10\1\0\2\10\2\0"+
    "\4\10\1\0\1\10\12\0\1\10\10\0\5\10\1\136"+
    "\11\10\4\0\1\10\1\0\2\10\2\0\2\10\1\137"+
    "\1\10\1\0\1\10\12\0\1\10\10\0\17\10\4\0"+
    "\1\10\1\0\2\10\2\0\4\10\1\0\1\10\12\0"+
    "\1\10\10\0\10\10\1\140\6\10\4\0\1\10\1\0"+
    "\2\10\2\0\4\10\1\0\1\10\12\0\1\10\10\0"+
    "\7\10\1\141\7\10\4\0\1\10\1\0\2\10\2\0"+
    "\4\10\1\0\1\10\12\0\1\10\10\0\4\10\1\142"+
    "\12\10\4\0\1\10\1\0\2\10\2\0\4\10\1\0"+
    "\1\10\12\0\1\10\10\0\5\10\1\143\11\10\4\0"+
    "\1\10\1\0\2\10\2\0\4\10\1\0\1\10\12\0"+
    "\1\10\10\0\3\10\1\144\13\10\4\0\1\10\1\0"+
    "\2\10\2\0\4\10\1\0\1\10\12\0\1\10\10\0"+
    "\7\10\1\145\7\10\4\0\1\10\1\0\2\10\2\0"+
    "\2\10\1\146\1\10\1\0\1\10\12\0\1\10\10\0"+
    "\17\10\4\0\1\10\1\0\2\10\2\0\1\147\3\10"+
    "\1\0\1\10\12\0\1\10\10\0\17\10\4\0\1\10"+
    "\1\0\2\10\2\0\1\150\3\10\1\0\1\10\12\0"+
    "\1\10\10\0\17\10\4\0\1\10\1\0\2\10\2\0"+
    "\4\10\1\0\1\10\12\0\1\10\10\0\14\10\1\151"+
    "\2\10\11\57\1\60\5\57\1\152\42\57\4\0\1\10"+
    "\1\0\2\10\2\0\1\10\1\153\2\10\1\0\1\10"+
    "\12\0\1\10\10\0\17\10\4\0\1\10\1\0\2\10"+
    "\2\0\4\10\1\0\1\10\12\0\1\10\10\0\5\10"+
    "\1\154\11\10\4\0\1\10\1\0\2\10\2\0\1\155"+
    "\3\10\1\0\1\10\12\0\1\10\10\0\17\10\4\0"+
    "\1\10\1\0\2\10\2\0\4\10\1\0\1\10\12\0"+
    "\1\10\10\0\11\10\1\156\5\10\4\0\1\10\1\0"+
    "\2\10\2\0\4\10\1\0\1\10\12\0\1\10\10\0"+
    "\5\10\1\157\11\10\4\0\1\10\1\0\2\10\2\0"+
    "\4\10\1\0\1\10\12\0\1\10\10\0\6\10\1\160"+
    "\10\10\4\0\1\10\1\0\2\10\2\0\4\10\1\0"+
    "\1\10\12\0\1\10\10\0\6\10\1\161\10\10\4\0"+
    "\1\10\1\0\2\10\2\0\4\10\1\0\1\10\12\0"+
    "\1\10\10\0\2\10\1\162\14\10\11\57\1\60\5\57"+
    "\1\163\42\57\4\0\1\10\1\0\2\10\2\0\2\10"+
    "\1\164\1\10\1\0\1\10\12\0\1\10\10\0\17\10"+
    "\4\0\1\10\1\0\2\10\2\0\4\10\1\0\1\10"+
    "\12\0\1\10\10\0\16\10\1\165\4\0\1\10\1\0"+
    "\2\10\2\0\4\10\1\0\1\10\12\0\1\10\10\0"+
    "\1\10\1\166\15\10\11\57\1\60\5\57\1\167\42\57"+
    "\4\0\1\10\1\0\2\10\2\0\4\10\1\0\1\10"+
    "\12\0\1\10\10\0\6\10\1\170\10\10\4\0\1\10"+
    "\1\0\2\10\2\0\4\10\1\0\1\10\12\0\1\10"+
    "\10\0\6\10\1\171\10\10\11\57\1\172\50\57\4\0"+
    "\1\10\1\0\2\10\2\0\4\10\1\0\1\10\12\0"+
    "\1\10\10\0\14\10\1\173\2\10\4\0\1\10\1\0"+
    "\2\10\2\0\4\10\1\0\1\10\12\0\1\10\10\0"+
    "\5\10\1\174\11\10\4\0\1\10\1\0\2\10\2\0"+
    "\4\10\1\0\1\10\12\0\1\10\10\0\1\10\1\175"+
    "\15\10\4\0\1\10\1\0\2\10\2\0\4\10\1\0"+
    "\1\10\12\0\1\10\10\0\7\10\1\176\7\10\4\0"+
    "\1\10\1\0\2\10\2\0\4\10\1\0\1\10\12\0"+
    "\1\10\10\0\10\10\1\177\6\10";

  private static int [] zzUnpackTrans() {
    int [] result = new int[4200];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\1\1\11\2\1\1\11\10\1\1\11\2\1\3\11"+
    "\6\1\7\11\12\1\1\0\1\1\1\0\1\11\1\0"+
    "\1\11\1\0\4\1\10\11\15\1\1\0\20\1\1\0"+
    "\15\1\1\0\10\1\1\0\3\1\1\0\2\1\1\11"+
    "\5\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[127];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
   


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Analizador_LexSR(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public Analizador_LexSR(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 2298) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn++;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 23: 
          { return new Symbol(sym.STRING_LITERAL, new token(yycolumn, yyline, yytext()));
          }
        case 50: break;
        case 6: 
          { return new Symbol(sym.POR, new token(yycolumn, yyline, yytext()));
          }
        case 51: break;
        case 4: 
          { return new Symbol(sym.NUM_LITERAL, new token(yycolumn, yyline, yytext()));
          }
        case 52: break;
        case 15: 
          { return new Symbol(sym.NOT, new token(yycolumn, yyline, yytext()));
          }
        case 53: break;
        case 49: 
          { return new Symbol(sym.RUNMULTDASM, new token(yycolumn, yyline, yytext()));
          }
        case 54: break;
        case 29: 
          { return new Symbol(sym.MAYIQ, new token(yycolumn, yyline, yytext()));
          }
        case 55: break;
        case 40: 
          { return new Symbol(sym.ELIF, new token(yycolumn, yyline, yytext()));
          }
        case 56: break;
        case 11: 
          { return new Symbol(sym.MOD, new token(yycolumn, yyline, yytext()));
          }
        case 57: break;
        case 37: 
          { return new Symbol(sym.NULO, new token(yycolumn, yyline, yytext()));
          }
        case 58: break;
        case 26: 
          { return new Symbol(sym.DEC, new token(yycolumn, yyline, yytext()));
          }
        case 59: break;
        case 36: 
          { return new Symbol(sym.FOR, new token(yycolumn, yyline, yytext()));
          }
        case 60: break;
        case 46: 
          { return new Symbol(sym.PRINT, new token(yycolumn, yyline, yytext()));
          }
        case 61: break;
        case 45: 
          { return new Symbol(sym.POINT, new token(yycolumn, yyline, yytext()));
          }
        case 62: break;
        case 39: 
          { return new Symbol(sym.OVAL, new token(yycolumn, yyline, yytext()));
          }
        case 63: break;
        case 32: 
          { return new Symbol(sym.AND, new token(yycolumn, yyline, yytext()));
          }
        case 64: break;
        case 18: 
          { return new Symbol(sym.ALLA, new token(yycolumn, yyline, yytext()));
          }
        case 65: break;
        case 47: 
          { return new Symbol(sym.STRING, new token(yycolumn, yyline, yytext()));
          }
        case 66: break;
        case 3: 
          { /* ignorar */
          }
        case 67: break;
        case 5: 
          { return new Symbol(sym.ID, new token(yycolumn, yyline, yytext()));
          }
        case 68: break;
        case 27: 
          { return new Symbol(sym.IG_IG, new token(yycolumn, yyline, yytext()));
          }
        case 69: break;
        case 7: 
          { return new Symbol(sym.MAS, new token(yycolumn, yyline, yytext()));
          }
        case 70: break;
        case 14: 
          { return new Symbol(sym.MAYQ, new token(yycolumn, yyline, yytext()));
          }
        case 71: break;
        case 34: 
          { return new Symbol(sym.NOX, new token(yycolumn, yyline, yytext()));
          }
        case 72: break;
        case 17: 
          { return new Symbol(sym.CPAR, new token(yycolumn, yyline, yytext()));
          }
        case 73: break;
        case 21: 
          { return new Symbol(sym.DSPTS, new token(yycolumn, yyline, yytext()));
          }
        case 74: break;
        case 24: 
          { return new Symbol(sym.CHAR_LITERAL, new token(yycolumn, yyline, yytext()));
          }
        case 75: break;
        case 12: 
          { return new Symbol(sym.IGUAL, new token(yycolumn, yyline, yytext()));
          }
        case 76: break;
        case 8: 
          { return new Symbol(sym.MENOS, new token(yycolumn, yyline, yytext()));
          }
        case 77: break;
        case 35: 
          { return new Symbol(sym.VAR, new token(yycolumn, yyline, yytext()));
          }
        case 78: break;
        case 48: 
          { return new Symbol(sym.QUADRATE, new token(yycolumn, yyline, yytext()));
          }
        case 79: break;
        case 42: 
          { return new Symbol(sym.FALSE, new token(yycolumn, yyline, "falso"));
          }
        case 80: break;
        case 10: 
          { return new Symbol(sym.POT, new token(yycolumn, yyline, yytext()));
          }
        case 81: break;
        case 25: 
          { return new Symbol(sym.INC, new token(yycolumn, yyline, yytext()));
          }
        case 82: break;
        case 41: 
          { return new Symbol(sym.TRUE, new token(yycolumn, yyline, "verdadero"));
          }
        case 83: break;
        case 30: 
          { return new Symbol(sym.DIF, new token(yycolumn, yyline, yytext()));
          }
        case 84: break;
        case 44: 
          { return new Symbol(sym.WHILE, new token(yycolumn, yyline, yytext()));
          }
        case 85: break;
        case 22: 
          { return new Symbol(sym.COMA, new token(yycolumn, yyline, yytext()));
          }
        case 86: break;
        case 20: 
          { return new Symbol(sym.PYC, new token(yycolumn, yyline, yytext()));
          }
        case 87: break;
        case 16: 
          { return new Symbol(sym.APAR, new token(yycolumn, yyline, yytext()));
          }
        case 88: break;
        case 28: 
          { return new Symbol(sym.MENIQ, new token(yycolumn, yyline, yytext()));
          }
        case 89: break;
        case 38: 
          { return new Symbol(sym.LINE, new token(yycolumn, yyline, yytext()));
          }
        case 90: break;
        case 9: 
          { return new Symbol(sym.DIV, new token(yycolumn, yyline, yytext()));
          }
        case 91: break;
        case 43: 
          { return new Symbol(sym.SMASH, new token(yycolumn, yyline, yytext()));
          }
        case 92: break;
        case 31: 
          { return new Symbol(sym.OR, new token(yycolumn, yyline, yytext()));
          }
        case 93: break;
        case 1: 
          { return new Symbol(sym.DECIMAL_LITERAL, new token(yycolumn, yyline, yytext()));
          }
        case 94: break;
        case 19: 
          { return new Symbol(sym.CLLA, new token(yycolumn, yyline, yytext()));
          }
        case 95: break;
        case 13: 
          { return new Symbol(sym.MENQ, new token(yycolumn, yyline, yytext()));
          }
        case 96: break;
        case 2: 
          { System.err.println(yyline+","+yycolumn+"=["+yytext()+"],"+yychar);
          }
        case 97: break;
        case 33: 
          { return new Symbol(sym.IF, new token(yycolumn, yyline, yytext()));
          }
        case 98: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              { return new java_cup.runtime.Symbol(sym.EOF); }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
