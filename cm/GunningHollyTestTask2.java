package cm;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;

public class GunningHollyTestTask2
{
    // 18. All parameters pass
    @Test
    public void success()
    {
        Period normalPeriod = new Period(0,6);
        Period reducedPeriod = new Period(8,12);
        ArrayList<Period> nP = new ArrayList<Period>();
        ArrayList<Period> rP = new ArrayList<Period>();
        nP.add(normalPeriod);
        rP.add(reducedPeriod);
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normalRate = new BigDecimal(4);
        BigDecimal reducedRate = new BigDecimal(2);

        Rate rate = new Rate(kind, normalRate, reducedRate, rP, nP);
    }

    // 1. Negative normalRate
    @Test(expected = IllegalArgumentException.class)
    public void negativeNormalRate()
    {
        Period normalPeriod = new Period(8,23);
        Period reducedPeriod = new Period(0,7);
        ArrayList<Period> nP = new ArrayList<Period>();
        ArrayList<Period> rP = new ArrayList<Period>();
        nP.add(normalPeriod);
        rP.add(reducedPeriod);
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normalRate = new BigDecimal(-2);
        BigDecimal reducedRate = new BigDecimal(1);

        Rate rate = new Rate(kind, normalRate, reducedRate, rP, nP);
    }

    // 2. Negative reducedRate
    @Test(expected = IllegalArgumentException.class)
    public void negativeReducedRate()
    {
        Period normalPeriod = new Period(3,8);
        Period reducedPeriod = new Period(9,21);
        ArrayList<Period> nP = new ArrayList<Period>();
        ArrayList<Period> rP = new ArrayList<Period>();
        nP.add(normalPeriod);
        rP.add(reducedPeriod);
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(-3);

        Rate rate = new Rate(kind, normalRate, reducedRate, rP, nP);
    }

    // 3. NormalRate must be > reducedRate
    @Test(expected = IllegalArgumentException.class)
    public void normalRateGreaterThanReducedRate()
    {
        Period normalPeriod = new Period(0,6);
        Period reducedPeriod = new Period(8,10);
        ArrayList<Period> nP = new ArrayList<Period>();
        ArrayList<Period> rP = new ArrayList<Period>();
        nP.add(normalPeriod);
        rP.add(reducedPeriod);
        CarParkKind kind = CarParkKind.MANAGEMENT;
        BigDecimal normalRate = new BigDecimal(1);
        BigDecimal reducedRate = new BigDecimal(5);

        Rate rate = new Rate(kind, normalRate, reducedRate, rP, nP);
    }

    // 4. Overlap between normalPeriod & reducedPeriod
    @Test(expected = IllegalArgumentException.class)
    public void overlapNormalPeriodReducedPeriod()
    {
        Period normalPeriod = new Period(3,9);
        Period reducedPeriod = new Period(8,23);
        ArrayList<Period> nP = new ArrayList<Period>();
        ArrayList<Period> rP = new ArrayList<Period>();
        nP.add(normalPeriod);
        rP.add(reducedPeriod);
        CarParkKind kind = CarParkKind.VISITOR;
        BigDecimal normalRate = new BigDecimal(7);
        BigDecimal reducedRate = new BigDecimal(3);

        Rate rate = new Rate(kind, normalRate, reducedRate, rP, nP);
    }

    // 5. Negative end normalPeriod
    @Test(expected = IllegalArgumentException.class)
    public void negativeEndNormalPeriod()
    {
        Period normalPeriod = new Period(0,-8);
        Period reducedPeriod = new Period(9,17);
        ArrayList<Period> nP = new ArrayList<Period>();
        ArrayList<Period> rP = new ArrayList<Period>();
        nP.add(normalPeriod);
        rP.add(reducedPeriod);
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normalRate = new BigDecimal(11);
        BigDecimal reducedRate = new BigDecimal(7);

        Rate rate = new Rate(kind, normalRate, reducedRate, rP, nP);
    }

    // 6. Negative end reducedPeriod
    @Test(expected = IllegalArgumentException.class)
    public void negativeEndReducedPeriod()
    {
        Period normalPeriod = new Period(12,14);
        Period reducedPeriod = new Period(5,-8);
        ArrayList<Period> nP = new ArrayList<Period>();
        ArrayList<Period> rP = new ArrayList<Period>();
        nP.add(normalPeriod);
        rP.add(reducedPeriod);
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(6);
        BigDecimal reducedRate = new BigDecimal(2);

        Rate rate = new Rate(kind, normalRate, reducedRate, rP, nP);
    }

    // 7. Overlap of normalPeriod
    @Test(expected = IllegalArgumentException.class)
    public void overlapNormalPeriod()
    {
        Period a = new Period(0, 8);
        Period b = new Period(6,12);
        Period c = new Period(13,15);
        Period d = new Period(17,23);
        ArrayList<Period> nP = new ArrayList<Period>();
        ArrayList<Period> rP = new ArrayList<Period>();
        nP.add(a);
        nP.add(b);
        rP.add(c);
        rP.add(d);
        CarParkKind kind = CarParkKind.MANAGEMENT;
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);

        Rate rate = new Rate(kind, normalRate, reducedRate, rP, nP);
    }

    // 8. Overlap of reducedPeriod
    @Test(expected = IllegalArgumentException.class)
    public void overlapReducedPeriod()
    {
        Period a = new Period(0,8);
        Period b = new Period(9,12);
        Period c = new Period(13,15);
        Period d = new Period(14,23);
        ArrayList<Period> nP = new ArrayList<Period>();
        ArrayList<Period> rP = new ArrayList<Period>();
        nP.add(a);
        nP.add(b);
        rP.add(c);
        rP.add(d);
        CarParkKind kind = CarParkKind.VISITOR;
        BigDecimal normalRate = new BigDecimal(4);
        BigDecimal reducedRate = new BigDecimal(2);

        Rate rate = new Rate(kind, normalRate, reducedRate, rP, nP);
    }

    // 9. Overlap between normalPeriod & reducedPeriod
    @Test(expected = IllegalArgumentException.class)
    public void overlap()
    {
        Period a = new Period(0,8);
        Period b = new Period(9,12);
        Period c = new Period(11,13);
        Period d = new Period(14,23);
        ArrayList<Period> nP = new ArrayList<Period>();
        ArrayList<Period> rP = new ArrayList<Period>();
        nP.add(a);
        nP.add(b);
        rP.add(c);
        rP.add(d);
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);

        Rate rate = new Rate(kind, normalRate, reducedRate, rP, nP);
    }

    // 10. NormalRate is null
    @Test(expected = IllegalArgumentException.class)
    public void normalRateNull()
    {
        Period normalPeriod = new Period(3,9);
        Period reducedPeriod = new Period(11,15);
        ArrayList<Period> nP = new ArrayList<Period>();
        ArrayList<Period> rP = new ArrayList<Period>();
        nP.add(normalPeriod);
        rP.add(reducedPeriod);
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = null;
        BigDecimal reducedRate = new BigDecimal(4);

        Rate rate = new Rate(kind, null, reducedRate, rP, nP);
    }

    // 11. ReducedRate is null
    @Test(expected = IllegalArgumentException.class)
    public void reducedRateNull()
    {
        Period normalPeriod = new Period(2,11);
        Period reducedPeriod = new Period(15,22);
        ArrayList<Period> nP = new ArrayList<Period>();
        ArrayList<Period> rP = new ArrayList<Period>();
        nP.add(normalPeriod);
        rP.add(reducedPeriod);
        CarParkKind kind = CarParkKind.MANAGEMENT;
        BigDecimal normalRate = new BigDecimal(6);
        BigDecimal reducedRate = null;

        Rate rate = new Rate(kind, normalRate, null, rP, nP);
    }

    // 12. NormalPeriod is null
    @Test(expected = IllegalArgumentException.class)
    public void normalPeriodNull()
    {
        Period normalPeriod = null;
        Period reducedPeriod = new Period(15,22);
        ArrayList<Period> nP = new ArrayList<Period>();
        ArrayList<Period> rP = new ArrayList<Period>();
        nP.add(null);
        rP.add(reducedPeriod);
        CarParkKind kind = CarParkKind.VISITOR;
        BigDecimal normalRate = new BigDecimal(6);
        BigDecimal reducedRate = new BigDecimal(3);

        Rate rate = new Rate(kind, normalRate, reducedRate, rP, null);
    }

    // 13. ReducedPeriod is null
    @Test( expected = IllegalArgumentException.class)
    public void reducedPeriodNull()
    {
        Period normalPeriod = new Period(2,11);
        Period reducedPeriod = null;
        ArrayList<Period> nP = new ArrayList<Period>();
        ArrayList<Period> rP = new ArrayList<Period>();
        nP.add(normalPeriod);
        rP.add(null);
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normalRate = new BigDecimal(8);
        BigDecimal reducedRate = new BigDecimal(4);

        Rate rate = new Rate(kind, normalRate, reducedRate, null, nP);
    }

    // 14. ReducedPeriod end hour >23
    @Test(expected = IllegalArgumentException.class)
    public void reducedPeriodEndHourGreater23()
    {

        Period normalPeriod = new Period(0,6);
        Period reducedPeriod = new Period(8,27);
        ArrayList<Period> nP = new ArrayList<Period>();
        ArrayList<Period> rP = new ArrayList<Period>();
        nP.add(normalPeriod);
        rP.add(reducedPeriod);
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normalRate = new BigDecimal(4);
        BigDecimal reducedRate = new BigDecimal(2);

        Rate rate = new Rate(kind, normalRate, reducedRate, rP, nP);
    }

    // 15. NormalPeriod end hour >23
    @Test(expected = IllegalArgumentException.class)
    public void normalPeriodEndHourGreater23()
    {
        Period normalPeriod = new Period(21,26);
        Period reducedPeriod = new Period(1,5);
        ArrayList<Period> nP = new ArrayList<Period>();
        ArrayList<Period> rP = new ArrayList<Period>();
        nP.add(normalPeriod);
        rP.add(reducedPeriod);
        CarParkKind kind = CarParkKind.MANAGEMENT;
        BigDecimal normalRate = new BigDecimal(11);
        BigDecimal reducedRate = new BigDecimal(7);

        Rate rate = new Rate(kind, normalRate, reducedRate, rP, nP);
    }

    // 16. Negative start normalPeriod
    @Test(expected = IllegalArgumentException.class)
    public void negativeStartNormalPeriod()
    {
        Period normalPeriod = new Period(-2,8);
        Period reducedPeriod = new Period(9,5);
        ArrayList<Period> nP = new ArrayList<Period>();
        ArrayList<Period> rP = new ArrayList<Period>();
        nP.add(normalPeriod);
        rP.add(reducedPeriod);
        CarParkKind kind = CarParkKind.VISITOR;
        BigDecimal normalRate = new BigDecimal(6);
        BigDecimal reducedRate = new BigDecimal(2);

        Rate rate = new Rate(kind, normalRate, reducedRate, rP, nP);
    }

    // 17. Negative start reducedPeriod
    @Test(expected = IllegalArgumentException.class)
    public void negativeStartReducedPeriod()
    {
        Period normalPeriod = new Period(2,8);
        Period reducedPeriod = new Period(-4,1);
        ArrayList<Period> nP = new ArrayList<Period>();
        ArrayList<Period> rP = new ArrayList<Period>();
        nP.add(normalPeriod);
        rP.add(reducedPeriod);
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normalRate = new BigDecimal(6);
        BigDecimal reducedRate = new BigDecimal(2);

        Rate rate = new Rate(kind, normalRate, reducedRate, rP, nP);
    }


    //  19. Between normal & reduced Period
    @Test
    public void betweenNormalReducedPeriod()
    {
        Period normalPeriod = new Period(0,5);
        Period reducedPeriod = new Period(6,20);
        ArrayList<Period> nP = new ArrayList<Period>();
        ArrayList<Period> rP = new ArrayList<Period>();
        nP.add(normalPeriod);
        rP.add(reducedPeriod);
        CarParkKind kind = CarParkKind.MANAGEMENT;
        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(5);

        Rate rate = new Rate(kind, normalRate, reducedRate, rP, nP);
        Period stayPeriod = new Period(4,7);

        assertEquals(rate.calculate(stayPeriod), new BigDecimal(15));
    }

    //  20. During normalPeriod
    @Test
    public void duringNormalPeriod()
    {
        Period normalPeriod = new Period(0,7);
        Period reducedPeriod = new Period(8,19);
        ArrayList<Period> nP = new ArrayList<Period>();
        ArrayList<Period> rP = new ArrayList<Period>();
        nP.add(normalPeriod);
        rP.add(reducedPeriod);
        CarParkKind kind = CarParkKind.VISITOR;
        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(5);

        Rate rate = new Rate(kind, normalRate, reducedRate, rP, nP);
        Period stayPeriod = new Period(2,7);

        assertEquals(rate.calculate(stayPeriod), new BigDecimal(50));
    }

    // 21. During reducedPeriod
    @Test
    public void duringReducedPeriod()
    {
        Period normalPeriod = new Period(0,6);
        Period reducedPeriod = new Period(7,20);
        ArrayList<Period> nP = new ArrayList<Period>();
        ArrayList<Period> rP = new ArrayList<Period>();
        nP.add(normalPeriod);
        rP.add(reducedPeriod);
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(5);

        Rate rate = new Rate(kind, normalRate, reducedRate, rP, nP);
        Period stayPeriod = new Period(15,18);

        assertEquals(rate.calculate(stayPeriod), new BigDecimal(15));
    }

    // 22. During freePeriod
    @Test
    public void duringFreePeriod()
    {
        Period normalPeriod = new Period(7,18);
        Period reducedPeriod = new Period(19,23);
        ArrayList<Period> nP = new ArrayList<Period>();
        ArrayList<Period> rP = new ArrayList<Period>();
        nP.add(normalPeriod);
        rP.add(reducedPeriod);
        CarParkKind kind = CarParkKind.STAFF;
        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(5);

        Rate rate = new Rate(kind, normalRate, reducedRate, rP, nP);
        Period stayPeriod = new Period(0,6);

        assertEquals(rate.calculate(stayPeriod), new BigDecimal(0));
    }

    // 23. Between normal and free period
    @Test
    public void btwnNormalFreePeriod()
    {
        Period normalPeriod = new Period(10,21);
        Period reducedPeriod = new Period(0,9);
        ArrayList<Period> nP = new ArrayList<Period>();
        ArrayList<Period> rP = new ArrayList<Period>();
        nP.add(normalPeriod);
        rP.add(reducedPeriod);
        CarParkKind kind = CarParkKind.MANAGEMENT;
        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(5);

        Rate rate = new Rate(kind, normalRate, reducedRate, rP, nP);
        Period stayPeriod = new Period(19,23);

        assertEquals(rate.calculate(stayPeriod), new BigDecimal(20));

    }

    // 24. Between reduced and free period
    @Test
    public void btwnReducedFreePeriod()
    {
        Period normalPeriod = new Period(0,17);
        Period reducedPeriod = new Period(18,20);
        ArrayList<Period> nP = new ArrayList<Period>();
        ArrayList<Period> rP = new ArrayList<Period>();
        nP.add(normalPeriod);
        rP.add(reducedPeriod);
        CarParkKind kind = CarParkKind.VISITOR;
        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(5);

        Rate rate = new Rate(kind, normalRate, reducedRate, rP, nP);
        Period stayPeriod = new Period(19,21);

        assertEquals(new BigDecimal(5),rate.calculate(stayPeriod));
    }

    // 25. Null Stay Period Exception
    @Test(expected = IllegalArgumentException.class)
    public void nullStayPeriod()
    {
        Period normalPeriod = new Period(0,15);
        Period reducedPeriod = new Period(16,21);
        ArrayList<Period> nP = new ArrayList<Period>();
        ArrayList<Period> rP = new ArrayList<Period>();
        nP.add(normalPeriod);
        rP.add(reducedPeriod);
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normalRate = new BigDecimal(10);
        BigDecimal reducedRate = new BigDecimal(5);

        Rate rate = new Rate(kind, normalRate, reducedRate, rP, nP);
        Period stayPeriod = null;

        assertEquals(rate.calculate(stayPeriod), null);
    }

    // 26. Triple overlap of normalPeriod
    @Test(expected = IllegalArgumentException.class)
    public void tripleOverlapNRPeriod()
    {
        Period a = new Period(0, 8);
        Period b = new Period(6,12);
        Period y = new Period(11, 15);
        Period c = new Period(0,8);
        Period d = new Period(6,12);
        Period z = new Period(11,15);

        ArrayList<Period> nP = new ArrayList<Period>();
        ArrayList<Period> rP = new ArrayList<Period>();
        nP.add(a);
        nP.add(b);
        nP.add(y);
        rP.add(c);
        rP.add(d);
        rP.add(z);

        CarParkKind kind = CarParkKind.MANAGEMENT;
        BigDecimal normalRate = new BigDecimal(5);
        BigDecimal reducedRate = new BigDecimal(2);

        Rate rate = new Rate(kind, normalRate, reducedRate, rP, nP);
    }

    // 27. Reduced rate = 0
    @Test
    public void reduceR0()
    {
        Period normalPeriod = new Period(8,23);
        Period reducedPeriod = new Period(0,7);
        ArrayList<Period> nP = new ArrayList<Period>();
        ArrayList<Period> rP = new ArrayList<Period>();
        nP.add(normalPeriod);
        rP.add(reducedPeriod);
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normalRate = new BigDecimal(2);
        BigDecimal reducedRate = new BigDecimal(0);

        Rate rate = new Rate(kind, normalRate, reducedRate, rP, nP);
    }

    // 28. Normal rate = 0
    @Test
    public void normalR0()
    {
        Period normalPeriod = new Period(8,23);
        Period reducedPeriod = new Period(0,7);
        ArrayList<Period> nP = new ArrayList<Period>();
        ArrayList<Period> rP = new ArrayList<Period>();
        nP.add(normalPeriod);
        rP.add(reducedPeriod);
        CarParkKind kind = CarParkKind.STUDENT;
        BigDecimal normalRate = new BigDecimal(0);
        BigDecimal reducedRate = new BigDecimal(0);

        Rate rate = new Rate(kind, normalRate, reducedRate, rP, nP);
    }
}
