package cm;

import java.math.BigDecimal;

public interface calculateInterface {
    BigDecimal calculate(BigDecimal baseCost);
}

class VisitorRate implements calculateInterface{

    @Override
    public BigDecimal calculate(BigDecimal baseCost){
        BigDecimal firstEightEuro = new BigDecimal("8");
        BigDecimal reduction = new BigDecimal("2");

        if (baseCost.compareTo(firstEightEuro) <= 0) {
            return new BigDecimal(0);
        }
        else {
            return baseCost.subtract(firstEightEuro).divide(reduction);
        }
    }
}


class ManagementRate implements calculateInterface{
    @Override
    public BigDecimal calculate(BigDecimal baseCost){
        BigDecimal minPay = new BigDecimal("3");

        if (baseCost.compareTo(minPay) < 0) {
            return minPay;
        }
        else {
            return baseCost;
        }
    }
}


class StudentRate implements calculateInterface{
    @Override
    public BigDecimal calculate(BigDecimal baseCost){
        BigDecimal standard = new BigDecimal("5.50");
        BigDecimal remainder = baseCost.subtract(standard);
        BigDecimal threeQuarter = new BigDecimal("0.75");

        if (baseCost.compareTo(standard) <= 0) {
            return baseCost;
        }
        else if (baseCost.compareTo(standard) > 0) {
            baseCost = threeQuarter.multiply(remainder).add(standard);
        }
        return baseCost;
    }
}


class StaffRate implements calculateInterface{
    @Override
    public BigDecimal calculate(BigDecimal baseCost){
        BigDecimal maxPay = new BigDecimal("16");

        if (baseCost.compareTo(maxPay) < 0) {
            return baseCost;
        } else {
            return maxPay;
        }
    }
}




