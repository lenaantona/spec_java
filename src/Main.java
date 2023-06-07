
public class Main {
    public static void main(String[] args) {
        Workers[] worker = {
                new WorkerFixedSalary("Дима", 25000.00),
                new WorkerHourlySalary("Кирилл", 250.00),
                new WorkerFixedSalary("Дима", 23000.00),
                new WorkerHourlySalary("Кирилл", 255.00),
        };

        for (Workers w: worker){
            System.out.println(w.GetInfo());
        }
    }
}