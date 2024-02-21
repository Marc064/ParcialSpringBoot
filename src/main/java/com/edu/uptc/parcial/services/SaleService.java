package com.edu.uptc.parcial.services;

import com.edu.uptc.parcial.entities.Sale;
import com.edu.uptc.parcial.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleService {
    @Autowired
    SaleRepository saleRepository;

    public Sale save (Sale sale){
        return saleRepository.save(sale);
    }
}
