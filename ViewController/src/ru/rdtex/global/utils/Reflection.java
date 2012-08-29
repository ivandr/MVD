package ru.rdtex.global.utils;
// ШМЯ

import java.lang.reflect.InvocationTargetException;

public class Reflection {
  public Reflection() {
      super();
  }
    
  /**
   * Выполнения метода через Java Reflection.
   * При этом знать сигнатуту элементов заранее не обязательно.
   */
  public static Object runInvokeMethod(Object object, 
                                       String methodName,
                                       Object[] params)
  {
    Object result = null;
    Class classObject = object.getClass();
    Class<?>[] parameterTypes = new Class<?>[params.length];
    for (int i = 0; i < params.length; i++)
    {
      parameterTypes[i] = params[i].getClass();
    }
    try
    {
      result =
          classObject.getMethod(methodName, parameterTypes).invoke(object,
                                                                   params);
    }
    catch (NoSuchMethodException e)
    {
      e.printStackTrace();
    }
    catch (IllegalAccessException e)
    {
      e.printStackTrace();
    }
    catch (InvocationTargetException e)
    {
      e.printStackTrace();
    }
    return result;
  }
}
