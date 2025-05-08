package com.example.answer.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import com.example.answer.domain.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


//@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testFindAll() {
        System.out.println("全件検索するテスト開始");

//        List<Integer> values = new ArrayList<>();
//        values.add(1);
//        values.add(2);
//        values.add(3);
        int[] values = {1,3,4};
        List<Employee> employeeList = employeeRepository.test(values);

        System.out.println(employeeList);

        System.out.println("全件検索するテスト終了");
    }

}
