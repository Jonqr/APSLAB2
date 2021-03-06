/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Model.Aviao;
import Model.CadVoo;
import Model.Cliente;
import Model.Venda;
import Repositorio.RepositorioCliente;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import util.Console;
import util.DateTimeUtil;

/**
 *
 * @author jonh_
 */
public class PassagemAerea {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int opcao = 0;
        do {

            try {
                System.out.println("\nSISTEMA DE COMPRA DE PASSAGENS: ");
                System.out.println("Selecione uma opção: ");
                System.out.println("1- Adicionar Cliente");
                System.out.println("2- Adicionar Avião");
                System.out.println("3- Listar Clientes");
                System.out.println("4- Listar Aviões");  
                System.out.println("5- Cadastrar Voo");
                System.out.println("6- Listar Vôos Cadastrados");
                System.out.println("7- Criar Venda");
                System.out.println("8- Relatorio de Venda");
                System.out.println("0- Sair");
                opcao = Console.scanInt("Digite a opcao: ");

                switch (opcao) {
                    case 1:
                        adicionarCliente();
                        break;
                    case 2: 
                        adicionarAviao();
                        break;
                    case 3:
                        listarClientes();
                        break;
                    case 4: 
                        listarAvioes();
                        break;
                    case 5:
                        cadastrarVoo();
                    case 6:
                        ListarCadastrovoo();
                        break;
                    case 7: 
                        Venda();
                    case 0:
                        System.out.println("Saindo do Sistema...");
                        break;
                    default:
                        System.err.println("Erro: Escolha a opcao correta!!");
                }
            } catch (InputMismatchException e) {
                System.err.println("Erro: Escolha a opcao correta!");
            }
        } while (opcao != 0);
        
        
    }
    
    private static void Venda(){
        
        System.out.println("\n Criando Venda ....");
            
            System.out.println("SELECIONE O CLIENTE: ");
            listarClientes();
            String rg = Console.scanString("RG: ");
            Cliente cliente = RepositorioCliente.getInstance().buscarCliente(rg);
            System.out.println("SELECIONE O VOO");
            ListarCadastrovoo();
            String cod = Console.scanString("SELECIONE AVIAO: ");
            CadVoo cad = Repositorio.RepositorioCadVoo.getInstance().buscarCadVoo(cod);
            String codVenda = Console.scanString("Insira um codigo para venda: ");
            Venda venda = new Venda();
            venda.registraVenda(cliente, cad, codVenda);
            Repositorio.RepositorioVenda.getInstance().add(venda);
    }
    
    
    //RG, nome, telefone
    private static void adicionarCliente() {
        System.out.println("\nAdicionando Cliente...");
        
            String rg = Console.scanString("RG: ");
            String nome = Console.scanString("Nome: ");
            String telefone = Console.scanString("Telefone: ");
        
            Cliente cliente = new Cliente(rg, nome, telefone);
            RepositorioCliente.getInstance().add(cliente);
            System.out.println("Cadastro  de cliente realizado com sucesso!");
        
    }
    
    private static void adicionarAviao(){
        System.out.println("\n --Adicionando Aviao--");
        
        String cod = Console.scanString("Codigo: ");
        String nome = Console.scanString("Nome: ");
        int qtd = Console.scanInt("Quantidade de lugares: ");
        
        Aviao aviao = new Aviao(cod, nome, qtd);
        Repositorio.RepositorioAviao.getInstance().add(aviao);
        System.out.println("Cadastro de avião realizado com sucesso ! ");

    
    
    
    }  
    
    private static void listarClientes() {
        System.out.println("\nListando Pacientes...");
        if (RepositorioCliente.getInstance().estaVazio()) {
            System.out.println("Nao ha pacientes cadastrados!");
        }
        else{
            System.out.print(String.format("%-10s","|RG"));
            System.out.print(String.format("%-20s","|NOME"));
            System.out.println(String.format("%-10s","|TELEFONE"));
            for(Cliente p: RepositorioCliente.getInstance().getClientes()){
                System.out.print(String.format("%-10s",p.getRG()));
                System.out.print(String.format("%-20s",p.getNome()));
                System.out.println(String.format("%-10s",p.getTelefone()));

            }
        }        
    }
    
    private static void listarAvioes(){
        
        System.out.print(String.format("%-10s","|CODIGO"));
        System.out.print(String.format("%-20s","|NOME"));
        System.out.println(String.format("%-10s","|QUANTIDADE DE ASSENTOS"));
        for(Aviao v: Repositorio.RepositorioAviao.getInstance().getAviao()){
            System.out.print(String.format("%-10s",v.getCódigo()));
            System.out.print(String.format("%-20s",v.getNome()));
            System.out.println(String.format("%-10s",v.getQtdAssentos()));
       
        }  
   
    }
 
    private static void ListarCadastrovoo(){
        System.out.print(String.format("%-10s","|AVIAO"));
        System.out.print(String.format("%-20s","|HORARIO"));
        System.out.println(String.format("%-10s","|ORIGEM"));
        System.out.println(String.format("%-10s","|DESTINO"));
    
        for(CadVoo c: Repositorio.RepositorioCadVoo.getInstance().getCadVoo()){
            System.out.println(String.format("%-10s", c.getAviao()));
            System.out.print(String.format("%-20s",c.getHorarioVoo()));        
            System.out.println(String.format("%-10s",c.getOrigem()));
            System.out.println(String.format("%-10s",c.getDestino()));
            
        }
    
    
    }

    private static void cadastrarVoo() {
        System.out.println("... adicionando cadastro de voo");
        System.out.println("Selecione Avião: ");
        
        listarAvioes();
        String cod = Console.scanString("CODIGO VOO: ");
        String destino = Console.scanString("DESTINO: ");
        String origem = Console.scanString("ORIGEM: ");
        String horarioVoo = Console.scanString("HORARIO VOO: ");        
        
        
       
       try{
       LocalDateTime HORA = DateTimeUtil.stringToDateTime(horarioVoo);
        
        CadVoo cadvoo = new CadVoo(Repositorio.RepositorioAviao.getInstance().aviaoExiste(cod), destino, origem,HORA );
        
        Repositorio.RepositorioCadVoo.getInstance().add(cadvoo);
       
       } catch(Exception e){
            System.out.println("HORARIO DE VOO INVALIDO!");
        }
       System.out.println("Cadastro de Vôo realizado com sucesso! ");
    }
    
    
}//fim classe
