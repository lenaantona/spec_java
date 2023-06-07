/**
 * абстрактный класс работников
 */
public abstract class Workers {
    protected String name; //имя сотрудника

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    abstract Double avgSalary(); //метод вычисления среднемесячной з/п
    abstract String GetInfo(); //метод получения информации по сотруднику

}
