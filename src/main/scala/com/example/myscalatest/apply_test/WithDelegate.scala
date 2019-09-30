package com.example.myscalatest.apply_test

trait WithDelegate {
  def apply[T](f: Delegate => T) : T
}
