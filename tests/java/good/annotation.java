package testPackage;

@interface TestAnn1 {}
@interface TestAnn2 {
  boolean value() default false;
}
@interface TestAnn3 {
  String first();
  String last();
}
@interface TestAnn4 {
  TestAnn2[] value();
}
@interface TestAnn5 {
  String[] value();
}

class Other {
  @TestAnn1
  void Test1() {}

  @TestAnn2(true)
  void Test2() {}

  @TestAnn3(first = "foo", last = "bar")
  void Test3() {}

  @TestAnn4(value = {@TestAnn2(true), @TestAnn2(false)})
  @TestAnn4({@TestAnn2(true), @TestAnn2(false)})
  void Test4() {}

  @TestAnn5({"foo", "bar", "baz"})
  @TestAnn5(value = {"foo", "bar", "baz"})
  void Test5() {}
}
