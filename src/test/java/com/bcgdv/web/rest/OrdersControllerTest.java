package com.bcgdv.web.rest;

import com.bcgdv.exception.CreateOrderHandler;
import com.bcgdv.service.OrderService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
public class OrdersControllerTest {
  private MockMvc mockMvc;

  @Mock
  private OrderService orderService;


  @Before
  public void setup() {
    this.mockMvc = MockMvcBuilders.standaloneSetup(new OrdersController(orderService)).build();
  }

  @Test
  public void whenPostOrder_thenCheckout() throws Exception {

     List<String> watchesOrder = Arrays.asList("001", "002", "001", "004", "003");
     Double price = 360.0;
     given(orderService.makeOrder(watchesOrder)).willReturn(price);

    mockMvc.perform(post("/checkout")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(JsonUtil.toJson(watchesOrder))
    ).andExpect(status().isCreated());
  }
}