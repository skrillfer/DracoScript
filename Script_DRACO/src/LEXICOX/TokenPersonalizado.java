/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LEXICOX;

/**
 *
 * @author fernando
 */
public class TokenPersonalizado {
    
  String _token;
  String _lexema;
 
  public String getLexema(){
    return this._lexema;
  }
 
  public String getToken(){
    return this._token;
  }
 
  TokenPersonalizado (String lexema, String token){
    this._lexema = lexema;
    this._token = token;
  }
 
  public String toString(){
    return "Lexema: " + this._lexema + " Token: " + this._token + ";";
  }
}
