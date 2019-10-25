package br.uefs.ecomp.organizer.util;
/**
 * Inteface responsável por estabelecer quais métodos uma pilha deve ter 
 * basicamente
 * public class NomeClasse implements IStack{...}
 */
public interface IStack {
    /**
    * Método responsével por inserir elementos na pilha
    * @param data que é o objeto que será inserido no topo da pilha.
    */
    public void push(Object data);
    /**
    * Método responsável por remover um elemento da pilha
    * @return Object que foi removido da pilha.
    */
    public Object pop();
    /**
    * Método responsável por acessar o conteúdo da celula que está no topo da pilha
    * @return Object que está no topo da pilha quando a pilha não está vazia,caso
    * contrário retorna null.
    */
    public Object peek();
    /**
    * Método responsável por retornar a quantidade de elementos da pilha.
    * @return o tamanho da pilha
    */
    public int size();
    /**
    * Método responsável por conferir se a pilha está vazia.
    * @return true caso a pilha esteja vazia e false caso a pilha tenha itens. 
    */
    public boolean isEmpty();
}
