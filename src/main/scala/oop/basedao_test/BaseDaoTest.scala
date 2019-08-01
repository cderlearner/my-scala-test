package oop.basedao_test

import java.io.PrintWriter
import java.sql.Connection
import java.util.logging.Logger

import javax.sql.DataSource

case class ScalaJdbcTemplate(source: DataSource)

abstract class BaseDao(dataSource: DataSource) {
  val jdbcTemplate = new ScalaJdbcTemplate(dataSource)
}

class c1Dao(dataSource: DataSource) extends BaseDao(dataSource)

class c2Dao(dataSource: DataSource) extends BaseDao(dataSource)


object BaseDaoTest {
  def main(args: Array[String]): Unit = {
    val ds = new DataSource {
      override def getConnection: Connection = ???

      override def getConnection(username: String, password: String): Connection = ???

      override def getLogWriter: PrintWriter = ???

      override def setLogWriter(out: PrintWriter): Unit = ???

      override def setLoginTimeout(seconds: Int): Unit = ???

      override def getLoginTimeout: Int = ???

      override def getParentLogger: Logger = ???

      override def unwrap[T](iface: Class[T]): T = ???

      override def isWrapperFor(iface: Class[_]): Boolean = ???
    }

    val c1dao = new c1Dao(ds)
    val c2dao = new c2Dao(ds)

    println(c1dao.jdbcTemplate == c2dao.jdbcTemplate)
  }
}