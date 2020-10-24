package com.thiagowill.controleEstoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thiagowill.controleEstoque.models.Madeira;

@Repository
public interface MadeiraRepository extends JpaRepository<Madeira, Integer>{

}
