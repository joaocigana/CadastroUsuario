package com.joao.cadastrousuario.entities;

import com.joao.cadastrousuario.enums.TipoDocumento;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Pessoa {
    
    private Integer id;
    private String primeiroNome;
    private String sobrenome;
    private TipoDocumento tipoDocumento;
    private String documento;
    private Date dataNascimento;
    private String telefone;

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    public Pessoa(
            String primeiroNome, String sobrenome,
            TipoDocumento tipoDocumento, String documento,
            Date dataNascimento, String telefone
    ) {

        this.primeiroNome = primeiroNome;
        this.sobrenome = sobrenome;
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
    }

    public Pessoa(Integer id, String primeiroNome, String sobrenome, TipoDocumento tipoDocumento, String documento, Date dataNascimento, String telefone) {
        this.id = id;
        this.primeiroNome = primeiroNome;
        this.sobrenome = sobrenome;
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
    }
    
    

    public Pessoa() {
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getId() {
        return id;
    }
    

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", primeiroNome=" + primeiroNome + ", sobrenome=" + sobrenome + ", tipoDocumento=" + tipoDocumento + ", documento=" + documento + ", dataNascimento=" + dataNascimento + ", telefone=" + telefone + '}';
    }
    
    

}
