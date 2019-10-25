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

import br.uefs.ecomp.organizer.util.Celula;
import br.uefs.ecomp.organizer.util.IteradorUser;
import br.uefs.ecomp.organizer.util.MyLinkedList;
import br.uefs.ecomp.organizer.util.MyStack;
import java.util.Iterator;

/**
 * Classe que tem as propriedades de um Autor,e efetua as ações do mesmo.
 * Ela guarda o nome e sobrenome do autor.
 * Além de manipular os livros.Como adicionar,remover,atualizar e resgastar 
 * os livros.
 * Author nomeAutor = new Author("nome autor","sobrenome autor");
 * @author Moisés
 */
public class Author {
    private String name;
    private String surname;
    private MyStack book;
    /**
    * 
    * @param name é o nome que o autor será inicializado.
    * @param surname é o sobrenome que o autor será inicializado.
    */
    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
        book = new MyStack();
    }
    
    /**
    *
    * @return  o nome do autor
    */
    public String getName() {
        return name;
    }
    /**
    *
    * @param name é o novo nome do autor
    */
    public void setName(String name) {
        this.name = name;
    }
    /**
    *
    * @return  o sobrenome do autor
    */
    public String getSurname() {
        return surname;
    }
    /**
    *
    * @param surname é o novo sobrenome do autor
    */
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    /**
    * Método que adiciona um livro na pilha de livros do autor
    * @param livro é o livro que será inserido na pilha
    */
    public void addBook(Book livro){
        book.push(livro);
    }
    /**
    * Método que remove um livro de acordo com seu título 
    * @param title é o título do livro que será removido
    */
    public void deleteBook(String title){
        
        MyStack stackAux = new MyStack();       
        Book book1;
        
        while(this.book.getTopo() != null){
            
            book1 = (Book)this.book.getTopo().getObject();
            
            if((book1.getTitle().equalsIgnoreCase(title))){
                this.book.pop();              
            }
            else{
                stackAux.push(this.book.pop());                
            }
        }
        while(stackAux.getTopo() != null){
           
            this.book.push(stackAux.pop());
        }
    }
    /**
    * Método responsável por acessar o último livro inserido
    * @return  o último livro adicionado na pilha
    */
    public Book getLastBook(){
        
        return (Book)this.book.peek();
    }
    /**
    * Método responsável por procurar livros que tenham uma determinada palavra 
    * chave,e mostra todos os livros que possuem essa palavra chave
    * @param chave é a palavra que será pesquisada nos livros 
    * @return  um objeto do tipo iterator,referenciando a primeira celula da 
    * lista que contém os livros que possuem a palavra chave.
    */
    public Iterator searchBookByContent(String chave){
        MyStack stackAux = new MyStack();
    
        MyLinkedList listSearch = new MyLinkedList();
        IteradorUser it;
        Book auxiliarBook;
        //Variavel controle controla a entrada de livros na listSearch
        int controle;      
        Chapter chapter1;
        while(!this.book.isEmpty()){
            controle = 0;
            auxiliarBook = getLastBook();
            
            it = new IteradorUser(auxiliarBook.getChapter());
            while(it.hasNext() && controle != 1){
                
                chapter1 = (Chapter)it.getAtual().getObject();
                /*No primeiro capítulo que a palavra chave aparece,o loop que 
                percorre a lista é encerrado pois a variavel de controle muda*/
                if(chapter1.getTitle().toLowerCase().contains(chave.toLowerCase())){                    
                    listSearch .add(0,auxiliarBook);
                    controle = 1;
                }
                else if(chapter1.getText().toLowerCase().contains(chave.toLowerCase())){
                    listSearch .add(0,auxiliarBook);
                    controle = 1;
                }  
                it.next();
            }
            stackAux.push(this.book.pop());
            
        }
        while(stackAux.getTopo() != null){         
            this.book.push(stackAux.pop());
        }
        
        IteradorUser iterator = new IteradorUser(listSearch .getPrimeiro());
        return iterator;
    }
    /**
    * Método responsável por contabilizar os livros
    * @return  a quantidade de livros que o autor possui
    */
    public int numBooks(){
        
        return this.book.size();
    }
    /**
    * Método responsável de acessar os livros de uma pilha
    * @return  um objeto do tipo iterator
    */
    public Iterator books(){
        
        MyLinkedList list = new MyLinkedList();
        
        while(this.book.getTopo() != null){
            
             list.add(0,this.book.pop());             
        }
        Celula auxiliar = list.getPrimeiro();
        while(auxiliar != null){           
            this.book.push(auxiliar.getObject());
            auxiliar = auxiliar.getProximo();
        }
        IteradorUser iterador = new IteradorUser(list.getPrimeiro());
        
        return iterador;
        
    }
    /**
     * 
    * @param object é o objeto que será comparado com o objeto(author) que chamou 
    * esse método
    * @return  true se eles forem iguais e false se eles forem diferentes.
    */
    @Override
    public boolean equals(Object object){
        if(object instanceof Author ){
            Author auxiliar = (Author)object;
            
            return (this.name.equalsIgnoreCase(auxiliar.name) && this.surname.equalsIgnoreCase(auxiliar.surname));
        } 
        else
            return false;
        
    }
}
