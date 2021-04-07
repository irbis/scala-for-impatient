// check other files in the folder. worksheet is not allowed
// to work with packages except operation import

import java.awt.{Color, Font}

import java.util.{HashMap => JavaHashMap} // rename while importing (hiding package names)
import collection.mutable._  // with previous line it's possible to determine Java and Scala hashmap later

// default importing for every source file
import java.lang._
import scala._
import Predef._