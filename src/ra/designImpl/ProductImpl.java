package ra.designImpl;

import ra.config.InputMethod;
import ra.design.IProducts;
import ra.entity.Products;
import ra.run.CategoriesManagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProductImpl implements IProducts {
    private static List<Products> productsList = new ArrayList<>();

    @Override
    public void addNewElement() {
        System.out.println("How many product you want to add");
        byte quantity = InputMethod.getByte();
        for (int i = 1; i <= quantity; i++) {
            System.out.printf("Product number %d \n", i);
            productsList.add(inputData(true));

        }
        System.out.println("Add successfully");
    }

    @Override
    public String getNewId() {

        System.out.println("Input ProductId");

        return InputMethod.checkProductId();

    }


    @Override
    public void displayProductInfoUpdate(Products products) {
        while (true) {
            System.out.println("********************PRODUCT UPDATE INFO***********");
            System.out.println("1. Product Name");
            System.out.println("2. Product Description");
            System.out.println("3. Product Status");
            System.out.println("4. Product Price");
            System.out.println("5. Product Date");
            System.out.println("6. Product CatalogId");
            System.out.println("7. Sign Out");
            byte choice = InputMethod.getByte();
            boolean isOut = false;
            switch (choice) {
                case 1:
                    System.out.println("Input Product Name");
                    products.setProductName(checkName());
                    break;
                case 2:
                    System.out.println("Input Product description");
                    products.setDescriptions(InputMethod.getString());
                    break;
                case 3:
                    System.out.println("Input Product Status");
                    products.setProductStatus(InputMethod.getProductStatus());
                    break;
                case 4:
                    System.out.println("Input Product Price");
                    products.setPrice(InputMethod.getFLoat());
                    break;
                case 5:
                    System.out.println("Input Product Created Date ");
                    products.setCreated(InputMethod.getDate());
                    break;
                case 6:
                    System.out.println("Input CatalogId");
                    products.setCatalogId(checkCatalogId());
                    break;
                case 7:
                    isOut = true;
                    break;
                default:
                    System.out.println("Your choice is out of range");
                    break;
            }
            if (isOut) {
                break;
            }
        }
    }

    @Override
    public void findProductByName() {
        System.out.println("Input product name to search");
        String productName = InputMethod.getString();
        for (Products products : productsList) {
            if (products.getProductName().contains(productName)) {
                System.out.println(products);
            }
        }
        System.out.println("Product not found");
    }


    @Override
    public void searhcProductByRange() {
        System.out.println("Input From Price");
        float fromPrice = InputMethod.getFLoat();
        System.out.println("Input To Price");
        float toPrice = InputMethod.getFLoat();
        byte count = 0;
        for (Products products : productsList) {
            if (products.getPrice() > fromPrice && products.getPrice() < toPrice) {
                count++;
                System.out.println(products);
            }
        }
        if (count == 0) {
            System.out.printf("No Product From %f To %f \n", fromPrice, toPrice);
        } else {
            System.out.printf("Total: %d", count);
        }

    }

    @Override
    public void sortByPrice() {
        System.out.println(productsList.toString());
        System.out.println("Mang sau khi sap xep");
        System.out.println(productsList.stream().sorted(Comparator.comparing(Products::getPrice)).collect(Collectors.toList()));

    }

    @Override
    public Products inputData(boolean isAdd) {

        Products products = new Products();

        if (isAdd) {
            products.setProductId(getNewId());
        }

        System.out.println("Input Product Name");
        products.setProductName(checkName());

        System.out.println("Input Product description");
        products.setDescriptions(InputMethod.getString());

        System.out.println("Input Product Created Date ");
        products.setCreated(InputMethod.getDate());

        System.out.println("Input Product Price");
        products.setPrice(InputMethod.getFLoat());

        System.out.println("Input CatalogId");
        products.setCatalogId(checkCatalogId());

        System.out.println("Input Product Status");
        products.setProductStatus(InputMethod.getProductStatus());

        return products;
    }

    private int checkCatalogId() {
        int cataLogId = InputMethod.getInt();
        for (int i = 0; i < CategoriesImpl.getCategoriesList().size(); i++) {
            if (CategoriesImpl.getCategoriesList().get(i).getCatalogId() == cataLogId) {
                return cataLogId;
            }
        }
        System.out.println("CatalogID not found");
        return 0;

    }

    @Override
    public void editElement() {
        System.out.println("Input productId");
        String productId = InputMethod.checkProductId();
        Products productUpdate = findById(productId);
        if (productUpdate == null) {
            System.out.println("Product not found");
        } else {
            displayProductInfoUpdate(productUpdate);
            System.out.println("Update successfully");
        }
    }

    @Override
    public void deleteElement() {
        System.out.println("Input productId");
        String productId = InputMethod.checkProductId();
        Products productDelete = findById(productId);
        if (productDelete == null) {
            System.out.println("Product not found");
        } else {
            productsList.remove(productDelete);
            System.out.println("Delete successfully");
        }
    }

    @Override
    public void displayAll() {
        System.out.println("All product info");
        for (Products products : productsList) {
            System.out.println(products.toString());
        }
    }

    @Override
    public String checkName() {
//        do {
//            String productName = InputMethod.getString();
//            for (int i = 0; i < productsList.size(); i++) {
//                if (!productsList.get(i).getProductName().equals(productName)) {
//                    return productName;
//
//                }
//            }
//
//            System.out.println("Product Name is exist");
//        } while (true);
        return InputMethod.getString();
    }

    @Override
    public Products findById(String id) {
        for (Products products : productsList) {
            if (products.getProductId().equals(id)) {
                return products;
            }
        }
        return null;
    }


}
