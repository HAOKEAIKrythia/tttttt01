package com.jiker.keju;

import org.junit.Test;


import static org.junit.Assert.*;

public class TaxiTest {
    @Test
    public void should_return_receipt_le_2(){
        Taxi taxi = new Taxi();
        taxi.parameter(1,0);
        assertEquals("收费6元\n","收费"+(int)Math.round(taxi.getDistancePrice())+"元\n");
        assertEquals("收费6元"+"\n",taxi.getPrice());
    }
    @Test
    public void should_return_receipt_2_to_8(){
        Taxi taxi = new Taxi();
        taxi.parameter(6,0);
        assertEquals("收费9元\n","收费"+(int)Math.round(taxi.getDistancePrice())+"元\n");
        assertEquals("收费9元"+"\n",taxi.getPrice());
    }
    @Test
    public void should_return_receipt_gt_8(){
        Taxi taxi = new Taxi();
        taxi.parameter(10,0);
        assertEquals("收费13元\n","收费"+(int)Math.round(taxi.getDistancePrice())+"元\n");
        assertEquals("收费13元"+"\n",taxi.getPrice());
    }
    @Test
    public void should_return_receipt_le_2_waitingTime_2(){
        Taxi taxi = new Taxi();
        taxi.parameter(2,2);
        assertEquals("收费6元\n","收费"+(int)Math.round(taxi.getDistancePrice())+"元\n");
        assertEquals("收费7元"+"\n",taxi.getPrice());
    }
    @Test
    public void should_return_receipt_2_to_8_waitingTime_4(){
        Taxi taxi = new Taxi();
        taxi.parameter(5,4);
        assertEquals("收费8元\n","收费"+(int)Math.round(taxi.getDistancePrice())+"元\n");
        assertEquals("收费9元"+"\n",taxi.getPrice());
    }
    @Test
    public void should_return_receipt_gt_8_waitingTime_6(){
        Taxi taxi = new Taxi();
        taxi.parameter(12,6);
        assertEquals("收费16元\n","收费"+(int)Math.round(taxi.getDistancePrice())+"元\n");
        assertEquals("收费17元"+"\n",taxi.getPrice());
    }
}