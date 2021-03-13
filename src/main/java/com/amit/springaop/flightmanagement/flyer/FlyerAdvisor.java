package com.amit.springaop.flightmanagement.flyer;

import org.springframework.aop.support.DefaultIntroductionAdvisor;

public class FlyerAdvisor extends DefaultIntroductionAdvisor {
    public FlyerAdvisor() {
        super(new FlyerImpl());
    }
}
