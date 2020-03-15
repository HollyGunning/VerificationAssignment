package cm;

import java.math.BigDecimal;

public class ManagementRate implements calculateInterface{
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