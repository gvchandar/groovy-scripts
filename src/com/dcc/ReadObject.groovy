//src/com/dcc/DTRBuildInfo.groovy
package com.dcc
import java.io.File
class ReadObject 
{
  ReadObject(String fileName) {
    File objectStore = new File(fileName)
    assert  objectStore.exists()
    def is
    try {
      is = objectStore.newObjectInputStream(this.class.classLoader)
      is.eachObject { 
        println it 
      }
    } 
    catch (e) { 
      throw new Exception(e) 
    } 
    finally { 
      is?.close() 
      println(" FINALLY of ReadObject")
    }   
  }
}
