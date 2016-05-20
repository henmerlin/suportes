package controllers;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.DonutChartModel;

import entidades.Atendimento;
import model.RelatorioServico;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class RelatorioBean implements Serializable{

	private Date dataInicio;

	private Date dataFim;

	private DonutChartModel chartModel1;

	private DonutChartModel chartModel2;	

	@EJB
	private RelatorioServico relatorioServico;

	@PostConstruct
	public void init() {

		createDonutModels();

	}

	public RelatorioBean() {

	}

	public void atualizaData() {

		Calendar cal = Calendar.getInstance();

		if (this.dataFim == null) {

			this.dataFim = this.dataInicio;

			cal.setTime(this.dataFim);
			cal.add(Calendar.DATE, 1);

			this.dataFim = cal.getTime();

		}else{

			cal.setTime(this.dataFim);
			cal.add(Calendar.DATE, 1);

			this.dataFim = cal.getTime();

		}

		this.init();

	}

	public void createDonutModels() {

		chartModel1 = initDonutModel1();
		chartModel1.setTitle("Relatorio Ordens");
		chartModel1.setLegendPosition("e");
		chartModel1.setShowDataLabels(true);
		chartModel1.setDataFormat("value");
		chartModel1.setShadow(false);	

	}

	public DonutChartModel initDonutModel1() {

		DonutChartModel model = new DonutChartModel();

		Map<String, Number> circulo = new LinkedHashMap<String, Number>();
		circulo.put("BA", this.calculaOrdem("BA"));
		circulo.put("TT", this.calculaOrdem("TT"));

		model.addCircle(circulo);

		return model;

	}

	public Integer calculaOrdem(String ordem) {

		List<Atendimento> listaDeAtendimentos;

		listaDeAtendimentos = this.relatorioServico.listaAtendimentos(this.dataInicio, this.dataFim);

		Integer contador = 0;

		for (Atendimento atendimento : listaDeAtendimentos) {

			if (atendimento.getOrdem().equalsIgnoreCase(ordem)){

				contador++;

			}

		}

		return contador;

	}
	
	public Integer calculaMotivo(String motivo) {	
		
		List<Atendimento> listaDeAtendimentos;

		listaDeAtendimentos = this.relatorioServico.listaAtendimentos(this.dataInicio, this.dataFim);
		
		Integer contador = 0;
		
		for (Atendimento atendimento : listaDeAtendimentos) {
			
			if(atendimento.getMotivo().getNome().equalsIgnoreCase(motivo)) {
				
				contador++;
				
			}
			
		}
				
		return contador;		
		
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public DonutChartModel getChartModel1() {
		return chartModel1;
	}

	public void setChartModel1(DonutChartModel chartModel1) {
		this.chartModel1 = chartModel1;
	}

	public DonutChartModel getChartModel2() {
		return chartModel2;
	}

	public void setChartModel2(DonutChartModel chartModel2) {
		this.chartModel2 = chartModel2;
	}	

}
