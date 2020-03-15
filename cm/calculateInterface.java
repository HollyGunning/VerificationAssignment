package cm;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
//        return baseCost.setScale(0, RoundingMode.CEILING);
    }
}




