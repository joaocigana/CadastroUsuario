package com.joao.cadastrousuario.daointerfaces;

import com.joao.cadastrousuario.enums.TipoDocumento;
import com.joao.cadastrousuario.entities.Pessoa;
import java.util.List;


public interface PessoaDAOInterface {
    
    public void inserirPessoa(Pessoa pessoa) throws Exception;
    
    public void atualizarPessoa(Pessoa pessoa) throws Exception;
    
    public void deletarPessoa(Integer id)throws Exception;
    
    public Pessoa buscarPessoaPeloID(Integer id) throws Exception;
    
    public boolean existePessoaPeloDocumento(TipoDocumento tipoDoc, String doc) throws Exception;
    
    public boolean existePessoaPeloId(Integer id) throws Exception;
    
    public List<Pessoa> listarPessoas() throws Exception;
   
    
}
