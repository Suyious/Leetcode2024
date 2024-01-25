from typing import Optional


class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def printLinkedList(l: ListNode) -> None:
    if(l != None):
        print(l.val, end = " ")
        printLinkedList(l.next)
    else:
        print()

def listToLinkedList(list: ListNode) -> ListNode:
    s = None
    j = s
    for l in list:
        if(s == None):
            s = ListNode(l)
            j = s
        else:
            j.next = ListNode(l)
            j = j.next
    return s
        

def addTwoNumbers( l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
    i = l1
    j = l2
    carry = 0
    s = None
    k = None

    while i != None or j != None or carry != 0:
        sum = carry

        if i != None:
            sum += i.val
            i = i.next

        if j != None:
            sum += j.val
            j = j.next

        if s == None:
            s = ListNode(sum % 10)
            k = s
        else:
            k.next = ListNode(sum % 10)
            k = k.next
        
        carry = sum // 10

    return s

if __name__ == '__main__':
    l1 = listToLinkedList([1, 2, 3, 4])
    l2 = listToLinkedList([2, 4, 6, 8])
    s = addTwoNumbers(l1, l2)
    printLinkedList(l1)
    printLinkedList(l2)
    printLinkedList(s)