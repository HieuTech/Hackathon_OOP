package ra.run;

import ra.config.InputMethod;

public class Main {
    public static void main(String[] args) {
        CategoriesManagement categoriesManagement = new CategoriesManagement();
        ProductManagement productManagement = new ProductManagement();
        while (true) {
            System.out.println("******************SHOP MENU*******************");
            System.out.println("1. Quản lý danh mục sản phẩm");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Thoát");
            byte choice = InputMethod.getByte();
            switch (choice) {
                case 1:
                    categoriesManagement.displayCategoriesMenu();
                    break;
                case 2:
                    productManagement.displayProductMenu();
                    break;
                case 3:
                    System.out.println("Good Bye");
                    System.exit(1);
                    break;
                default:
                    System.out.println("Your choice is out of range");
                    break;
            }
        }


    }
}
