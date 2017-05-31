package controllers;

import entidades.Atendimento;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.AtendimentoServico;
import util.JSFUtil;

@ViewScoped
@ManagedBean(name = "atendimentoBean")
public class AtendimentoBean {

    private Atendimento atendimento;

    @EJB
    private AtendimentoServico servicoAtendimento;

    public AtendimentoBean() {
        this.atendimento = new Atendimento();
    }

    public Atendimento getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(Atendimento atendimento) {
        this.atendimento = atendimento;
    }

    public Atendimento finalizar() {

        try {

            this.servicoAtendimento.salvar(this.atendimento);
            JSFUtil.addInfoMessage("Atendimento encerrado!");
            this.atendimento = new Atendimento();

        } catch (Exception e) {
            JSFUtil.addErrorMessage(e.getMessage());
        }

        return new Atendimento();
    }

    public List<Atendimento> listar() {

        return this.servicoAtendimento.listar();
    }

}
