package com.thiagowill.controleEstoque.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thiagowill.controleEstoque.models.PedidoMadeira;

public interface PedidoMadeiraRepository extends JpaRepository<PedidoMadeira, Integer> {
	List<PedidoMadeira> findByData(LocalDate data);
	List<PedidoMadeira> findByStatusEntrega(boolean status);
}
