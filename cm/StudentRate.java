package cm;

import java.math.BigDecimal;

public class StudentRate implements calculateInterface{
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