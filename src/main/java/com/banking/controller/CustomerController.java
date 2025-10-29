package com.banking.controller;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
  private List<Map<String, String>> customers = new ArrayList<>();
  @GetMapping public List<Map<String, String>> all() {
    if (customers.isEmpty()) {
      Map<String,String> c = new HashMap<>();
      c.put("id","1"); c.put("name","John Doe");
      customers.add(c);
    }
    return customers;
  }
  @PostMapping public Map<String,String> add(@RequestBody Map<String,String> c) {
    c.put("id", String.valueOf(customers.size()+1));
    customers.add(c); return c;
  }
}
