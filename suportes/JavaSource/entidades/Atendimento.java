package entidades;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Atendimento extends AbstractEntity {

    private String tecnico;

    @NotEmpty
    @Length(min = 8, max = 10)
    private String colaborador;

    @NotEmpty
    private String acompanhamento;

    @NotEmpty
    private String instancia;

    @NotEmpty
    private String ordem;

    @NotEmpty
    private String servico;

    @OneToOne
    @NotNull
    private Motivo motivo;

    @Lob
    private String observacao;

    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date data;

    @NotNull
    private Boolean acesso;

    @NotNull
    private Boolean ferramentas;

    @NotNull
    private Boolean demandaExterna;

    public Atendimento() {
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public String getColaborador() {
        return colaborador;
    }

    public void setColaborador(String colaborador) {
        this.colaborador = colaborador;
    }

    public String getAcompanhamento() {
        return acompanhamento;
    }

    public void setAcompanhamento(String acompanhamento) {
        this.acompanhamento = acompanhamento;
    }

    public String getInstancia() {
        return instancia;
    }

    public void setInstancia(String instancia) {
        this.instancia = instancia;
    }

    public String getOrdem() {
        return ordem;
    }

    public void setOrdem(String ordem) {
        this.ordem = ordem;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public Motivo getMotivo() {
        return motivo;
    }

    public void setMotivo(Motivo motivo) {
        this.motivo = motivo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Boolean getAcesso() {
        return acesso;
    }

    public void setAcesso(Boolean acesso) {
        this.acesso = acesso;
    }

    public Boolean getFerramentas() {
        return ferramentas;
    }

    public void setFerramentas(Boolean ferramentas) {
        this.ferramentas = ferramentas;
    }

    public Boolean getDemandaExterna() {
        return demandaExterna;
    }

    public void setDemandaExterna(Boolean demandaExterna) {
        this.demandaExterna = demandaExterna;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Atendimento other = (Atendimento) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Atendimento{" + "id=" + id + '}';
    }

 
    
    
    
    
    

}
