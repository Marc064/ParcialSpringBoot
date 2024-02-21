package com.edu.uptc.parcial.controllers;

import com.edu.uptc.parcial.entities.Customer;
import com.edu.uptc.parcial.entities.Product;
import com.edu.uptc.parcial.entities.Sale;
import com.edu.uptc.parcial.responses.ResponseHandler;
import com.edu.uptc.parcial.services.CustomerService;
import com.edu.uptc.parcial.services.ProductService;
import com.edu.uptc.parcial.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("sales")
public class SaleController {
    @Autowired
    private SaleService saleService;
    @Autowired
    private ProductService productService;
    @Autowired
    CustomerService customerService;

    @PostMapping("/{idProduct}/{idCustomer}/{amount}")
    public ResponseEntity<Object> save (@PathVariable Integer idProduct, @PathVariable Integer idCustomer,@PathVariable short amount){
        try{
            Customer customer = customerService.findById(idCustomer);
            Product product = productService.findById(idProduct);
            if(customer != null && product != null){
                if(amount <= product.getStock()){
                    product.setStock((short) (product.getStock()-amount));
                    productService.update(product);
                    Sale sale = new Sale();
                    sale.setCustomer(customer);
                    sale.setProduct(product);
                    Sale result = saleService.save(sale);
                    return ResponseHandler.generateResponse("Success", HttpStatus.OK, result);
                }else{
                    return ResponseHandler.generateResponse("Amount exceeded",HttpStatus.BAD_REQUEST, null );
                }
            }else{
                return ResponseHandler.generateResponse("Success",HttpStatus.NOT_FOUND, null );
            }
        }catch (Exception e){
            return  ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null );
        }
    }

}
