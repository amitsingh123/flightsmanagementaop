package com.amit.springaop.flightmanagement.flyer;

import org.springframework.aop.support.DelegatingIntroductionInterceptor;

public class FlyerImpl extends DelegatingIntroductionInterceptor implements Flyer {
    @Override
    public void takeoff() {
        System.out.println("Taking off");
    }

    @Override
    public void fly() {
        System.out.println("Flying");
    }

    @Override
    public void land() {
        System.out.println("Landing");
    }
}
