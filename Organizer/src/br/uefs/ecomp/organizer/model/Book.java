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
import java.util.Iterator;

/**
 * Classe que tem as propriedades de um livro,e efetua as ações do mesmo.
 * Ela guarda o título,número de capítulos e número de paginas de um livro,
 * além de manipular os capitulos,como adicionar,remover,atualizar e resgastar 
 * os mesmos.
 * Book nomeLivro = new Book("titulo do livro");
 * @author Moisés
 */
public class Book {
    private String title;
    private int numChapters;
    private int numPages;
    private MyLinkedList chapter;

    /**
    *
    * @param title é o título que o livro será inicializado.
    */
    public Book(String title) {
        this.title = title;
        chapter = new MyLinkedList();
    }
    /**
    *
    * @return o nome do título do livro
    */
    public String getTitle() {
        return title;
    }
    /**
    *
    * @param title é o novo título do livro
    */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
    *
    * @return o número de capítulos do livro
    */
    public int getNumChapters() {
        return numChapters;
    }
    /**
    *
    * @param numChapters é o nova do quantidade de capítulos
    */
    public void setNumChapters(int numChapters) {
        this.numChapters = numChapters;
    }
    /**
    *
    * @return o número de páginas do livro
    */
    public int getNumPages() {
        return numPages;
    }
    /**
    *
    * @param numPages é o novo número de páginas de um livro
    */
    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }
    /**
    *
    * @param numero é a posição que o capítulo está localizado na lista
    * @return o capítulo que foi indicado
    */
    public Chapter getChapter(int numero) {
        return (Chapter)chapter.get(numero);
    }
    /**
    * É uma sobregarga do método getChapter,que retorna o primeiro 
    * capítulo do livro.
    * @return o primeiro capítulo do livro
    */
    public Celula getChapter() {
        return chapter.getPrimeiro();
    }
    /**
    * Adiciona um capítulo em uma determinada posição
    * @param numero é a posição que o capítulo será adicionado
    * @param chapter é o capítulo que será adicionado
    */
    public void addChapter(int numero,Chapter chapter){
        /*caso ele queira colocar na posição 5,mas o livro não tenha nenhum 
        capítulo.*/
        if(this.chapter.getPrimeiro() == null){
            this.chapter.add(chapter);
        }
        else if(numero > this.chapter.size()){
            this.chapter.add(chapter);
        }
        else{
            this.chapter.add(numero, chapter);
        }
        this.numChapters++;
    }
    /**
     * 
    * @param numero é a posição em que o capítulo está
    * @return o capitulo que foi removido.
    */
    public Chapter removeChapter(int numero){
        
        this.numChapters--;
        
        return (Chapter)(this.chapter.remove(numero));
        
    }
    /**
    * Responsável por criar um iterator para pecorrer a lista.
    * @return um objeto do tipo iterator.
    */
    public Iterator chapters(){
        
        IteradorUser iterador = new IteradorUser(this.chapter.getPrimeiro());
        
        return iterador;
    }
    /**
    * Responsável por atualizar as informações de um certo capítulo(seu título
    * e texto),de um livro que está no topo da pilha.
    * @param number é a posição em que o capítulo está
    * @param title é o novo título que será inserido no capítulo
    * @param text é o novo título que será inserido no capítulo
    */
    public void updateChapter(int number, String title, String text){
        
        Chapter auxiliar = getChapter(number);
        auxiliar.setTitle(title);
        auxiliar.setText(text);
    }
    /**
     * 
    * @param object é o objeto que será comparado com o objeto que chamou 
    * esse método
    * @return  true se eles forem iguais e false se eles forem diferentes.
    */
    @Override
    public boolean equals(Object object){
        if(object instanceof Book ){
            Book auxiliar = (Book)object;
            
            return (this.title.equalsIgnoreCase(auxiliar.title));
        } 
        else
            return false;
        
    }
}
