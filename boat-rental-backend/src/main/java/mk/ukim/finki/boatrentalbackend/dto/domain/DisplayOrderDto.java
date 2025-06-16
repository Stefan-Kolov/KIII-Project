package mk.ukim.finki.boatrentalbackend.dto.domain;

import mk.ukim.finki.boatrentalbackend.model.domain.Order;
import mk.ukim.finki.boatrentalbackend.model.enums.BoatStatus;
import mk.ukim.finki.boatrentalbackend.model.enums.OrderStatus;

import java.util.List;

public record DisplayOrderDto(
        String username,
        List<DisplayBoatDto> boats,
        OrderStatus status
) {

    public static DisplayOrderDto from(Order order) {
        return new DisplayOrderDto(
                order.getUser().getUsername(),
                DisplayBoatDto.from(order.getBoats()),
                order.getStatus()
        );
    }

}
