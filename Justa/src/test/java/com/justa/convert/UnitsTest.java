package com.justa.convert;

import com.justa.convert.controller.UnitController;
import com.justa.convert.model.Units;
import com.justa.convert.service.UnitService;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class UnitsTest {

    @Test
    public void givenUnit_whenConvertUnitsWithEqualsDate_thenTheReturnShouldBeSucess() throws Exception {
        BigDecimal multiplication_factor = new BigDecimal("0.0003046174197867086");
        Units unit = new Units();
        Units returnUnit = unit.ConvertUnits("degree*degree");
        assertEquals("rad*rad", returnUnit.getUnit_name());
        assertEquals(multiplication_factor, returnUnit.getMultiplication_factor());
    }

    @Test(expected = Exception.class)
    public void givenUnit_whenConvertUnitsWithEmpty_thenTheReturnShouldBeException() throws Exception {
        Units unit = new Units();
        Units returnUnit = unit.ConvertUnits("");
        assertNull(returnUnit);
    }


    @Test(expected = Exception.class)
    public void givenUnit_whenConvertUnitsWithNull_thenTheReturnShouldBeNull() throws Exception {
        Units unit = new Units();
        Units returnUnit = unit.ConvertUnits(null);
        assertNull(returnUnit);
    }


    @Test
    public void givenUnit_whenConvertUnitsWithDifferentData_thenTheReturnShouldBeNotEquals() throws Exception {
        BigDecimal multiplication_factor = new BigDecimal("1500.96447372310076");
        Units unit = new Units();
        Units returnUnit = unit.ConvertUnits("degree*day");
        assertNotEquals("rad*rad", returnUnit.getUnit_name());
        assertNotEquals(multiplication_factor, returnUnit.getMultiplication_factor());
    }

    @Test
    public void givenUnitService_whenConvertUnitsWithDifferentData_thenTheReturnShouldBeNotEquals() throws Exception {
        BigDecimal multiplication_factor = new BigDecimal("1500.96447372310076");
        UnitService service = new UnitService();
        Units unit = service.convertUnits("degree*day");
        assertNotEquals("rad*rad", unit.getUnit_name());
        assertNotEquals(multiplication_factor, unit.getMultiplication_factor());
    }

    @Test(expected = Exception.class)
    public void givenUnitService_whenConvertUnitsWithNull_thenTheReturnShouldBeNull() throws Exception {
        UnitService service = new UnitService();
        Units unit = service.convertUnits(null);
        assertNull(unit);
    }


    @Test(expected = Exception.class)
    public void givenUnitController_whenConvertUnitsWithNull_thenTheReturnShouldBeNull() throws Exception {
        UnitController controller = new UnitController();
        Units unit = controller.ConvertUnits(null);
        assertNull(unit);
    }
}
