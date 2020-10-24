package com.thiagowill.controleEstoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thiagowill.controleEstoque.models.Emails;

@Repository
public interface EmailPedidoRepository extends JpaRepository<Emails, Integer> {

}
