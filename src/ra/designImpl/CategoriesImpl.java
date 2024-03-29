package ra.designImpl;

import ra.config.InputMethod;
import ra.design.ICategories;
import ra.entity.Categories;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class CategoriesImpl implements ICategories {
    private static List<Categories> categoriesList = new ArrayList<>();

    public static List<Categories> getCategoriesList() {
        return categoriesList;
    }

    public static void setCategoriesList(List<Categories> categoriesList) {
        CategoriesImpl.categoriesList = categoriesList;
    }

    @Override
    public int getNewId() {
        int idMax = 0;
        for (Categories categories : categoriesList) {
            if (idMax < categories.getCatalogId()) {
                idMax = categories.getCatalogId();
            }
        }
        return idMax + 1;
    }


    @Override
    public void addNewElement() {
        System.out.println("Input number of categories you want to add");
        byte count = InputMethod.getByte();
        for (int i = 1; i <= count; i++) {
            System.out.printf("Categories: %d \n", i);
            categoriesList.add(inputData(true));
            System.out.println("Add Successfully");
        }

    }

    @Override
    public Categories inputData(boolean isAdd) {

        Categories newCate = new Categories();
        if (isAdd) {
            newCate.setCatalogId(getNewId());

        }
        System.out.println("Input your Categories name");
        newCate.setCatalogName(checkName());
        System.out.println("Input your Categories Desc");
        newCate.setDescriptions(InputMethod.getString());
        System.out.println("Input your Categories Status");
        newCate.setCatalogStatus(InputMethod.getBoolean());

        return newCate;
    }


    @Override
    public Categories findById(Integer id) {
        for (Categories categories : categoriesList) {
            if (categories.getCatalogId() == id) {
                return categories;
            }
        }
        return null;
    }

    @Override
    public void deleteElement() {
        System.out.println("Input Categories Id");
        int categoriesId = InputMethod.getByte();
        Categories categoriesDelete = findById(categoriesId);
        if (categoriesDelete == null) {
            System.out.println("Categories Not Found");
        } else {
            categoriesList.remove(categoriesDelete);
            System.out.println("Delete successfully");
        }
    }

    @Override
    public void displayAll() {
        System.out.println("All Categories Info");
        for (Categories categories : categoriesList) {
            System.out.println(categories.toString());
        }
    }

    @Override
    public String checkName() {
        do {
            boolean isExist = false;
            String categoriesName = InputMethod.getString();
            for (int i = 0; i < categoriesList.size(); i++) {
                if (categoriesList.get(i).getCatalogName().equals(categoriesName)) {
                    System.out.println("Categories Name is exist");
                    isExist = true;
                }
            }
            if (!isExist) {
                return categoriesName;
            }
        } while (true);
    }

    //    private String checkCategoriesNameIsExist(){
//        do {
//            boolean isExist = false;
//            String categoriesName = InputMethod.getString();
//            for (int i = 0; i < categoriesList.size(); i++) {
//                if(categoriesList.get(i).getCatalogName().equals(categoriesName)){
//                    System.out.println("Categories Name is exist");
//                    isExist = true;
//                }
//            }
//            if (!isExist){
//                return categoriesName;
//            }
//        }while (true);
//    }
    @Override
    public void editElement() {
        System.out.println("Input Categories Id");
        int categoriesId = InputMethod.getByte();
        Categories categoriesUpdate = findById(categoriesId);
        if (categoriesUpdate == null) {
            System.out.println("Categories Not Found");
        } else {
            displayCategoriesInfoUpdate(categoriesUpdate);
            System.out.println("Update successfully");
        }

    }

    @Override
    public void displayCategoriesInfoUpdate(Categories categories) {

        while (true) {
            System.out.println("********************CATEGORIES UPDATE INFO***********");
            System.out.println("1. Categories Name");
            System.out.println("2. Categories Description");
            System.out.println("3. Categories Status");
            System.out.println("4. Sign Out");
            byte choice = InputMethod.getByte();
            boolean isOut = false;
            switch (choice) {
                case 1:
                    System.out.println("Input your Categories name");
                    categories.setCatalogName(InputMethod.getString());


                    break;
                case 2:
                    System.out.println("Input your Categories Desc");
                    categories.setDescriptions(InputMethod.getString());
                    break;
                case 3:
                    System.out.println("Input your Categories Status");
                    categories.setCatalogStatus(InputMethod.getBoolean());
                    break;
                case 4:
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
    public void updateCategoriesStatus() {
        System.out.println("Input Categories Id");
        int categoriesId = InputMethod.getByte();
        Categories categoriesUpdate = findById(categoriesId);
        if (categoriesUpdate == null) {
            System.out.println("Categories Not Found");
        } else {
            categoriesUpdate.setCatalogStatus(InputMethod.getBoolean());
            System.out.println("Update Status successfully");
        }
    }


}
