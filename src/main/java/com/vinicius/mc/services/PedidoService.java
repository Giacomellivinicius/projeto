package com.vinicius.mc.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinicius.mc.domain.ItemPedido;
import com.vinicius.mc.domain.PagamentoComBoleto;
import com.vinicius.mc.domain.Pedido;
import com.vinicius.mc.domain.enums.EstadoPagamento;
import com.vinicius.mc.repositories.ItemPedidoRepository;
import com.vinicius.mc.repositories.PagamentoRepository;
import com.vinicius.mc.repositories.PedidoRepository;
import com.vinicius.mc.repositories.ProdutoRepository;
import com.vinicius.mc.services.exception.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	//Essa anotação faz com que a dependência seja
	//automaticamente instanciada pelo spring
	private PedidoRepository repo ;
	
	@Autowired
	private BoletoService boletoService;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	

	@Autowired
	private EmailService emailService;
	

	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		//Método .findById() herdado da classe JpaRepository
		//Substitui o antigo método .findOne()
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado! id: "+id+", Tipo: "
				+Pedido.class.getName()));
			}
	
	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstante(new Date());
		obj.setCliente(clienteService.find(obj.getCliente().getId()));
		obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);
		if(obj.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagto,obj.getInstante());
		}
		obj = repo.save(obj);
		pagamentoRepository.save(obj.getPagamento());
		
		for (ItemPedido ip: obj.getItens()) {
			ip.setDesconto(0.0);
			ip.setProduto(produtoService.find(ip.getProduto().getId()));
			ip.setPreco(ip.getProduto().getPreco());
			ip.setPedido(obj);
		}
		itemPedidoRepository.saveAll(obj.getItens());
		emailService.sendOrderConfirmationEmail(obj);

		System.out.println(obj);

		return obj;
		
	}
	
	
	
	
	
	
}
