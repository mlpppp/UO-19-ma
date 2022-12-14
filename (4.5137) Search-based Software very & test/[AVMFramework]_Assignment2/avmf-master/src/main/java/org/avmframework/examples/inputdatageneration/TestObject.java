package org.avmframework.examples.inputdatageneration;

import org.avmframework.Vector;

public abstract class TestObject {

  public abstract Vector getVector();

  public abstract BranchTargetObjectiveFunction getObjectiveFunction(Branch target);

  public abstract int getNumBranchingNodes();
  //instantiate a TestObject from the test name(string)
  //go to either org.avmframework.examples.inputdatageneration.triangle.TriangleTestObject
  //org.avmframework.examples.inputdatageneration.line.LineTestObject or other 
  //these classes inherit the abstract TestObject.
  public static TestObject instantiate(String name) {
    String testObjectClassName =
        "org.avmframework.examples.inputdatageneration."
            + name.toLowerCase()
            + "."
            + name
            + "TestObject";

    try {
      Class<?> testObjectClass = Class.forName(testObjectClassName);
      return (TestObject) testObjectClass.newInstance();
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException exception) {
      throw new RuntimeException("Unable to instantiate test object \"" + name + "\"");
    }
  }
}
