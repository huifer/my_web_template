package com.huifer.baseweb.web.mobile;

import static org.junit.jupiter.api.Assertions.*;

import com.huifer.baseweb.constants.InitializrGlobalValue;
import com.huifer.baseweb.service.IInitializrService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class EventControllerTest {



  @Autowired
  IInitializrService initializrService;

  @Test
  void tt(){
    InitializrGlobalValue value = initializrService.getValue();
    Assert.assertTrue(value != null);


}}