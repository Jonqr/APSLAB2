/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author jonh_
 */
public class Cliente {
    
    private String RG, nome, telefone;

    public Cliente(String RG, String nome, String telefone) {
        this.RG = RG;
        this.nome = nome;
        this.telefone = telefone;
    }
    
    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Cliente{" + "RG=" + RG + ", nome=" + nome + ", telefone=" + telefone + '}';
    }
    
    
    
}
