package entities;

import entities.enums.WorkerLevel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Worker {
    //adicionando os atributos e a enumeração
     private String name;
     private WorkerLevel level;
     private double baseSalary;
     //adicionando aciociação
     private Department department;

     //adicionando uma lista de contratos
     private List<HourContract> contracts = new ArrayList<>();

     public Worker(){}

    public Worker(String name, WorkerLevel level, double baseSalary, Department department) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

        //a lista de contratos tem que ser adicionada ou removida,
        //nunca incluida em um set, pois se não você altera a lista
        //por um todo
        //public void setContracts(List<HourContract> contracts) {
        //    this.contracts = contracts;
        //}

    public void addContract(HourContract contract){
         this.contracts.add(contract);
    }
    public void removeContract(HourContract contract){
         this.contracts.remove(contract);
    }

    public double income(int year, int month){
         double sum = baseSalary;
         Calendar cal = Calendar.getInstance();
         //percorrendo o arraylist com base no paramento HourContract


        for (HourContract c : contracts){
            cal.setTime(c.getDate());
            int c_year = cal.get(Calendar.YEAR);
            int c_month = 1 + cal.get(Calendar.MONTH);

            if (year == c_year && month == c_month) {
            sum += c.totalValue();
            }
         }
        return sum;
    }
}
