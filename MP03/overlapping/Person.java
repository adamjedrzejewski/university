package overlapping;

import java.util.EnumSet;

public class Person {
    private int yearsOfService;
    private int numberOfChildren;
    private int age;

    private final EnumSet<PersonTaxClass> taxClasses;

    public Person(int armyYearsOfService, int numberOfChildren, int age) {
        taxClasses = EnumSet.of(PersonTaxClass.BASIC);

        setArmyClass(armyYearsOfService);
        setParentClass(numberOfChildren);
        setYoungWorker(age);
    }

    public int getYearsOfService() {
        return yearsOfService;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    public int getAge() {
        return age;
    }

    public EnumSet<PersonTaxClass> getTaxClasses() {
        return EnumSet.copyOf(taxClasses);
    }

    public void setYearsOfService(int yearsOfService) {
        if (yearsOfService < 0) {
            throw new IllegalArgumentException("Years of service must be non-negative.");
        }
        this.yearsOfService = yearsOfService;
    }

    public void setNumberOfChildren(int numberOfChildren) {
        if (numberOfChildren < 0) {
            throw new IllegalArgumentException("Number of children must be non-negative.");
        }
        this.numberOfChildren = numberOfChildren;
    }

    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be positive.");
        }
        this.age = age;
    }

    private void setYoungWorker(int age) {
        if (age < 26) {
            taxClasses.add(PersonTaxClass.YOUNGER_THAN_26);
        }
        setAge(age);
    }

    private void setParentClass(int numberOfChildren) {
        if (numberOfChildren > 1) {
            taxClasses.add(PersonTaxClass.TWO_OR_MORE_CHILDREN);
        }

        setNumberOfChildren(numberOfChildren);
    }

    private void setArmyClass(int armyYearsOfService) {
        if (yearsOfService > 0) {
            taxClasses.add(PersonTaxClass.ARMY);
        }

        setYearsOfService(armyYearsOfService);
    }

    private double getChildrenDiscount() {
        return numberOfChildren * 0.01;
    }

    private double getYearsOfServiceDiscount() {
        return yearsOfService * 0.02;
    }

    public double getTaxOnIncome(int accumulatedAnnualIncome) {
        double taxRate = 0.17;
        if (accumulatedAnnualIncome > 120000) {
            taxRate = 0.32;
        }

        if (taxClasses.contains(PersonTaxClass.ARMY)) {
            taxRate -= getYearsOfServiceDiscount();
            if (taxRate < 0.10) {
                taxRate = 0.10;
            }
        }
        if (taxClasses.contains(PersonTaxClass.TWO_OR_MORE_CHILDREN)) {
            taxRate -= getChildrenDiscount();
            if (taxRate < 0.05) {
                taxRate = 0.05;
            }
        }
        if (taxClasses.contains(PersonTaxClass.YOUNGER_THAN_26)) {
            taxRate = 0;
        }

        return accumulatedAnnualIncome * taxRate;
    }

}
