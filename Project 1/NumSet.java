// Jonathan Parks jqp

public class NumSet {

 // Fields
 NumLinkedList set = new NumLinkedList();

 // Constructor
 public NumSet(double[] set) {
  for (int i = 0; i < set.length; i++) {
   if (!this.set.contains(set[i])) {
    this.set.add(set[i]);
   }
  }
 }


 // Methods
 public int size() {
  return set.size();
 }

 public boolean contains(double value) {
  return set.contains(value);
 }

 public static NumSet intersect(NumSet S1, NumSet S2) {
   NumLinkedList temp = new NumLinkedList();
   for (int i = 0; i < S1.size(); i++) {
     double num = S1.set.lookup(i);
     if (S2.contains(num)) temp.add(num);
   }
   
   double[] output = new double[temp.size()];
   for (int j = 0; j < output.length; j++) {
     output[j] = temp.lookup(j);
   }
   return new NumSet(output);
 }

 public static NumSet union(NumSet S1, NumSet S2) {
   NumLinkedList temp = new NumLinkedList();
   for (int i = 0; i < S1.size(); i++) temp.add(S1.set.lookup(i));
   for (int j = 0; j < S2.size(); j++) {
     double num = S2.set.lookup(j);
     if (!temp.contains(num)) temp.add(num);
   }
   
   double[] output = new double[temp.size()];
   for (int j = 0; j < output.length; j++) {
     output[j] = temp.lookup(j);
   }
   return new NumSet(output);
 }

 public String toString() {
  return set.toString();
 }

 // Extra Credit
 public static boolean equivalence(NumSet S1, NumSet S2) {
 	int size = S1.size();
	if (S2.size() != size) return false;
	else {
		for (int i = 0; i < size; i++) {
			if (!S2.contains(S1.set.lookup(i))) return false;
		}
		return true;
	}
 }
}
