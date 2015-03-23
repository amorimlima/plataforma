/**
 *   Este codigo é software livre você e pode resdistribuir e/ou modificar ele seguindo os termos da
 *   Creative Commons Attribution 4.0 International Pare visualizar uma copia desta 
 *   licensa em ingles visite http://creativecommons.org/licenses/by/4.0/.
 *   
 *   This code is free software; you can redistribute it and/or modify it
 *   under the terms of Creative Commons Attribution 4.0 International License. 
 *   To view a copy of this license, visit http://creativecommons.org/licenses/by/4.0/.
 */

package br.com.muranodesign.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Classe tem como objetivo mapear a tabela aluno onde deve ser cadatrados os alunos matriculados na escola.
 *
 * @author Rogerio Lima dos Santos
 * @version 1.00
 * @since Release 1 da aplicação
 */
@Entity
@Table(name = "aluno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aluno.findAll", query = "SELECT a FROM Aluno a"),
    @NamedQuery(name = "Aluno.findByIdAluno", query = "SELECT a FROM Aluno a WHERE a.idAluno = :idAluno"),
    @NamedQuery(name = "Aluno.findByBairro", query = "SELECT a FROM Aluno a WHERE a.bairro = :bairro"),
    @NamedQuery(name = "Aluno.findByCep", query = "SELECT a FROM Aluno a WHERE a.cep = :cep"),
    @NamedQuery(name = "Aluno.findByCepMae", query = "SELECT a FROM Aluno a WHERE a.cepMae = :cepMae"),
    @NamedQuery(name = "Aluno.findByCepPai", query = "SELECT a FROM Aluno a WHERE a.cepPai = :cepPai"),
    @NamedQuery(name = "Aluno.findByCepResponsavel", query = "SELECT a FROM Aluno a WHERE a.cepResponsavel = :cepResponsavel"),
    @NamedQuery(name = "Aluno.findByCidade", query = "SELECT a FROM Aluno a WHERE a.cidade = :cidade"),
    @NamedQuery(name = "Aluno.findByCidadeMae", query = "SELECT a FROM Aluno a WHERE a.cidadeMae = :cidadeMae"),
    @NamedQuery(name = "Aluno.findByCidadePai", query = "SELECT a FROM Aluno a WHERE a.cidadePai = :cidadePai"),
    @NamedQuery(name = "Aluno.findByCidadeResponsavel", query = "SELECT a FROM Aluno a WHERE a.cidadeResponsavel = :cidadeResponsavel"),
    @NamedQuery(name = "Aluno.findByComplemento", query = "SELECT a FROM Aluno a WHERE a.complemento = :complemento"),
    @NamedQuery(name = "Aluno.findByComplementoMae", query = "SELECT a FROM Aluno a WHERE a.complementoMae = :complementoMae"),
    @NamedQuery(name = "Aluno.findByComplementoPai", query = "SELECT a FROM Aluno a WHERE a.complementoPai = :complementoPai"),
    @NamedQuery(name = "Aluno.findByComplementoResponsavel", query = "SELECT a FROM Aluno a WHERE a.complementoResponsavel = :complementoResponsavel"),
    @NamedQuery(name = "Aluno.findByDataMatricula", query = "SELECT a FROM Aluno a WHERE a.dataMatricula = :dataMatricula"),
    @NamedQuery(name = "Aluno.findByDataNascimento", query = "SELECT a FROM Aluno a WHERE a.dataNascimento = :dataNascimento"),
    @NamedQuery(name = "Aluno.findByENecessidadeEspecial", query = "SELECT a FROM Aluno a WHERE a.eNecessidadeEspecial = :eNecessidadeEspecial"),
    @NamedQuery(name = "Aluno.findByEResponsavelLegalMae", query = "SELECT a FROM Aluno a WHERE a.eResponsavelLegalMae = :eResponsavelLegalMae"),
    @NamedQuery(name = "Aluno.findByEResponsavelLegalPai", query = "SELECT a FROM Aluno a WHERE a.eResponsavelLegalPai = :eResponsavelLegalPai"),
    @NamedQuery(name = "Aluno.findByEResponsavelLegalResponsavel", query = "SELECT a FROM Aluno a WHERE a.eResponsavelLegalResponsavel = :eResponsavelLegalResponsavel"),
    @NamedQuery(name = "Aluno.findByEmail1Mae", query = "SELECT a FROM Aluno a WHERE a.email1Mae = :email1Mae"),
    @NamedQuery(name = "Aluno.findByEmail1Pai", query = "SELECT a FROM Aluno a WHERE a.email1Pai = :email1Pai"),
    @NamedQuery(name = "Aluno.findByEmail1Responsavel", query = "SELECT a FROM Aluno a WHERE a.email1Responsavel = :email1Responsavel"),
    @NamedQuery(name = "Aluno.findByEmail2Mae", query = "SELECT a FROM Aluno a WHERE a.email2Mae = :email2Mae"),
    @NamedQuery(name = "Aluno.findByEmail2Pai", query = "SELECT a FROM Aluno a WHERE a.email2Pai = :email2Pai"),
    @NamedQuery(name = "Aluno.findByEmail2Responsavel", query = "SELECT a FROM Aluno a WHERE a.email2Responsavel = :email2Responsavel"),
    @NamedQuery(name = "Aluno.findByEndereco", query = "SELECT a FROM Aluno a WHERE a.endereco = :endereco"),
    @NamedQuery(name = "Aluno.findByEnderecoMae", query = "SELECT a FROM Aluno a WHERE a.enderecoMae = :enderecoMae"),
    @NamedQuery(name = "Aluno.findByEnderecoPai", query = "SELECT a FROM Aluno a WHERE a.enderecoPai = :enderecoPai"),
    @NamedQuery(name = "Aluno.findByEnderecoResponsavel", query = "SELECT a FROM Aluno a WHERE a.enderecoResponsavel = :enderecoResponsavel"),
    @NamedQuery(name = "Aluno.findByEtnia", query = "SELECT a FROM Aluno a WHERE a.etnia = :etnia"),
    @NamedQuery(name = "Aluno.findByNaturalCidade", query = "SELECT a FROM Aluno a WHERE a.naturalCidade = :naturalCidade"),
    @NamedQuery(name = "Aluno.findByNaturalEstado", query = "SELECT a FROM Aluno a WHERE a.naturalEstado = :naturalEstado"),
    @NamedQuery(name = "Aluno.findByNaturalPais", query = "SELECT a FROM Aluno a WHERE a.naturalPais = :naturalPais"),
    @NamedQuery(name = "Aluno.findByNome", query = "SELECT a FROM Aluno a WHERE a.nome = :nome"),
    @NamedQuery(name = "Aluno.findByNomeMae", query = "SELECT a FROM Aluno a WHERE a.nomeMae = :nomeMae"),
    @NamedQuery(name = "Aluno.findByNomePai", query = "SELECT a FROM Aluno a WHERE a.nomePai = :nomePai"),
    @NamedQuery(name = "Aluno.findByNomeResponsavel", query = "SELECT a FROM Aluno a WHERE a.nomeResponsavel = :nomeResponsavel"),
    @NamedQuery(name = "Aluno.findByNumero", query = "SELECT a FROM Aluno a WHERE a.numero = :numero"),
    @NamedQuery(name = "Aluno.findByNumeroMae", query = "SELECT a FROM Aluno a WHERE a.numeroMae = :numeroMae"),
    @NamedQuery(name = "Aluno.findByNumeroPai", query = "SELECT a FROM Aluno a WHERE a.numeroPai = :numeroPai"),
    @NamedQuery(name = "Aluno.findByNumeroResponsavel", query = "SELECT a FROM Aluno a WHERE a.numeroResponsavel = :numeroResponsavel"),
    @NamedQuery(name = "Aluno.findByPais", query = "SELECT a FROM Aluno a WHERE a.pais = :pais"),
    @NamedQuery(name = "Aluno.findByResponsaveisResponsavel", query = "SELECT a FROM Aluno a WHERE a.responsaveisResponsavel = :responsaveisResponsavel"),
    @NamedQuery(name = "Aluno.findByRg", query = "SELECT a FROM Aluno a WHERE a.rg = :rg"),
    @NamedQuery(name = "Aluno.findByTelefoneCelularMae", query = "SELECT a FROM Aluno a WHERE a.telefoneCelularMae = :telefoneCelularMae"),
    @NamedQuery(name = "Aluno.findByTelefoneCelularPai", query = "SELECT a FROM Aluno a WHERE a.telefoneCelularPai = :telefoneCelularPai"),
    @NamedQuery(name = "Aluno.findByTelefoneCelularResponsavel", query = "SELECT a FROM Aluno a WHERE a.telefoneCelularResponsavel = :telefoneCelularResponsavel"),
    @NamedQuery(name = "Aluno.findByTelefoneComercialMae", query = "SELECT a FROM Aluno a WHERE a.telefoneComercialMae = :telefoneComercialMae"),
    @NamedQuery(name = "Aluno.findByTelefoneComercialPai", query = "SELECT a FROM Aluno a WHERE a.telefoneComercialPai = :telefoneComercialPai"),
    @NamedQuery(name = "Aluno.findByTelefoneComercialResponsavel", query = "SELECT a FROM Aluno a WHERE a.telefoneComercialResponsavel = :telefoneComercialResponsavel"),
    @NamedQuery(name = "Aluno.findByTelefoneResidencialMae", query = "SELECT a FROM Aluno a WHERE a.telefoneResidencialMae = :telefoneResidencialMae"),
    @NamedQuery(name = "Aluno.findByTelefoneResidencialPai", query = "SELECT a FROM Aluno a WHERE a.telefoneResidencialPai = :telefoneResidencialPai"),
    @NamedQuery(name = "Aluno.findByTelefoneResidencialResponsavel", query = "SELECT a FROM Aluno a WHERE a.telefoneResidencialResponsavel = :telefoneResidencialResponsavel"),
    @NamedQuery(name = "Aluno.findByNecessidadeEspecial", query = "SELECT a FROM Aluno a WHERE a.necessidadeEspecial = :necessidadeEspecial"),
    @NamedQuery(name = "Aluno.findByUf", query = "SELECT a FROM Aluno a WHERE a.uf = :uf"),
    @NamedQuery(name = "Aluno.findByUfMae", query = "SELECT a FROM Aluno a WHERE a.ufMae = :ufMae"),
    @NamedQuery(name = "Aluno.findByUfPai", query = "SELECT a FROM Aluno a WHERE a.ufPai = :ufPai"),
    @NamedQuery(name = "Aluno.findByUfResponsavel", query = "SELECT a FROM Aluno a WHERE a.ufResponsavel = :ufResponsavel"),
    @NamedQuery(name = "Aluno.findByFotoAluno", query = "SELECT a FROM Aluno a WHERE a.fotoAluno = :fotoAluno"),
    @NamedQuery(name = "Aluno.findBySexo", query = "SELECT a FROM Aluno a WHERE a.sexo = :sexo"),
    @NamedQuery(name = "Aluno.findByAtivo", query = "SELECT a FROM Aluno a WHERE a.ativo = :ativo"),
    @NamedQuery(name = "Aluno.findByNumeroEol", query = "SELECT a FROM Aluno a WHERE a.numeroEol = :numeroEol"),
    @NamedQuery(name = "Aluno.findByNumeroRA", query = "SELECT a FROM Aluno a WHERE a.numeroRA = :numeroRA"),
    @NamedQuery(name = "Aluno.findByEmail", query = "SELECT a FROM Aluno a WHERE a.email = :email"),
    @NamedQuery(name = "Aluno.findByCelular", query = "SELECT a FROM Aluno a WHERE a.celular = :celular"),
    @NamedQuery(name = "Aluno.findByCpf", query = "SELECT a FROM Aluno a WHERE a.cpf = :cpf"),
    @NamedQuery(name = "Aluno.findByParentescoResponsavel", query = "SELECT a FROM Aluno a WHERE a.parentescoResponsavel = :parentescoResponsavel")})
public class Aluno implements Serializable {
    
 
    private static final long serialVersionUID = 1L;
    
    /** The id aluno. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ALUNO")
    private Integer idAluno;
    
    /** The bairro. */
    @Basic(optional = false)
    @Column(name = "BAIRRO")
    private String bairro;
    
    /** The cep. */
    @Basic(optional = false)
    @Column(name = "CEP")
    private String cep;
    
    /** The cep mae. */
    @Column(name = "CEP_MAE")
    private String cepMae;
    
    /** The cep pai. */
    @Column(name = "CEP_PAI")
    private String cepPai;
    
    /** The cep responsavel. */
    @Column(name = "CEP_RESPONSAVEL")
    private String cepResponsavel;
    
    /** The cidade. */
    @Basic(optional = false)
    @Column(name = "CIDADE")
    private String cidade;
    
    /** The cidade mae. */
    @Column(name = "CIDADE_MAE")
    private String cidadeMae;
    
    /** The cidade pai. */
    @Column(name = "CIDADE_PAI")
    private String cidadePai;
    
    /** The cidade responsavel. */
    @Column(name = "CIDADE_RESPONSAVEL")
    private String cidadeResponsavel;
    
    /** The complemento. */
    @Column(name = "COMPLEMENTO")
    private String complemento;
    
    /** The complemento mae. */
    @Column(name = "COMPLEMENTO_MAE")
    private String complementoMae;
    
    /** The complemento pai. */
    @Column(name = "COMPLEMENTO_PAI")
    private String complementoPai;
    
    /** The complemento responsavel. */
    @Column(name = "COMPLEMENTO_RESPONSAVEL")
    private String complementoResponsavel;
    
    /** The data matricula. */
    @Basic(optional = false)
    @Column(name = "DATA_MATRICULA")
    @Temporal(TemporalType.DATE)
    private Date dataMatricula;
    
    /** The data nascimento. */
    @Basic(optional = false)
    @Column(name = "DATA_NASCIMENTO")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    
    /** The e necessidade especial. */
    @Column(name = "E_NECESSIDADE_ESPECIAL")
    private String eNecessidadeEspecial;
    
    /** The e responsavel legal mae. */
    @Column(name = "E_RESPONSAVEL_LEGAL_MAE")
    private String eResponsavelLegalMae;
    
    /** The e responsavel legal pai. */
    @Column(name = "E_RESPONSAVEL_LEGAL_PAI")
    private String eResponsavelLegalPai;
    
    /** The e responsavel legal responsavel. */
    @Column(name = "E_RESPONSAVEL_LEGAL_RESPONSAVEL")
    private String eResponsavelLegalResponsavel;
    
    /** The email1 mae. */
    @Column(name = "EMAIL_1_MAE")
    private String email1Mae;
    
    /** The email1 pai. */
    @Column(name = "EMAIL_1_PAI")
    private String email1Pai;
    
    /** The email1 responsavel. */
    @Column(name = "EMAIL_1_RESPONSAVEL")
    private String email1Responsavel;
    
    /** The email2 mae. */
    @Column(name = "EMAIL_2_MAE")
    private String email2Mae;
    
    /** The email2 pai. */
    @Column(name = "EMAIL_2_PAI")
    private String email2Pai;
    
    /** The email2 responsavel. */
    @Column(name = "EMAIL_2_RESPONSAVEL")
    private String email2Responsavel;
    
    /** The endereco. */
    @Basic(optional = false)
    @Column(name = "ENDERECO")
    private String endereco;
    
    /** The endereco mae. */
    @Column(name = "ENDERECO_MAE")
    private String enderecoMae;
    
    /** The endereco pai. */
    @Column(name = "ENDERECO_PAI")
    private String enderecoPai;
    
    /** The endereco responsavel. */
    @Column(name = "ENDERECO_RESPONSAVEL")
    private String enderecoResponsavel;
    
    /** The etnia. */
    @Basic(optional = false)
    @Column(name = "ETNIA")
    private String etnia;
    
    /** The natural cidade. */
    @Column(name = "NATURAL_CIDADE")
    private String naturalCidade;
    
    /** The natural estado. */
    @Column(name = "NATURAL_ESTADO")
    private String naturalEstado;
    
    /** The natural pais. */
    @Column(name = "NATURAL_PAIS")
    private String naturalPais;
    
    /** The nome. */
    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;
    
    /** The nome mae. */
    @Basic(optional = false)
    @Column(name = "NOME_MAE")
    private String nomeMae;
    
    /** The nome pai. */
    @Basic(optional = false)
    @Column(name = "NOME_PAI")
    private String nomePai;
    
    /** The nome responsavel. */
    @Column(name = "NOME_RESPONSAVEL")
    private String nomeResponsavel;
    
    /** The numero. */
    @Column(name = "NUMERO")
    private String numero;
    
    /** The numero mae. */
    @Column(name = "NUMERO_MAE")
    private String numeroMae;
    
    /** The numero pai. */
    @Column(name = "NUMERO_PAI")
    private String numeroPai;
    
    /** The numero responsavel. */
    @Column(name = "NUMERO_RESPONSAVEL")
    private String numeroResponsavel;
    
    /** The pais. */
    @Column(name = "PAIS")
    private String pais;
    
    /** The responsaveis responsavel. */
    @Column(name = "RESPONSAVEIS_RESPONSAVEL")
    private String responsaveisResponsavel;
    
    /** The rg. */
    @Column(name = "RG")
    private String rg;
    
    /** The telefone celular mae. */
    @Column(name = "TELEFONE_CELULAR_MAE")
    private String telefoneCelularMae;
    
    /** The telefone celular pai. */
    @Column(name = "TELEFONE_CELULAR_PAI")
    private String telefoneCelularPai;
    
    /** The telefone celular responsavel. */
    @Column(name = "TELEFONE_CELULAR_RESPONSAVEL")
    private String telefoneCelularResponsavel;
    
    /** The telefone comercial mae. */
    @Column(name = "TELEFONE_COMERCIAL_MAE")
    private String telefoneComercialMae;
    
    /** The telefone comercial pai. */
    @Column(name = "TELEFONE_COMERCIAL_PAI")
    private String telefoneComercialPai;
    
    /** The telefone comercial responsavel. */
    @Column(name = "TELEFONE_COMERCIAL_RESPONSAVEL")
    private String telefoneComercialResponsavel;
    
    /** The telefone residencial mae. */
    @Column(name = "TELEFONE_RESIDENCIAL_MAE")
    private String telefoneResidencialMae;
    
    /** The telefone residencial pai. */
    @Column(name = "TELEFONE_RESIDENCIAL_PAI")
    private String telefoneResidencialPai;
    
    /** The telefone residencial responsavel. */
    @Column(name = "TELEFONE_RESIDENCIAL_RESPONSAVEL")
    private String telefoneResidencialResponsavel;
    
    /** The necessidade especial. */
    @Column(name = "NECESSIDADE_ESPECIAL")
    private String necessidadeEspecial;
    
    /** The uf. */
    @Column(name = "UF")
    private String uf;
    
    /** The uf mae. */
    @Column(name = "UF_MAE")
    private String ufMae;
    
    /** The uf pai. */
    @Column(name = "UF_PAI")
    private String ufPai;
    
    /** The uf responsavel. */
    @Column(name = "UF_RESPONSAVEL")
    private String ufResponsavel;
    
    /** The foto aluno. */
    @Column(name = "FOTO_ALUNO")
    private String fotoAluno;
    
    /** The sexo. */
    @Column(name = "SEXO")
    private String sexo;
    
    /** The ativo. */
    @Column(name = "ativo")
    private String ativo;
    
    /** The numero eol. */
    @Column(name = "numero_eol")
    private String numeroEol;
    
    /** The numero ra. */
    @Column(name = "numero_r_a")
    private String numeroRA;
    
    /** The email. */
    @Column(name = "EMAIL")
    private String email;
    
    /** The celular. */
    @Column(name = "CELULAR")
    private String celular;
    
    /** The cpf. */
    @Column(name = "CPF")
    private String cpf;
    
    /** The observacao. */
    @Lob
    @Column(name = "OBSERVACAO")
    private String observacao;
    
    /** The parentesco responsavel. */
    @Column(name = "PARENTESCO_RESPONSAVEL")
    private String parentescoResponsavel;
    
    /** The relatorio tutoria collection. */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aluno")
    private Collection<RelatorioTutoria> relatorioTutoriaCollection;
    
    /** The relatorio aluno collection. */
    @OneToMany(mappedBy = "aluno")
    private Collection<RelatorioAluno> relatorioAlunoCollection;
    
    /** The aluno variavel collection. */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aluno")
    private Collection<AlunoVariavel> alunoVariavelCollection;
    
    /** The plano estudo collection. */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aluno")
    private Collection<PlanoEstudo> planoEstudoCollection;
    
    /** The chamada collection. */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aluno")
    private Collection<Chamada> chamadaCollection;
    
    /** The producao aluno collection. */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aluno")
    private Collection<ProducaoAluno> producaoAlunoCollection;
    
    /** The usuario collection. */
    @OneToMany(mappedBy = "aluno")
    private Collection<Usuario> usuarioCollection;
    
    /** The ficha finalizacao questao collection. */
    @OneToMany(mappedBy = "aluno")
    private Collection<FichaFinalizacaoQuestao> fichaFinalizacaoQuestaoCollection;
    
    /** The atribuicao roteiro extra collection. */
    @OneToMany(mappedBy = "aluno")
    private Collection<AtribuicaoRoteiroExtra> atribuicaoRoteiroExtraCollection;
    
    /** The avaliacao producao aluno collection. */
    @OneToMany(mappedBy = "aluno")
    private Collection<AvaliacaoProducaoAluno> avaliacaoProducaoAlunoCollection;

    /**
     * Instantiates a new aluno.
     */
    public Aluno() {
    }

    /**
     * Instantiates a new aluno.
     *
     * @param idAluno the id aluno
     */
    public Aluno(Integer idAluno) {
        this.idAluno = idAluno;
    }

    /**
     * Instantiates a new aluno.
     *
     * @param idAluno the id aluno
     * @param bairro the bairro
     * @param cep the cep
     * @param cidade the cidade
     * @param dataMatricula the data matricula
     * @param dataNascimento the data nascimento
     * @param endereco the endereco
     * @param etnia the etnia
     * @param nome the nome
     * @param nomeMae the nome mae
     * @param nomePai the nome pai
     */
    public Aluno(Integer idAluno, String bairro, String cep, String cidade, Date dataMatricula, Date dataNascimento, String endereco, String etnia, String nome, String nomeMae, String nomePai) {
        this.idAluno = idAluno;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.dataMatricula = dataMatricula;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.etnia = etnia;
        this.nome = nome;
        this.nomeMae = nomeMae;
        this.nomePai = nomePai;
    }

    /**
     * Gets the id aluno.
     *
     * @return the id aluno
     */
    public Integer getIdAluno() {
        return idAluno;
    }

    /**
     * Sets the id aluno.
     *
     * @param idAluno the new id aluno
     */
    public void setIdAluno(Integer idAluno) {
        this.idAluno = idAluno;
    }

    /**
     * Gets the bairro.
     *
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * Sets the bairro.
     *
     * @param bairro the new bairro
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * Gets the cep.
     *
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * Sets the cep.
     *
     * @param cep the new cep
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * Gets the cep mae.
     *
     * @return the cep mae
     */
    public String getCepMae() {
        return cepMae;
    }

    /**
     * Sets the cep mae.
     *
     * @param cepMae the new cep mae
     */
    public void setCepMae(String cepMae) {
        this.cepMae = cepMae;
    }

    /**
     * Gets the cep pai.
     *
     * @return the cep pai
     */
    public String getCepPai() {
        return cepPai;
    }

    /**
     * Sets the cep pai.
     *
     * @param cepPai the new cep pai
     */
    public void setCepPai(String cepPai) {
        this.cepPai = cepPai;
    }

    /**
     * Gets the cep responsavel.
     *
     * @return the cep responsavel
     */
    public String getCepResponsavel() {
        return cepResponsavel;
    }

    /**
     * Sets the cep responsavel.
     *
     * @param cepResponsavel the new cep responsavel
     */
    public void setCepResponsavel(String cepResponsavel) {
        this.cepResponsavel = cepResponsavel;
    }

    /**
     * Gets the cidade.
     *
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * Sets the cidade.
     *
     * @param cidade the new cidade
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * Gets the cidade mae.
     *
     * @return the cidade mae
     */
    public String getCidadeMae() {
        return cidadeMae;
    }

    /**
     * Sets the cidade mae.
     *
     * @param cidadeMae the new cidade mae
     */
    public void setCidadeMae(String cidadeMae) {
        this.cidadeMae = cidadeMae;
    }

    /**
     * Gets the cidade pai.
     *
     * @return the cidade pai
     */
    public String getCidadePai() {
        return cidadePai;
    }

    /**
     * Sets the cidade pai.
     *
     * @param cidadePai the new cidade pai
     */
    public void setCidadePai(String cidadePai) {
        this.cidadePai = cidadePai;
    }

    /**
     * Gets the cidade responsavel.
     *
     * @return the cidade responsavel
     */
    public String getCidadeResponsavel() {
        return cidadeResponsavel;
    }

    /**
     * Sets the cidade responsavel.
     *
     * @param cidadeResponsavel the new cidade responsavel
     */
    public void setCidadeResponsavel(String cidadeResponsavel) {
        this.cidadeResponsavel = cidadeResponsavel;
    }

    /**
     * Gets the complemento.
     *
     * @return the complemento
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * Sets the complemento.
     *
     * @param complemento the new complemento
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * Gets the complemento mae.
     *
     * @return the complemento mae
     */
    public String getComplementoMae() {
        return complementoMae;
    }

    /**
     * Sets the complemento mae.
     *
     * @param complementoMae the new complemento mae
     */
    public void setComplementoMae(String complementoMae) {
        this.complementoMae = complementoMae;
    }

    /**
     * Gets the complemento pai.
     *
     * @return the complemento pai
     */
    public String getComplementoPai() {
        return complementoPai;
    }

    /**
     * Sets the complemento pai.
     *
     * @param complementoPai the new complemento pai
     */
    public void setComplementoPai(String complementoPai) {
        this.complementoPai = complementoPai;
    }

    /**
     * Gets the complemento responsavel.
     *
     * @return the complemento responsavel
     */
    public String getComplementoResponsavel() {
        return complementoResponsavel;
    }

    /**
     * Sets the complemento responsavel.
     *
     * @param complementoResponsavel the new complemento responsavel
     */
    public void setComplementoResponsavel(String complementoResponsavel) {
        this.complementoResponsavel = complementoResponsavel;
    }

    /**
     * Gets the data matricula.
     *
     * @return the data matricula
     */
    public Date getDataMatricula() {
        return dataMatricula;
    }

    /**
     * Sets the data matricula.
     *
     * @param dataMatricula the new data matricula
     */
    public void setDataMatricula(Date dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    /**
     * Gets the data nascimento.
     *
     * @return the data nascimento
     */
    public Date getDataNascimento() {
        return dataNascimento;
    }

    /**
     * Sets the data nascimento.
     *
     * @param dataNascimento the new data nascimento
     */
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * Gets the e necessidade especial.
     *
     * @return the e necessidade especial
     */
    public String getENecessidadeEspecial() {
        return eNecessidadeEspecial;
    }

    /**
     * Sets the e necessidade especial.
     *
     * @param eNecessidadeEspecial the new e necessidade especial
     */
    public void setENecessidadeEspecial(String eNecessidadeEspecial) {
        this.eNecessidadeEspecial = eNecessidadeEspecial;
    }

    /**
     * Gets the e responsavel legal mae.
     *
     * @return the e responsavel legal mae
     */
    public String getEResponsavelLegalMae() {
        return eResponsavelLegalMae;
    }

    /**
     * Sets the e responsavel legal mae.
     *
     * @param eResponsavelLegalMae the new e responsavel legal mae
     */
    public void setEResponsavelLegalMae(String eResponsavelLegalMae) {
        this.eResponsavelLegalMae = eResponsavelLegalMae;
    }

    /**
     * Gets the e responsavel legal pai.
     *
     * @return the e responsavel legal pai
     */
    public String getEResponsavelLegalPai() {
        return eResponsavelLegalPai;
    }

    /**
     * Sets the e responsavel legal pai.
     *
     * @param eResponsavelLegalPai the new e responsavel legal pai
     */
    public void setEResponsavelLegalPai(String eResponsavelLegalPai) {
        this.eResponsavelLegalPai = eResponsavelLegalPai;
    }

    /**
     * Gets the e responsavel legal responsavel.
     *
     * @return the e responsavel legal responsavel
     */
    public String getEResponsavelLegalResponsavel() {
        return eResponsavelLegalResponsavel;
    }

    /**
     * Sets the e responsavel legal responsavel.
     *
     * @param eResponsavelLegalResponsavel the new e responsavel legal responsavel
     */
    public void setEResponsavelLegalResponsavel(String eResponsavelLegalResponsavel) {
        this.eResponsavelLegalResponsavel = eResponsavelLegalResponsavel;
    }

    /**
     * Gets the email1 mae.
     *
     * @return the email1 mae
     */
    public String getEmail1Mae() {
        return email1Mae;
    }

    /**
     * Sets the email1 mae.
     *
     * @param email1Mae the new email1 mae
     */
    public void setEmail1Mae(String email1Mae) {
        this.email1Mae = email1Mae;
    }

    /**
     * Gets the email1 pai.
     *
     * @return the email1 pai
     */
    public String getEmail1Pai() {
        return email1Pai;
    }

    /**
     * Sets the email1 pai.
     *
     * @param email1Pai the new email1 pai
     */
    public void setEmail1Pai(String email1Pai) {
        this.email1Pai = email1Pai;
    }

    /**
     * Gets the email1 responsavel.
     *
     * @return the email1 responsavel
     */
    public String getEmail1Responsavel() {
        return email1Responsavel;
    }

    /**
     * Sets the email1 responsavel.
     *
     * @param email1Responsavel the new email1 responsavel
     */
    public void setEmail1Responsavel(String email1Responsavel) {
        this.email1Responsavel = email1Responsavel;
    }

    /**
     * Gets the email2 mae.
     *
     * @return the email2 mae
     */
    public String getEmail2Mae() {
        return email2Mae;
    }

    /**
     * Sets the email2 mae.
     *
     * @param email2Mae the new email2 mae
     */
    public void setEmail2Mae(String email2Mae) {
        this.email2Mae = email2Mae;
    }

    /**
     * Gets the email2 pai.
     *
     * @return the email2 pai
     */
    public String getEmail2Pai() {
        return email2Pai;
    }

    /**
     * Sets the email2 pai.
     *
     * @param email2Pai the new email2 pai
     */
    public void setEmail2Pai(String email2Pai) {
        this.email2Pai = email2Pai;
    }

    /**
     * Gets the email2 responsavel.
     *
     * @return the email2 responsavel
     */
    public String getEmail2Responsavel() {
        return email2Responsavel;
    }

    /**
     * Sets the email2 responsavel.
     *
     * @param email2Responsavel the new email2 responsavel
     */
    public void setEmail2Responsavel(String email2Responsavel) {
        this.email2Responsavel = email2Responsavel;
    }

    /**
     * Gets the endereco.
     *
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Sets the endereco.
     *
     * @param endereco the new endereco
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Gets the endereco mae.
     *
     * @return the endereco mae
     */
    public String getEnderecoMae() {
        return enderecoMae;
    }

    /**
     * Sets the endereco mae.
     *
     * @param enderecoMae the new endereco mae
     */
    public void setEnderecoMae(String enderecoMae) {
        this.enderecoMae = enderecoMae;
    }

    /**
     * Gets the endereco pai.
     *
     * @return the endereco pai
     */
    public String getEnderecoPai() {
        return enderecoPai;
    }

    /**
     * Sets the endereco pai.
     *
     * @param enderecoPai the new endereco pai
     */
    public void setEnderecoPai(String enderecoPai) {
        this.enderecoPai = enderecoPai;
    }

    /**
     * Gets the endereco responsavel.
     *
     * @return the endereco responsavel
     */
    public String getEnderecoResponsavel() {
        return enderecoResponsavel;
    }

    /**
     * Sets the endereco responsavel.
     *
     * @param enderecoResponsavel the new endereco responsavel
     */
    public void setEnderecoResponsavel(String enderecoResponsavel) {
        this.enderecoResponsavel = enderecoResponsavel;
    }

    /**
     * Gets the etnia.
     *
     * @return the etnia
     */
    public String getEtnia() {
        return etnia;
    }

    /**
     * Sets the etnia.
     *
     * @param etnia the new etnia
     */
    public void setEtnia(String etnia) {
        this.etnia = etnia;
    }

    /**
     * Gets the natural cidade.
     *
     * @return the natural cidade
     */
    public String getNaturalCidade() {
        return naturalCidade;
    }

    /**
     * Sets the natural cidade.
     *
     * @param naturalCidade the new natural cidade
     */
    public void setNaturalCidade(String naturalCidade) {
        this.naturalCidade = naturalCidade;
    }

    /**
     * Gets the natural estado.
     *
     * @return the natural estado
     */
    public String getNaturalEstado() {
        return naturalEstado;
    }

    /**
     * Sets the natural estado.
     *
     * @param naturalEstado the new natural estado
     */
    public void setNaturalEstado(String naturalEstado) {
        this.naturalEstado = naturalEstado;
    }

    /**
     * Gets the natural pais.
     *
     * @return the natural pais
     */
    public String getNaturalPais() {
        return naturalPais;
    }

    /**
     * Sets the natural pais.
     *
     * @param naturalPais the new natural pais
     */
    public void setNaturalPais(String naturalPais) {
        this.naturalPais = naturalPais;
    }

    /**
     * Gets the nome.
     *
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Sets the nome.
     *
     * @param nome the new nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Gets the nome mae.
     *
     * @return the nome mae
     */
    public String getNomeMae() {
        return nomeMae;
    }

    /**
     * Sets the nome mae.
     *
     * @param nomeMae the new nome mae
     */
    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    /**
     * Gets the nome pai.
     *
     * @return the nome pai
     */
    public String getNomePai() {
        return nomePai;
    }

    /**
     * Sets the nome pai.
     *
     * @param nomePai the new nome pai
     */
    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    /**
     * Gets the nome responsavel.
     *
     * @return the nome responsavel
     */
    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    /**
     * Sets the nome responsavel.
     *
     * @param nomeResponsavel the new nome responsavel
     */
    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    /**
     * Gets the numero.
     *
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Sets the numero.
     *
     * @param numero the new numero
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Gets the numero mae.
     *
     * @return the numero mae
     */
    public String getNumeroMae() {
        return numeroMae;
    }

    /**
     * Sets the numero mae.
     *
     * @param numeroMae the new numero mae
     */
    public void setNumeroMae(String numeroMae) {
        this.numeroMae = numeroMae;
    }

    /**
     * Gets the numero pai.
     *
     * @return the numero pai
     */
    public String getNumeroPai() {
        return numeroPai;
    }

    /**
     * Sets the numero pai.
     *
     * @param numeroPai the new numero pai
     */
    public void setNumeroPai(String numeroPai) {
        this.numeroPai = numeroPai;
    }

    /**
     * Gets the numero responsavel.
     *
     * @return the numero responsavel
     */
    public String getNumeroResponsavel() {
        return numeroResponsavel;
    }

    /**
     * Sets the numero responsavel.
     *
     * @param numeroResponsavel the new numero responsavel
     */
    public void setNumeroResponsavel(String numeroResponsavel) {
        this.numeroResponsavel = numeroResponsavel;
    }

    /**
     * Gets the pais.
     *
     * @return the pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * Sets the pais.
     *
     * @param pais the new pais
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * Gets the responsaveis responsavel.
     *
     * @return the responsaveis responsavel
     */
    public String getResponsaveisResponsavel() {
        return responsaveisResponsavel;
    }

    /**
     * Sets the responsaveis responsavel.
     *
     * @param responsaveisResponsavel the new responsaveis responsavel
     */
    public void setResponsaveisResponsavel(String responsaveisResponsavel) {
        this.responsaveisResponsavel = responsaveisResponsavel;
    }

    /**
     * Gets the rg.
     *
     * @return the rg
     */
    public String getRg() {
        return rg;
    }

    /**
     * Sets the rg.
     *
     * @param rg the new rg
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * Gets the telefone celular mae.
     *
     * @return the telefone celular mae
     */
    public String getTelefoneCelularMae() {
        return telefoneCelularMae;
    }

    /**
     * Sets the telefone celular mae.
     *
     * @param telefoneCelularMae the new telefone celular mae
     */
    public void setTelefoneCelularMae(String telefoneCelularMae) {
        this.telefoneCelularMae = telefoneCelularMae;
    }

    /**
     * Gets the telefone celular pai.
     *
     * @return the telefone celular pai
     */
    public String getTelefoneCelularPai() {
        return telefoneCelularPai;
    }

    /**
     * Sets the telefone celular pai.
     *
     * @param telefoneCelularPai the new telefone celular pai
     */
    public void setTelefoneCelularPai(String telefoneCelularPai) {
        this.telefoneCelularPai = telefoneCelularPai;
    }

    /**
     * Gets the telefone celular responsavel.
     *
     * @return the telefone celular responsavel
     */
    public String getTelefoneCelularResponsavel() {
        return telefoneCelularResponsavel;
    }

    /**
     * Sets the telefone celular responsavel.
     *
     * @param telefoneCelularResponsavel the new telefone celular responsavel
     */
    public void setTelefoneCelularResponsavel(String telefoneCelularResponsavel) {
        this.telefoneCelularResponsavel = telefoneCelularResponsavel;
    }

    /**
     * Gets the telefone comercial mae.
     *
     * @return the telefone comercial mae
     */
    public String getTelefoneComercialMae() {
        return telefoneComercialMae;
    }

    /**
     * Sets the telefone comercial mae.
     *
     * @param telefoneComercialMae the new telefone comercial mae
     */
    public void setTelefoneComercialMae(String telefoneComercialMae) {
        this.telefoneComercialMae = telefoneComercialMae;
    }

    /**
     * Gets the telefone comercial pai.
     *
     * @return the telefone comercial pai
     */
    public String getTelefoneComercialPai() {
        return telefoneComercialPai;
    }

    /**
     * Sets the telefone comercial pai.
     *
     * @param telefoneComercialPai the new telefone comercial pai
     */
    public void setTelefoneComercialPai(String telefoneComercialPai) {
        this.telefoneComercialPai = telefoneComercialPai;
    }

    /**
     * Gets the telefone comercial responsavel.
     *
     * @return the telefone comercial responsavel
     */
    public String getTelefoneComercialResponsavel() {
        return telefoneComercialResponsavel;
    }

    /**
     * Sets the telefone comercial responsavel.
     *
     * @param telefoneComercialResponsavel the new telefone comercial responsavel
     */
    public void setTelefoneComercialResponsavel(String telefoneComercialResponsavel) {
        this.telefoneComercialResponsavel = telefoneComercialResponsavel;
    }

    /**
     * Gets the telefone residencial mae.
     *
     * @return the telefone residencial mae
     */
    public String getTelefoneResidencialMae() {
        return telefoneResidencialMae;
    }

    /**
     * Sets the telefone residencial mae.
     *
     * @param telefoneResidencialMae the new telefone residencial mae
     */
    public void setTelefoneResidencialMae(String telefoneResidencialMae) {
        this.telefoneResidencialMae = telefoneResidencialMae;
    }

    /**
     * Gets the telefone residencial pai.
     *
     * @return the telefone residencial pai
     */
    public String getTelefoneResidencialPai() {
        return telefoneResidencialPai;
    }

    /**
     * Sets the telefone residencial pai.
     *
     * @param telefoneResidencialPai the new telefone residencial pai
     */
    public void setTelefoneResidencialPai(String telefoneResidencialPai) {
        this.telefoneResidencialPai = telefoneResidencialPai;
    }

    /**
     * Gets the telefone residencial responsavel.
     *
     * @return the telefone residencial responsavel
     */
    public String getTelefoneResidencialResponsavel() {
        return telefoneResidencialResponsavel;
    }

    /**
     * Sets the telefone residencial responsavel.
     *
     * @param telefoneResidencialResponsavel the new telefone residencial responsavel
     */
    public void setTelefoneResidencialResponsavel(String telefoneResidencialResponsavel) {
        this.telefoneResidencialResponsavel = telefoneResidencialResponsavel;
    }

    /**
     * Gets the necessidade especial.
     *
     * @return the necessidade especial
     */
    public String getNecessidadeEspecial() {
        return necessidadeEspecial;
    }

    /**
     * Sets the necessidade especial.
     *
     * @param necessidadeEspecial the new necessidade especial
     */
    public void setNecessidadeEspecial(String necessidadeEspecial) {
        this.necessidadeEspecial = necessidadeEspecial;
    }

    /**
     * Gets the uf.
     *
     * @return the uf
     */
    public String getUf() {
        return uf;
    }

    /**
     * Sets the uf.
     *
     * @param uf the new uf
     */
    public void setUf(String uf) {
        this.uf = uf;
    }

    /**
     * Gets the uf mae.
     *
     * @return the uf mae
     */
    public String getUfMae() {
        return ufMae;
    }

    /**
     * Sets the uf mae.
     *
     * @param ufMae the new uf mae
     */
    public void setUfMae(String ufMae) {
        this.ufMae = ufMae;
    }

    /**
     * Gets the uf pai.
     *
     * @return the uf pai
     */
    public String getUfPai() {
        return ufPai;
    }

    /**
     * Sets the uf pai.
     *
     * @param ufPai the new uf pai
     */
    public void setUfPai(String ufPai) {
        this.ufPai = ufPai;
    }

    /**
     * Gets the uf responsavel.
     *
     * @return the uf responsavel
     */
    public String getUfResponsavel() {
        return ufResponsavel;
    }

    /**
     * Sets the uf responsavel.
     *
     * @param ufResponsavel the new uf responsavel
     */
    public void setUfResponsavel(String ufResponsavel) {
        this.ufResponsavel = ufResponsavel;
    }

    /**
     * Gets the foto aluno.
     *
     * @return the foto aluno
     */
    public String getFotoAluno() {
        return fotoAluno;
    }

    /**
     * Sets the foto aluno.
     *
     * @param fotoAluno the new foto aluno
     */
    public void setFotoAluno(String fotoAluno) {
        this.fotoAluno = fotoAluno;
    }

    /**
     * Gets the sexo.
     *
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * Sets the sexo.
     *
     * @param sexo the new sexo
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * Gets the ativo.
     *
     * @return the ativo
     */
    public String getAtivo() {
        return ativo;
    }

    /**
     * Sets the ativo.
     *
     * @param ativo the new ativo
     */
    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    /**
     * Gets the numero eol.
     *
     * @return the numero eol
     */
    public String getNumeroEol() {
        return numeroEol;
    }

    /**
     * Sets the numero eol.
     *
     * @param numeroEol the new numero eol
     */
    public void setNumeroEol(String numeroEol) {
        this.numeroEol = numeroEol;
    }

    /**
     * Gets the numero ra.
     *
     * @return the numero ra
     */
    public String getNumeroRA() {
        return numeroRA;
    }

    /**
     * Sets the numero ra.
     *
     * @param numeroRA the new numero ra
     */
    public void setNumeroRA(String numeroRA) {
        this.numeroRA = numeroRA;
    }

    /**
     * Gets the email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email.
     *
     * @param email the new email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the celular.
     *
     * @return the celular
     */
    public String getCelular() {
        return celular;
    }

    /**
     * Sets the celular.
     *
     * @param celular the new celular
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     * Gets the cpf.
     *
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Sets the cpf.
     *
     * @param cpf the new cpf
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Gets the observacao.
     *
     * @return the observacao
     */
    public String getObservacao() {
        return observacao;
    }

    /**
     * Sets the observacao.
     *
     * @param observacao the new observacao
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    /**
     * Gets the parentesco responsavel.
     *
     * @return the parentesco responsavel
     */
    public String getParentescoResponsavel() {
        return parentescoResponsavel;
    }

    /**
     * Sets the parentesco responsavel.
     *
     * @param parentescoResponsavel the new parentesco responsavel
     */
    public void setParentescoResponsavel(String parentescoResponsavel) {
        this.parentescoResponsavel = parentescoResponsavel;
    }

    /**
     * Gets the relatorio tutoria collection.
     *
     * @return the relatorio tutoria collection
     */
    @XmlTransient
    public Collection<RelatorioTutoria> getRelatorioTutoriaCollection() {
        return relatorioTutoriaCollection;
    }

    /**
     * Sets the relatorio tutoria collection.
     *
     * @param relatorioTutoriaCollection the new relatorio tutoria collection
     */
    public void setRelatorioTutoriaCollection(Collection<RelatorioTutoria> relatorioTutoriaCollection) {
        this.relatorioTutoriaCollection = relatorioTutoriaCollection;
    }

    /**
     * Gets the relatorio aluno collection.
     *
     * @return the relatorio aluno collection
     */
    @XmlTransient
    public Collection<RelatorioAluno> getRelatorioAlunoCollection() {
        return relatorioAlunoCollection;
    }

    /**
     * Sets the relatorio aluno collection.
     *
     * @param relatorioAlunoCollection the new relatorio aluno collection
     */
    public void setRelatorioAlunoCollection(Collection<RelatorioAluno> relatorioAlunoCollection) {
        this.relatorioAlunoCollection = relatorioAlunoCollection;
    }

    /**
     * Gets the aluno variavel collection.
     *
     * @return the aluno variavel collection
     */
    @XmlTransient
    public Collection<AlunoVariavel> getAlunoVariavelCollection() {
        return alunoVariavelCollection;
    }

    /**
     * Sets the aluno variavel collection.
     *
     * @param alunoVariavelCollection the new aluno variavel collection
     */
    public void setAlunoVariavelCollection(Collection<AlunoVariavel> alunoVariavelCollection) {
        this.alunoVariavelCollection = alunoVariavelCollection;
    }

    /**
     * Gets the plano estudo collection.
     *
     * @return the plano estudo collection
     */
    @XmlTransient
    public Collection<PlanoEstudo> getPlanoEstudoCollection() {
        return planoEstudoCollection;
    }

    /**
     * Sets the plano estudo collection.
     *
     * @param planoEstudoCollection the new plano estudo collection
     */
    public void setPlanoEstudoCollection(Collection<PlanoEstudo> planoEstudoCollection) {
        this.planoEstudoCollection = planoEstudoCollection;
    }

    /**
     * Gets the chamada collection.
     *
     * @return the chamada collection
     */
    @XmlTransient
    public Collection<Chamada> getChamadaCollection() {
        return chamadaCollection;
    }

    /**
     * Sets the chamada collection.
     *
     * @param chamadaCollection the new chamada collection
     */
    public void setChamadaCollection(Collection<Chamada> chamadaCollection) {
        this.chamadaCollection = chamadaCollection;
    }

    /**
     * Gets the producao aluno collection.
     *
     * @return the producao aluno collection
     */
    @XmlTransient
    public Collection<ProducaoAluno> getProducaoAlunoCollection() {
        return producaoAlunoCollection;
    }

    /**
     * Sets the producao aluno collection.
     *
     * @param producaoAlunoCollection the new producao aluno collection
     */
    public void setProducaoAlunoCollection(Collection<ProducaoAluno> producaoAlunoCollection) {
        this.producaoAlunoCollection = producaoAlunoCollection;
    }

    /**
     * Gets the usuario collection.
     *
     * @return the usuario collection
     */
    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    /**
     * Sets the usuario collection.
     *
     * @param usuarioCollection the new usuario collection
     */
    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    /**
     * Gets the ficha finalizacao questao collection.
     *
     * @return the ficha finalizacao questao collection
     */
    @XmlTransient
    public Collection<FichaFinalizacaoQuestao> getFichaFinalizacaoQuestaoCollection() {
        return fichaFinalizacaoQuestaoCollection;
    }

    /**
     * Sets the ficha finalizacao questao collection.
     *
     * @param fichaFinalizacaoQuestaoCollection the new ficha finalizacao questao collection
     */
    public void setFichaFinalizacaoQuestaoCollection(Collection<FichaFinalizacaoQuestao> fichaFinalizacaoQuestaoCollection) {
        this.fichaFinalizacaoQuestaoCollection = fichaFinalizacaoQuestaoCollection;
    }

    /**
     * Gets the atribuicao roteiro extra collection.
     *
     * @return the atribuicao roteiro extra collection
     */
    @XmlTransient
    public Collection<AtribuicaoRoteiroExtra> getAtribuicaoRoteiroExtraCollection() {
        return atribuicaoRoteiroExtraCollection;
    }

    /**
     * Sets the atribuicao roteiro extra collection.
     *
     * @param atribuicaoRoteiroExtraCollection the new atribuicao roteiro extra collection
     */
    public void setAtribuicaoRoteiroExtraCollection(Collection<AtribuicaoRoteiroExtra> atribuicaoRoteiroExtraCollection) {
        this.atribuicaoRoteiroExtraCollection = atribuicaoRoteiroExtraCollection;
    }

    /**
     * Gets the avaliacao producao aluno collection.
     *
     * @return the avaliacao producao aluno collection
     */
    @XmlTransient
    public Collection<AvaliacaoProducaoAluno> getAvaliacaoProducaoAlunoCollection() {
        return avaliacaoProducaoAlunoCollection;
    }

    /**
     * Sets the avaliacao producao aluno collection.
     *
     * @param avaliacaoProducaoAlunoCollection the new avaliacao producao aluno collection
     */
    public void setAvaliacaoProducaoAlunoCollection(Collection<AvaliacaoProducaoAluno> avaliacaoProducaoAlunoCollection) {
        this.avaliacaoProducaoAlunoCollection = avaliacaoProducaoAlunoCollection;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAluno != null ? idAluno.hashCode() : 0);
        return hash;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aluno)) {
            return false;
        }
        Aluno other = (Aluno) object;
        if ((this.idAluno == null && other.idAluno != null) || (this.idAluno != null && !this.idAluno.equals(other.idAluno))) {
            return false;
        }
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "br.com.muranodesign.model.Aluno[ idAluno=" + idAluno + " ]";
    }
    
}
