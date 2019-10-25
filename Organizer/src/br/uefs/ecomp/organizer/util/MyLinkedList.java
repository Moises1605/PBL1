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
import java.util.Iterator;

/**
 * Responsável por implementar as ações da estrutura de dados: Lista 
 * Como adicionar,remover e acessar os itens da lista, além de 
 * conferir se ela está vazia.
 * MyLinkedList() nomeObjeto = new MylinkedList();
 * @author Moisés
 */
public class MyLinkedList implements IList{

    private Celula primeiro;
    private int tamanho;
    /**
    *
    * Método que inicializa os atributos da lista,com valores adequados,-1 para o 
    * tamanho pois o primeiro elemento equivale ao 0 e null para o primeiro pois 
    * ela está vazia.
    */
    public MyLinkedList() {
        this.primeiro = null;
        this.tamanho = -1;
    }
    /**
    *
    * @return o primeiro elemento da lista 
    */
    public Celula getPrimeiro() {
        return primeiro;
    }
    /**
    *
    * @param primeiro é o novo elemento que será a cabeça da lista.
    */
    public void setPrimeiro(Celula primeiro) {
        this.primeiro = primeiro;
    }
    /**
    *
    * @return a quantidade de elemntos existentes na lista.
    */
    @Override
    public int size() {
        
        Celula auxiliar;
        int contador = 0;
        auxiliar = this.primeiro; 
        while(auxiliar != null){
              contador++;
              auxiliar = auxiliar.getProximo();
        }
        return contador;  
    }
    /**
    * Método que adiciona um elemento no final da lista. 
    * @param obj é o novo elemento que será inserido na lista.
    */
    @Override
    public void add(Object obj) {
        
        Celula celula = new Celula(obj);
        if(this.primeiro == null){
            this.primeiro = celula;
            this.primeiro.setProximo(null);
        }
        else{
            Celula auxiliar;
            auxiliar = this.primeiro;
            while(auxiliar.getProximo() != null){
                auxiliar = auxiliar.getProximo();
            }
            auxiliar.setProximo(celula);
            celula.setProximo(null);
        }
        this.tamanho++;
    }
    /**
    * Método que adiciona um elemento em uma posição indicada. 
    * @param obj é o novo elemento que será inserido na lista.
    * @param pos é a posição que o elemento deve ser inserido
    * @return true se o objeto foi inserido com sucesso e false se não foi 
    * possível inserir.
    */
    @Override
    public boolean add(int pos, Object obj) {
        
        Celula celula = new Celula(obj);
        
        if(this.primeiro == null){
             if(pos == 0){  
                this.primeiro = celula;
                this.primeiro.setProximo(null);
                this.tamanho++;
                return true;
             }
            return false;
        }
        
        else if(pos == 0){
            
            celula.setProximo(this.primeiro);
            this.primeiro = celula;
            this.tamanho++;
            
            return true;
        }    
        
        else{    
            Celula auxiliar = this.primeiro;
            Celula anterior = this.primeiro;
            int contador = 0;
             
            while(auxiliar != null && contador != pos){
                contador++;
                anterior = auxiliar;
                auxiliar = auxiliar.getProximo();
            }
            
            anterior.setProximo(celula);
            celula.setProximo(auxiliar);
            this.tamanho++;
            return true;
            
        }
    }
    /**
    * Método que remove o ultimo elemento da lista 
    * @return o elemento que foi removido,caso a lista ela esteja vazia retorna 
    * null
    */
    @Override
    public Object remove() {
        
        Celula auxiliar = this.primeiro;
        if(this.primeiro == null){
            return null;
        }  
        else if(this.primeiro.getProximo() == null){
            this.primeiro = null;
            this.tamanho--;
            return auxiliar.getObject();
        }
        else{    
            Celula anterior = this.primeiro;
            
            while(auxiliar.getProximo() != null){
                anterior = auxiliar;
                auxiliar = auxiliar.getProximo();
            }
            anterior.setProximo(null);
            this.tamanho--;
            return auxiliar.getObject();
        }
    }
    /**
    * Método que remove um elemento em uma posição indicada.
    * @param pos é a posição que o elemento deve ser removido.
    * @return o elemento que foi removido,caso a lista esteja vazia retorna null
    */
    @Override
    public Object remove(int pos) {
        
        Celula auxiliar = this.primeiro;
        if(pos < 0 || pos > this.tamanho || this.primeiro == null){
            return null;
        }    
        
        else if(pos == 0){
            
            this.primeiro = this.primeiro.getProximo();
            this.tamanho--;
            return auxiliar.getObject();
        }
        else{    
            Celula anterior = this.primeiro;
            int contador = 0;
            
            while(auxiliar != null && contador != pos){
                contador++;
                anterior = auxiliar;
                auxiliar = auxiliar.getProximo();
            }
                 
            anterior.setProximo(auxiliar.getProximo());
            this.tamanho--;
            return auxiliar.getObject();          
        }   
    }
    /**
    * Método que acessa um elemento em uma posição indicada. 
    * @param index a posição em que o elemento está inserido.
    * @return o elemento que quer ser acessado,se a lista estiver vazia retorna
    * null ou se o index for maior ou menor que o tamanho da lista .
    */
    @Override
    public Object get(int index) {
        
        if(this.primeiro == null || index > this.tamanho){
            return null;
        }    
        else{    
            Celula auxiliar = this.primeiro;
            int contador = 0;
             
            while(auxiliar != null && contador != index){
                contador++;
                auxiliar = auxiliar.getProximo();
            }
            
            if(auxiliar == null){
                return null;
            }
            
            return auxiliar.getObject();
        }  
    }
    /**
    * Método que conferi se a lista está vazia. 
    * @return true se a lista estiver vazia e false se não estiver.
    */
    @Override
    public boolean isEmpty() {
        return (this.primeiro == null);
    }
    /**
    * Método responsável por criar um iterator para percorrer a lista. 
    * @return um objeto do tipo iterator.
    */
    @Override
    public Iterator iterator() {
        
        IteradorUser iterador = new IteradorUser(this.primeiro);
        
        return iterador;   
    }
    
}
