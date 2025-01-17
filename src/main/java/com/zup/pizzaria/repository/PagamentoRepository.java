package com.zup.pizzaria.repository;

import com.zup.pizzaria.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pedido, Long> {
}
