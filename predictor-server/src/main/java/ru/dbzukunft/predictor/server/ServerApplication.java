package ru.dbzukunft.predictor.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }
}

//USD = "$.Valute.USD"
//EUR = "$.Valute.EUR"
/*public static Valute extractValuteData(Response<BodyWrapper> response) {
    assertResponse(response)
            .is200OK()
            .isNotNullData();
    assert response.body() != null;
    return response.body().convert(USD, Valute.class);
}*/

//tests

/*
await().atMost(5, SECONDS)
        .untilAsserted(() -> assertThat(extractValuteData(response)
            .isEqualTo(...)));
 */