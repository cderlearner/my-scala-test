package com.example.myscalatest

import javax.annotation.PostConstruct
import org.springframework.stereotype.Service

@Service
class ScalaMyService {

  @PostConstruct
  def init(): Unit = {
    println("MyService Hello!")
  }
}
