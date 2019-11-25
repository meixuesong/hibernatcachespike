package com.github.meixuesong.hibernatespike;

import com.github.meixuesong.hibernatespike.user.ChangeUserNameRequest;
import com.github.meixuesong.hibernatespike.user.User;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;

public class UserControllerTest extends ApiTest {
    @Test
    @Sql(scripts = "classpath:sql/user-test-before.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "classpath:sql/user-test-after.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void should_add_user() {
        String userId = "TEST_USER_ID";
        String newName = "TEST_USER_NAME2";
        ChangeUserNameRequest request = new ChangeUserNameRequest(userId, newName);

        //When
        this.restTemplate.put(baseUrl + "/users/"+ userId, request);

        //Then
        ResponseEntity<User> responseEntity = this.restTemplate.getForEntity(baseUrl + "/users/" + userId, User.class);
        assertThat(responseEntity.getBody().getName()).isEqualTo(newName);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
