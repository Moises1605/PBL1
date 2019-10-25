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

/**
 * Essa classe é responsavel pelas características de um capítulo.
 * Como o seu título,conteúdo e número de páginas 
 * Chapter nomeObjeto = new Chapter("Titulo do Capitulo","Conteudo do Capitulo");
 * @author Moisés
 */

public class Chapter {
    
    private String title;
    private String text;
    private int numPages;

    /**
    *
    * @param title é o título que o capítulo será inicializado
    * @param text é o novo conteúdo que o capítulo será inicializado
    */
    public Chapter(String title, String text) {
        this.title = title;
        this.text = text;
    }

    /**
    *
    * @return o nome do título do capítulo
    */
    public String getTitle() {
        return title;
    }
    /**
    *
    * @param title é o novo título do capítulo
    */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
    *
    * @return o conteúdo do capítulo
    */
    public String getText() {
        return text;
    }
    /**
    *
    * @param text é o novo conteúdo do capítulo
    */
    public void setText(String text) {
        this.text = text;
    }
    /**
    *
    * @return  o número de páginas de um capítulo
    */
    public int getNumPages() {
        return numPages;
    }
    /**
    *
    * @param numPages é o novo número de páginas de um capítulo
    */
    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }
    /**
    * Responsável por conferir se o objeto mandado como parametro é um objeto 
    * Chapter e se tem o mesmo conteúdo do objeto Chapter que chamou o método. 
    * @param object a ser comparado com o capitulo
    * @return true caso eles forem iguais ou false se eles forem diferentes.
    */
    @Override
    public boolean equals(Object object){
        if(object instanceof Chapter ){
            Chapter auxiliar = (Chapter)object;
            
            return (this.title.equalsIgnoreCase(auxiliar.title) && this.text.equalsIgnoreCase(auxiliar.text));
        } 
        else
            return false;
        
    }
}
