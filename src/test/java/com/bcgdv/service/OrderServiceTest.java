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
  private List<String> watches1;
  private List<String> watches2;
  private List<String> watches3;
  private List<String> watches4;

  @Before
  public void setUp() {
    orderService = new OrderService(parameters);
     watches1 = Arrays.asList("001", "001", "001", "001", "001","001","001");
     watches2 = new ArrayList<>();
     watches3 = Arrays.asList("UUU", "WWW", "001", "", "003");
     watches4 = Arrays.asList("001", "002", "001", "004", "008");
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

    Double total = orderService.makeOrder(watches1);
    assertThat(total).isNotNull().isEqualTo(Double.valueOf(500));

  }
  @Test
  public void whenOrderIsNotValid() throws CreateOrderHandler {

    assertThrows(CreateOrderHandler.class, () -> orderService.makeOrder(watches2));
    assertThrows(CreateOrderHandler.class, () -> orderService.makeOrder(watches3));
    assertThrows(CreateOrderHandler.class, () -> orderService.makeOrder(watches4));

  }

}