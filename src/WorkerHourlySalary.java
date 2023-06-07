/**
 * работники с почасовой оплатой труда
 */
public class WorkerHourlySalary extends Workers{
     private Double salaryHourly; //почасовая ставка

     public WorkerHourlySalary(String name, Double salaryHourly) {
          this.name = name;
          this.salaryHourly = salaryHourly;
     }

     public Double getSalaryHourly() {
          return salaryHourly;
     }

     @Override
     Double avgSalary() {
          return 20.8 * 8 * salaryHourly;
     }

     @Override
     String GetInfo() {
          return "Работник с почас.оплатой имя: " + name + ", ср.зп = " + avgSalary();
     }
}
