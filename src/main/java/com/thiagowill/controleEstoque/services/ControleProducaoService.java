package com.thiagowill.controleEstoque.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiagowill.controleEstoque.enums.Processos;
import com.thiagowill.controleEstoque.exceptions.FuncaoNaoReconhecidaException;
import com.thiagowill.controleEstoque.exceptions.OrdemAbertaException;
import com.thiagowill.controleEstoque.models.Funcionario;
import com.thiagowill.controleEstoque.models.OrdemServico;

@Service
public class ControleProducaoService {

	@Autowired
	private OrdemServicoService ordemServicoService;
	@Autowired
	private FuncionarioService funcionarioService;

	public void entradaDeServico(int idOrdemServico, int idFuncionario) throws Exception {
		
		Funcionario funcionario = new Funcionario();
		funcionario = procurarFuncionario(idFuncionario);
		OrdemServico ordemServico;
		ordemServico = ordemServicoService.findById(idOrdemServico);
		if (ordemServico == null) {
			throw new Exception("O.S não encontrada!");
		} else {

			if (ordemServico.getFuncionarioAtual() != null) {
				throw new OrdemAbertaException();
			} else {
				ordemServico.setFuncionarioAtual(funcionario);

				switch (funcionario.getFuncao()) {
				case DESENHISTA:
					ordemServico.setProcessos(Processos.DESENVOLVIMENTO);
					break;
				case SERRADOR:
					ordemServico.setProcessos(Processos.SERRA);
					break;
				case MONTADOR:
					ordemServico.setProcessos(Processos.MONTAGEM);
					break;
				case FINALIZADOR:
					ordemServico.setProcessos(Processos.ACABAMENTO);
					break;
				case ENTREGADOR:
					ordemServico.setProcessos(Processos.ENTREGA);
					break;
				default:
					throw new FuncaoNaoReconhecidaException();
				}

				ordemServicoService.save(ordemServico);
			}

		}
	}

	private Funcionario procurarFuncionario(int id) throws Exception {
		Funcionario f = new Funcionario();
		f = funcionarioService.findById(id);
		if (f == null) {
			throw new Exception("Funcionário não encntrado");
			
		}
		else
			return f;
	}
	
	public void concluirServico(int idOrdemServico,int idFuncionario) throws Exception {
		Funcionario funcionario = new Funcionario();
		funcionario = procurarFuncionario(idFuncionario);
		OrdemServico ordemServico;
		ordemServico = ordemServicoService.findById(idOrdemServico);
		
		if(ordemServico == null) {
			throw new Exception("O.S não encontrada!");
		}else {
			if(ordemServico.getFuncionarioAtual() == null) {
				throw new Exception("O.S não está aberta!");
			}else {
				if(idFuncionario != ordemServico.getFuncionarioAtual().getId()) {
					throw new Exception("ID funcionário não é o mesmo que abriu O.S!");
				}else {
					switch(funcionario.getFuncao()) {
						case DESENHISTA : ordemServico.setProcessos(Processos.SERRA); break;
						case SERRADOR : ordemServico.setProcessos(Processos.MONTAGEM); break;
						case MONTADOR : ordemServico.setProcessos(Processos.ACABAMENTO); break;
						case FINALIZADOR : ordemServico.setProcessos(Processos.ENTREGA); break;
						case ENTREGADOR : ordemServico.setProcessos(Processos.FINALIZADO);break;
						default: throw new FuncaoNaoReconhecidaException();
					}
					ordemServico.setFuncionarioAtual(null);
					if(!ordemServico.getFuncionariosRelacionados().contains(funcionario)) {
						ordemServico.getFuncionariosRelacionados().add(funcionario);
					}
					ordemServicoService.save(ordemServico);
				}
				
			}
		}
		
	}

}
