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
 * Classe responsavel por percorrer uma lista.
 * Para dar mais segurança para o codigo, é criado uma classe chamada iteradorUser 
 * que terá a responsabilidade de transitar pela lista e da suporte a métodos 
 * como remover,adicinar e pegar certos elementos da lista.
 * IteradorUser nomeObjeto = new IteratorUser(CelulaQueIteratorIráReferenciar);
 * @author Moisés
 */
public class IteradorUser implements Iterator{
    
    private Celula atual;
    
    /**
    *
    * @param celula é a referência da celula que o iterator irá referenciar
    * como atual.
    */
    public IteradorUser(Celula celula) {
        atual = celula;
    }
    /**
    *
    * @return a celula em que o iterator está referenciando no momento.
    */
    public Celula getAtual() {
        return atual;
    }
    
    /**
    *
    * @return true caso tenha conteúdo na celula onde o iterator está posicionado
    * ou false caso a celula seja igual a null.
    */
    @Override
    public boolean hasNext() {
       
        return (this.atual != null);
    }

    /**
    * O método retorna o objeto da celula e passa para a proxima celula.
    * @return o objeto da celula que o iterator está refenciando,se o conteúdo
    * da celula for null retorna null.
    */
    @Override
    public Object next() {
        Celula auxiliar = this.atual;
        /*Como tem que retornar um objeto,fiz um caso especial caso o iterator 
        esteja no null,pois não tem como retornar um objeto quando a celula é
        igual a null.*/
         if(hasNext() == false){
            return null;
        }
        else{
            this.atual = this.atual.getProximo();
            return auxiliar.getObject();
        }
    }
    
}
