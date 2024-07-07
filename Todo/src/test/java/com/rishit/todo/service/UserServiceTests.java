package com.rishit.todo.service;

import com.rishit.todo.repository.UserRepo;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserRepo userRepo;

    @Disabled
    @Test
    public void testFindByUserName(){
        assertNotNull(userRepo.findByUserName("Rishit"));
    }

    @ParameterizedTest
    @CsvSource({
            "1,2,3",
            "2,7,9"
    })
    public void test(int a,int b,int expected){
        assertEquals(expected,a+b,"Failed for these values ");
    }

}
