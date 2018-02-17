/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.upperapps.publikationrest;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author rodrigomelo
 */
@Entity
@Table(name = "Autor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Autor.findAll", query = "SELECT a FROM Autor a")
    , @NamedQuery(name = "Autor.findById", query = "SELECT a FROM Autor a WHERE a.id = :id")
    , @NamedQuery(name = "Autor.findByNome", query = "SELECT a FROM Autor a WHERE a.nome = :nome")
    , @NamedQuery(name = "Autor.findByNomeCitacao", query = "SELECT a FROM Autor a WHERE a.nomeCitacao = :nomeCitacao")
    , @NamedQuery(name = "Autor.findByCpf", query = "SELECT a FROM Autor a WHERE a.cpf = :cpf")
    , @NamedQuery(name = "Autor.findByCep", query = "SELECT a FROM Autor a WHERE a.cep = :cep")})
public class Autor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nomeCitacao")
    private String nomeCitacao;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "cpf")
    private String cpf;
    @Size(max = 8)
    @Column(name = "cep")
    private String cep;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "autorid")
    private Collection<AutorPublicacao> autorPublicacaoCollection;

    public Autor() {
    }

    public Autor(Integer id) {
        this.id = id;
    }

    public Autor(Integer id, String nome, String nomeCitacao, String cpf) {
        this.id = id;
        this.nome = nome;
        this.nomeCitacao = nomeCitacao;
        this.cpf = cpf;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeCitacao() {
        return nomeCitacao;
    }

    public void setNomeCitacao(String nomeCitacao) {
        this.nomeCitacao = nomeCitacao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @XmlTransient
    public Collection<AutorPublicacao> getAutorPublicacaoCollection() {
        return autorPublicacaoCollection;
    }

    public void setAutorPublicacaoCollection(Collection<AutorPublicacao> autorPublicacaoCollection) {
        this.autorPublicacaoCollection = autorPublicacaoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Autor)) {
            return false;
        }
        Autor other = (Autor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.upperapps.publikationrest.Autor[ id=" + id + " ]";
    }
    
}
