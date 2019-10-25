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
package br.uefs.ecomp.organizer.model;

import br.uefs.ecomp.organizer.util.IteradorUser;
import  br.uefs.ecomp.organizer.util.MyLinkedList;
import java.util.Iterator;

/**
 * Responsável por fazer as operações desiginadas aos autores.
 * Essa classe adiciona,remove e resgata autores.
 * @author Moisés.
 */
public class System {
    
    MyLinkedList  list = new MyLinkedList();
    
    /**
    * Adiciona autores na lista de autores.
    * @param author que será um novo autor a ser adicionado na lista do mesmo. 
    */
    public void add(Author author){
        this.list.add(author);
    }
    /**
    * Método que remove um autor pelo seu nome e sobrenome
    * @param name é o nome do autor que será removido
    * @param surname é o sobrenome do autor que será removido
    */
    public void remove(String name, String surname){
        
        int contador = 0;
        IteradorUser iterator = new IteradorUser(this.list.getPrimeiro());
        Author author;
        
        while(iterator.hasNext()){
            author = (Author)iterator.getAtual().getObject();
            if((author.getName().equalsIgnoreCase(name)) && (author.getSurname().equalsIgnoreCase(surname))){
               this.list.remove(contador);               
            }  
            contador++;
            iterator.next();
        }
        
    }
    /**
    * Método que acessa um autor específico na lista 
    * @param number onde está localizado o autor na lista
    * @return o autor que estava na posição indicada pelo parametro
    */
    public Author get(int number){
        
        return (Author)this.list.get(number);
    }
    /**
    * Método que informa quantos autores foram adicionados.
    * @return a quantidade de autores
    */
    public int size(){
        
        return this.list.size();
    }
    /**
    * Método que cria um objeto do tipo iterator
    * @return um iterator
    */
    public Iterator iterator() {
       
        IteradorUser iterador = new IteradorUser(this.list.getPrimeiro());
        
        return iterador; 
    }

    
}
