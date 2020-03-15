package cm;

import java.math.BigDecimal;

public class StaffRate implements calculateInterface{
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