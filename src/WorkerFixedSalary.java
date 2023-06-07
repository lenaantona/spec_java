/**
 * работники с фиксированной оплатой труда
 */
public class WorkerFixedSalary extends Workers {
    private Double salaryFixed; //фиксированная месячная оплата
    public WorkerFixedSalary(String name, Double salary) {
        this.name = name;
        this.salaryFixed = salary;
    }

    public Double getSalaryFixed() {
        return salaryFixed;
    }

    @Override
    Double avgSalary() {
        return salaryFixed;
    }

    @Override
    String GetInfo() {
        return "Работник с фик.оплатой имя: " + name + ", ср.зп = " + avgSalary();
    }
}