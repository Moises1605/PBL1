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
 * Responsável por representar um nó ou celula de uma estrutura de dados.
 * Celula nomeObjeto = new Celula(ConteudoDaCelula);
 * @author Moisés
 */
public class Celula {
    private Object object;
    private Celula proximo;
    
    /**
    * Método que inicializa a celula com o conteúdo que a mesma irá guardar
    * @param object é o objeto que será inserido na celula.
    */
    public Celula(Object object) {
        this.object = object;
    }
    
    /**
    *
    * @return o objeto que está inserido na celula.
    */
    public Object getObject() {
        return object;
    }
    /**
    *
    * @param object que é o novo objeto que será inserido na celula
    */
    public void setObject(Object object) {
        this.object = object;
    }
    /**
    *
    * @return a referência para a próxima celula da estrutura de dados.
    */
    public Celula getProximo() {
        return proximo;
    }
    /**
    *
    * @param proximo que é o a nova referência para a próxima celula da 
    * estrutura de dados.
    */
    public void setProximo(Celula proximo) {
        this.proximo = proximo;
    }
    
    
}
