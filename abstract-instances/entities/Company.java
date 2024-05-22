package abstract_instances;

public class Company extends TaxPayer {
    private Integer numberEmployee;

    public Company() {}

    public Company(String name, Double annualIncome, Integer numberEmployee) {
        super(name, annualIncome);
        this.numberEmployee = numberEmployee;
    }

    public Integer getNumberEmployee() {
        return numberEmployee;
    }

    public void setNumberEmployee(Integer numberEmployee) {
        this.numberEmployee = numberEmployee;
    }

    @Override
    public double tax() {
        if (numberEmployee < 10) {
            return getAnnualIncome() * 0.16;
        }
        else {
            return getAnnualIncome() * 0.14;
        }
    }
}
