package service;

import model.Products;

import java.util.List;

public interface IProductService extends IGeneralService<Products> {
    List<Products> findAll();

    Products findById(long productId);

}
