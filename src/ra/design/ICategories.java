package ra.design;

import ra.entity.Categories;

public interface ICategories extends IGenericDesign<Categories, Integer> {

    int getNewId();


    void displayCategoriesInfoUpdate(Categories categories);

    void updateCategoriesStatus();

}
