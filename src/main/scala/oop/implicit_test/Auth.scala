package oop.implicit_test

import oop.implicit_test.V1AuthService.V1AuthRequest
import oop.implicit_test.V2AuthService.V2AuthRequest

// Auth Magnet参数
trait AuthMagnet {
  type Result

  def apply(): Result
}

// Auth Service 方法
trait AuthService {
  def auth(am: AuthMagnet): am.Result = am.apply()
}


//v1 auth service
trait V1AuthService extends AuthService

//v2 auth service
trait V2AuthService extends AuthService

//V1 版本的服务实现
object V1AuthService {

  case class V1AuthRequest()

  case class V1AuthResponse()

  implicit def toAuthMagnet(p: V1AuthRequest): AuthMagnet {type Result = V1AuthResponse} = new AuthMagnet {
    override def apply(): Result = {
      // v1 版本的auth 业务委托到magnet的apply中实现
      println("这是V1 Auth Service")
      V1AuthResponse()
    }

    override type Result = V1AuthResponse
  }
}

//V2 版本的服务实现
object V2AuthService {

  case class V2AuthRequest()

  case class V2AuthResponse()

  implicit def toAuthMagnet(p: V2AuthRequest): AuthMagnet {type Result = V2AuthResponse} = new AuthMagnet {
    override def apply(): Result = {
      // v2 版本的auth 业务委托到magnet的apply中实现
      println("这是V2 Auth Service")
      V2AuthResponse()
    }

    override type Result = V2AuthResponse
  }
}


object Auth {

  trait V1Resource extends V1AuthService {
    def serv(): Unit = {
      val p = V1AuthRequest()
      val response = auth(p)
      println(s"v1 resource response: $response")
    }
  }

  trait V2Resource extends V2AuthService {
    def serv(): Unit = {
      val p = V2AuthRequest()
      val response = auth(p)
      println(s"v2 resource response: $response")
    }
  }

  trait h{
    def apply: String
  }

  def main(args: Array[String]): Unit = {
    val s = new h {
      override def apply: String = {
        "hello"
      }
    }


    val res1 = new V1Resource {}
    val res2 = new V2Resource {}

    res1.serv()
    res2.serv()
  }
}

