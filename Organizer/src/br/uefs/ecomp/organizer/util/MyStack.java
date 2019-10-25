/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*******************************************************************************
Autor: Moisés Almeida da Cruz Farias 
Componente Curricular: MI de Programação
Concluido em: 02/10/2018
Declaro que este código foi elaborado por mim de forma individual e não contém nenhum 
trecho de código de outro colega ou de outro autor, tais como provindos de livros e 
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
******************************************************************************************/
package br.uefs.ecomp.organizer.util;

/**
 * Responsável por implementar as ações da estrutura de dados: pilha
 * Como adicionar,remover e acessar o primeiro item da pilha, além de 
 * conferir se ela está vazia.
 * MyStack() nomeObjeto = new MyStack();
 * @author Moisés
 */
public class MyStack implements IStack{

    private Celula topo;
    private int tamanho; 
    /**
    *
    * Método que inicializa os atributos da pilha,com valores adequados,0 para o 
    * tamanho e null para o topo pois ela está vazia.
    */
    public MyStack() {
        this.topo = null;
        this.tamanho = 0;
    }
    /**
    *
    * @return o objeto do tipo Celula que está no topo da pilha.
    */
    public Celula getTopo() {
        return topo;
    }
    /**
    *
    * @param topo é a nova celula que será o topo da pilha.
    */
    public void setTopo(Celula topo) {
        this.topo = topo;
    }
    
    /**
    * Método responsável por inserir elementos na pilha
    * @param data é o objeto que será inserido no topo da pilha.
    */
    @Override
    public void push(Object data) {
        Celula celula = new Celula(data);
        
        celula.setProximo(this.topo);
        this.topo = celula;
        
        this.tamanho++;
    }
    /**
    * Método responsável por remover um elemento da pilha
    * @return objeto que foi removido da pilha,caso a pilha esteja vazia retorna
    * null.
    */
    @Override
    public Object pop() {
        
        if(this.topo == null){
            return null;
        }
        else{
            Celula auxiliar = this.topo;
            this.topo = this.topo.getProximo();
        
            this.tamanho--;
            return auxiliar.getObject();
        }
    }
    /**
    * Método responsável por acessar o conteúdo da celula que está no topo da pilha
    * @return objeto que está no topo da pilha quando a pilha não está vazia,caso
    * contrário retorna null.
    */
    @Override
    public Object peek() {
        if(this.topo == null){
            return null;
        }
        else
            return this.topo.getObject();
    }
    /**
    * Método responsável por retornar a quantidade de elementos da pilha.
    * @return o tamanho da pilha
    */
    @Override
    public int size() {
         
        return this.tamanho;
    }
    /**
    * Método responsável por conferir se a pilha está vazia.
    * @return true caso a pilha esteja vazia e false caso a pilha tenha itens. 
    */
    @Override
    public boolean isEmpty() {
        return (this.topo == null);
        
    }
    
}
