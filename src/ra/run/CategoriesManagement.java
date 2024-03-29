package ra.run;

import ra.config.InputMethod;
import ra.design.ICategories;
import ra.designImpl.CategoriesImpl;
import ra.entity.Categories;

public class CategoriesManagement {
    private ICategories categories = new CategoriesImpl();

    public void displayCategoriesMenu(){

        while (true){
            System.out.println("********************CATEGORIES MENU***********");
            System.out.println("1. Nhập thông tin các danh mục");
            System.out.println("2. Hiển thị thông tin các danh mục");
            System.out.println("3. Cập nhật thông tin danh mục");
            System.out.println("4. Xóa danh mục");
            System.out.println("5. Cập nhật trạng thái danh mục");
            System.out.println("6. Quay lại");
            boolean isOut = false;
            byte choice = InputMethod.getByte();
            switch (choice){

                case 1:
                    categories.addNewElement();
                    break;
                case 2:
                    categories.displayAll();
                    break;
                case 3:
                    categories.editElement();
                    break;
                case 4:
                    categories.deleteElement();
                    break;
                case 5:
                    categories.updateCategoriesStatus();
                    break;
                case 6:
                    isOut = true;
                    break;

                default:
                    System.out.println("Your choice is out of range");
                    break;
            }
            if (isOut){
                break;
            }
        }

    }
}
