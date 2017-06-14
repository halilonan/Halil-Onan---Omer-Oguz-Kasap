package com.medipol.springdemo;

import org.junit.Test;

public class MedipolBasketRestControllerTest {

    @Test
    public void shouldAddProductToBasket() throws Exception {

        final MedipolBasketRestController controller = new MedipolBasketRestController();

        controller.addToBasket(1, 1);

    }
}