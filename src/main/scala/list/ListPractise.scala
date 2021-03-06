package list


object ListPractise {
  def apply = new ListPractise
}

class ListPractise {

  /**
   *01. Find the last element of the list
   */
  def getLastElementIn[A](list : List[A]): Option[A] = list match {
    case Nil => throw new NoSuchElementException
    case hd::Nil => Some(hd)
    case hd::tl => getLastElementIn(tl)
  }

  /**
   *02. Find the last but one element of a list.
   */
  def getPenultimate(list : List[Int]):Option[Int] = list match {
    case hd::Nil => throw new NoSuchElementException
    case hd::_::Nil => Some(hd)
    case hd::tl => getPenultimate(tl)
  }

  /**
   * 03. Find the Nth element.
   */
  def getNthElement[A](n : Int, list: List[A]): Option[A] = list match {
    case Nil => throw new UnsupportedOperationException
    case hd::tl => {
      if (n == 0) throw new NoSuchElementException
      else if (n == 1) Some(hd)
      else getNthElement(n-1, tl)
    }
  }

  /**
   * 04. Find the number of elements in a list.
   */
  def getNumberOfElements[A](list: List[A]):Int = list match {
    case Nil => 0
    case hd::tl => getNumberOfElements(tl) + 1
  }

  /**
   *05. Reverse the contents of the list.
   */
  def reverse[A](list: List[A]):List[A] = list match {
    case Nil => Nil
    case hd::Nil => List(hd)
    case hd::tl => reverse(tl):+hd
  }

  /**
   *06. Find out if the list is a palindrome.
   */
  def isPalindrome[A](list: List[A]):Boolean = list match {
    case Nil => true
    case hd::Nil => true
    case hd::tl => {
      if (hd == tl.last) isPalindrome(tl.take(tl.size-1))
      else false
    }
  }

  /**
   * 07. Flatten a nested list structure.
   */
  def flattenList(list : List[Any]):List[Any] = list match {
    case Nil => Nil
    case (hd:List[_]) :: tl => flattenList(hd) ++ flattenList(tl)
    case hd::tl => hd :: flattenList(tl)
  }

  /**
   * 08. Eliminate consecutive duplicates of list elements.
   */
  def eliminateDuplicates(list : List[Any]):List[Any] = list match {
    case Nil => throw new UnsupportedOperationException
    case hd::Nil => List(hd)
    case hd::tl => {
      if (hd == tl.head) eliminateDuplicates(tl)
      else hd :: eliminateDuplicates(tl)
    }
  }


  /**
   * 09. Pack consecutive duplicates of list elements into sublists.
   */
  def packConsecutiveDuplicates(list: List[Any]):List[Any] = list match {
    case hd::Nil => List(hd)
    case (hd:Any) :: tl => {
      if (hd == tl.head) {
        List(hd,tl.head) :: packConsecutiveDuplicates(tl.drop(1))
      } else {
        List(hd)::List(tl.head) :: packConsecutiveDuplicates(tl.drop(1))
      }
    }
  }
}

object Runner extends App {
  val a : ListPractise = new ListPractise
  print(a.packConsecutiveDuplicates(List('a','a','c','c','c','b','a')))

}