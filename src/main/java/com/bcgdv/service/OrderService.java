package com.bcgdv.service;

import com.bcgdv.configuration.Parameters;
import com.bcgdv.configuration.Utils;
import com.bcgdv.exception.CreateOrderHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
  private final Parameters parameters;

  public Double makeOrder(List<String> watchesList) throws CreateOrderHandler {
    Utils utils = new Utils();
    double total = 0;

    if (watchesList.isEmpty()) {
      throw new CreateOrderHandler("Empty order ! ", null);
    }
    if (utils.invalidOrder(watchesList)) {
      throw new CreateOrderHandler("This is not a valid order ! ", null);
    }

    if (watchesList.contains(parameters.getRolexID())) {
      int occurrences = Collections.frequency(watchesList, parameters.getRolexID());
      if (occurrences < parameters.getRolexDiscountQuantity() && occurrences > 0) {
        total += parameters.getRolexPrice() * occurrences;
      } else if (occurrences > parameters.getRolexDiscountQuantity()) {
        int eligibleDiscount = (occurrences / parameters.getRolexDiscountQuantity());
        int normalPrice = (occurrences % parameters.getRolexDiscountQuantity());
        total += eligibleDiscount * parameters.getRolexDiscountPrice() + normalPrice * parameters.getRolexPrice();
      }
    }
    if (watchesList.contains(parameters.getMichaelkorsID())) {
      int occurrences = Collections.frequency(watchesList, parameters.getMichaelkorsID());
      if (occurrences < parameters.getMichaelkorsDiscountQuantity() && occurrences > 0) {
        total += parameters.getMichaelkorsPrice() * occurrences;
      } else if (occurrences > parameters.getRolexDiscountQuantity()) {
        int eligibleDiscount = (occurrences / parameters.getMichaelkorsDiscountQuantity());
        int normalPrice = (occurrences % parameters.getMichaelkorsDiscountPrice());
        total += eligibleDiscount * parameters.getMichaelkorsDiscountPrice() + normalPrice * parameters.getMichaelkorsPrice();
      }
    }
      int occurrencesCasio = Collections.frequency(watchesList, parameters.getCasioID());
      int occurrencesSwatch = Collections.frequency(watchesList, parameters.getSwatchID());
      total += occurrencesSwatch * parameters.getSwatchPrice() + occurrencesCasio * parameters.getCasioPrice();

    return total;
  }
}
