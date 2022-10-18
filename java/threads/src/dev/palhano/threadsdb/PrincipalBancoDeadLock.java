package dev.palhano.threadsdb;
/**
 * DeadLock quando existe synchronizes que acabam por gerar um dependencia ciclica, que nenhum liberar o 
 * Uma thread segura um recurso e aguarda por outro.
 * */
public class PrincipalBancoDeadLock {

    public static void main(String[] args) {

        GerenciadorDeTransacao tx = new GerenciadorDeTransacao();
        PoolDeConexao pool = new PoolDeConexao();
        
        
        
        new Thread(new TaskAcessoBanco(pool,tx)).start();
        new Thread(new TaskAcessoBancoProcedure(pool,tx)).start();
    }
}
