package ra.design;

public interface IGenericDesign<T,E> {

    void addNewElement();

    void editElement();

    void deleteElement();

    void displayAll();
    String checkName();

    T findById(E id);

    T inputData(boolean isAdd);
}
