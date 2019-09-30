package com.example.myscalatest.apply_test

class DelegateUse(val withDelegate: WithDelegate) {
  def exists: Boolean = withDelegate(_.exists)
  def hello: Unit = withDelegate(_.hello)
}

object DelegateUse {
  def main(args: Array[String]): Unit = {

    val withDelegate = new WithDelegate {
      def apply[T](f: Delegate => T): T = {
        new DelegateJava().withDelegate(f)
      }
    }

    new DelegateUse(withDelegate).exists
    new DelegateUse(withDelegate).hello
  }
}