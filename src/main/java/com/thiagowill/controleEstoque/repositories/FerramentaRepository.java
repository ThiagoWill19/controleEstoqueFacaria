package com.thiagowill.controleEstoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.thiagowill.controleEstoque.models.Ferramenta;

@Repository
public interface FerramentaRepository extends JpaRepository<Ferramenta, Integer>{

}
