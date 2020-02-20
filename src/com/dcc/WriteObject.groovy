//src/com/dcc/DTRBuildInfo.groovy
package com.dcc
import java.io.File

// DTR Build Information
class WriteObject 
{
  WriteObject(DTRBuildInfo DTRBuild, String fileName) {
    File objectStore = new File(fileName)
    if (objectStore.exists()) { objectStore.delete() }
    assert ! objectStore.exists()
    def os
    try {
      os = objectStore.newObjectOutputStream()
      os << DTRBuild
    }
    catch (e) { 
      throw new Exception(e) 
    }
    finally { 
     os?.close() 
    }
    assert objectStore.exists()    
  }
}
