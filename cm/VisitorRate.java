package cm;

import java.math.BigDecimal;

public class VisitorRate implements calculateInterface{

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
