package com.bcgdv.service;

import com.bcgdv.configuration.Parameters;
import com.bcgdv.exception.CreateOrderHandler;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class OrderServiceTest {

  @InjectMocks
  private OrderService orderService;

  @Mock
  private Parameters parameters;
  private List<String> watchesOrder1;
  private List<String> watchesOrder2;
  private List<String> watchesOrder3;
  private List<String> watchesOrder4;
  private List<String> watchesOrder5;
  private List<String> watchesOrder6;

  @Before
  public void setUp() {
    orderService = new OrderService(parameters);

    watchesOrder1 = Arrays.asList("001", "001", "001", "001", "001","001","001");
    watchesOrder2 = new ArrayList<>();
    watchesOrder3 = Arrays.asList("UUU", "WWW", "001", "", "003");
    watchesOrder4 = Arrays.asList("001", "002", "001", "004", "008");
    watchesOrder5 = Arrays.asList("002", "002", "002", "002", "002","002","002");
    watchesOrder6 = Arrays.asList("001", "002", "001", "004", "003");

  }

  @Test
  public void whenOrderIsValid() throws CreateOrderHandler {

    when(parameters.getRolexPrice()).thenReturn(100.0);
    when(parameters.getRolexDiscountPrice()).thenReturn(200);
    when(parameters.getRolexDiscountQuantity()).thenReturn(3);
    when(parameters.getMichaelkorsPrice()).thenReturn(80.0);
    when(parameters.getMichaelkorsDiscountQuantity()).thenReturn(2);
    when(parameters.getMichaelkorsDiscountPrice()).thenReturn(120);
    when(parameters.getCasioPrice()).thenReturn(30.0);
    when(parameters.getSwatchPrice()).thenReturn(50.0);
    when(parameters.getRolexID()).thenReturn("001");
    when(parameters.getMichaelkorsID()).thenReturn("002");
    when(parameters.getSwatchID()).thenReturn("003");
    when(parameters.getCasioID()).thenReturn("004");

    Double total1 = orderService.makeOrder(watchesOrder1);
    assertThat(total1).isNotNull().isEqualTo(Double.valueOf(500));

    Double total2 = orderService.makeOrder(watchesOrder5);
    assertThat(total2).isNotNull().isEqualTo(Double.valueOf(440));

    Double total3 = orderService.makeOrder(watchesOrder6);
    assertThat(total3).isNotNull().isEqualTo(Double.valueOf(360));
  }
  @Test
  public void whenOrderIsNotValid() throws CreateOrderHandler {

    assertThrows(CreateOrderHandler.class, () -> orderService.makeOrder(watchesOrder2));
    assertThrows(CreateOrderHandler.class, () -> orderService.makeOrder(watchesOrder3));
    assertThrows(CreateOrderHandler.class, () -> orderService.makeOrder(watchesOrder4));

  }

}