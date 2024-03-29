package ra.run;

import ra.config.InputMethod;
import ra.design.IProducts;
import ra.designImpl.ProductImpl;

public class ProductManagement {
    private IProducts iProducts = new ProductImpl();

    public void displayProductMenu() {

        while (true) {
            System.out.println("*******************PRODUCT MANAGEMENT*****************");
            System.out.println("1. Nhập thông tin các sản phẩm");
            System.out.println("2. Hiển thị thông tin các sản phẩm");
            System.out.println("3. Sắp xếp các sản phẩm theo giá");
            System.out.println("4. Cập nhật thông tin sản phẩm theo mã sản phẩm");
            System.out.println("5. Xóa sản phẩm theo mã sản phẩm");
            System.out.println("6. Tìm kiếm các sản phẩm theo tên sản phẩm");
            System.out.println("7. Tìm kiếm sản phẩm trong khoảng giá a – b (a,b nhập từ bàn phim");
            System.out.println("8. Quay lại");
            boolean isExit = false;
            byte choice = InputMethod.getByte();
            switch (choice) {
                case 1:
                    iProducts.addNewElement();
                    break;
                case 2:
                    iProducts.displayAll();
                    break;
                case 3:
                    iProducts.sortByPrice();
                    break;
                case 4:
                    iProducts.editElement();
                    break;
                case 5:
                    iProducts.deleteElement();
                    break;
                case 6:
                    iProducts.findProductByName();
                    break;
                case 7:
                    iProducts.searhcProductByRange();
                    break;
                case 8:
                    isExit = true;
                    break;
                default:
                    System.out.println("Your choice is out of range");
                    break;


            }
            if (isExit) {
                break;
            }

        }
    }


}
