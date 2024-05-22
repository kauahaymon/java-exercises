package abstract_instances;

public abstract class TaxPayer {
    private String name;
    private Double annualIncome;

    public TaxPayer() {}

    public TaxPayer(String name, Double annualIncome) {
        this.name = name;
        this.annualIncome = annualIncome;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAnnualIncome() {
        return annualIncome;
    }

    public abstract double tax();
}
