package com.exam.Gateway;

import com.exam.Gateway.test_model.Customer;
import org.assertj.core.api.BDDAssertions;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
@AutoConfigureStubRunner(
        ids = "com.example.demo:customer-service:0.0.1-SNAPSHOT:stubs:8081",
        stubsMode = StubRunnerProperties.StubsMode.LOCAL
)
public class ContractIntegrationTest {

    @Test
    public void get_person_from_service_contract() {
        // given:
        RestTemplate restTemplate = new RestTemplate();

        // when:
        ResponseEntity<Customer> personResponseEntity = restTemplate.getForEntity("http://localhost:8081/api/customer/20", Customer.class);

        // then:
        BDDAssertions.then(personResponseEntity.getStatusCodeValue()).isEqualTo(200);
        BDDAssertions.then(personResponseEntity.getBody().getId()).isEqualTo(20l);
        BDDAssertions.then(personResponseEntity.getBody().getName()).isEqualTo("Rodd Rosenkranc");
        BDDAssertions.then(personResponseEntity.getBody().getEmail()).isEqualTo("rrosenkrancj@edublogs.org");
        BDDAssertions.then(personResponseEntity.getBody().getPhone()).isEqualTo("+86 783 433 1537");
        BDDAssertions.then(personResponseEntity.getBody().getAddress().getId()).isEqualTo(110l);
        BDDAssertions.then(personResponseEntity.getBody().getAddress().getStreet()).isEqualTo("80187 Kunze Heights");
        BDDAssertions.then(personResponseEntity.getBody().getAddress().getCity()).isEqualTo("Eulahland");
        BDDAssertions.then(personResponseEntity.getBody().getAddress().getPostalCode()).isEqualTo(320736158);

    }
}
