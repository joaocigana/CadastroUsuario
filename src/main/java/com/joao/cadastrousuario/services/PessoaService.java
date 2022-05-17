package com.joao.cadastrousuario.services;

import com.joao.cadastrousuario.exceptions.RegraDeNegocioVioladaException;
import com.joao.cadastrousuario.entities.Pessoa;
import com.joao.cadastrousuario.enums.TipoDocumento;
import com.joao.cadastrousuario.repository.PessoaRepositoryInterface;
import java.util.List;
import java.util.Optional;

public class PessoaService {

    private PessoaRepositoryInterface pessoaDAO;

    public PessoaService(PessoaRepositoryInterface pessoaDAO) {
        this.pessoaDAO = pessoaDAO;
    }

    public void cadastrarPessoa(Pessoa pessoa) throws Exception {
        try {
            if (pessoaDAO.existePessoaPeloDocumento(pessoa.getTipoDocumento(), pessoa.getDocumento())) {
                throw new RegraDeNegocioVioladaException("Documento já cadastrado!");
            } else {
                pessoaDAO.inserirPessoa(pessoa);
            }
        } catch (Exception ex) {
            throw new Exception("Erro inesperado ao cadastrar pessoa!", ex);
        }
    }

    public Pessoa buscarPessoaPeloId(Integer id) throws Exception {
        try {
            if (pessoaDAO.existePessoaPeloId(id)) {
                return pessoaDAO.buscarPessoaPeloID(id);
            } else {
                throw new RegraDeNegocioVioladaException("Pessoa com Id " + id + " não exixte!");
            }
        } catch (Exception ex) {
            throw new Exception("Erro inesperado ao buscar pessoa!", ex);
        }
    }

    public void deletarPessoa(Integer id) throws Exception {
        try {
            if (pessoaDAO.existePessoaPeloId(id)) {
                pessoaDAO.deletarPessoa(id);
            } else {
                throw new RegraDeNegocioVioladaException("Pessoa inexistente! Id " + id + " não encontrado!");
            }
        } catch (Exception ex) {
            throw new Exception(ex.getMessage(), ex);
        }
    }

    public List<Pessoa> listarPessoas() throws Exception {
        try {
            return pessoaDAO.listarPessoas();
        } catch (Exception ex) {
            throw new Exception("Erro inesperado ao listar pessoas!", ex);
        }
    }

    public void atualizarPessoa(Pessoa pessoa) throws Exception {
        try {
            if (pessoaDAO.existePessoaPeloId(pessoa.getId())){
                if(pessoaDAO.existePessoaPeloDocumento(pessoa.getTipoDocumento(), pessoa.getDocumento()) == false){
                    pessoaDAO.atualizarPessoa(pessoa);
                } else{
                    throw new RegraDeNegocioVioladaException("Documento já cadastrado");
                }
            } else {
                throw new RegraDeNegocioVioladaException("Pessoa Inexistente!");
            }
        } catch (Exception ex) {
            throw new Exception(ex.getMessage(), ex);
        }
    }

    public PessoaRepositoryInterface getPessoaDAO() {
        return pessoaDAO;
    }
}
