package com.example.myscalatest

import javax.annotation.{PostConstruct, Resource}
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Repository

abstract class BaseDao(dataSource: ScalaMockDataSource) {
  val jdbcTemplate = new ScalaJdbcTemplate(dataSource)
}

class ScalaJdbcTemplate(dataSource: ScalaMockDataSource) {
  println(dataSource.name)

  def getScalaJdbcDatasource = dataSource
}

class ScalaJdbcPrivacyDao(dataSource: ScalaMockDataSource) extends BaseDao(dataSource) {

  //  @Resource
  //  private var dataSource2: ScalaMockDataSource = _

  //def getDatasource = dataSource
}

@Repository
class ScalaJdbcPrivacyForwardingDao {

  @Resource
  private var scalaMockDataSource: ScalaMockDataSource = _
  private var scalaJdbcPrivacyDao: ScalaJdbcPrivacyDao = _
  @Resource
  private var app: ApplicationContext = _

  @PostConstruct
  def init(): Unit = {
    scalaJdbcPrivacyDao = new ScalaJdbcPrivacyDao(scalaMockDataSource)

    val myTestBean2: MyTestBean2 = app.getBean(classOf[MyTestBean2])
    myTestBean2.helloTestBean2()
  }

  def getScalaJdbcPrivacyDao = scalaJdbcPrivacyDao
}