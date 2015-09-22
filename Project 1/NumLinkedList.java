// Jonathan Parks jqp

public class NumLinkedList implements NumList {

 // Fields
 public LLNode head;

 // Constructors
 public NumLinkedList() {
  head = null;
 }



 // Methods
 public int size() {
  int size = 0;
  Iterator iter = new Iterator();
  while (iter.hasNext()) {
   size++;
   iter.next();
  }
  return size;
 }

 public void add(double value) {
  LLNode currentNode = head;
  while (currentNode != null && currentNode.nextNode != null) {
   currentNode = currentNode.nextNode;
  }
  if (currentNode == null) head = new LLNode(value);
  else currentNode.nextNode = new LLNode(value);
 }

 public void insert(int i, double value) {
  if (i == 0 || head == null) head = new LLNode(value, head);
  else {
   LLNode current = head;
   Iterator iter = new Iterator();
   while (iter.hasNext() && i > 0) {
    current = iter.nextNode();
    i--;
   }
   current.nextNode = new LLNode(value, iter.nextNode());
  }
 }

 public void remove(int i) {
  LLNode currentNode = head;
  for (int j = 0; j < i-1; j++) {
   if (currentNode != null && currentNode.nextNode != null) {
    currentNode = currentNode.nextNode;
   }
  }
  if (currentNode != null && currentNode.nextNode != null) {
   currentNode.nextNode = currentNode.nextNode.nextNode;
  }
 }

 public boolean contains(double value) {
  Iterator iter = new Iterator();
  while (iter.hasNext()) {
   if (iter.next() == value) return true;
  }
  return false;
 }

 public double lookup(int i) {
  Iterator iter = new Iterator();
  for (int j = 0; j < i; j++) {
   if (iter.hasNext()) iter.next();
  }
  if (iter.hasNext()) return iter.next();
  else throw new IllegalArgumentException("Index does not exist");
 }

 public boolean equals(NumList otherList) {
  int thisSize = this.size();
  try {
   if (thisSize != otherList.size()) return false;
   for (int i = 0; i < thisSize; i++) {
    if (this.lookup(i) != otherList.lookup(i)) return false;
   }
   return true;
  } catch (IllegalArgumentException e) {
   return false;
  }
 }

 public void removeDuplicates() {
   NumLinkedList temp = new NumLinkedList();
   for (int i = 0; i < this.size(); i++) {
     if (!temp.contains(this.lookup(i))) {
       temp.add(this.lookup(i));
     } else {
       this.remove(i);
     }
   }
 }

 public String toString() {
  String output = "";
  Iterator iter = new Iterator();
  while (iter.hasNext()) {
   output += Double.toString(iter.next());
   if (iter.hasNext()) output += " ";
  }
  return output;
 }


 // Iterator
 private class Iterator {
  private LLNode nextNode;
  private Iterator() {
   nextNode = head;
  }

  public boolean hasNext() {
   return nextNode != null;
  }

  public double next() {
   if (nextNode == null) throw new IllegalArgumentException();
   double output = nextNode.value;
   nextNode = nextNode.nextNode;
   return output;
  }

  public LLNode nextNode() {
   if (nextNode == null) return null;
   LLNode output = nextNode;
   nextNode = nextNode.nextNode;
   return output;
  }
 }
}
