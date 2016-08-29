package cracking.code.interview.chapt02;

import java.util.Hashtable;

public class I_RemoveDuplicatedFromUnsortedLinkedList {

	static class Node {
		Node next = null;
		int data;

		public Node(int d) {
			data = d;
		}

		public void appendToTail(int d) {
			Node end = new Node(d);
			Node n = this;
			while (n.next != null) {
				n = n.next;
			}

			n.next = end;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", next=" + (next != null ? next.data : false) + "]";
		}

	}

	/*
	 * Removing duplicated nodes from Unsorted Linked List (consider to be a
	 * singly) Follow up - use of temporary buffer is not allowed.
	 */

	public static Node removeDuplicatedNodesFromLinkedList(Node head) {
		Node n = head;
		while (n.next != null) {
			Node beingCompared = n;
			Node previous = null;
			while (beingCompared.next != null) {
				Node navigator = beingCompared.next;
				// System.out.println("Linked: "+ n +", Linked 2: "+ navigator);

				if (n.data == navigator.data) {
					if (previous == null) {
						n.next = navigator.next;
					} else {
						previous.next = navigator.next;
					}
					beingCompared = navigator;
					continue;

				}
				previous = navigator;
				beingCompared = beingCompared.next;
			}

			if (n.next != null) {
				n = n.next;
			} else {
				return n;
			}
		}

		return n;

	}

	/*
	 * Book solution - using auxiliar buffer structure On this case, hashtable
	 */
	public static void removeDuplicatedByTheBook(Node n) {
		Hashtable<Integer, Boolean> table = new Hashtable<>();

		Node previous = null;
		while (n != null) {
			if (table.containsKey(n.data)) {
				previous.next = n.next;
			} else {
				table.put(n.data, true);
				previous = n;
			}
			n = n.next;
		}
	}

	/*
	 * Book solution - not using auxiliar buffer structure
	 */
	public static void removeDuplicatedByTheBookWithoutAux(Node head) {
		if (head == null)
			return;
		Node previous = head;
		Node current = previous.next;
		while (current != null) {
			// Look backwards for dups, and remove any that you see.
			Node runner = head;
			while (runner != current) {
				if (runner.data == current.data) {
					Node tmp = current.next;
					previous.next = tmp;
					current = tmp;
					/*
					 * We know we can’t have more than one dup preceding our
					 * element since it would have been removed earlier.
					 */
					break;
				}
				runner = runner.next;
			}

			/*
			 * If runner == current, then we didn’t find any duplicate elements
			 * in the previous for loop. We then need to increment current. If
			 * runner != current, then we must have hit the ‘break’ condition,
			 * in which case we found a dup and current has already been
			 * incremented.
			 */
			if (runner == current) {
				previous = current;
				current = current.next;
			}
		}
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.appendToTail(2);
		head.appendToTail(3);
		head.appendToTail(3);
		head.appendToTail(4);
		head.appendToTail(5);
		head.appendToTail(6);
		head.appendToTail(6);
		head.appendToTail(7);
		head.appendToTail(6);
		head.appendToTail(8);
		head.appendToTail(6);
		head.appendToTail(9);
		removeDuplicatedByTheBookWithoutAux(head);
		printResult(head);

		head = new Node(1);
		head.appendToTail(1);
		head.appendToTail(1);
		head.appendToTail(1);
		head.appendToTail(1);
		removeDuplicatedNodesFromLinkedList(head);
		printResult(head);

		head = new Node(1);
		head.appendToTail(1);
		head.appendToTail(1);
		head.appendToTail(1);
		head.appendToTail(1);
		removeDuplicatedByTheBook(head);
		printResult(head);

		head = new Node(1);
		head.appendToTail(2);
		head.appendToTail(3);
		head.appendToTail(3);
		head.appendToTail(4);
		head.appendToTail(5);
		head.appendToTail(6);
		head.appendToTail(6);
		head.appendToTail(7);
		head.appendToTail(6);
		head.appendToTail(8);
		head.appendToTail(6);
		head.appendToTail(9);
		removeDuplicatedByTheBook(head);
		printResult(head);

	}

	static void printResult(Node head) {
		System.out.println("!!!!!--------------!!!!");
		while (head.next != null) {
			System.out.println(head.toString());
			head = head.next;
		}
		System.out.println(head);
	}

}
