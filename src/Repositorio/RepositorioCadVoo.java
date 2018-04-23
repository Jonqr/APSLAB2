/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio;

import Model.Aviao;
import Model.CadVoo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jonh_
 */
public class RepositorioCadVoo {
    private List<CadVoo> cadastroVoo;
    private static RepositorioCadVoo instance = null;
    
    private RepositorioCadVoo(){
        
        cadastroVoo = new ArrayList<CadVoo>();
    }
    
    public static RepositorioCadVoo getInstance(){
    
        if(instance == null) instance = new RepositorioCadVoo();
        return instance;
    }
   
    public boolean add(CadVoo cd){
        
        return(cadastroVoo.add(cd));
    } 
     
    
    public boolean estaVazio(){
        return cadastroVoo.isEmpty();
    }
    
    public List<CadVoo> getCadVoo(){
        return cadastroVoo;
    }
    public CadVoo cadVooExiste(String cod){
        
        for(CadVoo cadv: cadastroVoo){
            if(cadv.getAviao().equals(cod)){
            return cadv;
            }
        }
        return null;
    }
    
    public CadVoo buscarCadVoo(String cod){
        for(CadVoo cadv:cadastroVoo){
            if(cadv.getAviao().equals(cadastroVoo)){
            return cadv;
            }
            
        }
        return null;
    }
   
    
    
}
