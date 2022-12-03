package disjoint;

public class IndividualContributor extends Employee {

    private String jobGroup;
    private Seniority seniority;

    public IndividualContributor(String firstName, String lastName, String employeeId, double salary, String jobGroup, Seniority seniority) {
        super(firstName, lastName, employeeId, salary);

        setJobGroup(jobGroup);
        setSeniority(seniority);
    }

    public String getJobGroup() {
        return this.jobGroup;
    }

    public Seniority getSeniority() {
        return this.seniority;
    }

    public void setJobGroup(String jobGroup) {
        if (jobGroup == null || jobGroup.isEmpty()) {
            throw new IllegalArgumentException("Job group cannot be empty.");
        }

        this.jobGroup = jobGroup;
    }

    public void setSeniority(Seniority seniority) {
        if (seniority == null) {
            throw new IllegalArgumentException("Seniority cannot be null.");
        }

        this.seniority = seniority;
    }
    
    @Override
    public String toString() {
        return "IndividualContributor {" +
                    " firstName=" + super.getFirstName() +
                    ", lastName=" + super.getLastName() + 
                    ", salary=" + super.getSalary() +
                    ", jobGroup=" + this.jobGroup +
                    ", seniority=" + this.seniority +
                " }";
    }
}