package abstract_instances;

public class Individual extends TaxPayer {
    private Double healthSpending;

    public Individual() {
    }

    public Individual(String name, Double income, Double healthSpending) {
        super(name, income);
        this.healthSpending = healthSpending;
    }

    public Double getHealthSpending() {
        return healthSpending;
    }

    public void setHealthSpending(Double healthSpending) {
        this.healthSpending = healthSpending;
    }

    @Override
    public double tax() {
        if (getAnnualIncome() < 20000.00 && healthSpending != 0.0) {
            return (getAnnualIncome() * 0.15) - (healthSpending * 0.50);
        }
        else {
            return (getAnnualIncome() * 0.25) - (healthSpending * 0.50);
        }
    }
}
