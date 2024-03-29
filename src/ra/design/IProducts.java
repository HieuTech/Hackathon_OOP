package ra.design;

import ra.entity.Products;

public interface IProducts extends IGenericDesign<Products, String> {

    String getNewId();

    void displayProductInfoUpdate(Products products);

    void findProductByName();

    void searhcProductByRange();

    void sortByPrice();
}
